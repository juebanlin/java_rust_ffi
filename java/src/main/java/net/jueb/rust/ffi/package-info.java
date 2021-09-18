package net.jueb.rust.ffi;

/**
 * 说明 jdk9以上需要在编译器添加如下参数
 --add-modules=jdk.incubator.foreign
 --add-exports=jdk.incubator.foreign/jdk.internal.foreign=ALL-UNNAMED
 --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED
 如果使用FFM则运行时需要添加 --enable-native-access=net.jueb.rust.ffi

 maven编译配置：
 <plugin>
 <groupId>org.apache.maven.plugins</groupId>
 <artifactId>maven-compiler-plugin</artifactId>
 <version>3.8.1</version>
 <configuration>
 <source>17</source>
 <target>17</target>
 <compilerArgs>
 <arg>--add-modules=jdk.incubator.foreign</arg>
 <arg>--add-exports=jdk.incubator.foreign/jdk.internal.foreign=ALL-UNNAMED</arg>
 <arg>--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED</arg>
 </compilerArgs>
 </configuration>
 </plugin>
 */