package ironpeace.batch;

import ironpeace.jobflow.GroupingExtendSampleJobFlow;

import com.asakusafw.vocabulary.batch.Batch;
import com.asakusafw.vocabulary.batch.BatchDescription;

@Batch(name="gesBatch")
public class GroupingExtendSampleBatch extends BatchDescription {

	@Override
	protected void describe() {
		run(GroupingExtendSampleJobFlow.class).soon();
	}

}
