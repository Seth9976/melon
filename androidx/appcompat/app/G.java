package androidx.appcompat.app;

import E8.a;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.core.widget.NestedScrollView;
import c2.N;

public class g extends AppCompatDialog implements DialogInterface {
    public final f f;

    public g(Context context0, int v) {
        super(context0, g.d(context0, v));
        this.f = new f(this.getContext(), this, this.getWindow());
    }

    public static int d(Context context0, int v) {
        if((v >>> 24 & 0xFF) >= 1) {
            return v;
        }
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x7F04003A, typedValue0, true);  // attr:alertDialogTheme
        return typedValue0.resourceId;
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public void onCreate(Bundle bundle0) {
        int v2;
        super.onCreate(bundle0);
        f f0 = this.f;
        f0.b.setContentView(f0.A);
        Context context0 = f0.a;
        Window window0 = f0.c;
        View view0 = window0.findViewById(0x7F0A0901);  // id:parentPanel
        View view1 = view0.findViewById(0x7F0A0BCA);  // id:topPanel
        View view2 = view0.findViewById(0x7F0A0336);  // id:contentPanel
        View view3 = view0.findViewById(0x7F0A01D2);  // id:buttonPanel
        ViewGroup viewGroup0 = (ViewGroup)view0.findViewById(0x7F0A0377);  // id:customPanel
        View view4 = f0.g == null ? null : f0.g;
        int v = 0;
        if(view4 == null || !f.a(view4)) {
            window0.setFlags(0x20000, 0x20000);
        }
        if(view4 == null) {
            viewGroup0.setVisibility(8);
        }
        else {
            FrameLayout frameLayout0 = (FrameLayout)window0.findViewById(0x7F0A0376);  // id:custom
            frameLayout0.addView(view4, new ViewGroup.LayoutParams(-1, -1));
            if(f0.h) {
                frameLayout0.setPadding(0, 0, 0, 0);
            }
            if(f0.f != null) {
                ((LayoutParams)viewGroup0.getLayoutParams()).weight = 0.0f;
            }
        }
        View view5 = viewGroup0.findViewById(0x7F0A0BCA);  // id:topPanel
        View view6 = viewGroup0.findViewById(0x7F0A0336);  // id:contentPanel
        View view7 = viewGroup0.findViewById(0x7F0A01D2);  // id:buttonPanel
        ViewGroup viewGroup1 = f.b(view5, view1);
        ViewGroup viewGroup2 = f.b(view6, view2);
        ViewGroup viewGroup3 = f.b(view7, view3);
        NestedScrollView nestedScrollView0 = (NestedScrollView)window0.findViewById(0x7F0A0A2C);  // id:scrollView
        f0.r = nestedScrollView0;
        nestedScrollView0.setFocusable(false);
        f0.r.setNestedScrollingEnabled(false);
        TextView textView0 = (TextView)viewGroup2.findViewById(0x102000B);
        f0.w = textView0;
        if(textView0 != null) {
            CharSequence charSequence0 = f0.e;
            if(charSequence0 == null) {
                textView0.setVisibility(8);
                f0.r.removeView(f0.w);
                if(f0.f == null) {
                    viewGroup2.setVisibility(8);
                }
                else {
                    ViewGroup viewGroup4 = (ViewGroup)f0.r.getParent();
                    int v1 = viewGroup4.indexOfChild(f0.r);
                    viewGroup4.removeViewAt(v1);
                    viewGroup4.addView(f0.f, v1, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            else {
                textView0.setText(charSequence0);
            }
        }
        Button button0 = (Button)viewGroup3.findViewById(0x1020019);
        f0.i = button0;
        a a0 = f0.G;
        button0.setOnClickListener(a0);
        if(TextUtils.isEmpty(f0.j)) {
            f0.i.setVisibility(8);
            v2 = 0;
        }
        else {
            f0.i.setText(f0.j);
            f0.i.setVisibility(0);
            v2 = 1;
        }
        Button button1 = (Button)viewGroup3.findViewById(0x102001A);
        f0.l = button1;
        button1.setOnClickListener(a0);
        if(TextUtils.isEmpty(f0.m)) {
            f0.l.setVisibility(8);
        }
        else {
            f0.l.setText(f0.m);
            f0.l.setVisibility(0);
            v2 |= 2;
        }
        Button button2 = (Button)viewGroup3.findViewById(0x102001B);
        f0.o = button2;
        button2.setOnClickListener(a0);
        if(TextUtils.isEmpty(f0.p)) {
            f0.o.setVisibility(8);
        }
        else {
            f0.o.setText(f0.p);
            f0.o.setVisibility(0);
            v2 |= 4;
        }
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x7F040038, typedValue0, true);  // attr:alertDialogCenterButtons
        if(typedValue0.data != 0) {
            switch(v2) {
                case 1: {
                    Button button3 = f0.i;
                    LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)button3.getLayoutParams();
                    linearLayout$LayoutParams0.gravity = 1;
                    linearLayout$LayoutParams0.weight = 0.5f;
                    button3.setLayoutParams(linearLayout$LayoutParams0);
                    break;
                }
                case 2: {
                    Button button4 = f0.l;
                    LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)button4.getLayoutParams();
                    linearLayout$LayoutParams1.gravity = 1;
                    linearLayout$LayoutParams1.weight = 0.5f;
                    button4.setLayoutParams(linearLayout$LayoutParams1);
                    break;
                }
                case 4: {
                    Button button5 = f0.o;
                    LinearLayout.LayoutParams linearLayout$LayoutParams2 = (LinearLayout.LayoutParams)button5.getLayoutParams();
                    linearLayout$LayoutParams2.gravity = 1;
                    linearLayout$LayoutParams2.weight = 0.5f;
                    button5.setLayoutParams(linearLayout$LayoutParams2);
                }
            }
        }
        if(v2 == 0) {
            viewGroup3.setVisibility(8);
        }
        if(f0.x == null) {
            f0.u = (ImageView)window0.findViewById(0x1020006);
            if(TextUtils.isEmpty(f0.d) || !f0.E) {
                window0.findViewById(0x7F0A0BA7).setVisibility(8);  // id:title_template
                f0.u.setVisibility(8);
                viewGroup1.setVisibility(8);
            }
            else {
                TextView textView1 = (TextView)window0.findViewById(0x7F0A0091);  // id:alertTitle
                f0.v = textView1;
                textView1.setText(f0.d);
                int v3 = f0.s;
                if(v3 == 0) {
                    Drawable drawable0 = f0.t;
                    if(drawable0 == null) {
                        f0.v.setPadding(f0.u.getPaddingLeft(), f0.u.getPaddingTop(), f0.u.getPaddingRight(), f0.u.getPaddingBottom());
                        f0.u.setVisibility(8);
                    }
                    else {
                        f0.u.setImageDrawable(drawable0);
                    }
                }
                else {
                    f0.u.setImageResource(v3);
                }
            }
        }
        else {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = new ViewGroup.LayoutParams(-1, -2);
            viewGroup1.addView(f0.x, 0, viewGroup$LayoutParams0);
            window0.findViewById(0x7F0A0BA7).setVisibility(8);  // id:title_template
        }
        boolean z = viewGroup0.getVisibility() != 8;
        int v4 = viewGroup1 == null || viewGroup1.getVisibility() == 8 ? 0 : 1;
        boolean z1 = viewGroup3.getVisibility() != 8;
        if(!z1) {
            View view8 = viewGroup2.findViewById(0x7F0A0B4E);  // id:textSpacerNoButtons
            if(view8 != null) {
                view8.setVisibility(0);
            }
        }
        if(v4 == 0) {
            View view10 = viewGroup2.findViewById(0x7F0A0B4F);  // id:textSpacerNoTitle
            if(view10 != null) {
                view10.setVisibility(0);
            }
        }
        else {
            NestedScrollView nestedScrollView1 = f0.r;
            if(nestedScrollView1 != null) {
                nestedScrollView1.setClipToPadding(true);
            }
            View view9 = f0.e != null || f0.f != null ? viewGroup1.findViewById(0x7F0A0B8E) : null;  // id:titleDividerNoCustom
            if(view9 != null) {
                view9.setVisibility(0);
            }
        }
        AlertController.RecycleListView alertController$RecycleListView0 = f0.f;
        if(alertController$RecycleListView0 != null && (!z1 || v4 == 0)) {
            alertController$RecycleListView0.setPadding(alertController$RecycleListView0.getPaddingLeft(), (v4 == 0 ? alertController$RecycleListView0.a : alertController$RecycleListView0.getPaddingTop()), alertController$RecycleListView0.getPaddingRight(), (z1 ? alertController$RecycleListView0.getPaddingBottom() : alertController$RecycleListView0.b));
        }
        if(!z) {
            AlertController.RecycleListView alertController$RecycleListView1 = f0.f;
            if(alertController$RecycleListView1 == null) {
                alertController$RecycleListView1 = f0.r;
            }
            if(alertController$RecycleListView1 != null) {
                if(z1) {
                    v = 2;
                }
                View view11 = window0.findViewById(0x7F0A0A2B);  // id:scrollIndicatorUp
                View view12 = window0.findViewById(0x7F0A0A2A);  // id:scrollIndicatorDown
                N.b(alertController$RecycleListView1, v4 | v, 3);
                if(view11 != null) {
                    viewGroup2.removeView(view11);
                }
                if(view12 != null) {
                    viewGroup2.removeView(view12);
                }
            }
        }
        AlertController.RecycleListView alertController$RecycleListView2 = f0.f;
        if(alertController$RecycleListView2 != null) {
            ListAdapter listAdapter0 = f0.y;
            if(listAdapter0 != null) {
                alertController$RecycleListView2.setAdapter(listAdapter0);
                int v5 = f0.z;
                if(v5 > -1) {
                    alertController$RecycleListView2.setItemChecked(v5, true);
                    alertController$RecycleListView2.setSelection(v5);
                }
            }
        }
    }

    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        NestedScrollView nestedScrollView0 = this.f.r;
        return nestedScrollView0 == null || !nestedScrollView0.d(keyEvent0) ? super.onKeyDown(v, keyEvent0) : true;
    }

    @Override  // android.app.Dialog
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        NestedScrollView nestedScrollView0 = this.f.r;
        return nestedScrollView0 == null || !nestedScrollView0.d(keyEvent0) ? super.onKeyUp(v, keyEvent0) : true;
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setTitle(CharSequence charSequence0) {
        super.setTitle(charSequence0);
        this.f.d = charSequence0;
        TextView textView0 = this.f.v;
        if(textView0 != null) {
            textView0.setText(charSequence0);
        }
    }
}

