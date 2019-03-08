package br.com.expoente.integralocaweb.resource;

import br.com.expoente.integralocaweb.config.Acessos;
import br.com.expoente.integralocaweb.entity.ContatoCustomFields;
import br.com.expoente.integralocaweb.entity.ContatoExportadoLocaWeb;
import br.com.expoente.integralocaweb.entity.ContatoImportadoLocaWeb;
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
@Path("contato")
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
    @Path("test")
    public Response test() {
        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);
        System.out.println("CONTATO RESPONDIDO...");
        return Response.ok().build();
    }

    @GET
    public Response getLista() {

        System.out.println("ENDPONT: " + acessos.getUriLocaWeb() + endPoint);

        ContatoImportadoLocaWeb listagem = client
                .target(acessos.getUriLocaWeb() + endPoint)
                .request(MediaType.APPLICATION_JSON)
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .get(ContatoImportadoLocaWeb.class);

        System.out.println("LISTAGEM: " + listagem.toString());
        return Response.ok().build();
    }

    @GET
    @Path("cria")
    public void criaCampanha() {

        ContatoExportadoLocaWeb contatoExportado = new ContatoExportadoLocaWeb();

        contatoExportado.setEmail("email4@locaweb.com.br");
        contatoExportado.setList_ids(Arrays.asList("4fa136a52c1e581220000005"));
        contatoExportado.getCustom_fields().setNome("USUARIO TESTE 4");
        contatoExportado.getCustom_fields().setCidade("Curitiba/PR");
        contatoExportado.getCustom_fields().setData_de_nascimento("01/01/1980");

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
                throw new BusinessException("ERRO ao tentar cadastrar MENSAGEM: " + contatoExportado.getCustom_fields().getNome() + " no LOCAWEB código de retorno: " + response.getStatus());
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
    @Path("altera/{id}")
    public void alteraLista(@PathParam("id") Integer id) {

        ContatoExportadoLocaWeb contatoExportado = new ContatoExportadoLocaWeb();

        contatoExportado.setList_ids(Arrays.asList("4fa136a52c1e581220000005", "4fa136a52c1e58122000000"));
        contatoExportado.getCustom_fields().setNome("USUARIO TESTE 04 - ALTERADO");
        contatoExportado.getCustom_fields().setCidade("Curitiba");
        contatoExportado.getCustom_fields().setData_de_nascimento("09/12/1980");

        System.out.println("CONTATO: " + Entity.json(contatoExportado).toString());
        Response response = client
                .target(acessos.getUriLocaWeb() + endPoint + "/" + id)
                .request()
                .header(acessos.getKeyAuthorization(), acessos.getToken())
                .put(Entity.json(contatoExportado));

        System.out.println("ALTERADO ...");
    }

}
