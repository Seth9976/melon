package td;

import android.content.DialogInterface;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class y implements k {
    public final int a;
    public final b0 b;

    public y(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                H0 h00 = new H0(((int)(((Integer)object0))));
                this.b.sendUserEvent(h00);
                return H.a;
            }
            case 1: {
                q.g(((DialogInterface)object0), "it");
                this.b.getRetainDismissListener().onDismiss(((DialogInterface)object0));
                ((t1)this.b.getViewModel()).j();
                return H.a;
            }
            case 2: {
                I0 i00 = new I0(((int)(((Integer)object0))));
                this.b.sendUserEvent(i00);
                return H.a;
            }
            default: {
                G0 g00 = new G0(((int)(((Integer)object0))));
                this.b.sendUserEvent(g00);
                return H.a;
            }
        }
    }
}

