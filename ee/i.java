package ee;

import E9.w;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.I;
import d5.n;
import fe.b;
import k8.e;
import k8.h;

public final class i implements b {
    public volatile h a;
    public final Object b;
    public final I c;

    public i(I i0) {
        this.b = new Object();
        this.c = i0;
    }

    public final h a() {
        I i0 = this.c;
        if(i0.getHost() == null) {
            throw new NullPointerException("Hilt Fragments must be attached before creating the component.");
        }
        n.n(i0.getHost() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", new Object[]{i0.getHost().getClass()});
        e e0 = (e)(((ee.h)w.s(i0.getHost(), ee.h.class)));
        return new h(e0.b, e0.c, e0.d, i0);
    }

    public static final Context b(Context context0) {
        while(context0 instanceof ContextWrapper && !(context0 instanceof Activity)) {
            context0 = ((ContextWrapper)context0).getBaseContext();
        }
        return context0;
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

