package com.iloen.melon.fragments.comments;

import J8.E1;
import Uc.n;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K1;
import com.melon.ui.W1;
import com.melon.ui.k2;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.c;
import zd.M;
import zd.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u0011\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\'\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/comments/AdCommentListRenewalViewHolder;", "Lcom/iloen/melon/fragments/comments/CmtBaseViewHolder;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "LJ8/E1;", "binding", "Lcom/iloen/melon/fragments/comments/CmtBaseFragment;", "fragment", "<init>", "(LJ8/E1;Lcom/iloen/melon/fragments/comments/CmtBaseFragment;)V", "Lie/H;", "setAccessibilityDelegate", "()V", "", "isEditable", "", "adapterposition", "dataposition", "showContextPopupMore", "(ZII)V", "hasUserLink", "profileClickEvent", "info", "bindView", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;II)V", "LJ8/E1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AdCommentListRenewalViewHolder extends CmtBaseViewHolder {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/comments/AdCommentListRenewalViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "MAX_ATTACH_COUNT", "", "POPUP_INDEX_MY_DELETE", "POPUP_INDEX_REPORT", "DETAIL_ITEM_PADDING_DEFAULT", "", "DETAIL_ITEM_PADDING_TOP", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[93] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[92] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[83] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final float DETAIL_ITEM_PADDING_DEFAULT = 20.0f;
    public static final float DETAIL_ITEM_PADDING_TOP = 22.0f;
    private static final int MAX_ATTACH_COUNT = 999;
    public static final int POPUP_INDEX_MY_DELETE = 0;
    public static final int POPUP_INDEX_REPORT = 0;
    @NotNull
    private static final String TAG = "AdCommentListRenewalViewHolder";
    @NotNull
    private final E1 binding;

    static {
        AdCommentListRenewalViewHolder.Companion = new Companion(null);
        AdCommentListRenewalViewHolder.$stable = 8;
    }

    public AdCommentListRenewalViewHolder(@NotNull E1 e10, @Nullable CmtBaseFragment cmtBaseFragment0) {
        q.g(e10, "binding");
        super(e10.a, cmtBaseFragment0);
        this.binding = e10;
        int v = ScreenUtils.dipToPixel(this.getContext(), 30.0f);
        ViewUtils.setDefaultImage(((ImageView)e10.l.c), v, true);
    }

    public void bindView(@NotNull cmtList cmtResViewModel$result$cmtList0, int v, int v1) {
        q.g(cmtResViewModel$result$cmtList0, "info");
        if(this.isCmtResViewModelValid(cmtResViewModel$result$cmtList0) && this.isFragmentValid(this.getFragment())) {
            boolean z = cmtResViewModel$result$cmtList0.cmtinfo.ancmflag;
            String s = cmtResViewModel$result$cmtList0.memberinfo.memberkey;
            boolean z1 = cmtResViewModel$result$cmtList0.memberinfo.artistflag;
            boolean z2 = false;
            boolean z3 = z1 || !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.k);
            boolean z4 = cmtResViewModel$result$cmtList0.cmtinfo.tempActFlag;
            boolean z5 = !cmtResViewModel$result$cmtList0.isReadOnly && !cmtResViewModel$result$cmtList0.cmtinfo.delflag && !cmtResViewModel$result$cmtList0.cmtinfo.ancmflag && cmtResViewModel$result$cmtList0.cmtinfo.membercmtflag && !z4;
            boolean z6 = !cmtResViewModel$result$cmtList0.isReadOnly && (!cmtResViewModel$result$cmtList0.cmtinfo.breakflag && !cmtResViewModel$result$cmtList0.cmtinfo.delflag) && !z && cmtResViewModel$result$cmtList0.reprtUseFlag && !cmtResViewModel$result$cmtList0.cmtinfo.membercmtflag && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.j) && !StringIds.a(s, StringIds.k) && !z4;
            c c0 = this.getFragment().mParam.theme;
            boolean z7 = this.getFragment().mLoadPgnRes.result.chnlinfo.playFilterUseFlag;
            boolean z8 = cmtResViewModel$result$cmtList0.chnlseq == 101;
            boolean z9 = cmtResViewModel$result$cmtList0.cmtinfo.pinnedFlag;
            int v2 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
            int v3 = ScreenUtils.dipToPixel(this.getContext(), 22.0f);
            this.binding.a.setPadding(v2, v3, 0, 0);
            boolean z10 = v1 == this.getFragment().getMelonArrayAdapter().getCount() - 1;
            ViewUtils.hideWhen(this.binding.r, z10);
            if(z1) {
                Glide.with(this.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.artistimage).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)this.binding.l.d));
            }
            else {
                Glide.with(this.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.mypageimg).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)this.binding.l.d));
            }
            ((BorderImageView)this.binding.l.d).setImportantForAccessibility(2);
            int v4 = ResourceUtils.getProfileBadgeColorId(z1, cmtResViewModel$result$cmtList0.memberinfo.memberDjIconType);
            if(v4 > -1) {
                this.binding.q.setText(this.getContext().getString((z1 ? 0x7F130136 : 0x7F130335)));  // string:artist_eng "ARTIST"
                int v5 = ColorUtils.getColor(this.getContext(), v4);
                this.binding.q.setTextColor(v5);
                this.binding.q.setVisibility(0);
            }
            else {
                this.binding.q.setVisibility(8);
            }
            a a0 = new a(z3, this, z1, cmtResViewModel$result$cmtList0, v, v1, 0);
            this.binding.o.setOnClickListener(a0);
            ((BorderImageView)this.binding.l.d).setOnClickListener(a0);
            ViewUtils.showWhen(this.binding.p, z9);
            if(z) {
                this.binding.i.setImageResource(0x7F080591);  // drawable:ic_notice
                this.binding.i.setVisibility(0);
            }
            else if(cmtResViewModel$result$cmtList0.cmtinfo.bestflag) {
                this.binding.i.setImageResource(0x7F0803B4);  // drawable:ic_best
                this.binding.i.setVisibility(0);
            }
            else {
                this.binding.i.setVisibility(8);
            }
            String s1 = z1 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname;
            this.binding.o.setText(s1);
            int v6 = ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtNicknameColorResId(c0, z));
            this.binding.o.setTextColor(v6);
            ViewUtils.showWhen(this.binding.c, cmtResViewModel$result$cmtList0.memberinfo.official);
            int v7 = cmtResViewModel$result$cmtList0.memberinfo.artistTemperature;
            this.binding.e.setText(String.valueOf(v7));
            ViewUtils.showWhen(this.binding.h, v7 > -1);
            if(v7 > -1) {
                int v8 = ResourceUtils.getFriendlyColorId(this.getContext(), v7);
                this.binding.e.setTextColor(v8);
                this.binding.f.setImageResource(ResourceUtils.get4dpDegreeImageResId(v7));
            }
            ViewUtils.showWhen(this.binding.d, z7 && cmtResViewModel$result$cmtList0.cmtinfo.playFlag);
            this.binding.m.setText(cmtResViewModel$result$cmtList0.cmtinfo.dsplyDate2);
            if(z4) {
                CmtBaseFragment cmtBaseFragment0 = this.getFragment();
                ViewUtils.setText(this.binding.j, cmtBaseFragment0.mLoadPgnRes.result.chnlinfo.tempActCmtDsplyText);
                b b0 = new b(this, 0);
                ViewUtils.setOnClickListener(this.binding.k, b0);
            }
            ViewUtils.showWhen(this.binding.g, z4);
            ViewUtils.showWhen(this.binding.n, !z4);
            Spanned spanned0 = Html.fromHtml(cmtResViewModel$result$cmtList0.cmtinfo.cmtcont, 0);
            this.binding.n.setText(spanned0);
            ImageView imageView0 = this.binding.b;
            if(z5 || z6) {
                z2 = true;
            }
            imageView0.setEnabled(z2);
            com.iloen.melon.fragments.comments.q q0 = new com.iloen.melon.fragments.comments.q(this, z5, v, v1, cmtResViewModel$result$cmtList0);
            x1.a.N(this.binding.b, q0);
            ViewUtils.showWhen(this.getMainContainer(), true);
            this.setContainerContentDescription(z1, s1, z8, false, false, cmtResViewModel$result$cmtList0, v1 + 1, this.getFragment().getMelonArrayAdapter().getCount());
            this.setAccessibilityDelegate();
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((cmtList)object0), v, v1);
    }

    private static final void bindView$lambda$1(boolean z, AdCommentListRenewalViewHolder adCommentListRenewalViewHolder0, boolean z1, cmtList cmtResViewModel$result$cmtList0, int v, int v1, View view0) {
        if(z) {
            CmtBaseFragment cmtBaseFragment0 = adCommentListRenewalViewHolder0.getFragment();
            ActionKind actionKind0 = ActionKind.ClickContent;
            adCommentListRenewalViewHolder0.getContext().getResources();
            String s = null;
            String s1 = z1 ? String.valueOf(cmtResViewModel$result$cmtList0.memberinfo.artistid) : null;
            if(z1) {
                s = "아티스트";
            }
            cmtBaseFragment0.contentsItemReplyClickLog(actionKind0, (z1 ? "아티스트" : "프로필"), s1, s, (z1 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname));
        }
        adCommentListRenewalViewHolder0.profileClickEvent(z, v, v1);
    }

    private static final void bindView$lambda$5(AdCommentListRenewalViewHolder adCommentListRenewalViewHolder0, View view0) {
        Navigator.openUrl(adCommentListRenewalViewHolder0.getFragment().mLoadPgnRes.result.chnlinfo.tempActLinkUrlText, OpenType.FullScreenWithBar);
        CmtBaseFragment cmtBaseFragment0 = adCommentListRenewalViewHolder0.getFragment();
        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
    }

    private static final void bindView$lambda$6(AdCommentListRenewalViewHolder adCommentListRenewalViewHolder0, boolean z, int v, int v1, cmtList cmtResViewModel$result$cmtList0, View view0) {
        adCommentListRenewalViewHolder0.showContextPopupMore(z, v, v1);
        adCommentListRenewalViewHolder0.getFragment().itemClickLog("페이지이동", ActionKind.ClickContent, "답글", "더보기", false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), null, null);
    }

    private final void profileClickEvent(boolean z, int v, int v1) {
        if(z) {
            this.getFragment().openUserView(v, v1);
        }
    }

    private final void setAccessibilityDelegate() {
        this.getMainContainer().setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F1302A0, "작성자 프로필로 이동"));  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130CA2, "더보기"));  // string:text_more "더보기"
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 0x7F1302A0: {  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                        ((BorderImageView)AdCommentListRenewalViewHolder.this.binding.l.d).performClick();
                        CmtBaseFragment cmtBaseFragment0 = AdCommentListRenewalViewHolder.this.getFragment();
                        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
                        return true;
                    }
                    case 0x7F130CA2: {  // string:text_more "더보기"
                        AdCommentListRenewalViewHolder.this.binding.b.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
    }

    private final void showContextPopupMore(boolean z, int v, int v1) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        if(fragmentActivity0 != null) {
            com.melon.ui.popup.b.o(fragmentActivity0.getSupportFragmentManager(), new k(z, true), new n(this, v, v1, 1), 12);
        }
    }

    private static final H showContextPopupMore$lambda$8$lambda$7(AdCommentListRenewalViewHolder adCommentListRenewalViewHolder0, int v, int v1, k2 k20) {
        q.g(k20, "onEvent");
        if(k20 instanceof W1) {
            adCommentListRenewalViewHolder0.getFragment().reportCmt(v, v1, "");
            return H.a;
        }
        if(k20 instanceof K1) {
            switch(WhenMappings.$EnumSwitchMapping$0[((K1)k20).b.a.ordinal()]) {
                case 1: {
                    CmtBaseFragment cmtBaseFragment0 = adCommentListRenewalViewHolder0.getFragment();
                    q.e(cmtBaseFragment0, "null cannot be cast to non-null type com.iloen.melon.fragments.comments.AdcmtListFragment");
                    ((AdcmtListFragment)cmtBaseFragment0).removeAdcmt(v, v1);
                    break;
                }
                case 3: {
                    adCommentListRenewalViewHolder0.getFragment().reportCmt(v, v1, "");
                    return H.a;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
    }
}

