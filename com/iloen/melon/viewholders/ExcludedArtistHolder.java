package com.iloen.melon.viewholders;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class ExcludedArtistHolder extends ArtistHolder {
    public final TextView a;

    public ExcludedArtistHolder(View view0) {
        super(view0);
        ViewGroup viewGroup0 = (ViewGroup)view0.findViewById(0x7F0A00C6);  // id:attach_btn_container
        if(viewGroup0 != null) {
            ViewUtils.showWhen(viewGroup0, true);
            TextView textView0 = (TextView)viewGroup0.findViewById(0x7F0A0140);  // id:btn_attach
            this.a = textView0;
            if(textView0 != null) {
                ViewUtils.showWhen(textView0, true);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = textView0.getLayoutParams();
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 26.0f);
            }
        }
    }
}

