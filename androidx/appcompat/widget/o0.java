package androidx.appcompat.widget;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.View;

public final class O0 implements View.OnKeyListener {
    public final SearchView a;

    public O0(SearchView searchView0) {
        this.a = searchView0;
    }

    @Override  // android.view.View$OnKeyListener
    public final boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        SearchView searchView0 = this.a;
        SearchAutoComplete searchView$SearchAutoComplete0 = searchView0.r;
        if(searchView0.x0 != null) {
            if(searchView$SearchAutoComplete0.isPopupShowing() && searchView$SearchAutoComplete0.getListSelection() != -1) {
                if(searchView0.x0 != null && searchView0.n0 != null && keyEvent0.getAction() == 0 && keyEvent0.hasNoModifiers()) {
                    switch(v) {
                        case 19: {
                            searchView$SearchAutoComplete0.getListSelection();
                            return false;
                        }
                        case 21: 
                        case 22: {
                            searchView$SearchAutoComplete0.setSelection((v == 21 ? 0 : searchView$SearchAutoComplete0.length()));
                            searchView$SearchAutoComplete0.setListSelection(0);
                            searchView$SearchAutoComplete0.clearListSelection();
                            searchView$SearchAutoComplete0.a();
                            return true;
                        }
                        case 61: 
                        case 66: 
                        case 84: {
                            searchView0.n(searchView$SearchAutoComplete0.getListSelection());
                            return true;
                        }
                        default: {
                            return false;
                        }
                    }
                }
            }
            else if(TextUtils.getTrimmedLength(searchView$SearchAutoComplete0.getText()) != 0 && keyEvent0.hasNoModifiers() && keyEvent0.getAction() == 1 && v == 66) {
                view0.cancelLongPress();
                Intent intent0 = searchView0.j(null, "android.intent.action.SEARCH", null, searchView$SearchAutoComplete0.getText().toString());
                searchView0.getContext().startActivity(intent0);
                return true;
            }
        }
        return false;
    }
}

