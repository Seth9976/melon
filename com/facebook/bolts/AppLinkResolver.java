package com.facebook.bolts;

import android.net.Uri;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/bolts/AppLinkResolver;", "", "getAppLinkFromUrlInBackground", "Lcom/facebook/bolts/Task;", "Lcom/facebook/bolts/AppLink;", "url", "Landroid/net/Uri;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface AppLinkResolver {
    @NotNull
    Task getAppLinkFromUrlInBackground(@NotNull Uri arg1);
}

