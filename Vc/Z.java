package Vc;

import A7.d;
import U4.x;
import Wc.i;
import k8.Y;

public final class z {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final i g;

    public z(String s, String s1, String s2, String s3, String s4, boolean z, i i0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = z;
        this.g = i0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof z && this.a.equals(((z)object0).a) && this.b.equals(((z)object0).b) && this.c.equals(((z)object0).c) && this.d.equals(((z)object0).d) && this.e.equals(((z)object0).e) && this.f == ((z)object0).f && this.g.equals(((z)object0).g);
    }

    @Override
    public final int hashCode() {
        return this.g.hashCode() + d.e(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("PersonalSlotItemUiState(songName=", this.a, ", artistName=", this.b, ", songId=");
        d.u(stringBuilder0, this.c, ", albumImageUrl=", this.d, ", artistImageUrl=");
        Y.x(stringBuilder0, this.e, ", isTitleSong=", this.f, ", userEvent=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

