package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 H2\u00020\u0001:\u0003IHJB\u0083\u0001\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017B#\b\u0017\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\u000E\u0010\u001A\u001A\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019\u00A2\u0006\u0004\b\u0016\u0010\u001BB%\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u001C\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\u0016\u0010\u001DB\u0011\b\u0012\u0012\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b\u0016\u0010 J\u000F\u0010!\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010&\u001A\u00020%2\u0006\u0010#\u001A\u00020\u001E2\u0006\u0010$\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010*\u001A\u0004\b+\u0010)R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010*\u001A\u0004\b,\u0010)R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010*\u001A\u0004\b-\u0010)R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010.\u001A\u0004\b/\u0010\"R\u0019\u0010\t\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\t\u0010.\u001A\u0004\b0\u0010\"R\u0019\u0010\n\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\n\u0010.\u001A\u0004\b1\u0010\"R\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006\u00A2\u0006\f\n\u0004\b\f\u00102\u001A\u0004\b3\u00104R\u0019\u0010\r\u001A\u0004\u0018\u00010\u000B8\u0006\u00A2\u0006\f\n\u0004\b\r\u00102\u001A\u0004\b5\u00104R\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00106\u001A\u0004\b7\u00108R\u0019\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006\u00A2\u0006\f\n\u0004\b\u0011\u00109\u001A\u0004\b:\u0010;R\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u00068F\u00A2\u0006\f\n\u0004\b\u001C\u0010.\u001A\u0004\b<\u0010\"R(\u0010\u001A\u001A\u0004\u0018\u00010\u00122\b\u0010=\u001A\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u001A\u0010>\u001A\u0004\b?\u0010@R\u0017\u0010B\u001A\u00020A8\u0006\u00A2\u0006\f\n\u0004\bB\u0010C\u001A\u0004\bD\u0010ER\u0019\u0010F\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\bF\u0010.\u001A\u0004\bG\u0010\"\u00A8\u0006K"}, d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", "", "requestStatusCode", "errorCode", "subErrorCode", "", "errorType", "errorMessageField", "errorUserTitle", "errorUserMessage", "Lorg/json/JSONObject;", "requestResultBody", "requestResult", "", "batchRequestResult", "Ljava/net/HttpURLConnection;", "connection", "Lcom/facebook/FacebookException;", "exceptionField", "", "errorIsTransient", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "errorMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "toString", "()Ljava/lang/String;", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "I", "getRequestStatusCode", "getErrorCode", "getSubErrorCode", "Ljava/lang/String;", "getErrorType", "getErrorUserTitle", "getErrorUserMessage", "Lorg/json/JSONObject;", "getRequestResultBody", "()Lorg/json/JSONObject;", "getRequestResult", "Ljava/lang/Object;", "getBatchRequestResult", "()Ljava/lang/Object;", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "getErrorMessage", "<set-?>", "Lcom/facebook/FacebookException;", "getException", "()Lcom/facebook/FacebookException;", "Lcom/facebook/FacebookRequestError$Category;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "errorRecoveryMessage", "getErrorRecoveryMessage", "Companion", "Category", "Range", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookRequestError implements Parcelable {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/FacebookRequestError$Category;", "", "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        private static final Category[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001F\u001A\u0004\u0018\u00010\b2\u0006\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u00012\b\u0010#\u001A\u0004\u0018\u00010$H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0018\u001A\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001B\u001A\u00020\u001C8G¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006%"}, d2 = {"Lcom/facebook/FacebookRequestError$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "INVALID_ERROR_CODE", "", "INVALID_HTTP_STATUS_CODE", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "checkResponseAndCreateError", "singleResult", "Lorg/json/JSONObject;", "batchResult", "connection", "Ljava/net/HttpURLConnection;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final FacebookRequestError checkResponseAndCreateError(@NotNull JSONObject jSONObject0, @Nullable Object object0, @Nullable HttpURLConnection httpURLConnection0) {
            boolean z2;
            String s5;
            Object object2;
            String s4;
            int v3;
            String s2;
            String s1;
            q.g(jSONObject0, "singleResult");
            try {
                if(jSONObject0.has("code")) {
                    int v = jSONObject0.getInt("code");
                    Object object1 = Utility.getStringPropertyAsJSON(jSONObject0, "body", "FACEBOOK_NON_JSON_RESULT");
                    if(object1 != null && object1 instanceof JSONObject) {
                        boolean z = true;
                        boolean z1 = false;
                        int v1 = -1;
                        if(((JSONObject)object1).has("error")) {
                            JSONObject jSONObject1 = (JSONObject)Utility.getStringPropertyAsJSON(((JSONObject)object1), "error", null);
                            String s = jSONObject1 == null ? null : jSONObject1.optString("type", null);
                            s1 = jSONObject1 == null ? null : jSONObject1.optString("message", null);
                            int v2 = jSONObject1 == null ? -1 : jSONObject1.optInt("code", -1);
                            if(jSONObject1 != null) {
                                v1 = jSONObject1.optInt("error_subcode", -1);
                            }
                            s2 = jSONObject1 == null ? null : jSONObject1.optString("error_user_msg", null);
                            String s3 = jSONObject1 == null ? null : jSONObject1.optString("error_user_title", null);
                            if(jSONObject1 != null) {
                                z1 = jSONObject1.optBoolean("is_transient", false);
                            }
                            v3 = v1;
                            v1 = v2;
                            s4 = s;
                            object2 = object1;
                            s5 = s3;
                            z2 = z1;
                        }
                        else {
                            if(((JSONObject)object1).has("error_code") || (((JSONObject)object1).has("error_msg") || ((JSONObject)object1).has("error_reason"))) {
                                String s6 = ((JSONObject)object1).optString("error_reason", null);
                                s1 = ((JSONObject)object1).optString("error_msg", null);
                                v1 = ((JSONObject)object1).optInt("error_code", -1);
                                v3 = ((JSONObject)object1).optInt("error_subcode", -1);
                                s4 = s6;
                                object2 = object1;
                                z2 = false;
                                s5 = null;
                            }
                            else {
                                object2 = object1;
                                z = false;
                                z2 = false;
                                v3 = -1;
                                s4 = null;
                                s5 = null;
                                s1 = null;
                            }
                            s2 = null;
                        }
                        if(z) {
                            return new FacebookRequestError(v, v1, v3, s4, s1, s5, s2, ((JSONObject)object2), jSONObject0, object0, httpURLConnection0, null, z2, null);
                        }
                    }
                    return this.getHTTP_RANGE_SUCCESS$facebook_core_release().contains(v) ? null : new FacebookRequestError(v, -1, -1, null, null, null, null, (jSONObject0.has("body") ? ((JSONObject)Utility.getStringPropertyAsJSON(jSONObject0, "body", "FACEBOOK_NON_JSON_RESULT")) : null), jSONObject0, object0, httpURLConnection0, null, false, null);
                }
            }
            catch(JSONException unused_ex) {
            }
            return null;
        }

        @NotNull
        public final FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettings fetchedAppSettings0;
            synchronized(this) {
                fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                if(fetchedAppSettings0 == null) {
                    return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
                }
            }
            return fetchedAppSettings0.getErrorClassification();
        }

        @NotNull
        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H\u0086\u0002R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/FacebookRequestError$Range;", "", "start", "", "end", "(II)V", "contains", "", "value", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Range {
        private final int end;
        private final int start;

        public Range(int v, int v1) {
            this.start = v;
            this.end = v1;
        }

        public final boolean contains(int v) {
            return v <= this.end && this.start <= v;
        }
    }

    @NotNull
    private static final String BODY_KEY = "body";
    @NotNull
    private static final String CODE_KEY = "code";
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String ERROR_CODE_FIELD_KEY = "code";
    @NotNull
    private static final String ERROR_CODE_KEY = "error_code";
    @NotNull
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    @NotNull
    private static final String ERROR_KEY = "error";
    @NotNull
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    @NotNull
    private static final String ERROR_MSG_KEY = "error_msg";
    @NotNull
    private static final String ERROR_REASON_KEY = "error_reason";
    @NotNull
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    @NotNull
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    @NotNull
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    @NotNull
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    @NotNull
    private static final Range HTTP_RANGE_SUCCESS = null;
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    @Nullable
    private final Object batchRequestResult;
    @NotNull
    private final Category category;
    @Nullable
    private final HttpURLConnection connection;
    private final int errorCode;
    @Nullable
    private final String errorMessage;
    @Nullable
    private final String errorRecoveryMessage;
    @Nullable
    private final String errorType;
    @Nullable
    private final String errorUserMessage;
    @Nullable
    private final String errorUserTitle;
    @Nullable
    private FacebookException exception;
    @Nullable
    private final JSONObject requestResult;
    @Nullable
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    static {
        FacebookRequestError.Companion = new Companion(null);
        FacebookRequestError.HTTP_RANGE_SUCCESS = new Range(200, 299);
        FacebookRequestError.CREATOR = new FacebookRequestError.Companion.CREATOR.1();
    }

    private FacebookRequestError(int v, int v1, int v2, String s, String s1, String s2, String s3, JSONObject jSONObject0, JSONObject jSONObject1, Object object0, HttpURLConnection httpURLConnection0, FacebookException facebookException0, boolean z) {
        Category facebookRequestError$Category0;
        this.requestStatusCode = v;
        this.errorCode = v1;
        this.subErrorCode = v2;
        this.errorType = s;
        this.errorUserTitle = s2;
        this.errorUserMessage = s3;
        this.requestResultBody = jSONObject0;
        this.requestResult = jSONObject1;
        this.batchRequestResult = object0;
        this.connection = httpURLConnection0;
        this.errorMessage = s1;
        if(facebookException0 == null) {
            this.exception = new FacebookServiceException(this, this.getErrorMessage());
            facebookRequestError$Category0 = FacebookRequestError.Companion.getErrorClassification().classify(v1, v2, z);
        }
        else {
            this.exception = facebookException0;
            facebookRequestError$Category0 = Category.OTHER;
        }
        this.category = facebookRequestError$Category0;
        this.errorRecoveryMessage = FacebookRequestError.Companion.getErrorClassification().getRecoveryMessage(facebookRequestError$Category0);
    }

    public FacebookRequestError(int v, int v1, int v2, String s, String s1, String s2, String s3, JSONObject jSONObject0, JSONObject jSONObject1, Object object0, HttpURLConnection httpURLConnection0, FacebookException facebookException0, boolean z, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, v1, v2, s, s1, s2, s3, jSONObject0, jSONObject1, object0, httpURLConnection0, facebookException0, z);
    }

    public FacebookRequestError(int v, @Nullable String s, @Nullable String s1) {
        this(-1, v, -1, s, s1, null, null, null, null, null, null, null, false);
    }

    private FacebookRequestError(Parcel parcel0) {
        this(parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), null, null, null, null, null, false);
    }

    public FacebookRequestError(Parcel parcel0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(parcel0);
    }

    public FacebookRequestError(@Nullable HttpURLConnection httpURLConnection0, @Nullable Exception exception0) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection0, (exception0 instanceof FacebookException ? ((FacebookException)exception0) : new FacebookException(exception0)), false);
    }

    @Nullable
    public static final FacebookRequestError checkResponseAndCreateError(@NotNull JSONObject jSONObject0, @Nullable Object object0, @Nullable HttpURLConnection httpURLConnection0) {
        return FacebookRequestError.Companion.checkResponseAndCreateError(jSONObject0, object0, httpURLConnection0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    @NotNull
    public final Category getCategory() {
        return this.category;
    }

    @Nullable
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    @NotNull
    public static final FacebookRequestErrorClassification getErrorClassification() {
        synchronized(FacebookRequestError.class) {
            return FacebookRequestError.Companion.getErrorClassification();
        }
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        String s = this.errorMessage;
        if(s == null) {
            return this.exception == null ? null : this.exception.getLocalizedMessage();
        }
        return s;
    }

    @Nullable
    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    @Nullable
    public final String getErrorType() {
        return this.errorType;
    }

    @Nullable
    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    @Nullable
    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    @Nullable
    public final FacebookException getException() {
        return this.exception;
    }

    @Nullable
    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    @Nullable
    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    @Override
    @NotNull
    public String toString() {
        String s = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + this.getErrorMessage() + "}";
        q.f(s, "StringBuilder(\"{HttpStat…(\"}\")\n        .toString()");
        return s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeInt(this.requestStatusCode);
        parcel0.writeInt(this.errorCode);
        parcel0.writeInt(this.subErrorCode);
        parcel0.writeString(this.errorType);
        parcel0.writeString(this.getErrorMessage());
        parcel0.writeString(this.errorUserTitle);
        parcel0.writeString(this.errorUserMessage);
    }
}

