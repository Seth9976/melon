package jd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;

public final class c {
    public final int a;
    public final int b;
    public final int c;

    public c(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        if(this.a != ((c)object0).a) {
            return false;
        }
        return this.b == ((c)object0).b ? this.c == ((c)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "ColorData(hue=", ", saturation=", ", lightness=");
        return x.g(this.c, ")", stringBuilder0);
    }
}

