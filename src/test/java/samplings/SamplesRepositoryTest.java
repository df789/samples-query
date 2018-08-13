package samplings;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SamplesRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SamplesRepository repository;

	@Autowired
	private SamplingsRepository samplingsRepository;

	@Test
	public void saveAndQuery() throws Exception {
		// set up
		Samplings sampling = new Samplings();
		sampling.setYear(2018);

		Samples sample = new Samples();
		sample.setSampling(sampling);
		sample.setSampleLetter("A");

		TestSamples testSamples = new TestSamples();
		testSamples.setSample(sample);

		sample.setTestSamples(testSamples);
		sampling.addSample(sample);

		sampling = samplingsRepository.save(sampling);

		EntityManager em = entityManager.getEntityManager();
		em.flush();
		em.clear();
		
		Pageable pageable = Pageable.unpaged();

		// exercise
		Page<Samples> samples = repository.findAllFullSample(pageable);

		// verify
		Samples firstSampleBack = samples.getContent().get(0);
		assertNotNull(firstSampleBack.getTestSamples());
		System.out
				.println("--> testSamples=" + firstSampleBack.getTestSamples());
	}
}
