import java.util.*;
import java.util.regex.*;
import java.io.IOException;

public class respuestitaspro {

    public static void main(String[] args) {

        System.out.println("Hola, aquí podras añadir los mensajes y las respuestas deseadas");

        ArrayList<String> condi = new ArrayList<String>();
        ArrayList<String> respt = new ArrayList<String>();
        Scanner recb;
        String input;
        String yn = "";

        recb = new Scanner(System.in).useDelimiter("\r");

        while (!yn.equals("N")) {
            
            recb.nextLine()

            System.out.println("El mensaje se contestara sí \n1: Es una coincidencia exacta\n2: Si el mensaje contiene la(s) palabra(s)\n3: Comienza con la(s) palabra(s)\n4: Termine con la(s) palabra(s)");

            input = recb.next();
           
            recb.nextLine();

           switch (Integer.parseInt(input)){
               
                case 1:{

                    System.out.println("Escribe el mensaje al que desea responder"); 

                    input = recb.next();

                    break;
                }

                case 2:{

                    System.out.println("Escribe el mensaje al que desea responder"); 

                    input = ".*" + "(?)" + recb.next() + ".*";

                    break;
                }

                case 3:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    input = "^" + "(?)" + recb.next() + ".*";

                    break;
                }

                case 4:{

                    System.out.println("Escribe el mensaje al que desea responder");

                    input = ".*" + "(?)" + recb.next() + "$";

                    break;
                }
           }

           condi.add(input);

           recb.nextLine();

            System.out.println("Ahora escriba lo que desea responder");

            input = recb.next();

            respt.add(input);

            recb.nextLine();

            System.out.println("¿Desea añadir mas respuestas? (Y/N)");

            yn = recb.next();

        }

        recb.nextLine();

        System.out.println("Introduce tu mensaje");

        Msj msj1 = new Msj(recb.next(), condi, respt);

        System.out.println(msj1.contestacion());
        
        recb.close();

    }
}

class Msj {

    public Msj(String mensj, ArrayList<String> condi, ArrayList<String> respt) {

        mensaje = mensj;

        for (int i = 0; i < condi.size(); i++) {

            mensaje.matches(condi.get(i));

            if  (mensaje.matches(condi.get(i)));{

                respuesta += respt.get(i); 
                
                respuesta += " ";

            }

        }

    }

    public String contestacion() {

        return respuesta;
    }

    private String mensaje;

    private String respuesta = "";
}
