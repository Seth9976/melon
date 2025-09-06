package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import d5.w;
import java.io.IOException;
import java.util.ArrayList;
import l4.O;

public final class b extends ArrayAdapter implements AdapterView.OnItemClickListener {
    public final LayoutInflater a;
    public final Drawable b;
    public final Drawable c;
    public final Drawable d;
    public final Drawable e;

    public b(Context context0, ArrayList arrayList0) {
        super(context0, 0, arrayList0);
        this.a = LayoutInflater.from(context0);
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(new int[]{0x7F040432, 0x7F04043B, 0x7F040438, 0x7F040437});  // attr:mediaRouteDefaultIconDrawable
        this.b = w.B(context0, typedArray0.getResourceId(0, 0));
        this.c = w.B(context0, typedArray0.getResourceId(1, 0));
        this.d = w.B(context0, typedArray0.getResourceId(2, 0));
        this.e = w.B(context0, typedArray0.getResourceId(3, 0));
        typedArray0.recycle();
    }

    @Override  // android.widget.BaseAdapter
    public final boolean areAllItemsEnabled() {
        return false;
    }

    @Override  // android.widget.ArrayAdapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        Drawable drawable0;
        Drawable drawable1;
        if(view0 == null) {
            view0 = this.a.inflate(0x7F0D0527, viewGroup0, false);  // layout:mr_chooser_list_item
        }
        O o0 = (O)this.getItem(v);
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0844);  // id:mr_chooser_route_name
        TextView textView1 = (TextView)view0.findViewById(0x7F0A0842);  // id:mr_chooser_route_desc
        textView0.setText(o0.d);
        String s = o0.e;
        if(o0.i != 1 && o0.i != 2 || TextUtils.isEmpty(s)) {
            textView0.setGravity(16);
            textView1.setVisibility(8);
            textView1.setText("");
        }
        else {
            textView0.setGravity(80);
            textView1.setVisibility(0);
            textView1.setText(s);
        }
        view0.setEnabled(o0.g);
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0843);  // id:mr_chooser_route_icon
        if(imageView0 != null) {
            Uri uri0 = o0.f;
            if(uri0 == null) {
            label_26:
                switch(o0.n) {
                    case 1: {
                        drawable1 = this.c;
                        break;
                    }
                    case 2: {
                        drawable1 = this.d;
                        break;
                    }
                    default: {
                        drawable1 = o0.e() ? this.e : this.b;
                    }
                }
                drawable0 = drawable1;
            }
            else {
                try {
                    drawable0 = Drawable.createFromStream(this.getContext().getContentResolver().openInputStream(uri0), null);
                }
                catch(IOException iOException0) {
                    Log.w("MediaRouteChooserDialog", "Failed to load " + uri0, iOException0);
                    goto label_26;
                }
                if(drawable0 == null) {
                    goto label_26;
                }
            }
            imageView0.setImageDrawable(drawable0);
        }
        return view0;
    }

    @Override  // android.widget.BaseAdapter
    public final boolean isEnabled(int v) {
        return ((O)this.getItem(v)).g;
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        O o0 = (O)this.getItem(v);
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0843);  // id:mr_chooser_route_icon
        ProgressBar progressBar0 = (ProgressBar)view0.findViewById(0x7F0A0845);  // id:mr_chooser_route_progress_bar
        if(imageView0 != null && progressBar0 != null) {
            imageView0.setVisibility(8);
            progressBar0.setVisibility(0);
        }
        o0.l(true);
    }
}

