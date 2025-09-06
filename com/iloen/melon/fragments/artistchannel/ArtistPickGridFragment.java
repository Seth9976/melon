package com.iloen.melon.fragments.artistchannel;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailPhotoSpanSizeLookup;
import com.iloen.melon.fragments.detail.PhotoGridSpacingItemDecoration;
import com.iloen.melon.fragments.detail.PhotoGridSpacingItemDecorationKt;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ArtistPickWholeListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistPickWholeListReq;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes.RESPONSE.ArtistPick;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 72\u00020\u0001:\u000278B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u0017\u0010\u0010\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ-\u0010#\u001A\u00020\"2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010!\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010,R\u0016\u0010-\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010.R\u0014\u00106\u001A\u0002038BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b4\u00105\u00A8\u00069"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "artistId", "Ljava/lang/String;", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "viewType", "", "getSpanCount", "()I", "spanCount", "Companion", "ArtistPickGridAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistPickGridFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment$ArtistPickGridAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ArtistPickWholeListRes$RESPONSE$ArtistPick;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ArtistPickGridAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment$ArtistPickGridAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment$ArtistPickGridAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvLike", "Landroid/widget/TextView;", "getTvLike", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemViewHolder extends O0 {
            @NotNull
            private final ImageView ivThumb;
            @NotNull
            private final TextView tvLike;

            public ItemViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ArtistPickGridAdapter.this = artistPickGridFragment$ArtistPickGridAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
                q.f(view1, "findViewById(...)");
                this.ivThumb = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A0C99);  // id:tv_like
                q.f(view2, "findViewById(...)");
                this.tvLike = (TextView)view2;
            }

            @NotNull
            public final ImageView getIvThumb() {
                return this.ivThumb;
            }

            @NotNull
            public final TextView getTvLike() {
                return this.tvLike;
            }
        }

        public ArtistPickGridAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == 1) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.ArtistPickWholeListRes.RESPONSE.ArtistPick");
                ((ItemViewHolder)o00).getTvLike().setText(StringUtils.getCountString(((ArtistPick)object0).likeCnt, 0x1869F));
                Glide.with(this.getContext()).load(((ArtistPick)object0).artistPickThumbUrl).into(new CustomTarget() {
                    @Override  // com.bumptech.glide.request.target.Target
                    public void onLoadCleared(Drawable drawable0) {
                    }

                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                        q.g(drawable0, "drawable");
                        this.$vh.getIvThumb().setScaleType((drawable0.getIntrinsicWidth() <= drawable0.getIntrinsicHeight() ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER));
                        this.$vh.getIvThumb().setImageDrawable(drawable0);
                    }

                    @Override  // com.bumptech.glide.request.target.Target
                    public void onResourceReady(Object object0, Transition transition0) {
                        this.onResourceReady(((Drawable)object0), transition0);
                    }
                });
                com.iloen.melon.fragments.artistchannel.p p0 = new com.iloen.melon.fragments.artistchannel.p(ArtistPickGridFragment.this, this, v1, ((ArtistPick)object0));
                ((ItemViewHolder)o00).itemView.setOnClickListener(p0);
                String s = ArtistPickGridFragment.this.getString(0x7F130AD6, new Object[]{((ArtistPick)object0).artistPickTitle, ((ArtistPick)object0).likeCnt});  // string:talkback_artistpick_item "%1$s, 좋아요 %2$s개, 재생하기"
                ViewUtils.setContentDescriptionWithButtonClassName(((ItemViewHolder)o00).itemView, s);
            }
        }

        private static final void onBindViewImpl$lambda$0(ArtistPickGridFragment artistPickGridFragment0, ArtistPickGridAdapter artistPickGridFragment$ArtistPickGridAdapter0, int v, ArtistPick artistPickWholeListRes$RESPONSE$ArtistPick0, View view0) {
            String s = MelonContentUris.S0.buildUpon().appendPath(artistPickGridFragment0.artistId).build().toString();
            q.f(s, "toString(...)");
            a.c(artistPickGridFragment$ArtistPickGridAdapter0.getContext(), s, true);
            if(artistPickGridFragment0.mMelonTiaraProperty != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.a = artistPickGridFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                g0.b = artistPickGridFragment0.mMelonTiaraProperty.a;
                g0.c = artistPickGridFragment0.mMelonTiaraProperty.b;
                g0.y = artistPickGridFragment0.getString(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
                g0.C = String.valueOf(v + 1);
                g0.o = artistPickWholeListRes$RESPONSE$ArtistPick0.artistId;
                g0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
                g0.q = artistPickWholeListRes$RESPONSE$ArtistPick0.artistName;
                g0.e = artistPickWholeListRes$RESPONSE$ArtistPick0.artistPickSeq;
                g0.I = artistPickGridFragment0.mMelonTiaraProperty.c;
                g0.a().track();
            }
            String s1 = artistPickWholeListRes$RESPONSE$ArtistPick0.artistId;
            q.f(s1, "artistId");
            Navigator.open(ArtistPickFragment.Companion.newInstance(s1, artistPickGridFragment0.viewType, artistPickWholeListRes$RESPONSE$ArtistPick0.artistPickSeq));
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = ArtistPickGridFragment.this.getLayoutInflater().inflate(0x7F0D01FE, viewGroup0, false);  // layout:detail_artist_pick_grid_item
            q.f(view0, "inflate(...)");
            return new ItemViewHolder(this, view0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_ITEM", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistPickGridFragment;", "artistId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPickGridFragment newInstance(@NotNull String s) {
            q.g(s, "artistId");
            ArtistPickGridFragment artistPickGridFragment0 = new ArtistPickGridFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            artistPickGridFragment0.setArguments(bundle0);
            return artistPickGridFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistPickGridFragment";
    private static final int VIEW_TYPE_ITEM = 1;
    @NotNull
    private String artistId;
    @Nullable
    private GridLayoutManager layoutManager;
    @NotNull
    private String viewType;

    static {
        ArtistPickGridFragment.Companion = new Companion(null);
        ArtistPickGridFragment.$stable = 8;
    }

    public ArtistPickGridFragment() {
        this.artistId = "";
        this.viewType = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ArtistPickGridAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.b.buildUpon().appendPath("CACHE_KEY_ARTIST_PICK_LIST"), this.artistId, "toString(...)");
    }

    private final int getSpanCount() {
        return PhotoGridSpacingItemDecorationKt.getPhotoSpanCount(this.getContext());
    }

    @NotNull
    public static final ArtistPickGridFragment newInstance(@NotNull String s) {
        return ArtistPickGridFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        GridLayoutManager gridLayoutManager0 = this.layoutManager;
        if(gridLayoutManager0 != null) {
            gridLayoutManager0.P(this.getSpanCount());
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(((RecyclerView)view0).getContext(), this.getSpanCount());
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistPickGridFragment.ArtistPickGridAdapter");
        gridLayoutManager0.g = new DetailPhotoSpanSizeLookup(gridLayoutManager0, ((ArtistPickGridAdapter)j00));
        this.layoutManager = gridLayoutManager0;
        ((RecyclerView)view0).setLayoutManager(gridLayoutManager0);
        ((RecyclerView)view0).addItemDecoration(new PhotoGridSpacingItemDecoration());
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D01FD, null, false);  // layout:detail_artist_pick_grid
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistPickGridFragment.ArtistPickGridAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((ArtistPickGridAdapter)j00).clear();
        }
        Params artistPickWholeListReq$Params0 = new Params();
        artistPickWholeListReq$Params0.artistId = this.artistId;
        artistPickWholeListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((ArtistPickGridAdapter)j00).getCount() + 1;
        artistPickWholeListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ArtistPickWholeListReq(this.getContext(), artistPickWholeListReq$Params0)).tag(this.getRequestTag()).listener(new c(14, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(ArtistPickGridFragment artistPickGridFragment0, i i0, ArtistPickWholeListRes artistPickWholeListRes0) {
        if(!artistPickGridFragment0.prepareFetchComplete(artistPickWholeListRes0)) {
            return;
        }
        RESPONSE artistPickWholeListRes$RESPONSE0 = artistPickWholeListRes0.response;
        artistPickGridFragment0.mMelonTiaraProperty = new s(artistPickWholeListRes$RESPONSE0.section, artistPickWholeListRes$RESPONSE0.page, artistPickWholeListRes$RESPONSE0.menuId, null);
        String s = artistPickWholeListRes$RESPONSE0.viewType;
        q.f(s, "viewType");
        artistPickGridFragment0.viewType = s;
        artistPickGridFragment0.performFetchComplete(i0, artistPickWholeListRes0);
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
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F13011B));  // string:artist_detail_artist_pick "아티스트 PICK"
        }
    }
}

