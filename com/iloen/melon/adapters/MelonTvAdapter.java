package com.iloen.melon.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MelonTvMvListRes.RESPONSE.RECOMMENDATION;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;
import java.util.List;

public class MelonTvAdapter extends p {
    public static class ItemViewHolder extends O0 {
        public TextView artist;
        public RelativeLayout bottomContainer;
        public ImageView btnInfo;
        public ImageView btnPlay;
        public TextView currentRank;
        public TextView date;
        public ImageView defaultImage;
        public ImageView gradeIcon;
        public TextView liveIcon;
        public MelonTextView playTime;
        public TextView rankGap;
        public ImageView recomIcon;
        public TextView round;
        public ImageView thumbnail;
        public RelativeLayout topContainer;
        public TextView tvTitle;
        public LinearLayout videoTimeContainer;
        public RelativeLayout wrapperLayout;

        public ItemViewHolder(View view0, Context context0) {
            super(view0);
            this.wrapperLayout = (RelativeLayout)view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
            this.topContainer = (RelativeLayout)view0.findViewById(0x7F0A0BCE);  // id:top_container
            this.bottomContainer = (RelativeLayout)view0.findViewById(0x7F0A0118);  // id:bottom_container
            this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.btnPlay = (ImageView)view0.findViewById(0x7F0A0147);  // id:btn_center
            this.videoTimeContainer = (LinearLayout)view0.findViewById(0x7F0A0B7E);  // id:thumb_left_container
            MelonTextView melonTextView0 = (MelonTextView)view0.findViewById(0x7F0A0CDF);  // id:tv_play_time
            this.playTime = melonTextView0;
            ViewUtils.showWhen(melonTextView0, true);
            this.liveIcon = (MelonTextView)view0.findViewById(0x7F0A0D2F);  // id:tv_thumb_live
            this.recomIcon = (ImageView)view0.findViewById(0x7F0A06A3);  // id:iv_thumb_recom
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A06A1);  // id:iv_thumb_grade
            this.gradeIcon = imageView0;
            ViewUtils.showWhen(imageView0, true);
            this.defaultImage = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            this.currentRank = (TextView)view0.findViewById(0x7F0A0CA3);  // id:tv_list_ranking
            this.rankGap = (TextView)view0.findViewById(0x7F0A0C9C);  // id:tv_list_change
            this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.artist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            this.date = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
            this.round = (TextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
            this.btnInfo = (ImageView)view0.findViewById(0x7F0A0169);  // id:btn_info
        }
    }

    public interface OnInfoBtnClick {
        void a(Playable arg1);
    }

    private static final int VIEW_TYPE_ITEM = 1;
    private static final int VIEW_TYPE_ITEM_LAND = 2;
    private int mArtistImgWidth;
    private OnInfoBtnClick mInfoBtnClick;

    public MelonTvAdapter(Context context0, List list0) {
        super(context0, list0);
        this.mArtistImgWidth = ScreenUtils.dipToPixel(context0, 60.0f);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return ScreenUtils.isPortrait(this.getContext()) ? 1 : 2;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        if(o00 instanceof ItemViewHolder) {
            this.updateItemView(((ItemViewHolder)o00), ((MvInfoBase)this.getItem(v1)), v);
        }
    }

    @Override  // com.iloen.melon.adapters.common.p
    public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        return new ItemViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0500, viewGroup0, false), this.getContext());  // layout:melontv_today_fullitem
    }

    public void setOnInfoBtnClick(OnInfoBtnClick melonTvAdapter$OnInfoBtnClick0) {
        this.mInfoBtnClick = melonTvAdapter$OnInfoBtnClick0;
    }

    public void updateItemView(ItemViewHolder melonTvAdapter$ItemViewHolder0, MvInfoBase mvInfoBase0, int v) {
        if(mvInfoBase0 == null) {
            return;
        }
        ViewUtils.setEnable(melonTvAdapter$ItemViewHolder0.wrapperLayout, mvInfoBase0.canService);
        ViewUtils.showWhen(melonTvAdapter$ItemViewHolder0.btnPlay, mvInfoBase0.canService);
        if(mvInfoBase0.canService) {
            a a0 = new a(this, mvInfoBase0);
            ViewUtils.setOnClickListener(melonTvAdapter$ItemViewHolder0.itemView, a0);
        }
        else {
            ViewUtils.setOnClickListener(melonTvAdapter$ItemViewHolder0.itemView, null);
        }
        ViewUtils.setDefaultImage(melonTvAdapter$ItemViewHolder0.defaultImage, this.mArtistImgWidth, true);
        ImageView imageView0 = melonTvAdapter$ItemViewHolder0.thumbnail;
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(mvInfoBase0.mv169Img).into(melonTvAdapter$ItemViewHolder0.thumbnail);
        }
        ViewUtils.setTimeForSecText(melonTvAdapter$ItemViewHolder0.playTime, mvInfoBase0.playTime);
        boolean z = false;
        ViewUtils.showWhen(melonTvAdapter$ItemViewHolder0.liveIcon, false);
        ViewUtils.hideWhen(melonTvAdapter$ItemViewHolder0.videoTimeContainer, false);
        ViewUtils.showWhen(melonTvAdapter$ItemViewHolder0.recomIcon, mvInfoBase0 instanceof RECOMMENDATION || mvInfoBase0 instanceof com.iloen.melon.net.v4x.response.MelonTvTodayListRes.RESPONSE.RECOMMENDATION);
        int v1 = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
        ImageView imageView1 = melonTvAdapter$ItemViewHolder0.gradeIcon;
        if(v1 > 0) {
            z = true;
        }
        ViewUtils.showWhen(imageView1, z);
        if(v1 > 0) {
            melonTvAdapter$ItemViewHolder0.gradeIcon.setImageResource(v1);
        }
        else {
            melonTvAdapter$ItemViewHolder0.gradeIcon.setImageDrawable(null);
        }
        melonTvAdapter$ItemViewHolder0.tvTitle.setText(mvInfoBase0.mvName);
        melonTvAdapter$ItemViewHolder0.artist.setText(ProtocolUtils.getArtistNames(mvInfoBase0.artistList));
        melonTvAdapter$ItemViewHolder0.artist.requestLayout();
        melonTvAdapter$ItemViewHolder0.date.setText(mvInfoBase0.issueDate);
        ViewUtils.showWhen(melonTvAdapter$ItemViewHolder0.round, !TextUtils.isEmpty(mvInfoBase0.epsdName));
        melonTvAdapter$ItemViewHolder0.round.setText(mvInfoBase0.epsdName);
        ViewUtils.setOnClickListener(melonTvAdapter$ItemViewHolder0.btnInfo, new b(this, mvInfoBase0));
    }
}

