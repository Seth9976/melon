package m0;

public final class h {
    public final int a;
    public final long[] b;
    public final Object[] c;

    public h(int v, long[] arr_v, Object[] arr_object) {
        this.a = v;
        this.b = arr_v;
        this.c = arr_object;
    }

    public final int a(long v) {
        int v1 = this.a - 1;
        if(v1 != -1) {
            long[] arr_v = this.b;
            int v2 = 0;
            if(v1 != 0) {
                while(v2 <= v1) {
                    int v3 = v2 + v1 >>> 1;
                    int v4 = Long.compare(arr_v[v3] - v, 0L);
                    if(v4 < 0) {
                        v2 = v3 + 1;
                        continue;
                    }
                    if(v4 > 0) {
                        v1 = v3 - 1;
                        continue;
                    }
                    return v3;
                }
                return -(v2 + 1);
            }
            long v5 = arr_v[0];
            if(v5 == v) {
                return 0;
            }
            return v5 <= v ? -1 : -2;
        }
        return -1;
    }

    public final h b(long v, Object object0) {
        long[] arr_v1;
        Object[] arr_object = this.c;
        int v1 = 0;
        int v3 = 0;
        for(int v2 = 0; v2 < arr_object.length; ++v2) {
            if(arr_object[v2] != null) {
                ++v3;
            }
        }
        long[] arr_v = new long[v3 + 1];
        Object[] arr_object1 = new Object[v3 + 1];
        if(v3 + 1 > 1) {
            int v4;
            for(v4 = 0; true; ++v4) {
                arr_v1 = this.b;
                int v5 = this.a;
                if(v1 >= v3 + 1 || v4 >= v5) {
                    break;
                }
                long v6 = arr_v1[v4];
                Object object1 = arr_object[v4];
                if(v6 > v) {
                    arr_v[v1] = v;
                    arr_object1[v1] = object0;
                    ++v1;
                    break;
                }
                if(object1 != null) {
                    arr_v[v1] = v6;
                    arr_object1[v1] = object1;
                    ++v1;
                }
            }
            if(v4 == v5) {
                arr_v[v3] = v;
                arr_object1[v3] = object0;
                return new h(v3 + 1, arr_v, arr_object1);
            }
            while(v1 < v3 + 1) {
                long v7 = arr_v1[v4];
                Object object2 = arr_object[v4];
                if(object2 != null) {
                    arr_v[v1] = v7;
                    arr_object1[v1] = object2;
                    ++v1;
                }
                ++v4;
            }
            return new h(v3 + 1, arr_v, arr_object1);
        }
        arr_v[0] = v;
        arr_object1[0] = object0;
        return new h(v3 + 1, arr_v, arr_object1);
    }
}

