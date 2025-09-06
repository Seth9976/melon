package com.iloen.melon.fragments.searchandadd;

import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;

public class SearchAndAddMvViewHolder extends O0 {
    private View actionView;
    private TextView artistName;
    private ImageView gradeIcon;
    private TextView issueDate;
    private ImageView ivThumb;
    private ImageView ivThumbDefault;
    private SearchAndAddBaseAdapter mAdapter;
    private ImageView moreIv;
    private TextView playtime;
    private TextView title;
    private TextView tvRound;
    private TextView viewCount;
    private View wrapperLayout;

    public SearchAndAddMvViewHolder(View view0, SearchAndAddBaseAdapter searchAndAddBaseAdapter0) {
        super(view0);
        this.mAdapter = searchAndAddBaseAdapter0;
        this.wrapperLayout = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
        this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.gradeIcon = (ImageView)view0.findViewById(0x7F0A0633);  // id:iv_grade
        this.playtime = (TextView)view0.findViewById(0x7F0A0CE5);  // id:tv_playtime
        this.tvRound = (TextView)view0.findViewById(0x7F0A0CFF);  // id:tv_round
        this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
        this.issueDate = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        this.viewCount = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
        this.moreIv = (ImageView)view0.findViewById(0x7F0A081B);  // id:more_iv
        ViewUtils.hideWhen(this.viewCount, true);
        ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 92.0f), false);
        ViewUtils.showWhen(this.moreIv, false);
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

    public void bindView(MvInfoBase mvInfoBase0, int v, int v1) {
        if(mvInfoBase0 != null) {
            ImageView imageView0 = this.ivThumb;
            if(imageView0 != null) {
                Glide.with(imageView0.getContext()).load(mvInfoBase0.mvImg).into(this.ivThumb);
            }
            int v2 = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
            if(v2 < 0) {
                ViewUtils.showWhen(this.gradeIcon, false);
            }
            else {
                this.gradeIcon.setImageResource(v2);
                ViewUtils.showWhen(this.gradeIcon, true);
            }
            if(TextUtils.isEmpty(mvInfoBase0.playTime)) {
                ViewUtils.showWhen(this.playtime, false);
            }
            else {
                ViewUtils.showWhen(this.playtime, !TextUtils.isEmpty(mvInfoBase0.playTime));
                ViewUtils.setTimeForSecText(this.playtime, mvInfoBase0.playTime);
            }
            ViewUtils.showWhen(this.tvRound, !TextUtils.isEmpty(mvInfoBase0.epsdName));
            this.tvRound.setText(mvInfoBase0.epsdName);
            ViewUtils.setTextViewMarquee(this.title, this.mAdapter.isMarqueeNeeded(v1));
            this.title.setText("null");
            this.artistName.setText(ProtocolUtils.getArtistNames(mvInfoBase0.artistList));
            this.issueDate.setText(mvInfoBase0.issueDate);
            this.viewCount.setText(StringUtils.getCountFormattedString(mvInfoBase0.viewCnt));
            ViewUtils.showWhen(this.actionView, mvInfoBase0.canService);
            if(!this.mAdapter.isMarkedMode()) {
                this.actionView.setTag(Playable.from(mvInfoBase0, this.mAdapter.getMenuId(), null));
                this.actionView.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddMvViewHolder.this.mAdapter.mOnItemEventListener != null) {
                            SearchAndAddMvViewHolder.this.mAdapter.mOnItemEventListener.onAdd(((Playable)view0.getTag()));
                        }
                    }
                });
            }
            else if(this.actionView instanceof ImageView) {
                com.iloen.melon.fragments.searchandadd.SearchAndAddMvViewHolder.1 searchAndAddMvViewHolder$10 = new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        if(SearchAndAddMvViewHolder.this.mAdapter.mOnItemViewClickListener != null) {
                            SearchAndAddMvViewHolder.this.mAdapter.mOnItemViewClickListener.onItemViewClick(view0, v);
                        }
                    }
                };
                ViewUtils.setOnClickListener(this.itemView, searchAndAddMvViewHolder$10);
                if(this.mAdapter.isMarked(v1)) {
                    ((ImageView)this.actionView).setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                    this.actionView.setContentDescription("선택 취소 버튼");
                    int v3 = ColorUtils.getColor(this.itemView.getContext(), 0x7F060199);  // color:list_item_marked
                    this.itemView.setBackgroundColor(v3);
                }
                else {
                    ((ImageView)this.actionView).setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                    this.actionView.setContentDescription("선택 버튼");
                    int v4 = ColorUtils.getColor(this.itemView.getContext(), 0x7F06048A);  // color:transparent
                    this.itemView.setBackgroundColor(v4);
                }
            }
            ViewUtils.setEnable(this.wrapperLayout, mvInfoBase0.canService);
            ViewUtils.showWhen(this.itemView, true);
        }
    }

    public static int getLayoutRsId() [...] // Inlined contents
}

