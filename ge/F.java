package Ge;

import De.o;
import Me.p;
import e1.b;
import java.lang.reflect.Method;
import java.util.Comparator;

public final class f implements Comparator {
    public final int a;

    public f(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                return b.r(((Method)object0).getName(), ((Method)object1).getName());
            }
            case 1: {
                return b.r(((W)(((o)object0))).getName(), ((W)(((o)object1))).getName());
            }
            default: {
                Integer integer0 = p.b(((Me.o)object0), ((Me.o)object1));
                return integer0 == null ? 0 : ((int)integer0);
            }
        }
    }
}

