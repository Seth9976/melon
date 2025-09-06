package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.f;
import J8.i2;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.DETAILINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RelatedArtistsInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 &2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003&\'(B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001D\u0010\u0019\u001A\u00020\u00102\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u001C\u0010\"\u001A\b\u0018\u00010!R\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$DETAILINFO;", "LJ8/f;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/f;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;", "vh", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RelatedArtistsInfoBase;", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RelatedArtistsInfoBase;I)V", "openArtistInfo", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RelatedArtistsInfoBase;I)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$GroupRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$GroupRecyclerAdapter;", "holderBind", "LJ8/f;", "Companion", "GroupRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistGroupHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistGroupHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0034, viewGroup0, false);  // layout:artist_detail_artistgroup
            int v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                v = 0x7F0A09CF;  // id:recycler_horizontal
                RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                if(recyclerView0 != null) {
                    return new ArtistGroupHolder(new f(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$GroupRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RelatedArtistsInfoBase;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GroupRecyclerAdapter extends c {
        public GroupRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder artistGroupHolder$ViewHolder0) {
            q.g(artistGroupHolder$ViewHolder0, "vh");
            int v = ScreenUtils.dipToPixel(this.getContext(), 100.0f);
            ViewUtils.setDefaultImage(artistGroupHolder$ViewHolder0.getBind().c, v, true);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder artistGroupHolder$ViewHolder0, int v, int v1) {
            q.g(artistGroupHolder$ViewHolder0, "vh");
            this.initViewHolder(artistGroupHolder$ViewHolder0);
            RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0 = (RelatedArtistsInfoBase)this.getItem(v1);
            q.d(artistHomeContentsRes$RelatedArtistsInfoBase0);
            ArtistGroupHolder.this.bindItem(artistGroupHolder$ViewHolder0, artistHomeContentsRes$RelatedArtistsInfoBase0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = o.e(viewGroup0, 0x7F0D04B4, viewGroup0, false);  // layout:listitem_tab_station_program
            int v1 = 0x7F0A069B;  // id:iv_thumb_circle
            View view1 = I.C(view0, 0x7F0A069B);  // id:iv_thumb_circle
            if(((BorderImageView)view1) != null) {
                v1 = 0x7F0A069C;  // id:iv_thumb_circle_default
                View view2 = I.C(view0, 0x7F0A069C);  // id:iv_thumb_circle_default
                if(((ImageView)view2) != null) {
                    v1 = 0x7F0A069D;  // id:iv_thumb_circle_default_bg
                    View view3 = I.C(view0, 0x7F0A069D);  // id:iv_thumb_circle_default_bg
                    if(view3 != null) {
                        v1 = 0x7F0A0D34;  // id:tv_title
                        View view4 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                        if(((MelonTextView)view4) != null && ((Group)I.C(view0, 0x7F0A0D74)) != null && ((ImageView)I.C(view0, 0x7F0A0D75)) != null) {  // id:update_dot_iv
                            v1 = 0x7F0A0D76;  // id:update_dot_iv_start
                            View view5 = I.C(view0, 0x7F0A0D76);  // id:update_dot_iv_start
                            if(view5 != null) {
                                return new ViewHolder(new i2(((ConstraintLayout)view0), ((BorderImageView)view1), ((ImageView)view2), view3, ((MelonTextView)view4), view5));
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/i2;", "listItemTabStationProgramBinding", "<init>", "(LJ8/i2;)V", "bind", "LJ8/i2;", "getBind", "()LJ8/i2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final i2 bind;

        public ViewHolder(@NotNull i2 i20) {
            q.g(i20, "listItemTabStationProgramBinding");
            super(i20.a);
            this.bind = i20;
        }

        @NotNull
        public final i2 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistGroupHolder";
    @NotNull
    private f holderBind;
    @Nullable
    private GroupRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistGroupHolder.Companion = new Companion(null);
        ArtistGroupHolder.$stable = 8;
    }

    public ArtistGroupHolder(@NotNull f f0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(f0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(f0, onViewHolderActionBaseListener0);
        this.holderBind = f0;
        this.setTitleView(f0.b);
        RecyclerView recyclerView0 = this.holderBind.c;
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setNestedScrollingEnabled(false);
        recyclerView0.addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
        recyclerView0.getContext();
        recyclerView0.setLayoutManager(new LinearLayoutManager(0, false));
        this.recyclerView = recyclerView0;
        this.innerAdapter = new GroupRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindItem(ViewHolder artistGroupHolder$ViewHolder0, RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0, int v) {
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(artistGroupHolder$ViewHolder0.getBind().b);
        }
        artistGroupHolder$ViewHolder0.getBind().e.setText(artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistName());
        g g0 = new g(this, artistHomeContentsRes$RelatedArtistsInfoBase0, v, 0);
        artistGroupHolder$ViewHolder0.getBind().e.setOnClickListener(g0);
        g g1 = new g(this, artistHomeContentsRes$RelatedArtistsInfoBase0, v, 1);
        artistGroupHolder$ViewHolder0.getBind().b.setOnClickListener(g1);
        ViewUtils.setContentDescriptionWithButtonClassName(artistGroupHolder$ViewHolder0.getBind().a, artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistName());
    }

    private static final void bindItem$lambda$3(ArtistGroupHolder artistGroupHolder0, RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0, int v, View view0) {
        artistGroupHolder0.openArtistInfo(artistHomeContentsRes$RelatedArtistsInfoBase0, v);
    }

    private static final void bindItem$lambda$4(ArtistGroupHolder artistGroupHolder0, RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0, int v, View view0) {
        artistGroupHolder0.openArtistInfo(artistHomeContentsRes$RelatedArtistsInfoBase0, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final ArtistGroupHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistGroupHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        List list0;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        DETAILINFO artistHomeContentsRes$RESPONSE$DETAILINFO0 = (DETAILINFO)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitleClickable(false);
        }
        if(artistHomeContentsRes$RESPONSE$DETAILINFO0.memberList == null || !artistHomeContentsRes$RESPONSE$DETAILINFO0.memberList.isEmpty() != 1) {
            MainTabTitleView mainTabTitleView2 = this.getTitleView();
            if(mainTabTitleView2 != null) {
                mainTabTitleView2.setTitle(this.getString(0x7F13012E));  // string:artist_detail_group_and_unit_artist "소속 그룹 / 유닛 아티스트"
            }
            list0 = artistHomeContentsRes$RESPONSE$DETAILINFO0.groupList;
        }
        else {
            MainTabTitleView mainTabTitleView1 = this.getTitleView();
            if(mainTabTitleView1 != null) {
                mainTabTitleView1.setTitle(this.getString(0x7F13010E));  // string:artist_channel_member "멤버"
            }
            list0 = artistHomeContentsRes$RESPONSE$DETAILINFO0.memberList;
        }
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            GroupRecyclerAdapter artistGroupHolder$GroupRecyclerAdapter0 = this.innerAdapter;
            if(artistGroupHolder$GroupRecyclerAdapter0 != null) {
                artistGroupHolder$GroupRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private final void openArtistInfo(RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0, int v) {
        Navigator.openArtistInfo(artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistId());
        p8.f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130CDA);  // string:tiara_artist_layer1_group_member_channel "소속그룹/멤버채널"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistId();
            f0.f = Y.i(ContsTypeCode.ARTIST, "code(...)");
            f0.g = artistHomeContentsRes$RelatedArtistsInfoBase0.getArtistName();
            f0.a().track();
        }
    }
}

