package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class PlaylistNewHolder extends O0 {
    public TextView artistTv;
    public View attatchBtn;
    public ImageView checkIv;
    public Context context;
    public TextView likeTv;
    public ImageView moreIv;
    public ImageView newIv;
    public ImageView playIv;
    public ImageView privateLockIv;
    public View rootView;
    public TextView songCountTv;
    public View thumbContainer;
    public ImageView thumbDefaultIv;
    public ImageView thumbIv;
    public TextView titleTv;
    public View underline;

    public PlaylistNewHolder(View view0) {
        super(view0);
        this.context = view0.getContext();
        this.rootView = view0;
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.thumbContainer = view1;
        ImageView imageView0 = (ImageView)view1.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.thumbDefaultIv = imageView0;
        ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(this.context, 96.0f));
        this.thumbIv = (ImageView)this.thumbContainer.findViewById(0x7F0A069A);  // id:iv_thumb
        this.songCountTv = (TextView)view0.findViewById(0x7F0A0AA7);  // id:song_count_tv
        this.playIv = (ImageView)view0.findViewById(0x7F0A091E);  // id:play_iv
        this.moreIv = (ImageView)view0.findViewById(0x7F0A0650);  // id:iv_more
        this.checkIv = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.newIv = (ImageView)view0.findViewById(0x7F0A08AF);  // id:new_iv
        this.attatchBtn = view0.findViewById(0x7F0A00C5);  // id:attach_btn
        this.privateLockIv = (ImageView)view0.findViewById(0x7F0A0965);  // id:private_lock_iv
        this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.artistTv = (TextView)view0.findViewById(0x7F0A00C2);  // id:artist_tv
        this.likeTv = (TextView)view0.findViewById(0x7F0A076A);  // id:like_tv
        this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
    }
}

