package I4;

import Ac.U;
import H4.a;
import H4.b;
import H4.e;
import android.content.Context;
import ie.C;
import ie.r;
import kotlin.jvm.internal.q;

public final class g implements e {
    public final Context a;
    public final String b;
    public final b c;
    public final boolean d;
    public final boolean e;
    public final r f;
    public boolean g;

    public g(Context context0, String s, b b0, boolean z, boolean z1) {
        q.g(b0, "callback");
        super();
        this.a = context0;
        this.b = s;
        this.c = b0;
        this.d = z;
        this.e = z1;
        this.f = d3.g.Q(new U(this, 20));
    }

    @Override
    public final void close() {
        if(this.f.b != C.a) {
            ((f)this.f.getValue()).close();
        }
    }

    @Override  // H4.e
    public final String getDatabaseName() {
        return this.b;
    }

    @Override  // H4.e
    public final a getWritableDatabase() {
        return ((f)this.f.getValue()).c(true);
    }

    @Override  // H4.e
    public final void setWriteAheadLoggingEnabled(boolean z) {
        if(this.f.b != C.a) {
            ((f)this.f.getValue()).setWriteAheadLoggingEnabled(z);
        }
        this.g = z;
    }
}

