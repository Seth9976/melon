package gd;

import A7.d;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class x extends B {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final List g;

    public x(String s, String s1, String s2, String s3, String s4, List list0, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = z;
        this.g = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x)) {
            return false;
        }
        if(!q.b(this.a, ((x)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((x)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((x)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((x)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((x)object0).e)) {
            return false;
        }
        return this.f == ((x)object0).f ? q.b(this.g, ((x)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return this.g.hashCode() + d.e(((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F, 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjHomePowerDjSubContentListItem(myPageImg=", this.a, ", memberKey=", this.b, ", memberNickName=");
        d.u(stringBuilder0, this.c, ", followerCount=", this.d, ", offerIntroduceText=");
        Y.x(stringBuilder0, this.e, ", isMyFriend=", this.f, ", playlist=");
        return Y.m(stringBuilder0, this.g, ")");
    }
}

