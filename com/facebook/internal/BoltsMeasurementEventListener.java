package com.facebook.internal;

import W2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ#\u0010\r\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lie/H;", "open", "()V", "close", "finalize", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "applicationContext", "Landroid/content/Context;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BoltsMeasurementEventListener extends BroadcastReceiver {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001C\u0010\u0007\u001A\u00020\u00048\u0000X\u0081D¢\u0006\u000E\n\u0000\u0012\u0004\b\b\u0010\u0002\u001A\u0004\b\t\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener$Companion;", "", "()V", "BOLTS_MEASUREMENT_EVENT_PREFIX", "", "MEASUREMENT_EVENT_ARGS_KEY", "MEASUREMENT_EVENT_NAME_KEY", "MEASUREMENT_EVENT_NOTIFICATION_NAME", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release", "()Ljava/lang/String;", "singleton", "Lcom/facebook/internal/BoltsMeasurementEventListener;", "getInstance", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final BoltsMeasurementEventListener getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            if(BoltsMeasurementEventListener.access$getSingleton$cp() != null) {
                return BoltsMeasurementEventListener.access$getSingleton$cp();
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener0 = new BoltsMeasurementEventListener(context0, null);
            BoltsMeasurementEventListener.access$open(boltsMeasurementEventListener0);
            BoltsMeasurementEventListener.access$setSingleton$cp(boltsMeasurementEventListener0);
            return BoltsMeasurementEventListener.access$getSingleton$cp();
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release() {
            return "com.parse.bolts.measurement_event";
        }

        public static void getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations() {
        }
    }

    @NotNull
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    @NotNull
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    @NotNull
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME;
    @NotNull
    private final Context applicationContext;
    @Nullable
    private static BoltsMeasurementEventListener singleton;

    static {
        BoltsMeasurementEventListener.Companion = new Companion(null);
        BoltsMeasurementEventListener.MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    }

    private BoltsMeasurementEventListener(Context context0) {
        Context context1 = context0.getApplicationContext();
        q.f(context1, "context.applicationContext");
        this.applicationContext = context1;
    }

    public BoltsMeasurementEventListener(Context context0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(context0);
    }

    // 去混淆评级： 低(40)
    public static final String access$getMEASUREMENT_EVENT_NOTIFICATION_NAME$cp() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static final BoltsMeasurementEventListener access$getSingleton$cp() {
        return CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class) ? null : BoltsMeasurementEventListener.singleton;
    }

    public static final void access$open(BoltsMeasurementEventListener boltsMeasurementEventListener0) {
        Class class0 = BoltsMeasurementEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            boltsMeasurementEventListener0.open();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$setSingleton$cp(BoltsMeasurementEventListener boltsMeasurementEventListener0) {
        if(CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return;
        }
        BoltsMeasurementEventListener.singleton = boltsMeasurementEventListener0;
    }

    private final void close() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            b b0 = b.a(this.applicationContext);
            q.f(b0, "getInstance(applicationContext)");
            b0.d(this);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Override
    public final void finalize() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.close();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Nullable
    public static final BoltsMeasurementEventListener getInstance(@NotNull Context context0) {
        Class class0 = BoltsMeasurementEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return BoltsMeasurementEventListener.Companion.getInstance(context0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context0, @Nullable Intent intent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
            Set set0 = null;
            String s = "bf_" + (intent0 == null ? null : intent0.getStringExtra("event_name"));
            Bundle bundle0 = intent0 == null ? null : intent0.getBundleExtra("event_args");
            Bundle bundle1 = new Bundle();
            if(bundle0 != null) {
                set0 = bundle0.keySet();
            }
            if(set0 != null) {
                for(Object object0: set0) {
                    q.f(((String)object0), "key");
                    Pattern pattern0 = Pattern.compile("[^0-9a-zA-Z _-]");
                    q.f(pattern0, "compile(...)");
                    String s1 = pattern0.matcher(((String)object0)).replaceAll("-");
                    q.f(s1, "replaceAll(...)");
                    Pattern pattern1 = Pattern.compile("^[ -]*");
                    q.f(pattern1, "compile(...)");
                    String s2 = pattern1.matcher(s1).replaceAll("");
                    q.f(s2, "replaceAll(...)");
                    Pattern pattern2 = Pattern.compile("[ -]*$");
                    q.f(pattern2, "compile(...)");
                    String s3 = pattern2.matcher(s2).replaceAll("");
                    q.f(s3, "replaceAll(...)");
                    bundle1.putString(s3, ((String)bundle0.get(((String)object0))));
                }
            }
            internalAppEventsLogger0.logEvent(s, bundle1);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void open() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            b b0 = b.a(this.applicationContext);
            q.f(b0, "getInstance(applicationContext)");
            b0.b(this, new IntentFilter("com.parse.bolts.measurement_event"));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}

