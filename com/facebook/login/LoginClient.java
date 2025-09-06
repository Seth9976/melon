package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.common.R.string;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0017\u0018\u0000 \u0084\u00012\u00020\u0001:\n\u0085\u0001\u0084\u0001\u0086\u0001\u0087\u0001\u0088\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u000E\u0010\rJ\r\u0010\u000F\u001A\u00020\u000B\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u0014H\u0004\u00A2\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u00142\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010 \u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001F2\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u001C\u00A2\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\u000B\u00A2\u0006\u0004\b$\u0010\u0010J%\u0010)\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%2\u0006\u0010(\u001A\u00020\u001C\u00A2\u0006\u0004\b)\u0010*J\r\u0010+\u001A\u00020\u001C\u00A2\u0006\u0004\b+\u0010#J\u0015\u0010.\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020,\u00A2\u0006\u0004\b.\u0010/J\u0015\u00100\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020,\u00A2\u0006\u0004\b0\u0010/J\u0015\u00102\u001A\u00020\u00142\u0006\u00101\u001A\u00020%\u00A2\u0006\u0004\b2\u00103J\u0015\u00105\u001A\u00020\u000B2\u0006\u00104\u001A\u00020,\u00A2\u0006\u0004\b5\u0010/J\r\u00106\u001A\u00020\u000B\u00A2\u0006\u0004\b6\u0010\u0010J\r\u00107\u001A\u00020\u000B\u00A2\u0006\u0004\b7\u0010\u0010J\u000F\u00108\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b8\u00109J\u001F\u0010<\u001A\u00020\u000B2\u0006\u0010:\u001A\u00020\u00062\u0006\u0010;\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b<\u0010=J\u000F\u0010>\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b>\u0010\u0010J\'\u0010?\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%2\u0006\u0010(\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b?\u0010*J\u0017\u0010@\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020,H\u0002\u00A2\u0006\u0004\b@\u0010/J9\u0010E\u001A\u00020\u000B2\u0006\u0010A\u001A\u00020%2\u0006\u0010B\u001A\u00020,2\u0018\u0010D\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010CH\u0002\u00A2\u0006\u0004\bE\u0010FJM\u0010E\u001A\u00020\u000B2\u0006\u0010A\u001A\u00020%2\u0006\u0010B\u001A\u00020%2\b\u0010G\u001A\u0004\u0018\u00010%2\b\u0010H\u001A\u0004\u0018\u00010%2\u0018\u0010D\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010CH\u0002\u00A2\u0006\u0004\bE\u0010IR*\u0010J\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\b \u0010L\"\u0004\bM\u0010NR\u0016\u0010O\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR.\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\'\u001A\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0003\u0010Q\u001A\u0004\bR\u0010S\"\u0004\bT\u0010\u0005R$\u0010V\u001A\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bV\u0010W\u001A\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001A\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b]\u0010^\u001A\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010c\u001A\u00020\u001C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bc\u0010d\u001A\u0004\be\u0010#\"\u0004\bf\u0010gR$\u0010h\u001A\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010\rR0\u0010D\u001A\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010m8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bD\u0010n\u001A\u0004\bo\u0010p\"\u0004\bq\u0010rR0\u0010s\u001A\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010m8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bs\u0010n\u001A\u0004\bt\u0010p\"\u0004\bu\u0010rR\u0018\u0010w\u001A\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\by\u0010PR\u0016\u0010z\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bz\u0010PR\u0013\u0010~\u001A\u0004\u0018\u00010{8F\u00A2\u0006\u0006\u001A\u0004\b|\u0010}R\u0012\u0010\u0080\u0001\u001A\u00020\u001C8F\u00A2\u0006\u0006\u001A\u0004\b\u007F\u0010#R\u0017\u0010\u0083\u0001\u001A\u00020v8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u0081\u0001\u0010\u0082\u0001\u00A8\u0006\u0089\u0001"}, d2 = {"Lcom/facebook/login/LoginClient;", "Landroid/os/Parcelable;", "Landroidx/fragment/app/I;", "fragment", "<init>", "(Landroidx/fragment/app/I;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "Lie/H;", "startOrContinueAuth", "(Lcom/facebook/login/LoginClient$Request;)V", "authorize", "cancelCurrentHandler", "()V", "Lcom/facebook/login/LoginMethodHandler;", "getCurrentHandler", "()Lcom/facebook/login/LoginMethodHandler;", "", "index", "setCurrentHandlerIndex", "(I)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)Z", "", "getHandlersToTry", "(Lcom/facebook/login/LoginClient$Request;)[Lcom/facebook/login/LoginMethodHandler;", "checkInternetPermission", "()Z", "tryNextHandler", "", "key", "value", "accumulate", "addExtraData", "(Ljava/lang/String;Ljava/lang/String;Z)V", "tryCurrentHandler", "Lcom/facebook/login/LoginClient$Result;", "outcome", "completeAndValidate", "(Lcom/facebook/login/LoginClient$Result;)V", "complete", "permission", "checkPermission", "(Ljava/lang/String;)I", "pendingResult", "validateSameFbidAndFinish", "notifyBackgroundProcessingStart", "notifyBackgroundProcessingStop", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "completeWithFailure", "addLoggingExtra", "notifyOnCompleteListener", "method", "result", "", "loggingExtras", "logAuthorizationMethodComplete", "(Ljava/lang/String;Lcom/facebook/login/LoginClient$Result;Ljava/util/Map;)V", "errorMessage", "errorCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "handlersToTry", "[Lcom/facebook/login/LoginMethodHandler;", "()[Lcom/facebook/login/LoginMethodHandler;", "setHandlersToTry", "([Lcom/facebook/login/LoginMethodHandler;)V", "currentHandler", "I", "Landroidx/fragment/app/I;", "getFragment", "()Landroidx/fragment/app/I;", "setFragment", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "onCompletedListener", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "getOnCompletedListener", "()Lcom/facebook/login/LoginClient$OnCompletedListener;", "setOnCompletedListener", "(Lcom/facebook/login/LoginClient$OnCompletedListener;)V", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "backgroundProcessingListener", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "getBackgroundProcessingListener", "()Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "setBackgroundProcessingListener", "(Lcom/facebook/login/LoginClient$BackgroundProcessingListener;)V", "checkedInternetPermission", "Z", "getCheckedInternetPermission", "setCheckedInternetPermission", "(Z)V", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "getPendingRequest", "()Lcom/facebook/login/LoginClient$Request;", "setPendingRequest", "", "Ljava/util/Map;", "getLoggingExtras", "()Ljava/util/Map;", "setLoggingExtras", "(Ljava/util/Map;)V", "extraData", "getExtraData", "setExtraData", "Lcom/facebook/login/LoginLogger;", "loginLogger", "Lcom/facebook/login/LoginLogger;", "numActivitiesReturned", "numTotalIntentsFired", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "getInProgress", "inProgress", "getLogger", "()Lcom/facebook/login/LoginLogger;", "logger", "Companion", "BackgroundProcessingListener", "OnCompletedListener", "Request", "Result", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class LoginClient implements Parcelable {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "", "Lie/H;", "onBackgroundProcessingStarted", "()V", "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u00020\u0007H\u0007J\b\u0010\b\u001A\u00020\tH\u0007R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient;", "getE2E", "", "getLoginRequestCode", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getE2E() [...] // 潜在的解密器

        public final int getLoginRequestCode() {
            return RequestCodeOffset.Login.toRequestCode();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/LoginClient$OnCompletedListener;", "", "Lcom/facebook/login/LoginClient$Result;", "result", "Lie/H;", "onCompleted", "(Lcom/facebook/login/LoginClient$Result;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface OnCompletedListener {
        void onCompleted(@NotNull Result arg1);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b7\u0018\u0000 U2\u00020\u0001:\u0001UB}\b\u0011\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0012\u0012\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0013\u0010\u0017J\r\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001E\u001A\u00020\u0018\u00A2\u0006\u0004\b\u001E\u0010\u001AJ\u000F\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u001F\u0010$\u001A\u00020\u001B2\u0006\u0010\"\u001A\u00020\u00152\u0006\u0010#\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010&\u001A\u0004\b\'\u0010(R(\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0006\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010.\u001A\u0004\b/\u00100R\u0017\u0010\n\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\n\u00101\u001A\u0004\b2\u00103R\"\u0010\u000B\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u00101\u001A\u0004\b4\u00103\"\u0004\b5\u00106R\"\u00107\u001A\u00020\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b7\u00108\u001A\u0004\b7\u0010\u001A\"\u0004\b9\u0010\u001DR$\u0010:\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b:\u00101\u001A\u0004\b;\u00103\"\u0004\b<\u00106R\"\u0010\t\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\t\u00101\u001A\u0004\b=\u00103\"\u0004\b>\u00106R$\u0010?\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b?\u00101\u001A\u0004\b@\u00103\"\u0004\bA\u00106R$\u0010B\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bB\u00101\u001A\u0004\bC\u00103\"\u0004\bD\u00106R\"\u0010E\u001A\u00020\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bE\u00108\u001A\u0004\bF\u0010\u001A\"\u0004\bG\u0010\u001DR\u0017\u0010H\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010KR\"\u0010L\u001A\u00020\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bL\u00108\u001A\u0004\bL\u0010\u001A\"\u0004\bM\u0010\u001DR\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0019\u00108R\u0017\u0010\u000E\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u000E\u00101\u001A\u0004\bN\u00103R\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u00058\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00101\u001A\u0004\bO\u00103R\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0010\u00101\u001A\u0004\bP\u00103R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006\u00A2\u0006\f\n\u0004\b\u0012\u0010Q\u001A\u0004\bR\u0010SR\u0011\u0010T\u001A\u00020\u00188F\u00A2\u0006\u0006\u001A\u0004\bT\u0010\u001A\u00A8\u0006V"}, d2 = {"Lcom/facebook/login/LoginClient$Request;", "Landroid/os/Parcelable;", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "", "", "permissions", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "authType", "applicationId", "authId", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "nonce", "codeVerifier", "codeChallenge", "Lcom/facebook/login/CodeChallengeMethod;", "codeChallengeMethod", "<init>", "(Lcom/facebook/login/LoginBehavior;Ljava/util/Set;Lcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/LoginTargetApp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/CodeChallengeMethod;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "shouldSkipAccountDeduplication", "()Z", "Lie/H;", "setShouldSkipAccountDeduplication", "(Z)V", "hasPublishPermission", "", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Ljava/util/Set;", "getPermissions", "()Ljava/util/Set;", "setPermissions", "(Ljava/util/Set;)V", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "Ljava/lang/String;", "getApplicationId", "()Ljava/lang/String;", "getAuthId", "setAuthId", "(Ljava/lang/String;)V", "isRerequest", "Z", "setRerequest", "deviceRedirectUriString", "getDeviceRedirectUriString", "setDeviceRedirectUriString", "getAuthType", "setAuthType", "deviceAuthTargetUserId", "getDeviceAuthTargetUserId", "setDeviceAuthTargetUserId", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "isFamilyLogin", "setFamilyLogin", "getNonce", "getCodeVerifier", "getCodeChallenge", "Lcom/facebook/login/CodeChallengeMethod;", "getCodeChallengeMethod", "()Lcom/facebook/login/CodeChallengeMethod;", "isInstagramLogin", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Request implements Parcelable {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$Request$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Request;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.login.LoginClient.Request.Companion {
            private com.facebook.login.LoginClient.Request.Companion() {
            }

            public com.facebook.login.LoginClient.Request.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Parcelable.Creator CREATOR;
        @NotNull
        public static final com.facebook.login.LoginClient.Request.Companion Companion;
        @NotNull
        private final String applicationId;
        @NotNull
        private String authId;
        @NotNull
        private String authType;
        @Nullable
        private final String codeChallenge;
        @Nullable
        private final CodeChallengeMethod codeChallengeMethod;
        @Nullable
        private final String codeVerifier;
        @NotNull
        private final DefaultAudience defaultAudience;
        @Nullable
        private String deviceAuthTargetUserId;
        @Nullable
        private String deviceRedirectUriString;
        private boolean isFamilyLogin;
        private boolean isRerequest;
        @NotNull
        private final LoginBehavior loginBehavior;
        @NotNull
        private final LoginTargetApp loginTargetApp;
        @Nullable
        private String messengerPageId;
        @NotNull
        private final String nonce;
        @NotNull
        private Set permissions;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;

        static {
            Request.Companion = new com.facebook.login.LoginClient.Request.Companion(null);
            Request.CREATOR = new LoginClient.Request.Companion.CREATOR.1();
        }

        private Request(Parcel parcel0) {
            this.loginBehavior = LoginBehavior.valueOf(Validate.notNullOrEmpty(parcel0.readString(), "loginBehavior"));
            ArrayList arrayList0 = new ArrayList();
            parcel0.readStringList(arrayList0);
            this.permissions = new HashSet(arrayList0);
            String s = parcel0.readString();
            this.defaultAudience = s == null ? DefaultAudience.NONE : DefaultAudience.valueOf(s);
            this.applicationId = Validate.notNullOrEmpty(parcel0.readString(), "applicationId");
            this.authId = Validate.notNullOrEmpty(parcel0.readString(), "authId");
            boolean z = false;
            this.isRerequest = parcel0.readByte() != 0;
            this.deviceRedirectUriString = parcel0.readString();
            this.authType = Validate.notNullOrEmpty(parcel0.readString(), "authType");
            this.deviceAuthTargetUserId = parcel0.readString();
            this.messengerPageId = parcel0.readString();
            this.resetMessengerState = parcel0.readByte() != 0;
            String s1 = parcel0.readString();
            this.loginTargetApp = s1 == null ? LoginTargetApp.FACEBOOK : LoginTargetApp.valueOf(s1);
            this.isFamilyLogin = parcel0.readByte() != 0;
            if(parcel0.readByte() != 0) {
                z = true;
            }
            this.shouldSkipAccountDeduplication = z;
            this.nonce = Validate.notNullOrEmpty(parcel0.readString(), "nonce");
            this.codeVerifier = parcel0.readString();
            this.codeChallenge = parcel0.readString();
            String s2 = parcel0.readString();
            this.codeChallengeMethod = s2 == null ? null : CodeChallengeMethod.valueOf(s2);
        }

        public Request(Parcel parcel0, DefaultConstructorMarker defaultConstructorMarker0) {
            this(parcel0);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, null, null, null, null, null, 0x7C0, null);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable LoginTargetApp loginTargetApp0) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, loginTargetApp0, null, null, null, null, 0x780, null);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable LoginTargetApp loginTargetApp0, @Nullable String s3) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, loginTargetApp0, s3, null, null, null, 0x700, null);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable LoginTargetApp loginTargetApp0, @Nullable String s3, @Nullable String s4) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, loginTargetApp0, s3, s4, null, null, 0x600, null);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable LoginTargetApp loginTargetApp0, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, loginTargetApp0, s3, s4, s5, null, 0x400, null);
        }

        public Request(@NotNull LoginBehavior loginBehavior0, @Nullable Set set0, @NotNull DefaultAudience defaultAudience0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable LoginTargetApp loginTargetApp0, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable CodeChallengeMethod codeChallengeMethod0) {
            q.g(loginBehavior0, "loginBehavior");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s, "authType");
            q.g(s1, "applicationId");
            q.g(s2, "authId");
            super();
            this.loginBehavior = loginBehavior0;
            if(set0 == null) {
                set0 = new HashSet();
            }
            this.permissions = set0;
            this.defaultAudience = defaultAudience0;
            this.authType = s;
            this.applicationId = s1;
            this.authId = s2;
            if(loginTargetApp0 == null) {
                loginTargetApp0 = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetApp0;
            if(s3 == null || s3.length() == 0) {
                q.f("e1b23bb6-c0a3-4441-bce9-5d25279067c0", "randomUUID().toString()");
                this.nonce = "e1b23bb6-c0a3-4441-bce9-5d25279067c0";
            }
            else {
                this.nonce = s3;
            }
            this.codeVerifier = s4;
            this.codeChallenge = s5;
            this.codeChallengeMethod = codeChallengeMethod0;
        }

        public Request(LoginBehavior loginBehavior0, Set set0, DefaultAudience defaultAudience0, String s, String s1, String s2, LoginTargetApp loginTargetApp0, String s3, String s4, String s5, CodeChallengeMethod codeChallengeMethod0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            this(loginBehavior0, set0, defaultAudience0, s, s1, s2, ((v & 0x40) == 0 ? loginTargetApp0 : LoginTargetApp.FACEBOOK), ((v & 0x80) == 0 ? s3 : null), ((v & 0x100) == 0 ? s4 : null), ((v & 0x200) == 0 ? s5 : null), ((v & 0x400) == 0 ? codeChallengeMethod0 : null));
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getApplicationId() {
            return this.applicationId;
        }

        @NotNull
        public final String getAuthId() {
            return this.authId;
        }

        @NotNull
        public final String getAuthType() {
            return this.authType;
        }

        @Nullable
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        @Nullable
        public final CodeChallengeMethod getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        @Nullable
        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        @NotNull
        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        @Nullable
        public final String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        @Nullable
        public final String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        @NotNull
        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        @NotNull
        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        @Nullable
        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        @NotNull
        public final String getNonce() {
            return this.nonce;
        }

        @NotNull
        public final Set getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean hasPublishPermission() {
            for(Object object0: this.permissions) {
                if(LoginManager.Companion.isPublishPermission(((String)object0))) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }

        public final boolean isFamilyLogin() {
            return this.isFamilyLogin;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        public final boolean isRerequest() {
            return this.isRerequest;
        }

        public final void setAuthId(@NotNull String s) {
            q.g(s, "<set-?>");
            this.authId = s;
        }

        public final void setAuthType(@NotNull String s) {
            q.g(s, "<set-?>");
            this.authType = s;
        }

        public final void setDeviceAuthTargetUserId(@Nullable String s) {
            this.deviceAuthTargetUserId = s;
        }

        public final void setDeviceRedirectUriString(@Nullable String s) {
            this.deviceRedirectUriString = s;
        }

        public final void setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
        }

        public final void setMessengerPageId(@Nullable String s) {
            this.messengerPageId = s;
        }

        public final void setPermissions(@NotNull Set set0) {
            q.g(set0, "<set-?>");
            this.permissions = set0;
        }

        public final void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        public final void setResetMessengerState(boolean z) {
            this.resetMessengerState = z;
        }

        public final void setShouldSkipAccountDeduplication(boolean z) {
            this.shouldSkipAccountDeduplication = z;
        }

        public final boolean shouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.loginBehavior.name());
            parcel0.writeStringList(new ArrayList(this.permissions));
            parcel0.writeString(this.defaultAudience.name());
            parcel0.writeString(this.applicationId);
            parcel0.writeString(this.authId);
            parcel0.writeByte(((byte)this.isRerequest));
            parcel0.writeString(this.deviceRedirectUriString);
            parcel0.writeString(this.authType);
            parcel0.writeString(this.deviceAuthTargetUserId);
            parcel0.writeString(this.messengerPageId);
            parcel0.writeByte(((byte)this.resetMessengerState));
            parcel0.writeString(this.loginTargetApp.name());
            parcel0.writeByte(((byte)this.isFamilyLogin));
            parcel0.writeByte(((byte)this.shouldSkipAccountDeduplication));
            parcel0.writeString(this.nonce);
            parcel0.writeString(this.codeVerifier);
            parcel0.writeString(this.codeChallenge);
            parcel0.writeString((this.codeChallengeMethod == null ? null : this.codeChallengeMethod.name()));
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0002&%B9\b\u0010\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fBC\b\u0010\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\u0010B\u0011\b\u0012\u0012\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u000B\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\u001CR\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\u001DR\u0016\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u000F\u0010\u001ER\u0016\u0010\t\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010\u001FR\u0016\u0010\n\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010\u001FR\u0016\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010 R$\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010$\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b$\u0010#\u00A8\u0006\'"}, d2 = {"Lcom/facebook/login/LoginClient$Result;", "Landroid/os/Parcelable;", "Lcom/facebook/login/LoginClient$Request;", "request", "Lcom/facebook/login/LoginClient$Result$Code;", "code", "Lcom/facebook/AccessToken;", "token", "", "errorMessage", "errorCode", "<init>", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "Lcom/facebook/AuthenticationToken;", "authenticationToken", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/login/LoginClient$Result$Code;", "Lcom/facebook/AccessToken;", "Lcom/facebook/AuthenticationToken;", "Ljava/lang/String;", "Lcom/facebook/login/LoginClient$Request;", "", "loggingExtras", "Ljava/util/Map;", "extraData", "Companion", "Code", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Result implements Parcelable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Code;", "", "loggingValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLoggingValue", "()Ljava/lang/String;", "SUCCESS", "CANCEL", "ERROR", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");

            @NotNull
            private final String loggingValue;

            private static final Code[] $values() [...] // Inlined contents

            private Code(String s1) {
                this.loggingValue = s1;
            }

            @NotNull
            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001C\u0010\u0006\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0007J&\u0010\u000B\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007J2\u0010\u0010\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\nH\u0007J\u001A\u0010\u0014\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001A\u00020\rH\u0007R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Result;", "createCancelResult", "request", "Lcom/facebook/login/LoginClient$Request;", "message", "", "createCompositeTokenResult", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "createErrorResult", "errorType", "errorDescription", "errorCode", "createTokenResult", "token", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.login.LoginClient.Result.Companion {
            private com.facebook.login.LoginClient.Result.Companion() {
            }

            public com.facebook.login.LoginClient.Result.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Result createCancelResult(@Nullable Request loginClient$Request0, @Nullable String s) {
                return new Result(loginClient$Request0, Code.CANCEL, null, s, null);
            }

            @NotNull
            public final Result createCompositeTokenResult(@Nullable Request loginClient$Request0, @Nullable AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0) {
                return new Result(loginClient$Request0, Code.SUCCESS, accessToken0, authenticationToken0, null, null);
            }

            @NotNull
            public final Result createErrorResult(@Nullable Request loginClient$Request0, @Nullable String s, @Nullable String s1) {
                return com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(this, loginClient$Request0, s, s1, null, 8, null);
            }

            @NotNull
            public final Result createErrorResult(@Nullable Request loginClient$Request0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
                ArrayList arrayList0 = new ArrayList();
                if(s != null) {
                    arrayList0.add(s);
                }
                if(s1 != null) {
                    arrayList0.add(s1);
                }
                String s3 = TextUtils.join(": ", arrayList0);
                return new Result(loginClient$Request0, Code.ERROR, null, s3, s2);
            }

            public static Result createErrorResult$default(com.facebook.login.LoginClient.Result.Companion loginClient$Result$Companion0, Request loginClient$Request0, String s, String s1, String s2, int v, Object object0) {
                if((v & 8) != 0) {
                    s2 = null;
                }
                return loginClient$Result$Companion0.createErrorResult(loginClient$Request0, s, s1, s2);
            }

            @NotNull
            public final Result createTokenResult(@Nullable Request loginClient$Request0, @NotNull AccessToken accessToken0) {
                q.g(accessToken0, "token");
                return new Result(loginClient$Request0, Code.SUCCESS, accessToken0, null, null);
            }
        }

        @NotNull
        public static final Parcelable.Creator CREATOR;
        @NotNull
        public static final com.facebook.login.LoginClient.Result.Companion Companion;
        @Nullable
        public final AuthenticationToken authenticationToken;
        @NotNull
        public final Code code;
        @Nullable
        public final String errorCode;
        @Nullable
        public final String errorMessage;
        @Nullable
        public Map extraData;
        @Nullable
        public Map loggingExtras;
        @Nullable
        public final Request request;
        @Nullable
        public final AccessToken token;

        static {
            Result.Companion = new com.facebook.login.LoginClient.Result.Companion(null);
            Result.CREATOR = new LoginClient.Result.Companion.CREATOR.1();
        }

        private Result(Parcel parcel0) {
            String s = parcel0.readString();
            if(s == null) {
                s = "error";
            }
            this.code = Code.valueOf(s);
            this.token = (AccessToken)parcel0.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken)parcel0.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel0.readString();
            this.errorCode = parcel0.readString();
            this.request = (Request)parcel0.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel0);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel0);
        }

        public Result(Parcel parcel0, DefaultConstructorMarker defaultConstructorMarker0) {
            this(parcel0);
        }

        public Result(@Nullable Request loginClient$Request0, @NotNull Code loginClient$Result$Code0, @Nullable AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0, @Nullable String s, @Nullable String s1) {
            q.g(loginClient$Result$Code0, "code");
            super();
            this.request = loginClient$Request0;
            this.token = accessToken0;
            this.authenticationToken = authenticationToken0;
            this.errorMessage = s;
            this.code = loginClient$Result$Code0;
            this.errorCode = s1;
        }

        public Result(@Nullable Request loginClient$Request0, @NotNull Code loginClient$Result$Code0, @Nullable AccessToken accessToken0, @Nullable String s, @Nullable String s1) {
            q.g(loginClient$Result$Code0, "code");
            this(loginClient$Request0, loginClient$Result$Code0, accessToken0, null, s, s1);
        }

        @NotNull
        public static final Result createCancelResult(@Nullable Request loginClient$Request0, @Nullable String s) {
            return Result.Companion.createCancelResult(loginClient$Request0, s);
        }

        @NotNull
        public static final Result createCompositeTokenResult(@Nullable Request loginClient$Request0, @Nullable AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0) {
            return Result.Companion.createCompositeTokenResult(loginClient$Request0, accessToken0, authenticationToken0);
        }

        @NotNull
        public static final Result createErrorResult(@Nullable Request loginClient$Request0, @Nullable String s, @Nullable String s1) {
            return Result.Companion.createErrorResult(loginClient$Request0, s, s1);
        }

        @NotNull
        public static final Result createErrorResult(@Nullable Request loginClient$Request0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
            return Result.Companion.createErrorResult(loginClient$Request0, s, s1, s2);
        }

        @NotNull
        public static final Result createTokenResult(@Nullable Request loginClient$Request0, @NotNull AccessToken accessToken0) {
            return Result.Companion.createTokenResult(loginClient$Request0, accessToken0);
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.code.name());
            parcel0.writeParcelable(this.token, v);
            parcel0.writeParcelable(this.authenticationToken, v);
            parcel0.writeString(this.errorMessage);
            parcel0.writeString(this.errorCode);
            parcel0.writeParcelable(this.request, v);
            Utility.writeNonnullStringMapToParcel(parcel0, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(parcel0, this.extraData);
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private BackgroundProcessingListener backgroundProcessingListener;
    private boolean checkedInternetPermission;
    private int currentHandler;
    @Nullable
    private Map extraData;
    @Nullable
    private I fragment;
    @Nullable
    private LoginMethodHandler[] handlersToTry;
    @Nullable
    private Map loggingExtras;
    @Nullable
    private LoginLogger loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;
    @Nullable
    private OnCompletedListener onCompletedListener;
    @Nullable
    private Request pendingRequest;

    static {
        LoginClient.Companion = new Companion(null);
        LoginClient.CREATOR = new LoginClient.Companion.CREATOR.1();
    }

    public LoginClient(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        LoginMethodHandler loginMethodHandler0;
        super();
        this.currentHandler = -1;
        Parcelable[] arr_parcelable = parcel0.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        if(arr_parcelable == null) {
            arr_parcelable = new Parcelable[0];
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; true; ++v) {
            loginMethodHandler0 = null;
            if(v >= arr_parcelable.length) {
                break;
            }
            Parcelable parcelable0 = arr_parcelable[v];
            if(parcelable0 instanceof LoginMethodHandler) {
                loginMethodHandler0 = (LoginMethodHandler)parcelable0;
            }
            if(loginMethodHandler0 != null) {
                loginMethodHandler0.setLoginClient(this);
            }
            if(loginMethodHandler0 != null) {
                arrayList0.add(loginMethodHandler0);
            }
        }
        this.handlersToTry = (LoginMethodHandler[])arrayList0.toArray(new LoginMethodHandler[0]);
        this.currentHandler = parcel0.readInt();
        this.pendingRequest = (Request)parcel0.readParcelable(Request.class.getClassLoader());
        Map map0 = Utility.readNonnullStringMapFromParcel(parcel0);
        this.loggingExtras = map0 == null ? null : C.a0(map0);
        Map map1 = Utility.readNonnullStringMapFromParcel(parcel0);
        if(map1 != null) {
            loginMethodHandler0 = C.a0(map1);
        }
        this.extraData = loginMethodHandler0;
    }

    public LoginClient(@NotNull I i0) {
        q.g(i0, "fragment");
        super();
        this.currentHandler = -1;
        this.setFragment(i0);
    }

    public final void addExtraData(@NotNull String s, @NotNull String s1, boolean z) {
        q.g(s, "key");
        q.g(s1, "value");
        Map map0 = this.extraData;
        if(map0 == null) {
            map0 = new HashMap();
        }
        if(this.extraData == null) {
            this.extraData = map0;
        }
        if(map0.containsKey(s) && z) {
            s1 = ((String)map0.get(s)) + ',' + s1;
        }
        map0.put(s, s1);
    }

    private final void addLoggingExtra(String s, String s1, boolean z) {
        Map map0 = this.loggingExtras;
        if(map0 == null) {
            map0 = new HashMap();
        }
        if(this.loggingExtras == null) {
            this.loggingExtras = map0;
        }
        if(map0.containsKey(s) && z) {
            s1 = ((String)map0.get(s)) + ',' + s1;
        }
        map0.put(s, s1);
    }

    public final void authorize(@Nullable Request loginClient$Request0) {
        if(loginClient$Request0 != null) {
            if(this.pendingRequest != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            }
            if(!AccessToken.Companion.isCurrentAccessTokenActive() || this.checkInternetPermission()) {
                this.pendingRequest = loginClient$Request0;
                this.handlersToTry = this.getHandlersToTry(loginClient$Request0);
                this.tryNextHandler();
            }
        }
    }

    public final void cancelCurrentHandler() {
        LoginMethodHandler loginMethodHandler0 = this.getCurrentHandler();
        if(loginMethodHandler0 != null) {
            loginMethodHandler0.cancel();
        }
    }

    public final boolean checkInternetPermission() {
        if(this.checkedInternetPermission) {
            return true;
        }
        if(this.checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            String s = null;
            String s1 = fragmentActivity0 == null ? null : fragmentActivity0.getString(string.com_facebook_internet_permission_error_title);
            if(fragmentActivity0 != null) {
                s = fragmentActivity0.getString(string.com_facebook_internet_permission_error_message);
            }
            this.complete(com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, s1, s, null, 8, null));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    public final int checkPermission(@NotNull String s) {
        q.g(s, "permission");
        FragmentActivity fragmentActivity0 = this.getActivity();
        return fragmentActivity0 == null ? -1 : fragmentActivity0.checkCallingOrSelfPermission(s);
    }

    public final void complete(@NotNull Result loginClient$Result0) {
        q.g(loginClient$Result0, "outcome");
        LoginMethodHandler loginMethodHandler0 = this.getCurrentHandler();
        if(loginMethodHandler0 != null) {
            this.logAuthorizationMethodComplete(loginMethodHandler0.getNameForLogging(), loginClient$Result0, loginMethodHandler0.getMethodLoggingExtras());
        }
        Map map0 = this.loggingExtras;
        if(map0 != null) {
            loginClient$Result0.loggingExtras = map0;
        }
        Map map1 = this.extraData;
        if(map1 != null) {
            loginClient$Result0.extraData = map1;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        this.notifyOnCompleteListener(loginClient$Result0);
    }

    public final void completeAndValidate(@NotNull Result loginClient$Result0) {
        q.g(loginClient$Result0, "outcome");
        if(loginClient$Result0.token != null && AccessToken.Companion.isCurrentAccessTokenActive()) {
            this.validateSameFbidAndFinish(loginClient$Result0);
            return;
        }
        this.complete(loginClient$Result0);
    }

    private final void completeWithFailure() {
        this.complete(com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "Login attempt failed.", null, null, 8, null));
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final FragmentActivity getActivity() {
        return this.fragment == null ? null : this.fragment.getActivity();
    }

    @Nullable
    public final BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    public final boolean getCheckedInternetPermission() {
        return this.checkedInternetPermission;
    }

    @Nullable
    public final LoginMethodHandler getCurrentHandler() {
        int v = this.currentHandler;
        if(v >= 0) {
            return this.handlersToTry == null ? null : this.handlersToTry[v];
        }
        return null;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getE2E() {
        return "{\"init\":1757129019754}";
    }

    @Nullable
    public final Map getExtraData() {
        return this.extraData;
    }

    @Nullable
    public final I getFragment() {
        return this.fragment;
    }

    @Nullable
    public final LoginMethodHandler[] getHandlersToTry() {
        return this.handlersToTry;
    }

    @Nullable
    public LoginMethodHandler[] getHandlersToTry(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        ArrayList arrayList0 = new ArrayList();
        LoginBehavior loginBehavior0 = loginClient$Request0.getLoginBehavior();
        if(!loginClient$Request0.isInstagramLogin()) {
            if(loginBehavior0.allowsGetTokenAuth()) {
                arrayList0.add(new GetTokenLoginMethodHandler(this));
            }
            if(!FacebookSdk.bypassAppSwitch && loginBehavior0.allowsKatanaAuth()) {
                arrayList0.add(new KatanaProxyLoginMethodHandler(this));
            }
        }
        else if(!FacebookSdk.bypassAppSwitch && loginBehavior0.allowsInstagramAppAuth()) {
            arrayList0.add(new InstagramAppLoginMethodHandler(this));
        }
        if(loginBehavior0.allowsCustomTabAuth()) {
            arrayList0.add(new CustomTabLoginMethodHandler(this));
        }
        if(loginBehavior0.allowsWebViewAuth()) {
            arrayList0.add(new WebViewLoginMethodHandler(this));
        }
        if(!loginClient$Request0.isInstagramLogin() && loginBehavior0.allowsDeviceAuth()) {
            arrayList0.add(new DeviceAuthMethodHandler(this));
        }
        return (LoginMethodHandler[])arrayList0.toArray(new LoginMethodHandler[0]);
    }

    public final boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    private final LoginLogger getLogger() {
        String s;
        LoginLogger loginLogger0 = this.loginLogger;
        if(loginLogger0 != null && q.b(loginLogger0.getApplicationId(), (this.pendingRequest == null ? null : this.pendingRequest.getApplicationId()))) {
            return loginLogger0;
        }
        Context context0 = this.getActivity();
        if(context0 == null) {
            context0 = FacebookSdk.getApplicationContext();
        }
        Request loginClient$Request0 = this.pendingRequest;
        if(loginClient$Request0 == null) {
            s = FacebookSdk.getApplicationId();
        }
        else {
            s = loginClient$Request0.getApplicationId();
            if(s == null) {
                s = FacebookSdk.getApplicationId();
            }
        }
        LoginLogger loginLogger1 = new LoginLogger(context0, s);
        this.loginLogger = loginLogger1;
        return loginLogger1;
    }

    @Nullable
    public final Map getLoggingExtras() {
        return this.loggingExtras;
    }

    public static final int getLoginRequestCode() {
        return LoginClient.Companion.getLoginRequestCode();
    }

    @Nullable
    public final OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    @Nullable
    public final Request getPendingRequest() {
        return this.pendingRequest;
    }

    private final void logAuthorizationMethodComplete(String s, Result loginClient$Result0, Map map0) {
        this.logAuthorizationMethodComplete(s, loginClient$Result0.code.getLoggingValue(), loginClient$Result0.errorMessage, loginClient$Result0.errorCode, map0);
    }

    private final void logAuthorizationMethodComplete(String s, String s1, String s2, String s3, Map map0) {
        Request loginClient$Request0 = this.pendingRequest;
        String s4 = "fb_mobile_login_method_complete";
        if(loginClient$Request0 == null) {
            this.getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", s);
            return;
        }
        LoginLogger loginLogger0 = this.getLogger();
        String s5 = loginClient$Request0.getAuthId();
        if(loginClient$Request0.isFamilyLogin()) {
            s4 = "foa_mobile_login_method_complete";
        }
        loginLogger0.logAuthorizationMethodComplete(s5, s, s1, s2, s3, map0, s4);
    }

    public final void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener loginClient$BackgroundProcessingListener0 = this.backgroundProcessingListener;
        if(loginClient$BackgroundProcessingListener0 != null) {
            loginClient$BackgroundProcessingListener0.onBackgroundProcessingStarted();
        }
    }

    public final void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener loginClient$BackgroundProcessingListener0 = this.backgroundProcessingListener;
        if(loginClient$BackgroundProcessingListener0 != null) {
            loginClient$BackgroundProcessingListener0.onBackgroundProcessingStopped();
        }
    }

    private final void notifyOnCompleteListener(Result loginClient$Result0) {
        OnCompletedListener loginClient$OnCompletedListener0 = this.onCompletedListener;
        if(loginClient$OnCompletedListener0 != null) {
            loginClient$OnCompletedListener0.onCompleted(loginClient$Result0);
        }
    }

    public final boolean onActivityResult(int v, int v1, @Nullable Intent intent0) {
        ++this.numActivitiesReturned;
        if(this.pendingRequest != null) {
            if(intent0 != null && intent0.getBooleanExtra("CustomTabMainActivity.no_activity_exception", false)) {
                this.tryNextHandler();
                return false;
            }
            LoginMethodHandler loginMethodHandler0 = this.getCurrentHandler();
            return loginMethodHandler0 == null || loginMethodHandler0.shouldKeepTrackOfMultipleIntents() && intent0 == null && this.numActivitiesReturned < this.numTotalIntentsFired ? false : loginMethodHandler0.onActivityResult(v, v1, intent0);
        }
        return false;
    }

    public final void setBackgroundProcessingListener(@Nullable BackgroundProcessingListener loginClient$BackgroundProcessingListener0) {
        this.backgroundProcessingListener = loginClient$BackgroundProcessingListener0;
    }

    public final void setCheckedInternetPermission(boolean z) {
        this.checkedInternetPermission = z;
    }

    public final void setCurrentHandlerIndex(int v) {
        this.currentHandler = v;
    }

    public final void setExtraData(@Nullable Map map0) {
        this.extraData = map0;
    }

    public final void setFragment(@Nullable I i0) {
        if(this.fragment != null) {
            throw new FacebookException("Can\'t set fragment once it is already set.");
        }
        this.fragment = i0;
    }

    public final void setHandlersToTry(@Nullable LoginMethodHandler[] arr_loginMethodHandler) {
        this.handlersToTry = arr_loginMethodHandler;
    }

    public final void setLoggingExtras(@Nullable Map map0) {
        this.loggingExtras = map0;
    }

    public final void setOnCompletedListener(@Nullable OnCompletedListener loginClient$OnCompletedListener0) {
        this.onCompletedListener = loginClient$OnCompletedListener0;
    }

    public final void setPendingRequest(@Nullable Request loginClient$Request0) {
        this.pendingRequest = loginClient$Request0;
    }

    public final void startOrContinueAuth(@Nullable Request loginClient$Request0) {
        if(!this.getInProgress()) {
            this.authorize(loginClient$Request0);
        }
    }

    public final boolean tryCurrentHandler() {
        LoginMethodHandler loginMethodHandler0 = this.getCurrentHandler();
        if(loginMethodHandler0 == null) {
            return false;
        }
        if(loginMethodHandler0.needsInternetPermission() && !this.checkInternetPermission()) {
            this.addLoggingExtra("no_internet_permission", "1", false);
            return false;
        }
        Request loginClient$Request0 = this.pendingRequest;
        if(loginClient$Request0 == null) {
            return false;
        }
        int v = loginMethodHandler0.tryAuthorize(loginClient$Request0);
        this.numActivitiesReturned = 0;
        if(v > 0) {
            this.getLogger().logAuthorizationMethodStart(loginClient$Request0.getAuthId(), loginMethodHandler0.getNameForLogging(), (loginClient$Request0.isFamilyLogin() ? "foa_mobile_login_method_start" : "fb_mobile_login_method_start"));
            this.numTotalIntentsFired = v;
            return v > 0;
        }
        this.getLogger().logAuthorizationMethodNotTried(loginClient$Request0.getAuthId(), loginMethodHandler0.getNameForLogging(), (loginClient$Request0.isFamilyLogin() ? "foa_mobile_login_method_not_tried" : "fb_mobile_login_method_not_tried"));
        this.addLoggingExtra("not_tried", loginMethodHandler0.getNameForLogging(), true);
        return v > 0;
    }

    public final void tryNextHandler() {
        LoginMethodHandler loginMethodHandler0 = this.getCurrentHandler();
        if(loginMethodHandler0 != null) {
            this.logAuthorizationMethodComplete(loginMethodHandler0.getNameForLogging(), "skipped", null, null, loginMethodHandler0.getMethodLoggingExtras());
        }
        LoginMethodHandler[] arr_loginMethodHandler = this.handlersToTry;
        while(arr_loginMethodHandler != null) {
            int v = this.currentHandler;
            if(v >= arr_loginMethodHandler.length - 1) {
                break;
            }
            this.currentHandler = v + 1;
            if(this.tryCurrentHandler()) {
                return;
            }
            if(false) {
                break;
            }
        }
        if(this.pendingRequest != null) {
            this.completeWithFailure();
        }
    }

    public final void validateSameFbidAndFinish(@NotNull Result loginClient$Result0) {
        Result loginClient$Result1;
        q.g(loginClient$Result0, "pendingResult");
        if(loginClient$Result0.token == null) {
            throw new FacebookException("Can\'t validate without a token");
        }
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        AccessToken accessToken1 = loginClient$Result0.token;
        try {
            if(accessToken0 == null) {
                loginClient$Result1 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "User logged in as different Facebook user.", null, null, 8, null);
            }
            else if(q.b(accessToken0.getUserId(), accessToken1.getUserId())) {
                loginClient$Result1 = Result.Companion.createCompositeTokenResult(this.pendingRequest, loginClient$Result0.token, loginClient$Result0.authenticationToken);
            }
            else {
                loginClient$Result1 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "User logged in as different Facebook user.", null, null, 8, null);
            }
            this.complete(loginClient$Result1);
        }
        catch(Exception exception0) {
            this.complete(com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "Caught exception", exception0.getMessage(), null, 8, null));
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeParcelableArray(this.handlersToTry, v);
        parcel0.writeInt(this.currentHandler);
        parcel0.writeParcelable(this.pendingRequest, v);
        Utility.writeNonnullStringMapToParcel(parcel0, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(parcel0, this.extraData);
    }
}

