package k9;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.a;
import u9.f;

public abstract class d {
    public static final String a;
    public static final String b;

    static {
        StringBuilder stringBuilder0 = new StringBuilder();
        Context context0 = MelonAppBase.instance.getContext();
        d.a = a.k(0, f.g.b(context0, "offline").f, stringBuilder0);
        StringBuilder stringBuilder1 = new StringBuilder();
        Context context1 = MelonAppBase.instance.getContext();
        d.b = a.k(1, f.g.b(context1, "offline").f, stringBuilder1);
    }
}

