package com.iloen.melon.fragments.searchandadd;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.PhotoInfoBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class SearchAndAddPhotoViewHolder extends O0 {
    private View actionView;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private SearchAndAddBaseAdapter mAdapter;

    public SearchAndAddPhotoViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        recyclerView$LayoutParams0.leftMargin = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 1.0f);
        recyclerView$LayoutParams0.rightMargin = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 1.0f);
        recyclerView$LayoutParams0.topMargin = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 1.0f);
        recyclerView$LayoutParams0.bottomMargin = ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 1.0f);
        this.mAdapter = searchAndAddBaseAdapter0;
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 117.0f), false);
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

    public void bindView(PhotoInfoBase photoInfoBase0, int v, int v1) {
        if(photoInfoBase0 != null) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(photoInfoBase0.imagePath).into(this.ivThumb);
            }
            if(!TextUtils.isEmpty("이미지")) {
                this.ivThumb.setContentDescription("이미지");
            }
            ViewUtils.showWhen(this.actionView, true);
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(photoInfoBase0);
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddPhotoViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddPhotoViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                com.iloen.melon.fragments.searchandadd.SearchAndAddPhotoViewHolder.1 searchAndAddPhotoViewHolder$10 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddPhotoViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddPhotoViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                };
                ViewUtils.setOnClickListener(this.itemView, searchAndAddPhotoViewHolder$10);
                if(this.mAdapter.isMarked(v1)) {
                    ViewUtils.showWhen(this.actionView, true);
                    this.actionView.setContentDescription("선택 취소 버튼");
                }
                else {
                    ViewUtils.showWhen(this.actionView, false);
                    this.actionView.setContentDescription("선택 버튼");
                }
            }
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public static int getLayoutRsId() {
        return 0x7F0D041B;  // layout:griditem_photo
    }
}

