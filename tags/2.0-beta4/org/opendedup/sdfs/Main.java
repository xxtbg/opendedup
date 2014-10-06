package org.opendedup.sdfs;

import java.io.File;

import org.opendedup.hashing.HashFunctionPool;
import org.opendedup.sdfs.filestore.gc.StandAloneGCScheduler;
import org.opendedup.sdfs.io.Volume;
import org.opendedup.sdfs.notification.SDFSEvent;
import org.opendedup.util.OSValidator;
import org.w3c.dom.Element;

/**
 * 
 * @author Sam Silverberg Global constants used for SDFS classes.
 * 
 */
public class Main {
	static {
		if (OSValidator.isWindows()) {
			Main.chunkStore = System.getenv("programfiles") + File.separator
					+ "sdfs" + File.separator;
		}
	}
	// public static VolumeConfigWriterThread wth = null;
	public static boolean runConsistancyCheck = true;
	
	public static boolean blockDev = false;

	public static boolean firstRun = true;

	public static boolean logToConsole = false;

	public static StandAloneGCScheduler pFullSched = null;

	public static String logPath = "/var/log/sdfs/sdfs.log";
	public static byte MAPVERSION = 0;

	public static String sdfsPassword = "";

	public static String sdfsPasswordSalt = "";
	public static boolean allowExternalSymlinks = true;

	public static boolean sdfsCliRequireAuth = false;
	public static int sdfsCliPort = 6442;
	public static boolean sdfsCliEnabled = true;
	public static String sdfsCliListenAddr = "localhost";
	public static boolean runCompact = false;

	public static boolean forceCompact = false;
	public static int MAX_REPL_BATCH_SZ = 128;

	public static SDFSEvent mountEvent = null;

	public static String DSEClusterID = "sdfs-cluster";
	public static byte DSEClusterMemberID = 0;
	public static int ClusterRSPTimeout = 1000;
	public static String DSEClusterConfig = "/etc/sdfs/jgroups.cfg.xml";
	public static boolean DSEClusterEnabled = false;
	public static String DSEClusterVolumeList = "/etc/sdfs/cluster-volumes.xml";
	public static boolean DSEClusterDirectIO = false;
	/**
	 * DSE Host for front end file systems
	 */
	public static String DSERemoteHostName = null;

	public static boolean standAloneDSE = false;

	/**
	 * DSE Host port for front end file systems
	 */
	public static int DSERemotePort = 2222;

	/**
	 * DSE Host use SSL for front end file systems
	 */
	public static boolean DSERemoteUseSSL = true;

	/**
	 * DSE Host use SSL for front end file systems
	 */
	public static boolean DSERemoteCompress = false;

	public static String DSEPassword = "admin";

	public static String DSEClusterNodeRack = "rack1";
	public static String DSEClusterNodeLocation = "pdx";

	/**
	 * Class path when launching sdfs
	 */
	public static String classPath = "/usr/share/sdfs/lib/snappy-java.jar:/usr/share/sdfs/lib/activation-1.1.jar:/usr/share/sdfs/lib/antlr-2.7.4.jar:/usr/share/sdfs/lib/apache-mime4j-0.6.jar:/usr/share/sdfs/lib/bcprov-jdk16-143.jar:/usr/share/sdfs/lib/chardet-1.0.jar:/usr/share/sdfs/lib/commons-cli-1.2.jar:/usr/share/sdfs/lib/commons-codec-1.3.jar:/usr/share/sdfs/lib/commons-collections-3.2.1.jar:/usr/share/sdfs/lib/commons-digester-1.8.1.jar:/usr/share/sdfs/lib/commons-httpclient-3.1.jar:/usr/share/sdfs/lib/commons-io-1.4.jar:/usr/share/sdfs/lib/commons-lang3-3.1.jar:/usr/share/sdfs/lib/commons-logging-1.0.4.jar:/usr/share/sdfs/lib/commons-logging-1.1.1.jar:/usr/share/sdfs/lib/commons-pool-1.5.5.jar:/usr/share/sdfs/lib/concurrent-1.3.4.jar:/usr/share/sdfs/lib/concurrentlinkedhashmap-lru-1.3.jar:/usr/share/sdfs/lib/cpdetector_1.0.8.jar:/usr/share/sdfs/lib/dom4j-1.6.1.jar:/usr/share/sdfs/lib/httpclient-4.1.1.jar:/usr/share/sdfs/lib/httpcore-4.1.jar:/usr/share/sdfs/lib/httpcore-nio-4.1.jar:/usr/share/sdfs/lib/httpmime-4.0.3.jar:/usr/share/sdfs/lib/jackson-core-asl-1.8.3.jar:/usr/share/sdfs/lib/jackson-jaxrs-1.8.3.jar:/usr/share/sdfs/lib/jackson-mapper-asl-1.8.3.jar:/usr/share/sdfs/lib/jackson-xc-1.8.3.jar:/usr/share/sdfs/lib/jacksum.jar:/usr/share/sdfs/lib/jargs-1.0.jar:/usr/share/sdfs/lib/javax.inject-1.jar:/usr/share/sdfs/lib/java-xmlbuilder-1.jar:/usr/share/sdfs/lib/jaxb-impl-2.2.3-1.jar:/usr/share/sdfs/lib/jaxen-1.1.1.jar:/usr/share/sdfs/lib/jcs-1.3.jar:/usr/share/sdfs/lib/jdbm.jar:/usr/share/sdfs/lib/jdokan.jar:/usr/share/sdfs/lib/jersey-client-1.10-b02.jar:/usr/share/sdfs/lib/jersey-core-1.10-b02.jar:/usr/share/sdfs/lib/jersey-json-1.10-b02.jar:/usr/share/sdfs/lib/jets3t-0.7.4.jar:/usr/share/sdfs/lib/jets3t-0.8.1.jar:/usr/share/sdfs/lib/log4j-1.2.15.jar:/usr/share/sdfs/lib/mail-1.4.jar:/usr/share/sdfs/lib/microsoft-windowsazure-api-0.2.2.jar:/usr/share/sdfs/lib/quartz-1.8.3.jar:/usr/share/sdfs/lib/sdfs.jar:/usr/share/sdfs/lib/simple-4.1.21.jar:/usr/share/sdfs/lib/slf4j-api-1.5.10.jar:/usr/share/sdfs/lib/slf4j-log4j12-1.5.10.jar:/usr/share/sdfs/lib/stax-api-1.0.1.jar:/usr/share/sdfs/lib/trove-3.0.0a3.jar:/usr/share/sdfs/lib/truezip-samples-7.3.2-jar-with-dependencies.jar:/usr/share/sdfs/lib/uuid-3.1.jar";

	public static String javaOptions = "-Djava.library.path=/usr/share/sdfs/bin/ -Dorg.apache.commons.logging.Log=fuse.logging.FuseLog -Dfuse.logging.level=INFO -server -XX:+UseG1GC";

	public static String javaPath = "/usr/share/sdfs/jre1.7.0/bin/java";

	/**
	 * The Version of SDFS this is
	 */
	public static String version = "2.0BETA4";

	/**
	 * The location where the actual blocks of deduplicated data will be
	 * located. This is used for the chunk stores.
	 */
	public static String chunkStore = "";

	/**
	 * Future implementation for pluggable chunkstores
	 */
	public static Element chunkStoreConfig = null;

	/**
	 * Future implementation of pluggable cs
	 */
	public static String chunkStoreClass = "org.opendedup.sdfs.filestore.NullChunkStore";

	// public static String hashesDBClass =
	// "com.opendedup.collections.FileBasedCSMap";
	public static String hashesDBClass = "org.opendedup.collections.FileBasedCSMap";
	/**
	 * Future implementation of pluggable garbageCollector
	 */
	public static String gcClass = "org.opendedup.sdfs.filestore.gc.PFullGC";

	/**
	 * Secret Key to Encrypt chunks in DSE.
	 */
	public static String chunkStoreEncryptionKey = "Password";
	/**
	 * whether encryption should be enabled for the DSE
	 */
	public static boolean chunkStoreEncryptionEnabled = false;

	/**
	 * The location where database of deduped hashes will be stores and written
	 * to. This is used for the chunk store.
	 */
	public static String hashDBStore = null;
	/**
	 * The location where dedup file maps will be stored. Dedup file maps are
	 * database files and the virtual representation of a file on disk. This is
	 * used on the client.
	 */
	public static String dedupDBStore = null;
	/**
	 * The location where the model of the virtual file structure will be held.
	 * The virtual file structure maps what will be presented as the filesystem
	 * is being mapped. This is used on the client.
	 */
	// public static String metaDBStore = "/opt/dedup/jdb";
	/**
	 * The location where the IO stats SDFSLogger.getLog() file will be held.
	 * The IO SDFSLogger.getLog() file is used to record IO stats at specific
	 * intervals. This is used on the client and chunk store.
	 */
	public static String ioLogFile = null;
	/**
	 * The location where debug and system SDFSLogger.getLog()s are kept. This
	 * is used on the client and chunk store.
	 */
	public static String logLocation = null;
	/**
	 * The chunk size used for deduplication of incoming data. This is used on
	 * the client.
	 */
	public static int CHUNK_LENGTH = 16 * 1024;
	/**
	 * the default db user name. This is only used if the H2 database is being
	 * used instead of TC. This is used on the client and chunk store.
	 */
	public static String dbuserName = "sa";
	/**
	 * the default db user password. This is only used if the H2 database is
	 * being used instead of TC. This is used on the client and chunk store.
	 */
	public static String dbpassword = "sa";
	/**
	 * The version of the communication protocol being used for client <-> chunk
	 * store network communication.
	 */
	public static String PROTOCOL_VERSION = "1.1";
	/**
	 * The ping time used to keep client to chunk store network pipes open. This
	 * is used on the client.
	 */
	public static int PING_TIME = 15 * 1000;

	/**
	 * The maximum number of writable chunks @see
	 * com.annesam.sdfs.io.WritableCacheBuffer to keep in memory for a specific
	 * file. As a file is written too the write buffer will fill up to the
	 * maxWriteBuffers size and the purged from the buffer and written to the
	 * chunk store based on LRU queuing. This parameter is used per file. This
	 * is used on the client.
	 */
	public static int maxWriteBuffers = 100;

	/**
	 * Write threads @see com.annesam.util.ThreadPool are used to process data
	 * from dedup file write buffers in a multi threaded fashion. When data is
	 * purged from the write buffer it is added to the thread pool queue and
	 * then processed by an available thread. The number of initial available
	 * threads is set by writeThreads. The number here should be set to at least
	 * the number of cpu cores used by the client. This is used on the client.
	 */

	public static int writeThreads = 8;
	/**
	 * The representation of a blank hash of the default chunk size. This is
	 * used on the client.
	 */

	public static byte[] blankHash = new byte[CHUNK_LENGTH];
	public static String internalMountPath = "/media";
	public static String vmdkMountPath = "/media/vmmount";
	public static String scriptsDir = "/opt/dedup/scripts/";
	public static String vmdkMountOptions = "rw";
	public static int defaultOffset = 2048;

	/**
	 * The maximum number of dedup files that can be open at any one time. This
	 * can be changed based on the amount of memory on a specfic system. Files
	 * will be closed automatically once the maxOpenFiles has been hit based on
	 * LRU. This is used on the client.
	 */
	public static int maxOpenFiles = 100;
	/**
	 * Default file posix permissions as is represented on the client when the
	 * filesystem is mounted. This is used on the client.
	 */
	public static int defaultFilePermissions = 0644;
	/**
	 * Default folder posix permissions as is represented on the client when the
	 * filesystem is mounted. This is used on the client.
	 */
	public static int defaultDirPermissions = 0755;
	/**
	 * Default posix owner as is represented on the client when the filesystem
	 * is mounted. This is used on the client.
	 */
	public static int defaultOwner = 0;
	/**
	 * Default posix group as is represented on the client when the filesystem
	 * is mounted. This is used on the client.
	 */
	public static int defaultGroup = 0;

	/**
	 * The port the chunk store uses to listen of TCP and UDP connections. This
	 * is used on the chunk store.
	 */
	public static int serverPort = 2222;
	/**
	 * The host name or IP that the chunk store network port will listen on.
	 * This is used on the chunk store.
	 */
	public static String serverHostName = "0.0.0.0";

	/**
	 * The host name or IP that the chunk store network port will listen on.
	 * This is used on the chunk store.
	 */
	public static boolean serverUseSSL = false;

	/**
	 * The maximum number of results that a specific query will return if H2 is
	 * being used. This is used on the chunk store and the client.
	 */
	public static int maxReturnResults = 3000;
	/**
	 * The Volume object. This is used on the client.
	 */
	public static Volume volume;

	/**
	 * 
	 */
	public static double gcPFIncrement = .05;

	/**
	 * The Volume mount point. This is used on the client.
	 */
	public static String volumeMountPoint;

	/**
	 * Enable the DSE Network Server
	 */
	public static boolean enableNetworkDSEServer = false;

	/**
	 * Determines whether dedup file map will be closed when the filesystem
	 * requests that the represented file is. This should be set to false if NFS
	 * is used because the opening and closing of dedup file maps is resource
	 * intensive. The default Linux NFS implementation closes and opens files on
	 * every open and read command. If this option is set to false files will be
	 * closed based on inactivity with maxInactiveFileTime @see
	 * maxInactiveFileTime or the maxOpenFiles parameter @see maxOpenFiles.
	 */
	public static boolean safeClose = true;
	/**
	 * Determines if, when the filesystem request a sync, if the deduped file
	 * will actually sync the underlying data. If set to true, this could
	 * severely impact performance and deduplication rates. It should be set to
	 * false unless needed. This is used on the client.
	 */
	public static boolean safeSync = true;
	/**
	 * The maximum about of time that a file is inactive before it is close.
	 * Inactivity is determined by the time the file was last accessed. @see
	 * com.annesam.sdfs.filestore.OpenFileMonitor . This is used on the client.
	 */
	public static int maxInactiveFileTime = 15 * 60 * 1000;
	/**
	 * Specifies whether the Dedup Storage Engine will store data to AWS S3 or
	 * not. This is set on the chunk store.
	 */
	public static boolean cloudChunkStore = false;
	/**
	 * 
	 */
	public static String cloudBucket = null;
	/**
	 * The awsAccessKey. This is used on the client.
	 */
	public static String cloudAccessKey = null;
	/**
	 * The awsSecretKey. This is used on the client.
	 */
	public static String cloudSecretKey = null;

	/** Azure login info **/
	public static boolean AZUREChunkStore = false;
	public static String AZURE_ACCOUNT_NAME = "MyAccountName";
	public static String AZURE_ACCOUNT_KEY = "MyAccountKey";
	public static String AZURE_BLOB_HOST_NAME = null;

	/**
	 * Compress AWS data using zlib
	 */
	public static boolean cloudCompress = true;

	/**
	 * PreAllocates the size of the Dedup Storage Engine
	 */
	public static long chunkStoreAllocationSize = 536870912000L;

	/**
	 * Dedup Files by default
	 */
	public static boolean dedupFiles = false;

	/**
	 * The page size used for the Dedup Storage Engine. This should be the same
	 * as the Chunk Length used on the client side.
	 */
	public static int chunkStorePageSize = 4096;

	/**
	 * If the Dedup Storage Engine is remote or local
	 */
	public static boolean chunkStoreLocal = false;

	/**
	 * If the Dedup Storage Engine is remote or local
	 */
	public static boolean enableNetworkChunkStore = false;

	/**
	 * hash type can be tiger or murmur
	 */
	public static String hashType = HashFunctionPool.MURMUR3_16;
	/**
	 * FDisk Schedule in cron format
	 * 
	 * @see org.opendedup.sdfs.FDISKJob
	 */
	public static String fDkiskSchedule = "0 59 23 * * ?";

	/**
	 * Age, if older than, that data will be evicted from the Dedup Storage
	 * Engine
	 */
	// public static int evictionAge = 3;
	/**
	 * Compressed Index
	 */
	public static boolean compressedIndex = false;

	public static boolean closedGracefully = true;

}