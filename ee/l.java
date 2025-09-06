package ee;

import E9.w;
import android.app.Application;
import android.app.Service;
import d5.n;
import fe.b;
import k8.j;
import k8.o;

public final class l implements b {
    public final Service a;
    public j b;

    public l(Service service0) {
        this.a = service0;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.b == null) {
            Application application0 = this.a.getApplication();
            n.n(application0 instanceof b, "Hilt service must be attached to an @HiltAndroidApp Application. Found: %s", new Object[]{application0.getClass()});
            this.b = new j(((o)(((k)w.s(application0, k.class)))).b, this.a);
        }
        return this.b;
    }
}

