package net.jueb.rust.ffitest.jni;

public class HelloWorld {

    public static native String hello(String input);
    public static native byte[] helloByte(byte[] input);
    public static native void factAndCallMeBack(int n, HelloWorld callback);

    public static native long counterNew(HelloWorld callback);
    public static native void counterIncrement(long counter_ptr);
    public static native void counterDestroy(long counter_ptr);

    public static native void asyncComputation(HelloWorld callback);

    public void factCallback(int res) {
           System.out.println("factCallback: res = " + res);
       }

    public void counterCallback(int count) {
           System.out.println("counterCallback: count = " + count);
       }

    public void asyncCallback(int progress) {
           System.out.println("asyncCallback: thread id = " + Thread.currentThread().getId() + ", progress = " + progress + "%");
    }
}