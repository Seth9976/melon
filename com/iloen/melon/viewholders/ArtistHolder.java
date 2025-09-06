package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class ArtistHolder extends O0 {
    public TextView artistNameTv;
    public TextView artistNewsTv;
    public ImageView defaultThumbIv;
    public ImageView fanIv;
    public ImageView friendshipIv;
    public View friendshipLayout;
    public TextView friendshipTv;
    public ImageView newIv;
    public View rootView;
    public ImageView thumbIv;

    public ArtistHolder(View view0) {
        super(view0);
        Context context0 = view0.getContext();
        this.rootView = view0;
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.defaultThumbIv = imageView0;
        ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(context0, 65.0f), true);
        this.thumbIv = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.newIv = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
        this.artistNameTv = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.artistNewsTv = (TextView)view0.findViewById(0x7F0A0C62);  // id:tv_detail
        View view1 = view0.findViewById(0x7F0A04E0);  // id:friendship_container
        this.friendshipLayout = view1;
        view1.setVisibility(0);
        this.friendshipTv = (TextView)view0.findViewById(0x7F0A0C82);  // id:tv_friendship
        this.friendshipIv = (ImageView)view0.findViewById(0x7F0A0630);  // id:iv_friendship
        this.fanIv = (ImageView)view0.findViewById(0x7F0A062D);  // id:iv_fan
    }
}

