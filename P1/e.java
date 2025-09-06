package P1;

import android.content.Intent;
import android.content.pm.ShortcutInfo.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.v;
import com.iloen.melon.playback.Actor;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import v1.m;

public abstract class e {
    public static OnBackInvokedDispatcher a(ComponentActivity componentActivity0) {
        q.g(componentActivity0, "activity");
        OnBackInvokedDispatcher onBackInvokedDispatcher0 = componentActivity0.getOnBackInvokedDispatcher();
        q.f(onBackInvokedDispatcher0, "activity.getOnBackInvokedDispatcher()");
        return onBackInvokedDispatcher0;
    }

    public static Object b(Bundle bundle0, String s, Class class0) {
        return bundle0.getParcelable(s, class0);
    }

    public static ArrayList c(Bundle bundle0) {
        return bundle0.getParcelableArrayList("image_uri_list", Uri.class);
    }

    public static Object d(Intent intent0, String s, Class class0) {
        return intent0.getParcelableExtra(s, class0);
    }

    public static Serializable e(Bundle bundle0, String s, Class class0) {
        return bundle0.getSerializable(s, class0);
    }

    public static Serializable f(Intent intent0) {
        return intent0.getSerializableExtra("com.iloen.melon.intent.extra.actor", Actor.class);
    }

    public static String g(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.getUniqueId();
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.isTextSelectable();
    }

    public static final void i(m m0, v v0) {
        if(v0 != null) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = m0.findOnBackInvokedDispatcher();
            if(onBackInvokedDispatcher0 != null) {
                onBackInvokedDispatcher0.registerOnBackInvokedCallback(1000000, v0);
            }
        }
    }

    public static final void j(m m0, v v0) {
        if(v0 != null) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = m0.findOnBackInvokedDispatcher();
            if(onBackInvokedDispatcher0 != null) {
                onBackInvokedDispatcher0.unregisterOnBackInvokedCallback(v0);
            }
        }
    }

    public static void k(Object object0, Object object1) {
        q.g(object0, "dispatcher");
        q.g(object1, "callback");
        ((OnBackInvokedDispatcher)object0).registerOnBackInvokedCallback(0, ((OnBackInvokedCallback)object1));
    }

    public static void l(ShortcutInfo.Builder shortcutInfo$Builder0) {
        shortcutInfo$Builder0.setExcludedFromSurfaces(0);
    }

    public static void m(Object object0, Object object1) {
        q.g(object0, "dispatcher");
        q.g(object1, "callback");
        ((OnBackInvokedDispatcher)object0).unregisterOnBackInvokedCallback(((OnBackInvokedCallback)object1));
    }
}

