package com.google.protobuf;

import U4.x;
import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class j extends c implements A2, E1, RandomAccess {
    public boolean[] b;
    public int c;
    public static final boolean[] d;
    public static final j e;

    static {
        boolean[] arr_z = new boolean[0];
        j.d = arr_z;
        j.e = new j(arr_z, 0, false);
    }

    public j(boolean[] arr_z, int v, boolean z) {
        super(z);
        this.b = arr_z;
        this.c = v;
    }

    @Override
    public final void add(int v, Object object0) {
        boolean z = ((Boolean)object0).booleanValue();
        this.b();
        if(v >= 0) {
            int v1 = this.c;
            if(v <= v1) {
                boolean[] arr_z = this.b;
                if(v1 < arr_z.length) {
                    System.arraycopy(arr_z, v, arr_z, v + 1, v1 - v);
                }
                else {
                    boolean[] arr_z1 = new boolean[Z.c(arr_z.length, 3, 2, 1, 10)];
                    System.arraycopy(this.b, 0, arr_z1, 0, v);
                    System.arraycopy(this.b, v, arr_z1, v + 1, this.c - v);
                    this.b = arr_z1;
                }
                this.b[v] = z;
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
        this.d(((Boolean)object0).booleanValue());
        return true;
    }

    @Override  // com.google.protobuf.c
    public final boolean addAll(Collection collection0) {
        this.b();
        collection0.getClass();
        if(!(collection0 instanceof j)) {
            return super.addAll(collection0);
        }
        int v = ((j)collection0).c;
        if(v == 0) {
            return false;
        }
        int v1 = this.c;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        boolean[] arr_z = this.b;
        if(v2 > arr_z.length) {
            this.b = Arrays.copyOf(arr_z, v2);
        }
        System.arraycopy(((j)collection0).b, 0, this.b, this.c, ((j)collection0).c);
        this.c = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    public final void d(boolean z) {
        this.b();
        boolean[] arr_z = this.b;
        if(this.c == arr_z.length) {
            boolean[] arr_z1 = new boolean[Z.c(arr_z.length, 3, 2, 1, 10)];
            System.arraycopy(this.b, 0, arr_z1, 0, this.c);
            this.b = arr_z1;
        }
        int v = this.c;
        this.c = v + 1;
        this.b[v] = z;
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
        if(!(object0 instanceof j)) {
            return super.equals(object0);
        }
        if(this.c != ((j)object0).c) {
            return false;
        }
        boolean[] arr_z = ((j)object0).b;
        for(int v = 0; v < this.c; ++v) {
            if(this.b[v] != arr_z[v]) {
                return false;
            }
        }
        return true;
    }

    public final j f(int v) {
        if(v < this.c) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new j(j.d, this.c, true) : new j(Arrays.copyOf(this.b, v), this.c, true);
    }

    @Override
    public final Object get(int v) {
        this.e(v);
        return Boolean.valueOf(this.b[v]);
    }

    @Override  // com.google.protobuf.c
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.c; ++v1) {
            v = v * 0x1F + (this.b[v1] ? 0x4CF : 0x4D5);
        }
        return v;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Boolean)) {
            return -1;
        }
        boolean z = ((Boolean)object0).booleanValue();
        int v = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.b[v1] == z) {
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
        boolean[] arr_z = this.b;
        boolean z = arr_z[v];
        int v1 = this.c;
        if(v < v1 - 1) {
            System.arraycopy(arr_z, v + 1, arr_z, v, v1 - v - 1);
        }
        --this.c;
        ++this.modCount;
        return Boolean.valueOf(z);
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
        boolean[] arr_z = this.b;
        boolean z = arr_z[v];
        arr_z[v] = ((Boolean)object0).booleanValue();
        return Boolean.valueOf(z);
    }

    @Override
    public final int size() {
        return this.c;
    }
}

