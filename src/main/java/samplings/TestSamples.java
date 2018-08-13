package samplings;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TestSamples { 

    @Id
    @SequenceGenerator(name = "test_samples_id_seq", sequenceName = "test_samples_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_samples_id_seq")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Samples sample;

//    @OneToOne(mappedBy = "testSample", fetch = FetchType.LAZY)
//    private Compressions compressionTest;
//
//    @OneToOne(mappedBy = "testSample", fetch = FetchType.LAZY)
//    private Durabilities durabilityTest;
//
//    @OneToOne(mappedBy = "testSample", fetch = FetchType.LAZY)
//    private Scalings scalingTest;
//
//    @OneToOne(mappedBy = "testSample", fetch = FetchType.LAZY)
//    private Granulometries granulometryTest;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    private Absorptions absorptionTest;
//    ...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Samples getSample() {
		return sample;
	}

	public void setSample(Samples sample) {
		this.sample = sample;
	}

	@Override
	public String toString() {
		return "TestSamples [id=" + id + "]";
	}
}