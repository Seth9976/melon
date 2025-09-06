package com.facebook.login;

import A6.b;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.w;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.a;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R.id;
import com.facebook.common.R.layout;
import com.facebook.common.R.string;
import com.facebook.common.R.style;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00B8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 b2\u00020\u0001:\u0003bcdB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001D\u0010\u001F\u001A\u0010\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001A\u00020\n2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\'2\u0006\u0010$\u001A\u00020#H\u0015\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010,\u001A\u00020\u00122\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b.\u0010\u0003J\u000F\u0010/\u001A\u00020#H\u0014\u00A2\u0006\u0004\b/\u00100J\u0017\u00103\u001A\u00020\u00122\u0006\u00102\u001A\u000201H\u0002\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b5\u0010\u0003J\u000F\u00106\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b6\u0010\u0003JC\u0010?\u001A\u00020\u00122\u0006\u00107\u001A\u00020\u001E2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020\u001E2\u0006\u0010;\u001A\u00020\u001E2\b\u0010=\u001A\u0004\u0018\u00010<2\b\u0010>\u001A\u0004\u0018\u00010<H\u0002\u00A2\u0006\u0004\b?\u0010@J)\u0010C\u001A\u00020\u00122\u0006\u0010:\u001A\u00020\u001E2\u0006\u0010B\u001A\u00020A2\b\u0010>\u001A\u0004\u0018\u00010AH\u0002\u00A2\u0006\u0004\bC\u0010DJ;\u0010E\u001A\u00020\u00122\u0006\u00107\u001A\u00020\u001E2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020\u001E2\b\u0010=\u001A\u0004\u0018\u00010<2\b\u0010>\u001A\u0004\u0018\u00010<H\u0002\u00A2\u0006\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020\n8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001A\u00020I8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001A\u00020I8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bL\u0010KR\u0018\u0010N\u001A\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001A\u00020P8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001A\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u001C\u0010W\u001A\b\u0012\u0002\b\u0003\u0018\u00010V8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u00102\u001A\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010YR\u0016\u0010Z\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010[R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001A\u0010]R\u0014\u0010a\u001A\u00020^8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b_\u0010`\u00A8\u0006e"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog;", "Landroidx/fragment/app/w;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "Lie/H;", "onDismiss", "(Landroid/content/DialogInterface;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "Lcom/facebook/login/LoginClient$Request;", "request", "startLogin", "(Lcom/facebook/login/LoginClient$Request;)V", "", "", "additionalDeviceInfo", "()Ljava/util/Map;", "getApplicationAccessToken", "()Ljava/lang/String;", "", "isSmartLogin", "initializeContentView", "(Z)Landroid/view/View;", "", "getLayoutResId", "(Z)I", "Lcom/facebook/FacebookException;", "ex", "onError", "(Lcom/facebook/FacebookException;)V", "onCancel", "onBackButtonPressed", "()Z", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "currentRequestState", "setCurrentRequestState", "(Lcom/facebook/login/DeviceAuthDialog$RequestState;)V", "poll", "schedulePoll", "userId", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "permissions", "accessToken", "name", "Ljava/util/Date;", "expirationTime", "dataAccessExpirationTime", "presentConfirmation", "(Ljava/lang/String;Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "", "expiresIn", "onSuccess", "(Ljava/lang/String;JLjava/lang/Long;)V", "completeLogin", "(Ljava/lang/String;Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "progressBar", "Landroid/view/View;", "Landroid/widget/TextView;", "confirmationCode", "Landroid/widget/TextView;", "instructions", "Lcom/facebook/login/DeviceAuthMethodHandler;", "deviceAuthMethodHandler", "Lcom/facebook/login/DeviceAuthMethodHandler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/facebook/GraphRequestAsyncTask;", "currentGraphRequestPoll", "Lcom/facebook/GraphRequestAsyncTask;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledPoll", "Ljava/util/concurrent/ScheduledFuture;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "isBeingDestroyed", "Z", "isRetry", "Lcom/facebook/login/LoginClient$Request;", "Lcom/facebook/GraphRequest;", "getPollRequest", "()Lcom/facebook/GraphRequest;", "pollRequest", "Companion", "PermissionsLists", "RequestState", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class DeviceAuthDialog extends w {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002R\u001C\u0010\u0003\u001A\u00020\u00048\u0000X\u0081D¢\u0006\u000E\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001A\u0004\b\u0006\u0010\u0007R\u001C\u0010\b\u001A\u00020\u00048\u0000X\u0081D¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\u0002\u001A\u0004\b\n\u0010\u0007R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u001C\u0010\r\u001A\u00020\f8\u0000X\u0081D¢\u0006\u000E\n\u0000\u0012\u0004\b\u000E\u0010\u0002\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0011\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$Companion;", "", "()V", "DEVICE_LOGIN_ENDPOINT", "", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release", "()Ljava/lang/String;", "DEVICE_LOGIN_STATUS_ENDPOINT", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED", "", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release", "()I", "LOGIN_ERROR_SUBCODE_CODE_EXPIRED", "LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING", "REQUEST_STATE_KEY", "handlePermissionResponse", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "result", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final PermissionsLists access$handlePermissionResponse(Companion deviceAuthDialog$Companion0, JSONObject jSONObject0) {
            return deviceAuthDialog$Companion0.handlePermissionResponse(jSONObject0);
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return "device/login";
        }

        public static void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return "device/login_status";
        }

        public static void getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations() {
        }

        // 去混淆评级： 低(20)
        public final int getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release() {
            return 0x149636;
        }

        public static void getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations() {
        }

        private final PermissionsLists handlePermissionResponse(JSONObject jSONObject0) {
            JSONArray jSONArray0 = jSONObject0.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONArray0.optJSONObject(v1);
                String s = jSONObject1.optString("permission");
                q.f(s, "permission");
                if(s.length() != 0 && !s.equals("installed")) {
                    String s1 = jSONObject1.optString("status");
                    if(s1 != null) {
                        switch(s1) {
                            case "declined": {
                                arrayList1.add(s);
                                break;
                            }
                            case "expired": {
                                arrayList2.add(s);
                                break;
                            }
                            case "granted": {
                                arrayList0.add(s);
                            }
                        }
                    }
                }
            }
            return new PermissionsLists(arrayList0, arrayList1, arrayList2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000BR \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u000B¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class PermissionsLists {
        @NotNull
        private List declinedPermissions;
        @NotNull
        private List expiredPermissions;
        @NotNull
        private List grantedPermissions;

        public PermissionsLists(@NotNull List list0, @NotNull List list1, @NotNull List list2) {
            q.g(list0, "grantedPermissions");
            q.g(list1, "declinedPermissions");
            q.g(list2, "expiredPermissions");
            super();
            this.grantedPermissions = list0;
            this.declinedPermissions = list1;
            this.expiredPermissions = list2;
        }

        @NotNull
        public final List getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        @NotNull
        public final List getExpiredPermissions() {
            return this.expiredPermissions;
        }

        @NotNull
        public final List getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.declinedPermissions = list0;
        }

        public final void setExpiredPermissions(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.expiredPermissions = list0;
        }

        public final void setGrantedPermissions(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.grantedPermissions = list0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0014\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000F\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR(\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010\tR\u0018\u0010\n\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u001ER$\u0010 \u001A\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b \u0010\u001E\u001A\u0004\b!\u0010\t\"\u0004\b\"\u0010\rR\"\u0010#\u001A\u00020\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010\u0011R\u0016\u0010\u000F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010$¨\u0006)"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "getUserCode", "()Ljava/lang/String;", "userCode", "Lie/H;", "setUserCode", "(Ljava/lang/String;)V", "", "lastPoll", "setLastPoll", "(J)V", "", "withinLastRefreshWindow", "()Z", "", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "<set-?>", "authorizationUri", "Ljava/lang/String;", "getAuthorizationUri", "requestCode", "getRequestCode", "setRequestCode", "interval", "J", "getInterval", "()J", "setInterval", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class RequestState implements Parcelable {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.login.DeviceAuthDialog.RequestState.Companion {
            private com.facebook.login.DeviceAuthDialog.RequestState.Companion() {
            }

            public com.facebook.login.DeviceAuthDialog.RequestState.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Parcelable.Creator CREATOR;
        @NotNull
        public static final com.facebook.login.DeviceAuthDialog.RequestState.Companion Companion;
        @Nullable
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        @Nullable
        private String requestCode;
        @Nullable
        private String userCode;

        static {
            RequestState.Companion = new com.facebook.login.DeviceAuthDialog.RequestState.Companion(null);
            RequestState.CREATOR = new DeviceAuthDialog.RequestState.Companion.CREATOR.1();
        }

        public RequestState() {
        }

        public RequestState(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            super();
            this.authorizationUri = parcel0.readString();
            this.userCode = parcel0.readString();
            this.requestCode = parcel0.readString();
            this.interval = parcel0.readLong();
            this.lastPoll = parcel0.readLong();
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        @Nullable
        public final String getRequestCode() {
            return this.requestCode;
        }

        @Nullable
        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long v) {
            this.interval = v;
        }

        public final void setLastPoll(long v) {
            this.lastPoll = v;
        }

        public final void setRequestCode(@Nullable String s) {
            this.requestCode = s;
        }

        public final void setUserCode(@Nullable String s) {
            this.userCode = s;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{s}, 1));
        }

        public final boolean withinLastRefreshWindow() {
            return Long.compare(this.lastPoll, 0L) == 0 ? false : new Date().getTime() - this.lastPoll - this.interval * 1000L < 0L;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.authorizationUri);
            parcel0.writeString(this.userCode);
            parcel0.writeString(this.requestCode);
            parcel0.writeLong(this.interval);
            parcel0.writeLong(this.lastPoll);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String DEVICE_LOGIN_ENDPOINT = null;
    @NotNull
    private static final String DEVICE_LOGIN_STATUS_ENDPOINT = null;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 0x149635;
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 0;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 0x149620;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 0x149634;
    @NotNull
    private static final String REQUEST_STATE_KEY = "request_state";
    @NotNull
    private final AtomicBoolean completed;
    private TextView confirmationCode;
    @Nullable
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    @Nullable
    private volatile RequestState currentRequestState;
    @Nullable
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    private boolean isBeingDestroyed;
    private boolean isRetry;
    private View progressBar;
    @Nullable
    private Request request;
    @Nullable
    private volatile ScheduledFuture scheduledPoll;

    static {
        DeviceAuthDialog.Companion = new Companion(null);
        DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT = "device/login";
        DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
        DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 0x149636;
    }

    public DeviceAuthDialog() {
        this.completed = new AtomicBoolean();
    }

    private static final void _get_pollRequest_$lambda$5(DeviceAuthDialog deviceAuthDialog0, GraphResponse graphResponse0) {
        FacebookException facebookException0;
        q.g(deviceAuthDialog0, "this$0");
        q.g(graphResponse0, "response");
        if(deviceAuthDialog0.completed.get()) {
            return;
        }
        FacebookRequestError facebookRequestError0 = graphResponse0.getError();
        if(facebookRequestError0 != null) {
            int v = facebookRequestError0.getSubErrorCode();
            if(v != DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING) {
                switch(v) {
                    case 0x149620: {
                        RequestState deviceAuthDialog$RequestState0 = deviceAuthDialog0.currentRequestState;
                        if(deviceAuthDialog$RequestState0 != null) {
                            DeviceRequestsHelper.cleanUpAdvertisementService(deviceAuthDialog$RequestState0.getUserCode());
                        }
                        Request loginClient$Request0 = deviceAuthDialog0.request;
                        if(loginClient$Request0 != null) {
                            deviceAuthDialog0.startLogin(loginClient$Request0);
                            return;
                        }
                        deviceAuthDialog0.onCancel();
                        return;
                    }
                    case 0x149634: {
                        break;
                    }
                    case 0x149635: {
                        deviceAuthDialog0.onCancel();
                        return;
                    }
                    default: {
                        FacebookRequestError facebookRequestError1 = graphResponse0.getError();
                        if(facebookRequestError1 == null) {
                            facebookException0 = new FacebookException();
                        }
                        else {
                            facebookException0 = facebookRequestError1.getException();
                            if(facebookException0 == null) {
                                facebookException0 = new FacebookException();
                            }
                        }
                        deviceAuthDialog0.onError(facebookException0);
                        return;
                    }
                }
            }
            deviceAuthDialog0.schedulePoll();
            return;
        }
        try {
            JSONObject jSONObject0 = graphResponse0.getJSONObject() == null ? new JSONObject() : graphResponse0.getJSONObject();
            String s = jSONObject0.getString("access_token");
            q.f(s, "resultObject.getString(\"access_token\")");
            deviceAuthDialog0.onSuccess(s, jSONObject0.getLong("expires_in"), jSONObject0.optLong("data_access_expiration_time"));
            return;
        }
        catch(JSONException jSONException0) {
        }
        deviceAuthDialog0.onError(new FacebookException(jSONException0));
    }

    public static final String access$getDEVICE_LOGIN_ENDPOINT$cp() [...] // 潜在的解密器

    public static final String access$getDEVICE_LOGIN_STATUS_ENDPOINT$cp() [...] // 潜在的解密器

    public static final int access$getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$cp() [...] // 潜在的解密器

    @Nullable
    public Map additionalDeviceInfo() [...] // Inlined contents

    private final void completeLogin(String s, PermissionsLists deviceAuthDialog$PermissionsLists0, String s1, Date date0, Date date1) {
        DeviceAuthMethodHandler deviceAuthMethodHandler0 = this.deviceAuthMethodHandler;
        if(deviceAuthMethodHandler0 != null) {
            deviceAuthMethodHandler0.onSuccess(s1, FacebookSdk.getApplicationId(), s, deviceAuthDialog$PermissionsLists0.getGrantedPermissions(), deviceAuthDialog$PermissionsLists0.getDeclinedPermissions(), deviceAuthDialog$PermissionsLists0.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date0, null, date1);
        }
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            dialog0.dismiss();
        }
    }

    @NotNull
    public String getApplicationAccessToken() {
        return Validate.hasAppID() + '|' + Validate.hasClientToken();
    }

    // 去混淆评级： 低(20)
    public int getLayoutResId(boolean z) {
        return z ? layout.com_facebook_smart_device_dialog_fragment : layout.com_facebook_device_auth_dialog_fragment;
    }

    private final GraphRequest getPollRequest() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("code", (this.currentRequestState == null ? null : this.currentRequestState.getRequestCode()));
        bundle0.putString("access_token", this.getApplicationAccessToken());
        c c0 = new c(this, 0);
        return GraphRequest.Companion.newPostRequestWithBundle(null, "device/login_status", bundle0, c0);
    }

    @NotNull
    public View initializeContentView(boolean z) {
        LayoutInflater layoutInflater0 = this.requireActivity().getLayoutInflater();
        q.f(layoutInflater0, "requireActivity().layoutInflater");
        View view0 = layoutInflater0.inflate(this.getLayoutResId(z), null);
        q.f(view0, "inflater.inflate(getLayo…esId(isSmartLogin), null)");
        View view1 = view0.findViewById(id.progress_bar);
        q.f(view1, "view.findViewById(R.id.progress_bar)");
        this.progressBar = view1;
        View view2 = view0.findViewById(id.confirmation_code);
        q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
        this.confirmationCode = (TextView)view2;
        View view3 = view0.findViewById(id.cancel_button);
        q.e(view3, "null cannot be cast to non-null type android.widget.Button");
        ((Button)view3).setOnClickListener(new b(this, 20));
        View view4 = view0.findViewById(id.com_facebook_device_auth_instructions);
        q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
        this.instructions = (TextView)view4;
        ((TextView)view4).setText(Html.fromHtml(this.getString(string.com_facebook_device_auth_instructions)));
        return view0;
    }

    private static final void initializeContentView$lambda$2(DeviceAuthDialog deviceAuthDialog0, View view0) {
        q.g(deviceAuthDialog0, "this$0");
        deviceAuthDialog0.onCancel();
    }

    public static void o(DeviceAuthDialog deviceAuthDialog0, View view0) {
        DeviceAuthDialog.initializeContentView$lambda$2(deviceAuthDialog0, view0);
    }

    public boolean onBackButtonPressed() [...] // Inlined contents

    public void onCancel() {
        if(this.completed.compareAndSet(false, true)) {
            RequestState deviceAuthDialog$RequestState0 = this.currentRequestState;
            if(deviceAuthDialog$RequestState0 != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(deviceAuthDialog$RequestState0.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler0 = this.deviceAuthMethodHandler;
            if(deviceAuthMethodHandler0 != null) {
                deviceAuthMethodHandler0.onCancel();
            }
            Dialog dialog0 = this.getDialog();
            if(dialog0 != null) {
                dialog0.dismiss();
            }
        }
    }

    @Override  // androidx.fragment.app.w
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle0) {
        Dialog dialog0 = new Dialog(style.com_facebook_auth_dialog/*ERROR_MISSING_ARG_2/*) {
            @Override  // android.app.Dialog
            public void onBackPressed() {
                super.onBackPressed();
            }
        };
        dialog0.setContentView(this.initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return dialog0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        LoginMethodHandler loginMethodHandler0;
        q.g(layoutInflater0, "inflater");
        View view0 = super.onCreateView(layoutInflater0, viewGroup0, bundle0);
        FragmentActivity fragmentActivity0 = this.requireActivity();
        q.e(fragmentActivity0, "null cannot be cast to non-null type com.facebook.FacebookActivity");
        LoginFragment loginFragment0 = (LoginFragment)((FacebookActivity)fragmentActivity0).getCurrentFragment();
        if(loginFragment0 == null) {
            loginMethodHandler0 = null;
        }
        else {
            LoginClient loginClient0 = loginFragment0.getLoginClient();
            loginMethodHandler0 = loginClient0 == null ? null : loginClient0.getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler)loginMethodHandler0;
        if(bundle0 != null) {
            RequestState deviceAuthDialog$RequestState0 = (RequestState)bundle0.getParcelable("request_state");
            if(deviceAuthDialog$RequestState0 != null) {
                this.setCurrentRequestState(deviceAuthDialog$RequestState0);
            }
        }
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask0 = this.currentGraphRequestPoll;
        if(graphRequestAsyncTask0 != null) {
            graphRequestAsyncTask0.cancel(true);
        }
        ScheduledFuture scheduledFuture0 = this.scheduledPoll;
        if(scheduledFuture0 != null) {
            scheduledFuture0.cancel(true);
        }
    }

    @Override  // androidx.fragment.app.w
    public void onDismiss(@NotNull DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onDismiss(dialogInterface0);
        if(!this.isBeingDestroyed) {
            this.onCancel();
        }
    }

    public void onError(@NotNull FacebookException facebookException0) {
        q.g(facebookException0, "ex");
        if(this.completed.compareAndSet(false, true)) {
            RequestState deviceAuthDialog$RequestState0 = this.currentRequestState;
            if(deviceAuthDialog$RequestState0 != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(deviceAuthDialog$RequestState0.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler0 = this.deviceAuthMethodHandler;
            if(deviceAuthMethodHandler0 != null) {
                deviceAuthMethodHandler0.onError(facebookException0);
            }
            Dialog dialog0 = this.getDialog();
            if(dialog0 != null) {
                dialog0.dismiss();
            }
        }
    }

    @Override  // androidx.fragment.app.w
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        if(this.currentRequestState != null) {
            bundle0.putParcelable("request_state", this.currentRequestState);
        }
    }

    private final void onSuccess(String s, long v, Long long0) {
        Bundle bundle0 = Y.b("fields", "id,permissions,name");
        Date date0 = null;
        Date date1 = Long.compare(v, 0L) == 0 ? null : new Date(v * 1000L + new Date().getTime());
        if((long0 == null || ((long)long0) != 0L) && long0 != null) {
            date0 = new Date(((long)long0) * 1000L);
        }
        AccessToken accessToken0 = new AccessToken(s, FacebookSdk.getApplicationId(), "0", null, null, null, null, date1, null, date0, null, 0x400, null);
        a a0 = new a(this, s, date1, date0, 2);
        GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(accessToken0, "me", a0);
        graphRequest0.setHttpMethod(HttpMethod.GET);
        graphRequest0.setParameters(bundle0);
        graphRequest0.executeAsync();
    }

    private static final void onSuccess$lambda$10(DeviceAuthDialog deviceAuthDialog0, String s, Date date0, Date date1, GraphResponse graphResponse0) {
        Boolean boolean0;
        RequestState deviceAuthDialog$RequestState0;
        String s2;
        PermissionsLists deviceAuthDialog$PermissionsLists0;
        String s1;
        JSONException jSONException2;
        q.g(deviceAuthDialog0, "this$0");
        q.g(s, "$accessToken");
        q.g(graphResponse0, "response");
        if(deviceAuthDialog0.completed.get()) {
            return;
        }
        FacebookRequestError facebookRequestError0 = graphResponse0.getError();
        if(facebookRequestError0 != null) {
            FacebookException facebookException0 = facebookRequestError0.getException();
            if(facebookException0 == null) {
                facebookException0 = new FacebookException();
            }
            deviceAuthDialog0.onError(facebookException0);
            return;
        }
        try {
            JSONObject jSONObject0 = graphResponse0.getJSONObject();
            if(jSONObject0 == null) {
                try {
                    jSONObject0 = new JSONObject();
                }
                catch(JSONException jSONException1) {
                    jSONException2 = jSONException1;
                    goto label_28;
                }
            }
            s1 = jSONObject0.getString("id");
            q.f(s1, "jsonObject.getString(\"id\")");
            deviceAuthDialog$PermissionsLists0 = Companion.access$handlePermissionResponse(DeviceAuthDialog.Companion, jSONObject0);
            s2 = jSONObject0.getString("name");
            q.f(s2, "jsonObject.getString(\"name\")");
            deviceAuthDialog$RequestState0 = deviceAuthDialog0.currentRequestState;
            goto label_30;
        }
        catch(JSONException jSONException0) {
            jSONException2 = jSONException0;
        }
    label_28:
        deviceAuthDialog0.onError(new FacebookException(jSONException2));
        return;
    label_30:
        if(deviceAuthDialog$RequestState0 != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(deviceAuthDialog$RequestState0.getUserCode());
        }
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if(fetchedAppSettings0 == null) {
            boolean0 = null;
        }
        else {
            EnumSet enumSet0 = fetchedAppSettings0.getSmartLoginOptions();
            boolean0 = enumSet0 == null ? null : Boolean.valueOf(enumSet0.contains(SmartLoginOption.RequireConfirm));
        }
        if(q.b(boolean0, Boolean.TRUE) && !deviceAuthDialog0.isRetry) {
            deviceAuthDialog0.isRetry = true;
            deviceAuthDialog0.presentConfirmation(s1, deviceAuthDialog$PermissionsLists0, s, s2, date0, date1);
            return;
        }
        deviceAuthDialog0.completeLogin(s1, deviceAuthDialog$PermissionsLists0, s, date0, date1);
    }

    private final void poll() {
        RequestState deviceAuthDialog$RequestState0 = this.currentRequestState;
        if(deviceAuthDialog$RequestState0 != null) {
            deviceAuthDialog$RequestState0.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = this.getPollRequest().executeAsync();
    }

    private final void presentConfirmation(String s, PermissionsLists deviceAuthDialog$PermissionsLists0, String s1, String s2, Date date0, Date date1) {
        String s3 = this.getResources().getString(string.com_facebook_smart_login_confirmation_title);
        q.f(s3, "resources.getString(R.st…login_confirmation_title)");
        String s4 = this.getResources().getString(string.com_facebook_smart_login_confirmation_continue_as);
        q.f(s4, "resources.getString(R.st…confirmation_continue_as)");
        String s5 = this.getResources().getString(string.com_facebook_smart_login_confirmation_cancel);
        q.f(s5, "resources.getString(R.st…ogin_confirmation_cancel)");
        String s6 = String.format(s4, Arrays.copyOf(new Object[]{s2}, 1));
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this.getContext());
        alertDialog$Builder0.setMessage(s3).setCancelable(true).setNegativeButton(s6, new com.facebook.login.a(this, s, deviceAuthDialog$PermissionsLists0, s1, date0, date1)).setPositiveButton(s5, new com.facebook.login.b(this, 0));
        alertDialog$Builder0.create().show();
    }

    private static final void presentConfirmation$lambda$6(DeviceAuthDialog deviceAuthDialog0, String s, PermissionsLists deviceAuthDialog$PermissionsLists0, String s1, Date date0, Date date1, DialogInterface dialogInterface0, int v) {
        q.g(deviceAuthDialog0, "this$0");
        q.g(s, "$userId");
        q.g(deviceAuthDialog$PermissionsLists0, "$permissions");
        q.g(s1, "$accessToken");
        deviceAuthDialog0.completeLogin(s, deviceAuthDialog$PermissionsLists0, s1, date0, date1);
    }

    private static final void presentConfirmation$lambda$8(DeviceAuthDialog deviceAuthDialog0, DialogInterface dialogInterface0, int v) {
        q.g(deviceAuthDialog0, "this$0");
        View view0 = deviceAuthDialog0.initializeContentView(false);
        Dialog dialog0 = deviceAuthDialog0.getDialog();
        if(dialog0 != null) {
            dialog0.setContentView(view0);
        }
        Request loginClient$Request0 = deviceAuthDialog0.request;
        if(loginClient$Request0 != null) {
            deviceAuthDialog0.startLogin(loginClient$Request0);
        }
    }

    public static void q(DeviceAuthDialog deviceAuthDialog0) {
        DeviceAuthDialog.schedulePoll$lambda$3(deviceAuthDialog0);
    }

    public static void s(DeviceAuthDialog deviceAuthDialog0, String s, Date date0, Date date1, GraphResponse graphResponse0) {
        DeviceAuthDialog.onSuccess$lambda$10(deviceAuthDialog0, s, date0, date1, graphResponse0);
    }

    private final void schedulePoll() {
        Long long0 = this.currentRequestState == null ? null : this.currentRequestState.getInterval();
        if(long0 != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new com.facebook.appevents.c(this, 10), ((long)long0), TimeUnit.SECONDS);
        }
    }

    private static final void schedulePoll$lambda$3(DeviceAuthDialog deviceAuthDialog0) {
        q.g(deviceAuthDialog0, "this$0");
        deviceAuthDialog0.poll();
    }

    private final void setCurrentRequestState(RequestState deviceAuthDialog$RequestState0) {
        this.currentRequestState = deviceAuthDialog$RequestState0;
        TextView textView0 = this.confirmationCode;
        if(textView0 != null) {
            textView0.setText(deviceAuthDialog$RequestState0.getUserCode());
            Bitmap bitmap0 = DeviceRequestsHelper.generateQRCode(deviceAuthDialog$RequestState0.getAuthorizationUri());
            BitmapDrawable bitmapDrawable0 = new BitmapDrawable(this.getResources(), bitmap0);
            TextView textView1 = this.instructions;
            if(textView1 != null) {
                textView1.setCompoundDrawablesWithIntrinsicBounds(null, bitmapDrawable0, null, null);
                TextView textView2 = this.confirmationCode;
                if(textView2 != null) {
                    textView2.setVisibility(0);
                    View view0 = this.progressBar;
                    if(view0 != null) {
                        view0.setVisibility(8);
                        if(!this.isRetry && DeviceRequestsHelper.startAdvertisementService(deviceAuthDialog$RequestState0.getUserCode())) {
                            new InternalAppEventsLogger(this.getContext()).logEventImplicitly("fb_smart_login_service");
                        }
                        if(deviceAuthDialog$RequestState0.withinLastRefreshWindow()) {
                            this.schedulePoll();
                            return;
                        }
                        this.poll();
                        return;
                    }
                    q.m("progressBar");
                    throw null;
                }
                q.m("confirmationCode");
                throw null;
            }
            q.m("instructions");
            throw null;
        }
        q.m("confirmationCode");
        throw null;
    }

    public void startLogin(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        this.request = loginClient$Request0;
        Bundle bundle0 = new Bundle();
        bundle0.putString("scope", TextUtils.join(",", loginClient$Request0.getPermissions()));
        Utility.putNonEmptyString(bundle0, "redirect_uri", loginClient$Request0.getDeviceRedirectUriString());
        Utility.putNonEmptyString(bundle0, "target_user_id", loginClient$Request0.getDeviceAuthTargetUserId());
        bundle0.putString("access_token", this.getApplicationAccessToken());
        bundle0.putString("device_info", DeviceRequestsHelper.getDeviceInfo(null));
        c c0 = new c(this, 1);
        GraphRequest.Companion.newPostRequestWithBundle(null, "device/login", bundle0, c0).executeAsync();
    }

    private static final void startLogin$lambda$1(DeviceAuthDialog deviceAuthDialog0, GraphResponse graphResponse0) {
        FacebookException facebookException0;
        q.g(deviceAuthDialog0, "this$0");
        q.g(graphResponse0, "response");
        if(deviceAuthDialog0.isBeingDestroyed) {
            return;
        }
        if(graphResponse0.getError() != null) {
            FacebookRequestError facebookRequestError0 = graphResponse0.getError();
            if(facebookRequestError0 == null) {
                facebookException0 = new FacebookException();
            }
            else {
                facebookException0 = facebookRequestError0.getException();
                if(facebookException0 == null) {
                    facebookException0 = new FacebookException();
                }
            }
            deviceAuthDialog0.onError(facebookException0);
            return;
        }
        JSONObject jSONObject0 = graphResponse0.getJSONObject() == null ? new JSONObject() : graphResponse0.getJSONObject();
        RequestState deviceAuthDialog$RequestState0 = new RequestState();
        try {
            deviceAuthDialog$RequestState0.setUserCode(jSONObject0.getString("user_code"));
            deviceAuthDialog$RequestState0.setRequestCode(jSONObject0.getString("code"));
            deviceAuthDialog$RequestState0.setInterval(jSONObject0.getLong("interval"));
        }
        catch(JSONException jSONException0) {
            deviceAuthDialog0.onError(new FacebookException(jSONException0));
            return;
        }
        deviceAuthDialog0.setCurrentRequestState(deviceAuthDialog$RequestState0);
    }
}

