package k2;

import android.content.Context;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import okio.Path.Companion;
import okio.Path;
import we.a;

public final class b extends r implements a {
    public final Context f;
    public final c g;

    public b(Context context0, c c0) {
        this.f = context0;
        this.g = c0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        q.f(this.f, "applicationContext");
        String s = de.c.p(this.f, this.g.a).getAbsolutePath();
        q.f(s, "applicationContext.dataS…le(fileName).absolutePath");
        return Companion.get$default(Path.Companion, s, false, 1, null);
    }
}

