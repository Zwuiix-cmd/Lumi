package cn.nukkit.entity.ai.evaluator;



import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.NotNull;

public abstract class MultiBehaviorEvaluator implements IBehaviorEvaluator {
    protected ObjectArrayList<IBehaviorEvaluator> evaluators;

    public MultiBehaviorEvaluator(@NotNull ObjectArrayList<IBehaviorEvaluator> evaluators) {
        this.evaluators = evaluators;
    }

    public MultiBehaviorEvaluator(@NotNull IBehaviorEvaluator... evaluators) {
        this.evaluators = ObjectArrayList.of(evaluators);
    }
}