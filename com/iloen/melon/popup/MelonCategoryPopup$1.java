package com.iloen.melon.popup;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

class MelonCategoryPopup.1 implements AdapterView.OnItemClickListener {
    public final MelonCategoryPopup a;

    public MelonCategoryPopup.1(MelonCategoryPopup melonCategoryPopup0) {
        this.a = melonCategoryPopup0;
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        Category category0 = (Category)adapterView0.getAdapter().getItem(v);
        this.a.c = category0.getNum();
        this.a.b(category0.getName());
        ((CategoryPopupArrayAdapter)adapterView0.getAdapter()).notifyDataSetChanged();
    }
}

