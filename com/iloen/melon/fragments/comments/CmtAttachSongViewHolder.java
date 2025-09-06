package com.iloen.melon.fragments.comments;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.c;

public class CmtAttachSongViewHolder extends CmtBaseViewHolder {
    private static final String TAG = "CmtAttachSongViewHolder";
    private TextView btnAttach;
    private ImageView ivList19;
    private ImageView ivListFree;
    private ImageView ivListHoldBack;
    private ImageView ivListHot;
    private ImageView ivListTitle;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private View thumbContainer;
    private TextView tvArtist;
    private TextView tvTitle;

    public CmtAttachSongViewHolder(View view0, CmtBaseFragment cmtBaseFragment0) {
        super(view0, cmtBaseFragment0);
        this.thumbContainer = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.ivList19 = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
        this.ivListTitle = (ImageView)view0.findViewById(0x7F0A0646);  // id:iv_list_title
        this.ivListHot = (ImageView)view0.findViewById(0x7F0A0642);  // id:iv_list_hot
        this.ivListFree = (ImageView)view0.findViewById(0x7F0A0640);  // id:iv_list_free
        this.ivListHoldBack = (ImageView)view0.findViewById(0x7F0A0641);  // id:iv_list_holdback
        this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.tvArtist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.btnAttach = (TextView)view0.findViewById(0x7F0A0140);  // id:btn_attach
        ImageView imageView0 = this.ivThumbDefault;
        if(imageView0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(imageView0.getContext(), 48.0f), false);
        }
        ViewUtils.showWhen(view0.findViewById(0x7F0A0182), false);  // id:btn_play
        ViewUtils.showWhen(view0.findViewById(0x7F0A0169), false);  // id:btn_info
    }

    public void bindView(MUSICLIST listMusicRes$result$MUSICLIST0, int v, int v1) {
        if(this.isListMusicResValid(listMusicRes$result$MUSICLIST0) && this.isFragmentValid(this.getFragment())) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(listMusicRes$result$MUSICLIST0.albumimagepath).into(this.ivThumb);
                if(!TextUtils.isEmpty("이미지")) {
                    this.ivThumb.setContentDescription("이미지");
                }
            }
            ImageView imageView1 = this.ivList19;
            if(imageView1 != null) {
                ViewUtils.showWhen(imageView1, listMusicRes$result$MUSICLIST0.adultflag);
            }
            ImageView imageView2 = this.ivListHoldBack;
            if(imageView2 != null) {
                ViewUtils.showWhen(imageView2, listMusicRes$result$MUSICLIST0.holdbackflag);
            }
            ImageView imageView3 = this.ivListFree;
            if(imageView3 != null) {
                ViewUtils.showWhen(imageView3, listMusicRes$result$MUSICLIST0.freezoneflag);
            }
            TextView textView0 = this.tvTitle;
            if(textView0 != null) {
                textView0.setText(listMusicRes$result$MUSICLIST0.songname);
            }
            TextView textView1 = this.tvArtist;
            if(textView1 != null) {
                textView1.setText(ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist));
            }
            TextView textView2 = this.btnAttach;
            if(textView2 != null) {
                ViewUtils.showWhen(textView2, true);
                this.btnAttach.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(CmtAttachSongViewHolder.this.getFragment() instanceof CmtAttachFragment) {
                            ((CmtAttachFragment)CmtAttachSongViewHolder.this.getFragment()).addAttachInfo(listMusicRes$result$MUSICLIST0);
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
        return CmtAttachSongViewHolder.getLayoutRsId(c.a);
    }

    public static int getLayoutRsId(c c0) {
        LogU.d("CmtAttachSongViewHolder", "Layout theme = " + c0);
        return 0x7F0D04A8;  // layout:listitem_song
    }
}

