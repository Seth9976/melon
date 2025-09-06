package android.support.v4.media.session;

import U4.x;
import android.annotation.SuppressLint;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    static class Api21Impl {
        public static void addCustomAction(PlaybackState.Builder playbackState$Builder0, PlaybackState.CustomAction playbackState$CustomAction0) {
            playbackState$Builder0.addCustomAction(playbackState$CustomAction0);
        }

        public static PlaybackState.CustomAction build(PlaybackState.CustomAction.Builder playbackState$CustomAction$Builder0) {
            return playbackState$CustomAction$Builder0.build();
        }

        public static PlaybackState build(PlaybackState.Builder playbackState$Builder0) {
            return playbackState$Builder0.build();
        }

        public static PlaybackState.Builder createBuilder() {
            return new PlaybackState.Builder();
        }

        public static PlaybackState.CustomAction.Builder createCustomActionBuilder(String s, CharSequence charSequence0, int v) {
            return new PlaybackState.CustomAction.Builder(s, charSequence0, v);
        }

        public static String getAction(PlaybackState.CustomAction playbackState$CustomAction0) {
            return playbackState$CustomAction0.getAction();
        }

        public static long getActions(PlaybackState playbackState0) {
            return playbackState0.getActions();
        }

        public static long getActiveQueueItemId(PlaybackState playbackState0) {
            return playbackState0.getActiveQueueItemId();
        }

        public static long getBufferedPosition(PlaybackState playbackState0) {
            return playbackState0.getBufferedPosition();
        }

        public static List getCustomActions(PlaybackState playbackState0) {
            return playbackState0.getCustomActions();
        }

        public static CharSequence getErrorMessage(PlaybackState playbackState0) {
            return playbackState0.getErrorMessage();
        }

        public static Bundle getExtras(PlaybackState.CustomAction playbackState$CustomAction0) {
            return playbackState$CustomAction0.getExtras();
        }

        public static int getIcon(PlaybackState.CustomAction playbackState$CustomAction0) {
            return playbackState$CustomAction0.getIcon();
        }

        public static long getLastPositionUpdateTime(PlaybackState playbackState0) {
            return playbackState0.getLastPositionUpdateTime();
        }

        public static CharSequence getName(PlaybackState.CustomAction playbackState$CustomAction0) {
            return playbackState$CustomAction0.getName();
        }

        public static float getPlaybackSpeed(PlaybackState playbackState0) {
            return playbackState0.getPlaybackSpeed();
        }

        public static long getPosition(PlaybackState playbackState0) {
            return playbackState0.getPosition();
        }

        public static int getState(PlaybackState playbackState0) {
            return playbackState0.getState();
        }

        public static void setActions(PlaybackState.Builder playbackState$Builder0, long v) {
            playbackState$Builder0.setActions(v);
        }

        public static void setActiveQueueItemId(PlaybackState.Builder playbackState$Builder0, long v) {
            playbackState$Builder0.setActiveQueueItemId(v);
        }

        public static void setBufferedPosition(PlaybackState.Builder playbackState$Builder0, long v) {
            playbackState$Builder0.setBufferedPosition(v);
        }

        public static void setErrorMessage(PlaybackState.Builder playbackState$Builder0, CharSequence charSequence0) {
            playbackState$Builder0.setErrorMessage(charSequence0);
        }

        public static void setExtras(PlaybackState.CustomAction.Builder playbackState$CustomAction$Builder0, Bundle bundle0) {
            playbackState$CustomAction$Builder0.setExtras(bundle0);
        }

        public static void setState(PlaybackState.Builder playbackState$Builder0, int v, long v1, float f, long v2) {
            playbackState$Builder0.setState(v, v1, f, v2);
        }
    }

    static class Api22Impl {
        public static Bundle getExtras(PlaybackState playbackState0) {
            return playbackState0.getExtras();
        }

        public static void setExtras(PlaybackState.Builder playbackState$Builder0, Bundle bundle0) {
            playbackState$Builder0.setExtras(bundle0);
        }
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final List mCustomActions;
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1L;
        }

        public Builder(PlaybackStateCompat playbackStateCompat0) {
            ArrayList arrayList0 = new ArrayList();
            this.mCustomActions = arrayList0;
            this.mActiveItemId = -1L;
            this.mState = playbackStateCompat0.mState;
            this.mPosition = playbackStateCompat0.mPosition;
            this.mRate = playbackStateCompat0.mSpeed;
            this.mUpdateTime = playbackStateCompat0.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat0.mBufferedPosition;
            this.mActions = playbackStateCompat0.mActions;
            this.mErrorCode = playbackStateCompat0.mErrorCode;
            this.mErrorMessage = playbackStateCompat0.mErrorMessage;
            List list0 = playbackStateCompat0.mCustomActions;
            if(list0 != null) {
                arrayList0.addAll(list0);
            }
            this.mActiveItemId = playbackStateCompat0.mActiveItemId;
            this.mExtras = playbackStateCompat0.mExtras;
        }

        public Builder addCustomAction(CustomAction playbackStateCompat$CustomAction0) {
            if(playbackStateCompat$CustomAction0 == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
            }
            this.mCustomActions.add(playbackStateCompat$CustomAction0);
            return this;
        }

        public Builder addCustomAction(String s, String s1, int v) {
            return this.addCustomAction(new CustomAction(s, s1, v, null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }

        public Builder setActions(long v) {
            this.mActions = v;
            return this;
        }

        public Builder setActiveQueueItemId(long v) {
            this.mActiveItemId = v;
            return this;
        }

        public Builder setBufferedPosition(long v) {
            this.mBufferedPosition = v;
            return this;
        }

        public Builder setErrorMessage(int v, CharSequence charSequence0) {
            this.mErrorCode = v;
            this.mErrorMessage = charSequence0;
            return this;
        }

        @Deprecated
        public Builder setErrorMessage(CharSequence charSequence0) {
            this.mErrorMessage = charSequence0;
            return this;
        }

        public Builder setExtras(Bundle bundle0) {
            this.mExtras = bundle0;
            return this;
        }

        public Builder setState(int v, long v1, float f) {
            return this.setState(v, v1, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int v, long v1, float f, long v2) {
            this.mState = v;
            this.mPosition = v1;
            this.mUpdateTime = v2;
            this.mRate = f;
            return this;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final class android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder(String s, CharSequence charSequence0, int v) {
                if(TextUtils.isEmpty(s)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                }
                if(TextUtils.isEmpty(charSequence0)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                if(v == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                }
                this.mAction = s;
                this.mName = charSequence0;
                this.mIcon = v;
            }

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }

            public android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder setExtras(Bundle bundle0) {
                this.mExtras = bundle0;
                return this;
            }
        }

        public static final Parcelable.Creator CREATOR;
        private final String mAction;
        private PlaybackState.CustomAction mCustomActionFwk;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        static {
            CustomAction.CREATOR = new Parcelable.Creator() {
                public CustomAction createFromParcel(Parcel parcel0) {
                    return new CustomAction(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public CustomAction[] newArray(int v) {
                    return new CustomAction[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public CustomAction(Parcel parcel0) {
            this.mAction = parcel0.readString();
            this.mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
            this.mIcon = parcel0.readInt();
            this.mExtras = parcel0.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public CustomAction(String s, CharSequence charSequence0, int v, Bundle bundle0) {
            this.mAction = s;
            this.mName = charSequence0;
            this.mIcon = v;
            this.mExtras = bundle0;
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object object0) {
            if(object0 != null) {
                Bundle bundle0 = Api21Impl.getExtras(((PlaybackState.CustomAction)object0));
                MediaSessionCompat.ensureClassLoader(bundle0);
                CustomAction playbackStateCompat$CustomAction0 = new CustomAction(Api21Impl.getAction(((PlaybackState.CustomAction)object0)), Api21Impl.getName(((PlaybackState.CustomAction)object0)), Api21Impl.getIcon(((PlaybackState.CustomAction)object0)), bundle0);
                playbackStateCompat$CustomAction0.mCustomActionFwk = (PlaybackState.CustomAction)object0;
                return playbackStateCompat$CustomAction0;
            }
            return null;
        }

        public String getAction() {
            return this.mAction;
        }

        public Object getCustomAction() {
            PlaybackState.CustomAction playbackState$CustomAction0 = this.mCustomActionFwk;
            if(playbackState$CustomAction0 == null) {
                PlaybackState.CustomAction.Builder playbackState$CustomAction$Builder0 = Api21Impl.createCustomActionBuilder(this.mAction, this.mName, this.mIcon);
                Api21Impl.setExtras(playbackState$CustomAction$Builder0, this.mExtras);
                return Api21Impl.build(playbackState$CustomAction$Builder0);
            }
            return playbackState$CustomAction0;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        @Override
        public String toString() {
            return "Action:mName=\'" + this.mName + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel0, v);
            parcel0.writeInt(this.mIcon);
            parcel0.writeBundle(this.mExtras);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static final long ACTION_FAST_FORWARD = 0x40L;
    public static final long ACTION_PAUSE = 2L;
    public static final long ACTION_PLAY = 4L;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 0x400L;
    public static final long ACTION_PLAY_FROM_SEARCH = 0x800L;
    public static final long ACTION_PLAY_FROM_URI = 0x2000L;
    public static final long ACTION_PLAY_PAUSE = 0x200L;
    public static final long ACTION_PREPARE = 0x4000L;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 0x8000L;
    public static final long ACTION_PREPARE_FROM_SEARCH = 0x10000L;
    public static final long ACTION_PREPARE_FROM_URI = 0x20000L;
    public static final long ACTION_REWIND = 8L;
    public static final long ACTION_SEEK_TO = 0x100L;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 0x100000L;
    public static final long ACTION_SET_PLAYBACK_SPEED = 0x400000L;
    public static final long ACTION_SET_RATING = 0x80L;
    public static final long ACTION_SET_REPEAT_MODE = 0x40000L;
    public static final long ACTION_SET_SHUFFLE_MODE = 0x200000L;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 0x80000L;
    public static final long ACTION_SKIP_TO_NEXT = 0x20L;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 0x1000L;
    public static final long ACTION_STOP = 1L;
    public static final Parcelable.Creator CREATOR = null;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 0x7F;
    private static final int KEYCODE_MEDIA_PLAY = 0x7E;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private PlaybackState mStateFwk;
    final long mUpdateTime;

    static {
        PlaybackStateCompat.CREATOR = new Parcelable.Creator() {
            public PlaybackStateCompat createFromParcel(Parcel parcel0) {
                return new PlaybackStateCompat(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public PlaybackStateCompat[] newArray(int v) {
                return new PlaybackStateCompat[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public PlaybackStateCompat(int v, long v1, long v2, float f, long v3, int v4, CharSequence charSequence0, long v5, List list0, long v6, Bundle bundle0) {
        this.mState = v;
        this.mPosition = v1;
        this.mBufferedPosition = v2;
        this.mSpeed = f;
        this.mActions = v3;
        this.mErrorCode = v4;
        this.mErrorMessage = charSequence0;
        this.mUpdateTime = v5;
        this.mCustomActions = new ArrayList(list0);
        this.mActiveItemId = v6;
        this.mExtras = bundle0;
    }

    public PlaybackStateCompat(Parcel parcel0) {
        this.mState = parcel0.readInt();
        this.mPosition = parcel0.readLong();
        this.mSpeed = parcel0.readFloat();
        this.mUpdateTime = parcel0.readLong();
        this.mBufferedPosition = parcel0.readLong();
        this.mActions = parcel0.readLong();
        this.mErrorMessage = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        this.mCustomActions = parcel0.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel0.readLong();
        this.mExtras = parcel0.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = parcel0.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static PlaybackStateCompat fromPlaybackState(Object object0) {
        ArrayList arrayList0 = null;
        if(object0 != null) {
            List list0 = Api21Impl.getCustomActions(((PlaybackState)object0));
            if(list0 != null) {
                arrayList0 = new ArrayList(list0.size());
                for(Object object1: list0) {
                    arrayList0.add(CustomAction.fromCustomAction(object1));
                }
            }
            Bundle bundle0 = Api22Impl.getExtras(((PlaybackState)object0));
            MediaSessionCompat.ensureClassLoader(bundle0);
            PlaybackStateCompat playbackStateCompat0 = new PlaybackStateCompat(Api21Impl.getState(((PlaybackState)object0)), Api21Impl.getPosition(((PlaybackState)object0)), Api21Impl.getBufferedPosition(((PlaybackState)object0)), Api21Impl.getPlaybackSpeed(((PlaybackState)object0)), Api21Impl.getActions(((PlaybackState)object0)), 0, Api21Impl.getErrorMessage(((PlaybackState)object0)), Api21Impl.getLastPositionUpdateTime(((PlaybackState)object0)), arrayList0, Api21Impl.getActiveQueueItemId(((PlaybackState)object0)), bundle0);
            playbackStateCompat0.mStateFwk = (PlaybackState)object0;
            return playbackStateCompat0;
        }
        return null;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public long getCurrentPosition(Long long0) {
        return long0 == null ? Math.max(0L, this.mPosition + ((long)(this.mSpeed * ((float)(SystemClock.elapsedRealtime() - this.mUpdateTime))))) : Math.max(0L, this.mPosition + ((long)(this.mSpeed * ((float)(((long)long0))))));
    }

    public List getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        if(this.mStateFwk == null) {
            PlaybackState.Builder playbackState$Builder0 = Api21Impl.createBuilder();
            Api21Impl.setState(playbackState$Builder0, this.mState, this.mPosition, this.mSpeed, this.mUpdateTime);
            Api21Impl.setBufferedPosition(playbackState$Builder0, this.mBufferedPosition);
            Api21Impl.setActions(playbackState$Builder0, this.mActions);
            Api21Impl.setErrorMessage(playbackState$Builder0, this.mErrorMessage);
            for(Object object0: this.mCustomActions) {
                Api21Impl.addCustomAction(playbackState$Builder0, ((PlaybackState.CustomAction)((CustomAction)object0).getCustomAction()));
            }
            Api21Impl.setActiveQueueItemId(playbackState$Builder0, this.mActiveItemId);
            Api22Impl.setExtras(playbackState$Builder0, this.mExtras);
            this.mStateFwk = Api21Impl.build(playbackState$Builder0);
        }
        return this.mStateFwk;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public static int toKeyCode(long v) {
        if(v == 4L) {
            return 0x7E;
        }
        if(v == 2L) {
            return 0x7F;
        }
        if(v == 0x20L) {
            return 87;
        }
        if(v == 16L) {
            return 88;
        }
        if(v == 1L) {
            return 86;
        }
        if(v == 0x40L) {
            return 90;
        }
        if(v == 8L) {
            return 89;
        }
        return v == 0x200L ? 85 : 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PlaybackState {state=");
        stringBuilder0.append(this.mState);
        stringBuilder0.append(", position=");
        stringBuilder0.append(this.mPosition);
        stringBuilder0.append(", buffered position=");
        stringBuilder0.append(this.mBufferedPosition);
        stringBuilder0.append(", speed=");
        stringBuilder0.append(this.mSpeed);
        stringBuilder0.append(", updated=");
        stringBuilder0.append(this.mUpdateTime);
        stringBuilder0.append(", actions=");
        stringBuilder0.append(this.mActions);
        stringBuilder0.append(", error code=");
        stringBuilder0.append(this.mErrorCode);
        stringBuilder0.append(", error message=");
        stringBuilder0.append(this.mErrorMessage);
        stringBuilder0.append(", custom actions=");
        stringBuilder0.append(this.mCustomActions);
        stringBuilder0.append(", active item id=");
        return x.h(this.mActiveItemId, "}", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.mState);
        parcel0.writeLong(this.mPosition);
        parcel0.writeFloat(this.mSpeed);
        parcel0.writeLong(this.mUpdateTime);
        parcel0.writeLong(this.mBufferedPosition);
        parcel0.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel0, v);
        parcel0.writeTypedList(this.mCustomActions);
        parcel0.writeLong(this.mActiveItemId);
        parcel0.writeBundle(this.mExtras);
        parcel0.writeInt(this.mErrorCode);
    }
}

