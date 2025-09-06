package M;

import A7.d;
import kotlin.jvm.internal.q;

public final class m0 {
    public float a;
    public boolean b;
    public c c;

    public m0() {
        this.a = 0.0f;
        this.b = true;
        this.c = null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m0)) {
            return false;
        }
        if(Float.compare(this.a, ((m0)object0).a) != 0) {
            return false;
        }
        return this.b == ((m0)object0).b ? q.b(this.c, ((m0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(Float.hashCode(this.a) * 0x1F, 0x1F, this.b);
        return this.c == null ? v * 0x1F : (v + this.c.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return "RowColumnParentData(weight=" + this.a + ", fill=" + this.b + ", crossAxisAlignment=" + this.c + ", flowLayoutData=null)";
    }
}

