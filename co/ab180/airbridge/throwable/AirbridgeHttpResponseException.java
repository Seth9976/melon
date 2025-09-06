package co.ab180.airbridge.throwable;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000B\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001A\u00020\b\u0012\b\b\u0002\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001A\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fR\u0019\u0010\u0010\u001A\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000E\u0010\n\u001A\u0004\b\u000F\u0010\f¨\u0006\u0013"}, d2 = {"Lco/ab180/airbridge/throwable/AirbridgeHttpResponseException;", "", "", "a", "I", "getResponseCode", "()I", "responseCode", "", "c", "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "method", "b", "getPayload", "payload", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeHttpResponseException extends Throwable {
    private final int a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;

    public AirbridgeHttpResponseException(int v, @NotNull String s, @NotNull String s1) {
        super(o.r(o.u(v, "Invalid response is received on ", s1, ": code={", "} payload={"), s, '}'));
        this.a = v;
        this.b = s;
        this.c = s1;
    }

    public AirbridgeHttpResponseException(int v, String s, String s1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            s = "";
        }
        if((v1 & 4) != 0) {
            s1 = "unknown method";
        }
        this(v, s, s1);
    }

    @NotNull
    public final String getMethod() {
        return this.c;
    }

    @NotNull
    public final String getPayload() {
        return this.b;
    }

    public final int getResponseCode() {
        return this.a;
    }
}

