// Generated by jextract

package org.hello;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public class student {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
        C_POINTER.withName("name"),
        C_INT.withName("age"),
        MemoryLayout.paddingLayout(32),
        C_DOUBLE.withName("height")
    ).withName("student");
    public static MemoryLayout $LAYOUT() {
        return student.$struct$LAYOUT;
    }
    static final VarHandle name$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("name")));
    public static VarHandle name$VH() {
        return student.name$VH;
    }
    public static MemoryAddress name$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)student.name$VH.get(seg);
    }
    public static void name$set( MemorySegment seg, MemoryAddress x) {
        student.name$VH.set(seg, x);
    }
    public static MemoryAddress name$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)student.name$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void name$set(MemorySegment seg, long index, MemoryAddress x) {
        student.name$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle age$VH = $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("age"));
    public static VarHandle age$VH() {
        return student.age$VH;
    }
    public static int age$get(MemorySegment seg) {
        return (int)student.age$VH.get(seg);
    }
    public static void age$set( MemorySegment seg, int x) {
        student.age$VH.set(seg, x);
    }
    public static int age$get(MemorySegment seg, long index) {
        return (int)student.age$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void age$set(MemorySegment seg, long index, int x) {
        student.age$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle height$VH = $struct$LAYOUT.varHandle(double.class, MemoryLayout.PathElement.groupElement("height"));
    public static VarHandle height$VH() {
        return student.height$VH;
    }
    public static double height$get(MemorySegment seg) {
        return (double)student.height$VH.get(seg);
    }
    public static void height$set( MemorySegment seg, double x) {
        student.height$VH.set(seg, x);
    }
    public static double height$get(MemorySegment seg, long index) {
        return (double)student.height$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void height$set(MemorySegment seg, long index, double x) {
        student.height$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocate(ResourceScope scope) { return allocate(SegmentAllocator.ofScope(scope)); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


