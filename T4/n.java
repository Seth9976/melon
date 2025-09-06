package T4;

import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public interface n {
    DropDataContentProviderBoundaryInterface getDropDataProvider();

    StaticsBoundaryInterface getStatics();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();

    String[] q();
}

