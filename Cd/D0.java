package cd;

import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.melon.ui.K4;
import dd.m;
import kotlin.jvm.internal.q;

public final class d0 implements K4 {
    public final Content a;
    public final m b;

    public d0(Content flexibleRes$RESPONSE$Flexible$Content0, m m0) {
        q.g(flexibleRes$RESPONSE$Flexible$Content0, "item");
        super();
        this.a = flexibleRes$RESPONSE$Flexible$Content0;
        this.b = m0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d0 && q.b(this.a, ((d0)object0).a) && this.b.equals(((d0)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "FlexibleMusicWaveItemUiState(item=" + this.a + ", userEvent=" + this.b + ")";
    }
}

