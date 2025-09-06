package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.n;
import De.I;
import J8.B1;
import J8.o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.O;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 !2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0003!\"#B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001A\u00020\u00102\u0012\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001D\u001A\b\u0018\u00010\u001CR\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "LJ8/o;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/o;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;", "vh", "item", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;I)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$HorizontalLinearRecyclerAdapter;", "horizontalLinearAdapter", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$HorizontalLinearRecyclerAdapter;", "holderBind", "LJ8/o;", "Companion", "HorizontalLinearRecyclerAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistPhotoLinearHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPhotoLinearHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D003D, viewGroup0, false);  // layout:artist_detail_photo_linear
            int v = 0x7F0A05A7;  // id:item_container
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(recyclerView0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new ArtistPhotoLinearHolder(new o(((LinearLayout)view0), recyclerView0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0011\u001A\u00020\u00102\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$HorizontalLinearRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;)V", "rawPosition", "position", "onBindViewHolder", "(Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HorizontalLinearRecyclerAdapter extends c {
        public HorizontalLinearRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public void initViewHolder(O0 o00) {
            this.initViewHolder(((ViewHolder)o00));
        }

        public void initViewHolder(@NotNull ViewHolder artistPhotoLinearHolder$ViewHolder0) {
            q.g(artistPhotoLinearHolder$ViewHolder0, "vh");
            artistPhotoLinearHolder$ViewHolder0.getBind().b.c.setImageResource(0x7F080786);  // drawable:noimage_logo_large
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder artistPhotoLinearHolder$ViewHolder0, int v, int v1) {
            q.g(artistPhotoLinearHolder$ViewHolder0, "vh");
            this.initViewHolder(artistPhotoLinearHolder$ViewHolder0);
            PHOTO detailBaseRes$PHOTO0 = (PHOTO)this.getItem(v1);
            q.d(detailBaseRes$PHOTO0);
            ArtistPhotoLinearHolder.this.bindItem(artistPhotoLinearHolder$ViewHolder0, detailBaseRes$PHOTO0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return new ViewHolder(B1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/B1;", "listitemArtistPhotoBinding", "<init>", "(LJ8/B1;)V", "bind", "LJ8/B1;", "getBind", "()LJ8/B1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @NotNull
        private final B1 bind;

        public ViewHolder(@NotNull B1 b10) {
            q.g(b10, "listitemArtistPhotoBinding");
            super(b10.a);
            this.bind = b10;
        }

        @NotNull
        public final B1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistPhotoLinearHolder";
    @NotNull
    private o holderBind;
    @Nullable
    private HorizontalLinearRecyclerAdapter horizontalLinearAdapter;
    @Nullable
    private RecyclerView recyclerView;

    static {
        ArtistPhotoLinearHolder.Companion = new Companion(null);
        ArtistPhotoLinearHolder.$stable = 8;
    }

    public ArtistPhotoLinearHolder(@NotNull o o0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(o0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(o0, onViewHolderActionBaseListener0);
        this.holderBind = o0;
        this.setTitleView(o0.c);
        RecyclerView recyclerView0 = this.holderBind.b;
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setNestedScrollingEnabled(false);
        recyclerView0.addItemDecoration(new O(11.0f));
        ScreenUtils.getScreenWidth(recyclerView0.getContext());
        recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()) {
            final RecyclerView $this_apply;

            {
                this.$this_apply = recyclerView0;
                super(0, false);
            }

            @Override  // androidx.recyclerview.widget.w0
            public boolean checkLayoutParams(LayoutParams recyclerView$LayoutParams0) {
                int v;
                if(recyclerView$LayoutParams0 != null) {
                    if(ScreenUtils.isTablet(this.$this_apply.getContext())) {
                        v = ScreenUtils.dipToPixel(this.$this_apply.getContext(), 283.0f);
                    }
                    else {
                        v = ScreenUtils.isPortrait(this.$this_apply.getContext()) ? this.getWidth() - ScreenUtils.dipToPixel(this.$this_apply.getContext(), 40.0f) : ScreenUtils.dipToPixel(this.$this_apply.getContext(), 320.0f);
                    }
                    recyclerView$LayoutParams0.width = v;
                    recyclerView$LayoutParams0.height = v;
                    return true;
                }
                return false;
            }
        });
        this.recyclerView = recyclerView0;
        this.horizontalLinearAdapter = new HorizontalLinearRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindItem(ViewHolder artistPhotoLinearHolder$ViewHolder0, PHOTO detailBaseRes$PHOTO0, int v) {
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(detailBaseRes$PHOTO0.photoImg).into(artistPhotoLinearHolder$ViewHolder0.getBind().b.b);
        }
        B1 b10 = artistPhotoLinearHolder$ViewHolder0.getBind();
        n n0 = new n(detailBaseRes$PHOTO0, this, v, 10);
        b10.b.b.setOnClickListener(n0);
        String s = b10.b.b.getContext().getString(0x7F130BB3, new Object[]{detailBaseRes$PHOTO0.photoName});  // string:talkback_photo_item "%1$s, 포토, 상세보기"
        b10.b.b.setContentDescription(s);
    }

    private static final void bindItem$lambda$6$lambda$5(PHOTO detailBaseRes$PHOTO0, ArtistPhotoLinearHolder artistPhotoLinearHolder0, int v, View view0) {
        Navigator.INSTANCE.openPhotoInfo(detailBaseRes$PHOTO0.photoId);
        f f0 = artistPhotoLinearHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistPhotoLinearHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistPhotoLinearHolder0.getString(0x7F130E03);  // string:tiara_common_layer1_photo "포토"
            f0.c(v + 1);
            f0.e = detailBaseRes$PHOTO0.photoId;
            f0.f = Y.i(ContsTypeCode.PHOTO, "code(...)");
            f0.g = detailBaseRes$PHOTO0.photoName;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302F9);  // string:detail_common_title_photo "포토"
    }

    @NotNull
    public static final ArtistPhotoLinearHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistPhotoLinearHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
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
                    Navigator.open(ArtistDetailContentsPhotoFragment.Companion.newInstance(this.getContentId()));
                    f f0 = ArtistPhotoLinearHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistPhotoLinearHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistPhotoLinearHolder.this.getString(0x7F130E03);  // string:tiara_common_layer1_photo "포토"
                        f0.F = ArtistPhotoLinearHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        if(list0 != null && !q.b((this.horizontalLinearAdapter == null ? null : this.horizontalLinearAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.horizontalLinearAdapter);
            }
            HorizontalLinearRecyclerAdapter artistPhotoLinearHolder$HorizontalLinearRecyclerAdapter0 = this.horizontalLinearAdapter;
            if(artistPhotoLinearHolder$HorizontalLinearRecyclerAdapter0 != null) {
                artistPhotoLinearHolder$HorizontalLinearRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

