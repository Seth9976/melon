package vc;

import U4.x;
import kotlin.jvm.internal.q;

public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public static final d e;

    static {
        d.e = new d("", "", "", "");
    }

    public d(String s, String s1, String s2, String s3) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(!q.b(this.a, ((d)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((d)object0).b)) {
            return false;
        }
        return q.b(this.c, ((d)object0).c) ? q.b(this.d, ((d)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        return A7.d.n(A7.d.o("RemoteConfigState(enableAdvancedCache=", this.a, ", intervalOptimizationPopup=", this.b, ", traceTargetMembers="), this.c, ", userChoiceBilling=", this.d, ")");
    }
}

