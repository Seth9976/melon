package gd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class s4 implements I4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;

    public s4(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = z;
    }

    // 去混淆评级： 中等(100)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof s4 && this.a.equals(((s4)object0).a) && this.b.equals(((s4)object0).b) && this.c.equals(((s4)object0).c) && this.d.equals(((s4)object0).d) && this.e.equals(((s4)object0).e) && this.f.equals(((s4)object0).f) && this.g.equals(((s4)object0).g) && q.b(this.h, ((s4)object0).h) && this.i == ((s4)object0).i;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
        return this.h == null ? d.e(v * 0x1F, 0x1F, this.i) + 0x4CF : d.e((v + this.h.hashCode()) * 0x1F, 0x1F, this.i) + 0x4CF;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ShowContextPopupDjPlaylist(playlistSeq=", this.a, ", playlistTitle=", this.b, ", ownerNickName=");
        d.u(stringBuilder0, this.c, ", ownerMemberKey=", this.d, ", songCnt=");
        d.u(stringBuilder0, this.e, ", fameregyn=", this.f, ", withDrawYN=");
        d.u(stringBuilder0, this.g, ", imgUrl=", this.h, ", isDeleted=");
        return o.s(stringBuilder0, this.i, ", isOpen=true)");
    }
}

