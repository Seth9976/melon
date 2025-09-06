package com.melon.ui.popup.context.more;

import A7.d;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.melon.ui.c2;
import com.melon.ui.k2;
import e1.G;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import va.e;
import vb.t;
import zd.o0;
import zd.x;

public final class b extends o0 {
    public final PlaylistId a;
    public final Playable b;
    public final boolean c;
    public final boolean d;
    public final Object e;

    public b(PlaylistId playlistId0, Playable playable0, boolean z, boolean z1, Object object0) {
        q.g(playlistId0, "playlistId");
        q.g(playable0, "playable");
        super();
        this.a = playlistId0;
        this.b = playable0;
        this.c = z;
        this.d = z1;
        this.e = object0;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.b.getSongidString();
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
        ArrayList arrayList0 = new ArrayList();
        Playable playable0 = this.b;
        boolean z = true;
        boolean z1 = playable0.isOriginLocal() && playable0.hasLocalFile();
        if(!this.o() || z1) {
            z = false;
        }
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        AddPosition addPosition1 = MelonSettingInfo.getNormalPlayListAddPosition();
        boolean z2 = this.o();
        arrayList0.add(MelonBottomSheetItem.a(x.h0, z2, null, 0x2F));
        if(this.a == PlaylistId.DRAWER || this.a == PlaylistId.MIX_UP) {
            AddPositionInfo extraProperties$AddPositionInfo0 = new AddPositionInfo(addPosition0);
            arrayList0.add(MelonBottomSheetItem.a(x.t, false, extraProperties$AddPositionInfo0, 0x1F));
        }
        boolean z3 = this.o();
        AddPositionInfo extraProperties$AddPositionInfo1 = new AddPositionInfo(addPosition1);
        arrayList0.add(MelonBottomSheetItem.a(x.u, z3, extraProperties$AddPositionInfo1, 15));
        if(this.d) {
            AddPosition addPosition2 = MelonSettingInfo.getDjPlayListAddPosition();
            boolean z4 = this.o();
            AddPositionInfo extraProperties$AddPositionInfo2 = new AddPositionInfo(addPosition2);
            arrayList0.add(MelonBottomSheetItem.a(x.w, z4, extraProperties$AddPositionInfo2, 15));
        }
        if(this.c) {
            arrayList0.add(x.r);
        }
        arrayList0.add(MelonBottomSheetItem.a(x.b, z, null, 0x2F));
        boolean z5 = this.o();
        arrayList0.add(MelonBottomSheetItem.a(x.o, z5, null, 0x2F));
        boolean z6 = this.o();
        arrayList0.add(MelonBottomSheetItem.a(x.f, z6, null, 0x2F));
        boolean z7 = this.h();
        arrayList0.add(MelonBottomSheetItem.a(x.g, z7, null, 0x2F));
        boolean z8 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z8, null, 0x2F));
        boolean z9 = this.k();
        arrayList0.add(MelonBottomSheetItem.a(x.m, z9, null, 0x2F));
        if(z1 && this.o() && G.t(playable0)) {
            arrayList0.add(x.s);
        }
        if(this.z()) {
            arrayList0.add(x.Z);
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(this.a != ((b)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((b)object0).b)) {
            return false;
        }
        if(this.c != ((b)object0).c) {
            return false;
        }
        return this.d == ((b)object0).d ? q.b(this.e, ((b)object0).e) : false;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.Q
    public final String f() {
        q.f("N10001", "code(...)");
        return "N10001";
    }

    @Override  // zd.Q
    public final int g() {
        return 25;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c), 0x1F, this.d);
        return this.e == null ? v : v + this.e.hashCode();
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

    @Override  // zd.Q
    public final String r() {
        String s = this.b.getSongName();
        q.f(s, "getSongName(...)");
        return s;
    }

    @Override  // zd.o0
    public final Object s() {
        return this.e;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CommonPlaylistSongType(playlistId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", playable=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isDeletable=");
        U4.x.y(stringBuilder0, this.c, ", isDj=", this.d, ", thumbnail=");
        return e.d(stringBuilder0, this.e, ")");
    }

    @Override  // zd.m
    public final k2 u() {
        String s = this.a();
        String s1 = this.r();
        String s2 = this.b.getAlbumid();
        return new c2(new t(s, s1, s2, l1.n(s2, "getAlbumid(...)", this.b, "getArtistNames(...)")));
    }

    @Override  // zd.o0
    public final Playable y() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    @Override  // zd.o0
    public final boolean z() {
        return this.o() && !this.b.isAdult();
    }
}

