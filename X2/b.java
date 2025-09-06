package x2;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import wc.u;

public final class b extends InputConnectionWrapper {
    public final EditText a;
    public final u b;

    public b(EditText editText0, InputConnection inputConnection0, EditorInfo editorInfo0) {
        u u0 = new u(1);
        super(inputConnection0, false);
        this.a = editText0;
        this.b = u0;
    }

    @Override  // android.view.inputmethod.InputConnectionWrapper
    public final boolean deleteSurroundingText(int v, int v1) {
        Editable editable0 = this.a.getEditableText();
        this.b.getClass();
        return u.d(this, editable0, v, v1, false) || super.deleteSurroundingText(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnectionWrapper
    public final boolean deleteSurroundingTextInCodePoints(int v, int v1) {
        Editable editable0 = this.a.getEditableText();
        this.b.getClass();
        return u.d(this, editable0, v, v1, true) || super.deleteSurroundingTextInCodePoints(v, v1);
    }
}

