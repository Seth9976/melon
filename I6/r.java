package I6;

import java.util.Map.Entry;
import x1.a;

public abstract class r implements Map.Entry {
    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof Map.Entry && a.w(this.getKey(), ((Map.Entry)object0).getKey()) && a.w(this.getValue(), ((Map.Entry)object0).getValue());
    }

    @Override
    public final int hashCode() {
        Object object0 = this.getKey();
        Object object1 = this.getValue();
        int v = 0;
        int v1 = object0 == null ? 0 : object0.hashCode();
        if(object1 != null) {
            v = object1.hashCode();
        }
        return v1 ^ v;
    }

    @Override
    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}

