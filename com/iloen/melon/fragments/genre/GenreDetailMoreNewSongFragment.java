package com.iloen.melon.fragments.genre;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.GenreMoreNewMusicReq.Params;
import com.iloen.melon.net.v5x.request.GenreMoreNewMusicReq;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.AlbumInfoBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 92\u00020\u0001:\u00029:B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0003J\'\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u001D\u0010 \u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b \u0010!J\u0011\u0010#\u001A\u0004\u0018\u00010\"H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b%\u0010&J\u0011\u0010(\u001A\u0004\u0018\u00010\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u0011\u0010*\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020,H\u0014\u00A2\u0006\u0004\b/\u0010.R\u0018\u00100\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001A\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreNewSongFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "isShow", "Lie/H;", "showSortingBarButton", "(Z)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "gnrCode", "Ljava/lang/String;", "isYearlyGnr", "Z", "mCurrentFilterIndex", "I", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "Companion", "NewSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class GenreDetailMoreNewSongFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreNewSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GENRE_CODE", "ARG_ISYEARLY_GNR", "SORT_FILTER_ALBUM", "", "SORT_FILTER_SONG", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailMoreNewSongFragment;", "genreCode", "isYearlyGnr", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailMoreNewSongFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "genreCode");
            GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0 = new GenreDetailMoreNewSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            bundle0.putBoolean("argIsYearlyGnr", z);
            genreDetailMoreNewSongFragment0.setArguments(bundle0);
            return genreDetailMoreNewSongFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreNewSongFragment$NewSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMoreNewSongFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "responseContainer", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "VIEW_TYPE_ALBUM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class NewSongAdapter extends p {
        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_SONG;

        public NewSongAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailMoreNewSongFragment.this = genreDetailMoreNewSongFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ALBUM = 1;
        }

        // 去混淆评级： 低(30)
        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return GenreDetailMoreNewSongFragment.this.mCurrentFilterIndex == 0 ? this.VIEW_TYPE_ALBUM : this.VIEW_TYPE_SONG;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "responseContainer");
            if(httpResponse0 instanceof GenreMoreNewMusicRes) {
                RESPONSE genreMoreNewMusicRes$RESPONSE0 = ((GenreMoreNewMusicRes)httpResponse0).response;
                if(genreMoreNewMusicRes$RESPONSE0 != null) {
                    this.setMenuId(genreMoreNewMusicRes$RESPONSE0.menuId);
                    this.setHasMore(genreMoreNewMusicRes$RESPONSE0.hasMore);
                    this.updateModifiedTime(s);
                    ArrayList arrayList0 = genreMoreNewMusicRes$RESPONSE0.songList;
                    ArrayList arrayList1 = genreMoreNewMusicRes$RESPONSE0.albumList;
                    if(GenreDetailMoreNewSongFragment.this.mCurrentFilterIndex == 0) {
                        if(arrayList1 != null && arrayList1.size() > 0) {
                            this.addAll(arrayList1);
                            return true;
                        }
                    }
                    else if(arrayList0 != null && arrayList0.size() > 0) {
                        this.addAll(arrayList0);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_SONG) {
                SongHolder songHolder0 = (SongHolder)o00;
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes.RESPONSE.SONGLIST");
                ViewUtils.setEnable(songHolder0.wrapperLayout, ((SONGLIST)object0).canService);
                if(((SONGLIST)object0).canService) {
                    ViewUtils.setOnClickListener(songHolder0.rootView, new j(GenreDetailMoreNewSongFragment.this, v, 1));
                    if(this.isMarked(v1)) {
                        songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                    }
                    else {
                        songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    }
                }
                else {
                    ViewUtils.setOnClickListener(songHolder0.rootView, null);
                    songHolder0.rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                }
                ViewUtils.setOnLongClickListener(songHolder0.rootView, new b(GenreDetailMoreNewSongFragment.this, ((SONGLIST)object0), this, 2));
                ImageView imageView0 = songHolder0.thumbnailIv;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(((SONGLIST)object0).albumImg).into(songHolder0.thumbnailIv);
                }
                ViewUtils.showWhen(songHolder0.btnPlay, ((SONGLIST)object0).canService);
                ViewUtils.setOnClickListener(songHolder0.btnPlay, new com.iloen.melon.fragments.genre.q(GenreDetailMoreNewSongFragment.this, ((SONGLIST)object0), this, 0));
                ViewUtils.showWhen(songHolder0.btnInfo, true);
                ViewUtils.setOnClickListener(songHolder0.btnInfo, new com.iloen.melon.fragments.genre.q(GenreDetailMoreNewSongFragment.this, ((SONGLIST)object0), this, 1));
                ViewUtils.setOnClickListener(songHolder0.thumbContainer, new e(6, GenreDetailMoreNewSongFragment.this, ((SONGLIST)object0)));
                ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                songHolder0.titleTv.setText(((SONGLIST)object0).songName);
                songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((SONGLIST)object0).artistList));
                ViewUtils.showWhen(songHolder0.list19Iv, ((SONGLIST)object0).isAdult);
                ViewUtils.showWhen(songHolder0.listHotIv, ((SONGLIST)object0).isHitSong);
                ViewUtils.showWhen(songHolder0.listFreeIv, ((SONGLIST)object0).isFree);
                ViewUtils.showWhen(songHolder0.listHoldbackIv, ((SONGLIST)object0).isHoldback);
                return;
            }
            if(v2 == this.VIEW_TYPE_ALBUM) {
                Object object1 = this.getItem(v1);
                q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.AlbumInfoBase");
                String s = ((AlbumInfoBase)object1).albumId;
                boolean z = ((AlbumInfoBase)object1).canService;
                ViewUtils.setEnable(((AlbumHolder)o00).wrapperLayout, z);
                ViewUtils.setOnClickListener(((AlbumHolder)o00).btnPlayIv, new a(z, GenreDetailMoreNewSongFragment.this, v1, ((AlbumInfoBase)object1), this, 2));
                if(z) {
                    e e0 = new e(7, s, GenreDetailMoreNewSongFragment.this);
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, e0);
                }
                else {
                    ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, null);
                }
                b b0 = new b(GenreDetailMoreNewSongFragment.this, ((AlbumInfoBase)object1), this, 3);
                ViewUtils.setOnLongClickListener(((AlbumHolder)o00).itemView, b0);
                ((AlbumHolder)o00).btnPlayIv.setImageResource((z ? 0x7F080309 : 0x7F0801F2));  // drawable:common_btn_play_01
                ImageView imageView1 = ((AlbumHolder)o00).thumbnailIv;
                if(imageView1 != null) {
                    Glide.with(imageView1.getContext()).load(((AlbumInfoBase)object1).albumImg).into(((AlbumHolder)o00).thumbnailIv);
                }
                ((AlbumHolder)o00).titleTv.setText(((AlbumInfoBase)object1).albumName);
                ((AlbumHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((AlbumInfoBase)object1).artistList));
                ((AlbumHolder)o00).issueTv.setText(((AlbumInfoBase)object1).issueDate);
                ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                ((AlbumHolder)o00).ratingView.c(((AlbumInfoBase)object1).totAvrgScore);
                ((AlbumHolder)o00).ratingText.setText(Float.toString(((AlbumInfoBase)object1).totAvrgScore));
                ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(((AlbumInfoBase)object1).ptcPnmPrco, 0x3B9AC9FF));
            }
        }

        private static final void onBindViewImpl$lambda$0(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, int v, View view0) {
            genreDetailMoreNewSongFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$1(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, SONGLIST genreMoreNewMusicRes$RESPONSE$SONGLIST0, NewSongAdapter genreDetailMoreNewSongFragment$NewSongAdapter0, View view0) {
            genreDetailMoreNewSongFragment0.showContextPopupSongOrInstantPlay(Playable.from(genreMoreNewMusicRes$RESPONSE$SONGLIST0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$2(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, SONGLIST genreMoreNewMusicRes$RESPONSE$SONGLIST0, NewSongAdapter genreDetailMoreNewSongFragment$NewSongAdapter0, View view0) {
            if(!genreDetailMoreNewSongFragment0.isLoginUser()) {
                genreDetailMoreNewSongFragment0.playSong(Playable.from(genreMoreNewMusicRes$RESPONSE$SONGLIST0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null), true);
                return;
            }
            genreDetailMoreNewSongFragment0.playSong(Playable.from(genreMoreNewMusicRes$RESPONSE$SONGLIST0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null), true);
        }

        private static final void onBindViewImpl$lambda$3(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, SONGLIST genreMoreNewMusicRes$RESPONSE$SONGLIST0, NewSongAdapter genreDetailMoreNewSongFragment$NewSongAdapter0, View view0) {
            genreDetailMoreNewSongFragment0.showContextPopupSong(Playable.from(genreMoreNewMusicRes$RESPONSE$SONGLIST0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$4(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, SONGLIST genreMoreNewMusicRes$RESPONSE$SONGLIST0, View view0) {
            genreDetailMoreNewSongFragment0.showAlbumInfoPage(genreMoreNewMusicRes$RESPONSE$SONGLIST0);
        }

        private static final void onBindViewImpl$lambda$5(boolean z, GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, int v, AlbumInfoBase albumInfoBase0, NewSongAdapter genreDetailMoreNewSongFragment$NewSongAdapter0, View view0) {
            if(z) {
                if(!genreDetailMoreNewSongFragment0.isLoginUser()) {
                    genreDetailMoreNewSongFragment0.playAlbum(v);
                    return;
                }
                genreDetailMoreNewSongFragment0.playAlbum(v);
                return;
            }
            genreDetailMoreNewSongFragment0.showContextPopupAlbum(Playable.from(albumInfoBase0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$6(String s, GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, View view0) {
            if(!TextUtils.isEmpty(s)) {
                genreDetailMoreNewSongFragment0.showAlbumInfoPage(s);
            }
        }

        private static final boolean onBindViewImpl$lambda$7(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, AlbumInfoBase albumInfoBase0, NewSongAdapter genreDetailMoreNewSongFragment$NewSongAdapter0, View view0) {
            genreDetailMoreNewSongFragment0.showContextPopupAlbum(Playable.from(albumInfoBase0, genreDetailMoreNewSongFragment$NewSongAdapter0.getMenuId(), null));
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SONG) {
                return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
            }
            return v == this.VIEW_TYPE_ALBUM ? new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false)) : null;  // layout:listitem_album
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GENRE_CODE;
    @NotNull
    private static final String ARG_ISYEARLY_GNR;
    @NotNull
    public static final Companion Companion;
    private static final int SORT_FILTER_ALBUM;
    private static final int SORT_FILTER_SONG;
    @NotNull
    private static final String TAG;
    @Nullable
    private String gnrCode;
    private boolean isYearlyGnr;
    private int mCurrentFilterIndex;
    @Nullable
    private SortingBarView sortingBarView;

    static {
        GenreDetailMoreNewSongFragment.Companion = new Companion(null);
        GenreDetailMoreNewSongFragment.$stable = 8;
        GenreDetailMoreNewSongFragment.TAG = "GenreDetailMoreNewSongFragment";
        GenreDetailMoreNewSongFragment.ARG_GENRE_CODE = "argGenreCode";
        GenreDetailMoreNewSongFragment.ARG_ISYEARLY_GNR = "argIsYearlyGnr";
        GenreDetailMoreNewSongFragment.SORT_FILTER_SONG = 1;
    }

    public GenreDetailMoreNewSongFragment() {
        this.mCurrentFilterIndex = GenreDetailMoreNewSongFragment.SORT_FILTER_ALBUM;
    }

    public static final String access$getARG_GENRE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_ISYEARLY_GNR$cp() [...] // 潜在的解密器

    public static final int access$getSORT_FILTER_ALBUM$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View buildParallaxHeaderView() {
        return LayoutInflater.from(this.getContext()).inflate(0x7F0D02D7, null, false);  // layout:genre_album_song_select_filter
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 1000);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new NewSongAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.x0.buildUpon().appendQueryParameter("gnrCode", this.gnrCode).toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
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
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMoreNewSongFragment.NewSongAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((NewSongAdapter)j00).clear();
        }
        Params genreMoreNewMusicReq$Params0 = new Params();
        genreMoreNewMusicReq$Params0.gnrCode = this.gnrCode;
        genreMoreNewMusicReq$Params0.startIndex = i1.equals(i0) ? 1 : ((NewSongAdapter)j00).getCount() + 1;
        genreMoreNewMusicReq$Params0.pageSize = 100;
        if(this.mCurrentFilterIndex == GenreDetailMoreNewSongFragment.SORT_FILTER_SONG) {
            genreMoreNewMusicReq$Params0.contsTypeCode = "N10001";
            ((NewSongAdapter)j00).setMarkedMode(true);
        }
        else {
            genreMoreNewMusicReq$Params0.contsTypeCode = "N10002";
            this.showSortingBarButton(false);
            ((NewSongAdapter)j00).setListContentType(2);
            ((NewSongAdapter)j00).setMarkedMode(false);
        }
        RequestBuilder.newInstance(new GenreMoreNewMusicReq(this.getContext(), genreMoreNewMusicReq$Params0)).tag("GenreDetailMoreNewSongFragment").listener(new k(this, i0, 5)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, i i0, GenreMoreNewMusicRes genreMoreNewMusicRes0) {
        if(!genreDetailMoreNewSongFragment0.prepareFetchComplete(genreMoreNewMusicRes0)) {
            return;
        }
        if(genreMoreNewMusicRes0 != null && (genreMoreNewMusicRes0.response != null && (genreMoreNewMusicRes0.response.songList != null && !genreMoreNewMusicRes0.response.songList.isEmpty()))) {
            genreDetailMoreNewSongFragment0.showSortingBarButton(true);
        }
        genreDetailMoreNewSongFragment0.performFetchComplete(i0, genreMoreNewMusicRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.gnrCode = bundle0.getString("argGenreCode");
        this.isYearlyGnr = bundle0.getBoolean("argIsYearlyGnr");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", this.gnrCode);
        bundle0.putBoolean("argIsYearlyGnr", this.isYearlyGnr);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SortingBarView");
        this.sortingBarView = (SortingBarView)view1;
        String[] arr_s = null;
        if(this.isYearlyGnr) {
            Context context0 = this.getContext();
            if(context0 != null) {
                Resources resources0 = context0.getResources();
                if(resources0 != null) {
                    arr_s = resources0.getStringArray(0x7F03002F);  // array:sorting_bar_genre_more_newsong_yearly
                }
            }
        }
        else {
            Context context1 = this.getContext();
            if(context1 != null) {
                Resources resources1 = context1.getResources();
                if(resources1 != null) {
                    arr_s = resources1.getStringArray(0x7F03002E);  // array:sorting_bar_genre_more_newsong
                }
            }
        }
        SortingBarView sortingBarView0 = this.sortingBarView;
        if(sortingBarView0 != null) {
            sortingBarView0.setItems(arr_s);
        }
        SortingBarView sortingBarView1 = this.sortingBarView;
        if(sortingBarView1 != null) {
            sortingBarView1.setSelection(this.mCurrentFilterIndex);
        }
        SortingBarView sortingBarView2 = this.sortingBarView;
        if(sortingBarView2 != null) {
            sortingBarView2.setOnSortSelectionListener(new com.iloen.melon.fragments.genre.p(this));
        }
        this.showSortingBarButton(this.getItemCount() > 0);
    }

    private static final void onViewCreated$lambda$0(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, int v) {
        if(genreDetailMoreNewSongFragment0.mCurrentFilterIndex == v) {
            return;
        }
        genreDetailMoreNewSongFragment0.mCurrentFilterIndex = v;
        j0 j00 = genreDetailMoreNewSongFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMoreNewSongFragment.NewSongAdapter");
        if(genreDetailMoreNewSongFragment0.mCurrentFilterIndex == GenreDetailMoreNewSongFragment.SORT_FILTER_ALBUM) {
            ((NewSongAdapter)j00).setMarkedMode(false);
            ((NewSongAdapter)j00).setListContentType(2);
        }
        else {
            ((NewSongAdapter)j00).setMarkedMode(true);
            ((NewSongAdapter)j00).setListContentType(1);
        }
        genreDetailMoreNewSongFragment0.updateParallaxHeaderView();
        genreDetailMoreNewSongFragment0.startFetch("sortbar change");
    }

    private final void showSortingBarButton(boolean z) {
        if(!z) {
            SortingBarView sortingBarView5 = this.sortingBarView;
            if(sortingBarView5 != null) {
                sortingBarView5.setOnCheckedListener(null);
            }
            SortingBarView sortingBarView6 = this.sortingBarView;
            if(sortingBarView6 != null) {
                sortingBarView6.setLeftButton(null);
            }
            SortingBarView sortingBarView7 = this.sortingBarView;
            if(sortingBarView7 != null) {
                sortingBarView7.setRightLayout(null);
            }
        }
        else if(this.mCurrentFilterIndex == GenreDetailMoreNewSongFragment.SORT_FILTER_ALBUM) {
            SortingBarView sortingBarView0 = this.sortingBarView;
            if(sortingBarView0 != null) {
                sortingBarView0.setOnCheckedListener(null);
            }
            SortingBarView sortingBarView1 = this.sortingBarView;
            if(sortingBarView1 != null) {
                sortingBarView1.setLeftButton(null);
            }
            SortingBarView sortingBarView2 = this.sortingBarView;
            if(sortingBarView2 != null) {
                sortingBarView2.setRightLayout(null);
            }
        }
        else {
            SortingBarView sortingBarView3 = this.sortingBarView;
            if(sortingBarView3 != null) {
                sortingBarView3.setOnCheckedListener(new com.iloen.melon.fragments.genre.p(this));
            }
            SortingBarView sortingBarView4 = this.sortingBarView;
            if(sortingBarView4 != null) {
                com.iloen.melon.fragments.genre.p p0 = new com.iloen.melon.fragments.genre.p(this);
                sortingBarView4.c(L.b, p0);
            }
        }
    }

    private static final void showSortingBarButton$lambda$1(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, S s0, boolean z) {
        genreDetailMoreNewSongFragment0.toggleSelectAll();
    }

    private static final void showSortingBarButton$lambda$2(GenreDetailMoreNewSongFragment genreDetailMoreNewSongFragment0, View view0) {
        genreDetailMoreNewSongFragment0.playAll();
    }
}

