package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER;
import kotlin.jvm.internal.q;

public final class d implements g {
    public final b a;
    public final HEADER b;

    public d(b b0, HEADER mainMusicRes$RESPONSE$HEADER0) {
        q.g(b0, "chartItemUiState");
        super();
        this.a = b0;
        this.b = mainMusicRes$RESPONSE$HEADER0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemClick(chartItemUiState=" + this.a + ", header=" + this.b + ")";
    }
}

