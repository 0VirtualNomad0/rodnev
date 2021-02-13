package vendorapplication.form;

import java.io.Serializable;

public class ActionForm implements Serializable {

    private String action;
    private String comments;
    private String user_role;
    private String app_id;

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

    @Override
    public String toString() {
        return "ActionForm{" +
                "action='" + action + '\'' +
                ", comments='" + comments + '\'' +
                ", user_role='" + user_role + '\'' +
                ", app_id='" + app_id + '\'' +
                '}';
    }
}
