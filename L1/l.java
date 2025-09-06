package l1;

import androidx.appcompat.app.o;
import java.util.ArrayList;
import t1.a;

public final class l {
    public final int a;
    public static final l b;
    public static final l c;
    public static final l d;

    static {
        l.b = new l(0);
        l.c = new l(1);
        l.d = new l(2);
    }

    public l(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l ? this.a == ((l)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        int v = this.a;
        if(v == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList0 = new ArrayList();
        if((v & 1) != 0) {
            arrayList0.add("Underline");
        }
        if((v & 2) != 0) {
            arrayList0.add("LineThrough");
        }
        return arrayList0.size() == 1 ? "TextDecoration." + ((String)arrayList0.get(0)) : o.r(new StringBuilder("TextDecoration["), a.a(arrayList0, ", ", null, 62), ']');
    }
}

