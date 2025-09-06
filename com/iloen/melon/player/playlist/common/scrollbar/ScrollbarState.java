package com.iloen.melon.player.playlist.common.scrollbar;

import androidx.compose.runtime.M0;
import androidx.compose.runtime.w;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\r\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u000F\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0011\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "", "<init>", "()V", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarStateValue;", "stateValue", "Lie/H;", "onScroll-L0Nbrkk$app_playstoreProdRelease", "(J)V", "onScroll", "", "getThumbSizePercent", "()F", "thumbSizePercent", "getThumbMovedPercent", "thumbMovedPercent", "getThumbTrackSizePercent", "thumbTrackSizePercent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ScrollbarState {
    public static final int $stable;
    public final M0 a;

    public ScrollbarState() {
        this.a = w.q(0L);
    }

    public final float getThumbMovedPercent() {
        return Float.intBitsToFloat(((int)(this.a.m() & 0xFFFFFFFFL)));
    }

    public final float getThumbSizePercent() {
        return Float.intBitsToFloat(((int)(this.a.m() >> 0x20)));
    }

    public final float getThumbTrackSizePercent() {
        return 1.0f - this.getThumbSizePercent();
    }

    public final void onScroll-L0Nbrkk$app_playstoreProdRelease(long v) {
        this.a.n(v);
    }
}

