package I6;

import java.util.Iterator;
import java.util.Set;

public final class y0 extends a {
    public final Iterator c;
    public final Iterator d;
    public final Set e;
    public final Set f;

    public y0(Set set0, Set set1) {
        this.e = set0;
        this.f = set1;
        super();
        this.c = set0.iterator();
        this.d = set1.iterator();
    }

    @Override  // I6.a
    public final Object a() {
        Iterator iterator0 = this.c;
        if(iterator0.hasNext()) {
            return iterator0.next();
        }
        while(true) {
            Iterator iterator1 = this.d;
            if(!iterator1.hasNext()) {
                break;
            }
            Object object1 = iterator1.next();
            if(!this.e.contains(object1)) {
                return object1;
            }
        }
        this.a = 3;
        return null;
    }
}

