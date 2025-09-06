package B9;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.CoverView;
import kotlin.jvm.internal.q;

public abstract class f extends O0 {
    public final View a;
    public final CoverView b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final View f;

    public f(View view0) {
        super(view0);
        q.f(view0.getContext(), "getContext(...)");
        this.a = view0;
        View view1 = view0.findViewById(0x7F0A0355);  // id:cover_view
        q.f(view1, "findViewById(...)");
        this.b = (CoverView)view1;
        View view2 = ((CoverView)view1).getPlayButtonView();
        q.f(view2, "getPlayButtonView(...)");
        this.c = view2;
        View view3 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
        q.f(view3, "findViewById(...)");
        this.d = (TextView)view3;
        View view4 = view0.findViewById(0x7F0A00C2);  // id:artist_tv
        q.f(view4, "findViewById(...)");
        this.e = (TextView)view4;
        View view5 = view0.findViewById(0x7F0A0D6B);  // id:underline
        q.f(view5, "findViewById(...)");
        this.f = view5;
    }
}

