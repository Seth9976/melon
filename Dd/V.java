package dd;

import I6.p0;
import Ud.j;
import Vb.o0;
import X5.g;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.common.d;
import b3.G;
import b3.L;
import b3.N;
import b3.h0;
import b3.i0;
import b3.k;
import b3.l;
import b3.u0;
import b3.z0;
import com.iloen.melon.utils.Navigator;
import d3.c;
import e3.q;
import ed.N0;
import ie.H;
import java.util.Arrays;
import je.p;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.JsonElementSerializer;
import r8.f;
import we.a;

public final class v implements a {
    public final int a;

    public v(int v) {
        this.a = v;
        super();
    }

    public v(o0 o00) {
        this.a = 15;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return "";
            }
            case 1: {
                return "";
            }
            case 2: {
                Navigator.openLoginView(f.f);
                return H.a;
            }
            case 3: {
                return "";
            }
            case 4: {
                return "1000003099";
            }
            case 5: {
                return "";
            }
            case 6: {
                return "";
            }
            case 7: {
                return 2;
            }
            case 8: {
                return new j();
            }
            case 9: {
                return new N0();
            }
            case 10: {
                return JsonElementSerializer.b();
            }
            case 11: {
                return JsonElementSerializer.c();
            }
            case 12: {
                return JsonElementSerializer.d();
            }
            case 13: {
                return JsonElementSerializer.e();
            }
            case 14: {
                return JsonElementSerializer.f();
            }
            case 15: {
                d d0 = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
                d0.a = N.b;
                d0.b = false;
                d0.c = 1;
                d0.d = 1;
                d0.e = null;
                d0.f = 0;
                d0.g = 5000L;
                d0.h = 15000L;
                d0.i = 3000L;
                d0.j = L.d;
                d0.k = u0.C;
                d0.l = b3.d.g;
                d0.m = 1.0f;
                d0.n = z0.d;
                d0.o = c.c;
                d0.p = k.e;
                d0.q = 0;
                d0.r = q.c;
                d0.s = new Metadata(0x8000000000000001L, new Entry[0]);
                d0.t = p0.e;
                d0.u = b3.p0.a;
                d0.v = null;
                d0.w = null;
                d0.x = G.K;
                d0.y = -1;
                d0.z = -1;
                d0.A = -1;
                d0.B = null;
                d0.C = new g(0x8000000000000001L);
                d0.D = h0.F;
                d0.E = new g(0x8000000000000001L);
                d0.F = h0.F;
                d0.G = h0.F;
                d0.H = 5;
                l l0 = new l(0);
                int[] arr_v = p.O0(Nb.a.a);
                l0.e(Arrays.copyOf(arr_v, arr_v.length));
                int[] arr_v1 = p.O0(Nb.a.b);
                l0.e(Arrays.copyOf(arr_v1, arr_v1.length));
                int[] arr_v2 = p.O0(Nb.a.c);
                l0.e(Arrays.copyOf(arr_v2, arr_v2.length));
                int[] arr_v3 = p.O0(Nb.a.d);
                l0.e(Arrays.copyOf(arr_v3, arr_v3.length));
                int[] arr_v4 = p.O0(Nb.a.e);
                l0.e(Arrays.copyOf(arr_v4, arr_v4.length));
                d0.a = new N(l0.f());
                androidx.media3.common.c c0 = new androidx.media3.common.c();
                c0.a = "";
                c0.e = "";
                d0.x = new G(c0);
                d0.i = 3000L;
                d0.g = 10000L;
                d0.h = 10000L;
                d d1 = new i0(d0).a();
                d1.f = 2;
                return StateFlowKt.MutableStateFlow(new i0(d1));
            }
            case 16: {
                Looper looper0 = Looper.myLooper();
                if(looper0 == null) {
                    looper0 = Looper.getMainLooper();
                }
                return new Handler(looper0);
            }
            case 17: {
                return new j();
            }
            case 18: {
                return new j();
            }
            case 19: {
                return new j();
            }
            case 20: {
                return new j();
            }
            case 21: {
                return new j();
            }
            case 22: {
                return new j();
            }
            case 23: {
                return new j();
            }
            case 24: {
                return new j();
            }
            case 25: {
                return new j();
            }
            case 26: {
                return new j();
            }
            case 27: {
                return new j();
            }
            case 28: {
                return new j();
            }
            default: {
                return new j();
            }
        }
    }
}

