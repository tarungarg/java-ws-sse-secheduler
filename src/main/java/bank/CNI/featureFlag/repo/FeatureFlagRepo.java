package bank.CNI.featureFlag.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureFlagRepo extends CrudRepository<Feature, Long> {

}
