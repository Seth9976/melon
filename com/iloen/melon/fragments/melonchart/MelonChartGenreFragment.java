package com.iloen.melon.fragments.melonchart;

import B9.c;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.NewChartFilterLayout;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ChartAlbumInfoBase;
import com.iloen.melon.net.v4x.common.ChartSongInfoBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.GenreMenuListInfoBase.GNRLIST;
import com.iloen.melon.net.v4x.common.GenreMenuListInfoBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.DailyAlbumChartListReq.Params;
import com.iloen.melon.net.v5x.request.DailyAlbumChartListReq;
import com.iloen.melon.net.v5x.request.DailySongChartListReq;
import com.iloen.melon.net.v5x.response.DailyAlbumChartListRes.RESPONSE.CHARTINFO;
import com.iloen.melon.net.v5x.response.DailyAlbumChartListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.DailyAlbumChartListRes;
import com.iloen.melon.net.v5x.response.DailySongChartListRes.RESPONSE.CHARTLIST;
import com.iloen.melon.net.v5x.response.DailySongChartListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import com.iloen.melon.viewholders.SongHolder;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.LinkInfoBase;
import e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import v9.h;

@Metadata(d1 = {"\u0000\u00B6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 e2\u00020\u0001:\u0003efgB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010%J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0017\u00100\u001A\u00020\f2\u0006\u0010/\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b0\u00101J\u0017\u00103\u001A\u00020\f2\u0006\u00102\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b3\u00104J#\u00107\u001A\u00020\f2\n\u00106\u001A\u000605R\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b7\u00108J\u001F\u00109\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001E\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b9\u0010:J/\u0010?\u001A\u00020\f2\u001E\u0010>\u001A\u001A\u0012\u0006\b\u0001\u0012\u00020<\u0018\u00010;j\f\u0012\u0006\b\u0001\u0012\u00020<\u0018\u0001`=H\u0002\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bA\u0010\u0003J\u0017\u0010B\u001A\u00020\f2\u0006\u0010/\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bB\u00101R\u0016\u0010C\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010FR$\u0010I\u001A\u0012\u0012\u0004\u0012\u00020H0;j\b\u0012\u0004\u0012\u00020H`=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001A\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001A\u00020N8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001A\u00020\u00158\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001A\u00020S8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001A\u00020V8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001A\u00020\u00158\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bY\u0010RR\u0018\u0010Z\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010RR\u0018\u0010[\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b[\u0010RR\u0018\u0010\\\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010RR\u0018\u0010]\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b]\u0010RR\u0016\u0010_\u001A\u00020^8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001A\u0004\u0018\u00010a8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bb\u0010c\u00A8\u0006h"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment;", "Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "<init>", "()V", "", "isGenreExclude", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "clickCopy", "playLog", "(Ljava/lang/String;)V", "Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$GenreAdapter;", "adapter", "requestDaySong", "(Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$GenreAdapter;Ljava/lang/String;)V", "requestDayAlbum", "(Lv9/i;Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/common/GenreMenuListInfoBase;", "Lkotlin/collections/ArrayList;", "list", "setGenreMenuData", "(Ljava/util/ArrayList;)V", "setFilterLayout", "updateHeaderLayout", "genreCode", "Ljava/lang/String;", "currentMenuIndex", "I", "currentGenreIndex", "Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$GenreMenuData;", "genreMenuDataList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/LinkInfoBase;", "chartInfoData", "Lcom/melon/net/res/common/LinkInfoBase;", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "mFilterLayout", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "headerContainer", "Landroid/view/View;", "Landroid/widget/TextView;", "tvToggleMenu", "Landroid/widget/TextView;", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scrollableAlyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "viewDim", "playShuffleAllButtons", "playShuffleButton", "playAllButton", "chartInfoTv", "Lcom/android/volley/Response$ErrorListener;", "responseErrorListener", "Lcom/android/volley/Response$ErrorListener;", "Lv9/j;", "getCurrentFilterData", "()Lv9/j;", "currentFilterData", "Companion", "GenreAdapter", "GenreMenuData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartGenreFragment extends MelonChartBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$Companion;", "", "<init>", "()V", "TAG", "", "UNKNOWN_INDEX", "", "FETCH_REASON_ALYAC_CHANGE", "ARG_GENRE_CODE", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment;", "genreCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartGenreFragment newInstance(@NotNull String s) {
            q.g(s, "genreCode");
            MelonChartGenreFragment melonChartGenreFragment0 = new MelonChartGenreFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            melonChartGenreFragment0.setArguments(bundle0);
            return melonChartGenreFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$GenreAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_UNKNOWN", "I", "VIEW_TYPE_SONG", "VIEW_TYPE_ALBUM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GenreAdapter extends p {
        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_SONG;
        private final int VIEW_TYPE_UNKNOWN;

        public GenreAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartGenreFragment.this = melonChartGenreFragment0;
            super(context0, list0);
            this.VIEW_TYPE_UNKNOWN = -1;
            this.VIEW_TYPE_SONG = 1;
            this.VIEW_TYPE_ALBUM = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof CHARTLIST) {
                return this.VIEW_TYPE_SONG;
            }
            return object0 instanceof com.iloen.melon.net.v5x.response.DailyAlbumChartListRes.RESPONSE.CHARTLIST ? this.VIEW_TYPE_ALBUM : this.VIEW_TYPE_UNKNOWN;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            SongHolder songHolder0;
            boolean z1;
            q.g(o00, "viewHolder");
            int v2 = o00.getItemViewType();
            if(v2 == this.VIEW_TYPE_SONG) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.common.ChartSongInfoBase");
                boolean z = ((ChartSongInfoBase)object0).canService;
                ViewUtils.setEnable(((SongHolder)o00).wrapperLayout, z);
                if(z) {
                    z1 = true;
                    songHolder0 = (SongHolder)o00;
                    f f0 = new f(MelonChartGenreFragment.this, v, this, v1, ((ChartSongInfoBase)object0), 1);
                    ViewUtils.setOnClickListener(((SongHolder)o00).itemView, f0);
                    if(this.isMarked(v1)) {
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                        songHolder0.itemView.setBackgroundColor(v3);
                    }
                    else {
                        int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        songHolder0.itemView.setBackgroundColor(v4);
                    }
                }
                else {
                    songHolder0 = (SongHolder)o00;
                    z1 = false;
                    ViewUtils.setOnClickListener(songHolder0.itemView, null);
                    int v5 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    songHolder0.itemView.setBackgroundColor(v5);
                }
                g g0 = new g(MelonChartGenreFragment.this, ((ChartSongInfoBase)object0), this, v1, 1);
                ViewUtils.setOnLongClickListener(songHolder0.itemView, g0);
                Glide.with(this.getContext()).load(((ChartSongInfoBase)object0).albumImg).into(songHolder0.thumbnailIv);
                ViewUtils.showWhen(songHolder0.btnPlay, z1);
                ViewUtils.setOnClickListener(songHolder0.btnPlay, new com.iloen.melon.fragments.melonchart.q(MelonChartGenreFragment.this, ((ChartSongInfoBase)object0), this, v1, 0));
                ViewUtils.showWhen(songHolder0.btnInfo, true);
                ViewUtils.setOnClickListener(songHolder0.btnInfo, new com.iloen.melon.fragments.melonchart.q(MelonChartGenreFragment.this, ((ChartSongInfoBase)object0), this, v1, 1));
                ViewUtils.setOnClickListener(songHolder0.thumbContainer, new i(MelonChartGenreFragment.this, ((ChartSongInfoBase)object0), v1, 2));
                ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                songHolder0.titleTv.setText(((ChartSongInfoBase)object0).songName);
                songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((ChartSongInfoBase)object0).artistList));
                ViewUtils.showWhen(songHolder0.list19Iv, ((ChartSongInfoBase)object0).isAdult);
                ViewUtils.showWhen(songHolder0.listFreeIv, ((ChartSongInfoBase)object0).isFree);
                ViewUtils.showWhen(songHolder0.listHoldbackIv, ((ChartSongInfoBase)object0).isHoldback);
                songHolder0.updownLayout.setVisibility(0);
                songHolder0.listRankingTv.setText(((ChartSongInfoBase)object0).currentRank);
                songHolder0.updownLayout.setVisibility(0);
                songHolder0.listRankingTv.setText(((ChartSongInfoBase)object0).currentRank);
                String s = ((ChartSongInfoBase)object0).rankType;
                if(s != null) {
                    switch(s) {
                        case "DOWN": {
                            songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                            songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                            songHolder0.listChangeTv.setText(((ChartSongInfoBase)object0).rankGap);
                            songHolder0.listChangeTv.setTextSize(1, 12.0f);
                            return;
                        }
                        case "NEW": {
                            songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060459));  // color:rank_new_color
                            songHolder0.listChangeTv.setText("NEW");
                            songHolder0.listChangeTv.setTextSize(1, 10.0f);
                            return;
                        }
                        case "NONE": {
                            songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DB, 0, 0, 0);  // drawable:ic_common_arrow_equal_tint
                            songHolder0.listChangeTv.setText("");
                            return;
                        }
                        case "UP": {
                            songHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                            songHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06045A));  // color:rank_up_color
                            songHolder0.listChangeTv.setText(((ChartSongInfoBase)object0).rankGap);
                            songHolder0.listChangeTv.setTextSize(1, 12.0f);
                        }
                    }
                }
            }
            else if(v2 == this.VIEW_TYPE_ALBUM) {
                AlbumHolder albumHolder0 = (AlbumHolder)o00;
                ViewUtils.hideWhen(albumHolder0.arrowIv, true);
                Object object1 = this.getItem(v1);
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.net.v4x.common.ChartAlbumInfoBase");
                boolean z2 = ((ChartAlbumInfoBase)object1).canService;
                ViewUtils.setEnable(albumHolder0.wrapperLayout, z2);
                ViewUtils.setOnClickListener(albumHolder0.btnPlayIv, new r(z2, MelonChartGenreFragment.this, v1, ((ChartAlbumInfoBase)object1), this));
                if(z2) {
                    i i0 = new i(((ChartAlbumInfoBase)object1), MelonChartGenreFragment.this, v1, 3);
                    ViewUtils.setOnClickListener(albumHolder0.itemView, i0);
                }
                else {
                    ViewUtils.setOnClickListener(albumHolder0.itemView, null);
                }
                g g1 = new g(MelonChartGenreFragment.this, ((ChartAlbumInfoBase)object1), this, v1, 2);
                ViewUtils.setOnLongClickListener(albumHolder0.itemView, g1);
                albumHolder0.btnPlayIv.setImageResource((z2 ? 0x7F080309 : 0x7F0801F1));  // drawable:common_btn_play_01
                Glide.with(this.getContext()).load(((ChartAlbumInfoBase)object1).albumImg).into(albumHolder0.thumbnailIv);
                albumHolder0.titleTv.setText(((ChartAlbumInfoBase)object1).albumName);
                albumHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((ChartAlbumInfoBase)object1).artistList));
                albumHolder0.issueTv.setText(((ChartAlbumInfoBase)object1).issueDate);
                ViewUtils.showWhen(albumHolder0.ratingContainer, true);
                albumHolder0.ratingView.c(((ChartAlbumInfoBase)object1).totAvrgScore);
                albumHolder0.ratingText.setText(Float.toString(((ChartAlbumInfoBase)object1).totAvrgScore));
                albumHolder0.ratingUserCntTv.setText(StringUtils.getCountString(((ChartAlbumInfoBase)object1).ptcPnmPrco, 0x3B9AC9FF));
                ViewUtils.showWhen(albumHolder0.rankLayout, true);
                albumHolder0.rankTv.setText(((ChartAlbumInfoBase)object1).currentRank);
                String s1 = ((ChartAlbumInfoBase)object1).rankType;
                if(s1 != null) {
                    switch(s1) {
                        case "DOWN": {
                            albumHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                            albumHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                            albumHolder0.listChangeTv.setText(((ChartAlbumInfoBase)object1).rankGap);
                            albumHolder0.listChangeTv.setTextSize(1, 12.0f);
                            return;
                        }
                        case "NEW": {
                            albumHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            albumHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060459));  // color:rank_new_color
                            albumHolder0.listChangeTv.setText("NEW");
                            albumHolder0.listChangeTv.setTextSize(1, 10.0f);
                            return;
                        }
                        case "NONE": {
                            albumHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DB, 0, 0, 0);  // drawable:ic_common_arrow_equal_tint
                            albumHolder0.listChangeTv.setText("");
                            return;
                        }
                        case "UP": {
                            albumHolder0.listChangeTv.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                            albumHolder0.listChangeTv.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06045A));  // color:rank_up_color
                            albumHolder0.listChangeTv.setText(((ChartAlbumInfoBase)object1).rankGap);
                            albumHolder0.listChangeTv.setTextSize(1, 12.0f);
                            break;
                        }
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$1(MelonChartGenreFragment melonChartGenreFragment0, int v, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v1, ChartSongInfoBase chartSongInfoBase0, View view0) {
            melonChartGenreFragment0.onItemClick(view0, v);
            if(melonChartGenreFragment$GenreAdapter0.isMarked(v1)) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartGenreFragment0.mMenuId;
                g0.a = "선택";
                g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
                g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.F = "곡선택";
                g0.C = String.valueOf(v1 + 1);
                g0.E = chartSongInfoBase0.albumImg;
                g0.e = chartSongInfoBase0.songId;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.g = chartSongInfoBase0.songName;
                g0.h = chartSongInfoBase0.getArtistNames();
                g0.a().track();
            }
        }

        private static final boolean onBindViewImpl$lambda$2(MelonChartGenreFragment melonChartGenreFragment0, ChartSongInfoBase chartSongInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v, View view0) {
            melonChartGenreFragment0.showContextPopupSongOrInstantPlay(Playable.from(chartSongInfoBase0, melonChartGenreFragment$GenreAdapter0.getMenuId(), null), true);
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "페이지이동";
            g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "더보기";
            g0.C = String.valueOf(v + 1);
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
            return true;
        }

        private static final void onBindViewImpl$lambda$3(MelonChartGenreFragment melonChartGenreFragment0, ChartSongInfoBase chartSongInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v, View view0) {
            melonChartGenreFragment0.playSong(Playable.from(chartSongInfoBase0, melonChartGenreFragment$GenreAdapter0.getMenuId(), null), true);
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "음악재생";
            g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g0.d = ActionKind.PlayMusic;
            g0.y = "곡리스트";
            g0.F = "음악재생";
            g0.C = String.valueOf(v + 1);
            g0.E = chartSongInfoBase0.albumImg;
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$4(MelonChartGenreFragment melonChartGenreFragment0, ChartSongInfoBase chartSongInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v, View view0) {
            melonChartGenreFragment0.showContextPopupSong(Playable.from(chartSongInfoBase0, melonChartGenreFragment$GenreAdapter0.getMenuId(), null), 14);
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "페이지이동";
            g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "더보기";
            g0.C = String.valueOf(v + 1);
            g0.e = chartSongInfoBase0.songId;
            g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
            g0.g = chartSongInfoBase0.songName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$5(MelonChartGenreFragment melonChartGenreFragment0, ChartSongInfoBase chartSongInfoBase0, int v, View view0) {
            melonChartGenreFragment0.showAlbumInfoPage(chartSongInfoBase0);
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "페이지이동";
            g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g0.d = ActionKind.ClickContent;
            g0.y = "곡리스트";
            g0.F = "앨범페이지이동";
            g0.C = String.valueOf(v + 1);
            g0.E = chartSongInfoBase0.albumImg;
            g0.e = chartSongInfoBase0.albumId;
            g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            g0.g = chartSongInfoBase0.albumName;
            g0.h = chartSongInfoBase0.getArtistNames();
            g0.a().track();
        }

        private static final void onBindViewImpl$lambda$6(boolean z, MelonChartGenreFragment melonChartGenreFragment0, int v, ChartAlbumInfoBase chartAlbumInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, View view0) {
            if(z) {
                melonChartGenreFragment0.playAlbum(v);
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartGenreFragment0.mMenuId;
                g0.a = "음악재생";
                g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
                g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
                g0.d = ActionKind.PlayMusic;
                g0.y = "앨범리스트";
                g0.F = "음악재생";
                g0.C = String.valueOf(v + 1);
                g0.e = chartAlbumInfoBase0.albumId;
                g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                g0.g = chartAlbumInfoBase0.albumName;
                g0.h = chartAlbumInfoBase0.getArtistNames();
                g0.a().track();
                return;
            }
            melonChartGenreFragment0.showContextPopupAlbum(Playable.from(chartAlbumInfoBase0, melonChartGenreFragment$GenreAdapter0.getMenuId(), null));
            p8.g g1 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g1.I = melonChartGenreFragment0.mMenuId;
            g1.a = "페이지이동";
            g1.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g1.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g1.d = ActionKind.ClickContent;
            g1.y = "앨범리스트";
            g1.F = "더보기";
            g1.C = String.valueOf(v + 1);
            g1.e = chartAlbumInfoBase0.albumId;
            g1.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            g1.g = chartAlbumInfoBase0.albumName;
            g1.h = chartAlbumInfoBase0.getArtistNames();
            g1.a().track();
        }

        private static final void onBindViewImpl$lambda$7(ChartAlbumInfoBase chartAlbumInfoBase0, MelonChartGenreFragment melonChartGenreFragment0, int v, View view0) {
            if(chartAlbumInfoBase0.albumId != null && chartAlbumInfoBase0.albumId.length() != 0) {
                melonChartGenreFragment0.showAlbumInfoPage(chartAlbumInfoBase0.albumId);
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartGenreFragment0.mMenuId;
                g0.a = "페이지이동";
                g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
                g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
                g0.d = ActionKind.ClickContent;
                g0.y = "앨범리스트";
                g0.F = "앨범페이지이동";
                g0.C = String.valueOf(v + 1);
                g0.E = chartAlbumInfoBase0.albumImg;
                g0.e = chartAlbumInfoBase0.albumId;
                g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
                g0.g = chartAlbumInfoBase0.albumName;
                g0.h = chartAlbumInfoBase0.getArtistNames();
                g0.a().track();
            }
        }

        private static final boolean onBindViewImpl$lambda$8(MelonChartGenreFragment melonChartGenreFragment0, ChartAlbumInfoBase chartAlbumInfoBase0, GenreAdapter melonChartGenreFragment$GenreAdapter0, int v, View view0) {
            melonChartGenreFragment0.showContextPopupAlbum(Playable.from(chartAlbumInfoBase0, melonChartGenreFragment$GenreAdapter0.getMenuId(), null));
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "페이지이동";
            g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
            g0.d = ActionKind.ClickContent;
            g0.y = "앨범리스트";
            g0.F = "더보기";
            g0.C = String.valueOf(v + 1);
            g0.e = chartAlbumInfoBase0.albumId;
            g0.f = Y.i(ContsTypeCode.ALBUM, "code(...)");
            g0.g = chartAlbumInfoBase0.albumName;
            g0.h = chartAlbumInfoBase0.getArtistNames();
            g0.a().track();
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = null;
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_SONG) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
                q.f(view0, "inflate(...)");
                return new c(view0);
            }
            if(v == this.VIEW_TYPE_ALBUM) {
                O0 o00 = new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false));  // layout:listitem_album
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = o00.wrapperLayout.getLayoutParams();
                if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                    viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0;
                }
                if(viewGroup$MarginLayoutParams0 != null) {
                    viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 4.0f);
                }
                return o00;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\'\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartGenreFragment$GenreMenuData;", "", "", "menuName", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getMenuName", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "genreFilterDataList", "Ljava/util/ArrayList;", "getGenreFilterDataList", "()Ljava/util/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class GenreMenuData {
        @NotNull
        private final ArrayList genreFilterDataList;
        @NotNull
        private final String menuName;

        public GenreMenuData(@NotNull String s) {
            q.g(s, "menuName");
            super();
            this.menuName = s;
            this.genreFilterDataList = new ArrayList();
        }

        @NotNull
        public final ArrayList getGenreFilterDataList() {
            return this.genreFilterDataList;
        }

        @NotNull
        public final String getMenuName() {
            return this.menuName;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_GENRE_CODE = "argGenreCode";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String FETCH_REASON_ALYAC_CHANGE = "alyac change";
    @NotNull
    private static final String TAG = "MelonChartGenreFragment";
    private static final int UNKNOWN_INDEX = -1;
    @Nullable
    private LinkInfoBase chartInfoData;
    @Nullable
    private View chartInfoTv;
    private int currentGenreIndex;
    private int currentMenuIndex;
    @NotNull
    private String genreCode;
    @NotNull
    private final ArrayList genreMenuDataList;
    private View headerContainer;
    private NewChartFilterLayout mFilterLayout;
    @Nullable
    private View playAllButton;
    @Nullable
    private View playShuffleAllButtons;
    @Nullable
    private View playShuffleButton;
    @NotNull
    private ErrorListener responseErrorListener;
    private ScrollableAlyacFilter scrollableAlyacFilter;
    private TextView tvToggleMenu;
    private View viewDim;

    static {
        MelonChartGenreFragment.Companion = new Companion(null);
        MelonChartGenreFragment.$stable = 8;
    }

    public MelonChartGenreFragment() {
        this.genreCode = "";
        this.currentMenuIndex = -1;
        this.currentGenreIndex = -1;
        this.genreMenuDataList = new ArrayList();
        this.responseErrorListener = new m(this);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0264, null, false);  // layout:filter_chart_genre
        q.f(view0, "inflate(...)");
        this.headerContainer = view0;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new GenreAdapter(this, context0, null);
        ((p)j00).setHasMore(false);
        ((j)j00).setMarkedMode(true);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.o0.buildUpon(), "genreCode", this.genreCode, "toString(...)");
    }

    private final v9.j getCurrentFilterData() {
        if(!this.genreMenuDataList.isEmpty()) {
            GenreMenuData melonChartGenreFragment$GenreMenuData0 = (GenreMenuData)je.p.n0(this.currentMenuIndex, this.genreMenuDataList);
            ArrayList arrayList0 = melonChartGenreFragment$GenreMenuData0 == null ? null : melonChartGenreFragment$GenreMenuData0.getGenreFilterDataList();
            return arrayList0 == null ? null : ((v9.j)je.p.n0(this.currentGenreIndex, arrayList0));
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        if(ScreenUtils.isOrientationPortrait(this.getContext())) {
            View view0 = this.headerContainer;
            if(view0 == null) {
                q.m("headerContainer");
                throw null;
            }
            else if(view0.getVisibility() == 0) {
                if("GN2200".equals(this.genreCode)) {
                    return ScreenUtils.dipToPixel(this.getContext(), 38.0f);
                }
                Context context0 = this.getContext();
                if(context0 != null) {
                    Resources resources0 = context0.getResources();
                    return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07008C);  // dimen:chart_parallax_header_fixed_height
                }
                return 0;
            }
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        View view0 = this.headerContainer;
        if(view0 != null) {
            if(view0.getVisibility() == 0) {
                int v = ScreenUtils.dipToPixel(this.getContext(), 168.0f);
                return "GN2200".equals(this.genreCode) ? v - ScreenUtils.dipToPixel(this.getContext(), 74.0f) : v;
            }
            return 0;
        }
        q.m("headerContainer");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isGenreExclude() {
        return true;
    }

    @NotNull
    public static final MelonChartGenreFragment newInstance(@NotNull String s) {
        return MelonChartGenreFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.scrollableAlyacFilter;
        if(scrollableAlyacFilter0 != null) {
            scrollableAlyacFilter0.c(this.currentGenreIndex);
            this.onUpdateParallaxHeader();
            return;
        }
        q.m("scrollableAlyacFilter");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartGenreFragment.GenreAdapter");
        ((GenreAdapter)j00).clear();
        this.chartInfoData = null;
        if("GN2200".equals(this.genreCode)) {
            this.setAllCheckButtonVisibility(false);
            this.requestDayAlbum(i0, s);
            return true;
        }
        this.requestDaySong(((GenreAdapter)j00), s);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argGenreCode");
        if(s == null) {
            s = "";
        }
        this.genreCode = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", this.genreCode);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        int v = 8;
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        View view1 = view0.findViewById(0x7F0A0D43);  // id:tv_toggle_menu
        q.f(view1, "findViewById(...)");
        this.tvToggleMenu = (TextView)view1;
        View view2 = view0.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.f(view2, "findViewById(...)");
        this.scrollableAlyacFilter = (ScrollableAlyacFilter)view2;
        View view3 = view0.findViewById(0x7F0A0DC3);  // id:view_dim
        q.f(view3, "findViewById(...)");
        this.viewDim = view3;
        View view4 = view0.findViewById(0x7F0A0498);  // id:filter
        q.f(view4, "findViewById(...)");
        this.mFilterLayout = (NewChartFilterLayout)view4;
        this.playShuffleAllButtons = view0.findViewById(0x7F0A01BC);  // id:btn_shuffle_play_all
        View view5 = view0.findViewById(0x7F0A024A);  // id:chart_info_tv
        this.chartInfoTv = view5;
        boolean z = false;
        if(view5 != null) {
            if(this.chartInfoData != null) {
                v = 0;
            }
            view5.setVisibility(v);
        }
        View view6 = this.chartInfoTv;
        if(view6 != null) {
            view6.setOnClickListener(new n(this, 0));
        }
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.scrollableAlyacFilter;
        if(scrollableAlyacFilter0 != null) {
            scrollableAlyacFilter0.setOnScrollChangeListener(new o(this));
            this.setFilterLayout();
            View view7 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
            this.playShuffleButton = view7;
            if(view7 != null) {
                view7.setOnClickListener(new n(this, 1));
            }
            View view8 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
            this.playAllButton = view8;
            if(view8 != null) {
                view8.setOnClickListener(new n(this, 2));
            }
            if(!"GN2200".equals(this.genreCode) && this.getItemCount() > 0) {
                z = true;
            }
            this.setAllCheckButtonVisibility(z);
            return;
        }
        q.m("scrollableAlyacFilter");
        throw null;
    }

    private static final void onViewCreated$lambda$1(MelonChartGenreFragment melonChartGenreFragment0, View view0) {
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        LinkInfoBase linkInfoBase0 = melonChartGenreFragment0.chartInfoData;
        String s = null;
        melonLinkInfo0.a = linkInfoBase0 == null ? null : linkInfoBase0.linktype;
        if(linkInfoBase0 != null) {
            s = linkInfoBase0.linkurl;
        }
        melonLinkInfo0.b = s;
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    private static final void onViewCreated$lambda$2(MelonChartGenreFragment melonChartGenreFragment0, View view0, int v, int v1, int v2, int v3) {
        int v4 = 0;
        View view1 = melonChartGenreFragment0.viewDim;
        if(view1 != null) {
            if(v <= 0) {
                v4 = 8;
            }
            view1.setVisibility(v4);
            return;
        }
        q.m("viewDim");
        throw null;
    }

    private static final void onViewCreated$lambda$3(MelonChartGenreFragment melonChartGenreFragment0, View view0) {
        melonChartGenreFragment0.checkAndShowBanPopup();
        melonChartGenreFragment0.playShuffleAll();
        String s = melonChartGenreFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        q.f(s, "getString(...)");
        melonChartGenreFragment0.playLog(s);
    }

    private static final void onViewCreated$lambda$4(MelonChartGenreFragment melonChartGenreFragment0, View view0) {
        melonChartGenreFragment0.checkAndShowBanPopup();
        melonChartGenreFragment0.playAll();
        String s = melonChartGenreFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        q.f(s, "getString(...)");
        melonChartGenreFragment0.playLog(s);
    }

    private final void playLog(String s) {
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = this.mMenuId;
        g0.a = "음악재생";
        s s1 = this.mMelonTiaraProperty;
        String s2 = null;
        g0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s2 = s1.b;
        }
        g0.c = s2;
        g0.y = "곡리스트";
        g0.F = s;
        g0.a().track();
    }

    private final void requestDayAlbum(v9.i i0, String s) {
        Params dailyAlbumChartListReq$Params0 = new Params();
        dailyAlbumChartListReq$Params0.startIndex = 1;
        dailyAlbumChartListReq$Params0.pageSize = 100;
        dailyAlbumChartListReq$Params0.gnrCode = "GN2200";
        RequestBuilder.newInstance(new DailyAlbumChartListReq(this.getContext(), dailyAlbumChartListReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.melonchart.p(this, i0, s, 2)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestDayAlbum$lambda$11(MelonChartGenreFragment melonChartGenreFragment0, v9.i i0, String s, DailyAlbumChartListRes dailyAlbumChartListRes0) {
        if(!melonChartGenreFragment0.prepareFetchComplete(dailyAlbumChartListRes0)) {
            return;
        }
        if(dailyAlbumChartListRes0 != null) {
            RESPONSE dailyAlbumChartListRes$RESPONSE0 = dailyAlbumChartListRes0.response;
            if(dailyAlbumChartListRes$RESPONSE0 != null) {
                if(melonChartGenreFragment0.genreMenuDataList.isEmpty()) {
                    melonChartGenreFragment0.setGenreMenuData(dailyAlbumChartListRes$RESPONSE0.gnrmenuList);
                }
                if(!q.b(s, "alyac change")) {
                    melonChartGenreFragment0.setFilterLayout();
                }
                CHARTINFO dailyAlbumChartListRes$RESPONSE$CHARTINFO0 = dailyAlbumChartListRes$RESPONSE0.chartInfo;
                melonChartGenreFragment0.chartInfoData = dailyAlbumChartListRes$RESPONSE$CHARTINFO0;
                View view0 = melonChartGenreFragment0.chartInfoTv;
                if(view0 != null) {
                    view0.setVisibility((dailyAlbumChartListRes$RESPONSE$CHARTINFO0 == null ? 8 : 0));
                }
                j0 j00 = melonChartGenreFragment0.getAdapter();
                j j0 = j00 instanceof j ? ((j)j00) : null;
                if(j0 != null) {
                    j0.setListContentType(2);
                }
                melonChartGenreFragment0.updateHeaderLayout(true);
                melonChartGenreFragment0.mMelonTiaraProperty = new s(dailyAlbumChartListRes$RESPONSE0.section, dailyAlbumChartListRes$RESPONSE0.page, "", null);
            }
        }
        melonChartGenreFragment0.performFetchComplete(i0, dailyAlbumChartListRes0);
    }

    private final void requestDaySong(GenreAdapter melonChartGenreFragment$GenreAdapter0, String s) {
        com.iloen.melon.net.v5x.request.DailySongChartListReq.Params dailySongChartListReq$Params0 = new com.iloen.melon.net.v5x.request.DailySongChartListReq.Params();
        dailySongChartListReq$Params0.startIndex = 1;
        dailySongChartListReq$Params0.pageSize = 100;
        dailySongChartListReq$Params0.gnrCode = this.genreCode;
        RequestBuilder.newInstance(new DailySongChartListReq(this.getContext(), dailySongChartListReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.melonchart.p(this, s, melonChartGenreFragment$GenreAdapter0, 0)).errorListener(this.responseErrorListener).request();
    }

    private static final void requestDaySong$lambda$8(MelonChartGenreFragment melonChartGenreFragment0, String s, GenreAdapter melonChartGenreFragment$GenreAdapter0, DailySongChartListRes dailySongChartListRes0) {
        int v = 0;
        if(!melonChartGenreFragment0.prepareFetchComplete(dailySongChartListRes0)) {
            melonChartGenreFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        if(dailySongChartListRes0 != null) {
            com.iloen.melon.net.v5x.response.DailySongChartListRes.RESPONSE dailySongChartListRes$RESPONSE0 = dailySongChartListRes0.response;
            if(dailySongChartListRes$RESPONSE0 != null) {
                if(melonChartGenreFragment0.genreMenuDataList.isEmpty()) {
                    melonChartGenreFragment0.setGenreMenuData(dailySongChartListRes$RESPONSE0.gnrmenuList);
                }
                if(!q.b(s, "alyac change")) {
                    melonChartGenreFragment0.setFilterLayout();
                }
                com.iloen.melon.net.v5x.response.DailySongChartListRes.RESPONSE.CHARTINFO dailySongChartListRes$RESPONSE$CHARTINFO0 = dailySongChartListRes$RESPONSE0.chartInfo;
                melonChartGenreFragment0.chartInfoData = dailySongChartListRes$RESPONSE$CHARTINFO0;
                View view0 = melonChartGenreFragment0.chartInfoTv;
                if(view0 != null) {
                    if(dailySongChartListRes$RESPONSE$CHARTINFO0 == null) {
                        v = 8;
                    }
                    view0.setVisibility(v);
                }
                GenreAdapter melonChartGenreFragment$GenreAdapter1 = melonChartGenreFragment$GenreAdapter0 == null ? null : melonChartGenreFragment$GenreAdapter0;
                if(melonChartGenreFragment$GenreAdapter1 != null) {
                    melonChartGenreFragment$GenreAdapter1.setListContentType(1);
                }
                if(dailySongChartListRes$RESPONSE0.chartList != null && !dailySongChartListRes$RESPONSE0.chartList.isEmpty() == 1) {
                    melonChartGenreFragment0.updateHeaderLayout(true);
                    melonChartGenreFragment0.setAllCheckButtonVisibility(true);
                    melonChartGenreFragment$GenreAdapter0.addAll(dailySongChartListRes$RESPONSE0.chartList);
                    melonChartGenreFragment$GenreAdapter0.setMenuId(dailySongChartListRes$RESPONSE0.menuId);
                    melonChartGenreFragment$GenreAdapter0.updateModifiedTime(melonChartGenreFragment0.getCacheKey());
                }
                melonChartGenreFragment0.mMelonTiaraProperty = new s(dailySongChartListRes$RESPONSE0.section, dailySongChartListRes$RESPONSE0.page, dailySongChartListRes0.getMenuId(), null);
            }
        }
        melonChartGenreFragment0.performFetchCompleteOnlyViews();
    }

    private static final void responseErrorListener$lambda$22(MelonChartGenreFragment melonChartGenreFragment0, VolleyError volleyError0) {
        melonChartGenreFragment0.performFetchError(volleyError0);
        melonChartGenreFragment0.mResponse = null;
        melonChartGenreFragment0.updateHeaderLayout(false);
        melonChartGenreFragment0.setAllCheckButtonVisibility(false);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            View view0 = this.playShuffleAllButtons;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            NewChartFilterLayout newChartFilterLayout0 = this.mFilterLayout;
            if(newChartFilterLayout0 != null) {
                newChartFilterLayout0.setOnCheckedListener(new m(this));
                this.updateParallaxHeaderView();
                return;
            }
            q.m("mFilterLayout");
            throw null;
        }
        View view1 = this.playShuffleAllButtons;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        NewChartFilterLayout newChartFilterLayout1 = this.mFilterLayout;
        if(newChartFilterLayout1 != null) {
            newChartFilterLayout1.setOnCheckedListener(null);
            NewChartFilterLayout newChartFilterLayout2 = this.mFilterLayout;
            if(newChartFilterLayout2 != null) {
                newChartFilterLayout2.setLeftButton(null);
                this.updateParallaxHeaderView();
                return;
            }
            q.m("mFilterLayout");
            throw null;
        }
        q.m("mFilterLayout");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$5(MelonChartGenreFragment melonChartGenreFragment0, S s0, boolean z) {
        melonChartGenreFragment0.toggleSelectAll();
        if(melonChartGenreFragment0.mMarkedAll) {
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartGenreFragment0.mMenuId;
            g0.a = "선택";
            s s1 = melonChartGenreFragment0.mMelonTiaraProperty;
            String s2 = null;
            g0.b = s1 == null ? null : s1.a;
            if(s1 != null) {
                s2 = s1.b;
            }
            g0.c = s2;
            g0.y = "곡리스트";
            g0.F = "전체선택";
            g0.a().track();
        }
    }

    private final void setFilterLayout() {
        if(this.genreMenuDataList.isEmpty()) {
            return;
        }
        if(this.currentMenuIndex == -1 || this.currentGenreIndex == -1) {
            if(this.genreCode.length() == 0) {
                this.currentMenuIndex = 0;
                this.currentGenreIndex = 0;
            }
            else {
                int v = 0;
                Iterator iterator0 = this.genreMenuDataList.iterator();
            label_9:
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    if(v >= 0) {
                        int v1 = 0;
                        for(Object object1: ((GenreMenuData)object0).getGenreFilterDataList()) {
                            if(v1 >= 0) {
                                if(q.b(this.genreCode, ((v9.j)object1).c)) {
                                    this.currentMenuIndex = v;
                                    this.currentGenreIndex = v1;
                                    break label_9;
                                }
                                ++v1;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
        if(this.currentMenuIndex <= -1) {
            this.currentMenuIndex = 0;
        }
        if(this.currentGenreIndex <= -1) {
            this.currentGenreIndex = 0;
        }
        Object object2 = this.genreMenuDataList.get(this.currentMenuIndex);
        q.f(object2, "get(...)");
        TextView textView0 = this.tvToggleMenu;
        if(textView0 != null) {
            if(textView0.getVisibility() != 0) {
                TextView textView1 = this.tvToggleMenu;
                if(textView1 != null) {
                    textView1.setVisibility(0);
                    goto label_44;
                }
                q.m("tvToggleMenu");
                throw null;
            }
        label_44:
            TextView textView2 = this.tvToggleMenu;
            if(textView2 != null) {
                textView2.setText(((GenreMenuData)object2).getMenuName());
                TextView textView3 = this.tvToggleMenu;
                if(textView3 != null) {
                    textView3.setOnClickListener(new n(this, 3));
                    ScrollableAlyacFilter scrollableAlyacFilter0 = this.scrollableAlyacFilter;
                    if(scrollableAlyacFilter0 != null) {
                        int v2 = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
                        scrollableAlyacFilter0.g = 0;
                        scrollableAlyacFilter0.h = v2;
                        ScrollableAlyacFilter scrollableAlyacFilter1 = this.scrollableAlyacFilter;
                        if(scrollableAlyacFilter1 != null) {
                            Object object3 = ((GenreMenuData)this.genreMenuDataList.get(this.currentMenuIndex)).getGenreFilterDataList().clone();
                            q.e(object3, "null cannot be cast to non-null type kotlin.collections.List<com.iloen.melon.types.FilterData>");
                            scrollableAlyacFilter1.a(((List)object3));
                            ScrollableAlyacFilter scrollableAlyacFilter2 = this.scrollableAlyacFilter;
                            if(scrollableAlyacFilter2 != null) {
                                scrollableAlyacFilter2.setSelectedIndex(this.currentGenreIndex);
                                ScrollableAlyacFilter scrollableAlyacFilter3 = this.scrollableAlyacFilter;
                                if(scrollableAlyacFilter3 != null) {
                                    scrollableAlyacFilter3.e(new m(this), new E8.c());  // 初始化器: Ljava/lang/Object;-><init>()V
                                    return;
                                }
                                q.m("scrollableAlyacFilter");
                                throw null;
                            }
                            q.m("scrollableAlyacFilter");
                            throw null;
                        }
                        q.m("scrollableAlyacFilter");
                        throw null;
                    }
                    q.m("scrollableAlyacFilter");
                    throw null;
                }
                q.m("tvToggleMenu");
                throw null;
            }
            q.m("tvToggleMenu");
            throw null;
        }
        q.m("tvToggleMenu");
        throw null;
    }

    private static final void setFilterLayout$lambda$18(MelonChartGenreFragment melonChartGenreFragment0, View view0) {
        String s;
        melonChartGenreFragment0.currentMenuIndex = (melonChartGenreFragment0.currentMenuIndex + 1) % melonChartGenreFragment0.genreMenuDataList.size();
        melonChartGenreFragment0.currentGenreIndex = 0;
        v9.j j0 = melonChartGenreFragment0.getCurrentFilterData();
        if(j0 == null) {
            s = "";
        }
        else {
            s = j0.c;
            if(s == null) {
                s = "";
            }
        }
        melonChartGenreFragment0.genreCode = s;
        melonChartGenreFragment0.startFetch("toggle change");
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = melonChartGenreFragment0.mMenuId;
        g0.a = "페이지이동";
        g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
        g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
        g0.y = "Pagemenu";
        g0.F = ((GenreMenuData)melonChartGenreFragment0.genreMenuDataList.get(melonChartGenreFragment0.currentMenuIndex)).getMenuName();
        g0.a().track();
    }

    private static final void setFilterLayout$lambda$19(MelonChartGenreFragment melonChartGenreFragment0, int v) {
        String s1;
        if(melonChartGenreFragment0.currentGenreIndex == v) {
            return;
        }
        melonChartGenreFragment0.currentGenreIndex = v;
        v9.j j0 = melonChartGenreFragment0.getCurrentFilterData();
        String s = "";
        if(j0 == null) {
            s1 = "";
        }
        else {
            s1 = j0.c;
            if(s1 == null) {
                s1 = "";
            }
        }
        melonChartGenreFragment0.genreCode = s1;
        melonChartGenreFragment0.startFetch("alyac change");
        String s2 = ((GenreMenuData)melonChartGenreFragment0.genreMenuDataList.get(melonChartGenreFragment0.currentMenuIndex)).getMenuName();
        v9.j j1 = melonChartGenreFragment0.getCurrentFilterData();
        if(j1 != null) {
            String s3 = j1.b;
            if(s3 != null) {
                s = s3;
            }
        }
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = melonChartGenreFragment0.mMenuId;
        g0.a = "페이지이동";
        g0.b = melonChartGenreFragment0.mMelonTiaraProperty.a;
        g0.c = melonChartGenreFragment0.mMelonTiaraProperty.b;
        g0.y = "Pagemenu";
        g0.F = s2 + ":" + s;
        g0.a().track();
    }

    private final void setGenreMenuData(ArrayList arrayList0) {
        if(arrayList0 != null) {
            this.genreMenuDataList.clear();
            for(Object object0: arrayList0) {
                String s = ((GenreMenuListInfoBase)object0).menuName;
                if(s == null) {
                    s = "";
                }
                GenreMenuData melonChartGenreFragment$GenreMenuData0 = new GenreMenuData(s);
                ArrayList arrayList1 = ((GenreMenuListInfoBase)object0).gnrlist;
                q.f(arrayList1, "gnrlist");
                for(Object object1: arrayList1) {
                    v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j0.c = ((GNRLIST)object1).genreCode;
                    j0.b = ((GNRLIST)object1).genreName;
                    melonChartGenreFragment$GenreMenuData0.getGenreFilterDataList().add(j0);
                }
                this.genreMenuDataList.add(melonChartGenreFragment$GenreMenuData0);
            }
        }
    }

    private final void updateHeaderLayout(boolean z) {
        int v = 0;
        View view0 = this.headerContainer;
        if(view0 != null) {
            if(view0.getVisibility() == 0 != z) {
                View view1 = this.headerContainer;
                if(view1 != null) {
                    if(!z) {
                        v = 8;
                    }
                    view1.setVisibility(v);
                    this.onUpdateParallaxHeader();
                    return;
                }
                q.m("headerContainer");
                throw null;
            }
            return;
        }
        q.m("headerContainer");
        throw null;
    }
}

