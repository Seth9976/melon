package D6;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.Y0;
import com.google.android.material.tabs.TabLayout;

public final class f extends DataSetObserver {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.database.DataSetObserver
    public final void onChanged() {
        switch(this.a) {
            case 0: {
                ((TabLayout)this.b).i();
                return;
            }
            case 1: {
                ListPopupWindow listPopupWindow0 = (ListPopupWindow)this.b;
                if(listPopupWindow0.T.isShowing()) {
                    listPopupWindow0.show();
                }
                return;
            }
            default: {
                ((Y0)this.b).a = true;
                ((Y0)this.b).notifyDataSetChanged();
            }
        }
    }

    @Override  // android.database.DataSetObserver
    public final void onInvalidated() {
        switch(this.a) {
            case 0: {
                ((TabLayout)this.b).i();
                return;
            }
            case 1: {
                ((ListPopupWindow)this.b).dismiss();
                return;
            }
            default: {
                ((Y0)this.b).a = false;
                ((Y0)this.b).notifyDataSetInvalidated();
            }
        }
    }
}

