package Nc;

import A7.d;
import Oc.m;
import U4.x;

public final class p1 {
    public final String a;
    public final String b;
    public final m c;

    public p1(String s, String s1, m m0) {
        this.a = s;
        this.b = s1;
        this.c = m0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p1 && this.a.equals(((p1)object0).a) && this.b.equals(((p1)object0).b) && this.c.equals(((p1)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("GenrePlaylistUiState(title=", this.a, ", thumbImgUrl=", this.b, ", onGenrePlaylistUserEvent=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

