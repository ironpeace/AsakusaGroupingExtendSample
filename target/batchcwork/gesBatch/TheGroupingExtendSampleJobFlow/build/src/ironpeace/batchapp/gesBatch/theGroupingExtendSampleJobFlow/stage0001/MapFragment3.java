package ironpeace.batchapp.gesBatch.theGroupingExtendSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.operator.GroupingExtendSampleOperatorImpl;
/**
 * {@code [in->extend(operator#1115600610)]}の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapFragment3 implements Result<Middata> {
    private final Result<PreResult> original;
    private final Result<ironpeace.modelgen.dmdl.model.Result> out;
    private PreResult cache = new PreResult();
    private GroupingExtendSampleOperatorImpl op = new GroupingExtendSampleOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param original {@code GroupingExtendSampleOperator.convertedResult#original}への出力
     * @param out {@code GroupingExtendSampleOperator.convertedResult#out}への出力
     */
    public MapFragment3(Result<PreResult> original, Result<ironpeace.modelgen.dmdl.model.Result> out) {
        this.original = original;
        this.out = out;
    }
    @Override public void add(Middata result) {
        this.cache.reset();
        this.cache.setData0Option(result.getData0Option());
        this.cache.setData1Option(result.getData1Option());
        this.cache.setUseridOption(result.getUseridOption());
        ironpeace.modelgen.dmdl.model.Result v = this.op.convertedResult(this.cache);
        this.original.add(this.cache);
        this.out.add(v);
    }
}