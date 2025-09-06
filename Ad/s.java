package ad;

import com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner;

public final class s extends w {
    public final CommerceBanner a;
    public final N b;

    public s(CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0, N n0) {
        this.a = musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0;
        this.b = n0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s && this.a.equals(((s)object0).a) && this.b.equals(((s)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "CashFriendsBannerItem(banner=" + this.a + ", userEvent=" + this.b + ")";
    }
}

