package androidx.car.app;

import android.content.Intent;
import android.content.res.Configuration;
import androidx.car.app.utils.a;

public final class d implements a {
    public final CarAppBinder a;
    public final ICarHost b;
    public final Configuration c;
    public final Intent d;

    public d(CarAppBinder carAppBinder0, ICarHost iCarHost0, Configuration configuration0, Intent intent0) {
        this.a = carAppBinder0;
        this.b = iCarHost0;
        this.c = configuration0;
        this.d = intent0;
    }

    @Override  // androidx.car.app.utils.a
    public final Object a() {
        return this.a.lambda$onAppCreate$0(this.b, this.c, this.d);
    }
}

