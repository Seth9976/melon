package androidx.datastore.preferences.protobuf;

import U4.x;
import java.util.Arrays;
import java.util.RandomAccess;

public final class c0 extends b implements RandomAccess {
    public Object[] b;
    public int c;
    public static final c0 d;

    static {
        c0.d = new c0(new Object[0], 0, false);
    }

    public c0(Object[] arr_object, int v, boolean z) {
        this.a = z;
        this.b = arr_object;
        this.c = v;
    }

    @Override
    public final void add(int v, Object object0) {
        this.b();
        if(v >= 0) {
            int v1 = this.c;
            if(v <= v1) {
                Object[] arr_object = this.b;
                if(v1 < arr_object.length) {
                    System.arraycopy(arr_object, v, arr_object, v + 1, v1 - v);
                }
                else {
                    Object[] arr_object1 = new Object[v1 * 3 / 2 + 1];
                    System.arraycopy(arr_object, 0, arr_object1, 0, v);
                    System.arraycopy(this.b, v, arr_object1, v + 1, this.c - v);
                    this.b = arr_object1;
                }
                this.b[v] = object0;
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
        this.b();
        int v = this.c;
        Object[] arr_object = this.b;
        if(v == arr_object.length) {
            this.b = Arrays.copyOf(arr_object, v * 3 / 2 + 1);
        }
        int v1 = this.c;
        this.c = v1 + 1;
        this.b[v1] = object0;
        ++this.modCount;
        return true;
    }

    public final void d(int v) {
        if(v >= 0 && v < this.c) {
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "Index:", ", Size:");
        stringBuilder0.append(this.c);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public final c0 e(int v) {
        if(v < this.c) {
            throw new IllegalArgumentException();
        }
        return new c0(Arrays.copyOf(this.b, v), this.c, true);
    }

    @Override
    public final Object get(int v) {
        this.d(v);
        return this.b[v];
    }

    @Override  // androidx.datastore.preferences.protobuf.b
    public final Object remove(int v) {
        this.b();
        this.d(v);
        Object[] arr_object = this.b;
        Object object0 = arr_object[v];
        int v1 = this.c;
        if(v < v1 - 1) {
            System.arraycopy(arr_object, v + 1, arr_object, v, v1 - v - 1);
        }
        --this.c;
        ++this.modCount;
        return object0;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.b();
        this.d(v);
        Object[] arr_object = this.b;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        ++this.modCount;
        return object1;
    }

    @Override
    public final int size() {
        return this.c;
    }
}

