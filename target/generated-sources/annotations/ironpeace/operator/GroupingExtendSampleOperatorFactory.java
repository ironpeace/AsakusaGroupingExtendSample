package ironpeace.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.Branch;
import com.asakusafw.vocabulary.operator.Convert;
import com.asakusafw.vocabulary.operator.MasterJoin;
import ironpeace.modelgen.dmdl.model.Middata;
import ironpeace.modelgen.dmdl.model.OriginalData;
import ironpeace.modelgen.dmdl.model.PreResult;
import ironpeace.modelgen.dmdl.model.Result;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link GroupingExtendSampleOperator}に関する演算子ファクトリークラス。
 * @see GroupingExtendSampleOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1") public class GroupingExtendSampleOperatorFactory {
    /**
     */
    public static final class Balance implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<OriginalData> before;
        /**
         */
        public final Source<OriginalData> current;
        /**
         */
        public final Source<OriginalData> old;
        Balance(Source<OriginalData> originaldata) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Branch.class);
            builder.declare(GroupingExtendSampleOperator.class, GroupingExtendSampleOperatorImpl.class, "balance");
            builder.declareParameter(OriginalData.class);
            builder.addInput("originaldata", originaldata);
            builder.addOutput("before", originaldata);
            builder.addOutput("current", originaldata);
            builder.addOutput("old", originaldata);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("originaldata", originaldata);
            this.before = this.$.resolveOutput("before");
            this.current = this.$.resolveOutput("current");
            this.old = this.$.resolveOutput("old");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingExtendSampleOperatorFactory.Balance as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param originaldata
     * @return 生成した演算子オブジェクト
     * @see GroupingExtendSampleOperator#balance(OriginalData)
     */
    public GroupingExtendSampleOperatorFactory.Balance balance(Source<OriginalData> originaldata) {
        return new GroupingExtendSampleOperatorFactory.Balance(originaldata);
    }
    /**
     */
    public static final class Join4Mid implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<Middata> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<OriginalData> missed;
        Join4Mid(Source<OriginalData> t11, Source<OriginalData> t12) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterJoin.class);
            builder0.declare(GroupingExtendSampleOperator.class, GroupingExtendSampleOperatorImpl.class, "join4Mid");
            builder0.declareParameter(OriginalData.class);
            builder0.declareParameter(OriginalData.class);
            builder0.addInput("t11", t11, new ShuffleKey(Arrays.asList(new String[]{"userid"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("t12", t12, new ShuffleKey(Arrays.asList(new String[]{"userid"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addOutput("joined", Middata.class);
            builder0.addOutput("missed", t12);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("t11", t11);
            this.$.resolveInput("t12", t12);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingExtendSampleOperatorFactory.Join4Mid as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * @param t11
     * @param t12
     * @return 生成した演算子オブジェクト
     * @see GroupingExtendSampleOperator#join4Mid(OriginalData, OriginalData)
     */
    public GroupingExtendSampleOperatorFactory.Join4Mid join4Mid(Source<OriginalData> t11, Source<OriginalData> t12) {
        return new GroupingExtendSampleOperatorFactory.Join4Mid(t11, t12);
    }
    /**
     */
    public static final class ConvertedResult implements Operator {
        private final FlowElementResolver $;
        /**
         * 入力された内容
         */
        public final Source<PreResult> original;
        /**
         */
        public final Source<Result> out;
        ConvertedResult(Source<PreResult> pre) {
            OperatorDescription.Builder builder1 = new OperatorDescription.Builder(Convert.class);
            builder1.declare(GroupingExtendSampleOperator.class, GroupingExtendSampleOperatorImpl.class, 
                    "convertedResult");
            builder1.declareParameter(PreResult.class);
            builder1.addInput("pre", pre);
            builder1.addOutput("original", pre);
            builder1.addOutput("out", Result.class);
            builder1.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder1.toResolver();
            this.$.resolveInput("pre", pre);
            this.original = this.$.resolveOutput("original");
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName1 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public GroupingExtendSampleOperatorFactory.ConvertedResult as(String newName1) {
            this.$.setName(newName1);
            return this;
        }
    }
    /**
     * @param pre
     * @return 生成した演算子オブジェクト
     * @see GroupingExtendSampleOperator#convertedResult(PreResult)
     */
    public GroupingExtendSampleOperatorFactory.ConvertedResult convertedResult(Source<PreResult> pre) {
        return new GroupingExtendSampleOperatorFactory.ConvertedResult(pre);
    }
}