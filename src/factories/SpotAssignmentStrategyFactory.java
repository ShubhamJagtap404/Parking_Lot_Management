package factories;

import models.SpotAssignmentStrategyType;
import strategies.NearestSpotAssignmentStrategy;
import strategies.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStratey(SpotAssignmentStrategyType
                                                               spotAssignmentStrategyType) {
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        } else {
            return new RandomSpotAssignmentStrategy();
        }
    }
}
