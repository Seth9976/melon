package com.kakao.emoticon.net;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class HeaderInfo.eAHeader.2 extends r implements a {
    public static final HeaderInfo.eAHeader.2 INSTANCE;

    static {
        HeaderInfo.eAHeader.2.INSTANCE = new HeaderInfo.eAHeader.2();
    }

    public HeaderInfo.eAHeader.2() {
        super(0);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }

    @NotNull
    public final String invoke() {
        return "sdk/2.0.1 density/" + HeaderInfo.INSTANCE.getEmoticonDensity();
    }
}

