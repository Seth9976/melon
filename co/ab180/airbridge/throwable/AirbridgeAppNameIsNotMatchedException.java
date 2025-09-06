package co.ab180.airbridge.throwable;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lco/ab180/airbridge/throwable/AirbridgeAppNameIsNotMatchedException;", "", "", "appName", "<init>", "(Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeAppNameIsNotMatchedException extends Throwable {
    public AirbridgeAppNameIsNotMatchedException(@Nullable String s) {
        super("AppName is not matched. " + s);
    }
}

