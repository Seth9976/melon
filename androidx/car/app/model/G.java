package androidx.car.app.model;

import android.os.Binder;
import androidx.car.app.utils.a;

public final class g implements a {
    public final int a;
    public final int b;
    public final Binder c;

    public g(Binder binder0, int v, int v1) {
        this.a = v1;
        this.c = binder0;
        this.b = v;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a == 0 ? ((AlertCallbackStub)this.c).lambda$onAlertCancelled$0(this.b) : ((OnSelectedListenerStub)this.c).lambda$onSelected$0(this.b);
    }
}

