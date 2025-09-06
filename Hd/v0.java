package hd;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class v0 extends J0 {
    public final String a;
    public final String b;
    public final int c;

    public v0(String s, String s1, int v) {
        q.g(s, "artistId");
        q.g(s1, "artistName");
        super();
        this.a = s;
        this.b = s1;
        this.c = v;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof v0 && q.b(this.a, ((v0)object0).a) && q.b(this.b, ((v0)object0).b) && this.c == ((v0)object0).c;
    }

    @Override
    public final int hashCode() {
        return this.c + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ClickArtistGoArtistChannel(artistId=", this.a, ", artistName=", this.b, ", type=");
        return x.g(this.c, ")", stringBuilder0);
    }
}

