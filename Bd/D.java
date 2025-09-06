package bd;

import android.net.Uri;
import com.iloen.melon.player.trackzero.SinglePlayer;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class d extends i implements n {
    public final String B;
    public final long D;
    public final SinglePlayer r;
    public final String w;

    public d(SinglePlayer singlePlayer0, String s, String s1, long v, Continuation continuation0) {
        this.r = singlePlayer0;
        this.w = s;
        this.B = s1;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        SinglePlayer singlePlayer0 = this.r;
        String s = this.w;
        String s1 = this.B;
        if(s == null) {
            Uri uri1 = Uri.parse(s1);
            q.f(uri1, "parse(...)");
            singlePlayer0.setDataSource(uri1, true);
        }
        else {
            Uri uri0 = Uri.parse(s1);
            q.f(uri0, "parse(...)");
            singlePlayer0.setDataSourceWithCustomCacheKey(uri0, true, s);
        }
        singlePlayer0.setVolume(0.0f);
        singlePlayer0.seekTo(this.D);
        return H.a;
    }
}

