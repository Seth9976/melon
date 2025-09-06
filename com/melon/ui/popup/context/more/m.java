package com.melon.ui.popup.context.more;

import A7.d;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE.PROG;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import com.melon.ui.k2;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import zd.l;
import zd.o0;
import zd.x;

public final class m extends o0 {
    public final Playable a;
    public final RESPONSE b;
    public final boolean c;

    public m(Playable playable0, RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE0, boolean z) {
        this.a = playable0;
        this.b = melonTvVdoGetMvProgInfoRes$RESPONSE0;
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
        String s;
        ArrayList arrayList0 = new ArrayList();
        boolean z = this.l();
        arrayList0.add(MelonBottomSheetItem.a(x.C, z, null, 0x2F));
        boolean z1 = true;
        boolean z2 = this.a.isDownload() && !this.a.hasLocalFile();
        arrayList0.add(MelonBottomSheetItem.a(x.b, z2, null, 0x2F));
        boolean z3 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z3, null, 0x2F));
        MelonBottomSheetItem melonBottomSheetItem0 = x.z0;
        RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE0 = this.b;
        if(melonTvVdoGetMvProgInfoRes$RESPONSE0 == null) {
            s = null;
        }
        else {
            PROG melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0 = melonTvVdoGetMvProgInfoRes$RESPONSE0.prog;
            s = melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0 == null ? null : melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0.progSeq;
        }
        if(s == null || s.length() == 0) {
            z1 = false;
        }
        arrayList0.add(MelonBottomSheetItem.a(melonBottomSheetItem0, z1, null, 0x2F));
        ToggleInfo extraProperties$ToggleInfo0 = new ToggleInfo(this.c);
        arrayList0.add(MelonBottomSheetItem.a(x.s0, false, extraProperties$ToggleInfo0, 0x1F));
        return arrayList0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof m && this.a.equals(((m)object0).a) && q.b(this.b, ((m)object0).b) && this.c == ((m)object0).c;
    }

    @Override  // zd.Q
    public final int g() {
        return 37;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? d.e(v * 961, 0x1F, this.c) + 0x4D5 : d.e((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c) + 0x4D5;
    }

    // 去混淆评级： 中等(100)
    @Override  // zd.o0
    public final boolean i() {
        return false;
    }

    // 去混淆评级： 中等(100)
    @Override  // zd.o0
    public final boolean l() {
        return false;
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
        String s = this.a.getArtistNames();
        q.f(s, "getArtistNames(...)");
        return s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.getMvname();
        q.f(s, "getMvname(...)");
        return s;
    }

    @Override  // zd.o0
    public final Object s() {
        return this.a.getAlbumImg();
    }

    @Override  // zd.m
    public final l t() {
        return l.c;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("VodType(playable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", vodInfo=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isRepeat=");
        return o.s(stringBuilder0, this.c, ", isLiveContent=false)");
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

