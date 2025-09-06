package q2;

import H.o;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.F;
import androidx.datastore.preferences.protobuf.j;
import df.v;
import e.k;
import e3.h;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.p;
import je.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import l2.M;
import l2.Q;
import l2.c0;
import m2.a;
import p2.c;
import p2.i;

public final class e implements c0 {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static d a(a a0, we.a a1, int v) {
        if((v & 1) != 0) {
            a0 = null;
        }
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        q.g(coroutineScope0, "scope");
        o o0 = new o(2, a1);
        Q q0 = new Q(e.a, o0);
        if(a0 == null) {
            a0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        return new d(new d(new M(q0, k.z(new l2.e(w.a, null)), a0, coroutineScope0)));
    }

    @Override  // l2.c0
    public Object getDefaultValue() {
        return new b(true);
    }

    @Override  // l2.c0
    public Object readFrom(InputStream inputStream0, Continuation continuation0) {
        byte[] arr_b;
        f f3;
        p2.e e0;
        q.g(inputStream0, "input");
        try {
            e0 = p2.e.o(inputStream0);
        }
        catch(F f0) {
            throw new l2.b("Unable to parse preferences proto.", f0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        b b0 = new b(false);
        g[] arr_g = (g[])Arrays.copyOf(new g[0], 0);
        q.g(arr_g, "pairs");
        b0.e();
        if(arr_g.length <= 0) {
            Map map0 = e0.m();
            q.f(map0, "preferencesProto.preferencesMap");
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                i i0 = (i)((Map.Entry)object0).getValue();
                q.f(s, "name");
                q.f(i0, "value");
                int v = i0.C();
                switch((v == 0 ? -1 : q2.i.a[e0.b.b(v)])) {
                    case -1: {
                        throw new l2.b("Value case is null.", null);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                    }
                    case 1: {
                        b0.h(v.n(s), Boolean.valueOf(i0.t()));
                        continue;
                    }
                    case 2: {
                        b0.h(new f(s), i0.x());
                        continue;
                    }
                    case 3: {
                        b0.h(new f(s), i0.w());
                        continue;
                    }
                    case 4: {
                        b0.h(v.z(s), i0.y());
                        continue;
                    }
                    case 5: {
                        b0.h(v.B(s), i0.z());
                        continue;
                    }
                    case 6: {
                        f f1 = v.K(s);
                        q.f("", "value.string");
                        b0.h(f1, "");
                        continue;
                    }
                    case 7: {
                        f f2 = new f(s);
                        C c0 = i0.B().n();
                        q.f(c0, "value.stringSet.stringsList");
                        b0.h(f2, p.T0(c0));
                        continue;
                    }
                    case 8: {
                        f3 = new f(s);
                        j j0 = i0.u();
                        int v1 = j0.size();
                        if(v1 == 0) {
                            arr_b = D.b;
                        }
                        else {
                            byte[] arr_b1 = new byte[v1];
                            j0.e(v1, arr_b1);
                            arr_b = arr_b1;
                        }
                        break;
                    }
                    case 9: {
                        throw new l2.b("Value not set.", null);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                q.f(arr_b, "value.bytes.toByteArray()");
                b0.h(f3, arr_b);
            }
            return b0.d();
        }
        g g0 = arr_g[0];
        throw null;
    }

    @Override  // l2.c0
    public Object writeTo(Object object0, OutputStream outputStream0, Continuation continuation0) {
        i i0;
        Map map0 = ((q2.h)object0).a();
        c c0 = p2.e.n();
        for(Object object1: map0.entrySet()) {
            f f0 = (f)((Map.Entry)object1).getKey();
            Object object2 = ((Map.Entry)object1).getValue();
            String s = f0.a;
            if(object2 instanceof Boolean) {
                p2.h h0 = i.D();
                h0.c();
                i.q(((i)h0.b), ((Boolean)object2).booleanValue());
                i0 = (i)h0.a();
            }
            else if(object2 instanceof Float) {
                p2.h h1 = i.D();
                h1.c();
                i.r(((i)h1.b), ((Number)object2).floatValue());
                i0 = (i)h1.a();
            }
            else if(object2 instanceof Double) {
                p2.h h2 = i.D();
                h2.c();
                i.o(((i)h2.b), ((Number)object2).doubleValue());
                i0 = (i)h2.a();
            }
            else if(object2 instanceof Integer) {
                p2.h h3 = i.D();
                h3.c();
                i.s(((i)h3.b), ((Number)object2).intValue());
                i0 = (i)h3.a();
            }
            else if(object2 instanceof Long) {
                p2.h h4 = i.D();
                h4.c();
                i.l(((i)h4.b), ((Number)object2).longValue());
                i0 = (i)h4.a();
            }
            else if(object2 instanceof String) {
                p2.h h5 = i.D();
                h5.c();
                i.m(((i)h5.b), ((String)object2));
                i0 = (i)h5.a();
            }
            else if(object2 instanceof Set) {
                p2.h h6 = i.D();
                p2.f f1 = p2.g.o();
                q.e(object2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                f1.c();
                p2.g.l(((p2.g)f1.b), ((Set)object2));
                h6.c();
                i.n(((i)h6.b), ((p2.g)f1.a()));
                i0 = (i)h6.a();
            }
            else {
                if(!(object2 instanceof byte[])) {
                    throw new IllegalStateException("PreferencesSerializer does not support type: " + object2.getClass().getName());
                }
                p2.h h7 = i.D();
                androidx.datastore.preferences.protobuf.i i1 = j.d(((byte[])object2), 0, ((byte[])object2).length);
                h7.c();
                i.p(((i)h7.b), i1);
                i0 = (i)h7.a();
            }
            c0.getClass();
            s.getClass();
            c0.c();
            p2.e.l(((p2.e)c0.b)).put(s, i0);
        }
        p2.e e0 = (p2.e)c0.a();
        int v = e0.a(null);
        if(v > 0x1000) {
            v = 0x1000;
        }
        androidx.datastore.preferences.protobuf.o o0 = new androidx.datastore.preferences.protobuf.o(outputStream0, v);
        e0.k(o0);
        if(o0.m > 0) {
            o0.r0();
        }
        return H.a;
    }
}

