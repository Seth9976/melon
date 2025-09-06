package cd;

import Oc.m;
import bd.s;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class j0 implements K4 {
    public final s a;
    public final Content b;
    public final m c;

    public j0(s s0, Content flexibleRes$RESPONSE$Flexible$Content0, m m0) {
        this.a = s0;
        this.b = flexibleRes$RESPONSE$Flexible$Content0;
        this.c = m0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j0 && q.b(this.a, ((j0)object0).a) && this.b.equals(((j0)object0).b) && this.c.equals(((j0)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.c.hashCode() + this.b.hashCode() * 0x1F : this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "FlexibleMusicWaveSingleSlotUiState(headerUiState=" + this.a + ", item=" + this.b + ", userEvent=" + this.c + ")";
    }
}

