package td;

import com.iloen.melon.playback.Playable;
import com.melon.ui.I4;

public final class o0 implements I4 {
    public final Playable a;
    public final boolean b;

    public o0(Playable playable0, boolean z) {
        this.a = playable0;
        this.b = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof o0 && this.a.equals(((o0)object0).a) && this.b == ((o0)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShowContextMenuAddToPopup(playable=" + this.a + ", isNowPlaying=" + this.b + ")";
    }
}

