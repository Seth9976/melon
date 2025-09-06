package l8;

import androidx.fragment.app.I;
import com.iloen.melon.activity.PopupFragmentBaseActivity;

public final class z implements Runnable {
    public final int a;
    public final PopupFragmentBaseActivity b;
    public final I c;
    public final I d;

    public z(PopupFragmentBaseActivity popupFragmentBaseActivity0, I i0, I i1, int v) {
        this.a = v;
        this.b = popupFragmentBaseActivity0;
        this.c = i0;
        this.d = i1;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            PopupFragmentBaseActivity.addFragment$lambda$3(this.b, this.c, this.d);
            return;
        }
        PopupFragmentBaseActivity.addFragment$lambda$2(this.b, this.c, this.d);
    }
}

