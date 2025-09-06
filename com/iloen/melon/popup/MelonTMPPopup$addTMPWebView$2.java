package com.iloen.melon.popup;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.iloen.melon.custom.MelonWebViewListener;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.OpenUri;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r8.f;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000E\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u000E\u001A\u00020\r2\b\u0010\t\u001A\u0004\u0018\u00010\u00042\b\u0010\n\u001A\u0004\u0018\u00010\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ9\u0010\u0017\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00022\u0014\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u00112\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u001D\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u00062\b\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ-\u0010\u001F\u001A\u00020\r2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"com/iloen/melon/popup/MelonTMPPopup$addTMPWebView$2", "Lcom/iloen/melon/custom/MelonWebViewListener;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "command", "param1", "param2", "param3", "Lie/H;", "requestCommand", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "", "fileChooserParams", "showFileChooser", "(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Ljava/lang/Object;)Z", "play", "cType", "menuId", "cId", "addOrPlay", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "playMixUp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "restoreScreenRotation", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTMPPopup.addTMPWebView.2 implements MelonWebViewListener {
    public final MelonTMPPopup a;

    public MelonTMPPopup.addTMPWebView.2(MelonTMPPopup melonTMPPopup0) {
        this.a = melonTMPPopup0;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void addOrPlay(boolean z, String s, String s1, String s2) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void playMixUp(String s, String s1, String s2) {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void requestCommand(String s, String s1, String s2, String s3) {
        if(q.b(s, "TMPConfirm")) {
            boolean z = q.b(s1, "true");
            MelonTMPPopup melonTMPPopup0 = this.a;
            if(z) {
                ToastManager.show("동의가 완료되었습니다.");
                melonTMPPopup0.dismiss();
                return;
            }
            ToastManager.show("동의가 실패되었습니다. 다시 시도해주세요.");
        }
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public void restoreScreenRotation() {
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public boolean shouldOverrideUrlLoading(WebView webView0, String s) {
        LogU.Companion.d("MelonTMPPopup", "shouldOverrideUrlLoading: " + s);
        Uri uri0 = Uri.parse(s);
        if("melonapp".equalsIgnoreCase(uri0.getScheme()) && f.c(uri0) == 109) {
            EventBusHelper.post(new OpenUri(uri0));
            this.a.dismiss();
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewListener
    public boolean showFileChooser(WebView webView0, ValueCallback valueCallback0, Object object0) {
        return false;
    }
}

