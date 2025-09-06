package Ic;

import Cb.i;
import Dd.g2;
import F8.u;
import Hc.O;
import Hc.x;
import J8.N;
import J8.S;
import J8.e3;
import Jc.A;
import Jc.X;
import Jc.y;
import Jc.z;
import R6.c;
import R6.d;
import Ub.s;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SmallRatingDetailView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE.RECMLIST;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.A4;
import com.melon.ui.C4;
import com.melon.ui.F4;
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.V;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.l;
import com.melon.ui.m2;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.x3;
import com.melon.ui.x4;
import com.melon.ui.z4;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import vd.P;
import we.o;
import zd.Q;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\n\u000BB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"LIc/k;", "LHc/w;", "LIc/A0;", "LJ8/d;", "", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "Ic/g", "Ic/f", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class k extends B0 implements M2, a, k3 {
    public final p3 B;
    public final d D;
    public final e E;
    public final LogU G;
    public final b I;
    public final c w;

    public k() {
        this.w = new c(26);
        this.B = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.D = new d(25);
        this.E = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("AlbumDetailFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.G = logU0;
        this.I = H0.e.T(this, new g2(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return A0.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, we.k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.E.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public final void handleMoreListPopupOnEvent(I i0, we.k k0, Q q0, k2 k20) {
        q.g(k20, "event");
        this.D.x(i0, k0, q0, k20);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.D.handleMorePopupUiEvent(m20, i0, o0);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, I i0, we.a a0, we.k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.B.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    @Override  // Hc.w
    public final O n() {
        return new f(0);
    }

    @Override  // Hc.w
    public final Q4.a o(LayoutInflater layoutInflater0) {
        View view0 = layoutInflater0.inflate(0x7F0D002D, null, false);  // layout:album_detail_header
        int v = 0x7F0A008C;  // id:album_purchase_container
        View view1 = De.I.C(view0, 0x7F0A008C);  // id:album_purchase_container
        if(((ConstraintLayout)view1) != null) {
            v = 0x7F0A00B3;  // id:artist_container
            View view2 = De.I.C(view0, 0x7F0A00B3);  // id:artist_container
            if(((RelativeLayout)view2) != null && ((FrameLayout)De.I.C(view0, 0x7F0A00BE)) != null) {  // id:artist_thumb_container
                v = 0x7F0A00F1;  // id:banner_iv
                View view3 = De.I.C(view0, 0x7F0A00F1);  // id:banner_iv
                if(((ImageView)view3) != null) {
                    v = 0x7F0A012B;  // id:bottom_space_view
                    View view4 = De.I.C(view0, 0x7F0A012B);  // id:bottom_space_view
                    if(view4 != null) {
                        v = 0x7F0A013E;  // id:btn_album_purchase
                        View view5 = De.I.C(view0, 0x7F0A013E);  // id:btn_album_purchase
                        if(((MelonTextView)view5) != null) {
                            v = 0x7F0A02FE;  // id:common_contents
                            View view6 = De.I.C(view0, 0x7F0A02FE);  // id:common_contents
                            if(view6 != null) {
                                N n0 = N.a(view6);
                                v = 0x7F0A033E;  // id:contents_container
                                if(((RelativeLayout)De.I.C(view0, 0x7F0A033E)) != null) {  // id:contents_container
                                    v = 0x7F0A03A7;  // id:desc_container
                                    View view7 = De.I.C(view0, 0x7F0A03A7);  // id:desc_container
                                    if(((RelativeLayout)view7) != null) {
                                        v = 0x7F0A03A9;  // id:desc_long
                                        View view8 = De.I.C(view0, 0x7F0A03A9);  // id:desc_long
                                        if(((MelonTextView)view8) != null) {
                                            v = 0x7F0A03AA;  // id:desc_long_container
                                            View view9 = De.I.C(view0, 0x7F0A03AA);  // id:desc_long_container
                                            if(((RelativeLayout)view9) != null) {
                                                v = 0x7F0A03AB;  // id:desc_more
                                                View view10 = De.I.C(view0, 0x7F0A03AB);  // id:desc_more
                                                if(((LinearLayout)view10) != null) {
                                                    v = 0x7F0A03AC;  // id:desc_short
                                                    View view11 = De.I.C(view0, 0x7F0A03AC);  // id:desc_short
                                                    if(((MelonTextView)view11) != null) {
                                                        v = 0x7F0A03AD;  // id:desc_short_container
                                                        View view12 = De.I.C(view0, 0x7F0A03AD);  // id:desc_short_container
                                                        if(((RelativeLayout)view12) != null) {
                                                            v = 0x7F0A03D8;  // id:divider_view
                                                            View view13 = De.I.C(view0, 0x7F0A03D8);  // id:divider_view
                                                            if(view13 != null) {
                                                                v = 0x7F0A048A;  // id:fame_layout
                                                                View view14 = De.I.C(view0, 0x7F0A048A);  // id:fame_layout
                                                                if(((RelativeLayout)view14) != null && ((RelativeLayout)De.I.C(view0, 0x7F0A0595)) != null && (((LinearLayout)De.I.C(view0, 0x7F0A0596)) != null && ((ImageView)De.I.C(view0, 0x7F0A05EB)) != null)) {  // id:issue_date_container
                                                                    v = 0x7F0A05ED;  // id:iv_album_thumb
                                                                    View view15 = De.I.C(view0, 0x7F0A05ED);  // id:iv_album_thumb
                                                                    if(((MelonImageView)view15) != null) {
                                                                        v = 0x7F0A05F1;  // id:iv_arrow
                                                                        View view16 = De.I.C(view0, 0x7F0A05F1);  // id:iv_arrow
                                                                        if(((ImageView)view16) != null) {
                                                                            v = 0x7F0A05F8;  // id:iv_badge
                                                                            View view17 = De.I.C(view0, 0x7F0A05F8);  // id:iv_badge
                                                                            if(((ImageView)view17) != null) {
                                                                                v = 0x7F0A0626;  // id:iv_dolby
                                                                                View view18 = De.I.C(view0, 0x7F0A0626);  // id:iv_dolby
                                                                                if(((ImageView)view18) != null) {
                                                                                    v = 0x7F0A0627;  // id:iv_dot
                                                                                    View view19 = De.I.C(view0, 0x7F0A0627);  // id:iv_dot
                                                                                    if(view19 != null) {
                                                                                        v = 0x7F0A062B;  // id:iv_fame_bg
                                                                                        View view20 = De.I.C(view0, 0x7F0A062B);  // id:iv_fame_bg
                                                                                        if(((ImageView)view20) != null) {
                                                                                            v = 0x7F0A062C;  // id:iv_fame_dim
                                                                                            View view21 = De.I.C(view0, 0x7F0A062C);  // id:iv_fame_dim
                                                                                            if(((ImageView)view21) != null) {
                                                                                                v = 0x7F0A0638;  // id:iv_info
                                                                                                View view22 = De.I.C(view0, 0x7F0A0638);  // id:iv_info
                                                                                                if(((ImageView)view22) != null) {
                                                                                                    v = 0x7F0A064E;  // id:iv_masterpiece
                                                                                                    View view23 = De.I.C(view0, 0x7F0A064E);  // id:iv_masterpiece
                                                                                                    if(((ImageView)view23) != null) {
                                                                                                        v = 0x7F0A068F;  // id:iv_spotlight
                                                                                                        View view24 = De.I.C(view0, 0x7F0A068F);  // id:iv_spotlight
                                                                                                        if(((ImageView)view24) != null) {
                                                                                                            Guideline guideline0 = (Guideline)De.I.C(view0, 0x7F0A0759);  // id:left_guideline
                                                                                                            v = 0x7F0A09B5;  // id:rate_container
                                                                                                            View view25 = De.I.C(view0, 0x7F0A09B5);  // id:rate_container
                                                                                                            if(((RelativeLayout)view25) != null) {
                                                                                                                Guideline guideline1 = (Guideline)De.I.C(view0, 0x7F0A09F8);  // id:right_guideline
                                                                                                                LinearLayoutCompat linearLayoutCompat0 = (LinearLayoutCompat)De.I.C(view0, 0x7F0A0AD0);  // id:spot_dolby_layout
                                                                                                                v = 0x7F0A0AD1;  // id:spotlight_layout
                                                                                                                View view26 = De.I.C(view0, 0x7F0A0AD1);  // id:spotlight_layout
                                                                                                                if(((RelativeLayout)view26) != null) {
                                                                                                                    v = 0x7F0A0ADA;  // id:srv_album_rating
                                                                                                                    View view27 = De.I.C(view0, 0x7F0A0ADA);  // id:srv_album_rating
                                                                                                                    if(((SmallRatingDetailView)view27) != null && ((FrameLayout)De.I.C(view0, 0x7F0A0B79)) != null) {  // id:thumb_layout
                                                                                                                        v = 0x7F0A0B7A;  // id:thumb_layout1
                                                                                                                        View view28 = De.I.C(view0, 0x7F0A0B7A);  // id:thumb_layout1
                                                                                                                        if(view28 != null) {
                                                                                                                            e3 e30 = e3.a(view28);
                                                                                                                            v = 0x7F0A0B7B;  // id:thumb_layout2
                                                                                                                            View view29 = De.I.C(view0, 0x7F0A0B7B);  // id:thumb_layout2
                                                                                                                            if(view29 != null) {
                                                                                                                                e3 e31 = e3.a(view29);
                                                                                                                                v = 0x7F0A0B7C;  // id:thumb_layout3
                                                                                                                                View view30 = De.I.C(view0, 0x7F0A0B7C);  // id:thumb_layout3
                                                                                                                                if(view30 != null) {
                                                                                                                                    e3 e32 = e3.a(view30);
                                                                                                                                    v = 0x7F0A0C0B;  // id:tv_album_purchase_msg
                                                                                                                                    View view31 = De.I.C(view0, 0x7F0A0C0B);  // id:tv_album_purchase_msg
                                                                                                                                    if(((MelonTextView)view31) != null) {
                                                                                                                                        v = 0x7F0A0C0C;  // id:tv_album_rate_avg
                                                                                                                                        View view32 = De.I.C(view0, 0x7F0A0C0C);  // id:tv_album_rate_avg
                                                                                                                                        if(((MelonTextView)view32) != null) {
                                                                                                                                            v = 0x7F0A0C0D;  // id:tv_album_rate_partin
                                                                                                                                            View view33 = De.I.C(view0, 0x7F0A0C0D);  // id:tv_album_rate_partin
                                                                                                                                            if(((MelonTextView)view33) != null) {
                                                                                                                                                v = 0x7F0A0C12;  // id:tv_artist
                                                                                                                                                View view34 = De.I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                                                                                                                                if(((MelonTextView)view34) != null) {
                                                                                                                                                    v = 0x7F0A0C1E;  // id:tv_badge
                                                                                                                                                    View view35 = De.I.C(view0, 0x7F0A0C1E);  // id:tv_badge
                                                                                                                                                    if(((MelonTextView)view35) != null && ((MelonTextView)De.I.C(view0, 0x7F0A0C74)) != null) {  // id:tv_fame
                                                                                                                                                        v = 0x7F0A0C7A;  // id:tv_flac
                                                                                                                                                        View view36 = De.I.C(view0, 0x7F0A0C7A);  // id:tv_flac
                                                                                                                                                        if(((MelonTextView)view36) != null) {
                                                                                                                                                            v = 0x7F0A0C93;  // id:tv_issue_date
                                                                                                                                                            View view37 = De.I.C(view0, 0x7F0A0C93);  // id:tv_issue_date
                                                                                                                                                            if(((MelonTextView)view37) != null) {
                                                                                                                                                                return new J8.d(((ConstraintLayout)view0), ((ConstraintLayout)view1), ((RelativeLayout)view2), ((ImageView)view3), view4, ((MelonTextView)view5), n0, ((RelativeLayout)view7), ((MelonTextView)view8), ((RelativeLayout)view9), ((LinearLayout)view10), ((MelonTextView)view11), ((RelativeLayout)view12), view13, ((RelativeLayout)view14), ((MelonImageView)view15), ((ImageView)view16), ((ImageView)view17), ((ImageView)view18), view19, ((ImageView)view20), ((ImageView)view21), ((ImageView)view22), ((ImageView)view23), ((ImageView)view24), ((RelativeLayout)view25), ((RelativeLayout)view26), ((SmallRatingDetailView)view27), e30, e31, e32, ((MelonTextView)view31), ((MelonTextView)view32), ((MelonTextView)view33), ((MelonTextView)view34), ((MelonTextView)view35), ((MelonTextView)view36), ((MelonTextView)view37));
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Hc.w
    public final void onAppBarCollapsed() {
        TitleBar titleBar0 = this.j;
        if(titleBar0 != null) {
            titleBar0.setTitle(((A0)this.getViewModel()).r());
            titleBar0.f(false);
        }
    }

    @Override  // Hc.w
    public final void onAppBarExpended() {
        TitleBar titleBar0 = this.j;
        if(titleBar0 != null) {
            titleBar0.setTitle("");
            titleBar0.f(true);
        }
    }

    @Override  // Hc.w
    public final void onAppBarScrolling(int v) {
        RelativeLayout relativeLayout0;
        float f = (float)Math.abs(v);
        float f1 = 0.0f;
        if(ScreenUtils.isLandscape(this.getContext()) || ScreenUtils.isTablet(this.getContext())) {
            J8.d d0 = (J8.d)this.b;
            if(d0 == null) {
                relativeLayout0 = null;
            }
            else {
                ConstraintLayout constraintLayout0 = d0.a;
                relativeLayout0 = constraintLayout0 == null ? null : ((RelativeLayout)constraintLayout0.findViewById(0x7F0A03A7));  // id:desc_container
            }
            if(relativeLayout0 != null) {
                f1 = (float)relativeLayout0.getHeight();
            }
            if(f >= f1) {
                TitleBar titleBar2 = this.j;
                if(titleBar2 != null) {
                    titleBar2.setTitle(((A0)this.getViewModel()).r());
                    titleBar2.f(true);
                }
            }
            else {
                TitleBar titleBar3 = this.j;
                if(titleBar3 != null) {
                    titleBar3.setTitle("");
                    titleBar3.f(false);
                }
            }
        }
        else if(f > 0.0f) {
            TitleBar titleBar0 = this.j;
            if(titleBar0 != null) {
                titleBar0.setTitle(((A0)this.getViewModel()).r());
            }
        }
        else {
            if(f != 0.0f) {
                return;
            }
            TitleBar titleBar1 = this.j;
            if(titleBar1 != null) {
                titleBar1.f(false);
            }
        }
    }

    @Override  // Hc.w
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.x(((K4)((A0)this.getViewModel()).w.getValue()));
    }

    @Override  // Hc.w
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        A0 a00 = (A0)this.getViewModel();
        String s = bundle0.getString("argAlbumId", "");
        q.f(s, "getString(...)");
        a00.getClass();
        a00.s = s;
        A0 a01 = (A0)this.getViewModel();
        a01.t = bundle0.getBoolean("argAutoPlay", false);
    }

    @Override  // com.melon.ui.o1
    public final void onForeground() {
        super.onForeground();
        if(this.isFragmentVisible()) {
            this.sendUserEvent(d0.a);
        }
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argAlbumId", ((A0)this.getViewModel()).p());
        bundle0.putBoolean("argAutoPlay", ((A0)this.getViewModel()).t);
    }

    @Override  // Hc.w
    public final void onUiEvent(I4 i40) {
        ArrayList arrayList1;
        q.g(i40, "event");
        String s = "onUiEvent() event: " + i.o(i40);
        LogU.info$default(this.G, s, null, false, 6, null);
        if(i40 instanceof m) {
            RESPONSE albumSuggestedContentsRes$RESPONSE0 = ((m)i40).a;
            ArrayList arrayList0 = albumSuggestedContentsRes$RESPONSE0.recmList;
            if(arrayList0 == null) {
                arrayList1 = w.a;
            }
            else {
                arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    arrayList1.add(new P(((RECMLIST)object0).relatTitle, ((RECMLIST)object0).recmTypeCode, ((RECMLIST)object0).contsTypeCode, ((RECMLIST)object0).contsId, ((RECMLIST)object0).contsName, ((RECMLIST)object0).contsImg, ((RECMLIST)object0).chnllSeq, ((RECMLIST)object0).link, ((RECMLIST)object0).playTime));
                }
            }
            l0 l00 = this.getChildFragmentManager();
            String s1 = TextUtils.isEmpty(albumSuggestedContentsRes$RESPONSE0.popupTitle) ? "이 앨범을 좋아하신 다면!" : albumSuggestedContentsRes$RESPONSE0.popupTitle;
            q.d(s1);
            com.melon.ui.popup.b.q(l00, s1, arrayList1, albumSuggestedContentsRes$RESPONSE0.menuId);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            boolean z = ((A0)this.getViewModel()).isLoginUser();
            g2 g20 = new g2(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 13);
            this.w.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.I, g20);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new h(0, this, k.class, "unselectAll", "unselectAll()V", 0, 0), new g2(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 14), false, 0x30);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, new Bd.e(this, 6));
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            a.f(this, l01, ((com.melon.ui.b)i40), this.getContext(), new g2(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 15));
            return;
        }
        if(i40 instanceof G4) {
            com.melon.ui.popup.b.k(this.getContext(), this.getParentFragmentManager(), 28);
            return;
        }
        if(i40 instanceof A4) {
            this.sendUserEvent(new com.melon.ui.m(((A4)i40).a, ((A4)i40).b, null, null, 0x30));
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            if(((x4)i40).c) {
                ((A0)this.getViewModel()).x(false);
            }
            return;
        }
        if(i40 instanceof C4) {
            this.sendUserEvent(new com.melon.ui.o(((C4)i40).a, "1000000563", null, 36));
            return;
        }
        if(i40 instanceof F4) {
            String s2 = ((A0)this.getViewModel()).getMenuId();
            g2 g21 = new g2(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 16);
            this.D.A(((F4)i40).a, this, s2, g21);
            return;
        }
        if(i40 instanceof z4) {
            this.sendUserEvent(new l(((z4)i40).a, ((z4)i40).b, null, 28));
            return;
        }
        if(i40 instanceof A) {
            MelonAppBase.Companion.getClass();
            if(!t.a().isCarConnected()) {
                Context context0 = this.requireContext();
                q.f(context0, "requireContext(...)");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                if(!((Ub.t)(((s)((k8.o)(((Ma.m)com.google.firebase.b.B(context1, Ma.m.class)))).z.get()))).f()) {
                    InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(((A)i40).a);
                    l0 l02 = this.getChildFragmentManager();
                    q.f(l02, "getChildFragmentManager(...)");
                    instantPlayPopup0.show(l02, "InstantPlayPopup");
                    return;
                }
            }
            ToastManager.show(i.k(this, 0x7F1304B4));  // string:instant_play_other_device "기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다."
            return;
        }
        if(i40 instanceof y) {
            this.sendUserEvent(new com.melon.ui.h(((y)i40).a, ((y)i40).b, null, 60));
            return;
        }
        if(i40 instanceof z) {
            this.sendUserEvent(new com.melon.ui.h(((z)i40).a, ((z)i40).b, null, 60));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // Hc.w
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        S s0 = (S)this.getBinding();
        if(s0 != null) {
            s0.f.setImportantForAccessibility(2);
            s0.d.setVisibility(8);
            g g0 = new g(0);
            s0.i.addItemDecoration(g0);
        }
        TitleBar titleBar0 = this.j;
        if(titleBar0 != null) {
            F8.I i0 = new F8.I(1, i.k(this, 0x7F130053));  // string:album "앨범"
            i0.c = new Ic.b(this, 1);
            F8.o o0 = B.a.s(7);
            o0.g(i0);
            titleBar0.a(o0);
            titleBar0.setTitle(((A0)this.getViewModel()).r());
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new j(this, null), 3, null);
    }

    @Override  // Hc.w
    public final void p(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderCommentCountUi() uiState: " + i.o(k40);
        LogU.info$default(this.G, s, null, false, 6, null);
        J8.d d0 = (J8.d)this.b;
        if(d0 != null) {
            x x0 = k40 instanceof x ? ((x)k40) : null;
            if(x0 != null) {
                N n0 = d0.g;
                String s1 = String.valueOf(x0.a);
                q.g(s1, "count");
                Context context0 = n0.c.getContext();
                q.f(context0, "getContext(...)");
                String s2 = Cb.k.a(context0, s1);
                n0.c.setText(s2);
                int v = 8;
                ((ImageView)n0.h).setVisibility((x0.b ? 0 : 8));
                ImageView imageView0 = (ImageView)n0.i;
                if(x0.c) {
                    v = 0;
                }
                imageView0.setVisibility(v);
                Ad.s s3 = new Ad.s(9, this, x0);
                ((ConstraintLayout)n0.f).setOnClickListener(s3);
            }
        }
    }

    @Override  // Hc.w
    public final void q(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderLikeUi() uiState: " + i.o(k40);
        LogU.info$default(this.G, s, null, false, 6, null);
        J8.d d0 = (J8.d)this.b;
        if(d0 != null) {
            Hc.P p0 = k40 instanceof Hc.P ? ((Hc.P)k40) : null;
            if(p0 != null) {
                ((CheckableImageView)d0.g.j).setChecked(p0.b);
                String s1 = String.valueOf(p0.a);
                q.g(s1, "count");
                Context context0 = d0.g.d.getContext();
                q.f(context0, "getContext(...)");
                String s2 = Cb.k.a(context0, s1);
                d0.g.d.setText(s2);
                String s3 = p0.b ? i.k(this, 0x7F130B5C) : i.k(this, 0x7F130B5B);  // string:talkback_like_off "좋아요 취소"
                ((CheckableImageView)d0.g.j).setContentDescription(s3);
            }
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        int v7;
        Ic.z z6;
        ImageView imageView4;
        MelonTextView melonTextView7;
        ConstraintLayout constraintLayout3;
        e3 e33;
        BorderImageView borderImageView0;
        Iterator iterator2;
        ConstraintLayout constraintLayout2;
        MelonTextView melonTextView6;
        RelativeLayout relativeLayout3;
        MelonTextView melonTextView5;
        int v3;
        int v2;
        int v1;
        List list1;
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + i.o(k40);
        LogU.info$default(this.G, s, null, false, 6, null);
        if(k40 instanceof Ic.z) {
            this.r(false);
            List list0 = ((Ic.z)k40).b;
            Ic.s s1 = ((Ic.z)k40).a;
            Context context0 = this.getContext();
            if(context0 == null) {
                z6 = (Ic.z)k40;
                list1 = list0;
            }
            else {
                J8.d d0 = (J8.d)this.b;
                if(d0 == null) {
                    z6 = (Ic.z)k40;
                    list1 = list0;
                }
                else {
                    RelativeLayout relativeLayout0 = d0.h;
                    ImageView imageView0 = d0.q;
                    ImageView imageView1 = d0.y;
                    MelonTextView melonTextView0 = d0.J;
                    list1 = list0;
                    MelonTextView melonTextView1 = d0.F;
                    e3 e30 = d0.C;
                    ConstraintLayout constraintLayout0 = d0.b;
                    ImageView imageView2 = d0.d;
                    MelonTextView melonTextView2 = d0.f;
                    MelonImageView melonImageView0 = d0.p;
                    MelonTextView melonTextView3 = d0.K;
                    ImageView imageView3 = d0.r;
                    RelativeLayout relativeLayout1 = d0.c;
                    k.w(((ViewComponentManager.FragmentContextWrapper)context0), e30);
                    k.w(((ViewComponentManager.FragmentContextWrapper)context0), d0.D);
                    k.w(((ViewComponentManager.FragmentContextWrapper)context0), d0.E);
                    MelonTextView melonTextView4 = d0.I;
                    ConstraintLayout constraintLayout1 = d0.a;
                    GradientDrawable.Orientation gradientDrawable$Orientation0 = GradientDrawable.Orientation.LEFT_RIGHT;
                    e3 e31 = d0.D;
                    int v = ColorUtils.getColor(context0, 0x7F06007D);  // color:color_00fcd5
                    e3 e32 = d0.E;
                    GradientDrawable gradientDrawable0 = new GradientDrawable(gradientDrawable$Orientation0, new int[]{v, ColorUtils.getColor(context0, 0x7F06007C)});  // color:color_00f969
                    gradientDrawable0.setCornerRadius(((float)ScreenUtils.dipToPixel(context0, 4.0f)));
                    d0.u.setBackground(gradientDrawable0);
                    Drawable drawable0 = d0.v.getBackground();
                    GradientDrawable gradientDrawable1 = drawable0 instanceof GradientDrawable ? ((GradientDrawable)drawable0) : null;
                    if(gradientDrawable1 != null) {
                        P4.a.B(gradientDrawable1, ColorUtils.getColor(context0, 0x7F060151), ScreenUtils.dipToPixel(context0, 4.0f));  // color:gray160e
                    }
                    boolean z = s1.k;
                    Ic.t t0 = s1.i;
                    String s2 = s1.B;
                    Ic.A a0 = s1.g;
                    String s3 = s1.l;
                    String s4 = s1.d;
                    ViewUtils.showWhen(d0.o, s1.b);
                    Ic.e e0 = new Ic.e(s1, 0);
                    d0.o.setOnClickListener(e0);
                    if(!Tf.o.H0(s4)) {
                        ViewUtils.showWhen(imageView3, true);
                        melonTextView0.setText(s4);
                        switch(s4) {
                            case "1M": 
                            case "2M": {
                                v1 = 0x7F0800AE;  // drawable:badge_millions_1_m_60
                                break;
                            }
                            case "3M": 
                            case "4M": {
                                v1 = 0x7F0800B0;  // drawable:badge_millions_3_m_60
                                break;
                            }
                            case "5M": 
                            case "6M": 
                            case "7M": 
                            case "8M": 
                            case "9M": {
                                v1 = 0x7F0800B2;  // drawable:badge_millions_5_m_60
                                break;
                            }
                            default: {
                                v1 = 0x7F0800AC;  // drawable:badge_millions_10_m_60
                            }
                        }
                        imageView3.setImageResource(v1);
                        for(Object object0: e.k.e(new View[]{melonTextView0, imageView3})) {
                            i.b(((View)object0), new Ic.e(s1, 1));
                        }
                    }
                    RelativeLayout relativeLayout2 = d0.A;
                    ViewUtils.showWhen(relativeLayout2, s1.f || s1.h);
                    if(s1.f) {
                        Drawable drawable1 = relativeLayout2.getBackground();
                        GradientDrawable gradientDrawable2 = drawable1 instanceof GradientDrawable ? ((GradientDrawable)drawable1) : null;
                        if(gradientDrawable2 != null) {
                            try {
                                v2 = Color.parseColor((a0.c.length() == 0 ? "#FFFFFF" : a0.c));
                            }
                            catch(Exception unused_ex) {
                                v2 = Color.parseColor("#FFFFFF");
                            }
                            gradientDrawable2.setColor(v2);
                        }
                        boolean z1 = a0.d.equals("WHITE");
                        imageView1.setBackgroundResource(0x7F08067C);  // drawable:img_spotlight_logo
                        imageView1.setBackgroundTintList(ColorUtils.getColorStateList(context0, (z1 ? 0x7F0604A0 : 0x7F06002F)));  // color:white
                        imageView0.setBackgroundTintList(ColorUtils.getColorStateList(context0, (z1 ? 0x7F0604A0 : 0x7F06002F)));  // color:white
                        relativeLayout2.setOnClickListener(new Ic.a(s1, this, 4));
                        ViewUtils.setContentDescriptionWithButtonClassName(relativeLayout2, i.k(this, 0x7F130C5D) + "," + i.k(this, 0x7F130B8E));  // string:talkback_spotlight "스포트라이트"
                    }
                    else {
                        Drawable drawable2 = relativeLayout2.getBackground();
                        GradientDrawable gradientDrawable3 = drawable2 instanceof GradientDrawable ? ((GradientDrawable)drawable2) : null;
                        if(gradientDrawable3 != null) {
                            try {
                                v3 = Color.parseColor((t0.c.length() == 0 ? "#FFFFFF" : t0.c));
                            }
                            catch(Exception unused_ex) {
                                v3 = Color.parseColor("#FFFFFF");
                            }
                            gradientDrawable3.setColor(v3);
                        }
                        boolean z2 = t0.d.equals("WHITE");
                        imageView1.setBackgroundResource(0x7F08063E);  // drawable:img_hirising_logo
                        imageView1.setBackgroundTintList(ColorUtils.getColorStateList(context0, (z2 ? 0x7F0604A0 : 0x7F06002F)));  // color:white
                        imageView0.setBackgroundTintList(ColorUtils.getColorStateList(context0, (z2 ? 0x7F0604A0 : 0x7F06002F)));  // color:white
                        relativeLayout2.setOnClickListener(new Ic.a(s1, this, 5));
                        ViewUtils.setContentDescriptionWithButtonClassName(relativeLayout2, i.k(this, 0x7F130B4C) + "," + i.k(this, 0x7F130B8E));  // string:talkback_hirising "하이라이징"
                    }
                    boolean z3 = MediaCodecInfoCompat.isAc4Supported() && s1.j;
                    d0.s.setVisibility((z3 ? 0 : 8));
                    n n0 = s1.a;
                    String s5 = n0.a;
                    RequestManager requestManager0 = Glide.with(melonImageView0);
                    ArrayList arrayList0 = n0.e;
                    requestManager0.load(n0.b).into(new u(melonImageView0, n0, 1));
                    if(s5.length() > 0) {
                        relativeLayout0.setVisibility(0);
                        J8.d d1 = (J8.d)this.b;
                        if(d1 == null) {
                            melonTextView5 = melonTextView3;
                            relativeLayout3 = relativeLayout1;
                            melonTextView6 = melonTextView4;
                            constraintLayout2 = constraintLayout1;
                        }
                        else {
                            d1.h.setVisibility(0);
                            d1.l.setText(s5);
                            d1.i.setText(s5);
                            melonTextView5 = melonTextView3;
                            relativeLayout3 = relativeLayout1;
                            melonTextView6 = melonTextView4;
                            constraintLayout2 = constraintLayout1;
                            Ic.d d2 = new Ic.d(this, d1.l, d1.k, s5, 0, 0);
                            d1.l.post(d2);
                            A6.b b0 = new A6.b(d1, 7);
                            d1.m.setOnClickListener(b0);
                        }
                    }
                    else {
                        melonTextView5 = melonTextView3;
                        relativeLayout3 = relativeLayout1;
                        melonTextView6 = melonTextView4;
                        constraintLayout2 = constraintLayout1;
                        relativeLayout0.setVisibility(8);
                    }
                    d0.L.setText(n0.d);
                    String s6 = i.k(this, 0x7F130B56);  // string:talkback_issue_date "발매일"
                    CharSequence charSequence0 = d0.L.getText();
                    d0.L.setContentDescription(s6 + " : " + charSequence0);
                    int v4 = 0;
                    Iterator iterator1 = p.K0(3, arrayList0).iterator();
                    while(iterator1.hasNext()) {
                        Object object1 = iterator1.next();
                        if(v4 >= 0) {
                            switch(v4) {
                                case 1: {
                                    iterator2 = iterator1;
                                    e33 = e32;
                                    constraintLayout3 = constraintLayout2;
                                    View view0 = constraintLayout3.findViewById(0x7F0A0B7B);  // id:thumb_layout2
                                    q.d(view0);
                                    view0.setVisibility(0);
                                    borderImageView0 = e31.b;
                                    break;
                                }
                                case 2: {
                                    constraintLayout3 = constraintLayout2;
                                    View view1 = constraintLayout3.findViewById(0x7F0A0B7C);  // id:thumb_layout3
                                    q.d(view1);
                                    iterator2 = iterator1;
                                    view1.setVisibility(0);
                                    e33 = e32;
                                    borderImageView0 = e33.b;
                                    break;
                                }
                                default: {
                                    iterator2 = iterator1;
                                    borderImageView0 = e30.b;
                                    e33 = e32;
                                    constraintLayout3 = constraintLayout2;
                                }
                            }
                            Glide.with(borderImageView0).load(((Ic.o)object1).c).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                            ++v4;
                            constraintLayout2 = constraintLayout3;
                            e32 = e33;
                            iterator1 = iterator2;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    melonTextView6.setText(ye.a.C(context0, arrayList0));
                    ViewUtils.setContentDescriptionWithButtonClassName(relativeLayout3, melonTextView6.getText());
                    relativeLayout3.setOnClickListener(new Ad.s(8, this, n0));
                    StringBuilder stringBuilder0 = new StringBuilder();
                    if(z) {
                        stringBuilder0.append(i.k(this, 0x7F130B77));  // string:talkback_masterpiece "명반"
                        stringBuilder0.append(",");
                    }
                    stringBuilder0.append(s5);
                    stringBuilder0.append(",");
                    stringBuilder0.append(i.k(this, 0x7F130AD0));  // string:talkback_album_image "앨범이미지"
                    stringBuilder0.append(",");
                    stringBuilder0.append(i.k(this, 0x7F130C89));  // string:talkback_zoom_in "크게보기"
                    stringBuilder0.append(",");
                    ViewUtils.setContentDescriptionWithButtonClassName(melonImageView0, stringBuilder0.toString());
                    d0.x.setVisibility((z ? 0 : 8));
                    if(s3.length() > 0) {
                        melonTextView5.setVisibility(0);
                        melonTextView5.setText(s3);
                        melonTextView5.setContentDescription(i.k(this, 0x7F130B9E) + " : " + melonTextView5.getText());  // string:talkback_music_sound_info "음원정보"
                    }
                    else {
                        melonTextView5.setVisibility(8);
                    }
                    d0.B.setTouchable(false);
                    Ic.a a1 = new Ic.a(s1, this, 0);
                    d0.w.setOnClickListener(a1);
                    melonImageView0.setOnClickListener(new Ic.a(s1, this, 1));
                    Ic.a a2 = new Ic.a(s1, this, 2);
                    ((ImageView)d0.g.g).setOnClickListener(a2);
                    Ic.b b1 = new Ic.b(this, 0);
                    ((CheckableImageView)d0.g.j).setOnClickListener(b1);
                    boolean z4 = s1.o.length() > 0 || s1.r.length() > 0 || s1.w.length() > 0;
                    boolean z5 = s2.length() > 0;
                    if(z4 || z5) {
                        constraintLayout0.setVisibility(0);
                        if(z4) {
                            melonTextView7 = melonTextView2;
                            melonTextView7.setVisibility(0);
                            melonTextView7.setOnClickListener(new Ic.a(this, s1));
                        }
                        else {
                            melonTextView7 = melonTextView2;
                            melonTextView7.setVisibility(8);
                        }
                        if(z5) {
                            melonTextView1.setVisibility(0);
                            melonTextView1.setText(Html.fromHtml(s2, 0));
                        }
                        else {
                            melonTextView1.setVisibility(8);
                        }
                    }
                    else {
                        constraintLayout0.setVisibility(8);
                        melonTextView7 = melonTextView2;
                    }
                    ViewUtils.setContentDescriptionWithButtonClassName(melonTextView7, melonTextView7.getText());
                    Ic.p p0 = s1.D;
                    LogU.debug$default(this.G, "drawHeaderUi() banner visible: " + p0.b, null, false, 6, null);
                    if(p0.b) {
                        imageView4 = imageView2;
                        imageView4.setVisibility(0);
                        Drawable drawable3 = imageView4.getBackground();
                        String s7 = p0.d;
                        int v5 = -1;
                        if(s7.length() > 0 && s7.length() == 6) {
                            try {
                                v5 = Color.parseColor(String.format("#%s", Arrays.copyOf(new Object[]{s7}, 1)));
                            }
                            catch(Exception unused_ex) {
                            }
                        }
                        if(v5 == -1) {
                            v5 = ColorUtils.getColor(this.getContext(), 0x7F06002C);  // color:bg_banner
                        }
                        drawable3.setTint(v5);
                        imageView4.setOnClickListener(new Ad.s(10, p0, this));
                        Glide.with(context0).load(p0.c).apply(RequestOptions.noAnimation()).into(imageView4);
                    }
                    else {
                        imageView4 = imageView2;
                        imageView4.setVisibility(8);
                    }
                    ViewUtils.setContentDescriptionWithButtonClassName(imageView4, i.k(this, 0x7F130ADA));  // string:talkback_banner "배너"
                    z6 = (Ic.z)k40;
                }
            }
            int v6 = z6.c;
            O o0 = this.m;
            if(o0 != null) {
                o0.c = v6;
                V.e(o0, list1);
                ArrayList arrayList1 = new ArrayList();
                for(Object object2: list1) {
                    if(object2 instanceof X) {
                        arrayList1.add(object2);
                    }
                }
                if(arrayList1.isEmpty()) {
                    v7 = 0;
                }
                else {
                    v7 = 0;
                    for(Object object3: arrayList1) {
                        if(((X)object3).M) {
                            ++v7;
                            if(v7 < 0) {
                                e.k.N();
                                throw null;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                this.v(v7);
                return;
            }
            q.m("adapter");
            throw null;
        }
        if(k40 instanceof r) {
            this.s(((r)k40).a);
            return;
        }
        if(k40 instanceof Ic.w) {
            this.t(((Ic.w)k40).a);
        }
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(I i0, String s, List list0, we.a a0, we.k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.B.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }

    public static final void w(ViewComponentManager.FragmentContextWrapper viewComponentManager$FragmentContextWrapper0, e3 e30) {
        int v = ScreenUtils.dipToPixel(viewComponentManager$FragmentContextWrapper0, 32.0f);
        ViewUtils.setDefaultImage(e30.c, v, true);
        int v1 = ScreenUtils.dipToPixel(viewComponentManager$FragmentContextWrapper0, 0.5f);
        e30.b.setBorderWidth(v1);
        int v2 = ColorUtils.getColor(viewComponentManager$FragmentContextWrapper0, 0x7F06014A);  // color:gray100a
        e30.b.setBorderColor(v2);
    }

    public final void x(K4 k40) {
        String s3;
        String s = "renderRatingUi() uiState: " + i.o(k40);
        LogU.info$default(this.G, s, null, false, 6, null);
        J8.d d0 = (J8.d)this.b;
        if(d0 != null) {
            Ic.y y0 = k40 instanceof Ic.y ? ((Ic.y)k40) : null;
            if(y0 != null) {
                String s1 = y0.a;
                float f = StringUtils.getFloat(s1);
                if(Float.compare(f, -1.0f) != 0) {
                    SmallRatingDetailView smallRatingDetailView0 = d0.B;
                    if(f > 4.9f) {
                        smallRatingDetailView0.a(10);
                    }
                    else if(f > 4.0f) {
                        smallRatingDetailView0.a(9);
                    }
                    else if(f > 3.9f) {
                        smallRatingDetailView0.a(8);
                    }
                    else if(f > 3.0f) {
                        smallRatingDetailView0.a(7);
                    }
                    else if(f > 2.9f) {
                        smallRatingDetailView0.a(6);
                    }
                    else if(f > 2.0f) {
                        smallRatingDetailView0.a(5);
                    }
                    else if(f > 1.9f) {
                        smallRatingDetailView0.a(4);
                    }
                    else if(f > 1.0f) {
                        smallRatingDetailView0.a(3);
                    }
                    else if(f > 0.9f) {
                        smallRatingDetailView0.a(2);
                    }
                    else if(f > 0.0f) {
                        smallRatingDetailView0.a(1);
                    }
                    else {
                        smallRatingDetailView0.a(0);
                    }
                }
                d0.G.setText(s1);
                String s2 = String.format(i.k(this, 0x7F130AD9), Arrays.copyOf(new Object[]{d0.G.getText()}, 1));  // string:talkback_average_scrore "평점 5점중 %s점"
                ViewUtils.setContentDescriptionWithButtonClassName(d0.G, s2);
                MelonTextView melonTextView0 = d0.H;
                Context context0 = melonTextView0.getContext();
                q.f(context0, "getContext(...)");
                Object[] arr_object = {Cb.k.a(context0, y0.b)};
                Context context1 = this.getContext();
                if(context1 == null) {
                    s3 = "";
                }
                else {
                    Resources resources0 = context1.getResources();
                    if(resources0 == null) {
                        s3 = "";
                    }
                    else {
                        s3 = resources0.getString(0x7F130A6F, Arrays.copyOf(arr_object, 1));  // string:song_detail_rate_partin "%s명"
                        if(s3 == null) {
                            s3 = "";
                        }
                    }
                }
                melonTextView0.setText(s3);
                melonTextView0.setContentDescription(i.k(this, 0x7F130BB0) + " : " + melonTextView0.getText());  // string:talkback_participant_of_given_avg "평점 참여자"
                Ad.s s4 = new Ad.s(7, this, y0);
                d0.z.setOnClickListener(s4);
            }
        }
    }
}

