package J2;

import B2.m;

public final class q implements m {
    public final p a;
    public final p b;
    public final p c;
    public final p d;
    public final p e;
    public final p f;

    public q(p p0, p p1, p p2, p p3) {
        this(new p(0.0f, 3), p0, p1, new p(0.0f, 3), p2, p3);
    }

    public q(p p0, p p1, p p2, p p3, p p4, p p5) {
        this.a = p0;
        this.b = p1;
        this.c = p2;
        this.d = p3;
        this.e = p4;
        this.f = p5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.a, ((q)object0).a)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.b, ((q)object0).b)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.c, ((q)object0).c)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.d, ((q)object0).d)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.e, ((q)object0).e) ? kotlin.jvm.internal.q.b(this.f, ((q)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode() + (this.e.hashCode() + (this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "PaddingModifier(left=" + this.a + ", start=" + this.b + ", top=" + this.c + ", right=" + this.d + ", end=" + this.e + ", bottom=" + this.f + ')';
    }
}

