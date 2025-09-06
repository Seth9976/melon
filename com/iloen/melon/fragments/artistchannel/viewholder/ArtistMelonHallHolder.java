package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.n;
import De.I;
import J8.I1;
import J8.U;
import J8.f3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.MELONHALLLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import va.e;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003$%&B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001A\u001A\u00020\u00102\u0012\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u001C\u0010 \u001A\b\u0018\u00010\u001FR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$MELONHALLLIST;", "LJ8/U;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/U;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;", "vh", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$MELONHALLLIST;I)V", "", "albumBadgeCount", "getBadge", "(Ljava/lang/String;)I", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$InnerRecyclerAdapter;", "holderBind", "LJ8/U;", "Companion", "InnerRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistMelonHallHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistMelonHallHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new ArtistMelonHallHolder(U.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$MELONHALLLIST;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder artistMelonHallHolder$ViewHolder0) {
            q.g(artistMelonHallHolder$ViewHolder0, "vh");
            artistMelonHallHolder$ViewHolder0.getBind().e.b.setImageDrawable(null);
            artistMelonHallHolder$ViewHolder0.getBind().f.setText("");
            artistMelonHallHolder$ViewHolder0.getBind().b.setText("");
            artistMelonHallHolder$ViewHolder0.getBind().c.setImageDrawable(null);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder artistMelonHallHolder$ViewHolder0, int v, int v1) {
            q.g(artistMelonHallHolder$ViewHolder0, "vh");
            this.initViewHolder(artistMelonHallHolder$ViewHolder0);
            MELONHALLLIST artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 = (MELONHALLLIST)this.getItem(v1);
            ArtistMelonHallHolder.this.bindItem(artistMelonHallHolder$ViewHolder0, artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = o.e(viewGroup0, 0x7F0D0478, viewGroup0, false);  // layout:listitem_detail_artist_melon_hall_album
            int v1 = 0x7F0A008A;  // id:album_name
            View view1 = I.C(view0, 0x7F0A008A);  // id:album_name
            if(((MelonTextView)view1) != null) {
                v1 = 0x7F0A00EB;  // id:badge
                View view2 = I.C(view0, 0x7F0A00EB);  // id:badge
                if(((ImageView)view2) != null) {
                    v1 = 0x7F0A00EC;  // id:badge_text
                    View view3 = I.C(view0, 0x7F0A00EC);  // id:badge_text
                    if(((MelonTextView)view3) != null) {
                        v1 = 0x7F0A056B;  // id:include_thumbnail_layout
                        View view4 = I.C(view0, 0x7F0A056B);  // id:include_thumbnail_layout
                        if(view4 != null) {
                            f3 f30 = f3.a(view4);
                            v1 = 0x7F0A0B8D;  // id:title
                            View view5 = I.C(view0, 0x7F0A0B8D);  // id:title
                            if(((MelonTextView)view5) != null) {
                                return new ViewHolder(new I1(((FrameLayout)view0), ((MelonTextView)view1), ((ImageView)view2), ((MelonTextView)view3), f30, ((MelonTextView)view5)));
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/I1;", "listitemDetailArtistMelonHallAlbumBinding", "<init>", "(LJ8/I1;)V", "bind", "LJ8/I1;", "getBind", "()LJ8/I1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final I1 bind;

        public ViewHolder(@NotNull I1 i10) {
            q.g(i10, "listitemDetailArtistMelonHallAlbumBinding");
            super(i10.a);
            this.bind = i10;
        }

        @NotNull
        public final I1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistMelonHallHolder";
    @NotNull
    private U holderBind;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistMelonHallHolder.Companion = new Companion(null);
        ArtistMelonHallHolder.$stable = 8;
    }

    public ArtistMelonHallHolder(@NotNull U u0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(u0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(u0, onViewHolderActionBaseListener0);
        this.holderBind = u0;
        this.setTitleView(u0.b);
        this.recyclerView = this.holderBind.c;
        this.holderBind.c.setHasFixedSize(true);
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.addItemDecoration(new O(11.0f));
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        }
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindItem(ViewHolder artistMelonHallHolder$ViewHolder0, MELONHALLLIST artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0, int v) {
        String s3;
        MelonImageView melonImageView0 = artistMelonHallHolder$ViewHolder0.getBind().e.b;
        String s = null;
        Glide.with(melonImageView0).load((artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 == null ? null : artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.albumImg)).into(melonImageView0);
        String s1 = e.b("%s", this.getString(0x7F130131));  // string:artist_detail_melon_hall_millions_album_desc "M 밀리언스 앨범"
        l1.D(new Object[]{(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 == null ? null : artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.millionsAlbumBadge)}, 1, s1, artistMelonHallHolder$ViewHolder0.getBind().f);
        MelonTextView melonTextView0 = artistMelonHallHolder$ViewHolder0.getBind().b;
        if(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 != null) {
            s = artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.albumName;
        }
        melonTextView0.setText(s);
        RequestManager requestManager0 = Glide.with(this.itemView);
        String s2 = "";
        if(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 == null) {
            s3 = "";
        }
        else {
            s3 = artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.millionsAlbumBadge;
            if(s3 == null) {
                s3 = "";
            }
        }
        requestManager0.load(this.getBadge(s3)).into(artistMelonHallHolder$ViewHolder0.getBind().c);
        MelonTextView melonTextView1 = artistMelonHallHolder$ViewHolder0.getBind().d;
        if(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 != null) {
            String s4 = artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.millionsAlbumBadge;
            if(s4 != null) {
                s2 = s4;
            }
        }
        melonTextView1.setText(this.getString(0x7F130130, s2));  // string:artist_detail_melon_hall_millions_album_badge "%1$sM"
        n n0 = new n(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0, this, v, 8);
        artistMelonHallHolder$ViewHolder0.getBind().a.setOnClickListener(n0);
    }

    private static final void bindItem$lambda$4(MELONHALLLIST artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0, ArtistMelonHallHolder artistMelonHallHolder0, int v, View view0) {
        String s = null;
        MelonLinkExecutor.open(MelonLinkInfo.b((artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 == null ? null : artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.linkInfo)));
        f f0 = artistMelonHallHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistMelonHallHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistMelonHallHolder0.getString(0x7F130DFD);  // string:tiara_common_layer1_melon_hall "멜론의 전당"
            f0.c(v + 1);
            f0.e = artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 == null ? null : artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.albumId;
            f0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            if(artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0 != null) {
                s = artistHomeBasicInfoRes$RESPONSE$MELONHALLLIST0.albumName;
            }
            f0.g = s;
            f0.a().track();
        }
    }

    private final int getBadge(String s) {
        int v;
        try {
            v = Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
            return 0x7F0800AD;  // drawable:badge_millions_1_m_50
        }
        if(v >= 10) {
            return 0x7F0800AB;  // drawable:badge_millions_10_m_50
        }
        if(v >= 5) {
            return 0x7F0800B1;  // drawable:badge_millions_5_m_50
        }
        return v < 3 ? 0x7F0800AD : 0x7F0800AF;  // drawable:badge_millions_1_m_50
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130606);  // string:melon_hall "멜론의 전당"
    }

    @NotNull
    public static final ArtistMelonHallHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistMelonHallHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
            mainTabTitleView0.setTitleClickable(true);
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    MelonLinkExecutor.open(this.getViewAllLinkInfo());
                    f f0 = ArtistMelonHallHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistMelonHallHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistMelonHallHolder.this.getString(0x7F130DFD);  // string:tiara_common_layer1_melon_hall "멜론의 전당"
                        f0.F = ArtistMelonHallHolder.this.getString(0x7F130D9A);  // string:tiara_click_copy_shortcut "바로가기"
                        f0.a().track();
                    }
                }
            });
            mainTabTitleView0.setViewAllText(0x7F130908);  // string:search_tag_shortcut "바로가기"
        }
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            InnerRecyclerAdapter artistMelonHallHolder$InnerRecyclerAdapter0 = this.innerAdapter;
            if(artistMelonHallHolder$InnerRecyclerAdapter0 != null) {
                artistMelonHallHolder$InnerRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

