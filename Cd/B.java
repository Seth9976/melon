package cd;

import A7.d;
import U4.x;
import Vb.p0;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class b implements K4 {
    public final CONTENTS a;
    public final ChartHeader b;
    public final int c;
    public final int d;
    public final p0 e;

    public b(CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0, int v, int v1, p0 p00) {
        q.g(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, "item");
        super();
        this.a = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0;
        this.b = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0;
        this.c = v;
        this.d = v1;
        this.e = p00;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b && q.b(this.a, ((b)object0).a) && q.b(this.b, ((b)object0).b) && this.c == ((b)object0).c && this.d == ((b)object0).d && this.e.equals(((b)object0).e);
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.e.hashCode() + d.b(this.d, d.b(this.c, v * 961, 0x1F), 0x1F) : this.e.hashCode() + d.b(this.d, d.b(this.c, (v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ChartItemUiState(item=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", chartHeader=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", chartIndex=");
        x.x(stringBuilder0, this.c, ", contentsIndex=", this.d, ", userEvent=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

