package com.iloen.melon.fragments.melontv;

import U4.x;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import b3.Z;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MelonTvLiveListReq;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes.RESPONSE.LIVELIST;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes.RESPONSE.PASTLIVELIST.LINK;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes.RESPONSE.PASTLIVELIST;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.h;
import v9.i;

public class MelonTvLiveFragment extends MelonTvBaseFragment {
    static class LiveAdapter extends p {
        static class LiveViewHolder extends O0 {
            private TextView description;
            private TextView issueDate;
            private TextView onAirText;
            private View separator;
            private View thumbGradient;
            private ImageView thumbnail;
            private TextView title;
            private TextView viewCount;

            public LiveViewHolder(Context context0, View view0) {
                super(view0);
                this.separator = view0.findViewById(0x7F0A0A69);  // id:separator
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                TextView textView0 = (TextView)view0.findViewById(0x7F0A0CD4);  // id:tv_onair
                this.onAirText = textView0;
                ViewUtils.showWhen(textView0, true);
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0147), true);  // id:btn_center
                TextView textView1 = (TextView)view0.findViewById(0x7F0A0D2C);  // id:tv_thumb_count
                this.viewCount = textView1;
                ViewUtils.hideWhen(textView1, true);
                this.title = (TextView)view0.findViewById(0x7F0A0790);  // id:live_title
                this.issueDate = (TextView)view0.findViewById(0x7F0A078E);  // id:live_time
                this.description = (TextView)view0.findViewById(0x7F0A0786);  // id:live_description
                View view1 = view0.findViewById(0x7F0A0B77);  // id:thumb_gradient
                this.thumbGradient = view1;
                ViewUtils.showWhen(view1, true);
            }

            public static TextView a(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.description;
            }

            public static TextView b(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.issueDate;
            }

            public static TextView c(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.onAirText;
            }

            public static View d(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.separator;
            }

            public static ImageView e(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.thumbnail;
            }

            public static TextView f(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.title;
            }

            public static TextView g(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$LiveViewHolder0.viewCount;
            }
        }

        static class PastLiveViewHolder extends O0 {
            private View bottomSeparator;
            private TextView date;
            private ImageView gradeIcon;
            private ImageView ivThumbDefault;
            private ImageView moreBtn;
            private View mvItem;
            private ImageView thumbnail;
            private TextView tvTitle;
            private View underline;
            private TextView viewCount;

            public PastLiveViewHolder(View view0) {
                super(view0);
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0182), true);  // id:btn_play
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0CE5), true);  // id:tv_playtime
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0633), true);  // id:iv_grade
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0CFF), true);  // id:tv_round
                this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0C12), true);  // id:tv_artist
                this.date = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
                this.viewCount = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
                this.underline = view0.findViewById(0x7F0A0D6B);  // id:underline
                this.bottomSeparator = view0.findViewById(0x7F0A0974);  // id:program_item_bottom_separator
                this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                View view1 = view0.findViewById(0x7F0A088E);  // id:mv_item
                this.mvItem = view1;
                this.moreBtn = (ImageView)view1.findViewById(0x7F0A081B);  // id:more_iv
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0D96), true);  // id:v_bottom_gradient
            }

            public static View a(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.bottomSeparator;
            }

            public static TextView b(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.date;
            }

            public static ImageView c(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.ivThumbDefault;
            }

            public static ImageView d(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.moreBtn;
            }

            public static ImageView e(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.thumbnail;
            }

            public static TextView f(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.tvTitle;
            }

            public static TextView g(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.viewCount;
            }
        }

        public static class Section {
            public boolean isTopLine;
            public String sectionTitle;

            public Section() {
                this.isTopLine = false;
            }
        }

        class SectionViewHolder extends O0 {
            private TextView sectionTitle;
            private View topLine;

            public SectionViewHolder(View view0) {
                super(view0);
                this.sectionTitle = (TextView)view0.findViewById(0x7F0A0A50);  // id:section_title
                this.topLine = view0.findViewById(0x7F0A0BD0);  // id:top_line
            }

            public static TextView a(SectionViewHolder melonTvLiveFragment$LiveAdapter$SectionViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$SectionViewHolder0.sectionTitle;
            }

            public static View b(SectionViewHolder melonTvLiveFragment$LiveAdapter$SectionViewHolder0) {
                return melonTvLiveFragment$LiveAdapter$SectionViewHolder0.topLine;
            }
        }

        private static final int VIEW_TYPE_LAST_LIVE = 3;
        private static final int VIEW_TYPE_LIVE = 1;
        private static final int VIEW_TYPE_LIVE_LAND = 2;
        private static final int VIEW_TYPE_SECTION;
        private int mComingSoonTextViewWidth;
        private int mOnAirTextViewWidth;

        public LiveAdapter(Context context0, List list0) {
            super(context0, list0);
            this.mOnAirTextViewWidth = ScreenUtils.dipToPixel(context0, 55.0f);
            this.mComingSoonTextViewWidth = ScreenUtils.dipToPixel(context0, 92.0f);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof Section) {
                return 0;
            }
            if(object0 instanceof LIVELIST) {
                return ScreenUtils.isPortrait(this.getContext()) ? 1 : 2;
            }
            return 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof MelonTvLiveListRes) {
                RESPONSE melonTvLiveListRes$RESPONSE0 = ((MelonTvLiveListRes)httpResponse0).response;
                if(melonTvLiveListRes$RESPONSE0 != null) {
                    boolean z = melonTvLiveListRes$RESPONSE0.liveList != null && melonTvLiveListRes$RESPONSE0.liveList.size() > 0;
                    i i1 = i.c;
                    if(!i1.equals(i0) && z) {
                        Section melonTvLiveFragment$LiveAdapter$Section0 = new Section();
                        melonTvLiveFragment$LiveAdapter$Section0.sectionTitle = "진행중인 생중계";
                        melonTvLiveFragment$LiveAdapter$Section0.isTopLine = false;
                        this.add(melonTvLiveFragment$LiveAdapter$Section0);
                        this.addAll(melonTvLiveListRes$RESPONSE0.liveList);
                    }
                    if(melonTvLiveListRes$RESPONSE0.pastLiveList != null && melonTvLiveListRes$RESPONSE0.pastLiveList.size() > 0) {
                        if(!i1.equals(i0)) {
                            Section melonTvLiveFragment$LiveAdapter$Section1 = new Section();
                            melonTvLiveFragment$LiveAdapter$Section1.sectionTitle = "지난 생중계";
                            melonTvLiveFragment$LiveAdapter$Section1.isTopLine = z;
                            this.add(melonTvLiveFragment$LiveAdapter$Section1);
                        }
                        this.addAll(melonTvLiveListRes$RESPONSE0.pastLiveList);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            switch(o00.getItemViewType()) {
                case 0: {
                    if(object0 instanceof Section) {
                        ViewUtils.showWhen(SectionViewHolder.b(((SectionViewHolder)o00)), ((Section)object0).isTopLine);
                        SectionViewHolder.a(((SectionViewHolder)o00)).setText(((Section)object0).sectionTitle);
                        return;
                    }
                    break;
                }
                case 1: 
                case 2: {
                    if(object0 instanceof LIVELIST) {
                        this.updateLiveItem(((LiveViewHolder)o00), ((LIVELIST)object0), v1);
                        return;
                    }
                    break;
                }
                case 3: {
                    if(object0 instanceof PASTLIVELIST) {
                        this.updateLastLiveItem(((PastLiveViewHolder)o00), ((PASTLIVELIST)object0), v1);
                        return;
                    }
                    break;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 0: {
                    return new SectionViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04F1, viewGroup0, false));  // layout:melontv_live_section_list_item
                }
                case 1: 
                case 2: {
                    return new LiveViewHolder(this.getContext(), LayoutInflater.from(this.getContext()).inflate(0x7F0D04F0, viewGroup0, false));  // layout:melontv_live_list_item
                }
                default: {
                    return new PastLiveViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04F8, viewGroup0, false));  // layout:melontv_program_mv_item
                }
            }
        }

        private void updateLastLiveItem(PastLiveViewHolder melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0, PASTLIVELIST melonTvLiveListRes$RESPONSE$PASTLIVELIST0, int v) {
            if(PastLiveViewHolder.e(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0) != null) {
                Glide.with(PastLiveViewHolder.e(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).getContext()).load(melonTvLiveListRes$RESPONSE$PASTLIVELIST0.liveImg).into(PastLiveViewHolder.e(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0));
            }
            PastLiveViewHolder.f(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setText(melonTvLiveListRes$RESPONSE$PASTLIVELIST0.liveTitle);
            PastLiveViewHolder.b(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setText(melonTvLiveListRes$RESPONSE$PASTLIVELIST0.liveDate);
            if(TextUtils.isEmpty(melonTvLiveListRes$RESPONSE$PASTLIVELIST0.viewCnt)) {
                PastLiveViewHolder.g(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setText("0");
            }
            else {
                PastLiveViewHolder.g(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setText(StringUtils.getCountString(melonTvLiveListRes$RESPONSE$PASTLIVELIST0.viewCnt, 0x98967F));
            }
            PastLiveViewHolder.c(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setImageResource(0x7F08078D);  // drawable:noimage_logo_small
            ViewUtils.showWhen(PastLiveViewHolder.a(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0), v == this.getCount() - 1);
            PastLiveViewHolder.d(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0).setVisibility(4);
            com.iloen.melon.fragments.melontv.MelonTvLiveFragment.LiveAdapter.2 melonTvLiveFragment$LiveAdapter$20 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    LINK melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0 = melonTvLiveListRes$RESPONSE$PASTLIVELIST0.link;
                    if(melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0 != null) {
                        MelonLinkExecutor.open(melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0.linktype, melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0.linkurl);
                    }
                }
            };
            ViewUtils.setOnClickListener(melonTvLiveFragment$LiveAdapter$PastLiveViewHolder0.itemView, melonTvLiveFragment$LiveAdapter$20);
        }

        private void updateLiveItem(LiveViewHolder melonTvLiveFragment$LiveAdapter$LiveViewHolder0, LIVELIST melonTvLiveListRes$RESPONSE$LIVELIST0, int v) {
            boolean z = false;
            if(ScreenUtils.isPortrait(this.getContext())) {
                ViewUtils.showWhen(LiveViewHolder.d(melonTvLiveFragment$LiveAdapter$LiveViewHolder0), this.getItem(v - 1) instanceof Section);
            }
            else {
                ViewUtils.showWhen(LiveViewHolder.d(melonTvLiveFragment$LiveAdapter$LiveViewHolder0), v == 1 || v == 2);
            }
            if(LiveViewHolder.e(melonTvLiveFragment$LiveAdapter$LiveViewHolder0) != null) {
                Glide.with(LiveViewHolder.e(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).getContext()).load(melonTvLiveListRes$RESPONSE$LIVELIST0.liveImg).into(LiveViewHolder.e(melonTvLiveFragment$LiveAdapter$LiveViewHolder0));
            }
            TextView textView0 = LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0);
            if("O".equals(melonTvLiveListRes$RESPONSE$LIVELIST0.liveStatus) || "C".equals(melonTvLiveListRes$RESPONSE$LIVELIST0.liveStatus)) {
                z = true;
            }
            ViewUtils.showWhen(textView0, z);
            if("O".equals(melonTvLiveListRes$RESPONSE$LIVELIST0.liveStatus)) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).getLayoutParams();
                viewGroup$LayoutParams0.width = this.mOnAirTextViewWidth;
                LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(0x7F130677);  // string:melontv_on_air "ON AIR"
            }
            else if("C".equals(melonTvLiveListRes$RESPONSE$LIVELIST0.liveStatus)) {
                ViewGroup.LayoutParams viewGroup$LayoutParams1 = LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).getLayoutParams();
                viewGroup$LayoutParams1.width = this.mComingSoonTextViewWidth;
                LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(0x7F130671);  // string:melontv_coming_soon "Coming Soon"
            }
            LiveViewHolder.c(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).requestLayout();
            if(TextUtils.isEmpty(melonTvLiveListRes$RESPONSE$LIVELIST0.viewCnt)) {
                LiveViewHolder.g(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText("0");
            }
            else {
                LiveViewHolder.g(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(StringUtils.getCountString(melonTvLiveListRes$RESPONSE$LIVELIST0.viewCnt, 0x98967F));
            }
            LiveViewHolder.f(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(melonTvLiveListRes$RESPONSE$LIVELIST0.liveTitle);
            LiveViewHolder.b(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(melonTvLiveListRes$RESPONSE$LIVELIST0.liveDate);
            LiveViewHolder.a(melonTvLiveFragment$LiveAdapter$LiveViewHolder0).setText(melonTvLiveListRes$RESPONSE$LIVELIST0.liveDesc);
            com.iloen.melon.fragments.melontv.MelonTvLiveFragment.LiveAdapter.1 melonTvLiveFragment$LiveAdapter$10 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    LINK melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0 = melonTvLiveListRes$RESPONSE$LIVELIST0.link;
                    if(melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0 != null) {
                        MelonLinkExecutor.open(melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0.linktype, melonTvLiveListRes$RESPONSE$PASTLIVELIST$LINK0.linkurl);
                    }
                }
            };
            ViewUtils.setOnClickListener(melonTvLiveFragment$LiveAdapter$LiveViewHolder0.itemView, melonTvLiveFragment$LiveAdapter$10);
        }
    }

    class MvItemDecoration extends r0 {
        private int spacingPixel;
        private int spanCount;

        public MvItemDecoration(int v) {
            this.spacingPixel = ScreenUtils.dipToPixel(melonTvLiveFragment0.getContext(), 16.0f);
            this.spanCount = v;
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            LiveAdapter melonTvLiveFragment$LiveAdapter0 = (LiveAdapter)MelonTvLiveFragment.this.mAdapter;
            int v = recyclerView0.getChildAdapterPosition(view0);
            int v1 = melonTvLiveFragment$LiveAdapter0.getItemViewType(v);
            if(!melonTvLiveFragment$LiveAdapter0.isReservedPosition(v) && (v1 != 0 && v1 != 3)) {
                int v2 = this.spanCount;
                int v3 = (v + 1) % v2;
                int v4 = this.spacingPixel;
                rect0.left = v4 - v3 * v4 / v2;
                rect0.right = (v3 + 1) * v4 / v2;
                StringBuilder stringBuilder0 = x.n(v, "GridSpacingItemDecoration >> [position: ", " ] >> left: ");
                stringBuilder0.append(rect0.left);
                stringBuilder0.append(", right: ");
                Z.s(rect0.right, "MelonTvLiveFragment", stringBuilder0);
            }
        }

        public void setSpanCount(int v) {
            this.spanCount = v;
        }
    }

    private static final String LIVE_STATUS_COMING = "C";
    private static final String LIVE_STATUS_ON_AIR = "O";
    private static final int SPAN_SIZE_1 = 1;
    private static final int SPAN_SIZE_2 = 2;
    private static final String TAG = "MelonTvLiveFragment";
    private MvItemDecoration mvItemDecoration;

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new LiveAdapter(context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("live").build().toString();
    }

    private void lambda$onFetchStart$0(i i0, MelonTvLiveListRes melonTvLiveListRes0) {
        if(!this.prepareFetchComplete(melonTvLiveListRes0)) {
            return;
        }
        this.performFetchComplete(i0, melonTvLiveListRes0);
    }

    public static MelonTvLiveFragment newInstance() {
        return new MelonTvLiveFragment();
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.mvItemDecoration.setSpanCount((configuration0.orientation == 1 ? 1 : 2));
        this.mAdapter.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        int v = 1;
        recyclerView0.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 2);
        gridLayoutManager0.g = new H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                return ((LiveAdapter)MelonTvLiveFragment.this.mAdapter).getItemViewType(v) == 2 ? 1 : 2;
            }
        };
        recyclerView0.setLayoutManager(gridLayoutManager0);
        if(!ScreenUtils.isPortrait(this.getContext())) {
            v = 2;
        }
        MvItemDecoration melonTvLiveFragment$MvItemDecoration0 = new MvItemDecoration(this, v);
        this.mvItemDecoration = melonTvLiveFragment$MvItemDecoration0;
        recyclerView0.addItemDecoration(melonTvLiveFragment$MvItemDecoration0);
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D04EF, viewGroup0, false);  // layout:melontv_live
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        RequestBuilder.newInstance(new MelonTvLiveListReq(this.getContext())).tag("MelonTvLiveFragment").listener(new b(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
    }
}

