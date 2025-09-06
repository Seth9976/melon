package androidx.media3.exoplayer.trackselection;

import A3.c;
import E1.a;
import I6.E;
import I6.V;
import I6.n0;
import I6.p0;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.TrackSelectionParameters.Builder;
import androidx.media3.exoplayer.H;
import b3.d;
import b3.q0;
import b3.r0;
import b3.t0;
import b3.u0;
import e1.F;
import e3.b;
import e3.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import s3.g0;
import v3.h;
import v3.k;
import v3.l;
import v3.n;
import v3.q;
import v3.r;

public class DefaultTrackSelector extends r {
    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        public final DefaultTrackSelector.Parameters.Builder C;

        public ParametersBuilder(Context context0) {
            this.C = new DefaultTrackSelector.Parameters.Builder(context0);
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final void a(r0 r00) {
            this.C.A.put(r00.a, r00);
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final u0 b() {
            this.C.getClass();
            return new h(this.C);
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final TrackSelectionParameters.Builder c() {
            this.C.i();
            return this;
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final void f(Context context0) {
            this.C.k(context0);
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final TrackSelectionParameters.Builder g(int v, int v1) {
            this.C.l(v, v1);
            return this;
        }

        @Override  // androidx.media3.common.TrackSelectionParameters$Builder
        public final void h(Context context0) {
            this.C.m(context0);
        }
    }

    public final Object c;
    public final Context d;
    public final F e;
    public final boolean f;
    public h g;
    public final c h;
    public d i;
    public static final n0 j;

    static {
        DefaultTrackSelector.j = new E(new a(18));
    }

    public DefaultTrackSelector(Context context0) {
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        h h0 = new h(new DefaultTrackSelector.Parameters.Builder(context0));
        super();
        this.c = new Object();
        c c0 = null;
        this.d = context0 == null ? null : context0.getApplicationContext();
        this.e = f0;
        this.g = h0;
        this.i = d.g;
        boolean z = context0 != null && x.K(context0);
        this.f = z;
        if(!z && context0 != null) {
            AudioManager audioManager0 = (AudioManager)context0.getSystemService("audio");
            if(audioManager0 != null) {
                c0 = new c(b3.c.b(audioManager0));
            }
            this.h = c0;
        }
        if(this.g.m0 && context0 == null) {
            b.D("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    @Override  // v3.r
    public final void a(d d0) {
        synchronized(this.c) {
            boolean z = this.i.equals(d0);
            this.i = d0;
        }
        if(!z) {
            this.e();
        }
    }

    public static void b(g0 g00, h h0, HashMap hashMap0) {
        for(int v = 0; v < g00.a; ++v) {
            q0 q00 = g00.a(v);
            r0 r00 = (r0)h0.A.get(q00);
            if(r00 != null) {
                q0 q01 = r00.a;
                r0 r01 = (r0)hashMap0.get(q01.c);
                if(r01 == null || r01.b.isEmpty() && !r00.b.isEmpty()) {
                    hashMap0.put(q01.c, r00);
                }
            }
        }
    }

    public static int c(androidx.media3.common.b b0, String s, boolean z) {
        if(!TextUtils.isEmpty(s) && s.equals(b0.d)) {
            return 4;
        }
        String s1 = DefaultTrackSelector.f(s);
        String s2 = DefaultTrackSelector.f(b0.d);
        if(s2 != null && s1 != null) {
            if(!s2.startsWith(s1) && !s1.startsWith(s2)) {
                return s2.split("-", 2)[0].equals(s1.split("-", 2)[0]) ? 2 : 0;
            }
            return 3;
        }
        return !z || s2 != null ? 0 : 1;
    }

    public final h d() {
        synchronized(this.c) {
        }
        return this.g;
    }

    public final void e() {
        synchronized(this.c) {
        }
        if(this.g.m0 && !this.f && (this.h != null && this.h.a)) {
            H h0 = this.a;
            if(h0 != null) {
                h0.i.e(10);
            }
        }
    }

    // 去混淆评级： 低(20)
    public static String f(String s) {
        return TextUtils.isEmpty(s) || TextUtils.equals(s, "und") ? null : s;
    }

    public static boolean g(h h0, int v, androidx.media3.common.b b0) {
        if((v & 0xE00) == 0) {
            return false;
        }
        t0 t00 = h0.s;
        if(t00.c && (v & 0x800) == 0) {
            return false;
        }
        return t00.b ? b0.F == 0 && b0.G == 0 || (v & 0x400) != 0 : true;
    }

    public static Pair h(int v, q q0, int[][][] arr3_v, k k0, Comparator comparator0) {
        p0 p01;
        ArrayList arrayList0 = new ArrayList();
        int v1 = q0.a;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(v == q0.b[v2]) {
                g0 g00 = q0.c[v2];
                for(int v3 = 0; v3 < g00.a; ++v3) {
                    q0 q00 = g00.a(v3);
                    p0 p00 = k0.c(v2, q00, arr3_v[v2][v3]);
                    int v4 = q00.a;
                    boolean[] arr_z = new boolean[v4];
                    for(int v5 = 0; v5 < v4; ++v5) {
                        l l0 = (l)p00.get(v5);
                        int v6 = l0.a();
                        if(!arr_z[v5] && v6 != 0) {
                            if(v6 == 1) {
                                p01 = V.t(l0);
                            }
                            else {
                                ArrayList arrayList1 = new ArrayList();
                                arrayList1.add(l0);
                                for(int v7 = v5 + 1; v7 < v4; ++v7) {
                                    l l1 = (l)p00.get(v7);
                                    if(l1.a() == 2 && l0.b(l1)) {
                                        arrayList1.add(l1);
                                        arr_z[v7] = true;
                                    }
                                }
                                p01 = arrayList1;
                            }
                            arrayList0.add(p01);
                        }
                    }
                }
            }
        }
        if(arrayList0.isEmpty()) {
            return null;
        }
        List list0 = (List)Collections.max(arrayList0, comparator0);
        int[] arr_v = new int[list0.size()];
        for(int v8 = 0; v8 < list0.size(); ++v8) {
            arr_v[v8] = ((l)list0.get(v8)).c;
        }
        l l2 = (l)list0.get(0);
        return Pair.create(new n(0, l2.b, arr_v), l2.a);
    }

    public final void i(h h0) {
        h0.getClass();
        synchronized(this.c) {
            boolean z = this.g.equals(h0);
            this.g = h0;
        }
        if(!z) {
            if(h0.m0 && this.d == null) {
                b.D("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            H h1 = this.a;
            if(h1 != null) {
                h1.i.e(10);
            }
        }
    }
}

