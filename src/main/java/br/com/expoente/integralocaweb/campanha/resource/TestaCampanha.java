package br.com.expoente.integralocaweb.campanha.resource;

import br.com.expoente.integralocaweb.campanha.entity.CampanhaLocaWeb;
import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.exception.BusinessException;
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
@Path("campanhas")
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
    @Path("test")
    public Response test() {
        System.out.println("RESPONDIDO...");
        return Response.ok().build();
    }

    @GET
    public Response getLista() {

        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);
        CampanhaLocaWeb lista = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(CampanhaLocaWeb.class);

        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getCampanha(@PathParam("id") Integer id) {

        CampanhaLocaWeb campanha = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(CampanhaLocaWeb.class);

        return Response.ok().build();
    }

    @GET
    @Path("criar")
    public void criaCampanha() {

        CampanhaLocaWeb campanhaEnvida = new CampanhaLocaWeb();
        campanhaEnvida.setName("NOME: CAMPANHA TESTE 6");
        campanhaEnvida.setDescription("DESCRICAO: CAMPANHA TESTE 6");

        try {
            Response response = client
                    .target(acessos.getUriLocaWeb() + endPoint)
                    .request()
                    .header(acessos.getKeyAuthorization(), acessos.getToken())
                    .post(Entity.json(campanhaEnvida));

            if (response.getStatus() == 200) {
                Integer id = response.readEntity(JsonObject.class).getInt("id");
                campanhaEnvida.setIdLocaWeb(id);
            } else {
                throw new BusinessException("ERRO ao tentar cadastrar a LISTA: " + campanhaEnvida.getName() + " no LOCAWEB código de retorno: " + response.getStatus());
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
    }

    @GET
    @Path("alterar/{id}")
    public void alteraLista(@PathParam("id") Integer id) {

        CampanhaLocaWeb campanhaEnvida = new CampanhaLocaWeb();
        campanhaEnvida.setName("NOME: CAMPANHA TESTE 01 ALTERADA");
        campanhaEnvida.setDescription("DESCRICAO: CAMPANHA TESTE 01 ALTERADA");

        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(campanhaEnvida));
    }
}
