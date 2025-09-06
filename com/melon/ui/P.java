package com.melon.ui;

import A7.d;
import com.iloen.melon.playback.Playable;

public final class p implements f {
    public final Playable a;
    public boolean b;

    public p(Playable playable0) {
        this.a = playable0;
        this.b = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.b = true;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && this.a.equals(((p)object0).a) && this.b == ((p)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + d.e(d.e(this.a.hashCode() * 0x1F, 0x1F, false), 0x1F, true);
    }

    @Override
    public final String toString() {
        return "PlayVideoPlayable(playable=" + this.a + ", isFullscreen=false, openPlayer=true, isAllowBanContent=" + this.b + ")";
    }
}

