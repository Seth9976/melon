package com.iloen.melon.fragments.melontv;

import U4.x;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.iloen.melon.net.v4x.request.MelonTvMvListReq.ParamInfo;
import com.iloen.melon.net.v4x.request.MelonTvMvListReq;
import com.iloen.melon.net.v4x.response.MelonTvMvListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.h;
import v9.i;

public class MelonTvMusicVideoFragment extends MelonTvBaseFragment {
    public static class MusicVideoAdapter extends MelonTvAdapter {
        public interface OnClickListener {
            void onSortBarClick(String arg1);
        }

        public class SortViewHolder extends O0 {
            private SortingBarView sortingBarView;

            public SortViewHolder(Context context0, View view0) {
                super(view0);
                SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                this.sortingBarView = sortingBarView0;
                sortingBarView0.setSortBarStyle(2);
                this.sortingBarView.setItems(melonTvMusicVideoFragment$MusicVideoAdapter0.getContext().getResources().getStringArray(0x7F030041));  // array:sortingbar_melontv_mv
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D6B), true);  // id:underline
            }

            public static SortingBarView a(SortViewHolder melonTvMusicVideoFragment$MusicVideoAdapter$SortViewHolder0) {
                return melonTvMusicVideoFragment$MusicVideoAdapter$SortViewHolder0.sortingBarView;
            }
        }

        private static final int VIEW_TYPE_HEADER = 10;
        private static final int VIEW_TYPE_ITEM = 1;
        private static final int VIEW_TYPE_ITEM_LAND = 2;
        private OnClickListener mClickListener;
        private String mOrderBy;

        public MusicVideoAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 10 : super.getItemViewTypeImpl(v, v1);
        }

        private int getSortPosition() {
            if(TextUtils.isEmpty(this.mOrderBy)) {
                this.mOrderBy = "AM0001";
            }
            if("AM0002".equals(this.mOrderBy)) {
                return 1;
            }
            return "AM0003".equals(this.mOrderBy) ? 2 : 0;
        }

        private void lambda$onBindViewImpl$0(int v) {
            if(v == 0) {
                this.mOrderBy = "AM0001";
            }
            else {
                switch(v) {
                    case 1: {
                        this.mOrderBy = "AM0002";
                        break;
                    }
                    case 2: {
                        this.mOrderBy = "AM0003";
                        break;
                    }
                    default: {
                        LogU.e("MelonTvMusicVideoFragment", "Invalid sort position");
                        return;
                    }
                }
            }
            OnClickListener melonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener0 = this.mClickListener;
            if(melonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener0 != null) {
                melonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener0.onSortBarClick(this.mOrderBy);
            }
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00 instanceof SortViewHolder) {
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(null);
                SortViewHolder.a(((SortViewHolder)o00)).setSelection(this.getSortPosition());
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(new d(this, 0));
                return;
            }
            super.onBindViewImpl(o00, v, v1);
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 10 ? new SortViewHolder(this, this.getContext(), LayoutInflater.from(this.getContext()).inflate(0x7F0D085D, viewGroup0, false)) : super.onCreateViewHolderImpl(viewGroup0, v);  // layout:sortbar_view
        }

        public void setOnClickListener(OnClickListener melonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener0) {
            this.mClickListener = melonTvMusicVideoFragment$MusicVideoAdapter$OnClickListener0;
        }

        public void setOrderBy(String s) {
            this.mOrderBy = s;
            this.notifyItemChanged(this.getAvailableHeaderPosition());
        }
    }

    class MvItemDecoration extends r0 {
        private int spacingPixel;

        public MvItemDecoration() {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvMusicVideoFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            MusicVideoAdapter melonTvMusicVideoFragment$MusicVideoAdapter0 = (MusicVideoAdapter)MelonTvMusicVideoFragment.this.mAdapter;
            int v = recyclerView0.getChildAdapterPosition(view0);
            if(!melonTvMusicVideoFragment$MusicVideoAdapter0.isReservedPosition(v) && melonTvMusicVideoFragment$MusicVideoAdapter0.getItemViewType(v) != 10) {
                String s = MelonTvMusicVideoFragment.this.getDeviceUiType();
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
                Z.s(rect0.right, "MelonTvMusicVideoFragment", stringBuilder0);
            }
        }
    }

    private static final String ARG_ORDER_BY = "argOrderBy";
    private static final String DEFAULT_ORDER_BY = "AM0001";
    private static final int PAGE_SIZE = 20;
    private static final int SORT_DOMESTIC = 0;
    private static final int SORT_OST = 2;
    private static final int SORT_OVERSEA = 1;
    private static final int START_INDEX = 1;
    private static final String TAG = "MelonTvMusicVideoFragment";
    private String mOrderBy;
    private MvItemDecoration mvItemDecoration;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new MusicVideoAdapter(context0, null);
        ((j)j00).setListContentType(3);
        ((MelonTvAdapter)j00).setOnInfoBtnClick(new c(this));
        ((MusicVideoAdapter)j00).setOnClickListener(new c(this));
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("musicVideo").build().toString();
    }

    private int getStartIndex(i i0) {
        if(i.c.equals(i0)) {
            return this.mAdapter instanceof MusicVideoAdapter ? ((MusicVideoAdapter)this.mAdapter).getCount() + 1 : 1;
        }
        return 1;
    }

    private void lambda$createRecyclerViewAdapter$1(Playable playable0) {
        this.showContextPopupMv(playable0);
    }

    private void lambda$createRecyclerViewAdapter$2(String s) {
        this.mOrderBy = s;
        this.startFetch();
    }

    private void lambda$onFetchStart$0(i i0, MelonTvMvListRes melonTvMvListRes0) {
        if(!this.prepareFetchComplete(melonTvMvListRes0)) {
            return;
        }
        this.performFetchComplete(i0, melonTvMvListRes0);
    }

    public static MelonTvMusicVideoFragment newInstance() {
        MelonTvMusicVideoFragment melonTvMusicVideoFragment0 = new MelonTvMusicVideoFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argOrderBy", "AM0001");
        melonTvMusicVideoFragment0.setArguments(bundle0);
        return melonTvMusicVideoFragment0;
    }

    public static MelonTvMusicVideoFragment newInstance(int v) {
        MelonTvMusicVideoFragment melonTvMusicVideoFragment0 = new MelonTvMusicVideoFragment();
        Bundle bundle0 = new Bundle();
        if(v == 1) {
            bundle0.putString("argOrderBy", "AM0002");
        }
        else if(v == 2) {
            bundle0.putString("argOrderBy", "AM0003");
        }
        else {
            bundle0.putString("argOrderBy", "AM0001");
        }
        melonTvMusicVideoFragment0.setArguments(bundle0);
        return melonTvMusicVideoFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 6);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                if(MelonTvMusicVideoFragment.this.mAdapter instanceof MusicVideoAdapter && MelonTvMusicVideoFragment.this.mAdapter.getItemViewType(v) != 10) {
                    switch(MelonTvMusicVideoFragment.this.getDeviceUiType()) {
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
        MvItemDecoration melonTvMusicVideoFragment$MvItemDecoration0 = new MvItemDecoration(this);
        this.mvItemDecoration = melonTvMusicVideoFragment$MvItemDecoration0;
        recyclerView0.addItemDecoration(melonTvMusicVideoFragment$MvItemDecoration0);
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D04FD, viewGroup0, false);  // layout:melontv_today
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        ParamInfo melonTvMvListReq$ParamInfo0 = new ParamInfo();
        melonTvMvListReq$ParamInfo0.classCode = this.mOrderBy;
        melonTvMvListReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        melonTvMvListReq$ParamInfo0.pageSize = 20;
        RequestBuilder.newInstance(new MelonTvMvListReq(this.getContext(), melonTvMvListReq$ParamInfo0)).tag("MelonTvMusicVideoFragment").listener(new b(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mOrderBy = bundle0.getString("argOrderBy");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argOrderBy", this.mOrderBy);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        j0 j00 = this.mAdapter;
        if(j00 instanceof MusicVideoAdapter) {
            ((MusicVideoAdapter)j00).setOrderBy(this.mOrderBy);
        }
    }
}

