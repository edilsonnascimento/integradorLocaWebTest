package br.com.expoente.integralocaweb.entity;

/**
 *
 * @author ednascimento
 */
public class ItemConta {

    private Integer id;
    private String display_name;
    private String plan_name;
    private String messages_bought;
    private String status;
    private String user_token;

    public ItemConta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getMessages_bought() {
        return messages_bought;
    }

    public void setMessages_bought(String messages_bought) {
        this.messages_bought = messages_bought;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    @Override
    public String toString() {
        return "ItemConta{" + "id=" + id + ", display_name=" + display_name + ", plan_name=" + plan_name + ", messages_bought=" + messages_bought + ", status=" + status + ", user_token=" + user_token + '}';
    }

}
