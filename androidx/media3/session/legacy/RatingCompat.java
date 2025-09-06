package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;

@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final float b;
    public Object c;

    static {
        RatingCompat.CREATOR = new U(8);
    }

    public RatingCompat(int v, float f) {
        this.a = v;
        this.b = f;
    }

    public static RatingCompat a(Parcelable parcelable0) {
        RatingCompat ratingCompat0 = null;
        if(parcelable0 != null) {
            int v = ((Rating)parcelable0).getRatingStyle();
            if(((Rating)parcelable0).isRated()) {
                float f = 0.0f;
                switch(v) {
                    case 1: {
                        if(((Rating)parcelable0).hasHeart()) {
                            f = 1.0f;
                        }
                        ratingCompat0 = new RatingCompat(1, f);
                        break;
                    }
                    case 2: {
                        if(((Rating)parcelable0).isThumbUp()) {
                            f = 1.0f;
                        }
                        ratingCompat0 = new RatingCompat(2, f);
                        break;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        ratingCompat0 = RatingCompat.j(((Rating)parcelable0).getStarRating(), v);
                        break;
                    }
                    case 6: {
                        ratingCompat0 = RatingCompat.h(((Rating)parcelable0).getPercentRating());
                        break;
                    }
                    default: {
                        return null;
                    }
                }
            }
            else {
                switch(v) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: {
                        ratingCompat0 = new RatingCompat(v, -1.0f);
                    }
                }
            }
            ratingCompat0.getClass();
            ratingCompat0.c = parcelable0;
        }
        return ratingCompat0;
    }

    public final float d() {
        return this.a != 3 && this.a != 4 && this.a != 5 || !this.e() ? -1.0f : this.b;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return this.a;
    }

    public final boolean e() {
        return this.b >= 0.0f;
    }

    public static RatingCompat h(float f) {
        if(f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat j(float f, int v) {
        float f1;
        switch(v) {
            case 3: {
                f1 = 3.0f;
                break;
            }
            case 4: {
                f1 = 4.0f;
                break;
            }
            case 5: {
                f1 = 5.0f;
                break;
            }
            default: {
                Log.e("Rating", "Invalid rating style (" + v + ") for a star rating");
                return null;
            }
        }
        if(f >= 0.0f && f <= f1) {
            return new RatingCompat(v, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    @Override
    public final String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeFloat(this.b);
    }
}

