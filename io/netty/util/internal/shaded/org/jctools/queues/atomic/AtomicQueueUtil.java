package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class AtomicQueueUtil {
    public static AtomicLongArray allocateLongArray(int v) {
        return new AtomicLongArray(v);
    }

    public static AtomicReferenceArray allocateRefArray(int v) {
        return new AtomicReferenceArray(v);
    }

    public static int calcCircularLongElementOffset(long v, int v1) {
        return (int)(v & ((long)v1));
    }

    public static int calcCircularRefElementOffset(long v, long v1) {
        return (int)(v & v1);
    }

    public static int calcLongElementOffset(long v) {
        return (int)v;
    }

    public static int calcRefElementOffset(long v) {
        return (int)v;
    }

    public static int length(AtomicReferenceArray atomicReferenceArray0) {
        return atomicReferenceArray0.length();
    }

    public static long lpLongElement(AtomicLongArray atomicLongArray0, int v) {
        return atomicLongArray0.get(v);
    }

    public static Object lpRefElement(AtomicReferenceArray atomicReferenceArray0, int v) {
        return atomicReferenceArray0.get(v);
    }

    public static long lvLongElement(AtomicLongArray atomicLongArray0, int v) {
        return atomicLongArray0.get(v);
    }

    public static Object lvRefElement(AtomicReferenceArray atomicReferenceArray0, int v) {
        return atomicReferenceArray0.get(v);
    }

    public static int modifiedCalcCircularRefElementOffset(long v, long v1) {
        return ((int)(v & v1)) >> 1;
    }

    public static int nextArrayOffset(AtomicReferenceArray atomicReferenceArray0) {
        return AtomicQueueUtil.length(atomicReferenceArray0) - 1;
    }

    public static void soLongElement(AtomicLongArray atomicLongArray0, int v, long v1) {
        atomicLongArray0.lazySet(v, v1);
    }

    public static void soRefElement(AtomicReferenceArray atomicReferenceArray0, int v, Object object0) {
        atomicReferenceArray0.lazySet(v, object0);
    }

    public static void spLongElement(AtomicLongArray atomicLongArray0, int v, long v1) {
        atomicLongArray0.lazySet(v, v1);
    }

    public static void spRefElement(AtomicReferenceArray atomicReferenceArray0, int v, Object object0) {
        atomicReferenceArray0.lazySet(v, object0);
    }

    public static void svRefElement(AtomicReferenceArray atomicReferenceArray0, int v, Object object0) {
        atomicReferenceArray0.set(v, object0);
    }
}

