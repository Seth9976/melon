package com.iloen.melon.viewholders;

import android.view.View;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class PlaylistNewHolderImpl extends PlaylistNewHolder {
    public interface OnClickListener {
        void clickItemView(ArtistPlayListInfoBase arg1);

        void clickMore(ArtistPlayListInfoBase arg1);

        void playPlaylist(ArtistPlayListInfoBase arg1);
    }

    public interface OnLongClickListener {
        void a(View arg1, int arg2);
    }

    private boolean isMyPlaylist;
    private OnClickListener mOnClickListener;
    private OnLongClickListener mOnLongClickListener;

    public PlaylistNewHolderImpl(View view0) {
        super(view0);
        this.isMyPlaylist = false;
    }

    public void bindView(Object object0, int v) {
        if(this.context != null && object0 != null && object0 instanceof ArtistPlayListInfoBase) {
            j j0 = new j(this, v);
            ViewUtils.setOnLongClickListener(this.itemView, j0);
            k k0 = new k(this, ((ArtistPlayListInfoBase)object0));
            ViewUtils.setOnClickListener(this.itemView, k0);
            ViewUtils.setOnClickListener(this.playIv, new l(this, ((ArtistPlayListInfoBase)object0)));
            ViewUtils.setOnClickListener(this.moreIv, new m(this, ((ArtistPlayListInfoBase)object0)));
            ViewUtils.showWhen(this.privateLockIv, "N".equals(((ArtistPlayListInfoBase)object0).openyn));
            Glide.with(this.context).clear(this.thumbIv);
            Glide.with(this.context).load(((ArtistPlayListInfoBase)object0).thumbimg).into(this.thumbIv);
            this.titleTv.setText(((ArtistPlayListInfoBase)object0).plylsttitle);
            this.artistTv.setText(((ArtistPlayListInfoBase)object0).ownernickname);
            this.artistTv.requestLayout();
            this.likeTv.setText(StringUtils.getCountString(((ArtistPlayListInfoBase)object0).likecnt, 0x98967F));
            ViewUtils.showWhen(this.newIv, "Y".equals(((ArtistPlayListInfoBase)object0).newyn));
            ViewUtils.showWhen(this.songCountTv, this.isMyPlaylist());
            this.songCountTv.setText(String.format("%s곡", ((ArtistPlayListInfoBase)object0).songcnt));
        }
    }

    public boolean isMyPlaylist() {
        return this.isMyPlaylist;
    }

    public void setMyPlaylist(boolean z) {
        this.isMyPlaylist = z;
    }

    public void setOnClickListener(OnClickListener playlistNewHolderImpl$OnClickListener0) {
        this.mOnClickListener = playlistNewHolderImpl$OnClickListener0;
    }

    public void setOnLongClickListener(OnLongClickListener playlistNewHolderImpl$OnLongClickListener0) {
        this.mOnLongClickListener = playlistNewHolderImpl$OnLongClickListener0;
    }
}

