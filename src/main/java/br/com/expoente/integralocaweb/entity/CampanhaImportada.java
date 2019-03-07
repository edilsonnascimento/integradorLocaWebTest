package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class CampanhaImportada {

    private Page page;
    private List<ItemCampanha> items = new ArrayList<ItemCampanha>();

    public CampanhaImportada() {
    }

    public List<ItemCampanha> getItems() {
        return items;
    }

    public void setItems(List<ItemCampanha> items) {
        this.items = items;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Conta{" + "items=" + items + ", page=" + page + '}';
    }

}
