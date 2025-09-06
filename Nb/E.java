package Nb;

import android.widget.TextView;
import androidx.lifecycle.M;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.playback.FloatingLyricService;
import d9.h;
import java.util.List;
import kotlin.jvm.internal.q;

public final class e implements M {
    public final int a;
    public final FloatingLyricService b;

    public e(FloatingLyricService floatingLyricService0, int v) {
        this.a = v;
        this.b = floatingLyricService0;
        super();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        if(this.a != 0) {
            q.g(((List)object0), "value");
            FloatingLyricService floatingLyricService0 = this.b;
            floatingLyricService0.n = (List)object0;
            h h0 = floatingLyricService0.w;
            q.d(h0);
            floatingLyricService0.o = h0.i;
            int v = MelonSettingInfo.getLaboratoryFloatingLyricSkinType();
            h h1 = floatingLyricService0.w;
            q.d(h1);
            if(h1.j) {
                h h2 = floatingLyricService0.w;
                q.d(h2);
                Playable playable0 = h2.m;
                if(playable0 != null) {
                    TextView textView0 = floatingLyricService0.k;
                    if(textView0 != null) {
                        textView0.setMaxLines(1);
                        TextView textView1 = floatingLyricService0.k;
                        q.d(textView1);
                        textView1.setTextColor(ColorUtils.getColor(floatingLyricService0, (v == 0 ? 0x7F0604A1 : 0x7F060171)));  // color:white000e
                        if(!playable0.isTypeOfLive()) {
                            boolean z = !playable0.isTypeOfMv();
                        }
                        TextView textView2 = floatingLyricService0.k;
                        q.d(textView2);
                        textView2.setText("");
                    }
                    TextView textView3 = floatingLyricService0.l;
                    if(textView3 != null) {
                        textView3.setMaxLines(1);
                        TextView textView4 = floatingLyricService0.l;
                        q.d(textView4);
                        textView4.setText("");
                    }
                    ViewUtils.showWhen(floatingLyricService0.j, true);
                    ViewUtils.showWhen(floatingLyricService0.l, true);
                    return;
                }
            }
            else {
                FloatingLyricService.a(floatingLyricService0);
            }
            return;
        }
        int v1 = ((Number)object0).intValue();
        FloatingLyricService floatingLyricService1 = this.b;
        h h3 = floatingLyricService1.w;
        q.d(h3);
        if(!h3.j) {
            if(v1 == -1) {
                FloatingLyricService.a(floatingLyricService1);
                return;
            }
            if(v1 > -1 && v1 < floatingLyricService1.n.size()) {
                LyricsInfo lyricsInfo0 = (LyricsInfo)floatingLyricService1.n.get(v1);
                TextView textView5 = floatingLyricService1.k;
                if(textView5 != null) {
                    textView5.setText(lyricsInfo0.b);
                }
            }
            TextView textView6 = floatingLyricService1.l;
            if(textView6 != null) {
                textView6.setText((v1 + 1 >= floatingLyricService1.n.size() ? "" : ((LyricsInfo)floatingLyricService1.n.get(v1 + 1)).b));
            }
        }
    }
}

