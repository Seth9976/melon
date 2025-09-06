package Ac;

import A7.d;
import U4.x;
import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class e0 implements I4 {
    public final String a;
    public final String b;
    public final String c;

    public e0(String s, String s1, String s2) {
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e0)) {
            return false;
        }
        if(!q.b(this.a, ((e0)object0).a)) {
            return false;
        }
        return q.b(this.b, ((e0)object0).b) ? q.b(this.c, ((e0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(d.o("LinkVideoAttachUiEvent(title=", this.a, ", thumbnail=", this.b, ", originalUrl="), this.c, ")");
    }
}

