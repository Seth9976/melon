package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class SearchAndAddPlaylistViewHolder extends O0 {
    private View actionView;
    private View btnPlay;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private TextView likeCount;
    private SearchAndAddBaseAdapter mAdapter;
    private TextView nickName;
    private TextView songCount;
    private TextView title;
    private TextView viewCount;

    public SearchAndAddPlaylistViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        Context context0 = view0.getContext();
        this.mAdapter = searchAndAddBaseAdapter0;
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.songCount = (TextView)view0.findViewById(0x7F0A0D17);  // id:tv_song_count
        this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.nickName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.likeCount = (TextView)view0.findViewById(0x7F0A0C99);  // id:tv_like
        this.viewCount = (TextView)view0.findViewById(0x7F0A0D51);  // id:tv_view_cnt
        if(context0 != null) {
            ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(context0, 85.0f));
        }
        View view1 = view0.findViewById(0x7F0A0182);  // id:btn_play
        this.btnPlay = view1;
        ViewUtils.showWhen(view1, false);
        if(this.mAdapter.isMarkedMode()) {
            View view2 = view0.findViewById(0x7F0A0610);  // id:iv_check
            this.actionView = view2;
            view2.setClickable(false);
        }
        else {
            View view3 = view0.findViewById(0x7F0A0140);  // id:btn_attach
            this.actionView = view3;
            ((TextView)view3).setText(0x7F130781);  // string:mymusic_setting "설정"
        }
        ViewUtils.showWhen(view0, false);
    }

    public void bindView(ArtistPlayListInfoBase artistPlayListInfoBase0, int v, int v1, String s) {
        if(artistPlayListInfoBase0 != null) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(artistPlayListInfoBase0.thumbimg).into(this.ivThumb);
            }
            boolean z = false;
            if(TextUtils.isEmpty(artistPlayListInfoBase0.songcnt)) {
                ViewUtils.showWhen(this.songCount, false);
            }
            else {
                this.songCount.setText(StringUtils.getSongCountString(artistPlayListInfoBase0.songcnt));
                ViewUtils.showWhen(this.songCount, true);
            }
            ViewUtils.setTextViewMarquee(this.title, this.mAdapter.isMarqueeNeeded(v1));
            this.title.setText(artistPlayListInfoBase0.plylsttitle);
            this.nickName.setText(artistPlayListInfoBase0.ownernickname);
            this.likeCount.setText(StringUtils.getCountFormattedString(artistPlayListInfoBase0.likecnt));
            if("M20002".equals(s)) {
                this.viewCount.setText(StringUtils.getCountFormattedString(artistPlayListInfoBase0.viewcnt));
                ViewUtils.showWhen(this.viewCount, true);
            }
            else {
                ViewUtils.showWhen(this.viewCount, false);
            }
            ViewUtils.showWhen(this.actionView, ProtocolUtils.parseBoolean(artistPlayListInfoBase0.openyn));
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(artistPlayListInfoBase0);
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddPlaylistViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddPlaylistViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                com.iloen.melon.fragments.searchandadd.SearchAndAddPlaylistViewHolder.1 searchAndAddPlaylistViewHolder$10 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddPlaylistViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddPlaylistViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                };
                ViewUtils.setOnClickListener(this.itemView, searchAndAddPlaylistViewHolder$10);
                if(this.mAdapter.isMarked(v1)) {
                    ((ImageView)this.actionView).setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                    this.actionView.setContentDescription("선택 취소 버튼");
                    int v2 = ColorUtils.getColor(this.itemView.getContext(), 0x7F060199);  // color:list_item_marked
                    this.itemView.setBackgroundColor(v2);
                }
                else {
                    ((ImageView)this.actionView).setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                    this.actionView.setContentDescription("선택 버튼");
                    int v3 = ColorUtils.getColor(this.itemView.getContext(), 0x7F06048A);  // color:transparent
                    this.itemView.setBackgroundColor(v3);
                }
            }
            if("M20002".equals(s)) {
                View view0 = this.itemView;
                if(ProtocolUtils.parseBoolean(artistPlayListInfoBase0.openyn) && !ProtocolUtils.parseBoolean(artistPlayListInfoBase0.dimYn)) {
                    z = true;
                }
                ViewUtils.setEnable(view0, z);
            }
            else {
                ViewUtils.setEnable(this.itemView, ProtocolUtils.parseBoolean(artistPlayListInfoBase0.openyn));
            }
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public static int getLayoutRsId() [...] // Inlined contents
}

