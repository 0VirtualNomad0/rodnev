package vendorapplication.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey_agriculture")
public class SurveyAgricultureEntity implements Serializable {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "surveyAgricultureId")
    List<CropDetailEntity> cropDetails;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "surveyAgricultureId")
    List<FutureCropDetailEntity> futureCropDetails;

    @Id
    @GeneratedValue(generator = "survey_agriculture_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "survey_agriculture_id_seq", sequenceName = "public.survey_agriculture_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "survey_agriculture_id")
    private long animalHusbandryId;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_user_id")
    private SurveyUserEntity surveyUserId;
    @Column(name = "total_land")
    private float totalLand;
    @Column(name = "cultivated_land")
    private float cultivatedLand;
    @Column(name = "irrigated_land")
    private float irrigatedLand;
    @Column(name = "non_irrigated_land")
    private float nonIrrigatedLand;
    @Column(name = "present_income")
    private double presentIncome;

    @Column(name = "marketable_income")
    private String marketableIncome;

    @Column(name = "infrastructure_requirements", length = 500)
    private String infraRequirements;

    @Column(name = "training_details", length = 500)
    private String trainingAgri;

    @Column(name = "natural_farming")
    private boolean naturalFarming;

    @Column(name = "partial")
    private boolean partial;

    @Column(name = "benefit_from_pmkisan")
    private boolean pmkisanBenifit;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public long getAnimalHusbandryId() {
        return animalHusbandryId;
    }

    public void setAnimalHusbandryId(long animalHusbandryId) {
        this.animalHusbandryId = animalHusbandryId;
    }

    public SurveyUserEntity getSurveyUserId() {
        return surveyUserId;
    }

    public void setSurveyUserId(SurveyUserEntity surveyUserId) {
        this.surveyUserId = surveyUserId;
    }

    public float getTotalLand() {
        return totalLand;
    }

    public void setTotalLand(float totalLand) {
        this.totalLand = totalLand;
    }

    public float getCultivatedLand() {
        return cultivatedLand;
    }

    public void setCultivatedLand(float cultivatedLand) {
        this.cultivatedLand = cultivatedLand;
    }

    public float getIrrigatedLand() {
        return irrigatedLand;
    }

    public void setIrrigatedLand(float irrigatedLand) {
        this.irrigatedLand = irrigatedLand;
    }

    public float getNonIrrigatedLand() {
        return nonIrrigatedLand;
    }

    public void setNonIrrigatedLand(float nonIrrigatedLand) {
        this.nonIrrigatedLand = nonIrrigatedLand;
    }

    public List<CropDetailEntity> getCropDetails() {
        return cropDetails;
    }

    public void setCropDetails(List<CropDetailEntity> cropDetails) {
        if (this.cropDetails == null) {
            this.cropDetails = cropDetails;
        } else {
            this.cropDetails.retainAll(cropDetails);
            this.cropDetails.addAll(cropDetails);
        }
    }

    public List<FutureCropDetailEntity> getFutureCropDetails() {
        return futureCropDetails;
    }

    public void setFutureCropDetails(List<FutureCropDetailEntity> futureCropDetails) {
        if (this.futureCropDetails == null) {
            this.futureCropDetails = futureCropDetails;
        } else {
            this.futureCropDetails.retainAll(futureCropDetails);
            this.futureCropDetails.addAll(futureCropDetails);
        }
    }

    public double getPresentIncome() {
        return presentIncome;
    }

    public void setPresentIncome(double presentIncome) {
        this.presentIncome = presentIncome;
    }

    public String getMarketableIncome() {
        return marketableIncome;
    }

    public void setMarketableIncome(String marketableIncome) {
        this.marketableIncome = marketableIncome;
    }

    public String getInfraRequirements() {
        return infraRequirements;
    }

    public void setInfraRequirements(String infraRequirements) {
        this.infraRequirements = infraRequirements;
    }

    public String getTrainingAgri() {
        return trainingAgri;
    }

    public void setTrainingAgri(String trainingAgri) {
        this.trainingAgri = trainingAgri;
    }

    public boolean isNaturalFarming() {
        return naturalFarming;
    }

    public void setNaturalFarming(boolean naturalFarming) {
        this.naturalFarming = naturalFarming;
    }

    public boolean isPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public boolean isPmkisanBenifit() {
        return pmkisanBenifit;
    }

    public void setPmkisanBenifit(boolean pmkisanBenifit) {
        this.pmkisanBenifit = pmkisanBenifit;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "SurveyAgricultureEntity{" +
                "animalHusbandryId=" + animalHusbandryId +
                ", totalLand=" + totalLand +
                ", cultivatedLand=" + cultivatedLand +
                ", irrigatedLand=" + irrigatedLand +
                ", nonIrrigatedLand=" + nonIrrigatedLand +
                ", cropDetails=" + cropDetails +
                ", futureCropDetails=" + futureCropDetails +
                ", presentIncome=" + presentIncome +
                ", marketableIncome='" + marketableIncome + '\'' +
                ", infraRequirements='" + infraRequirements + '\'' +
                ", trainingAgri='" + trainingAgri + '\'' +
                ", naturalFarming=" + naturalFarming +
                ", partial=" + partial +
                ", pmkisanBenifit=" + pmkisanBenifit +
                ", createdDate=" + createdDate +
                '}';
    }
}
