package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class TimedValueQueue {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private Object[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int v) {
        this.timestamps = new long[v];
        this.values = TimedValueQueue.newArray(v);
    }

    public void add(long v, Object object0) {
        synchronized(this) {
            this.clearBufferOnTimeDiscontinuity(v);
            this.doubleCapacityIfFull();
            this.addUnchecked(v, object0);
        }
    }

    private void addUnchecked(long v, Object object0) {
        int v1 = this.size;
        Object[] arr_object = this.values;
        int v2 = (this.first + v1) % arr_object.length;
        this.timestamps[v2] = v;
        arr_object[v2] = object0;
        this.size = v1 + 1;
    }

    public void clear() {
        synchronized(this) {
            this.first = 0;
            this.size = 0;
            Arrays.fill(this.values, null);
        }
    }

    private void clearBufferOnTimeDiscontinuity(long v) {
        if(this.size > 0 && v <= this.timestamps[(this.first + this.size - 1) % this.values.length]) {
            this.clear();
        }
    }

    private void doubleCapacityIfFull() {
        int v = this.values.length;
        if(this.size < v) {
            return;
        }
        long[] arr_v = new long[v * 2];
        Object[] arr_object = TimedValueQueue.newArray(v * 2);
        int v1 = v - this.first;
        System.arraycopy(this.timestamps, this.first, arr_v, 0, v1);
        System.arraycopy(this.values, this.first, arr_object, 0, v1);
        int v2 = this.first;
        if(v2 > 0) {
            System.arraycopy(this.timestamps, 0, arr_v, v1, v2);
            System.arraycopy(this.values, 0, arr_object, v1, this.first);
        }
        this.timestamps = arr_v;
        this.values = arr_object;
        this.first = 0;
    }

    private static Object[] newArray(int v) {
        return new Object[v];
    }

    private Object poll(long v, boolean z) {
        Object object0 = null;
        int v2;
        for(long v1 = 0x7FFFFFFFFFFFFFFFL; (v2 = this.size) > 0; v1 = v4) {
            int v3 = this.first;
            long v4 = v - this.timestamps[v3];
            if(v4 < 0L && (z || -v4 >= v1)) {
                break;
            }
            Object[] arr_object = this.values;
            object0 = arr_object[v3];
            arr_object[v3] = null;
            this.first = (v3 + 1) % arr_object.length;
            this.size = v2 - 1;
        }
        return object0;
    }

    public Object poll(long v) {
        synchronized(this) {
            return this.poll(v, false);
        }
    }

    public Object pollFloor(long v) {
        synchronized(this) {
            return this.poll(v, true);
        }
    }

    public int size() {
        synchronized(this) {
        }
        return this.size;
    }
}

