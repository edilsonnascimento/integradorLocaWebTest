package br.com.expoente.integralocaweb.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ednascimento
 */
public class ContatoExportadoLocaWeb {

    private Integer idLocaWeb;
    private String email;
    private List<String> list_ids = new ArrayList<>();
    private ContatoCustomFields custom_fields = new ContatoCustomFields();

    public Integer getIdLocaWeb() {
        return idLocaWeb;
    }

    public void setIdLocaWeb(Integer idLocaWeb) {
        this.idLocaWeb = idLocaWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getList_ids() {
        return list_ids;
    }

    public void setList_ids(List<String> list_ids) {
        this.list_ids = list_ids;
    }

    public ContatoCustomFields getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(ContatoCustomFields custom_fields) {
        this.custom_fields = custom_fields;
    }

    @Override
    public String toString() {
        return "ContatoExportadoLocaWeb{" + "email=" + email + ", list_ids=" + list_ids + ", custom_fields=" + custom_fields + '}';
    }

}
