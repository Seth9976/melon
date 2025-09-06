package com.melon.ui.popup.context.more;

import A7.d;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import sd.j;
import zd.l;
import zd.o0;
import zd.x;

public final class i extends o0 {
    public final Playable a;
    public final Response b;
    public final boolean c;

    public i(Playable playable0, Response liveDetailRes$Response0, boolean z) {
        this.a = playable0;
        this.b = liveDetailRes$Response0;
        this.c = z;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.getMvid();
        q.f(s, "getMvid(...)");
        return s;
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
        ToggleInfo extraProperties$ToggleInfo0 = new ToggleInfo(this.c);
        arrayList0.add(MelonBottomSheetItem.a(x.A0, false, extraProperties$ToggleInfo0, 0x1F));
        return arrayList0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof i && this.a.equals(((i)object0).a) && q.b(this.b, ((i)object0).b) && this.c == ((i)object0).c;
    }

    @Override  // zd.Q
    public final int g() {
        return 39;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? d.e(v * 961, 0x1F, this.c) + 0x4CF : d.e((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c) + 0x4CF;
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
                    String s = p.q0(arrayList0, ", ", null, null, new j(27), 30);
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
        StringBuilder stringBuilder0 = new StringBuilder("LivePreviewType(playable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", liveInfo=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isAlarm=");
        return o.s(stringBuilder0, this.c, ", isLiveContent=true)");
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

