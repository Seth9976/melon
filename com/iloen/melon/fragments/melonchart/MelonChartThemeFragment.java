package com.iloen.melon.fragments.melonchart;

import B9.t;
import De.I;
import J8.b;
import J8.c2;
import J8.h3;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.w0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.ChartThemeListReq.Params;
import com.iloen.melon.net.v6x.request.ChartThemeListReq;
import com.iloen.melon.net.v6x.response.ChartThemeListRes.RESPONSE.THEMEINFO.THEMELIST;
import com.iloen.melon.net.v6x.response.ChartThemeListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ChartThemeListRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0005FGHIJB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0011\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\"\u001A\u00020!2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010.\u001A\u00020\u00052\u0006\u0010-\u001A\u00020,H\u0016\u00A2\u0006\u0004\b.\u0010/J!\u00104\u001A\u00020\u00052\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b4\u00105J!\u00106\u001A\u00020\u00052\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b6\u00105J!\u00107\u001A\u00020!2\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b7\u00108J!\u00109\u001A\u00020\u00052\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b9\u00105R\u0014\u0010:\u001A\u0002028\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001A\u0002028\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010>\u001A\u00020=8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u001A\u0010A\u001A\u00060@R\u00020\u00008\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010E\u001A\u0002028BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bC\u0010D\u00A8\u0006K"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "LB9/t;", "<init>", "()V", "Lie/H;", "updateDefaultEdgeMargin", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "data", "", "position", "playDjPlaylist", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)V", "clickBody", "longClickBody", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)Z", "clickThumbnail", "START_INDEX", "I", "PAGE_SIZE", "", "edgeMargin", "F", "Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$GridSpacingItemDecoration;", "gridSpacingItemDecoration", "Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$GridSpacingItemDecoration;", "getGridSpanCount", "()I", "gridSpanCount", "Companion", "InnerAdapter", "HeaderViewHolder", "ItemViewHolder", "GridSpacingItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonChartThemeFragment extends MetaContentBaseFragment implements t {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\fH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$Companion;", "", "<init>", "()V", "TAG", "", "SPAN_COUNT", "", "SPAN_COUNT_LAND", "ITEM_SPACING", "LOG_LAYER_RES_ID", "newInstance", "Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonChartThemeFragment newInstance() {
            return new MelonChartThemeFragment();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/r0;", "", "spanCount", "spacingDip", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment;II)V", "Lie/H;", "setSpanCount", "(I)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "I", "spacingPixel", "bottomMargin", "headerMargin", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GridSpacingItemDecoration extends r0 {
        private final int bottomMargin;
        private final int headerMargin;
        private final int spacingPixel;
        private int spanCount;

        public GridSpacingItemDecoration(int v, int v1) {
            this.spanCount = v;
            this.bottomMargin = ScreenUtils.dipToPixel(melonChartThemeFragment0.getContext(), 20.0f);
            this.headerMargin = ScreenUtils.dipToPixel(melonChartThemeFragment0.getContext(), 6.0f);
            this.spacingPixel = ScreenUtils.dipToPixel(melonChartThemeFragment0.getContext(), ((float)v1));
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            j0 j00 = MelonChartThemeFragment.this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartThemeFragment.InnerAdapter");
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(((InnerAdapter)j00).isReservedPosition(v)) {
                return;
            }
            int v1 = v - ((InnerAdapter)j00).getHeaderCount();
            if(v1 < 0) {
                rect0.top = this.headerMargin;
                rect0.bottom = this.headerMargin;
                rect0.left = this.spacingPixel;
                rect0.right = this.spacingPixel;
                return;
            }
            int v2 = this.spanCount;
            int v3 = v1 % v2;
            rect0.left = this.spacingPixel - v3 * this.spacingPixel / v2;
            rect0.right = (v3 + 1) * this.spacingPixel / v2;
            rect0.bottom = this.bottomMargin;
        }

        public final void setSpanCount(int v) {
            this.spanCount = v;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/h3;", "binding", "<init>", "(LJ8/h3;)V", "bind", "LJ8/h3;", "getBind", "()LJ8/h3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class HeaderViewHolder extends O0 {
        @NotNull
        private final h3 bind;

        public HeaderViewHolder(@NotNull h3 h30) {
            q.g(h30, "binding");
            super(h30.a);
            this.bind = h30;
        }

        @NotNull
        public final h3 getBind() {
            return this.bind;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ)\u0010\u001B\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER$\u0010!\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001A\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$InnerAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/ChartThemeListRes$RESPONSE$THEMEINFO$THEMELIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$ItemViewHolder;", "vh", "Lie/H;", "initViewHolder", "(Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$ItemViewHolder;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_ITEM", "LB9/t;", "listener", "LB9/t;", "getListener", "()LB9/t;", "setListener", "(LB9/t;)V", "", "titleText", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "Lcom/melon/net/res/common/LinkInfoBase;", "chartInfoData", "Lcom/melon/net/res/common/LinkInfoBase;", "getChartInfoData", "()Lcom/melon/net/res/common/LinkInfoBase;", "setChartInfoData", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerAdapter extends p {
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_ITEM;
        @Nullable
        private LinkInfoBase chartInfoData;
        @Nullable
        private t listener;
        @Nullable
        private String titleText;

        public InnerAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonChartThemeFragment.this = melonChartThemeFragment0;
            super(context0, list0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_ITEM = 2;
        }

        public static void a(MelonChartThemeFragment melonChartThemeFragment0, THEMELIST chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, int v, View view0) {
            InnerAdapter.onBindViewImpl$lambda$4(melonChartThemeFragment0, chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v, view0);
        }

        public static void b(MelonChartThemeFragment melonChartThemeFragment0, THEMELIST chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, int v, View view0) {
            InnerAdapter.onBindViewImpl$lambda$5(melonChartThemeFragment0, chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v, view0);
        }

        @Nullable
        public final LinkInfoBase getChartInfoData() {
            return this.chartInfoData;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_HEADER : this.VIEW_TYPE_ITEM;
        }

        @Nullable
        public final t getListener() {
            return this.listener;
        }

        @Nullable
        public final String getTitleText() {
            return this.titleText;
        }

        private final void initViewHolder(ItemViewHolder melonChartThemeFragment$ItemViewHolder0) {
            ((MelonImageView)melonChartThemeFragment$ItemViewHolder0.getBind().c.c).setImageDrawable(null);
            melonChartThemeFragment$ItemViewHolder0.getBind().d.setText("");
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof HeaderViewHolder) {
                ((HeaderViewHolder)o00).getBind().c.setText(this.titleText);
                ((HeaderViewHolder)o00).getBind().b.setVisibility((this.chartInfoData == null || !this.chartInfoData.isLinkable() ? 8 : 0));
                return;
            }
            if(o00 instanceof ItemViewHolder) {
                THEMELIST chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0 = (THEMELIST)this.getItem(v1);
                if(chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0 != null) {
                    this.initViewHolder(((ItemViewHolder)o00));
                    chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0.plylsttitle = chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0.djplylstSumm;
                    Context context0 = this.getContext();
                    if(context0 != null) {
                        Glide.with(context0).load(chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0.thumbimg).into(((MelonImageView)((ItemViewHolder)o00).getBind().c.c));
                    }
                    ((ItemViewHolder)o00).getBind().d.setText(chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0.plylsttitle);
                    K k0 = new K(MelonChartThemeFragment.this, chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v1, 0);
                    ((ItemViewHolder)o00).getBind().a.setOnClickListener(k0);
                    K k1 = new K(MelonChartThemeFragment.this, chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v1, 1);
                    ((ItemViewHolder)o00).getBind().b.setOnClickListener(k1);
                }
            }
        }

        private static final void onBindViewImpl$lambda$4(MelonChartThemeFragment melonChartThemeFragment0, THEMELIST chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, int v, View view0) {
            melonChartThemeFragment0.clickBody(chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v);
        }

        private static final void onBindViewImpl$lambda$5(MelonChartThemeFragment melonChartThemeFragment0, THEMELIST chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, int v, View view0) {
            melonChartThemeFragment0.playDjPlaylist(chartThemeListRes$RESPONSE$THEMEINFO$THEMELIST0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = o.e(viewGroup0, 0x7F0D0880, viewGroup0, false);  // layout:title_with_info
                int v1 = 0x7F0A0575;  // id:info
                MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0575);  // id:info
                if(melonTextView0 != null) {
                    v1 = 0x7F0A0B8D;  // id:title
                    MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0B8D);  // id:title
                    if(melonTextView1 != null) {
                        O0 o00 = new HeaderViewHolder(new h3(((LinearLayout)view0), melonTextView0, melonTextView1));
                        h3 h30 = ((HeaderViewHolder)o00).getBind();
                        j j0 = new j(this, 2);
                        h30.b.setOnClickListener(j0);
                        return o00;
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }
            View view1 = o.e(viewGroup0, 0x7F0D04A0, viewGroup0, false);  // layout:listitem_playlist_thumb
            int v2 = 0x7F0A064B;  // id:iv_logo_m
            if(((ImageView)I.C(view1, 0x7F0A064B)) != null) {  // id:iv_logo_m
                v2 = 0x7F0A065F;  // id:iv_play
                View view2 = I.C(view1, 0x7F0A065F);  // id:iv_play
                if(((ImageView)view2) != null) {
                    v2 = 0x7F0A0939;  // id:playlist_thumb_container
                    View view3 = I.C(view1, 0x7F0A0939);  // id:playlist_thumb_container
                    if(view3 != null) {
                        b b0 = b.c(view3);
                        v2 = 0x7F0A0CE4;  // id:tv_playlist_title
                        View view4 = I.C(view1, 0x7F0A0CE4);  // id:tv_playlist_title
                        if(((MelonTextView)view4) != null) {
                            v2 = 0x7F0A0D22;  // id:tv_tag
                            View view5 = I.C(view1, 0x7F0A0D22);  // id:tv_tag
                            if(((MelonTextView)view5) != null) {
                                return new ItemViewHolder(new c2(((LinearLayout)view1), ((ImageView)view2), b0, ((MelonTextView)view4), ((MelonTextView)view5)));
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v2));
        }

        private static final void onCreateViewHolderImpl$lambda$2$lambda$1(InnerAdapter melonChartThemeFragment$InnerAdapter0, View view0) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            LinkInfoBase linkInfoBase0 = melonChartThemeFragment$InnerAdapter0.chartInfoData;
            String s = null;
            melonLinkInfo0.b = linkInfoBase0 == null ? null : linkInfoBase0.linkurl;
            if(linkInfoBase0 != null) {
                s = linkInfoBase0.linktype;
            }
            melonLinkInfo0.a = s;
            MelonLinkExecutor.open(melonLinkInfo0);
        }

        public final void setChartInfoData(@Nullable LinkInfoBase linkInfoBase0) {
            this.chartInfoData = linkInfoBase0;
        }

        public final void setListener(@Nullable t t0) {
            this.listener = t0;
        }

        public final void setTitleText(@Nullable String s) {
            this.titleText = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartThemeFragment$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/c2;", "binding", "<init>", "(LJ8/c2;)V", "bind", "LJ8/c2;", "getBind", "()LJ8/c2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ItemViewHolder extends O0 {
        @NotNull
        private final c2 bind;

        public ItemViewHolder(@NotNull c2 c20) {
            q.g(c20, "binding");
            super(c20.a);
            this.bind = c20;
            q.f(c20.e, "tvTag");
            c20.e.setVisibility(8);
            c20.d.setLines(2);
        }

        @NotNull
        public final c2 getBind() {
            return this.bind;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int ITEM_SPACING = 12;
    private static final int LOG_LAYER_RES_ID = 0x7F130E1D;  // string:tiara_common_layer1_theme_list "테마리스트"
    private final int PAGE_SIZE;
    private static final int SPAN_COUNT = 2;
    private static final int SPAN_COUNT_LAND = 4;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MelonChartThemeFragment";
    private final float edgeMargin;
    private GridSpacingItemDecoration gridSpacingItemDecoration;

    static {
        MelonChartThemeFragment.Companion = new Companion(null);
        MelonChartThemeFragment.$stable = 8;
    }

    public MelonChartThemeFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.edgeMargin = 8.0f;
    }

    @Override  // B9.t
    public void clickBody(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
        if(djPlayListInfoBase0 != null) {
            String s = djPlayListInfoBase0.plylstseq;
            if(s != null) {
                Navigator.openDjPlaylistDetail(s);
            }
        }
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            Context context0 = this.getContext();
            String s1 = this.getString(0x7F130E1D);  // string:tiara_common_layer1_theme_list "테마리스트"
            q.f(s1, "getString(...)");
            ActionKind actionKind0 = ActionKind.ClickContent;
            String s2 = null;
            String s3 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq;
            String s4 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylsttitle;
            if(djPlayListInfoBase0 != null) {
                s2 = djPlayListInfoBase0.ownernickname;
            }
            com.google.firebase.b.O(f0, context0, null, s1, actionKind0, null, v, s3, null, s4, s2, null, false, 0, 7314);
        }
    }

    @Override  // B9.t
    public void clickThumbnail(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
        String s = null;
        Navigator.openDjPlaylistDetail((djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq));
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            Context context0 = this.getContext();
            String s1 = this.getString(0x7F130E1D);  // string:tiara_common_layer1_theme_list "테마리스트"
            q.f(s1, "getString(...)");
            ActionKind actionKind0 = ActionKind.ClickContent;
            String s2 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq;
            String s3 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylsttitle;
            if(djPlayListInfoBase0 != null) {
                s = djPlayListInfoBase0.ownernickname;
            }
            com.google.firebase.b.O(f0, context0, null, s1, actionKind0, null, v, s2, null, s3, s, null, false, 0, 7314);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new InnerAdapter(this, context0, null);
        ((InnerAdapter)j00).setListener(this);
        return j00;
    }

    public static void d0(MelonChartThemeFragment melonChartThemeFragment0, i i0, ChartThemeListRes chartThemeListRes0) {
        MelonChartThemeFragment.onFetchStart$lambda$3(melonChartThemeFragment0, i0, chartThemeListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.p0.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    // 去混淆评级： 低(20)
    private final int getGridSpanCount() {
        return ScreenUtils.isPortrait(this.getContext()) ? 2 : 4;
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.I = this.mMelonTiaraProperty.c;
        return f0;
    }

    @Override  // B9.t
    public boolean longClickBody(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
        return true;
    }

    @NotNull
    public static final MelonChartThemeFragment newInstance() {
        return MelonChartThemeFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(this.getRecyclerView() != null) {
            if(configuration0.orientation == 2) {
                w0 w00 = this.getRecyclerView().getLayoutManager();
                q.e(w00, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                ((GridLayoutManager)w00).P(4);
                GridSpacingItemDecoration melonChartThemeFragment$GridSpacingItemDecoration0 = this.gridSpacingItemDecoration;
                if(melonChartThemeFragment$GridSpacingItemDecoration0 != null) {
                    melonChartThemeFragment$GridSpacingItemDecoration0.setSpanCount(4);
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                q.m("gridSpacingItemDecoration");
                throw null;
            }
            w0 w01 = this.getRecyclerView().getLayoutManager();
            q.e(w01, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager)w01).P(2);
            GridSpacingItemDecoration melonChartThemeFragment$GridSpacingItemDecoration1 = this.gridSpacingItemDecoration;
            if(melonChartThemeFragment$GridSpacingItemDecoration1 != null) {
                melonChartThemeFragment$GridSpacingItemDecoration1.setSpanCount(2);
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            q.m("gridSpacingItemDecoration");
            throw null;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).getContext();
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getGridSpanCount());
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                j0 j00 = gridLayoutManager0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melonchart.MelonChartThemeFragment.InnerAdapter");
                return ((InnerAdapter)j00).isReservedPosition(v) || v - ((InnerAdapter)j00).getHeaderCount() < 0 ? this.$this_apply.b : 1;
            }
        };
        ((RecyclerView)view0).setLayoutManager(gridLayoutManager0);
        ((RecyclerView)view0).setHasFixedSize(true);
        GridSpacingItemDecoration melonChartThemeFragment$GridSpacingItemDecoration0 = new GridSpacingItemDecoration(this, this.getGridSpanCount(), 12);
        this.gridSpacingItemDecoration = melonChartThemeFragment$GridSpacingItemDecoration0;
        ((RecyclerView)view0).addItemDecoration(melonChartThemeFragment$GridSpacingItemDecoration0);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02A9, viewGroup0, false);  // layout:fragment_detail_basic
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        int v;
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        Params chartThemeListReq$Params0 = new Params();
        if(i0.equals(i.b)) {
            v = this.START_INDEX;
        }
        else {
            InnerAdapter melonChartThemeFragment$InnerAdapter0 = this.mAdapter instanceof InnerAdapter ? ((InnerAdapter)this.mAdapter) : null;
            v = melonChartThemeFragment$InnerAdapter0 == null ? this.START_INDEX : melonChartThemeFragment$InnerAdapter0.getCount() + this.START_INDEX;
        }
        chartThemeListReq$Params0.startIndex = v;
        chartThemeListReq$Params0.pageSize = this.PAGE_SIZE;
        RequestBuilder.newInstance(new ChartThemeListReq(this.getContext(), chartThemeListReq$Params0)).tag(this.getRequestTag()).listener(new J(this, i0, 3)).errorListener(new l(this, 2)).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(MelonChartThemeFragment melonChartThemeFragment0, i i0, ChartThemeListRes chartThemeListRes0) {
        if(!melonChartThemeFragment0.prepareFetchComplete(chartThemeListRes0)) {
            return;
        }
        if(chartThemeListRes0 != null) {
            RESPONSE chartThemeListRes$RESPONSE0 = chartThemeListRes0.response;
            if(chartThemeListRes$RESPONSE0 != null) {
                InnerAdapter melonChartThemeFragment$InnerAdapter0 = melonChartThemeFragment0.mAdapter instanceof InnerAdapter ? ((InnerAdapter)melonChartThemeFragment0.mAdapter) : null;
                if(melonChartThemeFragment$InnerAdapter0 != null) {
                    melonChartThemeFragment$InnerAdapter0.setTitleText((chartThemeListRes$RESPONSE0.themeInfo == null ? null : chartThemeListRes$RESPONSE0.themeInfo.themeManageTitle));
                    melonChartThemeFragment$InnerAdapter0.setChartInfoData(chartThemeListRes$RESPONSE0.chartInfo);
                    melonChartThemeFragment$InnerAdapter0.setHasMore(chartThemeListRes0.hasMore());
                }
                melonChartThemeFragment0.mMelonTiaraProperty = new s(chartThemeListRes$RESPONSE0.section, chartThemeListRes$RESPONSE0.page, chartThemeListRes$RESPONSE0.menuId, null);
            }
        }
        melonChartThemeFragment0.performFetchComplete(i0, chartThemeListRes0);
    }

    private static final void onFetchStart$lambda$4(MelonChartThemeFragment melonChartThemeFragment0, VolleyError volleyError0) {
        melonChartThemeFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        this.updateDefaultEdgeMargin();
    }

    @Override  // B9.t
    public void playDjPlaylist(@Nullable DjPlayListInfoBase djPlayListInfoBase0, int v) {
        String s = null;
        this.playPlaylist((djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq), (djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.contsTypeCode), this.getMenuId(), (djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.statsElements));
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            Context context0 = this.getContext();
            String s1 = this.getString(0x7F130E1D);  // string:tiara_common_layer1_theme_list "테마리스트"
            q.f(s1, "getString(...)");
            ActionKind actionKind0 = ActionKind.PlayMusic;
            String s2 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylstseq;
            String s3 = djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylsttitle;
            if(djPlayListInfoBase0 != null) {
                s = djPlayListInfoBase0.ownernickname;
            }
            com.google.firebase.b.O(f0, context0, null, s1, actionKind0, null, v, s2, null, s3, s, null, false, 0, 7314);
        }
    }

    private final void updateDefaultEdgeMargin() {
        int v = ScreenUtils.dipToPixel(this.getContext(), this.edgeMargin);
        RecyclerView recyclerView0 = this.getRecyclerView();
        if(recyclerView0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = recyclerView0.getLayoutParams();
            if(viewGroup$LayoutParams0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin = v;
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = v;
            recyclerView0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
        }
    }
}

