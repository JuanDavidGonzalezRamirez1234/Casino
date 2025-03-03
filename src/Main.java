import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double dinero;

        System.out.println("Ingrese su dinero:");
        dinero = teclado.nextDouble();

        CasinoGame juego = new CasinoGame(dinero);
        boolean seguirJugando = true;

        while (seguirJugando) {
            juego.jugar();

            System.out.println("¿Quieres jugar otra vez? (1: Sí, 2: No)");
            int opcion = teclado.nextInt();

            if (opcion != 1) {
                seguirJugando = false;
            }
        }

        teclado.close();
    }
}

class CasinoGame {
    private double dinero;

    public CasinoGame(double dineroInicial) {
        this.dinero = dineroInicial;
    }

    public void jugar() {
        Random random = new Random();
        int resultado = random.nextInt(3) + 1;
        System.out.println("Numero Generado: "+ resultado);



        switch (resultado) {
            case 1:
                dinero *= 2;
                System.out.println("Ganaste dinero: " + dinero);
                break;
            case 2:
                dinero /= 2;
                System.out.println("Perdiste la mitad: " + dinero);
                break;
            case 3:
                dinero = 0;
                System.out.println("Perdiste todo. Tu dinero ahora es: " + dinero);
                break;
        }
    }
}