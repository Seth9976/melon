package I6;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class z0 extends D0 {
    public final int b;
    public final Set c;
    public final Set d;

    public z0(Set set0, Set set1, int v) {
        this.b = v;
        this.c = set0;
        this.d = set1;
        super(1);
    }

    public G0 b() {
        return new A0(this.c, this.d);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean contains(Object object0) {
        return this.b == 0 ? this.c.contains(object0) || this.d.contains(object0) : this.c.contains(object0) && this.d.contains(object0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean containsAll(Collection collection0) {
        return this.b == 1 ? this.c.containsAll(collection0) && this.d.containsAll(collection0) : super.containsAll(collection0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean isEmpty() {
        return this.b == 0 ? this.c.isEmpty() && this.d.isEmpty() : Collections.disjoint(this.d, this.c);
    }

    @Override
    public final Iterator iterator() {
        return this.b != 0 ? new A0(this.c, this.d) : new y0(this.c, this.d);
    }

    @Override
    public final int size() {
        if(this.b != 0) {
            int v = 0;
            for(Object object0: this.c) {
                if(this.d.contains(object0)) {
                    ++v;
                }
            }
            return v;
        }
        Set set0 = this.c;
        int v1 = set0.size();
        for(Object object1: this.d) {
            if(!set0.contains(object1)) {
                ++v1;
            }
        }
        return v1;
    }
}

