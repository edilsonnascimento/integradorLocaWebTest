package br.com.expoente.integralocaweb.contato.entity;

/**
 *
 * @author ednascimento
 */
public class CustomFields {

    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "CustomFields{" + "fields=" + fields + '}';
    }

}
