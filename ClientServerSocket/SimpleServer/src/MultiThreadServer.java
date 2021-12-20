import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mercenery
 */
public class MultiThreadServer {

    static ExecutorService executeIt = Executors.newFixedThreadPool(10);

    /**
     * @param args
     */
    public static void main(String[] args) {
        BusStation busStation = new BusStation(new ArrayList<>(Arrays.asList(
                new Trip("Minsk - Baranovichy", new GregorianCalendar(2021, Calendar.FEBRUARY, 1)),
                new Trip("Minsk - Oshmiany", new GregorianCalendar(2021, Calendar.MARCH, 2)),
                new Trip("Minsk - Postavy", new GregorianCalendar(2021, Calendar.APRIL, 3)),
                new Trip("Minsk - Brest", new GregorianCalendar(2021, Calendar.MAY, 4)),
                new Trip("Minsk - Grodno", new GregorianCalendar(2021, Calendar.JUNE, 5)),
                new Trip("Minsk - Gomel", new GregorianCalendar(2021, Calendar.JULY, 6)),
                new Trip("Minsk - Vitebsk", new GregorianCalendar(2021, Calendar.AUGUST, 7)),
                new Trip("Minsk - Pinsk", new GregorianCalendar(2021, Calendar.SEPTEMBER, 8))
        )
        ));

        // стартуем сервер на порту 3345 и инициализируем переменную для обработки консольных команд с самого сервера
        try (ServerSocket server = new ServerSocket(3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Server socket created, command console reader for listen to server commands");

            // стартуем цикл при условии что серверный сокет не закрыт
            while (!server.isClosed()) {

                // проверяем поступившие комманды из консоли сервера если такие
                // были
                if (br.ready()) {

                    // если команда - quit то инициализируем закрытие сервера и
                    // выход из цикла раздачии нитей монопоточных серверов
                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }

                // если комманд от сервера нет то становимся в ожидание
                // подключения к сокету общения под именем - "clientDialog" на
                // серверной стороне
                Socket client = server.accept();

                // после получения запроса на подключение сервер создаёт сокет
                // для общения с клиентом и отправляет его в отдельную нить
                // в Runnable(при необходимости можно создать Callable)
                // монопоточную нить = сервер - MonoThreadClientHandler и тот
                // продолжает общение от лица сервера
                executeIt.execute(new MonoThreadClientHandler(client, busStation));
                System.out.print("Connection accepted.");
            }

            // закрытие пула нитей после завершения работы всех нитей
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}