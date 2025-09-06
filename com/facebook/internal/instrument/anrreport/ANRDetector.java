package com.facebook.internal.instrument.anrreport;

import A5.a;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001C\u0010\u0010\u001A\n \u000F*\u0004\u0018\u00010\u000E0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRDetector;", "", "<init>", "()V", "Landroid/app/ActivityManager;", "am", "Lie/H;", "checkProcessError", "(Landroid/app/ActivityManager;)V", "start", "", "DETECTION_INTERVAL_IN_MS", "I", "myUid", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "", "previousStackTrace", "Ljava/lang/String;", "Ljava/lang/Runnable;", "anrDetectorRunnable", "Ljava/lang/Runnable;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ANRDetector {
    private static final int DETECTION_INTERVAL_IN_MS = 500;
    @NotNull
    public static final ANRDetector INSTANCE;
    @NotNull
    private static final Runnable anrDetectorRunnable;
    private static final int myUid;
    @Nullable
    private static String previousStackTrace;
    private static final ScheduledExecutorService scheduledExecutorService;

    static {
        ANRDetector.INSTANCE = new ANRDetector();
        ANRDetector.myUid = Process.myUid();
        ANRDetector.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ANRDetector.previousStackTrace = "";
        ANRDetector.anrDetectorRunnable = new a(5);
    }

    private static final void anrDetectorRunnable$lambda$0() {
        Class class0 = ANRDetector.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                Object object0 = FacebookSdk.getApplicationContext().getSystemService("activity");
                q.e(object0, "null cannot be cast to non-null type android.app.ActivityManager");
                ANRDetector.checkProcessError(((ActivityManager)object0));
                return;
            }
            catch(Exception throwable0) {
            }
            catch(Throwable unused_ex) {
                return;
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void checkProcessError(@Nullable ActivityManager activityManager0) {
        Class class0 = ANRDetector.class;
        if(!CrashShieldHandler.isObjectCrashing(class0) && activityManager0 != null) {
            try {
                List list0 = activityManager0.getProcessesInErrorState();
                if(list0 != null) {
                    for(Object object0: list0) {
                        ActivityManager.ProcessErrorStateInfo activityManager$ProcessErrorStateInfo0 = (ActivityManager.ProcessErrorStateInfo)object0;
                        if(activityManager$ProcessErrorStateInfo0.condition == 2 && activityManager$ProcessErrorStateInfo0.uid == ANRDetector.myUid) {
                            Thread thread0 = Looper.getMainLooper().getThread();
                            q.f(thread0, "getMainLooper().thread");
                            String s = InstrumentUtility.getStackTrace(thread0);
                            if(!q.b(s, ANRDetector.previousStackTrace) && InstrumentUtility.isSDKRelatedThread(thread0)) {
                                ANRDetector.previousStackTrace = s;
                                Builder.build(activityManager$ProcessErrorStateInfo0.shortMsg, s).save();
                            }
                        }
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    public static final void start() {
        Class class0 = ANRDetector.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            ANRDetector.scheduledExecutorService.scheduleWithFixedDelay(ANRDetector.anrDetectorRunnable, 0L, 500L, TimeUnit.MILLISECONDS);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

