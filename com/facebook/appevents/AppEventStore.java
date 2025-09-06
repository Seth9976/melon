package com.facebook.appevents;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\t\u0010\rR\u001C\u0010\u0010\u001A\n \u000F*\u0004\u0018\u00010\u000E0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "<init>", "()V", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppIdPair", "Lcom/facebook/appevents/SessionEventsState;", "appEvents", "Lie/H;", "persistEvents", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Lcom/facebook/appevents/SessionEventsState;)V", "Lcom/facebook/appevents/AppEventCollection;", "eventsToPersist", "(Lcom/facebook/appevents/AppEventCollection;)V", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventStore {
    @NotNull
    public static final AppEventStore INSTANCE;
    private static final String TAG;

    static {
        AppEventStore.INSTANCE = new AppEventStore();
        AppEventStore.TAG = "com.facebook.appevents.AppEventStore";
    }

    public static final void persistEvents(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull SessionEventsState sessionEventsState0) {
        Class class0 = AppEventStore.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        try {
            q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
            q.g(sessionEventsState0, "appEvents");
            PersistedEvents persistedEvents0 = AppEventDiskStore.readAndClearStore();
            persistedEvents0.addEvents(accessTokenAppIdPair0, sessionEventsState0.getEventsToPersist());
            AppEventDiskStore.saveEventsToDisk$facebook_core_release(persistedEvents0);
            FIN.finallyExec$NT(v);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, AppEventStore.class);
            FIN.finallyExec$NT(v);
        }
    }

    public static final void persistEvents(@NotNull AppEventCollection appEventCollection0) {
        synchronized(AppEventStore.class) {
            if(CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                q.g(appEventCollection0, "eventsToPersist");
                PersistedEvents persistedEvents0 = AppEventDiskStore.readAndClearStore();
                for(Object object0: appEventCollection0.keySet()) {
                    SessionEventsState sessionEventsState0 = appEventCollection0.get(((AccessTokenAppIdPair)object0));
                    if(sessionEventsState0 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    persistedEvents0.addEvents(((AccessTokenAppIdPair)object0), sessionEventsState0.getEventsToPersist());
                }
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(persistedEvents0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, AppEventStore.class);
        }
    }
}

