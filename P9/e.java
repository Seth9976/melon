package p9;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import x8.f;

public final class e extends f {
    public int a;

    public e() {
        this.a = -1;
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        String s = (String)object0;
        Context context0 = Y.a(MelonAppBase.Companion);
        int v = this.a;
        if(s == null) {
            s = "";
        }
        a.a(context0, v, s);
        return H.a;
    }
}

