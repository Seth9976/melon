package co.ab180.airbridge;

import co.ab180.airbridge.common.Purchase;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0010\u001A\u00020\u000B¢\u0006\u0004\b\u0015\u0010\u0016R2\u0010\n\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001A\u00020\u000B8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR2\u0010\u0014\u001A\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001A\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/AirbridgeInAppPurchase;", "", "", "", "a", "Ljava/util/Map;", "getSemanticAttributes", "()Ljava/util/Map;", "setSemanticAttributes", "(Ljava/util/Map;)V", "semanticAttributes", "Lco/ab180/airbridge/common/Purchase;", "c", "Lco/ab180/airbridge/common/Purchase;", "getPurchase", "()Lco/ab180/airbridge/common/Purchase;", "purchase", "b", "getCustomAttributes", "setCustomAttributes", "customAttributes", "<init>", "(Lco/ab180/airbridge/common/Purchase;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeInAppPurchase {
    @Nullable
    private Map a;
    @Nullable
    private Map b;
    @NotNull
    private final Purchase c;

    public AirbridgeInAppPurchase(@NotNull Purchase purchase0) {
        this.c = purchase0;
    }

    @Nullable
    public final Map getCustomAttributes() {
        return this.b;
    }

    @NotNull
    public final Purchase getPurchase() {
        return this.c;
    }

    @Nullable
    public final Map getSemanticAttributes() {
        return this.a;
    }

    public final void setCustomAttributes(@Nullable Map map0) {
        this.b = map0;
    }

    public final void setSemanticAttributes(@Nullable Map map0) {
        this.a = map0;
    }
}

