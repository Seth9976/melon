package m3;

import java.util.Collections;
import java.util.List;

public abstract class l {
    public final String a;
    public final List b;
    public final boolean c;

    public l(String s, List list0, boolean z) {
        this.a = s;
        this.b = Collections.unmodifiableList(list0);
        this.c = z;
    }

    public abstract Object a(List arg1);
}

