package N4;

import androidx.transition.Transition;
import java.util.ArrayList;

public final class t extends U {
    public final Object a;
    public final ArrayList b;
    public final Object c;
    public final ArrayList d;
    public final v e;

    public t(v v0, Object object0, ArrayList arrayList0, Object object1, ArrayList arrayList1) {
        this.e = v0;
        this.a = object0;
        this.b = arrayList0;
        this.c = object1;
        this.d = arrayList1;
    }

    @Override  // N4.U
    public final void e(Transition transition0) {
        v v0 = this.e;
        Object object0 = this.a;
        if(object0 != null) {
            v0.z(object0, this.b, null);
        }
        Object object1 = this.c;
        if(object1 != null) {
            v0.z(object1, this.d, null);
        }
    }

    @Override  // N4.U
    public final void f(Transition transition0) {
        transition0.A(this);
    }
}

