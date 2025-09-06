package cd;

import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.LISTFEED;
import ie.H;
import java.util.List;
import we.a;

public final class y2 implements a {
    public final int a;
    public final List b;
    public final LISTFEED c;
    public final B2 d;

    public y2(List list0, LISTFEED mainTopNotificationRes$LISTFEED0, B2 b20, int v) {
        this.a = v;
        this.b = list0;
        this.c = mainTopNotificationRes$LISTFEED0;
        this.d = b20;
        super();
    }

    // 去混淆评级： 低(31)
    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            this.b.add("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c");
            this.d.c.invoke(new C2("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c", (this.c.getType() == null ? FeedType.UNKNOWN : this.c.getType())));
            return H.a;
        }
        this.b.add("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c");
        this.d.c.invoke(new D2("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c", (this.c.getType() == null ? FeedType.UNKNOWN : this.c.getType())));
        return H.a;
    }
}

