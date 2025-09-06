package com.facebook.internal.instrument.errorreport;

import E1.a;
import E5.b;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import je.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003J\u000F\u0010\n\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0007¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "<init>", "()V", "", "msg", "Lie/H;", "save", "(Ljava/lang/String;)V", "enable", "sendErrorReports", "", "Ljava/io/File;", "listErrorReportFiles", "()[Ljava/io/File;", "", "MAX_ERROR_REPORT_NUM", "I", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ErrorReportHandler {
    @NotNull
    public static final ErrorReportHandler INSTANCE = null;
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    static {
        ErrorReportHandler.INSTANCE = new ErrorReportHandler();
    }

    public static void a(ArrayList arrayList0, GraphResponse graphResponse0) {
        ErrorReportHandler.sendErrorReports$lambda$2(arrayList0, graphResponse0);
    }

    public static boolean b(File file0, String s) {
        return ErrorReportHandler.listErrorReportFiles$lambda$3(file0, s);
    }

    public static final void enable() {
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            ErrorReportHandler.sendErrorReports();
        }
    }

    @NotNull
    public static final File[] listErrorReportFiles() {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 == null) {
            return new File[0];
        }
        File[] arr_file = file0.listFiles(new b(3));
        q.f(arr_file, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
        return arr_file;
    }

    private static final boolean listErrorReportFiles$lambda$3(File file0, String s) {
        q.f(s, "name");
        Pattern pattern0 = Pattern.compile("^error_log_[0-9]+.json$");
        q.f(pattern0, "compile(...)");
        return pattern0.matcher(s).matches();
    }

    public static final void save(@Nullable String s) {
        try {
            new ErrorReportData(s).save();
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void sendErrorReports() {
        if(Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] arr_file = ErrorReportHandler.listErrorReportFiles();
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < arr_file.length; ++v1) {
            ErrorReportData errorReportData0 = new ErrorReportData(arr_file[v1]);
            if(errorReportData0.isValid()) {
                arrayList0.add(errorReportData0);
            }
        }
        t.S(arrayList0, new a(3));
        JSONArray jSONArray0 = new JSONArray();
        for(int v = 0; v < arrayList0.size() && v < 1000; ++v) {
            jSONArray0.put(arrayList0.get(v));
        }
        InstrumentUtility.sendReports("error_reports", jSONArray0, new E5.a(arrayList0, 1));
    }

    private static final int sendErrorReports$lambda$0(ErrorReportData errorReportData0, ErrorReportData errorReportData1) {
        q.f(errorReportData1, "o2");
        return errorReportData0.compareTo(errorReportData1);
    }

    private static final void sendErrorReports$lambda$2(ArrayList arrayList0, GraphResponse graphResponse0) {
        q.g(arrayList0, "$validReports");
        q.g(graphResponse0, "response");
        try {
            if(graphResponse0.getError() == null) {
                JSONObject jSONObject0 = graphResponse0.getJsonObject();
                if(jSONObject0 != null && jSONObject0.getBoolean("success")) {
                    for(Object object0: arrayList0) {
                        ((ErrorReportData)object0).clear();
                    }
                }
            }
        }
        catch(JSONException unused_ex) {
        }
    }
}

