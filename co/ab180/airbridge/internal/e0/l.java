package co.ab180.airbridge.internal.e0;

import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import co.ab180.airbridge.internal.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001A\u0013\u0010\u0006\u001A\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0013\u0010\b\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0003\u001A\u0013\u0010\t\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0003\u001A\u0013\u0010\n\u001A\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0007\u001A#\u0010\n\u001A\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u000BH\u0000¢\u0006\u0004\b\n\u0010\u000E\u001A\u0015\u0010\u0010\u001A\u0004\u0018\u00010\u000F*\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0012\"\u0014\u0010\u0014\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroid/content/Intent;", "", "e", "(Landroid/content/Intent;)Z", "g", "Lie/H;", "b", "(Landroid/content/Intent;)V", "d", "f", "a", "", "action", "dataString", "(Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/net/Uri;", "c", "(Landroid/content/Intent;)Landroid/net/Uri;", "Ljava/lang/String;", "KEY_DISPOSED", "KEY_CONSUMED", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class l {
    private static final String a = "airbridge_disposed";
    private static final String b = "airbridge_consumed";

    public static final void a(@NotNull Intent intent0) {
        try {
            intent0.putExtra("airbridge_consumed", true);
        }
        catch(Exception exception0) {
            b.e.g(exception0);
        }
    }

    public static final boolean a(@Nullable String s, @Nullable String s1) {
        return q.b(s, "android.intent.action.VIEW") && s1 != null && s1.length() != 0;
    }

    public static final void b(@NotNull Intent intent0) {
        try {
            intent0.putExtra("airbridge_disposed", true);
        }
        catch(Exception exception0) {
            b.e.g(exception0);
        }
    }

    @Nullable
    public static final Uri c(@NotNull Intent intent0) {
        try {
            Uri uri0 = (Uri)intent0.getParcelableExtra("android.intent.extra.REFERRER");
            if(uri0 != null) {
                return uri0;
            }
        }
        catch(BadParcelableException unused_ex) {
            b.e.b("Failed to get Parcelable extra: name={android.intent.extra.REFERRER}", new Object[0]);
        }
        try {
            String s = intent0.getStringExtra("android.intent.extra.REFERRER_NAME");
            if(s != null) {
                return Uri.parse(s);
            }
        }
        catch(BadParcelableException unused_ex) {
            b.e.b("Failed to get Parcelable extra: name={android.intent.extra.REFERRER_NAME}", new Object[0]);
        }
        return null;
    }

    public static final boolean d(@NotNull Intent intent0) {
        try {
            return intent0.getBooleanExtra("airbridge_consumed", false);
        }
        catch(BadParcelableException unused_ex) {
            return false;
        }
    }

    public static final boolean e(@NotNull Intent intent0) {
        try {
            return intent0.getBooleanExtra("airbridge_disposed", false);
        }
        catch(BadParcelableException unused_ex) {
            return false;
        }
    }

    public static final boolean f(@NotNull Intent intent0) {
        return !l.d(intent0);
    }

    public static final boolean g(@NotNull Intent intent0) {
        return !l.e(intent0);
    }
}

