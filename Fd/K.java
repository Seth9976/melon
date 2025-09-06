package Fd;

import P1.c;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.android.material.textfield.h;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;

public final class k implements View.OnFocusChangeListener {
    public final int a;
    public final Object b;

    public k(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view0, boolean z) {
        switch(this.a) {
            case 0: {
                D d0 = (D)this.b;
                if(z) {
                    d0.sendUserEvent(J.a);
                }
                return;
            }
            case 1: {
                EditText[] arr_editText = (EditText[])this.b;
                for(int v = 0; true; ++v) {
                    if(v >= arr_editText.length) {
                        InputMethodManager inputMethodManager0 = (InputMethodManager)c.getSystemService(view0.getContext(), InputMethodManager.class);
                        if(inputMethodManager0 == null) {
                            break;
                        }
                        inputMethodManager0.hideSoftInputFromWindow(view0.getWindowToken(), 0);
                        break;
                    }
                    if(arr_editText[v].hasFocus()) {
                        break;
                    }
                }
                return;
            }
            case 2: {
                boolean z1 = ((com.google.android.material.textfield.c)this.b).u();
                ((com.google.android.material.textfield.c)this.b).t(z1);
                return;
            }
            case 3: {
                h h0 = (h)this.b;
                h0.l = z;
                h0.q();
                if(!z) {
                    h0.t(false);
                    h0.m = false;
                }
                return;
            }
            default: {
                MusicMessageEditorFragment.onViewCreated$lambda$6(((MusicMessageEditorFragment)this.b), view0, z);
            }
        }
    }
}

