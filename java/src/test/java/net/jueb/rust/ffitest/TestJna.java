package net.jueb.rust.ffitest;

import com.sun.jna.Native;
import net.jueb.rust.ffi.PathUtil;
import net.jueb.rust.ffi.RustFFI_Jna;
import org.junit.Test;

import java.util.Arrays;

public class TestJna {

    final static RustFFI_Jna ffi;
    static {
        String libpath = PathUtil.getLibPath()+"/librustffi.dylib";
        ffi= Native.load(libpath, RustFFI_Jna.class);
    }

    @Test
    public void printString(){
       String r=ffi.printString("hello rust");
       System.out.println(r);
    }

    @Test
    public void printArray(){
        float[] input=new float[]{1,2,3};
        ffi.printArray(input.length,input);
    }

    @Test
    public void printArrayAndChange(){
        float[] input=new float[]{0,0,0};
        ffi.printArrayAndChange(input.length,input);
        System.out.println("input:"+ Arrays.toString(input));
    }

    @Test
    public void test_tuple(){
        float[] input=new float[]{1,2,3};
        String r=ffi.test_tuple(input);
        System.out.println(r);
        System.out.println("input:"+ Arrays.toString(input));
    }
}