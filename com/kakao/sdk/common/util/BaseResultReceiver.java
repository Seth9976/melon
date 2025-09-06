package com.kakao.sdk.common.util;

import U4.x;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.firebase.b;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0011\b\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00028\u0001H\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00028\u0000H&¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u0011H&¢\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010 \u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0014¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001E¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001E¢\u0006\u0004\b$\u0010#J\r\u0010%\u001A\u00020\n¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\'R(\u0010\t\u001A\u0004\u0018\u00018\u00012\b\u0010(\u001A\u0004\u0018\u00018\u00018\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\t\u0010)\u001A\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/kakao/sdk/common/util/BaseResultReceiver;", "", "T", "E", "Landroid/os/ResultReceiver;", "", "identifier", "<init>", "(Ljava/lang/String;)V", "emitter", "Lie/H;", "setEmitter", "(Ljava/lang/Object;)V", "Landroid/net/Uri;", "url", "parseResponse", "(Landroid/net/Uri;)Ljava/lang/Object;", "", "parseError", "(Landroid/net/Uri;)Ljava/lang/Throwable;", "", "isError", "(Landroid/net/Uri;)Z", "response", "onSuccess", "error", "onError", "(Ljava/lang/Throwable;)V", "", "resultCode", "Landroid/os/Bundle;", "resultData", "onReceiveResult", "(ILandroid/os/Bundle;)V", "receiveOk", "(Landroid/os/Bundle;)V", "receiveCanceled", "processError", "()V", "Ljava/lang/String;", "<set-?>", "Ljava/lang/Object;", "getEmitter", "()Ljava/lang/Object;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class BaseResultReceiver extends ResultReceiver {
    @Nullable
    private Object emitter;
    @NotNull
    private final String identifier;

    public BaseResultReceiver(@NotNull String s) {
        q.g(s, "identifier");
        super(new Handler(Looper.getMainLooper()));
        this.identifier = s;
    }

    @Nullable
    public final Object getEmitter() {
        return this.emitter;
    }

    public abstract boolean isError(@NotNull Uri arg1);

    public abstract void onError(@NotNull Throwable arg1);

    @Override  // android.os.ResultReceiver
    public void onReceiveResult(int v, @NotNull Bundle bundle0) {
        q.g(bundle0, "resultData");
        SdkLog.Companion.d("***** " + this.identifier + " Status: " + bundle0);
        switch(v) {
            case -1: {
                this.receiveOk(bundle0);
                break;
            }
            case 0: {
                this.receiveCanceled(bundle0);
                break;
            }
            default: {
                this.processError();
            }
        }
        this.emitter = null;
    }

    public abstract void onSuccess(@NotNull Object arg1);

    @NotNull
    public abstract Throwable parseError(@NotNull Uri arg1);

    @Nullable
    public abstract Object parseResponse(@NotNull Uri arg1);

    public final void processError() {
        this.onError(new IllegalStateException(x.k("Unknown resultCode in ", this.getClass().getSimpleName(), "#onReceivedResult()")));
    }

    public final void receiveCanceled(@NotNull Bundle bundle0) {
        q.g(bundle0, "resultData");
        KakaoSdkError kakaoSdkError0 = (KakaoSdkError)b.G(bundle0, "key.exception", KakaoSdkError.class);
        if(kakaoSdkError0 != null) {
            this.onError(kakaoSdkError0);
        }
    }

    public final void receiveOk(@NotNull Bundle bundle0) {
        q.g(bundle0, "resultData");
        Uri uri0 = (Uri)b.F(bundle0, "key.url", Uri.class);
        if(uri0 == null) {
            throw new IllegalStateException();
        }
        if(this.isError(uri0)) {
            this.onError(this.parseError(uri0));
            return;
        }
        Object object0 = this.parseResponse(uri0);
        if(object0 == null) {
            this.onError(new ClientError(ClientErrorCause.Unknown, "Failed to parse response\n" + uri0));
            return;
        }
        this.onSuccess(object0);
    }

    public final void setEmitter(Object object0) {
        this.emitter = object0;
    }
}

