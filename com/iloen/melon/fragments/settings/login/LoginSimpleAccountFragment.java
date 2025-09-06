package com.iloen.melon.fragments.settings.login;

import De.d;
import Gd.g;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.popup.b;
import e.k;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import we.n;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\nJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0019\u0010\nJ\u0019\u0010\u001B\u001A\u00020\u00042\b\u0010\u001A\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0015J\u000F\u0010\u001C\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u000F\u0010\u001D\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J-\u0010$\u001A\u0004\u0018\u00010#2\u0006\u0010 \u001A\u00020\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b$\u0010%J!\u0010\'\u001A\u00020\u00042\u0006\u0010&\u001A\u00020#2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010*\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001A\u00020,8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b-\u0010.\u001A\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00104\u001A\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001A\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initViews", "closePage", "executeReturnUriAndRemoveLoginFragment", "", "isBringToFrontFragment", "()Z", "", "getFragmentTag", "()Ljava/lang/String;", "onBackPressed", "", "getTitleResId", "()I", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "excludingTagArguments", "savedInstanceState", "onCreate", "onStart", "onResume", "onStop", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel;", "viewModel", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel;", "getViewModel", "()Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel;", "setViewModel", "(Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountViewModel;)V", "Landroid/widget/LinearLayout;", "mAccountLayout", "Landroid/widget/LinearLayout;", "otherLoginBtn", "Landroid/view/View;", "loginFragmentCount", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LoginSimpleAccountFragment extends Hilt_LoginSimpleAccountFragment {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0018\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountFragment$Companion;", "", "<init>", "()V", "TAG", "", "RETURN_URI", "LOGIN_FRAGMENT_COUNT", "newInstance", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountFragment;", "returnUri", "Landroid/net/Uri;", "loginFragmentCount", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LoginSimpleAccountFragment newInstance(@Nullable Uri uri0) {
            LoginSimpleAccountFragment loginSimpleAccountFragment0 = new LoginSimpleAccountFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("returnUri", uri0);
            loginSimpleAccountFragment0.setArguments(bundle0);
            LogU.Companion.d("LoginSimpleAccountFragment", "instantiate - returnUri: " + uri0);
            return loginSimpleAccountFragment0;
        }

        @NotNull
        public final LoginSimpleAccountFragment newInstance(@Nullable Uri uri0, int v) {
            LoginSimpleAccountFragment loginSimpleAccountFragment0 = new LoginSimpleAccountFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("returnUri", uri0);
            bundle0.putInt("loginFragmentCount", v);
            loginSimpleAccountFragment0.setArguments(bundle0);
            LogU.Companion.d("LoginSimpleAccountFragment", "instantiate - returnUri: " + uri0);
            return loginSimpleAccountFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String LOGIN_FRAGMENT_COUNT = "loginFragmentCount";
    @NotNull
    public static final String RETURN_URI = "returnUri";
    @NotNull
    private static final String TAG = "LoginSimpleAccountFragment";
    @NotNull
    private final LogU log;
    private int loginFragmentCount;
    @Nullable
    private LinearLayout mAccountLayout;
    @Nullable
    private View otherLoginBtn;
    public LoginSimpleAccountViewModel viewModel;

    static {
        LoginSimpleAccountFragment.Companion = new Companion(null);
        LoginSimpleAccountFragment.$stable = 8;
    }

    public LoginSimpleAccountFragment() {
        this.log = new LogU("LoginSimpleAccountFragment");
        this.loginFragmentCount = 1;
    }

    private final void closePage() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n(null) {
            int label;

            {
                LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.closePage.1(LoginSimpleAccountFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.closePage.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                boolean z = LoginSimpleAccountFragment.this.isFragmentValid();
                H h0 = H.a;
                if(!z) {
                    return h0;
                }
                if(LoginSimpleAccountFragment.this.loginFragmentCount > 1) {
                    LogU.debug$default(LoginSimpleAccountFragment.this.log, "closePage - navigateBack: " + LoginSimpleAccountFragment.this.loginFragmentCount, null, false, 6, null);
                    BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
                    if(baseActivity0 != null) {
                        baseActivity0.navigateBack(LoginSimpleAccountFragment.this.loginFragmentCount);
                        return h0;
                    }
                }
                else {
                    LogU.debug$default(LoginSimpleAccountFragment.this.log, "closePage - performBackPress", null, false, 6, null);
                    LoginSimpleAccountFragment.this.performBackPress();
                }
                return h0;
            }
        }, 2, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean excludingTagArguments() {
        return true;
    }

    private final void executeReturnUriAndRemoveLoginFragment() {
        Bundle bundle0 = this.getArguments();
        Parcelable parcelable0 = bundle0 == null ? null : bundle0.getParcelable("returnUri");
        if(((Uri)parcelable0) != null && 101 != f.c(((Uri)parcelable0))) {
            f.a(((Uri)parcelable0));
        }
        if(this.loginFragmentCount > 1) {
            BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
            if(baseActivity0 != null) {
                baseActivity0.navigateBack(this.loginFragmentCount);
            }
            return;
        }
        this.performBackPress();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public String getFragmentTag() {
        return "LoginSimpleAccountFragment";
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "simpleLogin");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13105A;  // string:title_setting_simple_login "멜론 간편로그인"
    }

    @NotNull
    public final LoginSimpleAccountViewModel getViewModel() {
        LoginSimpleAccountViewModel loginSimpleAccountViewModel0 = this.viewModel;
        if(loginSimpleAccountViewModel0 != null) {
            return loginSimpleAccountViewModel0;
        }
        q.m("viewModel");
        throw null;
    }

    private final void initViews() {
        View view0 = this.findViewById(0x7F0A0A8C);  // id:simple_login_list_view
        q.e(view0, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mAccountLayout = (LinearLayout)view0;
        View view1 = this.findViewById(0x7F0A08EB);  // id:other_id_login_btn
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        this.otherLoginBtn = (MelonTextView)view1;
        ViewUtils.setOnClickListener(((MelonTextView)view1), (View view0) -> {
            Bundle bundle0 = this.getArguments();
            Uri uri0 = (Uri)(bundle0 == null ? null : bundle0.getParcelable("returnUri"));
            Navigator navigator0 = Navigator.INSTANCE;
            if(uri0 == null) {
                uri0 = Uri.EMPTY;
            }
            int v = this.loginFragmentCount + 1;
            g g0 = new g();
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("returnUri", uri0);
            bundle1.putInt("argLoginFragmentCount", v);
            g0.setArguments(bundle1);
            navigator0.open(g0);
        });
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new n(null) {
            int label;

            {
                LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2(LoginSimpleAccountFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = LoginSimpleAccountFragment.this.getViewModel().getUiState();
                        com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1 loginSimpleAccountFragment$initViews$2$10 = new n(null) {
                            Object L$0;
                            int label;

                            {
                                LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1(LoginSimpleAccountFragment.this, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            public final Object invoke(K4 k40, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1)this.create(k40, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((K4)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                K4 k40 = (K4)this.L$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                if(k40 instanceof Screen) {
                                    LinearLayout linearLayout0 = LoginSimpleAccountFragment.this.mAccountLayout;
                                    if(linearLayout0 != null) {
                                        linearLayout0.removeAllViews();
                                    }
                                    int v = ((Screen)k40).getSimpleAccountUserIds().size();
                                    LoginSimpleAccountFragment loginSimpleAccountFragment0 = LoginSimpleAccountFragment.this;
                                    int v1 = 0;
                                    for(Object object1: ((Screen)k40).getSimpleAccountUserIds()) {
                                        if(v1 >= 0) {
                                            SettingItemView settingItemView0 = new SettingItemView(loginSimpleAccountFragment0.getContext());
                                            settingItemView0.setViewHeight(settingItemView0.getResources().getDimensionPixelSize(0x7F07042D));  // dimen:setting_login_cell_height
                                            ViewUtils.showWhen(settingItemView0.l, v > 1 && v1 < v - 1);
                                            settingItemView0.setBottomLineColor(0x7F06014E);  // color:gray125s
                                            settingItemView0.setTextColor(0x7F060169);  // color:gray850s
                                            settingItemView0.setTextSingleLine(false);
                                            settingItemView0.setText(((String)object1));
                                            View view0 = settingItemView0.findViewById(0x7F0A0AFC);  // id:sub_text_container_margin
                                            q.d(view0);
                                            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                                            if(viewGroup$LayoutParams0 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                                            }
                                            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).width = ScreenUtils.dipToPixel(settingItemView0.getContext(), 7.0f);
                                            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).height = 0;
                                            view0.setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
                                            settingItemView0.setOnClickListener(new c(loginSimpleAccountFragment0, ((String)object1), 0));
                                            View view1 = settingItemView0.findViewById(0x7F0A0548);  // id:icon_arrow
                                            q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
                                            ((ImageView)view1).setImageResource(0x7F080138);  // drawable:btn_common_edit_delete
                                            ((ImageView)view1).setContentDescription(loginSimpleAccountFragment0.getString(0x7F130B0E));  // string:talkback_del_simple_id "간편로그인 아이디 삭제"
                                            ((ImageView)view1).setOnClickListener(new c(loginSimpleAccountFragment0, ((String)object1), 1));
                                            LinearLayout linearLayout1 = loginSimpleAccountFragment0.mAccountLayout;
                                            if(linearLayout1 != null) {
                                                linearLayout1.addView(settingItemView0);
                                            }
                                            ++v1;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                    View view2 = LoginSimpleAccountFragment.this.otherLoginBtn;
                                    if(view2 != null) {
                                        view2.setVisibility(0);
                                    }
                                }
                                return H.a;

                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                                @e(c = "com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment$initViews$2$1$1$1$1", f = "LoginSimpleAccountFragment.kt", l = {0xC0}, m = "invokeSuspend")
                                final class com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.1.1 extends i implements n {
                                    final String $id;
                                    int label;

                                    public com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.1.1(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s, Continuation continuation0) {
                                        LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                                        this.$id = s;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.1.1(LoginSimpleAccountFragment.this, this.$id, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                LoginSimpleAccountViewModel loginSimpleAccountViewModel0 = LoginSimpleAccountFragment.this.getViewModel();
                                                this.label = 1;
                                                return loginSimpleAccountViewModel0.loginBySimpleAccount(this.$id, this) == a0 ? a0 : H.a;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                                return H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }


                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                                @e(c = "com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment$initViews$2$1$1$2$1$1", f = "LoginSimpleAccountFragment.kt", l = {206}, m = "invokeSuspend")
                                final class com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.2.1.1 extends i implements n {
                                    final String $id;
                                    int label;

                                    public com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.2.1.1(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s, Continuation continuation0) {
                                        LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                                        this.$id = s;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.2.1.1(LoginSimpleAccountFragment.this, this.$id, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                LoginSimpleAccountViewModel loginSimpleAccountViewModel0 = LoginSimpleAccountFragment.this.getViewModel();
                                                this.label = 1;
                                                return loginSimpleAccountViewModel0.removeSimpleAccount(this.$id, this) == a0 ? a0 : H.a;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                                return H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }

                            private static final void invokeSuspend$lambda$5$lambda$2(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s, View view0) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.1.1(loginSimpleAccountFragment0, s, null), 3, null);
                            }

                            private static final void invokeSuspend$lambda$5$lambda$4(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s, View view0) {
                                b.x(loginSimpleAccountFragment0.getChildFragmentManager(), loginSimpleAccountFragment0.getString(0x7F1300D0), loginSimpleAccountFragment0.getString(0x7F1309C1), false, false, null, null, () -> {
                                    D d0 = loginSimpleAccountFragment0.getViewLifecycleOwner();
                                    q.f(d0, "getViewLifecycleOwner(...)");
                                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.1.2.1.1(loginSimpleAccountFragment0, s, null), 3, null);
                                    return H.a;
                                }, null, null, null, 0xEF8);
                            }

                            // 检测为 Lambda 实现
                            private static final H invokeSuspend$lambda$5$lambda$4$lambda$3(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s) [...]
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(stateFlow0, loginSimpleAccountFragment$initViews$2$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), Dispatchers.getMain(), null, new n(null) {
            int label;

            {
                LoginSimpleAccountFragment.this = loginSimpleAccountFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.3(LoginSimpleAccountFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = LoginSimpleAccountFragment.this.getViewModel().getUiEvent();
                        com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.3.1 loginSimpleAccountFragment$initViews$3$10 = new FlowCollector() {
                            public final Object emit(I4 i40, Continuation continuation0) {
                                LogU.debug$default(LoginSimpleAccountFragment.this.log, "uiEvent.collect: " + i40, null, false, 6, null);
                                if(i40 instanceof ClosePage) {
                                    LoginSimpleAccountFragment.this.closePage();
                                    return H.a;
                                }
                                if(i40 instanceof ExecuteReturnUri) {
                                    LoginSimpleAccountFragment.this.executeReturnUriAndRemoveLoginFragment();
                                }
                                return H.a;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((I4)object0), continuation0);
                            }
                        };
                        this.label = 1;
                        return flow0.collect(loginSimpleAccountFragment$initViews$3$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
    }

    // 检测为 Lambda 实现
    private static final void initViews$lambda$1(LoginSimpleAccountFragment loginSimpleAccountFragment0, View view0) [...]

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isBringToFrontFragment() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        q0 q00 = this.getViewModelStore();
        o0 o00 = this.getDefaultViewModelProviderFactory();
        S2.c c0 = this.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(LoginSimpleAccountViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.setViewModel(((LoginSimpleAccountViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s)));
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D083C, viewGroup0, false);  // layout:setting_simple_or_other_login_layout
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.loginFragmentCount = bundle0.getInt("loginFragmentCount", 1);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        if(this.isLoginUser()) {
            new Handler(Looper.getMainLooper()).post(() -> {
                if(!this.isFragmentVisible) {
                    return;
                }
                this.executeReturnUriAndRemoveLoginFragment();
            });
        }
    }

    // 检测为 Lambda 实现
    private static final void onResume$lambda$0(LoginSimpleAccountFragment loginSimpleAccountFragment0) [...]

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        EventBusHelper.register(this);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        EventBusHelper.unregister(this);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    public final void setViewModel(@NotNull LoginSimpleAccountViewModel loginSimpleAccountViewModel0) {
        q.g(loginSimpleAccountViewModel0, "<set-?>");
        this.viewModel = loginSimpleAccountViewModel0;
    }
}

