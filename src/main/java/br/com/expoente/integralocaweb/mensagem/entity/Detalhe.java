package br.com.expoente.integralocaweb.mensagem.entity;

/**
 *
 * @author ednascimento
 */
public class Detalhe {

    private Integer id;
    private Integer contacts_count;
    private String description;
    private String name;
    private String created_at;
    private String updated_at;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
