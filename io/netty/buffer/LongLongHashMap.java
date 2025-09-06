package io.netty.buffer;

final class LongLongHashMap {
    private static final int MASK_TEMPLATE = -2;
    private long[] array;
    private final long emptyVal;
    private int mask;
    private int maxProbe;
    private long zeroVal;

    public LongLongHashMap(long v) {
        this.emptyVal = v;
        this.zeroVal = v;
        this.array = new long[0x20];
        this.mask = 0x1F;
        this.computeMaskAndProbe();
    }

    private void computeMaskAndProbe() {
        this.mask = this.array.length - 1 & -2;
        this.maxProbe = (int)Math.log(this.array.length);
    }

    private void expand() {
        long[] arr_v = this.array;
        this.array = new long[arr_v.length * 2];
        this.computeMaskAndProbe();
        for(int v = 0; v < arr_v.length; v += 2) {
            long v1 = arr_v[v];
            if(v1 != 0L) {
                this.put(v1, arr_v[v + 1]);
            }
        }
    }

    public long get(long v) {
        if(v == 0L) {
            return this.zeroVal;
        }
        int v1 = this.index(v);
        for(int v2 = 0; v2 < this.maxProbe; ++v2) {
            long[] arr_v = this.array;
            if(arr_v[v1] == v) {
                return arr_v[v1 + 1];
            }
            v1 = v1 + 2 & this.mask;
        }
        return this.emptyVal;
    }

    private int index(long v) {
        long v1 = (v ^ v >>> 33) * 0xFF51AFD7ED558CCDL;
        long v2 = (v1 ^ v1 >>> 33) * 0xC4CEB9FE1A85EC53L;
        return ((int)(v2 ^ v2 >>> 33)) & this.mask;
    }

    public long put(long v, long v1) {
        int v4;
        int v3;
        if(v == 0L) {
            long v2 = this.zeroVal;
            this.zeroVal = v1;
            return v2;
        }
        while(true) {
            v3 = this.index(v);
            v4 = 0;
        label_6:
            if(v4 < this.maxProbe) {
                break;
            }
            this.expand();
        }
        long[] arr_v = this.array;
        long v5 = arr_v[v3];
        if(v5 != v && v5 != 0L) {
            v3 = v3 + 2 & this.mask;
            ++v4;
            goto label_6;
        }
        long v6 = v5 == 0L ? this.emptyVal : arr_v[v3 + 1];
        arr_v[v3] = v;
        arr_v[v3 + 1] = v1;
        while(v4 < this.maxProbe) {
            v3 = v3 + 2 & this.mask;
            long[] arr_v1 = this.array;
            if(arr_v1[v3] == v) {
                arr_v1[v3] = 0L;
                return arr_v1[v3 + 1];
            }
            ++v4;
        }
        return v6;
    }

    public void remove(long v) {
        if(v == 0L) {
            this.zeroVal = this.emptyVal;
            return;
        }
        int v1 = this.index(v);
        for(int v2 = 0; v2 < this.maxProbe; ++v2) {
            long[] arr_v = this.array;
            if(arr_v[v1] == v) {
                arr_v[v1] = 0L;
                return;
            }
            v1 = v1 + 2 & this.mask;
        }
    }
}

