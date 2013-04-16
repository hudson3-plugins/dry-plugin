package hudson.plugins.dry;

import hudson.model.AbstractBuild;
import hudson.plugins.analysis.core.ParserResult;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.analysis.core.BuildResult;

/**
 * Represents the aggregated results of the DRY analysis in m2 jobs.
 *
 * @author Ulli Hafner
 */
public class DryReporterResult extends DryResult {
    private static final long serialVersionUID = -2812927497499345424L;

    /**
     * Creates a new instance of {@link DryReporterResult}.
     *
     * @param build
     *            the current build as owner of this action
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
     *            the parsed result with all annotations
     * @param useStableBuildAsReference
     *            determines whether only stable builds should be used as
     *            reference builds or not
     */
    public DryReporterResult(final AbstractBuild<?, ?> build, final String defaultEncoding,
            final ParserResult result, final boolean useStableBuildAsReference) {
        super(build, defaultEncoding, result, useStableBuildAsReference, DryMavenResultAction.class);
    }

    @Override
    protected Class<? extends ResultAction<? extends BuildResult>> getResultActionType() {
        return DryMavenResultAction.class;
    }
}

