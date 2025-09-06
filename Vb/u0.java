package Vb;

import M8.f;
import Nb.v0;
import Nb.z0;
import U4.F;
import Ub.s;
import Ub.t;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import b3.E;
import com.google.android.gms.cast.framework.CastContext;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.playback.manager.DlnaHelper;
import hc.m;
import hc.n;
import hc.o;
import ie.p;
import java.util.List;
import je.w;
import kc.i;
import kotlin.jvm.internal.q;
import va.e;

public final class u0 {
    public Context a;
    public i b;
    public s c;
    public final LogU d;

    public u0() {
        this.d = Companion.create$default(LogU.Companion, "MelonRemotePlayerProvider", false, Category.Playback, 2, null);
    }

    public static boolean a(E e0) {
        q.g(e0, "mediaItem");
        Bundle bundle0 = e0.d.I;
        return !(bundle0 == null ? false : bundle0.getBoolean("targetMusicwave")) && q0.a(F.E(e0)).equals(Uri.EMPTY);
    }

    public final Context b() {
        Context context0 = this.a;
        if(context0 != null) {
            return context0;
        }
        q.m("context");
        throw null;
    }

    public final o c(z0 z00) {
        n n0;
        try {
            if(z00 instanceof v0) {
                L8.s s0 = ((t)this.d()).c.i;
                q.d(s0);
                n0 = new n(s0);
            }
            else {
                if(!(z00 instanceof Nb.u0)) {
                    throw new IllegalArgumentException("Not supported playerType: " + z00);
                }
                CastContext castContext0 = CastContext.getSharedInstance(this.b());
                q.f(castContext0, "getSharedInstance(...)");
                n0 = new m(castContext0);
            }
        }
        catch(Throwable throwable0) {
            n0 = d5.n.t(throwable0);
        }
        Throwable throwable1 = p.a(n0);
        if(throwable1 != null) {
            throw new IllegalStateException(e.b("Failed to get Resource: ", throwable1.getMessage()), throwable1);
        }
        d5.n.D(n0);
        return n0;
    }

    public final s d() {
        s s0 = this.c;
        if(s0 != null) {
            return s0;
        }
        q.m("remotePlayerManager");
        throw null;
    }

    public final boolean e() {
        DlnaHelper dlnaHelper0 = ((t)this.d()).c;
        L8.s s0 = dlnaHelper0.i;
        List list0 = s0 == null ? w.a : s0.b;
        boolean z = false;
        for(Object object0: list0) {
            f f0 = (f)object0;
            try {
                if(!f0.a("audio/aac") && !f0.a("audio/mp4")) {
                    continue;
                }
            }
            catch(Exception exception0) {
                LogU.error$default(dlnaHelper0.b, e.b("isSupportedAac() error : ", exception0.getMessage()), null, false, 6, null);
                return false;
            }
            z = true;
        }
        return z;
    }
}

