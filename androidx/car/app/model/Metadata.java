package androidx.car.app.model;

import java.util.Objects;

public final class Metadata {
    public static final Metadata EMPTY_METADATA;
    private final Place mPlace;

    static {
        Metadata.EMPTY_METADATA = new Metadata(new y());  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    private Metadata() {
        this.mPlace = null;
    }

    public Metadata(y y0) {
        y0.getClass();
        this.mPlace = null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Metadata ? Objects.equals(this.mPlace, ((Metadata)object0).mPlace) : false;
    }

    public Place getPlace() {
        return this.mPlace;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.mPlace);
    }
}

