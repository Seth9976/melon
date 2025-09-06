package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import q6.a;

@Deprecated
public abstract class ExpandableBehavior extends Behavior {
    public int a;

    public ExpandableBehavior() {
        this.a = 0;
    }

    public ExpandableBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public abstract boolean f(View arg1, View arg2);

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
        boolean z = ((FloatingActionButton)(((a)view1))).o.b;
        int v = 2;
        if(!z) {
            if(this.a == 1) {
            label_6:
                if(z) {
                    v = 1;
                }
                this.a = v;
                this.w(((View)(((a)view1))), view0, z, true);
                return true;
            }
        }
        else if(this.a == 0 || this.a == 2) {
            goto label_6;
        }
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        a a0;
        if(!view0.isLaidOut()) {
            ArrayList arrayList0 = coordinatorLayout0.i(view0);
            int v1 = arrayList0.size();
            for(int v2 = 0; true; ++v2) {
                a0 = null;
                if(v2 >= v1) {
                    break;
                }
                View view1 = (View)arrayList0.get(v2);
                if(this.f(view0, view1)) {
                    a0 = (a)view1;
                    break;
                }
            }
            if(a0 != null) {
                boolean z = ((FloatingActionButton)a0).o.b;
                int v3 = 2;
                if(!z) {
                    if(this.a == 1) {
                    label_20:
                        if(z) {
                            v3 = 1;
                        }
                        this.a = v3;
                        view0.getViewTreeObserver().addOnPreDrawListener(new G6.a(this, view0, v3, a0));
                    }
                }
                else if(this.a == 0 || this.a == 2) {
                    goto label_20;
                }
            }
        }
        return false;
    }

    public abstract void w(View arg1, View arg2, boolean arg3, boolean arg4);
}

