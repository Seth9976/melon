package dd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import we.a;

public final class q implements a {
    public final int a;
    public final Header b;
    public final r c;

    public q(Header flexibleRes$RESPONSE$Flexible$Header0, r r0, int v) {
        this.a = v;
        this.b = flexibleRes$RESPONSE$Flexible$Header0;
        this.c = r0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            MelonLinkExecutor.open(MelonLinkInfo.b(this.b));
            H.o(this.c, "", null, null, null, 0, 1950);
            return ie.H.a;
        }
        Header flexibleRes$RESPONSE$Flexible$Header0 = this.b;
        if(flexibleRes$RESPONSE$Flexible$Header0.isLinkable()) {
            MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header0));
            H.o(this.c, "", null, null, null, 0, 1950);
        }
        return ie.H.a;
    }
}

