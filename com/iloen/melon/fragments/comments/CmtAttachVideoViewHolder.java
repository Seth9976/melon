package com.iloen.melon.fragments.comments;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.b;
import v9.c;

public class CmtAttachVideoViewHolder extends CmtBaseViewHolder {
    private static final String TAG = "CmtAttachVideoViewHolder";
    private TextView btnAttach;
    private ImageView ivGrade;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private ImageView moreIv;
    private View thumbContainer;
    private TextView tvArtist;
    private TextView tvIssue;
    private TextView tvPlaytime;
    private TextView tvRound;
    private TextView tvTitle;
    private TextView tvViewCount;

    public CmtAttachVideoViewHolder(View view0, CmtBaseFragment cmtBaseFragment0) {
        super(view0, cmtBaseFragment0);
        this.thumbContainer = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.tvPlaytime = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
        this.ivGrade = (ImageView)view0.findViewById(0x7F0A0633);  // id:iv_grade
        this.tvRound = (TextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
        this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.tvArtist = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.tvIssue = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        this.tvViewCount = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
        this.btnAttach = (TextView)view0.findViewById(0x7F0A0140);  // id:btn_attach
        this.moreIv = (ImageView)view0.findViewById(0x7F0A081B);  // id:more_iv
        ViewUtils.hideWhen(this.tvViewCount, true);
        this.tvArtist.setTextColor(ColorUtils.getColor(view0.getContext(), 0x7F06016D));  // color:gray900s
        ImageView imageView0 = this.ivThumbDefault;
        if(imageView0 != null) {
            ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(imageView0.getContext(), 92.0f), false);
        }
        ViewUtils.hideWhen(this.moreIv, true);
    }

    public void bindView(MUSICLIST listMusicRes$result$MUSICLIST0, int v, int v1) {
        if(this.isListMusicResValid(listMusicRes$result$MUSICLIST0) && this.isFragmentValid(this.getFragment())) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(listMusicRes$result$MUSICLIST0.videoimagepath).into(this.ivThumb);
                if(!TextUtils.isEmpty("이미지")) {
                    this.ivThumb.setContentDescription("이미지");
                }
            }
            if(this.ivGrade != null) {
                int v2 = ResourceUtils.getMvAdultGradeIcon(b.c(listMusicRes$result$MUSICLIST0.videoagelevel));
                if(v2 < 0) {
                    ViewUtils.hideWhen(this.ivGrade, true);
                }
                else {
                    this.ivGrade.setImageResource(v2);
                    ViewUtils.showWhen(this.ivGrade, true);
                }
            }
            TextView textView0 = this.tvRound;
            if(textView0 != null) {
                ViewUtils.showWhen(textView0, !TextUtils.isEmpty(listMusicRes$result$MUSICLIST0.videoEpsdName));
                this.tvRound.setText(listMusicRes$result$MUSICLIST0.videoEpsdName);
            }
            TextView textView1 = this.tvTitle;
            if(textView1 != null) {
                textView1.setText(ListMusicRes.getMvTitle(listMusicRes$result$MUSICLIST0));
            }
            TextView textView2 = this.tvArtist;
            if(textView2 != null) {
                textView2.setText(ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist));
                this.tvArtist.requestLayout();
            }
            TextView textView3 = this.tvIssue;
            if(textView3 != null) {
                textView3.setText(listMusicRes$result$MUSICLIST0.dsplyvideoissuedate);
            }
            TextView textView4 = this.tvPlaytime;
            if(textView4 != null) {
                textView4.setText(listMusicRes$result$MUSICLIST0.dsplyplaytime);
            }
            TextView textView5 = this.tvViewCount;
            if(textView5 != null) {
                textView5.setText(StringUtils.getCountFormattedString(listMusicRes$result$MUSICLIST0.videoviewcnt));
            }
            TextView textView6 = this.btnAttach;
            if(textView6 != null) {
                ViewUtils.showWhen(textView6, true);
                this.btnAttach.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(CmtAttachVideoViewHolder.this.getFragment() instanceof CmtAttachFragment) {
                            ((CmtAttachFragment)CmtAttachVideoViewHolder.this.getFragment()).addAttachInfo(listMusicRes$result$MUSICLIST0);
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
        return CmtAttachVideoViewHolder.getLayoutRsId(c.a);
    }

    public static int getLayoutRsId(c c0) {
        LogU.d("CmtAttachVideoViewHolder", "Layout theme = " + c0);
        return 0x7F0D04BB;  // layout:listitem_video
    }
}

