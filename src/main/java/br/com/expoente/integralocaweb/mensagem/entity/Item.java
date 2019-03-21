package br.com.expoente.integralocaweb.mensagem.entity;

/**
 *
 * @author ednascimento
 */
public class Item {

    private Integer id;
    private String name;
    private String campaign_name;
    private String status;
    private String scheduled_to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduled_to() {
        return scheduled_to;
    }

    public void setScheduled_to(String scheduled_to) {
        this.scheduled_to = scheduled_to;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", name: " + name + ", campaign_name: " + campaign_name + ", status: " + status + ", scheduled_to: " + scheduled_to + "}";
    }
}
