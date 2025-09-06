package androidx.car.app;

import java.util.List;

public final class g implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public g(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            CarContext.1.C0(((List)this.b), ((List)this.c));
            return;
        }
        synchronized(((CarAppService)this.b).a) {
            boolean z = ((CarAppBinder)((CarAppService)this.b).a.remove(((SessionInfo)this.c))) == null;
        }
    }
}

