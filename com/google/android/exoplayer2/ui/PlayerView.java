package com.google.android.exoplayer2.ui;

import P1.c;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View.OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Player.TextComponent;
import com.google.android.exoplayer2.Player.VideoComponent;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoListener;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class PlayerView extends FrameLayout implements AdViewProvider {
    final class ComponentListener implements View.OnLayoutChangeListener, EventListener, TextOutput, VisibilityListener, SingleTapListener, VideoListener {
        private Object lastPeriodUidWithTracks;
        private final Period period;

        public ComponentListener() {
            this.period = new Period();
        }

        @Override  // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List list0) {
            if(PlayerView.this.subtitleView != null) {
                PlayerView.this.subtitleView.onCues(list0);
            }
        }

        @Override  // android.view.View$OnLayoutChangeListener
        public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
            PlayerView.applyTextureViewRotation(((TextureView)view0), PlayerView.this.textureViewRotation);
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPlayerStateChanged(boolean z, int v) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateErrorMessage();
            if(PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
                return;
            }
            PlayerView.this.maybeShowController(false);
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPositionDiscontinuity(int v) {
            if(PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
            }
        }

        @Override  // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            if(PlayerView.this.shutterView != null) {
                PlayerView.this.shutterView.setVisibility(4);
            }
        }

        @Override  // com.google.android.exoplayer2.ui.spherical.SingleTapListener
        public boolean onSingleTapUp(MotionEvent motionEvent0) {
            return PlayerView.this.toggleControllerVisibility();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
            Player player0 = (Player)Assertions.checkNotNull(PlayerView.this.player);
            Timeline timeline0 = player0.getCurrentTimeline();
            if(timeline0.isEmpty()) {
                this.lastPeriodUidWithTracks = null;
            }
            else if(player0.getCurrentTrackGroups().isEmpty()) {
                Object object0 = this.lastPeriodUidWithTracks;
                if(object0 != null) {
                    int v = timeline0.getIndexOfPeriod(object0);
                    if(v != -1) {
                        int v1 = timeline0.getPeriod(v, this.period).windowIndex;
                        if(player0.getCurrentWindowIndex() == v1) {
                            return;
                        }
                    }
                    this.lastPeriodUidWithTracks = null;
                }
            }
            else {
                this.lastPeriodUidWithTracks = timeline0.getPeriod(player0.getCurrentPeriodIndex(), this.period, true).uid;
            }
            PlayerView.this.updateForCurrentTrackSelections(false);
        }

        @Override  // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int v, int v1, int v2, float f) {
            float f1 = v1 == 0 || v == 0 ? 1.0f : ((float)v) * f / ((float)v1);
            if(PlayerView.this.surfaceView instanceof TextureView) {
                if(v2 == 90 || v2 == 270) {
                    f1 = 1.0f / f1;
                }
                if(PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.removeOnLayoutChangeListener(this);
                }
                PlayerView.this.textureViewRotation = v2;
                if(PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.addOnLayoutChangeListener(this);
                }
                PlayerView.applyTextureViewRotation(((TextureView)PlayerView.this.surfaceView), PlayerView.this.textureViewRotation);
            }
            PlayerView.this.onContentAspectRatioChanged(f1, PlayerView.this.contentFrame, PlayerView.this.surfaceView);
        }

        @Override  // com.google.android.exoplayer2.ui.PlayerControlView$VisibilityListener
        public void onVisibilityChange(int v) {
            PlayerView.this.updateContentDescription();
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowBuffering {
    }

    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int PICTURE_TYPE_NOT_SET = -1;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private static final int SURFACE_TYPE_NONE = 0;
    private static final int SURFACE_TYPE_SPHERICAL_GL_SURFACE_VIEW = 3;
    private static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    private static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    private static final int SURFACE_TYPE_VIDEO_DECODER_GL_SURFACE_VIEW = 4;
    private final FrameLayout adOverlayFrameLayout;
    private final ImageView artworkView;
    private final View bufferingView;
    private final ComponentListener componentListener;
    private final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    private boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    private VisibilityListener controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private ErrorMessageProvider errorMessageProvider;
    private final TextView errorMessageView;
    private boolean isTouching;
    private boolean keepContentOnPlayerReset;
    private final FrameLayout overlayFrameLayout;
    private Player player;
    private int showBuffering;
    private final View shutterView;
    private final SubtitleView subtitleView;
    private final View surfaceView;
    private int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;
    private boolean useSensorRotation;

    public PlayerView(Context context0) {
        this(context0, null);
    }

    public PlayerView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public PlayerView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        boolean z5;
        boolean z4;
        boolean z3;
        int v8;
        int v7;
        int v6;
        boolean z2;
        int v5;
        boolean z1;
        int v4;
        int v3;
        boolean z;
        boolean z11;
        int v14;
        boolean z10;
        int v13;
        int v12;
        int v11;
        boolean z9;
        int v10;
        boolean z8;
        boolean z7;
        boolean z6;
        int v9;
        ComponentListener playerView$ComponentListener0 = new ComponentListener(this);
        this.componentListener = playerView$ComponentListener0;
        if(this.isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.surfaceView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.bufferingView = null;
            this.errorMessageView = null;
            this.controller = null;
            this.adOverlayFrameLayout = null;
            this.overlayFrameLayout = null;
            ImageView imageView0 = new ImageView(context0);
            if(Util.SDK_INT >= 23) {
                PlayerView.configureEditModeLogoV23(this.getResources(), imageView0);
            }
            else {
                PlayerView.configureEditModeLogo(this.getResources(), imageView0);
            }
            this.addView(imageView0);
            return;
        }
        int v1 = layout.exo_player_view;
        this.useSensorRotation = true;
        if(attributeSet0 == null) {
            v10 = 5000;
            z7 = true;
            v9 = 0;
            z8 = true;
            v11 = 0;
            z6 = true;
            v13 = 1;
            v12 = 0;
            z11 = true;
            v14 = 0;
            z10 = true;
            z9 = false;
        }
        else {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, styleable.PlayerView, 0, 0);
            try {
                z = typedArray0.hasValue(styleable.PlayerView_shutter_background_color);
                v3 = typedArray0.getColor(styleable.PlayerView_shutter_background_color, 0);
                v4 = typedArray0.getResourceId(styleable.PlayerView_player_layout_id, 0x7F0D025D);  // layout:exo_player_view
                z1 = typedArray0.getBoolean(styleable.PlayerView_use_artwork, true);
                v5 = typedArray0.getResourceId(styleable.PlayerView_default_artwork, 0);
                z2 = typedArray0.getBoolean(styleable.PlayerView_use_controller, true);
                v6 = typedArray0.getInt(styleable.PlayerView_surface_type, 1);
                v7 = typedArray0.getInt(styleable.PlayerView_resize_mode, 0);
                v8 = typedArray0.getInt(styleable.PlayerView_show_timeout, 5000);
                z3 = typedArray0.getBoolean(styleable.PlayerView_hide_on_touch, true);
                z4 = typedArray0.getBoolean(styleable.PlayerView_auto_show, true);
                v9 = typedArray0.getInteger(styleable.PlayerView_show_buffering, 0);
                this.keepContentOnPlayerReset = typedArray0.getBoolean(styleable.PlayerView_keep_content_on_player_reset, this.keepContentOnPlayerReset);
                z5 = typedArray0.getBoolean(styleable.PlayerView_hide_during_ads, true);
                this.useSensorRotation = typedArray0.getBoolean(styleable.PlayerView_use_sensor_rotation, this.useSensorRotation);
            }
            finally {
                typedArray0.recycle();
            }
            z6 = z3;
            v1 = v4;
            z7 = z4;
            z8 = z5;
            v10 = v8;
            z9 = z;
            v11 = v7;
            v12 = v3;
            v13 = v6;
            z10 = z2;
            v14 = v5;
            z11 = z1;
        }
        LayoutInflater.from(context0).inflate(v1, this);
        this.setDescendantFocusability(0x40000);
        AspectRatioFrameLayout aspectRatioFrameLayout0 = (AspectRatioFrameLayout)this.findViewById(id.exo_content_frame);
        this.contentFrame = aspectRatioFrameLayout0;
        if(aspectRatioFrameLayout0 != null) {
            PlayerView.setResizeModeRaw(aspectRatioFrameLayout0, v11);
        }
        View view0 = this.findViewById(id.exo_shutter);
        this.shutterView = view0;
        if(view0 != null && z9) {
            view0.setBackgroundColor(v12);
        }
        if(aspectRatioFrameLayout0 == null || v13 == 0) {
            this.surfaceView = null;
        }
        else {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = new ViewGroup.LayoutParams(-1, -1);
            switch(v13) {
                case 2: {
                    this.surfaceView = new TextureView(context0);
                    break;
                }
                case 3: {
                    SphericalGLSurfaceView sphericalGLSurfaceView0 = new SphericalGLSurfaceView(context0);
                    sphericalGLSurfaceView0.setSingleTapListener(playerView$ComponentListener0);
                    sphericalGLSurfaceView0.setUseSensorRotation(this.useSensorRotation);
                    this.surfaceView = sphericalGLSurfaceView0;
                    break;
                }
                case 4: {
                    this.surfaceView = new VideoDecoderGLSurfaceView(context0);
                    break;
                }
                default: {
                    this.surfaceView = new SurfaceView(context0);
                }
            }
            this.surfaceView.setLayoutParams(viewGroup$LayoutParams0);
            aspectRatioFrameLayout0.addView(this.surfaceView, 0);
        }
        this.adOverlayFrameLayout = (FrameLayout)this.findViewById(id.exo_ad_overlay);
        this.overlayFrameLayout = (FrameLayout)this.findViewById(id.exo_overlay);
        ImageView imageView1 = (ImageView)this.findViewById(id.exo_artwork);
        this.artworkView = imageView1;
        this.useArtwork = z11 && imageView1 != null;
        if(v14 != 0) {
            this.defaultArtwork = c.getDrawable(this.getContext(), v14);
        }
        SubtitleView subtitleView0 = (SubtitleView)this.findViewById(id.exo_subtitles);
        this.subtitleView = subtitleView0;
        if(subtitleView0 != null) {
            subtitleView0.setUserDefaultStyle();
            subtitleView0.setUserDefaultTextSize();
        }
        View view1 = this.findViewById(id.exo_buffering);
        this.bufferingView = view1;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        this.showBuffering = v9;
        TextView textView0 = (TextView)this.findViewById(id.exo_error_message);
        this.errorMessageView = textView0;
        if(textView0 != null) {
            textView0.setVisibility(8);
        }
        PlayerControlView playerControlView0 = (PlayerControlView)this.findViewById(id.exo_controller);
        View view2 = this.findViewById(id.exo_controller_placeholder);
        if(playerControlView0 != null) {
            this.controller = playerControlView0;
        }
        else if(view2 == null) {
            this.controller = null;
        }
        else {
            PlayerControlView playerControlView1 = new PlayerControlView(context0, null, 0, attributeSet0);
            this.controller = playerControlView1;
            playerControlView1.setId(0x7F0A045C);  // id:exo_controller
            playerControlView1.setLayoutParams(view2.getLayoutParams());
            ViewGroup viewGroup0 = (ViewGroup)view2.getParent();
            int v15 = viewGroup0.indexOfChild(view2);
            viewGroup0.removeView(view2);
            viewGroup0.addView(playerControlView1, v15);
        }
        this.controllerShowTimeoutMs = this.controller == null ? 0 : v10;
        this.controllerHideOnTouch = z6;
        this.controllerAutoShow = z7;
        this.controllerHideDuringAds = z8;
        this.useController = z10 && this.controller != null;
        this.hideController();
        this.updateContentDescription();
        PlayerControlView playerControlView2 = this.controller;
        if(playerControlView2 != null) {
            playerControlView2.addVisibilityListener(playerView$ComponentListener0);
        }
    }

    private static void applyTextureViewRotation(TextureView textureView0, int v) {
        Matrix matrix0 = new Matrix();
        float f = (float)textureView0.getWidth();
        float f1 = (float)textureView0.getHeight();
        if(f != 0.0f && f1 != 0.0f && v != 0) {
            matrix0.postRotate(((float)v), f / 2.0f, f1 / 2.0f);
            RectF rectF0 = new RectF(0.0f, 0.0f, f, f1);
            RectF rectF1 = new RectF();
            matrix0.mapRect(rectF1, rectF0);
            matrix0.postScale(f / rectF1.width(), f1 / rectF1.height(), f / 2.0f, f1 / 2.0f);
        }
        textureView0.setTransform(matrix0);
    }

    private void closeShutter() {
        View view0 = this.shutterView;
        if(view0 != null) {
            view0.setVisibility(0);
        }
    }

    private static void configureEditModeLogo(Resources resources0, ImageView imageView0) {
        imageView0.setImageDrawable(resources0.getDrawable(drawable.exo_edit_mode_logo));
        imageView0.setBackgroundColor(resources0.getColor(color.exo_edit_mode_background_color));
    }

    @TargetApi(23)
    private static void configureEditModeLogoV23(Resources resources0, ImageView imageView0) {
        imageView0.setImageDrawable(resources0.getDrawable(drawable.exo_edit_mode_logo, null));
        imageView0.setBackgroundColor(resources0.getColor(color.exo_edit_mode_background_color, null));
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(this.player != null && this.player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent0);
        }
        boolean z = this.isDpadKey(keyEvent0.getKeyCode());
        if(z && this.useController() && !this.controller.isVisible()) {
            this.maybeShowController(true);
            return true;
        }
        if(!this.dispatchMediaKeyEvent(keyEvent0) && !super.dispatchKeyEvent(keyEvent0)) {
            if(z && this.useController()) {
                this.maybeShowController(true);
            }
            return false;
        }
        this.maybeShowController(true);
        return true;
    }

    // 去混淆评级： 低(20)
    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent0) {
        return this.useController() && this.controller.dispatchMediaKeyEvent(keyEvent0);
    }

    @Override  // com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider
    public View[] getAdOverlayViews() {
        ArrayList arrayList0 = new ArrayList();
        FrameLayout frameLayout0 = this.overlayFrameLayout;
        if(frameLayout0 != null) {
            arrayList0.add(frameLayout0);
        }
        PlayerControlView playerControlView0 = this.controller;
        if(playerControlView0 != null) {
            arrayList0.add(playerControlView0);
        }
        return (View[])arrayList0.toArray(new View[0]);
    }

    @Override  // com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider
    public ViewGroup getAdViewGroup() {
        return (ViewGroup)Assertions.checkStateNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getResizeMode() {
        Assertions.checkStateNotNull(this.contentFrame);
        return this.contentFrame.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public boolean getUseController() {
        return this.useController;
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    private void hideArtwork() {
        ImageView imageView0 = this.artworkView;
        if(imageView0 != null) {
            imageView0.setImageResource(0x106000D);
            this.artworkView.setVisibility(4);
        }
    }

    public void hideController() {
        PlayerControlView playerControlView0 = this.controller;
        if(playerControlView0 != null) {
            playerControlView0.hide();
        }
    }

    public boolean isControllerVisible() {
        return this.controller != null && this.controller.isVisible();
    }

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int v) {
        switch(v) {
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 0x10C: 
            case 0x10D: 
            case 270: 
            case 0x10F: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    // 去混淆评级： 低(20)
    private boolean isPlayingAd() {
        return this.player != null && this.player.isPlayingAd() && this.player.getPlayWhenReady();
    }

    private void maybeShowController(boolean z) {
        if((!this.isPlayingAd() || !this.controllerHideDuringAds) && this.useController()) {
            boolean z1 = this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0;
            boolean z2 = this.shouldShowControllerIndefinitely();
            if(z || z1 || z2) {
                this.showController(z2);
            }
        }
    }

    public void onContentAspectRatioChanged(float f, AspectRatioFrameLayout aspectRatioFrameLayout0, View view0) {
        if(aspectRatioFrameLayout0 != null) {
            if(view0 instanceof SphericalGLSurfaceView) {
                f = 0.0f;
            }
            aspectRatioFrameLayout0.setAspectRatio(f);
        }
    }

    public void onPause() {
        View view0 = this.surfaceView;
        if(view0 instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView)view0).onPause();
        }
    }

    public void onResume() {
        View view0 = this.surfaceView;
        if(view0 instanceof SphericalGLSurfaceView) {
            ((SphericalGLSurfaceView)view0).onResume();
        }
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.useController() && this.player != null) {
            switch(motionEvent0.getAction()) {
                case 0: {
                    this.isTouching = true;
                    return true;
                }
                case 1: {
                    if(this.isTouching) {
                        this.isTouching = false;
                        this.performClick();
                        return true;
                    }
                    return false;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    @Override  // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent0) {
        if(this.useController() && this.player != null) {
            this.maybeShowController(true);
            return true;
        }
        return false;
    }

    @Override  // android.view.View
    public boolean performClick() {
        super.performClick();
        return this.toggleControllerVisibility();
    }

    @RequiresNonNull({"artworkView"})
    private boolean setArtworkFromMetadata(Metadata metadata0) {
        int v2;
        byte[] arr_b;
        int v = 0;
        boolean z = false;
        int v1 = -1;
        while(v < metadata0.length()) {
            Entry metadata$Entry0 = metadata0.get(v);
            if(metadata$Entry0 instanceof ApicFrame) {
                arr_b = ((ApicFrame)metadata$Entry0).pictureData;
                v2 = ((ApicFrame)metadata$Entry0).pictureType;
                goto label_12;
            }
            else if(metadata$Entry0 instanceof PictureFrame) {
                arr_b = ((PictureFrame)metadata$Entry0).pictureData;
                v2 = ((PictureFrame)metadata$Entry0).pictureType;
            label_12:
                if(v1 == -1 || v2 == 3) {
                    Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length);
                    z = this.setDrawableArtwork(new BitmapDrawable(this.getResources(), bitmap0));
                    if(v2 == 3) {
                        return z;
                    }
                    v1 = v2;
                }
            }
            ++v;
        }
        return z;
    }

    public void setAspectRatioListener(AspectRatioListener aspectRatioFrameLayout$AspectRatioListener0) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setAspectRatioListener(aspectRatioFrameLayout$AspectRatioListener0);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher0) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setControlDispatcher(controlDispatcher0);
    }

    public void setControllerAutoShow(boolean z) {
        this.controllerAutoShow = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.controllerHideDuringAds = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerHideOnTouch = z;
        this.updateContentDescription();
    }

    public void setControllerShowTimeoutMs(int v) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerShowTimeoutMs = v;
        if(this.controller.isVisible()) {
            this.showController();
        }
    }

    public void setControllerVisibilityListener(VisibilityListener playerControlView$VisibilityListener0) {
        Assertions.checkStateNotNull(this.controller);
        VisibilityListener playerControlView$VisibilityListener1 = this.controllerVisibilityListener;
        if(playerControlView$VisibilityListener1 != playerControlView$VisibilityListener0) {
            if(playerControlView$VisibilityListener1 != null) {
                this.controller.removeVisibilityListener(playerControlView$VisibilityListener1);
            }
            this.controllerVisibilityListener = playerControlView$VisibilityListener0;
            if(playerControlView$VisibilityListener0 != null) {
                this.controller.addVisibilityListener(playerControlView$VisibilityListener0);
            }
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence0) {
        Assertions.checkState(this.errorMessageView != null);
        this.customErrorMessage = charSequence0;
        this.updateErrorMessage();
    }

    @Deprecated
    public void setDefaultArtwork(Bitmap bitmap0) {
        this.setDefaultArtwork((bitmap0 == null ? null : new BitmapDrawable(this.getResources(), bitmap0)));
    }

    public void setDefaultArtwork(Drawable drawable0) {
        if(this.defaultArtwork != drawable0) {
            this.defaultArtwork = drawable0;
            this.updateForCurrentTrackSelections(false);
        }
    }

    @RequiresNonNull({"artworkView"})
    private boolean setDrawableArtwork(Drawable drawable0) {
        if(drawable0 != null) {
            int v = drawable0.getIntrinsicWidth();
            int v1 = drawable0.getIntrinsicHeight();
            if(v > 0 && v1 > 0) {
                this.onContentAspectRatioChanged(((float)v) / ((float)v1), this.contentFrame, this.artworkView);
                this.artworkView.setImageDrawable(drawable0);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public void setErrorMessageProvider(ErrorMessageProvider errorMessageProvider0) {
        if(this.errorMessageProvider != errorMessageProvider0) {
            this.errorMessageProvider = errorMessageProvider0;
            this.updateErrorMessage();
        }
    }

    public void setExtraAdGroupMarkers(long[] arr_v, boolean[] arr_z) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setExtraAdGroupMarkers(arr_v, arr_z);
    }

    public void setFastForwardIncrementMs(int v) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setFastForwardIncrementMs(v);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if(this.keepContentOnPlayerReset != z) {
            this.keepContentOnPlayerReset = z;
            this.updateForCurrentTrackSelections(false);
        }
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer0) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setPlaybackPreparer(playbackPreparer0);
    }

    public void setPlayer(Player player0) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player0 == null || player0.getApplicationLooper() == Looper.getMainLooper());
        Player player1 = this.player;
        if(player1 == player0) {
            return;
        }
        if(player1 != null) {
            player1.removeListener(this.componentListener);
            VideoComponent player$VideoComponent0 = player1.getVideoComponent();
            if(player$VideoComponent0 != null) {
                player$VideoComponent0.removeVideoListener(this.componentListener);
                View view0 = this.surfaceView;
                if(view0 instanceof TextureView) {
                    player$VideoComponent0.clearVideoTextureView(((TextureView)view0));
                }
                else if(view0 instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView)view0).setVideoComponent(null);
                }
                else if(view0 instanceof VideoDecoderGLSurfaceView) {
                    player$VideoComponent0.setVideoDecoderOutputBufferRenderer(null);
                }
                else if(view0 instanceof SurfaceView) {
                    player$VideoComponent0.clearVideoSurfaceView(((SurfaceView)view0));
                }
            }
            TextComponent player$TextComponent0 = player1.getTextComponent();
            if(player$TextComponent0 != null) {
                player$TextComponent0.removeTextOutput(this.componentListener);
            }
        }
        this.player = player0;
        if(this.useController()) {
            this.controller.setPlayer(player0);
        }
        SubtitleView subtitleView0 = this.subtitleView;
        if(subtitleView0 != null) {
            subtitleView0.setCues(null);
        }
        this.updateBuffering();
        this.updateErrorMessage();
        this.updateForCurrentTrackSelections(true);
        if(player0 != null) {
            VideoComponent player$VideoComponent1 = player0.getVideoComponent();
            if(player$VideoComponent1 != null) {
                View view1 = this.surfaceView;
                if(view1 instanceof TextureView) {
                    player$VideoComponent1.setVideoTextureView(((TextureView)view1));
                }
                else if(view1 instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView)view1).setVideoComponent(player$VideoComponent1);
                }
                else if(view1 instanceof VideoDecoderGLSurfaceView) {
                    player$VideoComponent1.setVideoDecoderOutputBufferRenderer(((VideoDecoderGLSurfaceView)view1).getVideoDecoderOutputBufferRenderer());
                }
                else if(view1 instanceof SurfaceView) {
                    player$VideoComponent1.setVideoSurfaceView(((SurfaceView)view1));
                }
                player$VideoComponent1.addVideoListener(this.componentListener);
            }
            TextComponent player$TextComponent1 = player0.getTextComponent();
            if(player$TextComponent1 != null) {
                player$TextComponent1.addTextOutput(this.componentListener);
            }
            player0.addListener(this.componentListener);
            this.maybeShowController(false);
            return;
        }
        this.hideController();
    }

    public void setRepeatToggleModes(int v) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setRepeatToggleModes(v);
    }

    public void setResizeMode(int v) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setResizeMode(v);
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout0, int v) {
        aspectRatioFrameLayout0.setResizeMode(v);
    }

    public void setRewindIncrementMs(int v) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setRewindIncrementMs(v);
    }

    public void setShowBuffering(int v) {
        if(this.showBuffering != v) {
            this.showBuffering = v;
            this.updateBuffering();
        }
    }

    @Deprecated
    public void setShowBuffering(boolean z) {
        this.setShowBuffering(((int)z));
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowMultiWindowTimeBar(z);
    }

    public void setShowShuffleButton(boolean z) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowShuffleButton(z);
    }

    public void setShutterBackgroundColor(int v) {
        View view0 = this.shutterView;
        if(view0 != null) {
            view0.setBackgroundColor(v);
        }
    }

    public void setUseArtwork(boolean z) {
        Assertions.checkState(!z || this.artworkView != null);
        if(this.useArtwork != z) {
            this.useArtwork = z;
            this.updateForCurrentTrackSelections(false);
        }
    }

    public void setUseController(boolean z) {
        Assertions.checkState(!z || this.controller != null);
        if(this.useController == z) {
            return;
        }
        this.useController = z;
        if(this.useController()) {
            this.controller.setPlayer(this.player);
        }
        else {
            PlayerControlView playerControlView0 = this.controller;
            if(playerControlView0 != null) {
                playerControlView0.hide();
                this.controller.setPlayer(null);
            }
        }
        this.updateContentDescription();
    }

    public void setUseSensorRotation(boolean z) {
        if(this.useSensorRotation != z) {
            this.useSensorRotation = z;
            View view0 = this.surfaceView;
            if(view0 instanceof SphericalGLSurfaceView) {
                ((SphericalGLSurfaceView)view0).setUseSensorRotation(z);
            }
        }
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        View view0 = this.surfaceView;
        if(view0 instanceof SurfaceView) {
            view0.setVisibility(v);
        }
    }

    private boolean shouldShowControllerIndefinitely() {
        Player player0 = this.player;
        if(player0 == null) {
            return true;
        }
        int v = player0.getPlaybackState();
        return this.controllerAutoShow && (v == 1 || v == 4 || !this.player.getPlayWhenReady());
    }

    private void showController(boolean z) {
        if(!this.useController()) {
            return;
        }
        this.controller.setShowTimeoutMs((z ? 0 : this.controllerShowTimeoutMs));
        this.controller.show();
    }

    public void showController() {
        this.showController(this.shouldShowControllerIndefinitely());
    }

    public static void switchTargetView(Player player0, PlayerView playerView0, PlayerView playerView1) {
        if(playerView0 != playerView1) {
            if(playerView1 != null) {
                playerView1.setPlayer(player0);
            }
            if(playerView0 != null) {
                playerView0.setPlayer(null);
            }
        }
    }

    private boolean toggleControllerVisibility() {
        if(this.useController() && this.player != null) {
            if(!this.controller.isVisible()) {
                this.maybeShowController(true);
                return true;
            }
            if(this.controllerHideOnTouch) {
                this.controller.hide();
            }
            return true;
        }
        return false;
    }

    private void updateBuffering() {
        boolean z = true;
        int v = 0;
        if(this.bufferingView != null) {
            if(this.player == null || this.player.getPlaybackState() != 2 || this.showBuffering != 2 && (this.showBuffering != 1 || !this.player.getPlayWhenReady())) {
                z = false;
            }
            View view0 = this.bufferingView;
            if(!z) {
                v = 8;
            }
            view0.setVisibility(v);
        }
    }

    private void updateContentDescription() {
        PlayerControlView playerControlView0 = this.controller;
        String s = null;
        if(playerControlView0 != null && this.useController) {
            if(playerControlView0.getVisibility() == 0) {
                if(this.controllerHideOnTouch) {
                    s = this.getResources().getString(string.exo_controls_hide);
                }
                this.setContentDescription(s);
                return;
            }
            this.setContentDescription(this.getResources().getString(string.exo_controls_show));
            return;
        }
        this.setContentDescription(null);
    }

    private void updateErrorMessage() {
        TextView textView0 = this.errorMessageView;
        if(textView0 != null) {
            CharSequence charSequence0 = this.customErrorMessage;
            if(charSequence0 != null) {
                textView0.setText(charSequence0);
                this.errorMessageView.setVisibility(0);
                return;
            }
            ExoPlaybackException exoPlaybackException0 = this.player == null ? null : this.player.getPlaybackError();
            if(exoPlaybackException0 != null) {
                ErrorMessageProvider errorMessageProvider0 = this.errorMessageProvider;
                if(errorMessageProvider0 != null) {
                    Pair pair0 = errorMessageProvider0.getErrorMessage(exoPlaybackException0);
                    this.errorMessageView.setText(((CharSequence)pair0.second));
                    this.errorMessageView.setVisibility(0);
                    return;
                }
            }
            this.errorMessageView.setVisibility(8);
        }
    }

    private void updateForCurrentTrackSelections(boolean z) {
        Player player0 = this.player;
        if(player0 != null && !player0.getCurrentTrackGroups().isEmpty()) {
            if(z && !this.keepContentOnPlayerReset) {
                this.closeShutter();
            }
            TrackSelectionArray trackSelectionArray0 = player0.getCurrentTrackSelections();
            for(int v = 0; v < trackSelectionArray0.length; ++v) {
                if(player0.getRendererType(v) == 2 && trackSelectionArray0.get(v) != null) {
                    this.hideArtwork();
                    return;
                }
            }
            this.closeShutter();
            if(!this.useArtwork()) {
                this.hideArtwork();
                return;
            }
            for(int v1 = 0; v1 < trackSelectionArray0.length; ++v1) {
                TrackSelection trackSelection0 = trackSelectionArray0.get(v1);
                if(trackSelection0 != null) {
                    for(int v2 = 0; v2 < trackSelection0.length(); ++v2) {
                        Metadata metadata0 = trackSelection0.getFormat(v2).metadata;
                        if(metadata0 != null && this.setArtworkFromMetadata(metadata0)) {
                            return;
                        }
                    }
                }
            }
            if(!this.setDrawableArtwork(this.defaultArtwork)) {
                this.hideArtwork();
            }
        }
        else if(!this.keepContentOnPlayerReset) {
            this.hideArtwork();
            this.closeShutter();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean useArtwork() {
        if(this.useArtwork) {
            Assertions.checkStateNotNull(this.artworkView);
            return true;
        }
        return false;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean useController() {
        if(this.useController) {
            Assertions.checkStateNotNull(this.controller);
            return true;
        }
        return false;
    }
}

