package X0;

public final class i {
    public final int a;

    public i(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof i && this.a == ((i)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        switch(this.a) {
            case 0: {
                return "Button";
            }
            case 1: {
                return "Checkbox";
            }
            case 2: {
                return "Switch";
            }
            case 3: {
                return "RadioButton";
            }
            case 4: {
                return "Tab";
            }
            case 5: {
                return "Image";
            }
            case 6: {
                return "DropdownList";
            }
            case 7: {
                return "Picker";
            }
            case 8: {
                return "Carousel";
            }
            default: {
                return "Unknown";
            }
        }
    }
}

