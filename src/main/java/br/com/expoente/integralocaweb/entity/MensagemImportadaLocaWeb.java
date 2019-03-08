package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class MensagemImportadaLocaWeb {

    private Page page;
    private List<ItemMensagem> items = new ArrayList<ItemMensagem>();

    public MensagemImportadaLocaWeb() {
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ItemMensagem> getItems() {
        return items;
    }

    public void setItems(List<ItemMensagem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "page=" + page + ", items=" + items + '}';
    }
}
