package com.melon.ui.popup.context.more;

import A7.d;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import zd.l;
import zd.o0;
import zd.x;

public final class j extends o0 {
    public final Playable a;
    public final Response b;
    public final String c;
    public final boolean d;

    public j(Playable playable0, Response liveDetailRes$Response0, String s, boolean z) {
        this.a = playable0;
        this.b = liveDetailRes$Response0;
        this.c = s;
        this.d = z;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String a() {
        q.f("", "getMvid(...)");
        return "";
    }

    @Override  // zd.m
    public final String b() {
        String s = this.a.getContsTypeCode().code();
        q.f(s, "code(...)");
        return s;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.C);
        arrayList0.add(MelonBottomSheetItem.a(x.y0, ((boolean)(1 ^ (this.b == null || (this.b.live == null || (this.b.live.artistList == null || !this.b.live.artistList.isEmpty())) ? 0 : 1))), null, 0x2F));
        arrayList0.add(MelonBottomSheetItem.a(x.z0, false, null, 0x2F));
        QualityInfo extraProperties$QualityInfo0 = new QualityInfo(this.c);
        arrayList0.add(MelonBottomSheetItem.a(x.x0, this.d, extraProperties$QualityInfo0, 15));
        return arrayList0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof j && this.a.equals(((j)object0).a) && q.b(this.b, ((j)object0).b) && this.c.equals(((j)object0).c) && this.d == ((j)object0).d;
    }

    @Override  // zd.Q
    public final int g() {
        return 38;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? d.e(U4.x.b(v * 961, 0x1F, this.c), 0x1F, this.d) + 0x4CF : d.e(U4.x.b((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c), 0x1F, this.d) + 0x4CF;
    }

    @Override  // zd.m
    public final boolean m() {
        return false;
    }

    // 去混淆评级： 中等(80)
    @Override  // zd.o0
    public final boolean o() {
        return false;
    }

    @Override  // zd.o0
    public final String q() {
        Response liveDetailRes$Response0 = this.b;
        if(liveDetailRes$Response0 != null) {
            Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
            if(liveDetailRes$Response$Live0 != null) {
                ArrayList arrayList0 = liveDetailRes$Response$Live0.artistList;
                if(arrayList0 != null) {
                    String s = p.q0(arrayList0, ", ", null, null, new sd.j(28), 30);
                    return s == null ? "" : s;
                }
            }
        }
        return "";
    }

    @Override  // zd.Q
    public final String r() {
        Response liveDetailRes$Response0 = this.b;
        if(liveDetailRes$Response0 != null) {
            Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
            if(liveDetailRes$Response$Live0 != null) {
                return liveDetailRes$Response$Live0.liveTitle == null ? "" : liveDetailRes$Response$Live0.liveTitle;
            }
        }
        return "";
    }

    @Override  // zd.o0
    public final Object s() {
        Response liveDetailRes$Response0 = this.b;
        if(liveDetailRes$Response0 != null) {
            Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
            if(liveDetailRes$Response$Live0 != null) {
                return liveDetailRes$Response$Live0.liveImg;
            }
        }
        return null;
    }

    @Override  // zd.m
    public final l t() {
        return l.c;
    }

    @Override
    public final String toString() {
        return "LiveType(playable=" + this.a + ", liveInfo=" + this.b + ", quality=" + this.c + ", isQualityEnabled=" + this.d + ", isLiveContent=true)";
    }

    @Override  // zd.m
    public final k2 u() {
        return null;
    }

    @Override  // zd.o0
    public final Playable y() {
        return this.a;
    }
}

