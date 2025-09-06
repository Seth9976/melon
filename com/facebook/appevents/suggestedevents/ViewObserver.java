package com.facebook.appevents.suggestedevents;

import A3.l;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000F\u0010\n\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000F\u0010\u000B\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\bR\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Lie/H;", "startTracking", "()V", "stopTracking", "process", "onGlobalLayout", "Ljava/lang/ref/WeakReference;", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/os/Handler;", "uiThreadHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR \u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000E0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver$Companion;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lie/H;", "startTrackingActivity", "(Landroid/app/Activity;)V", "stopTrackingActivity", "", "MAX_TEXT_LENGTH", "I", "", "Lcom/facebook/appevents/suggestedevents/ViewObserver;", "observers", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void startTrackingActivity(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Map map0 = ViewObserver.access$getObservers$cp();
            Integer integer0 = activity0.hashCode();
            ViewObserver viewObserver0 = map0.get(integer0);
            if(viewObserver0 == null) {
                viewObserver0 = new ViewObserver(activity0, null);
                map0.put(integer0, viewObserver0);
            }
            ViewObserver.access$startTracking(viewObserver0);
        }

        public final void stopTrackingActivity(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            ViewObserver viewObserver0 = (ViewObserver)ViewObserver.access$getObservers$cp().remove(activity0.hashCode());
            if(viewObserver0 != null) {
                ViewObserver.access$stopTracking(viewObserver0);
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_TEXT_LENGTH = 300;
    @NotNull
    private final WeakReference activityWeakReference;
    @NotNull
    private final AtomicBoolean isTracking;
    @NotNull
    private static final Map observers;
    @NotNull
    private final Handler uiThreadHandler;

    static {
        ViewObserver.Companion = new Companion(null);
        ViewObserver.observers = new HashMap();
    }

    private ViewObserver(Activity activity0) {
        this.activityWeakReference = new WeakReference(activity0);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    public ViewObserver(Activity activity0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(activity0);
    }

    // 去混淆评级： 低(20)
    public static final Map access$getObservers$cp() {
        return CrashShieldHandler.isObjectCrashing(ViewObserver.class) ? null : ViewObserver.observers;
    }

    public static final void access$startTracking(ViewObserver viewObserver0) {
        Class class0 = ViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            viewObserver0.startTracking();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$stopTracking(ViewObserver viewObserver0) {
        Class class0 = ViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            viewObserver0.stopTracking();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.process();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void process() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            l l0 = new l(this, 2);
            if(Thread.currentThread() == Looper.getMainLooper().getThread()) {
                l0.run();
                return;
            }
            this.uiThreadHandler.post(l0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void process$lambda$0(ViewObserver viewObserver0) {
        Class class0 = ViewObserver.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(viewObserver0, "this$0");
                try {
                    View view0 = AppEventUtility.getRootView(((Activity)viewObserver0.activityWeakReference.get()));
                    Activity activity0 = (Activity)viewObserver0.activityWeakReference.get();
                    if(view0 != null && activity0 != null) {
                        for(Object object0: SuggestedEventViewHierarchy.getAllClickableViews(view0)) {
                            View view1 = (View)object0;
                            if(!SensitiveUserDataUtils.isSensitiveUserData(view1)) {
                                String s = SuggestedEventViewHierarchy.getTextOfViewRecursively(view1);
                                if(s.length() > 0 && s.length() <= 300) {
                                    String s1 = activity0.getLocalClassName();
                                    q.f(s1, "activity.localClassName");
                                    ViewOnClickListener.Companion.attachListener$facebook_core_release(view1, view0, s1);
                                }
                            }
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private final void startTracking() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!this.isTracking.getAndSet(true)) {
                    View view0 = AppEventUtility.getRootView(((Activity)this.activityWeakReference.get()));
                    if(view0 != null) {
                        ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                        if(viewTreeObserver0.isAlive()) {
                            viewTreeObserver0.addOnGlobalLayoutListener(this);
                            this.process();
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void startTrackingActivity(@NotNull Activity activity0) {
        Class class0 = ViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ViewObserver.Companion.startTrackingActivity(activity0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void stopTracking() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(this.isTracking.getAndSet(false)) {
                    View view0 = AppEventUtility.getRootView(((Activity)this.activityWeakReference.get()));
                    if(view0 != null) {
                        ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                        if(viewTreeObserver0.isAlive()) {
                            viewTreeObserver0.removeOnGlobalLayoutListener(this);
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void stopTrackingActivity(@NotNull Activity activity0) {
        Class class0 = ViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ViewObserver.Companion.stopTrackingActivity(activity0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

