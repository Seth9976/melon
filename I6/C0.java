package I6;

import H6.g;
import java.util.Iterator;

public final class c0 extends a {
    public final Iterator c;
    public final g d;

    public c0(Iterator iterator0, g g0) {
        this.c = iterator0;
        this.d = g0;
        super();
    }

    @Override  // I6.a
    public final Object a() {
        while(true) {
            Iterator iterator0 = this.c;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            if(this.d.apply(object0)) {
                return object0;
            }
        }
        this.a = 3;
        return null;
    }
}

