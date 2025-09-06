package Cc;

import Kd.g;
import X0.u;
import X0.x;
import android.content.Context;
import com.iloen.melon.utils.TalkbackUtilKt;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class t implements k {
    public final int a;
    public final Context b;
    public final String c;
    public final g d;

    public t(Context context0, String s, g g0, int v) {
        this.a = v;
        this.b = context0;
        this.c = s;
        this.d = g0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((x)object0), "$this$semantics");
            String s = this.b.getString(0x7F130C16, new Object[]{this.c});  // string:talkback_rank "%s위"
            q.f(s, "getString(...)");
            u.h(((x)object0), s + ", " + TalkbackUtilKt.getPlayableTalkbackInfo(this.b, this.d.b, this.d.G));
            return H.a;
        }
        q.g(((x)object0), "$this$semantics");
        String s1 = this.b.getString(0x7F130C16, new Object[]{this.c});  // string:talkback_rank "%s위"
        q.f(s1, "getString(...)");
        u.h(((x)object0), s1 + ", " + TalkbackUtilKt.getPlayableTalkbackInfo(this.b, this.d.b, this.d.G));
        return H.a;
    }
}

