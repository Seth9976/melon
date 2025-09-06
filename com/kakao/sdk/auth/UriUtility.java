package com.kakao.sdk.auth;

import android.net.Uri.Builder;
import android.net.Uri;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ServerHosts;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J¾\u0001\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\n\u001A\u00020\b2\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0010\b\u0002\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/auth/UriUtility;", "", "hosts", "Lcom/kakao/sdk/common/model/ServerHosts;", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "authorize", "Landroid/net/Uri;", "clientId", "", "agt", "redirectUri", "scopes", "", "kaHeader", "channelPublicIds", "serviceTerms", "prompts", "Lcom/kakao/sdk/auth/model/Prompt;", "loginHint", "nonce", "approvalType", "codeChallenge", "codeChallengeMethod", "kauthTxId", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UriUtility {
    @NotNull
    private final ServerHosts hosts;

    public UriUtility() {
        this(null, 1, null);
    }

    public UriUtility(@NotNull ServerHosts serverHosts0) {
        q.g(serverHosts0, "hosts");
        super();
        this.hosts = serverHosts0;
    }

    public UriUtility(ServerHosts serverHosts0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            serverHosts0 = KakaoSdk.INSTANCE.getHosts();
        }
        this(serverHosts0);
    }

    @NotNull
    public final Uri authorize(@NotNull String s, @Nullable String s1, @NotNull String s2, @Nullable List list0, @Nullable String s3, @Nullable List list1, @Nullable List list2, @Nullable List list3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
        q.g(s, "clientId");
        q.g(s2, "redirectUri");
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("https").authority("kauth.kakao.com").path("oauth/authorize").appendQueryParameter("client_id", s).appendQueryParameter("redirect_uri", s2).appendQueryParameter("response_type", "code").appendQueryParameter("ka", s3);
        if(s1 != null) {
            uri$Builder0.appendQueryParameter("agt", s1);
        }
        if(list0 != null && !list0.isEmpty()) {
            uri$Builder0.appendQueryParameter("scope", p.q0(list0, ",", null, null, null, 62));
        }
        if(list1 != null) {
            uri$Builder0.appendQueryParameter("channel_public_id", p.q0(list1, ",", null, null, null, 62));
        }
        if(list2 != null) {
            uri$Builder0.appendQueryParameter("service_terms", p.q0(list2, ",", null, null, null, 62));
        }
        if(list3 != null) {
            uri$Builder0.appendQueryParameter("prompt", p.q0(list3, ",", null, null, com.kakao.sdk.auth.UriUtility.authorize.1.4.1.INSTANCE, 30));
        }
        if(s4 != null) {
            uri$Builder0.appendQueryParameter("login_hint", s4);
        }
        if(s5 != null) {
            uri$Builder0.appendQueryParameter("nonce", s5);
        }
        if(s6 != null) {
            uri$Builder0.appendQueryParameter("approval_type", s6);
        }
        if(s7 != null) {
            uri$Builder0.appendQueryParameter("code_challenge", s7);
        }
        if(s8 != null) {
            uri$Builder0.appendQueryParameter("code_challenge_method", s8);
        }
        if(s9 != null) {
            uri$Builder0.appendQueryParameter("kauth_tx_id", s9);
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "Builder()\n        .schem…       }\n        .build()");
        return uri0;

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "prompt", "Lcom/kakao/sdk/auth/model/Prompt;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.auth.UriUtility.authorize.1.4.1 extends r implements k {
            public static final com.kakao.sdk.auth.UriUtility.authorize.1.4.1 INSTANCE;

            static {
                com.kakao.sdk.auth.UriUtility.authorize.1.4.1.INSTANCE = new com.kakao.sdk.auth.UriUtility.authorize.1.4.1();
            }

            public com.kakao.sdk.auth.UriUtility.authorize.1.4.1() {
                super(1);
            }

            @NotNull
            public final CharSequence invoke(@NotNull Prompt prompt0) {
                q.g(prompt0, "prompt");
                return prompt0.getValue();
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Prompt)object0));
            }
        }

    }

    public static Uri authorize$default(UriUtility uriUtility0, String s, String s1, String s2, List list0, String s3, List list1, List list2, List list3, String s4, String s5, String s6, String s7, String s8, String s9, int v, Object object0) {
        String s10 = (v & 2) == 0 ? s1 : null;
        List list4 = (v & 8) == 0 ? list0 : null;
        String s11 = (v & 16) == 0 ? s3 : null;
        List list5 = (v & 0x20) == 0 ? list1 : null;
        List list6 = (v & 0x40) == 0 ? list2 : null;
        List list7 = (v & 0x80) == 0 ? list3 : null;
        String s12 = (v & 0x100) == 0 ? s4 : null;
        String s13 = (v & 0x200) == 0 ? s5 : null;
        String s14 = (v & 0x400) == 0 ? s6 : null;
        String s15 = (v & 0x800) == 0 ? s7 : null;
        String s16 = (v & 0x1000) == 0 ? s8 : null;
        return (v & 0x2000) == 0 ? uriUtility0.authorize(s, s10, s2, list4, s11, list5, list6, list7, s12, s13, s14, s15, s16, s9) : uriUtility0.authorize(s, s10, s2, list4, s11, list5, list6, list7, s12, s13, s14, s15, s16, null);
    }
}

