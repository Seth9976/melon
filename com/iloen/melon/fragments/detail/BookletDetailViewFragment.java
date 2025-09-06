package com.iloen.melon.fragments.detail;

import B.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.OnSwipeListener;
import com.github.chrisbanes.PhotoView;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.utils.animation.AnimationUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.io.Serializable;
import java.util.ArrayList;
import v9.h;
import v9.i;

public class BookletDetailViewFragment extends MetaContentBaseFragment {
    public static class BookletInfo implements Serializable {
        public String imgUrl;
        private static final long serialVersionUID = 0x4917CFFCA909007FL;

        public BookletInfo(String s) {
            this.imgUrl = s;
        }
    }

    static enum SLIDE_FLAG {
        PREV,
        NEW,
        NEXT;

        private static SLIDE_FLAG[] $values() [...] // Inlined contents
    }

    private static final String ARG_BOOKLET_CURRENT_POSITION = "argBookletCurrentPosition";
    private static final String ARG_BOOKLET_IMAGES = "argBookletImages";
    private static final String ARG_BOOKLET_TITLE = "argBookletTitle";
    private static final int ONE_CLICK_TIME = 1500;
    private static final String TAG = "BookletViewFragment";
    private ArrayList mBookletList;
    private String mBookletTitle;
    private ImageView mBtnSwipeNext;
    private String mCurrentImgUrl;
    private long mCurrentMotionEventTime;
    private int mCurrentPosition;
    private PhotoView mDetailImageView;
    private View mErrorView;
    private View.OnClickListener mOnClickListener;
    private OnSwipeListener mOnSwipeListener;
    private View mPagingContainer;
    private TranslateAnimation mPhotoViewAnimation;
    private Animation.AnimationListener mPhotoViewAnimationListener;
    private SLIDE_FLAG mSlideDirection;
    private View mTopContainer;
    private TextView mTvCurrentPage;
    private TextView mTvTopTitle;
    private TextView mTvTotalPage;

    public BookletDetailViewFragment() {
        this.mSlideDirection = SLIDE_FLAG.NEW;
        this.mPhotoViewAnimationListener = new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                BookletDetailViewFragment.this.mDetailImageView.setImageDrawable(null);
                ViewUtils.showWhen(BookletDetailViewFragment.this.mErrorView, false);
                BookletDetailViewFragment.this.mDetailImageView.clearAnimation();
                BookletDetailViewFragment.this.mErrorView.clearAnimation();
                BookletDetailViewFragment.this.mDetailImageView.setOnClickListener(BookletDetailViewFragment.this.mOnClickListener);
                BookletDetailViewFragment.this.mDetailImageView.setOnSwipeListener(BookletDetailViewFragment.this.mOnSwipeListener);
                BookletDetailViewFragment.this.moveCurrentPosition();
                BookletDetailViewFragment.this.startFetch();
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                BookletDetailViewFragment.this.mDetailImageView.setOnClickListener(null);
                BookletDetailViewFragment.this.mDetailImageView.setOnSwipeListener(null);
            }
        };
        this.mOnClickListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                boolean z = 8 == BookletDetailViewFragment.this.mPagingContainer.getVisibility();
                BookletDetailViewFragment.this.setInfoViewVisibility(z);
            }
        };
        this.mOnSwipeListener = new OnSwipeListener() {
            @Override  // com.github.chrisbanes.OnSwipeListener
            public void onSwipeLeft() {
                LogU.d("BookletViewFragment", "onSwipeLeft()");
                BookletDetailViewFragment.this.slidePhotoView(true);
            }

            @Override  // com.github.chrisbanes.OnSwipeListener
            public void onSwipeRight() {
                LogU.d("BookletViewFragment", "onSwipeRight()");
                BookletDetailViewFragment.this.slidePhotoView(false);
            }
        };
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.k.buildUpon().appendPath("detail").appendQueryParameter("pos", String.valueOf(this.mCurrentPosition)).appendQueryParameter("url", this.mCurrentImgUrl).build().toString();
    }

    private boolean hasMoreNextOutOfRange() {
        return this.mCurrentPosition < this.mBookletList.size() - 1;
    }

    private boolean hasMorePrevOutOfRange() {
        return this.mCurrentPosition > 0;
    }

    private boolean isFirstPage() {
        return this.mCurrentPosition == 0;
    }

    private boolean isLastPage() {
        return this.mBookletList != null && this.mCurrentPosition == this.mBookletList.size() - 1;
    }

    private boolean isSinglePage() {
        return this.mBookletList != null && this.mBookletList.size() == 1;
    }

    private void moveCurrentPosition() {
        SLIDE_FLAG bookletDetailViewFragment$SLIDE_FLAG0 = this.mSlideDirection;
        if(bookletDetailViewFragment$SLIDE_FLAG0 == SLIDE_FLAG.NEXT) {
            ++this.mCurrentPosition;
        }
        else if(bookletDetailViewFragment$SLIDE_FLAG0 == SLIDE_FLAG.PREV) {
            --this.mCurrentPosition;
        }
        StringBuilder stringBuilder0 = new StringBuilder("move: mCurrentPosition = ");
        Z.s(this.mCurrentPosition, "BookletViewFragment", stringBuilder0);
    }

    public static BookletDetailViewFragment newInstance(ArrayList arrayList0, String s, int v) {
        BookletDetailViewFragment bookletDetailViewFragment0 = new BookletDetailViewFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argBookletImages", arrayList0);
        bundle0.putString("argBookletTitle", s);
        bundle0.putInt("argBookletCurrentPosition", v);
        bookletDetailViewFragment0.setArguments(bundle0);
        return bookletDetailViewFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        LogU.d("BookletViewFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D005A, viewGroup0, false);  // layout:booklet_detailview
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Z.w("onFetchStart reason:", s, "BookletViewFragment");
        this.updateUi();
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mBookletList = (ArrayList)CompatUtils.getSerializable(bundle0, "argBookletImages", ArrayList.class);
        this.mBookletTitle = (String)CompatUtils.getSerializable(bundle0, "argBookletTitle", String.class);
        this.mCurrentPosition = (int)(((Integer)CompatUtils.getSerializable(bundle0, "argBookletCurrentPosition", Integer.class)));
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putSerializable("argBookletImages", this.mBookletList);
            bundle0.putString("argBookletTitle", this.mBookletTitle);
            bundle0.putInt("argBookletCurrentPosition", this.mCurrentPosition);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        LogU.d("BookletViewFragment", "onViewCreated : Title = " + this.mBookletTitle + " , Position = " + this.mCurrentPosition + " , List = " + this.mBookletList);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(0));
            titleBar0.setBackgroundColor(0);
        }
        this.mTopContainer = this.findViewById(0x7F0A0BCE);  // id:top_container
        this.mTvTopTitle = (TextView)this.findViewById(0x7F0A0D45);  // id:tv_top_title
        this.mPagingContainer = this.findViewById(0x7F0A08FC);  // id:paging_container
        this.mTvTotalPage = (TextView)this.findViewById(0x7F0A0D48);  // id:tv_totalpage
        this.mTvCurrentPage = (TextView)this.findViewById(0x7F0A0CD6);  // id:tv_page
        this.mBtnSwipeNext = (ImageView)view0.findViewById(0x7F0A0696);  // id:iv_swipe_next
        PhotoView photoView0 = (PhotoView)this.findViewById(0x7F0A03BB);  // id:detail_image
        this.mDetailImageView = photoView0;
        photoView0.setOnClickListener(this.mOnClickListener);
        this.mDetailImageView.setOnSwipeListener(this.mOnSwipeListener);
        this.mErrorView = this.findViewById(0x7F0A044C);  // id:error_text
        this.mTvTopTitle.setText(this.mBookletTitle);
        ArrayList arrayList0 = this.mBookletList;
        if(arrayList0 != null) {
            this.mTvTotalPage.setText(String.valueOf(arrayList0.size()));
            ViewUtils.showWhen(this.mPagingContainer, true);
        }
    }

    private void setErrorViewVisiblity(boolean z) {
        ViewUtils.showWhen(this.mErrorView, z);
        if(z) {
            this.mDetailImageView.setImageResource(0x7F080786);  // drawable:noimage_logo_large
        }
    }

    private void setInfoView(String s) {
        this.mTvCurrentPage.setText(String.valueOf(this.mCurrentPosition + 1));
        Context context0 = this.getContext();
        if(context0 != null && this.mDetailImageView != null) {
            Glide.with(context0).load(s).listener(new RequestListener() {
                @Override  // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
                    BookletDetailViewFragment.this.setErrorViewVisiblity(false);
                    return false;
                }

                public boolean onResourceReady(Drawable drawable0, Object object0, Target target0, DataSource dataSource0, boolean z) {
                    FragmentActivity fragmentActivity0 = BookletDetailViewFragment.this.getActivity();
                    if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                        fragmentActivity0.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(drawable0 == null) {
                                    BookletDetailViewFragment.this.setErrorViewVisiblity(true);
                                    return;
                                }
                                BookletDetailViewFragment.this.setErrorViewVisiblity(false);
                            }
                        });
                        return false;
                    }
                    LogU.e("BookletViewFragment", "onResourceReady() Activity Object is vaild!");
                    return false;
                }

                @Override  // com.bumptech.glide.request.RequestListener
                public boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
                    return this.onResourceReady(((Drawable)object0), object1, target0, dataSource0, z);
                }
            }).into(this.mDetailImageView);
        }
        this.setInfoViewVisibility(true);
    }

    private void setInfoViewVisibility(boolean z) {
        AnimationUtils.setFadeAnimation(this.getContext(), this.mTvTopTitle, z);
        AnimationUtils.setFadeAnimation(this.getContext(), this.mPagingContainer, z);
        if(z && !this.isSinglePage() && this.isFirstPage()) {
            AnimationUtils.setFadeInAndOutAnimation(this.mBtnSwipeNext);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private boolean slidePhotoView(boolean z) {
        this.mSlideDirection = z ? SLIDE_FLAG.NEXT : SLIDE_FLAG.PREV;
        if(!(z ? this.hasMoreNextOutOfRange() : this.hasMorePrevOutOfRange())) {
            LogU.v("BookletViewFragment", "slidePhotoView() There are no more");
            return false;
        }
        View view0 = this.mErrorView.getVisibility() == 0 ? this.mErrorView : this.mDetailImageView;
        int v = view0.getWidth();
        TranslateAnimation translateAnimation0 = new TranslateAnimation(0.0f, (z ? ((float)(-v)) : ((float)v)), 0.0f, 0.0f);
        this.mPhotoViewAnimation = translateAnimation0;
        translateAnimation0.setDuration(300L);
        this.mPhotoViewAnimation.setFillAfter(true);
        this.mPhotoViewAnimation.setAnimationListener(this.mPhotoViewAnimationListener);
        view0.startAnimation(this.mPhotoViewAnimation);
        return true;
    }

    private void updateUi() {
        this.setErrorViewVisiblity(false);
        if(this.mBookletList != null && this.mBookletList.get(this.mCurrentPosition) != null && !TextUtils.isEmpty(((BookletInfo)this.mBookletList.get(this.mCurrentPosition)).imgUrl)) {
            this.mCurrentImgUrl = ((BookletInfo)this.mBookletList.get(this.mCurrentPosition)).imgUrl;
            Z.x(new StringBuilder("updateUi : ImgUrl = "), this.mCurrentImgUrl, "BookletViewFragment");
            this.setInfoView(this.mCurrentImgUrl);
        }
    }
}

