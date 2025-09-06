package k8;

import com.iloen.melon.MelonAppBase;
import kotlin.jvm.internal.q;

public final class t {
    public static MelonAppBase a() {
        MelonAppBase melonAppBase0 = MelonAppBase.instance;
        if(melonAppBase0 != null) {
            return melonAppBase0;
        }
        q.m("instance");
        throw null;
    }
}

