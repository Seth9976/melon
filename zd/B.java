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

public final class b extends o0 {
    public final Playable a;

    public b(Playable playable0) {
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
        arrayList0.add(x.c);
        String s = this.y().getArtistid();
        q.f(s, "getArtistid(...)");
        boolean z = StringIds.a(s, StringIds.e);
        arrayList0.add(MelonBottomSheetItem.a(x.h, z, null, 0x2F));
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? q.b(this.a, ((b)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 20;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.o0
    public final boolean j() {
        return true;
    }

    @Override  // zd.o0
    public final boolean l() {
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
        String s = this.a.getAlbum();
        q.f(s, "getAlbum(...)");
        return s;
    }

    @Override
    public final String toString() {
        return "AlbumDetailType(playable=" + this.a + ")";
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

