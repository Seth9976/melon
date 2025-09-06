package i.n.i.b.a.s.e;

import androidx.media3.session.legacy.C;
import java.util.ArrayList;

public final class l9 {
    public final B9 a;

    public l9(B9 b90) {
        this.a = b90;
        super();
    }

    public void a(B8 b80) {
        ArrayList arrayList0 = this.a.k;
        if(!arrayList0.contains(b80)) {
            arrayList0.add(b80);
            if(arrayList0.size() == 1) {
                g5 g50 = b80.b.c();
                b80.z = g50;
                C c0 = b80.t;
                g50.getClass();
                c0.a(0, g50, true);
            }
        }
    }

    public void b(Exception exception0) {
        ArrayList arrayList0 = this.a.k;
        for(Object object0: arrayList0) {
            ((B8)object0).c(exception0, null);
        }
        arrayList0.clear();
    }
}

