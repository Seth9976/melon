package com.iloen.melon.userstore.entity;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/userstore/entity/ExcludedArtistEntity;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ExcludedArtistEntity {
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;

    public ExcludedArtistEntity() {
        this.a = 0L;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = false;
        this.g = "";
        this.h = "";
        this.i = null;
        this.j = "0";
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ExcludedArtistEntity)) {
            return false;
        }
        if(this.a != ((ExcludedArtistEntity)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((ExcludedArtistEntity)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((ExcludedArtistEntity)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((ExcludedArtistEntity)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((ExcludedArtistEntity)object0).e)) {
            return false;
        }
        if(this.f != ((ExcludedArtistEntity)object0).f) {
            return false;
        }
        if(!q.b(this.g, ((ExcludedArtistEntity)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((ExcludedArtistEntity)object0).h)) {
            return false;
        }
        return q.b(this.i, ((ExcludedArtistEntity)object0).i) ? q.b(this.j, ((ExcludedArtistEntity)object0).j) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(d.e(x.b(x.b(x.b(x.b(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
        return this.i == null ? this.j.hashCode() + v * 0x1F : this.j.hashCode() + (v + this.i.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        long v = this.a;
        String s = this.b;
        String s1 = this.c;
        String s2 = this.d;
        String s3 = this.e;
        boolean z = this.f;
        String s4 = this.g;
        String s5 = this.h;
        String s6 = this.i;
        String s7 = this.j;
        StringBuilder stringBuilder0 = new StringBuilder("ExcludedArtistEntity(uid=");
        stringBuilder0.append(v);
        stringBuilder0.append(", artistId=");
        stringBuilder0.append(s);
        d.u(stringBuilder0, ", artistName=", s1, ", artistImg=", s2);
        stringBuilder0.append(", excArtistSeq=");
        stringBuilder0.append(s3);
        stringBuilder0.append(", delYn=");
        stringBuilder0.append(z);
        d.u(stringBuilder0, ", actGenre=", s4, ", updtDate=", s5);
        d.u(stringBuilder0, ", syncTime=", s6, ", memberKey=", s7);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

