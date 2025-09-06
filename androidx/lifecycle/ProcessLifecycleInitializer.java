package androidx.lifecycle;

import K4.a;
import K4.b;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleInitializer;", "LK4/b;", "Landroidx/lifecycle/D;", "<init>", "()V", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ProcessLifecycleInitializer implements b {
    @Override  // K4.b
    public final List a() {
        return w.a;
    }

    @Override  // K4.b
    public final Object b(Context context0) {
        q.g(context0, "context");
        a a0 = a.c(context0);
        q.f(a0, "getInstance(...)");
        if(!a0.b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name=\'androidx.lifecycle.ProcessLifecycleInitializer\'\n                   android:value=\'androidx.startup\' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if(!A.a.getAndSet(true)) {
            Context context1 = context0.getApplicationContext();
            q.e(context1, "null cannot be cast to non-null type android.app.Application");
            ((Application)context1).registerActivityLifecycleCallbacks(new z());
        }
        T.i.getClass();
        T.i.e = new Handler();
        T.i.f.f(r.ON_CREATE);
        Context context2 = context0.getApplicationContext();
        q.e(context2, "null cannot be cast to non-null type android.app.Application");
        ((Application)context2).registerActivityLifecycleCallbacks(new S(T.i));
        return T.i;
    }
}

