package io.netty.util.concurrent;

import java.util.Arrays;

final class DefaultFutureListeners {
    private GenericFutureListener[] listeners;
    private int progressiveSize;
    private int size;

    public DefaultFutureListeners(GenericFutureListener genericFutureListener0, GenericFutureListener genericFutureListener1) {
        GenericFutureListener[] arr_genericFutureListener = new GenericFutureListener[2];
        this.listeners = arr_genericFutureListener;
        arr_genericFutureListener[0] = genericFutureListener0;
        arr_genericFutureListener[1] = genericFutureListener1;
        this.size = 2;
        if(genericFutureListener0 instanceof GenericProgressiveFutureListener) {
            ++this.progressiveSize;
        }
        if(genericFutureListener1 instanceof GenericProgressiveFutureListener) {
            ++this.progressiveSize;
        }
    }

    public void add(GenericFutureListener genericFutureListener0) {
        GenericFutureListener[] arr_genericFutureListener = this.listeners;
        int v = this.size;
        if(v == arr_genericFutureListener.length) {
            arr_genericFutureListener = (GenericFutureListener[])Arrays.copyOf(arr_genericFutureListener, v << 1);
            this.listeners = arr_genericFutureListener;
        }
        arr_genericFutureListener[v] = genericFutureListener0;
        this.size = v + 1;
        if(genericFutureListener0 instanceof GenericProgressiveFutureListener) {
            ++this.progressiveSize;
        }
    }

    public GenericFutureListener[] listeners() {
        return this.listeners;
    }

    public int progressiveSize() {
        return this.progressiveSize;
    }

    public void remove(GenericFutureListener genericFutureListener0) {
        GenericFutureListener[] arr_genericFutureListener = this.listeners;
        int v = this.size;
        for(int v1 = 0; v1 < v; ++v1) {
            if(arr_genericFutureListener[v1] == genericFutureListener0) {
                int v2 = v - v1 - 1;
                if(v2 > 0) {
                    System.arraycopy(arr_genericFutureListener, v1 + 1, arr_genericFutureListener, v1, v2);
                }
                arr_genericFutureListener[v - 1] = null;
                this.size = v - 1;
                if(!(genericFutureListener0 instanceof GenericProgressiveFutureListener)) {
                    break;
                }
                --this.progressiveSize;
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}

