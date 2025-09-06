package androidx.collection;

import Ce.g;
import E.a;
import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;

public final class y {
    public int[] a;
    public int b;

    public y() {
        this(16);
    }

    public y(int v) {
        this.a = v == 0 ? o.a : new int[v];
    }

    public final void a(int v) {
        this.b(this.b + 1);
        int v1 = this.b;
        this.a[v1] = v;
        this.b = v1 + 1;
    }

    public final void b(int v) {
        int[] arr_v = this.a;
        if(arr_v.length < v) {
            int[] arr_v1 = Arrays.copyOf(arr_v, Math.max(v, arr_v.length * 3 / 2));
            q.f(arr_v1, "copyOf(...)");
            this.a = arr_v1;
        }
    }

    public final int c(int v) {
        if(v >= 0 && v < this.b) {
            return this.a[v];
        }
        a.d("Index must be between 0 and size");
        throw null;
    }

    public final int d() {
        int v = this.b;
        if(v != 0) {
            return this.a[v - 1];
        }
        a.e("IntList is empty.");
        throw null;
    }

    public final int e(int v) {
        if(v >= 0) {
            int v1 = this.b;
            if(v < v1) {
                int[] arr_v = this.a;
                int v2 = arr_v[v];
                if(v != v1 - 1) {
                    n.S(v, v + 1, v1, arr_v, arr_v);
                }
                --this.b;
                return v2;
            }
        }
        a.d("Index must be between 0 and size");
        throw null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof y) {
            int v = this.b;
            if(((y)object0).b == v) {
                int[] arr_v = this.a;
                int[] arr_v1 = ((y)object0).a;
                g g0 = P4.a.K(0, v);
                int v1 = g0.a;
                int v2 = g0.b;
                if(v1 <= v2) {
                    while(true) {
                        if(arr_v[v1] != arr_v1[v1]) {
                            return false;
                        }
                        if(v1 == v2) {
                            break;
                        }
                        ++v1;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int v, int v1) {
        if(v >= 0 && v < this.b) {
            int[] arr_v = this.a;
            int v2 = arr_v[v];
            arr_v[v] = v1;
            return;
        }
        a.d("Index must be between 0 and size");
        throw null;
    }

    @Override
    public final int hashCode() {
        int[] arr_v = this.a;
        int v = this.b;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += arr_v[v1] * 0x1F;
        }
        return v2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("[");
        int[] arr_v = this.a;
        int v = this.b;
        for(int v1 = 0; true; ++v1) {
            if(v1 >= v) {
                stringBuilder0.append("]");
                break;
            }
            int v2 = arr_v[v1];
            if(v1 == -1) {
                stringBuilder0.append("...");
                break;
            }
            if(v1 != 0) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(v2);
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

