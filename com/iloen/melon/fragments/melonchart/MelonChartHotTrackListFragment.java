package com.iloen.melon.fragments.melonchart;

import B9.c;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.NewChartFilterLayout;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.HotTrackListReq.Params;
import com.iloen.melon.net.v5x.request.HotTrackListReq;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE.GENRECODELIST.GNRLIST;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE.GENRECODELIST;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE.HOTTRACKCODES;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE.TAGINFO.TAGLIST;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE.TAGINFO;
import com.iloen.melon.net.v5x.response.HotTrackListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.HotTrackListRes;
import com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.popup.SingleFilterListPopup.SectionedFilter;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.kakao.tiara.data.ActionKind;
import e.k;
import ie.H;
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
import v9.i;

@Metadata(d1 = {"\u0000\u00A4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 b2\u00020\u0001:\u0003bcdB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u0017\u0010\u0010\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J-\u0010 \u001A\u00020\u001F2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010&J\u0017\u0010)\u001A\u00020\t2\u0006\u0010(\u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b)\u0010*J\u001B\u0010.\u001A\u0006\u0012\u0002\b\u00030-2\u0006\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b.\u0010/J\u0017\u00101\u001A\u00020\t2\u0006\u00100\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b1\u0010*J\u001F\u00104\u001A\u00020\t2\u0006\u00102\u001A\u00020\u00042\u0006\u00103\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00106\u001A\u00020\t2\u0006\u00100\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b6\u0010*J\u000F\u00107\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b7\u0010\u0006J\u0017\u00108\u001A\u00020$2\u0006\u0010\u001B\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b:\u0010\u0003R\u0016\u0010;\u001A\u00020\u00048\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010<R\u0018\u0010>\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010?\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010<R\u0018\u0010@\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010<R&\u0010D\u001A\u0012\u0012\u0004\u0012\u00020B0Aj\b\u0012\u0004\u0012\u00020B`C8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001A\u00020F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010HR&\u0010J\u001A\u0012\u0012\u0004\u0012\u00020I0Aj\b\u0012\u0004\u0012\u00020I`C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010ER\u0016\u0010K\u001A\u00020$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001A\u00020\u00128\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001A\u00020O8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010S\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010NR&\u0010U\u001A\u0012\u0012\u0004\u0012\u00020T0Aj\b\u0012\u0004\u0012\u00020T`C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010ER&\u0010W\u001A\u0012\u0012\u0004\u0012\u00020V0Aj\b\u0012\u0004\u0012\u00020V`C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010ER\u0016\u0010X\u001A\u00020$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010Y\u001A\u00020$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bY\u0010LR&\u0010[\u001A\u0012\u0012\u0004\u0012\u00020Z0Aj\b\u0012\u0004\u0012\u00020Z`C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b[\u0010ER&\u0010\\\u001A\u0012\u0012\u0004\u0012\u00020I0Aj\b\u0012\u0004\u0012\u00020I`C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010ER\u0016\u0010]\u001A\u00020$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b]\u0010LR\u0014\u0010_\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b^\u0010\u0006R\u0014\u0010a\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b`\u0010\u0006\u00A8\u0006e"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment;", "Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "show", "updateToolBar", "(Z)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "isVisible", "updateHeaderLayout", "actionTypeCode", "actionLayer2", "playLog", "(Ljava/lang/String;Ljava/lang/String;)V", "setAllCheckButtonVisibility", "getFilterCode", "getFilterIndex", "(Ljava/lang/String;)I", "initAlyac", "typeCode", "Ljava/lang/String;", "genreCode", "genreName", "tagSeq", "tagName", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/HotTrackListRes$RESPONSE$HOTTRACKCODES;", "Lkotlin/collections/ArrayList;", "hotTrackCodeList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scAlyacFilterView", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "Lv9/j;", "hotTrackFilterDataList", "currentFilterIndex", "I", "headerContainer", "Landroid/view/View;", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/NewChartFilterLayout;", "playShuffleButton", "playAllButton", "Lcom/iloen/melon/net/v5x/response/HotTrackListRes$RESPONSE$GENRECODELIST;", "genreCodeList", "Lcom/iloen/melon/popup/SingleFilterListPopup$SectionedFilter;", "genreSortDataList", "currentGenreSectionIndex", "currentGenrePositionInSection", "Lcom/iloen/melon/net/v5x/response/HotTrackListRes$RESPONSE$TAGINFO$TAGLIST;", "tagList", "tagSortDataList", "currentTagSortingIndex", "getFilterName", "filterName", "getGenreOrTagName", "genreOrTagName", "Companion", "HotTrackType", "HotTracksSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartHotTrackListFragment extends MelonChartBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001A\u00020\u000EH\u0007J\u001A\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005H\u0007J$\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005H\u0007R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "ARG_TYPE_CODE", "ARG_FILTER_CODE", "ARG_FILTER_NAME", "ARG_TYPE_INDEX", "ARG_FILTER_INDEX", "REASON_FILTER_CHANGE", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment;", "typeCode", "filterCode", "filterName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartHotTrackListFragment newInstance() {
            return this.newInstance("", "");
        }

        @NotNull
        public final MelonChartHotTrackListFragment newInstance(@NotNull String s, @Nullable String s1) {
            q.g(s, "typeCode");
            return this.newInstance(s, s1, "");
        }

        @NotNull
        public final MelonChartHotTrackListFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2) {
            q.g(s, "typeCode");
            MelonChartHotTrackListFragment melonChartHotTrackListFragment0 = new MelonChartHotTrackListFragment();
            Bundle bundle0 = Y.c("argTypeCode", s, "argFilterCode", s1);
            bundle0.putString("argFilterName", s2);
            melonChartHotTrackListFragment0.setArguments(bundle0);
            return melonChartHotTrackListFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment$HotTrackType;", "", "<init>", "()V", "GENRE", "", "SEARCH", "DJ", "LIKE", "TAG", "PROFILE", "JUSTSONG", "RISING", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class HotTrackType {
        public static final int $stable = 0;
        @NotNull
        public static final String DJ = "HOT_03";
        @NotNull
        public static final String GENRE = "HOT_01";
        @NotNull
        public static final HotTrackType INSTANCE = null;
        @NotNull
        public static final String JUSTSONG = "HOT_07";
        @NotNull
        public static final String LIKE = "HOT_04";
        @NotNull
        public static final String PROFILE = "HOT_06";
        @NotNull
        public static final String RISING = "HOT_08";
        @NotNull
        public static final String SEARCH = "HOT_02";
        @NotNull
        public static final String TAG = "HOT_05";

        static {
            HotTrackType.INSTANCE = new HotTrackType();
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment$HotTracksSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartHotTrackListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "viewTypeSong", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HotTracksSongAdapter extends p {
        private final int viewTypeSong;

        public HotTracksSongAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartHotTrackListFragment.this = melonChartHotTrackListFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.viewTypeSong;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof HotTrackListRes) {
                RESPONSE hotTrackListRes$RESPONSE0 = ((HotTrackListRes)httpResponse0).response;
                if(hotTrackListRes$RESPONSE0 != null) {
                    this.setHasMore(false);
                    this.setMenuId(hotTrackListRes$RESPONSE0.menuId);
                    this.updateModifiedTime(this.getCacheKey());
                    ArrayList arrayList0 = hotTrackListRes$RESPONSE0.chartList;
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        this.addAll(arrayList0);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.viewTypeSong) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.HotTrackRes.RESPONSE.HOTTRACKS.CHARTLIST");
                boolean z = ((CHARTLIST)object0).canService;
                ViewUtils.setEnable(((SongHolder)o00).wrapperLayout, z);
                if(z) {
                    f f0 = new f(MelonChartHotTrackListFragment.this, v, this, v1, ((CHARTLIST)object0), 2);
                    ViewUtils.setOnClickListener(((SongHolder)o00).itemView, f0);
                    if(this.isMarked(v1)) {
                        int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                        ((SongHolder)o00).itemView.setBackgroundColor(v2);
                    }
                    else {
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        ((SongHolder)o00).itemView.setBackgroundColor(v3);
                    }
                }
                else {
                    ViewUtils.setOnClickListener(((SongHolder)o00).itemView, null);
                    int v4 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    ((SongHolder)o00).itemView.setBackgroundColor(v4);
                }
                g g0 = new g(MelonChartHotTrackListFragment.this, ((CHARTLIST)object0), this, v1, 3);
                ViewUtils.setOnLongClickListener(((SongHolder)o00).itemView, g0);
                Glide.with(this.getContext()).load(((CHARTLIST)object0).albumImg).into(((SongHolder)o00).thumbnailIv);
                ViewUtils.showWhen(((SongHolder)o00).btnPlay, z);
                ViewUtils.setOnClickListener(((SongHolder)o00).btnPlay, new v(MelonChartHotTrackListFragment.this, ((CHARTLIST)object0), this, v1, 0));
                ViewUtils.showWhen(((SongHolder)o00).btnInfo, true);
                ViewUtils.setOnClickListener(((SongHolder)o00).btnInfo, new v(MelonChartHotTrackListFragment.this, ((CHARTLIST)object0), this, v1, 1));
                ViewUtils.setOnClickListener(((SongHolder)o00).thumbContainer, new com.iloen.melon.fragments.melonchart.i(MelonChartHotTrackListFragment.this, ((CHARTLIST)object0), v1, 4));
                ViewUtils.setTextViewMarquee(((SongHolder)o00).titleTv, this.isMarqueeNeeded(v1));
                ((SongHolder)o00).titleTv.setText(((CHARTLIST)object0).songName);
                ((SongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((CHARTLIST)object0).artistList));
                ViewUtils.showWhen(((SongHolder)o00).list19Iv, ((CHARTLIST)object0).isAdult);
                ViewUtils.showWhen(((SongHolder)o00).listFreeIv, ((CHARTLIST)object0).isFree);
                ViewUtils.showWhen(((SongHolder)o00).listHoldbackIv, ((CHARTLIST)object0).isHoldback);
            }
        }

        private static final void onBindViewImpl$lambda$1(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v, HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0, int v1, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, View view0) {
            melonChartHotTrackListFragment0.onItemClick(view0, v);
            if(melonChartHotTrackListFragment$HotTracksSongAdapter0.isMarked(v1)) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "선택";
                s s0 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                String s1 = null;
                g0.b = s0 == null ? null : s0.a;
                s s2 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                if(s2 != null) {
                    s1 = s2.b;
                }
                g0.c = s1;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "곡선택";
                g0.C = String.valueOf(v1 + 1);
                g0.E = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumImg;
                g0.e = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                g0.g = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songName;
                g0.h = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.getArtistNames();
                g0.a().track();
            }
        }

        private static final boolean onBindViewImpl$lambda$2(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0, int v, View view0) {
            String s = null;
            melonChartHotTrackListFragment0.showContextPopupSongOrInstantPlay(Playable.from(hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, melonChartHotTrackListFragment$HotTracksSongAdapter0.getMenuId(), null));
            d5.s s1 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "V9");
            String s2 = melonChartHotTrackListFragment0.typeCode;
            if(s2 != null) {
                s1.g = s2;
                ContsTypeCode contsTypeCode0 = ContsTypeCode.SONG;
                s1.j = "N10001";
                s1.k = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                new ClickLog(s1).a();
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "페이지이동";
                s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s3 == null ? null : s3.a;
                s s4 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                if(s4 != null) {
                    s = s4.b;
                }
                g0.c = s;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "더보기";
                g0.C = String.valueOf(v + 1);
                g0.E = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumImg;
                g0.e = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                g0.f = Y.i(contsTypeCode0, "code(...)");
                g0.g = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songName;
                g0.h = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.getArtistNames();
                g0.a().track();
                return true;
            }
            q.m("typeCode");
            throw null;
        }

        private static final void onBindViewImpl$lambda$3(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0, int v, View view0) {
            String s = null;
            melonChartHotTrackListFragment0.playSong(Playable.from(hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, melonChartHotTrackListFragment$HotTracksSongAdapter0.getMenuId(), null), true);
            d5.s s1 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "P1");
            String s2 = melonChartHotTrackListFragment0.typeCode;
            if(s2 != null) {
                s1.g = s2;
                ContsTypeCode contsTypeCode0 = ContsTypeCode.SONG;
                s1.j = "N10001";
                s1.k = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                new ClickLog(s1).a();
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "음악재생";
                s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s3 == null ? null : s3.a;
                s s4 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                if(s4 != null) {
                    s = s4.b;
                }
                g0.c = s;
                g0.d = ActionKind.PlayMusic;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "음악재생";
                g0.C = String.valueOf(v + 1);
                g0.E = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumImg;
                g0.e = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                g0.f = Y.i(contsTypeCode0, "code(...)");
                g0.g = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songName;
                g0.h = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.getArtistNames();
                g0.a().track();
                return;
            }
            q.m("typeCode");
            throw null;
        }

        private static final void onBindViewImpl$lambda$4(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0, int v, View view0) {
            String s = null;
            melonChartHotTrackListFragment0.showContextPopupSong(Playable.from(hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, melonChartHotTrackListFragment$HotTracksSongAdapter0.getMenuId(), null));
            d5.s s1 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "V9");
            String s2 = melonChartHotTrackListFragment0.typeCode;
            if(s2 != null) {
                s1.g = s2;
                ContsTypeCode contsTypeCode0 = ContsTypeCode.SONG;
                s1.j = "N10001";
                s1.k = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                new ClickLog(s1).a();
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "페이지이동";
                s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s3 == null ? null : s3.a;
                s s4 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                if(s4 != null) {
                    s = s4.b;
                }
                g0.c = s;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "더보기";
                g0.C = String.valueOf(v + 1);
                g0.E = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumImg;
                g0.e = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songId;
                g0.f = Y.i(contsTypeCode0, "code(...)");
                g0.g = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.songName;
                g0.h = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.getArtistNames();
                g0.a().track();
                return;
            }
            q.m("typeCode");
            throw null;
        }

        private static final void onBindViewImpl$lambda$5(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, CHARTLIST hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0, int v, View view0) {
            melonChartHotTrackListFragment0.showAlbumInfoPage(hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0);
            d5.s s0 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "V1");
            String s1 = melonChartHotTrackListFragment0.typeCode;
            String s2 = null;
            if(s1 != null) {
                s0.g = s1;
                ContsTypeCode contsTypeCode0 = ContsTypeCode.ALBUM;
                s0.j = "N10002";
                s0.k = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumId;
                new ClickLog(s0).a();
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "페이지이동";
                s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s3 == null ? null : s3.a;
                s s4 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                if(s4 != null) {
                    s2 = s4.b;
                }
                g0.c = s2;
                g0.d = ActionKind.ClickContent;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "앨범페이지이동";
                g0.C = String.valueOf(v + 1);
                g0.E = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumImg;
                g0.e = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumId;
                g0.f = Y.i(contsTypeCode0, "code(...)");
                g0.g = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.albumName;
                g0.h = hotTrackRes$RESPONSE$HOTTRACKS$CHARTLIST0.getArtistNames();
                g0.a().track();
                return;
            }
            q.m("typeCode");
            throw null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
            q.f(view0, "inflate(...)");
            O0 o00 = new c(view0);
            o00.updownLayout.setVisibility(8);
            return o00;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_CODE = "argFilterCode";
    @NotNull
    private static final String ARG_FILTER_INDEX = "argFilterIndex";
    @NotNull
    private static final String ARG_FILTER_NAME = "argFilterName";
    @NotNull
    private static final String ARG_TYPE_CODE = "argTypeCode";
    @NotNull
    private static final String ARG_TYPE_INDEX = "argTypeIndex";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String REASON_FILTER_CHANGE = "filterChange";
    private static final String TAG;
    private int currentFilterIndex;
    private int currentGenrePositionInSection;
    private int currentGenreSectionIndex;
    private int currentTagSortingIndex;
    private NewChartFilterLayout filterLayout;
    @Nullable
    private String genreCode;
    @NotNull
    private ArrayList genreCodeList;
    @Nullable
    private String genreName;
    @NotNull
    private ArrayList genreSortDataList;
    private View headerContainer;
    private ArrayList hotTrackCodeList;
    @NotNull
    private ArrayList hotTrackFilterDataList;
    @Nullable
    private View playAllButton;
    @Nullable
    private View playShuffleButton;
    private ScrollableAlyacFilter scAlyacFilterView;
    @NotNull
    private ArrayList tagList;
    @Nullable
    private String tagName;
    @Nullable
    private String tagSeq;
    @NotNull
    private ArrayList tagSortDataList;
    private String typeCode;

    static {
        MelonChartHotTrackListFragment.Companion = new Companion(null);
        MelonChartHotTrackListFragment.$stable = 8;
        MelonChartHotTrackListFragment.TAG = "MelonChartHotTrackListFragment$Companion";
    }

    public MelonChartHotTrackListFragment() {
        this.hotTrackFilterDataList = new ArrayList();
        this.genreCodeList = new ArrayList();
        this.genreSortDataList = new ArrayList();
        this.tagList = new ArrayList();
        this.tagSortDataList = new ArrayList();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0263, null, false);  // layout:filter_chart_age_hottrack
        q.f(view0, "inflate(...)");
        this.headerContainer = view0;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new HotTracksSongAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.s0.buildUpon().appendQueryParameter("filterIndex", String.valueOf(this.currentFilterIndex)).appendQueryParameter("genreIndex", String.valueOf(this.currentGenreSectionIndex)).appendQueryParameter("genrePositionInSection", String.valueOf(this.currentGenrePositionInSection)).appendQueryParameter("tagIndex", String.valueOf(this.currentTagSortingIndex)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String getFilterCode() [...] // 潜在的解密器

    private final int getFilterIndex(String s) {
        ArrayList arrayList0 = this.hotTrackCodeList;
        if(arrayList0 != null) {
            int v = 0;
            for(Object object0: arrayList0) {
                if(v >= 0) {
                    if(((HOTTRACKCODES)object0).hotTrackCode.equals(s)) {
                        return v;
                    }
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            return 0;
        }
        q.m("hotTrackCodeList");
        throw null;
    }

    private final String getFilterName() {
        ArrayList arrayList0 = this.hotTrackCodeList;
        if(arrayList0 != null) {
            HOTTRACKCODES hotTrackListRes$RESPONSE$HOTTRACKCODES0 = (HOTTRACKCODES)je.p.n0(this.currentFilterIndex, arrayList0);
            if(hotTrackListRes$RESPONSE$HOTTRACKCODES0 != null) {
                return hotTrackListRes$RESPONSE$HOTTRACKCODES0.hotTrackCodeName == null ? "" : hotTrackListRes$RESPONSE$HOTTRACKCODES0.hotTrackCodeName;
            }
            return "";
        }
        return "";
    }

    private final String getGenreOrTagName() {
        String s = this.typeCode;
        if(s != null) {
            if(q.b(s, "HOT_01")) {
                return this.genreName == null ? "" : this.genreName;
            }
            if(q.b(s, "HOT_05")) {
                return this.tagName == null ? "" : this.tagName;
            }
            return "";
        }
        q.m("typeCode");
        throw null;
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
            return view0.getVisibility() == 0 ? ScreenUtils.dipToPixel(this.getContext(), 168.0f) : 0;
        }
        q.m("headerContainer");
        throw null;
    }

    private final void initAlyac() {
        if(!this.hotTrackFilterDataList.isEmpty()) {
            ScrollableAlyacFilter scrollableAlyacFilter0 = this.scAlyacFilterView;
            if(scrollableAlyacFilter0 == null) {
                q.m("scAlyacFilterView");
                throw null;
            }
            scrollableAlyacFilter0.setPadding(ScreenUtils.dipToPixel(this.getContext(), 20.0f));
            ScrollableAlyacFilter scrollableAlyacFilter1 = this.scAlyacFilterView;
            if(scrollableAlyacFilter1 == null) {
                q.m("scAlyacFilterView");
                throw null;
            }
            scrollableAlyacFilter1.setSelectedIndex(this.currentFilterIndex);
            ScrollableAlyacFilter scrollableAlyacFilter2 = this.scAlyacFilterView;
            if(scrollableAlyacFilter2 == null) {
                q.m("scAlyacFilterView");
                throw null;
            }
            else if(scrollableAlyacFilter2.d(this.hotTrackFilterDataList)) {
                ScrollableAlyacFilter scrollableAlyacFilter3 = this.scAlyacFilterView;
                if(scrollableAlyacFilter3 != null) {
                    scrollableAlyacFilter3.e(new com.iloen.melon.fragments.melonchart.s(this), new E8.c());  // 初始化器: Ljava/lang/Object;-><init>()V
                    return;
                }
                q.m("scAlyacFilterView");
                throw null;
            }
        }
    }

    private static final void initAlyac$lambda$23(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v) {
        if(melonChartHotTrackListFragment0.currentFilterIndex != v) {
            melonChartHotTrackListFragment0.currentFilterIndex = v;
            melonChartHotTrackListFragment0.typeCode = "HOT_01";
            melonChartHotTrackListFragment0.startFetch("filterChange");
            d5.s s0 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "V2");
            String s1 = melonChartHotTrackListFragment0.typeCode;
            String s2 = null;
            if(s1 != null) {
                s0.g = s1;
                new ClickLog(s0).a();
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "페이지이동";
                s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s3 == null ? null : s3.a;
                if(s3 != null) {
                    s2 = s3.b;
                }
                g0.c = s2;
                g0.y = "Pagemenu";
                g0.F = melonChartHotTrackListFragment0.getFilterName();
                g0.a().track();
                return;
            }
            q.m("typeCode");
            throw null;
        }
    }

    @NotNull
    public static final MelonChartHotTrackListFragment newInstance() {
        return MelonChartHotTrackListFragment.Companion.newInstance();
    }

    @NotNull
    public static final MelonChartHotTrackListFragment newInstance(@NotNull String s, @Nullable String s1) {
        return MelonChartHotTrackListFragment.Companion.newInstance(s, s1);
    }

    @NotNull
    public static final MelonChartHotTrackListFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2) {
        return MelonChartHotTrackListFragment.Companion.newInstance(s, s1, s2);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.scAlyacFilterView;
        if(scrollableAlyacFilter0 != null) {
            scrollableAlyacFilter0.c(this.currentFilterIndex);
            this.onUpdateParallaxHeader();
            return;
        }
        q.m("scAlyacFilterView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        HotTracksSongAdapter melonChartHotTrackListFragment$HotTracksSongAdapter0 = this.mAdapter instanceof HotTracksSongAdapter ? ((HotTracksSongAdapter)this.mAdapter) : null;
        if(melonChartHotTrackListFragment$HotTracksSongAdapter0 != null) {
            melonChartHotTrackListFragment$HotTracksSongAdapter0.clear();
        }
        Params hotTrackListReq$Params0 = new Params();
        String s1 = this.typeCode;
        if(s1 != null) {
            hotTrackListReq$Params0.hotTrackCode = s1;
            if(s1.equals("HOT_01")) {
                hotTrackListReq$Params0.genreCode = this.genreCode;
            }
            else if(s1.equals("HOT_05")) {
                hotTrackListReq$Params0.tagSeq = this.tagSeq;
            }
            RequestBuilder.newInstance(new HotTrackListReq(this.getContext(), hotTrackListReq$Params0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.melonchart.p(this, i0, s, 3)).errorListener(new com.iloen.melon.fragments.melonchart.s(this)).request();
            return true;
        }
        q.m("typeCode");
        throw null;
    }

    private static final void onFetchStart$lambda$18(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, i i0, String s, HotTrackListRes hotTrackListRes0) {
        if(!melonChartHotTrackListFragment0.prepareFetchComplete(hotTrackListRes0)) {
            if(melonChartHotTrackListFragment0.isFragmentValid()) {
                melonChartHotTrackListFragment0.setAllCheckButtonVisibility(false);
                NewChartFilterLayout newChartFilterLayout0 = melonChartHotTrackListFragment0.filterLayout;
                if(newChartFilterLayout0 != null) {
                    newChartFilterLayout0.e(false);
                    return;
                }
                q.m("filterLayout");
                throw null;
            }
            return;
        }
        melonChartHotTrackListFragment0.setAllCheckButtonVisibility(hotTrackListRes0 != null && hotTrackListRes0.response.chartList.size() > 0);
        melonChartHotTrackListFragment0.updateHeaderLayout(hotTrackListRes0 != null && hotTrackListRes0.response.chartList.size() > 0);
        String s1 = hotTrackListRes0.response.hotTrackCode;
        q.f(s1, "hotTrackCode");
        melonChartHotTrackListFragment0.typeCode = s1;
        ArrayList arrayList0 = hotTrackListRes0.response.hotTrackCodes;
        q.f(arrayList0, "hotTrackCodes");
        melonChartHotTrackListFragment0.hotTrackCodeList = arrayList0;
        melonChartHotTrackListFragment0.hotTrackFilterDataList.clear();
        ArrayList arrayList1 = melonChartHotTrackListFragment0.hotTrackCodeList;
        if(arrayList1 != null) {
            Iterator iterator0 = arrayList1.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = ((HOTTRACKCODES)object0).hotTrackCodeName;
                j0.c = ((HOTTRACKCODES)object0).hotTrackCode;
                melonChartHotTrackListFragment0.hotTrackFilterDataList.add(j0);
            }
            if(!"filterChange".equals(s)) {
                String s2 = hotTrackListRes0.response.hotTrackCode;
                q.f(s2, "hotTrackCode");
                melonChartHotTrackListFragment0.currentFilterIndex = melonChartHotTrackListFragment0.getFilterIndex(s2);
                melonChartHotTrackListFragment0.initAlyac();
            }
            String s3 = "";
            String s4 = melonChartHotTrackListFragment0.typeCode;
            if(s4 != null) {
                if(s4.equals("HOT_01")) {
                    NewChartFilterLayout newChartFilterLayout1 = melonChartHotTrackListFragment0.filterLayout;
                    if(newChartFilterLayout1 != null) {
                        newChartFilterLayout1.e(true);
                        ArrayList arrayList2 = hotTrackListRes0.response.genreCodeList;
                        if(arrayList2 == null) {
                            melonChartHotTrackListFragment0.mMelonTiaraProperty = new s(hotTrackListRes0.response.section, hotTrackListRes0.response.page, hotTrackListRes0.getMenuId(), null);
                            melonChartHotTrackListFragment0.performFetchComplete(i0, hotTrackListRes0);
                            return;
                        }
                        if(!melonChartHotTrackListFragment0.genreSortDataList.isEmpty()) {
                            melonChartHotTrackListFragment0.genreSortDataList.clear();
                        }
                        melonChartHotTrackListFragment0.genreCodeList = arrayList2;
                        int v = 0;
                        for(Object object1: arrayList2) {
                            if(v >= 0) {
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = ((GENRECODELIST)object1).gnrList;
                                if(arrayList4 != null) {
                                    int v1 = 0;
                                    for(Object object2: arrayList4) {
                                        if(v1 >= 0) {
                                            v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            j1.b = ((GNRLIST)object2).gnrName;
                                            j1.c = ((GNRLIST)object2).gnrCode;
                                            arrayList3.add(j1);
                                            if(melonChartHotTrackListFragment0.genreCode != null && melonChartHotTrackListFragment0.genreCode.length() != 0 && Tf.v.j0(melonChartHotTrackListFragment0.genreCode, ((GNRLIST)object2).gnrCode, false)) {
                                                melonChartHotTrackListFragment0.currentGenreSectionIndex = v;
                                                melonChartHotTrackListFragment0.currentGenrePositionInSection = v1;
                                            }
                                            ++v1;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                }
                                melonChartHotTrackListFragment0.genreSortDataList.add(new SectionedFilter(((GENRECODELIST)object1).menuName, arrayList3));
                                ++v;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                        SectionedFilter singleFilterListPopup$SectionedFilter0 = (SectionedFilter)je.p.n0(melonChartHotTrackListFragment0.currentGenreSectionIndex, melonChartHotTrackListFragment0.genreSortDataList);
                        if(singleFilterListPopup$SectionedFilter0 != null) {
                            ArrayList arrayList5 = singleFilterListPopup$SectionedFilter0.sectionContents;
                            if(arrayList5 != null) {
                                v9.j j2 = (v9.j)je.p.n0(melonChartHotTrackListFragment0.currentGenrePositionInSection, arrayList5);
                                if(j2 != null) {
                                    melonChartHotTrackListFragment0.genreCode = j2.c;
                                    melonChartHotTrackListFragment0.genreName = j2.b;
                                }
                            }
                        }
                        NewChartFilterLayout newChartFilterLayout2 = melonChartHotTrackListFragment0.filterLayout;
                        if(newChartFilterLayout2 != null) {
                            String s5 = melonChartHotTrackListFragment0.genreName;
                            if(s5 != null) {
                                s3 = s5;
                            }
                            newChartFilterLayout2.setDropDownText(s3);
                            melonChartHotTrackListFragment0.mMelonTiaraProperty = new s(hotTrackListRes0.response.section, hotTrackListRes0.response.page, hotTrackListRes0.getMenuId(), null);
                            melonChartHotTrackListFragment0.performFetchComplete(i0, hotTrackListRes0);
                            return;
                        }
                        q.m("filterLayout");
                        throw null;
                    }
                    q.m("filterLayout");
                    throw null;
                }
                if(s4.equals("HOT_05")) {
                    NewChartFilterLayout newChartFilterLayout3 = melonChartHotTrackListFragment0.filterLayout;
                    if(newChartFilterLayout3 != null) {
                        newChartFilterLayout3.e(true);
                        ArrayList arrayList6 = hotTrackListRes0.response.tagInfo;
                        if(arrayList6 != null) {
                            TAGINFO hotTrackListRes$RESPONSE$TAGINFO0 = (TAGINFO)je.p.n0(0, arrayList6);
                            if(hotTrackListRes$RESPONSE$TAGINFO0 != null) {
                                ArrayList arrayList7 = hotTrackListRes$RESPONSE$TAGINFO0.tagList;
                                if(arrayList7 != null) {
                                    if(!melonChartHotTrackListFragment0.tagSortDataList.isEmpty()) {
                                        melonChartHotTrackListFragment0.tagSortDataList.clear();
                                    }
                                    melonChartHotTrackListFragment0.tagList = arrayList7;
                                    for(Object object3: arrayList7) {
                                        v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        j3.b = ((TAGLIST)object3).tagName;
                                        j3.c = ((TAGLIST)object3).tagSeq;
                                        melonChartHotTrackListFragment0.tagSortDataList.add(j3);
                                    }
                                    int v2 = 0;
                                    for(Object object4: melonChartHotTrackListFragment0.tagList) {
                                        if(v2 >= 0) {
                                            if(Tf.v.j0(((TAGLIST)object4).tagSeq, melonChartHotTrackListFragment0.tagSeq, false)) {
                                                melonChartHotTrackListFragment0.currentTagSortingIndex = v2;
                                            }
                                            ++v2;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                    NewChartFilterLayout newChartFilterLayout4 = melonChartHotTrackListFragment0.filterLayout;
                                    if(newChartFilterLayout4 != null) {
                                        v9.j j4 = (v9.j)je.p.n0(melonChartHotTrackListFragment0.currentTagSortingIndex, melonChartHotTrackListFragment0.tagSortDataList);
                                        if(j4 != null) {
                                            String s6 = j4.b;
                                            if(s6 != null) {
                                                s3 = s6;
                                            }
                                        }
                                        newChartFilterLayout4.setDropDownText(s3);
                                        goto label_139;
                                    }
                                    q.m("filterLayout");
                                    throw null;
                                }
                            }
                        }
                    label_139:
                        melonChartHotTrackListFragment0.tagName = hotTrackListRes0.response.tagName;
                        melonChartHotTrackListFragment0.tagSeq = hotTrackListRes0.response.tagSeq;
                        melonChartHotTrackListFragment0.mMelonTiaraProperty = new s(hotTrackListRes0.response.section, hotTrackListRes0.response.page, hotTrackListRes0.getMenuId(), null);
                        melonChartHotTrackListFragment0.performFetchComplete(i0, hotTrackListRes0);
                        return;
                    }
                    q.m("filterLayout");
                    throw null;
                }
                NewChartFilterLayout newChartFilterLayout5 = melonChartHotTrackListFragment0.filterLayout;
                if(newChartFilterLayout5 != null) {
                    newChartFilterLayout5.e(false);
                    melonChartHotTrackListFragment0.genreSortDataList.clear();
                    melonChartHotTrackListFragment0.tagSortDataList.clear();
                    melonChartHotTrackListFragment0.mMelonTiaraProperty = new s(hotTrackListRes0.response.section, hotTrackListRes0.response.page, hotTrackListRes0.getMenuId(), null);
                    melonChartHotTrackListFragment0.performFetchComplete(i0, hotTrackListRes0);
                    return;
                }
                q.m("filterLayout");
                throw null;
            }
            q.m("typeCode");
            throw null;
        }
        q.m("hotTrackCodeList");
        throw null;
    }

    private static final void onFetchStart$lambda$19(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, VolleyError volleyError0) {
        melonChartHotTrackListFragment0.performFetchError(volleyError0);
        NewChartFilterLayout newChartFilterLayout0 = melonChartHotTrackListFragment0.filterLayout;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.e(false);
            melonChartHotTrackListFragment0.updateHeaderLayout(false);
            melonChartHotTrackListFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        q.m("filterLayout");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argTypeCode");
        if(s == null) {
            s = "";
        }
        this.typeCode = s;
        this.currentFilterIndex = bundle0.getInt("argTypeIndex");
        String s1 = this.typeCode;
        if(s1 != null) {
            if(q.b(s1, "HOT_01")) {
                this.genreCode = bundle0.getString("argFilterCode");
                this.genreName = bundle0.getString("argFilterName");
                this.currentGenreSectionIndex = bundle0.getInt("argFilterIndex");
                return;
            }
            if(q.b(s1, "HOT_05")) {
                this.tagSeq = bundle0.getString("argFilterCode");
                this.tagName = bundle0.getString("argFilterName");
                this.currentTagSortingIndex = bundle0.getInt("argFilterIndex");
            }
            return;
        }
        q.m("typeCode");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        String s = this.typeCode;
        if(s != null) {
            bundle0.putString("argTypeCode", s);
            bundle0.putInt("argTypeIndex", this.currentFilterIndex);
            String s1 = this.typeCode;
            if(s1 != null) {
                if(q.b(s1, "HOT_01")) {
                    bundle0.putString("argFilterCode", this.genreCode);
                    bundle0.putString("argFilterName", this.genreName);
                    bundle0.putInt("argFilterIndex", this.currentGenreSectionIndex);
                }
                else if(q.b(s1, "HOT_05")) {
                    bundle0.putString("argFilterCode", this.tagSeq);
                    bundle0.putString("argFilterName", this.tagName);
                    bundle0.putInt("argFilterIndex", this.currentTagSortingIndex);
                }
                super.onSaveInstanceState(bundle0);
                return;
            }
            q.m("typeCode");
            throw null;
        }
        q.m("typeCode");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        View view1 = view0.findViewById(0x7F0A01BB);  // id:btn_shuffle
        this.playShuffleButton = view1;
        if(view1 != null) {
            view1.setOnClickListener(new u(this, 0));
        }
        View view2 = view0.findViewById(0x7F0A0183);  // id:btn_play_all
        this.playAllButton = view2;
        if(view2 != null) {
            view2.setOnClickListener(new u(this, 1));
        }
        View view3 = view0.findViewById(0x7F0A0248);  // id:chart_filter_layout
        q.f(view3, "findViewById(...)");
        this.filterLayout = (NewChartFilterLayout)view3;
        boolean z = false;
        ((NewChartFilterLayout)view3).e(false);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
        View view4 = view0.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.f(view4, "findViewById(...)");
        this.scAlyacFilterView = (ScrollableAlyacFilter)view4;
        this.initAlyac();
        NewChartFilterLayout newChartFilterLayout0 = this.filterLayout;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.setOnDropDownListener(new e(this, 1));
            if(!this.genreSortDataList.isEmpty() || !this.tagSortDataList.isEmpty()) {
                NewChartFilterLayout newChartFilterLayout1 = this.filterLayout;
                if(newChartFilterLayout1 == null) {
                    q.m("filterLayout");
                    throw null;
                }
                newChartFilterLayout1.e(true);
                String s = this.typeCode;
                if(s == null) {
                    q.m("typeCode");
                    throw null;
                }
                if(s.equals("HOT_01")) {
                    NewChartFilterLayout newChartFilterLayout2 = this.filterLayout;
                    if(newChartFilterLayout2 != null) {
                        newChartFilterLayout2.setDropDownText(this.genreName);
                        return;
                    }
                    q.m("filterLayout");
                    throw null;
                }
                if(s.equals("HOT_05")) {
                    NewChartFilterLayout newChartFilterLayout3 = this.filterLayout;
                    if(newChartFilterLayout3 != null) {
                        newChartFilterLayout3.setDropDownText(this.tagName);
                        return;
                    }
                    q.m("filterLayout");
                    throw null;
                }
            }
            return;
        }
        q.m("filterLayout");
        throw null;
    }

    private static final void onViewCreated$lambda$0(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, View view0) {
        melonChartHotTrackListFragment0.playShuffleAll();
        String s = melonChartHotTrackListFragment0.getString(0x7F130E33);  // string:tiara_common_layer2_play_shuffle "셔플재생"
        q.f(s, "getString(...)");
        melonChartHotTrackListFragment0.playLog("P13", s);
    }

    private static final void onViewCreated$lambda$1(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, View view0) {
        melonChartHotTrackListFragment0.playAll();
        String s = melonChartHotTrackListFragment0.getString(0x7F130E31);  // string:tiara_common_layer2_play_all "전체재생"
        q.f(s, "getString(...)");
        melonChartHotTrackListFragment0.playLog("P2", s);
    }

    private static final H onViewCreated$lambda$8(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, View view0) {
        q.g(view0, "it");
        if(!melonChartHotTrackListFragment0.isRetainedPopupShowing()) {
            String s = melonChartHotTrackListFragment0.typeCode;
            if(s == null) {
                q.m("typeCode");
                throw null;
            }
            if(s.equals("HOT_01")) {
                com.iloen.melon.popup.CommonFilterPopup.Companion commonFilterPopup$Companion0 = CommonFilterPopup.Companion;
                ArrayList arrayList0 = melonChartHotTrackListFragment0.genreSortDataList;
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j0.b = ((SectionedFilter)object0).sectionName;
                    j0.e = ((SectionedFilter)object0).sectionContents;
                    arrayList1.add(j0);
                }
                CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(commonFilterPopup$Companion0, 0x7F1307D1, "LIST_TYPE_DEPTH_TWO_ALYAC", je.p.P0(arrayList1), melonChartHotTrackListFragment0.currentGenreSectionIndex, melonChartHotTrackListFragment0.currentGenrePositionInSection, 0, new t(melonChartHotTrackListFragment0, 0), 0x20, null);  // string:order_by "정렬"
                FragmentActivity fragmentActivity0 = melonChartHotTrackListFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    l0 l00 = fragmentActivity0.getSupportFragmentManager();
                    if(l00 != null) {
                        commonFilterPopup0.setDismissFragment(melonChartHotTrackListFragment0);
                        commonFilterPopup0.show(l00, "ComposeBottomSheet");
                    }
                }
            }
            else if(s.equals("HOT_05")) {
                ArrayList arrayList2 = melonChartHotTrackListFragment0.tagSortDataList;
                int v = melonChartHotTrackListFragment0.currentTagSortingIndex;
                t t0 = new t(melonChartHotTrackListFragment0, 1);
                CommonFilterPopup commonFilterPopup1 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(CommonFilterPopup.Companion, 0x7F1307D1, "LIST_TYPE_DEPTH_ONE_BASIC", arrayList2, v, 0, 0, t0, 0x30, null);  // string:order_by "정렬"
                FragmentActivity fragmentActivity1 = melonChartHotTrackListFragment0.getActivity();
                if(fragmentActivity1 != null) {
                    l0 l01 = fragmentActivity1.getSupportFragmentManager();
                    if(l01 != null) {
                        commonFilterPopup1.setDismissFragment(melonChartHotTrackListFragment0);
                        commonFilterPopup1.show(l01, "ComposeBottomSheet");
                    }
                }
            }
        }
        d5.s s1 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", "V23");
        String s2 = melonChartHotTrackListFragment0.typeCode;
        if(s2 != null) {
            s1.g = s2;
            new ClickLog(s1).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartHotTrackListFragment0.mMenuId;
            g0.a = "페이지이동";
            g0.b = melonChartHotTrackListFragment0.mMelonTiaraProperty == null ? null : melonChartHotTrackListFragment0.mMelonTiaraProperty.a;
            g0.c = melonChartHotTrackListFragment0.mMelonTiaraProperty == null ? null : melonChartHotTrackListFragment0.mMelonTiaraProperty.b;
            g0.y = "곡리스트";
            g0.z = melonChartHotTrackListFragment0.getFilterName();
            g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
            Resources resources0 = melonChartHotTrackListFragment0.getResources();
            String s3 = melonChartHotTrackListFragment0.typeCode;
            if(s3 != null) {
                g0.F = resources0.getString((s3.equals("HOT_01") ? 0x7F130E37 : 0x7F130E39));  // string:tiara_common_layer2_select_genre "장르선택"
                g0.a().track();
                return H.a;
            }
            q.m("typeCode");
            throw null;
        }
        q.m("typeCode");
        throw null;
    }

    private static final H onViewCreated$lambda$8$lambda$4(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v, int v1, int v2) {
        String s3;
        GNRLIST hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1;
        String s2;
        GNRLIST hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST0;
        q.f("MelonChartHotTrackListFragment$Companion", "TAG");
        LogU.Companion.d("MelonChartHotTrackListFragment$Companion", "onFilterSelectionListener oneDepthIndex:" + v + ", twoDepthIndex:" + v1);
        int v3 = melonChartHotTrackListFragment0.currentGenreSectionIndex;
        H h0 = H.a;
        if(v3 == v && melonChartHotTrackListFragment0.currentGenrePositionInSection == v1) {
            return h0;
        }
        GENRECODELIST hotTrackListRes$RESPONSE$GENRECODELIST0 = (GENRECODELIST)je.p.n0(v3, melonChartHotTrackListFragment0.genreCodeList);
        String s = null;
        if(hotTrackListRes$RESPONSE$GENRECODELIST0 == null) {
            hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST0 = null;
        }
        else {
            ArrayList arrayList0 = hotTrackListRes$RESPONSE$GENRECODELIST0.gnrList;
            hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST0 = arrayList0 == null ? null : ((GNRLIST)je.p.n0(melonChartHotTrackListFragment0.currentGenrePositionInSection, arrayList0));
        }
        String s1 = "";
        if(hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST0 == null) {
            s2 = "";
        }
        else {
            s2 = hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST0.gnrName;
            if(s2 == null) {
                s2 = "";
            }
        }
        melonChartHotTrackListFragment0.currentGenreSectionIndex = v;
        melonChartHotTrackListFragment0.currentGenrePositionInSection = v1;
        GENRECODELIST hotTrackListRes$RESPONSE$GENRECODELIST1 = (GENRECODELIST)je.p.n0(v, melonChartHotTrackListFragment0.genreCodeList);
        if(hotTrackListRes$RESPONSE$GENRECODELIST1 == null) {
            hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1 = null;
        }
        else {
            ArrayList arrayList1 = hotTrackListRes$RESPONSE$GENRECODELIST1.gnrList;
            hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1 = arrayList1 == null ? null : ((GNRLIST)je.p.n0(melonChartHotTrackListFragment0.currentGenrePositionInSection, arrayList1));
        }
        if(hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1 == null) {
            s3 = "";
        }
        else {
            s3 = hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1.gnrCode;
            if(s3 == null) {
                s3 = "";
            }
        }
        melonChartHotTrackListFragment0.genreCode = s3;
        if(hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1 != null) {
            String s4 = hotTrackListRes$RESPONSE$GENRECODELIST$GNRLIST1.gnrName;
            if(s4 != null) {
                s1 = s4;
            }
        }
        melonChartHotTrackListFragment0.genreName = s1;
        NewChartFilterLayout newChartFilterLayout0 = melonChartHotTrackListFragment0.filterLayout;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.setDropDownText(s1);
            if(!TextUtils.isEmpty(melonChartHotTrackListFragment0.genreCode)) {
                melonChartHotTrackListFragment0.startFetch("filterChange");
            }
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartHotTrackListFragment0.mMenuId;
            g0.a = "페이지이동";
            s s5 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
            g0.b = s5 == null ? null : s5.a;
            if(s5 != null) {
                s = s5.b;
            }
            g0.c = s;
            g0.y = "곡리스트";
            g0.z = melonChartHotTrackListFragment0.getFilterName();
            g0.A = s2;
            g0.F = melonChartHotTrackListFragment0.genreName;
            g0.a().track();
            return h0;
        }
        q.m("filterLayout");
        throw null;
    }

    private static final H onViewCreated$lambda$8$lambda$6(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, int v, int v1, int v2) {
        String s;
        q.f("MelonChartHotTrackListFragment$Companion", "TAG");
        LogU.Companion.d("MelonChartHotTrackListFragment$Companion", "onFilterSelectionListener oneDepthIndex:" + v);
        int v3 = melonChartHotTrackListFragment0.currentTagSortingIndex;
        H h0 = H.a;
        if(v3 == v) {
            return h0;
        }
        TAGLIST hotTrackListRes$RESPONSE$TAGINFO$TAGLIST0 = (TAGLIST)je.p.n0(v3, melonChartHotTrackListFragment0.tagList);
        if(hotTrackListRes$RESPONSE$TAGINFO$TAGLIST0 == null) {
            s = "";
        }
        else {
            s = hotTrackListRes$RESPONSE$TAGINFO$TAGLIST0.tagName;
            if(s == null) {
                s = "";
            }
        }
        melonChartHotTrackListFragment0.currentTagSortingIndex = v;
        melonChartHotTrackListFragment0.tagSeq = ((TAGLIST)melonChartHotTrackListFragment0.tagList.get(v)).tagSeq;
        String s1 = ((TAGLIST)melonChartHotTrackListFragment0.tagList.get(v)).tagName;
        melonChartHotTrackListFragment0.tagName = s1;
        NewChartFilterLayout newChartFilterLayout0 = melonChartHotTrackListFragment0.filterLayout;
        String s2 = null;
        if(newChartFilterLayout0 != null) {
            newChartFilterLayout0.setDropDownText(s1);
            melonChartHotTrackListFragment0.startFetch("filterChange");
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = melonChartHotTrackListFragment0.mMenuId;
            g0.a = "페이지이동";
            s s3 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
            g0.b = s3 == null ? null : s3.a;
            if(s3 != null) {
                s2 = s3.b;
            }
            g0.c = s2;
            g0.y = "곡리스트";
            g0.z = melonChartHotTrackListFragment0.getFilterName();
            g0.A = s;
            g0.F = melonChartHotTrackListFragment0.tagName;
            g0.a().track();
            return h0;
        }
        q.m("filterLayout");
        throw null;
    }

    private final void playLog(String s, String s1) {
        d5.s s2 = d3.g.K(this.mMenuId, "R20", s);
        String s3 = this.typeCode;
        String s4 = null;
        if(s3 != null) {
            s2.g = s3;
            new ClickLog(s2).a();
            p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = this.mMenuId;
            g0.a = "음악재생";
            s s5 = this.mMelonTiaraProperty;
            g0.b = s5 == null ? null : s5.a;
            if(s5 != null) {
                s4 = s5.b;
            }
            g0.c = s4;
            g0.y = "곡리스트";
            g0.z = this.getFilterName();
            g0.A = this.getGenreOrTagName();
            g0.F = s1;
            g0.a().track();
            return;
        }
        q.m("typeCode");
        throw null;
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            View view0 = this.playShuffleButton;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            View view1 = this.playAllButton;
            if(view1 != null) {
                view1.setVisibility(0);
            }
            NewChartFilterLayout newChartFilterLayout0 = this.filterLayout;
            if(newChartFilterLayout0 != null) {
                newChartFilterLayout0.setOnCheckedListener(new com.iloen.melon.fragments.melonchart.s(this));
                return;
            }
            q.m("filterLayout");
            throw null;
        }
        View view2 = this.playShuffleButton;
        if(view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.playAllButton;
        if(view3 != null) {
            view3.setVisibility(4);
        }
        NewChartFilterLayout newChartFilterLayout1 = this.filterLayout;
        if(newChartFilterLayout1 != null) {
            newChartFilterLayout1.setOnCheckedListener(null);
            NewChartFilterLayout newChartFilterLayout2 = this.filterLayout;
            if(newChartFilterLayout2 != null) {
                newChartFilterLayout2.setLeftButton(null);
                return;
            }
            q.m("filterLayout");
            throw null;
        }
        q.m("filterLayout");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$20(MelonChartHotTrackListFragment melonChartHotTrackListFragment0, S s0, boolean z) {
        melonChartHotTrackListFragment0.toggleSelectAll();
        d5.s s1 = d3.g.K(melonChartHotTrackListFragment0.mMenuId, "R20", (melonChartHotTrackListFragment0.mMarkedAll ? "C1" : "C2"));
        String s2 = melonChartHotTrackListFragment0.typeCode;
        String s3 = null;
        if(s2 != null) {
            s1.g = s2;
            a.t(s1);
            if(melonChartHotTrackListFragment0.mMarkedAll) {
                p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = melonChartHotTrackListFragment0.mMenuId;
                g0.a = "선택";
                s s4 = melonChartHotTrackListFragment0.mMelonTiaraProperty;
                g0.b = s4 == null ? null : s4.a;
                if(s4 != null) {
                    s3 = s4.b;
                }
                g0.c = s3;
                g0.y = "곡리스트";
                g0.z = melonChartHotTrackListFragment0.getFilterName();
                g0.A = melonChartHotTrackListFragment0.getGenreOrTagName();
                g0.F = "전체선택";
                g0.a().track();
            }
            return;
        }
        q.m("typeCode");
        throw null;
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

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateToolBar(boolean z) {
        super.updateToolBar(z);
        if(z && !this.isToolBarShowing() && this.getMarkedItemCount() == 1) {
            d5.s s0 = d3.g.K(this.mMenuId, "R20", "V20");
            String s1 = this.typeCode;
            if(s1 != null) {
                s0.g = s1;
                a.t(s0);
                return;
            }
            q.m("typeCode");
            throw null;
        }
    }
}

