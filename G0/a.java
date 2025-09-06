package g0;

import androidx.collection.G;
import androidx.collection.K;
import androidx.collection.P;
import java.util.NoSuchElementException;
import je.n;
import kotlin.jvm.internal.q;

public final class a {
    public final K a;

    public a(K k0) {
        this.a = k0;
    }

    public static final Object a(K k0) {
        Object object0 = k0.g(null);
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof G) {
            if(((G)object0).g()) {
                throw new NoSuchElementException("List is empty.");
            }
            int v = ((G)object0).b - 1;
            Object object1 = ((G)object0).e(v);
            ((G)object0).i(v);
            q.e(object1, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
            if(((G)object0).g()) {
                k0.j(null);
            }
            if(((G)object0).b == 1) {
                k0.l(null, ((G)object0).d());
            }
            return object1;
        }
        k0.j(null);
        return object0;
    }

    public static final G b(K k0) {
        if(k0.i()) {
            q.e(P.b, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
            return P.b;
        }
        G g0 = new G();
        Object[] arr_object = k0.c;
        long[] arr_v = k0.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            Object object0 = arr_object[(v1 << 3) + v4];
                            if(object0 instanceof G) {
                                q.e(object0, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>");
                                q.g(((G)object0), "elements");
                                if(!((G)object0).g()) {
                                    int v5 = g0.b + ((G)object0).b;
                                    Object[] arr_object1 = g0.a;
                                    if(arr_object1.length < v5) {
                                        g0.k(v5, arr_object1);
                                    }
                                    n.W(((G)object0).a, g0.b, g0.a, 0, ((G)object0).b);
                                    g0.b += ((G)object0).b;
                                }
                            }
                            else {
                                q.e(object0, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                                g0.a(object0);
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_33;
                    }
                    break;
                }
            label_33:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        return g0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a && q.b(this.a, ((a)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "MultiValueMap(map=" + this.a + ')';
    }
}

