package org.acme.vehiclerouting.domain.jackson;

import ai.timefold.solver.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import ai.timefold.solver.core.api.score.constraint.ConstraintRef;
import ai.timefold.solver.core.api.score.stream.ConstraintJustification;
import ai.timefold.solver.core.api.score.stream.DefaultConstraintJustification;
import ai.timefold.solver.jackson.api.score.analysis.AbstractScoreAnalysisJacksonDeserializer;

public class VRPScoreAnalysisJacksonDeserializer extends AbstractScoreAnalysisJacksonDeserializer<HardSoftLongScore> {

    @Override
    protected HardSoftLongScore parseScore(String scoreString) {
        return HardSoftLongScore.parseScore(scoreString);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <ConstraintJustification_ extends ConstraintJustification> ConstraintJustification_ parseConstraintJustification(
            ConstraintRef constraintRef, String constraintJustificationString, HardSoftLongScore score) {
        return (ConstraintJustification_) DefaultConstraintJustification.of(score);
    }
}
