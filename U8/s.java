package U8;

import Cc.U3;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.player.video.VideoInfoViewModel.WrappedData;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.K4;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class s implements k {
    public final int a;
    public final boolean b;
    public final int c;

    public s(w w0, int v, boolean z) {
        this.a = 0;
        super();
        this.c = v;
        this.b = z;
    }

    public s(boolean z, int v, int v1) {
        this.a = v1;
        this.b = z;
        this.c = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        int v = this.c;
        boolean z = this.b;
        switch(this.a) {
            case 0: {
                q.g(((K4)object0), "it");
                r r0 = null;
                r r1 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r1 != null) {
                    r0 = r.a(r1, false, 0, false, 0, null, U3.a(((r)(((K4)object0))).j, (v == 6 ? 0x3F3 : 1010), z, 0, 28), 0x1FF);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 1: {
                q.g(((Context)object0), "it");
                CoverView coverView0 = new CoverView(((Context)object0), (z ? 144.0f : 58.0f));
                RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = (RelativeLayout.LayoutParams)coverView0.g.getLayoutParams();
                int v1 = ScreenUtils.dipToPixel(coverView0.getContext(), ((float)v));
                int v2 = coverView0.b == 0.0f ? v1 : ScreenUtils.dipToPixel(coverView0.getContext(), coverView0.b);
                relativeLayout$LayoutParams0.width = v1;
                relativeLayout$LayoutParams0.height = v2;
                coverView0.c();
                coverView0.b(z);
                return coverView0;
            }
            default: {
                q.g(((WrappedData)object0), "data");
                ((WrappedData)object0).setLike(z);
                ((WrappedData)object0).setSumCount(String.valueOf(v));
                return H.a;
            }
        }
    }
}

