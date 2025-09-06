package A2;

import androidx.fragment.app.I;
import kotlin.jvm.internal.q;

public abstract class h extends RuntimeException {
    public final I a;

    public h(I i0, String s) {
        q.g(i0, "fragment");
        super(s);
        this.a = i0;
    }
}

