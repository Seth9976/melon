package rd;

import android.content.Context;
import android.os.Bundle;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class g0 implements a {
    public final int a;
    public final i0 b;

    public g0(i0 i00, int v) {
        this.a = v;
        this.b = i00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                Context context0 = this.b.requireContext();
                q.f(context0, "requireContext(...)");
                return new DjMalrangPlayerViewCalculator(context0);
            }
            case 1: {
                return ((DjMalrangPlayerViewCalculator)this.b.i.getValue()).b();
            }
            case 2: {
                this.b.getParentFragmentManager().i0(new Bundle(), "artist_click_malrang_pager");
                return H.a;
            }
            default: {
                this.b.getParentFragmentManager().i0(new Bundle(), "like_malrang_pager");
                return H.a;
            }
        }
    }
}

