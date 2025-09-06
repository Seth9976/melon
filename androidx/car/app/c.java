package androidx.car.app;

import androidx.car.app.utils.a;

public final class c implements a {
    public final int a;
    public final CarAppBinder b;

    public c(CarAppBinder carAppBinder0, int v) {
        this.a = v;
        this.b = carAppBinder0;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        switch(this.a) {
            case 0: {
                return this.b.lambda$onAppPause$3();
            }
            case 1: {
                return this.b.lambda$onAppStart$1();
            }
            case 2: {
                return this.b.lambda$onAppStop$4();
            }
            default: {
                return this.b.lambda$onAppResume$2();
            }
        }
    }
}

