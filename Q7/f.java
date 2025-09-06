package Q7;

import M7.b;
import android.net.Uri.Builder;
import java.net.URL;
import kotlin.jvm.internal.q;
import me.i;

public final class f {
    public final b a;
    public final i b;

    public f(b b0, i i0) {
        q.g(b0, "appInfo");
        q.g(i0, "blockingDispatcher");
        super();
        this.a = b0;
        this.b = i0;
    }

    public static final URL a(f f0) {
        f0.getClass();
        return new URL(new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(f0.a.a).appendPath("settings").appendQueryParameter("build_version", f0.a.b.c).appendQueryParameter("display_version", f0.a.b.b).build().toString());
    }
}

