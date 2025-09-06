package cd;

import Vb.p0;
import com.iloen.melon.net.v6x.response.BannerRes;
import com.melon.ui.K4;

public final class u2 implements K4 {
    public final BannerRes a;
    public final p0 b;

    public u2(BannerRes bannerRes0, p0 p00) {
        this.a = bannerRes0;
        this.b = p00;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof u2 && this.a.equals(((u2)object0).a) && this.b.equals(((u2)object0).b);
    }

    @Override
    public final int hashCode() {
        return (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "TopBannerSlotUiState(data=" + this.a + ", userEvent=" + this.b + ", extra=null)";
    }
}

