package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import kotlin.jvm.internal.q;

public final class r extends RemoteCallbackList {
    public final MultiInstanceInvalidationService a;

    public r(MultiInstanceInvalidationService multiInstanceInvalidationService0) {
        this.a = multiInstanceInvalidationService0;
        super();
    }

    @Override  // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface0, Object object0) {
        q.g(((f)iInterface0), "callback");
        q.g(object0, "cookie");
        this.a.b.remove(((Integer)object0));
    }
}

