import generico.Utils;

public class LostTreasure {
    public static void main(String[] args) {
        Utils.limpiarConsola();

        String direction, userAnswer;

        System.out.println(
                "Has encontrado la localización del famoso tesoro del pirata Bytero, tu único problema es que tu avión perdió su motor y tuviste que saltar usando tu paracaídas, tuviste suerte y caíste en el templo principal pero necesitaras usar tu ingenio para acceder al tesoro\n");
                     //Mapa agregado, Esteban
                     System.out.println(" ____________________");
                     System.out.println("|          ^          |");
                     System.out.println("|                     |");
                     System.out.println("|          N          |");
                     System.out.println("|^       W + E       ^|");
                     System.out.println("|          S          |");
                     System.out.println("|                     |");
                     System.out.println("|__________^__________|\n");
        
        direction = Utils.leerString(
                "Te encuentras en un lugar extremadamente antiguo, estas rodeado de ruinas cubiertas de musgo, completamente colapsadas, notas que en el piso se muestra un aparato incrustado en la piedra que asemeja una brújula, cada vértice tiene una indentación, como si pudieras incrustar algún objeto, así como 4 letras, N, S, E, O, alrededor tuyo descubres que existen 4 arcos de piedra, en la dirección de cada vértice, los arcos emiten un ruido casi imperceptible, como si estuvieran a punto de activarse en cualquier momento, pero tu ya sabes como activarlo el aparato es similar al que aparece en el mapa que dejó Bytero, te acercas y presionas la gema roja en el centro y los arcos explotan en color y se activan, mostrando diferentes lugares, según el mapa necesitas 4 llaves para acceder al tesoro. \n¿Hacia donde te quieres dirigir?\n");
        direction = direction.toLowerCase();

        switch (direction) {
            case "n":
                userAnswer = Utils.leerString(
                        "Has accesado el portal del norte el cual te lleva a la dorada playa Oro AU, lo único que ves es arena y pequeños destellos de pertenencias olvidadas entre esas pertenencias encuentras un contenedor con botellas de algún tipo de licor muchas de ellas están rotas pero logras rescatar 2, así como un poco de tela y algunas estacas con las que podrías hacer una antorcha, mientras exploras también notas un pequeño parche con algunas palmeras y tierra un poco más dura y una equis hecha con un par de piezas de madera, es este el tesoro de bytero? el problema es que la tierra es muy dura para usar tus manos \n ¿tienes una pala? \n");
                if (userAnswer.equalsIgnoreCase("si")) {
                    System.out.println(
                            "Usas la pala para cavar con toda tu fuerza pero lo que encuentras es solo una vieja llave, tal vez puedas usarla en las ruinas?");
                } else {
                    System.out.println("Deberías explorar un poco más.");
                }

                break;

            case "s":
                userAnswer = Utils.leerString(
                        "Has accesado el portal del sur, te encuentras en una cueva en la que apenas puedes ver, ¿tienes una antorcha?\n");
                if (userAnswer.equalsIgnoreCase("si")) {
                    System.out.println(
                            "Te encuentras en una cueva húmeda y fría, las paredes están cubiertas de piedras filosas y pequeños minerales que reaccionan a la luz, creando pequeños destellos, en el centro de la cueva se encuentra un pequeño lago un poco  profundo, en el centro del lago y en el fondo ves un destellos, parece un objeto que fue hecho a partir del mismo mineral de las paredes que reacciona con la luz. \n¿que deseas hacer? \n");
                } else {
                    System.out.println("Debes conseguir algo para iluminar tu camino y volver luego.");
                }
                break;

            case "e":
                userAnswer = Utils.leerString(
                        "Has accesado el portal del este, te encuentras en una jungla impregnable, tan llena de enredaderas y helechos que casi no te puedes mover, si tuvieras un machete podrías abrirte paso y hasta cortar algo de enredadera que te podria ser util luego.\n ¿tienes un machete?\n");
                if (userAnswer.equalsIgnoreCase("si")) {
                    userAnswer = Utils.leerString(
                            "Usando tu machete logras abrir un camino entre la vegetación, hasta llegar a lo que parece un claro, en el claro ves una masa de plantas espinosas completamente densa, notas que aunque hay muchas, están secas, vez algo en el centro de la masa de espinas, algo que parece otra llave, si tuvieras una antorcha podrias quemar la enredadera espinosa seca y conseguir la llave, \n¿tienes una antorcha?\n");
                    if (userAnswer.equalsIgnoreCase("si")) {
                        System.out.println(
                                "Usas la antorcha para quemar la enredadera espinosa, luego de varios minutos puedes acceder a la llave del Este.");
                    } else {
                        System.out.println("Deberías explorar más las ruinas o los otros portales");
                    }
                } else {
                    System.out.println("Deberías explorar otras zonas y tratar de encontrar uno.");
                }
                break;

            case "o":
                userAnswer = Utils.leerString(
                        "Has accesado el portal del oeste, te encuentras en una zona montañosa, estás rodeado de picos monumentalmente tan grandes que tocan el cielo, pero notas que frente a ti hay como un tipo de pilote de madera, asomas tu cabeza en el borde y ves que algunos metros más abajo hay un tipo de plataforma, en la plataforma notas un esqueleto con lo que parece una llave en su mano y cerca de el vez una pala antigua, podrías bajar si amarraras algún tipo de cuerda al pilote, \n¿Tienes algún tipo de cuerda?\n");
                if (userAnswer.equalsIgnoreCase("si")) {
                    System.out.println(
                            "usando las enredaderas que conseguiste en la jungla las amarras al pilote y logra descender a la plataforma y logras adquirir la llave del oeste, la pala que viste esta en muy buen estado y podrías usarla luego.");
                } else {
                    System.out.println("Deberías buscar en otras zonas, tal vez en la jungla?");
                }
                break;
            default:
                System.out.println("Dirección inválida. Por favor ingresa N, S, E u O.");
        }

    }
}
