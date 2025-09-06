package androidx.media3.exoplayer;

import B3.o;
import H6.k;
import android.app.Service;
import androidx.media3.common.d;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import b3.i0;
import gc.f;
import s3.y;

public final class m implements k {
    public final int a;
    public final Object b;

    public m(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // H6.k
    public final Object get() {
        switch(this.a) {
            case 0: {
                return (f)this.b;
            }
            case 1: {
                o o0 = new o();
                return new DefaultMediaSourceFactory(((Service)this.b), o0);
            }
            case 2: {
                return Boolean.valueOf(((H)this.b).X);
            }
            case 3: {
                d d0 = ((i0)this.b).a();
                d0.e = null;
                d0.d = ((i0)this.b).t.p() ? 4 : 2;
                return new i0(d0);
            }
            default: {
                Class class0 = (Class)this.b;
                try {
                    return (y)class0.getConstructor(null).newInstance(null);
                }
                catch(Exception exception0) {
                    throw new IllegalStateException(exception0);
                }
            }
        }
    }
}

