package td;

import J8.h1;
import android.graphics.Point;
import androidx.lifecycle.s;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.utils.ui.h;
import com.melon.ui.n0;
import com.melon.ui.playermusic.PlayerMoreView;
import com.melon.ui.playermusic.PlayerViewCalculator;
import ie.H;
import ie.r;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import oe.i;
import we.n;

public final class A extends i implements n {
    public final C B;
    public final h1 D;
    public boolean r;
    public final b0 w;

    public A(b0 b00, C c0, h1 h10, Continuation continuation0) {
        this.w = b00;
        this.B = c0;
        this.D = h10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new A(this.w, this.B, this.D, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((A)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        h1 h10 = this.D;
        PlayerMoreView playerMoreView0 = h10.e;
        boolean z = this.r;
        d5.n.D(object0);
        b0 b00 = this.w;
        r r0 = b00.l;
        Object object1 = ((t1)b00.getViewModel()).getUiState().getValue();
        p0 p00 = object1 instanceof p0 ? ((p0)object1) : null;
        boolean z1 = true;
        boolean z2 = !b00.m && !this.B.a;
        boolean z3 = this.B.a;
        this.B.a = false;
        if(z) {
            if(((Boolean)((t1)b00.getViewModel()).E.getValue()).booleanValue() || p00 == null || p00.j || ((PlayerViewCalculator)r0.getValue()).b(((Point)b00.k.getValue())) <= 0) {
                z1 = false;
            }
            h10.c.setVisibility(4);
            h10.d.setVisibility(4);
            Playable playable0 = ((t1)b00.getViewModel()).getCurrentPlayable();
            playerMoreView0.j((playable0 == null ? null : PlayableExtensionsKt.copyAndUpdatedWhenLocal(playable0)), z1);
        }
        else {
            boolean z4 = ((t1)b00.getViewModel()).h();
            if(!z4 || p00 == null || p00.j || ((PlayerViewCalculator)r0.getValue()).b(((Point)b00.k.getValue())) <= 0) {
                z1 = false;
            }
            playerMoreView0.h(z2, z1, new h(b00, h10, z4));
        }
        if(!z3 && b00.getLifecycle().b().compareTo(s.d) >= 0) {
            t1 t10 = (t1)b00.getViewModel();
            n0.performPvDummyLogging$default(t10, t10.e(), null, 2, null);
        }
        return H.a;
    }
}

