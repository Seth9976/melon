package X0;

import Q0.W0;
import Q0.x0;
import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.compose.ui.semantics.ClearAndSetSemanticsElement;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import je.D;
import je.q;
import we.k;

public abstract class n {
    public static final AtomicInteger a;

    static {
        n.a = new AtomicInteger(0);
    }

    public static final void a(x0 x00, l l0) {
        W0 w00 = x00.c;
        int v = D.N(q.Q(10, l0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        for(Object object0: l0) {
            w w0 = (w)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            linkedHashMap0.put(w0.a, object1);
        }
        w00.b(linkedHashMap0, "properties");
    }

    public static final r0.q b(r0.q q0, k k0) {
        return q0.then(new ClearAndSetSemanticsElement(k0));
    }

    public static final r0.q c(r0.q q0, boolean z, k k0) {
        return q0.then(new AppendedSemanticsElement(k0, z));
    }

    public static r0.q d(r0.q q0, k k0) {
        return n.c(q0, false, k0);
    }
}

