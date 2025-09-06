package com.iloen.melon.fragments.comments;

import J8.K1;
import ad.o;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import c2.W;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MediaAttachmentView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.MoreExpandTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.custom.c0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.artistchannel.topic.TopicFragment;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.ATACHLIST;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.MYMEMBERINFO;
import com.iloen.melon.player.video.VideoCmtListFragment;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.W1;
import com.melon.ui.k2;
import d2.d;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.c;
import zd.M;
import zd.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u001A\u0010\u001BJ?\u0010#\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u00112\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020 H\u0002¢\u0006\u0004\b#\u0010$J\'\u0010&\u001A\u00020\u000B2\u0006\u0010%\u001A\u00020\u00112\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020 H\u0002¢\u0006\u0004\b&\u0010\'J\'\u0010(\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u00022\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020 H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalViewHolder;", "Lcom/iloen/melon/fragments/comments/CmtBaseViewHolder;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "LJ8/K1;", "binding", "Lcom/iloen/melon/fragments/comments/CmtBaseFragment;", "fragment", "<init>", "(LJ8/K1;Lcom/iloen/melon/fragments/comments/CmtBaseFragment;)V", "Lcom/iloen/melon/types/MediaAttachInfo;", "attachInfo", "Lie/H;", "playSong", "(Lcom/iloen/melon/types/MediaAttachInfo;)V", "info", "showContentPage", "(Lcom/iloen/melon/types/MediaAttachInfo;Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)V", "", "isAdcmtAvailable", "isRecmAvailable", "data", "setAccessibilityDelegate", "(ZZLcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)V", "updateExpandLayout", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)V", "isExpand", "setTextViewExpand", "(Z)V", "isEditable", "isFanTalk", "isPinUse", "isPinned", "", "adapterposition", "dataposition", "showContextPopupMore", "(ZZZZII)V", "hasUserLink", "profileClickEvent", "(ZII)V", "bindView", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;II)V", "LJ8/K1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentListRenewalViewHolder extends CmtBaseViewHolder {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentListRenewalViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "MAX_ATTACH_COUNT", "", "MAX_LINE_FOLD", "MAX_LINE_EXPAND", "POPUP_INDEX_MY_EDIT", "POPUP_INDEX_MY_DELETE", "POPUP_INDEX_MY_FIX", "POPUP_INDEX_REPORT", "POPUP_INDEX_FIX", "DETAIL_ITEM_PADDING_DEFAULT", "", "DETAIL_ITEM_PADDING_TOP", "DETAIL_ITEM_PADDING_TOP_FIRST_POSITION", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    public static final float DETAIL_ITEM_PADDING_TOP_FIRST_POSITION = 10.0f;
    public static final int MAX_ATTACH_COUNT = 999;
    public static final int MAX_LINE_EXPAND = 1000;
    public static final int MAX_LINE_FOLD = 5;
    public static final int POPUP_INDEX_FIX = 1;
    public static final int POPUP_INDEX_MY_DELETE = 1;
    public static final int POPUP_INDEX_MY_EDIT = 0;
    public static final int POPUP_INDEX_MY_FIX = 2;
    public static final int POPUP_INDEX_REPORT = 0;
    @NotNull
    private static final String TAG = "CommentListRenewalViewHolder";
    @NotNull
    private final K1 binding;

    static {
        CommentListRenewalViewHolder.Companion = new Companion(null);
        CommentListRenewalViewHolder.$stable = 8;
    }

    public CommentListRenewalViewHolder(@NotNull K1 k10, @Nullable CmtBaseFragment cmtBaseFragment0) {
        q.g(k10, "binding");
        super(k10.a, cmtBaseFragment0);
        this.binding = k10;
        int v = ScreenUtils.dipToPixel(this.getContext(), 28.0f);
        ViewUtils.setDefaultImage(((ImageView)k10.q.c), v, true);
    }

    public void bindView(@NotNull cmtList cmtResViewModel$result$cmtList0, int v, int v1) {
        boolean z17;
        com.iloen.melon.fragments.comments.q q0;
        int v4;
        boolean z16;
        boolean z15;
        q.g(cmtResViewModel$result$cmtList0, "info");
        if(this.isCmtResViewModelValid(cmtResViewModel$result$cmtList0) && this.isFragmentValid(this.getFragment())) {
            boolean z = this.getFragment().isLoadPgnResValid("bindView") ? this.getFragment().mLoadPgnRes.result.chnlinfo.adcmtuseflag : false;
            boolean z1 = this.getFragment().isLoadPgnResValid("bindView") ? this.getFragment().mLoadPgnRes.result.chnlinfo.recmuseflag : false;
            boolean z2 = cmtResViewModel$result$cmtList0.cmtinfo.ancmflag;
            String s = cmtResViewModel$result$cmtList0.memberinfo.memberkey;
            boolean z3 = cmtResViewModel$result$cmtList0.memberinfo.artistflag;
            boolean z4 = z3 || !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.k);
            boolean z5 = cmtResViewModel$result$cmtList0.cmtinfo.breakflag || cmtResViewModel$result$cmtList0.cmtinfo.delflag;
            boolean z6 = cmtResViewModel$result$cmtList0.cmtinfo.tempActFlag;
            boolean z7 = !cmtResViewModel$result$cmtList0.isReadOnly && !cmtResViewModel$result$cmtList0.cmtinfo.delflag && !cmtResViewModel$result$cmtList0.cmtinfo.ancmflag && cmtResViewModel$result$cmtList0.cmtinfo.membercmtflag && !z6;
            int v2 = cmtResViewModel$result$cmtList0.isReadOnly || z5 || z2 || !cmtResViewModel$result$cmtList0.reprtUseFlag || cmtResViewModel$result$cmtList0.cmtinfo.membercmtflag || StringIds.a(s, StringIds.i) || StringIds.a(s, StringIds.j) || StringIds.a(s, StringIds.k) || z6 ? 0 : 1;
            boolean z8 = !cmtResViewModel$result$cmtList0.isReadOnly && !z2 && z && !z6 && (this.getFragment() instanceof CmtListFragment || this.getFragment() instanceof TopicFragment);
            boolean z9 = !cmtResViewModel$result$cmtList0.isReadOnly && !z5 && !z2 && z1 && !z6;
            c c0 = this.getFragment().mParam.theme;
            boolean z10 = this.getFragment().mLoadPgnRes.result.chnlinfo.playFilterUseFlag;
            boolean z11 = cmtResViewModel$result$cmtList0.chnlseq == 101;
            MYMEMBERINFO loadPgnRes$result$MYMEMBERINFO0 = this.getFragment().mLoadPgnRes.result.myMemberInfo;
            boolean z12 = loadPgnRes$result$MYMEMBERINFO0 == null ? false : loadPgnRes$result$MYMEMBERINFO0.pinUseFlag;
            boolean z13 = cmtResViewModel$result$cmtList0.cmtinfo.pinnedFlag;
            boolean z14 = v1 == this.getFragment().getMelonArrayAdapter().getCount() - 1;
            if(v1 != 0 && !(this.getFragment() instanceof AdcmtListFragment)) {
                z15 = z10;
                int v6 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
                z16 = z4;
                int v7 = ScreenUtils.dipToPixel(this.getContext(), 22.0f);
                this.binding.a.setPadding(v6, v7, 0, 0);
                v4 = v2;
            }
            else {
                z15 = z10;
                z16 = z4;
                int v3 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
                v4 = v2;
                int v5 = ScreenUtils.dipToPixel(this.getContext(), 10.0f);
                this.binding.a.setPadding(v3, v5, 0, 0);
            }
            ViewUtils.hideWhen(this.binding.A, z14);
            if(z14 && this.getFragment().isFragmentAddable()) {
                int v8 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
                int v9 = ScreenUtils.dipToPixel(this.getContext(), 22.0f);
                int v10 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
                this.binding.a.setPadding(v8, v9, 0, v10);
            }
            if(z3) {
                Glide.with(this.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.artistimage).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)this.binding.q.d));
            }
            else {
                Glide.with(this.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.mypageimg).apply(RequestOptions.circleCropTransform()).into(((BorderImageView)this.binding.q.d));
            }
            ((BorderImageView)this.binding.q.d).setImportantForAccessibility(2);
            int v11 = ResourceUtils.getProfileBadgeColorId(z3, cmtResViewModel$result$cmtList0.memberinfo.memberDjIconType);
            if(v11 > -1) {
                this.binding.y.setText(this.getContext().getString((z3 ? 0x7F130136 : 0x7F130335)));  // string:artist_eng "ARTIST"
                int v12 = ColorUtils.getColor(this.getContext(), v11);
                this.binding.y.setTextColor(v12);
                this.binding.y.setVisibility(0);
            }
            else {
                this.binding.y.setVisibility(8);
            }
            a a0 = new a(z16, this, z3, cmtResViewModel$result$cmtList0, v, v1, 1);
            this.binding.v.setOnClickListener(a0);
            ((BorderImageView)this.binding.q.d).setOnClickListener(a0);
            ViewUtils.showWhen(this.binding.x, z13);
            if(z2) {
                this.binding.m.setImageResource(0x7F080591);  // drawable:ic_notice
                this.binding.m.setVisibility(0);
            }
            else if(cmtResViewModel$result$cmtList0.cmtinfo.bestflag) {
                this.binding.m.setImageResource(0x7F0803B4);  // drawable:ic_best
                this.binding.m.setVisibility(0);
            }
            else {
                this.binding.m.setVisibility(8);
            }
            String s1 = z3 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname;
            this.binding.v.setText(s1);
            int v13 = ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtNicknameColorResId(c0, z2));
            this.binding.v.setTextColor(v13);
            ViewUtils.showWhen(this.binding.e, cmtResViewModel$result$cmtList0.memberinfo.official);
            int v14 = cmtResViewModel$result$cmtList0.memberinfo.artistTemperature;
            this.binding.g.setText(String.valueOf(v14));
            ViewUtils.showWhen(this.binding.l, v14 > -1);
            if(v14 > -1) {
                int v15 = ResourceUtils.getFriendlyColorId(this.getContext(), v14);
                this.binding.g.setTextColor(v15);
                this.binding.h.setImageResource(ResourceUtils.get4dpDegreeImageResId(v14));
            }
            ViewUtils.showWhen(this.binding.f, z15 && cmtResViewModel$result$cmtList0.cmtinfo.playFlag);
            this.binding.t.setText(cmtResViewModel$result$cmtList0.cmtinfo.dsplyDate2);
            if(z6) {
                CmtBaseFragment cmtBaseFragment0 = this.getFragment();
                ViewUtils.setText(this.binding.o, cmtBaseFragment0.mLoadPgnRes.result.chnlinfo.tempActCmtDsplyText);
                b b0 = new b(this, 2);
                ViewUtils.setOnClickListener(this.binding.p, b0);
            }
            ViewUtils.showWhen(this.binding.i, z6);
            ViewUtils.showWhen(this.binding.u, !z6);
            String s2 = cmtResViewModel$result$cmtList0.cmtinfo.cmtcont;
            if(!TextUtils.isEmpty(s2)) {
                q.d(s2);
                Pattern pattern0 = Pattern.compile("\n");
                q.f(pattern0, "compile(...)");
                s2 = pattern0.matcher(s2).replaceAll("<br>");
                q.f(s2, "replaceAll(...)");
            }
            this.setTextViewExpand(cmtResViewModel$result$cmtList0.isContentExpand);
            Spanned spanned0 = Html.fromHtml(s2, 0);
            this.binding.u.setText(spanned0);
            com.iloen.melon.fragments.artistchannel.viewholder.c c1 = new com.iloen.melon.fragments.artistchannel.viewholder.c(z5, this, cmtResViewModel$result$cmtList0);
            this.binding.u.setOnClickListener(c1);
            this.binding.c.setEnabled(z7 || v4 != 0);
            p p0 = new p(this, z7, z11, z12, z13, v, v1, cmtResViewModel$result$cmtList0);
            x1.a.N(this.binding.c, p0);
            ViewUtils.hideWhen(this.binding.d, z2);
            String s3 = StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.recmcnt), 0xF423F);
            this.binding.z.setText(s3);
            this.binding.z.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag), 0, 0, 0);
            int v16 = ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag));
            this.binding.z.setTextColor(v16);
            ViewUtils.showWhen(this.binding.k, z9);
            MelonTextView melonTextView0 = this.binding.z;
            String s4 = null;
            if(z9) {
                z17 = z3;
                q0 = new com.iloen.melon.fragments.comments.q(cmtResViewModel$result$cmtList0, this, v, v1, z17, 0);
            }
            else {
                q0 = null;
                z17 = z3;
            }
            ViewUtils.setOnClickListener(melonTextView0, q0);
            String s5 = StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt), 0xF423F);
            this.binding.w.setText(s5);
            this.binding.w.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtNonRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag), 0, 0, 0);
            int v17 = ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtNonRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag));
            this.binding.w.setTextColor(v17);
            ViewUtils.showWhen(this.binding.k, z9);
            com.iloen.melon.fragments.comments.q q1 = z9 ? new com.iloen.melon.fragments.comments.q(cmtResViewModel$result$cmtList0, this, v, v1, z17, 1) : null;
            ViewUtils.setOnClickListener(this.binding.w, q1);
            String s6 = StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.validadcmtcnt), 0xF423F);
            this.binding.r.setText(s6);
            ViewUtils.showWhen(this.binding.j, z8);
            r r0 = new r(z8, this, cmtResViewModel$result$cmtList0, v, v1);
            CommentListRenewalViewHolderKt.setAllOnClickListener(this.binding.j, r0);
            if(cmtResViewModel$result$cmtList0.recommenderInfo == null) {
                ViewUtils.showWhen(this.binding.n, false);
            }
            else {
                ViewUtils.showWhen(this.binding.n, true);
                RecommenderView recommenderView0 = this.binding.n;
                MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = cmtResViewModel$result$cmtList0.recommenderInfo;
                if(cmtSharedTypeRes$CmtListBase$MEMBERINFO0 != null) {
                    s4 = cmtSharedTypeRes$CmtListBase$MEMBERINFO0.mypageimg;
                }
                recommenderView0.setProfileImage(s4);
            }
            this.binding.b.removeAllViews();
            if(cmtResViewModel$result$cmtList0.cmtinfo.atachcnt <= 0 || cmtResViewModel$result$cmtList0.atachlist == null) {
                ViewUtils.showWhen(this.binding.b, false);
            }
            else {
                ViewUtils.setEnable(this.binding.b, true);
                Iterator iterator0 = cmtResViewModel$result$cmtList0.atachlist.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = (ATACHLIST)object0;
                    if(this.binding.b.getCount() >= 999) {
                        LogU.Companion.w("CommentListRenewalViewHolder", "max attachment limit");
                        break;
                    }
                    String s7 = cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype;
                    if(!"image".equals(s7) && !"music_album".equals(s7) && !"music_artist".equals(s7) && !"music_song".equals(s7) && !"video".equals(s7) && !"link_video".equals(s7) && !"kakao_emoticon".equals(s7) && !"link_genrl".equals(s7)) {
                        com.iloen.melon.utils.a.v("not supported atachType:", s7, LogU.Companion, "CommentListRenewalViewHolder");
                    }
                    else {
                        MediaAttachInfo mediaAttachInfo0 = v9.b.a(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
                        if(mediaAttachInfo0 == null) {
                            LogU.Companion.w("CommentListRenewalViewHolder", "invalid MediaAttachInfo");
                        }
                        else {
                            mediaAttachInfo0.b = 1;
                            mediaAttachInfo0.W = c0;
                            this.binding.b.a(mediaAttachInfo0);
                            if(MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                                ViewUtils.setEnable(this.binding.b, !mediaAttachInfo0.Y);
                            }
                            com.iloen.melon.fragments.comments.CommentListRenewalViewHolder.bindView.12 commentListRenewalViewHolder$bindView$120 = new c0() {
                                @Override  // com.iloen.melon.custom.c0
                                public void onAttachmentBtnClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                    q.g(mediaAttachmentLayout0, "layout");
                                    q.g(mediaAttachmentView0, "view");
                                    cmtResViewModel$result$cmtList0.playSong(this);
                                }

                                @Override  // com.iloen.melon.custom.c0
                                public void onAttachmentClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                    q.g(mediaAttachmentLayout0, "layout");
                                    q.g(mediaAttachmentView0, "view");
                                    LogU.Companion.d("CommentListRenewalViewHolder", "onAttachmentClick type : " + this.a);
                                    cmtResViewModel$result$cmtList0.showContentPage(this, this.$info);
                                }

                                @Override  // com.iloen.melon.custom.c0
                                public void onAttachmentImageClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                    q.g(mediaAttachmentLayout0, "layout");
                                    q.g(mediaAttachmentView0, "view");
                                    LogU.Companion.d("CommentListRenewalViewHolder", "onAttachmentImageClick type : " + this.a);
                                    cmtResViewModel$result$cmtList0.showContentPage(this, this.$info);
                                }
                            };
                            this.binding.b.setOnAttachmentClickListener(commentListRenewalViewHolder$bindView$120);
                        }
                    }
                }
                if(this.binding.b.getCount() > 0) {
                    ViewUtils.showWhen(this.binding.b, true);
                    this.binding.b.setExpand(false);
                }
            }
            ViewUtils.showWhen(this.getMainContainer(), true);
            this.setContainerContentDescription(z17, s1, z11, z8, z9, cmtResViewModel$result$cmtList0, v1 + 1, this.getFragment().mLoadPgnRes.result.pageinfo.validcnt);
            this.setAccessibilityDelegate(z8, z9, cmtResViewModel$result$cmtList0);
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((cmtList)object0), v, v1);
    }

    private static final void bindView$lambda$1(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, boolean z1, cmtList cmtResViewModel$result$cmtList0, int v, int v1, View view0) {
        String s2;
        if(z) {
            CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
            ActionKind actionKind0 = ActionKind.ClickContent;
            String s = z1 ? l1.i(commentListRenewalViewHolder0, 0x7F130EF1) : l1.i(commentListRenewalViewHolder0, 0x7F130D82);  // string:tiara_meta_type_artist "아티스트"
            String s1 = null;
            if(z1) {
                s2 = String.valueOf(cmtResViewModel$result$cmtList0.memberinfo.artistid);
            }
            else {
                s2 = commentListRenewalViewHolder0.getFragment() instanceof TopicFragment ? String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq) : null;
            }
            if(z1) {
                s1 = l1.i(commentListRenewalViewHolder0, 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            }
            cmtBaseFragment0.contentsItemClickLog(actionKind0, s, s2, s1, (z1 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname));
        }
        if(!StringIds.a(cmtResViewModel$result$cmtList0.memberinfo.memberkey, StringIds.h)) {
            commentListRenewalViewHolder0.profileClickEvent(z, v, v1);
        }
    }

    private static final H bindView$lambda$10(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, cmtList cmtResViewModel$result$cmtList0, int v, int v1, View view0) {
        q.g(view0, "it");
        if(z) {
            CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
            String s = l1.i(commentListRenewalViewHolder0, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s1 = l1.i(commentListRenewalViewHolder0, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
            String s2 = l1.i(commentListRenewalViewHolder0, 0x7F130D17);  // string:tiara_click_copy_comment_reply "답글"
            cmtBaseFragment0.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), null, null);
            commentListRenewalViewHolder0.getFragment().openAdcmtView(v, v1, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
            CmtBaseFragment cmtBaseFragment1 = commentListRenewalViewHolder0.getFragment();
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment1);
        }
        return H.a;
    }

    private static final void bindView$lambda$5(CommentListRenewalViewHolder commentListRenewalViewHolder0, View view0) {
        Navigator.openUrl(commentListRenewalViewHolder0.getFragment().mLoadPgnRes.result.chnlinfo.tempActLinkUrlText, OpenType.FullScreenWithBar);
        CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
    }

    private static final void bindView$lambda$6(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, cmtList cmtResViewModel$result$cmtList0, View view0) {
        if(!z && view0 instanceof MoreExpandTextView && ((MoreExpandTextView)view0).j()) {
            commentListRenewalViewHolder0.updateExpandLayout(cmtResViewModel$result$cmtList0);
            ((MoreExpandTextView)view0).l = false;
            ((MoreExpandTextView)view0).k = false;
        }
    }

    private static final void bindView$lambda$7(CommentListRenewalViewHolder commentListRenewalViewHolder0, boolean z, boolean z1, boolean z2, boolean z3, int v, int v1, cmtList cmtResViewModel$result$cmtList0, View view0) {
        commentListRenewalViewHolder0.showContextPopupMore(z, z1, z2, z3, v, v1);
        CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
        String s = l1.i(commentListRenewalViewHolder0, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s1 = l1.i(commentListRenewalViewHolder0, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
        String s2 = l1.i(commentListRenewalViewHolder0, 0x7F130D54);  // string:tiara_click_copy_more "더보기"
        cmtBaseFragment0.itemClickLog(s, ActionKind.ClickContent, s1, s2, false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), null, null);
    }

    private static final void bindView$lambda$8(cmtList cmtResViewModel$result$cmtList0, CommentListRenewalViewHolder commentListRenewalViewHolder0, int v, int v1, boolean z, View view0) {
        if(cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag) {
            ToastManager.show(0x7F1301D7);  // string:cmt_already_nonrecm_msg "이미 비추천한 댓글입니다."
            return;
        }
        commentListRenewalViewHolder0.getFragment().recomCmt(v, v1, true, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
        CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
        String s = l1.i(commentListRenewalViewHolder0, 0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        String s1 = l1.i(commentListRenewalViewHolder0, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
        String s2 = l1.i(commentListRenewalViewHolder0, 0x7F130D8B);  // string:tiara_click_copy_recommend "추천"
        cmtBaseFragment0.itemClickLog(s, ActionKind.Like, s1, s2, true, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), null, (z ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname));
    }

    private static final void bindView$lambda$9(cmtList cmtResViewModel$result$cmtList0, CommentListRenewalViewHolder commentListRenewalViewHolder0, int v, int v1, boolean z, View view0) {
        if(cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) {
            ToastManager.show(0x7F1301D8);  // string:cmt_already_recm_msg "이미 추천한 댓글입니다."
            return;
        }
        commentListRenewalViewHolder0.getFragment().recomCmt(v, v1, false, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
        CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
        String s = l1.i(commentListRenewalViewHolder0, 0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        String s1 = l1.i(commentListRenewalViewHolder0, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
        String s2 = l1.i(commentListRenewalViewHolder0, 0x7F130D8B);  // string:tiara_click_copy_recommend "추천"
        cmtBaseFragment0.itemClickLog(s, ActionKind.Like, s1, s2, false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), null, (z ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname));
    }

    public static H f(cmtList cmtResViewModel$result$cmtList0, CommentListRenewalViewHolder commentListRenewalViewHolder0, int v, int v1, boolean z, View view0) {
        return CommentListRenewalViewHolder.bindView$lambda$10(z, commentListRenewalViewHolder0, cmtResViewModel$result$cmtList0, v, v1, view0);
    }

    public static void g(boolean z, CommentListRenewalViewHolder commentListRenewalViewHolder0, cmtList cmtResViewModel$result$cmtList0, View view0) {
        CommentListRenewalViewHolder.bindView$lambda$6(z, commentListRenewalViewHolder0, cmtResViewModel$result$cmtList0, view0);
    }

    private final void playSong(MediaAttachInfo mediaAttachInfo0) {
        if(MediaAttachType.c.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            CmtBaseFragment cmtBaseFragment0 = this.getFragment();
            String s = String.valueOf(mediaAttachInfo0.e);
            String s1 = l1.i(this, 0x7F130F01);  // string:tiara_meta_type_song "곡"
            cmtBaseFragment0.contentsItemClickLog(ActionKind.PlayMusic, null, s, s1, mediaAttachInfo0.j);
            this.getFragment().playSong(String.valueOf(mediaAttachInfo0.e), "1000000563", this.getFragment() instanceof VideoCmtListFragment);
        }
        CmtBaseFragment cmtBaseFragment1 = this.getFragment();
        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment1);
    }

    private final void profileClickEvent(boolean z, int v, int v1) {
        if(z) {
            this.getFragment().openUserView(v, v1);
            CmtBaseFragment cmtBaseFragment0 = this.getFragment();
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
        }
    }

    private final void setAccessibilityDelegate(boolean z, boolean z1, cmtList cmtResViewModel$result$cmtList0) {
        W.o(this.getMainContainer(), new c2.b() {
            @Override  // c2.b
            public void onInitializeAccessibilityNodeInfo(View view0, d d0) {
                q.g(view0, "host");
                q.g(d0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                if(this) {
                    d0.b(new d2.c(16, "답글 상세보기 및 답글 달기"));
                }
                d0.b(new d2.c(0x7F1302A0, "작성자 프로필로 이동"));  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                cmtList cmtResViewModel$result$cmtList0 = z1;
                if(cmtResViewModel$result$cmtList0.cmtinfo.atachcnt > 0) {
                    ArrayList arrayList0 = cmtResViewModel$result$cmtList0.atachlist;
                    if(arrayList0 != null) {
                        Iterator iterator0 = arrayList0.iterator();
                        q.f(iterator0, "iterator(...)");
                        while(iterator0.hasNext()) {
                            Object object0 = iterator0.next();
                            ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = (ATACHLIST)object0;
                            String s = cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype;
                            if("image".equals(s) || "music_album".equals(s) || "music_artist".equals(s) || "music_song".equals(s) || "video".equals(s) || "link_video".equals(s) || "kakao_emoticon".equals(s) || "link_genrl".equals(s)) {
                                MediaAttachInfo mediaAttachInfo0 = v9.b.a(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
                                if(mediaAttachInfo0 != null) {
                                    MediaAttachType mediaAttachType0 = mediaAttachInfo0.a;
                                    if(q.b(mediaAttachType0, MediaAttachType.g) || q.b(mediaAttachType0, MediaAttachType.f)) {
                                        d0.b(new d2.c(0x7F130294, "첨부된 이미지 크게보기"));  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.c) || q.b(mediaAttachType0, MediaAttachType.d)) {
                                        if(mediaAttachInfo0.Y) {
                                            continue;
                                        }
                                        d0.b(new d2.c(0x7F130278, "첨부된 음악 재생하기"));  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.h)) {
                                        d0.b(new d2.c(0x7F13027A, "첨부된 뮤직비디오 재생하기"));  // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.i)) {
                                        d0.b(new d2.c(0x7F130267, "첨부된 유튜브 링크로 이동하기"));  // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
                                    }
                                    else {
                                        if(q.b(mediaAttachType0, MediaAttachType.e)) {
                                            continue;
                                        }
                                        q.b(mediaAttachType0, MediaAttachType.k);
                                    }
                                }
                            }
                        }
                    }
                }
                if(this) {
                    d0.b(new d2.c(0x7F130288, "답글 상세보기 및 답글 달기"));  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                }
                if(this.$isRecmAvailable) {
                    if(z1.cmtinfo.memberrecmflag) {
                        d0.b(new d2.c(0x7F13029C, "추천 해제하기"));  // string:ctx_menu_unrecommend "추천 해제하기"
                    }
                    else {
                        d0.b(new d2.c(0x7F130285, "추천하기"));  // string:ctx_menu_recommend "추천하기"
                    }
                    if(z1.cmtinfo.membernonrecmflag) {
                        d0.b(new d2.c(0x7F13029A, "비추천 해제하기"));  // string:ctx_menu_unnonrecommend "비추천 해제하기"
                    }
                    else {
                        d0.b(new d2.c(0x7F13026E, "비추천하기"));  // string:ctx_menu_nonrecommend "비추천하기"
                    }
                }
                d0.b(new d2.c(0x7F130CA2, "더보기"));  // string:text_more "더보기"
            }

            @Override  // c2.b
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 0x7F130278: {  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                        List list1 = cmtResViewModel$result$cmtList0.binding.b.getAttachInfos();
                        q.f(list1, "getAttachInfos(...)");
                        MediaAttachInfo mediaAttachInfo1 = (MediaAttachInfo)je.p.m0(list1);
                        if(mediaAttachInfo1 == null) {
                            return true;
                        }
                        cmtResViewModel$result$cmtList0.playSong(mediaAttachInfo1);
                        return true;
                    }
                    case 16: 
                    case 0x7F130288: {  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                        cmtResViewModel$result$cmtList0.binding.s.performClick();
                        CmtBaseFragment cmtBaseFragment0 = cmtResViewModel$result$cmtList0.getFragment();
                        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
                        return true;
                    }
                    case 0x7F130267:   // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
                    case 0x7F13027A:   // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
                    case 0x7F130294: {  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                        List list0 = cmtResViewModel$result$cmtList0.binding.b.getAttachInfos();
                        q.f(list0, "getAttachInfos(...)");
                        MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)je.p.m0(list0);
                        if(mediaAttachInfo0 == null) {
                            return true;
                        }
                        cmtResViewModel$result$cmtList0.showContentPage(mediaAttachInfo0, z1);
                        return true;
                    }
                    case 0x7F13026E:   // string:ctx_menu_nonrecommend "비추천하기"
                    case 0x7F13029A: {  // string:ctx_menu_unnonrecommend "비추천 해제하기"
                        cmtResViewModel$result$cmtList0.binding.w.performClick();
                        return true;
                    }
                    case 0x7F130285:   // string:ctx_menu_recommend "추천하기"
                    case 0x7F13029C: {  // string:ctx_menu_unrecommend "추천 해제하기"
                        cmtResViewModel$result$cmtList0.binding.z.performClick();
                        return true;
                    }
                    case 0x7F1302A0: {  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                        ((BorderImageView)cmtResViewModel$result$cmtList0.binding.q.d).performClick();
                        CmtBaseFragment cmtBaseFragment1 = cmtResViewModel$result$cmtList0.getFragment();
                        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment1);
                        return true;
                    }
                    case 0x7F130CA2: {  // string:text_more "더보기"
                        cmtResViewModel$result$cmtList0.binding.c.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
    }

    private final void setTextViewExpand(boolean z) {
        this.binding.u.setMaxLines((z ? 1000 : 5));
        this.binding.u.setEllipsize((z ? null : TextUtils.TruncateAt.END));
        if(this.binding.b.getCount() > 1) {
            this.binding.b.setExpand(z);
        }
    }

    private final void showContentPage(MediaAttachInfo mediaAttachInfo0, cmtList cmtResViewModel$result$cmtList0) {
        if(MediaAttachType.c.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            CmtBaseFragment cmtBaseFragment0 = this.getFragment();
            String s = String.valueOf(mediaAttachInfo0.e);
            String s1 = l1.i(this, 0x7F130F01);  // string:tiara_meta_type_song "곡"
            cmtBaseFragment0.contentsItemClickLog(ActionKind.ClickContent, null, s, s1, mediaAttachInfo0.j);
            this.getFragment().showSongInfoPage(String.valueOf(mediaAttachInfo0.e));
        }
        else if(MediaAttachType.d.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            CmtBaseFragment cmtBaseFragment1 = this.getFragment();
            String s2 = String.valueOf(mediaAttachInfo0.c);
            String s3 = l1.i(this, 0x7F130EF0);  // string:tiara_meta_type_album "앨범"
            cmtBaseFragment1.contentsItemClickLog(ActionKind.ClickContent, null, s2, s3, mediaAttachInfo0.i);
            this.getFragment().showAlbumInfoPage(String.valueOf(mediaAttachInfo0.c));
        }
        else if(MediaAttachType.e.equals(mediaAttachInfo0.a)) {
            CmtBaseFragment cmtBaseFragment2 = this.getFragment();
            String s4 = String.valueOf(mediaAttachInfo0.d);
            String s5 = l1.i(this, 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
            cmtBaseFragment2.contentsItemClickLog(ActionKind.ClickContent, null, s4, s5, mediaAttachInfo0.k);
            this.getFragment().showArtistInfoPage(String.valueOf(mediaAttachInfo0.d));
        }
        else if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
            CmtBaseFragment cmtBaseFragment3 = this.getFragment();
            String s6 = String.valueOf(mediaAttachInfo0.f);
            String s7 = l1.i(this, 0x7F130EFE);  // string:tiara_meta_type_mv "영상"
            cmtBaseFragment3.contentsItemClickLog(ActionKind.ClickContent, null, s6, s7, mediaAttachInfo0.E);
            this.getFragment().showMvInfoPage(String.valueOf(mediaAttachInfo0.f), "1000000563");
        }
        else if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
            CmtBaseFragment cmtBaseFragment4 = this.getFragment();
            String s8 = l1.i(this, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s9 = l1.i(this, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
            cmtBaseFragment4.itemClickLog(s8, ActionKind.ClickContent, s9, null, false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), mediaAttachInfo0.h, null);
            Navigator.openUrl(mediaAttachInfo0.h, OpenType.Browser);
        }
        else if(!MediaAttachType.j.equals(mediaAttachInfo0.a)) {
            if(MediaAttachType.k.equals(mediaAttachInfo0.a)) {
                Navigator.openUrl(mediaAttachInfo0.h, OpenType.Browser);
            }
            else if(MediaAttachType.g.equals(mediaAttachInfo0.a)) {
                CmtBaseFragment cmtBaseFragment5 = this.getFragment();
                if(cmtBaseFragment5 != null) {
                    String s10 = l1.i(this, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s11 = l1.i(this, 0x7F130DEC);  // string:tiara_common_layer1_comment_list "댓글리스트"
                    cmtBaseFragment5.itemClickLog(s10, ActionKind.ClickContent, s11, null, false, String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.cmtseq), mediaAttachInfo0.h, null);
                }
                Navigator.INSTANCE.openPhotoUrl(false, mediaAttachInfo0.h, null);
            }
            else {
                LogU.Companion.w("CommentListRenewalViewHolder", "onAttachmentClick() unknown type:" + mediaAttachInfo0.a);
            }
        }
        CmtBaseFragment cmtBaseFragment6 = this.getFragment();
        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment6);
    }

    private final void showContextPopupMore(boolean z, boolean z1, boolean z2, boolean z3, int v, int v1) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        if(fragmentActivity0 != null) {
            com.melon.ui.popup.b.o(fragmentActivity0.getSupportFragmentManager(), new k(z, false), new o(this, v, v1, z3, 1), 12);
        }
    }

    private static final H showContextPopupMore$lambda$12$lambda$11(CommentListRenewalViewHolder commentListRenewalViewHolder0, int v, int v1, boolean z, k2 k20) {
        q.g(k20, "onEvent");
        if(k20 instanceof W1) {
            commentListRenewalViewHolder0.getFragment().reportCmt(v, v1, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
            CmtBaseFragment cmtBaseFragment0 = commentListRenewalViewHolder0.getFragment();
            BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment0);
            return H.a;
        }
        if(k20 instanceof com.melon.ui.K1) {
            switch(WhenMappings.$EnumSwitchMapping$0[((com.melon.ui.K1)k20).b.a.ordinal()]) {
                case 1: {
                    commentListRenewalViewHolder0.getFragment().removeCmt(v, v1, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
                    break;
                }
                case 2: {
                    commentListRenewalViewHolder0.getFragment().openCmtEditView(v, v1);
                    CmtBaseFragment cmtBaseFragment1 = commentListRenewalViewHolder0.getFragment();
                    BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment1);
                    return H.a;
                }
                case 3: {
                    commentListRenewalViewHolder0.getFragment().reportCmt(v, v1, commentListRenewalViewHolder0.getFragment().mParam.cacheKeyOfCmtList);
                    CmtBaseFragment cmtBaseFragment2 = commentListRenewalViewHolder0.getFragment();
                    BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(cmtBaseFragment2);
                    return H.a;
                }
                default: {
                    return H.a;
                }
            }
        }
        return H.a;
    }

    private final void updateExpandLayout(cmtList cmtResViewModel$result$cmtList0) {
        int v = !cmtResViewModel$result$cmtList0.isContentExpand;
        cmtResViewModel$result$cmtList0.isContentExpand = v;
        this.setTextViewExpand(((boolean)v));
    }
}

