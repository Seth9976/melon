package Nc;

import A7.d;
import Oc.m;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class d1 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final m d;

    public d1(String s, String s1, String s2, m m0) {
        q.g(s1, "artistName");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = m0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d1 && this.a.equals(((d1)object0).a) && q.b(this.b, ((d1)object0).b) && this.c.equals(((d1)object0).c) && this.d.equals(((d1)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("GenreNewMusicUiState(albumName=", this.a, ", artistName=", this.b, ", albumImgUrl=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", onGenreNewMusicUserEvent=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

