package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

public final class l implements a {
    public final LinearLayout a;
    public final RecyclerView b;

    public l(LinearLayout linearLayout0, RecyclerView recyclerView0) {
        this.a = linearLayout0;
        this.b = recyclerView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

