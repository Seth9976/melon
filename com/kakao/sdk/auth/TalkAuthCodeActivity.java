package com.kakao.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.f0;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog.Companion;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.v2.auth.R.layout;
import e.a;
import e.b;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0012\u001A\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0019\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b\u001D\u0010\u001A\u001A\u0004\b\u001E\u0010\u001CR\u001A\u0010\u001F\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b\u001F\u0010\u001A\u001A\u0004\b \u0010\u001CR\u001A\u0010!\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b!\u0010\u001A\u001A\u0004\b\"\u0010\u001CR\u001A\u0010#\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b#\u0010\u001A\u001A\u0004\b$\u0010\u001CR\u001A\u0010%\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b%\u0010\u001A\u001A\u0004\b&\u0010\u001CR\u001A\u0010\'\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b\'\u0010\u001A\u001A\u0004\b(\u0010\u001CR\u001A\u0010)\u001A\u00020\u00188\u0006X\u0086D¢\u0006\f\n\u0004\b)\u0010\u001A\u001A\u0004\b*\u0010\u001C¨\u0006+"}, d2 = {"Lcom/kakao/sdk/auth/TalkAuthCodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "exception", "Lie/H;", "sendError", "(Lcom/kakao/sdk/common/model/KakaoSdkError;)V", "Le/a;", "Landroidx/activity/result/ActivityResult;", "activityResultCallback", "()Le/a;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/os/ResultReceiver;", "resultReceiver", "Landroid/os/ResultReceiver;", "Le/b;", "Landroid/content/Intent;", "activityResultLauncher", "Le/b;", "", "EXTRA_ERROR_TYPE", "Ljava/lang/String;", "getEXTRA_ERROR_TYPE", "()Ljava/lang/String;", "EXTRA_ERROR_DESCRIPTION", "getEXTRA_ERROR_DESCRIPTION", "NOT_SUPPORT_ERROR", "getNOT_SUPPORT_ERROR", "UNKNOWN_ERROR", "getUNKNOWN_ERROR", "PROTOCOL_ERROR", "getPROTOCOL_ERROR", "APPLICATION_ERROR", "getAPPLICATION_ERROR", "AUTH_CODE_ERROR", "getAUTH_CODE_ERROR", "CLIENT_INFO_ERROR", "getCLIENT_INFO_ERROR", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TalkAuthCodeActivity extends AppCompatActivity {
    @NotNull
    private final String APPLICATION_ERROR;
    @NotNull
    private final String AUTH_CODE_ERROR;
    @NotNull
    private final String CLIENT_INFO_ERROR;
    @NotNull
    private final String EXTRA_ERROR_DESCRIPTION;
    @NotNull
    private final String EXTRA_ERROR_TYPE;
    @NotNull
    private final String NOT_SUPPORT_ERROR;
    @NotNull
    private final String PROTOCOL_ERROR;
    @NotNull
    private final String UNKNOWN_ERROR;
    @NotNull
    private final b activityResultLauncher;
    private ResultReceiver resultReceiver;

    public TalkAuthCodeActivity() {
        b b0 = this.registerForActivityResult(new f0(2), this.activityResultCallback());
        q.f(b0, "registerForActivityResul…ityResultCallback()\n    )");
        this.activityResultLauncher = b0;
        this.EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
        this.EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
        this.NOT_SUPPORT_ERROR = "NotSupportError";
        this.UNKNOWN_ERROR = "UnknownError";
        this.PROTOCOL_ERROR = "ProtocolError";
        this.APPLICATION_ERROR = "ApplicationError";
        this.AUTH_CODE_ERROR = "AuthCodeError";
        this.CLIENT_INFO_ERROR = "ClientInfoError";
    }

    private final a activityResultCallback() {
        return new com.iloen.melon.fragments.radio.a(this, 4);
    }

    private static final void activityResultCallback$lambda$7(TalkAuthCodeActivity talkAuthCodeActivity0, ActivityResult activityResult0) {
        q.g(talkAuthCodeActivity0, "this$0");
        Bundle bundle0 = new Bundle();
        Intent intent0 = activityResult0.b;
        if(intent0 != null) {
            switch(activityResult0.a) {
                case -1: {
                    Bundle bundle1 = intent0 == null ? null : intent0.getExtras();
                    if(bundle1 == null) {
                        talkAuthCodeActivity0.sendError(new ClientError(ClientErrorCause.Unknown, "No result from KakaoTalk."));
                        return;
                    }
                    String s = bundle1.getString(talkAuthCodeActivity0.EXTRA_ERROR_TYPE);
                    String s1 = bundle1.getString(talkAuthCodeActivity0.EXTRA_ERROR_DESCRIPTION);
                    if(q.b(s, "access_denied")) {
                        talkAuthCodeActivity0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
                        return;
                    }
                    if(s != null) {
                        Json json0 = KakaoJson.INSTANCE.getJson();
                        json0.getSerializersModule();
                        AuthErrorCause authErrorCause0 = (AuthErrorCause)json0.decodeFromString(BuiltinSerializersKt.getNullable(AuthErrorCause.Companion.serializer()), s);
                        if(authErrorCause0 == null) {
                            authErrorCause0 = AuthErrorCause.Unknown;
                        }
                        if(s1 == null) {
                            s1 = "no error description";
                        }
                        talkAuthCodeActivity0.sendError(new AuthError(302, authErrorCause0, new AuthErrorResponse(s, s1)));
                        return;
                    }
                    bundle0.putParcelable("key.url", Uri.parse(bundle1.getString("com.kakao.sdk.talk.redirectUrl")));
                    ResultReceiver resultReceiver0 = talkAuthCodeActivity0.resultReceiver;
                    if(resultReceiver0 != null) {
                        resultReceiver0.send(-1, bundle0);
                        talkAuthCodeActivity0.finish();
                        talkAuthCodeActivity0.overridePendingTransition(0, 0);
                        return;
                    }
                    q.m("resultReceiver");
                    throw null;
                }
                case 0: {
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        talkAuthCodeActivity0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
    }

    @NotNull
    public final String getAPPLICATION_ERROR() {
        return this.APPLICATION_ERROR;
    }

    @NotNull
    public final String getAUTH_CODE_ERROR() {
        return this.AUTH_CODE_ERROR;
    }

    @NotNull
    public final String getCLIENT_INFO_ERROR() {
        return this.CLIENT_INFO_ERROR;
    }

    @NotNull
    public final String getEXTRA_ERROR_DESCRIPTION() {
        return this.EXTRA_ERROR_DESCRIPTION;
    }

    @NotNull
    public final String getEXTRA_ERROR_TYPE() {
        return this.EXTRA_ERROR_TYPE;
    }

    @NotNull
    public final String getNOT_SUPPORT_ERROR() {
        return this.NOT_SUPPORT_ERROR;
    }

    @NotNull
    public final String getPROTOCOL_ERROR() {
        return this.PROTOCOL_ERROR;
    }

    @NotNull
    public final String getUNKNOWN_ERROR() {
        return this.UNKNOWN_ERROR;
    }

    public static void k(TalkAuthCodeActivity talkAuthCodeActivity0, ActivityResult activityResult0) {
        TalkAuthCodeActivity.activityResultCallback$lambda$7(talkAuthCodeActivity0, activityResult0);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(layout.activity_talk_auth_code);
        try {
            Bundle bundle1 = this.getIntent().getExtras();
            if(bundle1 == null) {
                throw new IllegalArgumentException("no extras.");
            }
            Bundle bundle2 = bundle1.getBundle("key.bundle");
            if(bundle2 != null) {
                ResultReceiver resultReceiver0 = (ResultReceiver)com.google.firebase.b.F(bundle2, "key.result.receiver", ResultReceiver.class);
                if(resultReceiver0 == null) {
                    throw new IllegalStateException();
                }
                this.resultReceiver = resultReceiver0;
            }
            int v = bundle1.getInt("key.request.code");
            Companion sdkLog$Companion0 = SdkLog.Companion;
            sdkLog$Companion0.i("requestCode: " + v);
            Intent intent0 = (Intent)com.google.firebase.b.F(bundle1, "key.login.intent", Intent.class);
            sdkLog$Companion0.i("loginIntent:");
            if(intent0 != null) {
                Bundle bundle3 = intent0.getExtras();
                if(bundle3 != null) {
                    sdkLog$Companion0.i("\tcom.kakao.sdk.talk.appKey : " + bundle3.getString("com.kakao.sdk.talk.appKey"));
                    sdkLog$Companion0.i("\tcom.kakao.sdk.talk.redirectUri : " + bundle3.getString("com.kakao.sdk.talk.redirectUri"));
                    sdkLog$Companion0.i("\tcom.kakao.sdk.talk.kaHeader : " + bundle3.getString("com.kakao.sdk.talk.kaHeader"));
                    Bundle bundle4 = bundle3.getBundle("com.kakao.sdk.talk.extraparams");
                    if(bundle4 != null) {
                        sdkLog$Companion0.i("\tcom.kakao.sdk.talk.extraparams");
                        Set set0 = bundle4.keySet();
                        q.f(set0, "keySet()");
                        ArrayList arrayList0 = new ArrayList(je.q.Q(10, set0));
                        for(Object object0: set0) {
                            arrayList0.add("\t\t" + ((String)object0) + " : " + bundle4.getString(((String)object0)));
                        }
                        for(Object object1: arrayList0) {
                            SdkLog.Companion.i(((String)object1));
                        }
                    }
                }
            }
            this.activityResultLauncher.b(intent0);
            return;
        }
        catch(Throwable throwable0) {
        }
        SdkLog.Companion.e(throwable0);
        ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, null, 2, null);
        clientError0.initCause(throwable0);
        this.sendError(clientError0);
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
}

