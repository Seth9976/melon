package Ac;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class x1 implements C1 {
    public final String a;
    public final String b;
    public final String c;

    public x1(String s, String s1) {
        this.a = s;
        this.b = s1;
        this.c = "1000000563";
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x1)) {
            return false;
        }
        if(!q.b(this.a, ((x1)object0).a)) {
            return false;
        }
        return q.b(this.b, ((x1)object0).b) ? q.b(this.c, ((x1)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return x.m(d.o("AttachmentVideoItemClickEvent(videoId=", this.a, ", videoTitle=", this.b, ", menuId="), this.c, ")");
    }
}

