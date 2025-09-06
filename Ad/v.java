package ad;

import com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner;
import kotlin.jvm.internal.q;
import we.k;

public final class v extends w {
    public final CommerceBanner a;
    public final k b;

    public v(CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0, k k0) {
        this.a = musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0;
        this.b = k0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        return q.b(this.a, ((v)object0).a) ? q.b(this.b, ((v)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        k k0 = this.b;
        if(k0 != null) {
            v = k0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "PurchaseButtonItem(banner=" + this.a + ", userEvent=" + this.b + ")";
    }
}

