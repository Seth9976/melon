package com.iloen.melon.fragments.melontv;

import U4.x;
import a9.d;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.iloen.melon.adapters.MelonTvAdapter;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MelonTvPopListReq.ParamInfo;
import com.iloen.melon.net.v4x.request.MelonTvPopListReq;
import com.iloen.melon.net.v4x.response.MelonTvPopListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.h;
import v9.i;

public class MelonTvPopularFragment extends MelonTvBaseFragment {
    class MvItemDecoration extends r0 {
        private int spacingPixel;

        public MvItemDecoration() {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvPopularFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            PopularAdapter melonTvPopularFragment$PopularAdapter0 = (PopularAdapter)MelonTvPopularFragment.this.mAdapter;
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(!melonTvPopularFragment$PopularAdapter0.isReservedPosition(v) && melonTvPopularFragment$PopularAdapter0.getItemViewType(v) != 10) {
                String s = MelonTvPopularFragment.this.getDeviceUiType();
                s.getClass();
                if(s.equals("tabletLandscape")) {
                    int v2 = (v - 1) % 3;
                    rect0.left = this.spacingPixel - v2 * this.spacingPixel / 3;
                    rect0.right = (v2 + 1) * this.spacingPixel / 3;
                }
                else if(!s.equals("mobilePortrait")) {
                    int v1 = (v + 1) % 2;
                    rect0.left = this.spacingPixel - v1 * this.spacingPixel / 2;
                    rect0.right = (v1 + 1) * this.spacingPixel / 2;
                }
                else {
                    rect0.left = this.spacingPixel;
                    rect0.right = this.spacingPixel;
                }
                StringBuilder stringBuilder0 = x.n(v, "GridSpacingItemDecoration >> [position: ", " ] >> left: ");
                stringBuilder0.append(rect0.left);
                stringBuilder0.append(", right: ");
                Z.s(rect0.right, "MelonTvPopularFragment", stringBuilder0);
            }
        }
    }

    class PopularAdapter extends MelonTvAdapter {
        class SortViewHolder extends O0 {
            private SortingBarView mSortingBarView;

            public SortViewHolder(View view0) {
                super(view0);
                SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                this.mSortingBarView = sortingBarView0;
                sortingBarView0.setSortBarStyle(2);
                this.mSortingBarView.setItems(melonTvPopularFragment$PopularAdapter0.getContext().getResources().getStringArray(0x7F030042));  // array:sortingbar_melontv_popular
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D6B), true);  // id:underline
            }

            public static SortingBarView a(SortViewHolder melonTvPopularFragment$PopularAdapter$SortViewHolder0) {
                return melonTvPopularFragment$PopularAdapter$SortViewHolder0.mSortingBarView;
            }
        }

        private static final int VIEW_TYPE_HEADER = 10;
        private static final int VIEW_TYPE_ITEM = 1;
        private static final int VIEW_TYPE_ITEM_LAND = 2;

        public PopularAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 10 : super.getItemViewTypeImpl(v, v1);
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00 instanceof SortViewHolder) {
                LogU.d("MelonTvPopularFragment", "onBindViewImpl = " + MelonTvPopularFragment.this.mOrderBy);
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(null);
                SortViewHolder.a(((SortViewHolder)o00)).setSelection(MelonTvPopularFragment.this.mCurrentSortPosition);
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(new d() {
                    @Override  // a9.d
                    public void onSelected(int v) {
                        MelonTvPopularFragment.this.mCurrentSortPosition = v;
                        MelonTvPopularFragment.this.setOrderBy(MelonTvPopularFragment.this.mCurrentSortPosition);
                        MelonTvPopularFragment.this.startFetch();
                    }
                });
                return;
            }
            super.onBindViewImpl(o00, v, v1);
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 10 ? new SortViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D085D, viewGroup0, false)) : super.onCreateViewHolderImpl(viewGroup0, v);  // layout:sortbar_view
        }
    }

    private static final String ARG_ORDER_BY = "argOrderBy";
    private static final int PAGE_SIZE = 20;
    public static final int SORT_ALL = 0;
    public static final int SORT_MV = 1;
    public static final int SORT_ORIGINAL = 2;
    private static final int START_INDEX = 1;
    private static final String TAG = "MelonTvPopularFragment";
    private int mCurrentSortPosition;
    private int mOrderBy;
    private MvItemDecoration mvItemDecoration;

    public MelonTvPopularFragment() {
        this.mCurrentSortPosition = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new PopularAdapter(this, context0, null);
        ((j)j00).setListContentType(3);
        ((MelonTvAdapter)j00).setOnInfoBtnClick(new com.iloen.melon.fragments.melontv.d(this, 2));
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("popular").build().toString();
    }

    private int getStartIndex(i i0) {
        if(i.c.equals(i0)) {
            return this.mAdapter instanceof PopularAdapter ? ((PopularAdapter)this.mAdapter).getCount() + 1 : 1;
        }
        return 1;
    }

    private void lambda$createRecyclerViewAdapter$1(Playable playable0) {
        this.showContextPopupMv(playable0);
    }

    private void lambda$onFetchStart$0(i i0, MelonTvPopListRes melonTvPopListRes0) {
        if(!this.prepareFetchComplete(melonTvPopListRes0)) {
            return;
        }
        this.performFetchComplete(i0, melonTvPopListRes0);
    }

    public static MelonTvPopularFragment newInstance() {
        return MelonTvPopularFragment.newInstance(0);
    }

    public static MelonTvPopularFragment newInstance(int v) {
        MelonTvPopularFragment melonTvPopularFragment0 = new MelonTvPopularFragment();
        Bundle bundle0 = new Bundle();
        if(v == 1) {
            bundle0.putInt("argOrderBy", 1);
        }
        else if(v == 2) {
            bundle0.putInt("argOrderBy", 2);
        }
        else {
            bundle0.putInt("argOrderBy", 0);
        }
        melonTvPopularFragment0.setArguments(bundle0);
        return melonTvPopularFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 6);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                if(MelonTvPopularFragment.this.mAdapter instanceof PopularAdapter && MelonTvPopularFragment.this.mAdapter.getItemViewType(v) != 10) {
                    switch(MelonTvPopularFragment.this.getDeviceUiType()) {
                        case "mobileLandscape": {
                            return 3;
                        }
                        case "mobilePortrait": {
                            return 6;
                        }
                        case "tabletLandscape": {
                            return 2;
                        }
                        case "tabletPortrait": {
                            return 3;
                        }
                        default: {
                            return 6;
                        }
                    }
                }
                return 6;
            }
        };
        recyclerView0.setLayoutManager(gridLayoutManager0);
        MvItemDecoration melonTvPopularFragment$MvItemDecoration0 = new MvItemDecoration(this);
        this.mvItemDecoration = melonTvPopularFragment$MvItemDecoration0;
        recyclerView0.addItemDecoration(melonTvPopularFragment$MvItemDecoration0);
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D04F3, viewGroup0, false);  // layout:melontv_popular
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        ParamInfo melonTvPopListReq$ParamInfo0 = new ParamInfo();
        melonTvPopListReq$ParamInfo0.menuSeq = this.mOrderBy;
        melonTvPopListReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        melonTvPopListReq$ParamInfo0.pageSize = 20;
        RequestBuilder.newInstance(new MelonTvPopListReq(this.getContext(), melonTvPopListReq$ParamInfo0)).tag("MelonTvPopularFragment").listener(new b(this, i0, 3)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        int v = bundle0.getInt("argOrderBy");
        this.mCurrentSortPosition = v;
        this.setOrderBy(v);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt("argOrderBy", this.mCurrentSortPosition);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
    }

    public void setOrderBy(int v) {
        if(v != 0) {
            switch(v) {
                case 1: {
                    this.mOrderBy = 2;
                    return;
                }
                case 2: {
                    this.mOrderBy = 1;
                    return;
                }
                default: {
                    this.mOrderBy = -1;
                    return;
                }
            }
        }
        this.mOrderBy = -1;
    }
}

