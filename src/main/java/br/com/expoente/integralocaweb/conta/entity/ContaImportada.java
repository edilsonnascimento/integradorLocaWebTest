package br.com.expoente.integralocaweb.conta.entity;

import br.com.expoente.integralocaweb.entity.Page;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ContaImportada {

    private List<ItemConta> items = new ArrayList<ItemConta>();
    private Page page;

    public ContaImportada() {
    }

    public List<ItemConta> getItems() {
        return items;
    }

    public void setItems(List<ItemConta> itens) {
        this.items = itens;
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
