package androidx.mediarouter.app;

import De.I;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;

public final class w extends O0 {
    public final View a;
    public final ImageView b;
    public final ProgressBar c;
    public final TextView d;
    public final x e;

    public w(x x0, View view0) {
        this.e = x0;
        super(view0);
        this.a = view0;
        this.b = (ImageView)view0.findViewById(0x7F0A085E);  // id:mr_picker_route_icon
        ProgressBar progressBar0 = (ProgressBar)view0.findViewById(0x7F0A0860);  // id:mr_picker_route_progress_bar
        this.c = progressBar0;
        this.d = (TextView)view0.findViewById(0x7F0A085F);  // id:mr_picker_route_name
        I.U(x0.g.h, progressBar0);
    }
}

