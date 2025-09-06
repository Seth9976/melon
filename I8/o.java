package I8;

import android.content.Context;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.log.DevLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;

public abstract class o {
    public final AtomicBoolean a;

    public o() {
        this.a = new AtomicBoolean(false);
    }

    public static void a(String s) {
        q.g(s, "message");
        DevLog.Companion.get("Local Audio").put(s);
    }

    public abstract void b(Song arg1);

    public final p c(Context context0, List list0) {
        p p0;
        synchronized(this) {
            q.g(context0, "context");
            try {
                this.a.set(true);
                p0 = this.e(context0, list0);
            }
            catch(Throwable throwable0) {
                this.a.set(false);
                throw throwable0;
            }
            this.a.set(false);
            return p0;
        }
    }

    public final p d(Context context0, boolean z) {
        p p0;
        synchronized(this) {
            try {
                this.a.set(true);
                p0 = this.f(context0, z);
            }
            catch(Throwable throwable0) {
                this.a.set(false);
                throw throwable0;
            }
        }
        this.a.set(false);
        return p0;
    }

    public abstract p e(Context arg1, List arg2);

    public abstract p f(Context arg1, boolean arg2);
}

