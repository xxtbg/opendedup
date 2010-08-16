/usr/lib/jvm/jdk/bin/java \
  -Xmx2g -Xms2g -XX:MaxDirectMemorySize=8g -XX:ParallelGCThreads=20 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:SurvivorRatio=8 -XX:TargetSurvivorRatio=90 -XX:MaxTenuringThreshold=31 -XX:+AggressiveOpts  \
  -XX:+UseCompressedOops -Dorg.apache.commons.logging.Log=fuse.logging.FuseLog -Dfuse.logging.level=INFO\
 -classpath /home/annesam/java_api/sdfs-bin/lib/trove-3.0.0a3.jar:/home/annesam/java_api/sdfs-bin/lib/quartz-1.7.3.jar:/home/annesam/java_api/sdfs-bin/lib/commons-collections-3.2.1.jar:/home/annesam/java_api/sdfs-bin/lib/log4j-1.2.15.jar:/home/annesam/java_api/sdfs-bin/lib/jdbm.jar:/home/annesam/java_api/sdfs-bin/lib/clhm-production.jar:/home/annesam/java_api/sdfs-bin/lib/bcprov-jdk16-143.jar:~/java_api/sdfs-bin/lib/commons-codec-1.3.jar:/home/annesam/java_api/sdfs-bin/lib/commons-httpclient-3.1.jar:/home/annesam/java_api/sdfs-bin/lib/commons-logging-1.1.1.jar:/home/annesam/java_api/sdfs-bin/lib/java-xmlbuilder-1.jar:/home/annesam/java_api/sdfs-bin/lib/jets3t-0.7.1.jar:/home/annesam/java_api/sdfs-bin/lib/commons-cli-1.2.jar:../../sdfs/bin/:. \
   org.opendedup.sdfs.network.NetworkHCServer $*