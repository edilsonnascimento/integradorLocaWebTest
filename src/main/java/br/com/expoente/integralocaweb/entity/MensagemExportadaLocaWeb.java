package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class MensagemExportadaLocaWeb {

    private Integer idLocaWeb;
    private String campaign_id;
    private String domain_id;
    private String html_body;
    private String text_body;
    private List<String> list_ids = new ArrayList<String>();
    private String name;
    private String sender_name;
    private String sender;
    private String subject;
    private String scheduled_to;

    public Integer getIdLocaWeb() {
        return idLocaWeb;
    }

    public void setIdLocaWeb(Integer idLocaWeb) {
        this.idLocaWeb = idLocaWeb;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public String getHtml_body() {
        return html_body;
    }

    public void setHtml_body(String html_body) {
        this.html_body = html_body;
    }

    public String getText_body() {
        return text_body;
    }

    public void setText_body(String text_body) {
        this.text_body = text_body;
    }

    public List<String> getList_ids() {
        return list_ids;
    }

    public void setList_ids(List<String> list_ids) {
        this.list_ids = list_ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScheduled_to() {
        return scheduled_to;
    }

    public void setScheduled_to(String scheduled_to) {
        this.scheduled_to = scheduled_to;
    }

    @Override
    public String toString() {
        return "MensagemExportadaLocaWeb{" + "idLocaWeb=" + idLocaWeb + ", campaign_id=" + campaign_id + ", domain_id=" + domain_id + ", html_body=" + html_body + ", text_body=" + text_body + ", list_ids=" + list_ids + ", name=" + name + ", sender_name=" + sender_name + ", sender=" + sender + ", subject=" + subject + ", scheduled_to=" + scheduled_to + '}';
    }

}
