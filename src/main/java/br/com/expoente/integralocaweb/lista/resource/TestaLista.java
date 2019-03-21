package br.com.expoente.integralocaweb.lista.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.exception.BusinessException;
import br.com.expoente.integralocaweb.lista.entity.ItemLista;
import br.com.expoente.integralocaweb.lista.entity.ListaLocaWeb;
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
@Path("listas")
@Produces(MediaType.APPLICATION_JSON)
public class TestaLista {

    Acessos acessos = new Acessos();

    private Client client;

    private String endPoint = acessos.getIdConta() + "/lists";

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();

    }

    public Response testa() {
        return Response.ok().build();
    }

    @GET
    public Response getListas() {

        ListaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ListaLocaWeb.class);

        for (ItemLista item : lista.getItems()) {
            System.out.println("LISTA: " + item.toString());
        }
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getLista(@PathParam("id") Integer id) {

        ListaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ListaLocaWeb.class);

        System.out.println("LISTA DETALHE: ");
        System.out.println("id: " + lista.getId()
                + "\nname: " + lista.getName()
                + "\ndescription: " + lista.getDescription()
                + "\ncontacts_count: " + lista.getContacts_count()
                + "\ncreated_at: " + lista.getCreated_at()
                + "\nupdated_at: " + lista.getUpdated_at());

        return Response.ok().build();
    }

    @GET
    @Path("criar")
    public void criaLista() {

        ListaLocaWeb listaEnvida = new ListaLocaWeb();

        listaEnvida.setName("Lista TESTE 4");
        listaEnvida.setDescription("Descricao lista DE LISTA TESTE 4");

        try {
            Response response = client
                    .target(acessos.getUriLocaWeb() + endPoint)
                    .request()
                    .header(acessos.getKeyAuthorization(), acessos.getToken())
                    .post(Entity.json(listaEnvida));

            if (response.getStatus() == 200) {
                Integer id = response.readEntity(JsonObject.class).getInt("id");
                listaEnvida.setIdLocaWeb(id);
                System.out.println("RESPONSE: " + listaEnvida.getIdLocaWeb());

            } else {
                throw new BusinessException("ERRO ao tentar cadastrar a LISTA: " + listaEnvida.getName() + " no LOCAWEB código de retorno: " + response.getStatus());
            }

        } catch (RuntimeException ex) {
            throw new BusinessException("Erro ao tentar cadastrar a LISTA", ex);
        }
    }

    @GET
    @Path("deletar/{id}")
    public void deletaLista(@PathParam("id") Integer id) {

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .delete();
        System.out.println("DELETADO....");
    }

    @GET
    @Path("alterar/{id}")
    public void alteraLista(@PathParam("id") Integer id) {

        ListaLocaWeb listaEnvida = new ListaLocaWeb();
        listaEnvida.setName("Lista TESTE 04 - ALTERADA");
        listaEnvida.setDescription("Descricao lista DE LISTA TESTE 04 ALTERADA");

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(listaEnvida));

        System.out.println("ALTERADO ...");
    }
}
