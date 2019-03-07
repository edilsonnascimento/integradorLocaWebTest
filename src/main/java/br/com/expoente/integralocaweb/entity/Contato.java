package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class Contato {

    private Page page;
    private List<ItemContato> items = new ArrayList<ItemContato>();

    public Contato() {
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
        return "Contato{" + "page=" + page + ", items=" + items + '}';
    }
}
