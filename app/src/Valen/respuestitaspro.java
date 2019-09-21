import java.util.*;
import java.io.IOException;

public class respuestitaspro {

    public static void main(String[] args) {

        System.out.println("Hola, aquí podras añadir los mensajes y las respuestas deseadas");

        ArrayList<String> condi = new ArrayList<String>();
        ArrayList<String> respt = new ArrayList<String>();
        Scanner recb;
        String imput;
        String yn = "";

        while (!yn.equals("n\r")) {

            System.out.println("Escribe el mensaje recibido");

            recb = new Scanner(System.in).useDelimiter("\n");

            imput = recb.next();

            condi.add(imput);

            System.out.println("Ahora escriba lo que desea responder");

            recb = new Scanner(System.in).useDelimiter("\n");

            imput = recb.next();

            respt.add(imput);

            System.out.println("¿Desea añadir mas respuestas? (Y/N)");

            recb = new Scanner(System.in).useDelimiter("\n");

            yn = recb.next();

        }

        System.out.println("Introduce tu mensaje");

        Scanner mss = new Scanner(System.in).useDelimiter("\n");

        msj msj1 = new msj(mss.next(), condi, respt);

        System.out.println(msj1.contestacion());
    }
}

class msj {

    public msj(String mensj, ArrayList<String> condi, ArrayList<String> respt) {

        mensaje = mensj;

        for (int i = 0; i < condi.size(); i++) {

            if (mensaje.contains(condi.get(i))) {

                respuesta += respt.get(i);

            }

        }

    }

    public String contestacion() {

        return respuesta;
    }

    private String mensaje;

    private String respuesta = "";
}
