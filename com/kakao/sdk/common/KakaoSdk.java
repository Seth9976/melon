package com.kakao.sdk.common;

import android.content.Context;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.model.ServerHosts;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.user.AppLifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0003JU\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\t\u00A2\u0006\u0004\b\u0012\u0010\u0018R\"\u0010\u001A\u001A\u00020\u00198\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\"\u0010\f\u001A\u00020\u000B8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\f\u0010 \u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\n\u001A\u00020\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\n\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R\"\u0010\u0016\u001A\u00020\u00158\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u0016\u0010*\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000E\u001A\u00020\r8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u000E\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0017\u001A\u00020\t2\u0006\u00104\u001A\u00020\t8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0017\u0010%\u001A\u0004\b\u0017\u0010\'R\u0011\u0010\u0007\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b5\u00106R\u0011\u00108\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b7\u00106R\u0011\u0010:\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b9\u00106R\u0011\u0010<\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b;\u00106\u00A8\u0006>"}, d2 = {"Lcom/kakao/sdk/common/KakaoSdk;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "appKey", "customScheme", "", "loggingEnabled", "Lcom/kakao/sdk/common/model/ServerHosts;", "hosts", "Lcom/kakao/sdk/common/model/ApprovalType;", "approvalType", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "sdkIdentifier", "Lie/H;", "init", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/common/model/ServerHosts;Lcom/kakao/sdk/common/model/ApprovalType;Lcom/kakao/sdk/common/model/SdkIdentifier;)V", "registerLifecycleEventObserver", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "type", "isAutomotive", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/kakao/sdk/common/model/ServerHosts;Lcom/kakao/sdk/common/model/ApprovalType;Lcom/kakao/sdk/common/KakaoSdk$Type;Lcom/kakao/sdk/common/model/SdkIdentifier;Z)V", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "applicationContextInfo", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "getApplicationContextInfo", "()Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "setApplicationContextInfo", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "Lcom/kakao/sdk/common/model/ServerHosts;", "getHosts", "()Lcom/kakao/sdk/common/model/ServerHosts;", "setHosts", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "Z", "getLoggingEnabled", "()Z", "setLoggingEnabled", "(Z)V", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "getType", "()Lcom/kakao/sdk/common/KakaoSdk$Type;", "setType", "(Lcom/kakao/sdk/common/KakaoSdk$Type;)V", "Lcom/kakao/sdk/common/model/ApprovalType;", "getApprovalType", "()Lcom/kakao/sdk/common/model/ApprovalType;", "setApprovalType", "(Lcom/kakao/sdk/common/model/ApprovalType;)V", "<set-?>", "getAppKey", "()Ljava/lang/String;", "getRedirectUri", "redirectUri", "getKaHeader", "kaHeader", "getKeyHash", "keyHash", "Type", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class KakaoSdk {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakao/sdk/common/KakaoSdk$Type;", "", "(Ljava/lang/String;I)V", "KOTLIN", "RX_KOTLIN", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Type {
        KOTLIN,
        RX_KOTLIN;

        private static final Type[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final KakaoSdk INSTANCE;
    public static ApplicationContextInfo applicationContextInfo;
    public static ApprovalType approvalType;
    public static ServerHosts hosts;
    private static boolean isAutomotive;
    private static boolean loggingEnabled;
    public static Type type;

    static {
        KakaoSdk.INSTANCE = new KakaoSdk();
    }

    @NotNull
    public final String getAppKey() {
        return this.getApplicationContextInfo().getAppKey();
    }

    @NotNull
    public final ApplicationContextInfo getApplicationContextInfo() {
        ApplicationContextInfo applicationContextInfo0 = KakaoSdk.applicationContextInfo;
        if(applicationContextInfo0 != null) {
            return applicationContextInfo0;
        }
        q.m("applicationContextInfo");
        throw null;
    }

    @NotNull
    public final ApprovalType getApprovalType() {
        ApprovalType approvalType0 = KakaoSdk.approvalType;
        if(approvalType0 != null) {
            return approvalType0;
        }
        q.m("approvalType");
        throw null;
    }

    @NotNull
    public final ServerHosts getHosts() {
        ServerHosts serverHosts0 = KakaoSdk.hosts;
        if(serverHosts0 != null) {
            return serverHosts0;
        }
        q.m("hosts");
        throw null;
    }

    @NotNull
    public final String getKaHeader() {
        return this.getApplicationContextInfo().getKaHeader();
    }

    @NotNull
    public final String getKeyHash() {
        return this.getApplicationContextInfo().getSigningKeyHash();
    }

    public final boolean getLoggingEnabled() [...] // 潜在的解密器

    @NotNull
    public final String getRedirectUri() {
        return this.getApplicationContextInfo().getRedirectUri();
    }

    @NotNull
    public final Type getType() {
        Type kakaoSdk$Type0 = KakaoSdk.type;
        if(kakaoSdk$Type0 != null) {
            return kakaoSdk$Type0;
        }
        q.m("type");
        throw null;
    }

    public static final void init(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk.init$default(context0, s, null, null, null, null, null, 0x7C, null);
    }

    public static final void init(@NotNull Context context0, @NotNull String s, @Nullable String s1) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk.init$default(context0, s, s1, null, null, null, null, 120, null);
    }

    public static final void init(@NotNull Context context0, @NotNull String s, @Nullable String s1, @Nullable Boolean boolean0) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk.init$default(context0, s, s1, boolean0, null, null, null, 0x70, null);
    }

    public static final void init(@NotNull Context context0, @NotNull String s, @Nullable String s1, @Nullable Boolean boolean0, @Nullable ServerHosts serverHosts0) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk.init$default(context0, s, s1, boolean0, serverHosts0, null, null, 0x60, null);
    }

    public static final void init(@NotNull Context context0, @NotNull String s, @Nullable String s1, @Nullable Boolean boolean0, @Nullable ServerHosts serverHosts0, @Nullable ApprovalType approvalType0) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk.init$default(context0, s, s1, boolean0, serverHosts0, approvalType0, null, 0x40, null);
    }

    public static final void init(@NotNull Context context0, @NotNull String s, @Nullable String s1, @Nullable Boolean boolean0, @Nullable ServerHosts serverHosts0, @Nullable ApprovalType approvalType0, @Nullable SdkIdentifier sdkIdentifier0) {
        q.g(context0, "context");
        q.g(s, "appKey");
        KakaoSdk kakaoSdk0 = KakaoSdk.INSTANCE;
        if(s1 == null) {
            s1 = "kakao" + s;
        }
        boolean z = boolean0 == null ? false : boolean0.booleanValue();
        if(serverHosts0 == null) {
            serverHosts0 = new ServerHosts();
        }
        ApprovalType approvalType1 = approvalType0 == null ? new ApprovalType() : approvalType0;
        SdkIdentifier sdkIdentifier1 = sdkIdentifier0 == null ? new SdkIdentifier(null, 1, null) : sdkIdentifier0;
        kakaoSdk0.init(context0, s, s1, z, serverHosts0, approvalType1, Type.KOTLIN, sdkIdentifier1, false);
    }

    public final void init(@NotNull Context context0, @NotNull String s, @NotNull String s1, boolean z, @NotNull ServerHosts serverHosts0, @NotNull ApprovalType approvalType0, @NotNull Type kakaoSdk$Type0, @NotNull SdkIdentifier sdkIdentifier0, boolean z1) {
        q.g(context0, "context");
        q.g(s, "appKey");
        q.g(s1, "customScheme");
        q.g(serverHosts0, "hosts");
        q.g(approvalType0, "approvalType");
        q.g(kakaoSdk$Type0, "type");
        q.g(sdkIdentifier0, "sdkIdentifier");
        this.setHosts(serverHosts0);
        KakaoSdk.loggingEnabled = z;
        this.setType(kakaoSdk$Type0);
        this.setApprovalType(approvalType0);
        this.setApplicationContextInfo(new ApplicationContextInfo(context0, s, s1, kakaoSdk$Type0, sdkIdentifier0, null, 0x20, null));
        KakaoSdk.isAutomotive = z1;
        this.registerLifecycleEventObserver();
    }

    public static void init$default(Context context0, String s, String s1, Boolean boolean0, ServerHosts serverHosts0, ApprovalType approvalType0, SdkIdentifier sdkIdentifier0, int v, Object object0) {
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            boolean0 = null;
        }
        if((v & 16) != 0) {
            serverHosts0 = null;
        }
        if((v & 0x20) != 0) {
            approvalType0 = null;
        }
        if((v & 0x40) != 0) {
            sdkIdentifier0 = null;
        }
        KakaoSdk.init(context0, s, s1, boolean0, serverHosts0, approvalType0, sdkIdentifier0);
    }

    public final boolean isAutomotive() [...] // 潜在的解密器

    private final void registerLifecycleEventObserver() {
        try {
            AppLifecycleObserver appLifecycleObserver0 = AppLifecycleObserver.getInstance();
            q.e(appLifecycleObserver0, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
            () -> this.f.f.a(appLifecycleObserver0);
        }
        catch(Exception exception0) {
            SdkLog.Companion.e("Failed to register AppLifecycleObserver " + exception0);
        }
    }

    public final void setApplicationContextInfo(@NotNull ApplicationContextInfo applicationContextInfo0) {
        q.g(applicationContextInfo0, "<set-?>");
        KakaoSdk.applicationContextInfo = applicationContextInfo0;
    }

    public final void setApprovalType(@NotNull ApprovalType approvalType0) {
        q.g(approvalType0, "<set-?>");
        KakaoSdk.approvalType = approvalType0;
    }

    public final void setHosts(@NotNull ServerHosts serverHosts0) {
        q.g(serverHosts0, "<set-?>");
        KakaoSdk.hosts = serverHosts0;
    }

    public final void setLoggingEnabled(boolean z) {
        KakaoSdk.loggingEnabled = z;
    }

    public final void setType(@NotNull Type kakaoSdk$Type0) {
        q.g(kakaoSdk$Type0, "<set-?>");
        KakaoSdk.type = kakaoSdk$Type0;
    }
}

