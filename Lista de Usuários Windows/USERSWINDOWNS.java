import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListWindowsUsers {

    public static void main(String[] args) {
        try {
            // Comando para listar os usuários no Windows
            String command = "net user";

            // Executa o comando
            Process process = Runtime.getRuntime().exec(command);

            // Lê a saída do comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            System.out.println("Contas de usuário no Windows:");
            while ((line = reader.readLine()) != null) {
                // Filtra as linhas que contêm os nomes dos usuários
                if (!line.trim().isEmpty() && !line.startsWith("-----") && !line.startsWith("Os comandos")) {
                    System.out.println(line.trim());
                }
            }

            // Fecha o leitor
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
