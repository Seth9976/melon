package zd;

import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.StringIds;
import com.melon.ui.X1;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import vb.a;

public final class d extends o0 {
    public final Playable a;

    public d(Playable playable0) {
        this.a = playable0;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String a() {
        q.f("", "getAlbumid(...)");
        return "";
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10002", "code(...)");
        return "N10002";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        boolean z = this.h();
        arrayList0.add(MelonBottomSheetItem.a(x.g, z, null, 0x2F));
        boolean z1 = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.h, z1, null, 0x2F));
        arrayList0.add(x.n);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 5;
    }

    // 去混淆评级： 低(40)
    @Override  // zd.o0
    public final boolean h() {
        boolean z = this.a.isMelonSong();
        boolean z1 = !this.a.isOriginMelon() || !z;
        return !this.a.isOriginMelon() && z;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(25)
    @Override  // zd.o0
    public final boolean i() {
        boolean z = this.a.isMelonSong();
        return this.a.isOriginMelon() && z && StringIds.a(this.a.getArtistid(), StringIds.e) || !this.a.isOriginMelon() && z;
    }

    @Override  // zd.o0
    public final boolean j() {
        return true;
    }

    @Override  // zd.o0
    public final boolean l() {
        return true;
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    @Override  // zd.m
    public final String p() {
        String s = this.a.getMenuid();
        q.f(s, "getMenuid(...)");
        return s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.getAlbum();
        q.f(s, "getAlbum(...)");
        return s;
    }

    @Override
    public final String toString() {
        return "AlbumPopupType(playable=" + this.a + ")";
    }

    // 去混淆评级： 中等(60)
    @Override  // zd.m
    public final k2 u() {
        q.f("", "getAlbumid(...)");
        q.f("", "getAlbum(...)");
        return new X1(new a("", "", "", l1.n("", "getIssueDate(...)", this.a, "getArtistNames(...)")));
    }

    @Override  // zd.o0
    public final Playable y() {
        return this.a;
    }
}

