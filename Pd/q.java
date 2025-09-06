package pd;

import Tf.o;
import android.widget.SeekBar;
import android.widget.TextView;
import com.iloen.melon.utils.StringUtils;
import com.melon.ui.playback.VideoControllerHelper;
import ie.H;
import ie.m;
import java.util.Arrays;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final VideoControllerHelper B;
    public final TextView D;
    public final TextView E;
    public Object r;
    public final SeekBar w;

    public q(SeekBar seekBar0, TextView textView0, TextView textView1, VideoControllerHelper videoControllerHelper0, Continuation continuation0) {
        this.w = seekBar0;
        this.B = videoControllerHelper0;
        this.D = textView0;
        this.E = textView1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q(this.w, this.D, this.E, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((q)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m0 = (m)this.r;
        d5.n.D(object0);
        long v = ((Number)m0.a).longValue();
        this.w.setMax(((int)((Number)m0.b).longValue()));
        this.w.setProgress(((int)v));
        String s = ((int)v) == 0 ? "0:00" : StringUtils.INSTANCE.formatPlayerTime(v);
        kotlin.jvm.internal.q.d(s);
        TextView textView0 = this.D;
        if(textView0 != null) {
            textView0.setText(s);
        }
        TextView textView1 = this.E;
        if(textView1 != null) {
            textView1.setText(s);
        }
        if(o.v0(s, ":", false)) {
            String[] arr_s = (String[])o.R0(s, new String[]{":"}, 0, 6).toArray(new String[0]);
            if(arr_s.length > 1) {
                kotlin.jvm.internal.q.f("%1$s분%2$s초", "getString(...)");
                String s1 = String.format("%1$s분%2$s초", Arrays.copyOf(new Object[]{arr_s[0], arr_s[1]}, 2));
                if(textView1 != null) {
                    textView1.setContentDescription(s1);
                }
            }
        }
        return H.a;
    }
}

