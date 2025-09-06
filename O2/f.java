package o2;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class f {
    public final SharedPreferences a;
    public final Set b;

    public f(SharedPreferences sharedPreferences0, Set set0) {
        q.g(sharedPreferences0, "prefs");
        super();
        this.a = sharedPreferences0;
        this.b = set0;
    }

    public final void a(String s) {
        if(this.b != null && !this.b.contains(s)) {
            throw new IllegalStateException(("Can\'t access key outside migration: " + s).toString());
        }
    }
}

