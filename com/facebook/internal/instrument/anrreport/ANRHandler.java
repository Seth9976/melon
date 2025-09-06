package com.facebook.internal.instrument.anrreport;

import Ce.f;
import E1.a;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "<init>", "()V", "Lie/H;", "enable", "sendANRReports", "", "MAX_ANR_REPORT_NUM", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ANRHandler {
    @NotNull
    public static final ANRHandler INSTANCE = null;
    private static final int MAX_ANR_REPORT_NUM = 5;
    @NotNull
    private static final AtomicBoolean enabled;

    static {
        ANRHandler.INSTANCE = new ANRHandler();
        ANRHandler.enabled = new AtomicBoolean(false);
    }

    public static void b(List list0, GraphResponse graphResponse0) {
        ANRHandler.sendANRReports$lambda$5(list0, graphResponse0);
    }

    public static final void enable() {
        synchronized(ANRHandler.class) {
            if(CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                return;
            }
            try {
                if(!ANRHandler.enabled.getAndSet(true)) {
                    if(FacebookSdk.getAutoLogAppEventsEnabled()) {
                        ANRHandler.sendANRReports();
                    }
                    ANRDetector.start();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, ANRHandler.class);
        }
    }

    public static final void sendANRReports() {
        Class class0 = ANRHandler.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(!Utility.isDataProcessingRestricted()) {
                    File[] arr_file = InstrumentUtility.listAnrReportFiles();
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
                    List list0 = p.J0(arrayList1, new a(1));
                    JSONArray jSONArray0 = new JSONArray();
                    f f0 = P4.a.K(0, Math.min(list0.size(), 5)).b();
                    while(f0.c) {
                        jSONArray0.put(list0.get(f0.nextInt()));
                    }
                    InstrumentUtility.sendReports("anr_reports", jSONArray0, new F5.a(list0, 0));
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private static final int sendANRReports$lambda$2(InstrumentData instrumentData0, InstrumentData instrumentData1) {
        Class class0 = ANRHandler.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            q.f(instrumentData1, "o2");
            return instrumentData0.compareTo(instrumentData1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return 0;
        }
    }

    private static final void sendANRReports$lambda$5(List list0, GraphResponse graphResponse0) {
        Class class0 = ANRHandler.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
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
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }
}

