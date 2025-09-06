package gd;

import A7.d;
import kotlin.jvm.internal.q;

public final class y extends B {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public y(String s, String s1, String s2, boolean z, String s3, String s4) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y)) {
            return false;
        }
        if(!q.b(this.a, ((y)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((y)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((y)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((y)object0).d)) {
            return false;
        }
        return q.b(this.e, ((y)object0).e) ? this.f == ((y)object0).f : false;
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
        return Boolean.hashCode(this.f) + ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjHomeRecommendPlaylistSubContentListItem(myPageImg=", this.a, ", memberKey=", this.b, ", memberNickName=");
        d.u(stringBuilder0, this.c, ", followerCount=", this.d, ", offerIntroduceText=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isMyFriend=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

