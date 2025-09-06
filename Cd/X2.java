package cd;

import C8.e;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.LISTFEED;
import com.melon.net.res.common.LinkInfoBase;
import ie.H;
import we.a;

public final class x2 implements a {
    public final int a;
    public final B2 b;
    public final LISTFEED c;

    public x2(B2 b20, LISTFEED mainTopNotificationRes$LISTFEED0, int v) {
        this.a = v;
        this.b = b20;
        this.c = mainTopNotificationRes$LISTFEED0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                LinkInfoBase linkInfoBase0 = new LinkInfoBase();
                linkInfoBase0.scheme = "";
                this.b.c.invoke(new E2(linkInfoBase0, (this.c.getType() == null ? FeedType.UNKNOWN : this.c.getType()), (this.c.getContsId() == null ? "" : this.c.getContsId())));
                return H.a;
            }
            case 1: {
                e e1 = this.b.c;
                String s2 = "";
                FeedType mainTopNotificationRes$FeedType1 = this.c.getType() == null ? FeedType.UNKNOWN : this.c.getType();
                String s3 = this.c.getContsId();
                if(s3 != null) {
                    s2 = s3;
                }
                e1.invoke(new F2("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c", s2, mainTopNotificationRes$FeedType1));
                return H.a;
            }
            case 2: {
                e e2 = this.b.c;
                LISTFEED mainTopNotificationRes$LISTFEED0 = this.c;
                FeedType mainTopNotificationRes$FeedType2 = mainTopNotificationRes$LISTFEED0.getType();
                if(mainTopNotificationRes$FeedType2 == null) {
                    mainTopNotificationRes$FeedType2 = FeedType.UNKNOWN;
                }
                e2.invoke(new E2(mainTopNotificationRes$LISTFEED0, mainTopNotificationRes$FeedType2, (mainTopNotificationRes$LISTFEED0.getContsId() == null ? "" : mainTopNotificationRes$LISTFEED0.getContsId())));
                return H.a;
            }
            default: {
                e e0 = this.b.c;
                String s = "";
                FeedType mainTopNotificationRes$FeedType0 = this.c.getType() == null ? FeedType.UNKNOWN : this.c.getType();
                String s1 = this.c.getContsId();
                if(s1 != null) {
                    s = s1;
                }
                e0.invoke(new F2("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c", s, mainTopNotificationRes$FeedType0));
                return H.a;
            }
        }
    }
}

