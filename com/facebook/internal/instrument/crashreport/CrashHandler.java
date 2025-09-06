package com.facebook.internal.instrument.crashreport;

import Ce.f;
import E1.a;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentData.Type;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0013\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0016\u0010\u0002\u001A\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "<init>", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "Ljava/lang/Thread;", "t", "", "e", "Lie/H;", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001C\u0010\f\u001A\n \u000B*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "<init>", "()V", "Lie/H;", "sendExceptionReports", "enable", "", "MAX_CRASH_REPORT_NUM", "I", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static void a(List list0, GraphResponse graphResponse0) {
            Companion.sendExceptionReports$lambda$5(list0, graphResponse0);
        }

        public final void enable() {
            synchronized(this) {
                if(FacebookSdk.getAutoLogAppEventsEnabled()) {
                    this.sendExceptionReports();
                }
                if(CrashHandler.instance != null) {
                    Log.w(CrashHandler.TAG, "Already enabled!");
                    return;
                }
                CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), null);
                Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
            }
        }

        private final void sendExceptionReports() {
            if(Utility.isDataProcessingRestricted()) {
                return;
            }
            File[] arr_file = InstrumentUtility.listExceptionReportFiles();
            ArrayList arrayList0 = new ArrayList(arr_file.length);
            for(int v = 0; v < arr_file.length; ++v) {
                arrayList0.add(Builder.load(arr_file[v]));
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: arrayList0) {
                if(((InstrumentData)object0).isValid()) {
                    arrayList1.add(object0);
                }
            }
            List list0 = p.J0(arrayList1, new a(2));
            JSONArray jSONArray0 = new JSONArray();
            f f0 = P4.a.K(0, Math.min(list0.size(), 5)).b();
            while(f0.c) {
                jSONArray0.put(list0.get(f0.nextInt()));
            }
            InstrumentUtility.sendReports("crash_reports", jSONArray0, new F5.a(list0, 1));
        }

        private static final int sendExceptionReports$lambda$2(InstrumentData instrumentData0, InstrumentData instrumentData1) {
            q.f(instrumentData1, "o2");
            return instrumentData0.compareTo(instrumentData1);
        }

        private static final void sendExceptionReports$lambda$5(List list0, GraphResponse graphResponse0) {
            q.g(list0, "$validReports");
            q.g(graphResponse0, "response");
            try {
                if(graphResponse0.getError() == null) {
                    JSONObject jSONObject0 = graphResponse0.getJsonObject();
                    if(jSONObject0 != null && jSONObject0.getBoolean("success")) {
                        for(Object object0: list0) {
                            ((InstrumentData)object0).clear();
                        }
                    }
                }
            }
            catch(JSONException unused_ex) {
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_CRASH_REPORT_NUM = 5;
    private static final String TAG;
    @Nullable
    private static CrashHandler instance;
    @Nullable
    private final Thread.UncaughtExceptionHandler previousHandler;

    static {
        CrashHandler.Companion = new Companion(null);
        CrashHandler.TAG = CrashHandler.class.getCanonicalName();
    }

    private CrashHandler(Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0) {
        this.previousHandler = thread$UncaughtExceptionHandler0;
    }

    public CrashHandler(Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(thread$UncaughtExceptionHandler0);
    }

    public static final void enable() {
        synchronized(CrashHandler.class) {
            CrashHandler.Companion.enable();
        }
    }

    @Override
    public void uncaughtException(@NotNull Thread thread0, @NotNull Throwable throwable0) {
        q.g(thread0, "t");
        q.g(throwable0, "e");
        if(InstrumentUtility.isSDKRelatedException(throwable0)) {
            ExceptionAnalyzer.execute(throwable0);
            Builder.build(throwable0, Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler0 = this.previousHandler;
        if(thread$UncaughtExceptionHandler0 != null) {
            thread$UncaughtExceptionHandler0.uncaughtException(thread0, throwable0);
        }
    }
}

