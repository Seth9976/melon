package P0;

import Q0.L0;
import Q0.N;
import Q0.c1;
import Q0.s0;
import Q0.u;
import android.view.View;
import androidx.compose.ui.platform.DrawChildContainer;
import androidx.compose.ui.platform.ViewLayerContainer;
import ea.c;
import g0.e;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import kotlin.jvm.internal.q;
import we.n;

public interface r0 {
    static q0 a(r0 r00, n n0, g0 g00, boolean z, int v) {
        Object object0;
        e e0;
        if((v & 8) != 0) {
            z = false;
        }
        u u0 = (u)r00;
        if(!z) {
            c c0 = u0.P0;
            do {
                ReferenceQueue referenceQueue0 = (ReferenceQueue)c0.c;
                e0 = (e)c0.b;
                Reference reference0 = referenceQueue0.poll();
                if(reference0 != null) {
                    e0.j(reference0);
                }
            }
            while(reference0 != null);
            do {
                int v1 = e0.c;
                if(v1 == 0) {
                    goto label_17;
                }
                object0 = ((Reference)e0.k(v1 - 1)).get();
            }
            while(object0 == null);
            Object object1 = object0;
            goto label_18;
        label_17:
            object1 = null;
        label_18:
            if(((q0)object1) != null) {
                ((q0)object1).f(n0, g00);
                return (q0)object1;
            }
            return new s0(u0.getGraphicsContext().a(), u0.getGraphicsContext(), u0, n0, g00);
        }
        if(u0.isHardwareAccelerated() && u0.u0) {
            try {
                return new L0(u0, n0, g00);
            }
            catch(Throwable unused_ex) {
                u0.u0 = false;
            }
        }
        if(u0.i0 == null) {
            if(!c1.D) {
                N.y(new View(u0.getContext()));
            }
            DrawChildContainer drawChildContainer0 = c1.E ? new DrawChildContainer(u0.getContext()) : new ViewLayerContainer(u0.getContext());
            u0.i0 = drawChildContainer0;
            u0.addView(drawChildContainer0, -1);
        }
        DrawChildContainer drawChildContainer1 = u0.i0;
        q.d(drawChildContainer1);
        return new c1(u0, drawChildContainer1, n0, g00);
    }
}

