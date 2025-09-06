package rd;

import android.graphics.Point;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import ie.H;
import r1.l;
import we.k;

public final class h0 implements k {
    public final int a;
    public final i0 b;

    public h0(i0 i00, int v) {
        this.a = v;
        this.b = i00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            DjMalrangPlayerViewCalculator djMalrangPlayerViewCalculator0 = (DjMalrangPlayerViewCalculator)this.b.i.getValue();
            djMalrangPlayerViewCalculator0.getClass();
            return djMalrangPlayerViewCalculator0.a(new Point(((int)(((l)object0).a >> 0x20)), ((int)(((l)object0).a & 0xFFFFFFFFL))));
        }
        ((Float)object0).floatValue();
        this.b.h.setValue(((Float)object0));
        return H.a;
    }
}

