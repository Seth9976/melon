package od;

import android.content.Context;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.melon.playlist.mixup.DjMalrangInfo;
import d3.g;
import d5.n;
import ie.r;
import java.time.format.DateTimeFormatter;
import m9.d;
import we.a;

public final class b {
    public final a a;
    public final r b;

    public b(a a0) {
        this.a = a0;
        this.b = g.Q(new d(26));
    }

    public final String a(Playable playable0) {
        if(this.a.invoke() != null) {
            StatsElementsBase statsElementsBase0 = StatsElementsBase.toStatsElementsBase((playable0 == null ? null : ""));
            return statsElementsBase0 == null ? null : statsElementsBase0.impressionId;
        }
        return null;
    }

    public final String b() {
        return this.a.invoke() == null ? null : "rapis";
    }

    public final String c() {
        DjMalrangInfo djMalrangInfo0 = (DjMalrangInfo)this.a.invoke();
        return djMalrangInfo0 == null ? null : n.w(djMalrangInfo0);
    }

    public final String d(Context context0, Playable playable0) {
        return this.a.invoke() == null || playable0 == null ? null : n.x(playable0, context0, ((DateTimeFormatter)this.b.getValue()));
    }
}

