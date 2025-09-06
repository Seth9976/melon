package zd;

import com.iloen.melon.types.StringIds;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.k2;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class p extends n0 {
    public final DjPlayListInfoBase a;
    public final String b;
    public final String c;

    public p(DjPlayListInfoBase djPlayListInfoBase0, String s, String s1) {
        q.g(djPlayListInfoBase0, "playlistInfo");
        super();
        this.a = djPlayListInfoBase0;
        this.b = s;
        this.c = s1;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.plylstseq;
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10009", "code(...)");
        return "N10009";
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
        if(!(object0 instanceof p)) {
            return false;
        }
        if(!q.b(this.a, ((p)object0).a)) {
            return false;
        }
        return q.b(this.b, ((p)object0).b) ? q.b(this.c, ((p)object0).c) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 17;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v * 0x1F + v2) * 0x1F + v1;
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

    @Override  // zd.n0
    public final String q() {
        return this.b == null ? "" : this.b;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.plylsttitle;
        return s == null ? "" : s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.c;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DjPlaylistDetailType(playlistInfo=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", subTitle=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", imgUrl=");
        return U4.x.m(stringBuilder0, this.c, ")");
    }

    @Override  // zd.m
    public final k2 u() {
        return null;
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

