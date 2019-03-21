package br.com.expoente.integralocaweb.contato.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.contato.entity.ContatoLocaWeb;
import br.com.expoente.integralocaweb.exception.BusinessException;
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
@Path("contatos")
@Produces(MediaType.APPLICATION_JSON)
public class TestaContato {

    Acessos acessos = new Acessos();

    private Client client;

    private String endPoint = acessos.getIdConta() + "/contacts";

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();

    }

    @GET
    @Path("testar")
    public Response test() {
        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);
        System.out.println("CONTATO RESPONDIDO...");
        return Response.ok().build();
    }

    @GET
    public Response getLista() {

        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);

        ContatoLocaWeb listagem = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ContatoLocaWeb.class);

        System.out.println("LISTAGEM: " + listagem.toString());

        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getContato(@PathParam("id") Integer id) {

        ContatoLocaWeb contato = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ContatoLocaWeb.class);

        System.out.println("ENDPOINT: " + acessos.getUriLocaWeb() + endPoint + "/" + id);
        System.out.println("CONTATO: " + contato.toString());

        return Response.ok().build();
    }

    @GET
    @Path("criar")
    public void criaCampanha() {

        ContatoLocaWeb contatoExportado = new ContatoLocaWeb();

        contatoExportado.setEmail("email5@locaweb.com.br");
        contatoExportado.setList_ids(Arrays.asList("4fa136a52c1e581220000005"));
        contatoExportado.getCustom_fields().getFields().setNome("USUARIO TESTE 5");
        contatoExportado.getCustom_fields().getFields().setCidade("Curitiba/PR");
        contatoExportado.getCustom_fields().getFields().setData_de_nascimento("01/01/1980");

        try {
            Response response = client
                    .target(acessos.getUriLocaWeb() + endPoint)
                    .request()
                    .header(acessos.getKeyAuthorization(), acessos.getToken())
                    .post(Entity.json(contatoExportado));

            if (response.getStatus() == 200) {
                Integer id = response.readEntity(JsonObject.class).getInt("id");
                contatoExportado.setIdLocaWeb(id);
                System.out.println("RESPONSE: " + contatoExportado.getIdLocaWeb());
            } else {
                throw new BusinessException("ERRO ao tentar cadastrar MENSAGEM: " + contatoExportado.getCustom_fields().getFields().getNome() + " no LOCAWEB código de retorno: " + response.getStatus());
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

        ContatoLocaWeb contatoExportado = new ContatoLocaWeb();

        contatoExportado.setList_ids(Arrays.asList("4fa136a52c1e581220000005", "4fa136a52c1e58122000000"));
        contatoExportado.getCustom_fields().getFields().setNome("USUARIO TESTE 05 - ALTERADO");
        contatoExportado.getCustom_fields().getFields().setCidade("Curitiba");
        contatoExportado.getCustom_fields().getFields().setData_de_nascimento("09/12/1980");

        System.out.println("CONTATO: " + Entity.json(contatoExportado).toString());
        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(contatoExportado));

        System.out.println("ALTERADO ...");
    }
}
