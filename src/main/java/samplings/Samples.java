package samplings;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@IdClass(SamplesPK.class)
public class Samples /* extends BaseEntity */ {

    @Id
    private String sampleLetter;

    @Id
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name = "sampling_id", referencedColumnName = "sequenceId"),
        @JoinColumn(name = "sampling_year", referencedColumnName = "year")})
    private Samplings sampling;

    @OneToOne(mappedBy = "sample", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JoinColumns({
    //    @JoinColumn(name = "sampling_id", referencedColumnName = "sequenceId"),
    //    @JoinColumn(name = "sampling_year", referencedColumnName = "year")})
    private TestSamples testSamples;
	//...

	public String getSampleLetter() {
		return sampleLetter;
	}

	public void setSampleLetter(String sampleLetter) {
		this.sampleLetter = sampleLetter;
	}

	public Samplings getSampling() {
		return sampling;
	}

	public void setSampling(Samplings sampling) {
		this.sampling = sampling;
	}

	public TestSamples getTestSamples() {
		return testSamples;
	}

	public void setTestSamples(TestSamples testSamples) {
		this.testSamples = testSamples;
	}

}

