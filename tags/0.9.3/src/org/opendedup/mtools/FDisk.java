package org.opendedup.mtools;

import java.io.File;

import java.io.IOException;

import org.opendedup.collections.LongByteArrayMap;
import org.opendedup.sdfs.Main;
import org.opendedup.sdfs.io.SparseDataChunk;
import org.opendedup.sdfs.servers.HCServiceProxy;
import org.opendedup.util.SDFSLogger;

public class FDisk {
        private long files = 0;
        private long corruptFiles = 0;

        public FDisk() {
                long start = System.currentTimeMillis();
                File f = new File(Main.dedupDBStore);
                this.traverse(f);
                SDFSLogger.getLog().info("took [" + (System.currentTimeMillis() - start) / 1000
                                + "] seconds to check [" + files + "]. Found ["
                                + this.corruptFiles + "] corrupt files");
        }

        private void traverse(File dir) {

                if (dir.isDirectory()) {
                        String[] children = dir.list();
                        for (int i = 0; i < children.length; i++) {
                                traverse(new File(dir, children[i]));
                        }
                } else {
                        if (dir.getPath().endsWith(".map")) {
                                try {
                                        this.checkDedupFile(dir);
                                } catch (Exception e) {
                                        SDFSLogger.getLog().warn("error traversing for FDISK", e);
                                }
                        }
                }
        }

        private void checkDedupFile(File mapFile) throws IOException {
                LongByteArrayMap mp = new LongByteArrayMap(SparseDataChunk.RAWDL,
                                mapFile.getPath(),"r");
                try {
                        byte[] val = new byte[0];
                        mp.iterInit();
                        boolean corruption = false;
                        while (val != null) {
                                val = mp.nextValue();
                                if (val != null) {
                                        SparseDataChunk ck = new SparseDataChunk(val);
                                        if (!ck.isLocalData()) {
                                                boolean exists = HCServiceProxy
                                                                .hashExists(ck.getHash());
                                                if (!exists) {
                                                        corruption = true;
                                                }
                                        }
                                }
                        }
                        if (corruption) {
                                this.corruptFiles++;
                                SDFSLogger.getLog().warn("map file " + mapFile.getPath() + " is corrupt");
                        }
                } catch (Exception e) {
                        SDFSLogger.getLog().warn("error while checking file ["
                                        + mapFile.getPath() + "]", e);
                } finally {
                        mp.close();
                        mp = null;
                }
                this.files++;
        }

}

