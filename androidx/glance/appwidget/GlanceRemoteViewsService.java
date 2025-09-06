package androidx.glance.appwidget;

import D2.E0;
import D2.m0;
import android.content.Intent;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import android.widget.RemoteViewsService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/glance/appwidget/GlanceRemoteViewsService;", "Landroid/widget/RemoteViewsService;", "<init>", "()V", "D2/m0", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GlanceRemoteViewsService extends RemoteViewsService {
    public static final E0 a;

    static {
        GlanceRemoteViewsService.a = new E0(0);
    }

    @Override  // android.widget.RemoteViewsService
    public final RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent0) {
        int v = intent0.getIntExtra("appWidgetId", -1);
        if(v == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int v1 = intent0.getIntExtra("androidx.glance.widget.extra.view_id", -1);
        if(v1 == -1) {
            throw new IllegalStateException("No view id was present in the intent");
        }
        String s = intent0.getStringExtra("androidx.glance.widget.extra.size_info");
        if(s == null || s.length() == 0) {
            throw new IllegalStateException("No size info was present in the intent");
        }
        return new m0(this, v, v1, s);
    }
}

