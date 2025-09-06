package com.iloen.melon.fragments.genre;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.GenreDetailArtistReq;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000BJ!\u0010\u0011\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0016\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0014\u001A\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\"\u001A\u00020!2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001FH\u0014¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b$\u0010%J\u000F\u0010\'\u001A\u00020&H\u0014¢\u0006\u0004\b\'\u0010(R\u0018\u0010)\u001A\u0004\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001A\u0004\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b+\u0010*¨\u0006."}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistDetailBottomFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes;", "fetchData", "()Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxFixedHeight", "()I", "mGnrArtistSeq", "Ljava/lang/String;", "mHeaderCacheKey", "Companion", "AlbumAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreArtistDetailBottomFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistDetailBottomFragment$AlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes$RESPONSE$ALBUMLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreArtistDetailBottomFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ALBUM", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class AlbumAdapter extends p {
        private final int VIEW_TYPE_ALBUM;

        public AlbumAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreArtistDetailBottomFragment.this = genreArtistDetailBottomFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ALBUM = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_ALBUM;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.VIEW_TYPE_ALBUM) {
                Object object0 = this.getItem(v1);
                if(((ALBUMLIST)object0) != null) {
                    boolean z = ((ALBUMLIST)object0).canService;
                    ViewUtils.setEnable(((AlbumHolder)o00).wrapperLayout, z);
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).btnPlayIv, new a(z, GenreArtistDetailBottomFragment.this, v1, ((ALBUMLIST)object0), this, 0));
                    if(z) {
                        e e0 = new e(2, ((ALBUMLIST)object0), GenreArtistDetailBottomFragment.this);
                        ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, e0);
                    }
                    else {
                        ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, null);
                    }
                    b b0 = new b(GenreArtistDetailBottomFragment.this, ((ALBUMLIST)object0), this, 0);
                    ViewUtils.setOnLongClickListener(((AlbumHolder)o00).itemView, b0);
                    ((AlbumHolder)o00).btnPlayIv.setImageResource((z ? 0x7F080309 : 0x7F0801F1));  // drawable:common_btn_play_01
                    ImageView imageView0 = ((AlbumHolder)o00).thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(((ALBUMLIST)object0).albumImg).into(((AlbumHolder)o00).thumbnailIv);
                    }
                    ((AlbumHolder)o00).titleTv.setText(((ALBUMLIST)object0).albumName);
                    ((AlbumHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList));
                    ((AlbumHolder)o00).issueTv.setText(((ALBUMLIST)object0).issueDate);
                    ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                    ((AlbumHolder)o00).ratingView.c(((ALBUMLIST)object0).totAvrgScore);
                    ((AlbumHolder)o00).ratingText.setText(String.valueOf(((ALBUMLIST)object0).totAvrgScore));
                    ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(((ALBUMLIST)object0).ptcPnmPrco, 0x3B9AC9FF));
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(boolean z, GenreArtistDetailBottomFragment genreArtistDetailBottomFragment0, int v, ALBUMLIST genreDetailArtistRes$RESPONSE$ALBUMLIST0, AlbumAdapter genreArtistDetailBottomFragment$AlbumAdapter0, View view0) {
            if(z) {
                genreArtistDetailBottomFragment0.playAlbum(v);
                return;
            }
            genreArtistDetailBottomFragment0.showContextPopupAlbum(Playable.from(genreDetailArtistRes$RESPONSE$ALBUMLIST0, genreArtistDetailBottomFragment$AlbumAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$1(ALBUMLIST genreDetailArtistRes$RESPONSE$ALBUMLIST0, GenreArtistDetailBottomFragment genreArtistDetailBottomFragment0, View view0) {
            if(!TextUtils.isEmpty(genreDetailArtistRes$RESPONSE$ALBUMLIST0.albumId)) {
                genreArtistDetailBottomFragment0.showAlbumInfoPage(genreDetailArtistRes$RESPONSE$ALBUMLIST0.albumId);
            }
        }

        private static final boolean onBindViewImpl$lambda$2(GenreArtistDetailBottomFragment genreArtistDetailBottomFragment0, ALBUMLIST genreDetailArtistRes$RESPONSE$ALBUMLIST0, AlbumAdapter genreArtistDetailBottomFragment$AlbumAdapter0, View view0) {
            genreArtistDetailBottomFragment0.showContextPopupAlbum(Playable.from(genreDetailArtistRes$RESPONSE$ALBUMLIST0, genreArtistDetailBottomFragment$AlbumAdapter0.getMenuId(), null));
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_ALBUM ? new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false)) : null;  // layout:listitem_album
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistDetailBottomFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GNR_ARTIST_SEQ", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreArtistDetailBottomFragment;", "gnrArtistSeq", "headerCacheKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreArtistDetailBottomFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "gnrArtistSeq");
            q.g(s1, "headerCacheKey");
            GenreArtistDetailBottomFragment genreArtistDetailBottomFragment0 = new GenreArtistDetailBottomFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGnrArtistSeq", s);
            bundle0.putString("argCacheKey", s1);
            genreArtistDetailBottomFragment0.setArguments(bundle0);
            return genreArtistDetailBottomFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GNR_ARTIST_SEQ;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    @Nullable
    private String mGnrArtistSeq;
    @Nullable
    private String mHeaderCacheKey;

    static {
        GenreArtistDetailBottomFragment.Companion = new Companion(null);
        GenreArtistDetailBottomFragment.$stable = 8;
        GenreArtistDetailBottomFragment.TAG = "GenreArtistDetailBottomFragment";
        GenreArtistDetailBottomFragment.ARG_GNR_ARTIST_SEQ = "argGnrArtistSeq";
    }

    public GenreArtistDetailBottomFragment() {
        this.mGnrArtistSeq = "";
    }

    public static final String access$getARG_GNR_ARTIST_SEQ$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View buildParallaxHeaderView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new AlbumAdapter(this, context0, null);
        ((j)j00).setListContentType(2);
        return j00;
    }

    private final GenreDetailArtistRes fetchData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.mHeaderCacheKey);
        if(cursor0 != null && cursor0.getCount() > 0) {
            GenreDetailArtistRes genreDetailArtistRes0 = (GenreDetailArtistRes)com.iloen.melon.responsecache.a.d(cursor0, GenreDetailArtistRes.class);
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            if(genreDetailArtistRes0 == null) {
                LogU.Companion.w("GenreArtistDetailBottomFragment", "fetchData() failed to extract contents");
                return null;
            }
            return genreDetailArtistRes0;
        }
        LogU.Companion.w("GenreArtistDetailBottomFragment", "fetchData() invalid cursor");
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        String s1 = this.mHeaderCacheKey;
        q.d(s1);
        LogU.Companion.d("GenreArtistDetailBottomFragment", "onFetchStart() >> mHeaderCacheKey: " + s1);
        GenreDetailArtistRes genreDetailArtistRes0 = this.fetchData();
        if(genreDetailArtistRes0 == null) {
            RequestBuilder.newInstance(new GenreDetailArtistReq(this.getContext(), this.mGnrArtistSeq)).tag("GenreArtistDetailBottomFragment").listener(new k(this, i0, 1)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(20)).request();
            return false;
        }
        this.performFetchComplete(i0, genreDetailArtistRes0);
        return false;
    }

    private static final void onFetchStart$lambda$0(GenreArtistDetailBottomFragment genreArtistDetailBottomFragment0, i i0, GenreDetailArtistRes genreDetailArtistRes0) {
        if(!genreArtistDetailBottomFragment0.prepareFetchComplete(genreDetailArtistRes0)) {
            return;
        }
        genreArtistDetailBottomFragment0.performFetchComplete(i0, genreDetailArtistRes0);
    }

    private static final void onFetchStart$lambda$1(VolleyError volleyError0) {
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.mGnrArtistSeq = bundle0.getString("argGnrArtistSeq");
        this.mHeaderCacheKey = bundle0.getString("argCacheKey");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGnrArtistSeq", this.mGnrArtistSeq);
        bundle0.putString("argCacheKey", this.mHeaderCacheKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    public static void r0(VolleyError volleyError0) {
    }
}

