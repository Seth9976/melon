package com.iloen.melon.fragments.detail.viewholder;

import J8.N1;
import J8.O1;
import J8.c0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.O;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 .2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0004./01B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001A\u001A\u00020\u00102\u0012\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001F\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001F\u0010 R\u0018\u0010\"\u001A\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u001C\u0010%\u001A\b\u0018\u00010$R\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\'\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(R$\u0010,\u001A\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "LJ8/c0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/c0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Landroidx/recyclerview/widget/O0;", "vh", "item", "", "position", "Lie/H;", "bindItem", "(Landroidx/recyclerview/widget/O0;Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;I)V", "", "photoId", "itemClickLog", "(Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Landroid/widget/ImageView;", "imageView", "image", "setThumbImage", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$InnerRecyclerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$InnerRecyclerAdapter;", "holderBind", "LJ8/c0;", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "Lkotlin/collections/ArrayList;", "photoList", "Ljava/util/ArrayList;", "Companion", "InnerRecyclerAdapter", "PhotoSquareViewHolder", "PhotoWideViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PhotoHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_H", "", "VIEW_TYPE_W", "SIZE_FLAG_W", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PhotoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new PhotoHolder(c0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0014\u001A\u00020\u00132\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$InnerRecyclerAdapter;", "Lcom/iloen/melon/adapters/common/c;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder;Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "position", "getItemViewType", "(I)I", "Lie/H;", "setItems", "(Ljava/util/List;)V", "vh", "initViewHolder", "(Landroidx/recyclerview/widget/O0;)V", "rawPosition", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerRecyclerAdapter extends c {
        public InnerRecyclerAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            PHOTO detailBaseRes$PHOTO0 = (PHOTO)this.getItem(v);
            return q.b((detailBaseRes$PHOTO0 == null ? null : detailBaseRes$PHOTO0.photoImgSizeFlg), "W") ? 2 : 1;
        }

        public void initViewHolder(@NotNull O0 o00) {
            q.g(o00, "vh");
            if(o00 instanceof PhotoSquareViewHolder) {
                ((PhotoSquareViewHolder)o00).getBind().b.b.setImageDrawable(null);
                return;
            }
            if(o00 instanceof PhotoWideViewHolder) {
                ((PhotoWideViewHolder)o00).getBind().b.b.setImageDrawable(null);
            }
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "vh");
            this.initViewHolder(o00);
            PHOTO detailBaseRes$PHOTO0 = (PHOTO)this.getItem(v1);
            PhotoHolder.this.bindItem(o00, detailBaseRes$PHOTO0, v1);
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == 2 ? new PhotoWideViewHolder(O1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0)) : new PhotoSquareViewHolder(N1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
        }

        public final void setItems(@NotNull List list0) {
            q.g(list0, "list");
            this.clear(false);
            this.addAll(list0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$PhotoSquareViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/N1;", "listitemDetailPhotoHBinding", "<init>", "(LJ8/N1;)V", "bind", "LJ8/N1;", "getBind", "()LJ8/N1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class PhotoSquareViewHolder extends O0 {
        @NotNull
        private final N1 bind;

        public PhotoSquareViewHolder(@NotNull N1 n10) {
            q.g(n10, "listitemDetailPhotoHBinding");
            super(n10.a);
            this.bind = n10;
        }

        @NotNull
        public final N1 getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder$PhotoWideViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/O1;", "listitemDetailPhotoWBinding", "<init>", "(LJ8/O1;)V", "bind", "LJ8/O1;", "getBind", "()LJ8/O1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class PhotoWideViewHolder extends O0 {
        @NotNull
        private final O1 bind;

        public PhotoWideViewHolder(@NotNull O1 o10) {
            q.g(o10, "listitemDetailPhotoWBinding");
            super(o10.a);
            this.bind = o10;
        }

        @NotNull
        public final O1 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String SIZE_FLAG_W = "W";
    @NotNull
    public static final String TAG = "PhotoHolder";
    public static final int VIEW_TYPE_H = 1;
    public static final int VIEW_TYPE_W = 2;
    @NotNull
    private c0 holderBind;
    @Nullable
    private InnerRecyclerAdapter innerAdapter;
    @NotNull
    private final ArrayList photoList;
    @Nullable
    private RecyclerView recyclerView;

    static {
        PhotoHolder.Companion = new Companion(null);
        PhotoHolder.$stable = 8;
    }

    public PhotoHolder(@NotNull c0 c00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(c00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(c00, onViewHolderActionBaseListener0);
        this.holderBind = c00;
        this.photoList = new ArrayList();
        this.setTitleView(this.holderBind.b);
        this.recyclerView = this.holderBind.c;
        this.holderBind.c.setHasFixedSize(true);
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView1 = this.recyclerView;
        if(recyclerView1 != null) {
            recyclerView1.addItemDecoration(new O());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if(recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(0, false));
        }
        this.innerAdapter = new InnerRecyclerAdapter(this, this.getContext(), null);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final void bindItem(O0 o00, PHOTO detailBaseRes$PHOTO0, int v) {
        String s = null;
        if(o00 instanceof PhotoSquareViewHolder) {
            MelonImageView melonImageView0 = ((PhotoSquareViewHolder)o00).getBind().b.b;
            if(detailBaseRes$PHOTO0 != null) {
                s = detailBaseRes$PHOTO0.photoImg;
            }
            this.setThumbImage(melonImageView0, s);
        }
        else if(o00 instanceof PhotoWideViewHolder) {
            MelonImageView melonImageView1 = ((PhotoWideViewHolder)o00).getBind().b.b;
            if(detailBaseRes$PHOTO0 != null) {
                s = detailBaseRes$PHOTO0.photoImg;
            }
            this.setThumbImage(melonImageView1, s);
        }
        l l0 = new l(this, v, detailBaseRes$PHOTO0);
        o00.itemView.setOnClickListener(l0);
    }

    private static final void bindItem$lambda$4(PhotoHolder photoHolder0, int v, PHOTO detailBaseRes$PHOTO0, View view0) {
        String s;
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildArtistInfoParams(photoHolder0.photoList, false, v, photoHolder0.photoList.size(), "");
        Navigator.open(com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null));
        if(detailBaseRes$PHOTO0 == null) {
            s = "";
        }
        else {
            s = detailBaseRes$PHOTO0.photoId;
            if(s == null) {
                s = "";
            }
        }
        photoHolder0.itemClickLog(s);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() [...] // 潜在的解密器

    private final void itemClickLog(String s) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130DDC);  // string:tiara_common_layer1_album_photo "이앨범의포토"
            f0.e = s;
            f0.f = this.getString(0x7F130F9C);  // string:tiara_photo_meta_type_photo "포토"
            f0.a().track();
        }
    }

    @NotNull
    public static final PhotoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PhotoHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle("");
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(list0 != null && !q.b((this.innerAdapter == null ? null : this.innerAdapter.getList()), list0)) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.setAdapter(this.innerAdapter);
            }
            for(Object object0: list0) {
                PhotoItem photoDetailViewFragment$PhotoItem0 = new PhotoItem(((PHOTO)object0).photoId, "", null, null, null, 16, null);
                this.photoList.add(photoDetailViewFragment$PhotoItem0);
            }
            InnerRecyclerAdapter photoHolder$InnerRecyclerAdapter0 = this.innerAdapter;
            if(photoHolder$InnerRecyclerAdapter0 != null) {
                photoHolder$InnerRecyclerAdapter0.setItems(list0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    public final void setThumbImage(@NotNull ImageView imageView0, @Nullable String s) {
        q.g(imageView0, "imageView");
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(s).into(imageView0);
        }
    }
}

