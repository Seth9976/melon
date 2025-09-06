package k9;

import Bd.m;
import E9.w;
import M6.B;
import M6.s;
import M6.u;
import android.content.Context;
import androidx.room.H;
import com.google.gson.n;
import com.google.gson.x;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.premium.PremiumPlaylistEntity;
import com.iloen.melon.utils.MelonSettingInfo;
import i.n.i.b.a.s.e.Ga;
import java.util.List;
import k8.o;
import kc.L2;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ld.j;
import m9.l;
import o9.b;

public abstract class h {
    public static final n a;

    static {
        h.a = new n();
    }

    public static String a(g g0, String[] arr_s) {
        if(g.i != g0 && g.j != g0) {
            if(g.g == g0) {
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = 0; v < arr_s.length; ++v) {
                    stringBuilder0.append(arr_s[v]);
                }
                return stringBuilder0.toString();
            }
            String s = arr_s[0];
            return s == null ? "" : s;
        }
        return "";
    }

    // 去混淆评级： 中等(120)
    public static boolean b(PlaylistId playlistId0, g g0, String[] arr_s) {
        return false;
    }

    // 去混淆评级： 中等(120)
    public static boolean c(PlaylistId playlistId0, String[] arr_s) {
        return false;
    }

    public static boolean d(DrawerPlaylistInfo drawerPlaylistInfo0) {
        if(drawerPlaylistInfo0 == null) {
            return false;
        }
        g g0 = drawerPlaylistInfo0.getResponseType();
        PremiumPlaylistEntity premiumPlaylistEntity0 = h.i(g0, h.a(g0, new String[]{drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()}));
        return premiumPlaylistEntity0 == null ? false : premiumPlaylistEntity0.f;
    }

    public static Object e(g g0, Class class0, String s) {
        PremiumPlaylistEntity premiumPlaylistEntity0 = h.i(g0, s);
        if(premiumPlaylistEntity0 != null) {
            String s1 = premiumPlaylistEntity0.g;
            if(s1 != null) {
                try {
                    return h.a.e(s1, class0);
                }
                catch(x unused_ex) {
                }
            }
        }
        return null;
    }

    public static Object f(g g0, Class class0, String[] arr_s) {
        return h.e(g0, class0, h.a(g0, arr_s));
    }

    public static void g(g g0, HttpResponse httpResponse0, int v, String s) {
        if(httpResponse0 == null) {
            return;
        }
        PremiumPlaylistEntity premiumPlaylistEntity0 = h.i(g0, s);
        Ga ga0 = i.a;
        n n0 = h.a;
        if(premiumPlaylistEntity0 != null) {
            String s1 = n0.k(httpResponse0);
            q.g(s1, "<set-?>");
            premiumPlaylistEntity0.g = s1;
            b b0 = ga0.i();
            b0.getClass();
            w.N(((H)b0.a), false, true, new l(2, b0, premiumPlaylistEntity0));
            return;
        }
        String s2 = n0.k(httpResponse0);
        PremiumPlaylistEntity premiumPlaylistEntity1 = new PremiumPlaylistEntity();
        q.g(s, "<set-?>");
        premiumPlaylistEntity1.b = s;
        premiumPlaylistEntity1.c = g0.ordinal();
        premiumPlaylistEntity1.d = v;
        premiumPlaylistEntity1.f = false;
        q.g(s2, "<set-?>");
        premiumPlaylistEntity1.g = s2;
        premiumPlaylistEntity1.h = System.currentTimeMillis();
        b b1 = ga0.i();
        b1.getClass();
        w.N(((H)b1.a), false, true, new l(2, b1, premiumPlaylistEntity1));
    }

    public static void h(g g0, ResponseV6Res responseV6Res0, int v, String[] arr_s) {
        h.g(g0, responseV6Res0, v, h.a(g0, arr_s));
    }

    public static PremiumPlaylistEntity i(g g0, String s) {
        Ga ga0 = i.a;
        if(g0 != g.a && g0 != g.c && g0 != g.d && g0 != g.e && g0 != g.f) {
            return g0 == g.b || g0 == g.g || g0 == g.h || g0 == g.i || g0 == g.j || g0 == g.k || g0 == g.l ? ((PremiumPlaylistEntity)w.N(((H)ga0.i().a), true, false, new Ld.w(g0.ordinal(), s, 6))) : null;
        }
        return (PremiumPlaylistEntity)w.N(((H)ga0.i().a), true, false, new m(g0.ordinal(), 9));
    }

    public static void j() {
        MelonSettingInfo.setOfflineModeNP(false);
        MelonSettingInfo.setOfflineModeSP(false);
        Ga ga0 = i.a;
        List list0 = (List)w.N(((H)ga0.i().a), true, false, new j(7));
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                ((PremiumPlaylistEntity)object0).f = false;
                b b0 = ga0.i();
                b0.getClass();
                w.N(((H)b0.a), false, true, new l(2, b0, ((PremiumPlaylistEntity)object0)));
            }
        }
        Context context0 = MelonAppBase.instance.getContext();
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        d3 d30 = (d3)(((s2)((o)(((Ma.m)com.google.firebase.b.B(context1, Ma.m.class)))).w.get()));
        L2 l20 = new L2(d30, null);
        B b1 = ListenableFutureKt.future$default(d30.b, null, null, l20, 3, null);
        b1.addListener(new u(0, b1, new Ga(d30, 27)), s.a);
    }
}

