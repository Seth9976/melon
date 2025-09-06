package androidx.car.app;

import android.content.Intent;
import android.content.res.Configuration;
import androidx.car.app.utils.a;
import java.util.Map;

public final class b implements a, e.a {
    public final int a;
    public final Object b;
    public final Object c;

    public b(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // androidx.car.app.utils.a
    public Object a() {
        return this.a == 0 ? ((CarAppBinder)this.b).lambda$onConfigurationChanged$6(((Configuration)this.c)) : ((CarAppBinder)this.b).lambda$onNewIntent$5(((Intent)this.c));
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        ((CarAppPermissionActivity)this.b).lambda$requestPermissions$0(((IOnRequestPermissionsListener)this.c), ((Map)object0));
    }
}

