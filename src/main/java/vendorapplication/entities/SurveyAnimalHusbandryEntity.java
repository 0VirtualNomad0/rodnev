package vendorapplication.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "survey_animal_husbandry")
public class SurveyAnimalHusbandryEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "survey_animal_husbandry_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "survey_animal_husbandry_id_seq", sequenceName = "public.survey_animal_husbandry_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "survey_animal_husbandry_id")
    private long animalHusbandryId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_user_id")
    private SurveyUserEntity surveyUserId;

    @Column(name = "government_employed_family_number")
    private int govtEmplFamilyNumber;

    @Column(name = "self_employed_family_number")
    private int selfEmplFamilyNumber;

    @Column(name = "outsourced_employed_family_number")
    private int outsourcedEmplFamilyNumber;

    @Column(name = "pmu_employed_family_number")
    private int pmuEmplFamilyNumber;

    @Column(name = "private_employed_family_number")
    private int privateEmplFamilyNumber;

    @Column(name = "cows_number")
    private int cows;

    @Column(name = "buffaloes_number")
    private int buffaloes;

    @Column(name = "other_animal_number")
    private int otherAnimals;

    @Column(name = "total_animals")
    private int totalAnimals;

    @Column(name = "cow_milk_day_quantity")
    private float cowMilkQuantity;

    @Column(name = "buffalo_milk_day_quantity")
    private float buffaloMilkQuantity;

    @Column(name = "personal_use_milk_day_quantity")
    private float personalUseMilkQuantity;

    @Column(name = "milk_sold_quantity")
    private float milkSoldQuantity;

    @Column(name = "milk_sold_to")
    private String milkSoldTo;

    @Column(name = "milk_selling_price")
    private float sellingPrice;

    @Column(name = "sell_to_hp_milk")
    private boolean willingToSell;

    @Column(name = "quantity_to_sell_hp")
    private float quantityToSell;

    @Column(name = "can_increase_animal")
    private boolean canIncreaseAnimal;

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

    public int getGovtEmplFamilyNumber() {
        return govtEmplFamilyNumber;
    }

    public void setGovtEmplFamilyNumber(int govtEmplFamilyNumber) {
        this.govtEmplFamilyNumber = govtEmplFamilyNumber;
    }

    public int getSelfEmplFamilyNumber() {
        return selfEmplFamilyNumber;
    }

    public void setSelfEmplFamilyNumber(int selfEmplFamilyNumber) {
        this.selfEmplFamilyNumber = selfEmplFamilyNumber;
    }

    public int getOutsourcedEmplFamilyNumber() {
        return outsourcedEmplFamilyNumber;
    }

    public void setOutsourcedEmplFamilyNumber(int outsourcedEmplFamilyNumber) {
        this.outsourcedEmplFamilyNumber = outsourcedEmplFamilyNumber;
    }

    public int getPmuEmplFamilyNumber() {
        return pmuEmplFamilyNumber;
    }

    public void setPmuEmplFamilyNumber(int pmuEmplFamilyNumber) {
        this.pmuEmplFamilyNumber = pmuEmplFamilyNumber;
    }

    public int getPrivateEmplFamilyNumber() {
        return privateEmplFamilyNumber;
    }

    public void setPrivateEmplFamilyNumber(int privateEmplFamilyNumber) {
        this.privateEmplFamilyNumber = privateEmplFamilyNumber;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBuffaloes() {
        return buffaloes;
    }

    public void setBuffaloes(int buffaloes) {
        this.buffaloes = buffaloes;
    }

    public int getOtherAnimals() {
        return otherAnimals;
    }

    public void setOtherAnimals(int otherAnimals) {
        this.otherAnimals = otherAnimals;
    }

    public int getTotalAnimals() {
        return totalAnimals;
    }

    public void setTotalAnimals(int totalAnimals) {
        this.totalAnimals = totalAnimals;
    }

    public float getCowMilkQuantity() {
        return cowMilkQuantity;
    }

    public void setCowMilkQuantity(float cowMilkQuantity) {
        this.cowMilkQuantity = cowMilkQuantity;
    }

    public float getBuffaloMilkQuantity() {
        return buffaloMilkQuantity;
    }

    public void setBuffaloMilkQuantity(float buffaloMilkQuantity) {
        this.buffaloMilkQuantity = buffaloMilkQuantity;
    }

    public float getPersonalUseMilkQuantity() {
        return personalUseMilkQuantity;
    }

    public void setPersonalUseMilkQuantity(float personalUseMilkQuantity) {
        this.personalUseMilkQuantity = personalUseMilkQuantity;
    }

    public float getMilkSoldQuantity() {
        return milkSoldQuantity;
    }

    public void setMilkSoldQuantity(float milkSoldQuantity) {
        this.milkSoldQuantity = milkSoldQuantity;
    }

    public String getMilkSoldTo() {
        return milkSoldTo;
    }

    public void setMilkSoldTo(String milkSoldTo) {
        this.milkSoldTo = milkSoldTo;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isWillingToSell() {
        return willingToSell;
    }

    public void setWillingToSell(boolean willingToSell) {
        this.willingToSell = willingToSell;
    }

    public float getQuantityToSell() {
        return quantityToSell;
    }

    public void setQuantityToSell(float quantityToSell) {
        this.quantityToSell = quantityToSell;
    }

    public boolean isCanIncreaseAnimal() {
        return canIncreaseAnimal;
    }

    public void setCanIncreaseAnimal(boolean canIncreaseAnimal) {
        this.canIncreaseAnimal = canIncreaseAnimal;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "SurveyAnimalHusbandryEntity{" +
                "animalHusbandryId=" + animalHusbandryId +
                ", govtEmplFamilyNumber=" + govtEmplFamilyNumber +
                ", selfEmplFamilyNumber=" + selfEmplFamilyNumber +
                ", outsourcedEmplFamilyNumber=" + outsourcedEmplFamilyNumber +
                ", pmuEmplFamilyNumber=" + pmuEmplFamilyNumber +
                ", privateEmplFamilyNumber=" + privateEmplFamilyNumber +
                ", cows=" + cows +
                ", buffaloes=" + buffaloes +
                ", otherAnimals=" + otherAnimals +
                ", totalAnimals=" + totalAnimals +
                ", cowMilkQuantity=" + cowMilkQuantity +
                ", buffaloMilkQuantity=" + buffaloMilkQuantity +
                ", personalUseMilkQuantity=" + personalUseMilkQuantity +
                ", milkSoldQuantity=" + milkSoldQuantity +
                ", milkSoldTo='" + milkSoldTo + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", willingToSell=" + willingToSell +
                ", quantityToSell=" + quantityToSell +
                ", canIncreaseAnimal=" + canIncreaseAnimal +
                ", createdDate=" + createdDate +
                '}';
    }
}
