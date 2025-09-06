package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import androidx.appcompat.widget.C0;
import com.google.android.material.internal.r;
import java.util.ArrayList;
import k.B;
import k.e;
import k.f;

public final class m implements ViewTreeObserver.OnGlobalLayoutListener {
    public final int a;
    public final Object b;

    public m(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect rect0;
        Activity activity0;
        boolean z = false;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                int[] arr_v = ((NavigationView)object0).k;
                ((NavigationView)object0).getLocationOnScreen(arr_v);
                boolean z1 = arr_v[1] == 0;
                r r0 = ((NavigationView)object0).i;
                if(r0.N != z1) {
                    r0.N = z1;
                    int v = r0.b.getChildCount() > 0 || !r0.N ? 0 : r0.T;
                    r0.a.setPadding(0, v, 0, r0.a.getPaddingBottom());
                }
                ((NavigationView)object0).setDrawTopInsetForeground(z1 && ((NavigationView)object0).n);
                int v1 = arr_v[0];
                ((NavigationView)object0).setDrawLeftInsetForeground(v1 == 0 || ((NavigationView)object0).getWidth() + v1 == 0);
                for(Context context0 = ((NavigationView)object0).getContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
                    activity0 = null;
                    if(!(context0 instanceof ContextWrapper)) {
                        break;
                    }
                    if(context0 instanceof Activity) {
                        activity0 = (Activity)context0;
                        break;
                    }
                }
                if(activity0 != null) {
                    int v2 = Build.VERSION.SDK_INT;
                    WindowManager windowManager0 = (WindowManager)activity0.getSystemService("window");
                    if(v2 >= 30) {
                        rect0 = windowManager0.getCurrentWindowMetrics().getBounds();
                    }
                    else {
                        Display display0 = windowManager0.getDefaultDisplay();
                        Point point0 = new Point();
                        display0.getRealSize(point0);
                        rect0 = new Rect();
                        rect0.right = point0.x;
                        rect0.bottom = point0.y;
                    }
                    ((NavigationView)object0).setDrawBottomInsetForeground(rect0.height() - ((NavigationView)object0).getHeight() == arr_v[1] && Color.alpha(activity0.getWindow().getNavigationBarColor()) != 0 && ((NavigationView)object0).o);
                    if(rect0.width() == arr_v[0] || rect0.width() - ((NavigationView)object0).getWidth() == arr_v[0]) {
                        z = true;
                    }
                    ((NavigationView)object0).setDrawRightInsetForeground(z);
                }
                return;
            }
            case 1: {
                ArrayList arrayList0 = ((f)object0).h;
                if(((f)object0).a() && arrayList0.size() > 0 && !((e)arrayList0.get(0)).a.S) {
                    View view1 = ((f)object0).o;
                    if(view1 != null && view1.isShown()) {
                        for(Object object1: arrayList0) {
                            ((e)object1).a.show();
                        }
                        return;
                    }
                    ((f)object0).dismiss();
                }
                return;
            }
            default: {
                C0 c00 = ((B)object0).h;
                if(((B)object0).a() && !c00.S) {
                    View view0 = ((B)object0).m;
                    if(view0 != null && view0.isShown()) {
                        c00.show();
                        return;
                    }
                    ((B)object0).dismiss();
                }
            }
        }
    }
}

