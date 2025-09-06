package androidx.car.app.model.signin;

import U4.x;
import androidx.car.app.model.CarText;
import androidx.car.app.model.o;
import java.util.Objects;
import w.a;
import w.c;

public final class InputSignInMethod implements c {
    public static final int INPUT_TYPE_DEFAULT = 1;
    public static final int INPUT_TYPE_PASSWORD = 2;
    public static final int KEYBOARD_DEFAULT = 1;
    public static final int KEYBOARD_EMAIL = 2;
    public static final int KEYBOARD_NUMBER = 4;
    public static final int KEYBOARD_PHONE = 3;
    private final CarText mDefaultValue;
    private final CarText mErrorMessage;
    private final CarText mHint;
    private final o mInputCallbackDelegate;
    private final int mInputType;
    private final int mKeyboardType;
    private final boolean mShowKeyboardByDefault;

    private InputSignInMethod() {
        this.mHint = null;
        this.mDefaultValue = null;
        this.mInputType = 1;
        this.mErrorMessage = null;
        this.mKeyboardType = 1;
        this.mInputCallbackDelegate = null;
        this.mShowKeyboardByDefault = false;
    }

    public InputSignInMethod(a a0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof InputSignInMethod ? this.mInputType == ((InputSignInMethod)object0).mInputType && this.mKeyboardType == ((InputSignInMethod)object0).mKeyboardType && this.mShowKeyboardByDefault == ((InputSignInMethod)object0).mShowKeyboardByDefault && Objects.equals(this.mHint, ((InputSignInMethod)object0).mHint) && Objects.equals(this.mDefaultValue, ((InputSignInMethod)object0).mDefaultValue) && Objects.equals(this.mErrorMessage, ((InputSignInMethod)object0).mErrorMessage) : false;
    }

    public CarText getDefaultValue() {
        return this.mDefaultValue;
    }

    public CarText getErrorMessage() {
        return this.mErrorMessage;
    }

    public CarText getHint() {
        return this.mHint;
    }

    public o getInputCallbackDelegate() {
        Objects.requireNonNull(this.mInputCallbackDelegate);
        return this.mInputCallbackDelegate;
    }

    public int getInputType() {
        return this.mInputType;
    }

    public int getKeyboardType() {
        return this.mKeyboardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mHint, this.mDefaultValue, this.mInputType, this.mErrorMessage, this.mKeyboardType, Boolean.valueOf(this.mShowKeyboardByDefault)});
    }

    public boolean isShowKeyboardByDefault() {
        return this.mShowKeyboardByDefault;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[inputType:");
        stringBuilder0.append(this.mInputType);
        stringBuilder0.append(", keyboardType: ");
        return x.g(this.mKeyboardType, "]", stringBuilder0);
    }
}

