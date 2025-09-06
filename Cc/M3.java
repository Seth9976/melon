package Cc;

import Bd.e;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.SparseBooleanArray;
import kotlin.jvm.internal.q;
import we.a;

public abstract class m3 {
    public static final SparseBooleanArray a;

    static {
        m3.a = new SparseBooleanArray();
    }

    public static final Activity a(Context context0) {
        if(context0 instanceof Activity) {
            return (Activity)context0;
        }
        if(!(context0 instanceof ContextWrapper)) {
            throw new IllegalStateException("unable to find Activity");
        }
        Context context1 = ((ContextWrapper)context0).getBaseContext();
        q.f(context1, "getBaseContext(...)");
        return m3.a(context1);
    }

    public static final r0.q b(r0.q q0, a a0) {
        q.g(q0, "<this>");
        q.g(a0, "onShown");
        return r0.a.a(q0, new e(a0, 5));
    }
}

