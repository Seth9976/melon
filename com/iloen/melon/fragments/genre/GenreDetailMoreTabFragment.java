package com.iloen.melon.fragments.genre;

import B.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000E\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\u0003J-\u0010\u000F\u001A\u00020\u000E2\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001D\u0010\u0014\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001CJ\u000F\u0010\u001F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u000F\u0010 \u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b \u0010\u0003J\u000F\u0010!\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b!\u0010\u0003J\u0019\u0010#\u001A\u00020\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b#\u0010\u001CJ!\u0010&\u001A\u00020\u00072\u0006\u0010%\u001A\u00020$2\b\u0010\"\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010-\u001A\u0004\u0018\u00010,2\u0006\u0010)\u001A\u00020(2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0019\u00101\u001A\u0004\u0018\u00010$2\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b1\u00102J\u0019\u00103\u001A\u0004\u0018\u00010$2\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b3\u00102J\u0019\u00104\u001A\u0004\u0018\u00010$2\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b4\u00102J\u000F\u00105\u001A\u00020*H\u0014\u00A2\u0006\u0004\b5\u00106J\u000F\u00107\u001A\u00020*H\u0014\u00A2\u0006\u0004\b7\u00106J\u0017\u0010:\u001A\u00020\u00072\u0006\u00109\u001A\u000208H\u0014\u00A2\u0006\u0004\b:\u0010;J\u0011\u0010<\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b<\u0010\u0006R\u0016\u0010=\u001A\u00020*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001A\u00020\u00048\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010@R\u0018\u0010B\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010C\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010@R\u0016\u0010D\u001A\u00020*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010>\u00A8\u0006F"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreTabFragment;", "Lcom/iloen/melon/fragments/genre/GenreDetailPagerFragment;", "<init>", "()V", "", "getMoreTypeTitle", "()Ljava/lang/String;", "Lie/H;", "updateTabInfoList", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onSetProgress", "onTabFetchStart", "onTabFetched", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "tabInfo", "", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "createTopHeaderView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "createBottomHeaderView", "createImageHeaderView", "getTopHeaderHeight", "()I", "getBottomHeaderHeight", "", "ratio", "updateTitleBarRatio", "(F)V", "getRefcrTypeCode", "moreType", "I", "gnrCode", "Ljava/lang/String;", "genreContsSeq", "filterTypeFlg", "filterTypeCode", "mSongSortIndex", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreDetailMoreTabFragment extends GenreDetailPagerFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0005J4\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u00052\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_MORE_TYPE", "ARG_GENRE_CODE", "ARG_GENRE_CONTS_SEQ", "ARG_GENRE_FILTER_TYPE_FLG", "ARG_GENRE_FILTER_TYPE_CODE", "ARG_SONG_SORT_TYPE", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailMoreTabFragment;", "moreType", "Lcom/iloen/melon/fragments/genre/Genre$More_Fragment_Type;", "genreCode", "genreContsSeq", "filterTypeFlg", "filterTypeCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailMoreTabFragment newInstance(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @NotNull String s) {
            q.g(genre$More_Fragment_Type0, "moreType");
            q.g(s, "genreCode");
            GenreDetailMoreTabFragment genreDetailMoreTabFragment0 = new GenreDetailMoreTabFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argMoreTitle", genre$More_Fragment_Type0.ordinal());
            bundle0.putString("argCenreCode", s);
            genreDetailMoreTabFragment0.setArguments(bundle0);
            return genreDetailMoreTabFragment0;
        }

        @NotNull
        public final GenreDetailMoreTabFragment newInstance(@NotNull More_Fragment_Type genre$More_Fragment_Type0, @NotNull String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            q.g(genre$More_Fragment_Type0, "moreType");
            q.g(s, "genreCode");
            GenreDetailMoreTabFragment genreDetailMoreTabFragment0 = new GenreDetailMoreTabFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argMoreTitle", genre$More_Fragment_Type0.ordinal());
            bundle0.putString("argCenreCode", s);
            bundle0.putString("argGenreContsSeq", s1);
            bundle0.putString("argGenreFilterTypeFlg", s2);
            bundle0.putString("argGenreFilterTypeCode", s3);
            genreDetailMoreTabFragment0.setArguments(bundle0);
            return genreDetailMoreTabFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GENRE_CODE;
    @NotNull
    private static final String ARG_GENRE_CONTS_SEQ;
    @NotNull
    private static final String ARG_GENRE_FILTER_TYPE_CODE;
    @NotNull
    private static final String ARG_GENRE_FILTER_TYPE_FLG;
    @NotNull
    private static final String ARG_MORE_TYPE;
    @NotNull
    private static final String ARG_SONG_SORT_TYPE;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    @Nullable
    private String filterTypeCode;
    @Nullable
    private String filterTypeFlg;
    @Nullable
    private String genreContsSeq;
    private String gnrCode;
    private int mSongSortIndex;
    private int moreType;

    static {
        GenreDetailMoreTabFragment.Companion = new Companion(null);
        GenreDetailMoreTabFragment.$stable = 8;
        GenreDetailMoreTabFragment.TAG = "GenreDetailMoreTabFragment";
        GenreDetailMoreTabFragment.ARG_MORE_TYPE = "argMoreTitle";
        GenreDetailMoreTabFragment.ARG_GENRE_CODE = "argCenreCode";
        GenreDetailMoreTabFragment.ARG_GENRE_CONTS_SEQ = "argGenreContsSeq";
        GenreDetailMoreTabFragment.ARG_GENRE_FILTER_TYPE_FLG = "argGenreFilterTypeFlg";
        GenreDetailMoreTabFragment.ARG_GENRE_FILTER_TYPE_CODE = "argGenreFilterTypeCode";
        GenreDetailMoreTabFragment.ARG_SONG_SORT_TYPE = "argSongSortType";
    }

    public GenreDetailMoreTabFragment() {
        this.moreType = -1;
    }

    public static final String access$getARG_GENRE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_CONTS_SEQ$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_FILTER_TYPE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_FILTER_TYPE_FLG$cp() [...] // 潜在的解密器

    public static final String access$getARG_MORE_TYPE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createBottomHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createImageHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createTopHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02E3, null, false);  // layout:genre_detail_more_top_header
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getBottomHeaderHeight() {
        return -2;
    }

    private final String getMoreTypeTitle() {
        int v;
        if(this.moreType == More_Fragment_Type.GUI_MORE_ARTIST.ordinal()) {
            v = 0x7F13047C;  // string:genre_more_artist_title "%s 주요아티스트"
        }
        else if(this.moreType == More_Fragment_Type.GUI_MORE_MASTERPIECE.ordinal()) {
            v = 0x7F13047E;  // string:genre_more_masterpiece_title "명반"
        }
        else if(this.moreType == More_Fragment_Type.GUI_MORE_NEW_SONG.ordinal()) {
            v = 0x7F13047F;  // string:genre_more_new_song_title "%s 최신음악"
        }
        else {
            v = this.moreType == More_Fragment_Type.GUI_MORE_PLAYLIST.ordinal() ? 0x7F130480 : -1;  // string:genre_more_playlist_title "%s 플레이리스트"
        }
        if(v != -1) {
            String s = this.getString(v, new Object[]{this.getMenuName()});
            q.f(s, "getString(...)");
            return s;
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    @Nullable
    public String getRefcrTypeCode() {
        if(this.moreType == More_Fragment_Type.GUI_MORE_ARTIST.ordinal()) {
            return "R40013";
        }
        return this.moreType == More_Fragment_Type.GUI_MORE_MASTERPIECE.ordinal() ? "R40012" : null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTopHeaderHeight() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Resources resources0 = fragmentActivity0.getResources();
            return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07046F);  // dimen:top_header_genre_detail_more_height
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public MelonBaseFragment makeTabFragment(@NotNull TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        String s = ((GenreMenu)this.getGenreMenuArray().get(v)).getGnrCode();
        boolean z = ProtocolUtils.parseBoolean(((GenreMenu)this.getGenreMenuArray().get(v)).getYearlyGnrYN());
        More_Fragment_Type[] arr_genre$More_Fragment_Type = More_Fragment_Type.values();
        return GenreFragmentFactory.createMore(s, arr_genre$More_Fragment_Type[this.moreType], this.genreContsSeq, this.filterTypeFlg, this.filterTypeCode, z);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(this.getArguments() != null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            String s = bundle0.getString("argCenreCode");
            if(s == null) {
                s = "";
            }
            this.setGenreCode(s);
            this.mSongSortIndex = bundle0.getInt("argSongSortType");
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        super.onFetchStart(i0, h0, s);
        return false;
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.moreType = bundle0.getInt("argMoreTitle");
        String s = bundle0.getString("argCenreCode");
        if(s == null) {
            s = "";
        }
        this.gnrCode = s;
        this.genreContsSeq = bundle0.getString("argGenreContsSeq");
        this.filterTypeFlg = bundle0.getString("argGenreFilterTypeFlg");
        this.filterTypeCode = bundle0.getString("argGenreFilterTypeCode");
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argMoreTitle", this.moreType);
        String s = this.gnrCode;
        if(s != null) {
            bundle0.putString("argCenreCode", s);
            bundle0.putString("argGenreContsSeq", this.genreContsSeq);
            bundle0.putString("argGenreFilterTypeFlg", this.filterTypeFlg);
            bundle0.putString("argGenreFilterTypeCode", this.filterTypeCode);
            return;
        }
        q.m("gnrCode");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onSetProgress() {
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onTabFetchStart() {
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onTabFetched() {
        if(!this.isFragmentValid()) {
            return;
        }
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.setTitle(this.getMoreTypeTitle());
        titleBar0.setTitleVisibility(true);
        if(this.getSelectedTabIndex() == -1) {
            String s = this.gnrCode;
            if(s != null) {
                int v = this.getGenreMenuArray().size();
                for(int v1 = 0; v1 < v; ++v1) {
                    if(q.b(s, ((GenreMenu)this.getGenreMenuArray().get(v1)).getGnrCode())) {
                        this.setSelectedTabIndex(v1);
                        break;
                    }
                }
                goto label_19;
            }
            q.m("gnrCode");
            throw null;
        }
    label_19:
        if(this.getSelectedTabIndex() == -1) {
            this.setSelectedTabIndex(0);
        }
        this.selectTabByIndex(this.getSelectedTabIndex());
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.a(a.s(1));
        titleBar0.f(true);
        titleBar0.setTitleVisibility(false);
    }

    @Override  // com.iloen.melon.fragments.genre.GenreDetailPagerFragment
    public void updateTabInfoList() {
        ArrayList arrayList0 = new ArrayList();
        int v = this.getGenreMenuArray().size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ((GenreMenu)this.getGenreMenuArray().get(v1)).getGnrName();
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 0;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v1;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = -1;
            tabInfo0.j = -1.0f;
            tabInfo0.k = v1 == 0 ? 16.0f : 8.0f;
            tabInfo0.l = v1 >= this.getGenreMenuArray().size() - 1 ? 16.0f : 0.0f;
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        this.updateTabInfoList(arrayList0);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateTitleBarRatio(float f) {
        this.mTitleBar.setTitleVisibility(true);
    }
}

