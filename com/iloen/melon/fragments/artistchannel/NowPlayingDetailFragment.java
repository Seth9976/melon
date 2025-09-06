package com.iloen.melon.fragments.artistchannel;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.comments.CmtBaseFragment.Param;
import com.iloen.melon.fragments.comments.CmtBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.MEMBERINFO;
import com.iloen.melon.net.v3x.comments.ListCmtReq.Params;
import com.iloen.melon.net.v3x.comments.ListCmtReq;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;

public class NowPlayingDetailFragment extends CmtBaseFragment {
    public static class FooterViewHolder extends O0 {
        private View mBtnViewAll;
        private TextView mCountText;

        public FooterViewHolder(View view0) {
            super(view0);
            this.mBtnViewAll = view0.findViewById(0x7F0A01C4);  // id:btn_view_all
            this.mCountText = (TextView)view0.findViewById(0x7F0A0BD9);  // id:total_count
        }
    }

    public class NowPlayingAdapter extends p {
        public class Footer {
        }

        private static final int MAX_LIST_COUNT = 3;
        private static final int VIEW_TYPE_FOOTER = 1;
        private static final int VIEW_TYPE_ITEM = 2;
        private int mCmtCount;
        private int mUserImageWidth;

        public NowPlayingAdapter(Context context0, List list0) {
            super(context0, list0);
            this.mUserImageWidth = ScreenUtils.dipToPixel(context0, 40.0f);
        }

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getItem(v1) instanceof Footer ? 1 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(!(httpResponse0 instanceof ListCmtRes)) {
                return false;
            }
            if(((ListCmtRes)httpResponse0).result == null) {
                return false;
            }
            this.clear();
            CmtResViewModel cmtResViewModel0 = new CmtResViewModel();
            cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.toplist, NowPlayingDetailFragment.this.mParam.chnlSeq, NowPlayingDetailFragment.this.mParam.contsRefValue, NowPlayingDetailFragment.this.mParam.isReadOnly, NowPlayingDetailFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
            cmtResViewModel0.databindCmtListBase(((ListCmtRes)httpResponse0).result.cmtlist, NowPlayingDetailFragment.this.mParam.chnlSeq, NowPlayingDetailFragment.this.mParam.contsRefValue, NowPlayingDetailFragment.this.mParam.isReadOnly, NowPlayingDetailFragment.this.mLoadPgnRes.result.chnlinfo.reprtuseflag);
            this.addAll(cmtResViewModel0.result.cmtlist);
            this.setHasMore(((ListCmtRes)httpResponse0).result.pageinfo.pageno < ((ListCmtRes)httpResponse0).result.paginginfo.nextpageno);
            this.setMenuId(((ListCmtRes)httpResponse0).getMenuId());
            this.updateModifiedTime(s);
            int v = ((ListCmtRes)httpResponse0).result.pageinfo.validcnt;
            this.mCmtCount = v;
            if(v > 3) {
                this.add(new Footer(this));
            }
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean hasMore() {
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00 instanceof FooterViewHolder) {
                this.updateFooterView(((FooterViewHolder)o00));
                return;
            }
            if(o00 instanceof ReviewItemViewHolder) {
                Object object0 = this.getItem(v1);
                if(object0 instanceof cmtList) {
                    if(((cmtList)object0) == null) {
                        LogU.e("NowPlayingDetailFragment", "Invalid protocol response");
                        return;
                    }
                    boolean z = true;
                    ViewUtils.setDefaultImage(((ReviewItemViewHolder)o00).defaultThumbnail, this.mUserImageWidth, true);
                    MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO0 = ((cmtList)object0).memberinfo;
                    if(cmtSharedTypeRes$CmtListBase$MEMBERINFO0 != null) {
                        boolean z1 = cmtSharedTypeRes$CmtListBase$MEMBERINFO0.artistflag;
                        ImageView imageView0 = ReviewItemViewHolder.e(((ReviewItemViewHolder)o00));
                        MEMBERINFO cmtSharedTypeRes$CmtListBase$MEMBERINFO1 = ((cmtList)object0).memberinfo;
                        imageView0.setContentDescription(String.format("%s 회원 이미지", (z1 ? cmtSharedTypeRes$CmtListBase$MEMBERINFO1.artistname : cmtSharedTypeRes$CmtListBase$MEMBERINFO1.membernickname)));
                        Context context0 = this.getContext();
                        if(z1) {
                            Glide.with(context0).load(((cmtList)object0).memberinfo.artistimage).apply(RequestOptions.circleCropTransform()).into(ReviewItemViewHolder.e(((ReviewItemViewHolder)o00)));
                        }
                        else {
                            Glide.with(context0).load(((cmtList)object0).memberinfo.mypageimg).apply(RequestOptions.circleCropTransform()).into(ReviewItemViewHolder.e(((ReviewItemViewHolder)o00)));
                            String s = String.format("%s 회원 이미지", ((cmtList)object0).memberinfo.membernickname);
                            if(!TextUtils.isEmpty(s)) {
                                ReviewItemViewHolder.e(((ReviewItemViewHolder)o00)).setContentDescription(s);
                            }
                        }
                        if(ReviewItemViewHolder.f(((ReviewItemViewHolder)o00)) != null) {
                            int v2 = ResourceUtils.getDjIconResId(((cmtList)object0).memberinfo.memberDjType);
                            if(v2 > 0) {
                                ReviewItemViewHolder.f(((ReviewItemViewHolder)o00)).setImageResource(v2);
                                ViewUtils.showWhen(ReviewItemViewHolder.f(((ReviewItemViewHolder)o00)), true);
                            }
                            else {
                                ViewUtils.showWhen(ReviewItemViewHolder.f(((ReviewItemViewHolder)o00)), false);
                            }
                        }
                        ReviewItemViewHolder.g(((ReviewItemViewHolder)o00)).setText((z1 ? ((cmtList)object0).memberinfo.artistname : ((cmtList)object0).memberinfo.membernickname));
                    }
                    if(((cmtList)object0).cmtinfo != null) {
                        ((ReviewItemViewHolder)o00).date.setText(((cmtList)object0).cmtinfo.dsplydate);
                        String s1 = ((cmtList)object0).cmtinfo.cmtcont;
                        if(!TextUtils.isEmpty(s1)) {
                            s1 = s1.replaceAll("\n", "<br>");
                        }
                        ((ReviewItemViewHolder)o00).reviewText.setText(Html.fromHtml(s1, 0));
                    }
                    View view0 = ((ReviewItemViewHolder)o00).underLine;
                    if(v1 == 2) {
                        z = false;
                    }
                    ViewUtils.showWhen(view0, z);
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 1 ? new FooterViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0587, viewGroup0, false)) : new ReviewItemViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0585, viewGroup0, false));  // layout:nowplaying_footer
        }

        private void updateFooterView(FooterViewHolder nowPlayingDetailFragment$FooterViewHolder0) {
            try {
                nowPlayingDetailFragment$FooterViewHolder0.mCountText.setText(String.valueOf(this.mCmtCount));
            }
            catch(NumberFormatException unused_ex) {
            }
            ViewUtils.setOnClickListener(nowPlayingDetailFragment$FooterViewHolder0.mBtnViewAll, new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    I i0 = NowPlayingDetailFragment.this.getParentFragment();
                    if(i0 instanceof NowPlayingDetailTabFragment) {
                        ((NowPlayingDetailTabFragment)i0).openComments();
                    }
                }
            });
        }
    }

    public interface OnUpdateCmtListCount {
        void onUpdateCmtListCount(int arg1);
    }

    public static class ReviewItemViewHolder extends O0 {
        private TextView date;
        private ImageView defaultThumbnail;
        private TextView reviewText;
        private View underLine;
        private ImageView userImage;
        private ImageView userImageBadge;
        private TextView userName;

        public ReviewItemViewHolder(View view0) {
            super(view0);
            this.defaultThumbnail = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            this.userImage = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            this.userImageBadge = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
            this.userName = (TextView)view0.findViewById(0x7F0A0C40);  // id:tv_cmt_nickname
            this.date = (TextView)view0.findViewById(0x7F0A0C3E);  // id:tv_cmt_date
            this.reviewText = (TextView)view0.findViewById(0x7F0A0C3F);  // id:tv_cmt_detail
            this.underLine = view0.findViewById(0x7F0A0D6B);  // id:underline
        }

        public static ImageView e(ReviewItemViewHolder nowPlayingDetailFragment$ReviewItemViewHolder0) {
            return nowPlayingDetailFragment$ReviewItemViewHolder0.userImage;
        }

        public static ImageView f(ReviewItemViewHolder nowPlayingDetailFragment$ReviewItemViewHolder0) {
            return nowPlayingDetailFragment$ReviewItemViewHolder0.userImageBadge;
        }

        public static TextView g(ReviewItemViewHolder nowPlayingDetailFragment$ReviewItemViewHolder0) {
            return nowPlayingDetailFragment$ReviewItemViewHolder0.userName;
        }
    }

    private static final String ARG_CHANNEL_SEQ = "argChannelSeq";
    private static final String ARG_NOW_PLAY_SEQ = "argNowPlaySeq";
    protected static final int PAGE_MAX = 3;
    private static final String TAG = "NowPlayingDetailFragment";
    private int mChannelSeq;
    private String mNowPlaySeq;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new NowPlayingAdapter(this, context0, null);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F1307AD);  // string:nowplaying_empty_msg "아티스트 #NOWPLAYING의\n감상평을 남겨주세요."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private void executeListCmtReq(i i0) {
        Params listCmtReq$Params0 = new Params();
        listCmtReq$Params0.chnlSeq = this.mParam.chnlSeq;
        listCmtReq$Params0.contsRefValue = this.mParam.contsRefValue;
        listCmtReq$Params0.pageNo = 1;
        listCmtReq$Params0.pageSize = 3;
        listCmtReq$Params0.sortType = 0;
        listCmtReq$Params0.srchType = -1;
        result loadPgnRes$result0 = this.mLoadPgnRes.result;
        if(loadPgnRes$result0 != null && loadPgnRes$result0.paginginfo != null) {
            listCmtReq$Params0.startSeq = loadPgnRes$result0.pageinfo.startseq;
        }
        RequestBuilder.newInstance(new ListCmtReq(this.getContext(), listCmtReq$Params0)).tag("NowPlayingDetailFragment").listener(new Listener() {
            public void onResponse(ListCmtRes listCmtRes0) {
                if(!NowPlayingDetailFragment.this.prepareFetchComplete(listCmtRes0)) {
                    return;
                }
                if(!NowPlayingDetailFragment.this.isLoadPgnResValid("executeListCmtReq")) {
                    NowPlayingDetailFragment.this.performCmtFetchErrorToast(listCmtRes0.errormessage);
                    return;
                }
                NowPlayingDetailFragment.y0(NowPlayingDetailFragment.this, listCmtRes0);
                NowPlayingDetailFragment.this.resetScrollPosition();
                NowPlayingDetailFragment.this.performFetchComplete(i0, listCmtRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ListCmtRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.R0.buildUpon().appendQueryParameter("nowPlayingSeq", this.mNowPlaySeq).build().toString();
    }

    public static NowPlayingDetailFragment newInstance(String s, int v) {
        NowPlayingDetailFragment nowPlayingDetailFragment0 = new NowPlayingDetailFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argNowPlaySeq", s);
        bundle0.putInt("argChannelSeq", v);
        Param cmtBaseFragment$Param0 = new Param();
        cmtBaseFragment$Param0.chnlSeq = v;
        cmtBaseFragment$Param0.contsRefValue = s;
        bundle0.putSerializable("argCmtParam", cmtBaseFragment$Param0);
        nowPlayingDetailFragment0.setArguments(bundle0);
        return nowPlayingDetailFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(i.b.equals(i0)) {
            com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0 = new com.iloen.melon.net.v3x.comments.LoadPgnReq.Params();
            loadPgnReq$Params0.chnlSeq = this.mParam.chnlSeq;
            loadPgnReq$Params0.contsRefValue = this.mParam.contsRefValue;
            RequestBuilder.newInstance(new LoadPgnReq(this.getContext(), loadPgnReq$Params0)).tag("NowPlayingDetailFragment").listener(new Listener() {
                public void onResponse(LoadPgnRes loadPgnRes0) {
                    if(!NowPlayingDetailFragment.this.prepareFetchComplete(loadPgnRes0, true)) {
                        NowPlayingDetailFragment.this.performCmtFetchErrorToast(loadPgnRes0.errormessage);
                        return;
                    }
                    NowPlayingDetailFragment.this.mLoadPgnRes = loadPgnRes0;
                    if(NowPlayingDetailFragment.this.mLoadPgnRes.result != null && NowPlayingDetailFragment.this.mLoadPgnRes.result.chnlinfo != null && NowPlayingDetailFragment.this.mLoadPgnRes.result.chnlinfo.blindContsCmtListFlag) {
                        String s = NowPlayingDetailFragment.this.mLoadPgnRes.result.chnlinfo.blindContsDsplyText;
                        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        e0.d = -1;
                        e0.e = -1;
                        e0.g = -1;
                        e0.i = -1;
                        e0.k = -1;
                        e0.l = -1;
                        e0.f = s;
                        ((NowPlayingAdapter)NowPlayingDetailFragment.this.mAdapter).setEmptyViewInfo(e0);
                        NowPlayingDetailFragment.this.performFetchCompleteOnlyViews();
                        return;
                    }
                    NowPlayingDetailFragment.this.executeListCmtReq(i0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((LoadPgnRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.executeListCmtReq(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        super.onRestoreInstanceState(bundle0);
        this.mNowPlaySeq = bundle0.getString("argNowPlaySeq");
        this.mChannelSeq = bundle0.getInt("argChannelSeq");
        Param cmtBaseFragment$Param0 = (Param)CompatUtils.getSerializable(bundle0, "argCmtParam", Param.class);
        this.mParam = cmtBaseFragment$Param0;
        if(cmtBaseFragment$Param0 != null) {
            cmtBaseFragment$Param0.cacheKeyOfCmtList = this.getCacheKey();
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argNowPlaySeq", this.mNowPlaySeq);
            bundle0.putInt("argChannelSeq", this.mChannelSeq);
            bundle0.putSerializable("argCmtParam", this.mParam);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }

    private void updateCmtListCount(ListCmtRes listCmtRes0) {
        if(listCmtRes0 != null) {
            com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result0 = listCmtRes0.result;
            if(listCmtRes$result0 != null) {
                PAGEINFO listCmtRes$result$PAGEINFO0 = listCmtRes$result0.pageinfo;
                if(listCmtRes$result$PAGEINFO0 != null) {
                    int v = listCmtRes$result$PAGEINFO0.validcnt;
                    I i0 = this.getParentFragment();
                    if(i0 instanceof OnUpdateCmtListCount) {
                        ((OnUpdateCmtListCount)i0).onUpdateCmtListCount(v);
                    }
                }
            }
        }
    }

    public static void y0(NowPlayingDetailFragment nowPlayingDetailFragment0, ListCmtRes listCmtRes0) {
        nowPlayingDetailFragment0.updateCmtListCount(listCmtRes0);
    }
}

