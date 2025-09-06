package zd;

import A7.d;
import com.iloen.melon.types.StringIds;
import com.melon.ui.Y1;
import com.melon.ui.k2;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;

public final class q extends m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;

    public q(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, boolean z, boolean z1) {
        kotlin.jvm.internal.q.g(s, "playlistSeq");
        kotlin.jvm.internal.q.g(s1, "playlistTitle");
        kotlin.jvm.internal.q.g(s2, "ownerNickName");
        kotlin.jvm.internal.q.g(s3, "ownerMemberKey");
        kotlin.jvm.internal.q.g(s4, "songCnt");
        kotlin.jvm.internal.q.g(s5, "fameregyn");
        kotlin.jvm.internal.q.g(s6, "menuId");
        kotlin.jvm.internal.q.g(s7, "withDrawYN");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = s8;
        this.j = s9;
        this.k = z;
        this.l = z1;
    }

    @Override  // zd.m
    public final String a() {
        return this.a;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        kotlin.jvm.internal.q.f("N10009", "code(...)");
        return "N10009";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        boolean z = this.k;
        arrayList0.add(MelonBottomSheetItem.a(x.k, !z, null, 0x2F));
        String s = this.d;
        if(!this.j.equals(s)) {
            arrayList0.add(x.T);
        }
        if(StringIds.a(s, StringIds.h)) {
            arrayList0.add(MelonBottomSheetItem.a(x.b0, !z, null, 0x2F));
            boolean z1 = !"Y".equals(this.f) && !z;
            arrayList0.add(MelonBottomSheetItem.a(x.c0, z1, null, 0x2F));
        }
        arrayList0.add(x.n);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.a, ((q)object0).a)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.b, ((q)object0).b)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.c, ((q)object0).c)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.d, ((q)object0).d)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.e, ((q)object0).e)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.f, ((q)object0).f)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.g, ((q)object0).g)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.h, ((q)object0).h)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.i, ((q)object0).i)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.j, ((q)object0).j)) {
            return false;
        }
        return this.k == ((q)object0).k ? this.l == ((q)object0).l : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 10;
    }

    @Override
    public final int hashCode() {
        int v = U4.x.b(U4.x.b(U4.x.b(U4.x.b(U4.x.b(U4.x.b(U4.x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
        return this.i == null ? Boolean.hashCode(this.l) + d.e(U4.x.b(v * 0x1F, 0x1F, this.j), 0x1F, this.k) : Boolean.hashCode(this.l) + d.e(U4.x.b((v + this.i.hashCode()) * 0x1F, 0x1F, this.j), 0x1F, this.k);
    }

    @Override  // zd.m
    public final boolean i() {
        return false;
    }

    @Override  // zd.m
    public final boolean j() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // zd.m
    public final boolean l() {
        return !this.k && this.l;
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
        return this.g;
    }

    @Override  // zd.m
    public final String q() {
        return this.c;
    }

    @Override  // zd.Q
    public final String r() {
        return this.b;
    }

    @Override  // zd.m
    public final Object s() {
        return this.i;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjPlaylistType(playlistSeq=", this.a, ", playlistTitle=", this.b, ", ownerNickName=");
        d.u(stringBuilder0, this.c, ", ownerMemberKey=", this.d, ", songCnt=");
        d.u(stringBuilder0, this.e, ", fameregyn=", this.f, ", menuId=");
        d.u(stringBuilder0, this.g, ", withDrawYN=", this.h, ", imgUrl=");
        d.u(stringBuilder0, this.i, ", loginMemberKey=", this.j, ", isDeleted=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", isOpen=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // zd.m
    public final k2 u() {
        return new Y1(new vb.d(this.a, this.b, this.c, this.d, this.e));
    }
}

