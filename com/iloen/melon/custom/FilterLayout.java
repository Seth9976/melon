package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.media3.session.legacy.V;
import androidx.mediarouter.app.v;
import com.iloen.melon.fragments.mymusic.M;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class FilterLayout extends RelativeLayout {
    public final LinearLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public M d;
    public K e;
    public J f;
    public ColorStateList g;
    public float h;
    public final H i;
    public final H j;

    public FilterLayout(Context context0) {
        this(context0, null);
    }

    public FilterLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public FilterLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i = new H(this, 0);
        this.j = new H(this, 1);
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.G, v, 0);
        this.g = typedArray0.getColorStateList(1);
        this.h = (float)typedArray0.getDimensionPixelSize(0, 0);
        typedArray0.recycle();
        View view0 = ((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D026C, this, true);  // layout:filter_layout
        this.b = (FrameLayout)view0.findViewById(0x7F0A0757);  // id:left_button_container
        this.c = (FrameLayout)view0.findViewById(0x7F0A09F6);  // id:right_button_container
        this.a = (LinearLayout)view0.findViewById(0x7F0A0AB9);  // id:sort_bar_container
    }

    public final void a(I i0, M m0) {
        int v1;
        int v;
        this.d = m0;
        this.b.removeAllViews();
        if(i0 == I.c) {
            v = 0x7F0D0260;  // layout:filter_add_button
            v1 = 0x7F0A04A5;  // id:filter_view_left_button
            goto label_9;
        }
        else if(i0 == I.d) {
            v = 0x7F0D026A;  // layout:filter_edit_left_button
            v1 = 0x7F0A04A4;  // id:filter_view_edit_button
        label_9:
            LayoutInflater.from(this.getContext()).inflate(v, this.b, true);
            View view0 = this.b.findViewById(v1);
            if(view0 != null) {
                ViewUtils.setOnClickListener(view0, this.i);
            }
            this.requestLayout();
        }
    }

    public final void b(I i0, J j0) {
        int v;
        this.f = j0;
        this.b.removeAllViews();
        I i1 = I.e;
        if(i0 == I.a) {
            v = 0x7F0D0266;  // layout:filter_check_bottom_text_layout
            goto label_11;
        }
        else if(i0 == I.b) {
            v = 0x7F0D0267;  // layout:filter_check_right_text_layout
            goto label_11;
        }
        else if(i0 == i1) {
            v = 0x7F0D026E;  // layout:filter_new_check_right_text_layout
        label_11:
            this.setLeftContainerHeight(i0 == i1);
            LayoutInflater.from(this.getContext()).inflate(v, this.b, true);
            CheckableTextView checkableTextView0 = (CheckableTextView)this.getCheckButton();
            if(checkableTextView0 != null) {
                ViewUtils.setOnClickListener(checkableTextView0, new v(1, this, checkableTextView0));
                V v1 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
                v1.c = this;
                v1.a = i0;
                v1.b = checkableTextView0;
                checkableTextView0.setOnCheckedChangeListener(v1);
            }
        }
    }

    public final void c(L l0, K k0) {
        View view1;
        int v;
        this.e = k0;
        this.c.removeAllViews();
        ((RelativeLayout.LayoutParams)this.c.getLayoutParams()).addRule(15);
        L l1 = L.e;
        if(l0 == L.b) {
            v = 0x7F0D0271;  // layout:filter_play_bottom_text_layout
            goto label_27;
        }
        else if(l0 == l1) {
            v = 0x7F0D0272;  // layout:filter_play_bottom_with_shuffle_text_layout
            goto label_27;
        }
        else if(l0 == L.c) {
            v = 0x7F0D0273;  // layout:filter_play_left_text_layout
            goto label_27;
        }
        else if(l0 == L.d) {
            v = 0x7F0D0270;  // layout:filter_play_all_left_text_layout
            goto label_27;
        }
        else if(l0 == L.f) {
            v = 0x7F0D026B;  // layout:filter_edit_right_button
            goto label_27;
        }
        else if(l0 == L.g) {
            v = 0x7F0D0276;  // layout:filter_refresh_button
            goto label_27;
        }
        else if(l0 == L.h) {
            v = 0x7F0D026F;  // layout:filter_new_drop_down_layout
            goto label_27;
        }
        else if(l0 == L.i) {
            v = 0x7F0D0274;  // layout:filter_playlist_duration
        label_27:
            View view0 = LayoutInflater.from(this.getContext()).inflate(v, this.c, true);
            H h0 = this.j;
            ViewUtils.setOnClickListener(view0, h0);
            if(l0 == l1) {
                FrameLayout frameLayout0 = this.c;
                if(frameLayout0 == null) {
                    view1 = null;
                }
                else {
                    int v1 = l0 == l1 ? 0x7F0A04A9 : -1;  // id:filter_view_shuffle_layout
                    view1 = v1 == -1 ? null : frameLayout0.findViewById(v1);
                }
                if(view1 != null) {
                    ViewUtils.setOnClickListener(view1, h0);
                }
            }
            this.requestLayout();
        }
    }

    public void d() {
    }

    private View getCheckButton() {
        return this.b == null ? null : this.b.findViewById(0x7F0A04A2);  // id:filter_view_check_button
    }

    public ColorStateList getTextColor() {
        return this.g;
    }

    public float getTextSize() {
        return this.h;
    }

    public void setCheckButtonChecked(boolean z) {
        CheckableTextView checkableTextView0 = (CheckableTextView)this.b.findViewById(0x7F0A04A2);  // id:filter_view_check_button
        if(checkableTextView0 != null) {
            checkableTextView0.setChecked(z);
        }
    }

    public void setCheckButtonText(String s) {
        View view0 = this.getCheckButton();
        if(!(view0 instanceof CheckableTextView)) {
            LogU.w("FilterLayout", "setCheckButtonText() invalid check button");
            return;
        }
        if(!TextUtils.isEmpty(((TextView)view0).getText())) {
            if(TextUtils.isEmpty(s)) {
                s = "";
            }
            ((TextView)view0).setText(s);
        }
    }

    public void setCheckButtonTextColor(int v) {
        View view0 = this.getCheckButton();
        if(!(view0 instanceof CheckableTextView)) {
            LogU.w("FilterLayout", "setCheckButtonText() invalid check button");
            return;
        }
        if(!TextUtils.isEmpty(((TextView)view0).getText())) {
            ((TextView)view0).setTextColor(v);
        }
    }

    public void setLeftButton(I i0) {
        this.a(i0, null);
    }

    private void setLeftContainerHeight(boolean z) {
        Context context0 = this.getContext();
        if(context0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.b.getLayoutParams();
            viewGroup$LayoutParams0.height = z ? context0.getResources().getDimensionPixelSize(0x7F0703F2) : context0.getResources().getDimensionPixelSize(0x7F07043A);  // dimen:new_filter_layout_height
        }
    }

    public void setOnCheckedListener(J j0) {
        this.b(I.a, j0);
    }

    public void setRightLayout(L l0) {
        this.c(l0, null);
    }

    public void setSortBarHeight(int v) {
        if(v > 0) {
            LinearLayout linearLayout0 = this.a;
            if(linearLayout0 != null) {
                linearLayout0.getLayoutParams().height = v;
                this.requestLayout();
            }
        }
    }

    public void setTextColor(ColorStateList colorStateList0) {
        this.g = colorStateList0;
        this.d();
    }

    public void setTextSize(float f) {
        this.h = (float)ScreenUtils.dipToPixel(this.getContext(), f);
        this.d();
    }
}

