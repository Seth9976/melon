package wd;

import De.I;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.w;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.fragments.settings.alarm.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lwd/u;", "Landroidx/fragment/app/w;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class u extends w {
    public String a;
    public b b;
    public J8.b c;

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02D1, viewGroup0, false);  // layout:full_screen_one_button_layout
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A01CA);  // id:button
        if(melonTextView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A01CA));  // id:button
        }
        this.c = new J8.b(((ConstraintLayout)view0), melonTextView0, 4);
        return (ConstraintLayout)view0;
    }

    @Override  // androidx.fragment.app.w
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.getAttributes().width = -1;
                window0.setBackgroundDrawableResource(0x106000D);
                window0.setDimAmount(0.5f);
            }
        }
        this.setCancelable(false);
    }

    @Override  // androidx.fragment.app.I
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        String s = this.a;
        if(s != null && s.length() != 0) {
            J8.b b0 = this.c;
            if(b0 != null) {
                ((MelonTextView)b0.c).setText(s);
            }
        }
        J8.b b1 = this.c;
        if(b1 != null) {
            p p0 = new p(this, 19);
            ((MelonTextView)b1.c).setOnClickListener(p0);
        }
    }
}

