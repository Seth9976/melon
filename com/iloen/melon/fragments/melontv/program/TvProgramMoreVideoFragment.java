package com.iloen.melon.fragments.melontv.program;

import Cb.k;
import E8.c;
import android.content.Context;
import android.os.Bundle;
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
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ProgramMoreMvReq.Params;
import com.iloen.melon.net.v6x.request.ProgramMoreMvReq;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes.Response.EpsdList;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes.Response.MvList;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes.Response.MyTypeCode;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes.Response.YearList;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import pe.a;
import pe.b;
import v9.e;
import v9.h;
import v9.i;
import v9.j;

@Metadata(d1 = {"\u0000\u00BA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0089\u00012\u00020\u0001:\b\u008A\u0001\u008B\u0001\u0089\u0001\u008C\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0011H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b \u0010\u001EJ\u001B\u0010$\u001A\u0006\u0012\u0002\b\u00030#2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u001D\u0010,\u001A\u00020\u000E2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020*0)H\u0002\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b.\u0010\u0003J\u0019\u0010/\u001A\u00020\u000E2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b/\u00100J)\u00105\u001A\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4*\b\u0012\u0004\u0012\u0002010)H\u0002\u00A2\u0006\u0004\b5\u00106J)\u00108\u001A\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4*\b\u0012\u0004\u0012\u0002070)H\u0002\u00A2\u0006\u0004\b8\u00106J\u0017\u0010:\u001A\u00020\u000E2\u0006\u00109\u001A\u00020\u0019H\u0002\u00A2\u0006\u0004\b:\u0010;R\"\u0010<\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b<\u0010=\u001A\u0004\b>\u0010\u0013\"\u0004\b?\u0010@R\"\u0010B\u001A\u00020A8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bB\u0010C\u001A\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001A\u00020H8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010J\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001A\u00020H8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bO\u0010J\u001A\u0004\bP\u0010L\"\u0004\bQ\u0010NR2\u0010R\u001A\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`48\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bR\u0010S\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010X\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bX\u0010=\u001A\u0004\bY\u0010\u0013\"\u0004\bZ\u0010@R\"\u0010[\u001A\u00020H8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b[\u0010J\u001A\u0004\b\\\u0010L\"\u0004\b]\u0010NR2\u0010^\u001A\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`48\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b^\u0010S\u001A\u0004\b_\u0010U\"\u0004\b`\u0010WR\"\u0010a\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\ba\u0010b\u001A\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010h\u001A\u00020g8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001A\u00020\n8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bn\u0010b\u001A\u0004\bo\u0010d\"\u0004\bp\u0010fR\"\u0010q\u001A\u00020g8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bq\u0010i\u001A\u0004\br\u0010k\"\u0004\bs\u0010mR\"\u0010u\u001A\u00020t8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bu\u0010v\u001A\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001A\u00020\u00118\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b{\u0010=\u001A\u0004\b|\u0010\u0013\"\u0004\b}\u0010@R\'\u0010\u007F\u001A\u00020~8\u0006@\u0006X\u0086.\u00A2\u0006\u0017\n\u0005\b\u007F\u0010\u0080\u0001\u001A\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0088\u0001\u001A\u00030\u0085\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\u00A8\u0006\u008D\u0001"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getCacheKey", "()Ljava/lang/String;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/iloen/melon/net/v6x/response/ProgramMoreMvRes$Response$MyTypeCode;", "list", "makeScrollableAlyacFilterData", "(Ljava/util/List;)V", "initScrollableAlyacFilter", "request", "(Lv9/i;)V", "Lcom/iloen/melon/net/v6x/response/ProgramMoreMvRes$Response$YearList;", "Ljava/util/ArrayList;", "Lv9/j;", "Lkotlin/collections/ArrayList;", "convertFilterList", "(Ljava/util/List;)Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ProgramMoreMvRes$Response$EpsdList;", "convertFilterListItem", "isVisible", "setFilterButtonVisibility", "(Z)V", "progSeq", "Ljava/lang/String;", "getProgSeq", "setProgSeq", "(Ljava/lang/String;)V", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;", "orderType", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;", "getOrderType", "()Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;", "setOrderType", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;)V", "", "yearFilterIndex", "I", "getYearFilterIndex", "()I", "setYearFilterIndex", "(I)V", "roundPosition", "getRoundPosition", "setRoundPosition", "epsdList", "Ljava/util/ArrayList;", "getEpsdList", "()Ljava/util/ArrayList;", "setEpsdList", "(Ljava/util/ArrayList;)V", "alyacFilterType", "getAlyacFilterType", "setAlyacFilterType", "alyacPostion", "getAlyacPostion", "setAlyacPostion", "alyacList", "getAlyacList", "setAlyacList", "filterContainer", "Landroid/view/View;", "getFilterContainer", "()Landroid/view/View;", "setFilterContainer", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "orderTypeTv", "Landroid/widget/TextView;", "getOrderTypeTv", "()Landroid/widget/TextView;", "setOrderTypeTv", "(Landroid/widget/TextView;)V", "roundContainer", "getRoundContainer", "setRoundContainer", "roundTv", "getRoundTv", "setRoundTv", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "scrollableAlyacFilter", "Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "getScrollableAlyacFilter", "()Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;", "setScrollableAlyacFilter", "(Lcom/iloen/melon/custom/tablayout/ScrollableAlyacFilter;)V", "progName", "getProgName", "setProgName", "Lp8/s;", "tiaraBase", "Lp8/s;", "getTiaraBase", "()Lp8/s;", "setTiaraBase", "(Lp8/s;)V", "Lp8/f;", "getTiaraBuilder", "()Lp8/f;", "tiaraBuilder", "Companion", "TvProgramMoreVideoAdapter", "TvProgramVideoViewHolder", "OrderType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramMoreVideoFragment extends FetcherBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$Companion;", "", "<init>", "()V", "ARG_PROGSEQ", "", "ARG_PROGNAME", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment;", "progSeq", "progName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramMoreVideoFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "progSeq");
            q.g(s1, "progName");
            TvProgramMoreVideoFragment tvProgramMoreVideoFragment0 = new TvProgramMoreVideoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProcSeq", s);
            bundle0.putString("argProgName", s1);
            tvProgramMoreVideoFragment0.setArguments(bundle0);
            return tvProgramMoreVideoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NEW", "OLD", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum OrderType {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType$Companion;", "", "<init>", "()V", "getType", "Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$OrderType;", "ordinal", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion {
            private com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion() {
            }

            public com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final OrderType getType(int v) {
                return v == 0 ? OrderType.NEW : OrderType.OLD;
            }
        }

        NEW("NEW"),
        OLD("OLD");

        private static final a $ENTRIES;
        private static final OrderType[] $VALUES;
        @NotNull
        public static final com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion Companion;
        @NotNull
        private final String value;

        private static final OrderType[] $values() [...] // Inlined contents

        static {
            OrderType.$VALUES = arr_tvProgramMoreVideoFragment$OrderType;
            q.g(arr_tvProgramMoreVideoFragment$OrderType, "entries");
            OrderType.$ENTRIES = new b(arr_tvProgramMoreVideoFragment$OrderType);
            OrderType.Companion = new com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion(null);
        }

        private OrderType(String s1) {
            this.value = s1;
        }

        @NotNull
        public static a getEntries() {
            return OrderType.$ENTRIES;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00032\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u000B8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$TvProgramMoreVideoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/MvInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "videoType", "I", "getVideoType", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramMoreVideoAdapter extends p {
        private final int videoType;

        public TvProgramMoreVideoAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            TvProgramMoreVideoFragment.this = tvProgramMoreVideoFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.videoType;
        }

        public final int getVideoType() {
            return this.videoType;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof TvProgramVideoViewHolder) {
                Object object0 = this.getItem(v1);
                MvList programMoreMvRes$Response$MvList0 = object0 instanceof MvList ? ((MvList)object0) : null;
                if(programMoreMvRes$Response$MvList0 != null) {
                    Glide.with(this.getContext()).load(programMoreMvRes$Response$MvList0.mv169Img).into(((TvProgramVideoViewHolder)o00).getIvThumb());
                    ((TvProgramVideoViewHolder)o00).getMvTitle().setText(programMoreMvRes$Response$MvList0.mvName);
                    ((TvProgramVideoViewHolder)o00).getDateTv().setText(programMoreMvRes$Response$MvList0.issueDate);
                    ((TvProgramVideoViewHolder)o00).getArtistTv().setText(MelonDetailInfoUtils.INSTANCE.getArtistFormat(this.getContext(), programMoreMvRes$Response$MvList0.artistList, 0x7FFFFFFF));
                    int v2 = 8;
                    if(programMoreMvRes$Response$MvList0.epsdNoName == null || programMoreMvRes$Response$MvList0.epsdNoName.length() == 0) {
                        ((TvProgramVideoViewHolder)o00).getRoundDot().setVisibility(8);
                    }
                    else {
                        ((TvProgramVideoViewHolder)o00).getRoundDot().setVisibility(0);
                    }
                    ((TvProgramVideoViewHolder)o00).getRountTv().setText(programMoreMvRes$Response$MvList0.epsdNoName);
                    ((TvProgramVideoViewHolder)o00).getPlayTime().setText(k.f((programMoreMvRes$Response$MvList0.playTime == null ? "" : programMoreMvRes$Response$MvList0.playTime)));
                    View view0 = ((TvProgramVideoViewHolder)o00).getGrade19();
                    if(programMoreMvRes$Response$MvList0.isAdult) {
                        v2 = 0;
                    }
                    view0.setVisibility(v2);
                    l l0 = new l(programMoreMvRes$Response$MvList0, this, TvProgramMoreVideoFragment.this, v1, 2);
                    ((TvProgramVideoViewHolder)o00).itemView.setOnClickListener(l0);
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(MvList programMoreMvRes$Response$MvList0, TvProgramMoreVideoAdapter tvProgramMoreVideoFragment$TvProgramMoreVideoAdapter0, TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, int v, View view0) {
            Navigator.openMvInfo$default(programMoreMvRes$Response$MvList0.mvId, tvProgramMoreVideoFragment$TvProgramMoreVideoAdapter0.getMenuId(), null, false, 12, null);
            f f0 = tvProgramMoreVideoFragment0.getTiaraBuilder();
            f0.a = "영상재생";
            f0.d = ActionKind.PlayVideo;
            f0.C = String.valueOf(v + 1);
            f0.e = programMoreMvRes$Response$MvList0.mvId;
            f0.f = Y.i(ContsTypeCode.VIDEO, "code(...)");
            f0.g = programMoreMvRes$Response$MvList0.mvName;
            f0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D08CF, viewGroup0, false);  // layout:tvprogram_video_item_layout
            q.f(view0, "inflate(...)");
            return new TvProgramVideoViewHolder(TvProgramMoreVideoFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010R\u001F\u0010\u0011\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000E\u001A\u0004\b\u0012\u0010\u0010R\u001F\u0010\u0013\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000E\u001A\u0004\b\u0014\u0010\u0010R\u001F\u0010\u0015\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000E\u001A\u0004\b\u0016\u0010\u0010R\u001F\u0010\u0017\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000E\u001A\u0004\b\u0018\u0010\u0010R\u001F\u0010\u0019\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u001F\u0010\u001D\u001A\n \u0007*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001A\u001A\u0004\b\u001E\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment$TvProgramVideoViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramMoreVideoFragment;Landroid/view/View;)V", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "mvTitle", "Landroid/widget/TextView;", "getMvTitle", "()Landroid/widget/TextView;", "dateTv", "getDateTv", "artistTv", "getArtistTv", "rountTv", "getRountTv", "playTime", "getPlayTime", "grade19", "Landroid/view/View;", "getGrade19", "()Landroid/view/View;", "roundDot", "getRoundDot", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TvProgramVideoViewHolder extends O0 {
        private final TextView artistTv;
        private final TextView dateTv;
        private final View grade19;
        private final ImageView ivThumb;
        private final TextView mvTitle;
        private final TextView playTime;
        private final View roundDot;
        private final TextView rountTv;

        public TvProgramVideoViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            TvProgramMoreVideoFragment.this = tvProgramMoreVideoFragment0;
            super(view0);
            this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.mvTitle = (TextView)view0.findViewById(0x7F0A0890);  // id:mv_title
            this.dateTv = (TextView)view0.findViewById(0x7F0A037E);  // id:date_tv
            this.artistTv = (TextView)view0.findViewById(0x7F0A00C2);  // id:artist_tv
            this.rountTv = (TextView)view0.findViewById(0x7F0A0A13);  // id:round_text
            this.playTime = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
            this.grade19 = view0.findViewById(0x7F0A0633);  // id:iv_grade
            this.roundDot = view0.findViewById(0x7F0A03E1);  // id:dot
        }

        public final TextView getArtistTv() {
            return this.artistTv;
        }

        public final TextView getDateTv() {
            return this.dateTv;
        }

        public final View getGrade19() {
            return this.grade19;
        }

        public final ImageView getIvThumb() {
            return this.ivThumb;
        }

        public final TextView getMvTitle() {
            return this.mvTitle;
        }

        public final TextView getPlayTime() {
            return this.playTime;
        }

        public final View getRoundDot() {
            return this.roundDot;
        }

        public final TextView getRountTv() {
            return this.rountTv;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_PROGNAME = "argProgName";
    @NotNull
    public static final String ARG_PROGSEQ = "argProcSeq";
    @NotNull
    public static final Companion Companion;
    @NotNull
    private String alyacFilterType;
    @NotNull
    private ArrayList alyacList;
    private int alyacPostion;
    @NotNull
    private ArrayList epsdList;
    public View filterContainer;
    @NotNull
    private OrderType orderType;
    public TextView orderTypeTv;
    @NotNull
    private String progName;
    @NotNull
    private String progSeq;
    public View roundContainer;
    private int roundPosition;
    public TextView roundTv;
    public ScrollableAlyacFilter scrollableAlyacFilter;
    public s tiaraBase;
    private int yearFilterIndex;

    static {
        TvProgramMoreVideoFragment.Companion = new Companion(null);
        TvProgramMoreVideoFragment.$stable = 8;
    }

    public TvProgramMoreVideoFragment() {
        this.progSeq = "";
        this.orderType = OrderType.NEW;
        this.epsdList = new ArrayList();
        this.alyacFilterType = "";
        this.alyacList = new ArrayList();
        this.progName = "";
    }

    private final ArrayList convertFilterList(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.a = ((YearList)object0).year;
            j0.b = ((YearList)object0).year;
            List list1 = ((YearList)object0).epsdList;
            q.f(list1, "epsdList");
            j0.e = this.convertFilterListItem(list1);
            arrayList0.add(j0);
        }
        return arrayList0;
    }

    private final ArrayList convertFilterListItem(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            String s = ((EpsdList)object0).epsdName;
            j0.a = s;
            j0.c = ((EpsdList)object0).cnpckSeq;
            j0.b = s;
            arrayList0.add(j0);
        }
        return arrayList0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new TvProgramMoreVideoAdapter(this, context0, null);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1308A7);  // string:program_empty_description "등록된 영상이 없습니다."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @NotNull
    public final String getAlyacFilterType() {
        return this.alyacFilterType;
    }

    @NotNull
    public final ArrayList getAlyacList() {
        return this.alyacList;
    }

    public final int getAlyacPostion() {
        return this.alyacPostion;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.V0.buildUpon().appendPath("morevideo"), this.progSeq, "toString(...)");
    }

    @NotNull
    public final ArrayList getEpsdList() {
        return this.epsdList;
    }

    @NotNull
    public final View getFilterContainer() {
        View view0 = this.filterContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("filterContainer");
        throw null;
    }

    @NotNull
    public final OrderType getOrderType() {
        return this.orderType;
    }

    @NotNull
    public final TextView getOrderTypeTv() {
        TextView textView0 = this.orderTypeTv;
        if(textView0 != null) {
            return textView0;
        }
        q.m("orderTypeTv");
        throw null;
    }

    @NotNull
    public final String getProgName() {
        return this.progName;
    }

    @NotNull
    public final String getProgSeq() {
        return this.progSeq;
    }

    @NotNull
    public final View getRoundContainer() {
        View view0 = this.roundContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("roundContainer");
        throw null;
    }

    public final int getRoundPosition() {
        return this.roundPosition;
    }

    @NotNull
    public final TextView getRoundTv() {
        TextView textView0 = this.roundTv;
        if(textView0 != null) {
            return textView0;
        }
        q.m("roundTv");
        throw null;
    }

    @NotNull
    public final ScrollableAlyacFilter getScrollableAlyacFilter() {
        ScrollableAlyacFilter scrollableAlyacFilter0 = this.scrollableAlyacFilter;
        if(scrollableAlyacFilter0 != null) {
            return scrollableAlyacFilter0;
        }
        q.m("scrollableAlyacFilter");
        throw null;
    }

    @NotNull
    public final s getTiaraBase() {
        s s0 = this.tiaraBase;
        if(s0 != null) {
            return s0;
        }
        q.m("tiaraBase");
        throw null;
    }

    private final f getTiaraBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.getTiaraBase().a;
        f0.c = this.getTiaraBase().b;
        f0.I = this.getTiaraBase().c;
        f0.o = this.progSeq;
        f0.q = this.progName;
        f0.y = this.getContext() == null ? null : "리스트";
        return f0;
    }

    public final int getYearFilterIndex() {
        return this.yearFilterIndex;
    }

    private final void initScrollableAlyacFilter() {
        if(this.alyacList != null && !this.alyacList.isEmpty()) {
            this.getScrollableAlyacFilter().setVisibility(0);
            ScrollableAlyacFilter scrollableAlyacFilter0 = this.getScrollableAlyacFilter();
            scrollableAlyacFilter0.d(this.alyacList);
            scrollableAlyacFilter0.setPadding(ScreenUtils.dipToPixel(this.getContext(), 20.0f));
            scrollableAlyacFilter0.setSelectedIndex(this.alyacPostion);
            scrollableAlyacFilter0.e(new com.iloen.melon.fragments.melontv.program.s(this), new c());  // 初始化器: Ljava/lang/Object;-><init>()V
            return;
        }
        this.getScrollableAlyacFilter().setVisibility(8);
    }

    private static final void initScrollableAlyacFilter$lambda$9$lambda$8(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, int v) {
        String s = ((j)tvProgramMoreVideoFragment0.alyacList.get(v)).c;
        if(tvProgramMoreVideoFragment0.alyacPostion == v) {
            return;
        }
        tvProgramMoreVideoFragment0.alyacPostion = v;
        q.d(s);
        tvProgramMoreVideoFragment0.alyacFilterType = s;
        tvProgramMoreVideoFragment0.startFetch("alyac filter change");
        f f0 = tvProgramMoreVideoFragment0.getTiaraBuilder();
        String s1 = null;
        f0.a = tvProgramMoreVideoFragment0.getContext() == null ? null : "페이지이동";
        f0.C = String.valueOf(v + 1);
        if(tvProgramMoreVideoFragment0.getContext() != null) {
            s1 = "Pagemenu";
        }
        f0.y = s1;
        f0.F = ((j)tvProgramMoreVideoFragment0.alyacList.get(v)).a;
        f0.o = tvProgramMoreVideoFragment0.progSeq;
        f0.q = tvProgramMoreVideoFragment0.progName;
        f0.a().track();
    }

    private final void makeScrollableAlyacFilterData(List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.a = ((MyTypeCode)object0).name;
            j0.b = ((MyTypeCode)object0).name;
            j0.c = ((MyTypeCode)object0).myTypeCode;
            arrayList0.add(j0);
        }
        this.alyacList = arrayList0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D3);  // id:recyclerview
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setItemAnimator(null);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D08CB, viewGroup0, false);  // layout:tvprogram_more_video_layout
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        this.request(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argProcSeq");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.progSeq = s;
        String s2 = bundle0.getString("argProgName");
        if(s2 != null) {
            s1 = s2;
        }
        this.progName = s1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argProcSeq", this.progSeq);
        bundle0.putString("argProgName", this.progName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        String s1;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        if(this.getTitleBar() != null) {
            this.getTitleBar().a(B.a.s(7));
            this.getTitleBar().setBackgroundColor(0);
            TitleBar titleBar0 = this.getTitleBar();
            Context context0 = this.getContext();
            titleBar0.setTitle((context0 == null || context0.getResources() == null ? null : "영상"));
        }
        View view1 = view0.findViewById(0x7F0A049E);  // id:filter_layout
        q.f(view1, "findViewById(...)");
        this.setFilterContainer(view1);
        View view2 = view0.findViewById(0x7F0A04A1);  // id:filter_order_tv
        q.f(view2, "findViewById(...)");
        this.setOrderTypeTv(((TextView)view2));
        View view3 = view0.findViewById(0x7F0A0A14);  // id:round_tv
        q.f(view3, "findViewById(...)");
        this.setRoundTv(((TextView)view3));
        View view4 = view0.findViewById(0x7F0A08E8);  // id:orderby_container
        View view5 = view0.findViewById(0x7F0A03E1);  // id:dot
        String[] arr_s = this.getResources().getStringArray(0x7F030040);  // array:sortingbar_melontv_more_mv
        q.f(arr_s, "getStringArray(...)");
        List list0 = n.N(arr_s);
        this.getOrderTypeTv().setText(((CharSequence)list0.get(this.orderType.ordinal())));
        View view6 = view0.findViewById(0x7F0A0A11);  // id:round_filter_container
        q.f(view6, "findViewById(...)");
        this.setRoundContainer(view6);
        if(this.roundPosition == 0 && this.epsdList.isEmpty()) {
            this.getRoundContainer().setVisibility(8);
        }
        else if(this.roundPosition != 0) {
            view4.setVisibility(8);
            view5.setVisibility(8);
            String s = ((j)((j)this.epsdList.get(this.yearFilterIndex)).e.get(this.roundPosition)).a;
            this.getRoundTv().setText(s);
            View view7 = this.getRoundContainer();
            Context context1 = this.getContext();
            if(context1 == null) {
                s1 = "";
            }
            else {
                s1 = context1.getString(0x7F130C0E, new Object[]{s});  // string:talkback_program_detail_round_contentdescription_with_hint_and_classname 
                                                                       // "%s, 회차기준 변경, 버튼"
                if(s1 == null) {
                    s1 = "";
                }
            }
            view7.setContentDescription(s1);
        }
        this.getRoundContainer().setOnClickListener(new com.iloen.melon.fragments.melontv.program.e(this, view4, view5, 1));
        view4.setOnClickListener(new com.iloen.melon.fragments.melontv.program.b(3, this, list0));
        View view8 = this.findViewById(0x7F0A0A31);  // id:scrollable_alyac_filter
        q.e(view8, "null cannot be cast to non-null type com.iloen.melon.custom.tablayout.ScrollableAlyacFilter");
        this.setScrollableAlyacFilter(((ScrollableAlyacFilter)view8));
        if(!this.alyacList.isEmpty() && this.getScrollableAlyacFilter().getVisibility() != 0) {
            this.initScrollableAlyacFilter();
        }
    }

    private static final void onViewCreated$lambda$2(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, View view0, View view1, View view2) {
        if(!tvProgramMoreVideoFragment0.isRetainedPopupShowing()) {
            ArrayList arrayList0 = tvProgramMoreVideoFragment0.epsdList;
            int v = tvProgramMoreVideoFragment0.yearFilterIndex;
            int v1 = tvProgramMoreVideoFragment0.roundPosition;
            t t0 = new t(tvProgramMoreVideoFragment0, view0, view1);
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(CommonFilterPopup.Companion, 0x7F130213, "LIST_TYPE_DEPTH_TWO_HORIZONTAL", arrayList0, v, v1, 0, t0, 0x20, null);  // string:common_filter_popup_title_episode "회차"
            FragmentActivity fragmentActivity0 = tvProgramMoreVideoFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(tvProgramMoreVideoFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
        }
    }

    private static final H onViewCreated$lambda$2$lambda$0(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, View view0, View view1, int v, int v1, int v2) {
        String s1;
        H h0 = H.a;
        if(v == tvProgramMoreVideoFragment0.yearFilterIndex && v1 == tvProgramMoreVideoFragment0.roundPosition) {
            return h0;
        }
        tvProgramMoreVideoFragment0.yearFilterIndex = v;
        tvProgramMoreVideoFragment0.roundPosition = v1;
        String s = ((j)((j)tvProgramMoreVideoFragment0.epsdList.get(v)).e.get(tvProgramMoreVideoFragment0.roundPosition)).a;
        tvProgramMoreVideoFragment0.getRoundTv().setText(s);
        if(tvProgramMoreVideoFragment0.roundPosition == 0) {
            view0.setVisibility(0);
            view1.setVisibility(0);
        }
        else {
            view0.setVisibility(8);
            view1.setVisibility(8);
        }
        tvProgramMoreVideoFragment0.startFetch("filter change");
        if(tvProgramMoreVideoFragment0.tiaraBase != null) {
            f f0 = tvProgramMoreVideoFragment0.getTiaraBuilder();
            f0.a = tvProgramMoreVideoFragment0.getContext() == null ? null : "페이지이동";
            f0.F = s;
            f0.a().track();
        }
        View view2 = tvProgramMoreVideoFragment0.getRoundContainer();
        Context context0 = tvProgramMoreVideoFragment0.getContext();
        if(context0 == null) {
            s1 = "";
        }
        else {
            s1 = context0.getString(0x7F130C0E, new Object[]{s});  // string:talkback_program_detail_round_contentdescription_with_hint_and_classname 
                                                                   // "%s, 회차기준 변경, 버튼"
            if(s1 == null) {
                s1 = "";
            }
        }
        view2.setContentDescription(s1);
        return h0;
    }

    private static final void onViewCreated$lambda$5(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, List list0, View view0) {
        FragmentActivity fragmentActivity0 = tvProgramMoreVideoFragment0.getActivity();
        if(fragmentActivity0 != null) {
            BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
            bottomSingleFilterListPopup0.setTitle("정렬");
            bottomSingleFilterListPopup0.setFilterItem(list0, tvProgramMoreVideoFragment0.orderType.ordinal());
            bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.melontv.program.k(tvProgramMoreVideoFragment0, list0, 2));
            bottomSingleFilterListPopup0.setOnDismissListener(tvProgramMoreVideoFragment0.mDialogDismissListener);
            tvProgramMoreVideoFragment0.mRetainDialog = bottomSingleFilterListPopup0;
            bottomSingleFilterListPopup0.show();
        }
    }

    private static final void onViewCreated$lambda$5$lambda$4$lambda$3(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, List list0, int v) {
        com.iloen.melon.fragments.melontv.program.TvProgramMoreVideoFragment.OrderType.Companion tvProgramMoreVideoFragment$OrderType$Companion0 = OrderType.Companion;
        if(tvProgramMoreVideoFragment0.orderType != tvProgramMoreVideoFragment$OrderType$Companion0.getType(v)) {
            Object object0 = list0.get(v);
            q.f(object0, "get(...)");
            tvProgramMoreVideoFragment0.orderType = tvProgramMoreVideoFragment$OrderType$Companion0.getType(v);
            tvProgramMoreVideoFragment0.getOrderTypeTv().setText(((String)object0));
            tvProgramMoreVideoFragment0.startFetch("filter change");
            if(tvProgramMoreVideoFragment0.tiaraBase != null) {
                f f0 = tvProgramMoreVideoFragment0.getTiaraBuilder();
                f0.a = tvProgramMoreVideoFragment0.getContext() == null ? null : "페이지이동";
                f0.F = (String)object0;
                f0.a().track();
            }
        }
    }

    private final void request(i i0) {
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof TvProgramMoreVideoAdapter) {
            i i1 = i.b;
            if(q.b(i0, i1)) {
                ((TvProgramMoreVideoAdapter)j00).clear();
            }
            Params programMoreMvReq$Params0 = new Params();
            programMoreMvReq$Params0.orderBy = this.orderType.getValue();
            programMoreMvReq$Params0.startIndex = q.b(i0, i1) ? 1 : ((TvProgramMoreVideoAdapter)j00).getCount() + 1;
            programMoreMvReq$Params0.progSeq = this.progSeq;
            programMoreMvReq$Params0.mvTypeCode = this.alyacFilterType;
            if(!this.epsdList.isEmpty()) {
                programMoreMvReq$Params0.cnpckSeq = ((j)((j)this.epsdList.get(this.yearFilterIndex)).e.get(this.roundPosition)).c;
            }
            RequestBuilder.newInstance(new ProgramMoreMvReq(this.getContext(), programMoreMvReq$Params0)).listener(new o(this, i0, j00, 1)).tag(this.getRequestTag()).errorListener(new com.iloen.melon.fragments.melontv.program.s(this)).request();
        }
    }

    private static final void request$lambda$12$lambda$10(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, i i0, j0 j00, ProgramMoreMvRes programMoreMvRes0) {
        String s;
        if(!tvProgramMoreVideoFragment0.prepareFetchComplete(programMoreMvRes0)) {
            return;
        }
        tvProgramMoreVideoFragment0.performFetchComplete(i0, programMoreMvRes0);
        ((TvProgramMoreVideoAdapter)j00).notifyDataSetChanged();
        Collection collection0 = programMoreMvRes0.response.mvList;
        if(collection0 == null || collection0.isEmpty()) {
            tvProgramMoreVideoFragment0.setFilterButtonVisibility(false);
        }
        else {
            tvProgramMoreVideoFragment0.setFilterButtonVisibility(true);
        }
        if(tvProgramMoreVideoFragment0.getScrollableAlyacFilter().getVisibility() != 0) {
            Collection collection1 = programMoreMvRes0.response.filterList;
            if(collection1 != null && !collection1.isEmpty()) {
                List list0 = programMoreMvRes0.response.filterList;
                q.f(list0, "filterList");
                tvProgramMoreVideoFragment0.makeScrollableAlyacFilterData(list0);
                tvProgramMoreVideoFragment0.initScrollableAlyacFilter();
            }
        }
        if(tvProgramMoreVideoFragment0.roundContainer != null) {
            Collection collection2 = programMoreMvRes0.response.yearLists;
            if(collection2 == null || collection2.isEmpty()) {
                tvProgramMoreVideoFragment0.getRoundContainer().setVisibility(8);
            }
            else {
                List list1 = programMoreMvRes0.response.yearLists;
                tvProgramMoreVideoFragment0.getRoundContainer().setVisibility(0);
                tvProgramMoreVideoFragment0.getRoundTv().setText(((EpsdList)((YearList)list1.get(tvProgramMoreVideoFragment0.yearFilterIndex)).epsdList.get(tvProgramMoreVideoFragment0.roundPosition)).epsdName);
                View view0 = tvProgramMoreVideoFragment0.getRoundContainer();
                Context context0 = tvProgramMoreVideoFragment0.getContext();
                if(context0 == null) {
                    s = "";
                }
                else {
                    s = context0.getString(0x7F130C0E, new Object[]{tvProgramMoreVideoFragment0.getRoundTv().getText()});  // string:talkback_program_detail_round_contentdescription_with_hint_and_classname 
                                                                                                                           // "%s, 회차기준 변경, 버튼"
                    if(s == null) {
                        s = "";
                    }
                }
                view0.setContentDescription(s);
                tvProgramMoreVideoFragment0.epsdList = tvProgramMoreVideoFragment0.convertFilterList(list1);
            }
        }
        tvProgramMoreVideoFragment0.setTiaraBase(new s(programMoreMvRes0.response.section, programMoreMvRes0.response.page, programMoreMvRes0.response.menuId, null));
    }

    private static final void request$lambda$12$lambda$11(TvProgramMoreVideoFragment tvProgramMoreVideoFragment0, VolleyError volleyError0) {
        tvProgramMoreVideoFragment0.mResponseErrorListener.onErrorResponse(volleyError0);
        tvProgramMoreVideoFragment0.setFilterButtonVisibility(false);
    }

    public final void setAlyacFilterType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.alyacFilterType = s;
    }

    public final void setAlyacList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<set-?>");
        this.alyacList = arrayList0;
    }

    public final void setAlyacPostion(int v) {
        this.alyacPostion = v;
    }

    public final void setEpsdList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "<set-?>");
        this.epsdList = arrayList0;
    }

    private final void setFilterButtonVisibility(boolean z) {
        if(z) {
            this.getFilterContainer().setVisibility(0);
            return;
        }
        this.getFilterContainer().setVisibility(8);
    }

    public final void setFilterContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.filterContainer = view0;
    }

    public final void setOrderType(@NotNull OrderType tvProgramMoreVideoFragment$OrderType0) {
        q.g(tvProgramMoreVideoFragment$OrderType0, "<set-?>");
        this.orderType = tvProgramMoreVideoFragment$OrderType0;
    }

    public final void setOrderTypeTv(@NotNull TextView textView0) {
        q.g(textView0, "<set-?>");
        this.orderTypeTv = textView0;
    }

    public final void setProgName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.progName = s;
    }

    public final void setProgSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.progSeq = s;
    }

    public final void setRoundContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.roundContainer = view0;
    }

    public final void setRoundPosition(int v) {
        this.roundPosition = v;
    }

    public final void setRoundTv(@NotNull TextView textView0) {
        q.g(textView0, "<set-?>");
        this.roundTv = textView0;
    }

    public final void setScrollableAlyacFilter(@NotNull ScrollableAlyacFilter scrollableAlyacFilter0) {
        q.g(scrollableAlyacFilter0, "<set-?>");
        this.scrollableAlyacFilter = scrollableAlyacFilter0;
    }

    public final void setTiaraBase(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.tiaraBase = s0;
    }

    public final void setYearFilterIndex(int v) {
        this.yearFilterIndex = v;
    }
}

