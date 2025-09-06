package com.iloen.melon.custom;

import E8.a;
import a9.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import k8.t1;

public class SortingBarView extends FilterLayout {
    public final ArrayList B;
    public int D;
    public int E;
    public String[] G;
    public d I;
    public final a M;
    public CheckableTextView k;
    public CheckableTextView l;
    public CheckableTextView m;
    public CheckableTextView n;
    public View o;
    public View r;
    public View w;

    public SortingBarView(Context context0) {
        this(context0, null);
    }

    public SortingBarView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public SortingBarView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.D = 0;
        this.E = -1;
        this.G = null;
        this.M = new a(this, 7);
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.G, v, 0);
        if(typedArray0 != null) {
            this.D = typedArray0.getInt(3, 0);
            try {
                int v1 = typedArray0.getResourceId(2, -1);
                if(v1 > 0) {
                    this.G = this.getResources().getStringArray(v1);
                }
            }
            catch(Exception exception0) {
                LogU.e("SortingBarView", exception0.getMessage(), exception0);
            }
            typedArray0.recycle();
        }
        this.B = new ArrayList();
        this.setSortBarStyle(this.D);
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public final void d() {
        ArrayList arrayList0 = this.B;
        if(arrayList0 != null && this.G != null) {
            for(int v = 0; v < arrayList0.size(); ++v) {
                CheckableTextView checkableTextView0 = (CheckableTextView)arrayList0.get(v);
                String[] arr_s = this.G;
                if(arr_s.length > v) {
                    checkableTextView0.setText(arr_s[v]);
                }
                ColorStateList colorStateList0 = this.g;
                if(colorStateList0 != null) {
                    checkableTextView0.setTextColor(colorStateList0);
                }
                float f = this.h;
                if(f > 0.0f) {
                    checkableTextView0.setTextSize(0, f);
                }
            }
            this.requestLayout();
        }
    }

    public final void e(int v, boolean z) {
        ArrayList arrayList0 = this.B;
        if(arrayList0 != null && arrayList0.size() > v && v >= 0) {
            this.E = v;
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                ((CheckableTextView)arrayList0.get(v1)).setChecked(v1 == v);
            }
            d d0 = this.I;
            if(d0 != null && z) {
                d0.onSelected(v);
            }
            this.requestLayout();
        }
    }

    public String[] getItems() {
        ArrayList arrayList0 = this.B;
        if(arrayList0 == null) {
            return null;
        }
        String[] arr_s = new String[arrayList0.size()];
        for(int v = 0; v < arrayList0.size(); ++v) {
            arr_s[v] = ((CheckableTextView)arrayList0.get(v)).getText().toString();
        }
        return arr_s;
    }

    public d getOnSortSelectionListener() {
        return this.I;
    }

    public int getSelection() {
        return this.E;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.e(this.E, false);
    }

    public void setButtonPadding(int v) {
        if(v <= 0 || this.D != 1 && this.D != 2 && this.D != 3 && this.D != 10 && this.D != 11) {
            return;
        }
        CheckableTextView checkableTextView0 = this.k;
        if(checkableTextView0 != null) {
            checkableTextView0.getLayoutParams().width = -2;
            this.k.setPadding(v, 0, v, 0);
        }
        CheckableTextView checkableTextView1 = this.l;
        if(checkableTextView1 != null) {
            checkableTextView1.getLayoutParams().width = -2;
            this.l.setPadding(v, 0, v, 0);
        }
        CheckableTextView checkableTextView2 = this.m;
        if(checkableTextView2 != null) {
            checkableTextView2.getLayoutParams().width = -2;
            this.m.setPadding(v, 0, v, 0);
        }
        CheckableTextView checkableTextView3 = this.n;
        if(checkableTextView3 != null) {
            checkableTextView3.getLayoutParams().width = -2;
            this.n.setPadding(v, 0, v, 0);
        }
        this.requestLayout();
    }

    public void setButtonWidth(int v) {
        if(v <= 0 || this.D != 1 && this.D != 2 && this.D != 3 && this.D != 10 && this.D != 11) {
            return;
        }
        CheckableTextView checkableTextView0 = this.k;
        if(checkableTextView0 != null) {
            checkableTextView0.getLayoutParams().width = v;
        }
        CheckableTextView checkableTextView1 = this.l;
        if(checkableTextView1 != null) {
            checkableTextView1.getLayoutParams().width = v;
        }
        CheckableTextView checkableTextView2 = this.m;
        if(checkableTextView2 != null) {
            checkableTextView2.getLayoutParams().width = v;
        }
        CheckableTextView checkableTextView3 = this.n;
        if(checkableTextView3 != null) {
            checkableTextView3.getLayoutParams().width = v;
        }
        this.requestLayout();
    }

    public void setItems(String[] arr_s) {
        this.G = arr_s;
        this.d();
    }

    public void setOnSortSelectionListener(d d0) {
        this.I = d0;
    }

    public void setOverlapWidth(int v) {
        if(this.D != 1 && this.D != 2 && this.D != 3 && this.D != 10 && this.D != 11) {
            return;
        }
        View view0 = this.o;
        if(view0 != null) {
            view0.getLayoutParams().width = v;
        }
        View view1 = this.r;
        if(view1 != null) {
            view1.getLayoutParams().width = v;
        }
        View view2 = this.w;
        if(view2 != null) {
            view2.getLayoutParams().width = v;
        }
        this.requestLayout();
    }

    public void setSelection(int v) {
        this.e(v, true);
    }

    public void setSortBarStyle(int v) {
        int v1;
        if(v >= 0 && v <= 11) {
            this.a.removeAllViews();
            ArrayList arrayList0 = this.B;
            arrayList0.clear();
            this.D = v;
            if(v == 1) {
                v1 = 0x7F0D084F;  // layout:sortbar_button_2row
            }
            else {
                switch(v) {
                    case 2: {
                        v1 = 0x7F0D0854;  // layout:sortbar_button_3row
                        break;
                    }
                    case 3: {
                        v1 = 0x7F0D0857;  // layout:sortbar_button_4row
                        break;
                    }
                    case 4: {
                        v1 = 0x7F0D0853;  // layout:sortbar_button_2row_shallow
                        break;
                    }
                    case 5: {
                        v1 = 0x7F0D0856;  // layout:sortbar_button_3row_shallow
                        break;
                    }
                    case 8: {
                        v1 = 0x7F0D0850;  // layout:sortbar_button_2row_eq
                        break;
                    }
                    case 9: {
                        v1 = 0x7F0D0855;  // layout:sortbar_button_3row_eq
                        break;
                    }
                    case 10: {
                        v1 = 0x7F0D0851;  // layout:sortbar_button_2row_playlist
                        break;
                    }
                    case 11: {
                        v1 = 0x7F0D0852;  // layout:sortbar_button_2row_popup
                        break;
                    }
                    default: {
                        return;
                    }
                }
            }
            View view0 = LayoutInflater.from(this.getContext()).inflate(v1, this.a, false);
            if(view0 != null) {
                this.a.addView(view0);
            }
            CheckableTextView checkableTextView0 = (CheckableTextView)view0.findViewById(0x7F0A01CB);  // id:button1
            this.k = checkableTextView0;
            a a0 = this.M;
            if(checkableTextView0 != null) {
                ViewUtils.setOnClickListener(checkableTextView0, a0);
                arrayList0.add(this.k);
            }
            CheckableTextView checkableTextView1 = (CheckableTextView)view0.findViewById(0x7F0A01CC);  // id:button2
            this.l = checkableTextView1;
            if(checkableTextView1 != null) {
                ViewUtils.setOnClickListener(checkableTextView1, a0);
                arrayList0.add(this.l);
            }
            CheckableTextView checkableTextView2 = (CheckableTextView)view0.findViewById(0x7F0A01CE);  // id:button3
            this.m = checkableTextView2;
            if(checkableTextView2 != null) {
                ViewUtils.setOnClickListener(checkableTextView2, a0);
                arrayList0.add(this.m);
            }
            CheckableTextView checkableTextView3 = (CheckableTextView)view0.findViewById(0x7F0A01D0);  // id:button4
            this.n = checkableTextView3;
            if(checkableTextView3 != null) {
                ViewUtils.setOnClickListener(checkableTextView3, a0);
                arrayList0.add(this.n);
            }
            this.o = view0.findViewById(0x7F0A01CD);  // id:button2_anchor_point
            this.r = view0.findViewById(0x7F0A01CF);  // id:button3_anchor_point
            this.w = view0.findViewById(0x7F0A01D1);  // id:button4_anchor_point
            this.d();
            this.requestLayout();
            return;
        }
        LogU.e("SortBarView", "Invalid sort bar style");
    }
}

