package m1;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class m {
    public final Set a;

    public m() {
        this.a = Collections.newSetFromMap(new WeakHashMap());
    }
}

