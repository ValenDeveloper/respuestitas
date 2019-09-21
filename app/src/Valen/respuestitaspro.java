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

        recb = new Scanner(System.in).useDelimiter("\r");

        while (!yn.equals("N")) {

           System.out.println("El mensaje se contestara sí \n1: Es una coincidencia exacta\n2: Si el mensaje contiene la(s) palabra(s)\n3: Comienza con la(s) palabra(s)\n4: Termine con la(s) palabra(s)");

           imput = recb.next();
           
           switch (Integer.parseInt(imput)){
               
                case 1:{

                    recb.nextLine();

                    System.out.println("Escribe el mensaje al que desea responder"); 

                    imput = recb.next();

                    condi.add(imput);

                    break;
                }

                case 2:{

                    recb.nextLine();

                    System.out.println("Escribe el mensaje al que desea responder"); 

                    imput = ".*" + "(?)" + recb.next() + ".*";

                    condi.add(imput);

                    break;
                }

                case 3:{

                    recb.nextLine();

                    System.out.println("Escribe el mensaje al que desea responder");

                    imput = "^" + "(?)" + recb.next() + ".*";

                    condi.add(imput);

                    break;
                }

                case 4:{

                    recb.nextLine();

                    System.out.println("Escribe el mensaje al que desea responder");

                    imput = ".*" + "(?)" + recb.next() + "$";

                    condi.add(imput);

                    break;
                }
           }

           recb.nextLine();

            System.out.println("Ahora escriba lo que desea responder")

            imput = recb.next();

            respt.add(imput);

            recb.nextLine();

            System.out.println("¿Desea añadir mas respuestas? (Y/N)");

            yn = recb.next();

        }

        recb.nextLine();

        System.out.println("Introduce tu mensaje");

        msj msj1 = new msj(recb.next(), condi, respt);

        System.out.println(msj1.contestacion());
        
        recb.close();

    }
}

class msj {

    public msj(String mensj, ArrayList<String> condi, ArrayList<String> respt) {

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
