package androidx.car.app.navigation.model;

import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import java.util.Objects;

public final class MessageInfo implements f {
    private final CarIcon mImage;
    private final CarText mText;
    private final CarText mTitle;

    private MessageInfo() {
        this.mTitle = null;
        this.mText = null;
        this.mImage = null;
    }

    public MessageInfo(d d0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MessageInfo ? Objects.equals(this.mTitle, ((MessageInfo)object0).mTitle) && Objects.equals(this.mText, ((MessageInfo)object0).mText) && Objects.equals(this.mImage, ((MessageInfo)object0).mImage) : false;
    }

    public CarIcon getImage() {
        return this.mImage;
    }

    public CarText getText() {
        return this.mText;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTitle, this.mText, this.mImage});
    }

    @Override
    public String toString() {
        return "MessageInfo";
    }
}

