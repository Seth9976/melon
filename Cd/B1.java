package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT;
import com.melon.ui.K4;
import dd.m;
import kotlin.jvm.internal.q;

public final class b1 implements K4 {
    public final MAGAZINECONTENT a;
    public final m b;

    public b1(MAGAZINECONTENT mainMusicRes$RESPONSE$MAGAZINECONTENT0, m m0) {
        q.g(mainMusicRes$RESPONSE$MAGAZINECONTENT0, "item");
        super();
        this.a = mainMusicRes$RESPONSE$MAGAZINECONTENT0;
        this.b = m0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b1 && q.b(this.a, ((b1)object0).a) && this.b.equals(((b1)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "MagazineListItemUiState(item=" + this.a + ", userEvent=" + this.b + ")";
    }
}

