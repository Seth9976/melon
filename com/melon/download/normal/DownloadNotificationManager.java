package com.melon.download.normal;

import Bb.c;
import Bb.d;
import Bb.e;
import android.content.Context;
import android.os.Looper;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/melon/download/normal/DownloadNotificationManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Bb/d", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DownloadNotificationManager {
    public final DownloadNotification a;
    public final e b;

    public DownloadNotificationManager(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        LogU logU0 = new LogU("DownloadNotificationManager");
        logU0.setCategory(Category.Download);
        logU0.setUseThreadInfo(true);
        this.a = new DownloadNotification(context0);
        this.b = new e(this, Looper.getMainLooper(), 0);
    }

    public final void a(int v, c c0) {
        d d0 = new d(v, c0);
        this.b.obtainMessage(0, d0).sendToTarget();
    }
}

