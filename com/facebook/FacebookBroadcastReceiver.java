package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0010\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0012\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/FacebookBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "appCallId", "action", "Landroid/os/Bundle;", "extras", "onSuccessfulAppCall", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "onFailedAppCall", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onFailedAppCall(@NotNull String s, @NotNull String s1, @NotNull Bundle bundle0) {
        q.g(s, "appCallId");
        q.g(s1, "action");
        q.g(bundle0, "extras");
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        String s = intent0.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String s1 = intent0.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        Bundle bundle0 = intent0.getExtras();
        if(s != null && s1 != null && bundle0 != null) {
            if(NativeProtocol.isErrorResult(intent0)) {
                this.onFailedAppCall(s, s1, bundle0);
                return;
            }
            this.onSuccessfulAppCall(s, s1, bundle0);
        }
    }

    public void onSuccessfulAppCall(@NotNull String s, @NotNull String s1, @NotNull Bundle bundle0) {
        q.g(s, "appCallId");
        q.g(s1, "action");
        q.g(bundle0, "extras");
    }
}

