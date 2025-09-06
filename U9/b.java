package u9;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.q;
import we.a;

public final class b implements a {
    public final int a;
    public final f b;

    public b(f f0, int v) {
        this.a = v;
        this.b = f0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        f f0 = this.b;
        if(this.a != 0) {
            Context context0 = f0.a;
            File file0 = context0.getExternalFilesDir(null);
            if(file0 == null) {
                file0 = context0.getFilesDir();
            }
            q.f(file0, "run(...)");
            return new File(file0, f0.b);
        }
        return new File(c.c(), f0.b);
    }
}

