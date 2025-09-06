package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import k.l;

public class AlertController.AlertParams {
    public final Context a;
    public final LayoutInflater b;
    public int c;
    public Drawable d;
    public CharSequence e;
    public View f;
    public CharSequence g;
    public CharSequence h;
    public DialogInterface.OnClickListener i;
    public CharSequence j;
    public DialogInterface.OnClickListener k;
    public CharSequence l;
    public DialogInterface.OnClickListener m;
    public boolean n;
    public DialogInterface.OnCancelListener o;
    public l p;
    public ListAdapter q;
    public DialogInterface.OnClickListener r;
    public View s;
    public boolean t;
    public int u;

    public AlertController.AlertParams(Context context0) {
        this.c = 0;
        this.u = -1;
        this.a = context0;
        this.n = true;
        this.b = (LayoutInflater)context0.getSystemService("layout_inflater");
    }
}

