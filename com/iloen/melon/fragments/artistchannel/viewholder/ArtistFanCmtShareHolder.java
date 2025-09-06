package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.s;
import De.I;
import J8.h;
import Td.b;
import U4.x;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import ie.m;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182 \u0012\u001C\u0012\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u00020\u0001:\u0001\u0018B!\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J/\u0010\u0013\u001A\u00020\u00122\u001E\u0010\u0011\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0002`\u00060\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001A\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0016\u0010\u0016\u001A\u00020\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lie/m;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE;", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolderItem;", "", "bbsChannelSeq", "LJ8/h;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(Ljava/lang/String;LJ8/h;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Ljava/lang/String;", "holderBind", "LJ8/h;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistFanCmtShareHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "bbsChannelSeq", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistFanCmtShareHolder newInstance(@Nullable String s, @NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0036, viewGroup0, false);  // layout:artist_detail_fan_cmt_share
            int v = 0x7F0A02F7;  // id:comment_cnt_tv
            View view1 = I.C(view0, 0x7F0A02F7);  // id:comment_cnt_tv
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A02F9;  // id:comment_layout
                View view2 = I.C(view0, 0x7F0A02F9);  // id:comment_layout
                if(((LinearLayout)view2) != null) {
                    v = 0x7F0A048D;  // id:fan_accd
                    View view3 = I.C(view0, 0x7F0A048D);  // id:fan_accd
                    if(((AlphaControlCheckButton)view3) != null) {
                        v = 0x7F0A048E;  // id:fan_cnt_tv
                        View view4 = I.C(view0, 0x7F0A048E);  // id:fan_cnt_tv
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A053F;  // id:hot_iv
                            View view5 = I.C(view0, 0x7F0A053F);  // id:hot_iv
                            if(((ImageView)view5) != null) {
                                v = 0x7F0A08AB;  // id:new_cmt_iv
                                View view6 = I.C(view0, 0x7F0A08AB);  // id:new_cmt_iv
                                if(((ImageView)view6) != null) {
                                    v = 0x7F0A0A83;  // id:share_iv
                                    View view7 = I.C(view0, 0x7F0A0A83);  // id:share_iv
                                    if(((ImageView)view7) != null) {
                                        return new ArtistFanCmtShareHolder(s, new h(((LinearLayout)view0), ((MelonTextView)view1), ((LinearLayout)view2), ((AlphaControlCheckButton)view3), ((MelonTextView)view4), ((ImageView)view5), ((ImageView)view6), ((ImageView)view7)), onViewHolderActionBaseListener0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistFanCmtShareHolder";
    @Nullable
    private final String bbsChannelSeq;
    @NotNull
    private h holderBind;

    static {
        ArtistFanCmtShareHolder.Companion = new Companion(null);
        ArtistFanCmtShareHolder.$stable = 8;
    }

    public ArtistFanCmtShareHolder(@Nullable String s, @NotNull h h0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(h0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(h0, onViewHolderActionBaseListener0);
        this.bbsChannelSeq = s;
        this.holderBind = h0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        RESPONSE artistHomeBasicInfoRes$RESPONSE0 = (RESPONSE)((m)adapterInViewHolder$Row0.getItem()).a;
        CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = (CMTCONTSSUMM)((m)adapterInViewHolder$Row0.getItem()).b;
        boolean z = q.b(artistHomeBasicInfoRes$RESPONSE0.fanYN, "Y");
        this.holderBind.d.setChecked(z);
        ViewUtils.setContentDescriptionWithButtonClassName(this.holderBind.d, this.getString((z ? 0x7F130B24 : 0x7F130B25)));  // string:talkback_fan_off "팬 해제하기"
        this.holderBind.e.setText(StringUtils.getCountString(artistHomeBasicInfoRes$RESPONSE0.fanCnt, 0x98967F));
        this.holderBind.b.setText(StringUtils.getCountString(artistHomeBasicInfoRes$RESPONSE0.fantalkCnt, 0x98967F));
        this.holderBind.d.setOnClickListener(new c(artistHomeBasicInfoRes$RESPONSE0, z, this, 0));
        this.holderBind.e.setOnClickListener(new s(16, this, artistHomeBasicInfoRes$RESPONSE0));
        ViewUtils.setContentDescriptionWithButtonClassName(this.holderBind.e, x.l(String.format(this.getString(0x7F130B23), Arrays.copyOf(new Object[]{this.holderBind.e.getText()}, 1)), ", ", this.getString(0x7F130B26), " ", this.getString(0x7F130B8B)));  // string:talkback_fan_count "%1$s명의 팬"
        this.holderBind.c.setOnClickListener(new s(17, this, adapterInViewHolder$Row0));
        String s = String.format(this.getString(0x7F130B28), Arrays.copyOf(new Object[]{this.holderBind.b.getText()}, 1));  // string:talkback_fantalk_count "%1$s개의 팬톡"
        if(informCmtContsSummRes$result$CMTCONTSSUMM0 != null) {
            if(informCmtContsSummRes$result$CMTCONTSSUMM0.newFlag) {
                this.holderBind.g.setVisibility(0);
                s = s + ", " + this.getString(0x7F130BA2);  // string:talkback_new_item "새로운 항목"
            }
            if(informCmtContsSummRes$result$CMTCONTSSUMM0.hotFlag) {
                this.holderBind.f.setVisibility(0);
                s = s + ", " + this.getString(0x7F130B4E);  // string:talkback_hot "hot"
            }
        }
        ViewUtils.setContentDescriptionWithButtonClassName(this.holderBind.c, s + ", " + this.getString(0x7F130433) + " " + this.getString(0x7F130B8B));  // string:fan_talk "팬톡"
        this.holderBind.h.setOnClickListener(new d(this));
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$10(ArtistFanCmtShareHolder artistFanCmtShareHolder0, View view0) {
        artistFanCmtShareHolder0.getOnViewHolderActionListener().onShowSharePopupListener();
        f f0 = artistFanCmtShareHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistFanCmtShareHolder0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
            f0.d = ActionKind.Share;
            f0.y = artistFanCmtShareHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.F = artistFanCmtShareHolder0.getString(0x7F130CCE);  // string:tiara_artist_copy_share "공유하기"
            f0.a().track();
        }
    }

    private static final void onBindView$lambda$2(RESPONSE artistHomeBasicInfoRes$RESPONSE0, boolean z, ArtistFanCmtShareHolder artistFanCmtShareHolder0, View view0) {
        String s = artistHomeBasicInfoRes$RESPONSE0.artistId;
        if(s != null) {
            artistFanCmtShareHolder0.getOnViewHolderActionListener().onRequestFanListener(s, !z);
        }
        if(!z) {
            MetaContentBaseFragment metaContentBaseFragment0 = artistFanCmtShareHolder0.getCurrentFragment();
            b.a((metaContentBaseFragment0 == null ? null : metaContentBaseFragment0.getActivity()));
            f f0 = artistFanCmtShareHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistFanCmtShareHolder0.getString(0x7F130DC6);  // string:tiara_common_action_name_fan_on "팬맺기"
                f0.d = ActionKind.Like;
                f0.y = artistFanCmtShareHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
                f0.F = artistFanCmtShareHolder0.getString(0x7F130CCC);  // string:tiara_artist_copy_fan_on "팬맺기"
                f0.a().track();
            }
        }
    }

    private static final void onBindView$lambda$5(ArtistFanCmtShareHolder artistFanCmtShareHolder0, RESPONSE artistHomeBasicInfoRes$RESPONSE0, View view0) {
        if(artistFanCmtShareHolder0.getOnViewHolderActionListener().onCheckLoginListener()) {
            String s = artistHomeBasicInfoRes$RESPONSE0.artistId;
            if(s != null) {
                Navigator.open(ArtistDetailFanListFragment.Companion.newInstance(s, artistHomeBasicInfoRes$RESPONSE0.artistName));
            }
            f f0 = artistFanCmtShareHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
            if(f0 != null) {
                f0.a = artistFanCmtShareHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = artistFanCmtShareHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
                f0.F = artistFanCmtShareHolder0.getString(0x7F130CCA);  // string:tiara_artist_copy_fan_list_detail "팬리스트상세"
                f0.a().track();
            }
        }
    }

    private static final void onBindView$lambda$7(ArtistFanCmtShareHolder artistFanCmtShareHolder0, AdapterInViewHolder.Row adapterInViewHolder$Row0, View view0) {
        Param cmtListFragment$Param0 = new Param();
        cmtListFragment$Param0.chnlSeq = artistFanCmtShareHolder0.bbsChannelSeq == null ? -1 : Integer.parseInt(artistFanCmtShareHolder0.bbsChannelSeq);
        cmtListFragment$Param0.contsRefValue = adapterInViewHolder$Row0.getContentId();
        cmtListFragment$Param0.theme = v9.c.c;
        cmtListFragment$Param0.showTitle = true;
        cmtListFragment$Param0.cacheKeyOfTargetPage = artistFanCmtShareHolder0.getCurrentFragment() == null ? null : "";
        Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
        f f0 = artistFanCmtShareHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistFanCmtShareHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistFanCmtShareHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.F = artistFanCmtShareHolder0.getString(0x7F130CCD);  // string:tiara_artist_copy_fan_talk "팬톡상세"
            f0.a().track();
        }
    }
}

