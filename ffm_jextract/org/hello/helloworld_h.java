// Generated by jextract

package org.hello;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public class helloworld_h  {

    static {
        System.loadLibrary("ffm_jextract");
    }

    static final SymbolLookup LIBRARIES = RuntimeHelper.lookup();    /* package-private */ helloworld_h() {}
    public static MethodHandle helloworld$MH() {
        return RuntimeHelper.requireNonNull(constants$0.helloworld$MH,"ffm_jextract");
    }
    public static void helloworld () {
        var mh$ = RuntimeHelper.requireNonNull(constants$0.helloworld$MH, "ffm_jextract");
        try {
            mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    public static MethodHandle printstruct$MH() {
        return RuntimeHelper.requireNonNull(constants$0.printstruct$MH,"printstruct");
    }
    public static void printstruct ( Addressable s) {
        var mh$ = RuntimeHelper.requireNonNull(constants$0.printstruct$MH, "printstruct");
        try {
            mh$.invokeExact(s.address());
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    public static MethodHandle getstruct$MH() {
        return RuntimeHelper.requireNonNull(constants$0.getstruct$MH,"getstruct");
    }
    public static MemorySegment getstruct ( SegmentAllocator allocator) {
        var mh$ = RuntimeHelper.requireNonNull(constants$0.getstruct$MH, "getstruct");
        try {
            return (jdk.incubator.foreign.MemorySegment)mh$.invokeExact(allocator);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    public static MemorySegment getstruct ( ResourceScope scope) {
        return getstruct(SegmentAllocator.ofScope(scope));
    }
}


