package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import g.a;
import k.m;
import k.x;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, x {
    public m a;
    public ImageView b;
    public RadioButton c;
    public TextView d;
    public CheckBox e;
    public TextView f;
    public ImageView g;
    public ImageView h;
    public LinearLayout i;
    public final Drawable j;
    public final int k;
    public final Context l;
    public boolean m;
    public final Drawable n;
    public final boolean o;
    public LayoutInflater r;
    public boolean w;

    public ListMenuItemView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403BF);  // attr:listMenuViewStyle
    }

    public ListMenuItemView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0);
        d5.m m0 = d5.m.r(this.getContext(), attributeSet0, a.t, v);
        this.j = m0.k(5);
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.k = typedArray0.getResourceId(1, -1);
        this.m = typedArray0.getBoolean(7, false);
        this.l = context0;
        this.n = m0.k(8);
        TypedArray typedArray1 = context0.getTheme().obtainStyledAttributes(null, new int[]{0x1010129}, 0x7F040229, 0);  // attr:dropDownListViewStyle
        this.o = typedArray1.hasValue(0);
        m0.t();
        typedArray1.recycle();
    }

    @Override  // android.widget.AbsListView$SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect0) {
        if(this.h != null && this.h.getVisibility() == 0) {
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.h.getLayoutParams();
            int v = rect0.top;
            rect0.top = this.h.getHeight() + linearLayout$LayoutParams0.topMargin + linearLayout$LayoutParams0.bottomMargin + v;
        }
    }

    @Override  // k.x
    public final void c(m m0) {
        String s;
        this.a = m0;
        int v = 0;
        this.setVisibility((m0.isVisible() ? 0 : 8));
        this.setTitle(m0.e);
        this.setCheckable(m0.isCheckable());
        boolean z = m0.n.o() && (m0.n.n() ? m0.j : m0.h) != 0;
        m0.n.n();
        if(z) {
            m m1 = this.a;
            if(!m1.n.o() || (m1.n.n() ? m1.j : m1.h) == 0) {
                v = 8;
            }
            else {
                TextView textView0 = this.f;
                m m2 = this.a;
                MenuBuilder menuBuilder0 = m2.n;
                Context context0 = menuBuilder0.a;
                int v1 = menuBuilder0.n() ? m2.j : m2.h;
                if(v1 == 0) {
                    s = "";
                }
                else {
                    context0.getResources();
                    StringBuilder stringBuilder0 = new StringBuilder();
                    if(ViewConfiguration.get(context0).hasPermanentMenuKey()) {
                        stringBuilder0.append("Menu+");
                    }
                    int v2 = menuBuilder0.n() ? m2.k : m2.i;
                    m.c(v2, 0x10000, "Meta+", stringBuilder0);
                    m.c(v2, 0x1000, "Ctrl+", stringBuilder0);
                    m.c(v2, 2, "Alt+", stringBuilder0);
                    m.c(v2, 1, "Shift+", stringBuilder0);
                    m.c(v2, 4, "Sym+", stringBuilder0);
                    m.c(v2, 8, "Function+", stringBuilder0);
                    switch(v1) {
                        case 8: {
                            stringBuilder0.append("delete");
                            break;
                        }
                        case 10: {
                            stringBuilder0.append("enter");
                            break;
                        }
                        case 0x20: {
                            stringBuilder0.append("space");
                            break;
                        }
                        default: {
                            stringBuilder0.append(((char)v1));
                        }
                    }
                    s = stringBuilder0.toString();
                }
                textView0.setText(s);
            }
        }
        else {
            v = 8;
        }
        if(this.f.getVisibility() != v) {
            this.f.setVisibility(v);
        }
        this.setIcon(m0.getIcon());
        this.setEnabled(m0.isEnabled());
        this.setSubMenuArrowVisible(m0.hasSubMenu());
        this.setContentDescription(m0.q);
    }

    private LayoutInflater getInflater() {
        if(this.r == null) {
            this.r = LayoutInflater.from(this.getContext());
        }
        return this.r;
    }

    @Override  // k.x
    public m getItemData() {
        return this.a;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.setBackground(this.j);
        TextView textView0 = (TextView)this.findViewById(0x7F0A0B8D);  // id:title
        this.d = textView0;
        int v = this.k;
        if(v != -1) {
            textView0.setTextAppearance(this.l, v);
        }
        this.f = (TextView)this.findViewById(0x7F0A0A87);  // id:shortcut
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0B00);  // id:submenuarrow
        this.g = imageView0;
        if(imageView0 != null) {
            imageView0.setImageDrawable(this.n);
        }
        this.h = (ImageView)this.findViewById(0x7F0A0500);  // id:group_divider
        this.i = (LinearLayout)this.findViewById(0x7F0A0335);  // id:content
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        if(this.b != null && this.m) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
            int v2 = viewGroup$LayoutParams0.height;
            if(v2 > 0 && linearLayout$LayoutParams0.width <= 0) {
                linearLayout$LayoutParams0.width = v2;
            }
        }
        super.onMeasure(v, v1);
    }

    public void setCheckable(boolean z) {
        CheckBox checkBox0;
        RadioButton radioButton1;
        if(z || this.c != null || this.e != null) {
            if((this.a.x & 4) == 0) {
                if(this.e == null) {
                    CheckBox checkBox1 = (CheckBox)this.getInflater().inflate(0x7F0D000E, this, false);  // layout:abc_list_menu_item_checkbox
                    this.e = checkBox1;
                    LinearLayout linearLayout1 = this.i;
                    if(linearLayout1 == null) {
                        this.addView(checkBox1, -1);
                    }
                    else {
                        linearLayout1.addView(checkBox1, -1);
                    }
                }
                radioButton1 = this.e;
                checkBox0 = this.c;
            }
            else {
                if(this.c == null) {
                    RadioButton radioButton0 = (RadioButton)this.getInflater().inflate(0x7F0D0011, this, false);  // layout:abc_list_menu_item_radio
                    this.c = radioButton0;
                    LinearLayout linearLayout0 = this.i;
                    if(linearLayout0 == null) {
                        this.addView(radioButton0, -1);
                    }
                    else {
                        linearLayout0.addView(radioButton0, -1);
                    }
                }
                radioButton1 = this.c;
                checkBox0 = this.e;
            }
            if(z) {
                radioButton1.setChecked(this.a.isChecked());
                if(radioButton1.getVisibility() != 0) {
                    radioButton1.setVisibility(0);
                }
                if(checkBox0 != null && checkBox0.getVisibility() != 8) {
                    checkBox0.setVisibility(8);
                }
            }
            else {
                CheckBox checkBox2 = this.e;
                if(checkBox2 != null) {
                    checkBox2.setVisibility(8);
                }
                RadioButton radioButton2 = this.c;
                if(radioButton2 != null) {
                    radioButton2.setVisibility(8);
                }
            }
        }
    }

    public void setChecked(boolean z) {
        RadioButton radioButton1;
        if((this.a.x & 4) == 0) {
            if(this.e == null) {
                CheckBox checkBox0 = (CheckBox)this.getInflater().inflate(0x7F0D000E, this, false);  // layout:abc_list_menu_item_checkbox
                this.e = checkBox0;
                LinearLayout linearLayout1 = this.i;
                if(linearLayout1 == null) {
                    this.addView(checkBox0, -1);
                }
                else {
                    linearLayout1.addView(checkBox0, -1);
                }
            }
            radioButton1 = this.e;
        }
        else {
            if(this.c == null) {
                RadioButton radioButton0 = (RadioButton)this.getInflater().inflate(0x7F0D0011, this, false);  // layout:abc_list_menu_item_radio
                this.c = radioButton0;
                LinearLayout linearLayout0 = this.i;
                if(linearLayout0 == null) {
                    this.addView(radioButton0, -1);
                }
                else {
                    linearLayout0.addView(radioButton0, -1);
                }
            }
            radioButton1 = this.c;
        }
        radioButton1.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.w = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView0 = this.h;
        if(imageView0 != null) {
            imageView0.setVisibility((this.o || !z ? 8 : 0));
        }
    }

    public void setIcon(Drawable drawable0) {
        boolean z = this.w;
        if(z || this.m) {
            ImageView imageView0 = this.b;
            if(imageView0 != null || drawable0 != null || this.m) {
                if(imageView0 == null) {
                    ImageView imageView1 = (ImageView)this.getInflater().inflate(0x7F0D000F, this, false);  // layout:abc_list_menu_item_icon
                    this.b = imageView1;
                    LinearLayout linearLayout0 = this.i;
                    if(linearLayout0 == null) {
                        this.addView(imageView1, 0);
                    }
                    else {
                        linearLayout0.addView(imageView1, 0);
                    }
                }
                if(drawable0 == null && !this.m) {
                    this.b.setVisibility(8);
                    return;
                }
                ImageView imageView2 = this.b;
                if(!z) {
                    drawable0 = null;
                }
                imageView2.setImageDrawable(drawable0);
                if(this.b.getVisibility() != 0) {
                    this.b.setVisibility(0);
                }
            }
        }
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView0 = this.g;
        if(imageView0 != null) {
            imageView0.setVisibility((z ? 0 : 8));
        }
    }

    public void setTitle(CharSequence charSequence0) {
        if(charSequence0 != null) {
            this.d.setText(charSequence0);
            if(this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
        else if(this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }
}

