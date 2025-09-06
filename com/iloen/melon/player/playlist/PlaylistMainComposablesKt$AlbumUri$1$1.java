package com.iloen.melon.player.playlist;

import Cc.n3;
import android.content.Context;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.PlaylistMainComposablesKt$AlbumUri$1$1", f = "PlaylistMainComposables.kt", l = {}, m = "invokeSuspend")
final class PlaylistMainComposablesKt.AlbumUri.1.1 extends i implements n {
    public final String B;
    public final n3 r;
    public final Context w;

    public PlaylistMainComposablesKt.AlbumUri.1.1(n3 n30, Context context0, String s, Continuation continuation0) {
        this.r = n30;
        this.w = context0;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new PlaylistMainComposablesKt.AlbumUri.1.1(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((PlaylistMainComposablesKt.AlbumUri.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        this.r.a(this.w, this.B);
        return H.a;
    }
}

