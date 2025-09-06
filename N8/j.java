package n8;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.adapters.RecyclerItemClickListener.OnItemClickListener;

public final class j implements View.OnClickListener {
    public final int a;
    public final int b;
    public final PopupTextListAdapter c;

    public j(PopupTextListAdapter popupTextListAdapter0, int v, int v1) {
        this.a = v1;
        this.c = popupTextListAdapter0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            PopupTextListAdapter popupTextListAdapter0 = this.c;
            if(popupTextListAdapter0.j != null) {
                view0.setTag("contextItemInfoRightIcon");
                popupTextListAdapter0.j.onItemClick(view0, this.b);
            }
            return;
        }
        RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0 = this.c.j;
        if(recyclerItemClickListener$OnItemClickListener0 != null) {
            recyclerItemClickListener$OnItemClickListener0.onItemClick(view0, this.b);
        }
    }
}

