package net.jueb.rust.ffitest.jni;

import net.jueb.rust.ffi.PathUtil;
import org.junit.Test;

public class TestRustJni {

    static {
        String name="librustjni";
        String suffix=".dylib";
        try {
            String lib = PathUtil.getLibPath()+"/"+name+suffix;
            System.out.println(""+lib);
//            byte[] data=Files.readAllBytes(Paths.get(lib));
//            File f = File.createTempFile(name, suffix);
//            FileOutputStream fileOutputStream = new FileOutputStream(f);
//            fileOutputStream.write(data);
//            fileOutputStream.close();
//            lib=f.getAbsolutePath();
            System.load(lib);
            //-Djava.library.path=/Users/helin/git/java_rust_ffi/target/release
            //System.loadLibrary("rustffi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test(){
        String output = HelloWorld.hello("josh");
        System.out.println(output);
        byte[] outputByte = HelloWorld.helloByte("byte".getBytes());
        System.out.println(outputByte);

        HelloWorld.factAndCallMeBack(6, new HelloWorld());

        long counter_ptr = HelloWorld.counterNew(new HelloWorld());

        for (int i = 0; i < 5; i++) {
            HelloWorld.counterIncrement(counter_ptr);
        }

        HelloWorld.counterDestroy(counter_ptr);

        System.out.println("Invoking asyncComputation (thread id = " + Thread.currentThread().getId() + ")");
        HelloWorld.asyncComputation(new HelloWorld());
    }
}
