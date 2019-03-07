package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ListaImportadaLocaWeb {

    private Page page;
    private List<ItemLista> items = new ArrayList<ItemLista>();

    public ListaImportadaLocaWeb() {
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

    @Override
    public String toString() {
        return "Lista{" + "page=" + page + ", items=" + items + '}';
    }

}
