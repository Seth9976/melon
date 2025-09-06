package co.ab180.airbridge.internal.u.c;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.hybrid.AirbridgeJavascriptInterface;
import co.ab180.airbridge.internal.hybrid.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\f\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lco/ab180/airbridge/internal/u/c/q;", "Lco/ab180/airbridge/internal/u/c/t;", "<init>", "()V", "Landroid/webkit/WebView;", "webView", "", "webToken", "Lie/H;", "a", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "postMessageScript", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "command", "f", "(Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class q implements t {
    @Override  // co.ab180.airbridge.internal.u.c.t
    @SuppressLint({"AddJavascriptInterface"})
    public void a(@NotNull WebView webView0, @NotNull String s) {
        webView0.addJavascriptInterface(new AirbridgeJavascriptInterface(s), "AirbridgeNative");
        b.e.a("Javascript interface has been injected (" + s + ')', new Object[0]);
        b.e.d("Successfully injected web interface into the submitted WebView", new Object[0]);
    }

    @Override  // co.ab180.airbridge.internal.u.c.t
    @NotNull
    public String c(@NotNull String s, @NotNull String s1) {
        return a.a.a(s, s1);
    }

    @Override  // co.ab180.airbridge.internal.u.c.t
    public void f(@NotNull String s) {
        co.ab180.airbridge.internal.hybrid.b.b.h(s);
    }
}

