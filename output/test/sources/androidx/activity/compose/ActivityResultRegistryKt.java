package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ActivityResultRegistry.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ActivityResultRegistryKt {
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(ActivityResultContract<I, O> activityResultContract, Function1<? super O, Unit> function1, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        $composer.startReplaceableGroup(-1408504823);
        ComposerKt.sourceInformation($composer, "C(rememberLauncherForActivityResult)86@3568L30,87@3625L30,91@3794L49,*93@3924L7,96@4078L46,97@4152L85,103@4420L204,103@4364L260:ActivityResultRegistry.kt#q1dkbc");
        State currentContract = SnapshotStateKt.rememberUpdatedState(activityResultContract, $composer, $changed & 14);
        State currentOnResult = SnapshotStateKt.rememberUpdatedState(function1, $composer, ($changed >> 3) & 14);
        String key = (String) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, $composer, 3072, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent($composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        }
        ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
        $composer.startReplaceableGroup(-1672765924);
        ComposerKt.sourceInformation($composer, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new ActivityResultLauncherHolder();
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ActivityResultLauncherHolder realLauncher = (ActivityResultLauncherHolder) value$iv;
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-1672765850);
        ComposerKt.sourceInformation($composer, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new ManagedActivityResultLauncher(realLauncher, currentContract);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        ManagedActivityResultLauncher returnedLauncher = (ManagedActivityResultLauncher) value$iv2;
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-1672765582);
        ComposerKt.sourceInformation($composer, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        boolean invalid$iv = $composer.changed(realLauncher) | $composer.changed(activityResultRegistry) | $composer.changed(key) | $composer.changed(activityResultContract) | $composer.changed(currentOnResult);
        Object value$iv3 = $composer.rememberedValue();
        if (invalid$iv || value$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1(realLauncher, activityResultRegistry, key, activityResultContract, currentOnResult);
            $composer.updateRememberedValue(value$iv3);
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(activityResultRegistry, key, activityResultContract, (Function1) value$iv3, $composer, ($changed << 6) & 896);
        $composer.endReplaceableGroup();
        return returnedLauncher;
    }
}
