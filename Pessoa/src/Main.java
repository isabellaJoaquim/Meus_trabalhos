import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Pessoa pessoa1 = new Pessoa();

        pessoa1.nome="isabella";
        pessoa1.idade= 17;
        pessoa1.cpf="999.999.999-99";

        pessoa1.correr();
        System.out.println(pessoa1.nome);
        System.out.println(pessoa1.cpf);
        System.out.println(pessoa1.idade);
    }
}
