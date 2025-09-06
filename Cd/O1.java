package cd;

import com.melon.net.res.MainMusicMiddleBannerRes.Response.Banner;
import kotlin.jvm.internal.q;

public final class o1 implements p1 {
    public final Banner a;

    public o1(Banner mainMusicMiddleBannerRes$Response$Banner0) {
        this.a = mainMusicMiddleBannerRes$Response$Banner0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof o1 ? q.b(this.a, ((o1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnComponentShown(banner=" + this.a + ")";
    }
}

