package androidx.compose.foundation.lazy.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutItemProvider.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006"}, d2 = {"findIndexByKey", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "key", "", "lastKnownIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutItemProviderKt {
    public static final int findIndexByKey(LazyLayoutItemProvider $this$findIndexByKey, Object key, int lastKnownIndex) {
        Intrinsics.checkNotNullParameter($this$findIndexByKey, "<this>");
        if (key == null || $this$findIndexByKey.getItemCount() == 0) {
            return lastKnownIndex;
        }
        if (lastKnownIndex < $this$findIndexByKey.getItemCount() && Intrinsics.areEqual(key, $this$findIndexByKey.getKey(lastKnownIndex))) {
            return lastKnownIndex;
        }
        int newIndex = $this$findIndexByKey.getIndex(key);
        if (newIndex != -1) {
            return newIndex;
        }
        return lastKnownIndex;
    }
}
