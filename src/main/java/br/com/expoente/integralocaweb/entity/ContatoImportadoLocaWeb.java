package br.com.expoente.integralocaweb.entity;

import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ContatoImportadoLocaWeb {

    private Page page;
    private List<ItemContato> items;

    public ContatoImportadoLocaWeb() {
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
