package br.com.expoente.integralocaweb.config;

/**
 *
 * @author ednascimento
 */
public class Acessos {

    private String uriLocaWeb = "https://emailmarketing.locaweb.com.br/api/v1/accounts";
    private String keyAuthorization = "X-Auth-Token";
    private String token = "SyxXqjCsy3odzWuaLppacMpymHJTvzUg2WxU7xEqSpQr";
    private String idConta = "/95088";

    public String getUriLocaWeb() {
        return uriLocaWeb;
    }

    public String getKeyAuthorization() {
        return keyAuthorization;
    }

    public String getToken() {
        return token;
    }

    public String getIdConta() {
        return idConta;
    }

}
