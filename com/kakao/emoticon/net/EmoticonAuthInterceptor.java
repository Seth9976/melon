package com.kakao.emoticon.net;

import android.os.Build.VERSION;
import com.kakao.emoticon.KakaoEmoticon;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import tg.u;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonAuthInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "Lokhttp3/Request$Builder;", "builder", "Lie/H;", "injectAuthHeader", "(Lokhttp3/Request$Builder;)V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonAuthInterceptor implements Interceptor {
    private final void injectAuthHeader(Builder request$Builder0) {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap0.put("Accept", "*/*");
        hashMap0.put("User-Agent", "os/android-" + Build.VERSION.SDK_INT);
        hashMap0.put("EA", HeaderInfo.INSTANCE.getEAHeader());
        KakaoEmoticon kakaoEmoticon0 = KakaoEmoticon.INSTANCE;
        String s = kakaoEmoticon0.getKAHeader();
        if(s != null) {
            hashMap0.put("KA", s);
        }
        if(KakaoEmoticon.isConnectedAccount()) {
            switch(KakaoEmoticon.getIdpType()) {
                case 1: {
                    boolean z1 = KakaoEmoticon.getIdpToken() != null;
                    q.f("", "KakaoEmoticon.idpToken ?: StringUtils.EMPTY");
                    hashMap0.put("Cookie", "");
                    StringBuilder stringBuilder1 = new StringBuilder("KakaoAK ");
                    String s1 = kakaoEmoticon0.getAppKey();
                    if(s1 == null) {
                        s1 = "";
                    }
                    stringBuilder1.append(s1);
                    hashMap0.put("Authorization", stringBuilder1.toString());
                    break;
                }
                case 2: {
                    boolean z2 = KakaoEmoticon.getIdpToken() != null;
                    q.f("", "KakaoEmoticon.idpToken ?: StringUtils.EMPTY");
                    hashMap0.put("LKA", "");
                    StringBuilder stringBuilder2 = new StringBuilder("KakaoAK ");
                    String s2 = kakaoEmoticon0.getAppKey();
                    if(s2 == null) {
                        s2 = "";
                    }
                    stringBuilder2.append(s2);
                    hashMap0.put("Authorization", stringBuilder2.toString());
                    break;
                }
                default: {
                    StringBuilder stringBuilder0 = new StringBuilder("Bearer ");
                    boolean z = KakaoEmoticon.getIdpToken() != null;
                    stringBuilder0.append("");
                    hashMap0.put("Authorization", "Bearer ");
                }
            }
        }
        else {
            StringBuilder stringBuilder3 = new StringBuilder("KakaoAK ");
            String s3 = kakaoEmoticon0.getAppKey();
            if(s3 == null) {
                s3 = "";
            }
            stringBuilder3.append(s3);
            hashMap0.put("Authorization", stringBuilder3.toString());
        }
        for(Object object0: hashMap0.entrySet()) {
            request$Builder0.header(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        NeedAuth needAuth0;
        q.g(interceptor$Chain0, "chain");
        u u0 = (u)interceptor$Chain0.request().tag(u.class);
        if(u0 == null) {
            needAuth0 = null;
        }
        else {
            Method method0 = u0.c;
            needAuth0 = method0 == null ? null : ((NeedAuth)method0.getAnnotation(NeedAuth.class));
        }
        if(needAuth0 != null) {
            Builder request$Builder0 = interceptor$Chain0.request().newBuilder();
            this.injectAuthHeader(request$Builder0);
            return interceptor$Chain0.proceed(request$Builder0.build());
        }
        return interceptor$Chain0.proceed(interceptor$Chain0.request());
    }
}

