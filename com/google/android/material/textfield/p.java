package com.google.android.material.textfield;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

public final class p implements AdapterView.OnItemClickListener {
    public final MaterialAutoCompleteTextView a;

    public p(MaterialAutoCompleteTextView materialAutoCompleteTextView0) {
        this.a = materialAutoCompleteTextView0;
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        Object object0;
        MaterialAutoCompleteTextView materialAutoCompleteTextView0 = this.a;
        ListPopupWindow listPopupWindow0 = materialAutoCompleteTextView0.e;
        if(v >= 0) {
            object0 = materialAutoCompleteTextView0.getAdapter().getItem(v);
        }
        else if(!listPopupWindow0.T.isShowing()) {
            object0 = null;
        }
        else {
            object0 = listPopupWindow0.c.getSelectedItem();
        }
        MaterialAutoCompleteTextView.a(materialAutoCompleteTextView0, object0);
        AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = materialAutoCompleteTextView0.getOnItemClickListener();
        if(adapterView$OnItemClickListener0 != null) {
            if(view0 == null || v < 0) {
                view0 = listPopupWindow0.T.isShowing() ? listPopupWindow0.c.getSelectedView() : null;
                v = listPopupWindow0.T.isShowing() ? listPopupWindow0.c.getSelectedItemPosition() : -1;
                v1 = listPopupWindow0.T.isShowing() ? listPopupWindow0.c.getSelectedItemId() : 0x8000000000000000L;
            }
            adapterView$OnItemClickListener0.onItemClick(listPopupWindow0.c, view0, v, v1);
        }
        listPopupWindow0.dismiss();
    }
}

