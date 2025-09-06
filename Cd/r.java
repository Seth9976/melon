package cd;

import Cc.M;
import Vb.p0;
import Vc.B;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART;
import com.melon.ui.K4;

public final class r implements K4 {
    public final M a;
    public final MELONCHART b;
    public final B c;
    public final p0 d;

    public r(M m0, MELONCHART mainMusicRes$RESPONSE$MELONCHART0, B b0, p0 p00) {
        this.a = m0;
        this.b = mainMusicRes$RESPONSE$MELONCHART0;
        this.c = b0;
        this.d = p00;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof r && this.a.equals(((r)object0).a) && this.b.equals(((r)object0).b) && this.c.equals(((r)object0).c) && this.d.equals(((r)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ChartSlotUiState(headerUiState=" + this.a + ", item=" + this.b + ", chartUserEvent=" + this.c + ", chartItemUserEvent=" + this.d + ")";
    }
}

