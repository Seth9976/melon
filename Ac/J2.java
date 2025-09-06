package Ac;

import J8.t;
import J8.u;
import a9.a;
import android.text.Editable;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.MelonEditText;

public final class j2 implements View.OnClickListener {
    public final int a;
    public final v2 b;

    public j2(v2 v20, int v) {
        this.a = v;
        this.b = v20;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Editable editable0;
        if(this.a != 0) {
            v2 v20 = this.b;
            t t0 = (t)v20.getBinding();
            if(t0 == null) {
                editable0 = null;
            }
            else {
                u u0 = t0.b;
                if(u0 == null) {
                    editable0 = null;
                }
                else {
                    MelonEditText melonEditText0 = (MelonEditText)u0.d;
                    editable0 = melonEditText0 == null ? null : melonEditText0.getText();
                }
            }
            v20.sendUserEvent(new R1(String.valueOf(editable0), v20.getParentFragment() instanceof a));
            return;
        }
        v2 v21 = this.b;
        if(((N2)v21.getViewModel()).b.d != null) {
            v21.sendUserEvent(M1.a);
        }
    }
}

