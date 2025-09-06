package zd;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.types.StringIds;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class p0 extends o0 {
    public final Playable a;
    public final boolean b;

    public p0(Playable playable0, boolean z) {
        this.a = playable0;
        this.b = z;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.getMvid();
        q.f(s, "getMvid(...)");
        return s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10003", "code(...)");
        return "N10003";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        boolean z = this.k();
        arrayList0.add(MelonBottomSheetItem.a(x.q, z, null, 0x2F));
        boolean z1 = this.o();
        arrayList0.add(MelonBottomSheetItem.a(x.f, z1, null, 0x2F));
        boolean z2 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z2, null, 0x2F));
        boolean z3 = this.k();
        arrayList0.add(MelonBottomSheetItem.a(x.i, z3, null, 0x2F));
        if(this.b) {
            arrayList0.add(x.n);
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p0)) {
            return false;
        }
        return q.b(this.a, ((p0)object0).a) ? this.b == ((p0)object0).b : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 7;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override  // zd.o0
    public final boolean i() {
        Playable playable0 = this.a;
        boolean z = playable0.isTypeOfMv();
        int v = 0;
        boolean z1 = playable0.hasSongId();
        if(playable0.isMelonSong()) {
            if(!z) {
                v = z1;
            }
            return v == 0 ? playable0.isOriginMelon() && false && StringIds.a(playable0.getArtistid(), StringIds.e) || !playable0.isOriginMelon() && false : playable0.isOriginMelon() && StringIds.a(playable0.getArtistid(), StringIds.e) || !playable0.isOriginMelon();
        }
        return playable0.isOriginMelon() && false && StringIds.a(playable0.getArtistid(), StringIds.e) || !playable0.isOriginMelon() && false;
    }

    // 去混淆评级： 低(20)
    @Override  // zd.o0
    public final boolean k() {
        return PlayableExtensionsKt.isMvEnabled(this.a) && this.a.isService();
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    // 去混淆评级： 中等(80)
    @Override  // zd.o0
    public final boolean o() {
        return false;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.o0
    public final String q() {
        q.f("", "getArtistNames(...)");
        return "";
    }

    // 去混淆评级： 低(30)
    @Override  // zd.Q
    public final String r() {
        q.f("", "getMvname(...)");
        return "";
    }

    // 去混淆评级： 中等(110)
    @Override  // zd.o0
    public final Object s() {
        return "";
    }

    @Override  // zd.m
    public final l t() {
        return l.c;
    }

    @Override
    public final String toString() {
        return "MusicVideoType(playable=" + this.a + ", isFromLikeWith=" + this.b + ")";
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

