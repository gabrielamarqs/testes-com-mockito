package gbrmrqs.testes.testescommockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;
    @Test
    void validarDadosEnviadosParaPlataforma() {
        String enderecoEmail = "usuario@test.com.br";
        String mensagem = "Olá, mundo!";
        boolean ehFormatoHtml = false;

        servico.enviaEmail(enderecoEmail, mensagem, ehFormatoHtml);

        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();

        Assertions.assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
}
