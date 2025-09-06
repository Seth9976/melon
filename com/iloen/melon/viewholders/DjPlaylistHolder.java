package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class DjPlaylistHolder extends O0 {
    public View buttonContainer;
    public ImageView checkIv;
    public Context context;
    public View crownIcon;
    public View dayLayout;
    public TextView dayTv;
    public ImageView defaultImage;
    public TextView djName;
    public TextView likeCount;
    public ImageView moreIv;
    public ImageView moveIv;
    public ImageView newIv;
    public ImageView playIv;
    public ImageView playlistImage;
    public ImageView powerDjIcon;
    public View rootView;
    public ImageView seriesIconIv;
    public ImageView seriesIv;
    public View seriesLayout;
    public TextView songCount;
    public View tagContainer;
    public TextView tagName1;
    public TextView tagName2;
    public View thumbnailContainer;
    public TextView title;
    public View underline;
    public View viewGap;

    public DjPlaylistHolder(View view0) {
        super(view0);
        this.context = view0.getContext();
        this.rootView = view0;
        this.thumbnailContainer = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.playlistImage = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.defaultImage = imageView0;
        Context context0 = this.context;
        if(context0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(context0, 75.0f));
        }
        this.seriesLayout = view0.findViewById(0x7F0A0A70);  // id:series_image_layout
        this.seriesIv = (ImageView)view0.findViewById(0x7F0A0A71);  // id:series_iv
        this.songCount = (TextView)view0.findViewById(0x7F0A0AA6);  // id:song_count_text
        this.crownIcon = view0.findViewById(0x7F0A063D);  // id:iv_list_crown
        this.dayLayout = view0.findViewById(0x7F0A0380);  // id:day_layout
        this.seriesIconIv = (ImageView)view0.findViewById(0x7F0A0A6F);  // id:series_icon_iv
        this.dayTv = (TextView)view0.findViewById(0x7F0A0381);  // id:day_tv
        this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.powerDjIcon = (ImageView)view0.findViewById(0x7F0A0644);  // id:iv_list_powerdj
        this.djName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.likeCount = (TextView)view0.findViewById(0x7F0A0C99);  // id:tv_like
        this.tagContainer = view0.findViewById(0x7F0A0B25);  // id:tag_container
        this.tagName1 = (TextView)view0.findViewById(0x7F0A0B19);  // id:tag1_tv
        this.tagName2 = (TextView)view0.findViewById(0x7F0A0B1A);  // id:tag2_tv
        this.checkIv = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.viewGap = view0.findViewById(0x7F0A0DC5);  // id:view_gap
        this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
        this.playIv = (ImageView)view0.findViewById(0x7F0A0182);  // id:btn_play
        this.newIv = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
        this.moreIv = (ImageView)view0.findViewById(0x7F0A0650);  // id:iv_more
        this.moveIv = (ImageView)view0.findViewById(0x7F0A0651);  // id:iv_move
        this.buttonContainer = view0.findViewById(0x7F0A031F);  // id:container_button
        this.showMoreButton(false);
    }

    public void showMoreButton(boolean z) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.buttonContainer.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), (z ? 2.0f : 16.0f));
        }
        ViewUtils.showWhen(this.moreIv, z);
    }
}

