package samplings;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SamplesRepository extends CrudRepository<Samples, SamplesPK> {
//	@Query(value = "select s from Samples s Join fetch s.sampling sp Left Join fetch sp.machine m Join fetch sp.product p Join  fetch p.productType pt Join Fetch s.testSamples", 
//			countQuery = "select count(s) from Samples s Join s.sampling sp Left Join  sp.machine m Join  sp.product p Join  p.productType Join s.testSamples")
	@Query(value = "select s from Samples s Join fetch s.sampling sp Join Fetch s.testSamples", countQuery = "select count(s) from Samples s Join s.sampling sp Join s.testSamples")
	public Page<Samples> findAllFullSample(Pageable pageable);
}
