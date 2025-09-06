package com.iloen.melon.fragments.genre;

import android.app.Activity;
import com.iloen.melon.popup.SingleFilterListPopup;

public class GenreFilterListPopup extends SingleFilterListPopup {
    public GenreFilterListPopup(Activity activity0, int v) {
        super(activity0, v);
    }

    @Override  // com.iloen.melon.popup.SingleFilterListPopup
    public int getTabLayoutHeight() {
        return (int)this.getContext().getResources().getDimension(0x7F07044D);  // dimen:tab_container_genre_detail_height
    }
}

