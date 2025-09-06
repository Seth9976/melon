package com.google.protobuf;

import U4.x;
import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class c2 extends c implements A2, N1, RandomAccess {
    public long[] b;
    public int c;
    public static final long[] d;
    public static final c2 e;

    static {
        long[] arr_v = new long[0];
        c2.d = arr_v;
        c2.e = new c2(arr_v, 0, false);
    }

    public c2() {
        this(c2.d, 0, true);
    }

    public c2(long[] arr_v, int v, boolean z) {
        super(z);
        this.b = arr_v;
        this.c = v;
    }

    @Override
    public final void add(int v, Object object0) {
        long v1 = (long)(((Long)object0));
        this.b();
        if(v >= 0) {
            int v2 = this.c;
            if(v <= v2) {
                long[] arr_v = this.b;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    long[] arr_v1 = new long[Z.c(arr_v.length, 3, 2, 1, 10)];
                    System.arraycopy(this.b, 0, arr_v1, 0, v);
                    System.arraycopy(this.b, v, arr_v1, v + 1, this.c - v);
                    this.b = arr_v1;
                }
                this.b[v] = v1;
                ++this.c;
                ++this.modCount;
                return;
            }
        }
        StringBuilder stringBuilder0 = x.n(v, "Index:", ", Size:");
        stringBuilder0.append(this.c);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    @Override
    public final boolean add(Object object0) {
        this.d(((long)(((Long)object0))));
        return true;
    }

    @Override  // com.google.protobuf.c
    public final boolean addAll(Collection collection0) {
        this.b();
        collection0.getClass();
        if(!(collection0 instanceof c2)) {
            return super.addAll(collection0);
        }
        int v = ((c2)collection0).c;
        if(v == 0) {
            return false;
        }
        int v1 = this.c;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        long[] arr_v = this.b;
        if(v2 > arr_v.length) {
            this.b = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((c2)collection0).b, 0, this.b, this.c, ((c2)collection0).c);
        this.c = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    public final void d(long v) {
        this.b();
        long[] arr_v = this.b;
        if(this.c == arr_v.length) {
            long[] arr_v1 = new long[Z.c(arr_v.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, arr_v1, 0, this.c);
            this.b = arr_v1;
        }
        int v1 = this.c;
        this.c = v1 + 1;
        this.b[v1] = v;
    }

    public final void e(int v) {
        if(v >= 0 && v < this.c) {
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "Index:", ", Size:");
        stringBuilder0.append(this.c);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    @Override  // com.google.protobuf.c
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c2)) {
            return super.equals(object0);
        }
        if(this.c != ((c2)object0).c) {
            return false;
        }
        long[] arr_v = ((c2)object0).b;
        for(int v = 0; v < this.c; ++v) {
            if(this.b[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    public final long f(int v) {
        this.e(v);
        return this.b[v];
    }

    public final c2 g(int v) {
        if(v < this.c) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new c2(c2.d, this.c, true) : new c2(Arrays.copyOf(this.b, v), this.c, true);
    }

    @Override
    public final Object get(int v) {
        return this.f(v);
    }

    @Override  // com.google.protobuf.c
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.c; ++v1) {
            v = v * 0x1F + P1.b(this.b[v1]);
        }
        return v;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Long)) {
            return -1;
        }
        long v = (long)(((Long)object0));
        int v1 = this.c;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(this.b[v2] == v) {
                return v2;
            }
        }
        return -1;
    }

    @Override  // com.google.protobuf.O1
    public final O1 n(int v) {
        return this.g(v);
    }

    @Override  // com.google.protobuf.c
    public final Object remove(int v) {
        this.b();
        this.e(v);
        long[] arr_v = this.b;
        long v1 = arr_v[v];
        int v2 = this.c;
        if(v < v2 - 1) {
            System.arraycopy(arr_v, v + 1, arr_v, v, v2 - v - 1);
        }
        --this.c;
        ++this.modCount;
        return v1;
    }

    @Override
    public final void removeRange(int v, int v1) {
        this.b();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.b, v1, this.b, v, this.c - v1);
        this.c -= v1 - v;
        ++this.modCount;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.b();
        this.e(v);
        long[] arr_v = this.b;
        long v1 = arr_v[v];
        arr_v[v] = (long)(((Long)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.c;
    }
}

