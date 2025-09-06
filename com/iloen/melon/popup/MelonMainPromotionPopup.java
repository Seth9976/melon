package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.fragments.mymusic.dna.d;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes.Response.Banners.BANON;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes.Response.Banners;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes.Response;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.data.database.entity.BannerPopupEntity;
import d3.g;
import e1.u;
import he.e;
import ie.H;
import ie.r;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.i;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001B\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/popup/MelonMainPromotionPopup;", "Lcom/iloen/melon/popup/MelonCheckPopup;", "Landroid/app/Activity;", "activity", "Lcom/iloen/melon/net/v4x/response/MainLayerPopupRes;", "response", "<init>", "(Landroid/app/Activity;Lcom/iloen/melon/net/v4x/response/MainLayerPopupRes;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "", "orientation", "setConfigurationChanged", "(I)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonMainPromotionPopup extends MelonCheckPopup {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/popup/MelonMainPromotionPopup$Companion;", "", "Lcom/iloen/melon/net/v4x/response/MainLayerPopupRes;", "response", "", "canPopupShow", "(Lcom/iloen/melon/net/v4x/response/MainLayerPopupRes;)Z", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean canPopupShow(@Nullable MainLayerPopupRes mainLayerPopupRes0) {
            String s;
            if(mainLayerPopupRes0 != null && (mainLayerPopupRes0.response != null && (mainLayerPopupRes0.response.banners != null && mainLayerPopupRes0.response.banners.isEmpty()))) {
                return false;
            }
            if(mainLayerPopupRes0 == null) {
                s = null;
            }
            else {
                Response mainLayerPopupRes$Response0 = mainLayerPopupRes0.response;
                if(mainLayerPopupRes$Response0 == null) {
                    s = null;
                }
                else {
                    ArrayList arrayList0 = mainLayerPopupRes$Response0.banners;
                    if(arrayList0 == null) {
                        s = null;
                    }
                    else {
                        Banners mainLayerPopupRes$Response$Banners0 = (Banners)arrayList0.get(0);
                        s = mainLayerPopupRes$Response$Banners0 == null ? null : mainLayerPopupRes$Response$Banners0.imgurl;
                    }
                }
            }
            if(s == null) {
                s = "";
            }
            if(s.length() == 0) {
                LogU.Companion.w("MelonMainPromotionPopup", "canPopupShow() invalid imgUrl");
                return false;
            }
            return true;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final MainLayerPopupRes c;
    public View d;
    public final r e;
    public final r f;

    static {
        MelonMainPromotionPopup.Companion = new Companion(null);
        MelonMainPromotionPopup.$stable = 8;
    }

    public MelonMainPromotionPopup(@Nullable Activity activity0, @Nullable MainLayerPopupRes mainLayerPopupRes0) {
        super(activity0, 0x7F0D0138, MelonCheckPopup.newBuilder());  // layout:check_popup_layout
        this.e = g.Q(new d(24));
        this.f = g.Q(new d(25));
        LogU.Companion.d("MelonMainPromotionPopup", "MelonMainPromotionPopup()");
        this.c = mainLayerPopupRes0;
    }

    public final void a(boolean z) {
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        View view0 = this.d;
        if(view0 != null) {
            q.d(view0);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            viewGroup$LayoutParams0.width = ScreenUtils.dipToPixel(context0, (z ? 280.0f : 214.0f));
            viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(context0, (z ? 420.0f : 305.0f));
            View view1 = this.d;
            q.d(view1);
            view1.setLayoutParams(viewGroup$LayoutParams0);
            View view2 = this.d;
            q.d(view2);
            view2.requestLayout();
        }
    }

    public static final Ra.d access$getBannerPopupUseCase(MelonMainPromotionPopup melonMainPromotionPopup0) {
        return (Ra.d)melonMainPromotionPopup0.e.getValue();
    }

    @Override  // com.iloen.melon.popup.MelonCheckPopup
    public void onCreate(@Nullable Bundle bundle0) {
        ArrayList arrayList0;
        super.onCreate(bundle0);
        this.d = this.findViewById(0x7F0A0950);  // id:popup_container
        this.getLayoutInflater().inflate(0x7F0D05C7, this.mBodyContainer, true);  // layout:promotion_popup_body_layout
        ViewUtils.hideWhen(this.findViewById(0x7F0A095A), true);  // id:popup_top
        View view0 = this.findViewById(0x7F0A066F);  // id:iv_popup_divider
        boolean z = false;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = 0;
            }
        }
        MainLayerPopupRes mainLayerPopupRes0 = this.c;
        if(mainLayerPopupRes0 == null) {
            arrayList0 = null;
        }
        else {
            Response mainLayerPopupRes$Response0 = mainLayerPopupRes0.response;
            arrayList0 = mainLayerPopupRes$Response0 == null ? null : mainLayerPopupRes$Response0.banners;
        }
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            Banners mainLayerPopupRes$Response$Banners0 = (Banners)arrayList0.get(0);
            ViewUtils.setText(((TextView)this.findViewById(0x7F0A0CE7)), mainLayerPopupRes$Response$Banners0.dpTitle);  // id:tv_popup_checkbox
            String s = mainLayerPopupRes$Response$Banners0.imgurl == null ? "" : mainLayerPopupRes$Response$Banners0.imgurl;
            if(s.length() == 0) {
                this.dismiss();
                return;
            }
            this.mCheckBoxContainer.setOnClickListener(new E(this, 0));
            this.mRightButton.setOnClickListener(new F(0, this, mainLayerPopupRes$Response$Banners0));
            int v = ProtocolUtils.parseInt(mainLayerPopupRes$Response$Banners0.dpType, -1);
            View view1 = this.mCheckBoxContainer;
            if(v == -1) {
                z = true;
            }
            ViewUtils.hideWhen(view1, z);
            View view2 = this.findViewById(0x7F0A07A1);  // id:loading_progress
            ViewUtils.showWhen(view2, true);
            ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0989);  // id:promotion_image
            Context context0 = this.getContext();
            q.f(context0, "getContext(...)");
            int v1 = ScreenUtils.dipToPixel(context0, 5.5f);
            Glide.with(context0).load(s).apply(new RequestOptions().transform(new e(v1, RoundedCornersTransformation.CornerType.TOP))).into(new CustomTarget() {
                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable0) {
                }

                public void onResourceReady(Drawable drawable0, Transition transition0) {
                    q.g(drawable0, "resource");
                    ImageView imageView0 = view2;
                    if(imageView0 != null) {
                        imageView0.setImageDrawable(drawable0);
                        ViewUtils.hideWhen(this.b, true);
                    }
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Drawable)object0), transition0);
                }
            });
            ViewUtils.setOnClickListener(this.findViewById(0x7F0A098A), new s(mainLayerPopupRes$Response$Banners0, mainLayerPopupRes0, this, 7));  // id:promotion_image_container
            this.a(ScreenUtils.isPortrait(context0));
            ViewImpContent viewImpContent0 = new Builder().id(mainLayerPopupRes$Response$Banners0.banerseq).name(mainLayerPopupRes$Response$Banners0.title).type(mainLayerPopupRes$Response$Banners0.impType).layer1("레이어드팝업").impType("vimp").impProvider("melon_admin").impArea(mainLayerPopupRes$Response$Banners0.impArea).build();
            q.f(viewImpContent0, "build(...)");
            ContentList contentList0 = new ContentList();
            contentList0.addContent(viewImpContent0);
            i i0 = new i();  // 初始化器: Lp8/f;-><init>()V
            i0.b = "멜론홈탭";
            i0.c = "멜론홈탭_뮤직";
            i0.I = mainLayerPopupRes$Response$Banners0.menuId;
            i0.N = "0647dcc15b20c4f83f";
            i0.O = "app_user_id";
            i0.Q = "slot_personal";
            i0.M = "toros_melon_slot_personal_base";
            i0.Z = contentList0;
            i0.a().track();
            return;
        }
        this.dismiss();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.popup.MelonMainPromotionPopup$onCreate$2$1", f = "MelonMainPromotionPopup.kt", l = {0x80}, m = "invokeSuspend")
        final class com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1 extends oe.i implements n {
            public final String B;
            public final BANON D;
            public int r;
            public final MelonMainPromotionPopup w;

            public com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1(MelonMainPromotionPopup melonMainPromotionPopup0, String s, BANON mainLayerPopupRes$Response$Banners$BANON0, Continuation continuation0) {
                this.w = melonMainPromotionPopup0;
                this.B = s;
                this.D = mainLayerPopupRes$Response$Banners$BANON0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1.1 melonMainPromotionPopup$onCreate$2$1$10 = new n(this.B, this.D, null) {
                            public final String B;
                            public final BANON D;
                            public int r;
                            public final MelonMainPromotionPopup w;

                            {
                                this.w = melonMainPromotionPopup0;
                                this.B = s;
                                this.D = mainLayerPopupRes$Response$Banners$BANON0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1.1(this.w, this.B, this.D, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.popup.MelonMainPromotionPopup.onCreate.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Ra.d d0 = MelonMainPromotionPopup.access$getBannerPopupUseCase(this.w);
                                        BannerPopupEntity bannerPopupEntity0 = new BannerPopupEntity();
                                        bannerPopupEntity0.setMemberKey(u.v(((e0)o.a()).j()));
                                        q.d(this.B);
                                        bannerPopupEntity0.setId(this.B);
                                        String s = new com.google.gson.n().k(this.D);
                                        q.f(s, "toJson(...)");
                                        bannerPopupEntity0.setBanOn(s);
                                        bannerPopupEntity0.setPopupType("LAYER");
                                        this.r = 1;
                                        object0 = d0.c(bannerPopupEntity0, this);
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
                                LogU.Companion.d("MelonMainPromotionPopup", "onCreate() inserted : " + ((Number)object0).longValue());
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return BuildersKt.withContext(Dispatchers.getIO(), melonMainPromotionPopup$onCreate$2$1$10, this) == a0 ? a0 : H.a;
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

    @Override  // com.iloen.melon.popup.MelonBasePopup
    public void setConfigurationChanged(int v) {
        this.a(v == 1);
    }
}

