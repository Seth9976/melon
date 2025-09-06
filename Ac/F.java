package ac;

import H0.e;
import com.iloen.melon.drm.MelonFile;
import kotlin.jvm.internal.q;

public final class f extends e {
    public final MelonFile e;

    public f(MelonFile melonFile0) {
        this.e = melonFile0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.e, ((f)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e == null ? 0 : this.e.hashCode();
    }

    @Override
    public final String toString() {
        return "Local(file=" + this.e + ")";
    }
}

