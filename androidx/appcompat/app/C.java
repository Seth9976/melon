package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public final class c implements AdapterView.OnItemClickListener {
    public final f a;
    public final AlertController.AlertParams b;

    public c(AlertController.AlertParams alertController$AlertParams0, f f0) {
        this.b = alertController$AlertParams0;
        this.a = f0;
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        f f0 = this.a;
        this.b.r.onClick(f0.b, v);
        if(!this.b.t) {
            f0.b.dismiss();
        }
    }
}

