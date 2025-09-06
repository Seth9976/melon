package coil.memory;

import P1.c;
import android.app.ActivityManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coil/memory/MemoryCache$Builder", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class MemoryCache.Builder {
    public final Context a;
    public final double b;
    public final boolean c;
    public final boolean d;

    public MemoryCache.Builder(@NotNull Context context0) {
        this.a = context0;
        double f = 0.2;
        try {
            Object object0 = c.getSystemService(context0, ActivityManager.class);
            q.d(object0);
            if(((ActivityManager)object0).isLowRamDevice()) {
                f = 0.15;
            }
        }
        catch(Exception unused_ex) {
        }
        this.b = f;
        this.c = true;
        this.d = true;
    }
}

