package gd;

import A7.d;
import k8.Y;
import kotlin.jvm.internal.q;

public final class c0 extends e0 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final String g;
    public final String h;

    public c0(String s, String s1, String s2, boolean z, String s3, boolean z1, String s4, String s5) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = s3;
        this.f = z1;
        this.g = s4;
        this.h = s5;
    }

    public static c0 a(c0 c00, boolean z) {
        c00.getClass();
        return new c0(c00.a, c00.b, c00.c, c00.d, c00.e, z, c00.g, c00.h);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        if(!q.b(this.a, ((c0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((c0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((c0)object0).c)) {
            return false;
        }
        if(this.d != ((c0)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((c0)object0).e)) {
            return false;
        }
        if(this.f != ((c0)object0).f) {
            return false;
        }
        return q.b(this.g, ((c0)object0).g) ? q.b(this.h, ((c0)object0).h) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e((d.e((((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F, 0x1F, this.f);
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return this.h.hashCode() + (v1 + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("FriendItemUiState(memberKey=", this.a, ", memberDJIconType=", this.b, ", memberNickname=");
        Y.x(stringBuilder0, this.c, ", isOfficial=", this.d, ", myPageDesc=");
        Y.x(stringBuilder0, this.e, ", isMyFriend=", this.f, ", thumbImgUrl=");
        return d.n(stringBuilder0, this.g, ", loginMemberKey=", this.h, ")");
    }
}

