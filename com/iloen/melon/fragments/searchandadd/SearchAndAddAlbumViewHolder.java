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
import com.melon.net.res.common.AlbumInfoBase;

public class SearchAndAddAlbumViewHolder extends O0 {
    private View actionView;
    private TextView artistName;
    private TextView issueDate;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private SearchAndAddBaseAdapter mAdapter;
    private TextView title;
    private View wrapperLayout;

    public SearchAndAddAlbumViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        this.mAdapter = searchAndAddBaseAdapter0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.issueDate = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        ViewUtils.hideWhen(view0.findViewById(0x7F0A05F1), true);  // id:iv_arrow
        ViewUtils.hideWhen(view0.findViewById(0x7F0A0182), true);  // id:btn_play
        ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 85.0f), false);
        if(this.mAdapter.isMarkedMode()) {
            View view1 = view0.findViewById(0x7F0A0610);  // id:iv_check
            this.actionView = view1;
            view1.setClickable(false);
        }
        else {
            View view2 = view0.findViewById(0x7F0A0140);  // id:btn_attach
            this.actionView = view2;
            ((TextView)view2).setText(0x7F130781);  // string:mymusic_setting "설정"
        }
        ViewUtils.showWhen(view0, false);
    }

    public void bindView(AlbumInfoBase albumInfoBase0, int v, int v1) {
        if(albumInfoBase0 != null) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(albumInfoBase0.albumImg).into(this.ivThumb);
            }
            this.title.setText(albumInfoBase0.albumName);
            this.artistName.setText(ProtocolUtils.getArtistNames(albumInfoBase0.artistList));
            this.issueDate.setText(albumInfoBase0.issueDate);
            ViewUtils.showWhen(this.actionView, albumInfoBase0.canService);
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(Playable.from(albumInfoBase0, this.mAdapter.getMenuId(), null));
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddAlbumViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddAlbumViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                com.iloen.melon.fragments.searchandadd.SearchAndAddAlbumViewHolder.1 searchAndAddAlbumViewHolder$10 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddAlbumViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddAlbumViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                };
                ViewUtils.setOnClickListener(this.itemView, searchAndAddAlbumViewHolder$10);
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
            ViewUtils.setEnable(this.wrapperLayout, albumInfoBase0.canService);
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public static int getLayoutRsId() [...] // Inlined contents
}

