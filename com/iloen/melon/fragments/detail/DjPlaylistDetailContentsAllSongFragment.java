package com.iloen.melon.fragments.detail;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.MelonDjPlaylistListSongReq;
import com.iloen.melon.net.v6x.request.PlaylistListSongBaseReq.Params;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001A\u00020\u00132\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u00138\u0014X\u0094D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0006¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/detail/DjPlaylistDetailContentsAllSongFragment;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailContentsAllSongBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "hasMixUpPlayBtn", "Z", "getHasMixUpPlayBtn", "()Z", "getPageMetaType", "pageMetaType", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjPlaylistDetailContentsAllSongFragment extends PlaylistDetailContentsAllSongBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/DjPlaylistDetailContentsAllSongFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/DjPlaylistDetailContentsAllSongFragment;", "playlistSeq", "playlistName", "totalPlayTime", "totalSongCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DjPlaylistDetailContentsAllSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            DjPlaylistDetailContentsAllSongFragment djPlaylistDetailContentsAllSongFragment0 = new DjPlaylistDetailContentsAllSongFragment();
            Bundle bundle0 = Y.c("argPlaylistSeq", s, "argPlaylistName", s1);
            bundle0.putString("argPlayTime", s2);
            bundle0.putString("argSongCount", s3);
            djPlaylistDetailContentsAllSongFragment0.setArguments(bundle0);
            return djPlaylistDetailContentsAllSongFragment0;
        }

        public static DjPlaylistDetailContentsAllSongFragment newInstance$default(Companion djPlaylistDetailContentsAllSongFragment$Companion0, String s, String s1, String s2, String s3, int v, Object object0) {
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            return djPlaylistDetailContentsAllSongFragment$Companion0.newInstance(s, s1, s2, s3);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "DjPlaylistDetailContentsAllSongFragment";
    private final boolean hasMixUpPlayBtn;

    static {
        DjPlaylistDetailContentsAllSongFragment.Companion = new Companion(null);
        DjPlaylistDetailContentsAllSongFragment.$stable = 8;
    }

    public DjPlaylistDetailContentsAllSongFragment() {
        this.hasMixUpPlayBtn = true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.O0.buildUpon().appendPath("SONG").appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongBaseFragment
    public boolean getHasMixUpPlayBtn() {
        return this.hasMixUpPlayBtn;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailContentsAllSongBaseFragment
    @NotNull
    public String getPageMetaType() {
        String s = this.getString(0x7F130E6B);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
        q.f(s, "getString(...)");
        return s;
    }

    @NotNull
    public static final DjPlaylistDetailContentsAllSongFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        return DjPlaylistDetailContentsAllSongFragment.Companion.newInstance(s, s1, s2, s3);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.DetailContentsSongAdapter");
        if(i.b.equals(i0)) {
            this.setHeaderButtonVisibility(false);
            ((DetailContentsSongAdapter)j00).clear();
        }
        Params playlistListSongBaseReq$Params0 = new Params();
        playlistListSongBaseReq$Params0.plylstSeq = this.getPlaylistSeq();
        playlistListSongBaseReq$Params0.totCntFlg = "Y";
        playlistListSongBaseReq$Params0.mode = "all";
        RequestBuilder.newInstance(new MelonDjPlaylistListSongReq(this.getContext(), playlistListSongBaseReq$Params0)).tag(this.getRequestTag()).listener(new a(8, this, i0)).errorListener(new e(this, 2)).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(DjPlaylistDetailContentsAllSongFragment djPlaylistDetailContentsAllSongFragment0, i i0, MelonDjPlaylistListSongRes melonDjPlaylistListSongRes0) {
        if(!djPlaylistDetailContentsAllSongFragment0.prepareFetchComplete(melonDjPlaylistListSongRes0)) {
            djPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(false);
            return;
        }
        djPlaylistDetailContentsAllSongFragment0.setStatsElements(melonDjPlaylistListSongRes0.getStatsElements());
        String s = null;
        djPlaylistDetailContentsAllSongFragment0.mMelonTiaraProperty = new s(melonDjPlaylistListSongRes0.response.section, melonDjPlaylistListSongRes0.response.page, "", null);
        Collection collection0 = melonDjPlaylistListSongRes0.getItems();
        if(collection0 != null && !collection0.isEmpty() == 1) {
            djPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(true);
            RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = melonDjPlaylistListSongRes0.response;
            if(melonDjPlaylistListSongRes$RESPONSE0 != null) {
                s = melonDjPlaylistListSongRes$RESPONSE0.totalCount;
            }
            djPlaylistDetailContentsAllSongFragment0.updateSongCount(s);
        }
        djPlaylistDetailContentsAllSongFragment0.performFetchComplete(i0, melonDjPlaylistListSongRes0);
    }

    private static final void onFetchStart$lambda$3(DjPlaylistDetailContentsAllSongFragment djPlaylistDetailContentsAllSongFragment0, VolleyError volleyError0) {
        djPlaylistDetailContentsAllSongFragment0.performFetchError(volleyError0);
        djPlaylistDetailContentsAllSongFragment0.setHeaderButtonVisibility(false);
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

