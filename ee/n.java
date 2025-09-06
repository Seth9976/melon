package ee;

import E9.w;
import a.a;
import android.content.Context;
import android.content.ContextWrapper;
import fe.b;
import k8.e;
import k8.p;
import td.c;

public final class n implements b {
    public volatile p a;
    public final Object b;
    public final c c;

    public n(c c0) {
        this.b = new Object();
        this.c = c0;
    }

    public final p a() {
        c c0 = this.c;
        Context context0;
        for(context0 = c0.getContext(); context0 instanceof ContextWrapper && !b.class.isInstance(context0); context0 = ((ContextWrapper)context0).getBaseContext()) {
        }
        if(context0 == a.w(context0.getApplicationContext())) {
            d5.n.n(false, "%s, Hilt view cannot be created using the application context. Use a Hilt Fragment or Activity context.", new Object[]{c0.getClass()});
            context0 = null;
        }
        if(!(context0 instanceof b)) {
            throw new IllegalStateException(c0.getClass() + ", Hilt view must be attached to an @AndroidEntryPoint Fragment or Activity.");
        }
        e e0 = (e)(((m)w.s(((b)context0), m.class)));
        return new p(e0.b, e0.c);
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.a == null) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.a == null) {
                    this.a = this.a();
                }
            }
        }
        return this.a;
    }
}

