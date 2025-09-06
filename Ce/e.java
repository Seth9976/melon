package Ce;

import java.util.Iterator;
import xe.a;

public class e implements Iterable, a {
    public final int a;
    public final int b;
    public final int c;

    public e(int v, int v1, int v2) {
        switch(v2) {
            case 0x80000000: {
                throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            }
            case 0: {
                throw new IllegalArgumentException("Step must be non-zero.");
            }
            default: {
                this.a = v;
                this.b = e2.a.G(v, v1, v2);
                this.c = v2;
            }
        }
    }

    public final f b() {
        return new f(this.a, this.b, this.c);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof e && (this.isEmpty() && ((e)object0).isEmpty() || this.a == ((e)object0).a && this.b == ((e)object0).b && this.c == ((e)object0).c);
    }

    // 去混淆评级： 低(20)
    @Override
    public int hashCode() {
        return this.isEmpty() ? -1 : (this.a * 0x1F + this.b) * 0x1F + this.c;
    }

    public boolean isEmpty() {
        return this.c <= 0 ? this.a < this.b : this.a > this.b;
    }

    @Override
    public final Iterator iterator() {
        return this.b();
    }

    @Override
    public String toString() {
        return this.c <= 0 ? this.a + " downTo " + this.b + " step " + -this.c : this.a + ".." + this.b + " step " + this.c;
    }
}

