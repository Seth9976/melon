package n5;

import android.net.Uri;
import ie.j;
import kotlin.jvm.internal.q;
import t5.o;

public final class i implements f {
    public final Object a;
    public final Object b;
    public final boolean c;

    public i(j j0, j j1, boolean z) {
        this.a = j0;
        this.b = j1;
        this.c = z;
    }

    @Override  // n5.f
    public final g a(Object object0, o o0) {
        return !q.b(((Uri)object0).getScheme(), "http") && !q.b(((Uri)object0).getScheme(), "https") ? null : new l(((Uri)object0).toString(), o0, ((j)this.a), ((j)this.b), this.c);
    }
}

