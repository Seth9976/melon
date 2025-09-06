package s3;

import H6.k;
import androidx.media3.datasource.DefaultDataSource.Factory;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import g3.e;

public final class n implements k {
    public final int a;
    public final Class b;
    public final e c;

    public n(Class class0, DefaultDataSource.Factory defaultDataSource$Factory0, int v) {
        this.a = v;
        this.b = class0;
        this.c = defaultDataSource$Factory0;
        super();
    }

    @Override  // H6.k
    public final Object get() {
        switch(this.a) {
            case 0: {
                return DefaultMediaSourceFactory.d(this.b, this.c);
            }
            case 1: {
                return DefaultMediaSourceFactory.d(this.b, this.c);
            }
            default: {
                return DefaultMediaSourceFactory.d(this.b, this.c);
            }
        }
    }
}

