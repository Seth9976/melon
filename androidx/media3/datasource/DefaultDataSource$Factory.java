package androidx.media3.datasource;

import A3.g;
import android.content.Context;
import g3.e;
import g3.f;
import g3.k;

public final class DefaultDataSource.Factory implements e {
    public final Context a;
    public final g b;

    public DefaultDataSource.Factory(Context context0) {
        this(context0, new g(7, 0));
    }

    public DefaultDataSource.Factory(Context context0, g g0) {
        this.a = context0.getApplicationContext();
        this.b = g0;
    }

    @Override  // g3.e
    public final f createDataSource() {
        f f0 = this.b.createDataSource();
        return new k(this.a, f0);
    }
}

