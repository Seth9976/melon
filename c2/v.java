package c2;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class V {
    public WeakHashMap a;
    public SparseArray b;
    public WeakReference c;
    public static final ArrayList d;

    static {
        V.d = new ArrayList();
    }

    public final View a(View view0) {
        if(this.a != null && this.a.containsKey(view0)) {
            if(view0 instanceof ViewGroup) {
                for(int v = ((ViewGroup)view0).getChildCount() - 1; v >= 0; --v) {
                    View view1 = this.a(((ViewGroup)view0).getChildAt(v));
                    if(view1 != null) {
                        return view1;
                    }
                }
            }
            ArrayList arrayList0 = (ArrayList)view0.getTag(0x7F0A0B36);  // id:tag_unhandled_key_listeners
            if(arrayList0 != null) {
                int v1 = arrayList0.size();
                if(v1 - 1 >= 0) {
                    throw o.g(v1 - 1, arrayList0);
                }
            }
        }
        return null;
    }
}

