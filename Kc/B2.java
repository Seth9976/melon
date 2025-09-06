package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class b2 extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b2(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        int v = MelonPrefs.getInstance().getInt("PLAYLIST_ID", PlaylistId.TEMP.getSeq());
        return PlaylistId.Companion.makePlaylistId(v);
    }
}

