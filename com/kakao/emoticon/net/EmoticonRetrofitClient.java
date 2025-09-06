package com.kakao.emoticon.net;

import com.google.gson.o;
import com.kakao.emoticon.constant.Config;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient.Builder;
import org.jetbrains.annotations.NotNull;
import tg.T;
import tg.U;
import ug.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonRetrofitClient;", "", "<init>", "()V", "Ltg/U;", "getInstance", "()Ltg/U;", "instance", "Ltg/U;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonRetrofitClient {
    public static final EmoticonRetrofitClient INSTANCE;
    private static U instance;

    static {
        EmoticonRetrofitClient.INSTANCE = new EmoticonRetrofitClient();
    }

    @NotNull
    public final U getInstance() {
        if(EmoticonRetrofitClient.instance == null) {
            T t0 = new T();
            t0.a("https://" + Config.ITEM_API_AUTHORITY);
            o o0 = new o();
            o0.k = 1;
            a a0 = new a(o0.a());
            t0.c.add(a0);
            t0.c(new Builder().addInterceptor(new EmoticonAuthInterceptor()).build());
            EmoticonRetrofitClient.instance = t0.b();
        }
        U u0 = EmoticonRetrofitClient.instance;
        q.d(u0);
        return u0;
    }
}

