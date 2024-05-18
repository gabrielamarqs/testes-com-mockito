package gbrmrqs.testes.testescommockito;

import lombok.Data;

@Data
public class DadosLocalizacao {
    public DadosLocalizacao(String uf, String cidade, String logradouro, String complemento, String bairro) {
        this.uf = uf;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
    }
    private String uf;
    private String cidade;
    private String logradouro;
    private String complemento;
    private String bairro;
}
