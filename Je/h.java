package je;

import U4.x;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.q;

public final class H extends f implements RandomAccess {
    public final Object[] a;
    public final int b;
    public int c;
    public int d;

    public H(Object[] arr_object, int v) {
        this.a = arr_object;
        if(v < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + v).toString());
        }
        if(v <= arr_object.length) {
            this.b = arr_object.length;
            this.d = v;
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
        stringBuilder0.append(arr_object.length);
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public final void a(int v) {
        if(v < 0) {
            throw new IllegalArgumentException(("n shouldn\'t be negative but it is " + v).toString());
        }
        if(v <= this.size()) {
            if(v > 0) {
                int v1 = this.c;
                int v2 = this.b;
                int v3 = (v1 + v) % v2;
                Object[] arr_object = this.a;
                if(v1 > v3) {
                    Arrays.fill(arr_object, v1, v2, null);
                    Arrays.fill(arr_object, 0, v3, null);
                }
                else {
                    Arrays.fill(arr_object, v1, v3, null);
                }
                this.c = v3;
                this.d = this.size() - v;
            }
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "n shouldn\'t be greater than the buffer size: n = ", ", size = ");
        stringBuilder0.append(this.size());
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override
    public final Object get(int v) {
        f.Companion.getClass();
        c.b(v, this.size());
        return this.a[(this.c + v) % this.b];
    }

    @Override  // je.a
    public final int getSize() {
        return this.d;
    }

    @Override  // je.f
    public final Iterator iterator() {
        return new G(this);
    }

    @Override  // je.a
    public final Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }

    @Override  // je.a
    public final Object[] toArray(Object[] arr_object) {
        Object[] arr_object1;
        q.g(arr_object, "array");
        if(arr_object.length < this.size()) {
            arr_object = Arrays.copyOf(arr_object, this.size());
            q.f(arr_object, "copyOf(...)");
        }
        int v = this.size();
        int v1 = this.c;
        int v3 = 0;
        while(true) {
            arr_object1 = this.a;
            if(v3 >= v || v1 >= this.b) {
                break;
            }
            arr_object[v3] = arr_object1[v1];
            ++v3;
            ++v1;
        }
        for(int v2 = 0; v3 < v; ++v2) {
            arr_object[v3] = arr_object1[v2];
            ++v3;
        }
        if(v < arr_object.length) {
            arr_object[v] = null;
        }
        return arr_object;
    }
}

