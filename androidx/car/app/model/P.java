package androidx.car.app.model;

import android.os.Binder;
import androidx.car.app.utils.a;

public final class p implements a {
    public final int a;
    public final Binder b;
    public final String c;

    public p(Binder binder0, String s, int v) {
        this.a = v;
        this.b = binder0;
        this.c = s;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        switch(this.a) {
            case 0: {
                return ((OnInputCallbackStub)this.b).lambda$onInputTextChanged$1(this.c);
            }
            case 1: {
                return ((OnInputCallbackStub)this.b).lambda$onInputSubmitted$0(this.c);
            }
            default: {
                return ((TabCallbackStub)this.b).lambda$onTabSelected$0(this.c);
            }
        }
    }
}

