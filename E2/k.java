package E2;

import C2.a;
import C2.c;
import C2.d;
import C2.e;
import C2.f;
import D2.U0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.StrictMode.VmPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode;
import androidx.glance.appwidget.action.ActionCallbackBroadcastReceiver;
import androidx.glance.appwidget.action.ActionTrampolineActivity;
import androidx.glance.appwidget.action.InvisibleActionTrampolineActivity;
import com.iloen.melon.appwidget.CloseMessageAction;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Map;

public abstract class k {
    public static final c a;

    static {
        k.a = new c("android.widget.extra.CHECKED");
    }

    public static h a(Intent intent0) {
        return new h(intent0, u0.N(((d[])Arrays.copyOf(new d[0], 0))));
    }

    public static Intent b(Intent intent0, U0 u00, int v, int v1) {
        Intent intent1 = new Intent(u00.a, (v1 == 1 ? ActionTrampolineActivity.class : InvisibleActionTrampolineActivity.class));
        intent1.setData(k.d(u00, v, v1, ""));
        intent1.putExtra("ACTION_TYPE", A7.d.w(v1));
        intent1.putExtra("ACTION_INTENT", intent0);
        return intent1;
    }

    public static Intent c(Context context0, int v, f f0) {
        Intent intent0 = new Intent(context0, ActionCallbackBroadcastReceiver.class).setPackage("com.iloen.melon").putExtra("ActionCallbackBroadcastReceiver:callbackClass", CloseMessageAction.class.getCanonicalName()).putExtra("ActionCallbackBroadcastReceiver:appWidgetId", v);
        Map map0 = Collections.unmodifiableMap(f0.a);
        ArrayList arrayList0 = new ArrayList(map0.size());
        for(Object object0: map0.entrySet()) {
            c c0 = (c)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            arrayList0.add(new m(c0.a, object1));
        }
        m[] arr_m = (m[])arrayList0.toArray(new m[0]);
        intent0.putExtra("ActionCallbackBroadcastReceiver:parameters", d5.f.j(((m[])Arrays.copyOf(arr_m, arr_m.length))));
        return intent0;
    }

    public static final Uri d(U0 u00, int v, int v1, String s) {
        Uri.Builder uri$Builder0 = new Uri.Builder();
        uri$Builder0.scheme("glance-action");
        uri$Builder0.path(A7.d.w(v1));
        uri$Builder0.appendQueryParameter("appWidgetId", String.valueOf(u00.b));
        uri$Builder0.appendQueryParameter("viewId", String.valueOf(v));
        uri$Builder0.appendQueryParameter("viewSize", r1.h.c(u00.j));
        uri$Builder0.appendQueryParameter("extraData", s);
        if(u00.f) {
            uri$Builder0.appendQueryParameter("lazyCollection", String.valueOf(u00.k));
            uri$Builder0.appendQueryParameter("lazeViewItem", "-1");
        }
        return uri$Builder0.build();
    }

    public static final Intent e(a a0, U0 u00, int v, we.k k0) {
        int v1 = u00.b;
        if(a0 instanceof h) {
            Intent intent0 = k.g(((h)a0), ((f)k0.invoke(((h)a0).b)));
            if(intent0.getData() == null) {
                intent0.setData(k.d(u00, v, 5, ""));
            }
            return intent0;
        }
        if(a0 instanceof i) {
            if(!(((i)a0) instanceof i)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            Intent intent1 = ((i)a0).a;
            return ((i)a0).b ? k.b(intent1, u00, v, 4) : k.b(intent1, u00, v, 3);
        }
        if(a0 instanceof g) {
            f f0 = (f)k0.invoke(((g)a0).a);
            return k.b(k.c(u00.a, v1, f0), u00, v, 2);
        }
        if(!(a0 instanceof e)) {
            throw new IllegalStateException(("Cannot create fill-in Intent for action type: " + a0).toString());
        }
        ComponentName componentName0 = u00.n;
        if(componentName0 == null) {
            throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
        }
        return k.b(new Intent().setComponent(componentName0).setAction("ACTION_TRIGGER_LAMBDA").putExtra("EXTRA_ACTION_KEY", ((e)a0).a).putExtra("EXTRA_APPWIDGET_ID", v1), u00, v, 2);
    }

    public static final PendingIntent f(a a0, U0 u00, int v, we.k k0) {
        int v1 = u00.b;
        Context context0 = u00.a;
        if(a0 instanceof h) {
            Intent intent0 = k.g(((h)a0), ((f)k0.invoke(((h)a0).b)));
            if(intent0.getData() == null) {
                intent0.setData(k.d(u00, v, 5, ""));
            }
            return PendingIntent.getActivity(context0, 0, intent0, 0xC000000, null);
        }
        if(a0 instanceof i) {
            if(!(((i)a0) instanceof i)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            Intent intent1 = ((i)a0).a;
            if(intent1.getData() == null) {
                intent1.setData(k.d(u00, v, 5, ""));
            }
            return ((i)a0).b ? E2.d.a.a(context0, intent1) : PendingIntent.getService(context0, 0, intent1, 0xC000000);
        }
        if(a0 instanceof g) {
            Intent intent2 = k.c(context0, v1, ((f)k0.invoke(((g)a0).a)));
            intent2.setData(k.d(u00, v, 5, ""));
            return PendingIntent.getBroadcast(context0, 0, intent2, 0xC000000);
        }
        if(!(a0 instanceof e)) {
            throw new IllegalStateException(("Cannot create PendingIntent for action type: " + a0).toString());
        }
        ComponentName componentName0 = u00.n;
        if(componentName0 == null) {
            throw new IllegalArgumentException("In order to use LambdaAction, actionBroadcastReceiver must be provided");
        }
        Intent intent3 = new Intent().setComponent(componentName0).setAction("ACTION_TRIGGER_LAMBDA").putExtra("EXTRA_ACTION_KEY", ((e)a0).a).putExtra("EXTRA_APPWIDGET_ID", v1);
        intent3.setData(k.d(u00, v, 5, ((e)a0).a));
        return PendingIntent.getBroadcast(context0, 0, intent3, 0xC000000);
    }

    public static final Intent g(h h0, f f0) {
        if(!(h0 instanceof h)) {
            throw new IllegalStateException(("Action type not defined in app widget package: " + h0).toString());
        }
        Intent intent0 = h0.a;
        Map map0 = Collections.unmodifiableMap(f0.a);
        ArrayList arrayList0 = new ArrayList(map0.size());
        for(Object object0: map0.entrySet()) {
            c c0 = (c)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            arrayList0.add(new m(c0.a, object1));
        }
        m[] arr_m = (m[])arrayList0.toArray(new m[0]);
        intent0.putExtras(d5.f.j(((m[])Arrays.copyOf(arr_m, arr_m.length))));
        return intent0;
    }

    public static final void h(Activity activity0, Intent intent0) {
        StrictMode.VmPolicy strictMode$VmPolicy1;
        Parcelable parcelable0 = intent0.getParcelableExtra("ACTION_INTENT");
        if(parcelable0 == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without specifying target intent.");
        }
        if(intent0.hasExtra("android.widget.extra.CHECKED")) {
            ((Intent)parcelable0).putExtra("android.widget.extra.CHECKED", intent0.getBooleanExtra("android.widget.extra.CHECKED", false));
        }
        String s = intent0.getStringExtra("ACTION_TYPE");
        if(s == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without trampoline type");
        }
        E2.c c0 = new E2.c(s, activity0, ((Intent)parcelable0), intent0.getBundleExtra("ACTIVITY_OPTIONS"), 0);
        StrictMode.VmPolicy strictMode$VmPolicy0 = StrictMode.getVmPolicy();
        if(Build.VERSION.SDK_INT >= 0x1F) {
            StrictMode.VmPolicy.Builder strictMode$VmPolicy$Builder0 = new StrictMode.VmPolicy.Builder(strictMode$VmPolicy0);
            strictMode$VmPolicy1 = j.a.a(strictMode$VmPolicy$Builder0).build();
        }
        else {
            strictMode$VmPolicy1 = new StrictMode.VmPolicy.Builder().build();
        }
        StrictMode.setVmPolicy(strictMode$VmPolicy1);
        c0.invoke();
        StrictMode.setVmPolicy(strictMode$VmPolicy0);
        activity0.finish();
    }
}

