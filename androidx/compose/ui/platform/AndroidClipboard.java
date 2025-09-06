package androidx.compose.ui.platform;

import Q0.g0;
import Q0.h0;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/AndroidClipboard;", "LQ0/h0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidClipboard implements h0 {
    public final AndroidClipboardManager a;

    public AndroidClipboard(@NotNull Context context0) {
        this(new AndroidClipboardManager(context0));
    }

    public AndroidClipboard(AndroidClipboardManager androidClipboardManager0) {
        this.a = androidClipboardManager0;
    }

    public final void a(g0 g00) {
        ClipboardManager clipboardManager0 = this.a.a;
        if(g00 == null) {
            if(Build.VERSION.SDK_INT >= 28) {
                clipboardManager0.clearPrimaryClip();
                return;
            }
            clipboardManager0.setPrimaryClip(ClipData.newPlainText("", ""));
            return;
        }
        clipboardManager0.setPrimaryClip(g00.a);
    }
}

