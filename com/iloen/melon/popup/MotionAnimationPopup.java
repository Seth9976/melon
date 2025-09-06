package com.iloen.melon.popup;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.U0;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.ScreenUtils;

public abstract class MotionAnimationPopup extends Dialog {
    public static final long SINGLE_IMAGE_DISMISS_DELAY_MILLIS = 1000L;
    public final Activity a;
    public final int[] b;
    public final String c;
    public final int d;
    public final int e;
    public boolean f;
    public final long g;
    public long h;
    public final U0 i;

    public MotionAnimationPopup(Activity activity0, String s, int v, int v1) {
        super(activity0, 0x7F14000B);  // style:AppAnimationPopupThemeTransparent
        this.f = false;
        this.g = 1000L;
        this.i = new U0(this) {
            public int a;
            public final MotionAnimationPopup b;

            public void handleMessage(MotionAnimationPopup motionAnimationPopup0, Message message0) {
                MotionAnimationPopup motionAnimationPopup1 = MotionAnimationPopup.this;
                if(motionAnimationPopup1.a != null && !motionAnimationPopup1.a.isFinishing()) {
                    int v = message0.what;
                    if(100 == v) {
                        int[] arr_v = motionAnimationPopup0.b;
                        if(arr_v != null) {
                            ImageView imageView0 = motionAnimationPopup0.getImageView();
                            int v1 = this.a;
                            if(arr_v[v1 % arr_v.length] > 0) {
                                imageView0.setImageResource(arr_v[v1 % arr_v.length]);
                            }
                            int v2 = this.a + 1;
                            this.a = v2;
                            if(motionAnimationPopup1.f) {
                                if(System.currentTimeMillis() - motionAnimationPopup1.h > motionAnimationPopup1.g) {
                                    try {
                                        motionAnimationPopup0.dismiss();
                                    }
                                    catch(Exception unused_ex) {
                                    }
                                    return;
                                }
                                motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                                return;
                            }
                            if(v2 >= arr_v.length) {
                                try {
                                    motionAnimationPopup0.dismiss();
                                }
                                catch(Exception unused_ex) {
                                }
                                return;
                            }
                            motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                        }
                    }
                    else if(200 == v) {
                        try {
                            motionAnimationPopup0.dismiss();
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.custom.U0
            public void handleMessage(Object object0, Message message0) {
                this.handleMessage(((MotionAnimationPopup)object0), message0);
            }
        };
        this.e = v;
        this.d = v1;
        this.c = s;
        this.setCancelable(false);
        this.setContentView(this.getLayoutId());
        this.a = activity0;
    }

    public MotionAnimationPopup(Activity activity0, int[] arr_v) {
        super(activity0, 0x7F14000B);  // style:AppAnimationPopupThemeTransparent
        this.f = false;
        this.g = 1000L;
        this.i = new U0(this) {
            public int a;
            public final MotionAnimationPopup b;

            public void handleMessage(MotionAnimationPopup motionAnimationPopup0, Message message0) {
                MotionAnimationPopup motionAnimationPopup1 = MotionAnimationPopup.this;
                if(motionAnimationPopup1.a != null && !motionAnimationPopup1.a.isFinishing()) {
                    int v = message0.what;
                    if(100 == v) {
                        int[] arr_v = motionAnimationPopup0.b;
                        if(arr_v != null) {
                            ImageView imageView0 = motionAnimationPopup0.getImageView();
                            int v1 = this.a;
                            if(arr_v[v1 % arr_v.length] > 0) {
                                imageView0.setImageResource(arr_v[v1 % arr_v.length]);
                            }
                            int v2 = this.a + 1;
                            this.a = v2;
                            if(motionAnimationPopup1.f) {
                                if(System.currentTimeMillis() - motionAnimationPopup1.h > motionAnimationPopup1.g) {
                                    try {
                                        motionAnimationPopup0.dismiss();
                                    }
                                    catch(Exception unused_ex) {
                                    }
                                    return;
                                }
                                motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                                return;
                            }
                            if(v2 >= arr_v.length) {
                                try {
                                    motionAnimationPopup0.dismiss();
                                }
                                catch(Exception unused_ex) {
                                }
                                return;
                            }
                            motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                        }
                    }
                    else if(200 == v) {
                        try {
                            motionAnimationPopup0.dismiss();
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.custom.U0
            public void handleMessage(Object object0, Message message0) {
                this.handleMessage(((MotionAnimationPopup)object0), message0);
            }
        };
        this.b = arr_v;
        this.setCancelable(false);
        this.setContentView(this.getLayoutId());
        this.a = activity0;
    }

    public MotionAnimationPopup(Activity activity0, int[] arr_v, boolean z, long v) {
        super(activity0, 0x7F14000B);  // style:AppAnimationPopupThemeTransparent
        this.f = false;
        this.g = 1000L;
        this.i = new U0(this) {
            public int a;
            public final MotionAnimationPopup b;

            public void handleMessage(MotionAnimationPopup motionAnimationPopup0, Message message0) {
                MotionAnimationPopup motionAnimationPopup1 = MotionAnimationPopup.this;
                if(motionAnimationPopup1.a != null && !motionAnimationPopup1.a.isFinishing()) {
                    int v = message0.what;
                    if(100 == v) {
                        int[] arr_v = motionAnimationPopup0.b;
                        if(arr_v != null) {
                            ImageView imageView0 = motionAnimationPopup0.getImageView();
                            int v1 = this.a;
                            if(arr_v[v1 % arr_v.length] > 0) {
                                imageView0.setImageResource(arr_v[v1 % arr_v.length]);
                            }
                            int v2 = this.a + 1;
                            this.a = v2;
                            if(motionAnimationPopup1.f) {
                                if(System.currentTimeMillis() - motionAnimationPopup1.h > motionAnimationPopup1.g) {
                                    try {
                                        motionAnimationPopup0.dismiss();
                                    }
                                    catch(Exception unused_ex) {
                                    }
                                    return;
                                }
                                motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                                return;
                            }
                            if(v2 >= arr_v.length) {
                                try {
                                    motionAnimationPopup0.dismiss();
                                }
                                catch(Exception unused_ex) {
                                }
                                return;
                            }
                            motionAnimationPopup1.i.sendEmptyMessageDelayed(100, 20L);
                        }
                    }
                    else if(200 == v) {
                        try {
                            motionAnimationPopup0.dismiss();
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
            }

            @Override  // com.iloen.melon.custom.U0
            public void handleMessage(Object object0, Message message0) {
                this.handleMessage(((MotionAnimationPopup)object0), message0);
            }
        };
        this.f = z;
        this.g = v;
        this.b = arr_v;
        this.setCancelable(false);
        this.setContentView(this.getLayoutId());
        this.a = activity0;
    }

    public void forceRepeateClose() {
        this.f = false;
    }

    public long getDelayMillis() [...] // Inlined contents

    public ImageView getImageView() {
        View view0 = this.findViewById(0x7F0A00A2);  // id:animation_image
        return view0 instanceof ImageView ? ((ImageView)view0) : null;
    }

    public int getLayoutId() {
        return 0x7F0D059E;  // layout:popup_animation
    }

    public LottieAnimationView getLottieImageView() {
        View view0 = this.findViewById(0x7F0A07B1);  // id:lottie_animation_image
        return view0 instanceof LottieAnimationView ? ((LottieAnimationView)view0) : null;
    }

    @Override  // android.app.Dialog
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            Point point0 = ScreenUtils.getScreenSize(this.getContext());
            window0.setGravity(0x30);
            window0.setLayout(point0.x, point0.y);
        }
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        U0 u00 = this.i;
        if(this.b != null) {
            this.h = System.currentTimeMillis();
            u00.sendEmptyMessage(100);
            return;
        }
        if(!TextUtils.isEmpty(this.c)) {
            if(AndroidSettings.isAnimationDisabled(this.getContext())) {
                this.getLottieImageView().setImageResource(this.d);
                u00.sendEmptyMessageDelayed(200, 1000L);
                return;
            }
            LottieAnimationView lottieAnimationView0 = this.getLottieImageView();
            lottieAnimationView0.setAnimation(this.c);
            lottieAnimationView0.setRepeatCount(this.e);
            lottieAnimationView0.addAnimatorListener(new Animator.AnimatorListener() {
                public final MotionAnimationPopup a;

                {
                    this.a = motionAnimationPopup0;
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationCancel(Animator animator0) {
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationEnd(Animator animator0) {
                    this.a.dismiss();
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationRepeat(Animator animator0) {
                }

                @Override  // android.animation.Animator$AnimatorListener
                public void onAnimationStart(Animator animator0) {
                }
            });
            lottieAnimationView0.playAnimation();
            return;
        }
        this.dismiss();
    }
}

