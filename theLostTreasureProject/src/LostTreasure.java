import generico.Utils;

public class LostTreasure {
    public static void main(String[] args) {
        Utils.limpiarConsola();

        // Declaración e inicialización de variables
        String direction = "", currentPosition = "centro";
        boolean playing = true, torch = false, machete = false, rope = false, shovel = false, userAnswer;
        int keys = 0;

        // Banner y texto de bienvenida
        System.out.println("\r\n" +
                "  ____  _                           _     _                 _                               _                   _ \r\n"
                + " |  _ \\(_)                         (_)   | |               | |                             | |                 | |\r\n"
                + " | |_) |_  ___ _ ____   _____ _ __  _  __| | ___     __ _  | | __ _    __ ___   _____ _ __ | |_ _   _ _ __ __ _| |\r\n"
                + " |  _ <| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\   / _` | | |/ _` |  / _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _` | |\r\n"
                + " | |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) | | (_| | | | (_| | | (_| |\\ V /  __/ | | | |_| |_| | | | (_| |_|\r\n"
                + " |____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   \\__,_| |_|\\__,_|  \\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\__,_(_)\r\n"
                + "                                                                                                                  \r\n"
                + "                                                                                                                  \r\n");

        System.out.println(
                "Has encontrado la localización del famoso tesoro del pirata Bytero, tu único problema es que tu avión perdió su motor y tuviste que saltar usando tu paracaídas, tuviste suerte y caíste en el templo principal, pero necesitarás usar tu ingenio para acceder al tesoro");

        System.out.println(" ____________________");
        System.out.println("|          ^          |");
        System.out.println("|                     |");
        System.out.println("|          N          |");
        System.out.println("|^       O + E       ^|");
        System.out.println("|          S          |");
        System.out.println("|                     |");
        System.out.println("|__________^__________|\n");

        // loop principal del juego: mientras playing sea igual a true y las llaves sean
        // menor a 4
        while (playing && keys < 4) {
            // cuando la ubicación sea centro, el menú de dirección se debe mostrar
            if ("centro".equals(currentPosition)) {
                direction = Utils.leerString(
                        "Te encuentras en un lugar extremadamente antiguo, rodeado de ruinas cubiertas de musgo y colapsadas.\n"
                                + "Observas un aparato en la piedra con indentaciones marcadas con las letras N, S, E, O.\n"
                                + "Los arcos de piedra se activan revelando diferentes lugares. Según el mapa, necesitarás cuatro llaves para acceder al tesoro.\n"
                                + "¿Hacia dónde te quieres dirigir? (Ingresa N, S, E, O u 'salir' para terminar):");

                if ("salir".equalsIgnoreCase(direction)) {
                    System.out.println("¡Gracias por jugar!");
                    playing = false;
                }
            }

            // Lógica de dirección
            switch (direction.toLowerCase()) {

                case "n":
                    currentPosition = "norte";
                    System.out.println("\nHas accedido al portal del norte, el cual te lleva a la dorada playa Oro AU. "
                            + "Observas arena y destellos; encuentras un contenedor con botellas (algunas rotas), tela y estacas que te podrían servir para hacer una antorcha. "
                            + "También notas un parche con palmeras y tierra dura, y una equis hecha con piezas de madera. "
                            + "El problema es que la tierra es muy dura para cavar. ¿Tienes una pala?");
                    torch = true;
                    if (shovel) {
                        System.out.println(
                                "Usas la pala para cavar con toda tu fuerza y encuentras una vieja llave. Tal vez puedas usarla en las ruinas.");
                        keys++;
                    } else {
                        System.out.println(
                                "Aún no tienes una pala. PISTA: Quizás en las zonas montañosas del Oeste encuentres una.");
                    }
                    break;

                case "s":
                    currentPosition = "sur";
                    System.out.println(
                            "Has accedido al portal del sur. Estás en la entrada de la cueva, parece que para entrar necesitas resolver un acertijo.");

                    acertijoCueva(); // Llamamos al procedimiento y luego seguimos con la lógica dentro de la
                                     // posición sur

                    if (torch) {
                        userAnswer = Utils.leerBoolean(
                                "Gracias a la antorcha que hiciste en la playa, puedes adentrarte en la cueva. "
                                        + "Las paredes están cubiertas de piedras filosas y minerales que destellan con la luz. "
                                        + "En el centro de la cueva hay un lago poco profundo y, en el fondo, ves un destello. "
                                        + "¿Deseas ir por el objeto?");

                        if (userAnswer) {
                            System.out.println(
                                    "Te lanzas al agua y nadas con fuerza hacia el objeto. Aunque pierdes el aliento, logras tomarlo. "
                                            + "Al salir, lo inspeccionas y ves que es la llave del sur.");
                            System.out.println(
                                    "De regreso al templo, encuentras un machete oxidado y lo guardas para la jungla del Este.");
                            machete = true;
                            keys++;
                        } else {
                            System.out.println("Deberías seguir explorando.");
                        }
                    } else {
                        System.out.println(
                                "Debes conseguir algo para iluminar tu camino, vuelve con una antorcha. PISTA: Quizás la encuentres en la playa.");
                    }
                    break;

                case "e":
                    currentPosition = "este";
                    System.out.println(
                            "Has accedido al portal del este y te encuentras en una jungla densa, repleta de enredaderas y helechos. "
                                    + "¿Tienes un machete?");
                    if (machete) {
                        System.out.println(
                                "Usas el machete para abrir un camino hasta llegar a un claro rodeado de enredaderas espinosas. "
                                        + "En el claro ves algo que parece otra llave. Si tuvieras una antorcha, podrías quemar las enredaderas secas y conseguir la llave. "
                                        + "¿Tienes una antorcha para quemarlas?");
                        if (torch) {
                            System.out.println(
                                    "Usas la antorcha para quemar la enredadera espinosa, luego de varios minutos puedes acceder a la llave del este. En el camino de retorno encuentras una cuerda, la guardas porque podría serte útil\n");
                            rope = true;
                            keys++;
                        } else {
                            System.out.println(
                                    "Deberías explorar más las ruinas o los otros portales. PISTA: Cerca de la playa NORTE hay botellas de licor y tela vieja");
                        }
                    } else {
                        System.out.println(
                                "Deberías explorar otras zonas y tratar de encontrar un machete. PISTA: Es probable que encuentres algo en las cuevas del sur");
                    }
                    break;

                case "o":
                    currentPosition = "oeste";
                    System.out.println(
                            "Has accedido al portal del oeste y te encuentras en una zona montañosa, rodeado de picos tan altos que tocan el cielo. "
                                    + "Frente a ti hay un pilote de madera; asomas tu cabeza y ves una plataforma donde un esqueleto sostiene lo que parece una llave, y cerca, una pala antigua. "
                                    + "Podrías bajar si amarras una cuerda al pilote. ¿Tienes algún tipo de cuerda?");
                    if (rope) {
                        System.out.println(
                                "Usando la cuerda que conseguiste en la jungla la amarras al pilote y logras descender a la plataforma "
                                        + "Adquieres la llave del oeste, la pala que viste está en muy buen estado y podrías usarla luego.");
                        shovel = true;
                        keys++;
                    } else {
                        System.out.println(
                                "Deberías buscar en otras zonas. PISTA: tal vez en la jungla del este hayan lianas o algo que funcione para bajar\n");
                    }
                    break;

                default:
                    System.out.println("Dirección inválida. Por favor ingresa N, S, E u O.");
                    currentPosition = "centro";
            }

            // Después de explorar un portal, si no está en el "centro", pregunta si el
            // jugador quiere regresar a las ruinas.

            if (!"centro".equals(currentPosition)) {
                userAnswer = Utils.leerBoolean("Deseas volver a las ruinas");
                if (userAnswer) {
                    currentPosition = "centro";
                    direction = "";
                } else {
                    System.out.println("Debes regresar a las ruinas para continuar la aventura.");
                    currentPosition = "centro";
                    direction = "";
                }
            }
        } // Fin del loop principal

        // Si el jugador todavía está jugando y ha recogido las 4 llaves, resuelve el
        // acertijo central.
        if (playing && keys == 4) {
            System.out.println(
                    "En hora buena, tienes todas las llaves para acceder al tesoro, ahora debes resolver el acertijo");
            acertijoCentro();
            System.out.println("\r\n" + //
                    "  ____ __       ______  ____  __    ___   ____    ___       ____  __     ______ __ __ _  _   ___   __\r\n"
                    + //
                    " ||    ||       | || | ||    (( \\  // \\\\  || \\\\  // \\\\     ||    (( \\    | || | || || \\\\//  // \\\\  ||\r\n"
                    + //
                    " ||==  ||         ||   ||==   \\\\  ((   )) ||_// ((   ))    ||==   \\\\       ||   || ||  )/  ((   )) ||\r\n"
                    + //
                    " ||___ ||__|      ||   ||___ \\_))  \\\\_//  || \\\\  \\\\_//     ||___ \\_))      ||   \\\\_// //    \\\\_//  ..\r\n"
                    + //
                    "                                                                                                     \r\n"
                    + //
                    "");
            System.out.println(
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@%%%%%%%%#%@@@@@@@@@@@@@@@@@@@@%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@%%%%%%%%%##@@@@@@@@@@@@@@@@@%%%%%%%%%%##%%%%%%%##############%%%%%%%%##@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%%%%%%%%%##*+++++++++++++++++++#%%%%%%%###+++++++++++++++++++*#%%%%%%%##%@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%%%%%%%%###++++++++++++++++++++#%%%%%%%###++++++++++++++++++++*%%%%%%%%##@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@%%%%%%%%###*++++++++++++++++++++#%%%%%%%###++++++++++++++++++++*#%%%%%%%###@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@%%%%%%%%###++++++++++++++++++++*#%%%%%%%###=++++++++++++++++++++#%%%%%%%%##%@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@%%%%%%%%###*++++++++++++++++++++*%%%%%%%%###+++++++++++++++++++++*%%%%%%%%###@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@%%%%%%%####+++++++++++++++++++++*%%%%%%%%###*+++++++++++++++++++++#%%%%%%%###%@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@%%%%%%%%####+++++++++++++++++++++*%%%%%%%#####+++++++++++++++++++++*%%%%%%%%###@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@%%%%%%%%####*+++++++++++++++++++++*############++++++++++++++++++++++#%%%%%%%###%@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@############++++++++++++++++++++++*############***+++++++++++++++++++*###########%@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@%###########*+++++++++++++++++++#%%%%%@@@%%%%%%%%%%%*++++++++++++++++++###########%@@@@@@@@@@\r\n"
                            + //
                            "@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@%#%%@@%########%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@\r\n"
                            + //
                            "@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%######%#%%######%%%%%%%%%%%%##%%%%%%%%%%%%%%%%%%%%%%%%@@@@@\r\n"
                            + //
                            "@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###%%%####%#####%%%%%%%%%%%%%%%%%%%%%%%%%#############@@@@@\r\n"
                            + //
                            "@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###%%####%##%%%%####%%%####################################@@@@@\r\n"
                            + //
                            "@@@@%###################################%%###%%###%%####%%####################################%@@@@@\r\n"
                            + //
                            "@@@@@%##################################%%#############%%%###################################%@@@@@@\r\n"
                            + //
                            "@@@@@@@@#**********+++++++++++++++++++++*%%%%%%%%%%%%%%%%%*+++++++++++++++++++++**********%@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@%**********+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**#####**#@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@#######***++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*#######**%@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@%#######***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*######**#@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@#######***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#######**%@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@%#######**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*######**#%@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@%#######**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#######**#@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@%######***+++++++++++++++++++++++++++++++++++++++++++++++++++++++++######**#%@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@%#######**++++++++++++++++++++++++++++++++++++++++++++++++++++++++*######**#@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@#######***+++++++++++++++++++++++++++++++++++++++++++++++++++++++#######**%@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%#######**+++++++++++++++++++++++++++++++++++++++++++++++++++++++#######**@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%#######**++++++++++++++++++++++++++++++++++++++++++++++++++++++*######**%@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@#######**++++++++++++++++++++++++++++++++++++++++++++++++++++++*#####***@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@%#########********************############################%%%%#%%%%%%%%%%%@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%##########################################################################@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@%##########################################################################@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%############################%@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
                            + //
                            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
        System.out.println("Gracias por jugar!");
    }

    // Procedimiento con acertijo central
    public static void acertijoCentro() {
        boolean puertaAbierta = false;
        String llave1, llave2, llave3, llave4;
        int numLlaves;

        llave1 = llave2 = llave3 = llave4 = "";

        System.out.println("Digita la cantidad de llaves que tienes:");
        numLlaves = Integer.parseInt(Utils.leerString(""));
        if (numLlaves == 4) {
            while (numLlaves == 4) {
                System.out.println(
                        "Estás frente al acertijo de la puerta central. Las únicas pistas que tienes son las notas que encontraste con las llaves y una nota que decía 1N2O3?4O-S");
                System.out.println(
                        "La llave 1 parece tener forma circular y podría calzar con la llave norte o la llave sur. ¿En qué letra deseas colocarla?");
                llave1 = Utils.leerString("");
                System.out.println(
                        "La llave 2 es cuadrada y encaja perfecto con la llave oeste. ¿En qué letra quieres ponerla?");
                llave2 = Utils.leerString("");
                System.out.println(
                        "La llave 3 posee forma triangular, y la nota decía que podía calzar en la posición este, oeste o sur, pero debes seguir el patrón correcto. ¿En qué letra deseas colocarla?");
                llave3 = Utils.leerString("");
                System.out.println(
                        "La llave 4 tiene forma de rombo y se decía que solo funcionaba en algo que apuntaba siempre hacia el sur, aunque también calza en el orificio norte. ¿En qué letra deseas ponerla?");
                llave4 = Utils.leerString("");

                if (llave1.equalsIgnoreCase("norte") && llave2.equalsIgnoreCase("oeste") &&
                        llave3.equalsIgnoreCase("este") && llave4.equalsIgnoreCase("sur")) {
                    puertaAbierta = true;
                    System.out.println(
                            "Al colocar las cuatro llaves correctamente, escuchas un mecanismo moverse y la puerta se abre mostrando una luz intensa.");
                    numLlaves--; // Para salir del bucle
                } else {
                    System.out.println("Las llaves están mal colocadas, prueba con otra combinación.");
                }
            }
        } else {
            System.out.println("Tienes " + numLlaves + " llaves, deberías tener 4.");
        }
        System.out.println("¡FELICIDADES! Lograste abrir la puerta.");
    }

    // Procedimiento con acertijo cueva
    public static void acertijoCueva() {
        String respuesta;
        int puntuacion, opcion, claveSecreta;
        boolean pistaEncontrada;

        pistaEncontrada = false;
        claveSecreta = 0;
        puntuacion = 0;

        System.out.println("¿Qué deseas hacer? (1) Examinar dibujo (2) Usar antorcha (3) Ir al este");
        opcion = Integer.parseInt(Utils.leerString(""));
        if (opcion == 1 || opcion == 2) {
            if (opcion == 1) {
                System.out.println(
                        "El dibujo muestra símbolos antiguos que, según tus conocimientos, son los números 52. Podría ser una pista.");
                pistaEncontrada = true;
                puntuacion += 100;
                System.out.println("Sumaste una vida.");
            }
            System.out.println("El pasadizo está muy oscuro. ¿Quieres usar tu antorcha? (Digita 2)");
            opcion = Integer.parseInt(Utils.leerString(""));
            while (opcion == 2 || claveSecreta != 52) {
                System.out.println(
                        "Alumbras la zona con tu antorcha y ves un mecanismo donde puedes ingresar un código de 2 dígitos.");
                System.out.println("Ingresa la combinación correcta para abrir la puerta:");
                claveSecreta = Integer.parseInt(Utils.leerString(""));
                opcion = 0;
            }
            System.out.println("¡FELICIDADES, lograste abrir la puerta y puedes ingresar a las cuevas!");
        } else {
            System.out.println("Volviendo al este.");
        }
    }
}
