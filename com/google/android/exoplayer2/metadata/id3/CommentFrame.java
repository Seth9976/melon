package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.util.Util;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    static {
        CommentFrame.CREATOR = new Parcelable.Creator() {
            public CommentFrame createFromParcel(Parcel parcel0) {
                return new CommentFrame(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public CommentFrame[] newArray(int v) {
                return new CommentFrame[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public CommentFrame(Parcel parcel0) {
        super("COMM");
        this.language = (String)Util.castNonNull(parcel0.readString());
        this.description = (String)Util.castNonNull(parcel0.readString());
        this.text = (String)Util.castNonNull(parcel0.readString());
    }

    public CommentFrame(String s, String s1, String s2) {
        super("COMM");
        this.language = s;
        this.description = s1;
        this.text = s2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return CommentFrame.class == class0 && Util.areEqual(this.description, ((CommentFrame)object0).description) && Util.areEqual(this.language, ((CommentFrame)object0).language) && Util.areEqual(this.text, ((CommentFrame)object0).text);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.language == null ? 0 : this.language.hashCode();
        int v2 = this.description == null ? 0 : this.description.hashCode();
        String s = this.text;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 + 0x20F) * 0x1F + v2) * 0x1F + v;
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(25, this.id), this.language), this.description), this.id, ": language=", this.language, ", description=");
        stringBuilder0.append(this.description);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.language);
        parcel0.writeString(this.text);
    }
}

