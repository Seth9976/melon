package M7;

import P7.b;
import P7.c;
import Q7.i;
import com.google.firebase.e;
import com.google.firebase.sessions.SessionLifecycleServiceBinderImpl;
import javax.inject.Provider;

public final class y implements b {
    public final c a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public y(c c0, Provider provider0, Provider provider1, Provider provider2) {
        this.a = c0;
        this.b = provider0;
        this.c = provider1;
        this.d = provider2;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        i i0 = (i)this.b.get();
        me.i i1 = (me.i)this.c.get();
        SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl0 = (SessionLifecycleServiceBinderImpl)this.d.get();
        return new p(((e)this.a.a), i0, i1, sessionLifecycleServiceBinderImpl0);
    }
}

