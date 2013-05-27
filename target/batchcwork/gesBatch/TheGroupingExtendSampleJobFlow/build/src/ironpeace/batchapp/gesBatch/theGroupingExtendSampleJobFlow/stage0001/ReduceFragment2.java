package ironpeace.batchapp.gesBatch.theGroupingExtendSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.OriginalData;
/**
 * {@code 
         * [t11->GroupingExtendSampleOperator.join4Mid(operator#779185335), t12->GroupingExtendSampleOperator.join4Mid(operator#779185335)]
         * }の処理を担当するマッププログラムの断片。
 */
@SuppressWarnings("deprecation") public final class ReduceFragment2 extends com.asakusafw.runtime.flow.Rendezvous<
        ShuffleValue> {
    private final Result<Middata> joined;
    private final Result<OriginalData> missed;
    private boolean sawMaster;
    private OriginalData cache = new OriginalData();
    private Middata cache0 = new Middata();
    /**
     * インスタンスを生成する。
     * @param joined {@code GroupingExtendSampleOperator.join4Mid#joined}への出力
     * @param missed {@code GroupingExtendSampleOperator.join4Mid#missed}への出力
     */
    public ReduceFragment2(Result<Middata> joined, Result<OriginalData> missed) {
        this.joined = joined;
        this.missed = missed;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.sawMaster = false;
    }
    @Override public void end() {
    }
    private void process0001(OriginalData value) {
        if(this.sawMaster == false) {
            this.cache.copyFrom(value);
            this.sawMaster = true;
        }
    }
    private void process0002(OriginalData value) {
        if(this.sawMaster) {
            this.cache0.reset();
            this.cache0.setUseridOption(this.cache.getUseridOption());
            this.cache0.setData0Option(this.cache.getDataOption());
            this.cache0.setData1Option(this.cache.getDataOption());
            this.joined.add(this.cache0);
        }
        else {
            this.missed.add(value);
        }
    }
}