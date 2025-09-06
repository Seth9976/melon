package com.kakao.emoticon.net;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import we.a;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/kakao/emoticon/net/EmoticonApiService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
final class EmoticonApiServiceImpl.apiClass.2 extends r implements a {
    public static final EmoticonApiServiceImpl.apiClass.2 INSTANCE;

    static {
        EmoticonApiServiceImpl.apiClass.2.INSTANCE = new EmoticonApiServiceImpl.apiClass.2();
    }

    public EmoticonApiServiceImpl.apiClass.2() {
        super(0);
    }

    public final EmoticonApiService invoke() {
        return (EmoticonApiService)EmoticonRetrofitClient.INSTANCE.getInstance().b(EmoticonApiService.class);
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }
}

