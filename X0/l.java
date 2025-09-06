package X0;

import A7.d;
import Q0.N;
import androidx.collection.K;
import androidx.collection.i;
import androidx.collection.w;
import ie.f;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import xe.a;

public final class l implements x, Iterable, a {
    public final K a;
    public w b;
    public boolean c;
    public boolean d;

    public l() {
        this.a = new K();
    }

    public final l b() {
        l l0 = new l();
        l0.c = this.c;
        l0.d = this.d;
        K k0 = l0.a;
        k0.getClass();
        q.g(this.a, "from");
        Object[] arr_object = this.a.b;
        Object[] arr_object1 = this.a.c;
        long[] arr_v = this.a.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            k0.l(arr_object[v5], arr_object1[v5]);
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_24;
                    }
                    break;
                }
            label_24:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        return l0;
    }

    public final Object d(X0.w w0) {
        Object object0 = this.a.g(w0);
        if(object0 == null) {
            throw new IllegalStateException("Key not present: " + w0 + " - consider getOrElse or getOrNull");
        }
        return object0;
    }

    public final void e(l l0) {
        Object[] arr_object = l0.a.b;
        Object[] arr_object1 = l0.a.c;
        long[] arr_v = l0.a.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            Object object0 = arr_object[v5];
                            Object object1 = arr_object1[v5];
                            X0.w w0 = (X0.w)object0;
                            K k0 = this.a;
                            Object object2 = k0.g(w0);
                            q.e(w0, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                            Object object3 = w0.b.invoke(object2, object1);
                            if(object3 != null) {
                                k0.l(w0, object3);
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_26;
                    }
                    break;
                }
            label_26:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof l && q.b(this.a, ((l)object0).a) && this.c == ((l)object0).c && this.d == ((l)object0).d;
    }

    public final void g(X0.w w0, Object object0) {
        K k0 = this.a;
        if(object0 instanceof X0.a && k0.c(w0)) {
            Object object1 = k0.g(w0);
            q.e(object1, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            String s = ((X0.a)object0).a;
            if(s == null) {
                s = ((X0.a)object1).a;
            }
            f f0 = ((X0.a)object0).b;
            if(f0 == null) {
                f0 = ((X0.a)object1).b;
            }
            k0.l(w0, new X0.a(s, f0));
            return;
        }
        k0.l(w0, object0);
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.d) + d.e(this.a.hashCode() * 0x1F, 0x1F, this.c);
    }

    @Override
    public final Iterator iterator() {
        w w0 = this.b;
        if(w0 == null) {
            this.a.getClass();
            w w1 = new w(this.a);
            this.b = w1;
            w0 = w1;
        }
        return ((i)w0.entrySet()).iterator();
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.c) {
            stringBuilder0.append("mergeDescendants=true");
            s = ", ";
        }
        else {
            s = "";
        }
        if(this.d) {
            stringBuilder0.append(s);
            stringBuilder0.append("isClearingSemantics=true");
            s = ", ";
        }
        Object[] arr_object = this.a.b;
        Object[] arr_object1 = this.a.c;
        long[] arr_v = this.a.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            Object object0 = arr_object[v5];
                            Object object1 = arr_object1[v5];
                            stringBuilder0.append(s);
                            stringBuilder0.append(((X0.w)object0).a);
                            stringBuilder0.append(" : ");
                            stringBuilder0.append(object1);
                            s = ", ";
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_34;
                    }
                    break;
                }
            label_34:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        return N.w(this) + "{ " + stringBuilder0 + " }";
    }
}

