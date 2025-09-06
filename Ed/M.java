package ed;

import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class m implements k {
    public final int a;
    public final a b;
    public final boolean c;

    public m(a z$a0, boolean z, int v) {
        this.a = v;
        this.b = z$a0;
        this.c = z;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s;
        if(this.a != 0) {
            q.g(((x)object0), "$this$clearAndSetSemantics");
            a z$a0 = this.b;
            if(this.c) {
                s = "";
            }
            else {
                s = z$a0.getString(0x7F130C35);  // string:talkback_search_selected "선택됨"
                q.f(s, "getString(...)");
            }
            String s1 = z$a0.getString(0x7F130C2E, new Object[]{s, z$a0.getString(0x7F1308E8)});  // string:talkback_search_hotkeyword_index_button "%1$s, %2$s"
            q.f(s1, "getString(...)");
            u.h(((x)object0), s1);
            return H.a;
        }
        q.g(((x)object0), "$this$clearAndSetSemantics");
        String s2 = this.c ? this.b.getString(0x7F130C35) : "";  // string:talkback_search_selected "선택됨"
        String s3 = this.b.getString(0x7F130C2E, new Object[]{s2, this.b.getString(0x7F1308E7)});  // string:talkback_search_hotkeyword_index_button "%1$s, %2$s"
        q.f(s3, "getString(...)");
        u.h(((x)object0), s3);
        return H.a;
    }
}

