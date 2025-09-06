package yc;

import Pc.e;
import com.melon.ui.I4;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import ie.H;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.k;

public final class a extends n implements k {
    public final int b;

    public a(int v, Object object0, Class class0, String s, String s1, int v1, int v2) {
        this.b = v2;
        super(v, v1, class0, object0, s, s1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.b) {
            case 0: {
                q.g(((e)object0), "p0");
                ((b)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            case 1: {
                q.g(((e)object0), "p0");
                ((b)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            case 2: {
                q.g(((e)object0), "p0");
                ((b)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            case 3: {
                q.g(((e)object0), "p0");
                ((b)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            case 4: {
                q.g(((e)object0), "p0");
                ((b)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            case 5: {
                q.g(((I4)object0), "p0");
                ((E)this.receiver).sendUiEvent(((I4)object0));
                return h0;
            }
            case 6: {
                q.g(((I4)object0), "p0");
                ((E)this.receiver).sendUiEvent(((I4)object0));
                return h0;
            }
            case 7: {
                q.g(((I4)object0), "p0");
                ((E)this.receiver).sendUiEvent(((I4)object0));
                return h0;
            }
            case 8: {
                q.g(((I4)object0), "p0");
                ((E)this.receiver).sendUiEvent(((I4)object0));
                return h0;
            }
            case 9: {
                q.g(((e)object0), "p0");
                ((MelonBottomSheetComposeDialogFragment)this.receiver).sendUserEvent(((e)object0));
                return h0;
            }
            default: {
                ((MelonBottomSheetComposeDialogFragment)this.receiver).m(((Number)object0).intValue());
                return h0;
            }
        }
    }
}

