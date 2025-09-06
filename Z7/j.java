package z7;

import A7.b;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import w7.d;

public final class j {
    public final d a;
    public static final long b;
    public static final Pattern c;
    public static j d;

    static {
        j.b = TimeUnit.HOURS.toSeconds(1L);
        j.c = Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    public j(d d0) {
        this.a = d0;
    }

    public final boolean a(b b0) {
        if(!TextUtils.isEmpty(b0.c)) {
            TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
            this.a.getClass();
            long v = timeUnit0.toSeconds(System.currentTimeMillis());
            return b0.f + b0.e < v + j.b;
        }
        return true;
    }
}

