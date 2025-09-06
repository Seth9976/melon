package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.p;
import android.content.Context;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsTopicFragment;
import com.iloen.melon.fragments.artistchannel.topic.TopicFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.TopicActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.common.TopicInfoBase;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.TOPICLIST;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\'\b\u0017\u0018\u0000 *2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002*+B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u000F\u001A\u00020\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u001C\u0010\u001C\u001A\b\u0018\u00010\u001BR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR \u0010 \u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001F0\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001A\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;", "LJ8/p;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/p;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "position", "updateItem", "(I)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$TopicRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$TopicRecyclerAdapter;", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Ljava/util/Map;", "Landroidx/lifecycle/D;", "lifecycleOwner", "Landroidx/lifecycle/D;", "artistId", "Ljava/lang/String;", "com/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$actionListener$1;", "Companion", "TopicRecyclerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistTopicHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$Companion;", "", "<init>", "()V", "TAG", "", "HEIGHT_NO_COMMENT", "", "HEIGHT_ONE_COMMENT", "HEIGHT_TWO_COMMENT", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistTopicHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0047, viewGroup0, false);  // layout:artist_detail_topic
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new ArtistTopicHolder(new p(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder$TopicRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$TOPICLIST;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TopicRecyclerAdapter extends c {
        public TopicRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((DetailContentsTopicItemHolder)o00));
        }

        public void initViewHolder(@NotNull DetailContentsTopicItemHolder detailContentsTopicItemHolder0) {
            q.g(detailContentsTopicItemHolder0, "vh");
            detailContentsTopicItemHolder0.initViewHolder();
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((DetailContentsTopicItemHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull DetailContentsTopicItemHolder detailContentsTopicItemHolder0, int v, int v1) {
            q.g(detailContentsTopicItemHolder0, "vh");
            this.initViewHolder(detailContentsTopicItemHolder0);
            Object object0 = this.getItem(v1);
            q.f(object0, "getItem(...)");
            detailContentsTopicItemHolder0.bind(((TopicInfoBase)object0), v1, ArtistTopicHolder.this.lifecycleOwner);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public DetailContentsTopicItemHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return DetailContentsTopicItemHolder.Companion.newInstance(viewGroup0, ArtistTopicHolder.this.actionListener, ArtistTopicHolder.this.blurViewBgMap, true);
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
    private static final float HEIGHT_NO_COMMENT = 364.0f;
    private static final float HEIGHT_ONE_COMMENT = 412.0f;
    private static final float HEIGHT_TWO_COMMENT = 431.0f;
    @NotNull
    private static final String TAG = "ArtistTopicHolder";
    @NotNull
    private final com.iloen.melon.fragments.artistchannel.viewholder.ArtistTopicHolder.actionListener.1 actionListener;
    @NotNull
    private String artistId;
    @NotNull
    private final Map blurViewBgMap;
    @Nullable
    private TopicRecyclerAdapter innerAdapter;
    @Nullable
    private D lifecycleOwner;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistTopicHolder.Companion = new Companion(null);
        ArtistTopicHolder.$stable = 8;
    }

    public ArtistTopicHolder(@NotNull p p0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(p0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(p0, onViewHolderActionBaseListener0);
        this.blurViewBgMap = new LinkedHashMap();
        this.artistId = "";
        View view0 = this.itemView;
        q.f(view0, "itemView");
        if(view0.isAttachedToWindow()) {
            q.f(this.itemView, "itemView");
            ArtistTopicHolder.access$setLifecycleOwner$p(this, f0.d(this.itemView));
            TopicRecyclerAdapter artistTopicHolder$TopicRecyclerAdapter0 = ArtistTopicHolder.access$getInnerAdapter$p(this);
            if(artistTopicHolder$TopicRecyclerAdapter0 != null) {
                artistTopicHolder$TopicRecyclerAdapter0.notifyDataSetChanged();
            }
        }
        else {
            view0.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view0) {
                    this.removeOnAttachStateChangeListener(this);
                    q.f(ArtistTopicHolder.this.itemView, "itemView");
                    D d0 = f0.d(ArtistTopicHolder.this.itemView);
                    ArtistTopicHolder.access$setLifecycleOwner$p(ArtistTopicHolder.this, d0);
                    TopicRecyclerAdapter artistTopicHolder$TopicRecyclerAdapter0 = ArtistTopicHolder.access$getInnerAdapter$p(ArtistTopicHolder.this);
                    if(artistTopicHolder$TopicRecyclerAdapter0 != null) {
                        artistTopicHolder$TopicRecyclerAdapter0.notifyDataSetChanged();
                    }
                }

                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view0) {
                }
            });
        }
        View view1 = this.itemView;
        q.f(view1, "itemView");
        if(view1.isAttachedToWindow()) {
            view1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view0) {
                }

                @Override  // android.view.View$OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view0) {
                    this.removeOnAttachStateChangeListener(this);
                    ArtistTopicHolder.access$setLifecycleOwner$p(ArtistTopicHolder.this, null);
                }
            });
        }
        else {
            ArtistTopicHolder.access$setLifecycleOwner$p(this, null);
        }
        this.setTitleView(p0.b);
        p0.c.setHasFixedSize(true);
        p0.c.setNestedScrollingEnabled(false);
        O o0 = new O(11.0f);
        p0.c.addItemDecoration(o0);
        p0.c.getContext();
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(0, false);
        p0.c.setLayoutManager(linearLayoutManager0);
        this.recyclerView = p0.c;
        this.innerAdapter = new TopicRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
        this.actionListener = new TopicActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickLike(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                boolean z = topicInfoBase0.isLike;
                f f0 = this.onTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = ArtistTopicHolder.this.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                    f0.d = ActionKind.Like;
                    f0.y = ArtistTopicHolder.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.c(v + 1);
                    f0.e = topicInfoBase0.topicSeq;
                    f0.U = ArtistTopicHolder.this.getString((z ? 0x7F130FCC : 0x7F130FCD));  // string:tiara_props_dislike "dislike"
                    f0.a().track();
                }
                String s = topicInfoBase0.topicSeq;
                q.f(s, "topicSeq");
                q.f("N10098", "code(...)");
                this.onItemLikeListener(s, "N10098", !z, v);
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickTopic(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                f f0 = this.onTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = ArtistTopicHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistTopicHolder.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.c(v + 1);
                    f0.e = topicInfoBase0.topicSeq;
                    f0.a().track();
                }
                String s = topicInfoBase0.topicSeq;
                q.f(s, "topicSeq");
                Navigator.open(TopicFragment.Companion.newInstance(ArtistTopicHolder.access$getArtistId$p(ArtistTopicHolder.this), s));
            }

            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder$TopicActionListener
            public void onClickViewAllComment(TopicInfoBase topicInfoBase0, int v) {
                q.g(topicInfoBase0, "topic");
                f f0 = this.onTiaraEventBuilder();
                if(f0 != null) {
                    f0.a = ArtistTopicHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = ArtistTopicHolder.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                    f0.F = ArtistTopicHolder.this.getString(0x7F130DB2);  // string:tiara_click_copy_view_all_comment "댓글모두보기"
                    f0.c(v + 1);
                    f0.e = topicInfoBase0.topicSeq;
                    f0.a().track();
                }
                Param cmtListFragment$Param0 = new Param();
                cmtListFragment$Param0.chnlSeq = ProtocolUtils.parseInt(topicInfoBase0.topicChnlSeq, 0);
                cmtListFragment$Param0.contsRefValue = topicInfoBase0.topicSeq;
                cmtListFragment$Param0.showTitle = true;
                cmtListFragment$Param0.headerTitle = topicInfoBase0.title;
                cmtListFragment$Param0.isReadOnly = false;
                cmtListFragment$Param0.cacheKeyOfTargetPage = (ArtistTopicHolder.this.getCurrentFragment() == null ? null : "") + topicInfoBase0.topicSeq;
                Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
            }
        };
    }

    public static final TopicRecyclerAdapter access$getInnerAdapter$p(ArtistTopicHolder artistTopicHolder0) {
        return artistTopicHolder0.innerAdapter;
    }

    public static final void access$setLifecycleOwner$p(ArtistTopicHolder artistTopicHolder0, D d0) {
        artistTopicHolder0.lifecycleOwner = d0;
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1310F8);  // string:wageurwageul "와글와글"
    }

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final ArtistTopicHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistTopicHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        float f;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        String s = adapterInViewHolder$Row0.getContentId();
        q.f(s, "getContentId(...)");
        this.artistId = s;
        RESPONSE artistHomeContentsRes$RESPONSE0 = (RESPONSE)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitleTextSize(18.0f);
            mainTabTitleView0.setTitle(this.getTitleName() + " " + artistHomeContentsRes$RESPONSE0.topicCnt);
            mainTabTitleView0.setTitleClickable(true);
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    f f0 = ArtistTopicHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistTopicHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistTopicHolder.this.getString(0x7F130E20);  // string:tiara_common_layer1_topic "토픽"
                        f0.F = ArtistTopicHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                    Navigator.open(ArtistDetailContentsTopicFragment.Companion.newInstance(ArtistTopicHolder.this.artistId));
                }
            });
        }
        List list0 = artistHomeContentsRes$RESPONSE0.topicList;
        Integer integer0 = null;
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            TopicRecyclerAdapter artistTopicHolder$TopicRecyclerAdapter0 = this.innerAdapter;
            if(artistTopicHolder$TopicRecyclerAdapter0 != null) {
                artistTopicHolder$TopicRecyclerAdapter0.setItems(list0);
            }
        }
        q.d(list0);
        Iterator iterator0 = list0.iterator();
        int v = 0;
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            integer0 = ProtocolUtils.parseInt(((TOPICLIST)object0).totalCmtCnt, 0);
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                Integer integer1 = ProtocolUtils.parseInt(((TOPICLIST)object1).totalCmtCnt, 0);
                if(integer0.compareTo(integer1) < 0) {
                    integer0 = integer1;
                }
            }
        }
        if(integer0 != null) {
            v = (int)integer0;
        }
        switch(v) {
            case 0: {
                f = 364.0f;
                break;
            }
            case 1: {
                f = 412.0f;
                break;
            }
            default: {
                f = 431.0f;
            }
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = recyclerView1.getLayoutParams();
            if(viewGroup$LayoutParams0 != null) {
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), f);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    public final void updateItem(int v) {
        TopicRecyclerAdapter artistTopicHolder$TopicRecyclerAdapter0 = this.innerAdapter;
        if(artistTopicHolder$TopicRecyclerAdapter0 != null) {
            artistTopicHolder$TopicRecyclerAdapter0.notifyItemChanged(v);
        }
    }
}

