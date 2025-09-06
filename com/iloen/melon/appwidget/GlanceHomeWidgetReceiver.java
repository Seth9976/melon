package com.iloen.melon.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import w8.T;
import w8.w0;
import w8.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/appwidget/GlanceHomeWidgetReceiver;", "Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class GlanceHomeWidgetReceiver extends GlanceAppWidgetReceiver {
    @Override  // androidx.glance.appwidget.GlanceAppWidgetReceiver
    public final T b() {
        return this.c();
    }

    public abstract w0 c();

    @Override  // androidx.glance.appwidget.GlanceAppWidgetReceiver
    public final void onAppWidgetOptionsChanged(Context context0, AppWidgetManager appWidgetManager0, int v, Bundle bundle0) {
        q.g(context0, "context");
        q.g(appWidgetManager0, "appWidgetManager");
        q.g(bundle0, "newOptions");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new y0(context0, this, bundle0, null), 3, null);
        super.onAppWidgetOptionsChanged(context0, appWidgetManager0, v, bundle0);
    }
}

