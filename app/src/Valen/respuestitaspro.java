import java.util.*;
import java.util.regex.*;
import java.io.IOException;

public class respuestitaspro {

    public static void main(String[] args) {

        System.out.println("Hola, aquí podras añadir los mensajes y las respuestas deseadas");

        ArrayList<String> condi = new ArrayList<String>();
        ArrayList<String> respt = new ArrayList<String>();
        Scanner recb;
        String imput;
        String yn = "";

        while (!yn.equals("N\r")) {

           System.out.println("El mensaje se contestara sí \n1: Es una coincidencia exacta\n2: Si el mensaje contiene la(s) palabra(s)\n3: Comienza con la(s) palabra(s)\n4: Termine con la(s) palabra(s)");
           
           recb = new Scanner(System.in).useDelimiter("\r");

           imput = recb.next();
           
           switch (Integer.parseInt(imput)){
               
                case 1:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    recb = new Scanner(System.in).useDelimiter("\r"); 

                    imput = recb.next();

                    condi.add(imput);

                    break;
                }

                case 2:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    recb = new Scanner(System.in).useDelimiter("\r"); 

                    imput = ".*" + "(?)" + recb.next() + ".*";

                    condi.add(imput);

                    break;
                }

                case 3:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    recb = new Scanner(System.in).useDelimiter("\r"); 

                    imput = "^" + "(?)" + recb.next() + ".*";

                    condi.add(imput);

                    break;
                }

                case 4:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    recb = new Scanner(System.in).useDelimiter("\r"); 

                    imput = ".*" + "(?)" + recb.next() + "$";

                    condi.add(imput);

                    break;
                }
           }

            System.out.println("Ahora escriba lo que desea responder");

            recb = new Scanner(System.in).useDelimiter("\r");

            imput = recb.next();

            respt.add(imput);

            System.out.println("¿Desea añadir mas respuestas? (Y/N)");

            recb = new Scanner(System.in).useDelimiter("\n");

            yn = recb.next();

        }

        System.out.println("Introduce tu mensaje");

        Scanner mss = new Scanner(System.in);

        mss.useDelimiter("\n");

        msj msj1 = new msj(mss.next(), condi, respt);

        System.out.println(msj1.contestacion());

        mss.close();

    }
}

class msj {

    public msj(String mensj, ArrayList<String> condi, ArrayList<String> respt) {

        mensaje = mensj;

        for (int i = 0; i < condi.size(); i++) {

            mensaje.matches(condi.get(i));

            if  (mensaje.matches(condi.get(i)));{

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
