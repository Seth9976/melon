package androidx.media3.datasource;

import H6.k;
import H6.m;
import M6.B;
import M6.C;
import M6.D;
import android.content.Context;
import e3.a;
import e3.b;

public final class DataSourceBitmapLoader implements a {
    public final C a;
    public final DefaultDataSource.Factory b;
    public final int c;
    public static final k d;

    static {
        DataSourceBitmapLoader.d = B.a.T(new m(2));
    }

    public DataSourceBitmapLoader(Context context0) {
        C c0 = (C)DataSourceBitmapLoader.d.get();
        b.k(c0);
        DefaultDataSource.Factory defaultDataSource$Factory0 = new DefaultDataSource.Factory(context0);
        super();
        this.a = c0;
        this.b = defaultDataSource$Factory0;
        this.c = -1;
    }

    @Override  // e3.a
    public final B a(byte[] arr_b) {
        H7.a a0 = new H7.a(3, this, arr_b);
        return ((D)this.a).a(a0);
    }
}

