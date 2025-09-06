package gd;

import A7.d;
import U4.x;
import k8.Y;
import kotlin.jvm.internal.q;

public final class u extends B {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;

    public u(String s, String s1, String s2, String s3, boolean z, String s4, String s5) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = z;
        this.f = s4;
        this.g = s5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        if(!q.b(this.a, ((u)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((u)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((u)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((u)object0).d)) {
            return false;
        }
        if(this.e != ((u)object0).e) {
            return false;
        }
        return q.b(this.f, ((u)object0).f) ? q.b(this.g, ((u)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(((((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F, this.e);
        int v2 = this.f == null ? 0 : this.f.hashCode();
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjHomeNewDjSubContentListItem(thumbUrl=", this.a, ", memberDjIconType=", this.b, ", memberNickName=");
        d.u(stringBuilder0, this.c, ", memberKey=", this.d, ", isOfficial=");
        Y.y(stringBuilder0, this.e, ", offerIntroduceText=", this.f, ", playlistCount=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

