package gbrmrqs.testes.testescommockito;

import lombok.Data;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

@Data
public final class GeradorDeNumeros {

    private static SplittableRandom random = new SplittableRandom();

    public static List<Integer> geraNumerosAleatorios(int tamanhoLista) {
        return random.ints().boxed().limit(tamanhoLista).collect(Collectors.toList());
    }

    public static List<Integer> geraNumerosAleatorios() {
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }
}
