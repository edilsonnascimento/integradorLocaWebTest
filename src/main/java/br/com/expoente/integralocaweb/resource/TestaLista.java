package br.com.expoente.integralocaweb.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.entity.ListaExportadaLocaWeb;
import br.com.expoente.integralocaweb.entity.ListaImportadaLocaWeb;
import br.com.expoente.integralocaweb.excepetion.BusinessException;
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
@Path("lista")
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
    public Response getLista() {

        ListaImportadaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ListaImportadaLocaWeb.class);

        System.out.println("LISTA: " + lista.toString());
        return Response.ok().build();
    }

    @GET
    @Path("cria")
    public void criaLista() {

        ListaExportadaLocaWeb listaEnvida = new ListaExportadaLocaWeb();

        listaEnvida.setName("Lista TESTE 3");
        listaEnvida.setDescription("Descricao lista DE LISTA TESTE 3");

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
    @Path("deleta/{id}")
    public void deletaLista(@PathParam("id") Integer id) {

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .delete();
        System.out.println("DELETADO....");
    }

    @GET
    @Path("altera")
    public void alteraLista() {

        Integer id = 132;

        ListaExportadaLocaWeb listaEnvida = new ListaExportadaLocaWeb();
        listaEnvida.setName("Lista TESTE 02 NOVO");
        listaEnvida.setDescription("Descricao lista DE LISTA TESTE 02 NOVO");

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(listaEnvida));

        System.out.println("ALTERADO ...");
    }
}
