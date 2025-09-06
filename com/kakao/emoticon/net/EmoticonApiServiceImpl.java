package com.kakao.emoticon.net;

import d3.g;
import ie.j;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\t\u001A\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiServiceImpl;", "", "<init>", "()V", "Lcom/kakao/emoticon/net/EmoticonApiService;", "apiClass$delegate", "Lie/j;", "getApiClass", "()Lcom/kakao/emoticon/net/EmoticonApiService;", "apiClass", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonApiServiceImpl {
    public static final EmoticonApiServiceImpl INSTANCE;
    @NotNull
    private static final j apiClass$delegate;

    static {
        EmoticonApiServiceImpl.INSTANCE = new EmoticonApiServiceImpl();
        EmoticonApiServiceImpl.apiClass$delegate = g.Q(EmoticonApiServiceImpl.apiClass.2.INSTANCE);
    }

    @NotNull
    public final EmoticonApiService getApiClass() {
        return (EmoticonApiService)EmoticonApiServiceImpl.apiClass$delegate.getValue();
    }
}

