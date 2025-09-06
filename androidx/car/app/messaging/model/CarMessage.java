package androidx.car.app.messaging.model;

import N1.C;
import android.net.Uri;
import android.os.Bundle;
import androidx.car.app.model.CarText;
import java.util.Objects;

public class CarMessage {
    private final CarText mBody;
    private final boolean mIsRead;
    private final String mMultimediaMimeType;
    private final Uri mMultimediaUri;
    private final long mReceivedTimeEpochMillis;
    private final Bundle mSender;

    private CarMessage() {
        this.mSender = null;
        this.mBody = null;
        this.mMultimediaMimeType = null;
        this.mMultimediaUri = null;
        this.mReceivedTimeEpochMillis = 0L;
        this.mIsRead = false;
    }

    public CarMessage(a a0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CarMessage ? y5.a.j(this.getSender(), ((CarMessage)object0).getSender()) && Objects.equals(this.mBody, ((CarMessage)object0).mBody) && this.mReceivedTimeEpochMillis == ((CarMessage)object0).mReceivedTimeEpochMillis && this.mIsRead == ((CarMessage)object0).mIsRead : false;
    }

    public CarText getBody() {
        return this.mBody;
    }

    public String getMultimediaMimeType() {
        return this.mMultimediaMimeType;
    }

    public Uri getMultimediaUri() {
        return this.mMultimediaUri;
    }

    public long getReceivedTimeEpochMillis() {
        return this.mReceivedTimeEpochMillis;
    }

    public C getSender() {
        return this.mSender == null ? null : C.a(this.mSender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{y5.a.I(this.getSender()), this.mBody, this.mReceivedTimeEpochMillis, Boolean.valueOf(this.mIsRead)});
    }

    public boolean isRead() {
        return this.mIsRead;
    }
}

