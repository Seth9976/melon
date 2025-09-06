package co.ab180.airbridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u000E\u0010\u000FR\u0019\u0010\u0007\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001C\u0010\r\u001A\u00020\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/AirbridgeLogLevel;", "", "", "b", "I", "getAndroidLogLevel", "()I", "androidLogLevel", "", "c", "Ljava/lang/String;", "getValue$airbridge_release", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "DEBUG", "INFO", "WARNING", "ERROR", "FAULT", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum AirbridgeLogLevel {
    DEBUG(2, "debug"),
    INFO(4, "info"),
    WARNING(5, "warning"),
    ERROR(6, "error"),
    FAULT(7, "fault");

    private final int b;
    @NotNull
    private final String c;

    private AirbridgeLogLevel(int v1, String s1) {
        this.b = v1;
        this.c = s1;
    }

    public final int getAndroidLogLevel() {
        return this.b;
    }

    @NotNull
    public final String getValue$airbridge_release() {
        return this.c;
    }
}

