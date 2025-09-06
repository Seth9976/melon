package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;

public final class r0 implements a {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final MelonTextView c;
    public final MelonTextView d;

    public r0(ConstraintLayout constraintLayout0, ConstraintLayout constraintLayout1, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = constraintLayout1;
        this.c = melonTextView0;
        this.d = melonTextView1;
    }

    public static r0 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D022D, viewGroup0, false);  // layout:detail_song_list_etc
        int v = 0x7F0A0B53;  // id:text_container
        ConstraintLayout constraintLayout0 = (ConstraintLayout)I.C(view0, 0x7F0A0B53);  // id:text_container
        if(constraintLayout0 != null) {
            v = 0x7F0A0C49;  // id:tv_composer
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0C49);  // id:tv_composer
            if(melonTextView0 != null) {
                v = 0x7F0A0CC3;  // id:tv_movement
                MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0CC3);  // id:tv_movement
                if(melonTextView1 != null) {
                    return new r0(((ConstraintLayout)view0), constraintLayout0, melonTextView0, melonTextView1);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

