package O;

import N0.Z;
import androidx.compose.runtime.b0;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import we.k;

public final class t extends r implements k {
    public final int f;
    public final b0 g;
    public final ArrayList h;
    public final Object i;
    public final boolean j;

    public t(b0 b00, ArrayList arrayList0, List list0, boolean z, int v) {
        this.f = v;
        this.g = b00;
        this.h = arrayList0;
        this.i = list0;
        this.j = z;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            s s0 = new s(this.h, ((List)this.i), this.j, 1);
            ((Z)object0).a = true;
            s0.invoke(((Z)object0));
            ((Z)object0).a = false;
            this.g.getValue();
            return H.a;
        }
        s s1 = new s(this.h, ((List)this.i), this.j, 0);
        ((Z)object0).a = true;
        s1.invoke(((Z)object0));
        ((Z)object0).a = false;
        this.g.getValue();
        return H.a;
    }
}

