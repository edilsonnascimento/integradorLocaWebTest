/*
Lista enviadas ao Loca Web
 */
package br.com.expoente.integralocaweb.entity;

/**
 *
 * @author ednascimento
 */
public class CampanhaExportadaLocaWeb {

    private Integer idLocaWeb;
    private String name;
    private String description;

    public CampanhaExportadaLocaWeb() {
    }

    public Integer getIdLocaWeb() {
        return idLocaWeb;
    }

    public void setIdLocaWeb(Integer idLocaWeb) {
        this.idLocaWeb = idLocaWeb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
