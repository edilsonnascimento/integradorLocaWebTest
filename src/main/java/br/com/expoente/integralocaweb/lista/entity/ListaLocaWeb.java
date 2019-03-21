package br.com.expoente.integralocaweb.lista.entity;

import br.com.expoente.integralocaweb.entity.Page;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ListaLocaWeb {

    private Integer idLocaWeb;
    private String name;
    private String description;
    private Page page;
    private List<ItemLista> items;
    private Integer id;
    private Integer contacts_count;
    private String created_at; //"01/03/2019 - 13h50",
    private String updated_at; //"01/03/2019 - 17h14

    public ListaLocaWeb() {
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ItemLista> getItems() {
        return items;
    }

    public void setItems(List<ItemLista> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContacts_count() {
        return contacts_count;
    }

    public void setContacts_count(Integer contacts_count) {
        this.contacts_count = contacts_count;
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

    @Override
    public String toString() {
        return "ListaLocaWeb{" + "idLocaWeb=" + idLocaWeb + ", name=" + name + ", description=" + description + ", page=" + page + ", items=" + items + ", id=" + id + ", contacts_count=" + contacts_count + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}
