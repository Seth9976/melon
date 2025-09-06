package com.facebook;

import W2.b;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000E\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0003R\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/CustomTabActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "Landroid/content/BroadcastReceiver;", "closeReceiver", "Landroid/content/BroadcastReceiver;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomTabActivity extends Activity {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/CustomTabActivity$Companion;", "", "()V", "CUSTOM_TAB_REDIRECT_ACTION", "", "CUSTOM_TAB_REDIRECT_REQUEST_CODE", "", "DESTROY_ACTION", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final String CUSTOM_TAB_REDIRECT_ACTION = null;
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final String DESTROY_ACTION;
    @Nullable
    private BroadcastReceiver closeReceiver;

    static {
        CustomTabActivity.Companion = new Companion(null);
        CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION = "CustomTabActivity.action_customTabRedirect";
        CustomTabActivity.DESTROY_ACTION = "CustomTabActivity.action_destroy";
    }

    @Override  // android.app.Activity
    public void onActivityResult(int v, int v1, @Nullable Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        if(v1 == 0) {
            Intent intent1 = new Intent("CustomTabActivity.action_customTabRedirect");
            intent1.putExtra("CustomTabMainActivity.extra_url", this.getIntent().getDataString());
            b.a(this).c(intent1);
            com.facebook.CustomTabActivity.onActivityResult.closeReceiver.1 customTabActivity$onActivityResult$closeReceiver$10 = new BroadcastReceiver() {
                @Override  // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
                    q.g(context0, "context");
                    q.g(intent0, "intent");
                    CustomTabActivity.this.finish();
                }
            };
            b.a(this).b(customTabActivity$onActivityResult$closeReceiver$10, new IntentFilter("CustomTabActivity.action_destroy"));
            this.closeReceiver = customTabActivity$onActivityResult$closeReceiver$10;
        }
    }

    @Override  // android.app.Activity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Intent intent0 = new Intent(this, CustomTabMainActivity.class);
        intent0.setAction("CustomTabActivity.action_customTabRedirect");
        intent0.putExtra("CustomTabMainActivity.extra_url", this.getIntent().getDataString());
        intent0.addFlags(0x24000000);
        this.startActivityForResult(intent0, 2);
    }

    @Override  // android.app.Activity
    public void onDestroy() {
        BroadcastReceiver broadcastReceiver0 = this.closeReceiver;
        if(broadcastReceiver0 != null) {
            b.a(this).d(broadcastReceiver0);
        }
        super.onDestroy();
    }
}

