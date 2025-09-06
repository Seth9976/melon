package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.facebook.common.R.id;
import com.facebook.common.R.layout;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumper;
import com.facebook.login.LoginFragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\b\u0016\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J9\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001A\u00020\u00152\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017H\u0017¢\u0006\u0004\b\u0019\u0010\u001AR(\u0010\u001C\u001A\u0004\u0018\u00010\n2\b\u0010\u001B\u001A\u0004\u0018\u00010\n8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\f¨\u0006 "}, d2 = {"Lcom/facebook/FacebookActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "Lie/H;", "handlePassThroughError", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/fragment/app/I;", "getFragment", "()Landroidx/fragment/app/I;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "prefix", "Ljava/io/FileDescriptor;", "fd", "Ljava/io/PrintWriter;", "writer", "", "args", "dump", "(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "<set-?>", "currentFragment", "Landroidx/fragment/app/I;", "getCurrentFragment", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class FacebookActivity extends FragmentActivity {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/FacebookActivity$Companion;", "", "()V", "FRAGMENT_TAG", "", "PASS_THROUGH_CANCEL_ACTION", "TAG", "kotlin.jvm.PlatformType", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String FRAGMENT_TAG = "SingleFragment";
    @NotNull
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG;
    @Nullable
    private I currentFragment;

    static {
        FacebookActivity.Companion = new Companion(null);
        FacebookActivity.TAG = "com.facebook.FacebookActivity";
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void dump(@NotNull String s, @Nullable FileDescriptor fileDescriptor0, @NotNull PrintWriter printWriter0, @Nullable String[] arr_s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(s, "prefix");
            q.g(printWriter0, "writer");
            EndToEndDumper endToEndDumper0 = EndToEndDumper.Companion.getInstance();
            if(endToEndDumper0 != null && endToEndDumper0.maybeDump(s, printWriter0, arr_s)) {
                return;
            }
            super.dump(s, fileDescriptor0, printWriter0, arr_s);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Nullable
    public final I getCurrentFragment() {
        return this.currentFragment;
    }

    @NotNull
    public I getFragment() {
        Intent intent0 = this.getIntent();
        l0 l00 = this.getSupportFragmentManager();
        q.f(l00, "supportFragmentManager");
        I i0 = l00.E("SingleFragment");
        if(i0 == null) {
            if("FacebookDialogFragment".equals(intent0.getAction())) {
                I i1 = new FacebookDialogFragment();
                i1.setRetainInstance(true);
                ((w)i1).show(l00, "SingleFragment");
                return i1;
            }
            I i2 = new LoginFragment();
            i2.setRetainInstance(true);
            a a0 = new a(l00);
            a0.e(id.com_facebook_fragment_container, i2, "SingleFragment", 1);
            a0.k();
            return i2;
        }
        return i0;
    }

    private final void handlePassThroughError() {
        Intent intent0 = this.getIntent();
        q.f(intent0, "requestIntent");
        FacebookException facebookException0 = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(intent0));
        Intent intent1 = this.getIntent();
        q.f(intent1, "intent");
        this.setResult(0, NativeProtocol.createProtocolResultIntent(intent1, null, facebookException0));
        this.finish();
    }

    @Override  // androidx.activity.ComponentActivity
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        I i0 = this.currentFragment;
        if(i0 != null) {
            i0.onConfigurationChanged(configuration0);
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Intent intent0 = this.getIntent();
        if(!FacebookSdk.isInitialized()) {
            Utility.logd("com.facebook.FacebookActivity", "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application\'s onCreate method.");
            Context context0 = this.getApplicationContext();
            q.f(context0, "applicationContext");
            FacebookSdk.sdkInitialize(context0);
        }
        this.setContentView(layout.com_facebook_activity_layout);
        if("PassThrough".equals(intent0.getAction())) {
            this.handlePassThroughError();
            return;
        }
        this.currentFragment = this.getFragment();
    }
}

