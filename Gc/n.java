package gc;

import Nb.z0;
import Vb.o0;
import androidx.appcompat.app.o;
import androidx.media3.common.d;
import b3.i0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlayback.SeekComplete;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import we.k;

public final class n implements k {
    public final int a;
    public final y b;

    public n(y y0, int v) {
        this.a = v;
        this.b = y0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            Throwable throwable0 = (Throwable)object0;
            this.b.o = null;
            return H.a;
        }
        q.g(((E)object0), "player");
        y y0 = this.b;
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)y0.m.getValue();
        do {
            Object object1 = mutableStateFlow0.getValue();
            d d0 = ((i0)object1).a();
            d0.d = 3;
            d0.B = ((E)object0).e.b1();
        }
        while(!o.B(d0, mutableStateFlow0, object1));
        y0.v0();
        z0 z00 = y0.n.e.a1();
        q.g(z00, "playerType");
        LogU.info$default(((o0)y0).e1(), "onSeekCompletedMediaItem() " + z00.a(), null, false, 6, null);
        long v = ((o0)y0).getCurrentPosition();
        EpPlayLogger.INSTANCE.seek(v);
        long v1 = ((o0)y0).getCurrentPosition();
        ((o0)y0).B.c(v1);
        EventBusHelper.post(new SeekComplete());
        return H.a;
    }
}

