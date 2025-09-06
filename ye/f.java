package Ye;

import Xe.d;
import Xe.g;
import java.util.ArrayList;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;

public final class f implements g {
    public boolean a;
    public final ArrayList b;
    public static final d c;

    static {
        f.c = new d(I.a.b(f.class));
    }

    public f() {
        this.b = new ArrayList();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            Class class0 = object0 == null ? null : object0.getClass();
            if(f.class.equals(class0)) {
                q.e(object0, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
                return this.a == ((f)object0).a && q.b(this.b, ((f)object0).b);
            }
            return false;
        }
        return true;
    }

    @Override  // Xe.c
    public final d getType() {
        return f.c;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F;
    }
}

