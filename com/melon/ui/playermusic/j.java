package com.melon.ui.playermusic;

import android.net.Uri;
import androidx.compose.runtime.b0;
import com.iloen.melon.player.trackzero.SinglePlayer;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.n;

public final class j extends i implements n {
    public final b0 B;
    public final a D;
    public final SpecialVideo E;
    public final b0 r;
    public final SinglePlayer w;

    public j(b0 b00, SinglePlayer singlePlayer0, b0 b01, a a0, SpecialVideo bgType$SpecialVideo0, Continuation continuation0) {
        this.r = b00;
        this.w = singlePlayer0;
        this.B = b01;
        this.D = a0;
        this.E = bgType$SpecialVideo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.r, this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.setValue(Boolean.FALSE);
        SinglePlayer singlePlayer0 = this.w;
        singlePlayer0.stop(true);
        Object object1 = this.D.invoke();
        this.B.setValue(object1);
        if(((Boolean)this.B.getValue()).booleanValue()) {
            Uri uri0 = Uri.parse(this.E.c);
            q.f(uri0, "parse(...)");
            singlePlayer0.setDataSource(uri0, true);
        }
        return H.a;
    }
}

