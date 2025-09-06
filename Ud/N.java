package ud;

import X0.u;
import X0.x;
import android.content.Context;
import com.iloen.melon.utils.TalkbackUtilKt;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class n implements k {
    public final Context a;
    public final long b;
    public final long c;

    public n(Context context0, long v, long v1) {
        this.a = context0;
        this.b = v;
        this.c = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((x)object0), "$this$clearAndSetSemantics");
        u.h(((x)object0), TalkbackUtilKt.getPlayProgressTalkbackInfo(this.a, this.b, this.c));
        return H.a;
    }
}

