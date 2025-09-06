package com.iloen.melon.fragments.cashfriends;

import A8.M;
import A8.b;
import De.I;
import J8.R0;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.l1;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.kakaoent.trevi.ad.TreviAd.OfferWallEventCallback;
import com.kakaoent.trevi.ad.TreviAd;
import ie.H;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import v9.h;
import v9.i;
import va.e0;
import va.o;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0003J\u000F\u0010\u0018\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001D\u0010\u001F\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0011\u0010\"\u001A\u0004\u0018\u00010!H\u0014\u00A2\u0006\u0004\b\"\u0010#J-\u0010*\u001A\u00020\b2\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0019\u0010,\u001A\u00020\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b,\u0010\u001BR\"\u0010.\u001A\u00020-8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R.\u0010:\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0004098\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b:\u0010;\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010B\u001A\u0002048F\u00A2\u0006\u0006\u001A\u0004\b@\u0010A\u00A8\u0006D"}, d2 = {"Lcom/iloen/melon/fragments/cashfriends/CashFriendsFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "showOfferWall", "registerIsLoginFlow", "updateBottomMargin", "", "isScreenLandscapeSupported", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onBackPressed", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onNewArguments", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "LJ8/R0;", "_binding", "LJ8/R0;", "query", "Ljava/lang/String;", "Lkotlin/Function1;", "loginHandler", "Lwe/k;", "getLoginHandler", "()Lwe/k;", "setLoginHandler", "(Lwe/k;)V", "getBinding", "()LJ8/R0;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CashFriendsFragment extends Hilt_CashFriendsFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/cashfriends/CashFriendsFragment$Companion;", "", "<init>", "()V", "TAG", "", "OFFERWALL_FRAGMENT_TAG", "ARG_QUERY", "newInstance", "Lcom/iloen/melon/fragments/cashfriends/CashFriendsFragment;", "id", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CashFriendsFragment newInstance(@Nullable String s) {
            CashFriendsFragment cashFriendsFragment0 = new CashFriendsFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("query", s);
            cashFriendsFragment0.setArguments(bundle0);
            return cashFriendsFragment0;
        }

        public static CashFriendsFragment newInstance$default(Companion cashFriendsFragment$Companion0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = null;
            }
            return cashFriendsFragment$Companion0.newInstance(s);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_QUERY = "query";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String OFFERWALL_FRAGMENT_TAG = "OfferwallFragment";
    @NotNull
    private static final String TAG = "CashFriendsFragment";
    @Nullable
    private R0 _binding;
    public k loginHandler;
    @Inject
    public mb.k loginUseCase;
    @NotNull
    private String query;

    static {
        CashFriendsFragment.Companion = new Companion(null);
        CashFriendsFragment.$stable = 8;
    }

    public CashFriendsFragment() {
        this.query = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    public static void d0(WeakReference weakReference0, WeakReference weakReference1) {
        CashFriendsFragment.showOfferWall$lambda$0(weakReference0, weakReference1);
    }

    @NotNull
    public final R0 getBinding() {
        R0 r00 = this._binding;
        q.d(r00);
        return r00;
    }

    @NotNull
    public final k getLoginHandler() {
        k k0 = this.loginHandler;
        if(k0 != null) {
            return k0;
        }
        q.m("loginHandler");
        throw null;
    }

    @NotNull
    public final mb.k getLoginUseCase() {
        mb.k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        TreviAd treviAd0 = TreviAd.INSTANCE;
        if(treviAd0.canGoBackOfferWall()) {
            treviAd0.onBackPressedOfferWall();
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        if(!b.e() && MelonSettingInfo.getWebViewContentsDebugging()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        View view0 = layoutInflater0.inflate(0x7F0D029B, viewGroup0, false);  // layout:fragment_cash_friends
        int v = 0x7F0A04DD;  // id:fragment_container
        FragmentContainerView fragmentContainerView0 = (FragmentContainerView)I.C(view0, 0x7F0A04DD);  // id:fragment_container
        if(fragmentContainerView0 != null) {
            v = 0x7F0A0D00;  // id:tv_sdk_version
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D00);  // id:tv_sdk_version
            if(melonTextView0 != null) {
                this._binding = new R0(((FrameLayout)view0), fragmentContainerView0, melonTextView0);
                R0 r00 = this.getBinding();
                q.f(r00.a, "getRoot(...)");
                return r00.a;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onNewArguments(@Nullable Bundle bundle0) {
        super.onNewArguments(bundle0);
        this.showOfferWall();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.query = l1.g(bundle0, "inState", "query", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getBinding().c.setText("2.3.0");
        this.getBinding().c.setVisibility(8);
        this.showOfferWall();
        this.updateBottomMargin();
        this.registerIsLoginFlow();
    }

    private final void registerIsLoginFlow() {
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            int label;

            {
                CashFriendsFragment.this = cashFriendsFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.cashfriends.CashFriendsFragment.registerIsLoginFlow.1(CashFriendsFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.cashfriends.CashFriendsFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)CashFriendsFragment.this.getLoginUseCase()).n()), 1);
                        com.iloen.melon.fragments.cashfriends.CashFriendsFragment.registerIsLoginFlow.1.1 cashFriendsFragment$registerIsLoginFlow$1$10 = new n(null) {
                            boolean Z$0;
                            int label;

                            {
                                CashFriendsFragment.this = cashFriendsFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.cashfriends.CashFriendsFragment.registerIsLoginFlow.1.1(CashFriendsFragment.this, continuation0);
                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.cashfriends.CashFriendsFragment.registerIsLoginFlow.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.Z$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                if(CashFriendsFragment.this.loginHandler != null) {
                                    if(z) {
                                        q.g(((e0)o.a()).j(), "<this>");
                                    }
                                    CashFriendsFragment.this.getLoginHandler().invoke("0");
                                }
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, cashFriendsFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
    }

    public final void setLoginHandler(@NotNull k k0) {
        q.g(k0, "<set-?>");
        this.loginHandler = k0;
    }

    public final void setLoginUseCase(@NotNull mb.k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    private final void showOfferWall() {
        q.g(((e0)o.a()).j(), "<this>");
        if(this.loginHandler != null) {
            k k0 = this.getLoginHandler();
            q.f("", "getMemberKey(...)");
            k0.invoke("");
        }
        if(this.getChildFragmentManager().E("OfferwallFragment") == null) {
            boolean z = ScreenUtils.isDarkMode(this.requireContext());
            String s = this.query;
            com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1 cashFriendsFragment$showOfferWall$offerWallFragment$10 = new SimpleOfferWallCallBack() {
                public static void a(we.a a0, DialogInterface dialogInterface0) {
                    com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showAlertDialog$lambda$3$lambda$2(a0, dialogInterface0);
                }

                public static void c(we.a a0, DialogInterface dialogInterface0, int v) {
                    com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showAlertDialog$lambda$3$lambda$1(a0, dialogInterface0, v);
                }

                public static void d(CashFriendsFragment cashFriendsFragment0, DialogInterface dialogInterface0, int v) {
                    com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.onNetworkError$lambda$6(cashFriendsFragment0, dialogInterface0, v);
                }

                public static void e(we.a a0, DialogInterface dialogInterface0, int v) {
                    com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showAlertDialog$lambda$3$lambda$0(a0, dialogInterface0, v);
                }

                @Override  // com.iloen.melon.fragments.cashfriends.SimpleOfferWallCallBack
                public void onNetworkError(WeakReference weakReference0, boolean z, int v, we.a a0) {
                    q.g(weakReference0, "activityRef");
                    q.g(a0, "reload");
                    if(z) {
                        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(CashFriendsFragment.this.requireActivity(), 0, null, CashFriendsFragment.this.getString(0x7F13007B), new com.facebook.login.b(CashFriendsFragment.this, 2));  // string:alert_dlg_body_cash_friends_network_error "접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하시거나,\n잠시 
                                                                                                                                                                                                                                                 // 후 다시 시도해주세요."
                        melonTextPopup0.setOnDismissListener(CashFriendsFragment.this.mDialogDismissListener);
                        CashFriendsFragment.this.mRetainDialog = melonTextPopup0;
                        melonTextPopup0.show();
                        return;
                    }
                    ToastManager.show(0x7F13007C);  // string:alert_dlg_body_cash_friends_network_error_for_toast "접속이 지연되고 있습니다.\n네트워크 
                                                    // 연결을 확인해주세요."
                }

                private static final void onNetworkError$lambda$6(CashFriendsFragment cashFriendsFragment0, DialogInterface dialogInterface0, int v) {
                    cashFriendsFragment0.performBackPress();
                }

                @Override  // com.iloen.melon.fragments.cashfriends.SimpleOfferWallCallBack
                public void showAlertDialog(WeakReference weakReference0, String s, String s1, boolean z, String s2, String s3, we.a a0, we.a a1) {
                    q.g(weakReference0, "activityRef");
                    q.g(s2, "positiveButtonText");
                    q.g(a0, "positiveButtonAction");
                    q.g(a1, "negativeButtonAction");
                    Activity activity0 = (Activity)weakReference0.get();
                    if(activity0 != null) {
                        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0);
                        alertDialog$Builder0.a.n = z;
                        alertDialog$Builder0.a.e = s;
                        alertDialog$Builder0.a.g = s1;
                        com.iloen.melon.fragments.cashfriends.a a2 = new com.iloen.melon.fragments.cashfriends.a(0, a0);
                        alertDialog$Builder0.a.h = s2;
                        alertDialog$Builder0.a.i = a2;
                        com.iloen.melon.fragments.cashfriends.a a3 = new com.iloen.melon.fragments.cashfriends.a(1, a1);
                        alertDialog$Builder0.a.j = s3;
                        alertDialog$Builder0.a.k = a3;
                        alertDialog$Builder0.a.o = new U9.b(a1, 2);
                        alertDialog$Builder0.a().show();
                    }
                }

                private static final void showAlertDialog$lambda$3$lambda$0(we.a a0, DialogInterface dialogInterface0, int v) {
                    a0.invoke();
                    dialogInterface0.dismiss();
                }

                private static final void showAlertDialog$lambda$3$lambda$1(we.a a0, DialogInterface dialogInterface0, int v) {
                    a0.invoke();
                    dialogInterface0.dismiss();
                }

                private static final void showAlertDialog$lambda$3$lambda$2(we.a a0, DialogInterface dialogInterface0) {
                    a0.invoke();
                    dialogInterface0.dismiss();
                }

                @Override  // com.iloen.melon.fragments.cashfriends.SimpleOfferWallCallBack
                public void showLogin(WeakReference weakReference0, k k0) {
                    q.g(weakReference0, "activityRef");
                    q.g(k0, "setAppUserId");
                    CashFriendsFragment.this.setLoginHandler(k0);
                    if(((e0)o.a()).m()) {
                        MelonTextPopup melonTextPopup0 = new MelonTextPopup(CashFriendsFragment.this.requireActivity(), 2);
                        melonTextPopup0.setTitleName(CashFriendsFragment.this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
                        melonTextPopup0.setBodyMsg(CashFriendsFragment.this.getString(0x7F13007A));  // string:alert_dlg_body_cash_friends_need_kakao_account "고객님! 캐시프렌즈 이용을 위해 카카오톡 계정과 
                                                                                                     // 연동이 필요합니다."
                        melonTextPopup0.setPopupOnClickListener(new Xb.a(1));
                        melonTextPopup0.setRightBtnName(CashFriendsFragment.this.getString(0x7F1300C5));  // string:alert_dlg_link_button_cash_friends_need_kakao_account "계정 연동하기"
                        melonTextPopup0.show();
                        return;
                    }
                    CashFriendsFragment.this.openLoginView(f.f);

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @e(c = "com.iloen.melon.fragments.cashfriends.CashFriendsFragment$showOfferWall$offerWallFragment$1$showLogin$popup$1$1$1", f = "CashFriendsFragment.kt", l = {}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showLogin.popup.1.1.1 extends oe.i implements n {
                        int label;

                        public com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showLogin.popup.1.1.1(Continuation continuation0) {
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showLogin.popup.1.1.1(continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showLogin.popup.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            Navigator.openUrl(M.R, OpenType.FirstDepth);
                            return H.a;
                        }
                    }

                }

                private static final void showLogin$lambda$5$lambda$4(DialogInterface dialogInterface0, int v) {
                    if(-1 == v) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.1.showLogin.popup.1.1.1(null), 3, null);
                    }
                    dialogInterface0.dismiss();
                }

                @Override  // com.iloen.melon.fragments.cashfriends.SimpleOfferWallCallBack
                public void showToast(WeakReference weakReference0, String s) {
                    q.g(weakReference0, "activityRef");
                    Toast.makeText(((Context)weakReference0.get()), s, 1).show();
                }
            };
            com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.2 cashFriendsFragment$showOfferWall$offerWallFragment$20 = new com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.2();
            com.google.android.exoplayer2.upstream.cache.a a0 = new com.google.android.exoplayer2.upstream.cache.a(13);
            androidx.fragment.app.I i0 = TreviAd.getOfferWallFragment$default(TreviAd.INSTANCE, "0", z, 0, s, null, false, false, cashFriendsFragment$showOfferWall$offerWallFragment$10, cashFriendsFragment$showOfferWall$offerWallFragment$20, a0, 0x74, null);
            l0 l00 = this.getChildFragmentManager();
            l00.getClass();
            androidx.fragment.app.a a1 = new androidx.fragment.app.a(l00);
            a1.g(0x7F0A04DD, i0, "OfferwallFragment");  // id:fragment_container
            if(a1.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            a1.h = false;
            a1.r.A(a1, true);
        }

        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0007\u001A\u00020\u00062&\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\t\u001A\u00020\u00062&\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ7\u0010\n\u001A\u00020\u00062&\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ7\u0010\u000B\u001A\u00020\u00062&\u0010\u0005\u001A\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\b¨\u0006\f"}, d2 = {"com/iloen/melon/fragments/cashfriends/CashFriendsFragment$showOfferWall$offerWallFragment$2", "Lcom/kakaoent/trevi/ad/TreviAd$OfferWallEventCallback;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "data", "Lie/H;", "pageViewEvent", "(Ljava/util/HashMap;)V", "trackEvent", "trackExtraEvent", "viewImp", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.cashfriends.CashFriendsFragment.showOfferWall.offerWallFragment.2 implements OfferWallEventCallback {
            @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallEventCallback
            public void pageViewEvent(HashMap hashMap0) {
            }

            @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallEventCallback
            public void trackEvent(HashMap hashMap0) {
            }

            @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallEventCallback
            public void trackExtraEvent(HashMap hashMap0) {
            }

            @Override  // com.kakaoent.trevi.ad.TreviAd$OfferWallEventCallback
            public void viewImp(HashMap hashMap0) {
            }
        }

    }

    private static final void showOfferWall$lambda$0(WeakReference weakReference0, WeakReference weakReference1) {
        q.g(weakReference0, "backButtonRef");
        q.g(weakReference1, "<unused var>");
        ImageButton imageButton0 = (ImageButton)weakReference0.get();
        if(imageButton0 != null) {
            imageButton0.setImageResource(0x7F0801CE);  // drawable:btn_gnb_cf_back_tint_gray900s
        }
    }

    private final void updateBottomMargin() {
        int v1;
        if(this.isFragmentValid() && this.getActivity() instanceof U) {
            boolean z = this.shouldShowMiniPlayer();
            if(z) {
                int v = this.getResources().getDimensionPixelOffset(0x7F070315);  // dimen:mini_player_height
                v1 = this.getResources().getDimensionPixelOffset(0x7F070057) + v;  // dimen:bottom_tab_height
            }
            else {
                v1 = 0;
            }
            FragmentContainerView fragmentContainerView0 = this.getBinding().b;
            if(!z) {
                v1 = 0;
            }
            fragmentContainerView0.setPadding(0, 0, 0, v1);
        }
    }
}

