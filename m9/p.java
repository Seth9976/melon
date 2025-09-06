package m9;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import e1.m;
import ie.H;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import je.C;
import k8.Y;
import kotlin.jvm.internal.q;
import od.a;
import q8.i;
import we.k;

public final class p implements k {
    public final int a;
    public final MixUpPlaylistViewImpLogHelper b;
    public final Playable c;
    public final long d;
    public final a e;
    public final String f;

    public p(MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0, Playable playable0, long v, a a0, String s, int v1) {
        this.a = v1;
        this.b = mixUpPlaylistViewImpLogHelper0;
        this.c = playable0;
        this.d = v;
        this.e = a0;
        this.f = s;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        String s = this.f;
        a a0 = this.e;
        long v = this.d;
        Playable playable0 = this.c;
        MixUpPlaylistViewImpLogHelper mixUpPlaylistViewImpLogHelper0 = this.b;
        i i0 = (i)object0;
        if(this.a != 0) {
            q.g(i0, "$this$viewImpContentBuilder");
            i0.a = (String)mixUpPlaylistViewImpLogHelper0.c.invoke(playable0);
            i0.h = (String)mixUpPlaylistViewImpLogHelper0.d.invoke(playable0);
            i0.f = "vimp";
            i0.g = m.G(a0);
            i0.d = s;
            i0.i = (String)new m9.q(mixUpPlaylistViewImpLogHelper0, 1).invoke();
            i0.b = "";
            i0.c = Y.i(ContsTypeCode.SONG, "code(...)");
            i0.e = "";
            ie.m[] arr_m = {new ie.m("recmd_offer_timestamp", mixUpPlaylistViewImpLogHelper0.f.invoke(playable0)), new ie.m("vimp_time", ((DateTimeFormatter)mixUpPlaylistViewImpLogHelper0.i.getValue()).format(Instant.ofEpochMilli(v))), new ie.m("recmd_key", mixUpPlaylistViewImpLogHelper0.e.invoke())};
            C.V(i0.k, arr_m);
            return h0;
        }
        q.g(i0, "$this$viewImpContentBuilder");
        i0.a = (String)mixUpPlaylistViewImpLogHelper0.c.invoke(playable0);
        i0.h = (String)mixUpPlaylistViewImpLogHelper0.d.invoke(playable0);
        i0.f = "vimp";
        i0.g = m.G(a0);
        i0.d = s;
        i0.i = (String)new m9.q(mixUpPlaylistViewImpLogHelper0, 0).invoke();
        i0.b = "";
        i0.c = Y.i(ContsTypeCode.SONG, "code(...)");
        i0.e = "";
        ie.m[] arr_m1 = {new ie.m("recmd_offer_timestamp", mixUpPlaylistViewImpLogHelper0.f.invoke(playable0)), new ie.m("vimp_time", ((DateTimeFormatter)mixUpPlaylistViewImpLogHelper0.i.getValue()).format(Instant.ofEpochMilli(v))), new ie.m("recmd_key", mixUpPlaylistViewImpLogHelper0.e.invoke())};
        C.V(i0.k, arr_m1);
        return h0;
    }
}

