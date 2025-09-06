package M7;

import Q7.i;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.e;
import com.google.firebase.sessions.SessionLifecycleServiceBinderImpl;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

public final class p {
    public final e a;
    public final i b;

    public p(e e0, i i0, me.i i1, SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl0) {
        q.g(e0, "firebaseApp");
        q.g(i0, "settings");
        q.g(i1, "backgroundDispatcher");
        q.g(sessionLifecycleServiceBinderImpl0, "lifecycleServiceBinder");
        super();
        this.a = e0;
        this.b = i0;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        e0.a();
        Context context0 = e0.a.getApplicationContext();
        if(context0 instanceof Application) {
            ((Application)context0).registerActivityLifecycleCallbacks(d0.a);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i1), null, null, new o(this, i1, sessionLifecycleServiceBinderImpl0, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + context0.getClass() + '.');
    }
}

