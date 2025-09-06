package r0;

import e1.b;
import java.lang.reflect.Field;
import java.util.Comparator;

public final class c implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        return b.r(((Field)object0).getName(), ((Field)object1).getName());
    }
}

