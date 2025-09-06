package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class DjPlaylistNewHolder extends O0 {
    public TextView artistTv;
    public ImageView checkIv;
    public Context context;
    public ImageView crownIv;
    public View dayLayout;
    public TextView dayTv;
    public TextView likeTv;
    public ImageView moreIv;
    public ImageView newIv;
    public ImageView playIv;
    public View rootView;
    public ImageView seriesIconIv;
    public ImageView seriesIv;
    public View seriesLayout;
    public TextView songCountTv;
    public View tagContainer;
    public TextView tagName1Tv;
    public TextView tagName2Tv;
    public View thumbContainer;
    public ImageView thumbDefaultIv;
    public ImageView thumbIv;
    public TextView titleTv;
    public View underline;

    public DjPlaylistNewHolder(View view0) {
        super(view0);
        this.context = view0.getContext();
        this.rootView = view0;
        this.seriesLayout = view0.findViewById(0x7F0A0A72);  // id:series_layout
        this.seriesIv = (ImageView)view0.findViewById(0x7F0A0A71);  // id:series_iv
        this.dayLayout = view0.findViewById(0x7F0A0380);  // id:day_layout
        this.seriesIconIv = (ImageView)view0.findViewById(0x7F0A0A6F);  // id:series_icon_iv
        this.dayTv = (TextView)view0.findViewById(0x7F0A0381);  // id:day_tv
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
        this.crownIv = (ImageView)view0.findViewById(0x7F0A0369);  // id:crown_iv
        this.titleTv = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.artistTv = (TextView)view0.findViewById(0x7F0A00C2);  // id:artist_tv
        this.likeTv = (TextView)view0.findViewById(0x7F0A076A);  // id:like_tv
        this.tagContainer = view0.findViewById(0x7F0A0B25);  // id:tag_container
        this.tagName1Tv = (TextView)view0.findViewById(0x7F0A0B19);  // id:tag1_tv
        this.tagName2Tv = (TextView)view0.findViewById(0x7F0A0B1A);  // id:tag2_tv
        this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
    }
}

