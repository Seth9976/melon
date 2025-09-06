package Z8;

import U4.x;
import com.gaa.sdk.iap.l;
import kotlin.jvm.internal.q;

public final class h {
    public final l a;
    public final String b;
    public final String c;

    public h(l l0, String s, String s1) {
        this.a = l0;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        if(!q.b(this.a, ((h)object0).a)) {
            return false;
        }
        return q.b(this.b, ((h)object0).b) ? q.b(this.c, ((h)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OneStoreIapPurchaseFlowInfo(purchaseFlowParams=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", actionUrl=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", returnData=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

