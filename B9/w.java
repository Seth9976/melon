package B9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;

public final class w extends O0 {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;

    public w(View view0) {
        super(view0);
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.a = (ImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
        ImageView imageView0 = (ImageView)view1.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.b = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.c = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.d = (TextView)view0.findViewById(0x7F0A0CE0);  // id:tv_playlist_cnt
        this.e = (TextView)view0.findViewById(0x7F0A0C99);  // id:tv_like
    }
}

