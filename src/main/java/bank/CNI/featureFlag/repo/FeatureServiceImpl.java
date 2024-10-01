package bank.CNI.featureFlag.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureFlagRepo featureFlagRepo;

    public FeatureServiceImpl(FeatureFlagRepo featureFlagRepo) {
        this.featureFlagRepo = featureFlagRepo;
    }

    @Override
    public void save(String featureFlags) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
