package androidx.glance.appwidget;

import D2.d0;
import D2.e0;
import D2.f0;
import D2.h0;
import D2.i0;
import a.a;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import w8.T;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class GlanceAppWidgetReceiver extends AppWidgetProvider {
    public final CoroutineDispatcher a;

    public GlanceAppWidgetReceiver() {
        this.a = Dispatchers.getDefault();
    }

    public static final void a(GlanceAppWidgetReceiver glanceAppWidgetReceiver0, CoroutineScope coroutineScope0, Context context0) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new i0(context0, glanceAppWidgetReceiver0, null), 3, null);
    }

    public abstract T b();

    @Override  // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context0, AppWidgetManager appWidgetManager0, int v, Bundle bundle0) {
        d0 d00 = new d0(this, context0, v, bundle0, null);
        a.B(this, this.a, d00);
    }

    @Override  // android.appwidget.AppWidgetProvider
    public final void onDeleted(Context context0, int[] arr_v) {
        e0 e00 = new e0(this, context0, arr_v, null);
        a.B(this, this.a, e00);
    }

    @Override  // android.appwidget.AppWidgetProvider
    public final void onReceive(Context context0, Intent intent0) {
        int[] arr_v;
        try {
            String s = intent0.getAction();
            if(s != null) {
                switch(s) {
                    case "ACTION_TRIGGER_LAMBDA": {
                        String s2 = intent0.getStringExtra("EXTRA_ACTION_KEY");
                        if(s2 == null) {
                            throw new IllegalStateException("Intent is missing ActionKey extra");
                        }
                        int v = intent0.getIntExtra("EXTRA_APPWIDGET_ID", -1);
                        if(v == -1) {
                            throw new IllegalStateException("Intent is missing AppWidgetId extra");
                        }
                        f0 f00 = new f0(this, context0, v, s2, null);
                        a.B(this, this.a, f00);
                        return;
                    }
                    case "android.intent.action.LOCALE_CHANGED": 
                    case "androidx.glance.appwidget.action.DEBUG_UPDATE": {
                        AppWidgetManager appWidgetManager0 = AppWidgetManager.getInstance(context0);
                        String s1 = this.getClass().getCanonicalName();
                        if(s1 == null) {
                            throw new IllegalStateException("no canonical name");
                        }
                        ComponentName componentName0 = new ComponentName("com.iloen.melon", s1);
                        if(intent0.hasExtra("appWidgetIds")) {
                            arr_v = intent0.getIntArrayExtra("appWidgetIds");
                            q.d(arr_v);
                        }
                        else {
                            arr_v = appWidgetManager0.getAppWidgetIds(componentName0);
                        }
                        this.onUpdate(context0, appWidgetManager0, arr_v);
                        return;
                    }
                }
            }
            super.onReceive(context0, intent0);
            return;
        }
        catch(CancellationException unused_ex) {
            return;
        }
        catch(Throwable throwable0) {
        }
        Log.e("GlanceAppWidget", "Error in Glance App Widget", throwable0);
    }

    @Override  // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context0, AppWidgetManager appWidgetManager0, int[] arr_v) {
        h0 h00 = new h0(this, context0, arr_v, null);
        a.B(this, this.a, h00);
    }
}

