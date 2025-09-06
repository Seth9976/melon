package d2;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {
    public final int a;
    public final d b;
    public final int c;

    public a(int v, d d0, int v1) {
        this.a = v;
        this.b = d0;
        this.c = v1;
    }

    @Override  // android.text.style.ClickableSpan
    public final void onClick(View view0) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.a.performAction(this.c, bundle0);
    }
}

