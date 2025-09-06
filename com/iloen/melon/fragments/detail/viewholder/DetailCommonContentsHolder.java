package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Cb.k;
import De.I;
import J8.M;
import J8.N;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001E2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u001E\u001FB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0012\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0015\u001A\u00020\n2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u001B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder$ContentsData;", "LJ8/M;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/M;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lie/H;", "updateCmt", "()V", "", "actionName", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "clickCopy", "itemClickLog", "(Ljava/lang/String;Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/M;", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "informCmt", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "Companion", "ContentsData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailCommonContentsHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailCommonContentsHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0203, viewGroup0, false);  // layout:detail_common_contents
            int v = 0x7F0A02FE;  // id:common_contents
            View view1 = I.C(view0, 0x7F0A02FE);  // id:common_contents
            if(view1 != null) {
                N n0 = N.a(view1);
                if(((RelativeLayout)I.C(view0, 0x7F0A033E)) != null) {  // id:contents_container
                    return new DetailCommonContentsHolder(new M(((ConstraintLayout)view0), n0), onViewHolderActionBaseListener0);
                }
                v = 0x7F0A033E;  // id:contents_container
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u001F\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001A\u00020\u00052\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020\u0007HÖ\u0001R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder$ContentsData;", "", "songInfo", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "isLiked", "", "likeCnt", "", "commentInfo", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "<init>", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;ZLjava/lang/String;Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;)V", "getSongInfo", "()Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "setSongInfo", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;)V", "()Z", "setLiked", "(Z)V", "getLikeCnt", "()Ljava/lang/String;", "setLikeCnt", "(Ljava/lang/String;)V", "getCommentInfo", "()Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "setCommentInfo", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ContentsData {
        public static final int $stable = 8;
        @Nullable
        private CMTCONTSSUMM commentInfo;
        private boolean isLiked;
        @Nullable
        private String likeCnt;
        @Nullable
        private RESPONSE songInfo;

        public ContentsData() {
            this(null, false, null, null, 15, null);
        }

        public ContentsData(@Nullable RESPONSE songInfoRes$RESPONSE0, boolean z, @Nullable String s, @Nullable CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0) {
            this.songInfo = songInfoRes$RESPONSE0;
            this.isLiked = z;
            this.likeCnt = s;
            this.commentInfo = informCmtContsSummRes$result$CMTCONTSSUMM0;
        }

        public ContentsData(RESPONSE songInfoRes$RESPONSE0, boolean z, String s, CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                songInfoRes$RESPONSE0 = null;
            }
            if((v & 2) != 0) {
                z = false;
            }
            if((v & 4) != 0) {
                s = null;
            }
            if((v & 8) != 0) {
                informCmtContsSummRes$result$CMTCONTSSUMM0 = null;
            }
            this(songInfoRes$RESPONSE0, z, s, informCmtContsSummRes$result$CMTCONTSSUMM0);
        }

        @Nullable
        public final RESPONSE component1() {
            return this.songInfo;
        }

        public final boolean component2() {
            return this.isLiked;
        }

        @Nullable
        public final String component3() {
            return this.likeCnt;
        }

        @Nullable
        public final CMTCONTSSUMM component4() {
            return this.commentInfo;
        }

        @NotNull
        public final ContentsData copy(@Nullable RESPONSE songInfoRes$RESPONSE0, boolean z, @Nullable String s, @Nullable CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0) {
            return new ContentsData(songInfoRes$RESPONSE0, z, s, informCmtContsSummRes$result$CMTCONTSSUMM0);
        }

        public static ContentsData copy$default(ContentsData detailCommonContentsHolder$ContentsData0, RESPONSE songInfoRes$RESPONSE0, boolean z, String s, CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0, int v, Object object0) {
            if((v & 1) != 0) {
                songInfoRes$RESPONSE0 = detailCommonContentsHolder$ContentsData0.songInfo;
            }
            if((v & 2) != 0) {
                z = detailCommonContentsHolder$ContentsData0.isLiked;
            }
            if((v & 4) != 0) {
                s = detailCommonContentsHolder$ContentsData0.likeCnt;
            }
            if((v & 8) != 0) {
                informCmtContsSummRes$result$CMTCONTSSUMM0 = detailCommonContentsHolder$ContentsData0.commentInfo;
            }
            return detailCommonContentsHolder$ContentsData0.copy(songInfoRes$RESPONSE0, z, s, informCmtContsSummRes$result$CMTCONTSSUMM0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ContentsData)) {
                return false;
            }
            if(!q.b(this.songInfo, ((ContentsData)object0).songInfo)) {
                return false;
            }
            if(this.isLiked != ((ContentsData)object0).isLiked) {
                return false;
            }
            return q.b(this.likeCnt, ((ContentsData)object0).likeCnt) ? q.b(this.commentInfo, ((ContentsData)object0).commentInfo) : false;
        }

        @Nullable
        public final CMTCONTSSUMM getCommentInfo() {
            return this.commentInfo;
        }

        @Nullable
        public final String getLikeCnt() {
            return this.likeCnt;
        }

        @Nullable
        public final RESPONSE getSongInfo() {
            return this.songInfo;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = d.e((this.songInfo == null ? 0 : this.songInfo.hashCode()) * 0x1F, 0x1F, this.isLiked);
            int v2 = this.likeCnt == null ? 0 : this.likeCnt.hashCode();
            CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = this.commentInfo;
            if(informCmtContsSummRes$result$CMTCONTSSUMM0 != null) {
                v = informCmtContsSummRes$result$CMTCONTSSUMM0.hashCode();
            }
            return (v1 + v2) * 0x1F + v;
        }

        public final boolean isLiked() {
            return this.isLiked;
        }

        public final void setCommentInfo(@Nullable CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0) {
            this.commentInfo = informCmtContsSummRes$result$CMTCONTSSUMM0;
        }

        public final void setLikeCnt(@Nullable String s) {
            this.likeCnt = s;
        }

        public final void setLiked(boolean z) {
            this.isLiked = z;
        }

        public final void setSongInfo(@Nullable RESPONSE songInfoRes$RESPONSE0) {
            this.songInfo = songInfoRes$RESPONSE0;
        }

        @Override
        @NotNull
        public String toString() {
            return "ContentsData(songInfo=" + this.songInfo + ", isLiked=" + this.isLiked + ", likeCnt=" + this.likeCnt + ", commentInfo=" + this.commentInfo + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DetailCommonContentsHolder";
    @NotNull
    private M holderBind;
    @Nullable
    private CMTCONTSSUMM informCmt;

    static {
        DetailCommonContentsHolder.Companion = new Companion(null);
        DetailCommonContentsHolder.$stable = 8;
    }

    public DetailCommonContentsHolder(@NotNull M m0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(m0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(m0, onViewHolderActionBaseListener0);
        this.holderBind = m0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    private final void itemClickLog(String s, ActionKind actionKind0, String s1) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = s;
            f0.d = actionKind0;
            f0.y = this.getString(0x7F130E13);  // string:tiara_common_layer1_song_info "곡정보"
            f0.F = s1;
            f0.a().track();
        }
    }

    @NotNull
    public static final DetailCommonContentsHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return DetailCommonContentsHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        String s1;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        ContentsData detailCommonContentsHolder$ContentsData0 = (ContentsData)adapterInViewHolder$Row0.getItem();
        RESPONSE songInfoRes$RESPONSE0 = detailCommonContentsHolder$ContentsData0.getSongInfo();
        String s = "";
        if(detailCommonContentsHolder$ContentsData0.getLikeCnt() != null) {
            s1 = detailCommonContentsHolder$ContentsData0.getLikeCnt();
        }
        else if(songInfoRes$RESPONSE0 == null) {
            s1 = "";
        }
        else {
            s1 = songInfoRes$RESPONSE0.likeCnt;
            if(s1 == null) {
                s1 = "";
            }
        }
        this.informCmt = detailCommonContentsHolder$ContentsData0.getCommentInfo();
        this.updateCmt();
        MelonTextView melonTextView0 = this.holderBind.b.d;
        Context context0 = this.getContext();
        if(context0 != null) {
            String s2 = s1 == null ? null : k.a(context0, s1);
            if(s2 != null) {
                s = s2;
            }
        }
        melonTextView0.setText(s);
        ViewUtils.setOnClickListener(((CheckableImageView)this.holderBind.b.j), new com.iloen.melon.fragments.detail.viewholder.f(this, 0));
        if(((e0)o.a()).m()) {
            ((CheckableImageView)this.holderBind.b.j).setChecked(detailCommonContentsHolder$ContentsData0.isLiked());
        }
        else {
            ((CheckableImageView)this.holderBind.b.j).setChecked(false);
        }
        this.holderBind.b.b.setVisibility(0);
        if(songInfoRes$RESPONSE0 == null || (songInfoRes$RESPONSE0.songInfo == null || !songInfoRes$RESPONSE0.songInfo.canService)) {
            ViewUtils.setEnable(this.holderBind.b.b, false);
            this.holderBind.b.b.setOnClickListener(null);
        }
        else {
            ViewUtils.setOnClickListener(this.holderBind.b.b, new com.iloen.melon.fragments.detail.viewholder.f(this, 1));
        }
        ViewUtils.setOnClickListener(((ImageView)this.holderBind.b.g), new com.iloen.melon.fragments.detail.viewholder.f(this, 2));
        ViewUtils.setOnClickListener(((ConstraintLayout)this.holderBind.b.f), new com.iloen.melon.fragments.detail.viewholder.f(this, 3));
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$1(DetailCommonContentsHolder detailCommonContentsHolder0, View view0) {
        CheckableImageView checkableImageView0 = (CheckableImageView)detailCommonContentsHolder0.holderBind.b.j;
        q.f(checkableImageView0, "btnLiked");
        MelonTextView melonTextView0 = detailCommonContentsHolder0.holderBind.b.d;
        q.f(melonTextView0, "tvLikedCnt");
        detailCommonContentsHolder0.getOnViewHolderActionListener().onLikedListener(checkableImageView0, melonTextView0);
    }

    private static final void onBindView$lambda$2(DetailCommonContentsHolder detailCommonContentsHolder0, View view0) {
        detailCommonContentsHolder0.getOnViewHolderActionListener().onDownloadSong();
        String s = detailCommonContentsHolder0.getString(0x7F130DC2);  // string:tiara_common_action_buy "구매하기"
        String s1 = detailCommonContentsHolder0.getString(0x7F130DC5);  // string:tiara_common_action_name_download "다운로드"
        detailCommonContentsHolder0.itemClickLog(s, ActionKind.ClickContent, s1);
    }

    private static final void onBindView$lambda$3(DetailCommonContentsHolder detailCommonContentsHolder0, View view0) {
        detailCommonContentsHolder0.getOnViewHolderActionListener().onShowSharePopupListener();
        String s = detailCommonContentsHolder0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
        String s1 = detailCommonContentsHolder0.getString(0x7F130E27);  // string:tiara_common_layer2_doing_share "공유하기"
        detailCommonContentsHolder0.itemClickLog(s, ActionKind.Share, s1);
    }

    private static final void onBindView$lambda$4(DetailCommonContentsHolder detailCommonContentsHolder0, View view0) {
        detailCommonContentsHolder0.getOnViewHolderActionListener().onOpenCommentListView();
        String s = detailCommonContentsHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s1 = detailCommonContentsHolder0.getString(0x7F130D15);  // string:tiara_click_copy_comment_detail "댓글상세"
        detailCommonContentsHolder0.itemClickLog(s, ActionKind.ClickContent, s1);
    }

    private final void updateCmt() {
        String s1;
        MelonTextView melonTextView0 = this.holderBind.b.c;
        Context context0 = this.getContext();
        if(context0 == null) {
            s1 = "0";
        }
        else {
            CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = this.informCmt;
            if(informCmtContsSummRes$result$CMTCONTSSUMM0 == null) {
                s1 = null;
            }
            else {
                String s = informCmtContsSummRes$result$CMTCONTSSUMM0.validCmtCnt.toString();
                s1 = s == null ? null : k.a(context0, s);
            }
            if(s1 == null) {
                s1 = "0";
            }
        }
        melonTextView0.setText(s1);
        CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = this.informCmt;
        if(informCmtContsSummRes$result$CMTCONTSSUMM1 != null) {
            int v = 8;
            ((ImageView)this.holderBind.b.h).setVisibility((informCmtContsSummRes$result$CMTCONTSSUMM1.hotFlag ? 0 : 8));
            ImageView imageView0 = (ImageView)this.holderBind.b.i;
            if(informCmtContsSummRes$result$CMTCONTSSUMM1.newFlag) {
                v = 0;
            }
            imageView0.setVisibility(v);
        }
    }
}

