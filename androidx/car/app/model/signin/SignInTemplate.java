package androidx.car.app.model.signin;

import androidx.car.app.model.Action;
import androidx.car.app.model.ActionStrip;
import androidx.car.app.model.CarText;
import androidx.car.app.model.Y;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import w.b;
import w.c;

public final class SignInTemplate implements Y {
    private final List mActionList;
    private final ActionStrip mActionStrip;
    private final CarText mAdditionalText;
    private final Action mHeaderAction;
    private final CarText mInstructions;
    private final boolean mIsLoading;
    private final c mSignInMethod;
    private final CarText mTitle;

    private SignInTemplate() {
        this.mIsLoading = false;
        this.mHeaderAction = null;
        this.mTitle = null;
        this.mInstructions = null;
        this.mAdditionalText = null;
        this.mActionStrip = null;
        this.mActionList = Collections.EMPTY_LIST;
        this.mSignInMethod = null;
    }

    public SignInTemplate(b b0) {
        throw null;
    }

    // 去混淆评级： 低(26)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SignInTemplate ? this.mIsLoading == ((SignInTemplate)object0).mIsLoading && Objects.equals(this.mHeaderAction, ((SignInTemplate)object0).mHeaderAction) && Objects.equals(this.mTitle, ((SignInTemplate)object0).mTitle) && Objects.equals(this.mInstructions, ((SignInTemplate)object0).mInstructions) && Objects.equals(this.mAdditionalText, ((SignInTemplate)object0).mAdditionalText) && Objects.equals(this.mActionStrip, ((SignInTemplate)object0).mActionStrip) && Objects.equals(this.mActionList, ((SignInTemplate)object0).mActionList) && Objects.equals(this.mSignInMethod, ((SignInTemplate)object0).mSignInMethod) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public List getActions() {
        return this.mActionList == null ? Collections.EMPTY_LIST : this.mActionList;
    }

    public CarText getAdditionalText() {
        return this.mAdditionalText;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public CarText getInstructions() {
        return this.mInstructions;
    }

    public c getSignInMethod() {
        Objects.requireNonNull(this.mSignInMethod);
        return this.mSignInMethod;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsLoading), this.mHeaderAction, this.mTitle, this.mInstructions, this.mAdditionalText, this.mActionStrip, this.mActionList, this.mSignInMethod});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "SignInTemplate";
    }
}

