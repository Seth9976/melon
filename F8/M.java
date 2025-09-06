package F8;

import A6.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.jvm.internal.q;

public class m extends n {
    public TextView g;
    public ImageView h;
    public final int i;
    public final int j;
    public final boolean k;
    public View.OnClickListener l;
    public String m;

    public m(int v, int v1) {
        this(2, false);
        this.j = v;
    }

    public m(int v, boolean z) {
        this.i = v;
        this.k = z;
    }

    @Override  // F8.o
    public boolean b() {
        return false;
    }

    @Override  // F8.o
    public View c(Context context0) {
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0882, null);  // layout:titlebar_center_text
        this.g = (TextView)view0.findViewById(0x7F0A0D41);  // id:tv_titlebar_title
        View view1 = view0.findViewById(0x7F0A0BA6);  // id:title_sub_icon
        q.f(view1, "findViewById(...)");
        this.h = (ImageView)view1;
        View view2 = view0.findViewById(0x7F0A0B93);  // id:title_beta_icon
        q.f(view2, "findViewById(...)");
        ImageView imageView0 = (ImageView)view2;
        TextView textView0 = this.g;
        if(textView0 != null) {
            switch(this.i) {
                case 0: {
                    textView0.setTextColor(ColorUtils.getColor(context0, 0x7F0604A1));  // color:white000e
                    break;
                }
                case 2: {
                    textView0.setTextColor(ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
                    break;
                }
                case 4: {
                    textView0.setTextColor(ColorUtils.getColor(context0, 0x7F06002F));  // color:black
                }
            }
        }
        if(this.j != 0) {
            ImageView imageView1 = this.h;
            if(imageView1 != null) {
                ViewUtils.showWhen(imageView1, true);
                String s = this.m;
                if(s != null) {
                    ImageView imageView2 = this.h;
                    if(imageView2 != null) {
                        imageView2.setContentDescription(s);
                        goto label_29;
                    }
                    q.m("subButtonView");
                    throw null;
                }
            label_29:
                ImageView imageView3 = this.h;
                if(imageView3 != null) {
                    ViewUtils.setOnClickListener(imageView3, new b(this, 3));
                    return view0;
                }
                q.m("subButtonView");
                throw null;
            }
            q.m("subButtonView");
            throw null;
        }
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return this.k ? view0 : null;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        return "";
    }
}

