package com.google.android.material.transformation;

import E9.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.c;
import e6.f;
import e6.h;
import java.util.HashMap;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap i;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.google.android.material.transformation.FabTransformationBehavior
    public final g D(Context context0, boolean z) {
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.a = f.b(context0, (z ? 0x7F020023 : 0x7F020022));  // animator:mtrl_fab_transformation_sheet_expand_spec
        g0.b = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        return g0;
    }

    @Override  // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final void w(View view0, View view1, boolean z, boolean z1) {
        ViewParent viewParent0 = view1.getParent();
        if(viewParent0 instanceof CoordinatorLayout) {
            int v = ((CoordinatorLayout)viewParent0).getChildCount();
            if(z) {
                this.i = new HashMap(v);
            }
            for(int v1 = 0; v1 < v; ++v1) {
                View view2 = ((CoordinatorLayout)viewParent0).getChildAt(v1);
                if(view2 != view1 && (!(view2.getLayoutParams() instanceof c) || !(((c)view2.getLayoutParams()).a instanceof FabTransformationScrimBehavior))) {
                    if(z) {
                        this.i.put(view2, view2.getImportantForAccessibility());
                        view2.setImportantForAccessibility(4);
                    }
                    else if(this.i != null && this.i.containsKey(view2)) {
                        view2.setImportantForAccessibility(((int)(((Integer)this.i.get(view2)))));
                    }
                }
            }
            if(!z) {
                this.i = null;
            }
        }
        super.w(view0, view1, z, z1);
    }
}

