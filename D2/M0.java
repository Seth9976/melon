package D2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import androidx.glance.appwidget.GlanceRemoteViewsService;
import d5.n;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Job;
import ne.a;
import oe.c;
import w8.T;

public final class m0 implements RemoteViewsService.RemoteViewsFactory {
    public final GlanceRemoteViewsService a;
    public final int b;
    public final int c;
    public final String d;

    public m0(GlanceRemoteViewsService glanceRemoteViewsService0, int v, int v1, String s) {
        this.a = glanceRemoteViewsService0;
        this.b = v;
        this.c = v1;
        this.d = s;
    }

    public static final Object a(m0 m00, f f0, c c0) {
        Job job0;
        T t0;
        k0 k00;
        if(c0 instanceof k0) {
            k00 = (k0)c0;
            int v = k00.D;
            if((v & 0x80000000) == 0) {
                k00 = new k0(m00, c0);
            }
            else {
                k00.D = v ^ 0x80000000;
            }
        }
        else {
            k00 = new k0(m00, c0);
        }
        Object object0 = k00.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(k00.D) {
            case 0: {
                n.D(object0);
                AppWidgetProviderInfo appWidgetProviderInfo0 = AppWidgetManager.getInstance(m00.a).getAppWidgetInfo(m00.b);
                if(appWidgetProviderInfo0 == null) {
                    t0 = null;
                }
                else {
                    ComponentName componentName0 = appWidgetProviderInfo0.provider;
                    if(componentName0 == null) {
                        t0 = null;
                    }
                    else {
                        String s = componentName0.getClassName();
                        if(s == null) {
                            t0 = null;
                        }
                        else {
                            Object object1 = Class.forName(s).getDeclaredConstructor(null).newInstance(null);
                            q.e(object1, "null cannot be cast to non-null type androidx.glance.appwidget.GlanceAppWidgetReceiver");
                            t0 = ((GlanceAppWidgetReceiver)object1).b();
                        }
                    }
                }
                if(t0 == null) {
                    C.a(m00.b);
                    job0 = null;
                }
                else {
                    l0 l00 = new l0(m00, f0, t0, null);
                    k00.r = m00;
                    k00.D = 1;
                    object0 = L2.q.a.a(l00, k00);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_44;
                }
                break;
            }
            case 1: {
                m00 = k00.r;
                n.D(object0);
            label_44:
                job0 = (Job)object0;
                if(job0 == null) {
                    C.a(m00.b);
                    job0 = null;
                }
                break;
            }
            case 2: {
                n.D(object0);
                job0 = (Job)object0;
                break;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(job0 != null) {
            k00.r = null;
            k00.D = 3;
            if(job0.join(k00) == a0) {
                return a0;
            }
        }
        return h0;
    }

    public final D0 b() {
        E0 e00 = GlanceRemoteViewsService.a;
        synchronized(e00) {
            D0 d00 = (D0)e00.a.get(this.b + '-' + this.c + '-' + this.d);
            if(d00 == null) {
                d00 = D0.d;
            }
            return d00;
        }
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final int getCount() {
        return this.b().a.length;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final long getItemId(int v) {
        try {
            return this.b().a[v];
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            return -1L;
        }
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final RemoteViews getLoadingView() {
        return null;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final RemoteViews getViewAt(int v) {
        try {
            return this.b().b[v];
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            return new RemoteViews("com.iloen.melon", 0x7F0D0378);  // layout:glance_invalid_list_item
        }
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final int getViewTypeCount() {
        return this.b().c;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final boolean hasStableIds() {
        this.b().getClass();
        return false;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onCreate() {
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onDataSetChanged() {
        BuildersKt__BuildersKt.runBlocking$default(null, new j0(this, null), 1, null);
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onDestroy() {
        synchronized(GlanceRemoteViewsService.a) {
            GlanceRemoteViewsService.a.a.remove(this.b + '-' + this.c + '-' + this.d);
        }
    }
}

