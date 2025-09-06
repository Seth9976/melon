package Fd;

import J8.N2;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import com.iloen.melon.custom.MelonEditText;

public final class l implements TextView.OnEditorActionListener {
    public final D a;
    public final N2 b;
    public final MelonEditText c;

    public l(D d0, N2 n20, MelonEditText melonEditText0) {
        this.a = d0;
        this.b = n20;
        this.c = melonEditText0;
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        MelonEditText melonEditText0 = this.b.e;
        if(v == 3) {
            ((InputMethodManager)this.a.d.getValue()).hideSoftInputFromWindow(melonEditText0.getWindowToken(), 0);
            melonEditText0.clearFocus();
            L l0 = new L(String.valueOf(this.c.getText()), false);
            this.a.sendUserEvent(l0);
            return true;
        }
        return false;
    }
}

