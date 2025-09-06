package com.facebook;

import W2.b;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/facebook/CustomTabMainActivity;", "Landroid/app/Activity;", "<init>", "()V", "", "resultCode", "Landroid/content/Intent;", "resultIntent", "Lie/H;", "sendResult", "(ILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "", "shouldCloseCustomTab", "Z", "Landroid/content/BroadcastReceiver;", "redirectReceiver", "Landroid/content/BroadcastReceiver;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomTabMainActivity extends Activity {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0004H\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/CustomTabMainActivity$Companion;", "", "()V", "EXTRA_ACTION", "", "EXTRA_CHROME_PACKAGE", "EXTRA_PARAMS", "EXTRA_TARGET_APP", "EXTRA_URL", "NO_ACTIVITY_EXCEPTION", "REFRESH_ACTION", "parseResponseUri", "Landroid/os/Bundle;", "urlString", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Bundle access$parseResponseUri(Companion customTabMainActivity$Companion0, String s) {
            return customTabMainActivity$Companion0.parseResponseUri(s);
        }

        private final Bundle parseResponseUri(String s) {
            Uri uri0 = Uri.parse(s);
            Bundle bundle0 = Utility.parseUrlQueryString(uri0.getQuery());
            bundle0.putAll(Utility.parseUrlQueryString(uri0.getFragment()));
            return bundle0;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[LoginTargetApp.values().length];
            try {
                arr_v[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final String EXTRA_ACTION;
    @NotNull
    public static final String EXTRA_CHROME_PACKAGE;
    @NotNull
    public static final String EXTRA_PARAMS;
    @NotNull
    public static final String EXTRA_TARGET_APP;
    @NotNull
    public static final String EXTRA_URL;
    @NotNull
    public static final String NO_ACTIVITY_EXCEPTION;
    @NotNull
    public static final String REFRESH_ACTION;
    @Nullable
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab;

    static {
        CustomTabMainActivity.Companion = new Companion(null);
        CustomTabMainActivity.EXTRA_ACTION = "CustomTabMainActivity.extra_action";
        CustomTabMainActivity.EXTRA_PARAMS = "CustomTabMainActivity.extra_params";
        CustomTabMainActivity.EXTRA_CHROME_PACKAGE = "CustomTabMainActivity.extra_chromePackage";
        CustomTabMainActivity.EXTRA_URL = "CustomTabMainActivity.extra_url";
        CustomTabMainActivity.EXTRA_TARGET_APP = "CustomTabMainActivity.extra_targetApp";
        CustomTabMainActivity.REFRESH_ACTION = "CustomTabMainActivity.action_refresh";
        CustomTabMainActivity.NO_ACTIVITY_EXCEPTION = "CustomTabMainActivity.no_activity_exception";
    }

    public CustomTabMainActivity() {
        this.shouldCloseCustomTab = true;
    }

    @Override  // android.app.Activity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(q.b("CustomTabActivity.action_customTabRedirect", this.getIntent().getAction())) {
            this.setResult(0);
            this.finish();
            return;
        }
        if(bundle0 == null) {
            String s = this.getIntent().getStringExtra("CustomTabMainActivity.extra_action");
            if(s == null) {
                return;
            }
            Bundle bundle1 = this.getIntent().getBundleExtra("CustomTabMainActivity.extra_params");
            String s1 = this.getIntent().getStringExtra("CustomTabMainActivity.extra_chromePackage");
            String s2 = this.getIntent().getStringExtra("CustomTabMainActivity.extra_targetApp");
            CustomTab customTab0 = WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(s2).ordinal()] == 1 ? new InstagramCustomTab(s, bundle1) : new CustomTab(s, bundle1);
            boolean z = customTab0.openCustomTab(this, s1);
            this.shouldCloseCustomTab = false;
            if(!z) {
                this.setResult(0, this.getIntent().putExtra("CustomTabMainActivity.no_activity_exception", true));
                this.finish();
                return;
            }
            com.facebook.CustomTabMainActivity.onCreate.redirectReceiver.1 customTabMainActivity$onCreate$redirectReceiver$10 = new BroadcastReceiver() {
                @Override  // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
                    q.g(context0, "context");
                    q.g(intent0, "intent");
                    Intent intent1 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent1.setAction("CustomTabMainActivity.action_refresh");
                    intent1.putExtra("CustomTabMainActivity.extra_url", intent0.getStringExtra("CustomTabMainActivity.extra_url"));
                    intent1.addFlags(0x24000000);
                    CustomTabMainActivity.this.startActivity(intent1);
                }
            };
            this.redirectReceiver = customTabMainActivity$onCreate$redirectReceiver$10;
            b.a(this).b(customTabMainActivity$onCreate$redirectReceiver$10, new IntentFilter("CustomTabActivity.action_customTabRedirect"));
        }
    }

    @Override  // android.app.Activity
    public void onNewIntent(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        super.onNewIntent(intent0);
        if(q.b("CustomTabMainActivity.action_refresh", intent0.getAction())) {
            Intent intent1 = new Intent("CustomTabActivity.action_destroy");
            b.a(this).c(intent1);
            this.sendResult(-1, intent0);
            return;
        }
        if(q.b("CustomTabActivity.action_customTabRedirect", intent0.getAction())) {
            this.sendResult(-1, intent0);
        }
    }

    @Override  // android.app.Activity
    public void onResume() {
        super.onResume();
        if(this.shouldCloseCustomTab) {
            this.sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private final void sendResult(int v, Intent intent0) {
        BroadcastReceiver broadcastReceiver0 = this.redirectReceiver;
        if(broadcastReceiver0 != null) {
            b.a(this).d(broadcastReceiver0);
        }
        if(intent0 == null) {
            Intent intent3 = this.getIntent();
            q.f(intent3, "intent");
            this.setResult(v, NativeProtocol.createProtocolResultIntent(intent3, null, null));
        }
        else {
            String s = intent0.getStringExtra("CustomTabMainActivity.extra_url");
            Bundle bundle0 = s == null ? new Bundle() : Companion.access$parseResponseUri(CustomTabMainActivity.Companion, s);
            Intent intent1 = this.getIntent();
            q.f(intent1, "intent");
            Intent intent2 = NativeProtocol.createProtocolResultIntent(intent1, bundle0, null);
            if(intent2 != null) {
                intent0 = intent2;
            }
            this.setResult(v, intent0);
        }
        this.finish();
    }
}

