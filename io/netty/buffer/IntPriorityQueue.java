package io.netty.buffer;

import java.util.Arrays;

final class IntPriorityQueue {
    public static final int NO_VALUE = -1;
    private int[] array;
    private int size;

    public IntPriorityQueue() {
        this.array = new int[9];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void lift(int v) {
        while(v > 1 && this.subord(v >> 1, v)) {
            this.swap(v, v >> 1);
            v >>= 1;
        }
    }

    public void offer(int v) {
        if(v == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        int v1 = this.size + 1;
        this.size = v1;
        int[] arr_v = this.array;
        if(v1 == arr_v.length) {
            this.array = Arrays.copyOf(arr_v, (arr_v.length - 1) * 2 + 1);
        }
        int v2 = this.size;
        this.array[v2] = v;
        this.lift(v2);
    }

    public int peek() {
        return this.size == 0 ? -1 : this.array[1];
    }

    public int poll() {
        int v = this.size;
        if(v == 0) {
            return -1;
        }
        int[] arr_v = this.array;
        int v1 = arr_v[1];
        arr_v[1] = arr_v[v];
        arr_v[v] = 0;
        this.size = v - 1;
        this.sink(1);
        return v1;
    }

    public void remove(int v) {
        for(int v1 = 1; true; ++v1) {
            int v2 = this.size;
            if(v1 > v2) {
                break;
            }
            int[] arr_v = this.array;
            if(arr_v[v1] == v) {
                this.size = v2 - 1;
                arr_v[v1] = arr_v[v2];
                this.lift(v1);
                this.sink(v1);
                return;
            }
        }
    }

    private void sink(int v) {
        while(true) {
            int v1 = v << 1;
            int v2 = this.size;
            if(v1 > v2) {
                break;
            }
            if(v1 < v2 && this.subord(v1, v1 + 1)) {
                ++v1;
            }
            if(!this.subord(v, v1)) {
                break;
            }
            this.swap(v, v1);
            v = v1;
        }
    }

    private boolean subord(int v, int v1) {
        return this.array[v] > this.array[v1];
    }

    private void swap(int v, int v1) {
        int[] arr_v = this.array;
        int v2 = arr_v[v];
        arr_v[v] = arr_v[v1];
        arr_v[v1] = v2;
    }
}

