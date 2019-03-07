package br.com.expoente.integralocaweb.resource;

import br.com.expoente.integralocaweb.entity.CampanhaImportada;
import br.com.expoente.integralocaweb.entity.ContaImportada;
import br.com.expoente.integralocaweb.entity.Contato;
import br.com.expoente.integralocaweb.entity.ListaImportadaLocaWeb;
import br.com.expoente.integralocaweb.entity.MensagemImportada;
import java.net.URI;
import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ednascimento
 */
@Path("testaget")
@Produces(MediaType.APPLICATION_JSON)
public class TestaGetLocaWeb {

    private static final String URI_LOCAWEB = "https://emailmarketing.locaweb.com.br/api/v1/accounts";
    private static final String KEY_AUTHORIZATION = "X-Auth-Token";
    private static final String TOKEN = "SyxXqjCsy3odzWuaLppacMpymHJTvzUg2WxU7xEqSpQr";
    private static final String IDCONTA = "/95088";
    private Client client;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();

    }

    @GET
    @Path("test")
    public String getJson() {
        return "TESTE DE RETORNO";
    }

    @GET
    @Path("conta")
    public Response getContas(String endPoint) {
        endPoint = "";

        ContaImportada conta = client
                .target(URI_LOCAWEB + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(KEY_AUTHORIZATION, TOKEN)
                .get(ContaImportada.class);

        return Response.ok().build();
    }

    @GET
    @Path("campanha")
    public Response getCampana(String endPoint) {
        endPoint = IDCONTA + "/contacts";

        CampanhaImportada campanha = client
                .target(URI_LOCAWEB + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(KEY_AUTHORIZATION, TOKEN)
                .get(CampanhaImportada.class);

        URI uri = URI.create("/endpoint/" + campanha.getItems().get(1).getId());

        return Response.created(uri).build();
    }

    @GET
    @Path("contato")
    public Response getContatos(String endPoint) {
        endPoint = IDCONTA + "/contacts";

        Contato contato = client
                .target(URI_LOCAWEB + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(KEY_AUTHORIZATION, TOKEN)
                .get(Contato.class);
        System.out.println("Contato: " + contato.toString());

        return Response.ok().build();
    }

    @GET
    @Path("lista")
    public Response getListas(String endPoint) {
        endPoint = IDCONTA + "/lists";

        ListaImportadaLocaWeb lista = client
                .target(URI_LOCAWEB + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(KEY_AUTHORIZATION, TOKEN)
                .get(ListaImportadaLocaWeb.class);

        System.out.println("LISTA: " + lista.toString());
        return Response.ok().build();
    }

    @GET
    @Path("mensagem")
    public Response getMensagem(String endPoint) {
        endPoint = IDCONTA + "/messages";

        MensagemImportada mensagem = client
                .target(URI_LOCAWEB + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(KEY_AUTHORIZATION, TOKEN)
                .get(MensagemImportada.class);

        return Response.ok().build();
    }

}
