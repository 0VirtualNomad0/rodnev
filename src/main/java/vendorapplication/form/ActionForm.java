package vendorapplication.form;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ActionForm implements Serializable {

    private String action;
    private String comments;
    private String user_role;
    private String app_id;
    private String user_id;
    private String applicant_mobile;
    private MultipartFile attachment_if_any;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApplicant_mobile() {
        return applicant_mobile;
    }

    public void setApplicant_mobile(String applicant_mobile) {
        this.applicant_mobile = applicant_mobile;
    }

    public MultipartFile getAttachment_if_any() {
        return attachment_if_any;
    }

    public void setAttachment_if_any(MultipartFile attachment_if_any) {
        this.attachment_if_any = attachment_if_any;
    }

    @Override
    public String toString() {
        return "ActionForm{" +
                "action='" + action + '\'' +
                ", comments='" + comments + '\'' +
                ", user_role='" + user_role + '\'' +
                ", app_id='" + app_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", applicant_mobile='" + applicant_mobile + '\'' +
                ", attachment_if_any=" + attachment_if_any +
                '}';
    }
}