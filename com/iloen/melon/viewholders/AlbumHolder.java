package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.SmallRatingView;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class AlbumHolder extends O0 {
    public ImageView arrowIv;
    public TextView artistTv;
    public ImageView btnPlayIv;
    public ImageView checkIv;
    public ImageView defaultThumbnailIv;
    public View expandLayout;
    public ImageView fanIv;
    public ImageView foldIv;
    public View foldLayout;
    public TextView issueTv;
    public TextView listChangeTv;
    public TextView masterpieceDescTv;
    public TextView masterpieceTitleTv;
    public View rankLayout;
    public TextView rankTv;
    public View ratingContainer;
    public TextView ratingText;
    public TextView ratingUserCntTv;
    public SmallRatingView ratingView;
    public View rootView;
    public View thumbContainer;
    public ImageView thumbnailIv;
    public TextView titleTv;
    public View underline;
    public View wrapperLayout;

    public AlbumHolder(View view0) {
        super(view0);
        Context context0 = view0.getContext();
        this.rootView = view0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.thumbContainer = view1;
        this.thumbnailIv = (ImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
        this.defaultThumbnailIv = (ImageView)this.thumbContainer.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.btnPlayIv = (ImageView)view0.findViewById(0x7F0A0182);  // id:btn_play
        this.rankLayout = view0.findViewById(0x7F0A09B1);  // id:rank_layout
        this.rankTv = (TextView)view0.findViewById(0x7F0A09B4);  // id:rank_tv
        this.listChangeTv = (TextView)view0.findViewById(0x7F0A0C9C);  // id:tv_list_change
        this.titleTv = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistTv = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.ratingContainer = view0.findViewById(0x7F0A09BC);  // id:rating_container
        SmallRatingView smallRatingView0 = (SmallRatingView)view0.findViewById(0x7F0A0AD9);  // id:srvAlbumRating
        this.ratingView = smallRatingView0;
        smallRatingView0.setTouchable(false);
        this.ratingView.a(0);
        this.ratingText = (TextView)view0.findViewById(0x7F0A0BED);  // id:tvAlbumRatingScore
        this.ratingUserCntTv = (TextView)view0.findViewById(0x7F0A0BFC);  // id:tvRatingUserCnt
        this.issueTv = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        this.checkIv = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.arrowIv = (ImageView)view0.findViewById(0x7F0A05F1);  // id:iv_arrow
        this.fanIv = (ImageView)view0.findViewById(0x7F0A062D);  // id:iv_fan
        this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
        if(context0 != null) {
            ViewUtils.setDefaultImage(this.defaultThumbnailIv, ScreenUtils.dipToPixel(context0, 85.0f));
        }
        this.foldLayout = view0.findViewById(0x7F0A04D0);  // id:fold_layout
        this.foldIv = (ImageView)view0.findViewById(0x7F0A04CF);  // id:fold_iv
        this.expandLayout = view0.findViewById(0x7F0A0476);  // id:expand_layout
        this.masterpieceTitleTv = (TextView)view0.findViewById(0x7F0A07D5);  // id:masterpiece_title_tv
        this.masterpieceDescTv = (TextView)view0.findViewById(0x7F0A07D4);  // id:masterpiece_desc_tv
    }
}

