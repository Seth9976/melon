package hc;

import Ub.s;
import Ub.t;
import android.content.Context;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class l {
    public final Context a;
    public final s b;

    public l(Context context0, s s0) {
        q.g(context0, "context");
        q.g(s0, "remotePlayerManager");
        super();
        this.a = context0;
        this.b = s0;
    }

    public final String a() {
        s s0 = this.b;
        String s1 = "";
        if(((t)s0).c()) {
            String s2 = (String)((t)s0).i.getValue();
            if(s2 != null) {
                s1 = s2;
            }
            if(s1.length() > 0) {
                q.f("%1$s에 전송 중", "getString(...)");
                return String.format("%1$s에 전송 중", Arrays.copyOf(new Object[]{s1}, 1));
            }
        }
        return s1;
    }
}

