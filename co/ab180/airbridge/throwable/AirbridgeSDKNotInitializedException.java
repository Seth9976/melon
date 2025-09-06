package co.ab180.airbridge.throwable;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lco/ab180/airbridge/throwable/AirbridgeSDKNotInitializedException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeSDKNotInitializedException extends IllegalStateException {
    public AirbridgeSDKNotInitializedException() {
        super("Airbridge SDK is not initialized");
    }
}

