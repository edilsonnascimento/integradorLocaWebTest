package br.com.expoente.integralocaweb.entity;

import br.com.expoente.integralocaweb.entity.ItemCampanha;
import br.com.expoente.integralocaweb.entity.Page;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class CampanhaImportadaLocaWeb {

    private Page page;
    private List<ItemCampanha> items = new ArrayList<ItemCampanha>();

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
        return "CampanhaImportadaLocaWeb{" + "page=" + page + ", items=" + items + '}';
    }
}
