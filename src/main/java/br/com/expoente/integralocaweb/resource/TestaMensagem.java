package br.com.expoente.integralocaweb.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.entity.MensagemExportadaLocaWeb;
import br.com.expoente.integralocaweb.entity.MensagemImportadaLocaWeb;
import br.com.expoente.integralocaweb.excepetion.BusinessException;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ednascimento
 */
@Path("mensagem")
@Produces(MediaType.APPLICATION_JSON)
public class TestaMensagem {

    Acessos acessos = new Acessos();

    private Client client;

    private String endPoint = acessos.getIdConta() + "/messages";

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();

    }

    @GET
    @Path("test")
    public Response test() {
        System.out.println("ENDPOINT: https://DOMINIO/api/v1/accounts/ID_CONTA/messages");
        System.out.println("ENDPOINT: " + acessos.getUriLocaWeb() + endPoint);
        return Response.ok().build();
    }

    @GET
    public Response getLista() {

        MensagemImportadaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(MensagemImportadaLocaWeb.class);

        System.out.println("LISTA: " + lista.toString());
        return Response.ok().build();
    }

    @GET
    @Path("cria")
    public Response criaCampanha() {

        System.out.println("ENDPOINT: " + acessos.getUriLocaWeb() + endPoint);

        MensagemExportadaLocaWeb mensagemExportada = new MensagemExportadaLocaWeb();

        mensagemExportada.setCampaign_id("24");
        mensagemExportada.setDomain_id("4fa136a52c1e58122032577005");
        mensagemExportada.setHtml_body("<h1>Conteúdo da mensagem em HTML</h1>");
        mensagemExportada.setText_body("Conteúdo da mensagem.....");
        mensagemExportada.setList_ids(Arrays.asList("4fa136a52c1e581220000005"));
        mensagemExportada.setName("MENSAGEM NOME TESTE API 2");
        mensagemExportada.setSender_name("NOME DO DESTINATARIO");
        mensagemExportada.setSender("suporte@fatecpr.edu.br");
        mensagemExportada.setSubject("ASSUNTO MENSAGEM MENSAGEM 2");
        mensagemExportada.setScheduled_to("2019/03/09 00:00:00");

        System.out.println("MENSAGEM EXPORTADA: " + mensagemExportada.toString());

        try {
            Response response = client
                    .target(acessos.getUriLocaWeb() + endPoint)
                    .request()
                    .header(acessos.getKeyAuthorization(), acessos.getToken())
                    .post(Entity.json(mensagemExportada));

            if (response.getStatus() == 200) {
                Integer id = response.readEntity(JsonObject.class).getInt("id");
                mensagemExportada.setIdLocaWeb(id);
                System.out.println("RESPONSE: " + mensagemExportada.getIdLocaWeb());

                return Response.ok().build();

            } else {
                throw new BusinessException("ERRO ao tentar cadastrar a MENSAGEM " + "'" + mensagemExportada.getName()
                        + "' " + response.getStatus() + " :" + response.readEntity(JsonObject.class).getString("errors") + ".");
            }

        } catch (RuntimeException ex) {
            throw new BusinessException("Erro ao tentar cadastrar a MENSAGEM", ex);
        }
    }

    @GET
    @Path("deleta/{id}")
    public void deletaLista(@PathParam("id") Integer id) {

        System.out.println("DELETE ENDPOINT: " + acessos.getUriLocaWeb() + endPoint + "/" + id);

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .delete();

        if (response.getStatus() == 204) {
            System.out.println("DELETADO....");
        } else {
            System.out.println("ERRRO: " + response.getStatus());
        }

    }

    @GET
    @Path("altera/{id}")
    public void alteraLista(@PathParam("id") Integer id) {

        MensagemExportadaLocaWeb mensagemExportada = new MensagemExportadaLocaWeb();

        mensagemExportada.setDomain_id("4fa136a52c1e58122032577005A");
        mensagemExportada.setHtml_body("<h1>Conteúdo da mensagem em HTML - ALTERADA</h1>");
        mensagemExportada.setText_body("Conteúdo da mensagem..... ALTERADA");
        mensagemExportada.setList_ids(Arrays.asList("4fa136a52c1e581220000005A"));
        mensagemExportada.setName("MENSAGEM NOME TESTE API 2 - ALTERADA");
        mensagemExportada.setSender_name("NOME DO DESTINATARIO - ALTERADA");
        mensagemExportada.setSender("suporte@fatecpr.edu.br");
        mensagemExportada.setSubject("ASSUNTO MENSAGEM MENSAGEM 2 - ALTERADA");

        System.out.println("endPoint: " + acessos.getUriLocaWeb() + endPoint + "/" + id);
        System.out.println("BODY: " + Entity.json(mensagemExportada).toString());
        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(mensagemExportada));

        if (response.getStatus() == 204) {
            System.out.println("ALTERANDO....");
        } else {
            System.out.println("ERRRO: " + response.getStatus());
        }

    }

}
