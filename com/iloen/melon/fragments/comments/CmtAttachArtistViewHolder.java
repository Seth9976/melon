package com.iloen.melon.fragments.comments;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.c;

public class CmtAttachArtistViewHolder extends CmtBaseViewHolder {
    private static final String TAG = "CmtAttachArtistViewHolder";
    private View attachBtnContainer;
    private TextView btnAttach;
    private View friendshipContainer;
    private ImageView ivFan;
    private ImageView ivNew;
    private ImageView ivThumbCircle;
    private ImageView ivThumbCircleDefault;
    private View thumbCircleContainer;
    private TextView tvArtist;
    private TextView tvDetail;

    public CmtAttachArtistViewHolder(View view0, CmtBaseFragment cmtBaseFragment0) {
        super(view0, cmtBaseFragment0);
        this.thumbCircleContainer = view0.findViewById(0x7F0A0B6C);  // id:thumb_artist_container
        this.ivThumbCircleDefault = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.ivNew = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
        this.tvArtist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.tvDetail = (TextView)view0.findViewById(0x7F0A0C62);  // id:tv_detail
        View view1 = view0.findViewById(0x7F0A00C6);  // id:attach_btn_container
        this.attachBtnContainer = view1;
        this.btnAttach = (TextView)view1.findViewById(0x7F0A0140);  // id:btn_attach
        this.friendshipContainer = view0.findViewById(0x7F0A04E0);  // id:friendship_container
        this.ivFan = (ImageView)view0.findViewById(0x7F0A062D);  // id:iv_fan
        ViewUtils.hideWhen(this.friendshipContainer, true);
        ViewUtils.hideWhen(this.ivNew, true);
        ViewUtils.hideWhen(this.ivFan, true);
        ImageView imageView0 = this.ivThumbCircleDefault;
        if(imageView0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(imageView0.getContext(), 65.0f), true);
        }
    }

    public void bindView(MUSICLIST listMusicRes$result$MUSICLIST0, int v, int v1) {
        if(this.isListMusicResValid(listMusicRes$result$MUSICLIST0) && this.isFragmentValid(this.getFragment())) {
            ImageView imageView0 = this.ivThumbCircle;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(listMusicRes$result$MUSICLIST0.artistimagepath).apply(RequestOptions.circleCropTransform()).into(this.ivThumbCircle);
                String s = String.format("%s 아티스트 이미지", listMusicRes$result$MUSICLIST0.artistname);
                if(!TextUtils.isEmpty(s)) {
                    this.ivThumbCircle.setContentDescription(s);
                }
            }
            TextView textView0 = this.tvArtist;
            if(textView0 != null) {
                textView0.setText(listMusicRes$result$MUSICLIST0.artistname);
            }
            TextView textView1 = this.tvDetail;
            if(textView1 != null) {
                textView1.setText(listMusicRes$result$MUSICLIST0.gnr);
                ViewUtils.showWhen(this.tvDetail, true);
            }
            View view0 = this.attachBtnContainer;
            if(view0 != null && this.btnAttach != null) {
                ViewUtils.showWhen(view0, true);
                ViewUtils.showWhen(this.btnAttach, true);
                this.btnAttach.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(CmtAttachArtistViewHolder.this.getFragment() instanceof CmtAttachFragment) {
                            ((CmtAttachFragment)CmtAttachArtistViewHolder.this.getFragment()).addAttachInfo(listMusicRes$result$MUSICLIST0);
                        }
                    }
                });
            }
            ViewUtils.showWhen(this.getMainContainer(), true);
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CmtBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((MUSICLIST)object0), v, v1);
    }

    public static int getLayoutRsId() {
        return CmtAttachArtistViewHolder.getLayoutRsId(c.a);
    }

    public static int getLayoutRsId(c c0) {
        LogU.d("CmtAttachArtistViewHolder", "Layout theme = " + c0);
        return 0x7F0D0456;  // layout:listitem_artist
    }
}

