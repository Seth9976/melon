package wd;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final b b;

    public a(b b0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            this.b.sendUserEvent(n.a);
            return;
        }
        this.b.dismiss();
    }
}

