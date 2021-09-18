package net.jueb.rust.ffi;

/**
 * @Description TODO
 * @Date 2021/9/16 6:14 下午
 * @Created by helin
 */
public interface RustFFI_Jnr {

    String printString(String name);

    void printArray(int clen, float[] array);

    void printArrayAndChange(int clen, float[] array);

    String test_tuple(float[] array);
}
