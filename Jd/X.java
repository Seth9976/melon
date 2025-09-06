package jd;

import android.net.Uri;
import androidx.activity.result.ActivityResult;
import e.a;
import e.k;
import java.util.List;
import kotlin.jvm.internal.q;

public final class x implements a {
    public final int a;
    public final A b;

    public x(A a0, int v) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // e.a
    public final void onActivityResult(Object object0) {
        A a0 = this.b;
        if(this.a != 0) {
            q.g(((ActivityResult)object0), "result");
            if(((ActivityResult)object0).a == -1) {
                Uri uri0 = a0.h;
                if(uri0 != null) {
                    a0.sendUserEvent(new j0(k.z(uri0)));
                }
            }
            return;
        }
        q.g(((List)object0), "uris");
        if(!((List)object0).isEmpty()) {
            a0.sendUserEvent(new j0(((List)object0)));
        }
    }
}

