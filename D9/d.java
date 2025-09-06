package d9;

import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.player.SongMetaParser;
import ie.H;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public final String B;
    public final String D;
    public final h E;
    public int r;
    public final Playable w;

    public d(Playable playable0, String s, String s1, h h0, Continuation continuation0) {
        this.w = playable0;
        this.B = s;
        this.D = s1;
        this.E = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Playable playable0 = this.w;
                File file0 = SongMetaParser.getLyricFile(playable0);
                if(file0 != null && !file0.exists() && NetUtils.isConnected()) {
                    String s = StorageUtils.isScopedStorage() ? SongMetaParser.parseLyricCodeFromUri(Uri.parse(this.B)) : SongMetaParser.parseLyricCodeFromFile(this.D);
                    if(s != null && s.length() != 0) {
                        this.E.f(playable0, true);
                        return h0;
                    }
                    c c0 = new c(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    this.r = 1;
                    if(BuildersKt.withContext(Dispatchers.getMain(), c0, this) == a0) {
                        return a0;
                    }
                }
                return h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

