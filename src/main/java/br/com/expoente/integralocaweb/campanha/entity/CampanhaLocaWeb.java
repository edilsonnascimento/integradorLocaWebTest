package br.com.expoente.integralocaweb.campanha.entity;

import br.com.expoente.integralocaweb.entity.Page;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class CampanhaLocaWeb {

    private Integer id;
    private Integer idLocaWeb;
    private String name;
    private String description;
    private String created_at; //"19-03-07 11:06:14",
    private String updated_at; //19-03-07 11:17:42"
    private Page page;
    private List<ItemCampanha> items = new ArrayList<ItemCampanha>();

    public CampanhaLocaWeb() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLocaWeb() {
        return idLocaWeb;
    }

    public void setIdLocaWeb(Integer idLocaWeb) {
        this.idLocaWeb = idLocaWeb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ItemCampanha> getItems() {
        return items;
    }

    public void setItems(List<ItemCampanha> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CampanhaExportadaLocaWeb{" + "id=" + id + ", idLocaWeb=" + idLocaWeb + ", name=" + name + ", description=" + description + ", created_at=" + created_at + ", updated_at=" + updated_at + ", page=" + page + ", items=" + items + '}';
    }
}
