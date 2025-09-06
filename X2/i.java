package x2;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class i implements TextWatcher {
    public final EditText a;
    public h b;
    public boolean c;

    public i(EditText editText0) {
        this.a = editText0;
        this.c = true;
    }

    public static void a(EditText editText0, int v) {
        int v3;
        if(v == 1 && editText0 != null && editText0.isAttachedToWindow()) {
            Editable editable0 = editText0.getEditableText();
            int v1 = Selection.getSelectionStart(editable0);
            int v2 = Selection.getSelectionEnd(editable0);
            v2.h h0 = v2.h.a();
            if(editable0 == null) {
                v3 = 0;
            }
            else {
                h0.getClass();
                v3 = editable0.length();
            }
            h0.g(0, v3, 0, editable0);
            if(v1 >= 0 && v2 >= 0) {
                Selection.setSelection(editable0, v1, v2);
                return;
            }
            if(v1 >= 0) {
                Selection.setSelection(editable0, v1);
                return;
            }
            if(v2 >= 0) {
                Selection.setSelection(editable0, v2);
            }
        }
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
    }

    @Override  // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        EditText editText0 = this.a;
        if(!editText0.isInEditMode() && this.c && false && v1 <= v2 && charSequence0 instanceof Spannable) {
            switch(v2.h.a().c()) {
                case 1: {
                    v2.h.a().g(v, v2 + v, 0, ((Spannable)charSequence0));
                    return;
                }
                case 0: 
                case 3: {
                    v2.h h0 = v2.h.a();
                    if(this.b == null) {
                        this.b = new h(editText0);
                    }
                    h0.h(this.b);
                    break;
                }
            }
        }
    }
}

