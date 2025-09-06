package Me;

import kotlin.jvm.internal.q;
import qf.e;

public final class v extends T {
    public final e a;
    public final Kf.e b;

    public v(e e0, Kf.e e1) {
        q.g(e1, "underlyingType");
        super();
        this.a = e0;
        this.b = e1;
    }

    @Override  // Me.T
    public final boolean a(e e0) {
        return this.a.equals(e0);
    }

    @Override
    public final String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.a + ", underlyingType=" + this.b + ')';
    }
}

