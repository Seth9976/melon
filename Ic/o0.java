package Ic;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class o0 extends c {
    public L0 B;
    public String D;
    public Deferred E;
    public Deferred G;
    public Deferred I;
    public AlbumSongListRes M;
    public AlbumContentsListRes N;
    public PromotionContentsBannerRes S;
    public A0 T;
    public int V;
    public int W;
    public Object X;
    public final A0 Y;
    public int Z;
    public H r;
    public H w;

    public o0(A0 a00, c c0) {
        this.Y = a00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.onFetchStart(null, this);
    }
}

