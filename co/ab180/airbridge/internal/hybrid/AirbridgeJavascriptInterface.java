package co.ab180.airbridge.internal.hybrid;

import android.webkit.JavascriptInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0005R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/AirbridgeJavascriptInterface;", "", "", "webToken", "<init>", "(Ljava/lang/String;)V", "getWebToken", "()Ljava/lang/String;", "", "getJSONSchemaVersion", "()I", "jsonString", "Lie/H;", "execute", "a", "Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeJavascriptInterface {
    private final String a;

    public AirbridgeJavascriptInterface(@NotNull String s) {
        this.a = s;
    }

    @JavascriptInterface
    public final void execute(@NotNull String s) {
        b.b.h(s);
    }

    @JavascriptInterface
    public final int getJSONSchemaVersion() {
        return 5;
    }

    @JavascriptInterface
    @NotNull
    public final String getWebToken() {
        return this.a;
    }
}

