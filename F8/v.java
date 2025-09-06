package F8;

import android.content.Context;
import android.view.View;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import d5.f;
import kotlin.jvm.internal.q;

public final class v extends w {
    public final String g;
    public MelonTextView h;

    public v(String s) {
        this.g = s;
    }

    @Override  // F8.o
    public final boolean b() {
        return false;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        MelonTextView melonTextView0 = new MelonTextView(context0);
        this.h = melonTextView0;
        melonTextView0.setTextSize(0, context0.getResources().getDimension(0x7F07044A));  // dimen:tab_common_title_font
        MelonTextView melonTextView1 = this.h;
        if(melonTextView1 != null) {
            melonTextView1.setTextColor(ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
            MelonTextView melonTextView2 = this.h;
            if(melonTextView2 != null) {
                melonTextView2.setTypeface(f.F(context0));
                MelonTextView melonTextView3 = this.h;
                if(melonTextView3 != null) {
                    melonTextView3.setText(this.g);
                    MelonTextView melonTextView4 = this.h;
                    if(melonTextView4 != null) {
                        melonTextView4.setTextColor(ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
                        int v = (int)context0.getResources().getDimension(0x7F07044C);  // dimen:tab_common_title_padding
                        MelonTextView melonTextView5 = this.h;
                        if(melonTextView5 != null) {
                            melonTextView5.setPadding(v, 0, 0, 0);
                            View view0 = this.h;
                            if(view0 != null) {
                                return view0;
                            }
                            q.m("tvTitle");
                            throw null;
                        }
                        q.m("tvTitle");
                        throw null;
                    }
                    q.m("tvTitle");
                    throw null;
                }
                q.m("tvTitle");
                throw null;
            }
            q.m("tvTitle");
            throw null;
        }
        q.m("tvTitle");
        throw null;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        return this.g;
    }

    @Override  // F8.w
    public final String f(Context context0) {
        return this.g;
    }

    @Override  // F8.w
    public final int i() {
        return 3;
    }
}

