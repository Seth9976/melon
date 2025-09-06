package V4;

import B4.a;
import android.content.Context;
import kotlin.jvm.internal.q;

public final class g extends a {
    public final Context a;

    public g(Context context0, int v, int v1) {
        super(v, v1);
        this.a = context0;
    }

    @Override  // B4.a
    public final void migrate(H4.a a0) {
        q.g(a0, "db");
        if(this.endVersion >= 10) {
            a0.L(new Object[]{"reschedule_needed", 1});
            return;
        }
        this.a.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
    }
}

