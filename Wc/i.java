package wc;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class i extends c {
    public H B;
    public L0 D;
    public String E;
    public Deferred G;
    public Deferred I;
    public Deferred M;
    public AlbumSongListRes N;
    public AlbumContentsListRes S;
    public PromotionContentsBannerRes T;
    public w V;
    public int W;
    public int X;
    public Object Y;
    public final w Z;
    public int b0;
    public w r;
    public H w;

    public i(w w0, c c0) {
        this.Z = w0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Y = object0;
        this.b0 |= 0x80000000;
        return w.w(this.Z, null, this);
    }
}

