package F8;

import P1.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

public final class j extends m {
    @Override  // F8.m
    public final View c(Context context0) {
        View view0 = super.c(context0);
        Drawable drawable0 = c.getDrawable(context0, 0x7F08044A);  // drawable:ic_genre_titlebar_arrow
        if(drawable0 != null) {
            drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
            TextView textView0 = this.g;
            if(textView0 != null) {
                textView0.setCompoundDrawables(null, null, drawable0, null);
            }
        }
        return view0;
    }
}

