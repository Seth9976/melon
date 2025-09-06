package pc;

import A7.d;
import U4.x;
import android.content.Context;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class l1 extends w1 {
    public final String c;
    public final String d;
    public final String e;
    public final StatsElementsBase f;

    public l1(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        if((v & 8) != 0) {
            statsElementsBase0 = null;
        }
        this(s, s1, null, statsElementsBase0);
    }

    public l1(String s, String s1, String s2, StatsElementsBase statsElementsBase0) {
        q.g(s, "songId");
        q.g(s1, "title");
        super();
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = statsElementsBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l1)) {
            return false;
        }
        if(!q.b(this.c, ((l1)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((l1)object0).d)) {
            return false;
        }
        return q.b(this.e, ((l1)object0).e) ? q.b(this.f, ((l1)object0).f) : false;
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO().plus(this.a), new k1(this, s1, null), continuation0);
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.c.hashCode() * 0x1F, 0x1F, this.d);
        int v1 = 0;
        int v2 = this.e == null ? 0 : this.e.hashCode();
        StatsElementsBase statsElementsBase0 = this.f;
        if(statsElementsBase0 != null) {
            v1 = statsElementsBase0.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        String s1 = this.c;
        if(d10 instanceof c1) {
            String s2 = ((c1)d10).b;
            String s3 = ((c1)d10).a;
            if(s3 != null && s3.length() != 0 && s2 != null && s2.length() != 0) {
                q.d(s3);
                q.f("곡 믹스업", "getString(...)");
                return new DefaultMixUpRequestInfo(s3, s2, s1, "곡 믹스업");
            }
        }
        return this.d.length() <= 0 ? new DefaultMixUpRequestInfo(s, "재생 중인 곡", s1, com.iloen.melon.custom.l1.m("재생 중인 곡", "getString(...)", context0, 0x7F130F14, "getString(...)")) : new DefaultMixUpRequestInfo(this.d, "재생 중인 곡", s1, com.iloen.melon.custom.l1.m("재생 중인 곡", "getString(...)", context0, 0x7F130F14, "getString(...)"));  // string:tiara_mixup_page_meta_type_song "곡 믹스업"
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Song(songId=", this.c, ", title=", this.d, ", artistId=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", statsElement=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

