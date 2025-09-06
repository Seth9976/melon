package kotlin.jvm.internal;

import Ge.s;

public class z extends y {
    public z(Class class0, String s, String s1, int v) {
        super(e.NO_RECEIVER, class0, s, s1, v);
    }

    @Override  // De.t
    public Object get(Object object0) {
        return ((s)this.getGetter()).call(new Object[]{object0});
    }
}

