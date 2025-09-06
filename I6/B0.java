package I6;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import y5.a;

public abstract class b0 extends O implements Set {
    public transient V b;
    public static final int c = 0;
    private static final long serialVersionUID = 0xDECAFL;

    @Override  // I6.O
    public V b() {
        V v0 = this.b;
        if(v0 == null) {
            v0 = this.q();
            this.b = v0;
        }
        return v0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof b0 && this instanceof v0) {
            ((b0)object0).getClass();
            return !(((b0)object0) instanceof v0) || this.hashCode() == object0.hashCode() ? w.h(this, object0) : false;
        }
        return w.h(this, object0);
    }

    @Override
    public int hashCode() {
        return w.k(this);
    }

    public static int l(int v) {
        int v1 = Math.max(v, 2);
        boolean z = true;
        if(v1 < 0x2CCCCCCC) {
            int v2;
            for(v2 = Integer.highestOneBit(v1 - 1) << 1; ((double)v2) * 0.7 < ((double)v1); v2 <<= 1) {
            }
            return v2;
        }
        if(v1 >= 0x40000000) {
            z = false;
        }
        a.m(z, "collection too large");
        return 0x40000000;
    }

    public static b0 o(int v, Object[] arr_object) {
        switch(v) {
            case 0: {
                return v0.j;
            }
            case 1: {
                Object object3 = arr_object[0];
                Objects.requireNonNull(object3);
                return new E0(object3);
            }
            default: {
                int v1 = b0.l(v);
                Object[] arr_object1 = new Object[v1];
                int v3 = 0;
                int v4 = 0;
                for(int v2 = 0; v2 < v; ++v2) {
                    Object object0 = arr_object[v2];
                    if(object0 == null) {
                        throw new NullPointerException("at index " + v2);
                    }
                    int v5 = object0.hashCode();
                    for(int v6 = w.r(v5); true; ++v6) {
                        int v7 = v6 & v1 - 1;
                        Object object1 = arr_object1[v7];
                        if(object1 == null) {
                            arr_object[v4] = object0;
                            arr_object1[v7] = object0;
                            v3 += v5;
                            ++v4;
                            break;
                        }
                        if(object1.equals(object0)) {
                            break;
                        }
                    }
                }
                Arrays.fill(arr_object, v4, v, null);
                if(v4 == 1) {
                    Object object2 = arr_object[0];
                    Objects.requireNonNull(object2);
                    return new E0(object2);
                }
                if(b0.l(v4) < v1 / 2) {
                    return b0.o(v4, arr_object);
                }
                if(v4 < (arr_object.length >> 1) + (arr_object.length >> 2)) {
                    arr_object = Arrays.copyOf(arr_object, v4);
                }
                return new v0(arr_object, v3, arr_object1, v1 - 1, v4);
            }
        }
    }

    public static b0 p(Collection collection0) {
        if(collection0 instanceof b0 && !(collection0 instanceof SortedSet) && !((b0)collection0).i()) {
            return (b0)collection0;
        }
        Object[] arr_object = collection0.toArray();
        return b0.o(arr_object.length, arr_object);
    }

    public V q() {
        Object[] arr_object = this.toArray(O.a);
        return V.l(arr_object.length, arr_object);
    }

    public static b0 r(String s, String s1, String s2, String s3, String s4, String s5, Object[] arr_object) {
        a.m(arr_object.length <= 0x7FFFFFF9, "the total number of elements must fit in an int");
        Object[] arr_object1 = new Object[arr_object.length + 6];
        arr_object1[0] = s;
        arr_object1[1] = s1;
        arr_object1[2] = s2;
        arr_object1[3] = s3;
        arr_object1[4] = s4;
        arr_object1[5] = s5;
        System.arraycopy(arr_object, 0, arr_object1, 6, arr_object.length);
        return b0.o(arr_object.length + 6, arr_object1);
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override  // I6.O
    public Object writeReplace() {
        return new a0(this.toArray(O.a));
    }
}

