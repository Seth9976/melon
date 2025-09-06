package com.iloen.melon.fragments.melontv;

import a9.d;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.MelonTvAdapter;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.eventbus.EventLogin.MelOn;
import com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MelonTvLikedProgramReq;
import com.iloen.melon.net.v4x.request.MelonTvLikedVideoReq.ParamInfo;
import com.iloen.melon.net.v4x.request.MelonTvLikedVideoReq;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes;
import com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes.RESPONSE.MVLIST;
import com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.MvHolderDefaultImpl.OnClickListener;
import com.iloen.melon.viewholders.MvHolderDefaultImpl;
import com.melon.net.res.common.MvInfoBase.REPARTIST;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import r8.f;
import v9.e;
import v9.h;
import v9.i;

public class MelonTvLikedFragment extends MelonTvBaseFragment {
    class MelonTvLikedAdapter extends MelonTvAdapter {
        class ProgramLandViewHolder extends O0 {
            private ImageView ivDefaultThumb;
            private BorderImageView ivThumb;
            private ImageView mBtnInfo1;
            private ImageView mBtnInfo2;
            private ImageView mBtnInfo3;
            private ImageView mBtnInfo4;
            private ImageView mIvGrade1;
            private ImageView mIvGrade2;
            private ImageView mIvGrade3;
            private ImageView mIvGrade4;
            private ImageView mIvHot;
            private ImageView mIvNew;
            private ImageView mIvThumbDefault1;
            private ImageView mIvThumbDefault2;
            private ImageView mIvThumbDefault3;
            private ImageView mIvThumbDefault4;
            private ImageView mIvThumbnail1;
            private ImageView mIvThumbnail2;
            private ImageView mIvThumbnail3;
            private ImageView mIvThumbnail4;
            private View mProgramItem1;
            private View mProgramItem2;
            private View mProgramItem3;
            private View mProgramItem4;
            private View mProgramItemContainer;
            private View mProgramLikeContainer;
            private View mProgramTitleContainer;
            private TextView mTvArtist1;
            private TextView mTvArtist2;
            private TextView mTvArtist3;
            private TextView mTvArtist4;
            private TextView mTvMvName1;
            private TextView mTvMvName2;
            private TextView mTvMvName3;
            private TextView mTvMvName4;
            private TextView mTvPlayTime1;
            private TextView mTvPlayTime2;
            private TextView mTvPlayTime3;
            private TextView mTvPlayTime4;
            private TextView mTvProgramDesc;
            private TextView mTvProgramTitle;
            private TextView mTvRound1;
            private TextView mTvRound2;
            private TextView mTvRound3;
            private TextView mTvRound4;

            public ProgramLandViewHolder(View view0) {
                super(view0);
                this.mProgramLikeContainer = view0.findViewById(0x7F0A0976);  // id:program_like_container
                this.mProgramTitleContainer = view0.findViewById(0x7F0A097B);  // id:program_title_container
                this.mProgramItemContainer = view0.findViewById(0x7F0A0975);  // id:program_item_container
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb = imageView0;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 49.0f));
                BorderImageView borderImageView0 = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb = borderImageView0;
                borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 0.5f));
                this.ivThumb.setBorderColor(ColorUtils.getColor(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                this.mTvProgramTitle = (TextView)view0.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.mTvProgramDesc = (TextView)view0.findViewById(0x7F0A0CED);  // id:tv_program_desc
                this.mIvNew = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.mIvHot = (ImageView)view0.findViewById(0x7F0A0634);  // id:iv_hot
                View view1 = view0.findViewById(0x7F0A0970);  // id:program_item1
                this.mProgramItem1 = view1;
                View view2 = view1.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault1 = (ImageView)view2.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail1 = (ImageView)view2.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade1 = (ImageView)this.mProgramItem1.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo1 = (ImageView)this.mProgramItem1.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0CE5);  // id:tv_playtime
                View view3 = view0.findViewById(0x7F0A0971);  // id:program_item2
                this.mProgramItem2 = view3;
                View view4 = view3.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault2 = (ImageView)view4.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail2 = (ImageView)view4.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade2 = (ImageView)this.mProgramItem2.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo2 = (ImageView)this.mProgramItem2.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0CE5);  // id:tv_playtime
                View view5 = view0.findViewById(0x7F0A0972);  // id:program_item3
                this.mProgramItem3 = view5;
                View view6 = view5.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault3 = (ImageView)view6.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail3 = (ImageView)view6.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade3 = (ImageView)this.mProgramItem3.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo3 = (ImageView)this.mProgramItem3.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0CE5);  // id:tv_playtime
                View view7 = view0.findViewById(0x7F0A0973);  // id:program_item4
                this.mProgramItem4 = view7;
                View view8 = view7.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault4 = (ImageView)view8.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail4 = (ImageView)view8.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade4 = (ImageView)this.mProgramItem4.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo4 = (ImageView)this.mProgramItem4.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound4 = (TextView)this.mProgramItem4.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName4 = (TextView)this.mProgramItem4.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist4 = (TextView)this.mProgramItem4.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime4 = (TextView)this.mProgramItem4.findViewById(0x7F0A0CE5);  // id:tv_playtime
            }

            public static TextView O(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvRound1;
            }

            public static TextView P(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvRound2;
            }

            public static TextView Q(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvRound3;
            }

            public static TextView R(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvRound4;
            }

            public static BorderImageView a(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.ivThumb;
            }

            public static ImageView b(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mBtnInfo1;
            }

            public static ImageView c(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mBtnInfo2;
            }

            public static ImageView d(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mBtnInfo3;
            }

            public static ImageView e(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mBtnInfo4;
            }

            public static ImageView f(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvGrade1;
            }

            public static ImageView g(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvGrade2;
            }

            public static ImageView h(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvGrade3;
            }

            public static ImageView i(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvGrade4;
            }

            public static ImageView j(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvHot;
            }

            public static ImageView k(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvNew;
            }

            public static ImageView l(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbDefault1;
            }

            public static ImageView m(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbDefault2;
            }

            public static ImageView n(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbDefault3;
            }

            public static ImageView o(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbDefault4;
            }

            public static ImageView p(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbnail1;
            }

            public static ImageView q(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbnail2;
            }

            public static ImageView r(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbnail3;
            }

            public static ImageView s(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mIvThumbnail4;
            }

            public static View t(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramItem1;
            }

            public static View u(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramItem2;
            }

            public static View v(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramItem3;
            }

            public static View w(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramItem4;
            }

            public static View x(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramItemContainer;
            }

            public static View y(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramLikeContainer;
            }

            public static View z(ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mProgramTitleContainer;
            }
        }

        class ProgramViewHolder extends O0 {
            private ImageView ivDefaultThumb;
            private BorderImageView ivThumb;
            private ImageView mBtnInfo1;
            private ImageView mBtnInfo2;
            private ImageView mBtnInfo3;
            private ImageView mIvGrade1;
            private ImageView mIvGrade2;
            private ImageView mIvGrade3;
            private ImageView mIvHot;
            private ImageView mIvNew;
            private ImageView mIvThumbDefault1;
            private ImageView mIvThumbDefault2;
            private ImageView mIvThumbDefault3;
            private ImageView mIvThumbnail1;
            private ImageView mIvThumbnail2;
            private ImageView mIvThumbnail3;
            private View mProgramItem1;
            private View mProgramItem2;
            private View mProgramItem3;
            private View mProgramItemContainer;
            private View mProgramLikeContainer;
            private View mProgramTitleContainer;
            private TextView mTvArtist1;
            private TextView mTvArtist2;
            private TextView mTvArtist3;
            private TextView mTvMvName1;
            private TextView mTvMvName2;
            private TextView mTvMvName3;
            private TextView mTvPlayTime1;
            private TextView mTvPlayTime2;
            private TextView mTvPlayTime3;
            private TextView mTvProgramDesc;
            private TextView mTvProgramTitle;
            private TextView mTvRound1;
            private TextView mTvRound2;
            private TextView mTvRound3;

            public ProgramViewHolder(View view0) {
                super(view0);
                this.mProgramLikeContainer = view0.findViewById(0x7F0A0976);  // id:program_like_container
                this.mProgramTitleContainer = view0.findViewById(0x7F0A097B);  // id:program_title_container
                this.mProgramItemContainer = view0.findViewById(0x7F0A0975);  // id:program_item_container
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                this.ivDefaultThumb = imageView0;
                ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 49.0f));
                BorderImageView borderImageView0 = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.ivThumb = borderImageView0;
                borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 0.5f));
                this.ivThumb.setBorderColor(ColorUtils.getColor(melonTvLikedFragment$MelonTvLikedAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                this.mTvProgramTitle = (TextView)view0.findViewById(0x7F0A0CEF);  // id:tv_program_title
                this.mTvProgramDesc = (TextView)view0.findViewById(0x7F0A0CED);  // id:tv_program_desc
                this.mIvNew = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
                this.mIvHot = (ImageView)view0.findViewById(0x7F0A0634);  // id:iv_hot
                View view1 = view0.findViewById(0x7F0A0970);  // id:program_item1
                this.mProgramItem1 = view1;
                View view2 = view1.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault1 = (ImageView)view2.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail1 = (ImageView)view2.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade1 = (ImageView)this.mProgramItem1.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo1 = (ImageView)this.mProgramItem1.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime1 = (TextView)this.mProgramItem1.findViewById(0x7F0A0CE5);  // id:tv_playtime
                View view3 = view0.findViewById(0x7F0A0971);  // id:program_item2
                this.mProgramItem2 = view3;
                View view4 = view3.findViewById(0x7F0A0B72);  // id:thumb_container
                this.mIvThumbDefault2 = (ImageView)view4.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.mIvThumbnail2 = (ImageView)view4.findViewById(0x7F0A069A);  // id:iv_thumb
                this.mIvGrade2 = (ImageView)this.mProgramItem2.findViewById(0x7F0A0633);  // id:iv_grade
                this.mBtnInfo2 = (ImageView)this.mProgramItem2.findViewById(0x7F0A0169);  // id:btn_info
                this.mTvRound2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0CFF);  // id:tv_round
                this.mTvMvName2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0D34);  // id:tv_title
                this.mTvArtist2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0C12);  // id:tv_artist
                this.mTvPlayTime2 = (TextView)this.mProgramItem2.findViewById(0x7F0A0CE5);  // id:tv_playtime
                View view5 = view0.findViewById(0x7F0A0972);  // id:program_item3
                this.mProgramItem3 = view5;
                if(view5 != null) {
                    View view6 = view5.findViewById(0x7F0A0B72);  // id:thumb_container
                    if(view6 != null) {
                        this.mIvThumbDefault3 = (ImageView)view6.findViewById(0x7F0A069E);  // id:iv_thumb_default
                        this.mIvThumbnail3 = (ImageView)view6.findViewById(0x7F0A069A);  // id:iv_thumb
                    }
                    this.mIvGrade3 = (ImageView)this.mProgramItem3.findViewById(0x7F0A0633);  // id:iv_grade
                    this.mBtnInfo3 = (ImageView)this.mProgramItem3.findViewById(0x7F0A0169);  // id:btn_info
                    this.mTvRound3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0CFF);  // id:tv_round
                    this.mTvMvName3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0D34);  // id:tv_title
                    this.mTvArtist3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0C12);  // id:tv_artist
                    this.mTvPlayTime3 = (TextView)this.mProgramItem3.findViewById(0x7F0A0CE5);  // id:tv_playtime
                }
            }

            public static TextView A(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvMvName3;
            }

            public static TextView B(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvPlayTime1;
            }

            public static TextView C(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvPlayTime2;
            }

            public static TextView D(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvPlayTime3;
            }

            public static TextView E(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvProgramDesc;
            }

            public static TextView F(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvProgramTitle;
            }

            public static TextView G(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvRound1;
            }

            public static TextView H(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvRound2;
            }

            public static TextView I(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvRound3;
            }

            public static BorderImageView a(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.ivThumb;
            }

            public static ImageView b(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mBtnInfo1;
            }

            public static ImageView c(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mBtnInfo2;
            }

            public static ImageView d(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mBtnInfo3;
            }

            public static ImageView e(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvGrade1;
            }

            public static ImageView f(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvGrade2;
            }

            public static ImageView g(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvGrade3;
            }

            public static ImageView h(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvHot;
            }

            public static ImageView i(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvNew;
            }

            public static ImageView j(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbDefault1;
            }

            public static ImageView k(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbDefault2;
            }

            public static ImageView l(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbDefault3;
            }

            public static ImageView m(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbnail1;
            }

            public static ImageView n(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbnail2;
            }

            public static ImageView o(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mIvThumbnail3;
            }

            public static View p(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramItem1;
            }

            public static View q(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramItem2;
            }

            public static View r(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramItem3;
            }

            public static View s(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramItemContainer;
            }

            public static View t(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramLikeContainer;
            }

            public static View u(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mProgramTitleContainer;
            }

            public static TextView v(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvArtist1;
            }

            public static TextView w(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvArtist2;
            }

            public static TextView x(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvArtist3;
            }

            public static TextView y(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvMvName1;
            }

            public static TextView z(ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0.mTvMvName2;
            }
        }

        class SortViewHolder extends O0 {
            private SortingBarView mSortingBarView;

            public SortViewHolder(View view0) {
                super(view0);
                SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                this.mSortingBarView = sortingBarView0;
                sortingBarView0.setSortBarStyle(1);
                this.mSortingBarView.setItems(melonTvLikedFragment$MelonTvLikedAdapter0.getContext().getResources().getStringArray(0x7F03003E));  // array:sortingbar_melontv_like
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D6B), true);  // id:underline
            }

            public static SortingBarView a(SortViewHolder melonTvLikedFragment$MelonTvLikedAdapter$SortViewHolder0) {
                return melonTvLikedFragment$MelonTvLikedAdapter$SortViewHolder0.mSortingBarView;
            }
        }

        private static final int VIEW_TYPE_EMPTY = 15;
        private static final int VIEW_TYPE_PROGRAM = 11;
        private static final int VIEW_TYPE_PROGRAM_LAND = 12;
        private static final int VIEW_TYPE_PROGRAM_LAND_WIDE = 13;
        private static final int VIEW_TYPE_SORT = 10;
        private static final int VIEW_TYPE_VIDEO = 14;
        private RESPONSE mProgramList;
        private com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes.RESPONSE mVideoList;

        public MelonTvLikedAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            if(v == this.getAvailableHeaderPosition()) {
                return 10;
            }
            if(this.getItemCount() == 0) {
                return 15;
            }
            ServerDataWrapper melonTvLikedFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
            if(melonTvLikedFragment$ServerDataWrapper0 != null) {
                int v2 = melonTvLikedFragment$ServerDataWrapper0.viewType;
                if(v2 == 11) {
                    switch(MelonTvLikedFragment.this.getDeviceUiType()) {
                        case "mobileLandscape": {
                            return 12;
                        }
                        case "mobilePortrait": {
                            return 11;
                        }
                        case "tabletLandscape": {
                            return 13;
                        }
                        case "tabletPortrait": {
                            return 12;
                        }
                        default: {
                            return 11;
                        }
                    }
                }
                return v2;
            }
            return super.getItemViewTypeImpl(v, v1);
        }

        @Override  // com.iloen.melon.adapters.common.q
        public Playable getPlayable(int v) {
            ServerDataWrapper melonTvLikedFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v);
            return MelonTvLikedFragment.this.mCurrentSort == 0 ? Playable.from(melonTvLikedFragment$ServerDataWrapper0.programList, this.getMenuId(), null) : Playable.from(melonTvLikedFragment$ServerDataWrapper0.videoList, this.getMenuId(), null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof MelonTvLikedProgramRes) {
                RESPONSE melonTvLikedProgramRes$RESPONSE0 = this.mProgramList;
                this.setMenuId(melonTvLikedProgramRes$RESPONSE0.menuId);
                for(int v = 0; v < melonTvLikedProgramRes$RESPONSE0.contentsList.size(); ++v) {
                    ServerDataWrapper melonTvLikedFragment$ServerDataWrapper0 = new ServerDataWrapper(MelonTvLikedFragment.this, 0);
                    melonTvLikedFragment$ServerDataWrapper0.programList = (CONTENTSLIST)melonTvLikedProgramRes$RESPONSE0.contentsList.get(v);
                    melonTvLikedFragment$ServerDataWrapper0.viewType = 11;
                    this.add(melonTvLikedFragment$ServerDataWrapper0);
                }
                return true;
            }
            com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes.RESPONSE melonTvLikedVideoRes$RESPONSE0 = this.mVideoList;
            this.setMenuId(melonTvLikedVideoRes$RESPONSE0.menuId);
            this.setHasMore(melonTvLikedVideoRes$RESPONSE0.hasMore);
            for(int v1 = 0; v1 < melonTvLikedVideoRes$RESPONSE0.mvList.size(); ++v1) {
                ServerDataWrapper melonTvLikedFragment$ServerDataWrapper1 = new ServerDataWrapper(MelonTvLikedFragment.this, 0);
                melonTvLikedFragment$ServerDataWrapper1.videoList = (MVLIST)melonTvLikedVideoRes$RESPONSE0.mvList.get(v1);
                melonTvLikedFragment$ServerDataWrapper1.viewType = 14;
                this.add(melonTvLikedFragment$ServerDataWrapper1);
            }
            return true;
        }

        private static void lambda$onBindViewImpl$0(CONTENTSLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0, View view0) {
            if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progSeq)) {
                Navigator.open(TvProgramHomeFragment.newInstance(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progSeq));
            }
        }

        private void lambda$onBindViewImpl$1(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.playMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$2(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.showContextPopupMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$3(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.playMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$4(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.showContextPopupMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$5(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.playMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$6(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.showContextPopupMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$7(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.playMv(playable0);
            }
        }

        private void lambda$onBindViewImpl$8(com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, View view0) {
            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, this.getMenuId(), null);
            if(playable0 != null) {
                MelonTvLikedFragment.this.showContextPopupMv(playable0);
            }
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00 instanceof SortViewHolder) {
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(null);
                SortViewHolder.a(((SortViewHolder)o00)).setSelection(MelonTvLikedFragment.this.mCurrentSort);
                SortViewHolder.a(((SortViewHolder)o00)).setOnSortSelectionListener(new d() {
                    @Override  // a9.d
                    public void onSelected(int v) {
                        MelonTvLikedFragment.this.mCurrentSort = v;
                        MelonTvLikedFragment.this.startFetch();
                    }
                });
                if(MelonTvLikedFragment.this.isLoginUser() && this.getCount() > 0 && MelonTvLikedFragment.this.mCurrentSort == 1) {
                    SortingBarView sortingBarView0 = SortViewHolder.a(((SortViewHolder)o00));
                    com.iloen.melon.fragments.melontv.MelonTvLikedFragment.MelonTvLikedAdapter.2 melonTvLikedFragment$MelonTvLikedAdapter$20 = new K() {
                        @Override  // com.iloen.melon.custom.K
                        public void onClick(View view0) {
                            ArrayList arrayList0 = new ArrayList();
                            if(MelonTvLikedAdapter.this.mVideoList != null && MelonTvLikedAdapter.this.mVideoList.mvList != null && !MelonTvLikedAdapter.this.mVideoList.mvList.isEmpty()) {
                                for(Object object0: MelonTvLikedAdapter.this.mVideoList.mvList) {
                                    arrayList0.add(Playable.from(((MvInfoBase)object0), MelonTvLikedAdapter.this.getMenuId(), null));
                                }
                                MelonTvLikedFragment.this.playMvByMvId(arrayList0);
                            }
                        }
                    };
                    sortingBarView0.c(L.b, melonTvLikedFragment$MelonTvLikedAdapter$20);
                    return;
                }
                SortViewHolder.a(((SortViewHolder)o00)).setRightLayout(null);
                return;
            }
            if(o00 instanceof ProgramViewHolder) {
                ProgramViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0 = (ProgramViewHolder)o00;
                ServerDataWrapper melonTvLikedFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                CONTENTSLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0 = melonTvLikedFragment$ServerDataWrapper0.programList;
                if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0 != null) {
                    ViewUtils.setText(ProgramViewHolder.F(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progName);
                    ViewUtils.setText(ProgramViewHolder.E(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progSimplDesc);
                    Glide.with(this.getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(ProgramViewHolder.a(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0));
                    ViewUtils.showWhen(ProgramViewHolder.i(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ProtocolUtils.parseBoolean(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.newYN));
                    ViewUtils.showWhen(ProgramViewHolder.h(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ProtocolUtils.parseBoolean(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.hotYN));
                    ViewUtils.setOnClickListener(ProgramViewHolder.u(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progSeq)) {
                                Navigator.open(TvProgramHomeFragment.newInstance(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.progSeq));
                            }
                        }
                    });
                    ArrayList arrayList0 = melonTvLikedFragment$ServerDataWrapper0.programList.mvList;
                    if(arrayList0 == null || arrayList0.isEmpty()) {
                        ViewUtils.hideWhen(ProgramViewHolder.s(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                        return;
                    }
                    com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.mvList.get(0);
                    ViewUtils.showWhen(ProgramViewHolder.G(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.epsdName));
                    ViewUtils.setText(ProgramViewHolder.G(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.epsdName);
                    ViewUtils.setText(ProgramViewHolder.y(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.mvName);
                    ViewUtils.setText(ProgramViewHolder.v(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.artistList));
                    ViewUtils.setDefaultImage(ProgramViewHolder.j(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 144.0f));
                    Glide.with(ProgramViewHolder.m(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.mv169Img).into(ProgramViewHolder.m(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0));
                    ViewUtils.showWhen(ProgramViewHolder.B(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.playTime));
                    ViewUtils.setTimeForSecText(ProgramViewHolder.B(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.playTime);
                    ViewUtils.hideWhen(ProgramViewHolder.e(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                    if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.adultGrade)) {
                        int v2 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0.adultGrade);
                        if(v2 != -1) {
                            ViewUtils.showWhen(ProgramViewHolder.e(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                            ProgramViewHolder.e(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setBackgroundResource(v2);
                        }
                    }
                    ViewUtils.setOnClickListener(ProgramViewHolder.p(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            String s = MelonTvLikedAdapter.this.getMenuId();
                            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, s, null);
                            if(playable0 != null) {
                                MelonTvLikedFragment.this.playMv(playable0);
                            }
                        }
                    });
                    ViewUtils.setOnClickListener(ProgramViewHolder.b(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            String s = MelonTvLikedAdapter.this.getMenuId();
                            Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, s, null);
                            if(playable0 != null) {
                                MelonTvLikedFragment.this.showContextPopupMv(playable0);
                            }
                        }
                    });
                    boolean z = ScreenUtils.isPortrait(this.getContext());
                    if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.mvList.size() < 2) {
                        ProgramViewHolder.q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setVisibility(4);
                        if(!z) {
                            ProgramViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setVisibility(4);
                        }
                    }
                    else {
                        ProgramViewHolder.q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setVisibility(0);
                        com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.mvList.get(1);
                        ViewUtils.showWhen(ProgramViewHolder.H(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.epsdName));
                        ViewUtils.setText(ProgramViewHolder.H(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.epsdName);
                        ViewUtils.setText(ProgramViewHolder.z(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.mvName);
                        ViewUtils.setText(ProgramViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.artistList));
                        ViewUtils.setDefaultImage(ProgramViewHolder.k(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 144.0f));
                        Glide.with(ProgramViewHolder.n(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.mv169Img).into(ProgramViewHolder.n(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0));
                        ViewUtils.showWhen(ProgramViewHolder.C(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.playTime));
                        ViewUtils.setTimeForSecText(ProgramViewHolder.C(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.playTime);
                        ViewUtils.hideWhen(ProgramViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                        if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.adultGrade)) {
                            int v3 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1.adultGrade);
                            if(v3 != -1) {
                                ViewUtils.showWhen(ProgramViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                                ProgramViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setBackgroundResource(v3);
                            }
                        }
                        ViewUtils.setOnClickListener(ProgramViewHolder.q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                String s = MelonTvLikedAdapter.this.getMenuId();
                                Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1, s, null);
                                if(playable0 != null) {
                                    MelonTvLikedFragment.this.playMv(playable0);
                                }
                            }
                        });
                        ViewUtils.setOnClickListener(ProgramViewHolder.c(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                String s = MelonTvLikedAdapter.this.getMenuId();
                                Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST1, s, null);
                                if(playable0 != null) {
                                    MelonTvLikedFragment.this.showContextPopupMv(playable0);
                                }
                            }
                        });
                        if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.mvList.size() >= 3) {
                            if(z) {
                                ProgramViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setVisibility(8);
                            }
                            else {
                                com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST0.mvList.get(2);
                                ViewUtils.showWhen(ProgramViewHolder.I(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.epsdName));
                                ViewUtils.setText(ProgramViewHolder.I(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.epsdName);
                                ViewUtils.setText(ProgramViewHolder.A(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.mvName);
                                ViewUtils.setText(ProgramViewHolder.x(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.artistList));
                                ViewUtils.setDefaultImage(ProgramViewHolder.l(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 117.0f));
                                Glide.with(ProgramViewHolder.o(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.mv169Img).into(ProgramViewHolder.o(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0));
                                ViewUtils.showWhen(ProgramViewHolder.D(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.playTime));
                                ViewUtils.setTimeForSecText(ProgramViewHolder.D(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.playTime);
                                ViewUtils.hideWhen(ProgramViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                                if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.adultGrade)) {
                                    int v4 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2.adultGrade);
                                    if(v4 != -1) {
                                        ViewUtils.showWhen(ProgramViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), true);
                                        ProgramViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setBackgroundResource(v4);
                                    }
                                }
                                ViewUtils.setOnClickListener(ProgramViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                                    @Override  // android.view.View$OnClickListener
                                    public void onClick(View view0) {
                                        String s = MelonTvLikedAdapter.this.getMenuId();
                                        Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2, s, null);
                                        if(playable0 != null) {
                                            MelonTvLikedFragment.this.playMv(playable0);
                                        }
                                    }
                                });
                                ViewUtils.setOnClickListener(ProgramViewHolder.d(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0), new View.OnClickListener() {
                                    @Override  // android.view.View$OnClickListener
                                    public void onClick(View view0) {
                                        String s = MelonTvLikedAdapter.this.getMenuId();
                                        Playable playable0 = Playable.from(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST2, s, null);
                                        if(playable0 != null) {
                                            MelonTvLikedFragment.this.showContextPopupMv(playable0);
                                        }
                                    }
                                });
                            }
                        }
                        else if(!z) {
                            ProgramViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setVisibility(4);
                        }
                        if(v == 1) {
                            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)ProgramViewHolder.t(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).getLayoutParams();
                            viewGroup$MarginLayoutParams0.topMargin = ScreenUtils.dipToPixel(this.getContext(), 8.0f);
                            ProgramViewHolder.t(melonTvLikedFragment$MelonTvLikedAdapter$ProgramViewHolder0).setLayoutParams(viewGroup$MarginLayoutParams0);
                        }
                    }
                }
            }
            else if(o00 instanceof ProgramLandViewHolder) {
                ProgramLandViewHolder melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0 = (ProgramLandViewHolder)o00;
                ServerDataWrapper melonTvLikedFragment$ServerDataWrapper1 = (ServerDataWrapper)this.getItem(v1);
                CONTENTSLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1 = melonTvLikedFragment$ServerDataWrapper1.programList;
                if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1 != null) {
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvProgramTitle, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.progName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvProgramDesc, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.progSimplDesc);
                    Glide.with(this.getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(ProgramLandViewHolder.a(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0));
                    ViewUtils.showWhen(ProgramLandViewHolder.k(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ProtocolUtils.parseBoolean(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.newYN));
                    ViewUtils.showWhen(ProgramLandViewHolder.j(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ProtocolUtils.parseBoolean(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.hotYN));
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.z(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new j(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1, 4));
                    ArrayList arrayList1 = melonTvLikedFragment$ServerDataWrapper1.programList.mvList;
                    if(arrayList1 == null || arrayList1.isEmpty()) {
                        ViewUtils.hideWhen(ProgramLandViewHolder.x(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                        return;
                    }
                    com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.get(0);
                    ViewUtils.showWhen(ProgramLandViewHolder.O(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.epsdName));
                    ViewUtils.setText(ProgramLandViewHolder.O(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.epsdName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvMvName1, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.mvName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvArtist1, ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.artistList));
                    ViewUtils.setDefaultImage(ProgramLandViewHolder.l(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 144.0f));
                    Glide.with(ProgramLandViewHolder.p(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.mv169Img).into(ProgramLandViewHolder.p(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0));
                    ViewUtils.showWhen(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime1, !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.playTime));
                    ViewUtils.setTimeForSecText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime1, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.playTime);
                    ViewUtils.hideWhen(ProgramLandViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                    if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.adultGrade)) {
                        int v5 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3.adultGrade);
                        if(v5 != -1) {
                            ViewUtils.showWhen(ProgramLandViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                            ProgramLandViewHolder.f(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setBackgroundResource(v5);
                        }
                    }
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.t(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3, 0));
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.b(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST3, 1));
                    if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.size() < 2) {
                        ProgramLandViewHolder.u(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                        ProgramLandViewHolder.v(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                        ProgramLandViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                        return;
                    }
                    com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.get(1);
                    ViewUtils.showWhen(ProgramLandViewHolder.P(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.epsdName));
                    ViewUtils.setText(ProgramLandViewHolder.P(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.epsdName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvMvName2, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.mvName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvArtist2, ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.artistList));
                    ViewUtils.setDefaultImage(ProgramLandViewHolder.m(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 144.0f));
                    Glide.with(ProgramLandViewHolder.q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.mv169Img).into(ProgramLandViewHolder.q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0));
                    ViewUtils.showWhen(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime2, !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.playTime));
                    ViewUtils.setTimeForSecText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime2, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.playTime);
                    ViewUtils.hideWhen(ProgramLandViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                    if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.adultGrade)) {
                        int v6 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4.adultGrade);
                        if(v6 != -1) {
                            ViewUtils.showWhen(ProgramLandViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                            ProgramLandViewHolder.g(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setBackgroundResource(v6);
                        }
                    }
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.u(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4, 2));
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.c(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST4, 3));
                    if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.size() < 3) {
                        ProgramLandViewHolder.v(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                        ProgramLandViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                        return;
                    }
                    com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.get(2);
                    ViewUtils.showWhen(ProgramLandViewHolder.Q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.epsdName));
                    ViewUtils.setText(ProgramLandViewHolder.Q(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.epsdName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvMvName3, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.mvName);
                    ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvArtist3, ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.artistList));
                    ViewUtils.setDefaultImage(ProgramLandViewHolder.n(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 117.0f));
                    Glide.with(ProgramLandViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.mv169Img).into(ProgramLandViewHolder.r(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0));
                    ViewUtils.showWhen(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime3, !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.playTime));
                    ViewUtils.setTimeForSecText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime3, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.playTime);
                    ViewUtils.hideWhen(ProgramLandViewHolder.h(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                    if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.adultGrade)) {
                        int v7 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5.adultGrade);
                        if(v7 != -1) {
                            ViewUtils.showWhen(ProgramLandViewHolder.h(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                            ProgramLandViewHolder.h(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setBackgroundResource(v7);
                        }
                    }
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.v(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5, 4));
                    ViewUtils.setOnClickListener(ProgramLandViewHolder.d(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST5, 5));
                    if(this.getItemViewType(v1 + 1) == 13) {
                        if(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.size() < 4) {
                            ProgramLandViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(4);
                            return;
                        }
                        com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6 = (com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST)melonTvLikedProgramRes$RESPONSE$CONTENTSLIST1.mvList.get(3);
                        ViewUtils.showWhen(ProgramLandViewHolder.R(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.epsdName));
                        ViewUtils.setText(ProgramLandViewHolder.R(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.epsdName);
                        ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvMvName4, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.mvName);
                        ViewUtils.setText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvArtist4, ProtocolUtils.getArtistNames(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.artistList));
                        ViewUtils.setDefaultImage(ProgramLandViewHolder.o(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), ScreenUtils.dipToPixel(this.getContext(), 117.0f));
                        Glide.with(ProgramLandViewHolder.s(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).getContext()).load(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.mv169Img).into(ProgramLandViewHolder.s(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0));
                        ViewUtils.showWhen(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime4, !TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.playTime));
                        ViewUtils.setTimeForSecText(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0.mTvPlayTime4, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.playTime);
                        ViewUtils.hideWhen(ProgramLandViewHolder.i(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                        if(!TextUtils.isEmpty(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.adultGrade)) {
                            int v8 = ResourceUtils.getMvAdultGradeIcon(melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6.adultGrade);
                            if(v8 != -1) {
                                ViewUtils.showWhen(ProgramLandViewHolder.i(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), true);
                                ProgramLandViewHolder.i(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setBackgroundResource(v8);
                            }
                        }
                        ViewUtils.setOnClickListener(ProgramLandViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6, 6));
                        ViewUtils.setOnClickListener(ProgramLandViewHolder.e(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0), new a(this, melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST6, 7));
                    }
                    else {
                        ProgramLandViewHolder.w(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setVisibility(8);
                    }
                    if(v == 1) {
                        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams1 = (ViewGroup.MarginLayoutParams)ProgramLandViewHolder.y(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).getLayoutParams();
                        viewGroup$MarginLayoutParams1.topMargin = ScreenUtils.dipToPixel(this.getContext(), 8.0f);
                        ProgramLandViewHolder.y(melonTvLikedFragment$MelonTvLikedAdapter$ProgramLandViewHolder0).setLayoutParams(viewGroup$MarginLayoutParams1);
                    }
                }
            }
            else if(o00 instanceof MvHolderDefaultImpl) {
                MVLIST melonTvLikedVideoRes$RESPONSE$MVLIST0 = ((ServerDataWrapper)this.getItem(v1)).videoList;
                if(melonTvLikedVideoRes$RESPONSE$MVLIST0 != null) {
                    ((MvHolderDefaultImpl)o00).bindView(melonTvLikedVideoRes$RESPONSE$MVLIST0, false, this.getMenuId(), v1);
                    ((MvHolderDefaultImpl)o00).setOnClickListener(new OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void playMusicVideo(int v) {
                            Playable playable0 = MelonTvLikedAdapter.this.getPlayable(v);
                            if(playable0 != null) {
                                MelonTvLikedFragment.this.playMv(playable0);
                            }
                        }

                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void showContextPopup(Playable playable0) {
                            REPARTIST mvInfoBase$REPARTIST0 = melonTvLikedVideoRes$RESPONSE$MVLIST0.repArtist;
                            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), melonTvLikedVideoRes$RESPONSE$MVLIST0.repArtist.getArtistName());
                                playable0.setBrandDj(melonTvLikedVideoRes$RESPONSE$MVLIST0.repArtist.isBrandDjs);
                            }
                            MelonTvLikedFragment.this.showContextPopupMv(playable0);
                        }
                    });
                }
            }
        }

        @Override  // com.iloen.melon.adapters.MelonTvAdapter
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 10: {
                    return new SortViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D085D, viewGroup0, false));  // layout:sortbar_view
                }
                case 11: {
                    return new ProgramViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04ED, viewGroup0, false));  // layout:melontv_like_program_list_item
                }
                case 12: 
                case 13: {
                    return new ProgramLandViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04EE, viewGroup0, false));  // layout:melontv_like_program_list_item_land
                }
                case 14: {
                    return new MvHolderDefaultImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D04BB, viewGroup0, false));  // layout:listitem_video
                }
                default: {
                    return super.onCreateViewHolderImpl(viewGroup0, v);
                }
            }
        }

        public void setProgramListRes(RESPONSE melonTvLikedProgramRes$RESPONSE0) {
            this.mProgramList = melonTvLikedProgramRes$RESPONSE0;
        }

        public void setVideoListRes(com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes.RESPONSE melonTvLikedVideoRes$RESPONSE0) {
            this.mVideoList = melonTvLikedVideoRes$RESPONSE0;
        }
    }

    class ServerDataWrapper extends MvInfoBase {
        public CONTENTSLIST programList;
        public MVLIST videoList;
        public int viewType;

        private ServerDataWrapper() {
        }

        public ServerDataWrapper(int v) {
        }
    }

    private static String ARG_ORDER_BY = "argOrderBy";
    private static final int PAGE_SIZE = 20;
    private static final int SORT_DEFAULT = 0;
    private static final int SORT_PROGRAM = 0;
    private static final int SORT_VIDEO = 1;
    private static final int START_INDEX = 1;
    private static final String TAG = "MelonTvLikedFragment";
    private int mCurrentSort;

    public MelonTvLikedFragment() {
        this.mCurrentSort = 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new MelonTvLikedAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.j)j00).setListContentType(3);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("liked").build().toString();
    }

    private int getStartIndex(i i0) {
        if(i.c.equals(i0)) {
            return this.mAdapter instanceof MelonTvLikedAdapter ? ((MelonTvLikedAdapter)this.mAdapter).getCount() + 1 : 1;
        }
        return 1;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean handleNotificationStatusWithEmptyView() {
        return true;
    }

    public static MelonTvLikedFragment newInstance() {
        return MelonTvLikedFragment.newInstance(0);
    }

    public static MelonTvLikedFragment newInstance(int v) {
        MelonTvLikedFragment melonTvLikedFragment0 = new MelonTvLikedFragment();
        Bundle bundle0 = new Bundle();
        if(v == 0) {
            bundle0.putInt("argOrderBy", 0);
        }
        else if(v == 1) {
            bundle0.putInt("argOrderBy", 1);
        }
        else {
            bundle0.putInt("argOrderBy", 0);
        }
        melonTvLikedFragment0.setArguments(bundle0);
        return melonTvLikedFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(false);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D04EC, viewGroup0, false);  // layout:melontv_like
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MelOn eventLogin$MelOn0) {
        if(eventLogin$MelOn0.isLogin.booleanValue()) {
            MelonTvLikedAdapter melonTvLikedFragment$MelonTvLikedAdapter0 = (MelonTvLikedAdapter)this.mAdapter;
            e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
            e0.d = -1;
            e0.e = -1;
            e0.g = -1;
            e0.i = -1;
            e0.k = -1;
            e0.l = -1;
            e0.b = true;
            melonTvLikedFragment$MelonTvLikedAdapter0.setEmptyViewInfo(e0);
            this.startFetch("melontv liked log-in");
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(!this.isLoginUser()) {
            this.setEmptyView();
            return false;
        }
        if(this.mCurrentSort == 0) {
            RequestBuilder.newInstance(new MelonTvLikedProgramReq(this.getContext())).tag("MelonTvLikedFragment").listener(new Listener() {
                public void onResponse(MelonTvLikedProgramRes melonTvLikedProgramRes0) {
                    if(!MelonTvLikedFragment.this.prepareFetchComplete(melonTvLikedProgramRes0)) {
                        if(MelonTvLikedFragment.this.mAdapter != null && MelonTvLikedFragment.this.isFragmentValid()) {
                            MelonTvLikedFragment.this.setEmptyView();
                        }
                        return;
                    }
                    if(MelonTvLikedFragment.this.isFragmentValid() && melonTvLikedProgramRes0.isSuccessful()) {
                        ((MelonTvLikedAdapter)MelonTvLikedFragment.this.mAdapter).setProgramListRes(melonTvLikedProgramRes0.response);
                    }
                    MelonTvLikedFragment.this.performFetchComplete(i0, melonTvLikedProgramRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MelonTvLikedProgramRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        ParamInfo melonTvLikedVideoReq$ParamInfo0 = new ParamInfo();
        melonTvLikedVideoReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        melonTvLikedVideoReq$ParamInfo0.pageSize = 20;
        RequestBuilder.newInstance(new MelonTvLikedVideoReq(this.getContext(), melonTvLikedVideoReq$ParamInfo0)).tag("MelonTvLikedFragment").listener(new Listener() {
            public void onResponse(MelonTvLikedVideoRes melonTvLikedVideoRes0) {
                if(!MelonTvLikedFragment.this.prepareFetchComplete(melonTvLikedVideoRes0)) {
                    if(MelonTvLikedFragment.this.mAdapter != null && MelonTvLikedFragment.this.isFragmentValid()) {
                        MelonTvLikedFragment.this.setEmptyView();
                    }
                    return;
                }
                if(MelonTvLikedFragment.this.isFragmentValid() && melonTvLikedVideoRes0.isSuccessful()) {
                    ((MelonTvLikedAdapter)MelonTvLikedFragment.this.mAdapter).setVideoListRes(melonTvLikedVideoRes0.response);
                }
                MelonTvLikedFragment.this.performFetchComplete(i0, melonTvLikedVideoRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MelonTvLikedVideoRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mCurrentSort = bundle0.getInt(MelonTvLikedFragment.ARG_ORDER_BY);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putInt(MelonTvLikedFragment.ARG_ORDER_BY, this.mCurrentSort);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.setEmptyView();
    }

    private void setEmptyView() {
        MelonTvLikedAdapter melonTvLikedFragment$MelonTvLikedAdapter0 = (MelonTvLikedAdapter)this.mAdapter;
        melonTvLikedFragment$MelonTvLikedAdapter0.clear();
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        if(!this.isLoginUser()) {
            e0.f = "로그인 후 좋아요 목록을\n확인할 수 있습니다.";
            e0.j = "로그인";
            e0.m = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.openLoginView(f.f);
                }
            };
            melonTvLikedFragment$MelonTvLikedAdapter0.setEmptyViewInfo(e0);
            return;
        }
        melonTvLikedFragment$MelonTvLikedAdapter0.setEmptyViewInfo(e.o);
        e0.f = "마음에 드는 영상만 모아서 보고 싶다면?";
        e0.h = "영상/프로그램의 \"좋아요\" 버튼을 누르면\n이페이지에서 모아볼 수 있어요";
        melonTvLikedFragment$MelonTvLikedAdapter0.setEmptyViewInfo(e0);
    }
}

