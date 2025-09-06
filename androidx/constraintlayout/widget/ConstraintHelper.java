package androidx.constraintlayout.widget;

import F1.e;
import F1.j;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {
    public int[] a;
    public int b;
    public final Context c;
    public j d;
    public boolean e;
    public String f;
    public String g;
    public View[] h;
    public final HashMap i;

    public ConstraintHelper(Context context0) {
        super(context0);
        this.a = new int[0x20];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context0;
        this.j(null);
    }

    public ConstraintHelper(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new int[0x20];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context0;
        this.j(attributeSet0);
    }

    public ConstraintHelper(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new int[0x20];
        this.e = false;
        this.h = null;
        this.i = new HashMap();
        this.c = context0;
        this.j(attributeSet0);
    }

    public final void a(String s) {
        if(s != null && s.length() != 0 && this.c != null) {
            String s1 = s.trim();
            int v = this.h(s1);
            if(v != 0) {
                this.i.put(v, s1);
                this.b(v);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + s1 + "\"");
        }
    }

    public final void b(int v) {
        if(v == this.getId()) {
            return;
        }
        int[] arr_v = this.a;
        if(this.b + 1 > arr_v.length) {
            this.a = Arrays.copyOf(arr_v, arr_v.length * 2);
        }
        int v1 = this.b;
        this.a[v1] = v;
        this.b = v1 + 1;
    }

    public final void c(String s) {
        if(s != null && s.length() != 0 && this.c != null) {
            String s1 = s.trim();
            ConstraintLayout constraintLayout0 = this.getParent() instanceof ConstraintLayout ? ((ConstraintLayout)this.getParent()) : null;
            if(constraintLayout0 == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int v = constraintLayout0.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = constraintLayout0.getChildAt(v1);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(viewGroup$LayoutParams0 instanceof LayoutParams && s1.equals(((LayoutParams)viewGroup$LayoutParams0).Y)) {
                    if(view0.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + view0.getClass().getSimpleName() + " must have an ID");
                    }
                    else {
                        this.b(view0.getId());
                    }
                }
            }
        }
    }

    public final void d() {
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 != null && viewParent0 instanceof ConstraintLayout) {
            this.e(((ConstraintLayout)viewParent0));
        }
    }

    public final void e(ConstraintLayout constraintLayout0) {
        int v = this.getVisibility();
        float f = this.getElevation();
        for(int v1 = 0; v1 < this.b; ++v1) {
            View view0 = constraintLayout0.getViewById(this.a[v1]);
            if(view0 != null) {
                view0.setVisibility(v);
                if(f > 0.0f) {
                    view0.setTranslationZ(view0.getTranslationZ() + f);
                }
            }
        }
    }

    public void f(ConstraintLayout constraintLayout0) {
    }

    public final int g(ConstraintLayout constraintLayout0, String s) {
        if(s != null) {
            Resources resources0 = this.c.getResources();
            if(resources0 != null) {
                int v = constraintLayout0.getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view0 = constraintLayout0.getChildAt(v1);
                    if(view0.getId() != -1) {
                        try {
                            String s1 = null;
                            s1 = resources0.getResourceEntryName(view0.getId());
                        }
                        catch(Resources.NotFoundException unused_ex) {
                        }
                        if(s.equals(s1)) {
                            return view0.getId();
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.a, this.b);
    }

    public final int h(String s) {
        ConstraintLayout constraintLayout0 = this.getParent() instanceof ConstraintLayout ? ((ConstraintLayout)this.getParent()) : null;
        int v = 0;
        if(this.isInEditMode() && constraintLayout0 != null) {
            Object object0 = constraintLayout0.getDesignInformation(0, s);
            if(object0 instanceof Integer) {
                v = (int)(((Integer)object0));
            }
        }
        if(v == 0 && constraintLayout0 != null) {
            v = this.g(constraintLayout0, s);
        }
        if(v == 0) {
            try {
                v = p.class.getField(s).getInt(null);
            }
            catch(Exception unused_ex) {
            }
        }
        return v == 0 ? this.c.getResources().getIdentifier(s, "id", "com.iloen.melon") : v;
    }

    public final View[] i(ConstraintLayout constraintLayout0) {
        if(this.h == null || this.h.length != this.b) {
            this.h = new View[this.b];
        }
        for(int v = 0; v < this.b; ++v) {
            View[] arr_view = this.h;
            arr_view[v] = constraintLayout0.getViewById(this.a[v]);
        }
        return this.h;
    }

    public void j(AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 35) {
                    String s = typedArray0.getString(35);
                    this.f = s;
                    this.setIds(s);
                }
                else if(v2 == 36) {
                    String s1 = typedArray0.getString(36);
                    this.g = s1;
                    this.setReferenceTags(s1);
                }
            }
            typedArray0.recycle();
        }
    }

    public void k(i i0, j j0, androidx.constraintlayout.widget.Constraints.LayoutParams constraints$LayoutParams0, SparseArray sparseArray0) {
        androidx.constraintlayout.widget.j j1 = i0.e;
        int[] arr_v = j1.j0;
        if(arr_v == null) {
            String s = j1.k0;
            if(s != null) {
                if(s.length() > 0) {
                    String[] arr_s = j1.k0.split(",");
                    int[] arr_v1 = new int[arr_s.length];
                    int v2 = 0;
                    for(int v1 = 0; v1 < arr_s.length; ++v1) {
                        int v3 = this.h(arr_s[v1].trim());
                        if(v3 != 0) {
                            arr_v1[v2] = v3;
                            ++v2;
                        }
                    }
                    if(v2 != arr_s.length) {
                        arr_v1 = Arrays.copyOf(arr_v1, v2);
                    }
                    j1.j0 = arr_v1;
                }
                else {
                    j1.j0 = null;
                }
            }
        }
        else {
            this.setReferencedIds(arr_v);
        }
        j0.w0 = 0;
        Arrays.fill(j0.v0, null);
        if(j1.j0 != null) {
            for(int v = 0; true; ++v) {
                int[] arr_v2 = j1.j0;
                if(v >= arr_v2.length) {
                    break;
                }
                e e0 = (e)sparseArray0.get(arr_v2[v]);
                if(e0 != null) {
                    j0.W(e0);
                }
            }
        }
    }

    public void l(e e0, boolean z) {
    }

    public void m() {
    }

    public void n(ConstraintLayout constraintLayout0) {
    }

    public void o(j j0, SparseArray sparseArray0) {
        j0.w0 = 0;
        Arrays.fill(j0.v0, null);
        for(int v = 0; v < this.b; ++v) {
            j0.W(((e)sparseArray0.get(this.a[v])));
        }
    }

    @Override  // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String s = this.f;
        if(s != null) {
            this.setIds(s);
        }
        String s1 = this.g;
        if(s1 != null) {
            this.setReferenceTags(s1);
        }
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        if(this.e) {
            super.onMeasure(v, v1);
            return;
        }
        this.setMeasuredDimension(0, 0);
    }

    public final void p() {
        if(this.d != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
            if(viewGroup$LayoutParams0 instanceof LayoutParams) {
                ((LayoutParams)viewGroup$LayoutParams0).q0 = this.d;
            }
        }
    }

    public void setIds(String s) {
        this.f = s;
        if(s == null) {
            return;
        }
        int v = 0;
        this.b = 0;
        int v1;
        while((v1 = s.indexOf(44, v)) != -1) {
            this.a(s.substring(v, v1));
            v = v1 + 1;
        }
        this.a(s.substring(v));
    }

    public void setReferenceTags(String s) {
        this.g = s;
        if(s == null) {
            return;
        }
        int v = 0;
        this.b = 0;
        int v1;
        while((v1 = s.indexOf(44, v)) != -1) {
            this.c(s.substring(v, v1));
            v = v1 + 1;
        }
        this.c(s.substring(v));
    }

    public void setReferencedIds(int[] arr_v) {
        this.f = null;
        this.b = 0;
        for(int v = 0; v < arr_v.length; ++v) {
            this.b(arr_v[v]);
        }
    }

    @Override  // android.view.View
    public final void setTag(int v, Object object0) {
        super.setTag(v, object0);
        if(object0 == null && this.f == null) {
            this.b(v);
        }
    }
}

