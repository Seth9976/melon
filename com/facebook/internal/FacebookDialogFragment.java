package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.w;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000B\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000E\u001A\u00020\b2\b\u0010\r\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\fJ\u000F\u0010\u0010\u001A\u00020\bH\u0001¢\u0006\u0004\b\u000F\u0010\u0003J\u0019\u0010\u0012\u001A\u00020\u00112\b\u0010\r\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0003R$\u0010\u001A\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2 = {"Lcom/facebook/internal/FacebookDialogFragment;", "Landroidx/fragment/app/w;", "<init>", "()V", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lie/H;", "onCompleteWebDialog", "(Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "onCompleteWebFallbackDialog", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "initDialog$facebook_common_release", "initDialog", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroyView", "innerDialog", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "setInnerDialog", "(Landroid/app/Dialog;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookDialogFragment extends w {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/FacebookDialogFragment$Companion;", "", "()V", "TAG", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "FacebookDialogFragment";
    @Nullable
    private Dialog innerDialog;

    static {
        FacebookDialogFragment.Companion = new Companion(null);
    }

    @Nullable
    public final Dialog getInnerDialog() {
        return this.innerDialog;
    }

    public final void initDialog$facebook_common_release() {
        WebDialog webDialog0;
        if(this.innerDialog == null) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                Intent intent0 = fragmentActivity0.getIntent();
                q.f(intent0, "intent");
                Bundle bundle0 = NativeProtocol.getMethodArgumentsFromIntent(intent0);
                String s = null;
                if((bundle0 == null ? false : bundle0.getBoolean("is_fallback", false))) {
                    if(bundle0 != null) {
                        s = bundle0.getString("url");
                    }
                    if(Utility.isNullOrEmpty(s)) {
                        Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing \'url\'");
                        fragmentActivity0.finish();
                        return;
                    }
                    String s2 = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                    q.e(s, "null cannot be cast to non-null type kotlin.String");
                    webDialog0 = FacebookWebFallbackDialog.Companion.newInstance(fragmentActivity0, s, s2);
                    webDialog0.setOnCompleteListener(new a(this, 1));
                }
                else {
                    String s1 = bundle0 == null ? null : bundle0.getString("action");
                    if(bundle0 != null) {
                        s = bundle0.getBundle("params");
                    }
                    if(Utility.isNullOrEmpty(s1)) {
                        Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing \'actionName\'");
                        fragmentActivity0.finish();
                        return;
                    }
                    q.e(s1, "null cannot be cast to non-null type kotlin.String");
                    webDialog0 = new Builder(fragmentActivity0, s1, ((Bundle)s)).setOnCompleteListener(new a(this, 0)).build();
                }
                this.innerDialog = webDialog0;
            }
        }
    }

    private static final void initDialog$lambda$0(FacebookDialogFragment facebookDialogFragment0, Bundle bundle0, FacebookException facebookException0) {
        q.g(facebookDialogFragment0, "this$0");
        facebookDialogFragment0.onCompleteWebDialog(bundle0, facebookException0);
    }

    private static final void initDialog$lambda$1(FacebookDialogFragment facebookDialogFragment0, Bundle bundle0, FacebookException facebookException0) {
        q.g(facebookDialogFragment0, "this$0");
        facebookDialogFragment0.onCompleteWebFallbackDialog(bundle0);
    }

    private final void onCompleteWebDialog(Bundle bundle0, FacebookException facebookException0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            return;
        }
        Intent intent0 = fragmentActivity0.getIntent();
        q.f(intent0, "fragmentActivity.intent");
        fragmentActivity0.setResult((facebookException0 == null ? -1 : 0), NativeProtocol.createProtocolResultIntent(intent0, bundle0, facebookException0));
        fragmentActivity0.finish();
    }

    private final void onCompleteWebFallbackDialog(Bundle bundle0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            return;
        }
        Intent intent0 = new Intent();
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        intent0.putExtras(bundle0);
        fragmentActivity0.setResult(-1, intent0);
        fragmentActivity0.finish();
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(this.innerDialog instanceof WebDialog && this.isResumed()) {
            Dialog dialog0 = this.innerDialog;
            q.e(dialog0, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
            ((WebDialog)dialog0).resize();
        }
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.initDialog$facebook_common_release();
    }

    @Override  // androidx.fragment.app.w
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle0) {
        Dialog dialog0 = this.innerDialog;
        if(dialog0 == null) {
            this.onCompleteWebDialog(null, null);
            this.setShowsDialog(false);
            Dialog dialog1 = super.onCreateDialog(bundle0);
            q.f(dialog1, "super.onCreateDialog(savedInstanceState)");
            return dialog1;
        }
        q.e(dialog0, "null cannot be cast to non-null type android.app.Dialog");
        return dialog0;
    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null && this.getRetainInstance()) {
            dialog0.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        Dialog dialog0 = this.innerDialog;
        if(dialog0 instanceof WebDialog) {
            q.e(dialog0, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
            ((WebDialog)dialog0).resize();
        }
    }

    public final void setInnerDialog(@Nullable Dialog dialog0) {
        this.innerDialog = dialog0;
    }
}

