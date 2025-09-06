package com.google.android.material.search;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import c2.F0;
import c2.W;

public final class c implements Runnable {
    public final int a;
    public final SearchView b;

    public c(SearchView searchView0, int v) {
        this.a = v;
        this.b = searchView0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                SearchView searchView0 = this.b;
                EditText editText0 = searchView0.j;
                if(editText0.requestFocus()) {
                    editText0.sendAccessibilityEvent(8);
                }
                if(searchView0.T) {
                    F0 f00 = W.h(editText0);
                    if(f00 != null) {
                        f00.a.U(8);
                        return;
                    }
                }
                ((InputMethodManager)P1.c.getSystemService(editText0.getContext(), InputMethodManager.class)).showSoftInput(editText0, 1);
                return;
            }
            case 1: {
                SearchView searchView1 = this.b;
                EditText editText1 = searchView1.j;
                editText1.clearFocus();
                SearchBar searchBar0 = searchView1.E;
                if(searchBar0 != null) {
                    searchBar0.requestFocus();
                }
                if(searchView1.T) {
                    F0 f01 = W.h(editText1);
                    if(f01 != null) {
                        f01.a.G(8);
                        return;
                    }
                }
                InputMethodManager inputMethodManager0 = (InputMethodManager)P1.c.getSystemService(editText1.getContext(), InputMethodManager.class);
                if(inputMethodManager0 != null) {
                    inputMethodManager0.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
                }
                return;
            }
            case 2: {
                this.b.k();
                return;
            }
            default: {
                this.b.i();
            }
        }
    }
}

