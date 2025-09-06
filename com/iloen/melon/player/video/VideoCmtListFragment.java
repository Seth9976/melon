package com.iloen.melon.player.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.B;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.CmtListFragment;
import com.iloen.melon.utils.log.LogU;
import kc.d3;

public class VideoCmtListFragment extends CmtListFragment {
    public static final String TAG = "VideoCmtListFragment";

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean ignoreUpdateVideoScreen() {
        return true;
    }

    public static VideoCmtListFragment newInstance(Param cmtListFragment$Param0) {
        VideoCmtListFragment videoCmtListFragment0 = new VideoCmtListFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argCmtParam", cmtListFragment$Param0);
        videoCmtListFragment0.setArguments(bundle0);
        return videoCmtListFragment0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LogU.d("VideoCmtListFragment", "onCreateView");
        if(((d3)this.playlistManager).f() != null && false && this.mParam.contsRefValue != "") {
            String s = this.getCacheKey();
            Object object0 = this.getContentAdapter();
            if(object0 instanceof B) {
                ((B)object0).removeResponse(s);
            }
            this.updateCmtAllCount(0);
            this.mParam.contsRefValue = "";
        }
        return super.onCreateView(layoutInflater0, viewGroup0, bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void setScrollBottomMargin(boolean z) {
        if(this.isToolBarShowing()) {
            super.setScrollBottomMargin(z);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetOrientation() {
        return true;
    }
}

