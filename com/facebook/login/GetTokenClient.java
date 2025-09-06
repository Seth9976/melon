package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/facebook/login/GetTokenClient;", "Lcom/facebook/internal/PlatformServiceClient;", "Landroid/content/Context;", "context", "Lcom/facebook/login/LoginClient$Request;", "request", "<init>", "(Landroid/content/Context;Lcom/facebook/login/LoginClient$Request;)V", "Landroid/os/Bundle;", "data", "Lie/H;", "populateRequestBundle", "(Landroid/os/Bundle;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GetTokenClient extends PlatformServiceClient {
    public GetTokenClient(@NotNull Context context0, @NotNull Request loginClient$Request0) {
        q.g(context0, "context");
        q.g(loginClient$Request0, "request");
        super(context0, 0x10000, 0x10001, 0x133060D, loginClient$Request0.getApplicationId(), loginClient$Request0.getNonce());
    }

    @Override  // com.facebook.internal.PlatformServiceClient
    public void populateRequestBundle(@NotNull Bundle bundle0) {
        q.g(bundle0, "data");
    }
}

