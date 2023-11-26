import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result;

        // Executar os testes da classe LoginTeste
        result = JUnitCore.runClasses(LoginTeste.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Executar os testes da classe ConteudoTeste
        result = JUnitCore.runClasses(ConteudoTeste.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Executar os testes da classe SerieTeste
        result = JUnitCore.runClasses(SerieTeste.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Executar os testes da classe SuporteTeste
        result = JUnitCore.runClasses(SuporteTeste.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Verificar se todos os testes foram bem-sucedidos
        if (result.wasSuccessful()) {
            System.out.println("Todos os testes foram bem-sucedidos!");
        } else {
            System.out.println("Alguns testes falharam.");
        }
    }
}
