package androidx.mediarouter.app;

import De.I;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import java.io.IOException;
import java.util.ArrayList;
import l4.O;

public final class x extends j0 {
    public final ArrayList a;
    public final LayoutInflater b;
    public final Drawable c;
    public final Drawable d;
    public final Drawable e;
    public final Drawable f;
    public final MediaRouteDynamicChooserDialog g;

    public x(MediaRouteDynamicChooserDialog mediaRouteDynamicChooserDialog0) {
        this.g = mediaRouteDynamicChooserDialog0;
        super();
        this.a = new ArrayList();
        this.b = LayoutInflater.from(mediaRouteDynamicChooserDialog0.h);
        this.c = I.H(mediaRouteDynamicChooserDialog0.h, 0x7F040432);  // attr:mediaRouteDefaultIconDrawable
        this.d = I.H(mediaRouteDynamicChooserDialog0.h, 0x7F04043B);  // attr:mediaRouteTvIconDrawable
        this.e = I.H(mediaRouteDynamicChooserDialog0.h, 0x7F040438);  // attr:mediaRouteSpeakerIconDrawable
        this.f = I.H(mediaRouteDynamicChooserDialog0.h, 0x7F040437);  // attr:mediaRouteSpeakerGroupIconDrawable
        this.a();
    }

    public final void a() {
        ArrayList arrayList0 = this.a;
        arrayList0.clear();
        arrayList0.add(new u("Cast to"));
        for(Object object0: this.g.j) {
            arrayList0.add(new u(((O)object0)));
        }
        this.notifyDataSetChanged();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return this.a.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemViewType(int v) {
        return ((u)this.a.get(v)).b;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        Drawable drawable0;
        Drawable drawable1;
        int v1 = this.getItemViewType(v);
        u u0 = (u)this.a.get(v);
        switch(v1) {
            case 1: {
                ((t)o00).getClass();
                ((t)o00).a.setText(u0.a.toString());
                return;
            }
            case 2: {
                ((w)o00).getClass();
                O o0 = (O)u0.a;
                ((w)o00).a.setVisibility(0);
                ((w)o00).c.setVisibility(4);
                v v2 = new v(0, ((w)o00), o0);
                ((w)o00).a.setOnClickListener(v2);
                ((w)o00).d.setText(o0.d);
                ImageView imageView0 = ((w)o00).b;
                x x0 = ((w)o00).e;
                Uri uri0 = o0.f;
                if(uri0 == null) {
                label_25:
                    switch(o0.n) {
                        case 1: {
                            drawable1 = x0.d;
                            break;
                        }
                        case 2: {
                            drawable1 = x0.e;
                            break;
                        }
                        default: {
                            drawable1 = o0.e() ? x0.f : x0.c;
                        }
                    }
                    drawable0 = drawable1;
                }
                else {
                    try {
                        drawable0 = Drawable.createFromStream(x0.g.h.getContentResolver().openInputStream(uri0), null);
                    }
                    catch(IOException iOException0) {
                        Log.w("RecyclerAdapter", "Failed to load " + uri0, iOException0);
                        goto label_25;
                    }
                    if(drawable0 == null) {
                        goto label_25;
                    }
                }
                imageView0.setImageDrawable(drawable0);
                return;
            }
            default: {
                Log.w("RecyclerAdapter", "Cannot bind item to ViewHolder because of wrong view type");
            }
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        LayoutInflater layoutInflater0 = this.b;
        switch(v) {
            case 1: {
                View view0 = layoutInflater0.inflate(0x7F0D052B, viewGroup0, false);  // layout:mr_picker_header_item
                O0 o00 = new t(view0);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
                o00.a = (TextView)view0.findViewById(0x7F0A085C);  // id:mr_picker_header_name
                return o00;
            }
            case 2: {
                return new w(this, layoutInflater0.inflate(0x7F0D052C, viewGroup0, false));  // layout:mr_picker_route_item
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
}

