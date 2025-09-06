import A7.d;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;
import we.k;

public final class e implements K4 {
    public final Content a;
    public final boolean b;
    public final k c;

    public e(Content flexibleRes$RESPONSE$Flexible$Content0, boolean z, k k0) {
        q.g(flexibleRes$RESPONSE$Flexible$Content0, "item");
        super();
        this.a = flexibleRes$RESPONSE$Flexible$Content0;
        this.b = z;
        this.c = k0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e && q.b(this.a, ((e)object0).a) && this.b == ((e)object0).b && q.b(this.c, ((e)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "FlexibleListItemUiState(item=" + this.a + ", useInnerTitle=" + this.b + ", userEvent=" + this.c + ")";
    }
}

