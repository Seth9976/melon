package co.ab180.airbridge.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\r"}, d2 = {"Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;", "", "", "b", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GAID", "OAID", "APP_SET_ID", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum AirbridgeTrackingBlocklist {
    GAID("gaid"),
    OAID("oaid"),
    APP_SET_ID("appSetID");

    @NotNull
    private final String b;

    private AirbridgeTrackingBlocklist(String s1) {
        this.b = s1;
    }

    @NotNull
    public final String getValue() {
        return this.b;
    }
}

