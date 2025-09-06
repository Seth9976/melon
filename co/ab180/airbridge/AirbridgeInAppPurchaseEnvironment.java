package co.ab180.airbridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000E\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0007\u001A\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/AirbridgeInAppPurchaseEnvironment;", "", "", "b", "Ljava/lang/String;", "getValue$airbridge_release", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SANDBOX", "PRODUCTION", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum AirbridgeInAppPurchaseEnvironment {
    SANDBOX("sandbox"),
    PRODUCTION("production");

    @NotNull
    private final String b;

    private AirbridgeInAppPurchaseEnvironment(String s1) {
        this.b = s1;
    }

    @NotNull
    public final String getValue$airbridge_release() {
        return this.b;
    }
}

