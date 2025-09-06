package cd;

import bd.s;
import com.melon.ui.K4;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class m0 implements K4 {
    public final s a;
    public final ArrayList b;

    public m0(s s0, ArrayList arrayList0) {
        this.a = s0;
        this.b = arrayList0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof m0 && q.b(this.a, ((m0)object0).a) && this.b.equals(((m0)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "FlexibleMusicWaveSlotUiState(headerUiState=" + this.a + ", items=" + this.b + ")";
    }
}

