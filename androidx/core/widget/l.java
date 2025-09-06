package androidx.core.widget;

import android.graphics.Rect;
import android.media.MediaRoute2Info.Builder;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.RouteListingPreference.Builder;
import android.media.RouteListingPreference.Item.Builder;
import android.media.RouteListingPreference;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.window.BackEvent;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.q;
import l4.j0;
import l4.k0;
import l4.u;

public abstract class l {
    public static void a(MediaRoute2Info.Builder mediaRoute2Info$Builder0, u u0) {
        if(u0.a.getBoolean("isVisibilityPublic", true)) {
            mediaRoute2Info$Builder0.setVisibilityPublic();
            return;
        }
        mediaRoute2Info$Builder0.setVisibilityRestricted(u0.a());
    }

    public static AccessibilityNodeInfo.AccessibilityAction b() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static float c(VelocityTracker velocityTracker0, int v) {
        return velocityTracker0.getAxisVelocity(v);
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo0, Rect rect0) {
        accessibilityNodeInfo0.getBoundsInWindow(rect0);
    }

    public static CharSequence e(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.getContainerTitle();
    }

    public static Set f(MediaRoute2Info mediaRoute2Info0) {
        return mediaRoute2Info0.getDeduplicationIds();
    }

    public static int g(ViewConfiguration viewConfiguration0, int v, int v1, int v2) {
        return viewConfiguration0.getScaledMaximumFlingVelocity(v, v1, v2);
    }

    public static int h(ViewConfiguration viewConfiguration0, int v, int v1, int v2) {
        return viewConfiguration0.getScaledMinimumFlingVelocity(v, v1, v2);
    }

    public static int i(MediaRoute2Info mediaRoute2Info0) {
        return mediaRoute2Info0.getType();
    }

    public static boolean j(AccessibilityNodeInfo accessibilityNodeInfo0) {
        return accessibilityNodeInfo0.isAccessibilityDataSensitive();
    }

    public static float k(BackEvent backEvent0) {
        q.g(backEvent0, "backEvent");
        return backEvent0.getProgress();
    }

    public static void l(MediaRoute2Info.Builder mediaRoute2Info$Builder0, Set set0) {
        mediaRoute2Info$Builder0.setDeduplicationIds(set0);
    }

    public static void m(MediaRoute2Info.Builder mediaRoute2Info$Builder0, int v) {
        mediaRoute2Info$Builder0.setType(v);
    }

    public static void n(TextView textView0, int v, float f) {
        textView0.setLineHeight(v, f);
    }

    public static void o(MediaRouter2 mediaRouter20, RouteListingPreference routeListingPreference0) {
        mediaRouter20.setRouteListingPreference(routeListingPreference0);
    }

    public static boolean p(MediaRouter2 mediaRouter20) {
        return mediaRouter20.showSystemOutputSwitcher();
    }

    public static int q(BackEvent backEvent0) {
        q.g(backEvent0, "backEvent");
        return backEvent0.getSwipeEdge();
    }

    public static RouteListingPreference r(k0 k00) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: k00.a) {
            arrayList0.add(new RouteListingPreference.Item.Builder(((j0)object0).a).setFlags(0).setSubText(0).setCustomSubtextMessage(null).setSelectionBehavior(((j0)object0).b).build());
        }
        return new RouteListingPreference.Builder().setItems(arrayList0).setLinkedItemComponentName(null).setUseSystemOrdering(k00.b).build();
    }

    public static float s(BackEvent backEvent0) {
        q.g(backEvent0, "backEvent");
        return backEvent0.getTouchX();
    }

    public static float t(BackEvent backEvent0) {
        q.g(backEvent0, "backEvent");
        return backEvent0.getTouchY();
    }
}

