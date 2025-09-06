package com.iloen.melon.fragments.artistchannel;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailTabPagerBaseFragment;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.DeleteNowPlayingReq.ParamInfo;
import com.iloen.melon.net.v4x.request.DeleteNowPlayingReq;
import com.iloen.melon.net.v4x.request.InformNowPlayingReq;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.InformNowPlayingRes.RESPONSE;
import com.iloen.melon.net.v4x.response.InformNowPlayingRes;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList.Fields;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableNowplaying;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class NowPlayingDetailTabFragment extends DetailTabPagerBaseFragment implements OnUpdateCmtListCount {
    private static final String ARG_CHANNEL_SEQ = "argChannelSeq";
    private static final String ARG_NOW_PLAY_SEQ = "argNowPlaySeq";
    public static final String TAG = "NowPlayingDetailTabFragment";
    private ImageView mAlbumImage;
    private int mAlbumImageWidth;
    private View mArtistContainer;
    private int mArtistImageWidth;
    private TextView mArtistName;
    private ImageView mArtistThumbnail;
    private int mBottomHeaderHeight;
    private View mBtnDelete;
    private View mBtnLike;
    private View mBtnModify;
    private View mBtnPlay;
    private View mBtnReview;
    private View mBtnShare;
    private int mChannelSeq;
    private MelonImageView mCoverImage;
    private TextView mCreateArtistName;
    private TextView mIntroText;
    private TextView mLikeCount;
    private ImageView mLikeIcon;
    private RelationList mLikeInfo;
    private int mLikeOffTextColor;
    private int mLikeOnTextColor;
    private TextView mLyricView1;
    private TextView mLyricView2;
    private String mNowPlaySeq;
    private RESPONSE mResponse;
    private TextView mReviewCount;
    private TextView mSongName;
    private int mTopHeaderHeight;

    public NowPlayingDetailTabFragment() {
        this.mBottomHeaderHeight = -2;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public View createBottomHeaderView(LayoutInflater layoutInflater0) {
        View view0 = layoutInflater0.inflate(0x7F0D0584, null, false);  // layout:nowplaying_description
        View view1 = view0.findViewById(0x7F0A00B3);  // id:artist_container
        this.mArtistContainer = view1;
        ViewUtils.setOnClickListener(view1, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(NowPlayingDetailTabFragment.this.mResponse == null) {
                    return;
                }
                NowPlayingDetailTabFragment.this.showArtistInfoPage(NowPlayingDetailTabFragment.this.mResponse.artistId);
            }
        });
        this.mArtistThumbnail = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        ViewUtils.setDefaultImage(((ImageView)view0.findViewById(0x7F0A069C)), this.mArtistImageWidth, true);  // id:iv_thumb_circle_default
        this.mCreateArtistName = (TextView)view0.findViewById(0x7F0A03B0);  // id:description_artist_name
        View view2 = view0.findViewById(0x7F0A0179);  // id:btn_modify
        this.mBtnModify = view2;
        ViewUtils.setOnClickListener(view2, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Navigator.openNowPlayingEdit(NowPlayingDetailTabFragment.this.mNowPlaySeq);
            }
        });
        View view3 = view0.findViewById(0x7F0A0157);  // id:btn_delete
        this.mBtnDelete = view3;
        ViewUtils.setOnClickListener(view3, (/* 缺少LAMBDA参数 */) -> {
            b.v(NowPlayingDetailTabFragment.this.getChildFragmentManager(), NowPlayingDetailTabFragment.this.getString(0x7F1300D0), NowPlayingDetailTabFragment.this.getString(0x7F1301DA), false, null, null, new a(NowPlayingDetailTabFragment.this, 5), null);  // string:alert_dlg_title_info "안내"

            class com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.11 implements ErrorListener {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    Log.d("NowPlayingDetailTabFragment", "showDeletePopup() >> " + volleyError0.toString());
                }
            }


            class com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.12 implements Listener {
                public void onResponse(HttpResponse httpResponse0) {
                    NowPlayingDetailTabFragment.this.showProgress(false);
                    if(NowPlayingDetailTabFragment.this.isFragmentValid() && httpResponse0.isSuccessful()) {
                        NowPlayingDetailTabFragment.this.performBackPress();
                    }
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((HttpResponse)object0));
                }
            }

        });
        this.mIntroText = (TextView)view0.findViewById(0x7F0A058D);  // id:intro_text
        ViewUtils.showWhen(view0.findViewById(0x7F0A0A69), true);  // id:separator
        this.mLikeIcon = (ImageView)view0.findViewById(0x7F0A0767);  // id:like_icon
        this.mLikeCount = (TextView)view0.findViewById(0x7F0A0765);  // id:like_count
        View view4 = view0.findViewById(0x7F0A016F);  // id:btn_like
        this.mBtnLike = view4;
        ViewUtils.setOnClickListener(view4, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                boolean z = NowPlayingDetailTabFragment.this.mLikeInfo == null || NowPlayingDetailTabFragment.this.mLikeInfo.fields == null ? false : ProtocolUtils.parseBoolean(NowPlayingDetailTabFragment.this.mLikeInfo.fields.like);
                String s = NowPlayingDetailTabFragment.this.mResponse.menuId;
                com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.5.1 nowPlayingDetailTabFragment$5$10 = new OnJobFinishListener() {
                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        if(TextUtils.isEmpty(s) && NowPlayingDetailTabFragment.this.isFragmentValid()) {
                            if(NowPlayingDetailTabFragment.this.mLikeInfo != null && NowPlayingDetailTabFragment.this.mLikeInfo.fields != null) {
                                NowPlayingDetailTabFragment.this.mLikeInfo.fields.like = z ? "Y" : "N";
                                NowPlayingDetailTabFragment.this.updateLikeInfo();
                            }
                            if(NowPlayingDetailTabFragment.this.mResponse != null) {
                                NowPlayingDetailTabFragment.this.mResponse.likeCnt = String.valueOf(v);
                                String s1 = StringUtils.getCountString(NowPlayingDetailTabFragment.this.mResponse.likeCnt, 0x270F);
                                NowPlayingDetailTabFragment.this.mLikeCount.setText(s1);
                                com.iloen.melon.responsecache.a.c(NowPlayingDetailTabFragment.this.getContext(), NowPlayingDetailTabFragment.this.getCacheKey(), true);
                            }
                        }
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                    }
                };
                NowPlayingDetailTabFragment.this.updateLike(NowPlayingDetailTabFragment.this.mNowPlaySeq, "N10029", !z, s, nowPlayingDetailTabFragment$5$10);
            }
        });
        this.mReviewCount = (TextView)view0.findViewById(0x7F0A09F2);  // id:review_count
        View view5 = view0.findViewById(0x7F0A01A3);  // id:btn_review
        this.mBtnReview = view5;
        ViewUtils.setOnClickListener(view5, (/* 缺少LAMBDA参数 */) -> {
            Param cmtListFragment$Param0 = new Param();
            cmtListFragment$Param0.chnlSeq = NowPlayingDetailTabFragment.this.mChannelSeq;
            cmtListFragment$Param0.contsRefValue = NowPlayingDetailTabFragment.this.mNowPlaySeq;
            cmtListFragment$Param0.showTitle = true;
            Navigator.openComments(cmtListFragment$Param0);
        });
        View view6 = view0.findViewById(0x7F0A01B7);  // id:btn_share
        this.mBtnShare = view6;
        ViewUtils.setOnClickListener(view6, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Sharable sharable0 = NowPlayingDetailTabFragment.this.getSNSSharable();
                if(sharable0 != null) {
                    NowPlayingDetailTabFragment.this.showSNSListPopup(view0, sharable0);
                }
            }
        });
        return view0;

        class com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.4 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                NowPlayingDetailTabFragment.this.showDeletePopup();
            }
        }


        class com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.6 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                NowPlayingDetailTabFragment.this.openComments();
            }
        }

    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public View createImageHeaderView(LayoutInflater layoutInflater0) {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public View createTopHeaderView(LayoutInflater layoutInflater0) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0588, null, false);  // layout:nowplaying_header
        this.mCoverImage = (MelonImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        this.mBtnPlay = view0.findViewById(0x7F0A0182);  // id:btn_play
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        ViewUtils.setDefaultImage(imageView0, -1);
        imageView0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06013E));  // color:gray000s
        this.mSongName = (TextView)view0.findViewById(0x7F0A0AAF);  // id:song_name
        this.mArtistName = (TextView)view0.findViewById(0x7F0A00B8);  // id:artist_name
        ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0085);  // id:album_image
        this.mAlbumImage = imageView1;
        ViewUtils.setOnClickListener(imageView1, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(NowPlayingDetailTabFragment.this.mResponse != null) {
                    NowPlayingDetailTabFragment.this.playSong(NowPlayingDetailTabFragment.this.mResponse.songId, NowPlayingDetailTabFragment.this.mResponse.menuId);
                }
            }
        });
        this.mLyricView1 = (TextView)view0.findViewById(0x7F0A07B8);  // id:lyric1
        this.mLyricView2 = (TextView)view0.findViewById(0x7F0A07B9);  // id:lyric2
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public boolean disableSwipeable() {
        return true;
    }

    private RESPONSE fetchData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.w("NowPlayingDetailTabFragment", "Invalid cursor");
            return null;
        }
        InformNowPlayingRes informNowPlayingRes0 = (InformNowPlayingRes)com.iloen.melon.responsecache.a.d(cursor0, InformNowPlayingRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(informNowPlayingRes0 == null) {
            LogU.w("NowPlayingDetailTabFragment", "Failed to extract contents");
            return null;
        }
        return informNowPlayingRes0.response;
    }

    private void fetchLike() {
        if(!this.isLoginUser()) {
            return;
        }
        Params userActionsReq$Params0 = new Params();
        userActionsReq$Params0.fields = "like";
        userActionsReq$Params0.contsTypeCode = "N10029";
        userActionsReq$Params0.contsId = this.mNowPlaySeq;
        RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag("NowPlayingDetailTabFragment").listener(new Listener() {
            public void onResponse(UserActionsRes userActionsRes0) {
                if(NowPlayingDetailTabFragment.this.isFragmentValid() && userActionsRes0.isSuccessful()) {
                    Response userActionsRes$Response0 = userActionsRes0.response;
                    if(userActionsRes$Response0 != null) {
                        ArrayList arrayList0 = userActionsRes$Response0.relationList;
                        if(arrayList0 != null && arrayList0.size() > 0) {
                            RelationList userActionsRes$Response$RelationList0 = (RelationList)arrayList0.get(0);
                            NowPlayingDetailTabFragment.l0(NowPlayingDetailTabFragment.this, userActionsRes$Response$RelationList0);
                            NowPlayingDetailTabFragment.q0(NowPlayingDetailTabFragment.this);
                        }
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((UserActionsRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                NowPlayingDetailTabFragment.this.showProgress(false);
            }
        }).request();
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public float getAlphaValue(float f) {
        return Math.max(1.0f - Math.max(f - 0.3f, 0.0f) * 5.0f, 0.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getBottomHeaderHeight() {
        return this.mBottomHeaderHeight;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.Q0.buildUpon().appendQueryParameter("nowPlayingSeq", this.mNowPlaySeq).build().toString();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public Sharable getSNSSharable() {
        RESPONSE informNowPlayingRes$RESPONSE0 = this.mResponse;
        if(informNowPlayingRes$RESPONSE0 != null) {
            String s = informNowPlayingRes$RESPONSE0.nowPlaySeq;
            String s1 = informNowPlayingRes$RESPONSE0.introCont;
            String s2 = informNowPlayingRes$RESPONSE0.albumImg;
            Sharable sharable0 = new SharableNowplaying();  // 初始化器: Ljava/lang/Object;-><init>()V
            sharable0.a = s;
            sharable0.b = s1;
            sharable0.d = s2;
            sharable0.e = s2;
            return sharable0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTabHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTopHeaderHeight() {
        if(this.mTopHeaderHeight == 0) {
            this.mTopHeaderHeight = ScreenUtils.dipToPixel(this.getContext(), 360.0f);
        }
        return this.mTopHeaderHeight;
    }

    public static void l0(NowPlayingDetailTabFragment nowPlayingDetailTabFragment0, RelationList userActionsRes$Response$RelationList0) {
        nowPlayingDetailTabFragment0.mLikeInfo = userActionsRes$Response$RelationList0;
    }

    private H lambda$showDeletePopup$1() {
        ParamInfo deleteNowPlayingReq$ParamInfo0 = new ParamInfo();
        deleteNowPlayingReq$ParamInfo0.memberKey = u.v(((e0)o.a()).j());
        deleteNowPlayingReq$ParamInfo0.artistId = "";
        deleteNowPlayingReq$ParamInfo0.nowPlaySeq = this.mNowPlaySeq;
        this.showProgress(true);
        RequestBuilder.newInstance(new DeleteNowPlayingReq(this.getContext(), deleteNowPlayingReq$ParamInfo0)).tag("NowPlayingDetailTabFragment").listener(new com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.12(this)).errorListener(new com.iloen.melon.fragments.artistchannel.NowPlayingDetailTabFragment.11(this)).request();
        return null;
    }

    private void lambda$updateHeaderView$0() {
        this.mBottomHeaderHeight = this.mBottomContainer.getMeasuredHeight();
        this.updateParallaxHeaderHeight();
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public MelonBaseFragment makeTabFragment(TabInfo tabInfo0, int v) {
        return NowPlayingDetailFragment.newInstance(this.mNowPlaySeq, this.mChannelSeq);
    }

    public ArrayList makeTabInfo() [...] // Inlined contents

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public List makeTabInfo() {
        return null;
    }

    public static NowPlayingDetailTabFragment newInstance(String s) {
        NowPlayingDetailTabFragment nowPlayingDetailTabFragment0 = new NowPlayingDetailTabFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argNowPlaySeq", s);
        nowPlayingDetailTabFragment0.setArguments(bundle0);
        return nowPlayingDetailTabFragment0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mAlbumImageWidth = ScreenUtils.dipToPixel(this.getContext(), 189.0f);
        this.mArtistImageWidth = ScreenUtils.dipToPixel(this.getContext(), 50.0f);
        this.mLikeOnTextColor = ColorUtils.getColor(this.getContext(), 0x7F06017C);  // color:green500s_support_high_contrast
        this.mLikeOffTextColor = ColorUtils.getColor(this.getContext(), 0x7F060160);  // color:gray600s_support_high_contrast
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Context context0 = this.getContext();
        if(!com.iloen.melon.responsecache.a.e(300000L, this.getCacheKey(), context0)) {
            this.mResponse = this.fetchData();
            this.fetchLike();
            this.updateTabInfoList();
            this.updateHeaderView();
            return false;
        }
        RequestBuilder.newInstance(new InformNowPlayingReq(this.getContext(), this.mNowPlaySeq)).tag("NowPlayingDetailTabFragment").listener(new Listener() {
            public void onResponse(InformNowPlayingRes informNowPlayingRes0) {
                if(!NowPlayingDetailTabFragment.this.prepareFetchComplete(informNowPlayingRes0, true)) {
                    return;
                }
                com.iloen.melon.responsecache.a.a(NowPlayingDetailTabFragment.this.getContext(), informNowPlayingRes0, NowPlayingDetailTabFragment.this.getCacheKey());
                NowPlayingDetailTabFragment.this.mResponse = informNowPlayingRes0.response;
                NowPlayingDetailTabFragment.this.fetchLike();
                NowPlayingDetailTabFragment.this.updateHeaderView();
                NowPlayingDetailTabFragment.this.updateTabInfoList();
                NowPlayingDetailTabFragment.this.performFetchCompleteOnlyViews();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InformNowPlayingRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        super.onRestoreInstanceState(bundle0);
        this.mNowPlaySeq = bundle0.getString("argNowPlaySeq");
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argNowPlaySeq", this.mNowPlaySeq);
        }
    }

    @Override  // com.iloen.melon.fragments.artistchannel.NowPlayingDetailFragment$OnUpdateCmtListCount
    public void onUpdateCmtListCount(int v) {
        if(!this.isFragmentValid()) {
            return;
        }
        this.mReviewCount.setText(StringUtils.getCountString(v, 0x1869F));
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(0));
        }
        FrameLayout frameLayout0 = this.mTabContainer;
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(8);
        }
    }

    // 检测为 Lambda 实现
    public void openComments() [...]

    // 检测为 Lambda 实现
    private void showDeletePopup() [...]

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateHeaderRatio(float f) {
        super.updateHeaderRatio(f);
        float f1 = this.getAlphaValue(f);
        this.mLyricView1.setAlpha(f1);
        this.mLyricView2.setAlpha(f1);
    }

    private void updateHeaderView() {
        RESPONSE informNowPlayingRes$RESPONSE0 = this.mResponse;
        if(informNowPlayingRes$RESPONSE0 == null) {
            return;
        }
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setTitle(informNowPlayingRes$RESPONSE0.songName);
        }
        Context context0 = this.getContext();
        boolean z = false;
        if(context0 != null) {
            MelonImageView melonImageView0 = this.mCoverImage;
            if(melonImageView0 != null) {
                melonImageView0.setCornerType(0);
                Glide.with(context0).load(informNowPlayingRes$RESPONSE0.albumImgLarge).apply(new RequestOptions().transform(new MelonBlurTransformation(context0))).into(this.mCoverImage);
            }
        }
        this.mArtistName.setText(ProtocolUtils.getArtistNames(informNowPlayingRes$RESPONSE0.artistList));
        if(context0 != null && this.mAlbumImage != null) {
            Glide.with(context0).load(informNowPlayingRes$RESPONSE0.albumImg).apply(RequestOptions.circleCropTransform()).into(this.mAlbumImage);
        }
        this.mLyricView1.setText(informNowPlayingRes$RESPONSE0.selLyricsFirst);
        this.mLyricView2.setText(informNowPlayingRes$RESPONSE0.selLyricsSecond);
        if(!TextUtils.isEmpty(informNowPlayingRes$RESPONSE0.artistId) && informNowPlayingRes$RESPONSE0.artistId.equals("")) {
            z = true;
        }
        ViewUtils.showWhen(this.mBtnModify, z);
        ViewUtils.showWhen(this.mBtnDelete, z);
        if(context0 != null && this.mArtistThumbnail != null) {
            Glide.with(context0).load(informNowPlayingRes$RESPONSE0.artistImg).apply(RequestOptions.circleCropTransform()).into(this.mArtistThumbnail);
        }
        this.mCreateArtistName.setText(informNowPlayingRes$RESPONSE0.artistName);
        this.mIntroText.setText(informNowPlayingRes$RESPONSE0.introCont);
        this.mLikeCount.setText(StringUtils.getCountString(informNowPlayingRes$RESPONSE0.likeCnt, 0x270F));
        this.mReviewCount.setText(StringUtils.getCountString(informNowPlayingRes$RESPONSE0.validCmtCnt, 0x270F));
        ViewUtils.showWhen(this.mBtnPlay, !TextUtils.isEmpty(this.mResponse.songId));
        new Handler(Looper.getMainLooper()).post(new x(this, 1));
    }

    private void updateLikeInfo() {
        RelationList userActionsRes$Response$RelationList0 = this.mLikeInfo;
        if(userActionsRes$Response$RelationList0 != null) {
            Fields userActionsRes$Response$RelationList$Fields0 = userActionsRes$Response$RelationList0.fields;
            if(userActionsRes$Response$RelationList$Fields0 != null) {
                boolean z = ProtocolUtils.parseBoolean(userActionsRes$Response$RelationList$Fields0.like);
                this.mLikeIcon.setImageResource((z ? 0x7F0803FB : 0x7F0803FA));  // drawable:ic_common_like_13_on
                this.mLikeCount.setTextColor((z ? this.mLikeOnTextColor : this.mLikeOffTextColor));
                this.mBtnLike.setBackgroundResource((z ? 0x7F0808EB : 0x7F0808C6));  // drawable:shape_rectangle_green501s_0_5dp_stroke_round100
            }
        }
    }

    private void updateTabInfoList() {
        RESPONSE informNowPlayingRes$RESPONSE0 = this.mResponse;
        if(informNowPlayingRes$RESPONSE0 != null && !TextUtils.isEmpty(informNowPlayingRes$RESPONSE0.bbsChannelSeq)) {
            try {
                this.mChannelSeq = (int)Integer.valueOf(informNowPlayingRes$RESPONSE0.bbsChannelSeq);
                ArrayList arrayList0 = new ArrayList();
                TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                tabInfo0.a = 0;
                tabInfo0.b = null;
                tabInfo0.c = 0;
                tabInfo0.d = null;
                tabInfo0.e = 0;
                tabInfo0.f = 0;
                tabInfo0.g = 0;
                tabInfo0.h = 0;
                tabInfo0.i = 0x7F080820;  // drawable:selector_dot
                tabInfo0.j = -1.0f;
                tabInfo0.k = -1.0f;
                tabInfo0.l = -1.0f;
                tabInfo0.m = -1.0f;
                tabInfo0.n = 1.0f;
                tabInfo0.o = -1;
                arrayList0.add(tabInfo0);
                this.updateTabInfoList(arrayList0);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateTitleBarRatio(float f) {
        super.updateTitleBarRatio(1.0f);
    }
}

