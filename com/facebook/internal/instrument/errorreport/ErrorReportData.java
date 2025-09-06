package com.facebook.internal.instrument.errorreport;

import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\r¢\u0006\u0004\b\u0010\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001A\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u001F\u001A\u0004\u0018\u00010\u001C8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006!"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "", "", "message", "<init>", "(Ljava/lang/String;)V", "Ljava/io/File;", "file", "(Ljava/io/File;)V", "data", "", "compareTo", "(Lcom/facebook/internal/instrument/errorreport/ErrorReportData;)I", "Lie/H;", "save", "()V", "clear", "toString", "()Ljava/lang/String;", "filename", "Ljava/lang/String;", "errorMessage", "", "timestamp", "Ljava/lang/Long;", "", "isValid", "()Z", "Lorg/json/JSONObject;", "getParameters", "()Lorg/json/JSONObject;", "parameters", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ErrorReportData {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData$Companion;", "", "()V", "PARAM_TIMESTAMP", "", "PRARAM_ERROR_MESSAGE", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PARAM_TIMESTAMP = "timestamp";
    @NotNull
    private static final String PRARAM_ERROR_MESSAGE = "error_message";
    @Nullable
    private String errorMessage;
    @NotNull
    private String filename;
    @Nullable
    private Long timestamp;

    static {
        ErrorReportData.Companion = new Companion(null);
    }

    public ErrorReportData(@NotNull File file0) {
        q.g(file0, "file");
        super();
        String s = file0.getName();
        q.f(s, "file.name");
        this.filename = s;
        JSONObject jSONObject0 = InstrumentUtility.readFile(s, true);
        if(jSONObject0 != null) {
            this.timestamp = jSONObject0.optLong("timestamp", 0L);
            this.errorMessage = jSONObject0.optString("error_message", null);
        }
    }

    public ErrorReportData(@Nullable String s) {
        this.timestamp = (long)(System.currentTimeMillis() / 1000L);
        this.errorMessage = s;
        Long long0 = this.timestamp;
        q.e(long0, "null cannot be cast to non-null type kotlin.Long");
        String s1 = "error_log_" + ((long)long0) + ".json";
        q.f(s1, "StringBuffer()\n         …)\n            .toString()");
        this.filename = s1;
    }

    public final void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(@NotNull ErrorReportData errorReportData0) {
        q.g(errorReportData0, "data");
        Long long0 = this.timestamp;
        if(long0 != null) {
            long v = (long)long0;
            Long long1 = errorReportData0.timestamp;
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

    @Nullable
    public final JSONObject getParameters() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            Long long0 = this.timestamp;
            if(long0 != null) {
                jSONObject0.put("timestamp", long0);
            }
            jSONObject0.put("error_message", this.errorMessage);
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public final boolean isValid() {
        return this.errorMessage != null && this.timestamp != null;
    }

    public final void save() {
        if(this.isValid()) {
            InstrumentUtility.writeFile(this.filename, this.toString());
        }
    }

    @Override
    @NotNull
    public String toString() {
        JSONObject jSONObject0 = this.getParameters();
        if(jSONObject0 == null) {
            return super.toString();
        }
        String s = jSONObject0.toString();
        q.f(s, "params.toString()");
        return s;
    }
}

