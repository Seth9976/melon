package com.google.protobuf;

import U4.x;
import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class q1 extends c implements A2, J1, RandomAccess {
    public float[] b;
    public int c;
    public static final float[] d;
    public static final q1 e;

    static {
        float[] arr_f = new float[0];
        q1.d = arr_f;
        q1.e = new q1(arr_f, 0, false);
    }

    public q1(float[] arr_f, int v, boolean z) {
        super(z);
        this.b = arr_f;
        this.c = v;
    }

    @Override
    public final void add(int v, Object object0) {
        float f = (float)(((Float)object0));
        this.b();
        if(v >= 0) {
            int v1 = this.c;
            if(v <= v1) {
                float[] arr_f = this.b;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    float[] arr_f1 = new float[Z.c(arr_f.length, 3, 2, 1, 10)];
                    System.arraycopy(this.b, 0, arr_f1, 0, v);
                    System.arraycopy(this.b, v, arr_f1, v + 1, this.c - v);
                    this.b = arr_f1;
                }
                this.b[v] = f;
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
        this.d(((float)(((Float)object0))));
        return true;
    }

    @Override  // com.google.protobuf.c
    public final boolean addAll(Collection collection0) {
        this.b();
        collection0.getClass();
        if(!(collection0 instanceof q1)) {
            return super.addAll(collection0);
        }
        int v = ((q1)collection0).c;
        if(v == 0) {
            return false;
        }
        int v1 = this.c;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        float[] arr_f = this.b;
        if(v2 > arr_f.length) {
            this.b = Arrays.copyOf(arr_f, v2);
        }
        System.arraycopy(((q1)collection0).b, 0, this.b, this.c, ((q1)collection0).c);
        this.c = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    public final void d(float f) {
        this.b();
        float[] arr_f = this.b;
        if(this.c == arr_f.length) {
            float[] arr_f1 = new float[Z.c(arr_f.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, arr_f1, 0, this.c);
            this.b = arr_f1;
        }
        int v = this.c;
        this.c = v + 1;
        this.b[v] = f;
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
        if(!(object0 instanceof q1)) {
            return super.equals(object0);
        }
        if(this.c != ((q1)object0).c) {
            return false;
        }
        float[] arr_f = ((q1)object0).b;
        for(int v = 0; v < this.c; ++v) {
            if(Float.floatToIntBits(this.b[v]) != Float.floatToIntBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    public final q1 f(int v) {
        if(v < this.c) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new q1(q1.d, this.c, true) : new q1(Arrays.copyOf(this.b, v), this.c, true);
    }

    @Override
    public final Object get(int v) {
        this.e(v);
        return (float)this.b[v];
    }

    @Override  // com.google.protobuf.c
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.c; ++v1) {
            v = v * 0x1F + Float.floatToIntBits(this.b[v1]);
        }
        return v;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Float)) {
            return -1;
        }
        float f = (float)(((Float)object0));
        int v = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.b[v1] == f) {
                return v1;
            }
        }
        return -1;
    }

    @Override  // com.google.protobuf.O1
    public final O1 n(int v) {
        return this.f(v);
    }

    @Override  // com.google.protobuf.c
    public final Object remove(int v) {
        this.b();
        this.e(v);
        float[] arr_f = this.b;
        float f = arr_f[v];
        int v1 = this.c;
        if(v < v1 - 1) {
            System.arraycopy(arr_f, v + 1, arr_f, v, v1 - v - 1);
        }
        --this.c;
        ++this.modCount;
        return f;
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
        float[] arr_f = this.b;
        float f = arr_f[v];
        arr_f[v] = (float)(((Float)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.c;
    }
}

