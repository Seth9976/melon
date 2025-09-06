package gd;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class r2 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    public r2(String s, String s1, String s2, String s3, int v, String s4, String s5, String s6, String s7, String s8, String s9) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = v;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r2)) {
            return false;
        }
        if(!q.b(this.a, ((r2)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((r2)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((r2)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((r2)object0).d)) {
            return false;
        }
        if(this.e != ((r2)object0).e) {
            return false;
        }
        if(!q.b(this.f, ((r2)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((r2)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((r2)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((r2)object0).i)) {
            return false;
        }
        return q.b(this.j, ((r2)object0).j) ? q.b(this.k, ((r2)object0).k) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.b(this.e, ((((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F);
        int v2 = this.f == null ? 0 : this.f.hashCode();
        int v3 = this.g == null ? 0 : this.g.hashCode();
        int v4 = this.h == null ? 0 : this.h.hashCode();
        int v5 = this.i == null ? 0 : this.i.hashCode();
        int v6 = this.j == null ? 0 : this.j.hashCode();
        String s = this.k;
        if(s != null) {
            v = s.hashCode();
        }
        return (((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MelonDjBrandVideoItemUiState(mvId=", this.a, ", mvName=", this.b, ", artistName=");
        d.u(stringBuilder0, this.c, ", mvImgUrl=", this.d, ", gradeImgRes=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", playTimeText=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", contentDescription=");
        d.u(stringBuilder0, this.g, ", hintText=", this.h, ", contentsTypeCode=");
        d.u(stringBuilder0, this.i, ", linkType=", this.j, ", linkUrl=");
        return x.m(stringBuilder0, this.k, ")");
    }
}

