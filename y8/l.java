package y8;

import com.gaudiolab.sol.android.SolMusicOne.Feature;
import com.gaudiolab.sol.android.SolMusicOne.SpatialUpmixGenre;
import com.google.gson.n;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import d3.g;
import ie.r;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;

public final class l implements h {
    public static final l a;
    public static final r b;
    public static final LogU c;
    public static final AtomicBoolean d;

    static {
        l.a = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l.b = g.Q(new b(2));
        LogU logU0 = new LogU("EqualizerSettingManager");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(false);
        l.c = logU0;
        l.d = new AtomicBoolean(false);
    }

    public static y8.g b() {
        return (y8.g)l.b.getValue();
    }

    public static float[] c() {
        return (float[])f.b().c.equalizerBandGainDb.clone();
    }

    public final void d() {
        boolean z = MelonSettingInfo.isEqualizerStatusOn();
        k k0 = e1.b.F();
        int v = k0.c;
        LogU.debug$default(l.c, "initialize() eqStatusOn:" + z + ", state:" + k0, null, false, 6, null);
        if(z && !l.d.get()) {
            int v1 = k0.b;
            switch(v1) {
                case 5: {
                    l.j(k0);
                    h.a(this, 6, v, 4);
                    break;
                }
                case 6: {
                    l.j(k0);
                    return;
                }
                case 7: {
                    Object object0 = null;
                    for(Object object1: p.S) {
                        if(((p)object1).a == v) {
                            object0 = object1;
                            break;
                        }
                    }
                    p p0 = (p)object0;
                    if(p0 == null) {
                        p0 = p.b;
                    }
                    p p1 = p.b;
                    if(p0 != p1) {
                        l.k(p0);
                        return;
                    }
                    l.k(p1);
                    f.h(f.b().g);
                    h.a(this, 11, 0, 6);
                    return;
                }
                case 11: {
                    l.k(p.b);
                    f.h(f.b().g);
                    return;
                }
                default: {
                    if(v1 != 12) {
                        l.k(p.b);
                        f.h(f.b().g);
                        h.a(this, 11, 0, 6);
                        return;
                    }
                    l.k(p.b);
                    f.h(SpatialUpmixGenre.k3D);
                }
            }
        }
    }

    public static boolean e() {
        return l.b().c.upmixGenre == f.b().g;
    }

    public final void f(int v, int v1, String s) {
        int v2 = MelonSettingInfo.isEqualizerStatusOn() ? 2 : 0;
        if(s == null || s.length() == 0) {
            s = e1.b.A(v, v1);
        }
        k k0 = new k(v2, v, v1, s, l.c());
        MelonPrefs.getInstance().setString("g_eq_status", new n().k(k0));
    }

    public static void g(boolean z) {
        if(z) {
            q.g(Feature.kEqualizer, "features");
            f.f(Feature.kEqualizer);
            return;
        }
        q.g(Feature.kEqualizer, "features");
        f.e(Feature.kEqualizer);
    }

    public final void h(boolean z) {
        MelonSettingInfo.setEqualizerStatusOn(z);
        if(z) {
            this.d();
        }
        else {
            l.g(false);
            q.g(Feature.kSpatialUpmix, "features");
            f.e(Feature.kSpatialUpmix);
            f.h(SpatialUpmixGenre.kOff);
        }
        f.i();
    }

    public static void i(i i0) {
        q.g(i0, "eq");
        l.k(p.c);
        f.f(Feature.kEqualizer);
        y8.g g0 = f.b();
        g0.c.equalizerBandGainDb = (float[])i0.c().clone();
    }

    public static void j(k k0) {
        l.k(p.c);
        f.f(Feature.kEqualizer);
        y8.g g0 = f.b();
        g0.c.equalizerBandGainDb = (float[])k0.e.clone();
    }

    public static void k(p p0) {
        q.g(p0, "type");
        y8.g g0 = l.b();
        g0.getClass();
        g0.f = p0;
        y8.q.b(g0.c, p0);
    }
}

