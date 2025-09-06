package com.iloen.melon.custom;

import com.iloen.melon.player.video.VideoViewModel;
import com.melon.playlist.interfaces.PlayableData;
import kotlin.jvm.internal.q;

public final class x1 {
    public final PlayableData a;
    public final VideoViewModel b;

    public x1(PlayableData playableData0, VideoViewModel videoViewModel0) {
        q.g(videoViewModel0, "viewModel");
        super();
        this.a = playableData0;
        this.b = videoViewModel0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof x1 && q.b(this.a, ((x1)object0).a) && q.b(this.b, ((x1)object0).b);
    }

    // 去混淆评级： 低(20)
    @Override
    public final int hashCode() {
        return this.a == null ? 6000 + this.b.hashCode() * 0x1F : 6000 + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "EndingViewItem(nextPlayableData=" + this.a + ", viewModel=" + this.b + ", count=6000)";
    }
}

