package cd;

import C8.e;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE;
import ie.H;
import we.a;

public final class z2 implements a {
    public final int a;
    public final B2 b;
    public final NOTICE c;

    public z2(B2 b20, NOTICE mainTopNotificationRes$NOTICE0, int v) {
        this.a = v;
        this.b = b20;
        this.c = mainTopNotificationRes$NOTICE0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            e e0 = this.b.c;
            NOTICE mainTopNotificationRes$NOTICE0 = this.c;
            String s = mainTopNotificationRes$NOTICE0.getOfferSeq();
            String s1 = "";
            if(s == null) {
                s = "";
            }
            FeedType mainTopNotificationRes$FeedType0 = FeedType.NOTICE;
            String s2 = mainTopNotificationRes$NOTICE0.getOfferSeq();
            if(s2 != null) {
                s1 = s2;
            }
            e0.invoke(new F2(s, s1, mainTopNotificationRes$FeedType0));
            return H.a;
        }
        e e1 = this.b.c;
        FeedType mainTopNotificationRes$FeedType1 = FeedType.NOTICE;
        NOTICE mainTopNotificationRes$NOTICE1 = this.c;
        String s3 = mainTopNotificationRes$NOTICE1.getOfferSeq();
        if(s3 == null) {
            s3 = "";
        }
        e1.invoke(new E2(mainTopNotificationRes$NOTICE1, mainTopNotificationRes$FeedType1, s3));
        return H.a;
    }
}

