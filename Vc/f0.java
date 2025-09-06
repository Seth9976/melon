package Vc;

import com.google.android.exoplayer2.ExoPlaybackException;
import kotlin.jvm.internal.q;

public final class f0 implements g0 {
    public final ExoPlaybackException a;

    public f0(ExoPlaybackException exoPlaybackException0) {
        q.g(exoPlaybackException0, "error");
        super();
        this.a = exoPlaybackException0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f0 ? q.b(this.a, ((f0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnPlayerError(error=" + this.a + ")";
    }
}

