package f2;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import java.util.ArrayList;

public final class b extends View {
    public final ViewGroup a;
    public final d b;

    public b(d d0, Context context0, ViewGroup viewGroup0) {
        this.b = d0;
        this.a = viewGroup0;
        super(context0);
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        d d0 = this.b;
        ArrayList arrayList0 = d0.b;
        Drawable drawable0 = this.a.getBackground();
        int v = drawable0 instanceof ColorDrawable ? ((ColorDrawable)drawable0).getColor() : 0;
        if(d0.e != v) {
            d0.e = v;
            for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                ArrayList arrayList1 = ((a)arrayList0.get(v1)).a;
                int v2 = arrayList1.size() - 1;
                if(v2 >= 0) {
                    throw o.g(v2, arrayList1);
                }
            }
        }
    }
}

