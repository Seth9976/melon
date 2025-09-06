package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAGCONTENTS;
import com.melon.ui.K4;
import dd.m;
import kotlin.jvm.internal.q;

public final class d2 implements K4 {
    public final TAGCONTENTS a;
    public final m b;

    public d2(TAGCONTENTS mainMusicRes$RESPONSE$TAGCONTENTS0, m m0) {
        q.g(mainMusicRes$RESPONSE$TAGCONTENTS0, "item");
        super();
        this.a = mainMusicRes$RESPONSE$TAGCONTENTS0;
        this.b = m0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d2 && q.b(this.a, ((d2)object0).a) && this.b.equals(((d2)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "TagItemUiState(item=" + this.a + ", userEvent=" + this.b + ")";
    }
}

