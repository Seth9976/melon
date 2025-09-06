package com.samsung.android.sdk.look;

class RefSlookImpl extends AbstractBaseReflection {
    private static RefSlookImpl sInstance;

    public static RefSlookImpl get() {
        if(RefSlookImpl.sInstance == null) {
            RefSlookImpl.sInstance = new RefSlookImpl();
        }
        return RefSlookImpl.sInstance;
    }

    @Override  // com.samsung.android.sdk.look.AbstractBaseReflection
    public String getBaseClassName() {
        return "com.samsung.android.sdk.look.SlookImpl";
    }

    public boolean isFeatureEnabled(int v) {
        Object object0 = this.invokeStaticMethod("isFeatureEnabled", new Class[]{Integer.TYPE}, new Object[]{v});
        return object0 == null ? false : ((Boolean)object0).booleanValue();
    }
}

