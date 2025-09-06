package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import kotlin.jvm.internal.q;

public final class t implements y {
    public final ChartHeader a;
    public final int b;

    public t(ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0, int v) {
        this.a = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        return q.b(this.a, ((t)object0).a) ? this.b == ((t)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b : this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnPlayAllClick(header=" + this.a + ", index=" + this.b + ")";
    }
}

