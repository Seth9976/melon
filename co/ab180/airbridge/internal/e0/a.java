package co.ab180.airbridge.internal.e0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import co.ab180.airbridge.internal.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A!\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "url", "", "a", "(Landroid/content/Context;Ljava/lang/String;)Z", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class a {
    public static final boolean a(@NotNull Context context0, @Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s));
                intent0.setFlags(0x30000000);
                context0.startActivity(intent0);
                return true;
            }
            catch(Throwable throwable0) {
                b.e.f(throwable0);
            }
        }
        return false;
    }
}

