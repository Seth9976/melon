package Ic;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class o implements K4 {
    public final String a;
    public final String b;
    public final String c;

    public o(String s, String s1, String s2) {
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o)) {
            return false;
        }
        if(!q.b(this.a, ((o)object0).a)) {
            return false;
        }
        return q.b(this.b, ((o)object0).b) ? q.b(this.c, ((o)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(d.o("ArtistUiState(id=", this.a, ", name=", this.b, ", image="), this.c, ")");
    }
}

