package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.K1;
import J8.a0;
import Tf.o;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MediaAttachmentView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.MoreExpandTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.custom.c0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.CmtResourceUtils;
import com.iloen.melon.fragments.comments.CommentListRenewalViewHolderKt;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.ATACHLIST;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.CMTINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
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
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import x1.a;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u0000 `2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003`abB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010!\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b#\u0010\"J9\u0010*\u001A\u00020\u000B2\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010&\u001A\u00020\u000E2\u0006\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b*\u0010+J\u0011\u0010-\u001A\u0004\u0018\u00010,H\u0002\u00A2\u0006\u0004\b-\u0010.J\'\u00102\u001A\u00020\u000B2\u0006\u0010/\u001A\u00020\u001A2\u0006\u00100\u001A\u00020\u00182\u0006\u00101\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\b2\u00103J\u0019\u00104\u001A\u00020\u001A2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0002\u00A2\u0006\u0004\b4\u00105J\u0019\u00108\u001A\u00020\u001A2\b\u00107\u001A\u0004\u0018\u000106H\u0002\u00A2\u0006\u0004\b8\u00109J\u001F\u0010;\u001A\u00020\u000B2\u0006\u0010:\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b;\u0010<J\u001F\u0010>\u001A\u00020\u000B2\u0006\u0010:\u001A\u00020\u001C2\u0006\u0010=\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b>\u0010?J9\u0010E\u001A\u00020\u000B2\u0006\u0010A\u001A\u00020@2\u0006\u0010B\u001A\u00020\u001A2\b\u0010C\u001A\u0004\u0018\u00010\u000E2\u0006\u0010D\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020\u000E2\u0006\u0010\u0017\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bG\u0010HJ\u001F\u0010J\u001A\u00020\u000B2\u0006\u0010:\u001A\u00020\u001C2\u0006\u0010I\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bJ\u0010<R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010K\u001A\u0004\bL\u0010MR\u0014\u0010O\u001A\u00020N8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u001C\u0010R\u001A\b\u0018\u00010QR\u00020\u00008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001A\u00020\u00038\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u00107\u001A\u0002068\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b7\u0010ZR\"\u0010[\u001A\u00020\u000E8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b[\u0010W\u001A\u0004\b\\\u0010\u0010\"\u0004\b]\u0010^R\u0016\u0010D\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010_\u00A8\u0006c"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "LJ8/a0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/a0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleTiaraLogName", "()Ljava/lang/String;", "getTitleName", "openCommentList", "()V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;", "vh", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "info", "", "position", "", "isLastPosition", "LJ8/K1;", "bindItem", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;IZ)LJ8/K1;", "Lcom/iloen/melon/types/MediaAttachInfo;", "attachInfo", "playSong", "(Lcom/iloen/melon/types/MediaAttachInfo;)V", "showContentPage", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "copy", "isLike", "cmtSeq", "author", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ZILjava/lang/String;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "hasUserLink", "adapterposition", "dataposition", "profileClickEvent", "(ZII)V", "isCmtResViewModelValid", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)Z", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "isLoadPgnResValid", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;)Z", "binding", "updateExpandLayout", "(LJ8/K1;Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)V", "isExpand", "setTextViewExpand", "(LJ8/K1;Z)V", "Landroid/view/View;", "rootView", "isArtist", "nickName", "isFanTalk", "setContainerContentDescription", "(Landroid/view/View;ZLjava/lang/String;ZLcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)V", "getAccessibilityRegdate", "(Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;)Ljava/lang/String;", "data", "setAccessibilityDelegate", "LJ8/a0;", "getBind", "()LJ8/a0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$InnerRecyclerAdapter;", "bbsChannelSeq", "I", "contentReferenceId", "Ljava/lang/String;", "item", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "customTitleText", "getCustomTitleText", "setCustomTitleText", "(Ljava/lang/String;)V", "Z", "Companion", "InnerRecyclerAdapter", "CommentHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class DetailCommentItemHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/K1;", "binding", "<init>", "(LJ8/K1;)V", "bind", "LJ8/K1;", "getBind", "()LJ8/K1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class CommentHolder extends O0 {
        @NotNull
        private final K1 bind;

        public CommentHolder(@NotNull K1 k10) {
            q.g(k10, "binding");
            super(k10.a);
            this.bind = k10;
        }

        @NotNull
        public final K1 getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$Companion;", "", "<init>", "()V", "TAG", "", "DETAIL_ITEM_PADDING_TOP", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailCommentItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0217, viewGroup0, false);  // layout:detail_item_comment
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09D0;  // id:recycler_vertical
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D0);  // id:recycler_vertical
                if(recyclerView0 != null) {
                    return new DetailCommentItemHolder(new a0(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001B\u0010\u0015\u001A\u00020\u00142\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;Landroid/content/Context;Ljava/util/List;)V", "", "position", "", "isLastPosition", "(I)Z", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;)V", "rawPosition", "onBindViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder$CommentHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((CommentHolder)o00));
        }

        public void initViewHolder(@NotNull CommentHolder detailCommentItemHolder$CommentHolder0) {
            q.g(detailCommentItemHolder$CommentHolder0, "vh");
            ((BorderImageView)detailCommentItemHolder$CommentHolder0.getBind().q.d).setImageDrawable(null);
            detailCommentItemHolder$CommentHolder0.getBind().v.setText("");
        }

        private final boolean isLastPosition(int v) {
            return v == this.getCount() - 1;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((CommentHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull CommentHolder detailCommentItemHolder$CommentHolder0, int v, int v1) {
            q.g(detailCommentItemHolder$CommentHolder0, "vh");
            this.initViewHolder(detailCommentItemHolder$CommentHolder0);
            cmtList cmtResViewModel$result$cmtList0 = (cmtList)this.getItem(v1);
            q.d(cmtResViewModel$result$cmtList0);
            boolean z = this.isLastPosition(v1);
            DetailCommentItemHolder.this.bindItem(detailCommentItemHolder$CommentHolder0, cmtResViewModel$result$cmtList0, v1, z);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public CommentHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return new CommentHolder(K1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final float DETAIL_ITEM_PADDING_TOP = 22.0f;
    @NotNull
    public static final String TAG = "DetailCommentItemHolder";
    private int bbsChannelSeq;
    @NotNull
    private final a0 bind;
    @NotNull
    private String contentReferenceId;
    @NotNull
    private String customTitleText;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    private boolean isFanTalk;
    private CmtResViewModel item;
    private LoadPgnRes loadPgnRes;
    @NotNull
    private final RecyclerView recyclerView;

    static {
        DetailCommentItemHolder.Companion = new Companion(null);
        DetailCommentItemHolder.$stable = 8;
    }

    public DetailCommentItemHolder(@NotNull a0 a00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(a00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(a00, onViewHolderActionBaseListener0);
        this.bind = a00;
        q.f(a00.c, "recyclerVertical");
        this.recyclerView = a00.c;
        this.contentReferenceId = "";
        this.customTitleText = "";
        this.setTitleView(a00.b);
        a00.c.setHasFixedSize(true);
        a00.c.setNestedScrollingEnabled(false);
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
        com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder.1 detailCommentItemHolder$10 = new r0() {
            private final int paddingTop;

            {
                this.paddingTop = ScreenUtils.dipToPixel(detailCommentItemHolder0.getContext(), 22.0f);
            }

            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                int v = recyclerView0.getChildAdapterPosition(view0);
                if(DetailCommentItemHolder.access$getInnerAdapter$p(DetailCommentItemHolder.this) != null) {
                    rect0.top = v == 0 ? 0 : this.paddingTop;
                }
            }
        };
        a00.c.addItemDecoration(detailCommentItemHolder$10);
    }

    public static final InnerRecyclerAdapter access$getInnerAdapter$p(DetailCommentItemHolder detailCommentItemHolder0) {
        return detailCommentItemHolder0.innerAdapter;
    }

    public static void b(DetailCommentItemHolder detailCommentItemHolder0, View view0) {
        DetailCommentItemHolder.bindItem$lambda$8(detailCommentItemHolder0, view0);
    }

    private final K1 bindItem(CommentHolder detailCommentItemHolder$CommentHolder0, cmtList cmtResViewModel$result$cmtList0, int v, boolean z) {
        boolean z15;
        boolean z10;
        boolean z9;
        boolean z2;
        boolean z1;
        K1 k10 = detailCommentItemHolder$CommentHolder0.getBind();
        if(!this.isCmtResViewModelValid(cmtResViewModel$result$cmtList0)) {
            return null;
        }
        ImageView imageView0 = k10.c;
        Group group0 = k10.j;
        Group group1 = k10.k;
        MelonTextView melonTextView0 = k10.g;
        MoreExpandTextView moreExpandTextView0 = k10.u;
        MelonTextView melonTextView1 = k10.v;
        MelonTextView melonTextView2 = k10.w;
        MelonTextView melonTextView3 = k10.y;
        BorderImageView borderImageView0 = (BorderImageView)k10.q.d;
        ImageView imageView1 = k10.m;
        RecommenderView recommenderView0 = k10.n;
        MelonTextView melonTextView4 = k10.z;
        MediaAttachmentLayout mediaAttachmentLayout0 = k10.b;
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 28.0f);
        ViewUtils.setDefaultImage(((ImageView)k10.q.c), v1, true);
        LoadPgnRes loadPgnRes0 = this.loadPgnRes;
        if(loadPgnRes0 != null) {
            if(this.isLoadPgnResValid(loadPgnRes0)) {
                LoadPgnRes loadPgnRes1 = this.loadPgnRes;
                if(loadPgnRes1 != null) {
                    z1 = loadPgnRes1.result.chnlinfo.adcmtuseflag;
                    goto label_28;
                }
                q.m("loadPgnRes");
                throw null;
            }
            else {
                z1 = false;
            }
        label_28:
            LoadPgnRes loadPgnRes2 = this.loadPgnRes;
            if(loadPgnRes2 != null) {
                if(this.isLoadPgnResValid(loadPgnRes2)) {
                    LoadPgnRes loadPgnRes3 = this.loadPgnRes;
                    if(loadPgnRes3 != null) {
                        z2 = loadPgnRes3.result.chnlinfo.recmuseflag;
                        goto label_38;
                    }
                    q.m("loadPgnRes");
                    throw null;
                }
                else {
                    z2 = false;
                }
            label_38:
                boolean z3 = cmtResViewModel$result$cmtList0.cmtinfo.ancmflag;
                String s = cmtResViewModel$result$cmtList0.memberinfo.memberkey;
                boolean z4 = cmtResViewModel$result$cmtList0.memberinfo.artistflag;
                boolean z5 = z4 || !StringIds.a(s, StringIds.c) && !StringIds.a(s, StringIds.i) && !StringIds.a(s, StringIds.k);
                CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = cmtResViewModel$result$cmtList0.cmtinfo;
                boolean z6 = cmtSharedTypeRes$CmtListBase$CMTINFO0.breakflag || cmtSharedTypeRes$CmtListBase$CMTINFO0.delflag;
                boolean z7 = cmtSharedTypeRes$CmtListBase$CMTINFO0.tempActFlag;
                boolean z8 = !cmtResViewModel$result$cmtList0.isReadOnly && !cmtSharedTypeRes$CmtListBase$CMTINFO0.delflag && !cmtSharedTypeRes$CmtListBase$CMTINFO0.ancmflag && cmtSharedTypeRes$CmtListBase$CMTINFO0.membercmtflag && !z7;
                if(cmtResViewModel$result$cmtList0.isReadOnly || z6 || z3) {
                    z9 = z8;
                    z10 = false;
                }
                else {
                    z9 = z8;
                    z10 = !cmtResViewModel$result$cmtList0.reprtUseFlag || cmtSharedTypeRes$CmtListBase$CMTINFO0.membercmtflag || StringIds.a(s, StringIds.i) || StringIds.a(s, StringIds.j) || StringIds.a(s, StringIds.k) || z7 ? false : true;
                }
                boolean z11 = !cmtResViewModel$result$cmtList0.isReadOnly && !z3 && z1 && !z7;
                boolean z12 = !cmtResViewModel$result$cmtList0.isReadOnly && !z6 && !z3 && z2 && !z7;
                LoadPgnRes loadPgnRes4 = this.loadPgnRes;
                if(loadPgnRes4 != null) {
                    boolean z13 = loadPgnRes4.result.chnlinfo.playFilterUseFlag;
                    boolean z14 = cmtResViewModel$result$cmtList0.chnlseq == 101;
                    if(z4) {
                        z15 = z14;
                        Glide.with(this.itemView.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.artistimage).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                    }
                    else {
                        z15 = z14;
                        Glide.with(this.itemView.getContext()).load(cmtResViewModel$result$cmtList0.memberinfo.mypageimg).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                    }
                    k10.A.setVisibility((z ? 8 : 0));
                    borderImageView0.setImportantForAccessibility(2);
                    int v2 = ResourceUtils.getProfileBadgeColorId(z4, cmtResViewModel$result$cmtList0.memberinfo.memberDjIconType);
                    if(v2 > -1) {
                        melonTextView3.setText(this.getString((z4 ? 0x7F130136 : 0x7F130335)));  // string:artist_eng "ARTIST"
                        melonTextView3.setTextColor(ColorUtils.getColor(this.getContext(), v2));
                        melonTextView3.setVisibility(0);
                    }
                    else {
                        melonTextView3.setVisibility(8);
                    }
                    b b0 = new b(z5, this, z4, cmtResViewModel$result$cmtList0, v);
                    melonTextView1.setOnClickListener(b0);
                    borderImageView0.setOnClickListener(b0);
                    v9.c c0 = v9.c.c;
                    if(z3) {
                        imageView1.setImageResource(0x7F080591);  // drawable:ic_notice
                        imageView1.setVisibility(0);
                    }
                    else if(cmtResViewModel$result$cmtList0.cmtinfo.bestflag) {
                        imageView1.setImageResource(0x7F0803B4);  // drawable:ic_best
                        imageView1.setVisibility(0);
                    }
                    else {
                        imageView1.setVisibility(8);
                    }
                    String s1 = z4 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname;
                    melonTextView1.setText(s1);
                    melonTextView1.setTextColor(ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtNicknameColorResId(c0, z3)));
                    ViewUtils.showWhen(k10.e, cmtResViewModel$result$cmtList0.memberinfo.official);
                    int v3 = cmtResViewModel$result$cmtList0.memberinfo.artistTemperature;
                    melonTextView0.setText(String.valueOf(v3));
                    ViewUtils.showWhen(k10.l, v3 > -1);
                    if(v3 > -1) {
                        melonTextView0.setTextColor(ResourceUtils.getFriendlyColorId(this.getContext(), v3));
                        k10.h.setImageResource(ResourceUtils.get4dpDegreeImageResId(v3));
                    }
                    ViewUtils.showWhen(k10.f, z13 && cmtResViewModel$result$cmtList0.cmtinfo.playFlag);
                    k10.t.setText(cmtResViewModel$result$cmtList0.cmtinfo.dsplyDate2);
                    if(z7) {
                        MelonTextView melonTextView5 = k10.o;
                        LoadPgnRes loadPgnRes5 = this.loadPgnRes;
                        if(loadPgnRes5 != null) {
                            ViewUtils.setText(melonTextView5, loadPgnRes5.result.chnlinfo.tempActCmtDsplyText);
                            A6.b b1 = new A6.b(this, 28);
                            ViewUtils.setOnClickListener(k10.p, b1);
                            goto label_111;
                        }
                        q.m("loadPgnRes");
                        throw null;
                    }
                label_111:
                    ViewUtils.showWhen(k10.i, z7);
                    ViewUtils.showWhen(moreExpandTextView0, !z7);
                    String s2 = cmtResViewModel$result$cmtList0.cmtinfo.cmtcont;
                    if(!TextUtils.isEmpty(s2)) {
                        q.d(s2);
                        Pattern pattern0 = Pattern.compile("\n");
                        q.f(pattern0, "compile(...)");
                        s2 = pattern0.matcher(s2).replaceAll("<br>");
                        q.f(s2, "replaceAll(...)");
                    }
                    this.setTextViewExpand(k10, cmtResViewModel$result$cmtList0.isContentExpand);
                    moreExpandTextView0.setText(Html.fromHtml(s2, 0));
                    moreExpandTextView0.setOnClickListener((View view0) -> if(!z6 && view0 instanceof MoreExpandTextView && ((MoreExpandTextView)view0).j()) {
                        this.updateExpandLayout(k10, cmtResViewModel$result$cmtList0);
                        ((MoreExpandTextView)view0).l = false;
                        ((MoreExpandTextView)view0).k = false;
                    });
                    imageView0.setEnabled(z9 || z10);
                    a.N(imageView0, new b(this, cmtResViewModel$result$cmtList0, v, z9, z15));
                    melonTextView4.setText(StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.recmcnt), 0xF423F));
                    melonTextView4.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag), 0, 0, 0);
                    melonTextView4.setTextColor(ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag)));
                    ViewUtils.showWhen(group1, z12);
                    ViewUtils.setOnClickListener(melonTextView4, new d(z12, cmtResViewModel$result$cmtList0, this, v, k10, 0));
                    melonTextView2.setText(StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt), 0xF423F));
                    melonTextView2.setCompoundDrawablesWithIntrinsicBounds(CmtResourceUtils.getCmtNonRecomCountIconResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag), 0, 0, 0);
                    melonTextView2.setTextColor(ColorUtils.getColor(this.getContext(), CmtResourceUtils.getCmtNonRecomCountColorResId(c0, cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag)));
                    ViewUtils.showWhen(group1, z12);
                    ViewUtils.setOnClickListener(melonTextView2, new d(z12, cmtResViewModel$result$cmtList0, this, v, k10, 1));
                    String s3 = StringUtils.getCountString(String.valueOf(cmtResViewModel$result$cmtList0.cmtinfo.validadcmtcnt), 0xF423F);
                    k10.r.setText(s3);
                    ViewUtils.showWhen(group0, z11);
                    CommentListRenewalViewHolderKt.setAllOnClickListener(group0, new e(z11, this, cmtResViewModel$result$cmtList0, v));
                    if(cmtResViewModel$result$cmtList0.recommenderInfo == null) {
                        ViewUtils.showWhen(recommenderView0, false);
                    }
                    else {
                        ViewUtils.showWhen(recommenderView0, true);
                        recommenderView0.setProfileImage((cmtResViewModel$result$cmtList0.recommenderInfo == null ? null : cmtResViewModel$result$cmtList0.recommenderInfo.mypageimg));
                    }
                    mediaAttachmentLayout0.removeAllViews();
                    if(cmtResViewModel$result$cmtList0.cmtinfo.atachcnt <= 0 || cmtResViewModel$result$cmtList0.atachlist == null) {
                        ViewUtils.showWhen(mediaAttachmentLayout0, false);
                    }
                    else {
                        ViewUtils.setEnable(mediaAttachmentLayout0, true);
                        Iterator iterator0 = cmtResViewModel$result$cmtList0.atachlist.iterator();
                        q.f(iterator0, "iterator(...)");
                        while(iterator0.hasNext()) {
                            Object object0 = iterator0.next();
                            ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = (ATACHLIST)object0;
                            if(mediaAttachmentLayout0.getCount() >= 999) {
                                break;
                            }
                            String s4 = cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype;
                            if(!"image".equals(s4) && !"music_album".equals(s4) && !"music_artist".equals(s4) && !"music_song".equals(s4) && !"video".equals(s4) && !"link_video".equals(s4) && !"kakao_emoticon".equals(s4) && !"link_genrl".equals(s4)) {
                                com.iloen.melon.utils.a.v("not supported atachType:", s4, LogU.Companion, "DetailCommentItemHolder");
                            }
                            else {
                                MediaAttachInfo mediaAttachInfo0 = v9.b.a(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
                                if(mediaAttachInfo0 != null) {
                                    mediaAttachInfo0.b = 1;
                                    mediaAttachInfo0.W = c0;
                                    mediaAttachmentLayout0.a(mediaAttachInfo0);
                                    if(MediaAttachType.c.equals(mediaAttachInfo0.a) || MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                                        ViewUtils.setEnable(mediaAttachmentLayout0, !mediaAttachInfo0.Y);
                                    }
                                    mediaAttachmentLayout0.setOnAttachmentClickListener(new c0() {
                                        @Override  // com.iloen.melon.custom.c0
                                        public void onAttachmentBtnClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                            q.g(mediaAttachmentLayout0, "layout");
                                            q.g(mediaAttachmentView0, "view");
                                            DetailCommentItemHolder.this.playSong(this);
                                        }

                                        @Override  // com.iloen.melon.custom.c0
                                        public void onAttachmentClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                            q.g(mediaAttachmentLayout0, "layout");
                                            q.g(mediaAttachmentView0, "view");
                                            LogU.Companion.d("DetailCommentItemHolder", "onAttachmentClick type : " + this.a);
                                            DetailCommentItemHolder.this.showContentPage(this);
                                        }

                                        @Override  // com.iloen.melon.custom.c0
                                        public void onAttachmentImageClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
                                            q.g(mediaAttachmentLayout0, "layout");
                                            q.g(mediaAttachmentView0, "view");
                                            LogU.Companion.d("DetailCommentItemHolder", "onAttachmentImageClick type : " + this.a);
                                            DetailCommentItemHolder.this.showContentPage(this);
                                        }
                                    });
                                }
                            }
                        }
                        if(mediaAttachmentLayout0.getCount() > 0) {
                            ViewUtils.showWhen(mediaAttachmentLayout0, true);
                            mediaAttachmentLayout0.setExpand(false);
                        }
                    }
                    q.f(k10.a, "getRoot(...)");
                    this.setContainerContentDescription(k10.a, z4, s1, z15, cmtResViewModel$result$cmtList0);
                    this.setAccessibilityDelegate(k10, cmtResViewModel$result$cmtList0);
                    return k10;
                }
                q.m("loadPgnRes");
                throw null;
            }
            q.m("loadPgnRes");
            throw null;
        }
        q.m("loadPgnRes");
        throw null;
    }

    private static final void bindItem$lambda$10(DetailCommentItemHolder detailCommentItemHolder0, cmtList cmtResViewModel$result$cmtList0, int v, boolean z, boolean z1, View view0) {
        String s = detailCommentItemHolder0.getString(0x7F130D54);  // string:tiara_click_copy_more "더보기"
        detailCommentItemHolder0.itemClickLog(ActionKind.ClickContent, s, false, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq, "");
        detailCommentItemHolder0.getOnViewHolderActionListener().onShowContextPopupCommentMore(detailCommentItemHolder0.getBindingAdapterPosition(), v, z, z1);
    }

    private static final void bindItem$lambda$11(boolean z, cmtList cmtResViewModel$result$cmtList0, DetailCommentItemHolder detailCommentItemHolder0, int v, K1 k10, View view0) {
        if(z) {
            if(cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag) {
                ToastManager.show(0x7F1301D7);  // string:cmt_already_nonrecm_msg "이미 비추천한 댓글입니다."
                return;
            }
            String s = detailCommentItemHolder0.getString(0x7F130D8B);  // string:tiara_click_copy_recommend "추천"
            detailCommentItemHolder0.itemClickLog(ActionKind.Like, s, true, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq, "");
            int v1 = detailCommentItemHolder0.getBindingAdapterPosition();
            q.f(k10.z, "tvCmtRecomCount");
            q.f(k10.n, "recommenderLayout");
            detailCommentItemHolder0.getOnViewHolderActionListener().onCommentRecommendListener(v1, v, true, k10.z, k10.n);
        }
    }

    private static final void bindItem$lambda$12(boolean z, cmtList cmtResViewModel$result$cmtList0, DetailCommentItemHolder detailCommentItemHolder0, int v, K1 k10, View view0) {
        if(z) {
            if(cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) {
                ToastManager.show(0x7F1301D8);  // string:cmt_already_recm_msg "이미 추천한 댓글입니다."
                return;
            }
            String s = detailCommentItemHolder0.getString(0x7F130D61);  // string:tiara_click_copy_not_recommend "비추천"
            detailCommentItemHolder0.itemClickLog(ActionKind.Like, s, false, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq, "");
            int v1 = detailCommentItemHolder0.getBindingAdapterPosition();
            q.f(k10.w, "tvCmtNonrecomCount");
            q.f(k10.n, "recommenderLayout");
            detailCommentItemHolder0.getOnViewHolderActionListener().onCommentRecommendListener(v1, v, false, k10.w, k10.n);
        }
    }

    private static final H bindItem$lambda$13(boolean z, DetailCommentItemHolder detailCommentItemHolder0, cmtList cmtResViewModel$result$cmtList0, int v, View view0) {
        q.g(view0, "it");
        if(z) {
            String s = detailCommentItemHolder0.getString(0x7F130D17);  // string:tiara_click_copy_comment_reply "답글"
            detailCommentItemHolder0.itemClickLog(ActionKind.ClickContent, s, false, cmtResViewModel$result$cmtList0.cmtinfo.cmtseq, "");
            detailCommentItemHolder0.getOnViewHolderActionListener().onOpenAdCommentView(detailCommentItemHolder0.getBindingAdapterPosition(), v);
        }
        return H.a;
    }

    private static final void bindItem$lambda$4(boolean z, DetailCommentItemHolder detailCommentItemHolder0, boolean z1, cmtList cmtResViewModel$result$cmtList0, int v, View view0) {
        if(z) {
            String s = detailCommentItemHolder0.getString((z1 ? 0x7F130EF1 : 0x7F130D82));  // string:tiara_meta_type_artist "아티스트"
            int v1 = cmtResViewModel$result$cmtList0.cmtinfo.cmtseq;
            String s1 = z1 ? cmtResViewModel$result$cmtList0.memberinfo.artistname : cmtResViewModel$result$cmtList0.memberinfo.membernickname;
            q.d(s1);
            detailCommentItemHolder0.itemClickLog(ActionKind.ClickContent, s, false, v1, s1);
        }
        detailCommentItemHolder0.profileClickEvent(z, detailCommentItemHolder0.getBindingAdapterPosition(), v);
    }

    private static final void bindItem$lambda$8(DetailCommentItemHolder detailCommentItemHolder0, View view0) {
        LoadPgnRes loadPgnRes0 = detailCommentItemHolder0.loadPgnRes;
        if(loadPgnRes0 != null) {
            Navigator.openUrl(loadPgnRes0.result.chnlinfo.tempActLinkUrlText, OpenType.FullScreenWithBar);
            return;
        }
        q.m("loadPgnRes");
        throw null;
    }

    // 检测为 Lambda 实现
    private static final void bindItem$lambda$9(boolean z, DetailCommentItemHolder detailCommentItemHolder0, K1 k10, cmtList cmtResViewModel$result$cmtList0, View view0) [...]

    public static void c(DetailCommentItemHolder detailCommentItemHolder0, cmtList cmtResViewModel$result$cmtList0, int v, boolean z, boolean z1, View view0) {
        DetailCommentItemHolder.bindItem$lambda$4(z, detailCommentItemHolder0, z1, cmtResViewModel$result$cmtList0, v, view0);
    }

    private final String getAccessibilityRegdate(cmtList cmtResViewModel$result$cmtList0) {
        String s = cmtResViewModel$result$cmtList0.cmtinfo.dsplydate;
        q.f(s, "dsplydate");
        List list0 = o.R0(s, new String[]{"."}, 0, 6);
        if(list0.size() == 3) {
            String s1 = ((String)list0.get(0)) + this.getString(0x7F131105) + " " + StringUtils.getNumberFromString(((String)list0.get(1))) + this.getString(0x7F1306AD) + " " + ((String)list0.get(2)) + this.getString(0x7F1302A4);  // string:year "년"
            q.d(s1);
            return s1;
        }
        String s2 = cmtResViewModel$result$cmtList0.cmtinfo.dsplydate;
        q.d(s2);
        return s2;
    }

    @NotNull
    public final a0 getBind() {
        return this.bind;
    }

    @NotNull
    public final String getCustomTitleText() {
        return this.customTitleText;
    }

    private final f getTiaraEventBuilder() {
        return this.getOnViewHolderActionListener().onTiaraEventBuilder();
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        if(this.isFanTalk) {
            return this.getString(0x7F1307CD);  // string:one_word "한마디"
        }
        String s = this.customTitleText;
        return s.length() == 0 ? this.getString(0x7F130212) : s;  // string:comments "댓글"
    }

    @Nullable
    public String getTitleTiaraLogName() {
        return this.getTitleName();
    }

    private final boolean isCmtResViewModelValid(cmtList cmtResViewModel$result$cmtList0) {
        if((cmtResViewModel$result$cmtList0 == null ? null : cmtResViewModel$result$cmtList0.cmtinfo) != null && cmtResViewModel$result$cmtList0.memberinfo != null) {
            return true;
        }
        LogU.Companion.w("DetailCommentItemHolder", "Invalid CmtResViewModel dataset!");
        return false;
    }

    private final boolean isLoadPgnResValid(LoadPgnRes loadPgnRes0) {
        if(loadPgnRes0 != null) {
            return loadPgnRes0.result == null ? false : loadPgnRes0.result.chnlinfo != null && loadPgnRes0.result.spaminfo != null;
        }
        return false;
    }

    private final void itemClickLog(ActionKind actionKind0, String s, boolean z, int v, String s1) {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            if(actionKind0 != null) {
                f0.d = actionKind0;
            }
            f0.y = this.getTitleTiaraLogName();
            if(s.length() > 0) {
                f0.F = s;
            }
            if(v > -1) {
                f0.e = String.valueOf(v);
            }
            if(s1.length() > 0) {
                f0.h = s1;
            }
            if(actionKind0 == ActionKind.Like) {
                f0.U = this.getString((z ? 0x7F130FCD : 0x7F130FCC));  // string:tiara_props_like "like"
            }
            f0.a().track();
        }
    }

    @NotNull
    public static final DetailCommentItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return DetailCommentItemHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        Object object0 = adapterInViewHolder$Row0.getItem();
        q.f(object0, "getItem(...)");
        this.item = (CmtResViewModel)object0;
        LoadPgnRes loadPgnRes0 = ((CmtResViewModel)object0).result.loadPgnRes;
        q.f(loadPgnRes0, "loadPgnRes");
        this.loadPgnRes = loadPgnRes0;
        result loadPgnRes$result0 = loadPgnRes0.result;
        if(loadPgnRes$result0 != null) {
            PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes$result0.pageinfo;
            if(loadPgnRes$result$PAGEINFO0 != null) {
                this.bbsChannelSeq = loadPgnRes$result$PAGEINFO0.chnlseq;
                String s = loadPgnRes$result$PAGEINFO0.contsrefvalue;
                q.f(s, "contsrefvalue");
                this.contentReferenceId = s;
            }
        }
        LoadPgnRes loadPgnRes1 = this.loadPgnRes;
        List list0 = null;
        if(loadPgnRes1 != null) {
            this.isFanTalk = loadPgnRes1.result != null && (loadPgnRes1.result.chnlinfo != null && loadPgnRes1.result.chnlinfo.chnlseq == 101);
            CmtResViewModel cmtResViewModel0 = this.item;
            if(cmtResViewModel0 != null) {
                int v = cmtResViewModel0.result.totalCount;
                String s1 = this.getTitleName();
                MainTabTitleView mainTabTitleView0 = this.getTitleView();
                if(mainTabTitleView0 != null) {
                    mainTabTitleView0.setTitle(s1 + " " + StringUtils.getCountString(v, 0x98967F));
                    mainTabTitleView0.setTitleClickable(true);
                    mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                        @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                        public void onViewAllButtonClick(View view0) {
                            q.g(view0, "view");
                            String s = DetailCommentItemHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                            DetailCommentItemHolder.this.itemClickLog(null, s, false, -1, "");
                            DetailCommentItemHolder.this.openCommentList();
                        }
                    });
                    if(this.isFanTalk) {
                        ViewUtilsKt.setMarginToDp(mainTabTitleView0, 0.0f, 0.0f, 0.0f, 0.0f);
                        mainTabTitleView0.setTitleTextSize(18.0f);
                    }
                }
                CmtResViewModel cmtResViewModel1 = this.item;
                if(cmtResViewModel1 != null) {
                    com.iloen.melon.net.v3x.comments.CmtResViewModel.result cmtResViewModel$result0 = cmtResViewModel1.result;
                    if(cmtResViewModel$result0 != null) {
                        ArrayList arrayList0 = cmtResViewModel$result0.cmtlist;
                        if(arrayList0 != null) {
                            InnerRecyclerAdapter detailCommentItemHolder$InnerRecyclerAdapter0 = this.innerAdapter;
                            if(detailCommentItemHolder$InnerRecyclerAdapter0 != null) {
                                list0 = detailCommentItemHolder$InnerRecyclerAdapter0.getList();
                            }
                            if(q.b(list0, arrayList0)) {
                                InnerRecyclerAdapter detailCommentItemHolder$InnerRecyclerAdapter2 = this.innerAdapter;
                                if(detailCommentItemHolder$InnerRecyclerAdapter2 != null) {
                                    detailCommentItemHolder$InnerRecyclerAdapter2.notifyItemRangeChanged(0, arrayList0.size());
                                }
                            }
                            else {
                                this.recyclerView.setAdapter(this.innerAdapter);
                                InnerRecyclerAdapter detailCommentItemHolder$InnerRecyclerAdapter1 = this.innerAdapter;
                                if(detailCommentItemHolder$InnerRecyclerAdapter1 != null) {
                                    detailCommentItemHolder$InnerRecyclerAdapter1.setItems(p.P0(arrayList0));
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }
                q.m("item");
                throw null;
            }
            q.m("item");
            throw null;
        }
        q.m("loadPgnRes");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void openCommentList() {
        Param cmtListFragment$Param0 = new Param();
        cmtListFragment$Param0.chnlSeq = this.bbsChannelSeq;
        cmtListFragment$Param0.contsRefValue = this.contentReferenceId;
        cmtListFragment$Param0.theme = v9.c.c;
        cmtListFragment$Param0.showTitle = true;
        cmtListFragment$Param0.cacheKeyOfTargetPage = this.getCurrentFragment() == null ? null : "";
        if(this.customTitleText.length() > 0) {
            cmtListFragment$Param0.headerTitle = this.customTitleText;
        }
        this.getOnViewHolderActionListener().onOpenCommentListView(cmtListFragment$Param0);
    }

    private final void playSong(MediaAttachInfo mediaAttachInfo0) {
        if(MediaAttachType.c.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            MetaContentBaseFragment metaContentBaseFragment0 = this.getCurrentFragment();
            if(metaContentBaseFragment0 != null) {
                metaContentBaseFragment0.playSong(String.valueOf(mediaAttachInfo0.e), "1000000563", this.getCurrentFragment() instanceof VideoCmtListFragment);
            }
        }
    }

    private final void profileClickEvent(boolean z, int v, int v1) {
        if(z) {
            this.getOnViewHolderActionListener().onOpenUserView(v, v1);
        }
    }

    private final void setAccessibilityDelegate(K1 k10, cmtList cmtResViewModel$result$cmtList0) {
        com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder.setAccessibilityDelegate.1 detailCommentItemHolder$setAccessibilityDelegate$10 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, cmtResViewModel$result$cmtList0.getString(0x7F130288)));  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F1302A0, cmtResViewModel$result$cmtList0.getString(0x7F1302A0)));  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                cmtList cmtResViewModel$result$cmtList0 = k10;
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
                                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130294, cmtResViewModel$result$cmtList0.getString(0x7F130294)));  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.c) || q.b(mediaAttachType0, MediaAttachType.d)) {
                                        if(mediaAttachInfo0.Y) {
                                            continue;
                                        }
                                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130278, cmtResViewModel$result$cmtList0.getString(0x7F130278)));  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.h)) {
                                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13027A, cmtResViewModel$result$cmtList0.getString(0x7F13027A)));  // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
                                    }
                                    else if(q.b(mediaAttachType0, MediaAttachType.i)) {
                                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130267, cmtResViewModel$result$cmtList0.getString(0x7F130267)));  // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
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
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130288, cmtResViewModel$result$cmtList0.getString(0x7F130288)));  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                if(k10.cmtinfo.memberrecmflag) {
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13029C, cmtResViewModel$result$cmtList0.getString(0x7F13029C)));  // string:ctx_menu_unrecommend "추천 해제하기"
                }
                else {
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130285, cmtResViewModel$result$cmtList0.getString(0x7F130285)));  // string:ctx_menu_recommend "추천하기"
                }
                if(k10.cmtinfo.membernonrecmflag) {
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13029A, cmtResViewModel$result$cmtList0.getString(0x7F13029A)));  // string:ctx_menu_unnonrecommend "비추천 해제하기"
                }
                else {
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F13026E, cmtResViewModel$result$cmtList0.getString(0x7F13026E)));  // string:ctx_menu_nonrecommend "비추천하기"
                }
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130CA2, cmtResViewModel$result$cmtList0.getString(0x7F130CA2)));  // string:text_more "더보기"
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 0x7F130278: {  // string:ctx_menu_play_music_attachment "첨부된 음악 재생하기"
                        List list1 = this.$binding.b.getAttachInfos();
                        q.f(list1, "getAttachInfos(...)");
                        MediaAttachInfo mediaAttachInfo1 = (MediaAttachInfo)p.m0(list1);
                        if(mediaAttachInfo1 == null) {
                            return true;
                        }
                        cmtResViewModel$result$cmtList0.playSong(mediaAttachInfo1);
                        return true;
                    }
                    case 16: 
                    case 0x7F130288: {  // string:ctx_menu_replay "답글 상세보기 및 답글 달기"
                        this.$binding.s.performClick();
                        return true;
                    }
                    case 0x7F130267:   // string:ctx_menu_move_youtube_attachment "첨부된 유튜브 링크로 이동하기"
                    case 0x7F13027A:   // string:ctx_menu_play_video_attachment "첨부된 뮤직비디오 재생하기"
                    case 0x7F130294: {  // string:ctx_menu_show_image_attachment "첨부된 이미지 크게보기"
                        List list0 = this.$binding.b.getAttachInfos();
                        q.f(list0, "getAttachInfos(...)");
                        MediaAttachInfo mediaAttachInfo0 = (MediaAttachInfo)p.m0(list0);
                        if(mediaAttachInfo0 == null) {
                            return true;
                        }
                        cmtResViewModel$result$cmtList0.showContentPage(mediaAttachInfo0);
                        return true;
                    }
                    case 0x7F13026E:   // string:ctx_menu_nonrecommend "비추천하기"
                    case 0x7F13029A: {  // string:ctx_menu_unnonrecommend "비추천 해제하기"
                        this.$binding.w.performClick();
                        return true;
                    }
                    case 0x7F130285:   // string:ctx_menu_recommend "추천하기"
                    case 0x7F13029C: {  // string:ctx_menu_unrecommend "추천 해제하기"
                        this.$binding.z.performClick();
                        return true;
                    }
                    case 0x7F1302A0: {  // string:ctx_menu_writer_page "작성자 프로필로 이동"
                        ((BorderImageView)this.$binding.q.d).performClick();
                        return true;
                    }
                    case 0x7F130CA2: {  // string:text_more "더보기"
                        this.$binding.c.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        k10.a.setAccessibilityDelegate(detailCommentItemHolder$setAccessibilityDelegate$10);
    }

    // This method was un-flattened
    private final void setContainerContentDescription(View view0, boolean z, String s, boolean z1, cmtList cmtResViewModel$result$cmtList0) {
        int v;
        String s4;
        StringBuilder stringBuilder0 = new StringBuilder();
        A7.d.u(stringBuilder0, (z ? this.getString(0x7F1300FC) : this.getString(0x7F1310FD)), " ", s, ", ");  // string:artist "아티스트"
        if(z1) {
            stringBuilder0.append(this.getString(0x7F130105));  // string:artist_channel_friendly "친밀도"
            stringBuilder0.append(" ");
            stringBuilder0.append(cmtResViewModel$result$cmtList0.memberinfo.artistTemperature);
            stringBuilder0.append(this.getString(0x7F1302E3));  // string:degree "도"
            stringBuilder0.append(", ");
        }
        String s1 = this.getAccessibilityRegdate(cmtResViewModel$result$cmtList0);
        stringBuilder0.append(this.getString(0x7F1310FC));  // string:write_time "작성시간"
        stringBuilder0.append(" ");
        stringBuilder0.append(s1);
        stringBuilder0.append(", ");
        stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.cmtcont);
        stringBuilder0.append(", ");
        if(cmtResViewModel$result$cmtList0.cmtinfo.atachcnt > 0) {
            ArrayList arrayList0 = cmtResViewModel$result$cmtList0.atachlist;
            if(arrayList0 != null) {
                Iterator iterator0 = arrayList0.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    ATACHLIST cmtSharedTypeRes$CmtListBase$ATACHLIST0 = (ATACHLIST)object0;
                    String s2 = cmtSharedTypeRes$CmtListBase$ATACHLIST0.atachtype;
                    if("image".equals(s2) || "music_album".equals(s2) || "music_artist".equals(s2) || "music_song".equals(s2) || "video".equals(s2) || "link_video".equals(s2) || "kakao_emoticon".equals(s2) || "link_genrl".equals(s2)) {
                        String s3 = "";
                        MediaAttachInfo mediaAttachInfo0 = v9.b.a(cmtSharedTypeRes$CmtListBase$ATACHLIST0);
                        if(mediaAttachInfo0 != null) {
                            if(MediaAttachType.g.equals(mediaAttachInfo0.a) || MediaAttachType.f.equals(mediaAttachInfo0.a)) {
                                v = 0x7F130B50;  // string:talkback_image "이미지"
                                s4 = "";
                            }
                            else if(MediaAttachType.c.equals(mediaAttachInfo0.a)) {
                                s3 = mediaAttachInfo0.j;
                                q.f(s3, "song");
                                s4 = va.e.c(this.getString(0x7F1300FC), ", ", mediaAttachInfo0.k);  // string:artist "아티스트"
                                v = 0x7F130A63;  // string:song "곡"
                            }
                            else if(MediaAttachType.d.equals(mediaAttachInfo0.a)) {
                                s3 = mediaAttachInfo0.i;
                                q.f(s3, "album");
                                s4 = va.e.c(this.getString(0x7F1300FC), ", ", mediaAttachInfo0.k);  // string:artist "아티스트"
                                v = 0x7F130053;  // string:album "앨범"
                            }
                            else if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
                                s3 = mediaAttachInfo0.E;
                                q.f(s3, "mvTitle");
                                s4 = va.e.c(this.getString(0x7F1300FC), ", ", mediaAttachInfo0.k);  // string:artist "아티스트"
                                v = 0x7F1310EE;  // string:video "비디오"
                            }
                            else if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                                v = 0x7F131106;  // string:youtube "Youtube"
                                s3 = va.e.c(mediaAttachInfo0.E, ", ", this.getString(0x7F1301E5));  // string:cmt_link_video_attach_text "YouTube에서"
                                s4 = "";
                            }
                            else if(MediaAttachType.e.equals(mediaAttachInfo0.a)) {
                                String s5 = mediaAttachInfo0.k;
                                q.f(s5, "artist");
                                s3 = s5;
                                s4 = "";
                                v = 0x7F1300FC;  // string:artist "아티스트"
                            }
                            else {
                                if(MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                                    v = 0x7F1302F2;  // string:desc_emoticon "Emoticon"
                                }
                                else {
                                    if(!MediaAttachType.k.equals(mediaAttachInfo0.a)) {
                                        continue;
                                    }
                                    v = 0x7F130B65;  // string:talkback_link "링크"
                                }
                                s4 = "";
                            }
                            stringBuilder0.append(this.getString(v));
                            stringBuilder0.append(", ");
                            if(s3.length() > 0) {
                                stringBuilder0.append(s3);
                                stringBuilder0.append(", ");
                            }
                            if(s4.length() > 0) {
                                stringBuilder0.append(s4);
                                stringBuilder0.append(", ");
                            }
                            stringBuilder0.append(this.getString(0x7F130AD7));  // string:talkback_attach "첨부"
                            stringBuilder0.append(", ");
                        }
                    }
                }
            }
        }
        stringBuilder0.append(this.getString(0x7F1308CF));  // string:reply_text "답글"
        stringBuilder0.append(" ");
        stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.validadcmtcnt);
        stringBuilder0.append(this.getString(0x7F130753));  // string:musicdna_count_hangle "개"
        stringBuilder0.append(", ");
        if(cmtResViewModel$result$cmtList0.cmtinfo.memberrecmflag) {
            stringBuilder0.append(this.getString(0x7F130C1B));  // string:talkback_recom "추천"
            stringBuilder0.append(" ");
            stringBuilder0.append(this.getString(0x7F130C44));  // string:talkback_selected "선택됨"
            stringBuilder0.append(", ");
        }
        if(cmtResViewModel$result$cmtList0.cmtinfo.membernonrecmflag) {
            stringBuilder0.append(this.getString(0x7F130C78));  // string:talkback_unrecom "비추천"
            stringBuilder0.append(" ");
            stringBuilder0.append(this.getString(0x7F130C44));  // string:talkback_selected "선택됨"
            stringBuilder0.append(", ");
        }
        stringBuilder0.append(this.getString(0x7F130C1B));  // string:talkback_recom "추천"
        stringBuilder0.append(" ");
        stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.recmcnt);
        stringBuilder0.append(this.getString(0x7F130753));  // string:musicdna_count_hangle "개"
        stringBuilder0.append(", ");
        stringBuilder0.append(this.getString(0x7F130C78));  // string:talkback_unrecom "비추천"
        stringBuilder0.append(" ");
        stringBuilder0.append(cmtResViewModel$result$cmtList0.cmtinfo.nonrecmcnt);
        stringBuilder0.append(this.getString(0x7F130753));  // string:musicdna_count_hangle "개"
        stringBuilder0.append(", ");
        stringBuilder0.append(this.getString(0x7F130ADE));  // string:talkback_button "버튼"
        view0.setContentDescription(stringBuilder0.toString());
    }

    public final void setCustomTitleText(@NotNull String s) {
        q.g(s, "<set-?>");
        this.customTitleText = s;
    }

    private final void setTextViewExpand(K1 k10, boolean z) {
        MediaAttachmentLayout mediaAttachmentLayout0 = k10.b;
        k10.u.setMaxLines((z ? 1000 : 5));
        k10.u.setEllipsize((z ? null : TextUtils.TruncateAt.END));
        if(mediaAttachmentLayout0.getCount() > 1) {
            mediaAttachmentLayout0.setExpand(z);
        }
    }

    private final void showContentPage(MediaAttachInfo mediaAttachInfo0) {
        if(MediaAttachType.c.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            MetaContentBaseFragment metaContentBaseFragment0 = this.getCurrentFragment();
            if(metaContentBaseFragment0 != null) {
                metaContentBaseFragment0.showSongInfoPage(String.valueOf(mediaAttachInfo0.e));
            }
        }
        else if(MediaAttachType.d.equals(mediaAttachInfo0.a) && !mediaAttachInfo0.Y) {
            MetaContentBaseFragment metaContentBaseFragment1 = this.getCurrentFragment();
            if(metaContentBaseFragment1 != null) {
                metaContentBaseFragment1.showAlbumInfoPage(String.valueOf(mediaAttachInfo0.c));
            }
        }
        else if(MediaAttachType.e.equals(mediaAttachInfo0.a)) {
            MetaContentBaseFragment metaContentBaseFragment2 = this.getCurrentFragment();
            if(metaContentBaseFragment2 != null) {
                metaContentBaseFragment2.showArtistInfoPage(String.valueOf(mediaAttachInfo0.d));
            }
        }
        else if(MediaAttachType.h.equals(mediaAttachInfo0.a)) {
            MetaContentBaseFragment metaContentBaseFragment3 = this.getCurrentFragment();
            if(metaContentBaseFragment3 != null) {
                metaContentBaseFragment3.showMvInfoPage(String.valueOf(mediaAttachInfo0.f), "1000000563");
            }
        }
        else {
            if(MediaAttachType.i.equals(mediaAttachInfo0.a)) {
                Navigator.openUrl(mediaAttachInfo0.h, OpenType.Browser);
                return;
            }
            if(!MediaAttachType.j.equals(mediaAttachInfo0.a)) {
                if(MediaAttachType.k.equals(mediaAttachInfo0.a)) {
                    Navigator.openUrl(mediaAttachInfo0.h, OpenType.Browser);
                    return;
                }
                if(MediaAttachType.g.equals(mediaAttachInfo0.a)) {
                    Navigator.INSTANCE.openPhotoUrl(false, mediaAttachInfo0.h, null);
                    return;
                }
                LogU.Companion.w("DetailCommentItemHolder", "onAttachmentClick() unknown type:" + mediaAttachInfo0.a);
            }
        }
    }

    private final void updateExpandLayout(K1 k10, cmtList cmtResViewModel$result$cmtList0) {
        int v = !cmtResViewModel$result$cmtList0.isContentExpand;
        cmtResViewModel$result$cmtList0.isContentExpand = v;
        this.setTextViewExpand(k10, ((boolean)v));
    }
}

