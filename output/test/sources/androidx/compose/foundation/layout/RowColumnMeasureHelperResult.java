package androidx.compose.foundation.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnMeasurementHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "", "crossAxisSize", "", "mainAxisSize", "startIndex", "endIndex", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "(IIIII[I)V", "getBeforeCrossAxisAlignmentLine", "()I", "getCrossAxisSize", "getEndIndex", "getMainAxisPositions", "()[I", "getMainAxisSize", "getStartIndex", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowColumnMeasureHelperResult {
    private final int beforeCrossAxisAlignmentLine;
    private final int crossAxisSize;
    private final int endIndex;
    private final int[] mainAxisPositions;
    private final int mainAxisSize;
    private final int startIndex;

    public RowColumnMeasureHelperResult(int crossAxisSize, int mainAxisSize, int startIndex, int endIndex, int beforeCrossAxisAlignmentLine, int[] mainAxisPositions) {
        Intrinsics.checkNotNullParameter(mainAxisPositions, "mainAxisPositions");
        this.crossAxisSize = crossAxisSize;
        this.mainAxisSize = mainAxisSize;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.beforeCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine;
        this.mainAxisPositions = mainAxisPositions;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getBeforeCrossAxisAlignmentLine() {
        return this.beforeCrossAxisAlignmentLine;
    }

    public final int[] getMainAxisPositions() {
        return this.mainAxisPositions;
    }
}
