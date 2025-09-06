package com.iloen.melon.premium;

import A7.d;
import H0.b;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/premium/PremiumPlaylistEntity;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PremiumPlaylistEntity {
    public int a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public String g;
    public long h;

    public PremiumPlaylistEntity() {
        this.a = 0;
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = "";
        this.h = 0L;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PremiumPlaylistEntity)) {
            return false;
        }
        if(this.a != ((PremiumPlaylistEntity)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((PremiumPlaylistEntity)object0).b)) {
            return false;
        }
        if(this.c != ((PremiumPlaylistEntity)object0).c) {
            return false;
        }
        if(this.d != ((PremiumPlaylistEntity)object0).d) {
            return false;
        }
        if(this.e != ((PremiumPlaylistEntity)object0).e) {
            return false;
        }
        if(this.f != ((PremiumPlaylistEntity)object0).f) {
            return false;
        }
        return q.b(this.g, ((PremiumPlaylistEntity)object0).g) ? this.h == ((PremiumPlaylistEntity)object0).h : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.h) + x.b(d.e(d.e(d.b(this.d, d.b(this.c, x.b(this.a * 0x1F, 0x1F, this.b), 0x1F), 0x1F), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
    }

    @Override
    public final String toString() {
        int v = this.c;
        int v1 = this.d;
        boolean z = this.e;
        boolean z1 = this.f;
        String s = this.g;
        long v2 = this.h;
        StringBuilder stringBuilder0 = x.o(this.a, "PremiumPlaylistEntity(uid=", ", seq=", this.b, ", responseType=");
        x.x(stringBuilder0, v, ", playlistType=", v1, ", isDj=");
        x.y(stringBuilder0, z, ", offlineMode=", z1, ", responseMessage=");
        b.t(v2, s, ", saveDate=", stringBuilder0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

