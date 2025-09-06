package n8;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.PopupTextListAdapter;

public class n extends O0 {
    public final View a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final View f;
    public final PopupTextListAdapter g;

    public n(PopupTextListAdapter popupTextListAdapter0, View view0) {
        this.g = popupTextListAdapter0;
        super(view0);
        View view1 = view0.findViewById(0x7F0A05A7);  // id:item_container
        this.a = view1;
        this.b = (ImageView)view0.findViewById(0x7F0A0546);  // id:icon
        this.c = (ImageView)view0.findViewById(0x7F0A054F);  // id:icon_right
        this.d = (TextView)view0.findViewById(0x7F0A0B49);  // id:text
        this.e = (TextView)view0.findViewById(0x7F0A0CCA);  // id:tv_new
        this.f = view0.findViewById(0x7F0A0D6B);  // id:underline
        if(popupTextListAdapter0.e == 1 && popupTextListAdapter0.k != null && view1 != null) {
            view1.setOnClickListener(new m(this));
        }
    }
}

