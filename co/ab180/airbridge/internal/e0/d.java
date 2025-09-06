package co.ab180.airbridge.internal.e0;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import co.ab180.airbridge.AirbridgeOption;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\tR\u0016\u0010\u000B\u001A\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\u000E"}, d2 = {"Lco/ab180/airbridge/internal/e0/d;", "", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "option", "", "a", "(Landroid/content/Context;Lco/ab180/airbridge/AirbridgeOption;)Ljava/lang/String;", "(Landroid/content/Context;)Ljava/lang/String;", "Ljava/lang/String;", "META_DATA_APP_MARKET_IDENTIFIER", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d {
    private static final String a = "co.ab180.airbridge.app_market_identifier";
    @NotNull
    public static final d b;

    static {
        d.b = new d();
    }

    @Nullable
    public final String a(@NotNull Context context0) {
        try {
            return Build.VERSION.SDK_INT < 30 ? context0.getPackageManager().getInstallerPackageName("com.iloen.melon") : context0.getPackageManager().getInstallSourceInfo("com.iloen.melon").getInstallingPackageName();
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    @Nullable
    public final String a(@NotNull Context context0, @NotNull AirbridgeOption airbridgeOption0) {
        String s = airbridgeOption0.getAppMarketIdentifier();
        if(s.length() == 0) {
            try {
                s = null;
                Bundle bundle0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData;
                return bundle0.containsKey("co.ab180.airbridge.app_market_identifier") ? bundle0.getString("co.ab180.airbridge.app_market_identifier") : null;
            }
            catch(Exception unused_ex) {
            }
        }
        return s;
    }
}

