package propriedade;

import menu.MenuUsuario;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Reserva{
    private Propriedade propriedade;
    private String dtCheckin;
    private String dtCheckout;
    private float custoTotal;

    public Reserva(Propriedade propriedade, String dtCheckin, String dtCheckout, float custoTotal ){
        this.propriedade = propriedade;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
        this.custoTotal = custoTotal;
    }

    public static void reservarPropriedade(List<Propriedade> listaPropriedades){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o titulo da propriedade que deseja alugar");
        String propriedade = scanner.next();

        for (Propriedade listaPropriedade : listaPropriedades) {
            if (propriedade.equals(listaPropriedade.getTitulo())) {

                System.out.println("Digite a data de checkIn");
                String dtCheckin = scanner.next();
                System.out.println("Digite a data de checkOut");
                String dtCheckout = scanner.next();

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataInicial = LocalDate.parse(dtCheckin);
                LocalDate dataFinal = LocalDate.parse(dtCheckout);

                String data1 = dataInicial.format(formato);
                String data2 = dataFinal.format(formato);

                int diferenca = Period.between(dataInicial, dataFinal).getDays();

                // custoTotal = diferenca * precoNoite(TRAZER DE PROPRIEDADE)

                System.out.println(diferenca);
                listaPropriedade.mudaDisponibilidade();
            }

        }
        System.out.println("Propriedade não encontrada, por favor verificar se o nome esta correto");
        MenuUsuario.abrirMenuUsuario(listaPropriedades);
    }

    public Propriedade getNomePropriedade(){
        return propriedade;
    }

}