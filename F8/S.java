package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import kotlin.jvm.internal.q;

public final class s extends w {
    public final int g;
    public Object h;

    public s() {
        this.g = 0;
        super();
    }

    public s(String s) {
        this.g = 1;
        super();
        this.h = s;
    }

    @Override  // F8.o
    public boolean b() {
        return this.g == 0 ? false : super.b();
    }

    @Override  // F8.o
    public final View c(Context context0) {
        if(this.g != 0) {
            View view0 = new ImageView(context0);
            ((RequestBuilder)Glide.with(context0).asDrawable().load(((String)this.h)).override(0x80000000)).into(new u(((ImageView)view0), context0, 0));
            return view0;
        }
        View view1 = LayoutInflater.from(context0).inflate(0x7F0D0886, null);  // layout:titlebar_left_comment_button
        this.h = (TextView)view1.findViewById(0x7F0A0D3B);  // id:tv_title_left_cmt_count
        return view1;
    }

    @Override  // F8.o
    public final View d(View view0) {
        if(this.g != 0) {
            q.g(view0, "newView");
            return view0;
        }
        q.g(view0, "newView");
        return view0.findViewById(0x7F0A0D3C);  // id:tv_title_left_cmt_title
    }

    @Override  // F8.o
    public final String e(Context context0) {
        if(this.g != 0) {
            q.f("MMA", "getString(...)");
            return "MMA";
        }
        q.f("댓글", "getString(...)");
        return "댓글";
    }

    @Override  // F8.w
    public String f(Context context0) {
        return this.g == 1 ? "MMA" : super.f(context0);
    }

    @Override  // F8.w
    public final int i() {
        return this.g == 0 ? 4 : 1;
    }
}

