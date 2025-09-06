package com.kakao.sdk.auth;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.session.M;
import com.google.firebase.b;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.KakaoCustomTabsClient;
import com.kakao.sdk.common.util.SdkLog.Companion;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u000E\u0010\bJ\u0019\u0010\u0011\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u001A\u0010\u0003J\u0019\u0010\u001B\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u001B\u0010\u0019J\u000F\u0010\u001C\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u001C\u0010\u0003R\u0016\u0010\u001E\u001A\u00020\u001D8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0016\u0010 \u001A\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001A\u00020\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001A\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R\u0018\u0010)\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/kakao/sdk/auth/CustomTabLauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/net/Uri;", "uri", "Lie/H;", "openChromeCustomTab", "(Landroid/net/Uri;)V", "openBrowserWithoutBinding", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "exception", "sendError", "(Lcom/kakao/sdk/common/model/KakaoSdkError;)V", "sendOK", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onRestoreInstanceState", "Landroid/content/Intent;", "intent", "loadData", "(Landroid/content/Intent;)V", "onResume", "onNewIntent", "onDestroy", "Landroid/os/ResultReceiver;", "resultReceiver", "Landroid/os/ResultReceiver;", "fullUri", "Landroid/net/Uri;", "", "customTabsOpened", "Z", "Landroid/content/ServiceConnection;", "customTabsConnection", "Landroid/content/ServiceConnection;", "Landroid/os/Handler;", "internalHandler", "Landroid/os/Handler;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class CustomTabLauncherActivity extends AppCompatActivity {
    @Nullable
    private ServiceConnection customTabsConnection;
    private boolean customTabsOpened;
    private Uri fullUri;
    @Nullable
    private Handler internalHandler;
    private ResultReceiver resultReceiver;

    public static boolean k(CustomTabLauncherActivity customTabLauncherActivity0, Message message0) {
        return CustomTabLauncherActivity.loadData$lambda$1(customTabLauncherActivity0, message0);
    }

    public void loadData(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        try {
            Bundle bundle0 = intent0.getExtras();
            if(bundle0 != null) {
                Bundle bundle1 = bundle0.getBundle("key.bundle");
                if(bundle1 != null) {
                    ResultReceiver resultReceiver0 = (ResultReceiver)b.F(bundle1, "key.result.receiver", ResultReceiver.class);
                    if(resultReceiver0 == null) {
                        throw new IllegalStateException();
                    }
                    this.resultReceiver = resultReceiver0;
                    Uri uri0 = (Uri)b.F(bundle1, "key.full_authorize_uri", Uri.class);
                    if(uri0 == null) {
                        throw new IllegalStateException();
                    }
                    this.fullUri = uri0;
                }
            }
            this.internalHandler = new Handler(Looper.getMainLooper(), new M(this, 3));
            return;
        }
        catch(Throwable throwable0) {
        }
        SdkLog.Companion.e(throwable0);
        ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, null, 2, null);
        clientError0.initCause(throwable0);
        this.sendError(clientError0);
    }

    private static final boolean loadData$lambda$1(CustomTabLauncherActivity customTabLauncherActivity0, Message message0) {
        q.g(customTabLauncherActivity0, "this$0");
        q.g(message0, "it");
        SdkLog.Companion.i("handle delay message");
        customTabLauncherActivity0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
        return true;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Intent intent0 = this.getIntent();
        q.f(intent0, "intent");
        this.loadData(intent0);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onDestroy() {
        super.onDestroy();
        ServiceConnection serviceConnection0 = this.customTabsConnection;
        if(serviceConnection0 != null) {
            this.unbindService(serviceConnection0);
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public void onNewIntent(@Nullable Intent intent0) {
        super.onNewIntent(intent0);
        SdkLog.Companion.i("onNewIntent");
        this.setIntent(intent0);
        if(q.b((this.internalHandler == null ? null : Boolean.valueOf(this.internalHandler.hasMessages(0))), Boolean.TRUE)) {
            Handler handler0 = this.internalHandler;
            if(handler0 != null) {
                handler0.removeMessages(0);
            }
        }
        this.internalHandler = null;
        if(intent0 != null) {
            Uri uri0 = intent0.getData();
            if(uri0 != null) {
                this.sendOK(uri0);
            }
        }
        this.finish();
    }

    @Override  // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        super.onRestoreInstanceState(bundle0);
        this.customTabsOpened = bundle0.getBoolean("key.customtabs.opened", this.customTabsOpened);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        Boolean boolean0 = null;
        if(!this.customTabsOpened) {
            this.customTabsOpened = true;
            Uri uri0 = this.fullUri;
            if(uri0 != null) {
                this.openChromeCustomTab(uri0);
                return;
            }
            this.sendError(new ClientError(ClientErrorCause.IllegalState, "url has been not initialized."));
            return;
        }
        SdkLog.Companion.i("trigger delay message");
        Handler handler0 = this.internalHandler;
        if(handler0 != null) {
            boolean0 = Boolean.valueOf(handler0.hasMessages(0));
        }
        if(q.b(boolean0, Boolean.FALSE)) {
            Handler handler1 = this.internalHandler;
            if(handler1 != null) {
                handler1.sendEmptyMessageDelayed(0, 100L);
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("key.customtabs.opened", this.customTabsOpened);
    }

    private final void openBrowserWithoutBinding(Uri uri0) {
        try {
            KakaoCustomTabsClient.INSTANCE.open(this, uri0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            SdkLog.Companion.w(activityNotFoundException0);
            this.sendError(new ClientError(ClientErrorCause.NotSupported, "No browser has been installed on a device."));
        }
    }

    private final void openChromeCustomTab(Uri uri0) {
        Companion sdkLog$Companion0 = SdkLog.Companion;
        sdkLog$Companion0.i("Authorize Uri: " + uri0);
        try {
            ServiceConnection serviceConnection0 = KakaoCustomTabsClient.INSTANCE.openWithDefault(this, uri0);
            this.customTabsConnection = serviceConnection0;
            if(serviceConnection0 == null) {
                sdkLog$Companion0.i("try to open chrome without service binding");
                this.openBrowserWithoutBinding(uri0);
            }
        }
        catch(UnsupportedOperationException unsupportedOperationException0) {
            SdkLog.Companion.w(unsupportedOperationException0);
            this.openBrowserWithoutBinding(uri0);
        }
    }

    private final void sendError(KakaoSdkError kakaoSdkError0) {
        ResultReceiver resultReceiver0 = this.resultReceiver;
        if(resultReceiver0 != null) {
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("key.exception", kakaoSdkError0);
            resultReceiver0.send(0, bundle0);
        }
        this.finish();
    }

    private final void sendOK(Uri uri0) {
        ResultReceiver resultReceiver0 = this.resultReceiver;
        if(resultReceiver0 != null) {
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("key.url", uri0);
            resultReceiver0.send(-1, bundle0);
        }
        this.finish();
    }
}

