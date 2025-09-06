package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.f0;
import androidx.media3.session.a0;
import com.facebook.common.R.id;
import e.b;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0016\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0003J\u000F\u0010\u0010\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001A\u00020\b2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0003J-\u0010!\u001A\u0004\u0018\u00010 2\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b#\u0010\u0003J\u000F\u0010$\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b$\u0010\u0003J)\u0010*\u001A\u00020\b2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001A\u00020\b2\u0006\u0010,\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b-\u0010\u0017J\u000F\u0010.\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b.\u0010\u0003J\u000F\u0010/\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b/\u0010\u0003R\u0018\u00101\u001A\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001A\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001A\u00020\u00182\u0006\u00106\u001A\u00020\u00188\u0006@BX\u0086.\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b9\u0010\u001AR0\u0010;\u001A\b\u0012\u0004\u0012\u00020(0:2\f\u00106\u001A\b\u0012\u0004\u0012\u00020(0:8\u0006@BX\u0086.\u00A2\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020 8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001A\u00020%8UX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\bA\u0010B\u00A8\u0006E"}, d2 = {"Lcom/facebook/login/LoginFragment;", "Landroidx/fragment/app/I;", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "Lie/H;", "getLoginMethodHandlerCallback", "(Landroidx/fragment/app/FragmentActivity;)Lwe/k;", "Lcom/facebook/login/LoginClient$Result;", "outcome", "onLoginClientCompleted", "(Lcom/facebook/login/LoginClient$Result;)V", "showSpinner", "hideSpinner", "Landroid/app/Activity;", "initializeCallingPackage", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/facebook/login/LoginClient;", "createLoginClient", "()Lcom/facebook/login/LoginClient;", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onPause", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "onSpinnerShown", "onSpinnerHidden", "", "callingPackage", "Ljava/lang/String;", "Lcom/facebook/login/LoginClient$Request;", "request", "Lcom/facebook/login/LoginClient$Request;", "<set-?>", "loginClient", "Lcom/facebook/login/LoginClient;", "getLoginClient", "Le/b;", "launcher", "Le/b;", "getLauncher", "()Le/b;", "progressBar", "Landroid/view/View;", "getLayoutResId", "()I", "layoutResId", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class LoginFragment extends I {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginFragment$Companion;", "", "()V", "EXTRA_REQUEST", "", "NULL_CALLING_PKG_ERROR_MSG", "REQUEST_KEY", "RESULT_KEY", "SAVED_LOGIN_CLIENT", "TAG", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String EXTRA_REQUEST = "request";
    @NotNull
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    @NotNull
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    @NotNull
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    @NotNull
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    @NotNull
    private static final String TAG = "LoginFragment";
    @Nullable
    private String callingPackage;
    private b launcher;
    private LoginClient loginClient;
    private View progressBar;
    @Nullable
    private Request request;

    static {
        LoginFragment.Companion = new Companion(null);
    }

    @NotNull
    public LoginClient createLoginClient() {
        return new LoginClient(this);
    }

    @NotNull
    public final b getLauncher() {
        b b0 = this.launcher;
        if(b0 != null) {
            return b0;
        }
        q.m("launcher");
        throw null;
    }

    public int getLayoutResId() [...] // 潜在的解密器

    @NotNull
    public final LoginClient getLoginClient() {
        LoginClient loginClient0 = this.loginClient;
        if(loginClient0 != null) {
            return loginClient0;
        }
        q.m("loginClient");
        throw null;
    }

    private final k getLoginMethodHandlerCallback(FragmentActivity fragmentActivity0) {
        return new k(fragmentActivity0) {
            final FragmentActivity $activity;

            {
                LoginFragment.this = loginFragment0;
                this.$activity = fragmentActivity0;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((ActivityResult)object0));
                return H.a;
            }

            public final void invoke(@NotNull ActivityResult activityResult0) {
                q.g(activityResult0, "result");
                if(activityResult0.a == -1) {
                    LoginFragment.this.getLoginClient().onActivityResult(LoginClient.Companion.getLoginRequestCode(), -1, activityResult0.b);
                    return;
                }
                this.$activity.finish();
            }
        };
    }

    private final void hideSpinner() {
        View view0 = this.progressBar;
        if(view0 != null) {
            view0.setVisibility(8);
            return;
        }
        q.m("progressBar");
        throw null;
    }

    private final void initializeCallingPackage(Activity activity0) {
        ComponentName componentName0 = activity0.getCallingActivity();
        if(componentName0 == null) {
            return;
        }
        this.callingPackage = componentName0.getPackageName();
    }

    public static void l(k k0, ActivityResult activityResult0) {
        LoginFragment.onCreate$lambda$1(k0, activityResult0);
    }

    public static void m(LoginFragment loginFragment0, Result loginClient$Result0) {
        LoginFragment.onCreate$lambda$0(loginFragment0, loginClient$Result0);
    }

    @Override  // androidx.fragment.app.I
    public void onActivityResult(int v, int v1, @Nullable Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        this.getLoginClient().onActivityResult(v, v1, intent0);
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        LoginClient loginClient0 = bundle0 == null ? null : ((LoginClient)bundle0.getParcelable("loginClient"));
        if(loginClient0 == null) {
            loginClient0 = this.createLoginClient();
        }
        else {
            loginClient0.setFragment(this);
        }
        this.loginClient = loginClient0;
        this.getLoginClient().setOnCompletedListener(new a0(this, 16));
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            return;
        }
        this.initializeCallingPackage(fragmentActivity0);
        Intent intent0 = fragmentActivity0.getIntent();
        if(intent0 != null) {
            Bundle bundle1 = intent0.getBundleExtra("com.facebook.LoginFragment:Request");
            if(bundle1 != null) {
                this.request = (Request)bundle1.getParcelable("request");
            }
        }
        b b0 = this.registerForActivityResult(new f0(2), new a0(this.getLoginMethodHandlerCallback(fragmentActivity0), 17));
        q.f(b0, "registerForActivityResul…andlerCallback(activity))");
        this.launcher = b0;
    }

    private static final void onCreate$lambda$0(LoginFragment loginFragment0, Result loginClient$Result0) {
        q.g(loginFragment0, "this$0");
        q.g(loginClient$Result0, "outcome");
        loginFragment0.onLoginClientCompleted(loginClient$Result0);
    }

    private static final void onCreate$lambda$1(k k0, ActivityResult activityResult0) {
        q.g(k0, "$tmp0");
        k0.invoke(activityResult0);
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0189, viewGroup0, false);  // layout:com_facebook_login_fragment
        View view1 = view0.findViewById(id.com_facebook_login_fragment_progress_bar);
        q.f(view1, "view.findViewById<View>(…in_fragment_progress_bar)");
        this.progressBar = view1;
        this.getLoginClient().setBackgroundProcessingListener(new BackgroundProcessingListener() {
            @Override  // com.facebook.login.LoginClient$BackgroundProcessingListener
            public void onBackgroundProcessingStarted() {
                LoginFragment.this.showSpinner();
            }

            @Override  // com.facebook.login.LoginClient$BackgroundProcessingListener
            public void onBackgroundProcessingStopped() {
                LoginFragment.this.hideSpinner();
            }
        });
        return view0;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        this.getLoginClient().cancelCurrentHandler();
        super.onDestroy();
    }

    private final void onLoginClientCompleted(Result loginClient$Result0) {
        this.request = null;
        int v = loginClient$Result0.code == Code.CANCEL ? 0 : -1;
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("com.facebook.LoginFragment:Result", loginClient$Result0);
        Intent intent0 = new Intent();
        intent0.putExtras(bundle0);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(this.isAdded() && fragmentActivity0 != null) {
            fragmentActivity0.setResult(v, intent0);
            fragmentActivity0.finish();
        }
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        super.onPause();
        View view0 = this.getView();
        View view1 = view0 == null ? null : view0.findViewById(id.com_facebook_login_fragment_progress_bar);
        if(view1 != null) {
            view1.setVisibility(8);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        if(this.callingPackage == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                fragmentActivity0.finish();
            }
            return;
        }
        this.getLoginClient().startOrContinueAuth(this.request);
    }

    @Override  // androidx.fragment.app.I
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putParcelable("loginClient", this.getLoginClient());
    }

    public void onSpinnerHidden() {
    }

    public void onSpinnerShown() {
    }

    private final void showSpinner() {
        View view0 = this.progressBar;
        if(view0 != null) {
            view0.setVisibility(0);
            return;
        }
        q.m("progressBar");
        throw null;
    }
}

