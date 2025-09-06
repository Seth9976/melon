package com.iloen.melon.viewholders;

import android.view.View;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.ArrayList;

public class DjPlaylistNewHolderImpl extends DjPlaylistNewHolder {
    public interface OnClickListener {
        void clickBody(DjPlayListInfoBase arg1);

        void clickTag1(String arg1);

        void clickTag2(String arg1);

        void clickThumbnail(DjPlayListInfoBase arg1);

        void playDjPlaylist(DjPlayListInfoBase arg1);
    }

    public interface OnLongClickListener {
        void a(View arg1, int arg2);
    }

    public interface OnMoreClickListener {
        void b(DjPlayListInfoBase arg1);
    }

    private boolean isMyPlaylist;
    private String mDay;
    private boolean mIsShowDayLayout;
    private boolean mIsShowLikeIcon;
    private boolean mIsTitleSingleLine;
    private OnClickListener mOnClickListener;
    private OnLongClickListener mOnLongClickListener;
    private OnMoreClickListener mOnMoreClickListener;

    public DjPlaylistNewHolderImpl(View view0) {
        super(view0);
        this.mIsTitleSingleLine = false;
        this.mIsShowLikeIcon = true;
        this.mIsShowDayLayout = false;
        this.mDay = "";
        this.isMyPlaylist = false;
    }

    public void bindView(Object object0, int v) {
        if(this.context != null && object0 != null && object0 instanceof DjPlayListInfoBase) {
            a a0 = new a(this, v);
            ViewUtils.setOnLongClickListener(this.itemView, a0);
            b b0 = new b(this, ((DjPlayListInfoBase)object0));
            ViewUtils.setOnClickListener(this.itemView, b0);
            ViewUtils.setOnClickListener(this.playIv, new c(this, ((DjPlayListInfoBase)object0)));
            ViewUtils.setOnClickListener(this.thumbIv, new d(this, ((DjPlayListInfoBase)object0)));
            ViewUtils.setOnClickListener(this.moreIv, new e(this, ((DjPlayListInfoBase)object0)));
            boolean z = "Y".equals(((DjPlayListInfoBase)object0).seriesYn);
            ViewUtils.showWhen(this.seriesLayout, z);
            ViewUtils.showWhen(this.dayLayout, this.isShowDayLayout());
            ViewUtils.showWhen(this.seriesIconIv, z);
            this.dayTv.setText(this.getDay());
            if(z) {
                Glide.with(this.context).asBitmap().load(((DjPlayListInfoBase)object0).thumbimg).into(new B9.d(this, true));
            }
            else {
                Glide.with(this.context).load(((DjPlayListInfoBase)object0).thumbimg).into(this.thumbIv);
            }
            this.titleTv.setText(((DjPlayListInfoBase)object0).plylsttitle);
            if(this.isTitleSingleLine()) {
                this.titleTv.setMaxLines(1);
            }
            else {
                this.titleTv.setMaxLines(2);
            }
            this.artistTv.setText(StringUtils.getTrimmed(((DjPlayListInfoBase)object0).ownernickname, 13));
            this.artistTv.requestLayout();
            this.likeTv.setText(StringUtils.getCountString(((DjPlayListInfoBase)object0).likecnt, 0x98967F));
            ViewUtils.showWhen(this.likeTv, this.isShowLikeIcon());
            ViewUtils.showWhen(this.newIv, "Y".equals(((DjPlayListInfoBase)object0).upyn));
            ViewUtils.showWhen(this.crownIv, "Y".equals(((DjPlayListInfoBase)object0).fameregyn));
            ViewUtils.showWhen(this.songCountTv, this.isMyPlaylist());
            this.songCountTv.setText(String.format("%s곡", ((DjPlayListInfoBase)object0).songcnt));
            ViewUtils.hideWhen(this.tagName1Tv, true);
            ViewUtils.hideWhen(this.tagName2Tv, true);
            ArrayList arrayList0 = ((DjPlayListInfoBase)object0).taglist;
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                int v1 = ((DjPlayListInfoBase)object0).taglist.size();
                if(v1 > 0) {
                    ViewUtils.showWhen(this.tagName1Tv, true);
                    TagInfoBase tagInfoBase0 = (TagInfoBase)((DjPlayListInfoBase)object0).taglist.get(0);
                    this.tagName1Tv.setText(tagInfoBase0.tagName);
                    ViewUtils.setOnClickListener(this.tagName1Tv, new f(this, tagInfoBase0));
                }
                if(v1 > 1) {
                    ViewUtils.showWhen(this.tagName2Tv, true);
                    TagInfoBase tagInfoBase1 = (TagInfoBase)((DjPlayListInfoBase)object0).taglist.get(1);
                    this.tagName2Tv.setText(tagInfoBase1.tagName);
                    ViewUtils.setOnClickListener(this.tagName2Tv, new g(this, tagInfoBase1));
                }
            }
            ViewUtils.showWhen(this.underline, ((DjPlayListInfoBase)object0).isFullLine);
        }
    }

    public String getDay() {
        return this.mDay;
    }

    public boolean isMyPlaylist() {
        return this.isMyPlaylist;
    }

    public boolean isShowDayLayout() {
        return this.mIsShowDayLayout;
    }

    public boolean isShowLikeIcon() {
        return this.mIsShowLikeIcon;
    }

    public boolean isTitleSingleLine() {
        return this.mIsTitleSingleLine;
    }

    public void setDay(String s) {
        this.mDay = s;
    }

    public void setMyPlaylist(boolean z) {
        this.isMyPlaylist = z;
    }

    public void setOnClickListener(OnClickListener djPlaylistNewHolderImpl$OnClickListener0) {
        this.mOnClickListener = djPlaylistNewHolderImpl$OnClickListener0;
    }

    public void setOnLongClickListener(OnLongClickListener djPlaylistNewHolderImpl$OnLongClickListener0) {
        this.mOnLongClickListener = djPlaylistNewHolderImpl$OnLongClickListener0;
    }

    public void setOnMoreClickListener(OnMoreClickListener djPlaylistNewHolderImpl$OnMoreClickListener0) {
        this.mOnMoreClickListener = djPlaylistNewHolderImpl$OnMoreClickListener0;
    }

    public void setShowDayLayout(boolean z) {
        this.mIsShowDayLayout = z;
    }

    public void setShowLikeIcon(boolean z) {
        this.mIsShowLikeIcon = z;
    }

    public void setTitleSingleLine(boolean z) {
        this.mIsTitleSingleLine = z;
    }
}

