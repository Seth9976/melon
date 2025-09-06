package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import k.l;

public class AlertDialog.Builder {
    public final AlertController.AlertParams a;
    public final int b;

    public AlertDialog.Builder(Context context0) {
        this(context0, g.d(context0, 0));
    }

    public AlertDialog.Builder(Context context0, int v) {
        this.a = new AlertController.AlertParams(new ContextThemeWrapper(context0, g.d(context0, v)));
        this.b = v;
    }

    public g a() {
        AlertController.AlertParams alertController$AlertParams0 = this.a;
        g g0 = new g(alertController$AlertParams0.a, this.b);
        View view0 = alertController$AlertParams0.f;
        f f0 = g0.f;
        if(view0 == null) {
            CharSequence charSequence0 = alertController$AlertParams0.e;
            if(charSequence0 != null) {
                f0.d = charSequence0;
                TextView textView0 = f0.v;
                if(textView0 != null) {
                    textView0.setText(charSequence0);
                }
            }
            Drawable drawable0 = alertController$AlertParams0.d;
            if(drawable0 != null) {
                f0.t = drawable0;
                f0.s = 0;
                ImageView imageView0 = f0.u;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                    f0.u.setImageDrawable(drawable0);
                }
            }
            int v = alertController$AlertParams0.c;
            if(v != 0) {
                f0.t = null;
                f0.s = v;
                ImageView imageView1 = f0.u;
                if(imageView1 != null) {
                    imageView1.setVisibility(0);
                    f0.u.setImageResource(f0.s);
                }
            }
        }
        else {
            f0.x = view0;
        }
        CharSequence charSequence1 = alertController$AlertParams0.g;
        if(charSequence1 != null) {
            f0.e = charSequence1;
            TextView textView1 = f0.w;
            if(textView1 != null) {
                textView1.setText(charSequence1);
            }
        }
        CharSequence charSequence2 = alertController$AlertParams0.h;
        if(charSequence2 != null) {
            f0.c(-1, charSequence2, alertController$AlertParams0.i);
        }
        CharSequence charSequence3 = alertController$AlertParams0.j;
        if(charSequence3 != null) {
            f0.c(-2, charSequence3, alertController$AlertParams0.k);
        }
        CharSequence charSequence4 = alertController$AlertParams0.l;
        if(charSequence4 != null) {
            f0.c(-3, charSequence4, alertController$AlertParams0.m);
        }
        if(alertController$AlertParams0.q != null) {
            AlertController.RecycleListView alertController$RecycleListView0 = (AlertController.RecycleListView)alertController$AlertParams0.b.inflate(f0.B, null);
            int v1 = alertController$AlertParams0.t ? f0.C : f0.D;
            ListAdapter listAdapter0 = alertController$AlertParams0.q;
            if(listAdapter0 == null) {
                listAdapter0 = new e(alertController$AlertParams0.a, v1, 0x1020014, null);  // 初始化器: Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;II[Ljava/lang/Object;)V
            }
            f0.y = listAdapter0;
            f0.z = alertController$AlertParams0.u;
            if(alertController$AlertParams0.r != null) {
                alertController$RecycleListView0.setOnItemClickListener(new c(alertController$AlertParams0, f0));
            }
            if(alertController$AlertParams0.t) {
                alertController$RecycleListView0.setChoiceMode(1);
            }
            f0.f = alertController$RecycleListView0;
        }
        View view1 = alertController$AlertParams0.s;
        if(view1 != null) {
            f0.g = view1;
            f0.h = false;
        }
        g0.setCancelable(alertController$AlertParams0.n);
        if(alertController$AlertParams0.n) {
            g0.setCanceledOnTouchOutside(true);
        }
        g0.setOnCancelListener(alertController$AlertParams0.o);
        g0.setOnDismissListener(null);
        l l0 = alertController$AlertParams0.p;
        if(l0 != null) {
            g0.setOnKeyListener(l0);
        }
        return g0;
    }

    public void b(int v, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a.l = this.a.a.getText(v);
        this.a.m = dialogInterface$OnClickListener0;
    }

    public void c(DialogInterface.OnCancelListener dialogInterface$OnCancelListener0) {
        this.a.o = dialogInterface$OnCancelListener0;
    }

    public void d(int v, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a.h = this.a.a.getText(v);
        this.a.i = dialogInterface$OnClickListener0;
    }
}

