package Dd;

import com.melon.ui.K4;
import java.util.List;
import kotlin.jvm.internal.q;

public final class p1 implements K4 {
    public final List a;

    public p1(List list0) {
        q.g(list0, "artistList");
        super();
        this.a = list0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p1 && q.b(this.a, ((p1)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ArtistItemUiState(artistList=" + this.a + ", action=null)";
    }
}

