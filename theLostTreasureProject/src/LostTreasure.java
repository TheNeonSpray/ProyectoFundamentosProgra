import generico.Utils;

public class LostTreasure {
    public static void main(String[] args) {
        Utils.limpiarConsola();

        String direction = "", userAnswer, currentPosition = "centro";
        boolean playing = true;

        System.out.println("\r\n" +
                "  ____  _                           _     _                 _                               _                   _ \r\n"
                +
                " |  _ \\(_)                         (_)   | |               | |                             | |                 | |\r\n"
                +
                " | |_) |_  ___ _ ____   _____ _ __  _  __| | ___     __ _  | | __ _    __ ___   _____ _ __ | |_ _   _ _ __ __ _| |\r\n"
                +
                " |  _ <| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\   / _` | | |/ _` |  / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _` | |\r\n"
                +
                " | |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) | | (_| | | | (_| | | (_| |\\ V /  __/ | | | |_| |_| | | | (_| |_|\r\n"
                +
                " |____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   \\__,_| |_|\\__,_|  \\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\__,_(_)\r\n"
                +
                "                                                                                                                  \r\n"
                +
                "                                                                                                                  \r\n");

        System.out.println(
                "Has encontrado la localización del famoso tesoro del pirata Bytero, tu único problema es que tu avión perdió su motor y tuviste que saltar usando tu paracaídas, tuviste suerte y caíste en el templo principal pero necesitaras usar tu ingenio para acceder al tesoro\n");
        // Mapa agregado, Esteban
        System.out.println(" ____________________");
        System.out.println("|          ^          |");
        System.out.println("|                     |");
        System.out.println("|          N          |");
        System.out.println("|^       O + E       ^|");
        System.out.println("|          S          |");
        System.out.println("|                     |");
        System.out.println("|__________^__________|\n");

        while (playing) {
            // Si el jugador está en el centro, se muestra el menú para elegir dirección
            if (currentPosition.equals("centro")) {
                direction = Utils.leerString(
                        "Te encuentras en un lugar extremadamente antiguo, rodeado de ruinas cubiertas de musgo y colapsadas.\n"
                                +
                                "Observas un aparato en la piedra con indentaciones marcadas con las letras N, S, E, O.\n"
                                +
                                "Los arcos de piedra cercanos se activan revelando diferentes lugares. Según el mapa, necesitarás cuatro llaves para acceder al tesoro.\n"
                                +
                                "¿Hacia dónde te quieres dirigir? (Ingresa N, S, E, O o 'salir' para terminar):");
                direction = direction.toLowerCase();
                if (direction.equals("salir")) {
                    System.out.println("¡Gracias por jugar!");
                    playing = false;
                }
            }

            // Procesamos la exploración según la dirección seleccionada
            switch (direction) {
                case "n":
                    currentPosition = "norte";
                    userAnswer = Utils.leerString(
                            "\nHas accedido al portal del norte, el cual te lleva a la dorada playa Oro AU, lo único que ves es arena y pequeños destellos de pertenencias olvidadas entre esas pertenencias encuentras un contenedor con botellas de algún tipo de licor muchas de ellas están rotas pero logras rescatar 2, así como un poco de tela y algunas estacas con las que podrías hacer una antorcha, mientras exploras también notas un pequeño parche con algunas palmeras y tierra un poco más dura y una equis hecha con un par de piezas de madera, es este el tesoro de bytero? el problema es que la tierra es muy dura para usar tus manos. ¿tienes una pala?\n");
                    if (userAnswer.equalsIgnoreCase("si")) {
                        System.out.println(
                                "Usas la pala para cavar y encuentras una vieja llave, tal vez puedas usarla en las ruinas.");
                    } else {
                        System.out.println("Deberías explorar un poco más.");
                    }
                    break;
                case "s":
                    currentPosition = "sur";
                    userAnswer = Utils.leerString(
                            "Has accedido al portal del sur y entras en una cueva oscura. ¿Tienes una antorcha? \n ");
                    if (userAnswer.equalsIgnoreCase("si")) {
                        System.out.println(
                                "Te encuentras en una cueva húmeda y fría, las paredes están cubiertas de piedras filosas y pequeños minerales que reaccionan a la luz, creando pequeños destellos, en el centro de la cueva se encuentra un pequeño lago un poco profundo, en el centro del lago y en el fondo ves un destellos, parece un objeto que fue hecho a partir del mismo mineral de las paredes que reacciona con la luz. \n ¿que deseas hacer? \n");
                    } else {
                        System.out.println("Debes conseguir algo para iluminar tu camino y volver luego.");
                    }
                    break;
                case "e":
                    currentPosition = "este";
                    userAnswer = Utils.leerString(
                            "Has accedido al portal del este y te encuentras en una jungla densa, tan llena de enredaderas y helechos que casi no te puedes mover, si tuvieras un machete podrías abrirte paso y hasta cortar algo de enredadera que te podria ser util luego. \n ¿tienes un machete?\n");
                    if (userAnswer.equalsIgnoreCase("si")) {
                        userAnswer = Utils.leerString(
                                "Usas el machete para abrir un camino hasta llegar a lo que parece un claro, en el claro ves una masa de plantas espinosas completamente densa, notas que aunque hay muchas, están secas, vez algo en el centro de la masa de espinas, algo que parece otra llave, si tuvieras una antorcha podrias quemar la enredadera espinosa seca y conseguir la llave, \n ¿tienes una antorcha para quemarlas?\n");
                        if (userAnswer.equalsIgnoreCase("si")) {
                            System.out.println("La antorcha quema las enredaderas y consigues la llave del Este.");
                        } else {
                            System.out.println("Deberías explorar más las ruinas o los otros portales");
                        }
                    } else {
                        System.out.println("Deberías explorar otras zonas y tratar de encontrar un machete.");
                    }
                    break;
                case "o":
                    currentPosition = "oeste";
                    userAnswer = Utils.leerString(
                            "Has accedido al portal del oeste, te encuentras en una zona montañosa, estás rodeado de picos monumentalmente tan grandes que tocan el cielo, pero notas que frente a ti hay como un tipo de pilote de madera, asomas tu cabeza en el borde y ves que algunos metros más abajo hay un tipo de plataforma, en la plataforma notas un esqueleto con lo que parece una llave en su mano y cerca de el vez una pala antigua, podrías bajar si amarraras algún tipo de cuerda al pilote, \n ¿Tienes algún tipo de cuerda?\n");
                    if (userAnswer.equalsIgnoreCase("si")) {
                        System.out.println(
                                "usando las enredaderas que conseguiste en la jungla las amarras al pilote y logra descender a la plataforma y logras adquirir la llave del oeste, la pala que viste esta en muy buen estado y podrías usarla luego.");
                    } else {
                        System.out.println(
                                "Deberías buscar en otras zonas, tal vez en la jungla, para encontrar una cuerda.");
                    }
                    break;
                default:
                    System.out.println("Dirección inválida. Por favor ingresa N, S, E u O.");
                    // Forzamos que vuelva al centro para intentar de nuevo
                    currentPosition = "centro";
            }

            // Después de la exploración, si no estamos en el centro, se pregunta si desea
            // regresar
            if (!currentPosition.equals("centro")) {
                userAnswer = Utils.leerString("¿Deseas volver a las ruinas (centro)? (si/no): ");
                if (userAnswer.equalsIgnoreCase("si")) {
                    currentPosition = "centro";
                    // Se reinicia la variable direction para que se muestre el menú en la siguiente
                    // iteración
                    direction = "";
                } else {
                    System.out.println("Como requisito, debes regresar a las ruinas para continuar la aventura.");
                    currentPosition = "centro";
                    direction = "";
                }
            }
        }
    }
}
