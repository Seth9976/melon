package zd;

import com.iloen.melon.types.StringIds;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.b2;
import com.melon.ui.k2;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import vb.h;

public final class t0 extends n0 {
    public final DjPlayListInfoBase a;

    public t0(DjPlayListInfoBase djPlayListInfoBase0) {
        q.g(djPlayListInfoBase0, "playlistInfo");
        super();
        this.a = djPlayListInfoBase0;
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
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.c);
        arrayList0.add(x.j);
        if(!StringIds.a((this.a.ownermemberkey == null ? "" : this.a.ownermemberkey), StringIds.f)) {
            arrayList0.add(x.d0);
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t0 ? q.b(this.a, ((t0)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 16;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.m
    public final boolean i() {
        return false;
    }

    @Override  // zd.m
    public final boolean j() {
        return true;
    }

    @Override  // zd.m
    public final boolean l() {
        return true;
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    @Override  // zd.m
    public final boolean n() {
        return true;
    }

    @Override  // zd.m
    public final boolean o() {
        return true;
    }

    @Override  // zd.m
    public final String p() {
        String s = this.a.menuId;
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
        return "PlaylistDetailType(playlistInfo=" + this.a + ")";
    }

    @Override  // zd.m
    public final k2 u() {
        DjPlayListInfoBase djPlayListInfoBase0 = this.a;
        String s = djPlayListInfoBase0.plylstseq;
        q.d(s);
        String s1 = djPlayListInfoBase0.plylsttitle;
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        String s3 = djPlayListInfoBase0.ownermemberkey;
        String s4 = djPlayListInfoBase0.ownernickname;
        if(s4 != null) {
            s2 = s4;
        }
        return new b2(new h(s, s1, s3, s2, djPlayListInfoBase0.dpdate));
    }

    @Override  // zd.m
    public final boolean v() {
        return true;
    }

    @Override  // zd.m
    public final boolean x() {
        return true;
    }

    @Override  // zd.n0
    public final DjPlayListInfoBase y() {
        return this.a;
    }
}

