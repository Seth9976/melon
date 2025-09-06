package com.iloen.melon.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.ui.ViewUtils;

public class SongHolder extends O0 {
    public TextView artistTv;
    public TextView btnAttach;
    public ImageView btnInfo;
    public ImageView btnPlay;
    public View btnRecom;
    public View chartLayout;
    public ImageView checkIv;
    public ImageView defaultThumbnailIv;
    public ImageView forUCheckIv;
    public ImageView ivThumbStroke;
    public ImageView list19Iv;
    public TextView listChangeTv;
    public ImageView listDcfIv;
    public TextView listFlacTv;
    public ImageView listFreeIv;
    public ImageView listHoldbackIv;
    public ImageView listHotIv;
    public ImageView listMp3Iv;
    public TextView listRankingTv;
    public ImageView listTitleIv;
    public TextView listenCountTv;
    public ImageView moveIv;
    public View originSongContainer;
    public TextView rankGapTv;
    public TextView rankTv;
    public View rootView;
    public View thumbContainer;
    public ImageView thumbnailIv;
    public LinearLayout titleLayout;
    public TextView titleTv;
    public TextView tvTrackNo;
    public View underLine;
    public View updownLayout;
    public View wrapperLayout;

    public SongHolder(View view0) {
        super(view0);
        Context context0 = view0.getContext();
        this.rootView = view0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        this.updownLayout = view0.findViewById(0x7F0A0D79);  // id:updown_layout
        this.chartLayout = view0.findViewById(0x7F0A024B);  // id:chart_layout
        this.titleLayout = (LinearLayout)view0.findViewById(0x7F0A0B9E);  // id:title_layout
        this.listRankingTv = (TextView)view0.findViewById(0x7F0A0CA3);  // id:tv_list_ranking
        this.listChangeTv = (TextView)view0.findViewById(0x7F0A0C9C);  // id:tv_list_change
        View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.thumbContainer = view1;
        this.thumbnailIv = (ImageView)view1.findViewById(0x7F0A069A);  // id:iv_thumb
        this.defaultThumbnailIv = (ImageView)this.thumbContainer.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumbStroke = (ImageView)view0.findViewById(0x7F0A06A4);  // id:iv_thumb_stroke
        this.rankTv = (TextView)this.updownLayout.findViewById(0x7F0A0CA3);  // id:tv_list_ranking
        this.rankGapTv = (TextView)this.updownLayout.findViewById(0x7F0A0C9C);  // id:tv_list_change
        this.titleTv = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.titleTv = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistTv = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.listenCountTv = (TextView)view0.findViewById(0x7F0A0CA4);  // id:tv_listen_count
        this.originSongContainer = view0.findViewById(0x7F0A08EA);  // id:origin_song_layout
        this.list19Iv = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
        this.listFreeIv = (ImageView)view0.findViewById(0x7F0A0640);  // id:iv_list_free
        this.listTitleIv = (ImageView)view0.findViewById(0x7F0A0646);  // id:iv_list_title
        this.listHotIv = (ImageView)view0.findViewById(0x7F0A0642);  // id:iv_list_hot
        this.listHoldbackIv = (ImageView)view0.findViewById(0x7F0A0641);  // id:iv_list_holdback
        this.listDcfIv = (ImageView)view0.findViewById(0x7F0A063E);  // id:iv_list_dcf
        this.listMp3Iv = (ImageView)view0.findViewById(0x7F0A0643);  // id:iv_list_mp3
        this.listFlacTv = (TextView)view0.findViewById(0x7F0A063F);  // id:iv_list_flac
        this.btnPlay = (ImageView)view0.findViewById(0x7F0A0182);  // id:btn_play
        this.btnInfo = (ImageView)view0.findViewById(0x7F0A0169);  // id:btn_info
        this.checkIv = (ImageView)view0.findViewById(0x7F0A0610);  // id:iv_check
        this.moveIv = (ImageView)view0.findViewById(0x7F0A0651);  // id:iv_move
        this.forUCheckIv = (ImageView)view0.findViewById(0x7F0A062F);  // id:iv_foru_check
        this.btnAttach = (TextView)view0.findViewById(0x7F0A0140);  // id:btn_attach
        this.underLine = view0.findViewById(0x7F0A0D6B);  // id:underline
        this.tvTrackNo = (TextView)view0.findViewById(0x7F0A0CF5);  // id:tv_ranking
        this.btnRecom = view0.findViewById(0x7F0A0C81);  // id:tv_foru_recom
        if(context0 != null) {
            ViewUtils.setDefaultImage(this.defaultThumbnailIv, context0.getResources().getDimensionPixelSize(0x7F07045E));  // dimen:thumb_width_song
        }
    }
}

