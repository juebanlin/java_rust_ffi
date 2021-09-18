#JDK
export JAVA_17_panama_HOME=/Library/java/JavaVirtualMachines/openjdk-17-panama+3-167.jdk/Contents/Home
# 默认JDK为JDK10
export JAVA_HOME=$JAVA_17_panama_HOME
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar

cc -shared -o libhelloworld.dylib helloworld.c
jextract -t org.hello -lhelloworld helloworld.h
