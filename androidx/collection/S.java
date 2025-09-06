package androidx.collection;

import E.a;
import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;

public final class s implements Cloneable {
    public boolean a;
    public long[] b;
    public Object[] c;
    public int d;

    public s(int v) {
        if(v == 0) {
            this.b = a.b;
            this.c = a.c;
            return;
        }
        int v1 = v * 8;
        for(int v2 = 4; v2 < 0x20; ++v2) {
            int v3 = (1 << v2) - 12;
            if(v1 <= v3) {
                v1 = v3;
                break;
            }
        }
        this.b = new long[v1 / 8];
        this.c = new Object[v1 / 8];
    }

    public s(Object object0) {
        this(10);
    }

    public final void a() {
        int v = this.d;
        Object[] arr_object = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            arr_object[v1] = null;
        }
        this.d = 0;
        this.a = false;
    }

    public final Object b(long v) {
        int v1 = a.b(this.b, this.d, v);
        if(v1 >= 0) {
            Object object0 = this.c[v1];
            return object0 == t.a ? null : object0;
        }
        return null;
    }

    public final int c(long v) {
        if(this.a) {
            int v1 = this.d;
            long[] arr_v = this.b;
            Object[] arr_object = this.c;
            int v3 = 0;
            for(int v2 = 0; v2 < v1; ++v2) {
                Object object0 = arr_object[v2];
                if(object0 != t.a) {
                    if(v2 != v3) {
                        arr_v[v3] = arr_v[v2];
                        arr_object[v3] = object0;
                        arr_object[v2] = null;
                    }
                    ++v3;
                }
            }
            this.a = false;
            this.d = v3;
        }
        return a.b(this.b, this.d, v);
    }

    @Override
    public final Object clone() {
        Object object0 = super.clone();
        q.e(object0, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        ((s)object0).b = (long[])this.b.clone();
        ((s)object0).c = (Object[])this.c.clone();
        return (s)object0;
    }

    public final boolean d() {
        return this.h() == 0;
    }

    public final long e(int v) {
        if(v >= 0) {
            int v1 = this.d;
            if(v < v1) {
                if(this.a) {
                    long[] arr_v = this.b;
                    Object[] arr_object = this.c;
                    int v3 = 0;
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Object object0 = arr_object[v2];
                        if(object0 != t.a) {
                            if(v2 != v3) {
                                arr_v[v3] = arr_v[v2];
                                arr_object[v3] = object0;
                                arr_object[v2] = null;
                            }
                            ++v3;
                        }
                    }
                    this.a = false;
                    this.d = v3;
                }
                return this.b[v];
            }
        }
        a.c(("Expected index to be within 0..size()-1, but was " + v));
        throw null;
    }

    public final void f(long v, Object object0) {
        Object object1 = t.a;
        int v1 = a.b(this.b, this.d, v);
        if(v1 >= 0) {
            this.c[v1] = object0;
            return;
        }
        int v2 = ~v1;
        int v3 = this.d;
        if(v2 < v3) {
            Object[] arr_object = this.c;
            if(arr_object[v2] == object1) {
                this.b[v2] = v;
                arr_object[v2] = object0;
                return;
            }
        }
        if(this.a) {
            long[] arr_v = this.b;
            if(v3 >= arr_v.length) {
                Object[] arr_object1 = this.c;
                int v5 = 0;
                for(int v4 = 0; v4 < v3; ++v4) {
                    Object object2 = arr_object1[v4];
                    if(object2 != object1) {
                        if(v4 != v5) {
                            arr_v[v5] = arr_v[v4];
                            arr_object1[v5] = object2;
                            arr_object1[v4] = null;
                        }
                        ++v5;
                    }
                }
                this.a = false;
                this.d = v5;
                v2 = ~a.b(this.b, v5, v);
            }
        }
        int v6 = this.d;
        if(v6 >= this.b.length) {
            int v7 = (v6 + 1) * 8;
            for(int v8 = 4; v8 < 0x20; ++v8) {
                int v9 = (1 << v8) - 12;
                if(v7 <= v9) {
                    v7 = v9;
                    break;
                }
            }
            long[] arr_v1 = Arrays.copyOf(this.b, v7 / 8);
            q.f(arr_v1, "copyOf(...)");
            this.b = arr_v1;
            Object[] arr_object2 = Arrays.copyOf(this.c, v7 / 8);
            q.f(arr_object2, "copyOf(...)");
            this.c = arr_object2;
        }
        int v10 = this.d;
        if(v10 - v2 != 0) {
            n.V(this.b, this.b, v2 + 1, v2, v10);
            n.W(this.c, v2 + 1, this.c, v2, this.d);
        }
        this.b[v2] = v;
        this.c[v2] = object0;
        ++this.d;
    }

    public final void g(long v) {
        int v1 = a.b(this.b, this.d, v);
        if(v1 >= 0) {
            Object[] arr_object = this.c;
            Object object0 = t.a;
            if(arr_object[v1] != object0) {
                arr_object[v1] = object0;
                this.a = true;
            }
        }
    }

    public final int h() {
        if(this.a) {
            int v = this.d;
            long[] arr_v = this.b;
            Object[] arr_object = this.c;
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                Object object0 = arr_object[v1];
                if(object0 != t.a) {
                    if(v1 != v2) {
                        arr_v[v2] = arr_v[v1];
                        arr_object[v2] = object0;
                        arr_object[v1] = null;
                    }
                    ++v2;
                }
            }
            this.a = false;
            this.d = v2;
        }
        return this.d;
    }

    public final Object i(int v) {
        if(v >= 0) {
            int v1 = this.d;
            if(v < v1) {
                if(this.a) {
                    long[] arr_v = this.b;
                    Object[] arr_object = this.c;
                    int v3 = 0;
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Object object0 = arr_object[v2];
                        if(object0 != t.a) {
                            if(v2 != v3) {
                                arr_v[v3] = arr_v[v2];
                                arr_object[v3] = object0;
                                arr_object[v2] = null;
                            }
                            ++v3;
                        }
                    }
                    this.a = false;
                    this.d = v3;
                }
                return this.c[v];
            }
        }
        a.c(("Expected index to be within 0..size()-1, but was " + v));
        throw null;
    }

    @Override
    public final String toString() {
        if(this.h() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.d * 28);
        stringBuilder0.append('{');
        int v = this.d;
        for(int v1 = 0; v1 < v; ++v1) {
            if(v1 > 0) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(this.e(v1));
            stringBuilder0.append('=');
            Object object0 = this.i(v1);
            if(object0 == stringBuilder0) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
        }
        stringBuilder0.append('}');
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

