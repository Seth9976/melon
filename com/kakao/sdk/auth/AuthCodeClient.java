package com.kakao.sdk.auth;

import Tf.a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.IntentResolveClient;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import d3.g;
import ie.j;
import ie.o;
import java.security.MessageDigest;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001/B/\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0099\u0001\u0010 \u001A\u00020\u001E2\u0006\u0010\r\u001A\u00020\f2\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001A\u00020\u00142\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\u0010\b\u0002\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u00162\u001C\u0010\u001F\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0004\u0012\u00020\u001E0\u001CH\u0007\u00A2\u0006\u0004\b \u0010!J\u00B9\u0001\u0010%\u001A\u00020\u001E2\u0006\u0010\r\u001A\u00020\f2\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\u0010\b\u0002\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u00162\u001C\u0010\u001F\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0004\u0012\u00020\u001E0\u001CH\u0007\u00A2\u0006\u0004\b%\u0010&J3\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00160\'2\u001C\u0010\u001F\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0004\u0012\u00020\u001E0\u001CH\u0000\u00A2\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010.\u00A8\u00060"}, d2 = {"Lcom/kakao/sdk/auth/AuthCodeClient;", "", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "intentResolveClient", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ApprovalType;", "approvalType", "<init>", "(Lcom/kakao/sdk/common/util/IntentResolveClient;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApprovalType;)V", "Landroid/content/Context;", "context", "", "isKakaoTalkLoginAvailable", "(Landroid/content/Context;)Z", "", "Lcom/kakao/sdk/auth/model/Prompt;", "prompts", "", "requestCode", "", "nonce", "channelPublicIds", "serviceTerms", "codeVerifier", "kauthTxId", "Lkotlin/Function2;", "", "Lie/H;", "callback", "authorizeWithKakaoTalk", "(Landroid/content/Context;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lwe/n;)V", "scopes", "agt", "loginHint", "authorizeWithKakaoAccount", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lwe/n;)V", "Lcom/kakao/sdk/auth/SingleResultReceiver;", "resultReceiver$auth_release", "(Lwe/n;)Lcom/kakao/sdk/auth/SingleResultReceiver;", "resultReceiver", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ContextInfo;", "Lcom/kakao/sdk/common/model/ApprovalType;", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthCodeClient {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR!\u0010\u0010\u001A\u00020\n8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u0012\u0004\b\u000F\u0010\u0003\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0012\u001A\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/kakao/sdk/auth/AuthCodeClient$Companion;", "", "<init>", "()V", "", "codeVerifier", "()Ljava/lang/String;", "", "codeChallenge", "([B)Ljava/lang/String;", "Lcom/kakao/sdk/auth/AuthCodeClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/auth/AuthCodeClient;", "getInstance$annotations", "instance", "", "DEFAULT_REQUEST_CODE", "I", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String codeChallenge(@NotNull byte[] arr_b) {
            q.g(arr_b, "codeVerifier");
            String s = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(arr_b), 11);
            q.f(s, "encodeToString(\n        …64.URL_SAFE\n            )");
            return s;
        }

        // 去混淆评级： 低(24)
        @NotNull
        public final String codeVerifier() [...] // 潜在的解密器

        @NotNull
        public final AuthCodeClient getInstance() {
            return (AuthCodeClient)AuthCodeClient.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int DEFAULT_REQUEST_CODE = 10012;
    @NotNull
    private final ApplicationInfo applicationInfo;
    @NotNull
    private final ApprovalType approvalType;
    @NotNull
    private final ContextInfo contextInfo;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private final IntentResolveClient intentResolveClient;

    static {
        AuthCodeClient.Companion = new Companion(null);
        AuthCodeClient.instance$delegate = g.Q(AuthCodeClient.Companion.instance.2.INSTANCE);
    }

    public AuthCodeClient() {
        this(null, null, null, null, 15, null);
    }

    public AuthCodeClient(@NotNull IntentResolveClient intentResolveClient0, @NotNull ApplicationInfo applicationInfo0, @NotNull ContextInfo contextInfo0, @NotNull ApprovalType approvalType0) {
        q.g(intentResolveClient0, "intentResolveClient");
        q.g(applicationInfo0, "applicationInfo");
        q.g(contextInfo0, "contextInfo");
        q.g(approvalType0, "approvalType");
        super();
        this.intentResolveClient = intentResolveClient0;
        this.applicationInfo = applicationInfo0;
        this.contextInfo = contextInfo0;
        this.approvalType = approvalType0;
    }

    public AuthCodeClient(IntentResolveClient intentResolveClient0, ApplicationInfo applicationInfo0, ContextInfo contextInfo0, ApprovalType approvalType0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            intentResolveClient0 = IntentResolveClient.Companion.getInstance();
        }
        if((v & 2) != 0) {
            applicationInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 4) != 0) {
            contextInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 8) != 0) {
            approvalType0 = KakaoSdk.INSTANCE.getApprovalType();
        }
        this(intentResolveClient0, applicationInfo0, contextInfo0, approvalType0);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @Nullable List list2, @Nullable List list3, @Nullable String s2, @Nullable String s3, @Nullable String s4, @NotNull n n0) {
        String s9;
        q.g(context0, "context");
        q.g(n0, "callback");
        UriUtility uriUtility0 = new UriUtility(null, 1, null);
        String s5 = this.applicationInfo.getAppKey();
        String s6 = this.applicationInfo.getRedirectUri();
        String s7 = this.contextInfo.getKaHeader();
        String s8 = this.approvalType.getValue();
        if(s3 == null) {
            s9 = null;
        }
        else {
            byte[] arr_b = s3.getBytes(a.a);
            q.f(arr_b, "getBytes(...)");
            s9 = AuthCodeClient.Companion.codeChallenge(arr_b);
        }
        Uri uri0 = uriUtility0.authorize(s5, s1, s6, list1, s7, list2, list3, list0, s2, s, s8, s9, (s3 == null ? null : "S256"), s4);
        SdkLog.Companion.i(uri0);
        try {
            String s10 = this.applicationInfo.getRedirectUri();
            SingleResultReceiver singleResultReceiver0 = this.resultReceiver$auth_release(n0);
            context0.startActivity(IntentFactory.INSTANCE.account(context0, uri0, s10, singleResultReceiver0));
        }
        catch(Throwable throwable0) {
            SdkLog.Companion.e(throwable0);
            n0.invoke(null, throwable0);
        }
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @Nullable List list2, @Nullable List list3, @Nullable String s2, @Nullable String s3, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, s1, list2, list3, s2, s3, null, n0, 0x200, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @Nullable List list2, @Nullable List list3, @Nullable String s2, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, s1, list2, list3, s2, null, null, n0, 0x300, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @Nullable List list2, @Nullable List list3, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, s1, list2, list3, null, null, null, n0, 0x380, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @Nullable List list2, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, s1, list2, null, null, null, null, n0, 960, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @Nullable String s1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, s1, null, null, null, null, null, n0, 0x3E0, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @Nullable String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, s, null, null, null, null, null, null, n0, 0x3F0, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable List list1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, list1, null, null, null, null, null, null, null, n0, 0x3F8, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, list0, null, null, null, null, null, null, null, null, n0, 1020, null);
    }

    public final void authorizeWithKakaoAccount(@NotNull Context context0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(this, context0, null, null, null, null, null, null, null, null, null, n0, 0x3FE, null);
    }

    public static void authorizeWithKakaoAccount$default(AuthCodeClient authCodeClient0, Context context0, List list0, List list1, String s, String s1, List list2, List list3, String s2, String s3, String s4, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            list0 = null;
        }
        if((v & 4) != 0) {
            list1 = null;
        }
        if((v & 8) != 0) {
            s = null;
        }
        if((v & 16) != 0) {
            s1 = null;
        }
        if((v & 0x20) != 0) {
            list2 = null;
        }
        if((v & 0x40) != 0) {
            list3 = null;
        }
        if((v & 0x80) != 0) {
            s2 = null;
        }
        if((v & 0x100) != 0) {
            s3 = null;
        }
        if((v & 0x200) != 0) {
            s4 = null;
        }
        authCodeClient0.authorizeWithKakaoAccount(context0, list0, list1, s, s1, list2, list3, s2, s3, s4, n0);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @Nullable String s, @Nullable List list1, @Nullable List list2, @Nullable String s1, @Nullable String s2, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        if(!this.isKakaoTalkLoginAvailable(context0)) {
            n0.invoke(null, new ClientError(ClientErrorCause.NotSupported, "KakaoTalk not installed"));
            return;
        }
        try {
            String s3 = this.applicationInfo.getAppKey();
            String s4 = this.applicationInfo.getRedirectUri();
            String s5 = this.contextInfo.getKaHeader();
            IntentFactory intentFactory0 = IntentFactory.INSTANCE;
            Bundle bundle0 = new Bundle();
            if(list1 != null) {
                bundle0.putString("channel_public_id", p.q0(list1, ",", null, null, null, 62));
            }
            if(list2 != null) {
                bundle0.putString("service_terms", p.q0(list2, ",", null, null, null, 62));
            }
            String s6 = this.approvalType.getValue();
            if(s6 != null) {
                bundle0.putString("approval_type", s6);
            }
            if(s1 != null) {
                byte[] arr_b = s1.getBytes(a.a);
                q.f(arr_b, "getBytes(...)");
                bundle0.putString("code_challenge", AuthCodeClient.Companion.codeChallenge(arr_b));
                bundle0.putString("code_challenge_method", "S256");
            }
            if(list0 != null) {
                bundle0.putString("prompt", p.q0(list0, ",", null, null, com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1.INSTANCE, 30));
            }
            if(s != null) {
                bundle0.putString("nonce", s);
            }
            if(s2 != null) {
                bundle0.putString("kauth_tx_id", s2);
            }
            context0.startActivity(intentFactory0.talk(context0, v, s3, s4, s5, bundle0, this.resultReceiver$auth_release(n0)));
            return;
        }
        catch(Throwable throwable0) {
        }
        SdkLog.Companion.e(throwable0);
        n0.invoke(null, throwable0);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "prompt", "Lcom/kakao/sdk/auth/model/Prompt;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1 extends r implements k {
            public static final com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1 INSTANCE;

            static {
                com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1.INSTANCE = new com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1();
            }

            public com.kakao.sdk.auth.AuthCodeClient.authorizeWithKakaoTalk.1.5.1() {
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

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @Nullable String s, @Nullable List list1, @Nullable List list2, @Nullable String s1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, v, s, list1, list2, s1, null, n0, 0x80, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @Nullable String s, @Nullable List list1, @Nullable List list2, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, v, s, list1, list2, null, null, n0, 0xC0, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @Nullable String s, @Nullable List list1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, v, s, list1, null, null, null, n0, 0xE0, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @Nullable String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, v, s, null, null, null, null, n0, 0xF0, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, int v, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, v, null, null, null, null, null, n0, 0xF8, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @Nullable List list0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, list0, 0, null, null, null, null, null, n0, 0xFC, null);
    }

    public final void authorizeWithKakaoTalk(@NotNull Context context0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(this, context0, null, 0, null, null, null, null, null, n0, 0xFE, null);
    }

    public static void authorizeWithKakaoTalk$default(AuthCodeClient authCodeClient0, Context context0, List list0, int v, String s, List list1, List list2, String s1, String s2, n n0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            list0 = null;
        }
        if((v1 & 4) != 0) {
            v = 10012;
        }
        if((v1 & 8) != 0) {
            s = null;
        }
        if((v1 & 16) != 0) {
            list1 = null;
        }
        if((v1 & 0x20) != 0) {
            list2 = null;
        }
        if((v1 & 0x40) != 0) {
            s1 = null;
        }
        if((v1 & 0x80) != 0) {
            s2 = null;
        }
        authCodeClient0.authorizeWithKakaoTalk(context0, list0, v, s, list1, list2, s1, s2, n0);
    }

    @NotNull
    public static final AuthCodeClient getInstance() {
        return AuthCodeClient.Companion.getInstance();
    }

    public final boolean isKakaoTalkLoginAvailable(@NotNull Context context0) {
        q.g(context0, "context");
        Intent intent0 = IntentFactory.INSTANCE.talkBase();
        return this.intentResolveClient.resolveTalkIntent(context0, intent0) != null;
    }

    public final SingleResultReceiver resultReceiver$auth_release(n n0) {
        q.g(n0, "callback");
        com.kakao.sdk.auth.AuthCodeClient.resultReceiver.2 authCodeClient$resultReceiver$20 = new k() {
            {
                AuthCodeClient.this = authCodeClient0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Uri)object0));
            }

            @NotNull
            public final Throwable invoke(@NotNull Uri uri0) {
                AuthErrorCause authErrorCause0;
                q.g(uri0, "uri");
                String s = uri0.getQueryParameter("error");
                if(s == null) {
                    s = "unknown";
                }
                String s1 = uri0.getQueryParameter("error_description");
                try {
                    Json json0 = KakaoJson.INSTANCE.getJson();
                    json0.getSerializersModule();
                    authErrorCause0 = (AuthErrorCause)json0.decodeFromString(AuthErrorCause.Companion.serializer(), s);
                }
                catch(Throwable throwable0) {
                    authErrorCause0 = d5.n.t(throwable0);
                }
                AuthErrorCause authErrorCause1 = AuthErrorCause.Unknown;
                if(authErrorCause0 instanceof o) {
                    authErrorCause0 = authErrorCause1;
                }
                return new AuthError(302, authErrorCause0, new AuthErrorResponse(s, s1));
            }
        };
        return SingleResultReceiver.Companion.create(n0, "Auth Code", com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1.INSTANCE, authCodeClient$resultReceiver$20, com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1 extends r implements k {
            public static final com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1 INSTANCE;

            static {
                com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1.INSTANCE = new com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1();
            }

            public com.kakao.sdk.auth.AuthCodeClient.resultReceiver.1() {
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Uri)object0));
            }

            @Nullable
            public final String invoke(@NotNull Uri uri0) {
                q.g(uri0, "uri");
                return uri0.getQueryParameter("code");
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke", "(Landroid/net/Uri;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3 extends r implements k {
            public static final com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3 INSTANCE;

            static {
                com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3.INSTANCE = new com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3();
            }

            public com.kakao.sdk.auth.AuthCodeClient.resultReceiver.3() {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull Uri uri0) {
                q.g(uri0, "uri");
                String s = uri0.getQueryParameter("code");
                return s == null || s.length() == 0;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Uri)object0));
            }
        }

    }
}

