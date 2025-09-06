package zd;

import A7.d;
import com.iloen.melon.net.v5x.response.CastInfoBase.Creator;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.iloen.melon.net.v5x.response.CreatorInfoBase.ContsList;
import com.iloen.melon.types.StringIds;
import com.melon.ui.a2;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;

public final class j extends m {
    public final CastInfoBase a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;

    public j(CastInfoBase castInfoBase0, String s, boolean z, boolean z1, String s1) {
        q.g(castInfoBase0, "castInfo");
        q.g(s, "menuId");
        super();
        this.a = castInfoBase0;
        this.b = s;
        this.c = z;
        this.d = z1;
        this.e = s1;
    }

    @Override  // zd.m
    public final String a() {
        String s = this.a.castSeq;
        q.f(s, "castSeq");
        return s;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10082", "code(...)");
        return "N10082";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(MelonBottomSheetItem.a(x.c, this.d, null, 0x2F));
        arrayList0.add(x.g0);
        boolean z = this.i();
        arrayList0.add(MelonBottomSheetItem.a(x.o0, z, null, 0x2F));
        arrayList0.add((this.c ? x.e0 : x.f0));
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        if(!q.b(this.a, ((j)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((j)object0).b)) {
            return false;
        }
        if(this.c != ((j)object0).c) {
            return false;
        }
        return this.d == ((j)object0).d ? q.b(this.e, ((j)object0).e) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 22;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + d.e(d.e(U4.x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override  // zd.m
    public final boolean i() {
        Creator castInfoBase$Creator0 = this.a.creator;
        if(castInfoBase$Creator0 != null) {
            ArrayList arrayList0 = castInfoBase$Creator0.contsList;
            q.f(arrayList0, "contsList");
            ContsList creatorInfoBase$ContsList0 = (ContsList)p.m0(arrayList0);
            String s = creatorInfoBase$ContsList0 == null ? null : creatorInfoBase$ContsList0.id;
            return !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.d);
        }
        return false;
    }

    @Override  // zd.m
    public final boolean j() {
        return true;
    }

    @Override  // zd.m
    public final boolean m() {
        return true;
    }

    @Override  // zd.m
    public final String p() {
        return this.b;
    }

    @Override  // zd.m
    public final String q() {
        return this.e;
    }

    @Override  // zd.Q
    public final String r() {
        String s = this.a.castTitle;
        q.f(s, "castTitle");
        return s;
    }

    @Override  // zd.m
    public final Object s() {
        return this.a.verticalImgUrl;
    }

    @Override  // zd.m
    public final l t() {
        return l.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CastEpisodeDetailType(castInfo=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", menuId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isSubscription=");
        U4.x.y(stringBuilder0, this.c, ", hasSongContents=", this.d, ", subTitle=");
        return U4.x.m(stringBuilder0, this.e, ")");
    }

    @Override  // zd.m
    public final k2 u() {
        return a2.a;
    }

    @Override  // zd.m
    public final boolean v() {
        return true;
    }

    @Override  // zd.m
    public final boolean w() {
        return this.d;
    }

    @Override  // zd.m
    public final boolean x() {
        return true;
    }
}

