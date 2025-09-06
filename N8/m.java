package n8;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.types.ContextItemInfo;

public final class m implements View.OnClickListener {
    public final n a;

    public m(n n0) {
        this.a = n0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        n n0 = this.a;
        int v = n0.getAdapterPosition();
        ContextItemInfo contextItemInfo0 = (ContextItemInfo)n0.g.getItem(v);
        if(contextItemInfo0 != null) {
            n0.g.k.onContextItemClick(contextItemInfo0, contextItemInfo0.a, contextItemInfo0.c);
        }
    }
}

