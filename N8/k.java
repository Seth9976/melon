package n8;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.types.ContextItemInfo;

public final class k implements View.OnClickListener {
    public final ContextItemInfo a;
    public final PopupTextListAdapter b;

    public k(PopupTextListAdapter popupTextListAdapter0, ContextItemInfo contextItemInfo0) {
        this.b = popupTextListAdapter0;
        this.a = contextItemInfo0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.b.l.onClick(view0, this.a);
    }
}

