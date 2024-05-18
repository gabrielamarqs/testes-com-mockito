package gbrmrqs.testes.testescommockito;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
    
    // api dos correios mockada
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    // injetando o mock na classe que será testada
    // que no caso ela seria instanciada, mas como ela é um mock, ela é injetada
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("PR", "Palmas", "Cearaz", "centro", "Catará");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("88888-555")).thenReturn(null);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Sabrina", "77445566", LocalDate.now(), "88888-555");
        
//        assertEquals("Sabrina", pessoa.getNome());
//        assertEquals("77445566", pessoa.getDocumento());
//        assertEquals("PR", pessoa.getEndereco().getUf());
//        assertEquals("Palmas", pessoa.getEndereco().getCidade());
        assertNull(pessoa.getEndereco());
    }

    @Test
    void lancarExceptionQuandoChamarApiDosCorreios() {
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Sabrina", "77445566", LocalDate.now(), "88888-555"));
    }
}
