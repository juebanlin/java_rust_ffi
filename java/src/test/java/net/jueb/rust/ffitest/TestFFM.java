package net.jueb.rust.ffitest;

import jdk.incubator.foreign.*;
import net.jueb.rust.ffi.PathUtil;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/**
 * 运行时加上vm参数 --enable-native-access=net.jueb.rust.ffi
 */
public class TestFFM {

    static {
        String name = "librustffi";
        String suffix = ".dylib";
        try {
            String lib = PathUtil.getLibPath() + "/" + name + suffix;
            System.out.println("" + lib);
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
    public void printString() throws Throwable {
        String methodName = "printString";
        MemoryLayout layout = CLinker.C_POINTER;
        //c库查找
//        MemoryAddress address=CLinker.systemLookup().lookup("printString").get();
        MemoryAddress methodAddress = SymbolLookup.loaderLookup().lookup(methodName).get();
        CLinker cLinker = CLinker.getInstance();
        MethodHandle printString = cLinker.downcallHandle(
                methodAddress,
                MethodType.methodType(MemoryAddress.class, MemoryAddress.class),
                FunctionDescriptor.of(layout, layout)
        );
        MemorySegment arg = CLinker.toCString("Hello", ResourceScope.newImplicitScope());
        MemoryAddress result = (MemoryAddress) printString.invokeExact(arg.address());
        System.out.println(CLinker.toJavaString(result));
    }

    @Test
    public void printArray() throws Throwable {
        float[] input = new float[]{1, 2, 3};
        String methodName = "printArray";
        MemoryAddress methodAddress = SymbolLookup.loaderLookup().lookup(methodName).get();
        CLinker cLinker = CLinker.getInstance();
        MethodHandle printString = cLinker.downcallHandle(
                methodAddress,
                MethodType.methodType(void.class, int.class, MemoryAddress.class),
                FunctionDescriptor.ofVoid(CLinker.C_INT, CLinker.C_POINTER)
        );
        MemorySegment arg = MemorySegment.ofArray(input);
        MemorySegment everything = MemorySegment.allocateNative(arg.byteSize(), ResourceScope.newImplicitScope());
        everything.copyFrom(arg);
        printString.invokeExact(input.length, everything.address());
        System.out.println(Arrays.toString(input));
    }

    @Test
    public void printArrayAndChange() throws Throwable {
        float[] input = new float[]{0, 0, 0};
        String methodName = "printArrayAndChange";
        MemoryAddress methodAddress = SymbolLookup.loaderLookup().lookup(methodName).get();
        CLinker cLinker = CLinker.getInstance();
        MethodHandle printString = cLinker.downcallHandle(
                methodAddress,
                MethodType.methodType(void.class, int.class, MemoryAddress.class),
                FunctionDescriptor.ofVoid(CLinker.C_INT, CLinker.C_POINTER)
        );
        MemorySegment inputSegment = MemorySegment.ofArray(input);
        MemorySegment arg = MemorySegment.allocateNative(inputSegment.byteSize(), ResourceScope.newImplicitScope());
        arg.copyFrom(inputSegment);
        printString.invokeExact(input.length, arg.address());
        System.out.println(Arrays.toString(arg.toFloatArray()));
    }

    public void test_tuple() {
        float[] input = new float[]{1, 2, 3};
        System.out.println("input:" + Arrays.toString(input));
    }
}