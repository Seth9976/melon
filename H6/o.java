package H6;

import java.io.Serializable;
import java.util.Arrays;
import va.e;
import x1.a;

public final class o implements k, Serializable {
    public final Object a;
    private static final long serialVersionUID;

    public o(Object object0) {
        this.a = object0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof o ? a.w(this.a, ((o)object0).a) : false;
    }

    @Override  // H6.k
    public final Object get() {
        return this.a;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    @Override
    public final String toString() {
        return e.d(new StringBuilder("Suppliers.ofInstance("), this.a, ")");
    }
}

