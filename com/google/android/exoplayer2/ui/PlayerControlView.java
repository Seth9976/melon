package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerControlView extends FrameLayout {
    final class ComponentListener implements View.OnClickListener, EventListener, OnScrubListener {
        private ComponentListener() {
        }

        public ComponentListener(com.google.android.exoplayer2.ui.PlayerControlView.1 playerControlView$10) {
        }

        @Override  // android.view.View$OnClickListener
        public void onClick(View view0) {
            Player player0 = PlayerControlView.this.player;
            if(player0 != null) {
                if(PlayerControlView.this.nextButton == view0) {
                    PlayerControlView.this.next(player0);
                    return;
                }
                if(PlayerControlView.this.previousButton == view0) {
                    PlayerControlView.this.previous(player0);
                    return;
                }
                if(PlayerControlView.this.fastForwardButton == view0) {
                    PlayerControlView.this.fastForward(player0);
                    return;
                }
                if(PlayerControlView.this.rewindButton == view0) {
                    PlayerControlView.this.rewind(player0);
                    return;
                }
                if(PlayerControlView.this.playButton == view0) {
                    switch(player0.getPlaybackState()) {
                        case 1: {
                            if(PlayerControlView.this.playbackPreparer != null) {
                                PlayerControlView.this.playbackPreparer.preparePlayback();
                            }
                            break;
                        }
                        case 4: {
                            int v = player0.getCurrentWindowIndex();
                            PlayerControlView.this.seekTo(player0, v, 0x8000000000000001L);
                        }
                    }
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player0, true);
                    return;
                }
                if(PlayerControlView.this.pauseButton == view0) {
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player0, false);
                    return;
                }
                if(PlayerControlView.this.repeatToggleButton == view0) {
                    int v1 = RepeatModeUtil.getNextRepeatMode(player0.getRepeatMode(), PlayerControlView.this.repeatToggleModes);
                    PlayerControlView.this.controlDispatcher.dispatchSetRepeatMode(player0, v1);
                    return;
                }
                if(PlayerControlView.this.shuffleButton == view0) {
                    boolean z = player0.getShuffleModeEnabled();
                    PlayerControlView.this.controlDispatcher.dispatchSetShuffleModeEnabled(player0, !z);
                }
            }
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onIsPlayingChanged(boolean z) {
            PlayerControlView.this.updateProgress();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPlayerStateChanged(boolean z, int v) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPositionDiscontinuity(int v) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onRepeatModeChanged(int v) {
            PlayerControlView.this.updateRepeatModeButton();
            PlayerControlView.this.updateNavigation();
        }

        @Override  // com.google.android.exoplayer2.ui.TimeBar$OnScrubListener
        public void onScrubMove(TimeBar timeBar0, long v) {
            if(PlayerControlView.this.positionView != null) {
                String s = Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, v);
                PlayerControlView.this.positionView.setText(s);
            }
        }

        @Override  // com.google.android.exoplayer2.ui.TimeBar$OnScrubListener
        public void onScrubStart(TimeBar timeBar0, long v) {
            PlayerControlView.this.scrubbing = true;
            if(PlayerControlView.this.positionView != null) {
                String s = Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, v);
                PlayerControlView.this.positionView.setText(s);
            }
        }

        @Override  // com.google.android.exoplayer2.ui.TimeBar$OnScrubListener
        public void onScrubStop(TimeBar timeBar0, long v, boolean z) {
            PlayerControlView.this.scrubbing = false;
            if(!z && PlayerControlView.this.player != null) {
                PlayerControlView.this.seekToTimeBarPosition(PlayerControlView.this.player, v);
            }
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerControlView.this.updateShuffleButton();
            PlayerControlView.this.updateNavigation();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onTimelineChanged(Timeline timeline0, int v) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long arg1, long arg2);
    }

    public interface VisibilityListener {
        void onVisibilityChange(int arg1);
    }

    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000L;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    private ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private int fastForwardMs;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;
    private final View nextButton;
    private final View pauseButton;
    private final Period period;
    private final View playButton;
    private PlaybackPreparer playbackPreparer;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final View previousButton;
    private ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final View rewindButton;
    private int rewindMs;
    private boolean scrubbing;
    private boolean showMultiWindowTimeBar;
    private boolean showShuffleButton;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList visibilityListeners;
    private final View vrButton;
    private final Window window;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context0) {
        this(context0, null);
    }

    public PlayerControlView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public PlayerControlView(Context context0, AttributeSet attributeSet0, int v) {
        this(context0, attributeSet0, v, attributeSet0);
    }

    public PlayerControlView(Context context0, AttributeSet attributeSet0, int v, AttributeSet attributeSet1) {
        super(context0, attributeSet0, v);
        int v1 = layout.exo_player_control_view;
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = 0x8000000000000001L;
        this.showShuffleButton = false;
        if(attributeSet1 != null) {
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet1, styleable.PlayerControlView, 0, 0);
            try {
                this.rewindMs = typedArray0.getInt(styleable.PlayerControlView_rewind_increment, this.rewindMs);
                this.fastForwardMs = typedArray0.getInt(styleable.PlayerControlView_fastforward_increment, this.fastForwardMs);
                this.showTimeoutMs = typedArray0.getInt(styleable.PlayerControlView_show_timeout, this.showTimeoutMs);
                v1 = typedArray0.getResourceId(styleable.PlayerControlView_controller_layout_id, 0x7F0D025C);  // layout:exo_player_control_view
                this.repeatToggleModes = PlayerControlView.getRepeatToggleModes(typedArray0, this.repeatToggleModes);
                this.showShuffleButton = typedArray0.getBoolean(styleable.PlayerControlView_show_shuffle_button, this.showShuffleButton);
                this.setTimeBarMinUpdateInterval(typedArray0.getInt(styleable.PlayerControlView_time_bar_min_update_interval, 200));
            }
            finally {
                typedArray0.recycle();
            }
        }
        this.visibilityListeners = new CopyOnWriteArrayList();
        this.period = new Period();
        this.window = new Window();
        StringBuilder stringBuilder0 = new StringBuilder();
        this.formatBuilder = stringBuilder0;
        this.formatter = new Formatter(stringBuilder0, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        ComponentListener playerControlView$ComponentListener0 = new ComponentListener(this, null);
        this.componentListener = playerControlView$ComponentListener0;
        this.controlDispatcher = new DefaultControlDispatcher();
        this.updateProgressAction = new b(this, 0);
        this.hideAction = new b(this, 1);
        LayoutInflater.from(context0).inflate(v1, this);
        this.setDescendantFocusability(0x40000);
        TimeBar timeBar0 = (TimeBar)this.findViewById(id.exo_progress);
        View view0 = this.findViewById(id.exo_progress_placeholder);
        if(timeBar0 != null) {
            this.timeBar = timeBar0;
        }
        else if(view0 == null) {
            this.timeBar = null;
        }
        else {
            DefaultTimeBar defaultTimeBar0 = new DefaultTimeBar(context0, null, 0, attributeSet1);
            defaultTimeBar0.setId(0x7F0A0468);  // id:exo_progress
            defaultTimeBar0.setLayoutParams(view0.getLayoutParams());
            ViewGroup viewGroup0 = (ViewGroup)view0.getParent();
            int v3 = viewGroup0.indexOfChild(view0);
            viewGroup0.removeView(view0);
            viewGroup0.addView(defaultTimeBar0, v3);
            this.timeBar = defaultTimeBar0;
        }
        this.durationView = (TextView)this.findViewById(id.exo_duration);
        this.positionView = (TextView)this.findViewById(id.exo_position);
        TimeBar timeBar1 = this.timeBar;
        if(timeBar1 != null) {
            timeBar1.addListener(playerControlView$ComponentListener0);
        }
        View view1 = this.findViewById(id.exo_play);
        this.playButton = view1;
        if(view1 != null) {
            view1.setOnClickListener(playerControlView$ComponentListener0);
        }
        View view2 = this.findViewById(id.exo_pause);
        this.pauseButton = view2;
        if(view2 != null) {
            view2.setOnClickListener(playerControlView$ComponentListener0);
        }
        View view3 = this.findViewById(id.exo_prev);
        this.previousButton = view3;
        if(view3 != null) {
            view3.setOnClickListener(playerControlView$ComponentListener0);
        }
        View view4 = this.findViewById(id.exo_next);
        this.nextButton = view4;
        if(view4 != null) {
            view4.setOnClickListener(playerControlView$ComponentListener0);
        }
        View view5 = this.findViewById(id.exo_rew);
        this.rewindButton = view5;
        if(view5 != null) {
            view5.setOnClickListener(playerControlView$ComponentListener0);
        }
        View view6 = this.findViewById(id.exo_ffwd);
        this.fastForwardButton = view6;
        if(view6 != null) {
            view6.setOnClickListener(playerControlView$ComponentListener0);
        }
        ImageView imageView0 = (ImageView)this.findViewById(id.exo_repeat_toggle);
        this.repeatToggleButton = imageView0;
        if(imageView0 != null) {
            imageView0.setOnClickListener(playerControlView$ComponentListener0);
        }
        ImageView imageView1 = (ImageView)this.findViewById(id.exo_shuffle);
        this.shuffleButton = imageView1;
        if(imageView1 != null) {
            imageView1.setOnClickListener(playerControlView$ComponentListener0);
        }
        this.vrButton = this.findViewById(id.exo_vr);
        this.setShowVrButton(false);
        Resources resources0 = context0.getResources();
        this.buttonAlphaEnabled = ((float)resources0.getInteger(integer.exo_media_button_opacity_percentage_enabled)) / 100.0f;
        this.buttonAlphaDisabled = ((float)resources0.getInteger(integer.exo_media_button_opacity_percentage_disabled)) / 100.0f;
        this.repeatOffButtonDrawable = resources0.getDrawable(drawable.exo_controls_repeat_off);
        this.repeatOneButtonDrawable = resources0.getDrawable(drawable.exo_controls_repeat_one);
        this.repeatAllButtonDrawable = resources0.getDrawable(drawable.exo_controls_repeat_all);
        this.shuffleOnButtonDrawable = resources0.getDrawable(drawable.exo_controls_shuffle_on);
        this.shuffleOffButtonDrawable = resources0.getDrawable(drawable.exo_controls_shuffle_off);
        this.repeatOffButtonContentDescription = resources0.getString(string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = resources0.getString(string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = resources0.getString(string.exo_controls_repeat_all_description);
        this.shuffleOnContentDescription = resources0.getString(string.exo_controls_shuffle_on_description);
        this.shuffleOffContentDescription = resources0.getString(string.exo_controls_shuffle_off_description);
    }

    public void addVisibilityListener(VisibilityListener playerControlView$VisibilityListener0) {
        this.visibilityListeners.add(playerControlView$VisibilityListener0);
    }

    private static boolean canShowMultiWindowTimeBar(Timeline timeline0, Window timeline$Window0) {
        if(timeline0.getWindowCount() > 100) {
            return false;
        }
        int v = timeline0.getWindowCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(timeline0.getWindow(v1, timeline$Window0).durationUs == 0x8000000000000001L) {
                return false;
            }
        }
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        return this.dispatchMediaKeyEvent(keyEvent0) || super.dispatchKeyEvent(keyEvent0);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent0) {
        int v = keyEvent0.getKeyCode();
        Player player0 = this.player;
        if(player0 != null && PlayerControlView.isHandledMediaKey(v)) {
            if(keyEvent0.getAction() == 0) {
                switch(v) {
                    case 89: {
                        this.rewind(player0);
                        return true;
                    }
                    case 90: {
                        this.fastForward(player0);
                        return true;
                    label_10:
                        if(keyEvent0.getRepeatCount() == 0) {
                            switch(v) {
                                case 85: {
                                    this.controlDispatcher.dispatchSetPlayWhenReady(player0, !player0.getPlayWhenReady());
                                    break;
                                }
                                case 87: {
                                    this.next(player0);
                                    return true;
                                }
                                case 88: {
                                    this.previous(player0);
                                    return true;
                                }
                                case 0x7E: {
                                    this.controlDispatcher.dispatchSetPlayWhenReady(player0, true);
                                    return true;
                                }
                                case 0x7F: {
                                    this.controlDispatcher.dispatchSetPlayWhenReady(player0, false);
                                    return true;
                                }
                                default: {
                                    return true;
                                }
                            }
                        }
                        break;
                    }
                    default: {
                        goto label_10;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.removeCallbacks(this.hideAction);
                return super.dispatchTouchEvent(motionEvent0);
            }
            case 1: {
                this.hideAfterTimeout();
                return super.dispatchTouchEvent(motionEvent0);
            }
            default: {
                return super.dispatchTouchEvent(motionEvent0);
            }
        }
    }

    private void fastForward(Player player0) {
        if(player0.isCurrentWindowSeekable()) {
            int v = this.fastForwardMs;
            if(v > 0) {
                this.seekToOffset(player0, ((long)v));
            }
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    private static int getRepeatToggleModes(TypedArray typedArray0, int v) {
        return typedArray0.getInt(styleable.PlayerControlView_repeat_toggle_modes, v);
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        return this.vrButton != null && this.vrButton.getVisibility() == 0;
    }

    public void hide() {
        if(this.isVisible()) {
            this.setVisibility(8);
            for(Object object0: this.visibilityListeners) {
                ((VisibilityListener)object0).onVisibilityChange(this.getVisibility());
            }
            this.removeCallbacks(this.updateProgressAction);
            this.removeCallbacks(this.hideAction);
            this.hideAtMs = 0x8000000000000001L;
        }
    }

    private void hideAfterTimeout() {
        this.removeCallbacks(this.hideAction);
        if(this.showTimeoutMs > 0) {
            long v = SystemClock.uptimeMillis();
            int v1 = this.showTimeoutMs;
            this.hideAtMs = v + ((long)v1);
            if(this.isAttachedToWindow) {
                this.postDelayed(this.hideAction, ((long)v1));
            }
            return;
        }
        this.hideAtMs = 0x8000000000000001L;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int v) {
        switch(v) {
            case 85: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 0x7E: 
            case 0x7F: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public boolean isVisible() {
        return this.getVisibility() == 0;
    }

    private void next(Player player0) {
        Timeline timeline0 = player0.getCurrentTimeline();
        if(!timeline0.isEmpty() && !player0.isPlayingAd()) {
            int v = player0.getCurrentWindowIndex();
            int v1 = player0.getNextWindowIndex();
            if(v1 != -1) {
                this.seekTo(player0, v1, 0x8000000000000001L);
                return;
            }
            if(timeline0.getWindow(v, this.window).isDynamic) {
                this.seekTo(player0, v, 0x8000000000000001L);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long v = this.hideAtMs;
        if(v != 0x8000000000000001L) {
            long v1 = v - SystemClock.uptimeMillis();
            if(v1 <= 0L) {
                this.hide();
            }
            else {
                this.postDelayed(this.hideAction, v1);
            }
        }
        else if(this.isVisible()) {
            this.hideAfterTimeout();
        }
        this.updateAll();
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        this.removeCallbacks(this.updateProgressAction);
        this.removeCallbacks(this.hideAction);
    }

    private void previous(Player player0) {
        Timeline timeline0 = player0.getCurrentTimeline();
        if(!timeline0.isEmpty() && !player0.isPlayingAd()) {
            int v = player0.getCurrentWindowIndex();
            timeline0.getWindow(v, this.window);
            int v1 = player0.getPreviousWindowIndex();
            if(v1 != -1 && (player0.getCurrentPosition() <= 3000L || this.window.isDynamic && !this.window.isSeekable)) {
                this.seekTo(player0, v1, 0x8000000000000001L);
                return;
            }
            this.seekTo(player0, v, 0L);
        }
    }

    public void removeVisibilityListener(VisibilityListener playerControlView$VisibilityListener0) {
        this.visibilityListeners.remove(playerControlView$VisibilityListener0);
    }

    private void requestPlayPauseFocus() {
        boolean z = this.shouldShowPauseButton();
        if(!z) {
            View view0 = this.playButton;
            if(view0 != null) {
                view0.requestFocus();
                return;
            }
        }
        if(z) {
            View view1 = this.pauseButton;
            if(view1 != null) {
                view1.requestFocus();
            }
        }
    }

    private void rewind(Player player0) {
        if(player0.isCurrentWindowSeekable()) {
            int v = this.rewindMs;
            if(v > 0) {
                this.seekToOffset(player0, ((long)(-v)));
            }
        }
    }

    private boolean seekTo(Player player0, int v, long v1) {
        return this.controlDispatcher.dispatchSeekTo(player0, v, v1);
    }

    private void seekToOffset(Player player0, long v) {
        long v1 = player0.getCurrentPosition() + v;
        long v2 = player0.getDuration();
        if(v2 != 0x8000000000000001L) {
            v1 = Math.min(v1, v2);
        }
        this.seekTo(player0, player0.getCurrentWindowIndex(), Math.max(v1, 0L));
    }

    private void seekToTimeBarPosition(Player player0, long v) {
        Timeline timeline0 = player0.getCurrentTimeline();
        if(!this.multiWindowTimeBar || timeline0.isEmpty()) {
            v2 = player0.getCurrentWindowIndex();
        }
        else {
            int v1 = timeline0.getWindowCount();
            int v2;
            for(v2 = 0; true; ++v2) {
                long v3 = timeline0.getWindow(v2, this.window).getDurationMs();
                if(v < v3) {
                    break;
                }
                if(v2 == v1 - 1) {
                    v = v3;
                    break;
                }
                v -= v3;
            }
        }
        if(!this.seekTo(player0, v2, v)) {
            this.updateProgress();
        }
    }

    private void setButtonEnabled(boolean z, View view0) {
        if(view0 == null) {
            return;
        }
        view0.setEnabled(z);
        view0.setAlpha((z ? this.buttonAlphaEnabled : this.buttonAlphaDisabled));
        view0.setVisibility(0);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher0) {
        if(controlDispatcher0 == null) {
            controlDispatcher0 = new DefaultControlDispatcher();
        }
        this.controlDispatcher = controlDispatcher0;
    }

    public void setExtraAdGroupMarkers(long[] arr_v, boolean[] arr_z) {
        boolean z = false;
        if(arr_v == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        }
        else {
            boolean[] arr_z1 = (boolean[])Assertions.checkNotNull(arr_z);
            if(arr_v.length == arr_z1.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.extraAdGroupTimesMs = arr_v;
            this.extraPlayedAdGroups = arr_z1;
        }
        this.updateTimeline();
    }

    public void setFastForwardIncrementMs(int v) {
        this.fastForwardMs = v;
        this.updateNavigation();
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer0) {
        this.playbackPreparer = playbackPreparer0;
    }

    public void setPlayer(Player player0) {
        boolean z = false;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if(player0 == null || player0.getApplicationLooper() == Looper.getMainLooper()) {
            z = true;
        }
        Assertions.checkArgument(z);
        Player player1 = this.player;
        if(player1 == player0) {
            return;
        }
        if(player1 != null) {
            player1.removeListener(this.componentListener);
        }
        this.player = player0;
        if(player0 != null) {
            player0.addListener(this.componentListener);
        }
        this.updateAll();
    }

    public void setProgressUpdateListener(ProgressUpdateListener playerControlView$ProgressUpdateListener0) {
        this.progressUpdateListener = playerControlView$ProgressUpdateListener0;
    }

    public void setRepeatToggleModes(int v) {
        this.repeatToggleModes = v;
        Player player0 = this.player;
        if(player0 != null) {
            int v1 = player0.getRepeatMode();
            if(v == 0 && v1 != 0) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 0);
            }
            else if(v == 1 && v1 == 2) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 1);
            }
            else if(v == 2 && v1 == 1) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 2);
            }
        }
        this.updateRepeatModeButton();
    }

    public void setRewindIncrementMs(int v) {
        this.rewindMs = v;
        this.updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        this.updateTimeline();
    }

    public void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        this.updateShuffleButton();
    }

    public void setShowTimeoutMs(int v) {
        this.showTimeoutMs = v;
        if(this.isVisible()) {
            this.hideAfterTimeout();
        }
    }

    public void setShowVrButton(boolean z) {
        View view0 = this.vrButton;
        if(view0 != null) {
            view0.setVisibility((z ? 0 : 8));
        }
    }

    public void setTimeBarMinUpdateInterval(int v) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(v, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener view$OnClickListener0) {
        View view0 = this.vrButton;
        if(view0 != null) {
            view0.setOnClickListener(view$OnClickListener0);
        }
    }

    private boolean shouldShowPauseButton() {
        return this.player != null && this.player.getPlaybackState() != 4 && this.player.getPlaybackState() != 1 && this.player.getPlayWhenReady();
    }

    public void show() {
        if(!this.isVisible()) {
            this.setVisibility(0);
            for(Object object0: this.visibilityListeners) {
                ((VisibilityListener)object0).onVisibilityChange(this.getVisibility());
            }
            this.updateAll();
            this.requestPlayPauseFocus();
        }
        this.hideAfterTimeout();
    }

    private void updateAll() {
        this.updatePlayPauseButton();
        this.updateNavigation();
        this.updateRepeatModeButton();
        this.updateShuffleButton();
        this.updateTimeline();
    }

    private void updateNavigation() {
        boolean z5;
        boolean z4;
        boolean z3;
        boolean z1;
        if(this.isVisible() && this.isAttachedToWindow) {
            Player player0 = this.player;
            boolean z = false;
            if(player0 == null) {
            label_16:
                z5 = false;
                z1 = false;
                z3 = false;
                z4 = false;
            }
            else {
                Timeline timeline0 = player0.getCurrentTimeline();
                if(!timeline0.isEmpty() && !player0.isPlayingAd()) {
                    timeline0.getWindow(player0.getCurrentWindowIndex(), this.window);
                    z1 = this.window.isSeekable;
                    boolean z2 = z1 || !this.window.isDynamic || player0.hasPrevious();
                    z3 = z1 && this.rewindMs > 0;
                    z4 = z1 && this.fastForwardMs > 0;
                    if(this.window.isDynamic || player0.hasNext()) {
                        z = true;
                    }
                    z5 = z;
                    z = z2;
                    goto label_20;
                }
                goto label_16;
            }
        label_20:
            this.setButtonEnabled(z, this.previousButton);
            this.setButtonEnabled(z3, this.rewindButton);
            this.setButtonEnabled(z4, this.fastForwardButton);
            this.setButtonEnabled(z5, this.nextButton);
            TimeBar timeBar0 = this.timeBar;
            if(timeBar0 != null) {
                timeBar0.setEnabled(z1);
            }
        }
    }

    private void updatePlayPauseButton() {
        int v2;
        if(this.isVisible() && this.isAttachedToWindow) {
            boolean z = this.shouldShowPauseButton();
            View view0 = this.playButton;
            int v = 8;
            int v1 = 1;
            if(view0 == null) {
                v2 = 0;
            }
            else {
                v2 = !z || !view0.isFocused() ? 0 : 1;
                this.playButton.setVisibility((z ? 8 : 0));
            }
            View view1 = this.pauseButton;
            if(view1 != null) {
                if(z || !view1.isFocused()) {
                    v1 = 0;
                }
                v2 |= v1;
                View view2 = this.pauseButton;
                if(z) {
                    v = 0;
                }
                view2.setVisibility(v);
            }
            if(v2 != 0) {
                this.requestPlayPauseFocus();
            }
        }
    }

    private void updateProgress() {
        long v3;
        long v1;
        if(this.isVisible() && this.isAttachedToWindow) {
            Player player0 = this.player;
            if(player0 == null) {
                v1 = 0L;
                v3 = 0L;
            }
            else {
                long v = this.currentWindowOffset;
                v1 = player0.getContentPosition() + v;
                long v2 = this.currentWindowOffset;
                v3 = player0.getContentBufferedPosition() + v2;
            }
            TextView textView0 = this.positionView;
            if(textView0 != null && !this.scrubbing) {
                textView0.setText(Util.getStringForTime(this.formatBuilder, this.formatter, v1));
            }
            TimeBar timeBar0 = this.timeBar;
            if(timeBar0 != null) {
                timeBar0.setPosition(v1);
                this.timeBar.setBufferedPosition(v3);
            }
            ProgressUpdateListener playerControlView$ProgressUpdateListener0 = this.progressUpdateListener;
            if(playerControlView$ProgressUpdateListener0 != null) {
                playerControlView$ProgressUpdateListener0.onProgressUpdate(v1, v3);
            }
            this.removeCallbacks(this.updateProgressAction);
            int v4 = player0 == null ? 1 : player0.getPlaybackState();
            long v5 = 1000L;
            if(player0 != null && player0.isPlaying()) {
                long v6 = Math.min((this.timeBar == null ? 1000L : this.timeBar.getPreferredUpdateDelay()), 1000L - v1 % 1000L);
                float f = player0.getPlaybackParameters().speed;
                if(f > 0.0f) {
                    v5 = (long)(((float)v6) / f);
                }
                this.postDelayed(this.updateProgressAction, Util.constrainValue(v5, this.timeBarMinUpdateIntervalMs, 1000L));
                return;
            }
            if(v4 != 1 && v4 != 4) {
                this.postDelayed(this.updateProgressAction, 1000L);
            }
        }
    }

    private void updateRepeatModeButton() {
        if(this.isVisible() && this.isAttachedToWindow) {
            ImageView imageView0 = this.repeatToggleButton;
            if(imageView0 != null) {
                if(this.repeatToggleModes == 0) {
                    imageView0.setVisibility(8);
                    return;
                }
                Player player0 = this.player;
                if(player0 == null) {
                    this.setButtonEnabled(false, imageView0);
                    this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                    return;
                }
                this.setButtonEnabled(true, imageView0);
                int v = player0.getRepeatMode();
                switch(v) {
                    case 0: {
                        this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                        this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                        break;
                    }
                    case 1: {
                        this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                        this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
                        break;
                    }
                    default: {
                        if(v == 2) {
                            this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                            this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
                        }
                    }
                }
                this.repeatToggleButton.setVisibility(0);
            }
        }
    }

    private void updateShuffleButton() {
        if(this.isVisible() && this.isAttachedToWindow) {
            ImageView imageView0 = this.shuffleButton;
            if(imageView0 != null) {
                Player player0 = this.player;
                if(!this.showShuffleButton) {
                    imageView0.setVisibility(8);
                    return;
                }
                if(player0 == null) {
                    this.setButtonEnabled(false, imageView0);
                    this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                    this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
                    return;
                }
                this.setButtonEnabled(true, imageView0);
                Drawable drawable0 = player0.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable;
                this.shuffleButton.setImageDrawable(drawable0);
                String s = player0.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription;
                this.shuffleButton.setContentDescription(s);
            }
        }
    }

    private void updateTimeline() {
        Window timeline$Window1;
        int v4;
        Player player0 = this.player;
        if(player0 == null) {
            return;
        }
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && PlayerControlView.canShowMultiWindowTimeBar(player0.getCurrentTimeline(), this.window);
        long v = 0L;
        this.currentWindowOffset = 0L;
        Timeline timeline0 = player0.getCurrentTimeline();
        if(timeline0.isEmpty()) {
            v4 = 0;
        }
        else {
            int v1 = player0.getCurrentWindowIndex();
            int v2 = this.multiWindowTimeBar ? 0 : v1;
            int v3 = this.multiWindowTimeBar ? timeline0.getWindowCount() - 1 : v1;
            v4 = 0;
            long v5 = 0L;
            while(v2 <= v3) {
                if(v2 == v1) {
                    this.currentWindowOffset = C.usToMs(v5);
                }
                timeline0.getWindow(v2, this.window);
                Window timeline$Window0 = this.window;
                if(timeline$Window0.durationUs == 0x8000000000000001L) {
                    Assertions.checkState(!this.multiWindowTimeBar);
                    break;
                }
                int v6 = timeline$Window0.firstPeriodIndex;
                while(true) {
                    timeline$Window1 = this.window;
                    if(v6 > timeline$Window1.lastPeriodIndex) {
                        break;
                    }
                    timeline0.getPeriod(v6, this.period);
                    int v7 = this.period.getAdGroupCount();
                    int v8 = 0;
                    while(v8 < v7) {
                        long v9 = this.period.getAdGroupTimeUs(v8);
                        if(v9 == 0x8000000000000000L) {
                            long v10 = this.period.durationUs;
                            if(v10 != 0x8000000000000001L) {
                                v9 = v10;
                                goto label_33;
                            }
                        }
                        else {
                        label_33:
                            long v11 = this.period.getPositionInWindowUs() + v9;
                            if(v11 >= 0L) {
                                long[] arr_v = this.adGroupTimesMs;
                                if(v4 == arr_v.length) {
                                    int v12 = arr_v.length == 0 ? 1 : arr_v.length * 2;
                                    this.adGroupTimesMs = Arrays.copyOf(arr_v, v12);
                                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, v12);
                                }
                                long[] arr_v1 = this.adGroupTimesMs;
                                arr_v1[v4] = C.usToMs(v11 + v5);
                                this.playedAdGroups[v4] = this.period.hasPlayedAdGroup(v8);
                                ++v4;
                            }
                        }
                        ++v8;
                    }
                    ++v6;
                }
                v5 += timeline$Window1.durationUs;
                ++v2;
            }
            v = v5;
        }
        long v13 = C.usToMs(v);
        TextView textView0 = this.durationView;
        if(textView0 != null) {
            textView0.setText(Util.getStringForTime(this.formatBuilder, this.formatter, v13));
        }
        TimeBar timeBar0 = this.timeBar;
        if(timeBar0 != null) {
            timeBar0.setDuration(v13);
            int v14 = this.extraAdGroupTimesMs.length;
            int v15 = v4 + v14;
            long[] arr_v2 = this.adGroupTimesMs;
            if(v15 > arr_v2.length) {
                this.adGroupTimesMs = Arrays.copyOf(arr_v2, v15);
                this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, v15);
            }
            System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, v4, v14);
            System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, v4, v14);
            this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, v15);
        }
        this.updateProgress();
    }

    class com.google.android.exoplayer2.ui.PlayerControlView.1 {
    }

}

