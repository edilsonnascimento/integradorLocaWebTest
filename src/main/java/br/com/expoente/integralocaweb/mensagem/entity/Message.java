package br.com.expoente.integralocaweb.mensagem.entity;

/**
 *
 * @author ednascimento
 */
public class Message {

    private Mensagem message;

    public Message() {
        this.message = new Mensagem();
    }

    public Mensagem getMessage() {
        return message;
    }

    public void setMessage(Mensagem message) {
        this.message = message;
    }

}
