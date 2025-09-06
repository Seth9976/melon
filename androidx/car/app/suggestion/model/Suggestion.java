package androidx.car.app.suggestion.model;

import android.app.PendingIntent;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import java.util.Objects;
import z.a;

public final class Suggestion {
    private final PendingIntent mAction;
    private final CarIcon mIcon;
    private final String mIdentifier;
    private final CarText mSubtitle;
    private final CarText mTitle;

    private Suggestion() {
        this.mIdentifier = "";
        this.mTitle = CarText.create("");
        this.mSubtitle = null;
        this.mIcon = null;
        this.mAction = null;
    }

    public Suggestion(a a0) {
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Suggestion ? Objects.equals(this.mIdentifier, ((Suggestion)object0).mIdentifier) && Objects.equals(this.mTitle, ((Suggestion)object0).mTitle) && Objects.equals(this.mSubtitle, ((Suggestion)object0).mSubtitle) && Objects.equals(this.mAction, ((Suggestion)object0).mAction) && Objects.equals(this.mIcon, ((Suggestion)object0).mIcon) : false;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public CarText getSubtitle() {
        return this.mSubtitle;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mIdentifier, this.mTitle, this.mSubtitle, this.mIcon, this.mAction});
    }

    @Override
    public String toString() {
        return "[id: " + this.mIdentifier + ", title: " + CarText.toShortString(this.mTitle) + ", subtitle: " + CarText.toShortString(this.mSubtitle) + ", pendingIntent: " + this.mAction + ", icon: " + this.mIcon + "]";
    }
}

