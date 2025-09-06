package com.iloen.melon.fragments.searchandadd;

import a9.d;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.utils.ui.ViewUtils;

public class SearchAndAddSortbarViewHolder extends O0 {
    private SortingBarView mSortingBarView;

    public SearchAndAddSortbarViewHolder(View view0, String[] arr_s) {
        super(view0);
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
        }
    }

    public static int getLayoutRsId() [...] // Inlined contents

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

