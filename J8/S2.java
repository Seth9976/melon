package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;

public final class s2 implements a {
    public final RelativeLayout a;
    public final RecyclerView b;
    public final b c;

    public s2(RelativeLayout relativeLayout0, RecyclerView recyclerView0, b b0) {
        this.a = relativeLayout0;
        this.b = recyclerView0;
        this.c = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

