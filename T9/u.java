package t9;

import A8.f;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableMusicDna;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class u extends i implements n {
    public final Drawable B;
    public final int D;
    public final z r;
    public final Context w;

    public u(z z0, Context context0, Drawable drawable0, int v, Continuation continuation0) {
        this.r = z0;
        this.w = context0;
        this.B = drawable0;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new u(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        View view0;
        d5.n.D(object0);
        z z0 = this.r;
        String s = z0.c;
        String s1 = z0.b;
        int v = z0.a;
        f f0 = null;
        Drawable drawable0 = this.B;
        Context context0 = this.w;
        if(v == 8) {
            Sharable sharable0 = z0.d;
            view0 = LayoutInflater.from(context0).inflate(0x7F0D0031, null, false);  // layout:app_to_app_share_music_dna_sticker
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A05E3);  // id:iv_album
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = imageView0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            viewGroup$LayoutParams0.width = -2;
            viewGroup$LayoutParams0.height = -2;
            imageView0.setLayoutParams(viewGroup$LayoutParams0);
            imageView0.setImageDrawable(drawable0);
            if(sharable0 instanceof SharableMusicDna) {
                String s2 = ((SharableMusicDna)sharable0).a;
                int v2 = 0x7F080645;  // drawable:img_logo_dna_white
                if(q.b(s2, "MY_DNA")) {
                    z6.f f1 = f.d;
                    String s3 = ((SharableMusicDna)sharable0).b;
                    if(s3 == null) {
                        s3 = "DEFAULT";
                    }
                    f1.getClass();
                    f[] arr_f = f.values();
                    for(int v1 = 0; v1 < arr_f.length; ++v1) {
                        f f2 = arr_f[v1];
                        if(q.b(f2.name(), s3)) {
                            f0 = f2;
                            break;
                        }
                    }
                    if(f0 == null) {
                        f0 = f.e;
                    }
                    if(f0.b == 0x7F06016A) {  // color:gray900e
                        v2 = 0x7F080644;  // drawable:img_logo_dna_black
                    }
                }
                else if(q.b(s2, "RECENT_LOG_GENRE") || ((SharableMusicDna)sharable0).w) {
                    v2 = 0x7F080644;  // drawable:img_logo_dna_black
                }
                ((ImageView)view0.findViewById(0x7F0A064F)).setBackgroundResource(v2);  // id:iv_melon_logo
                return z.b(z0, context0, z.a(z0, view0), "insta_share_sticker.png");
            }
        }
        else {
            View view1 = LayoutInflater.from(context0).inflate(0x7F0D0032, null, false);  // layout:app_to_app_share_sticker
            q.f(view1, "inflate(...)");
            ((ImageView)view1.findViewById(0x7F0A05E3)).setImageDrawable(drawable0);  // id:iv_album
            view1.findViewById(0x7F0A0B94).setBackgroundColor(this.D);  // id:title_bg
            view1.findViewById(0x7F0A0B05).setBackgroundColor(this.D);  // id:subtitle_bg
            ImageView imageView1 = (ImageView)view1.findViewById(0x7F0A064F);  // id:iv_melon_logo
            if(v == 5 || v == 6 || v == 7) {
                imageView1.setVisibility(8);
            }
            TextView textView0 = (TextView)view1.findViewById(0x7F0A0D34);  // id:tv_title
            TextView textView1 = (TextView)view1.findViewById(0x7F0A0D1F);  // id:tv_subtitle
            if(s1.length() > 0) {
                textView0.setVisibility(0);
                textView0.setText(s1);
            }
            else {
                textView0.setVisibility(8);
            }
            if(s.length() > 0) {
                textView1.setVisibility(0);
                textView1.setText(s);
            }
            else {
                textView1.setVisibility(8);
            }
            view0 = view1;
        }
        return z.b(z0, context0, z.a(z0, view0), "insta_share_sticker.png");
    }
}

