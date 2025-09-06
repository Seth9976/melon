package Y4;

import U4.k;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

public final class c {
    public final ComponentName a;
    public final k b;
    public final boolean c;
    public static final String d;

    static {
        c.d = "WM-SystemJobInfoConvert";
    }

    public c(Context context0, k k0, boolean z) {
        this.b = k0;
        this.a = new ComponentName(context0.getApplicationContext(), SystemJobService.class);
        this.c = z;
    }
}

