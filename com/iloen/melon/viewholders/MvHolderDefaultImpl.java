package com.iloen.melon.viewholders;

import B9.l;
import android.text.TextUtils;
import android.view.View;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;

public class MvHolderDefaultImpl extends l {
    public interface OnClickListener {
        void playMusicVideo(int arg1);

        void showContextPopup(Playable arg1);
    }

    private OnClickListener mOnClickListenr;

    public MvHolderDefaultImpl(View view0) {
        super(view0);
    }

    public void bindView(MvInfoBase mvInfoBase0, boolean z, String s, int v) {
        if(mvInfoBase0 != null) {
            boolean z1 = mvInfoBase0.canService;
            ViewUtils.setEnable(this.wrapperLayout, z1);
            if(z1) {
                h h0 = new h(this, v);
                ViewUtils.setOnClickListener(this.itemView, h0);
            }
            else {
                ViewUtils.setOnClickListener(this.itemView, null);
            }
            ViewUtils.setOnClickListener(this.moreIv, new i(this, mvInfoBase0, s));
            if(this.thumbnailIv != null && this.thumbnailIv.getContext() != null) {
                Glide.with(this.thumbnailIv.getContext()).load(mvInfoBase0.mvImg).into(this.thumbnailIv);
            }
            ViewUtils.showWhen(this.roundTv, !TextUtils.isEmpty(mvInfoBase0.epsdName));
            this.roundTv.setText(mvInfoBase0.epsdName);
            if(z) {
                this.titleTv.setText("null");
            }
            else {
                this.titleTv.setText(mvInfoBase0.mvName);
            }
            this.artistTv.setText(ProtocolUtils.getArtistNames(mvInfoBase0.artistList));
            ViewUtils.showWhen(this.issueTv, !TextUtils.isEmpty(mvInfoBase0.issueDate));
            this.issueTv.setText(mvInfoBase0.issueDate);
            this.viewCountTv.setText(StringUtils.getCountString(mvInfoBase0.viewCnt, 0x3B9AC9FF));
            ViewUtils.setTimeForSecText(this.playtimeTv, mvInfoBase0.playTime);
            ViewUtils.hideWhen(this.gradeIv, true);
            if(!TextUtils.isEmpty(mvInfoBase0.adultGrade)) {
                int v1 = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
                if(v1 != -1) {
                    ViewUtils.showWhen(this.gradeIv, true);
                    this.gradeIv.setBackgroundResource(v1);
                }
            }
        }
    }

    public void setOnClickListener(OnClickListener mvHolderDefaultImpl$OnClickListener0) {
        this.mOnClickListenr = mvHolderDefaultImpl$OnClickListener0;
    }
}

