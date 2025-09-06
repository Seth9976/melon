package dd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import we.a;

public final class j implements a {
    public final int a;
    public final Header b;
    public final k c;

    public j(Header flexibleRes$RESPONSE$Flexible$Header0, k k0, int v) {
        this.a = v;
        this.b = flexibleRes$RESPONSE$Flexible$Header0;
        this.c = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            Header flexibleRes$RESPONSE$Flexible$Header0 = this.b;
            if(flexibleRes$RESPONSE$Flexible$Header0.isLinkable()) {
                MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header0));
                H.o(this.c, "", null, null, null, 0, 1950);
            }
            return ie.H.a;
        }
        Header flexibleRes$RESPONSE$Flexible$Header1 = this.b;
        if(flexibleRes$RESPONSE$Flexible$Header1.isLinkable()) {
            MelonLinkExecutor.open(MelonLinkInfo.b(flexibleRes$RESPONSE$Flexible$Header1));
            H.o(this.c, "", null, null, null, 0, 1950);
        }
        return ie.H.a;
    }
}

