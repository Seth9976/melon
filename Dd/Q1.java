package Dd;

import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v6x.response.DjBrandInformProfileRes.RESPONSE.BANNERLIST.SUBCONTENTLIST;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class q1 implements K4 {
    public final BannerBase a;
    public final String b;

    public q1(SUBCONTENTLIST djBrandInformProfileRes$RESPONSE$BANNERLIST$SUBCONTENTLIST0, String s) {
        this.a = djBrandInformProfileRes$RESPONSE$BANNERLIST$SUBCONTENTLIST0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q1)) {
            return false;
        }
        return q.b(this.a, ((q1)object0).a) ? q.b(this.b, ((q1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "BannerItemUiState(banner=" + this.a + ", playTime=" + this.b + ")";
    }
}

