package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes.RESPONSE.YEARLIST.MONTHLIST;
import com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes.RESPONSE.YEARLIST;
import com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes;
import com.iloen.melon.net.v5x.request.MyMusicTopListYearMonthReq;
import com.iloen.melon.net.v6x.request.MyMusicTopListSongManyReq.Params;
import com.iloen.melon.net.v6x.request.MyMusicTopListSongManyReq;
import com.iloen.melon.net.v6x.response.MyMusicTopListSongManyRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v6x.response.MyMusicTopListSongManyRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MyMusicTopListSongManyRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 [2\u00020\u0001:\u0002[\\B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0003J\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0011J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u000F\u0010\u001D\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020 H\u0014\u00A2\u0006\u0004\b#\u0010\"J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0011\u0010-\u001A\u0004\u0018\u00010,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b/\u00100J\u0017\u00102\u001A\u00020\u000B2\u0006\u00101\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b2\u00103J\u0019\u00104\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b4\u00105J\u0019\u00106\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b6\u00105J\u000F\u00107\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b7\u0010\u0006J\u0017\u0010:\u001A\u00020\u000B2\u0006\u00109\u001A\u000208H\u0002\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b<\u0010\u0006J\u000F\u0010=\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b=\u0010\u0006J\u000F\u0010>\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b>\u0010\u0003J\u0017\u0010@\u001A\u00020\u000B2\u0006\u0010?\u001A\u00020\u0019H\u0002\u00A2\u0006\u0004\b@\u0010AR\u0016\u0010C\u001A\u00020B8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001A\u00020E8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bF\u0010GRR\u0010M\u001A>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`K0Hj\u001E\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`K`L8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bM\u0010NR&\u0010O\u001A\u0012\u0012\u0004\u0012\u00020\u00040Ij\b\u0012\u0004\u0012\u00020\u0004`K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR&\u0010Q\u001A\u0012\u0012\u0004\u0012\u00020\u00040Ij\b\u0012\u0004\u0012\u00020\u0004`K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010R\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001A\u00020 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010SR\u0016\u0010U\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010X\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010V\u00A8\u0006]"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onResume", "onPause", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "initHeaderView", "(Landroid/view/View;)V", "filterText", "setFilterTextView", "(Ljava/lang/String;)V", "requestYearList", "(Lv9/i;)V", "requestMyChart", "getTermYear", "Lcom/iloen/melon/net/v4x/response/MyMusicTopListYearMonthRes$RESPONSE;", "res", "setYearList", "(Lcom/iloen/melon/net/v4x/response/MyMusicTopListYearMonthRes$RESPONSE;)V", "getFilterText", "getFilterTextFromTermYear", "setRmLandingFilterPosition", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "Lcom/iloen/melon/custom/FilterDropDownView;", "filterView", "Lcom/iloen/melon/custom/FilterDropDownView;", "Landroid/widget/TextView;", "tvPeriod", "Landroid/widget/TextView;", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "filterMap", "Ljava/util/LinkedHashMap;", "yearList", "Ljava/util/ArrayList;", "yearCodeList", "currentYearFilterIndex", "I", "currentMonthFilterIndex", "period", "Ljava/lang/String;", "termYear", "isNeedsFilterLayout", "Z", "memberKey", "Companion", "MyChartAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicMyChartMonthFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0007J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PERIOD", "ARG_TERM_YEAR", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment;", "period", "targetMemberKey", "termYear", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicMyChartMonthFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "period");
            q.g(s1, "targetMemberKey");
            return this.newInstance(s, "", s1);
        }

        @NotNull
        public final MyMusicMyChartMonthFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "period");
            q.g(s1, "termYear");
            q.g(s2, "targetMemberKey");
            MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0 = new MyMusicMyChartMonthFragment();
            Bundle bundle0 = Y.c("argPeriod", s, "argTermYear", s1);
            bundle0.putString("argMemberKey", s2);
            bundle0.putBoolean("argIsLoginRequired", true);
            myMusicMyChartMonthFragment0.setArguments(bundle0);
            return myMusicMyChartMonthFragment0;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001A\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001D\u001A\u00020\r2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment$MyChartAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "guide", "Lie/H;", "setGuideText", "(Ljava/lang/String;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getFooterViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "VIEW_TYPE_FOOTER", "tvGuide", "Ljava/lang/String;", "FooterViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MyChartAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment$MyChartAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicMyChartMonthFragment$MyChartAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class FooterViewHolder extends O0 {
            @NotNull
            private final MelonTextView tvTitle;

            public FooterViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                MyChartAdapter.this = myMusicMyChartMonthFragment$MyChartAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.tvTitle = (MelonTextView)view1;
            }

            @NotNull
            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        private final int VIEW_TYPE_FOOTER;
        private final int VIEW_TYPE_SONG;
        @NotNull
        private String tvGuide;

        public MyChartAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicMyChartMonthFragment.this = myMusicMyChartMonthFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_SONG = 1;
            this.VIEW_TYPE_FOOTER = 2;
            this.tvGuide = "";
        }

        public static boolean d(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, View view0) {
            return MyChartAdapter.onBindViewImpl$lambda$1(myMusicMyChartMonthFragment0, myMusicTopListSongManyRes$RESPONSE$SONGLIST0, myMusicMyChartMonthFragment$MyChartAdapter0, view0);
        }

        public static void e(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, int v, View view0) {
            MyChartAdapter.onBindViewImpl$lambda$0(myMusicMyChartMonthFragment0, v, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getFooterCount() <= 0 || v != this.getAvailableFooterPosition() ? this.VIEW_TYPE_SONG : this.VIEW_TYPE_FOOTER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof SongHolder) {
                Object object0 = this.getItem(v1);
                SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0 = object0 instanceof SONGLIST ? ((SONGLIST)object0) : null;
                if(myMusicTopListSongManyRes$RESPONSE$SONGLIST0 != null) {
                    SongHolder songHolder0 = (SongHolder)o00;
                    ViewUtils.setEnable(songHolder0.wrapperLayout, myMusicTopListSongManyRes$RESPONSE$SONGLIST0.canService);
                    if(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.canService) {
                        ViewUtils.setOnClickListener(songHolder0.rootView, new J(MyMusicMyChartMonthFragment.this, v, 2));
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
                    ViewUtils.setOnLongClickListener(songHolder0.rootView, new A(MyMusicMyChartMonthFragment.this, myMusicTopListSongManyRes$RESPONSE$SONGLIST0, this, 5));
                    ImageView imageView0 = songHolder0.thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.albumImg).into(songHolder0.thumbnailIv);
                    }
                    ViewUtils.showWhen(songHolder0.btnPlay, myMusicTopListSongManyRes$RESPONSE$SONGLIST0.canService);
                    ViewUtils.setOnClickListener(songHolder0.btnPlay, new V(MyMusicMyChartMonthFragment.this, myMusicTopListSongManyRes$RESPONSE$SONGLIST0, this, 0));
                    ViewUtils.showWhen(songHolder0.btnInfo, true);
                    ViewUtils.setOnClickListener(songHolder0.btnInfo, new V(MyMusicMyChartMonthFragment.this, myMusicTopListSongManyRes$RESPONSE$SONGLIST0, this, 1));
                    ViewUtils.setOnClickListener(songHolder0.thumbContainer, new e(5, myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyMusicMyChartMonthFragment.this));
                    ViewUtils.setTextViewMarquee(songHolder0.titleTv, this.isMarqueeNeeded(v1));
                    songHolder0.titleTv.setText(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.songName);
                    songHolder0.artistTv.setText(ProtocolUtils.getArtistNames(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.artistList));
                    songHolder0.rankTv.setText(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.rank);
                    songHolder0.updownLayout.setVisibility(0);
                    songHolder0.rankGapTv.setVisibility(4);
                    ViewUtils.showWhen(songHolder0.list19Iv, myMusicTopListSongManyRes$RESPONSE$SONGLIST0.isAdult);
                    ViewUtils.showWhen(songHolder0.listFreeIv, myMusicTopListSongManyRes$RESPONSE$SONGLIST0.isFree);
                    ViewUtils.showWhen(songHolder0.listHoldbackIv, myMusicTopListSongManyRes$RESPONSE$SONGLIST0.isHoldback);
                }
            }
            else if(o00 instanceof FooterViewHolder) {
                if(!TextUtils.isEmpty(this.tvGuide)) {
                    ViewUtils.showWhen(((FooterViewHolder)o00).getTvTitle(), true);
                    ViewUtils.setText(((FooterViewHolder)o00).getTvTitle(), this.tvGuide);
                    return;
                }
                ViewUtils.hideWhen(((FooterViewHolder)o00).getTvTitle(), true);
            }
        }

        private static final void onBindViewImpl$lambda$0(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, int v, View view0) {
            myMusicMyChartMonthFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$1(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, View view0) {
            myMusicMyChartMonthFragment0.showContextPopupSongOrInstantPlay(Playable.from(myMusicTopListSongManyRes$RESPONSE$SONGLIST0, myMusicMyChartMonthFragment$MyChartAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$2(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, View view0) {
            myMusicMyChartMonthFragment0.playSong(Playable.from(myMusicTopListSongManyRes$RESPONSE$SONGLIST0, myMusicMyChartMonthFragment$MyChartAdapter0.getMenuId(), null), true);
        }

        private static final void onBindViewImpl$lambda$3(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, View view0) {
            myMusicMyChartMonthFragment0.showContextPopupSong(Playable.from(myMusicTopListSongManyRes$RESPONSE$SONGLIST0, myMusicMyChartMonthFragment$MyChartAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$4(SONGLIST myMusicTopListSongManyRes$RESPONSE$SONGLIST0, MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, View view0) {
            if(!TextUtils.isEmpty(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.albumId)) {
                myMusicMyChartMonthFragment0.showAlbumInfoPage(myMusicTopListSongManyRes$RESPONSE$SONGLIST0.albumId);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_FOOTER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056F, viewGroup0, false);  // layout:mymusic_recent_last
                q.f(view0, "inflate(...)");
                return new FooterViewHolder(this, view0);
            }
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
        }

        public final void setGuideText(@NotNull String s) {
            q.g(s, "guide");
            this.tvGuide = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_PERIOD = "argPeriod";
    @NotNull
    private static final String ARG_TERM_YEAR = "argTermYear";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicMyChartMonthFragment";
    private int currentMonthFilterIndex;
    private int currentYearFilterIndex;
    @NotNull
    private LinkedHashMap filterMap;
    private FilterDropDownView filterView;
    private boolean isNeedsFilterLayout;
    @NotNull
    private String memberKey;
    @NotNull
    private String period;
    @NotNull
    private String termYear;
    private TextView tvPeriod;
    @NotNull
    private ArrayList yearCodeList;
    @NotNull
    private ArrayList yearList;

    static {
        MyMusicMyChartMonthFragment.Companion = new Companion(null);
        MyMusicMyChartMonthFragment.$stable = 8;
    }

    public MyMusicMyChartMonthFragment() {
        this.filterMap = new LinkedHashMap();
        this.yearList = new ArrayList();
        this.yearCodeList = new ArrayList();
        this.period = "";
        this.termYear = "";
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D085A, null, false);  // layout:sortbar_period_layout
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 1000);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new MyChartAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.W.buildUpon().appendQueryParameter("period", this.period).appendQueryParameter("filterIndex1", String.valueOf(this.currentYearFilterIndex)).appendQueryParameter("filterIndex2", String.valueOf(this.currentMonthFilterIndex)), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterText() {
        String s = "";
        if(this.yearList.isEmpty()) {
            return "";
        }
        Object object0 = this.yearList.get(this.currentYearFilterIndex);
        q.f(object0, "get(...)");
        ArrayList arrayList0 = (ArrayList)this.filterMap.get(this.yearList.get(this.currentYearFilterIndex));
        if(arrayList0 != null) {
            v9.j j0 = (v9.j)arrayList0.get(this.currentMonthFilterIndex);
            if(j0 != null) {
                String s1 = j0.b;
                if(s1 != null) {
                    s = s1;
                }
            }
        }
        return va.e.c(((String)object0), " ", s);
    }

    private final String getFilterTextFromTermYear() {
        String s = "";
        if(TextUtils.isEmpty(this.termYear) && this.termYear.length() < 5) {
            return "";
        }
        String s1 = this.termYear.substring(0, 4);
        q.f(s1, "substring(...)");
        String s2 = this.termYear.length() == 5 ? this.termYear.substring(4, 5) : this.termYear.substring(4, 6);
        q.f(s2, "substring(...)");
        String s3 = this.getContext() == null ? "" : "년";
        if(this.getContext() != null) {
            s = "월";
        }
        return s1 + s3 + " " + s2 + s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    private final String getTermYear() {
        String s = "";
        if(!this.yearList.isEmpty() && !this.yearCodeList.isEmpty()) {
            Object object0 = this.yearCodeList.get(this.currentYearFilterIndex);
            q.f(object0, "get(...)");
            ArrayList arrayList0 = (ArrayList)this.filterMap.get(this.yearList.get(this.currentYearFilterIndex));
            if(arrayList0 != null) {
                v9.j j0 = (v9.j)arrayList0.get(this.currentMonthFilterIndex);
                if(j0 != null) {
                    String s1 = j0.c;
                    if(s1 != null) {
                        s = s1;
                    }
                }
            }
            return ((String)object0) + s;
        }
        return "";
    }

    private final void initHeaderView(View view0) {
        View view1 = view0.findViewById(0x7F0A049E);  // id:filter_layout
        q.f(view1, "findViewById(...)");
        this.filterView = (FilterDropDownView)view1;
        View view2 = view0.findViewById(0x7F0A0CB9);  // id:tv_month_period
        q.f(view2, "findViewById(...)");
        this.tvPeriod = (TextView)view2;
        boolean z = q.b(this.period, "TERM");
        this.isNeedsFilterLayout = z;
        TextView textView0 = this.tvPeriod;
        if(textView0 != null) {
            ViewUtils.hideWhen(textView0, z);
            if(this.isNeedsFilterLayout) {
                if(!TextUtils.isEmpty(this.termYear)) {
                    this.setFilterTextView(this.getFilterTextFromTermYear());
                }
                FilterDropDownView filterDropDownView0 = this.filterView;
                if(filterDropDownView0 != null) {
                    filterDropDownView0.setOnDropDownListener(new T(this));
                    return;
                }
                q.m("filterView");
                throw null;
            }
            this.setFilterTextView(this.termYear);
            return;
        }
        q.m("tvPeriod");
        throw null;
    }

    private static final void initHeaderView$lambda$5(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, FilterDropDownView filterDropDownView0) {
        if(!myMusicMyChartMonthFragment0.isRetainedPopupShowing()) {
            com.iloen.melon.popup.CommonFilterPopup.Companion commonFilterPopup$Companion0 = CommonFilterPopup.Companion;
            ArrayList arrayList0 = myMusicMyChartMonthFragment0.yearList;
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object0: arrayList0) {
                v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = (String)object0;
                j0.e = (List)myMusicMyChartMonthFragment0.filterMap.get(((String)object0));
                arrayList1.add(j0);
            }
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(commonFilterPopup$Companion0, 0x7F1307D1, "LIST_TYPE_DEPTH_TWO_HORIZONTAL", je.p.P0(arrayList1), myMusicMyChartMonthFragment0.currentYearFilterIndex, myMusicMyChartMonthFragment0.currentMonthFilterIndex, 0, new U(myMusicMyChartMonthFragment0), 0x20, null);  // string:order_by "정렬"
            FragmentActivity fragmentActivity0 = myMusicMyChartMonthFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(myMusicMyChartMonthFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
        }
    }

    private static final H initHeaderView$lambda$5$lambda$3(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, int v, int v1, int v2) {
        H h0 = H.a;
        if(v == myMusicMyChartMonthFragment0.currentYearFilterIndex && v1 == myMusicMyChartMonthFragment0.currentMonthFilterIndex) {
            return h0;
        }
        myMusicMyChartMonthFragment0.currentYearFilterIndex = v;
        myMusicMyChartMonthFragment0.currentMonthFilterIndex = v1;
        myMusicMyChartMonthFragment0.setFilterTextView(myMusicMyChartMonthFragment0.getFilterText());
        myMusicMyChartMonthFragment0.startFetch("filter change");
        return h0;
    }

    @NotNull
    public static final MyMusicMyChartMonthFragment newInstance(@NotNull String s, @NotNull String s1) {
        return MyMusicMyChartMonthFragment.Companion.newInstance(s, s1);
    }

    @NotNull
    public static final MyMusicMyChartMonthFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        return MyMusicMyChartMonthFragment.Companion.newInstance(s, s1, s2);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        FilterDropDownView filterDropDownView0 = this.filterView;
        if(filterDropDownView0 != null) {
            filterDropDownView0.setOnDropDownListener(null);
            return;
        }
        q.m("filterView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        if(this.isNeedsFilterLayout && this.yearList.isEmpty()) {
            this.requestYearList(i0);
            return true;
        }
        this.requestMyChart(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argPeriod");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.period = s;
        String s2 = bundle0.getString("argTermYear");
        if(s2 == null) {
            s2 = "";
        }
        this.termYear = s2;
        String s3 = bundle0.getString("argMemberKey");
        if(s3 != null) {
            s1 = s3;
        }
        this.memberKey = s1;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onResume() {
        super.onResume();
        FilterDropDownView filterDropDownView0 = this.filterView;
        if(filterDropDownView0 != null) {
            filterDropDownView0.setText(this.getFilterText());
            return;
        }
        q.m("filterView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argPeriod", this.period);
        bundle0.putString("argTermYear", this.getTermYear());
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        this.initHeaderView(view0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        boolean z = false;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.setAllCheckButtonVisibility(z);
    }

    public static void r0(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, i i0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, MyMusicTopListSongManyRes myMusicTopListSongManyRes0) {
        MyMusicMyChartMonthFragment.requestMyChart$lambda$10(myMusicMyChartMonthFragment0, i0, myMusicMyChartMonthFragment$MyChartAdapter0, myMusicTopListSongManyRes0);
    }

    private final void requestMyChart(i i0) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicMyChartMonthFragment.MyChartAdapter");
        ((MyChartAdapter)j00).clear();
        Params myMusicTopListSongManyReq$Params0 = new Params();
        myMusicTopListSongManyReq$Params0.dateType = this.period;
        if(this.isNeedsFilterLayout) {
            myMusicTopListSongManyReq$Params0.term = this.getTermYear();
        }
        myMusicTopListSongManyReq$Params0.targetMemberKey = this.memberKey;
        RequestBuilder.newInstance(new MyMusicTopListSongManyReq(this.getContext(), myMusicTopListSongManyReq$Params0)).tag(this.getRequestTag()).listener(new E(this, i0, ((MyChartAdapter)j00), 3)).errorListener(new T(this)).request();
    }

    private static final void requestMyChart$lambda$10(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, i i0, MyChartAdapter myMusicMyChartMonthFragment$MyChartAdapter0, MyMusicTopListSongManyRes myMusicTopListSongManyRes0) {
        int v = 0;
        if(!myMusicMyChartMonthFragment0.prepareFetchComplete(myMusicTopListSongManyRes0)) {
            myMusicMyChartMonthFragment0.setAllCheckButtonVisibility(false);
            return;
        }
        RESPONSE myMusicTopListSongManyRes$RESPONSE0 = myMusicTopListSongManyRes0.response;
        if(myMusicTopListSongManyRes$RESPONSE0 != null) {
            myMusicMyChartMonthFragment0.mMelonTiaraProperty = new s(myMusicTopListSongManyRes$RESPONSE0.section, myMusicTopListSongManyRes$RESPONSE0.page, myMusicTopListSongManyRes$RESPONSE0.menuId, null);
            ArrayList arrayList0 = myMusicTopListSongManyRes$RESPONSE0.songlist;
            if(arrayList0 != null) {
                v = arrayList0.size();
            }
            if(v > 0) {
                String s = myMusicTopListSongManyRes0.response.guidetext;
                q.f(s, "guidetext");
                myMusicMyChartMonthFragment$MyChartAdapter0.setGuideText(s);
                myMusicMyChartMonthFragment0.setAllCheckButtonVisibility(true);
            }
        }
        if(!myMusicMyChartMonthFragment0.isNeedsFilterLayout) {
            String s1 = myMusicTopListSongManyRes0.response.monthText;
            q.f(s1, "monthText");
            myMusicMyChartMonthFragment0.termYear = s1;
            myMusicMyChartMonthFragment0.setFilterTextView(s1);
        }
        myMusicMyChartMonthFragment0.performFetchComplete(i0, myMusicTopListSongManyRes0);
    }

    private static final void requestMyChart$lambda$11(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, VolleyError volleyError0) {
        myMusicMyChartMonthFragment0.setAllCheckButtonVisibility(false);
        myMusicMyChartMonthFragment0.performFetchError(volleyError0);
    }

    private final void requestYearList(i i0) {
        RequestBuilder.newInstance(new MyMusicTopListYearMonthReq(this.getContext())).tag(this.getRequestTag()).listener(new S(this, i0)).errorListener(new S(this, i0)).request();
    }

    private static final void requestYearList$lambda$6(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, i i0, Object object0) {
        int v;
        if(object0 instanceof MyMusicTopListYearMonthRes) {
            com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes.RESPONSE myMusicTopListYearMonthRes$RESPONSE0 = ((MyMusicTopListYearMonthRes)object0).response;
            if(myMusicTopListYearMonthRes$RESPONSE0 == null) {
                v = 0;
            }
            else {
                ArrayList arrayList0 = myMusicTopListYearMonthRes$RESPONSE0.yearlist;
                v = arrayList0 == null ? 0 : arrayList0.size();
            }
            if(v > 0) {
                com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes.RESPONSE myMusicTopListYearMonthRes$RESPONSE1 = ((MyMusicTopListYearMonthRes)object0).response;
                q.f(myMusicTopListYearMonthRes$RESPONSE1, "response");
                myMusicMyChartMonthFragment0.setYearList(myMusicTopListYearMonthRes$RESPONSE1);
            }
            myMusicMyChartMonthFragment0.requestMyChart(i0);
        }
    }

    private static final void requestYearList$lambda$7(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, i i0, VolleyError volleyError0) {
        myMusicMyChartMonthFragment0.requestMyChart(i0);
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            FilterDropDownView filterDropDownView0 = this.filterView;
            if(filterDropDownView0 != null) {
                ViewUtils.showWhen(filterDropDownView0, true);
                FilterDropDownView filterDropDownView1 = this.filterView;
                if(filterDropDownView1 != null) {
                    T t0 = new T(this);
                    filterDropDownView1.c(L.b, t0);
                    FilterDropDownView filterDropDownView2 = this.filterView;
                    if(filterDropDownView2 != null) {
                        filterDropDownView2.setOnCheckedListener(new T(this));
                        return;
                    }
                    q.m("filterView");
                    throw null;
                }
                q.m("filterView");
                throw null;
            }
            q.m("filterView");
            throw null;
        }
        FilterDropDownView filterDropDownView3 = this.filterView;
        if(filterDropDownView3 != null) {
            ViewUtils.showWhen(filterDropDownView3, q.b(this.period, "TERM"));
            FilterDropDownView filterDropDownView4 = this.filterView;
            if(filterDropDownView4 != null) {
                filterDropDownView4.setLeftButton(null);
                FilterDropDownView filterDropDownView5 = this.filterView;
                if(filterDropDownView5 != null) {
                    filterDropDownView5.setRightLayout(null);
                    return;
                }
                q.m("filterView");
                throw null;
            }
            q.m("filterView");
            throw null;
        }
        q.m("filterView");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$12(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, View view0) {
        myMusicMyChartMonthFragment0.playAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$13(MyMusicMyChartMonthFragment myMusicMyChartMonthFragment0, com.iloen.melon.custom.S s0, boolean z) {
        myMusicMyChartMonthFragment0.toggleSelectAll();
    }

    private final void setFilterTextView(String s) {
        if(this.isNeedsFilterLayout) {
            FilterDropDownView filterDropDownView0 = this.filterView;
            if(filterDropDownView0 != null) {
                ViewUtils.showWhen(filterDropDownView0.k, true);
                FilterDropDownView filterDropDownView1 = this.filterView;
                if(filterDropDownView1 != null) {
                    filterDropDownView1.setText(s);
                    return;
                }
                q.m("filterView");
                throw null;
            }
            q.m("filterView");
            throw null;
        }
        FilterDropDownView filterDropDownView2 = this.filterView;
        if(filterDropDownView2 != null) {
            ViewUtils.showWhen(filterDropDownView2.k, false);
            TextView textView0 = this.tvPeriod;
            if(textView0 != null) {
                ViewUtils.setText(textView0, s);
                return;
            }
            q.m("tvPeriod");
            throw null;
        }
        q.m("filterView");
        throw null;
    }

    private final void setRmLandingFilterPosition() {
        String s4;
        String s2;
        if(!TextUtils.isEmpty(this.termYear) && this.termYear.length() > 4) {
            String s = this.termYear.substring(0, 4);
            q.f(s, "substring(...)");
            this.currentYearFilterIndex = this.yearCodeList.indexOf(s);
            if(this.termYear.length() == 5) {
                String s1 = this.termYear.substring(4, 5);
                q.f(s1, "substring(...)");
                s2 = "0" + s1;
            }
            else {
                s2 = this.termYear.substring(4, 6);
                q.f(s2, "substring(...)");
            }
            ArrayList arrayList0 = (ArrayList)this.filterMap.get(this.yearList.get(this.currentYearFilterIndex));
            int v1 = arrayList0 == null ? 0 : arrayList0.size();
            for(int v = 0; v < v1; ++v) {
                if(arrayList0 == null) {
                    s4 = "";
                }
                else {
                    v9.j j0 = (v9.j)arrayList0.get(v);
                    if(j0 != null) {
                        String s3 = j0.c;
                        if(s3 != null) {
                            s4 = s3;
                        }
                    }
                }
                if(s4.equals(s2)) {
                    this.currentMonthFilterIndex = v;
                }
            }
        }
    }

    private final void setYearList(com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes.RESPONSE myMusicTopListYearMonthRes$RESPONSE0) {
        this.filterMap = new LinkedHashMap();
        this.yearList = new ArrayList();
        int v = myMusicTopListYearMonthRes$RESPONSE0.yearlist.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = ((YEARLIST)myMusicTopListYearMonthRes$RESPONSE0.yearlist.get(v1)).name;
            String s1 = ((YEARLIST)myMusicTopListYearMonthRes$RESPONSE0.yearlist.get(v1)).year;
            this.yearList.add(s);
            this.yearCodeList.add(s1);
            ArrayList arrayList0 = ((YEARLIST)myMusicTopListYearMonthRes$RESPONSE0.yearlist.get(v1)).monthlist;
            ArrayList arrayList1 = new ArrayList();
            if(arrayList0 != null && arrayList0.size() > 0) {
                int v2 = arrayList0.size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    MONTHLIST myMusicTopListYearMonthRes$RESPONSE$YEARLIST$MONTHLIST0 = (MONTHLIST)arrayList0.get(v3);
                    v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                    j0.b = myMusicTopListYearMonthRes$RESPONSE$YEARLIST$MONTHLIST0.name;
                    j0.c = myMusicTopListYearMonthRes$RESPONSE$YEARLIST$MONTHLIST0.month;
                    arrayList1.add(j0);
                    if(q.b(s, s1 + myMusicTopListYearMonthRes$RESPONSE$YEARLIST$MONTHLIST0.month)) {
                        this.currentYearFilterIndex = v1;
                        this.currentMonthFilterIndex = v3;
                    }
                }
            }
            this.filterMap.put(s, arrayList1);
        }
        if(!TextUtils.isEmpty(this.termYear)) {
            FilterDropDownView filterDropDownView0 = this.filterView;
            if(filterDropDownView0 != null) {
                filterDropDownView0.setText(this.getFilterTextFromTermYear());
                this.setRmLandingFilterPosition();
                return;
            }
            q.m("filterView");
            throw null;
        }
        FilterDropDownView filterDropDownView1 = this.filterView;
        if(filterDropDownView1 != null) {
            filterDropDownView1.setText(this.getFilterText());
            return;
        }
        q.m("filterView");
        throw null;
    }
}

