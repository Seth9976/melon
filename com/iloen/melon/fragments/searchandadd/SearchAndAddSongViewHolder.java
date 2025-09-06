package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import com.melon.playlist.interfaces.PlayableData;

public class SearchAndAddSongViewHolder extends O0 {
    private View actionView;
    private ImageView adultIcon;
    private TextView artistName;
    private ImageView freeIcon;
    private ImageView holdbackIcon;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private SearchAndAddBaseAdapter mAdapter;
    private TextView title;
    private View wrapperLayout;

    public SearchAndAddSongViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        this.mAdapter = searchAndAddBaseAdapter0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.adultIcon = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
        this.holdbackIcon = (ImageView)view0.findViewById(0x7F0A0641);  // id:iv_list_holdback
        this.freeIcon = (ImageView)view0.findViewById(0x7F0A0640);  // id:iv_list_free
        this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 48.0f), false);
        ViewUtils.showWhen(view0.findViewById(0x7F0A0182), false);  // id:btn_play
        ViewUtils.showWhen(view0.findViewById(0x7F0A0169), false);  // id:btn_info
        if(this.mAdapter.isMarkedMode()) {
            View view1 = view0.findViewById(0x7F0A0610);  // id:iv_check
            this.actionView = view1;
            view1.setClickable(false);
        }
        else if(this.mAdapter.mSearchViewType == 0 || this.mAdapter.mSearchViewType == 10) {
            View view3 = view0.findViewById(0x7F0A0140);  // id:btn_attach
            this.actionView = view3;
            ((TextView)view3).setText(0x7F130783);  // string:myprofile_select "선택"
        }
        else {
            View view2 = view0.findViewById(0x7F0A0140);  // id:btn_attach
            this.actionView = view2;
            ((TextView)view2).setText(0x7F130781);  // string:mymusic_setting "설정"
        }
        ViewUtils.showWhen(view0, false);
    }

    public void bindView(SongInfoBase songInfoBase0, int v, int v1) {
        if(songInfoBase0 != null) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(this.ivThumb);
            }
            ViewUtils.showWhen(this.adultIcon, songInfoBase0.isAdult);
            ViewUtils.showWhen(this.freeIcon, songInfoBase0.isFree);
            ViewUtils.showWhen(this.holdbackIcon, songInfoBase0.isHoldback);
            this.title.setText(songInfoBase0.songName);
            this.artistName.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
            ViewUtils.showWhen(this.actionView, songInfoBase0.canService);
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(Playable.from(songInfoBase0, this.mAdapter.getMenuId(), null));
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddSongViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddSongViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                ViewUtils.setOnClickListener(this.wrapperLayout, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                });
                ViewUtils.setOnClickListener(this.actionView, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                });
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
            ViewUtils.setEnable(this.wrapperLayout, songInfoBase0.canService);
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public void bindView(PlayableData playableData0, int v, int v1) {
        if(playableData0 == null) {
            return;
        }
        Playable playable0 = playableData0.a;
        ImageView imageView0 = this.ivThumb;
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(playableData0.m).into(this.ivThumb);
        }
        ViewUtils.showWhen(this.adultIcon, playable0.isAdult());
        ViewUtils.showWhen(this.holdbackIcon, playable0.isHoldback());
        ViewUtils.showWhen(this.freeIcon, playable0.isFree());
        ViewUtils.setTextViewMarquee(this.title, this.mAdapter.isMarqueeNeeded(v1));
        this.title.setText("");
        this.artistName.setText("");
        ViewUtils.showWhen(this.actionView, playable0.isService());
        if(!this.mAdapter.isMarkedMode()) {
            this.actionView.setTag(playable0);
            this.actionView.setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(SearchAndAddSongViewHolder.this.mAdapter.mOnItemEventListener != null) {
                        SearchAndAddSongViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                    }
                }
            });
        }
        else if(this.actionView instanceof ImageView) {
            com.iloen.melon.fragments.searchandadd.SearchAndAddSongViewHolder.1 searchAndAddSongViewHolder$10 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                        SearchAndAddSongViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                    }
                }
            };
            ViewUtils.setOnClickListener(this.itemView, searchAndAddSongViewHolder$10);
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
        ViewUtils.setEnable(this.wrapperLayout, playable0.isService());
        ViewUtils.showWhen(this.itemView, true);
    }

    public static int getLayoutRsId() [...] // Inlined contents
}

