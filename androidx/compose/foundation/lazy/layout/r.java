package androidx.compose.foundation.lazy.layout;

import B7.b;
import java.util.Comparator;

public final class r implements Comparator {
    public final int a;
    public final b b;

    public r(b b0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                Object object4 = ((A)object0).getKey();
                Integer integer1 = this.b.n(object4);
                Object object5 = ((A)object1).getKey();
                return e1.b.r(integer1, this.b.n(object5));
            }
            case 1: {
                Object object6 = ((A)object0).getKey();
                Integer integer2 = this.b.n(object6);
                Object object7 = ((A)object1).getKey();
                return e1.b.r(integer2, this.b.n(object7));
            }
            case 2: {
                Object object8 = ((A)object1).getKey();
                Integer integer3 = this.b.n(object8);
                Object object9 = ((A)object0).getKey();
                return e1.b.r(integer3, this.b.n(object9));
            }
            default: {
                Object object2 = ((A)object1).getKey();
                Integer integer0 = this.b.n(object2);
                Object object3 = ((A)object0).getKey();
                return e1.b.r(integer0, this.b.n(object3));
            }
        }
    }
}

