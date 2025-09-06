package com.kakaoent.trevi.ad.databinding;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.kakaoent.trevi.ad.R.id;
import com.kakaoent.trevi.ad.R.layout;

public final class TreviCashFriendsVideoFragmentBinding implements a {
    public final AppCompatImageView closeButton;
    public final View closeGradientView;
    public final ProgressBar loadingProgress;
    public final View progressGradientView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout videoLayout;
    public final ProgressBar videoRemainTimeProgressView;
    public final AppCompatTextView videoRemainTimeTextView;
    public final VideoView videoView;

    private TreviCashFriendsVideoFragmentBinding(ConstraintLayout constraintLayout0, AppCompatImageView appCompatImageView0, View view0, ProgressBar progressBar0, View view1, ConstraintLayout constraintLayout1, ProgressBar progressBar1, AppCompatTextView appCompatTextView0, VideoView videoView0) {
        this.rootView = constraintLayout0;
        this.closeButton = appCompatImageView0;
        this.closeGradientView = view0;
        this.loadingProgress = progressBar0;
        this.progressGradientView = view1;
        this.videoLayout = constraintLayout1;
        this.videoRemainTimeProgressView = progressBar1;
        this.videoRemainTimeTextView = appCompatTextView0;
        this.videoView = videoView0;
    }

    public static TreviCashFriendsVideoFragmentBinding bind(View view0) {
        int v = R.id.closeButton;
        View view1 = I.C(view0, v);
        if(((AppCompatImageView)view1) != null) {
            v = R.id.closeGradientView;
            View view2 = I.C(view0, v);
            if(view2 != null) {
                v = R.id.loadingProgress;
                View view3 = I.C(view0, v);
                if(((ProgressBar)view3) != null) {
                    v = R.id.progressGradientView;
                    View view4 = I.C(view0, v);
                    if(view4 != null) {
                        v = R.id.videoRemainTimeProgressView;
                        View view5 = I.C(view0, v);
                        if(((ProgressBar)view5) != null) {
                            v = R.id.videoRemainTimeTextView;
                            View view6 = I.C(view0, v);
                            if(((AppCompatTextView)view6) != null) {
                                v = R.id.videoView;
                                View view7 = I.C(view0, v);
                                if(((VideoView)view7) != null) {
                                    return new TreviCashFriendsVideoFragmentBinding(((ConstraintLayout)view0), ((AppCompatImageView)view1), view2, ((ProgressBar)view3), view4, ((ConstraintLayout)view0), ((ProgressBar)view5), ((AppCompatTextView)view6), ((VideoView)view7));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TreviCashFriendsVideoFragmentBinding inflate(LayoutInflater layoutInflater0) {
        return TreviCashFriendsVideoFragmentBinding.inflate(layoutInflater0, null, false);
    }

    public static TreviCashFriendsVideoFragmentBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(R.layout.trevi_cash_friends_video_fragment, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return TreviCashFriendsVideoFragmentBinding.bind(view0);
    }
}

