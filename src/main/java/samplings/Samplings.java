package samplings;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@IdClass(SamplingsPK.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Samplings {

	@Id
	private int year;

    @Id
    @GeneratedValue
    private Integer sequenceId;

//    @OneToOne
//    private Products product;
//
//    @OneToOne
//    private Machines machine;
//
//    @OneToOne
//    private Dimensions dimension;
//
//    @OneToOne
//    private Colors color;

    @OneToMany(mappedBy = "sampling", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Samples> samples = new ArrayList<>();
//    ...

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Integer getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(Integer sequenceId) {
		this.sequenceId = sequenceId;
	}

	public List<Samples> getSamples() {
		return samples;
	}

	public void setSamples(List<Samples> samples) {
		this.samples = samples;
	}

	public void addSample(Samples samples) {
		getSamples().add(samples);
	}

}

