package com.facebook.internal.instrument;

import Tf.v;
import android.os.Build.VERSION;
import android.os.Build;
import com.facebook.internal.Utility;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u0003435B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0012\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u0004\u0010\nB\u001D\b\u0012\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b\u0004\u0010\u000EB\u0011\b\u0012\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0004\u0010\u0011J\u0018\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0000H\u0086\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0018\u0010\u001E\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0018\u0010 \u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\"\u0010\u001DR\u0018\u0010#\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b#\u0010\u001DR\u0018\u0010$\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b$\u0010\u001DR\u0018\u0010&\u001A\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0016\u0010+\u001A\u0004\u0018\u00010(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b)\u0010*R\u0016\u0010-\u001A\u0004\u0018\u00010(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010*R\u0016\u0010/\u001A\u0004\u0018\u00010(8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010*R\u0011\u00101\u001A\u0002008F\u00A2\u0006\u0006\u001A\u0004\b1\u00102\u00A8\u00066"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData;", "", "Lorg/json/JSONArray;", "features", "<init>", "(Lorg/json/JSONArray;)V", "", "e", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "t", "(Ljava/lang/Throwable;Lcom/facebook/internal/instrument/InstrumentData$Type;)V", "", "anrCause", "st", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/io/File;", "file", "(Ljava/io/File;)V", "data", "", "compareTo", "(Lcom/facebook/internal/instrument/InstrumentData;)I", "Lie/H;", "save", "()V", "clear", "toString", "()Ljava/lang/String;", "filename", "Ljava/lang/String;", "type", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "featureNames", "Lorg/json/JSONArray;", "appVersion", "cause", "stackTrace", "", "timestamp", "Ljava/lang/Long;", "Lorg/json/JSONObject;", "getParameters", "()Lorg/json/JSONObject;", "parameters", "getAnalysisReportParameters", "analysisReportParameters", "getExceptionReportParameters", "exceptionReportParameters", "", "isValid", "()Z", "Companion", "Builder", "Type", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstrumentData {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001C\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\rH\u0007J\u0010\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Builder;", "", "()V", "build", "Lcom/facebook/internal/instrument/InstrumentData;", "anrCause", "", "st", "e", "", "t", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "features", "Lorg/json/JSONArray;", "load", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        public static final Builder INSTANCE;

        static {
            Builder.INSTANCE = new Builder();
        }

        @NotNull
        public static final InstrumentData build(@Nullable String s, @Nullable String s1) {
            return new InstrumentData(s, s1, null);
        }

        @NotNull
        public static final InstrumentData build(@Nullable Throwable throwable0, @NotNull Type instrumentData$Type0) {
            q.g(instrumentData$Type0, "t");
            return new InstrumentData(throwable0, instrumentData$Type0, null);
        }

        @NotNull
        public static final InstrumentData build(@NotNull JSONArray jSONArray0) {
            q.g(jSONArray0, "features");
            return new InstrumentData(jSONArray0, null);
        }

        @NotNull
        public static final InstrumentData load(@NotNull File file0) {
            q.g(file0, "file");
            return new InstrumentData(file0, null);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0004H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Companion;", "", "()V", "PARAM_APP_VERSION", "", "PARAM_CALLSTACK", "PARAM_DEVICE_MODEL", "PARAM_DEVICE_OS", "PARAM_FEATURE_NAMES", "PARAM_REASON", "PARAM_TIMESTAMP", "PARAM_TYPE", "UNKNOWN", "getType", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "filename", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Type access$getType(Companion instrumentData$Companion0, String s) {
            return instrumentData$Companion0.getType(s);
        }

        private final Type getType(String s) {
            if(v.r0(s, "crash_log_", false)) {
                return Type.CrashReport;
            }
            if(v.r0(s, "shield_log_", false)) {
                return Type.CrashShield;
            }
            if(v.r0(s, "thread_check_log_", false)) {
                return Type.ThreadCheck;
            }
            if(v.r0(s, "analysis_log_", false)) {
                return Type.Analysis;
            }
            return v.r0(s, "anr_log_", false) ? Type.AnrReport : Type.Unknown;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001A\u00020\u0004H\u0016R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Type;", "", "(Ljava/lang/String;I)V", "logPrefix", "", "getLogPrefix", "()Ljava/lang/String;", "toString", "Unknown", "Analysis", "AnrReport", "CrashReport", "CrashShield", "ThreadCheck", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Type {
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[Type.values().length];
                try {
                    arr_v[Type.Analysis.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Type.AnrReport.ordinal()] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Type.CrashReport.ordinal()] = 3;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Type.CrashShield.ordinal()] = 4;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[Type.ThreadCheck.ordinal()] = 5;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;

        private static final Type[] $values() [...] // Inlined contents

        @NotNull
        public final String getLogPrefix() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    return "analysis_log_";
                }
                case 2: {
                    return "anr_log_";
                }
                case 3: {
                    return "crash_log_";
                }
                case 4: {
                    return "shield_log_";
                }
                case 5: {
                    return "thread_check_log_";
                }
                default: {
                    return "Unknown";
                }
            }
        }

        @Override
        @NotNull
        public String toString() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: {
                    return "Analysis";
                }
                case 2: {
                    return "AnrReport";
                }
                case 3: {
                    return "CrashReport";
                }
                case 4: {
                    return "CrashShield";
                }
                case 5: {
                    return "ThreadCheck";
                }
                default: {
                    return "Unknown";
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class com.facebook.internal.instrument.InstrumentData.WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Type.values().length];
            try {
                arr_v[Type.Analysis.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Type.AnrReport.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Type.CrashReport.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Type.CrashShield.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Type.ThreadCheck.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            com.facebook.internal.instrument.InstrumentData.WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PARAM_APP_VERSION = "app_version";
    @NotNull
    private static final String PARAM_CALLSTACK = "callstack";
    @NotNull
    private static final String PARAM_DEVICE_MODEL = "device_model";
    @NotNull
    private static final String PARAM_DEVICE_OS = "device_os_version";
    @NotNull
    private static final String PARAM_FEATURE_NAMES = "feature_names";
    @NotNull
    private static final String PARAM_REASON = "reason";
    @NotNull
    private static final String PARAM_TIMESTAMP = "timestamp";
    @NotNull
    private static final String PARAM_TYPE = "type";
    @NotNull
    private static final String UNKNOWN = "Unknown";
    @Nullable
    private String appVersion;
    @Nullable
    private String cause;
    @Nullable
    private JSONArray featureNames;
    @NotNull
    private String filename;
    @Nullable
    private String stackTrace;
    @Nullable
    private Long timestamp;
    @Nullable
    private Type type;

    static {
        InstrumentData.Companion = new Companion(null);
    }

    private InstrumentData(File file0) {
        String s = file0.getName();
        q.f(s, "file.name");
        this.filename = s;
        this.type = Companion.access$getType(InstrumentData.Companion, s);
        JSONObject jSONObject0 = InstrumentUtility.readFile(this.filename, true);
        if(jSONObject0 != null) {
            this.timestamp = jSONObject0.optLong("timestamp", 0L);
            this.appVersion = jSONObject0.optString("app_version", null);
            this.cause = jSONObject0.optString("reason", null);
            this.stackTrace = jSONObject0.optString("callstack", null);
            this.featureNames = jSONObject0.optJSONArray("feature_names");
        }
    }

    public InstrumentData(File file0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(file0);
    }

    private InstrumentData(String s, String s1) {
        this.type = Type.AnrReport;
        this.appVersion = Utility.getAppVersion();
        this.cause = s;
        this.stackTrace = s1;
        this.timestamp = (long)(System.currentTimeMillis() / 1000L);
        String s2 = "anr_log_" + this.timestamp + ".json";
        q.f(s2, "StringBuffer()\n         …)\n            .toString()");
        this.filename = s2;
    }

    public InstrumentData(String s, String s1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1);
    }

    private InstrumentData(Throwable throwable0, Type instrumentData$Type0) {
        this.type = instrumentData$Type0;
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(throwable0);
        this.stackTrace = InstrumentUtility.getStackTrace(throwable0);
        this.timestamp = (long)(System.currentTimeMillis() / 1000L);
        String s = instrumentData$Type0.getLogPrefix() + this.timestamp + ".json";
        q.f(s, "StringBuffer().append(t.…ppend(\".json\").toString()");
        this.filename = s;
    }

    public InstrumentData(Throwable throwable0, Type instrumentData$Type0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(throwable0, instrumentData$Type0);
    }

    private InstrumentData(JSONArray jSONArray0) {
        this.type = Type.Analysis;
        this.timestamp = (long)(System.currentTimeMillis() / 1000L);
        this.featureNames = jSONArray0;
        String s = "analysis_log_" + this.timestamp + ".json";
        q.f(s, "StringBuffer()\n         …)\n            .toString()");
        this.filename = s;
    }

    public InstrumentData(JSONArray jSONArray0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(jSONArray0);
    }

    public final void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(@NotNull InstrumentData instrumentData0) {
        q.g(instrumentData0, "data");
        Long long0 = this.timestamp;
        if(long0 != null) {
            long v = (long)long0;
            Long long1 = instrumentData0.timestamp;
            if(long1 != null) {
                int v1 = Long.compare(((long)long1), v);
                if(v1 < 0) {
                    return -1;
                }
                return v1 == 0 ? 0 : 1;
            }
            return 1;
        }
        return -1;
    }

    private final JSONObject getAnalysisReportParameters() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            JSONArray jSONArray0 = this.featureNames;
            if(jSONArray0 != null) {
                jSONObject0.put("feature_names", jSONArray0);
            }
            Long long0 = this.timestamp;
            if(long0 != null) {
                jSONObject0.put("timestamp", long0);
            }
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    private final JSONObject getExceptionReportParameters() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("device_os_version", Build.VERSION.RELEASE);
            jSONObject0.put("device_model", Build.MODEL);
            String s = this.appVersion;
            if(s != null) {
                jSONObject0.put("app_version", s);
            }
            Long long0 = this.timestamp;
            if(long0 != null) {
                jSONObject0.put("timestamp", long0);
            }
            String s1 = this.cause;
            if(s1 != null) {
                jSONObject0.put("reason", s1);
            }
            String s2 = this.stackTrace;
            if(s2 != null) {
                jSONObject0.put("callstack", s2);
            }
            Type instrumentData$Type0 = this.type;
            if(instrumentData$Type0 != null) {
                jSONObject0.put("type", instrumentData$Type0);
            }
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    private final JSONObject getParameters() {
        switch((this.type == null ? -1 : com.facebook.internal.instrument.InstrumentData.WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()])) {
            case 1: {
                return this.getAnalysisReportParameters();
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return this.getExceptionReportParameters();
            }
            default: {
                return null;
            }
        }
    }

    public final boolean isValid() {
        switch((this.type == null ? -1 : com.facebook.internal.instrument.InstrumentData.WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()])) {
            case 1: {
                return this.featureNames != null && this.timestamp != null;
            }
            case 2: {
                return this.stackTrace != null && this.cause != null && this.timestamp != null;
            }
            case 3: 
            case 4: 
            case 5: {
                return this.stackTrace != null && this.timestamp != null;
            }
            default: {
                return false;
            }
        }
    }

    public final void save() {
        if(!this.isValid()) {
            return;
        }
        InstrumentUtility.writeFile(this.filename, this.toString());
    }

    @Override
    @NotNull
    public String toString() {
        JSONObject jSONObject0 = this.getParameters();
        if(jSONObject0 == null) {
            q.f("{}", "JSONObject().toString()");
            return "{}";
        }
        String s = jSONObject0.toString();
        q.f(s, "params.toString()");
        return s;
    }
}

