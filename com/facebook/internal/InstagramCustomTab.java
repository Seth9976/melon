package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/internal/InstagramCustomTab;", "Lcom/facebook/internal/CustomTab;", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InstagramCustomTab extends CustomTab {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/InstagramCustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(30)
        @NotNull
        public final Uri getURIForAction(@NotNull String s, @Nullable Bundle bundle0) {
            q.g(s, "action");
            return s.equals("oauth") ? Utility.buildUri("m.null", "oauth/authorize", bundle0) : Utility.buildUri("m.null", FacebookSdk.getGraphApiVersion() + "/dialog/" + s, bundle0);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        InstagramCustomTab.Companion = new Companion(null);
    }

    public InstagramCustomTab(@NotNull String s, @Nullable Bundle bundle0) {
        q.g(s, "action");
        super(s, bundle0);
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        this.setUri(InstagramCustomTab.Companion.getURIForAction(s, bundle0));
    }
}

