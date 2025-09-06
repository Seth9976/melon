package j3;

import I6.G0;
import I6.Z;
import I6.b0;
import e3.x;
import java.util.Objects;
import java.util.Set;

public final class a {
    public final int a;
    public final int b;
    public final b0 c;
    public static final a d;

    static {
        Z z0 = new Z(4);  // 初始化器: LI6/N;-><init>(I)V
        for(int v = 1; v <= 10; ++v) {
            z0.a(x.p(v));
        }
        a.d = new a(2, z0.g());
    }

    public a(int v, int v1) {
        this.a = v;
        this.b = v1;
        this.c = null;
    }

    public a(int v, Set set0) {
        this.a = v;
        b0 b00 = b0.p(set0);
        this.c = b00;
        int v1 = 0;
        G0 g00 = b00.k();
        while(g00.hasNext()) {
            Object object0 = g00.next();
            v1 = Math.max(v1, Integer.bitCount(((int)(((Integer)object0)))));
        }
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? this.a == ((a)object0).a && this.b == ((a)object0).b && Objects.equals(this.c, ((a)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = (this.a * 0x1F + this.b) * 0x1F;
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "AudioProfile[format=" + this.a + ", maxChannelCount=" + this.b + ", channelMasks=" + this.c + "]";
    }
}

