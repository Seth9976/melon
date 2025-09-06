package com.kakaoent.trevi.ad.webview.helper;

import I7.k;
import android.annotation.TargetApi;
import android.app.Activity;
import android.security.KeyChain;
import android.security.KeyChainException;
import android.webkit.ClientCertRequest;
import android.webkit.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u00020\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/ClientCertRequestDialog;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/webkit/WebView;", "view", "Landroid/webkit/ClientCertRequest;", "request", "Lie/H;", "onReceivedClientCertRequest", "(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/ClientCertRequest;)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ClientCertRequestDialog {
    @NotNull
    public static final ClientCertRequestDialog INSTANCE;

    static {
        ClientCertRequestDialog.INSTANCE = new ClientCertRequestDialog();
    }

    // 检测为 Lambda 实现
    public static void a(Activity activity0, String s, ClientCertRequest clientCertRequest0) [...]

    public static void b(Activity activity0, String s, ClientCertRequest clientCertRequest0) {
        ClientCertRequestDialog.onReceivedClientCertRequest$lambda$1$lambda$0(activity0, s, clientCertRequest0);
    }

    @TargetApi(21)
    public final void onReceivedClientCertRequest(@Nullable Activity activity0, @Nullable WebView webView0, @Nullable ClientCertRequest clientCertRequest0) {
        if(activity0 == null || clientCertRequest0 == null) {
            return;
        }
        KeyChain.choosePrivateKeyAlias(activity0, (String s) -> ClientCertRequestDialog.onReceivedClientCertRequest$lambda$1(clientCertRequest0, activity0, s), clientCertRequest0.getKeyTypes(), clientCertRequest0.getPrincipals(), clientCertRequest0.getHost(), clientCertRequest0.getPort(), null);
    }

    private static final void onReceivedClientCertRequest$lambda$1(ClientCertRequest clientCertRequest0, Activity activity0, String s) {
        if(s == null) {
            clientCertRequest0.cancel();
            return;
        }
        new Thread(new k(activity0, s, clientCertRequest0, 1)).start();
    }

    private static final void onReceivedClientCertRequest$lambda$1$lambda$0(Activity activity0, String s, ClientCertRequest clientCertRequest0) {
        try {
            clientCertRequest0.proceed(KeyChain.getPrivateKey(activity0, s), KeyChain.getCertificateChain(activity0, s));
        }
        catch(InterruptedException unused_ex) {
            clientCertRequest0.ignore();
        }
        catch(KeyChainException unused_ex) {
            clientCertRequest0.ignore();
        }
    }
}

