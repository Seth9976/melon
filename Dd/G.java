package dd;

import bd.s;
import cd.Z;
import com.iloen.melon.net.v5x.response.FlexibleRes.OfferType;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible;
import e.k;
import java.util.ArrayList;
import java.util.List;
import je.q;

public final class g extends H {
    public String g;

    @Override  // dd.H
    public final String d() {
        return this.g;
    }

    public final Z p(Flexible flexibleRes$RESPONSE$Flexible0, int v) {
        OfferType flexibleRes$OfferType0 = flexibleRes$RESPONSE$Flexible0.getOfferType();
        int v1 = flexibleRes$OfferType0 == null ? 0 : flexibleRes$OfferType0.getSetNum();
        Header flexibleRes$RESPONSE$Flexible$Header0 = flexibleRes$RESPONSE$Flexible0.getHeader();
        ArrayList arrayList0 = null;
        String s = flexibleRes$RESPONSE$Flexible$Header0 == null ? null : flexibleRes$RESPONSE$Flexible$Header0.getOfferSeq();
        Header flexibleRes$RESPONSE$Flexible$Header1 = flexibleRes$RESPONSE$Flexible0.getHeader();
        s s1 = flexibleRes$RESPONSE$Flexible$Header1 == null ? null : new s(flexibleRes$RESPONSE$Flexible$Header1, new e(flexibleRes$RESPONSE$Flexible$Header1, flexibleRes$RESPONSE$Flexible0, this, v, 0), new e(flexibleRes$RESPONSE$Flexible$Header1, flexibleRes$RESPONSE$Flexible0, this, v, 1), null, 0x4FE);
        List list0 = flexibleRes$RESPONSE$Flexible0.getContents();
        if(list0 != null) {
            ArrayList arrayList1 = new ArrayList(q.Q(10, list0));
            int v2 = 0;
            for(Object object0: list0) {
                if(v2 >= 0) {
                    arrayList1.add(new e(((Content)object0), false, new f(((Content)object0), this, flexibleRes$RESPONSE$Flexible0, v2, s, v1, v)));
                    ++v2;
                    continue;
                }
                k.O();
                throw null;
            }
            arrayList0 = arrayList1;
        }
        return new Z(s1, arrayList0);
    }
}

