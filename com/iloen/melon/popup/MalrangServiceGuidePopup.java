package com.iloen.melon.popup;

import Q0.t0;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.data.database.entity.BannerPopupEntity;
import d3.g;
import i6.d;
import ie.H;
import ie.r;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import m0.b;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.i;
import we.n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fJ+\u0010\u0011\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u001D\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/popup/MalrangServiceGuidePopup;", "Li6/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "", "bannerUrl", "Landroidx/fragment/app/l0;", "fragmentManager", "show", "(Ljava/lang/String;Landroidx/fragment/app/l0;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MalrangServiceGuidePopup extends d {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/popup/MalrangServiceGuidePopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "SERVICE_TYPE", "BANNER_URL_KEY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String BANNER_URL_KEY = "INFOPOPUPURL";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String SERVICE_TYPE = "SIMPLEMODE";
    @NotNull
    public static final String TAG = "MalrangServiceGuidePopup";
    public String a;
    public final r b;

    static {
        MalrangServiceGuidePopup.Companion = new Companion(null);
        MalrangServiceGuidePopup.$stable = 8;
    }

    public MalrangServiceGuidePopup() {
        this.b = g.Q(new com.iloen.melon.fragments.mymusic.dna.d(23));
    }

    public static final Ra.d access$getBannerPopupUseCase(MalrangServiceGuidePopup malrangServiceGuidePopup0) {
        return (Ra.d)malrangServiceGuidePopup0.b.getValue();
    }

    public final void m(String s) {
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.d = ActionKind.ClickContent;
        g0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        g0.b = this.getString(0x7F130E4B);  // string:tiara_common_section "멜론홈탭"
        g0.c = this.getString(0x7F130E52);  // string:tiara_common_section_music "멜론홈탭_뮤직"
        g0.I = "1000002436";
        g0.y = this.getString(0x7F130F0B);  // string:tiara_mixup_malrang_guide_popup_layer "심플모드 서비스안내 팝업"
        g0.B = s;
        g0.F = this.getString((s == null || s.length() == 0 ? 0x7F1301D2 : 0x7F130F0A));  // string:close "닫기"
        g0.f = this.getString(0x7F130EF3);  // string:tiara_meta_type_banner "배너"
        g0.a().track();
    }

    @Override  // androidx.fragment.app.w
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setStyle(0, 0x7F14013B);  // style:CommonComposeBottomSheet
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        View view0 = new ComposeView(context0, null, 6, 0);
        ((AbstractComposeView)view0).setViewCompositionStrategy(t0.d);
        ((ComposeView)view0).setContent(new b(0x4816AC9F, new y(this, 4), true));
        Builder viewImpContent$Builder0 = new Builder().type(this.getString(0x7F130DE7)).layer1(this.getString(0x7F130F0B)).impType(this.getString(0x7F130EBC)).impOrdNum("1");  // string:tiara_common_layer1_banner "배너"
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        q.f("20250906123318", "format(...)");
        linkedHashMap0.put("vimp_time", "20250906123318");
        ViewImpContent viewImpContent0 = viewImpContent$Builder0.props(linkedHashMap0).build();
        q.f(viewImpContent0, "build(...)");
        ContentList contentList0 = new ContentList();
        contentList0.addContent(viewImpContent0);
        i i0 = new i();  // 初始化器: Lp8/f;-><init>()V
        i0.b = this.getString(0x7F130E4B);  // string:tiara_common_section "멜론홈탭"
        i0.c = this.getString(0x7F130E52);  // string:tiara_common_section_music "멜론홈탭_뮤직"
        i0.I = "1000002436";
        i0.Z = contentList0;
        i0.a().track();
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        BottomSheetBehavior bottomSheetBehavior0 = null;
        BottomSheetDialog bottomSheetDialog0 = dialog0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialog0) : null;
        if(bottomSheetDialog0 != null) {
            BottomSheetBehavior bottomSheetBehavior1 = bottomSheetDialog0.e();
            if(bottomSheetBehavior1 != null) {
                bottomSheetBehavior1.f0 = true;
                this.setCancelable(false);
                bottomSheetBehavior1.g0 = false;
                bottomSheetBehavior0 = bottomSheetBehavior1;
            }
        }
        if(bottomSheetBehavior0 != null) {
            bottomSheetBehavior0.M(3);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getIO(), null, new n(null) {
            public int r;
            public final MalrangServiceGuidePopup w;

            {
                this.w = malrangServiceGuidePopup0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.MalrangServiceGuidePopup.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.MalrangServiceGuidePopup.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Ra.d d0 = MalrangServiceGuidePopup.access$getBannerPopupUseCase(this.w);
                        BannerPopupEntity bannerPopupEntity0 = new BannerPopupEntity();
                        bannerPopupEntity0.setMemberKey("0");
                        bannerPopupEntity0.setId("DJ_MALRANG_GUIDE");
                        bannerPopupEntity0.setBanOn("{}");
                        bannerPopupEntity0.setPopupType("DJ_MALRANG_GUIDE");
                        this.r = 1;
                        return d0.c(bannerPopupEntity0, this) == a0 ? a0 : H.a;
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

    public final void show(@NotNull String s, @NotNull l0 l00) {
        q.g(s, "bannerUrl");
        q.g(l00, "fragmentManager");
        this.a = s;
        if(l00.E("MalrangServiceGuidePopup") == null) {
            androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
            a0.e(0, this, "MalrangServiceGuidePopup", 1);
            a0.l(true, true);
        }
    }
}

