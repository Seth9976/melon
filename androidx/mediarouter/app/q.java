package androidx.mediarouter.app;

import De.I;
import S1.c;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import l4.O;
import l4.Q;

public final class q extends ArrayAdapter {
    public final float a;
    public final MediaRouteControllerDialog b;

    public q(MediaRouteControllerDialog mediaRouteControllerDialog0, Context context0, ArrayList arrayList0) {
        this.b = mediaRouteControllerDialog0;
        super(context0, 0, arrayList0);
        this.a = I.G(context0);
    }

    @Override  // android.widget.ArrayAdapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        int v1 = 0;
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.b;
        if(view0 == null) {
            view0 = o.e(viewGroup0, 0x7F0D0529, viewGroup0, false);  // layout:mr_controller_volume_item
        }
        else {
            MediaRouteControllerDialog.l(((LinearLayout)view0.findViewById(0x7F0A0DE1)), mediaRouteControllerDialog0.k0);  // id:volume_item_container
            View view1 = view0.findViewById(0x7F0A0865);  // id:mr_volume_item_icon
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            viewGroup$LayoutParams0.width = mediaRouteControllerDialog0.j0;
            viewGroup$LayoutParams0.height = mediaRouteControllerDialog0.j0;
            view1.setLayoutParams(viewGroup$LayoutParams0);
        }
        O o0 = (O)this.getItem(v);
        if(o0 != null) {
            boolean z = o0.g;
            TextView textView0 = (TextView)view0.findViewById(0x7F0A085A);  // id:mr_name
            textView0.setEnabled(z);
            textView0.setText(o0.d);
            MediaRouteVolumeSlider mediaRouteVolumeSlider0 = (MediaRouteVolumeSlider)view0.findViewById(0x7F0A0866);  // id:mr_volume_slider
            Context context0 = viewGroup0.getContext();
            OverlayListView overlayListView0 = mediaRouteControllerDialog0.Z;
            int v2 = I.E(context0, 0);
            int v3 = 0xFF;
            if(Color.alpha(v2) != 0xFF) {
                v2 = c.h(v2, ((int)(((Integer)overlayListView0.getTag()))));
            }
            mediaRouteVolumeSlider0.a(v2, v2);
            mediaRouteVolumeSlider0.setTag(o0);
            mediaRouteControllerDialog0.n0.put(o0, mediaRouteVolumeSlider0);
            mediaRouteVolumeSlider0.b(!z);
            mediaRouteVolumeSlider0.setEnabled(z);
            if(z) {
                if(!mediaRouteControllerDialog0.S || (!o0.e() || Q.h() ? o0.o : 0) != 1) {
                    mediaRouteVolumeSlider0.setMax(100);
                    mediaRouteVolumeSlider0.setProgress(100);
                    mediaRouteVolumeSlider0.setEnabled(false);
                }
                else {
                    mediaRouteVolumeSlider0.setMax(o0.q);
                    mediaRouteVolumeSlider0.setProgress(o0.p);
                    mediaRouteVolumeSlider0.setOnSeekBarChangeListener(mediaRouteControllerDialog0.h0);
                }
            }
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0865);  // id:mr_volume_item_icon
            if(!z) {
                v3 = (int)(this.a * 255.0f);
            }
            imageView0.setAlpha(v3);
            LinearLayout linearLayout0 = (LinearLayout)view0.findViewById(0x7F0A0DE1);  // id:volume_item_container
            if(mediaRouteControllerDialog0.f0.contains(o0)) {
                v1 = 4;
            }
            linearLayout0.setVisibility(v1);
            if(mediaRouteControllerDialog0.d0 != null && mediaRouteControllerDialog0.d0.contains(o0)) {
                AlphaAnimation alphaAnimation0 = new AlphaAnimation(0.0f, 0.0f);
                alphaAnimation0.setDuration(0L);
                alphaAnimation0.setFillEnabled(true);
                alphaAnimation0.setFillAfter(true);
                view0.clearAnimation();
                view0.startAnimation(alphaAnimation0);
            }
        }
        return view0;
    }

    @Override  // android.widget.BaseAdapter
    public final boolean isEnabled(int v) {
        return false;
    }
}

