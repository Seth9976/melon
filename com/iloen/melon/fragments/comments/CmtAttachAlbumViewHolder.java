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

public class CmtAttachAlbumViewHolder extends CmtBaseViewHolder {
    private static final String TAG = "CmtAttachAlbumViewHolder";
    private TextView btnAttach;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private View thumbContainer;
    private TextView tvArtist;
    private TextView tvIssue;
    private TextView tvTitle;

    public CmtAttachAlbumViewHolder(View view0, CmtBaseFragment cmtBaseFragment0) {
        super(view0, cmtBaseFragment0);
        this.thumbContainer = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.tvArtist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.tvIssue = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        this.btnAttach = (TextView)view0.findViewById(0x7F0A0140);  // id:btn_attach
        ViewUtils.hideWhen(view0.findViewById(0x7F0A05F1), true);  // id:iv_arrow
        ViewUtils.hideWhen(view0.findViewById(0x7F0A0182), true);  // id:btn_play
        ImageView imageView0 = this.ivThumbDefault;
        if(imageView0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(imageView0.getContext(), 85.0f), false);
        }
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
            TextView textView0 = this.tvTitle;
            if(textView0 != null) {
                textView0.setText(listMusicRes$result$MUSICLIST0.albumname);
            }
            TextView textView1 = this.tvArtist;
            if(textView1 != null) {
                textView1.setText(ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist));
            }
            TextView textView2 = this.tvIssue;
            if(textView2 != null) {
                textView2.setText(listMusicRes$result$MUSICLIST0.dsplyissuedate);
            }
            TextView textView3 = this.btnAttach;
            if(textView3 != null) {
                ViewUtils.showWhen(textView3, true);
                this.btnAttach.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(CmtAttachAlbumViewHolder.this.getFragment() instanceof CmtAttachFragment) {
                            ((CmtAttachFragment)CmtAttachAlbumViewHolder.this.getFragment()).addAttachInfo(listMusicRes$result$MUSICLIST0);
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
        return CmtAttachAlbumViewHolder.getLayoutRsId(c.a);
    }

    public static int getLayoutRsId(c c0) {
        LogU.d("CmtAttachAlbumViewHolder", "Layout theme = " + c0);
        return 0x7F0D0455;  // layout:listitem_album
    }
}

