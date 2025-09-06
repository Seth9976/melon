package com.iloen.melon.premium;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/premium/PremiumContentsEntity;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PremiumContentsEntity {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public Boolean n;

    public PremiumContentsEntity() {
        this.a = 0;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = Boolean.FALSE;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PremiumContentsEntity)) {
            return false;
        }
        if(this.a != ((PremiumContentsEntity)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((PremiumContentsEntity)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((PremiumContentsEntity)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((PremiumContentsEntity)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((PremiumContentsEntity)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((PremiumContentsEntity)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((PremiumContentsEntity)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((PremiumContentsEntity)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((PremiumContentsEntity)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((PremiumContentsEntity)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((PremiumContentsEntity)object0).k)) {
            return false;
        }
        if(!q.b(this.l, ((PremiumContentsEntity)object0).l)) {
            return false;
        }
        return q.b(this.m, ((PremiumContentsEntity)object0).m) ? q.b(this.n, ((PremiumContentsEntity)object0).n) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j);
        int v1 = 0;
        int v2 = this.k == null ? 0 : this.k.hashCode();
        int v3 = this.l == null ? 0 : this.l.hashCode();
        int v4 = this.m == null ? 0 : this.m.hashCode();
        Boolean boolean0 = this.n;
        if(boolean0 != null) {
            v1 = boolean0.hashCode();
        }
        return (((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        String s = this.c;
        String s1 = this.d;
        String s2 = this.e;
        String s3 = this.f;
        String s4 = this.g;
        String s5 = this.h;
        String s6 = this.i;
        String s7 = this.j;
        String s8 = this.k;
        String s9 = this.l;
        String s10 = this.m;
        Boolean boolean0 = this.n;
        StringBuilder stringBuilder0 = x.o(this.a, "PremiumContentsEntity(uid=", ", cId=", this.b, ", cType=");
        d.u(stringBuilder0, s, ", metaType=", s1, ", bitrate=");
        d.u(stringBuilder0, s2, ", contentType=", s3, ", secret=");
        d.u(stringBuilder0, s4, ", fileUpdate=", s5, ", fileSize=");
        d.u(stringBuilder0, s6, ", cachePath=", s7, ", thumbnailPath=");
        d.u(stringBuilder0, s8, ", imagePath=", s9, ", imageETag=");
        stringBuilder0.append(s10);
        stringBuilder0.append(", free=");
        stringBuilder0.append(boolean0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

