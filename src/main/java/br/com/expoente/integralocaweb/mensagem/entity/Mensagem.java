package br.com.expoente.integralocaweb.mensagem.entity;

import br.com.expoente.integralocaweb.entity.Page;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class Mensagem {

    private Integer idLocaWeb;
    private Integer id;
    private Integer contacts_count;
    private String campaign_id;
    private String campaign_name;
    private String status;
    private String domain_id;
    private String html_body;
    private String text_body;
    private String name;
    private String sender_name;
    private String sender;
    private String subject;
    private String scheduled_to;
    private String created_at;
    private String updated_at;
    private String preview;
    private Page page;
    private List<String> list_ids;
    private List<Item> items;
    private List<Detalhe> lists;

    public Mensagem() {
        lists = new ArrayList<Detalhe>();
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public Integer getContacts_count() {
        return contacts_count;
    }

    public void setContacts_count(Integer contacts_count) {
        this.contacts_count = contacts_count;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdLocaWeb() {
        return idLocaWeb;
    }

    public void setIdLocaWeb(Integer idLocaWeb) {
        this.idLocaWeb = idLocaWeb;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getCampaign_name() {
        return campaign_name;
    }

    public void setCampaign_name(String campaign_name) {
        this.campaign_name = campaign_name;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Detalhe> getLists() {
        return lists;
    }

    public void setLists(List<Detalhe> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "idLocaWeb=" + idLocaWeb + ", id=" + id + ", contacts_count=" + contacts_count + ", campaign_id=" + campaign_id + ", campaign_name=" + campaign_name + ", status=" + status + ", domain_id=" + domain_id + ", html_body=" + html_body + ", text_body=" + text_body + ", name=" + name + ", sender_name=" + sender_name + ", sender=" + sender + ", subject=" + subject + ", scheduled_to=" + scheduled_to + ", created_at=" + created_at + ", updated_at=" + updated_at + ", preview=" + preview + ", page=" + page + ", list_ids=" + list_ids + ", items=" + items + ", lists=" + lists + '}';
    }
}
