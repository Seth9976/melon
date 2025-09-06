package Vb;

import A7.d;
import androidx.appcompat.app.o;

public final class s0 {
    public final int a;
    public final int b;
    public final boolean c;

    public s0(int v, int v1, boolean z) {
        this.a = v;
        this.b = v1;
        this.c = z;
    }

    public static s0 a(s0 s00, int v, int v1, boolean z, int v2) {
        if((v2 & 1) != 0) {
            v = s00.a;
        }
        if((v2 & 2) != 0) {
            v1 = s00.b;
        }
        if((v2 & 4) != 0) {
            z = s00.c;
        }
        s00.getClass();
        return new s0(v, v1, z);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s0)) {
            return false;
        }
        if(this.a != ((s0)object0).a) {
            return false;
        }
        return this.b == ((s0)object0).b ? this.c == ((s0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return o.s(o.t(this.a, this.b, "State(maxRetryCount=", ", maxErrorCount=", ", keepScreenOnDuringPlayback="), this.c, ")");
    }
}

