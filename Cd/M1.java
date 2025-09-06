package cd;

import Hd.F0;
import com.melon.net.res.MainMusicMiddleBannerRes;
import com.melon.ui.K4;

public final class m1 implements K4 {
    public final MainMusicMiddleBannerRes a;
    public final F0 b;

    public m1(MainMusicMiddleBannerRes mainMusicMiddleBannerRes0, F0 f00) {
        this.a = mainMusicMiddleBannerRes0;
        this.b = f00;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof m1 && this.a.equals(((m1)object0).a) && this.b.equals(((m1)object0).b);
    }

    @Override
    public final int hashCode() {
        return (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "MiddleBannerSlotUiState(data=" + this.a + ", userEvent=" + this.b + ", extra=null)";
    }
}

