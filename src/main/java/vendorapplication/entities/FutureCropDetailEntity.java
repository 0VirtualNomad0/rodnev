package vendorapplication.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "future_crop_details")
public class FutureCropDetailEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "future_crop_details_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "future_crop_details_id_seq", sequenceName = "public.future_crop_details_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "future_crop_details_id")
    private Integer cropDetailId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_agriculture_id")
    private SurveyAgricultureEntity surveyAgricultureId;

    @Column(name = "crop_name")
    private String cropName;

    @Column(name = "crop_area")
    private float cropArea;

    @OneToOne()
    @JoinColumn(name = "crop_type_id")
    private CropTypeEntity cropTypeId;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getCropDetailId() {
        return cropDetailId;
    }

    public void setCropDetailId(Integer cropDetailId) {
        this.cropDetailId = cropDetailId;
    }

    public SurveyAgricultureEntity getSurveyAgricultureId() {
        return surveyAgricultureId;
    }

    public void setSurveyAgricultureId(SurveyAgricultureEntity surveyAgricultureId) {
        this.surveyAgricultureId = surveyAgricultureId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public float getCropArea() {
        return cropArea;
    }

    public void setCropArea(float cropArea) {
        this.cropArea = cropArea;
    }


    public CropTypeEntity getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(CropTypeEntity cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CropDetailEntity{" +
                "cropDetailId=" + cropDetailId +
                ", cropName='" + cropName + '\'' +
                ", cropArea='" + cropArea + '\'' +
                ", cropTypeId=" + cropTypeId +
                ", createdDate=" + createdDate +
                '}';
    }
}
