package t9;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import we.n;

public final class i extends oe.i implements n {
    public final int B;
    public final o D;
    public final Context r;
    public final Drawable w;

    public i(Context context0, Drawable drawable0, int v, o o0, Continuation continuation0) {
        this.r = context0;
        this.w = drawable0;
        this.B = v;
        this.D = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Context context0 = this.r;
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0032, null, false);  // layout:app_to_app_share_sticker
        ((ImageView)view0.findViewById(0x7F0A05E3)).setImageDrawable(this.w);  // id:iv_album
        view0.findViewById(0x7F0A0B94).setBackgroundColor(this.B);  // id:title_bg
        view0.findViewById(0x7F0A0B05).setBackgroundColor(this.B);  // id:subtitle_bg
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A064F);  // id:iv_melon_logo
        o o0 = this.D;
        if(o0.a == 5 || o0.a == 6 || o0.a == 7) {
            imageView0.setVisibility(8);
        }
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        TextView textView1 = (TextView)view0.findViewById(0x7F0A0D1F);  // id:tv_subtitle
        if(o0.b.length() > 0) {
            textView0.setVisibility(0);
            textView0.setText(o0.b);
        }
        else {
            textView0.setVisibility(8);
        }
        if(o0.c.length() > 0) {
            textView1.setVisibility(0);
            textView1.setText(o0.c);
            return o.b(o0, context0, o.a(o0, view0), "facebook_share_sticker.png");
        }
        textView1.setVisibility(8);
        return o.b(o0, context0, o.a(o0, view0), "facebook_share_sticker.png");
    }
}

