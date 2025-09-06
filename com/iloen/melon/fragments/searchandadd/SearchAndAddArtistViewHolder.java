package com.iloen.melon.fragments.searchandadd;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.ArtistInfoBase;

public class SearchAndAddArtistViewHolder extends O0 {
    private View actionView;
    private TextView artistName;
    private TextView detail;
    private ImageView ivNew;
    private ImageView ivThumbCircle;
    private ImageView ivThumbCircleDefault;
    private SearchAndAddBaseAdapter mAdapter;
    private static final int thumbCircleDiameter;
    private View wrapperLayout;

    static {
        SearchAndAddArtistViewHolder.thumbCircleDiameter = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 65.0f);
    }

    public SearchAndAddArtistViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        this.mAdapter = searchAndAddBaseAdapter0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        this.ivThumbCircleDefault = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.ivNew = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
        this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.detail = (TextView)view0.findViewById(0x7F0A0C62);  // id:tv_detail
        ViewUtils.setDefaultImage(this.ivThumbCircleDefault, SearchAndAddArtistViewHolder.thumbCircleDiameter, true);
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

    public void bindView(ArtistInfoBase artistInfoBase0, int v, int v1) {
        if(artistInfoBase0 != null) {
            ImageView imageView0 = this.ivThumbCircle;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(artistInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(this.ivThumbCircle);
            }
            String s = String.format("%s 아티스트 이미지", ProtocolUtils.getArtistNames(artistInfoBase0.artistList));
            if(!TextUtils.isEmpty(s)) {
                this.ivThumbCircle.setContentDescription(s);
            }
            this.artistName.setText(artistInfoBase0.getArtistName());
            this.detail.setText(artistInfoBase0.actGenre);
            ViewUtils.showWhen(this.actionView, true);
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(artistInfoBase0);
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddArtistViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddArtistViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                com.iloen.melon.fragments.searchandadd.SearchAndAddArtistViewHolder.1 searchAndAddArtistViewHolder$10 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddArtistViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddArtistViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                };
                ViewUtils.setOnClickListener(this.itemView, searchAndAddArtistViewHolder$10);
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
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public static int getLayoutRsId() [...] // Inlined contents
}

