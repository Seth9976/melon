package zd;

import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.types.StringIds;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class u0 extends n0 {
    public final DjPlayListInfoBase a;
    public final String b;

    public u0(ArtistPlayListInfoBase artistPlayListInfoBase0, String s) {
        q.g(artistPlayListInfoBase0, "playlistInfo");
        q.g(s, "openYn");
        super();
        this.a = artistPlayListInfoBase0;
        this.b = s;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.plylstseq;
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10005", "code(...)");
        return "N10005";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        DjPlayListInfoBase djPlayListInfoBase0 = this.a;
        boolean z = q.b(djPlayListInfoBase0.delYn, "Y");
        ArrayList arrayList0 = new ArrayList();
        if(StringIds.a((djPlayListInfoBase0.ownermemberkey == null ? "" : djPlayListInfoBase0.ownermemberkey), StringIds.h)) {
            if(z) {
                arrayList0.add(MelonBottomSheetItem.a(x.b0, false, null, 0x2F));
                arrayList0.add(MelonBottomSheetItem.a(x.c0, false, null, 0x2F));
            }
            else {
                arrayList0.add(x.b0);
                boolean z1 = q.b(djPlayListInfoBase0.fameregyn, "Y");
                arrayList0.add(MelonBottomSheetItem.a(x.c0, !z1, null, 0x2F));
            }
            arrayList0.add(x.n);
            return arrayList0;
        }
        arrayList0.add(x.T);
        arrayList0.add(x.n);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u0)) {
            return false;
        }
        return q.b(this.a, ((u0)object0).a) ? q.b(this.b, ((u0)object0).b) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 11;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override  // zd.m
    public final boolean j() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // zd.m
    public final boolean l() {
        return !"Y".equals(this.a.delYn) && !"N".equals(this.b);
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    @Override  // zd.m
    public final boolean n() {
        return true;
    }

    @Override  // zd.n0
    public final String q() {
        String s = this.a.ownernickname;
        return s == null ? "" : s;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.plylsttitle;
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.a.thumbimg;
    }

    @Override
    public final String toString() {
        return "PlaylistPopupType(playlistInfo=" + this.a + ", openYn=" + this.b + ")";
    }

    @Override  // zd.n0
    public final DjPlayListInfoBase y() {
        return this.a;
    }
}

