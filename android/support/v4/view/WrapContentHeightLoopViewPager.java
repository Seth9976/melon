package android.support.v4.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.j;

public class WrapContentHeightLoopViewPager extends WrapContentHeightViewPager {
    static class LoopPagerAdapter extends a {
        private a mInnerPagerAdapter;

        public LoopPagerAdapter(int v, a a0) {
            this(a0);
        }

        private LoopPagerAdapter(a a0) {
            this.mInnerPagerAdapter = a0;
        }

        public int changeRealPositionToVirtualPosition(int v) {
            return this.mInnerPagerAdapter.getCount() * 2 + v + 1;
        }

        public int changeVirtualPositionToRealPosition(int v) {
            int v1 = this.getRealCount();
            if(v1 == 0) {
                return 0;
            }
            int v2 = (v - 1) % v1;
            if(v2 >= 0) {
                v1 = 0;
            }
            return v2 + v1;
        }

        @Override  // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
            int v1 = this.changeVirtualPositionToRealPosition(v);
            this.mInnerPagerAdapter.destroyItem(viewGroup0, v1, object0);
        }

        @Override  // androidx.viewpager.widget.a
        public void finishUpdate(ViewGroup viewGroup0) {
            this.mInnerPagerAdapter.finishUpdate(viewGroup0);
        }

        @Override  // androidx.viewpager.widget.a
        public int getCount() {
            return this.mInnerPagerAdapter.getCount() * 6 + 2;
        }

        public a getPagerAdapter() {
            return this.mInnerPagerAdapter;
        }

        public int getRealCount() {
            return this.mInnerPagerAdapter.getCount();
        }

        @Override  // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup0, int v) {
            int v1 = this.changeVirtualPositionToRealPosition(v);
            return this.mInnerPagerAdapter.instantiateItem(viewGroup0, v1);
        }

        @Override  // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view0, Object object0) {
            return this.mInnerPagerAdapter.isViewFromObject(view0, object0);
        }

        @Override  // androidx.viewpager.widget.a
        public void notifyDataSetChanged() {
            this.mInnerPagerAdapter.notifyDataSetChanged();
            super.notifyDataSetChanged();
        }

        @Override  // androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable0, ClassLoader classLoader0) {
            this.mInnerPagerAdapter.restoreState(parcelable0, classLoader0);
        }

        @Override  // androidx.viewpager.widget.a
        public Parcelable saveState() {
            return this.mInnerPagerAdapter.saveState();
        }

        @Override  // androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup0, int v, Object object0) {
            this.mInnerPagerAdapter.setPrimaryItem(viewGroup0, v, object0);
        }

        @Override  // androidx.viewpager.widget.a
        public void startUpdate(ViewGroup viewGroup0) {
            this.mInnerPagerAdapter.startUpdate(viewGroup0);
        }
    }

    private j mInnerPageChangeListener;
    private LoopPagerAdapter mLoopPagerAdapter;
    private j mOuterPageChangeListener;

    public WrapContentHeightLoopViewPager(Context context0) {
        super(context0);
        this.mOuterPageChangeListener = null;
        this.mLoopPagerAdapter = null;
        android.support.v4.view.WrapContentHeightLoopViewPager.1 wrapContentHeightLoopViewPager$10 = new j() {
            private float mPreviousOffset;
            private float mPreviousPosition;

            {
                this.mPreviousOffset = -1.0f;
                this.mPreviousPosition = -1.0f;
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v1 = WrapContentHeightLoopViewPager.this.super.getCurrentItem();
                    int v2 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v1);
                    if(v == 0 && (v1 == 0 || v1 == WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getCount() - 1)) {
                        WrapContentHeightLoopViewPager.this.setCurrentItem(v2, false);
                    }
                }
                if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                    WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrollStateChanged(v);
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v2 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v);
                    if(f == 0.0f && this.mPreviousOffset == 0.0f && (v == 0 || v == WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getCount() - 1)) {
                        WrapContentHeightLoopViewPager.this.setCurrentItem(v2, false);
                    }
                    v = v2;
                }
                this.mPreviousOffset = f;
                if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                    if(v != WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getRealCount() - 1) {
                        WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(v, f, v1);
                        return;
                    }
                    if(((double)f) > 0.5) {
                        WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(0, 0.0f, 0);
                        return;
                    }
                    WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(v, 0.0f, 0);
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v1 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v);
                    if(this.mPreviousPosition != ((float)v1)) {
                        this.mPreviousPosition = (float)v1;
                        if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                            WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageSelected(v1);
                        }
                    }
                }
            }
        };
        this.mInnerPageChangeListener = wrapContentHeightLoopViewPager$10;
        super.setOnPageChangeListener(wrapContentHeightLoopViewPager$10);
    }

    public WrapContentHeightLoopViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mOuterPageChangeListener = null;
        this.mLoopPagerAdapter = null;
        android.support.v4.view.WrapContentHeightLoopViewPager.1 wrapContentHeightLoopViewPager$10 = new j() {
            private float mPreviousOffset;
            private float mPreviousPosition;

            {
                this.mPreviousOffset = -1.0f;
                this.mPreviousPosition = -1.0f;
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v1 = WrapContentHeightLoopViewPager.this.super.getCurrentItem();
                    int v2 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v1);
                    if(v == 0 && (v1 == 0 || v1 == WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getCount() - 1)) {
                        WrapContentHeightLoopViewPager.this.setCurrentItem(v2, false);
                    }
                }
                if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                    WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrollStateChanged(v);
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v2 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v);
                    if(f == 0.0f && this.mPreviousOffset == 0.0f && (v == 0 || v == WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getCount() - 1)) {
                        WrapContentHeightLoopViewPager.this.setCurrentItem(v2, false);
                    }
                    v = v2;
                }
                this.mPreviousOffset = f;
                if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                    if(v != WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.getRealCount() - 1) {
                        WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(v, f, v1);
                        return;
                    }
                    if(((double)f) > 0.5) {
                        WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(0, 0.0f, 0);
                        return;
                    }
                    WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageScrolled(v, 0.0f, 0);
                }
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                if(WrapContentHeightLoopViewPager.this.mLoopPagerAdapter != null) {
                    int v1 = WrapContentHeightLoopViewPager.this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(v);
                    if(this.mPreviousPosition != ((float)v1)) {
                        this.mPreviousPosition = (float)v1;
                        if(WrapContentHeightLoopViewPager.this.mOuterPageChangeListener != null) {
                            WrapContentHeightLoopViewPager.this.mOuterPageChangeListener.onPageSelected(v1);
                        }
                    }
                }
            }
        };
        this.mInnerPageChangeListener = wrapContentHeightLoopViewPager$10;
        super.setOnPageChangeListener(wrapContentHeightLoopViewPager$10);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public a getAdapter() {
        return this.mLoopPagerAdapter == null ? null : this.mLoopPagerAdapter.getPagerAdapter();
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return this.mLoopPagerAdapter == null ? 0 : this.mLoopPagerAdapter.changeVirtualPositionToRealPosition(super.getCurrentItem());
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setAdapter(a a0) {
        if(a0 != null) {
            LoopPagerAdapter wrapContentHeightLoopViewPager$LoopPagerAdapter0 = new LoopPagerAdapter(0, a0);
            this.mLoopPagerAdapter = wrapContentHeightLoopViewPager$LoopPagerAdapter0;
            super.setAdapter(wrapContentHeightLoopViewPager$LoopPagerAdapter0);
            if(this.mLoopPagerAdapter.getRealCount() > 1) {
                this.setCurrentItem(0, false);
            }
            return;
        }
        this.mLoopPagerAdapter = null;
        super.setAdapter(null);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int v) {
        if(this.getCurrentItem() != v) {
            this.setCurrentItem(v, true);
        }
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int v, boolean z) {
        super.setCurrentItem(this.mLoopPagerAdapter.changeRealPositionToVirtualPosition(v), z);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(j j0) {
        this.mOuterPageChangeListener = j0;
    }
}

