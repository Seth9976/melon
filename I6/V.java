package I6;

import H6.e;
import java.io.Serializable;
import java.util.Arrays;

public final class v extends n0 implements Serializable {
    public final e a;
    public final n0 b;
    private static final long serialVersionUID;

    public v(e e0, n0 n00) {
        this.a = e0;
        this.b = n00;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        Object object2 = this.a.apply(object0);
        Object object3 = this.a.apply(object1);
        return this.b.compare(object2, object3);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof v && this.a.equals(((v)object0).a) && this.b.equals(((v)object0).b);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    @Override
    public final String toString() {
        return this.b + ".onResultOf(" + this.a + ")";
    }
}

