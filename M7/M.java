package M7;

import P7.b;
import P7.c;
import android.content.Context;
import com.google.firebase.e;
import com.google.firebase.sessions.SessionLifecycleServiceBinderImpl;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import javax.inject.Provider;
import kotlin.jvm.internal.q;
import l2.i;
import m2.a;

public final class m implements b {
    public final int a;
    public final Provider b;

    public m(Provider provider0, int v) {
        this.a = v;
        this.b = provider0;
        super();
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        Provider provider0 = this.b;
        switch(this.a) {
            case 0: {
                return new l(((y7.b)((c)provider0).a));
            }
            case 1: {
                q.g(((e)((c)provider0).a), "firebaseApp");
                return P.a(((e)((c)provider0).a));
            }
            case 2: {
                q.g(((Context)((c)provider0).a), "appContext");
                return q2.e.a(new a(M7.q.g), new r(((Context)((c)provider0).a), 0), 6);
            }
            case 3: {
                q.g(((Context)((c)provider0).a), "appContext");
                return q2.e.a(new a(M7.q.h), new r(((Context)((c)provider0).a), 1), 6);
            }
            case 4: {
                return new SessionLifecycleServiceBinderImpl(((Context)((c)provider0).a));
            }
            case 5: {
                return new LocalOverrideSettings(((Context)((c)provider0).a));
            }
            default: {
                return new Q7.m(((i)provider0.get()));
            }
        }
    }
}

