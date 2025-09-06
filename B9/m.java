package B9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.FollowToggleButton;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.jvm.internal.q;

public final class m extends O0 {
    public final View a;
    public final BorderImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final FollowToggleButton h;
    public final ImageView i;
    public static final int j;

    public m(View view0) {
        super(view0);
        View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
        q.f(view1, "findViewById(...)");
        this.a = view1;
        View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.f(view2, "findViewById(...)");
        View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.f(view3, "findViewById(...)");
        this.b = (BorderImageView)view3;
        View view4 = view0.findViewById(0x7F0A068D);  // id:iv_sns_icon
        q.f(view4, "findViewById(...)");
        this.c = (ImageView)view4;
        View view5 = view0.findViewById(0x7F0A0C64);  // id:tv_dj
        q.f(view5, "findViewById(...)");
        this.d = (TextView)view5;
        View view6 = view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
        q.f(view6, "findViewById(...)");
        this.e = (TextView)view6;
        View view7 = view0.findViewById(0x7F0A0D1F);  // id:tv_subtitle
        q.f(view7, "findViewById(...)");
        this.f = (TextView)view7;
        View view8 = view0.findViewById(0x7F0A0D20);  // id:tv_subtitle2
        q.f(view8, "findViewById(...)");
        TextView textView0 = (TextView)view8;
        View view9 = view0.findViewById(0x7F0A06B2);  // id:iv_verify_icon
        q.f(view9, "findViewById(...)");
        this.g = (ImageView)view9;
        View view10 = view0.findViewById(0x7F0A04D3);  // id:follow_toggle_button
        q.f(view10, "findViewById(...)");
        this.h = (FollowToggleButton)view10;
        View view11 = view0.findViewById(0x7F0A0610);  // id:iv_check
        q.f(view11, "findViewById(...)");
        this.i = (ImageView)view11;
        ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(view0.getContext(), 72.0f), true);
    }

    public final void a(String s) {
        TextView textView0 = this.f;
        if(s != null && s.length() != 0) {
            textView0.setVisibility(0);
            textView0.setText(s);
            return;
        }
        textView0.setVisibility(8);
    }

    public final void b(String s) {
        int v = ResourceUtils.getDjIconColorId(s);
        TextView textView0 = this.d;
        if(v > -1) {
            ViewUtils.showWhen(textView0, true);
            textView0.setTextColor(ColorUtils.getColor(textView0.getContext(), v));
            return;
        }
        ViewUtils.hideWhen(textView0, true);
    }

    public final void c(String s) {
        Glide.with(this.b.getContext()).load(s).apply(RequestOptions.circleCropTransform()).into(this.b);
    }
}

