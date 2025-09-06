package dd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import ie.H;
import we.a;

public final class s implements a {
    public final int a;
    public final Header b;
    public final t c;

    public s(Header flexibleRes$RESPONSE$Flexible$Header0, t t0, int v) {
        this.a = v;
        this.b = flexibleRes$RESPONSE$Flexible$Header0;
        this.c = t0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            Header flexibleRes$RESPONSE$Flexible$Header0 = this.b;
            if(flexibleRes$RESPONSE$Flexible$Header0.isLinkable()) {
                MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header0));
                this.c.n(flexibleRes$RESPONSE$Flexible$Header0);
            }
            return H.a;
        }
        Header flexibleRes$RESPONSE$Flexible$Header1 = this.b;
        if(flexibleRes$RESPONSE$Flexible$Header1.isLinkable()) {
            MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header1));
            dd.H.o(this.c, "", null, null, null, 0, 1950);
        }
        return H.a;
    }
}

