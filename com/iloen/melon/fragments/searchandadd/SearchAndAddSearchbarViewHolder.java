package com.iloen.melon.fragments.searchandadd;

import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.V0;

public class SearchAndAddSearchbarViewHolder extends O0 {
    private SearchBarView mSearchBarView;

    public SearchAndAddSearchbarViewHolder(View view0) {
        super(view0);
        this.mSearchBarView = (SearchBarView)view0.findViewById(0x7F0A0A36);  // id:search_bar
        this.mSearchBarView.setSearchButtonVisibility(false);
    }

    public static int getLayoutRsId() [...] // Inlined contents

    public void setKeyword(String s) {
        this.mSearchBarView.setInputText(s);
        this.mSearchBarView.a();
    }

    public void setOnSearchBarListener(V0 v00) {
        this.mSearchBarView.setOnSearchBarListener(v00);
    }

    public void setVisibility(int v) {
        View view0 = this.itemView;
        if(view0 != null) {
            view0.setVisibility(v);
        }
    }
}

