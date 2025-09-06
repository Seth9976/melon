package androidx.media3.session.legacy;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.view.KeyEvent;
import java.util.List;

public interface f extends IInterface {
    void A0(d arg1);

    void L(String arg1, Bundle arg2, MediaSessionCompat.ResultReceiverWrapper arg3);

    void Q(RatingCompat arg1);

    void T(RatingCompat arg1, Bundle arg2);

    void adjustVolume(int arg1, int arg2);

    void c(MediaDescriptionCompat arg1, int arg2);

    void f0(MediaDescriptionCompat arg1);

    void fastForward();

    Bundle getExtras();

    long getFlags();

    PendingIntent getLaunchPendingIntent();

    MediaMetadataCompat getMetadata();

    String getPackageName();

    PlaybackStateCompat getPlaybackState();

    List getQueue();

    CharSequence getQueueTitle();

    int getRatingType();

    int getRepeatMode();

    Bundle getSessionInfo();

    int getShuffleMode();

    String getTag();

    ParcelableVolumeInfo getVolumeAttributes();

    boolean isCaptioningEnabled();

    boolean isTransportControlEnabled();

    void j0(d arg1);

    void k0(MediaDescriptionCompat arg1);

    void next();

    void pause();

    void play();

    void playFromMediaId(String arg1, Bundle arg2);

    void playFromSearch(String arg1, Bundle arg2);

    void playFromUri(Uri arg1, Bundle arg2);

    void prepare();

    void prepareFromMediaId(String arg1, Bundle arg2);

    void prepareFromSearch(String arg1, Bundle arg2);

    void prepareFromUri(Uri arg1, Bundle arg2);

    void previous();

    void removeQueueItemAt(int arg1);

    void rewind();

    void seekTo(long arg1);

    void sendCustomAction(String arg1, Bundle arg2);

    boolean sendMediaButton(KeyEvent arg1);

    void setCaptioningEnabled(boolean arg1);

    void setPlaybackSpeed(float arg1);

    void setRepeatMode(int arg1);

    void setShuffleMode(int arg1);

    void setVolumeTo(int arg1, int arg2);

    void skipToQueueItem(long arg1);

    void stop();
}

