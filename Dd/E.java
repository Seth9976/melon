package dd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import we.a;

public final class e implements a {
    public final int a;
    public final Header b;
    public final Flexible c;
    public final g d;
    public final int e;

    public e(Header flexibleRes$RESPONSE$Flexible$Header0, Flexible flexibleRes$RESPONSE$Flexible0, g g0, int v, int v1) {
        this.a = v1;
        this.b = flexibleRes$RESPONSE$Flexible$Header0;
        this.c = flexibleRes$RESPONSE$Flexible0;
        this.d = g0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            MelonLinkExecutor.open(MelonLinkInfo.b(this.b));
            Flexible flexibleRes$RESPONSE$Flexible0 = this.c;
            String s = flexibleRes$RESPONSE$Flexible0.getSlotId();
            if(s == null) {
                s = "";
            }
            H.o(this.d, "", null, s, flexibleRes$RESPONSE$Flexible0.getStatsElements(), this.e, 0x9E);
            return ie.H.a;
        }
        Header flexibleRes$RESPONSE$Flexible$Header0 = this.b;
        if(flexibleRes$RESPONSE$Flexible$Header0.isLinkable()) {
            MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header0));
            Flexible flexibleRes$RESPONSE$Flexible1 = this.c;
            String s1 = flexibleRes$RESPONSE$Flexible1.getSlotId();
            if(s1 == null) {
                s1 = "";
            }
            H.o(this.d, "", null, s1, flexibleRes$RESPONSE$Flexible1.getStatsElements(), this.e, 0x9E);
        }
        return ie.H.a;
    }
}

