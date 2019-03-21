package br.com.expoente.integralocaweb.campanha.entity;

/**
 *
 * @author ednascimento
 */
public class ItemCampanha {

    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "ItemCampanha{" + "id=" + id + ", name=" + name + '}';
    }

}
