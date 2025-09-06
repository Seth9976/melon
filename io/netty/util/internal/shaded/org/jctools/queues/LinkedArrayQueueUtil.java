package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

final class LinkedArrayQueueUtil {
    public static int length(Object[] arr_object) {
        return arr_object.length;
    }

    public static long modifiedCalcCircularRefElementOffset(long v, long v1) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((v & v1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1);
    }

    public static long nextArrayOffset(Object[] arr_object) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + (((long)(LinkedArrayQueueUtil.length(arr_object) - 1)) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}

