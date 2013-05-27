package ironpeace.batchapp.gesBatch.theGroupingExtendSampleJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import ironpeace.modelgen.dmdl.model.OriginalData;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * {@code t12->GroupingExtendSampleOperator.join4Mid(operator#779185335)}へのシャッフル処理を担当するプログラムの断片。
 */
@SuppressWarnings("deprecation") public final class CombineOutputFragment2 implements Result<OriginalData> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * インスタンスを生成する。
     * @param collector 実際の出力先
     */
    public CombineOutputFragment2(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(OriginalData result) {
        this.key.setPort2(result);
        this.value.setPort2(result);
        try {
            this.collector.write(this.key, this.value);
        }
        catch(Exception exception) {
            throw new Result.OutputException(exception);
        }
    }
}