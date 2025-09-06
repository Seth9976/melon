package de;

import android.os.Looper;
import com.google.firebase.b;
import java.util.HashSet;
import kotlinx.coroutines.CoroutineScopeKt;

public final class h {
    public final HashSet a;
    public boolean b;

    public h() {
        this.a = new HashSet();
        this.b = false;
    }

    public final void a() {
        if(b.c == null) {
            b.c = Looper.getMainLooper().getThread();
        }
        if(Thread.currentThread() != b.c) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
        this.b = true;
        for(Object object0: this.a) {
            CoroutineScopeKt.cancel$default(((Ma.h)object0).a, null, 1, null);
        }
    }
}

