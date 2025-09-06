package gd;

import A7.d;
import U4.x;
import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class s3 implements I4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final boolean j;

    public s3(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, boolean z, boolean z1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = z;
        this.j = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s3)) {
            return false;
        }
        if(!q.b(this.a, ((s3)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((s3)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((s3)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((s3)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((s3)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((s3)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((s3)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((s3)object0).h)) {
            return false;
        }
        return this.i == ((s3)object0).i ? this.j == ((s3)object0).j : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
        return this.h == null ? Boolean.hashCode(this.j) + d.e(v * 0x1F, 0x1F, this.i) : Boolean.hashCode(this.j) + d.e((v + this.h.hashCode()) * 0x1F, 0x1F, this.i);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ShowContextPopupDjPlaylist(playlistSeq=", this.a, ", playlistTitle=", this.b, ", ownerNickName=");
        d.u(stringBuilder0, this.c, ", ownerMemberKey=", this.d, ", songCnt=");
        d.u(stringBuilder0, this.e, ", fameregyn=", this.f, ", withDrawYN=");
        d.u(stringBuilder0, this.g, ", imgUrl=", this.h, ", isDeleted=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isOpen=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

