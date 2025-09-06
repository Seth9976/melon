package com.google.android.exoplayer2.ui;

import N1.m;
import N1.z;
import Y2.c;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat.Token;
import androidx.core.app.NotificationCompat.Builder;
import androidx.media3.session.M;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerNotificationManager {
    public final class BitmapCallback {
        private final int notificationTag;

        private BitmapCallback(int v) {
            this.notificationTag = v;
        }

        public BitmapCallback(int v, com.google.android.exoplayer2.ui.PlayerNotificationManager.1 playerNotificationManager$10) {
            this(v);
        }

        public void onBitmap(Bitmap bitmap0) {
            if(bitmap0 != null) {
                PlayerNotificationManager.this.postUpdateNotificationBitmap(bitmap0, this.notificationTag);
            }
        }
    }

    public interface CustomActionReceiver {
        Map createCustomActions(Context arg1, int arg2);

        List getCustomActions(Player arg1);

        void onCustomAction(Player arg1, String arg2, Intent arg3);
    }

    public interface MediaDescriptionAdapter {
        PendingIntent createCurrentContentIntent(Player arg1);

        CharSequence getCurrentContentText(Player arg1);

        CharSequence getCurrentContentTitle(Player arg1);

        Bitmap getCurrentLargeIcon(Player arg1, BitmapCallback arg2);

        default CharSequence getCurrentSubText(Player player0) [...] // Inlined contents
    }

    class NotificationBroadcastReceiver extends BroadcastReceiver {
        private NotificationBroadcastReceiver() {
        }

        public NotificationBroadcastReceiver(com.google.android.exoplayer2.ui.PlayerNotificationManager.1 playerNotificationManager$10) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            Player player0 = PlayerNotificationManager.this.player;
            if(player0 != null && PlayerNotificationManager.this.isNotificationStarted && intent0.getIntExtra("INSTANCE_ID", PlayerNotificationManager.this.instanceId) == PlayerNotificationManager.this.instanceId) {
                String s = intent0.getAction();
                if("com.google.android.exoplayer.play".equals(s)) {
                    switch(player0.getPlaybackState()) {
                        case 1: {
                            if(PlayerNotificationManager.this.playbackPreparer != null) {
                                PlayerNotificationManager.this.playbackPreparer.preparePlayback();
                            }
                            break;
                        }
                        case 4: {
                            int v = player0.getCurrentWindowIndex();
                            PlayerNotificationManager.this.seekTo(player0, v, 0x8000000000000001L);
                        }
                    }
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(player0, true);
                    return;
                }
                if("com.google.android.exoplayer.pause".equals(s)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(player0, false);
                    return;
                }
                if("com.google.android.exoplayer.prev".equals(s)) {
                    PlayerNotificationManager.this.previous(player0);
                    return;
                }
                if("com.google.android.exoplayer.rewind".equals(s)) {
                    PlayerNotificationManager.this.rewind(player0);
                    return;
                }
                if("com.google.android.exoplayer.ffwd".equals(s)) {
                    PlayerNotificationManager.this.fastForward(player0);
                    return;
                }
                if("com.google.android.exoplayer.next".equals(s)) {
                    PlayerNotificationManager.this.next(player0);
                    return;
                }
                if("com.google.android.exoplayer.stop".equals(s)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchStop(player0, true);
                    return;
                }
                if("com.google.android.exoplayer.dismiss".equals(s)) {
                    PlayerNotificationManager.this.stopNotification(true);
                    return;
                }
                if(s != null && PlayerNotificationManager.this.customActionReceiver != null && PlayerNotificationManager.this.customActions.containsKey(s)) {
                    PlayerNotificationManager.this.customActionReceiver.onCustomAction(player0, s, intent0);
                }
            }
        }
    }

    public interface NotificationListener {
        @Deprecated
        default void onNotificationCancelled(int v) {
        }

        default void onNotificationCancelled(int v, boolean z) {
        }

        default void onNotificationPosted(int v, Notification notification0, boolean z) {
        }

        @Deprecated
        default void onNotificationStarted(int v, Notification notification0) {
        }
    }

    class PlayerListener implements EventListener {
        private PlayerListener() {
        }

        public PlayerListener(com.google.android.exoplayer2.ui.PlayerNotificationManager.1 playerNotificationManager$10) {
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onIsPlayingChanged(boolean z) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters0) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPlayerStateChanged(boolean z, int v) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPositionDiscontinuity(int v) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onRepeatModeChanged(int v) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onTimelineChanged(Timeline timeline0, int v) {
            PlayerNotificationManager.this.postStartOrUpdateNotification();
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    private static final String ACTION_DISMISS = "com.google.android.exoplayer.dismiss";
    public static final String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    private static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000L;
    private static final int MSG_START_OR_UPDATE_NOTIFICATION = 0;
    private static final int MSG_UPDATE_NOTIFICATION_BITMAP = 1;
    private int badgeIconType;
    private NotificationCompat.Builder builder;
    private ArrayList builderActions;
    private final String channelId;
    private int color;
    private boolean colorized;
    private final Context context;
    private ControlDispatcher controlDispatcher;
    private int currentNotificationTag;
    private final CustomActionReceiver customActionReceiver;
    private final Map customActions;
    private int defaults;
    private final PendingIntent dismissPendingIntent;
    private long fastForwardMs;
    private final int instanceId;
    private static int instanceIdCounter;
    private final IntentFilter intentFilter;
    private boolean isNotificationStarted;
    private final Handler mainHandler;
    private final MediaDescriptionAdapter mediaDescriptionAdapter;
    private Token mediaSessionToken;
    private final NotificationBroadcastReceiver notificationBroadcastReceiver;
    private final int notificationId;
    private NotificationListener notificationListener;
    private final z notificationManager;
    private final Map playbackActions;
    private PlaybackPreparer playbackPreparer;
    private Player player;
    private final EventListener playerListener;
    private int priority;
    private long rewindMs;
    private int smallIconResourceId;
    private boolean useChronometer;
    private boolean useNavigationActions;
    private boolean useNavigationActionsInCompactView;
    private boolean usePlayPauseActions;
    private boolean useStopAction;
    private int visibility;
    private final Window window;

    public PlayerNotificationManager(Context context0, String s, int v, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0) {
        this(context0, s, v, playerNotificationManager$MediaDescriptionAdapter0, null, null);
    }

    public PlayerNotificationManager(Context context0, String s, int v, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0, CustomActionReceiver playerNotificationManager$CustomActionReceiver0) {
        this(context0, s, v, playerNotificationManager$MediaDescriptionAdapter0, null, playerNotificationManager$CustomActionReceiver0);
    }

    public PlayerNotificationManager(Context context0, String s, int v, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0, NotificationListener playerNotificationManager$NotificationListener0) {
        this(context0, s, v, playerNotificationManager$MediaDescriptionAdapter0, playerNotificationManager$NotificationListener0, null);
    }

    public PlayerNotificationManager(Context context0, String s, int v, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0, NotificationListener playerNotificationManager$NotificationListener0, CustomActionReceiver playerNotificationManager$CustomActionReceiver0) {
        Context context1 = context0.getApplicationContext();
        this.context = context1;
        this.channelId = s;
        this.notificationId = v;
        this.mediaDescriptionAdapter = playerNotificationManager$MediaDescriptionAdapter0;
        this.notificationListener = playerNotificationManager$NotificationListener0;
        this.customActionReceiver = playerNotificationManager$CustomActionReceiver0;
        this.controlDispatcher = new DefaultControlDispatcher();
        this.window = new Window();
        int v1 = PlayerNotificationManager.instanceIdCounter;
        PlayerNotificationManager.instanceIdCounter = v1 + 1;
        this.instanceId = v1;
        this.mainHandler = Util.createHandler(Looper.getMainLooper(), new M(this, 2));
        this.notificationManager = new z(context1);
        this.playerListener = new PlayerListener(this, null);
        this.notificationBroadcastReceiver = new NotificationBroadcastReceiver(this, null);
        this.intentFilter = new IntentFilter();
        this.useNavigationActions = true;
        this.usePlayPauseActions = true;
        this.colorized = true;
        this.useChronometer = true;
        this.color = 0;
        this.smallIconResourceId = drawable.exo_notification_small_icon;
        this.defaults = 0;
        this.priority = -1;
        this.fastForwardMs = 15000L;
        this.rewindMs = 5000L;
        this.badgeIconType = 1;
        this.visibility = 1;
        Map map0 = PlayerNotificationManager.createPlaybackActions(context1, v1);
        this.playbackActions = map0;
        for(Object object0: map0.keySet()) {
            this.intentFilter.addAction(((String)object0));
        }
        Map map1 = playerNotificationManager$CustomActionReceiver0 == null ? Collections.EMPTY_MAP : playerNotificationManager$CustomActionReceiver0.createCustomActions(context1, this.instanceId);
        this.customActions = map1;
        for(Object object1: map1.keySet()) {
            this.intentFilter.addAction(((String)object1));
        }
        this.dismissPendingIntent = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.dismiss", context1, this.instanceId);
        this.intentFilter.addAction("com.google.android.exoplayer.dismiss");
    }

    public static boolean a(PlayerNotificationManager playerNotificationManager0, Message message0) {
        return playerNotificationManager0.lambda$new$0(message0);
    }

    private static PendingIntent createBroadcastIntent(String s, Context context0, int v) {
        Intent intent0 = new Intent(s).setPackage("com.iloen.melon");
        intent0.putExtra("INSTANCE_ID", v);
        return PendingIntent.getBroadcast(context0, v, intent0, 0x8000000);
    }

    public NotificationCompat.Builder createNotification(Player player0, NotificationCompat.Builder notificationCompat$Builder0, boolean z, Bitmap bitmap0) {
        if(player0.getPlaybackState() == 1 && (player0.getCurrentTimeline().isEmpty() || this.playbackPreparer == null)) {
            this.builderActions = null;
            return null;
        }
        List list0 = this.getActions(player0);
        ArrayList arrayList0 = new ArrayList(list0.size());
        for(int v = 0; v < list0.size(); ++v) {
            String s = (String)list0.get(v);
            m m0 = this.playbackActions.containsKey(s) ? ((m)this.playbackActions.get(s)) : ((m)this.customActions.get(s));
            if(m0 != null) {
                arrayList0.add(m0);
            }
        }
        if(notificationCompat$Builder0 == null || !arrayList0.equals(this.builderActions)) {
            notificationCompat$Builder0 = new NotificationCompat.Builder(this.context, this.channelId);
            this.builderActions = arrayList0;
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                m m1 = (m)arrayList0.get(v1);
                if(m1 != null) {
                    notificationCompat$Builder0.b.add(m1);
                }
            }
        }
        Notification notification0 = notificationCompat$Builder0.G;
        c c0 = new c();
        Token mediaSessionCompat$Token0 = this.mediaSessionToken;
        if(mediaSessionCompat$Token0 != null) {
            c0.e = mediaSessionCompat$Token0;
        }
        c0.d = this.getActionIndicesForCompactView(list0, player0);
        notificationCompat$Builder0.g(c0);
        notification0.deleteIntent = this.dismissPendingIntent;
        notificationCompat$Builder0.C = this.badgeIconType;
        notificationCompat$Builder0.e(2, z);
        notificationCompat$Builder0.z = this.color;
        notificationCompat$Builder0.v = this.colorized;
        notificationCompat$Builder0.w = true;
        notification0.icon = this.smallIconResourceId;
        notificationCompat$Builder0.A = this.visibility;
        notificationCompat$Builder0.j = this.priority;
        int v2 = this.defaults;
        Notification notification1 = notificationCompat$Builder0.G;
        notification1.defaults = v2;
        if((v2 & 4) != 0) {
            notification1.flags |= 1;
        }
        if(Util.SDK_INT < 21 || !this.useChronometer || !player0.isPlaying() || player0.isPlayingAd() || player0.isCurrentWindowDynamic() || player0.getPlaybackParameters().speed != 1.0f) {
            notificationCompat$Builder0.k = false;
            notificationCompat$Builder0.l = false;
        }
        else {
            notification0.when = System.currentTimeMillis() - player0.getContentPosition();
            notificationCompat$Builder0.k = true;
            notificationCompat$Builder0.l = true;
        }
        notificationCompat$Builder0.d(this.mediaDescriptionAdapter.getCurrentContentTitle(player0));
        notificationCompat$Builder0.c(this.mediaDescriptionAdapter.getCurrentContentText(player0));
        notificationCompat$Builder0.n = NotificationCompat.Builder.b(null);
        if(bitmap0 == null) {
            int v3 = this.currentNotificationTag + 1;
            this.currentNotificationTag = v3;
            BitmapCallback playerNotificationManager$BitmapCallback0 = new BitmapCallback(this, v3, null);
            bitmap0 = this.mediaDescriptionAdapter.getCurrentLargeIcon(player0, playerNotificationManager$BitmapCallback0);
        }
        PlayerNotificationManager.setLargeIcon(notificationCompat$Builder0, bitmap0);
        notificationCompat$Builder0.g = this.mediaDescriptionAdapter.createCurrentContentIntent(player0);
        return notificationCompat$Builder0;
    }

    private static Map createPlaybackActions(Context context0, int v) {
        Map map0 = new HashMap();
        String s = context0.getString(string.exo_controls_play_description);
        PendingIntent pendingIntent0 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.play", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.play", new m(drawable.exo_notification_play, s, pendingIntent0));
        String s1 = context0.getString(string.exo_controls_pause_description);
        PendingIntent pendingIntent1 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.pause", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.pause", new m(drawable.exo_notification_pause, s1, pendingIntent1));
        String s2 = context0.getString(string.exo_controls_stop_description);
        PendingIntent pendingIntent2 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.stop", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.stop", new m(drawable.exo_notification_stop, s2, pendingIntent2));
        String s3 = context0.getString(string.exo_controls_rewind_description);
        PendingIntent pendingIntent3 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.rewind", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.rewind", new m(drawable.exo_notification_rewind, s3, pendingIntent3));
        String s4 = context0.getString(string.exo_controls_fastforward_description);
        PendingIntent pendingIntent4 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.ffwd", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.ffwd", new m(drawable.exo_notification_fastforward, s4, pendingIntent4));
        String s5 = context0.getString(string.exo_controls_previous_description);
        PendingIntent pendingIntent5 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.prev", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.prev", new m(drawable.exo_notification_previous, s5, pendingIntent5));
        String s6 = context0.getString(string.exo_controls_next_description);
        PendingIntent pendingIntent6 = PlayerNotificationManager.createBroadcastIntent("com.google.android.exoplayer.next", context0, v);
        ((HashMap)map0).put("com.google.android.exoplayer.next", new m(drawable.exo_notification_next, s6, pendingIntent6));
        return map0;
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context0, String s, int v, int v1, int v2, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0) {
        NotificationUtil.createNotificationChannel(context0, s, v, v1, 2);
        return new PlayerNotificationManager(context0, s, v2, playerNotificationManager$MediaDescriptionAdapter0);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context0, String s, int v, int v1, int v2, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0, NotificationListener playerNotificationManager$NotificationListener0) {
        NotificationUtil.createNotificationChannel(context0, s, v, v1, 2);
        return new PlayerNotificationManager(context0, s, v2, playerNotificationManager$MediaDescriptionAdapter0, playerNotificationManager$NotificationListener0);
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context0, String s, int v, int v1, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0) {
        return PlayerNotificationManager.createWithNotificationChannel(context0, s, v, 0, v1, playerNotificationManager$MediaDescriptionAdapter0);
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context0, String s, int v, int v1, MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter0, NotificationListener playerNotificationManager$NotificationListener0) {
        return PlayerNotificationManager.createWithNotificationChannel(context0, s, v, 0, v1, playerNotificationManager$MediaDescriptionAdapter0, playerNotificationManager$NotificationListener0);
    }

    private void fastForward(Player player0) {
        if(player0.isCurrentWindowSeekable()) {
            long v = this.fastForwardMs;
            if(v > 0L) {
                this.seekToOffset(player0, v);
            }
        }
    }

    public int[] getActionIndicesForCompactView(List list0, Player player0) {
        int v = list0.indexOf("com.google.android.exoplayer.pause");
        int v1 = list0.indexOf("com.google.android.exoplayer.play");
        int v2 = this.useNavigationActionsInCompactView ? list0.indexOf("com.google.android.exoplayer.prev") : -1;
        int v3 = this.useNavigationActionsInCompactView ? list0.indexOf("com.google.android.exoplayer.next") : -1;
        int[] arr_v = new int[3];
        int v4 = 0;
        if(v2 != -1) {
            arr_v[0] = v2;
            v4 = 1;
        }
        boolean z = this.shouldShowPauseButton(player0);
        if(v != -1 && z) {
            arr_v[v4] = v;
            ++v4;
        }
        else if(v1 != -1 && !z) {
            arr_v[v4] = v1;
            ++v4;
        }
        if(v3 != -1) {
            arr_v[v4] = v3;
            ++v4;
        }
        return Arrays.copyOf(arr_v, v4);
    }

    public List getActions(Player player0) {
        int v3;
        boolean z1;
        boolean z;
        Timeline timeline0 = player0.getCurrentTimeline();
        int v = 0;
        if(timeline0.isEmpty() || player0.isPlayingAd()) {
            v3 = 0;
            z = false;
            z1 = false;
        }
        else {
            timeline0.getWindow(player0.getCurrentWindowIndex(), this.window);
            int v1 = this.window.isSeekable || !this.window.isDynamic || player0.hasPrevious() ? 1 : 0;
            z = this.rewindMs > 0L;
            z1 = this.fastForwardMs > 0L;
            if(this.window.isDynamic || player0.hasNext()) {
                v = 1;
            }
            int v2 = v;
            v = v1;
            v3 = v2;
        }
        List list0 = new ArrayList();
        if(this.useNavigationActions && v != 0) {
            ((ArrayList)list0).add("com.google.android.exoplayer.prev");
        }
        if(z) {
            ((ArrayList)list0).add("com.google.android.exoplayer.rewind");
        }
        if(this.usePlayPauseActions) {
            if(this.shouldShowPauseButton(player0)) {
                ((ArrayList)list0).add("com.google.android.exoplayer.pause");
            }
            else {
                ((ArrayList)list0).add("com.google.android.exoplayer.play");
            }
        }
        if(z1) {
            ((ArrayList)list0).add("com.google.android.exoplayer.ffwd");
        }
        if(this.useNavigationActions && v3 != 0) {
            ((ArrayList)list0).add("com.google.android.exoplayer.next");
        }
        CustomActionReceiver playerNotificationManager$CustomActionReceiver0 = this.customActionReceiver;
        if(playerNotificationManager$CustomActionReceiver0 != null) {
            ((ArrayList)list0).addAll(playerNotificationManager$CustomActionReceiver0.getCustomActions(player0));
        }
        if(this.useStopAction) {
            ((ArrayList)list0).add("com.google.android.exoplayer.stop");
        }
        return list0;
    }

    public boolean getOngoing(Player player0) {
        switch(player0.getPlaybackState()) {
            case 2: 
            case 3: {
                return player0.getPlayWhenReady();
            }
            default: {
                return false;
            }
        }
    }

    private boolean handleMessage(Message message0) {
        switch(message0.what) {
            case 0: {
                Player player0 = this.player;
                if(player0 != null) {
                    this.startOrUpdateNotification(player0, null);
                    return true;
                }
                break;
            }
            case 1: {
                Player player1 = this.player;
                if(player1 != null && this.isNotificationStarted && this.currentNotificationTag == message0.arg1) {
                    this.startOrUpdateNotification(player1, ((Bitmap)message0.obj));
                    return true;
                }
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    public void invalidate() {
        if(this.isNotificationStarted) {
            this.postStartOrUpdateNotification();
        }
    }

    private boolean lambda$new$0(Message message0) {
        return this.handleMessage(message0);
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

    private void postStartOrUpdateNotification() {
        if(!this.mainHandler.hasMessages(0)) {
            this.mainHandler.sendEmptyMessage(0);
        }
    }

    private void postUpdateNotificationBitmap(Bitmap bitmap0, int v) {
        this.mainHandler.obtainMessage(1, v, -1, bitmap0).sendToTarget();
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

    private void rewind(Player player0) {
        if(player0.isCurrentWindowSeekable()) {
            long v = this.rewindMs;
            if(v > 0L) {
                this.seekToOffset(player0, -v);
            }
        }
    }

    private void seekTo(Player player0, int v, long v1) {
        this.controlDispatcher.dispatchSeekTo(player0, v, v1);
    }

    private void seekToOffset(Player player0, long v) {
        long v1 = player0.getCurrentPosition() + v;
        long v2 = player0.getDuration();
        if(v2 != 0x8000000000000001L) {
            v1 = Math.min(v1, v2);
        }
        this.seekTo(player0, player0.getCurrentWindowIndex(), Math.max(v1, 0L));
    }

    public final void setBadgeIconType(int v) {
        if(this.badgeIconType == v) {
            return;
        }
        if(v != 0 && v != 1 && v != 2) {
            throw new IllegalArgumentException();
        }
        this.badgeIconType = v;
        this.invalidate();
    }

    public final void setColor(int v) {
        if(this.color != v) {
            this.color = v;
            this.invalidate();
        }
    }

    public final void setColorized(boolean z) {
        if(this.colorized != z) {
            this.colorized = z;
            this.invalidate();
        }
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher0) {
        if(controlDispatcher0 == null) {
            controlDispatcher0 = new DefaultControlDispatcher();
        }
        this.controlDispatcher = controlDispatcher0;
    }

    public final void setDefaults(int v) {
        if(this.defaults != v) {
            this.defaults = v;
            this.invalidate();
        }
    }

    public final void setFastForwardIncrementMs(long v) {
        if(this.fastForwardMs == v) {
            return;
        }
        this.fastForwardMs = v;
        this.invalidate();
    }

    private static void setLargeIcon(NotificationCompat.Builder notificationCompat$Builder0, Bitmap bitmap0) {
        notificationCompat$Builder0.f(bitmap0);
    }

    public final void setMediaSessionToken(Token mediaSessionCompat$Token0) {
        if(!Util.areEqual(this.mediaSessionToken, mediaSessionCompat$Token0)) {
            this.mediaSessionToken = mediaSessionCompat$Token0;
            this.invalidate();
        }
    }

    @Deprecated
    public final void setNotificationListener(NotificationListener playerNotificationManager$NotificationListener0) {
        this.notificationListener = playerNotificationManager$NotificationListener0;
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer0) {
        this.playbackPreparer = playbackPreparer0;
    }

    public final void setPlayer(Player player0) {
        boolean z = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if(player0 != null && player0.getApplicationLooper() != Looper.getMainLooper()) {
            z = false;
        }
        Assertions.checkArgument(z);
        Player player1 = this.player;
        if(player1 != player0) {
            if(player1 != null) {
                player1.removeListener(this.playerListener);
                if(player0 == null) {
                    this.stopNotification(false);
                }
            }
            this.player = player0;
            if(player0 != null) {
                player0.addListener(this.playerListener);
                this.postStartOrUpdateNotification();
            }
        }
    }

    public final void setPriority(int v) {
        if(this.priority == v) {
            return;
        }
        if(v != -2 && (v != -1 && v != 0) && (v != 1 && v != 2)) {
            throw new IllegalArgumentException();
        }
        this.priority = v;
        this.invalidate();
    }

    public final void setRewindIncrementMs(long v) {
        if(this.rewindMs == v) {
            return;
        }
        this.rewindMs = v;
        this.invalidate();
    }

    public final void setSmallIcon(int v) {
        if(this.smallIconResourceId != v) {
            this.smallIconResourceId = v;
            this.invalidate();
        }
    }

    public final void setUseChronometer(boolean z) {
        if(this.useChronometer != z) {
            this.useChronometer = z;
            this.invalidate();
        }
    }

    public final void setUseNavigationActions(boolean z) {
        if(this.useNavigationActions != z) {
            this.useNavigationActions = z;
            this.invalidate();
        }
    }

    public final void setUseNavigationActionsInCompactView(boolean z) {
        if(this.useNavigationActionsInCompactView != z) {
            this.useNavigationActionsInCompactView = z;
            this.invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z) {
        if(this.usePlayPauseActions != z) {
            this.usePlayPauseActions = z;
            this.invalidate();
        }
    }

    public final void setUseStopAction(boolean z) {
        if(this.useStopAction == z) {
            return;
        }
        this.useStopAction = z;
        this.invalidate();
    }

    public final void setVisibility(int v) {
        if(this.visibility == v) {
            return;
        }
        if(v != -1 && v != 0 && v != 1) {
            throw new IllegalStateException();
        }
        this.visibility = v;
        this.invalidate();
    }

    private boolean shouldShowPauseButton(Player player0) {
        switch(player0.getPlaybackState()) {
            case 1: 
            case 4: {
                return false;
            }
            default: {
                return player0.getPlayWhenReady();
            }
        }
    }

    private void startOrUpdateNotification(Player player0, Bitmap bitmap0) {
        boolean z = this.getOngoing(player0);
        NotificationCompat.Builder notificationCompat$Builder0 = this.createNotification(player0, this.builder, z, bitmap0);
        this.builder = notificationCompat$Builder0;
        if(notificationCompat$Builder0 == null) {
            this.stopNotification(false);
            return;
        }
        Notification notification0 = notificationCompat$Builder0.a();
        this.notificationManager.a(this.notificationId, notification0);
        if(!this.isNotificationStarted) {
            this.isNotificationStarted = true;
            this.context.registerReceiver(this.notificationBroadcastReceiver, this.intentFilter);
        }
    }

    private void stopNotification(boolean z) {
        if(this.isNotificationStarted) {
            this.isNotificationStarted = false;
            this.mainHandler.removeMessages(0);
            this.notificationManager.b.cancel(null, this.notificationId);
            this.context.unregisterReceiver(this.notificationBroadcastReceiver);
        }
    }

    class com.google.android.exoplayer2.ui.PlayerNotificationManager.1 {
    }

}

