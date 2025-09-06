package com.melon.playback.melon.analytics;

import Nb.z0;
import Wb.c;
import Wb.g;
import ac.w;
import android.content.Context;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001:\u0001\u0006B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/melon/playback/melon/analytics/AnalyticsTask;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Wb/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class AnalyticsTask {
    public final Context a;
    public final LogU b;
    public final g c;

    public AnalyticsTask(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = Companion.create$default(LogU.Companion, "AnalyticsTask", false, Category.Analytics, 2, null);
        this.c = new g();
    }

    public static long a(long v) {
        if(Long.compare(v, c.a) >= 0) {
            return 60000L;
        }
        return v <= c.b ? 1L : v - 3000L;
    }

    public abstract long b(w arg1, long arg2);

    public abstract void c(w arg1, z0 arg2);

    public abstract boolean d(w arg1);
}

