package gbrmrqs.testes.testescommockito;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Mensagem {

    private String id;
    private String mensagem;

    public Mensagem(final String mensagem) {
        this.id = UUID.randomUUID().toString();
        this.mensagem = mensagem;
    }
}
