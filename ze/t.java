package Ze;

import d3.g;
import java.util.Map;
import je.x;
import kotlin.jvm.internal.q;

public final class t {
    public final z a;
    public final z b;
    public final Map c;
    public final boolean d;

    public t(z z0, z z1) {
        this.a = z0;
        this.b = z1;
        this.c = x.a;
        g.Q(new Af.g(this, 27));
        this.d = z0 == z.b && z1 == z.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        if(this.a != ((t)object0).a) {
            return false;
        }
        return this.b == ((t)object0).b ? q.b(this.c, ((t)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.c.hashCode() + v * 961 : this.c.hashCode() + (v * 0x1F + this.b.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return "Jsr305Settings(globalLevel=" + this.a + ", migrationLevel=" + this.b + ", userDefinedLevelForSpecificAnnotation=" + this.c + ')';
    }
}

