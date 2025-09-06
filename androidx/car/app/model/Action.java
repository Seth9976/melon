package androidx.car.app.model;

import androidx.appcompat.app.o;
import java.util.Objects;

public final class Action {
    public static final Action APP_ICON = null;
    public static final Action BACK = null;
    public static final Action COMPOSE_MESSAGE = null;
    public static final int FLAG_DEFAULT = 4;
    public static final int FLAG_IS_PERSISTENT = 2;
    public static final int FLAG_PRIMARY = 1;
    public static final Action PAN = null;
    public static final int TYPE_APP_ICON = 0x10002;
    public static final int TYPE_BACK = 0x10003;
    public static final int TYPE_COMPOSE_MESSAGE = 0x10005;
    public static final int TYPE_CUSTOM = 1;
    public static final int TYPE_PAN = 0x10004;
    static final int TYPE_STANDARD = 0x10000;
    private final CarColor mBackgroundColor;
    private final int mFlags;
    private final CarIcon mIcon;
    private final boolean mIsEnabled;
    private final B mOnClickDelegate;
    private final CarText mTitle;
    private final int mType;

    static {
        Action.APP_ICON = new Action(0x10002);
        Action.COMPOSE_MESSAGE = new Action(0x10005);
        Action.BACK = new Action(0x10003);
        Action.PAN = new Action(0x10004);
    }

    private Action() {
        this.mTitle = null;
        this.mIcon = null;
        this.mBackgroundColor = CarColor.DEFAULT;
        this.mOnClickDelegate = null;
        this.mType = 1;
        this.mFlags = 0;
        this.mIsEnabled = true;
    }

    private Action(int v) {
        if(v == 1) {
            throw new IllegalArgumentException("Standard action constructor used with non standard type");
        }
        this.mTitle = null;
        this.mIcon = null;
        this.mBackgroundColor = CarColor.DEFAULT;
        this.mOnClickDelegate = null;
        this.mType = v;
        this.mFlags = 0;
        this.mIsEnabled = true;
    }

    public Action(a a0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Action)) {
            return false;
        }
        return !Objects.equals(this.mTitle, ((Action)object0).mTitle) || this.mType != ((Action)object0).mType || !Objects.equals(this.mIcon, ((Action)object0).mIcon) ? false : Boolean.valueOf(this.mOnClickDelegate == null).equals(Boolean.valueOf(((Action)object0).mOnClickDelegate == null)) && this.mFlags.equals(((Action)object0).mFlags) && this.mIsEnabled == ((Action)object0).mIsEnabled;
    }

    public CarColor getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public CarIcon getIcon() {
        return this.mIcon;
    }

    public B getOnClickDelegate() {
        return this.mOnClickDelegate;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return this.mType;
    }

    @Override
    public int hashCode() {
        CarText carText0 = this.mTitle;
        Integer integer0 = this.mType;
        boolean z = false;
        Boolean boolean0 = Boolean.valueOf(this.mOnClickDelegate == null);
        if(this.mIcon == null) {
            z = true;
        }
        return Objects.hash(new Object[]{carText0, integer0, boolean0, Boolean.valueOf(z), Boolean.valueOf(this.mIsEnabled)});
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isStandard() {
        return Action.isStandardActionType(this.mType);
    }

    public static boolean isStandardActionType(int v) {
        return (v & 0x10000) != 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[type: ");
        stringBuilder0.append(Action.typeToString(this.mType));
        stringBuilder0.append(", icon: ");
        stringBuilder0.append(this.mIcon);
        stringBuilder0.append(", bkg: ");
        stringBuilder0.append(this.mBackgroundColor);
        stringBuilder0.append(", isEnabled: ");
        return o.s(stringBuilder0, this.mIsEnabled, "]");
    }

    public static String typeToString(int v) {
        if(v != 1) {
            switch(v) {
                case 0x10002: {
                    return "APP_ICON";
                }
                case 0x10003: {
                    return "BACK";
                }
                case 0x10004: {
                    return "PAN";
                }
                case 0x10005: {
                    return "COMPOSE_MESSAGE";
                }
                default: {
                    return "<unknown>";
                }
            }
        }
        return "CUSTOM";
    }
}

