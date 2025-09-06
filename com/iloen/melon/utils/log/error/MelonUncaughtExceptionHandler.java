package com.iloen.melon.utils.log.error;

import A8.b;
import Db.a;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__BuildersKt;

public class MelonUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "MelonUncaughtExceptionHandler";
    public final Thread.UncaughtExceptionHandler a;

    public MelonUncaughtExceptionHandler(Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0) {
        this.a = thread$UncaughtExceptionHandler0;
    }

    @Override
    public void uncaughtException(Thread thread0, Throwable throwable0) {
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0;
        try {
            try {
                thread$UncaughtExceptionHandler0 = this.a;
                q.g(thread0, "thread");
                q.g(throwable0, "throwable");
                BuildersKt__BuildersKt.runBlocking$default(null, new a(thread0, throwable0, null), 1, null);
                b.d();
                if(MelonSettingInfo.isUseErrorReport()) {
                    ErrorReportManager.getInstance().sendExceptionReport(thread0, throwable0);
                }
                goto label_17;
            }
            catch(Exception exception0) {
            }
            LogU.e("MelonUncaughtExceptionHandler", exception0.toString());
            if(thread$UncaughtExceptionHandler0 != null) {
                goto label_11;
            }
            return;
        }
        catch(Throwable throwable1) {
            goto label_14;
        }
    label_11:
        thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        return;
    label_14:
        if(thread$UncaughtExceptionHandler0 != null) {
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
        throw throwable1;
    label_17:
        if(thread$UncaughtExceptionHandler0 != null) {
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
    }
}

