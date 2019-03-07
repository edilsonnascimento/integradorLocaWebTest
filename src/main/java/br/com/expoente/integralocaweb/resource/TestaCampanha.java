package br.com.expoente.integralocaweb.resource;

import br.com.expoente.integralocaweb.entity.CampanhaImportadaLocaWeb;
import br.com.expoente.integralocaweb.entity.ListaEnviadaLocaWeb;
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
@Path("campanha")
@Produces(MediaType.APPLICATION_JSON)
public class TestaCampanha {

    Acessos acessos = new Acessos();

    private Client client;

    private String endPoint = acessos.getIdConta() + "/campaigns";

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();

    }

    @GET
    @Path("/test")
    public Response test() {
        System.out.println("RESONDIDO");
        return Response.ok().build();
    }

    @GET
    public Response getLista() {

        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);
        CampanhaImportadaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(CampanhaImportadaLocaWeb.class);

        System.out.println("LISTA: " + lista.toString());
        return Response.ok().build();
    }

    @GET
    @Path("cria")
    public void criaLista() {

        ListaEnviadaLocaWeb listaEnvida = new ListaEnviadaLocaWeb();

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

        ListaEnviadaLocaWeb listaEnvida = new ListaEnviadaLocaWeb();
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
