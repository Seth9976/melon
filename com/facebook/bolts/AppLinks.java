package com.facebook.bolts;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u0012\u0010\n\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/facebook/bolts/AppLinks;", "", "()V", "KEY_NAME_APPLINK_DATA", "", "KEY_NAME_EXTRAS", "getAppLinkData", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", "getAppLinkExtras", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppLinks {
    @NotNull
    public static final AppLinks INSTANCE = null;
    @NotNull
    public static final String KEY_NAME_APPLINK_DATA = "al_applink_data";
    @NotNull
    public static final String KEY_NAME_EXTRAS = "extras";

    static {
        AppLinks.INSTANCE = new AppLinks();
    }

    @Nullable
    public static final Bundle getAppLinkData(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        return intent0.getBundleExtra("al_applink_data");
    }

    @Nullable
    public static final Bundle getAppLinkExtras(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        Bundle bundle0 = AppLinks.getAppLinkData(intent0);
        return bundle0 == null ? null : bundle0.getBundle("extras");
    }
}

