package br.com.expoente.integralocaweb.mensagem.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.exception.BusinessException;
import br.com.expoente.integralocaweb.mensagem.entity.Item;
import br.com.expoente.integralocaweb.mensagem.entity.Mensagem;
import br.com.expoente.integralocaweb.mensagem.entity.Message;
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
@Path("mensagens")
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

        Mensagem lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(Mensagem.class);

        System.out.println("{");
        for (Item item : lista.getItems()) {
            System.out.println("    " + item.toString());
        }
        System.out.println("    page: {"
                + "\n       current: " + lista.getPage().getCurrent()
                + "\n       total: " + lista.getPage().getTotal()
                + "\n   }"
                + "\n}");

        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getMensagem(@PathParam("id") Integer id) {

        Mensagem lista = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(Mensagem.class);

        System.out.println("{"
                + "\n   id: " + lista.getId() + ","
                + "\n   name: " + lista.getName() + ","
                + "\n   campaign_name: " + lista.getCampaign_name() + ","
                + "\n   status: " + lista.getStatus() + ","
                + "\n   scheduled_to: " + lista.getScheduled_to() + ","
                + "\n   subject: " + lista.getSubject() + ","
                + "\n   html_body: " + lista.getHtml_body() + ","
                + "\n   text_body: " + lista.getText_body() + ","
                + "\n   sender: " + lista.getSender() + ","
                + "\n   domain: " + lista.getDomain_id() + ","
                + "\n   contacts_count: " + lista.getContacts_count() + ","
                + "\n   created_at: " + lista.getCreated_at() + ","
                + "\n   updated_at: " + lista.getUpdated_at() + ","
                + "\n   lists: ["
                + "{id: " + lista.getLists().get(0).getId() + ","
                + "name: " + lista.getLists().get(0).getName() + ","
                + "description: " + lista.getLists().get(0).getDescription() + ","
                + "contacts_count: " + lista.getLists().get(0).getContacts_count() + ","
                + "created_at: " + lista.getLists().get(0).getCreated_at() + ","
                + "nupdated_at: " + lista.getLists().get(0).getUpdated_at() + "} ]"
                + "\n   preview: " + lista.getPreview()
                + "\n}");

        return Response.ok().build();
    }

    @GET
    @Path("criar")
    public Response criaCampanha() {

        System.out.println("ENDPOINT: " + acessos.getUriLocaWeb() + endPoint);

        Message mensagemExportada = new Message();

        mensagemExportada.getMessage().setCampaign_id("24");
        mensagemExportada.getMessage().setDomain_id("4fe4dc122c1e5806df000010");
        mensagemExportada.getMessage().setHtml_body("<h1>Conteúdo da mensagem em HTML</h1>");
        mensagemExportada.getMessage().setText_body("Conteúdo da mensagem.....");
        mensagemExportada.getMessage().setList_ids(Arrays.asList("4fa136a52c1e581220000005"));
        mensagemExportada.getMessage().setName("MENSAGEM NOME TESTE API 3");
        mensagemExportada.getMessage().setSender_name("NOME DO DESTINATARIO");
        mensagemExportada.getMessage().setSender("suporte@fatecpr.edu.br");
        mensagemExportada.getMessage().setSubject("ASSUNTO MENSAGEM API 3");
        mensagemExportada.getMessage().setScheduled_to("now");

        System.out.println("MENSAGEM EXPORTADA: " + mensagemExportada.toString());

        try {
            Response response = client
                    .target(acessos.getUriLocaWeb() + endPoint)
                    .request(MediaType.APPLICATION_JSON)
                    .header(acessos.getKeyAuthorization(), acessos.getToken())
                    .post(Entity.json(mensagemExportada));

            if (response.getStatus() == 200) {
                Integer id = response.readEntity(JsonObject.class).getInt("id");
                mensagemExportada.getMessage().setIdLocaWeb(id);
                System.out.println("RESPONSE: " + mensagemExportada.getMessage().getIdLocaWeb());

                return Response.ok().build();

            } else {
                throw new BusinessException("ERRO ao tentar cadastrar a MENSAGEM " + "'" + mensagemExportada.getMessage().getName()
                        + "' " + response.getStatus() + " :" + response.readEntity(JsonObject.class).getString("errors") + ".");
            }

        } catch (RuntimeException ex) {
            throw new BusinessException("Erro ao tentar cadastrar a MENSAGEM", ex);
        }

    }

    @GET
    @Path("deletar/{id}")
    public Response deletaLista(@PathParam("id") Integer id) {

        System.out.println("DELETE ENDPOINT: " + acessos.getUriLocaWeb() + endPoint + "/" + id);

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .delete();

        if (response.getStatus() == 204) {
            System.out.println("DELETADO....");
            return Response.noContent().build();
        } else {
            System.out.println("ERRRO: " + response.getStatus());
            return Response.status(response.getStatus()).build();
        }
    }

    @GET
    @Path("alterar/{id}")
    public Response alteraLista(@PathParam("id") Integer id) {

        Mensagem mensagemExportada = new Mensagem();

        mensagemExportada.setDomain_id("4fa136a52c1e58122032577005A");
        mensagemExportada.setHtml_body("<h1>Conteúdo da mensagem em HTML</h1>");
        mensagemExportada.setText_body("Conteúdo da mensagem.....");
        mensagemExportada.setList_ids(Arrays.asList("4fa136a52c1e581220000005A"));
        mensagemExportada.setName("MENSAGEM TESTE API 01 - ALTERADA");
        mensagemExportada.setSender_name("CAMPANHA TESTE 01 ALTERADA");
        mensagemExportada.setSender("suporte@fatecpr.edu.br");
        mensagemExportada.setSubject("ASSUNTO MENSAGEM MENSAGEM 01 ALTERADA");

        Message message = new Message();

        message.setMessage(mensagemExportada);

        System.out.println("endPoint: " + acessos.getUriLocaWeb() + endPoint + "/" + id);
        System.out.println("BODY: " + Entity.json(mensagemExportada).toString());
        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(message));

        if (response.getStatus() == 204) {
            System.out.println("ALTERANDO....");
            return Response.noContent().build();
        } else {
            System.out.println("ERRRO: " + response.getStatus());
            return Response.status(response.getStatus()).build();
        }

    }

}
