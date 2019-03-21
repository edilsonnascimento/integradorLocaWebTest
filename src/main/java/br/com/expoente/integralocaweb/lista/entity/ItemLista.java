package br.com.expoente.integralocaweb.lista.entity;

/**
 *
 * @author ednascimento
 */
public class ItemLista {

    private Integer contacts_count;
    private String id;
    private String description;
    private String name;

    public ItemLista() {
    }

    public Integer getContacts_count() {
        return contacts_count;
    }

    public void setContacts_count(Integer contacts_count) {
        this.contacts_count = contacts_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Lista{" + "contacts_count=" + contacts_count + ", id=" + id + ", description=" + description + ", name=" + name + '}';
    }
}
