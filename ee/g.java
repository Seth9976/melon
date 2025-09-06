package ee;

import com.iloen.melon.Hilt_MelonAppBase;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import fe.b;
import i.n.i.b.a.s.e.Ga;
import k8.o;

public final class g implements b {
    public volatile o a;
    public final Object b;
    public final Ga c;

    public g(Ga ga0) {
        this.b = new Object();
        this.c = ga0;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.a == null) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.a == null) {
                    this.a = new o(new ApplicationContextModule(((Hilt_MelonAppBase)this.c.b)));
                }
            }
        }
        return this.a;
    }
}

