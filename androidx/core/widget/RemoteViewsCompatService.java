package androidx.core.widget;

import android.content.Intent;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import android.widget.RemoteViewsService;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/core/widget/RemoteViewsCompatService;", "Landroid/widget/RemoteViewsService;", "<init>", "()V", "Bd/s", "androidx/core/widget/k", "core-remoteviews_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RemoteViewsCompatService extends RemoteViewsService {
    @Override  // android.widget.RemoteViewsService
    public final RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent0) {
        q.g(intent0, "intent");
        int v = intent0.getIntExtra("appWidgetId", -1);
        if(v == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int v1 = intent0.getIntExtra("androidx.core.widget.extra.view_id", -1);
        if(v1 == -1) {
            throw new IllegalStateException("No view id was present in the intent");
        }
        return new k(this, v, v1);
    }
}

