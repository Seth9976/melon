package zd;

import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.types.StringIds;
import com.melon.ui.c2;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import e1.G;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import vb.t;

public final class s0 extends o0 {
    public final Playable a;

    public s0(Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = playable0;
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
        Playable playable0 = this.a;
        boolean z = false;
        boolean z1 = playable0.isMelonSong() && playable0.hasSongId();
        if(playable0.isOriginLocal() && playable0.hasLocalFile()) {
            z = true;
        }
        ArrayList arrayList0 = new ArrayList();
        boolean z2 = this.o();
        arrayList0.add(MelonBottomSheetItem.a(x.f, z2, null, 0x2F));
        boolean z3 = this.h();
        arrayList0.add(MelonBottomSheetItem.a(x.g, z3, null, 0x2F));
        boolean z4 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z4, null, 0x2F));
        boolean z5 = PlayableExtensionsKt.isMvEnabled(playable0);
        arrayList0.add(MelonBottomSheetItem.a(x.m, z5, null, 0x2F));
        arrayList0.add(MelonBottomSheetItem.a(x.p, z1, null, 0x2F));
        if(z && this.o() && G.t(playable0)) {
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
        return object0 instanceof s0 ? q.b(this.a, ((s0)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 30;
    }

    // 去混淆评级： 中等(100)
    @Override  // zd.o0
    public final boolean h() {
        return this.a.isMelonSong() && this.a.hasSongId() && !this.a.isOriginMelon();
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.o0
    public final boolean i() {
        Playable playable0 = this.a;
        if(playable0.isMelonSong() && playable0.hasSongId()) {
            return playable0.isOriginMelon() ? StringIds.a(playable0.getArtistid(), StringIds.e) : true;
        }
        return false;
    }

    @Override  // zd.o0
    public final boolean k() {
        return PlayableExtensionsKt.isMvEnabled(this.a);
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
        return "PlayerType(playable=" + this.a + ")";
    }

    // 去混淆评级： 中等(60)
    @Override  // zd.m
    public final k2 u() {
        return new c2(new t(this.a(), this.r(), "", l1.n("", "getAlbumid(...)", this.a, "getArtistNames(...)")));
    }

    @Override  // zd.o0
    public final Playable y() {
        return this.a;
    }
}

