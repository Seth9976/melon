package k8;

import android.view.Window;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.player.video.d0;
import com.iloen.melon.utils.log.LogConstantsKt;
import ie.H;
import ie.m;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class j1 extends i implements n {
    public final Window B;
    public Object r;
    public final MusicBrowserActivity w;

    public j1(MusicBrowserActivity musicBrowserActivity0, Window window0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = window0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j1(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j1)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m0 = (m)this.r;
        d5.n.D(object0);
        boolean z = ((Boolean)m0.a).booleanValue();
        boolean z1 = ((Boolean)m0.b).booleanValue();
        d0 d00 = new d0(z, z1, 1);
        LogConstantsKt.buildDebug(this.w.log, true, d00);
        Window window0 = this.B;
        if(z && z1) {
            window0.addFlags(0x80);
            return H.a;
        }
        window0.clearFlags(0x80);
        return H.a;
    }
}

