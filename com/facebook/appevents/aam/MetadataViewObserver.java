package com.facebook.appevents.aam;

import A3.m;
import Tf.o;
import Tf.v;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000E\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\n2\b\u0010\u0014\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010\"\u001A\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Lie/H;", "startTracking", "()V", "stopTracking", "Landroid/view/View;", "view", "process", "(Landroid/view/View;)V", "processEditText", "Ljava/lang/Runnable;", "runnable", "runOnUIThread", "(Ljava/lang/Runnable;)V", "oldView", "newView", "onGlobalFocusChanged", "(Landroid/view/View;Landroid/view/View;)V", "", "", "processedText", "Ljava/util/Set;", "Landroid/os/Handler;", "uiThreadHandler", "Landroid/os/Handler;", "Ljava/lang/ref/WeakReference;", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001A\u00020\u000B2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/aam/MetadataViewObserver$Companion;", "", "<init>", "()V", "", "key", "value", "preNormalize", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "userData", "Lie/H;", "putUserData", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "activity", "startTrackingActivity", "(Landroid/app/Activity;)V", "stopTrackingActivity", "", "MAX_TEXT_LENGTH", "I", "Lcom/facebook/appevents/aam/MetadataViewObserver;", "observers", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final String preNormalize(String s, String s1) {
            if("r2".equals(s)) {
                Pattern pattern0 = Pattern.compile("[^\\d.]");
                q.f(pattern0, "compile(...)");
                q.g(s1, "input");
                String s2 = pattern0.matcher(s1).replaceAll("");
                q.f(s2, "replaceAll(...)");
                return s2;
            }
            return s1;
        }

        private final void putUserData(Map map0, String s, String s1) {
            List list0;
            switch(s.hashCode()) {
                case 0xE01: {
                    if(s.equals("r3")) {
                        s1 = v.r0(s1, "m", false) || v.r0(s1, "b", false) || v.r0(s1, "ge", false) ? "m" : "f";
                    }
                    break;
                }
                case 0xE02: {
                    if(s.equals("r4")) {
                        goto label_8;
                    }
                    break;
                }
                case 0xE03: {
                    if(s.equals("r5")) {
                    label_8:
                        Pattern pattern0 = Pattern.compile("[^a-z]+");
                        q.f(pattern0, "compile(...)");
                        q.g(s1, "input");
                        s1 = pattern0.matcher(s1).replaceAll("");
                        q.f(s1, "replaceAll(...)");
                    }
                    break;
                }
                case 0xE04: {
                    if(s.equals("r6") && o.v0(s1, "-", false)) {
                        Pattern pattern1 = Pattern.compile("-");
                        q.f(pattern1, "compile(...)");
                        o.P0(0);
                        Matcher matcher0 = pattern1.matcher(s1);
                        if(matcher0.find()) {
                            ArrayList arrayList0 = new ArrayList(10);
                            int v = 0;
                            do {
                                v = androidx.appcompat.app.o.c(matcher0, s1, v, arrayList0);
                            }
                            while(matcher0.find());
                            androidx.appcompat.app.o.w(v, s1, arrayList0);
                            list0 = arrayList0;
                        }
                        else {
                            list0 = k.z(s1.toString());
                        }
                        s1 = ((String[])list0.toArray(new String[0]))[0];
                    }
                }
            }
            map0.put(s, s1);
        }

        public final void startTrackingActivity(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Map map0 = MetadataViewObserver.access$getObservers$cp();
            Integer integer0 = activity0.hashCode();
            MetadataViewObserver metadataViewObserver0 = map0.get(integer0);
            if(metadataViewObserver0 == null) {
                metadataViewObserver0 = new MetadataViewObserver(activity0, null);
                map0.put(integer0, metadataViewObserver0);
            }
            MetadataViewObserver.access$startTracking(metadataViewObserver0);
        }

        public final void stopTrackingActivity(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            MetadataViewObserver metadataViewObserver0 = (MetadataViewObserver)MetadataViewObserver.access$getObservers$cp().remove(activity0.hashCode());
            if(metadataViewObserver0 != null) {
                MetadataViewObserver.access$stopTracking(metadataViewObserver0);
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_TEXT_LENGTH = 100;
    @NotNull
    private final WeakReference activityWeakReference;
    @NotNull
    private final AtomicBoolean isTracking;
    @NotNull
    private static final Map observers;
    @NotNull
    private final Set processedText;
    @NotNull
    private final Handler uiThreadHandler;

    static {
        MetadataViewObserver.Companion = new Companion(null);
        MetadataViewObserver.observers = new HashMap();
    }

    private MetadataViewObserver(Activity activity0) {
        this.processedText = new LinkedHashSet();
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.activityWeakReference = new WeakReference(activity0);
        this.isTracking = new AtomicBoolean(false);
    }

    public MetadataViewObserver(Activity activity0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(activity0);
    }

    // 去混淆评级： 低(20)
    public static final Map access$getObservers$cp() {
        return CrashShieldHandler.isObjectCrashing(MetadataViewObserver.class) ? null : MetadataViewObserver.observers;
    }

    public static final void access$startTracking(MetadataViewObserver metadataViewObserver0) {
        Class class0 = MetadataViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            metadataViewObserver0.startTracking();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$stopTracking(MetadataViewObserver metadataViewObserver0) {
        Class class0 = MetadataViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            metadataViewObserver0.stopTracking();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(@Nullable View view0, @Nullable View view1) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if(view0 != null) {
                    this.process(view0);
                }
                if(view1 != null) {
                    this.process(view1);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void process(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.runOnUIThread(new m(1, view0, this));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void process$lambda$0(View view0, MetadataViewObserver metadataViewObserver0) {
        Class class0 = MetadataViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(view0, "$view");
                q.g(metadataViewObserver0, "this$0");
                if(view0 instanceof EditText) {
                    metadataViewObserver0.processEditText(view0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void processEditText(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.e(view0, "null cannot be cast to non-null type android.widget.EditText");
                String s = o.e1(((EditText)view0).getText().toString()).toString().toLowerCase();
                q.f(s, "this as java.lang.String).toLowerCase()");
                if(s.length() == 0) {
                    return;
                }
                if(!this.processedText.contains(s) && s.length() <= 100) {
                    this.processedText.add(s);
                    HashMap hashMap0 = new HashMap();
                    List list0 = MetadataMatcher.getCurrentViewIndicators(view0);
                    List list1 = null;
                    for(Object object0: MetadataRule.Companion.getRules()) {
                        MetadataRule metadataRule0 = (MetadataRule)object0;
                        Companion metadataViewObserver$Companion0 = MetadataViewObserver.Companion;
                        String s1 = metadataViewObserver$Companion0.preNormalize(metadataRule0.getName(), s);
                        if(metadataRule0.getValRule().length() <= 0 || MetadataMatcher.matchValue(s1, metadataRule0.getValRule())) {
                            if(!MetadataMatcher.matchIndicator(list0, metadataRule0.getKeyRules())) {
                                if(list1 == null) {
                                    list1 = MetadataMatcher.getAroundViewIndicators(view0);
                                }
                                if(!MetadataMatcher.matchIndicator(list1, metadataRule0.getKeyRules())) {
                                    continue;
                                }
                            }
                            metadataViewObserver$Companion0.putUserData(hashMap0, metadataRule0.getName(), s1);
                        }
                    }
                    InternalAppEventsLogger.Companion.setInternalUserData(hashMap0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void runOnUIThread(Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable0.run();
                return;
            }
            this.uiThreadHandler.post(runnable0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
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
                            viewTreeObserver0.addOnGlobalFocusChangeListener(this);
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
        Class class0 = MetadataViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            MetadataViewObserver.Companion.startTrackingActivity(activity0);
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
                            viewTreeObserver0.removeOnGlobalFocusChangeListener(this);
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
        Class class0 = MetadataViewObserver.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            MetadataViewObserver.Companion.stopTrackingActivity(activity0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

