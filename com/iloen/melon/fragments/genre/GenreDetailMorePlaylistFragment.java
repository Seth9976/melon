package com.iloen.melon.fragments.genre;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailGridLayoutManager;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.request.GenreMorePlaylistReq.Params;
import com.iloen.melon.net.v5x.request.GenreMorePlaylistReq;
import com.iloen.melon.net.v5x.response.GenreMorePlaylistRes;
import com.iloen.melon.net.v5x.response.GenrePlayListInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 /2\u00020\u0001:\u0004/012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001C\u0010\u001AJ\u001D\u0010 \u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001A\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u000EH\u0016¢\u0006\u0004\b%\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(R\u0018\u0010*\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+R\u001A\u0010-\u001A\u00060,R\u00020\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "isWideMode", "()Z", "", "getPlylistSpanCount", "()I", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "gnrCode", "Ljava/lang/String;", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "gridLayoutManager", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$GridSpacingItemDecoration;", "gridSpacingItemDecoration", "Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$GridSpacingItemDecoration;", "Companion", "PlaylistAdapter", "PlaylistItemHolder", "GridSpacingItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class GenreDetailMorePlaylistFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GENRE_CODE", "GRID_COUNT_PORTRAIT", "", "GRID_COUNT_LAND", "GRID_COUNT_PORTRAIT_WIDE", "GRID_COUNT_LAND_WIDE", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment;", "genreCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailMorePlaylistFragment newInstance(@NotNull String s) {
            q.g(s, "genreCode");
            GenreDetailMorePlaylistFragment genreDetailMorePlaylistFragment0 = new GenreDetailMorePlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            genreDetailMorePlaylistFragment0.setArguments(bundle0);
            return genreDetailMorePlaylistFragment0;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "spanCount", "spacingDip", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment;II)V", "Lie/H;", "setSpanCount", "(I)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "I", "spacingPixel", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GridSpacingItemDecoration extends r0 {
        private final int spacingPixel;
        private int spanCount;

        public GridSpacingItemDecoration(int v, int v1) {
            this.spanCount = v;
            this.spacingPixel = ScreenUtils.dipToPixel(genreDetailMorePlaylistFragment0.getContext(), ((float)v1));
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            float f;
            Context context0;
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            j0 j00 = GenreDetailMorePlaylistFragment.this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMorePlaylistFragment.PlaylistAdapter");
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(!((PlaylistAdapter)j00).isReservedPosition(v)) {
                int v1 = v - ((PlaylistAdapter)j00).getHeaderCount();
                if(v1 >= 0) {
                    int v2 = this.spanCount;
                    int v3 = v1 % v2;
                    rect0.left = this.spacingPixel - v3 * this.spacingPixel / v2;
                    rect0.right = (v3 + 1) * this.spacingPixel / v2;
                    if(v1 < GenreDetailMorePlaylistFragment.this.getPlylistSpanCount()) {
                        context0 = GenreDetailMorePlaylistFragment.this.getContext();
                        f = 16.0f;
                    }
                    else {
                        context0 = GenreDetailMorePlaylistFragment.this.getContext();
                        f = 0.0f;
                    }
                    rect0.top = ScreenUtils.dipToPixel(context0, f);
                    rect0.bottom = ScreenUtils.dipToPixel(GenreDetailMorePlaylistFragment.this.getContext(), (GenreDetailMorePlaylistFragment.this.isWideMode() ? 24.0f : 18.0f));
                }
            }
        }

        public final void setSpanCount(int v) {
            this.spanCount = v;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$PlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_ITEM_PLAYLIST", "I", "getVIEW_ITEM_PLAYLIST", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlaylistAdapter extends p {
        private final int VIEW_ITEM_PLAYLIST;

        public PlaylistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailMorePlaylistFragment.this = genreDetailMorePlaylistFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_ITEM_PLAYLIST;
        }

        public final int getVIEW_ITEM_PLAYLIST() {
            return this.VIEW_ITEM_PLAYLIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.VIEW_ITEM_PLAYLIST) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.GenrePlayListInfoBase");
                ViewUtils.setOnClickListener(((PlaylistItemHolder)o00).getRootView$app_playstoreProdRelease(), new e(1, ((GenrePlayListInfoBase)object0), ((GenrePlayListInfoBase)object0)));
                ((PlaylistItemHolder)o00).getTitleTv$app_playstoreProdRelease().setText(((GenrePlayListInfoBase)object0).plylsttitle);
                Glide.with(this.getContext()).load(((GenrePlayListInfoBase)object0).thumbimg).into(((PlaylistItemHolder)o00).getThumbnailIv$app_playstoreProdRelease());
                ViewUtils.setOnClickListener(((PlaylistItemHolder)o00).getBtnPlayIv$app_playstoreProdRelease(), new com.iloen.melon.fragments.genre.q(GenreDetailMorePlaylistFragment.this, ((GenrePlayListInfoBase)object0), this, 2));
                ViewUtils.showWhen(((PlaylistItemHolder)o00).getArtistTv$app_playstoreProdRelease(), false);
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$0(GenrePlayListInfoBase genrePlayListInfoBase0, GenrePlayListInfoBase genrePlayListInfoBase1, View view0) {
            ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(genrePlayListInfoBase0.contsTypeCode);
            if(ContsTypeCode.DJ_PLAYLIST.equals(contsTypeCode0)) {
                Navigator.openDjPlaylistDetail(genrePlayListInfoBase1.plylstseq);
                return;
            }
            Navigator.INSTANCE.openPlaylistDetail(genrePlayListInfoBase1.plylstseq);
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(GenreDetailMorePlaylistFragment genreDetailMorePlaylistFragment0, GenrePlayListInfoBase genrePlayListInfoBase0, PlaylistAdapter genreDetailMorePlaylistFragment$PlaylistAdapter0, View view0) {
            genreDetailMorePlaylistFragment0.playPlaylist(genrePlayListInfoBase0.plylstseq, genrePlayListInfoBase0.contsTypeCode, genreDetailMorePlaylistFragment$PlaylistAdapter0.getMenuId(), genrePlayListInfoBase0.statsElements);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D041E, viewGroup0, false);  // layout:griditem_with_btn_right_top
            q.f(view0, "inflate(...)");
            return new PlaylistItemHolder(GenreDetailMorePlaylistFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000B\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\u0006\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000E\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u000E\u0010\u0006\u001A\u0004\b\u000F\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001A\u00020\u00118\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001A\u00020\u00118\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015\"\u0004\b\u001A\u0010\u0017R\"\u0010\u001C\u001A\u00020\u001B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\"\u0010\"\u001A\u00020\u001B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\"\u0010\u001D\u001A\u0004\b#\u0010\u001F\"\u0004\b$\u0010!R\"\u0010%\u001A\u00020\u001B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b%\u0010\u001D\u001A\u0004\b&\u0010\u001F\"\u0004\b\'\u0010!¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment$PlaylistItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "rootView", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMorePlaylistFragment;Landroid/view/View;)V", "Landroid/view/View;", "getRootView$app_playstoreProdRelease", "()Landroid/view/View;", "setRootView$app_playstoreProdRelease", "(Landroid/view/View;)V", "thumbContainer", "getThumbContainer$app_playstoreProdRelease", "setThumbContainer$app_playstoreProdRelease", "ivThumbDefault", "getIvThumbDefault$app_playstoreProdRelease", "setIvThumbDefault$app_playstoreProdRelease", "Landroid/widget/ImageView;", "thumbnailIv", "Landroid/widget/ImageView;", "getThumbnailIv$app_playstoreProdRelease", "()Landroid/widget/ImageView;", "setThumbnailIv$app_playstoreProdRelease", "(Landroid/widget/ImageView;)V", "btnPlayIv", "getBtnPlayIv$app_playstoreProdRelease", "setBtnPlayIv$app_playstoreProdRelease", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv$app_playstoreProdRelease", "()Landroid/widget/TextView;", "setTitleTv$app_playstoreProdRelease", "(Landroid/widget/TextView;)V", "artistTv", "getArtistTv$app_playstoreProdRelease", "setArtistTv$app_playstoreProdRelease", "songCountTv", "getSongCountTv$app_playstoreProdRelease", "setSongCountTv$app_playstoreProdRelease", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class PlaylistItemHolder extends O0 {
        @NotNull
        private TextView artistTv;
        @NotNull
        private ImageView btnPlayIv;
        @NotNull
        private View ivThumbDefault;
        @NotNull
        private View rootView;
        @NotNull
        private TextView songCountTv;
        @NotNull
        private View thumbContainer;
        @NotNull
        private ImageView thumbnailIv;
        @NotNull
        private TextView titleTv;

        public PlaylistItemHolder(@NotNull View view0) {
            q.g(view0, "rootView");
            GenreDetailMorePlaylistFragment.this = genreDetailMorePlaylistFragment0;
            super(view0);
            this.rootView = view0;
            View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
            q.f(view1, "findViewById(...)");
            this.thumbContainer = view1;
            View view2 = this.rootView.findViewById(0x7F0A069E);  // id:iv_thumb_default
            q.f(view2, "findViewById(...)");
            this.ivThumbDefault = view2;
            View view3 = this.rootView.findViewById(0x7F0A069A);  // id:iv_thumb
            q.f(view3, "findViewById(...)");
            this.thumbnailIv = (ImageView)view3;
            View view4 = this.rootView.findViewById(0x7F0A0182);  // id:btn_play
            q.f(view4, "findViewById(...)");
            this.btnPlayIv = (ImageView)view4;
            View view5 = this.rootView.findViewById(0x7F0A0D34);  // id:tv_title
            q.f(view5, "findViewById(...)");
            this.titleTv = (TextView)view5;
            View view6 = this.rootView.findViewById(0x7F0A0C12);  // id:tv_artist
            q.f(view6, "findViewById(...)");
            this.artistTv = (TextView)view6;
            View view7 = this.rootView.findViewById(0x7F0A0D17);  // id:tv_song_count
            q.f(view7, "findViewById(...)");
            this.songCountTv = (TextView)view7;
        }

        @NotNull
        public final TextView getArtistTv$app_playstoreProdRelease() {
            return this.artistTv;
        }

        @NotNull
        public final ImageView getBtnPlayIv$app_playstoreProdRelease() {
            return this.btnPlayIv;
        }

        @NotNull
        public final View getIvThumbDefault$app_playstoreProdRelease() {
            return this.ivThumbDefault;
        }

        @NotNull
        public final View getRootView$app_playstoreProdRelease() {
            return this.rootView;
        }

        @NotNull
        public final TextView getSongCountTv$app_playstoreProdRelease() {
            return this.songCountTv;
        }

        @NotNull
        public final View getThumbContainer$app_playstoreProdRelease() {
            return this.thumbContainer;
        }

        @NotNull
        public final ImageView getThumbnailIv$app_playstoreProdRelease() {
            return this.thumbnailIv;
        }

        @NotNull
        public final TextView getTitleTv$app_playstoreProdRelease() {
            return this.titleTv;
        }

        public final void setArtistTv$app_playstoreProdRelease(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.artistTv = textView0;
        }

        public final void setBtnPlayIv$app_playstoreProdRelease(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.btnPlayIv = imageView0;
        }

        public final void setIvThumbDefault$app_playstoreProdRelease(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.ivThumbDefault = view0;
        }

        public final void setRootView$app_playstoreProdRelease(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.rootView = view0;
        }

        public final void setSongCountTv$app_playstoreProdRelease(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.songCountTv = textView0;
        }

        public final void setThumbContainer$app_playstoreProdRelease(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.thumbContainer = view0;
        }

        public final void setThumbnailIv$app_playstoreProdRelease(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.thumbnailIv = imageView0;
        }

        public final void setTitleTv$app_playstoreProdRelease(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.titleTv = textView0;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GENRE_CODE;
    @NotNull
    public static final Companion Companion;
    private static final int GRID_COUNT_LAND;
    private static final int GRID_COUNT_LAND_WIDE;
    private static final int GRID_COUNT_PORTRAIT;
    private static final int GRID_COUNT_PORTRAIT_WIDE;
    @NotNull
    private static final String TAG;
    @Nullable
    private String gnrCode;
    @Nullable
    private DetailGridLayoutManager gridLayoutManager;
    private GridSpacingItemDecoration gridSpacingItemDecoration;

    static {
        GenreDetailMorePlaylistFragment.Companion = new Companion(null);
        GenreDetailMorePlaylistFragment.$stable = 8;
        GenreDetailMorePlaylistFragment.TAG = "GenreDetailMorePlaylistFragment";
        GenreDetailMorePlaylistFragment.ARG_GENRE_CODE = "argGenreCode";
        GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT = 2;
        GenreDetailMorePlaylistFragment.GRID_COUNT_LAND = 3;
        GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT_WIDE = 4;
        GenreDetailMorePlaylistFragment.GRID_COUNT_LAND_WIDE = 6;
    }

    public static final String access$getARG_GENRE_CODE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new PlaylistAdapter(this, context0, null);
        ((j)j00).setMarkedMode(false);
        ((j)j00).setListContentType(4);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.y0.buildUpon().appendQueryParameter("gnrCode", this.gnrCode).toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final int getPlylistSpanCount() {
        if(this.isWideMode()) {
            return ScreenUtils.isPortrait(this.getContext()) ? GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT_WIDE : GenreDetailMorePlaylistFragment.GRID_COUNT_LAND_WIDE;
        }
        return ScreenUtils.isPortrait(this.getContext()) ? GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT : GenreDetailMorePlaylistFragment.GRID_COUNT_LAND;
    }

    private final boolean isWideMode() {
        return ScreenUtils.isTablet(this.getContext());
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        switch(configuration0.orientation) {
            case 1: {
                GridSpacingItemDecoration genreDetailMorePlaylistFragment$GridSpacingItemDecoration0 = this.gridSpacingItemDecoration;
                if(genreDetailMorePlaylistFragment$GridSpacingItemDecoration0 != null) {
                    genreDetailMorePlaylistFragment$GridSpacingItemDecoration0.setSpanCount((this.isWideMode() ? GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT_WIDE : GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT));
                    DetailGridLayoutManager detailGridLayoutManager0 = this.gridLayoutManager;
                    if(detailGridLayoutManager0 == null) {
                        this.mAdapter.notifyDataSetChanged();
                        return;
                    }
                    detailGridLayoutManager0.P((this.isWideMode() ? GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT_WIDE : GenreDetailMorePlaylistFragment.GRID_COUNT_PORTRAIT));
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                q.m("gridSpacingItemDecoration");
                throw null;
            }
            case 2: {
                GridSpacingItemDecoration genreDetailMorePlaylistFragment$GridSpacingItemDecoration1 = this.gridSpacingItemDecoration;
                if(genreDetailMorePlaylistFragment$GridSpacingItemDecoration1 != null) {
                    genreDetailMorePlaylistFragment$GridSpacingItemDecoration1.setSpanCount((this.isWideMode() ? GenreDetailMorePlaylistFragment.GRID_COUNT_LAND_WIDE : GenreDetailMorePlaylistFragment.GRID_COUNT_LAND));
                    DetailGridLayoutManager detailGridLayoutManager1 = this.gridLayoutManager;
                    if(detailGridLayoutManager1 != null) {
                        detailGridLayoutManager1.P((this.isWideMode() ? GenreDetailMorePlaylistFragment.GRID_COUNT_LAND_WIDE : GenreDetailMorePlaylistFragment.GRID_COUNT_LAND));
                    }
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                q.m("gridSpacingItemDecoration");
                throw null;
            }
            default: {
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        DetailGridLayoutManager detailGridLayoutManager0 = new DetailGridLayoutManager(this.getActivity(), this.getPlylistSpanCount());
        this.gridLayoutManager = detailGridLayoutManager0;
        detailGridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                j0 j00 = detailGridLayoutManager0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMorePlaylistFragment.PlaylistAdapter");
                return ((PlaylistAdapter)j00).isReservedPosition(v) ? this.$this_apply.b : 1;
            }
        };
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setLayoutManager(this.gridLayoutManager);
        GridSpacingItemDecoration genreDetailMorePlaylistFragment$GridSpacingItemDecoration0 = new GridSpacingItemDecoration(this, this.getPlylistSpanCount(), 16);
        this.gridSpacingItemDecoration = genreDetailMorePlaylistFragment$GridSpacingItemDecoration0;
        ((RecyclerView)view0).addItemDecoration(genreDetailMorePlaylistFragment$GridSpacingItemDecoration0);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMorePlaylistFragment.PlaylistAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((PlaylistAdapter)j00).clear();
        }
        Params genreMorePlaylistReq$Params0 = new Params();
        genreMorePlaylistReq$Params0.gnrCode = this.gnrCode;
        genreMorePlaylistReq$Params0.startIndex = i1.equals(i0) ? 1 : ((PlaylistAdapter)j00).getCount() + 1;
        genreMorePlaylistReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new GenreMorePlaylistReq(this.getContext(), genreMorePlaylistReq$Params0)).tag("GenreDetailMorePlaylistFragment").listener(new k(this, i0, 6)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(GenreDetailMorePlaylistFragment genreDetailMorePlaylistFragment0, i i0, GenreMorePlaylistRes genreMorePlaylistRes0) {
        if(!genreDetailMorePlaylistFragment0.prepareFetchComplete(genreMorePlaylistRes0)) {
            return;
        }
        genreDetailMorePlaylistFragment0.performFetchComplete(i0, genreMorePlaylistRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.gnrCode = bundle0.getString("argGenreCode");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", this.gnrCode);
    }
}

