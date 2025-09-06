package pc;

import A7.d;
import U4.x;
import android.content.Context;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class h1 extends w1 {
    public final String c;
    public final String d;
    public final StatsElementsBase e;

    public h1(String s, String s1, StatsElementsBase statsElementsBase0) {
        q.g(s, "playlistId");
        super();
        this.c = s;
        this.d = s1;
        this.e = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h1)) {
            return false;
        }
        if(!q.b(this.c, ((h1)object0).c)) {
            return false;
        }
        return q.b(this.d, ((h1)object0).d) ? q.b(this.e, ((h1)object0).e) : false;
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO().plus(this.a), new g1(this, s1, null), continuation0);
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.c.hashCode() * 0x1F, 0x1F, this.d);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        String s1 = this.c;
        if(d10 instanceof c1) {
            String s2 = ((c1)d10).b;
            String s3 = ((c1)d10).a;
            if(s3 != null && s3.length() != 0 && s2 != null && s2.length() != 0) {
                q.d(s3);
                q.f("플리 믹스업", "getString(...)");
                return new DefaultMixUpRequestInfo(s3, s2, s1, "플리 믹스업");
            }
        }
        return this.d.length() <= 0 ? new DefaultMixUpRequestInfo(s, "재생 중인 곡", s1, l1.m("재생 중인 곡", "getString(...)", context0, 0x7F130F12, "getString(...)")) : new DefaultMixUpRequestInfo(this.d, "재생 중인 플레이리스트", s1, l1.m("재생 중인 플레이리스트", "getString(...)", context0, 0x7F130F12, "getString(...)"));  // string:tiara_mixup_page_meta_type_playlist "플리 믹스업"
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Playlist(playlistId=", this.c, ", title=", this.d, ", statsElement=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

