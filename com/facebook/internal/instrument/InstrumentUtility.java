package com.facebook.internal.instrument;

import E5.b;
import Tf.a;
import Tf.v;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\t\u001A\u0004\u0018\u00010\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\bJ\u0019\u0010\t\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0007\u00A2\u0006\u0004\b\t\u0010\fJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0010\u001A\u00020\r2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0015J#\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ#\u0010\u001F\u001A\u00020\u001E2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b\u001F\u0010 J\u0019\u0010!\u001A\u00020\r2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b!\u0010\"J+\u0010(\u001A\u00020\u001E2\b\u0010#\u001A\u0004\u0018\u00010\u00062\u0006\u0010%\u001A\u00020$2\b\u0010\'\u001A\u0004\u0018\u00010&H\u0007\u00A2\u0006\u0004\b(\u0010)J\u0011\u0010*\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010.\u001A\u00020\r2\u0006\u0010-\u001A\u00020,H\u0007\u00A2\u0006\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00104\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b4\u00101R\u0014\u00105\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b5\u00101R\u0014\u00106\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b6\u00101R\u0014\u00107\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b7\u00101R\u0014\u00108\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b8\u00101R\u0014\u00109\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b9\u00101R\u0014\u0010:\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b:\u00101R\u0014\u0010;\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u00101\u00A8\u0006<"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "<init>", "()V", "", "e", "", "getCause", "(Ljava/lang/Throwable;)Ljava/lang/String;", "getStackTrace", "Ljava/lang/Thread;", "thread", "(Ljava/lang/Thread;)Ljava/lang/String;", "", "isSDKRelatedException", "(Ljava/lang/Throwable;)Z", "isSDKRelatedThread", "(Ljava/lang/Thread;)Z", "", "Ljava/io/File;", "listAnrReportFiles", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "filename", "deleteOnException", "Lorg/json/JSONObject;", "readFile", "(Ljava/lang/String;Z)Lorg/json/JSONObject;", "content", "Lie/H;", "writeFile", "(Ljava/lang/String;Ljava/lang/String;)V", "deleteFile", "(Ljava/lang/String;)Z", "key", "Lorg/json/JSONArray;", "reports", "Lcom/facebook/GraphRequest$Callback;", "callback", "sendReports", "(Ljava/lang/String;Lorg/json/JSONArray;Lcom/facebook/GraphRequest$Callback;)V", "getInstrumentReportDir", "()Ljava/io/File;", "Ljava/lang/StackTraceElement;", "element", "isFromFbOrMeta", "(Ljava/lang/StackTraceElement;)Z", "ANALYSIS_REPORT_PREFIX", "Ljava/lang/String;", "ANR_REPORT_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "THREAD_CHECK_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "METASDK_PREFIX", "CODELESS_PREFIX", "SUGGESTED_EVENTS_PREFIX", "INSTRUMENT_DIR", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstrumentUtility {
    @NotNull
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    @NotNull
    public static final String ANR_REPORT_PREFIX = "anr_log_";
    @NotNull
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    @NotNull
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    @NotNull
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    @NotNull
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    @NotNull
    private static final String FBSDK_PREFIX = "com.facebook";
    @NotNull
    public static final InstrumentUtility INSTANCE = null;
    @NotNull
    private static final String INSTRUMENT_DIR = "instrument";
    @NotNull
    private static final String METASDK_PREFIX = "com.meta";
    @NotNull
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";
    @NotNull
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    static {
        InstrumentUtility.INSTANCE = new InstrumentUtility();
    }

    public static boolean a(File file0, String s) {
        return InstrumentUtility.listExceptionAnalysisReportFiles$lambda$2(file0, s);
    }

    public static boolean b(File file0, String s) {
        return InstrumentUtility.listExceptionReportFiles$lambda$3(file0, s);
    }

    public static boolean c(File file0, String s) {
        return InstrumentUtility.listAnrReportFiles$lambda$1(file0, s);
    }

    public static final boolean deleteFile(@Nullable String s) {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        return file0 == null || s == null ? false : new File(file0, s).delete();
    }

    @Nullable
    public static final String getCause(@Nullable Throwable throwable0) {
        if(throwable0 == null) {
            return null;
        }
        return throwable0.getCause() == null ? throwable0.toString() : String.valueOf(throwable0.getCause());
    }

    @Nullable
    public static final File getInstrumentReportDir() {
        File file0 = new File(FacebookSdk.getApplicationContext().getCacheDir(), "instrument");
        return file0.exists() || file0.mkdirs() ? file0 : null;
    }

    @Nullable
    public static final String getStackTrace(@NotNull Thread thread0) {
        q.g(thread0, "thread");
        StackTraceElement[] arr_stackTraceElement = thread0.getStackTrace();
        JSONArray jSONArray0 = new JSONArray();
        q.f(arr_stackTraceElement, "stackTrace");
        for(int v = 0; v < arr_stackTraceElement.length; ++v) {
            jSONArray0.put(arr_stackTraceElement[v].toString());
        }
        return jSONArray0.toString();
    }

    @Nullable
    public static final String getStackTrace(@Nullable Throwable throwable0) {
        Throwable throwable1 = null;
        if(throwable0 == null) {
            return null;
        }
        JSONArray jSONArray0 = new JSONArray();
        while(throwable0 != null && throwable0 != throwable1) {
            StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
            q.f(arr_stackTraceElement, "t.stackTrace");
            for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                jSONArray0.put(arr_stackTraceElement[v].toString());
            }
            throwable1 = throwable0;
            throwable0 = throwable0.getCause();
        }
        return jSONArray0.toString();
    }

    public static final boolean isFromFbOrMeta(@NotNull StackTraceElement stackTraceElement0) {
        q.g(stackTraceElement0, "element");
        String s = stackTraceElement0.getClassName();
        q.f(s, "element.className");
        if(!v.r0(s, "com.facebook", false)) {
            String s1 = stackTraceElement0.getClassName();
            q.f(s1, "element.className");
            return v.r0(s1, "com.meta", false);
        }
        return true;
    }

    public static final boolean isSDKRelatedException(@Nullable Throwable throwable0) {
        if(throwable0 == null) {
            return false;
        }
        Throwable throwable1 = null;
        while(throwable0 != null && throwable0 != throwable1) {
            StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
            q.f(arr_stackTraceElement, "t.stackTrace");
            for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
                q.f(stackTraceElement0, "element");
                if(InstrumentUtility.isFromFbOrMeta(stackTraceElement0)) {
                    return true;
                }
            }
            throwable1 = throwable0;
            throwable0 = throwable0.getCause();
        }
        return false;
    }

    public static final boolean isSDKRelatedThread(@Nullable Thread thread0) {
        if(thread0 != null) {
            StackTraceElement[] arr_stackTraceElement = thread0.getStackTrace();
            if(arr_stackTraceElement != null) {
                int v = 0;
                while(v < arr_stackTraceElement.length) {
                    StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
                    q.f(stackTraceElement0, "element");
                    if(InstrumentUtility.isFromFbOrMeta(stackTraceElement0)) {
                        String s = stackTraceElement0.getClassName();
                        q.f(s, "element.className");
                        if(!v.r0(s, "com.facebook.appevents.codeless", false)) {
                            String s1 = stackTraceElement0.getClassName();
                            q.f(s1, "element.className");
                            if(v.r0(s1, "com.facebook.appevents.suggestedevents", false)) {
                                goto label_14;
                            }
                            return true;
                        }
                    label_14:
                        String s2 = stackTraceElement0.getMethodName();
                        q.f(s2, "element.methodName");
                        if(!v.r0(s2, "onClick", false)) {
                            String s3 = stackTraceElement0.getMethodName();
                            q.f(s3, "element.methodName");
                            if(!v.r0(s3, "onItemClick", false)) {
                                String s4 = stackTraceElement0.getMethodName();
                                q.f(s4, "element.methodName");
                                if(v.r0(s4, "onTouch", false)) {
                                    goto label_24;
                                }
                                return true;
                            }
                        }
                    }
                label_24:
                    ++v;
                }
            }
        }
        return false;
    }

    @NotNull
    public static final File[] listAnrReportFiles() {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 == null) {
            return new File[0];
        }
        File[] arr_file = file0.listFiles(new b(1));
        return arr_file == null ? new File[0] : arr_file;
    }

    private static final boolean listAnrReportFiles$lambda$1(File file0, String s) {
        q.f(s, "name");
        Pattern pattern0 = Pattern.compile("^anr_log_[0-9]+.json$");
        q.f(pattern0, "compile(...)");
        return pattern0.matcher(s).matches();
    }

    @NotNull
    public static final File[] listExceptionAnalysisReportFiles() {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 == null) {
            return new File[0];
        }
        File[] arr_file = file0.listFiles(new b(2));
        return arr_file == null ? new File[0] : arr_file;
    }

    private static final boolean listExceptionAnalysisReportFiles$lambda$2(File file0, String s) {
        q.f(s, "name");
        Pattern pattern0 = Pattern.compile("^analysis_log_[0-9]+.json$");
        q.f(pattern0, "compile(...)");
        return pattern0.matcher(s).matches();
    }

    @NotNull
    public static final File[] listExceptionReportFiles() {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 == null) {
            return new File[0];
        }
        File[] arr_file = file0.listFiles(new b(0));
        return arr_file == null ? new File[0] : arr_file;
    }

    private static final boolean listExceptionReportFiles$lambda$3(File file0, String s) {
        q.f(s, "name");
        Pattern pattern0 = Pattern.compile("^(crash_log_|shield_log_|thread_check_log_)[0-9]+.json$");
        q.f(pattern0, "compile(...)");
        return pattern0.matcher(s).matches();
    }

    @Nullable
    public static final JSONObject readFile(@Nullable String s, boolean z) {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 != null && s != null) {
            File file1 = new File(file0, s);
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(file1)));
            }
            catch(Exception unused_ex) {
                if(z) {
                    InstrumentUtility.deleteFile(s);
                }
            }
        }
        return null;
    }

    public static final void sendReports(@Nullable String s, @NotNull JSONArray jSONArray0, @Nullable Callback graphRequest$Callback0) {
        q.g(jSONArray0, "reports");
        if(jSONArray0.length() != 0) {
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put(s, jSONArray0.toString());
                JSONObject jSONObject1 = Utility.getDataProcessingOptions();
                if(jSONObject1 != null) {
                    Iterator iterator0 = jSONObject1.keys();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        jSONObject0.put(((String)object0), jSONObject1.get(((String)object0)));
                    }
                }
            }
            catch(JSONException unused_ex) {
                return;
            }
            String s1 = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            GraphRequest.Companion.newPostRequest(null, s1, jSONObject0, graphRequest$Callback0).executeAsync();
        }
    }

    public static final void writeFile(@Nullable String s, @Nullable String s1) {
        File file0 = InstrumentUtility.getInstrumentReportDir();
        if(file0 != null && s != null && s1 != null) {
            File file1 = new File(file0, s);
            try {
                FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
                byte[] arr_b = s1.getBytes(a.a);
                q.f(arr_b, "this as java.lang.String).getBytes(charset)");
                fileOutputStream0.write(arr_b);
                fileOutputStream0.close();
            }
            catch(Exception unused_ex) {
            }
        }
    }
}

