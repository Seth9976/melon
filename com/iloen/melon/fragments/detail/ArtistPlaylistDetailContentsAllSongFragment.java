package com.iloen.melon.fragments.detail;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ArtistPlylstSongListReq.Params;
import com.iloen.melon.net.v4x.request.ArtistPlylstSongListReq;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;
import e1.u;
import java.util.Collection;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001A\u00020\u00132\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailContentsAllSongFragment;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailContentsAllSongBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "getPageMetaType", "pageMetaType", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistPlaylistDetailContentsAllSongFragment extends PlaylistDetailContentsAllSongBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailContentsAllSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailContentsAllSongFragment;", "playlistSeq", "playlistName", "totalPlayTime", "totalSongCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPlaylistDetailContentsAllSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            ArtistPlaylistDetailContentsAllSongFragment artistPlaylistDetailContentsAllSongFragment0 = new ArtistPlaylistDetailContentsAllSongFragment();
            Bundle bundle0 = Y.c("argPlaylistSeq", s, "argPlaylistName", s1);
            bundle0.putString("argPlayTime", s2);
            bundle0.putString("argSongCount", s3);
            artistPlaylistDetailContentsAllSongFragment0.setArguments(bundle0);
            return artistPlaylistDetailContentsAllSongFragment0;
        }

        public static ArtistPlaylistDetailContentsAllSongFragment newInstance$default(Companion artistPlaylistDetailContentsAllSongFragment$Companion0, String s, String s1, String s2, String s3, int v, Object object0) {
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            return artistPlaylistDetailContentsAllSongFragment$Companion0.newInstance(s, s1, s2, s3);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistPlaylistDetailContentsAllSongFragment";

    static {
        ArtistPlaylistDetailContentsAllSongFragment.Companion = new Companion(null);
        ArtistPlaylistDetailContentsAllSongFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.K0.buildUpon().appendPath("SONG").appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongBaseFragment
    @NotNull
    public String getPageMetaType() {
        String s = this.getString(0x7F130CE6);  // string:tiara_artistplaylist_meta_type "아티스트플레이리스트"
        q.f(s, "getString(...)");
        return s;
    }

    @NotNull
    public static final ArtistPlaylistDetailContentsAllSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        return ArtistPlaylistDetailContentsAllSongFragment.Companion.newInstance(s, s1, s2, s3);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsSongAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            this.setHeaderButtonVisibility(false);
            ((DetailContentsSongAdapter)j00).clear();
        }
        Params artistPlylstSongListReq$Params0 = new Params();
        artistPlylstSongListReq$Params0.plylstSeq = this.getPlaylistSeq();
        artistPlylstSongListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((DetailContentsSongAdapter)j00).getCount() + 1;
        artistPlylstSongListReq$Params0.pageSize = 100;
        RequestBuilder.newInstance(new ArtistPlylstSongListReq(this.getContext(), u.v(((e0)o.a()).j()), artistPlylstSongListReq$Params0)).tag(this.getRequestTag()).listener(new a(7, this, i0)).errorListener(new e(this, 0)).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(ArtistPlaylistDetailContentsAllSongFragment artistPlaylistDetailContentsAllSongFragment0, i i0, ArtistPlylstSongListRes artistPlylstSongListRes0) {
        if(!artistPlaylistDetailContentsAllSongFragment0.prepareFetchComplete(artistPlylstSongListRes0)) {
            artistPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(false);
            return;
        }
        RESPONSE artistPlylstSongListRes$RESPONSE0 = artistPlylstSongListRes0.response;
        artistPlaylistDetailContentsAllSongFragment0.setStatsElements(artistPlylstSongListRes0.getStatsElements());
        artistPlaylistDetailContentsAllSongFragment0.mMelonTiaraProperty = new s(artistPlylstSongListRes$RESPONSE0.section, artistPlylstSongListRes$RESPONSE0.page, artistPlylstSongListRes$RESPONSE0.menuId, null);
        Collection collection0 = artistPlylstSongListRes0.getItems();
        if(collection0 != null && !collection0.isEmpty() == 1) {
            artistPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(true);
            PlaylistDetailContentsAllSongBaseFragment.updateSongCount$default(artistPlaylistDetailContentsAllSongFragment0, null, 1, null);
        }
        artistPlaylistDetailContentsAllSongFragment0.performFetchComplete(i0, artistPlylstSongListRes0);
    }

    private static final void onFetchStart$lambda$3(ArtistPlaylistDetailContentsAllSongFragment artistPlaylistDetailContentsAllSongFragment0, VolleyError volleyError0) {
        artistPlaylistDetailContentsAllSongFragment0.performFetchError(volleyError0);
        artistPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F130825));  // string:playlist_detail_contents_all_song_title "수록곡"
        }
    }
}

