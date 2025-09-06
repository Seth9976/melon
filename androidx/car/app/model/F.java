package androidx.car.app.model;

import android.os.Binder;
import androidx.car.app.utils.a;

public final class f implements a {
    public final int a;
    public final Binder b;

    public f(Binder binder0, int v) {
        this.a = v;
        this.b = binder0;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        switch(this.a) {
            case 0: {
                return ((AlertCallbackStub)this.b).lambda$onAlertDismissed$1();
            }
            case 1: {
                return ((OnClickListenerStub)this.b).lambda$onClick$0();
            }
            default: {
                return ((OnContentRefreshListenerStub)this.b).lambda$onContentRefreshRequested$0();
            }
        }
    }
}

