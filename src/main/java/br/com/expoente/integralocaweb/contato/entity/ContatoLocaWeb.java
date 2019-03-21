package br.com.expoente.integralocaweb.contato.entity;

import br.com.expoente.integralocaweb.entity.Page;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ContatoLocaWeb {

    private Integer idLocaWeb;
    private Integer id;
    private String email;
    private String status;
    private CustomFields custom_fields;
    private Integer openings_count;
    private Integer uniq_openings_count;
    private Integer clicks_count;
    private Integer bounces_count;
    private String updated_at; //12-01-01 00:00:00
    private String created_at; //12-01-01 00:00:00
    private List<String> list_ids;
    private Page page;
    private List<ItemContato> items;

    public ContatoLocaWeb() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomFields getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(CustomFields custom_fields) {
        this.custom_fields = custom_fields;
    }

    public Integer getOpenings_count() {
        return openings_count;
    }

    public void setOpenings_count(Integer openings_count) {
        this.openings_count = openings_count;
    }

    public Integer getUniq_openings_count() {
        return uniq_openings_count;
    }

    public void setUniq_openings_count(Integer uniq_openings_count) {
        this.uniq_openings_count = uniq_openings_count;
    }

    public Integer getClicks_count() {
        return clicks_count;
    }

    public void setClicks_count(Integer clicks_count) {
        this.clicks_count = clicks_count;
    }

    public Integer getBounces_count() {
        return bounces_count;
    }

    public void setBounces_count(Integer bounces_count) {
        this.bounces_count = bounces_count;
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

    public List<String> getList_ids() {
        return list_ids;
    }

    public void setList_ids(List<String> list_ids) {
        this.list_ids = list_ids;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ItemContato> getItems() {
        return items;
    }

    public void setItems(List<ItemContato> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ContatoLocaWeb{" + "idLocaWeb=" + idLocaWeb + ", id=" + id + ", email=" + email + ", status=" + status + ", custom_fields=" + custom_fields + ", openings_count=" + openings_count + ", uniq_openings_count=" + uniq_openings_count + ", clicks_count=" + clicks_count + ", bounces_count=" + bounces_count + ", updated_at=" + updated_at + ", created_at=" + created_at + ", list_ids=" + list_ids + ", page=" + page + ", items=" + items + '}';
    }

}
