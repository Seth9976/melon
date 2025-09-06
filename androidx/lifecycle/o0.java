package androidx.lifecycle;

import De.d;
import S2.c;
import kotlin.jvm.internal.q;

public interface o0 {
    default m0 create(d d0, c c0) {
        q.g(d0, "modelClass");
        q.g(c0, "extras");
        return this.create(df.d.v(d0), c0);
    }

    default m0 create(Class class0) {
        q.g(class0, "modelClass");
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default m0 create(Class class0, c c0) {
        q.g(class0, "modelClass");
        q.g(c0, "extras");
        return this.create(class0);
    }
}

