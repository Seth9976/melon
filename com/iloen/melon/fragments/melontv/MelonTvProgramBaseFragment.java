package com.iloen.melon.fragments.melontv;

import U4.x;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.system.ScreenUtils;
import n8.i;

public abstract class MelonTvProgramBaseFragment extends MelonTvBaseFragment {
    class MvItemDecoration extends r0 {
        private int spacingPixel;

        public MvItemDecoration() {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvProgramBaseFragment0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            i i0 = (i)MelonTvProgramBaseFragment.this.mAdapter;
            int v = recyclerView0.getChildAdapterPosition(view0);
            int v1 = i0.getItemViewType(v);
            if(!i0.isReservedPosition(v) && (v1 != 10 && v1 != 11 && v1 != 14)) {
                String s = MelonTvProgramBaseFragment.this.getDeviceUiType();
                s.getClass();
                if(s.equals("tabletLandscape")) {
                    if(i0.a) {
                        --v;
                    }
                    int v2 = (v - 2) % 3;
                    rect0.left = this.spacingPixel - v2 * this.spacingPixel / 3;
                    rect0.right = (v2 + 1) * this.spacingPixel / 3;
                }
                else if(!s.equals("mobilePortrait")) {
                    if(i0.a) {
                        ++v;
                    }
                    rect0.left = this.spacingPixel - v % 2 * this.spacingPixel / 2;
                    rect0.right = (v % 2 + 1) * this.spacingPixel / 2;
                }
                else {
                    rect0.left = this.spacingPixel;
                    rect0.right = this.spacingPixel;
                }
                StringBuilder stringBuilder0 = x.n(v, "GridSpacingItemDecoration >> [position: ", " ] >> left: ");
                stringBuilder0.append(rect0.left);
                stringBuilder0.append(", right: ");
                Z.s(rect0.right, "MelonTvProgramBaseFragment", stringBuilder0);
            }
        }
    }

    private static final String TAG = "MelonTvProgramBaseFragment";
    private MvItemDecoration mvItemDecoration;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new i(context0, null);  // 初始化器: Lcom/iloen/melon/adapters/common/p;-><init>(Landroid/content/Context;Ljava/util/List;)V
        j00.a = false;
        ScreenUtils.dipToPixel(context0, 50.0f);
        ((j)j00).setListContentType(3);
        j00.b = new f(this);
        j00.d = new f(this);
        return j00;
    }

    public static void d0(MelonTvProgramBaseFragment melonTvProgramBaseFragment0, Playable playable0) {
        melonTvProgramBaseFragment0.lambda$createRecyclerViewAdapter$1(playable0);
    }

    private void lambda$createRecyclerViewAdapter$0() {
        this.showDropDownView();
    }

    private void lambda$createRecyclerViewAdapter$1(Playable playable0) {
        this.showContextPopupMv(playable0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 6);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                switch(((i)MelonTvProgramBaseFragment.this.mAdapter).getItemViewType(v)) {
                    case 10: 
                    case 11: 
                    case 14: {
                        return 6;
                    }
                    default: {
                        switch(MelonTvProgramBaseFragment.this.getDeviceUiType()) {
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
                }
            }
        };
        recyclerView0.setLayoutManager(gridLayoutManager0);
        MvItemDecoration melonTvProgramBaseFragment$MvItemDecoration0 = new MvItemDecoration(this);
        this.mvItemDecoration = melonTvProgramBaseFragment$MvItemDecoration0;
        recyclerView0.addItemDecoration(melonTvProgramBaseFragment$MvItemDecoration0);
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D04F4, viewGroup0, false);  // layout:melontv_program
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onRecyclerViewItemLongClick(j0 j00, View view0, int v, int v1) {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        j0 j00 = this.mAdapter;
        if(j00 instanceof i) {
            ((i)j00).c = "프로그램 바로가기";
            ((i)j00).notifyItemChanged(((i)j00).getAvailableHeaderPosition());
        }
    }

    public void showDropDownView() {
    }
}

