package io.jenkins.plugins.workflow.restful.api;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition;
import org.jenkinsci.plugins.workflow.flow.FlowDefinition;

@Extension
public class SCMPipelineConvert implements PipelineConvert {
    @Override
    public boolean accept(FlowDefinition flowDefinition) {
        return flowDefinition instanceof CpsScmFlowDefinition;
    }

    @Override
    public Pipeline convert(FlowDefinition flowDefinition) {
        CpsScmFlowDefinition def = (CpsScmFlowDefinition) flowDefinition;
        SCMPipeline pipeline = new SCMPipeline();
        pipeline.setScriptPath(def.getScriptPath());
        pipeline.setDisplayName(def.getDescriptor().getDisplayName());
        return pipeline;
    }
}
