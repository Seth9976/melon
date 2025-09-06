package com.iloen.melon.fragments.artistchannel;

import B9.e;
import Cb.i;
import F8.O;
import F8.m;
import H0.b;
import Tf.o;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.artistchannel.topic.TopicFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.TopicActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.common.TopicInfoBase;
import com.iloen.melon.net.v6x.request.ArtistContentsArtistTopicListReq;
import com.iloen.melon.net.v6x.request.ArtistContentsListLikeAndCmtReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsListLikeAndCmtReq;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes.RESPONSE.ARTISTINFO;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes.RESPONSE.TOPICLIST;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes.RESPONSE.USERACTIONLIST;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import d3.g;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import v9.h;

@Metadata(d1 = {"\u0000\u009B\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001G\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001B\u0010\"\u001A\u0006\u0012\u0002\b\u00030!2\u0006\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b\"\u0010#J-\u0010)\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\'\u001A\u0004\u0018\u00010&2\b\u0010(\u001A\u0004\u0018\u00010\u000EH\u0014\u00A2\u0006\u0004\b)\u0010*J!\u0010-\u001A\u00020\t2\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\b-\u0010.J\u001F\u00102\u001A\u00020\t2\u000E\u00101\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0002\u00A2\u0006\u0004\b2\u00103J\u0013\u00105\u001A\u00020\u000E*\u000204H\u0002\u00A2\u0006\u0004\b5\u00106R\u0016\u00107\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010;\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R \u0010?\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020>0=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b?\u0010@R)\u0010F\u001A\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010\u000E0\u000E0/8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bB\u0010C\u001A\u0004\bD\u0010ER\u0014\u0010H\u001A\u00020G8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010M\u001A\u00020J8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bK\u0010L\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicListRes;", "artistContentsArtistTopicListRes", "fetchLikeAndCmt", "(Lv9/i;Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicListRes;)V", "", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicListRes$RESPONSE$TOPICLIST;", "topicList", "fetchTopicLike", "(Ljava/util/List;)V", "", "asOrder", "(I)Ljava/lang/String;", "artistId", "Ljava/lang/String;", "topicCnt", "artistName", "orderType", "I", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Ljava/util/Map;", "kotlin.jvm.PlatformType", "orderList$delegate", "Lie/j;", "getOrderList", "()Ljava/util/List;", "orderList", "com/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment$actionListener$1;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "TopicAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsTopicFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment$Companion;", "", "<init>", "()V", "TAG", "", "ORDER_NEW", "", "ORDER_POP", "VIEW_TYPE_HEADER", "VIEW_TYPE_TOPIC", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment;", "artistId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsTopicFragment newInstance(@Nullable String s) {
            ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0 = new ArtistDetailContentsTopicFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            artistDetailContentsTopicFragment0.setArguments(bundle0);
            return artistDetailContentsTopicFragment0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001A\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment$TopicAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicListRes$RESPONSE$TOPICLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsTopicFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TopicAdapter extends p {
        @NotNull
        private final TopicActionListener actionListener;

        public TopicAdapter(@Nullable Context context0, @Nullable List list0, @NotNull TopicActionListener detailContentsTopicItemHolder$TopicActionListener0) {
            q.g(detailContentsTopicItemHolder$TopicActionListener0, "actionListener");
            ArtistDetailContentsTopicFragment.this = artistDetailContentsTopicFragment0;
            super(context0, list0);
            this.actionListener = detailContentsTopicItemHolder$TopicActionListener0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 1 : 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof e) {
                String s = va.e.h(ArtistDetailContentsTopicFragment.this.getString(0x7F1301D6), " %s");  // string:cmt_all "전체"
                l1.D(new Object[]{ArtistDetailContentsTopicFragment.this.topicCnt}, 1, s, ((e)o00).a);
                List list0 = ArtistDetailContentsTopicFragment.this.getOrderList();
                String s1 = (String)je.p.n0(ArtistDetailContentsTopicFragment.this.orderType, list0);
                ((e)o00).b.setText(s1);
                Object[] arr_object = {((e)o00).b.getText()};
                String s2 = ArtistDetailContentsTopicFragment.this.getString(0x7F130BAF, arr_object);  // string:talkback_order_change "%1$s, 정렬기준 변경"
                ViewUtils.setContentDescriptionWithButtonClassName(((e)o00).b, s2);
                j j0 = new j(0, ArtistDetailContentsTopicFragment.this, ((e)o00).b);
                ((e)o00).b.setOnClickListener(j0);
                return;
            }
            if(o00 instanceof DetailContentsTopicItemHolder) {
                Object object0 = this.getItem(v1);
                q.f(object0, "getItem(...)");
                ((DetailContentsTopicItemHolder)o00).bind(((TopicInfoBase)object0), v1, ArtistDetailContentsTopicFragment.this.getViewLifecycleOwner());
            }
        }

        private static final void onBindViewImpl$lambda$1(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, TextView textView0, View view0) {
            if(artistDetailContentsTopicFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = artistDetailContentsTopicFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(artistDetailContentsTopicFragment0.getOrderList(), artistDetailContentsTopicFragment0.orderType);
                    bottomSingleFilterListPopup0.setFilterListener(new c(1, artistDetailContentsTopicFragment0, textView0));
                    bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsTopicFragment0.mDialogDismissListener);
                    artistDetailContentsTopicFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, TextView textView0, int v) {
            artistDetailContentsTopicFragment0.orderType = v;
            String s = (String)je.p.n0(artistDetailContentsTopicFragment0.orderType, artistDetailContentsTopicFragment0.getOrderList());
            textView0.setText(s);
            ViewUtils.setContentDescriptionWithButtonClassName(textView0, artistDetailContentsTopicFragment0.getString(0x7F130BAF, new Object[]{textView0.getText()}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
            if(i.l(artistDetailContentsTopicFragment0.mMelonTiaraProperty)) {
                f f0 = artistDetailContentsTopicFragment0.getBaseTiaraLogEventBuilder();
                f0.a = artistDetailContentsTopicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.y = artistDetailContentsTopicFragment0.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
                f0.F = s;
                f0.a().track();
            }
            artistDetailContentsTopicFragment0.startFetch("filter change");
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == 0 ? z6.f.p(viewGroup0, 10.0f, 2) : DetailContentsTopicItemHolder.Companion.newInstance(viewGroup0, this.actionListener, ArtistDetailContentsTopicFragment.this.blurViewBgMap, false);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int ORDER_NEW = 0;
    private static final int ORDER_POP = 1;
    @NotNull
    private static final String TAG = "ArtistDetailContentsTopicFragment";
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_TOPIC = 1;
    @NotNull
    private final com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment.actionListener.1 actionListener;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private final Map blurViewBgMap;
    @NotNull
    private final ie.j orderList$delegate;
    private int orderType;
    @NotNull
    private String topicCnt;

    static {
        ArtistDetailContentsTopicFragment.Companion = new Companion(null);
        ArtistDetailContentsTopicFragment.$stable = 8;
    }

    public ArtistDetailContentsTopicFragment() {
        this.artistId = "";
        this.topicCnt = "";
        this.artistName = "";
        this.orderType = 1;
        this.blurViewBgMap = new LinkedHashMap();
        this.orderList$delegate = g.Q(new a(this, 3));
        this.actionListener = new TopicActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickLike(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                boolean z = topicInfoBase0.isLike;
                if(i.l(ArtistDetailContentsTopicFragment.this.mMelonTiaraProperty)) {
                    f f0 = ArtistDetailContentsTopicFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = ArtistDetailContentsTopicFragment.this.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                    f0.d = ActionKind.Like;
                    f0.y = ArtistDetailContentsTopicFragment.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.e = topicInfoBase0.topicSeq;
                    f0.U = ArtistDetailContentsTopicFragment.this.getString((z ? 0x7F130FCC : 0x7F130FCD));  // string:tiara_props_dislike "dislike"
                    f0.a().track();
                }
                String s = topicInfoBase0.topicSeq;
                String s1 = ArtistDetailContentsTopicFragment.this.getMenuId();
                com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment.actionListener.1.onClickLike.1 artistDetailContentsTopicFragment$actionListener$1$onClickLike$10 = new OnJobFinishListener() {
                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        if(o.H0(s) && v.isFragmentValid()) {
                            j0 j00 = v.getAdapter();
                            TopicAdapter artistDetailContentsTopicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                            if(artistDetailContentsTopicFragment$TopicAdapter0 != null) {
                                Object object0 = artistDetailContentsTopicFragment$TopicAdapter0.getItem(this.$position);
                                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes.RESPONSE.TOPICLIST");
                                ((TOPICLIST)object0).isLike = z;
                                ((TOPICLIST)object0).likeCnt = String.valueOf(v);
                                artistDetailContentsTopicFragment$TopicAdapter0.notifyItemChanged(artistDetailContentsTopicFragment$TopicAdapter0.getHeaderCount() + this.$position);
                            }
                        }
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                    }
                };
                ArtistDetailContentsTopicFragment.this.updateLike(s, "N10098", !z, s1, artistDetailContentsTopicFragment$actionListener$1$onClickLike$10);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickTopic(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                if(i.l(ArtistDetailContentsTopicFragment.access$getMMelonTiaraProperty$p$s-1910957075(ArtistDetailContentsTopicFragment.this))) {
                    f f0 = ArtistDetailContentsTopicFragment.access$getBaseTiaraLogEventBuilder(ArtistDetailContentsTopicFragment.this);
                    f0.a = ArtistDetailContentsTopicFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistDetailContentsTopicFragment.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.e = topicInfoBase0.topicSeq;
                    f0.a().track();
                }
                String s = topicInfoBase0.topicSeq;
                q.f(s, "topicSeq");
                Navigator.open(TopicFragment.Companion.newInstance(ArtistDetailContentsTopicFragment.access$getArtistId$p(ArtistDetailContentsTopicFragment.this), s));
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickViewAllComment(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                if(i.l(ArtistDetailContentsTopicFragment.this.mMelonTiaraProperty)) {
                    f f0 = ArtistDetailContentsTopicFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = ArtistDetailContentsTopicFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistDetailContentsTopicFragment.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.F = ArtistDetailContentsTopicFragment.this.getString(0x7F130DB2);  // string:tiara_click_copy_view_all_comment "댓글모두보기"
                    f0.e = topicInfoBase0.topicSeq;
                    f0.a().track();
                }
                Param cmtListFragment$Param0 = new Param();
                cmtListFragment$Param0.chnlSeq = ProtocolUtils.parseInt(topicInfoBase0.topicChnlSeq, 0);
                cmtListFragment$Param0.contsRefValue = topicInfoBase0.topicSeq;
                cmtListFragment$Param0.showTitle = true;
                cmtListFragment$Param0.headerTitle = topicInfoBase0.title;
                cmtListFragment$Param0.isReadOnly = false;
                cmtListFragment$Param0.cacheKeyOfTargetPage = va.e.h(ArtistDetailContentsTopicFragment.this.getCacheKey(), topicInfoBase0.topicSeq);
                Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
            }
        };
    }

    public static final String access$getArtistId$p(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0) {
        return artistDetailContentsTopicFragment0.artistId;
    }

    private final String asOrder(int v) {
        return v == 1 ? "POP" : "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new TopicAdapter(this, context0, null, this.actionListener);
    }

    private final void fetchLikeAndCmt(v9.i i0, ArtistContentsArtistTopicListRes artistContentsArtistTopicListRes0) {
        String s1;
        List list0 = artistContentsArtistTopicListRes0.response.topicList;
        q.d(list0);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            TOPICLIST artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 = (TOPICLIST)object0;
            if(artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 == null) {
                s1 = "";
            }
            else {
                String s = artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.topicSeq;
                if(s != null) {
                    s1 = s;
                }
            }
            arrayList0.add(s1);
        }
        String s2 = StringUtils.convertToCommaSeparatedText(new ArrayList(arrayList0));
        Params artistContentsListLikeAndCmtReq$Params0 = new Params();
        artistContentsListLikeAndCmtReq$Params0.artistId = this.artistId;
        artistContentsListLikeAndCmtReq$Params0.contsIds = s2;
        artistContentsListLikeAndCmtReq$Params0.contsTypeCode = "N10098";
        RequestBuilder.newInstance(new ArtistContentsListLikeAndCmtReq(this.getContext(), artistContentsListLikeAndCmtReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.artistchannel.i(this, i0, artistContentsArtistTopicListRes0, list0)).errorListener(new com.iloen.melon.fragments.artistchannel.i(this, i0, artistContentsArtistTopicListRes0, list0)).request();
    }

    private static final void fetchLikeAndCmt$lambda$13(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, v9.i i0, ArtistContentsArtistTopicListRes artistContentsArtistTopicListRes0, List list0, ArtistContentsListLikeAndCmtRes artistContentsListLikeAndCmtRes0) {
        if(!artistDetailContentsTopicFragment0.isFragmentValid()) {
            return;
        }
        int v = 0;
        Cb.j.b(artistContentsListLikeAndCmtRes0.notification, false, 2);
        if(Cb.j.d(artistContentsListLikeAndCmtRes0)) {
            RESPONSE artistContentsListLikeAndCmtRes$RESPONSE0 = artistContentsListLikeAndCmtRes0.response;
            if(artistContentsListLikeAndCmtRes$RESPONSE0 != null) {
                List list1 = artistContentsListLikeAndCmtRes$RESPONSE0.userActionList;
                if(list1 != null) {
                    try {
                        for(Object object0: list1) {
                            if(v < 0) {
                                k.O();
                                throw null;
                            }
                            q.d(list0);
                            TOPICLIST artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 = (TOPICLIST)je.p.n0(v, list0);
                            if(artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 != null) {
                                artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.likeCnt = ((USERACTIONLIST)object0).likeCnt;
                                artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.totalCmtCnt = ((USERACTIONLIST)object0).totalCmtCnt;
                                artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.cmtList = ((USERACTIONLIST)object0).cmtList;
                            }
                            ++v;
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
                artistDetailContentsTopicFragment0.performFetchComplete(i0, artistContentsArtistTopicListRes0);
                q.d(list0);
                artistDetailContentsTopicFragment0.fetchTopicLike(list0);
                return;
            }
        }
        artistDetailContentsTopicFragment0.performFetchComplete(i0, artistContentsArtistTopicListRes0);
        q.d(list0);
        artistDetailContentsTopicFragment0.fetchTopicLike(list0);
    }

    private static final void fetchLikeAndCmt$lambda$14(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, v9.i i0, ArtistContentsArtistTopicListRes artistContentsArtistTopicListRes0, List list0, VolleyError volleyError0) {
        b.w("error : ", volleyError0.getMessage(), LogU.Companion, "ArtistDetailContentsTopicFragment");
        artistDetailContentsTopicFragment0.performFetchComplete(i0, artistContentsArtistTopicListRes0);
        q.d(list0);
        artistDetailContentsTopicFragment0.fetchTopicLike(list0);
    }

    private final void fetchTopicLike(List list0) {
        String s1;
        if(!this.isLoginUser()) {
            return;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            TOPICLIST artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 = (TOPICLIST)object0;
            if(artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 == null) {
                s1 = "";
            }
            else {
                String s = artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.topicSeq;
                if(s != null) {
                    s1 = s;
                }
            }
            arrayList0.add(s1);
        }
        String s2 = StringUtils.convertToCommaSeparatedText(new ArrayList(arrayList0));
        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
        userActionsReq$Params0.fields = "like";
        userActionsReq$Params0.contsTypeCode = "N10098";
        userActionsReq$Params0.contsId = s2;
        RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new c(10, this, list0)).errorListener(new s(2)).request();
    }

    private static final void fetchTopicLike$lambda$19(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, List list0, UserActionsRes userActionsRes0) {
        if(artistDetailContentsTopicFragment0.isFragmentValid()) {
            int v = 0;
            Cb.j.b(userActionsRes0.notification, false, 3);
            if(Cb.j.d(userActionsRes0)) {
                Response userActionsRes$Response0 = userActionsRes0.response;
                if(userActionsRes$Response0 != null) {
                    ArrayList arrayList0 = userActionsRes$Response0.relationList;
                    if(arrayList0 != null) {
                        try {
                            for(Object object0: arrayList0) {
                                if(v < 0) {
                                    k.O();
                                    throw null;
                                }
                                TOPICLIST artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 = (TOPICLIST)je.p.n0(v, list0);
                                if(artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0 != null) {
                                    artistContentsArtistTopicListRes$RESPONSE$TOPICLIST0.isLike = q.b(((RelationList)object0).fields.like, "Y");
                                }
                                ++v;
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    artistDetailContentsTopicFragment0.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    private static final void fetchTopicLike$lambda$20(VolleyError volleyError0) {
        com.iloen.melon.utils.a.v("error : ", volleyError0.getMessage(), LogU.Companion, "ArtistDetailContentsTopicFragment");
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        p8.s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        String s2 = "아티스트";
        f0.c = s1;
        f0.o = this.artistId;
        if(this.getContext() == null) {
            s2 = "";
        }
        f0.p = s2;
        f0.q = this.artistName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("TOPIC").appendPath(this.artistId).appendQueryParameter("orderType", String.valueOf(this.orderType)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getOrderList() {
        return (List)this.orderList$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsTopicFragment newInstance(@Nullable String s) {
        return ArtistDetailContentsTopicFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(false);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).addItemDecoration(new r0() {
            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                j0 j00 = this.$this_apply.getAdapter();
                TopicAdapter artistDetailContentsTopicFragment$TopicAdapter0 = j00 instanceof TopicAdapter ? ((TopicAdapter)j00) : null;
                int v = recyclerView0.getChildAdapterPosition(view0);
                if(artistDetailContentsTopicFragment$TopicAdapter0 != null && 1 == artistDetailContentsTopicFragment$TopicAdapter0.getItemViewType(v)) {
                    int v1 = ScreenUtils.dipToPixel(this.$this_apply.getContext(), 20.0f);
                    rect0.left = v1;
                    rect0.right = v1;
                    rect0.bottom = ScreenUtils.dipToPixel(this.$this_apply.getContext(), (v == artistDetailContentsTopicFragment$TopicAdapter0.getItemCount() - 1 ? 40.0f : 30.0f));
                }
            }
        });
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0206, null, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment.TopicAdapter");
        v9.i i1 = v9.i.b;
        if(i1.equals(i0)) {
            ((TopicAdapter)j00).clear();
        }
        com.iloen.melon.net.v6x.request.ArtistContentsArtistTopicListReq.Params artistContentsArtistTopicListReq$Params0 = new com.iloen.melon.net.v6x.request.ArtistContentsArtistTopicListReq.Params();
        artistContentsArtistTopicListReq$Params0.artistId = this.artistId;
        artistContentsArtistTopicListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((TopicAdapter)j00).getCount() + 1;
        artistContentsArtistTopicListReq$Params0.pageSize = 10;
        artistContentsArtistTopicListReq$Params0.orderBy = this.asOrder(this.orderType);
        RequestBuilder.newInstance(new ArtistContentsArtistTopicListReq(this.getContext(), artistContentsArtistTopicListReq$Params0)).tag(this.getRequestTag()).listener(new c(11, this, i0)).errorListener(new r(this, 2)).request();
        return true;
    }

    private static final void onFetchStart$lambda$7(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, v9.i i0, ArtistContentsArtistTopicListRes artistContentsArtistTopicListRes0) {
        String s;
        q.g(artistContentsArtistTopicListRes0, "response");
        if(!artistDetailContentsTopicFragment0.prepareFetchComplete(artistContentsArtistTopicListRes0)) {
            return;
        }
        com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes.RESPONSE artistContentsArtistTopicListRes$RESPONSE0 = artistContentsArtistTopicListRes0.response;
        if(artistContentsArtistTopicListRes$RESPONSE0 != null) {
            ARTISTINFO artistContentsArtistTopicListRes$RESPONSE$ARTISTINFO0 = artistContentsArtistTopicListRes$RESPONSE0.artistInfo;
            if(artistContentsArtistTopicListRes$RESPONSE$ARTISTINFO0 == null) {
                s = "";
            }
            else {
                s = artistContentsArtistTopicListRes$RESPONSE$ARTISTINFO0.artistName;
                if(s == null) {
                    s = "";
                }
            }
            artistDetailContentsTopicFragment0.artistName = s;
            artistDetailContentsTopicFragment0.mMelonTiaraProperty = new p8.s(artistContentsArtistTopicListRes$RESPONSE0.section, artistContentsArtistTopicListRes$RESPONSE0.page, artistContentsArtistTopicListRes0.getMenuId(), null);
            if(artistContentsArtistTopicListRes$RESPONSE0.topicCnt != null && !o.H0(artistContentsArtistTopicListRes$RESPONSE0.topicCnt) == 1) {
                String s1 = artistContentsArtistTopicListRes$RESPONSE0.topicCnt;
                q.f(s1, "topicCnt");
                artistDetailContentsTopicFragment0.topicCnt = s1;
            }
        }
        if(artistContentsArtistTopicListRes0.response != null && (artistContentsArtistTopicListRes0.response.topicList != null && !artistContentsArtistTopicListRes0.response.topicList.isEmpty() == 1)) {
            artistDetailContentsTopicFragment0.fetchLikeAndCmt(i0, artistContentsArtistTopicListRes0);
            return;
        }
        artistDetailContentsTopicFragment0.performFetchComplete(i0, artistContentsArtistTopicListRes0);
    }

    private static final void onFetchStart$lambda$8(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, VolleyError volleyError0) {
        artistDetailContentsTopicFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            F8.p p0 = new F8.p(1);
            p0.c = new com.iloen.melon.fragments.artistchannel.h(this, 0);
            O o0 = new O(20.0f);
            o0.c = new com.iloen.melon.fragments.artistchannel.h(this, 1);
            p0.g(new m(2, false));
            p0.g(o0);
            titleBar0.a(p0);
            titleBar0.setTitle(this.getString(0x7F1310F8));  // string:wageurwageul "와글와글"
        }
    }

    private static final void onViewCreated$lambda$3$lambda$1(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, View view0) {
        if(i.l(artistDetailContentsTopicFragment0.mMelonTiaraProperty)) {
            f f0 = artistDetailContentsTopicFragment0.getBaseTiaraLogEventBuilder();
            f0.a = artistDetailContentsTopicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = artistDetailContentsTopicFragment0.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            f0.F = artistDetailContentsTopicFragment0.getString(0x7F130DD4);  // string:tiara_common_back_button "뒤로가기"
            f0.a().track();
        }
        artistDetailContentsTopicFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$3$lambda$2(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0, View view0) {
        if(i.l(artistDetailContentsTopicFragment0.mMelonTiaraProperty)) {
            f f0 = artistDetailContentsTopicFragment0.getBaseTiaraLogEventBuilder();
            f0.a = artistDetailContentsTopicFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = artistDetailContentsTopicFragment0.getString(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            f0.F = artistDetailContentsTopicFragment0.getString(0x7F130E35);  // string:tiara_common_layer2_refresh "새로고침"
            f0.a().track();
        }
        j0 j00 = artistDetailContentsTopicFragment0.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment.TopicAdapter");
        ((TopicAdapter)j00).clearCache(artistDetailContentsTopicFragment0.getCacheKey());
        artistDetailContentsTopicFragment0.startFetch("refresh");
    }

    private static final List orderList_delegate$lambda$0(ArtistDetailContentsTopicFragment artistDetailContentsTopicFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsTopicFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030003);  // array:artist_channel_basic_tab_order
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }
}

