package com.iloen.melon.fragments.settings;

import A8.j;
import A8.l;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.UrlUtil;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import ie.p;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.f;
import mb.k;
import mb.o;
import ob.z;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.h0;
import va.i0;
import we.n;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\tJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J\u000F\u0010\u001F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003R\u0018\u0010!\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u000E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001A\u00020%8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001A\u00020,8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b-\u0010.\u001A\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001A\u0002038\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b4\u00105\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001A\u00020:8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010B\u001A\u00020A8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010C\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/settings/KakaoMelonLoginFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initViews", "executeLoginReturnUriAndRemoveLoginFragment", "", "isBringToFrontFragment", "()Z", "", "getFragmentTag", "()Ljava/lang/String;", "onBackPressed", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "onResume", "Landroid/widget/TextView;", "btnSignIn", "Landroid/widget/TextView;", "loginFragmentCount", "I", "Lmb/k;", "melonLoginUseCase", "Lmb/k;", "getMelonLoginUseCase", "()Lmb/k;", "setMelonLoginUseCase", "(Lmb/k;)V", "Lmb/f;", "kakaoLoginUseCase", "Lmb/f;", "getKakaoLoginUseCase", "()Lmb/f;", "setKakaoLoginUseCase", "(Lmb/f;)V", "Lmb/o;", "simpleAccountUseCase", "Lmb/o;", "getSimpleAccountUseCase", "()Lmb/o;", "setSimpleAccountUseCase", "(Lmb/o;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class KakaoMelonLoginFragment extends Hilt_KakaoMelonLoginFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/settings/KakaoMelonLoginFragment$Companion;", "", "<init>", "()V", "TAG", "", "RETURN_URI", "newInstance", "Lcom/iloen/melon/fragments/settings/KakaoMelonLoginFragment;", "returnUri", "Landroid/net/Uri;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KakaoMelonLoginFragment newInstance(@NotNull Uri uri0) {
            q.g(uri0, "returnUri");
            KakaoMelonLoginFragment kakaoMelonLoginFragment0 = new KakaoMelonLoginFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("returnUri", uri0);
            kakaoMelonLoginFragment0.setArguments(bundle0);
            LogU.Companion.d("KakaoMelonLoginFragment", "instantiate - returnUri: " + uri0);
            return kakaoMelonLoginFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String RETURN_URI = "returnUri";
    @NotNull
    private static final String TAG = "KakaoMelonLoginFragment";
    @Nullable
    private TextView btnSignIn;
    @Inject
    public f kakaoLoginUseCase;
    @NotNull
    private final LogU log;
    private final int loginFragmentCount;
    @Inject
    public k melonLoginUseCase;
    @Inject
    public z playerUseCase;
    @Inject
    public o simpleAccountUseCase;

    static {
        KakaoMelonLoginFragment.Companion = new Companion(null);
        KakaoMelonLoginFragment.$stable = 8;
    }

    public KakaoMelonLoginFragment() {
        this.loginFragmentCount = 1;
        this.log = new LogU("KakaoMelonLoginFragment");
    }

    private final void executeLoginReturnUriAndRemoveLoginFragment() {
        Bundle bundle0 = this.getArguments();
        Uri uri0 = bundle0 == null ? null : ((Uri)bundle0.getParcelable("returnUri"));
        if(uri0 != null && 101 != r8.f.c(uri0)) {
            LogU.debug$default(this.log, "loginSuccess returnUri: " + uri0, null, false, 6, null);
            r8.f.a(uri0);
        }
        this.performBackPress();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public String getFragmentTag() {
        return "KakaoMelonLoginFragment";
    }

    @NotNull
    public final f getKakaoLoginUseCase() {
        f f0 = this.kakaoLoginUseCase;
        if(f0 != null) {
            return f0;
        }
        q.m("kakaoLoginUseCase");
        throw null;
    }

    @NotNull
    public final k getMelonLoginUseCase() {
        k k0 = this.melonLoginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("melonLoginUseCase");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final o getSimpleAccountUseCase() {
        o o0 = this.simpleAccountUseCase;
        if(o0 != null) {
            return o0;
        }
        q.m("simpleAccountUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F131054;  // string:title_setting_login "로그인"
    }

    private final void initViews() {
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0174), new a(this, 0));  // id:btn_melon_login
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A016B), new a(this, 1));  // id:btn_kakao_login
        View view0 = this.findViewById(0x7F0A01BD);  // id:btn_sign_in
        q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
        this.btnSignIn = (TextView)view0;
        ((TextView)view0).setText(Html.fromHtml(this.getString(0x7F13060B), 0));  // string:melon_login_join_text "<u>회원가입</u>"
        ViewUtils.setOnClickListener(this.btnSignIn, new Gd.f(11));

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.settings.KakaoMelonLoginFragment$initViews$2$1", f = "KakaoMelonLoginFragment.kt", l = {0x89}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1 extends i implements n {
            int label;

            public com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1(KakaoMelonLoginFragment kakaoMelonLoginFragment0, Continuation continuation0) {
                KakaoMelonLoginFragment.this = kakaoMelonLoginFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1(KakaoMelonLoginFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        f f0 = KakaoMelonLoginFragment.this.getKakaoLoginUseCase();
                        this.label = 1;
                        if(f0.d(this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                new Qd.e(KakaoMelonLoginFragment.this.getContext(), KakaoMelonLoginFragment.this.getKakaoLoginUseCase(), KakaoMelonLoginFragment.this.getPlayerUseCase()).a(new b(KakaoMelonLoginFragment.this));
                return H.a;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @e(c = "com.iloen.melon.fragments.settings.KakaoMelonLoginFragment$initViews$2$1$1$1", f = "KakaoMelonLoginFragment.kt", l = {0x90, 0x94}, m = "invokeSuspend")
                final class com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1.1.1 extends i implements n {
                    final j $kakaoAuthType;
                    Object L$0;
                    Object L$1;
                    int label;

                    public com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1.1.1(KakaoMelonLoginFragment kakaoMelonLoginFragment0, j j0, Continuation continuation0) {
                        KakaoMelonLoginFragment.this = kakaoMelonLoginFragment0;
                        this.$kakaoAuthType = j0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1.1.1(KakaoMelonLoginFragment.this, this.$kakaoAuthType, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        H h0 = H.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                Context context0 = KakaoMelonLoginFragment.this.getContext();
                                if(context0 != null) {
                                    f f0 = KakaoMelonLoginFragment.this.getKakaoLoginUseCase();
                                    this.L$0 = null;
                                    this.label = 1;
                                    if(f0.b(context0, this.$kakaoAuthType, this) == a0) {
                                        return a0;
                                    }
                                    goto label_15;
                                }
                                break;
                            }
                            case 1: {
                                Context context1 = (Context)this.L$0;
                                d5.n.D(object0);
                                ((p)object0).getClass();
                            label_15:
                                l l0 = KakaoMelonLoginFragment.this.getKakaoLoginUseCase().a.c();
                                if(l0 != null) {
                                    k k0 = KakaoMelonLoginFragment.this.getMelonLoginUseCase();
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.label = 2;
                                    object0 = k.b(k0, l0, this);
                                    if(object0 == a0) {
                                        return a0;
                                    }
                                    goto label_27;
                                }
                                break;
                            }
                            case 2: {
                                l l1 = (l)this.L$1;
                                Context context2 = (Context)this.L$0;
                                d5.n.D(object0);
                            label_27:
                                if(((i0)object0) instanceof h0) {
                                    ToastManager.showShort(0x7F13060F);  // string:melon_login_ok "멜론 로그인되었습니다."
                                    KakaoMelonLoginFragment.this.executeLoginReturnUriAndRemoveLoginFragment();
                                }
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        return h0;
                    }
                }

            }

            private static final H invokeSuspend$lambda$0(KakaoMelonLoginFragment kakaoMelonLoginFragment0, j j0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1.1.1(kakaoMelonLoginFragment0, j0, null), 3, null);
                return H.a;
            }
        }

    }

    private static final void initViews$lambda$0(KakaoMelonLoginFragment kakaoMelonLoginFragment0, View view0) {
        Bundle bundle0 = kakaoMelonLoginFragment0.getArguments();
        Parcelable parcelable0 = bundle0 == null ? null : bundle0.getParcelable("returnUri");
        q.e(parcelable0, "null cannot be cast to non-null type android.net.Uri");
        Navigator.INSTANCE.openMelonLoginView(((Uri)parcelable0), kakaoMelonLoginFragment0.loginFragmentCount + 1);
    }

    private static final void initViews$lambda$1(KakaoMelonLoginFragment kakaoMelonLoginFragment0, View view0) {
        D d0 = kakaoMelonLoginFragment0.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.initViews.2.1(kakaoMelonLoginFragment0, null), 3, null);
    }

    private static final void initViews$lambda$2(View view0) {
        Navigator.openUrlFullScreenView(UrlUtil.INSTANCE.getSignUpMembershipUrl());
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isBringToFrontFragment() {
        return true;
    }

    @NotNull
    public static final KakaoMelonLoginFragment newInstance(@NotNull Uri uri0) {
        return KakaoMelonLoginFragment.Companion.newInstance(uri0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0432, viewGroup0, false);  // layout:kakao_melon_login_layout
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n(null) {
            int label;

            {
                KakaoMelonLoginFragment.this = kakaoMelonLoginFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.onResume.1(KakaoMelonLoginFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.KakaoMelonLoginFragment.onResume.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        k k0 = KakaoMelonLoginFragment.this.getMelonLoginUseCase();
                        this.label = 1;
                        object0 = ((e0)k0).o(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                H h0 = H.a;
                if(((Boolean)object0).booleanValue() && KakaoMelonLoginFragment.this.isFragmentVisible) {
                    KakaoMelonLoginFragment.this.executeLoginReturnUriAndRemoveLoginFragment();
                }
                return h0;
            }
        }, 2, null);
    }

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

    public final void setKakaoLoginUseCase(@NotNull f f0) {
        q.g(f0, "<set-?>");
        this.kakaoLoginUseCase = f0;
    }

    public final void setMelonLoginUseCase(@NotNull k k0) {
        q.g(k0, "<set-?>");
        this.melonLoginUseCase = k0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setSimpleAccountUseCase(@NotNull o o0) {
        q.g(o0, "<set-?>");
        this.simpleAccountUseCase = o0;
    }
}

