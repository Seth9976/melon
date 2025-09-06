package com.google.android.material.button;

import A6.c;
import B6.f;
import E6.a;
import Hf.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.lifecycle.b;
import c2.W;
import com.google.android.material.internal.B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import z6.m;
import z6.o;

public class MaterialButtonToggleGroup extends LinearLayout {
    public final ArrayList a;
    public final b b;
    public final LinkedHashSet c;
    public final v d;
    public Integer[] e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final int i;
    public HashSet j;
    public static final int k;

    public MaterialButtonToggleGroup(Context context0) {
        this(context0, null);
    }

    public MaterialButtonToggleGroup(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403F4);  // attr:materialButtonToggleGroupStyle
    }

    public MaterialButtonToggleGroup(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404A9), attributeSet0, v);  // style:Widget.MaterialComponents.MaterialButtonToggleGroup
        this.a = new ArrayList();
        this.b = new b(this, 18);
        this.c = new LinkedHashSet();
        this.d = new v(this, 3);
        this.f = false;
        this.j = new HashSet();
        TypedArray typedArray0 = B.m(this.getContext(), attributeSet0, d6.a.B, v, 0x7F1404A9, new int[0]);  // style:Widget.MaterialComponents.MaterialButtonToggleGroup
        this.setSingleSelection(typedArray0.getBoolean(3, false));
        this.i = typedArray0.getResourceId(1, -1);
        this.h = typedArray0.getBoolean(2, false);
        this.setChildrenDrawingOrderEnabled(true);
        this.setEnabled(typedArray0.getBoolean(0, true));
        typedArray0.recycle();
        this.setImportantForAccessibility(1);
    }

    public final void a() {
        int v = this.getFirstVisibleChildIndex();
        if(v != -1) {
            for(int v1 = v + 1; v1 < this.getChildCount(); ++v1) {
                MaterialButton materialButton0 = (MaterialButton)this.getChildAt(v1);
                int v2 = Math.min(materialButton0.getStrokeWidth(), ((MaterialButton)this.getChildAt(v1 - 1)).getStrokeWidth());
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = materialButton0.getLayoutParams();
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = viewGroup$LayoutParams0 instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams)viewGroup$LayoutParams0) : new LinearLayout.LayoutParams(viewGroup$LayoutParams0.width, viewGroup$LayoutParams0.height);
                if(this.getOrientation() == 0) {
                    linearLayout$LayoutParams0.setMarginEnd(0);
                    linearLayout$LayoutParams0.setMarginStart(-v2);
                    linearLayout$LayoutParams0.topMargin = 0;
                }
                else {
                    linearLayout$LayoutParams0.bottomMargin = 0;
                    linearLayout$LayoutParams0.topMargin = -v2;
                    linearLayout$LayoutParams0.setMarginStart(0);
                }
                materialButton0.setLayoutParams(linearLayout$LayoutParams0);
            }
            if(this.getChildCount() != 0 && v != -1) {
                LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)((MaterialButton)this.getChildAt(v)).getLayoutParams();
                if(this.getOrientation() == 1) {
                    linearLayout$LayoutParams1.topMargin = 0;
                    linearLayout$LayoutParams1.bottomMargin = 0;
                    return;
                }
                linearLayout$LayoutParams1.setMarginEnd(0);
                linearLayout$LayoutParams1.setMarginStart(0);
                linearLayout$LayoutParams1.leftMargin = 0;
                linearLayout$LayoutParams1.rightMargin = 0;
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(!(view0 instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
        this.setGeneratedIdIfNeeded(((MaterialButton)view0));
        this.setupButtonChild(((MaterialButton)view0));
        this.b(((MaterialButton)view0).getId(), ((MaterialButton)view0).o);
        o o0 = ((MaterialButton)view0).getShapeAppearanceModel();
        d d0 = new d(o0.e, o0.h, o0.f, o0.g);
        this.a.add(d0);
        ((MaterialButton)view0).setEnabled(this.isEnabled());
        W.o(((MaterialButton)view0), new c(this, 1));
    }

    public final void b(int v, boolean z) {
        if(v == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + -1);
            return;
        }
        HashSet hashSet0 = new HashSet(this.j);
        if(z && !hashSet0.contains(v)) {
            if(this.g && !hashSet0.isEmpty()) {
                hashSet0.clear();
            }
            hashSet0.add(v);
            this.d(hashSet0);
            return;
        }
        if(!z && hashSet0.contains(v)) {
            if(!this.h || hashSet0.size() > 1) {
                hashSet0.remove(v);
            }
            this.d(hashSet0);
        }
    }

    public final boolean c(int v) {
        return this.getChildAt(v).getVisibility() != 8;
    }

    public final void d(Set set0) {
        HashSet hashSet0 = this.j;
        this.j = new HashSet(set0);
        for(int v = 0; v < this.getChildCount(); ++v) {
            int v1 = ((MaterialButton)this.getChildAt(v)).getId();
            boolean z = set0.contains(v1);
            View view0 = this.findViewById(v1);
            if(view0 instanceof MaterialButton) {
                this.f = true;
                ((MaterialButton)view0).setChecked(z);
                this.f = false;
            }
            if(hashSet0.contains(v1) != set0.contains(v1)) {
                set0.contains(v1);
                Iterator iterator0 = this.c.iterator();
                while(iterator0.hasNext()) {
                    iterator0.next();
                }
            }
        }
        this.invalidate();
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        TreeMap treeMap0 = new TreeMap(this.d);
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            treeMap0.put(((MaterialButton)this.getChildAt(v1)), v1);
        }
        this.e = (Integer[])treeMap0.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas0);
    }

    public final void e() {
        d d1;
        int v = this.getChildCount();
        int v1 = this.getFirstVisibleChildIndex();
        int v2 = this.getLastVisibleChildIndex();
        for(int v3 = 0; v3 < v; ++v3) {
            MaterialButton materialButton0 = (MaterialButton)this.getChildAt(v3);
            if(materialButton0.getVisibility() != 8) {
                m m0 = materialButton0.getShapeAppearanceModel().g();
                d d0 = (d)this.a.get(v3);
                if(v1 != v2) {
                    boolean z = this.getOrientation() == 0;
                    z6.a a0 = d.e;
                    if(v3 == v1) {
                        if(!z) {
                            d1 = new d(d0.a, a0, d0.b, a0);
                        }
                        else if(B.l(this)) {
                            d1 = new d(a0, a0, d0.b, d0.c);
                        }
                        else {
                            d1 = new d(d0.a, d0.d, a0, a0);
                        }
                        d0 = d1;
                    }
                    else if(v3 == v2) {
                        if(!z) {
                            d1 = new d(a0, d0.d, a0, d0.c);
                        }
                        else if(B.l(this)) {
                            d1 = new d(d0.a, d0.d, a0, a0);
                        }
                        else {
                            d1 = new d(a0, a0, d0.b, d0.c);
                        }
                        d0 = d1;
                    }
                    else {
                        d0 = null;
                    }
                }
                if(d0 == null) {
                    m0.c(0.0f);
                }
                else {
                    m0.e = d0.a;
                    m0.h = d0.d;
                    m0.f = d0.b;
                    m0.g = d0.c;
                }
                materialButton0.setShapeAppearanceModel(m0.a());
            }
        }
    }

    public int getCheckedButtonId() {
        return this.g && !this.j.isEmpty() ? this.j.iterator().next() : -1;
    }

    public List getCheckedButtonIds() {
        List list0 = new ArrayList();
        for(int v = 0; v < this.getChildCount(); ++v) {
            int v1 = ((MaterialButton)this.getChildAt(v)).getId();
            if(this.j.contains(v1)) {
                ((ArrayList)list0).add(v1);
            }
        }
        return list0;
    }

    @Override  // android.view.ViewGroup
    public final int getChildDrawingOrder(int v, int v1) {
        Integer[] arr_integer = this.e;
        if(arr_integer != null && v1 < arr_integer.length) {
            return (int)arr_integer[v1];
        }
        Log.w("MButtonToggleGroup", "Child order wasn\'t updated");
        return v1;
    }

    private int getFirstVisibleChildIndex() {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.c(v1)) {
                return v1;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for(int v = this.getChildCount() - 1; v >= 0; --v) {
            if(this.c(v)) {
                return v;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int v1 = 0;
        for(int v = 0; v < this.getChildCount(); ++v) {
            if(this.getChildAt(v) instanceof MaterialButton && this.c(v)) {
                ++v1;
            }
        }
        return v1;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int v = this.i;
        if(v != -1) {
            this.d(Collections.singleton(v));
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)f.d(1, this.getVisibleButtonCount(), (this.g ? 1 : 2), false).a));
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        this.e();
        this.a();
        super.onMeasure(v, v1);
    }

    @Override  // android.view.ViewGroup
    public final void onViewRemoved(View view0) {
        super.onViewRemoved(view0);
        if(view0 instanceof MaterialButton) {
            ((MaterialButton)view0).setOnPressedChangeListenerInternal(null);
        }
        int v = this.indexOfChild(view0);
        if(v >= 0) {
            this.a.remove(v);
        }
        this.e();
        this.a();
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for(int v = 0; v < this.getChildCount(); ++v) {
            ((MaterialButton)this.getChildAt(v)).setEnabled(z);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton0) {
        if(materialButton0.getId() == -1) {
            materialButton0.setId(View.generateViewId());
        }
    }

    public void setSelectionRequired(boolean z) {
        this.h = z;
    }

    public void setSingleSelection(int v) {
        this.setSingleSelection(this.getResources().getBoolean(v));
    }

    public void setSingleSelection(boolean z) {
        if(this.g != z) {
            this.g = z;
            this.d(new HashSet());
        }
        for(int v = 0; v < this.getChildCount(); ++v) {
            Class class0 = this.g ? RadioButton.class : ToggleButton.class;
            ((MaterialButton)this.getChildAt(v)).setA11yClassName(class0.getName());
        }
    }

    private void setupButtonChild(MaterialButton materialButton0) {
        materialButton0.setMaxLines(1);
        materialButton0.setEllipsize(TextUtils.TruncateAt.END);
        materialButton0.setCheckable(true);
        materialButton0.setOnPressedChangeListenerInternal(this.b);
        materialButton0.setShouldDrawSurfaceColorStroke(true);
    }
}

