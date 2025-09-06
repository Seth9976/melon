package dd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import we.a;

public final class x implements a {
    public final int a;
    public final Header b;
    public final y c;

    public x(Header flexibleRes$RESPONSE$Flexible$Header0, y y0, int v) {
        this.a = v;
        this.b = flexibleRes$RESPONSE$Flexible$Header0;
        this.c = y0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                Header flexibleRes$RESPONSE$Flexible$Header0 = this.b;
                if(flexibleRes$RESPONSE$Flexible$Header0.isLinkable()) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header0));
                    H.o(this.c, "", null, null, null, 0, 1950);
                }
                return ie.H.a;
            }
            case 1: {
                Header flexibleRes$RESPONSE$Flexible$Header1 = this.b;
                if(flexibleRes$RESPONSE$Flexible$Header1.isLinkable()) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header1));
                    H.o(this.c, "", null, null, null, 0, 1950);
                }
                return ie.H.a;
            }
            default: {
                MelonLinkExecutor.open(MelonLinkInfo.b(this.b));
                this.c.n(this.b);
                return ie.H.a;
            }
        }
    }
}

