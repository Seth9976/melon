package x2;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import v2.f;
import v2.h;

public final class c extends f implements Runnable {
    public final WeakReference a;
    public final WeakReference b;

    public c(TextView textView0, d d0) {
        this.a = new WeakReference(textView0);
        this.b = new WeakReference(d0);
    }

    @Override  // v2.f
    public final void b() {
        TextView textView0 = (TextView)this.a.get();
        if(textView0 != null) {
            Handler handler0 = textView0.getHandler();
            if(handler0 != null) {
                handler0.post(this);
            }
        }
    }

    @Override
    public final void run() {
        int v1;
        TextView textView0 = (TextView)this.a.get();
        InputFilter inputFilter0 = (InputFilter)this.b.get();
        if(inputFilter0 != null && textView0 != null) {
            InputFilter[] arr_inputFilter = textView0.getFilters();
            if(arr_inputFilter != null) {
                for(int v = 0; v < arr_inputFilter.length; ++v) {
                    if(arr_inputFilter[v] == inputFilter0) {
                        if(!textView0.isAttachedToWindow()) {
                            break;
                        }
                        CharSequence charSequence0 = textView0.getText();
                        h h0 = h.a();
                        if(charSequence0 == null) {
                            v1 = 0;
                        }
                        else {
                            h0.getClass();
                            v1 = charSequence0.length();
                        }
                        CharSequence charSequence1 = h0.g(0, v1, 0, charSequence0);
                        if(charSequence0 == charSequence1) {
                            break;
                        }
                        int v2 = Selection.getSelectionStart(charSequence1);
                        int v3 = Selection.getSelectionEnd(charSequence1);
                        textView0.setText(charSequence1);
                        if(!(charSequence1 instanceof Spannable)) {
                            break;
                        }
                        if(v2 >= 0 && v3 >= 0) {
                            Selection.setSelection(((Spannable)charSequence1), v2, v3);
                            return;
                        }
                        if(v2 >= 0) {
                            Selection.setSelection(((Spannable)charSequence1), v2);
                            return;
                        }
                        if(v3 < 0) {
                            break;
                        }
                        Selection.setSelection(((Spannable)charSequence1), v3);
                        return;
                    }
                }
            }
        }
    }
}

