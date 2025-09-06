package y9;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class b {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public b() {
        this.a = 0L;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "0";
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(this.a != ((b)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((b)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((b)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((b)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((b)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((b)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((b)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((b)object0).h)) {
            return false;
        }
        return q.b(this.i, ((b)object0).i) ? q.b(this.j, ((b)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        return this.j.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i);
    }

    @Override
    public final String toString() {
        long v = this.a;
        String s = this.b;
        String s1 = this.c;
        String s2 = this.d;
        String s3 = this.e;
        String s4 = this.f;
        String s5 = this.g;
        String s6 = this.h;
        String s7 = this.i;
        String s8 = this.j;
        StringBuilder stringBuilder0 = new StringBuilder("ExcludedGenreEntity(uid=");
        stringBuilder0.append(v);
        stringBuilder0.append(", gnrMenuSeq=");
        stringBuilder0.append(s);
        d.u(stringBuilder0, ", gnrCode=", s1, ", gnrName=", s2);
        d.u(stringBuilder0, ", gnrNameFull=", s3, ", gnrNameSimple=", s4);
        d.u(stringBuilder0, ", bgImgUrl=", s5, ", bgColor=", s6);
        d.u(stringBuilder0, ", fontColor=", s7, ", memberKey=", s8);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

