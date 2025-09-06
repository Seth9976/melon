package com.kakao.sdk.auth;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\bD\b\u00C6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00A2\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00108\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010;\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010<\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010=\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010>\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010C\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000\u00A8\u0006H"}, d2 = {"Lcom/kakao/sdk/auth/Constants;", "", "()V", "ACCESS_TOKEN", "", "ACCESS_TOKEN_EXPIRES_AT", "ACCOUNT_LOGIN_PARAM_CONTINUE", "ACCOUNT_LOGIN_PATH", "AGT", "AGT_PATH", "ANDROID_KEY_HASH", "APPROVAL_TYPE", "AUTHORIZATION_CODE", "AUTHORIZE_PATH", "AUTOMOTIVE", "AUTOMOTIVE_VIEW", "CAPRI_LOGGED_IN_ACTIVITY", "CERT_TYPE", "CHANNEL_PUBLIC_ID", "CLIENT_ID", "CODE", "CODE_CHALLENGE", "CODE_CHALLENGE_ALGORITHM", "CODE_CHALLENGE_METHOD", "CODE_CHALLENGE_METHOD_VALUE", "CODE_VERIFIER", "CODE_VERIFIER_ALGORITHM", "DEVICE_TYPE", "ERROR", "ERROR_DESCRIPTION", "EXPIRES_IN", "EXTRA_APPLICATION_KEY", "EXTRA_ERROR_DESCRIPTION", "EXTRA_ERROR_TYPE", "EXTRA_EXTRAPARAMS", "EXTRA_KA_HEADER", "EXTRA_REDIRECT_URI", "EXTRA_REDIRECT_URL", "GRANT_TYPE", "ID_TOKEN", "KAUTH_TX_ID", "KA_HEADER", "KEY_BUNDLE", "KEY_CUSTOM_TABS_OPENED", "KEY_FULL_URI", "KEY_HEADERS", "KEY_LOGIN_INTENT", "KEY_REDIRECT_URI", "KEY_REQUEST_CODE", "KEY_RESULT_RECEIVER", "LOGIN_HINT", "NONCE", "NOT_SUPPORT_ERROR", "PREPARE_PATH", "PROMPT", "REDIRECT_URI", "REFRESH_TOKEN", "REFRESH_TOKEN_EXPIRES_AT", "REFRESH_TOKEN_EXPIRES_IN", "RESPONSE_TYPE", "SCOPE", "SECURE_RESOURCE", "SERVICE_TERMS", "SETTLE_ID", "SIGN_DATA", "SIGN_IDENTIFY_ITEMS", "STATE", "TOKEN_PATH", "TOKEN_TYPE", "TX_ID", "UNKNOWN_ERROR", "V1_CHECK_ACCESS_TOKEN", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Constants {
    @NotNull
    public static final String ACCESS_TOKEN = "access_token";
    @NotNull
    public static final String ACCESS_TOKEN_EXPIRES_AT = "access_token_expires_at";
    @NotNull
    public static final String ACCOUNT_LOGIN_PARAM_CONTINUE = "continue";
    @NotNull
    public static final String ACCOUNT_LOGIN_PATH = "/sdks/page";
    @NotNull
    public static final String AGT = "agt";
    @NotNull
    public static final String AGT_PATH = "api/agt";
    @NotNull
    public static final String ANDROID_KEY_HASH = "android_key_hash";
    @NotNull
    public static final String APPROVAL_TYPE = "approval_type";
    @NotNull
    public static final String AUTHORIZATION_CODE = "authorization_code";
    @NotNull
    public static final String AUTHORIZE_PATH = "oauth/authorize";
    @NotNull
    public static final String AUTOMOTIVE = "car";
    @NotNull
    public static final String AUTOMOTIVE_VIEW = "com.kakao.sdk.automotive.AutomotiveWebViewActivity";
    @NotNull
    public static final String CAPRI_LOGGED_IN_ACTIVITY = "com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY";
    @NotNull
    public static final String CERT_TYPE = "cert_type";
    @NotNull
    public static final String CHANNEL_PUBLIC_ID = "channel_public_id";
    @NotNull
    public static final String CLIENT_ID = "client_id";
    @NotNull
    public static final String CODE = "code";
    @NotNull
    public static final String CODE_CHALLENGE = "code_challenge";
    @NotNull
    public static final String CODE_CHALLENGE_ALGORITHM = "SHA-256";
    @NotNull
    public static final String CODE_CHALLENGE_METHOD = "code_challenge_method";
    @NotNull
    public static final String CODE_CHALLENGE_METHOD_VALUE = "S256";
    @NotNull
    public static final String CODE_VERIFIER = "code_verifier";
    @NotNull
    public static final String CODE_VERIFIER_ALGORITHM = "SHA-512";
    @NotNull
    public static final String DEVICE_TYPE = "device_type";
    @NotNull
    public static final String ERROR = "error";
    @NotNull
    public static final String ERROR_DESCRIPTION = "error_description";
    @NotNull
    public static final String EXPIRES_IN = "expires_in";
    @NotNull
    public static final String EXTRA_APPLICATION_KEY = "com.kakao.sdk.talk.appKey";
    @NotNull
    public static final String EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
    @NotNull
    public static final String EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
    @NotNull
    public static final String EXTRA_EXTRAPARAMS = "com.kakao.sdk.talk.extraparams";
    @NotNull
    public static final String EXTRA_KA_HEADER = "com.kakao.sdk.talk.kaHeader";
    @NotNull
    public static final String EXTRA_REDIRECT_URI = "com.kakao.sdk.talk.redirectUri";
    @NotNull
    public static final String EXTRA_REDIRECT_URL = "com.kakao.sdk.talk.redirectUrl";
    @NotNull
    public static final String GRANT_TYPE = "grant_type";
    @NotNull
    public static final String ID_TOKEN = "id_token";
    @NotNull
    public static final Constants INSTANCE = null;
    @NotNull
    public static final String KAUTH_TX_ID = "kauth_tx_id";
    @NotNull
    public static final String KA_HEADER = "ka";
    @NotNull
    public static final String KEY_BUNDLE = "key.bundle";
    @NotNull
    public static final String KEY_CUSTOM_TABS_OPENED = "key.customtabs.opened";
    @NotNull
    public static final String KEY_FULL_URI = "key.full_authorize_uri";
    @NotNull
    public static final String KEY_HEADERS = "key.extra.headers";
    @NotNull
    public static final String KEY_LOGIN_INTENT = "key.login.intent";
    @NotNull
    public static final String KEY_REDIRECT_URI = "key.redirect_uri";
    @NotNull
    public static final String KEY_REQUEST_CODE = "key.request.code";
    @NotNull
    public static final String KEY_RESULT_RECEIVER = "key.result.receiver";
    @NotNull
    public static final String LOGIN_HINT = "login_hint";
    @NotNull
    public static final String NONCE = "nonce";
    @NotNull
    public static final String NOT_SUPPORT_ERROR = "NotSupportError";
    @NotNull
    public static final String PREPARE_PATH = "oauth/authorize/prepare";
    @NotNull
    public static final String PROMPT = "prompt";
    @NotNull
    public static final String REDIRECT_URI = "redirect_uri";
    @NotNull
    public static final String REFRESH_TOKEN = "refresh_token";
    @NotNull
    public static final String REFRESH_TOKEN_EXPIRES_AT = "refresh_token_expires_at";
    @NotNull
    public static final String REFRESH_TOKEN_EXPIRES_IN = "refresh_token_expires_in";
    @NotNull
    public static final String RESPONSE_TYPE = "response_type";
    @NotNull
    public static final String SCOPE = "scope";
    @NotNull
    public static final String SECURE_RESOURCE = "secure_resource";
    @NotNull
    public static final String SERVICE_TERMS = "service_terms";
    @NotNull
    public static final String SETTLE_ID = "settle_id";
    @NotNull
    public static final String SIGN_DATA = "sign_data";
    @NotNull
    public static final String SIGN_IDENTIFY_ITEMS = "sign_identify_items";
    @NotNull
    public static final String STATE = "state";
    @NotNull
    public static final String TOKEN_PATH = "oauth/token";
    @NotNull
    public static final String TOKEN_TYPE = "token_type";
    @NotNull
    public static final String TX_ID = "tx_id";
    @NotNull
    public static final String UNKNOWN_ERROR = "unknown";
    @NotNull
    public static final String V1_CHECK_ACCESS_TOKEN = "/v1/user/check_access_token";

    static {
        Constants.INSTANCE = new Constants();
    }
}

