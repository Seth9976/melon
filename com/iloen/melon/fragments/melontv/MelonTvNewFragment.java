package com.iloen.melon.fragments.melontv;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.adapters.MelonTvAdapter.ItemViewHolder;
import com.iloen.melon.adapters.MelonTvAdapter;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.request.MelonTvNewMvListReq.ParamInfo;
import com.iloen.melon.net.v5x.request.MelonTvNewMvListReq;
import com.iloen.melon.net.v5x.response.MelonTvNewMvListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;
import d3.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001E\u001A\u00020\u001D2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\u0010H\u0014¢\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014¢\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014¢\u0006\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010,¨\u00061"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment;", "Lcom/iloen/melon/fragments/melontv/MelonTvBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "", "getStartIndex", "(Lv9/i;)I", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "START_INDEX", "I", "PAGE_SIZE", "Companion", "MvItemDecoration", "MelonTvNewAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTvNewFragment extends MelonTvBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonTvNewFragment newInstance() {
            return new MelonTvNewFragment();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001EB\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0014\u001A\u00020\u00132\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u00052\u0006\u0010\f\u001A\u00020\tH\u0014¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment$MelonTvNewAdapter;", "Lcom/iloen/melon/adapters/MelonTvAdapter;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/MvInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/adapters/MelonTvAdapter$ItemViewHolder;", "vh", "info", "Lie/H;", "updateItemView", "(Lcom/iloen/melon/adapters/MelonTvAdapter$ItemViewHolder;Lcom/melon/net/res/common/MvInfoBase;I)V", "VIEW_TYPE_TOP_SPACE", "I", "TopSpaceViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MelonTvNewAdapter extends MelonTvAdapter {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment$MelonTvNewAdapter$TopSpaceViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment$MelonTvNewAdapter;Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class TopSpaceViewHolder extends O0 {
            public TopSpaceViewHolder(@NotNull View view0) {
                q.g(view0, "itemView");
                MelonTvNewAdapter.this = melonTvNewFragment$MelonTvNewAdapter0;
                super(view0);
            }
        }

        private final int VIEW_TYPE_TOP_SPACE;

        public MelonTvNewAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MelonTvNewFragment.this = melonTvNewFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 1;
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? this.VIEW_TYPE_TOP_SPACE : super.getItemViewTypeImpl(v, v1);
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_TOP_SPACE) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0507, viewGroup0, false);  // layout:melontv_top_space
                q.f(view0, "inflate(...)");
                return new TopSpaceViewHolder(this, view0);
            }
            O0 o00 = super.onCreateViewHolderImpl(viewGroup0, v);
            q.f(o00, "onCreateViewHolderImpl(...)");
            return o00;
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public void updateItemView(@NotNull ItemViewHolder melonTvAdapter$ItemViewHolder0, @Nullable MvInfoBase mvInfoBase0, int v) {
            q.g(melonTvAdapter$ItemViewHolder0, "vh");
            super.updateItemView(melonTvAdapter$ItemViewHolder0, mvInfoBase0, v);
            if(mvInfoBase0 != null && mvInfoBase0.canService) {
                e e0 = new e(this, v, mvInfoBase0);
                ViewUtils.setOnClickListener(melonTvAdapter$ItemViewHolder0.itemView, e0);
                return;
            }
            ViewUtils.setOnClickListener(melonTvAdapter$ItemViewHolder0.itemView, null);
        }

        private static final void updateItemView$lambda$0(MelonTvNewAdapter melonTvNewFragment$MelonTvNewAdapter0, int v, MvInfoBase mvInfoBase0, View view0) {
            g.c0("3", melonTvNewFragment$MelonTvNewAdapter0.getMenuId(), "O57", "T01", "V1", String.valueOf(v), ContsTypeCode.VIDEO.code(), mvInfoBase0.mvId, "");
            Navigator.openMvInfo$default(mvInfoBase0.mvId, melonTvNewFragment$MelonTvNewAdapter0.getMenuId(), null, false, 12, null);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment$MvItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "(Lcom/iloen/melon/fragments/melontv/MelonTvNewFragment;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "", "spacingPixel", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MvItemDecoration extends r0 {
        private int spacingPixel;

        public MvItemDecoration() {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvNewFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            int v = recyclerView0.getChildAdapterPosition(view0);
            String s = MelonTvNewFragment.this.getDeviceUiType();
            if(q.b(s, "tabletLandscape")) {
                int v1 = (v - 1) % 3;
                rect0.left = this.spacingPixel - v1 * this.spacingPixel / 3;
                rect0.right = (v1 + 1) * this.spacingPixel / 3;
            }
            else if(q.b(s, "mobilePortrait")) {
                rect0.left = this.spacingPixel;
                rect0.right = this.spacingPixel;
            }
            else {
                int v2 = (v + 1) % 2;
                rect0.left = this.spacingPixel - v2 * this.spacingPixel / 2;
                rect0.right = (v2 + 1) * this.spacingPixel / 2;
            }
            int v3 = rect0.right;
            StringBuilder stringBuilder0 = o.t(v, rect0.left, "GridSpacingItemDecoration >> [position: ", " ] >> left: ", ", right: ");
            stringBuilder0.append(v3);
            LogU.Companion.d("MelonTvNewFragment", stringBuilder0.toString());
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MelonTvNewFragment";

    static {
        MelonTvNewFragment.Companion = new Companion(null);
        MelonTvNewFragment.$stable = 8;
    }

    public MelonTvNewFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new MelonTvNewAdapter(this, context0, null);
        ((j)j00).setListContentType(3);
        ((MelonTvAdapter)j00).setOnInfoBtnClick(new d(this, 1));
        return j00;
    }

    private static final void createRecyclerViewAdapter$lambda$3$lambda$2(MelonTvNewFragment melonTvNewFragment0, Playable playable0) {
        melonTvNewFragment0.showContextPopupMv(playable0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.f.buildUpon().appendPath("newVideo").build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final int getStartIndex(i i0) {
        if(i.c.equals(i0)) {
            j0 j00 = this.mAdapter;
            if(j00 instanceof MelonTvNewAdapter) {
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.melontv.MelonTvNewFragment.MelonTvNewAdapter");
                return ((MelonTvNewAdapter)j00).getCount() + 1;
            }
        }
        return this.START_INDEX;
    }

    @NotNull
    public static final MelonTvNewFragment newInstance() {
        return MelonTvNewFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(((RecyclerView)view0).getContext(), 6);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                if(MelonTvNewFragment.this.mAdapter instanceof MelonTvNewAdapter && (MelonTvNewFragment.this.mAdapter.getItemCount() <= 0 || v != 0)) {
                    String s = MelonTvNewFragment.this.getDeviceUiType();
                    if(s != null) {
                        switch(s.hashCode()) {
                            case 0xA5C91839: {
                                return s.equals("mobileLandscape") ? 3 : 6;
                            }
                            case 0x15C9A6F5: {
                                return s.equals("tabletLandscape") ? 2 : 6;
                            }
                            case 972003361: {
                                return s.equals("tabletPortrait") ? 3 : 6;
                            }
                            case 1465577053: {
                                return 6;
                            }
                            default: {
                                return 6;
                            }
                        }
                    }
                }
                return 6;
            }
        };
        ((RecyclerView)view0).addItemDecoration(new MvItemDecoration(this));
        ((RecyclerView)view0).setLayoutManager(gridLayoutManager0);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D04F2, viewGroup0, false);  // layout:melontv_new
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        ParamInfo melonTvNewMvListReq$ParamInfo0 = new ParamInfo();
        melonTvNewMvListReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        melonTvNewMvListReq$ParamInfo0.pageSize = this.PAGE_SIZE;
        RequestBuilder.newInstance(new MelonTvNewMvListReq(this.getContext(), melonTvNewMvListReq$ParamInfo0)).tag("MelonTvNewFragment").listener(new b(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(MelonTvNewFragment melonTvNewFragment0, i i0, MelonTvNewMvListRes melonTvNewMvListRes0) {
        if(!melonTvNewFragment0.prepareFetchComplete(melonTvNewMvListRes0)) {
            return;
        }
        melonTvNewFragment0.performFetchComplete(i0, melonTvNewMvListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }
}

