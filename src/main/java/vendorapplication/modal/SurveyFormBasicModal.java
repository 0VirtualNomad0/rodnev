package vendorapplication.modal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SurveyFormBasicModal {
    private SurveyUserBasicModal surveyUserId;

    public SurveyUserBasicModal getSurveyUserId() {
        return surveyUserId;
    }

    public void setSurveyUserId(SurveyUserBasicModal surveyUserId) {
        this.surveyUserId = surveyUserId;
    }

    @Override
    public String toString() {
        return "SurveyFormBasicModal{" +
                "surveyUserId=" + surveyUserId +
                '}';
    }

}
