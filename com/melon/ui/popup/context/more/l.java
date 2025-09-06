package com.melon.ui.popup.context.more;

import A7.d;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.melon.ui.c2;
import com.melon.ui.k2;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import vb.t;
import zd.o0;
import zd.x;

public final class l extends o0 {
    public final Playable a;
    public final boolean b;
    public final Link c;

    public l(Playable playable0, boolean z, Link extraProperties$Link0) {
        this.a = playable0;
        this.b = z;
        this.c = extraProperties$Link0;
    }

    @Override  // zd.o0
    public final boolean A() {
        return false;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.getSongidString();
        q.f(s, "getSongidString(...)");
        return s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10001", "code(...)");
        return "N10001";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        boolean z = this.a.isService();
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        AddPosition addPosition1 = MelonSettingInfo.getNormalPlayListAddPosition();
        ArrayList arrayList0 = new ArrayList();
        AddPositionInfo extraProperties$AddPositionInfo0 = new AddPositionInfo(addPosition0);
        arrayList0.add(MelonBottomSheetItem.a(x.t, z, extraProperties$AddPositionInfo0, 15));
        AddPositionInfo extraProperties$AddPositionInfo1 = new AddPositionInfo(addPosition1);
        arrayList0.add(MelonBottomSheetItem.a(x.u, z, extraProperties$AddPositionInfo1, 15));
        if(this.b) {
            AddPositionInfo extraProperties$AddPositionInfo2 = new AddPositionInfo(MelonSettingInfo.getDjPlayListAddPosition());
            arrayList0.add(MelonBottomSheetItem.a(x.w, z, extraProperties$AddPositionInfo2, 15));
        }
        arrayList0.add(MelonBottomSheetItem.a(x.a0, z, null, 0x2F));
        arrayList0.add(MelonBottomSheetItem.a(x.U, z, null, 0x2F));
        boolean z1 = this.h();
        arrayList0.add(MelonBottomSheetItem.a(x.g, z1, null, 0x2F));
        boolean z2 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z2, null, 0x2F));
        if(this.z()) {
            arrayList0.add(x.Z);
        }
        Link extraProperties$Link0 = this.c;
        if(extraProperties$Link0 != null) {
            arrayList0.add(MelonBottomSheetItem.a(x.B, false, extraProperties$Link0, 0x1F));
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        if(!q.b(this.a, ((l)object0).a)) {
            return false;
        }
        return this.b == ((l)object0).b ? q.b(this.c, ((l)object0).c) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 13;
    }

    @Override
    public final int hashCode() {
        int v = d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String p() {
        q.f("", "getMenuid(...)");
        return "";
    }

    // 去混淆评级： 低(30)
    @Override  // zd.Q
    public final String r() {
        q.f("", "getSongName(...)");
        return "";
    }

    @Override
    public final String toString() {
        return "SongMoreType(playable=" + this.a + ", isDj=" + this.b + ", tiktokInfo=" + this.c + ")";
    }

    @Override  // zd.m
    public final k2 u() {
        String s = this.a();
        String s1 = this.r();
        String s2 = this.a.getAlbumid();
        return new c2(new t(s, s1, s2, l1.n(s2, "getAlbumid(...)", this.a, "getArtistNames(...)")));
    }

    @Override  // zd.o0
    public final Playable y() {
        return this.a;
    }
}

