package by.pvt.pojo.annotation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private  long applicantId;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="profession_id")
    private Profession profession;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="applicant")
    private List<ApplicantResult> applicantResults;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "entrance_year")
    private int entranceYear;

    public long getApplicatId() {
        return applicantId;
    }

    public void setApplicatId(long applicantId) {
        this.applicantId = applicantId;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<ApplicantResult> getApplicantResults() {
        return applicantResults;
    }

    public void setApplicantResults(List<ApplicantResult> applicantResults) {
        this.applicantResults = applicantResults;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }
}
