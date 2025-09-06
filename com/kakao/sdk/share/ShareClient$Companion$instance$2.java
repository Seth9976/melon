package com.kakao.sdk.share;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/kakao/sdk/share/ShareClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
final class ShareClient.Companion.instance.2 extends r implements a {
    public static final ShareClient.Companion.instance.2 INSTANCE;

    static {
        ShareClient.Companion.instance.2.INSTANCE = new ShareClient.Companion.instance.2();
    }

    public ShareClient.Companion.instance.2() {
        super(0);
    }

    @NotNull
    public final ShareClient invoke() {
        return new ShareClient(null, null, 3, null);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }
}

