package Nb;

import H0.b;
import androidx.media3.session.d0;
import androidx.media3.session.r;
import com.iloen.melon.utils.image.ImageUtils;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class y extends i implements n {
    public final d0 r;
    public final h0 w;

    public y(h0 h00, d0 d00, Continuation continuation0) {
        this.r = d00;
        this.w = h00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.w, this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ArrayList arrayList0 = b.m(object0);
        q.f("곡", "getString(...)");
        arrayList0.add(f.a("곡", "[PLAY][PLAYLIST]/musicplaylist/", true, false, 13, null, ImageUtils.getResourceUri(0x7F080433), 0x17E0));  // drawable:ic_etc_auto_songlist
        q.f("믹스업", "getString(...)");
        q.g("12", "playlistIdSeq");
        arrayList0.add(f.a("믹스업", "[PLAY][PLAYLIST]/12/", true, false, 13, null, ImageUtils.getResourceUri(0x7F080432), 0x17E0));  // drawable:ic_etc_auto_mixup
        return r.c(arrayList0, this.r);
    }
}

