package com.iloen.melon.fragments.comments;

import a9.d;
import android.view.View;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.c;

public class CmtAttachSortbarViewHolder extends CmtBaseViewHolder {
    private static final String TAG = "CmtAttachSortbarViewHolder";
    private SortingBarView mSortingBarView;

    public CmtAttachSortbarViewHolder(View view0, CmtBaseFragment cmtBaseFragment0, String[] arr_s) {
        super(view0, cmtBaseFragment0);
        ViewUtils.showWhen(view0.findViewById(0x7F0A0D6B), false);  // id:underline
        ViewUtils.showWhen(view0.findViewById(0x7F0A0D6D), false);  // id:underline_short
        SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.mSortingBarView = sortingBarView0;
        if(sortingBarView0 != null && arr_s != null && arr_s.length >= 2) {
            sortingBarView0.setItems(arr_s);
            if(arr_s.length == 2) {
                this.mSortingBarView.setSortBarStyle(1);
            }
            else if(arr_s.length == 3) {
                this.mSortingBarView.setSortBarStyle(2);
            }
            this.mSortingBarView.setSelection(0);
            ViewUtils.showWhen(view0, true);
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
    }

    public CmtAttachFragment getFragment() {
        return (CmtAttachFragment)super.getFragment();
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseViewHolder
    public CmtBaseFragment getFragment() {
        return this.getFragment();
    }

    public static int getLayoutRsId() {
        return CmtAttachSortbarViewHolder.getLayoutRsId(c.a);
    }

    public static int getLayoutRsId(c c0) {
        LogU.d("CmtAttachSortbarViewHolder", "Layout theme = " + c0);
        return 0x7F0D085D;  // layout:sortbar_view
    }

    public void setOnSortSelectionListener(d d0) {
        this.mSortingBarView.setOnSortSelectionListener(d0);
    }

    public void setVisibility(int v) {
        View view0 = this.itemView;
        if(view0 != null) {
            view0.setVisibility(v);
        }
    }
}

