package homework_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        String allTransactoinInYear = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(t -> t.toString())
                .collect(Collectors.joining(","));
        System.out.println("Транзакции за 2011 год " + allTransactoinInYear);
        System.out.println(); // {Trader:Brian in Cambridge, year: 2011, value: 300},{Trader:Raoul in Cambridge, year: 2011, value: 400}

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        String uniqueCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.joining());
        System.out.println("Список не повторяющихся городов: " + uniqueCities);
        System.out.println(); // Cambridge Milan

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        String tradersCambridge = transactions.stream()
                .map(t -> t.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .map(trader -> trader.getName())
                .sorted()
                .distinct()
                .collect(Collectors.joining());
        System.out.println("Список трейдеров из Кембриджа: " + tradersCambridge);
        System.out.println(); //Alan Brian Raoul

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String sortedNames = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.joining());
        System.out.println("Список, отсортированный в алфавитном порядке: " + sortedNames);
        System.out.println(); // Alan Brian Mario Raoul

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean tradersFromMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("Трейдеры из Милана : " + tradersFromMilan); // true

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumTransactionCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();
        System.out.println("Сумма транзакций трейдеров из Кембриджа: " + sumTransactionCambridge);
        System.out.println(); // 2650

        // 7. Какова максимальная сумма среди всех транзакций?
        int maxAmountOfAllTransaction = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max()
                .getAsInt();
        System.out.println("Максимальная сумма среди всех транзакций: " + maxAmountOfAllTransaction);
        System.out.println(); // 1000

        // 8. Найти транзакцию с минимальной суммой.
        int minAmountOfAllTransaction = transactions.stream()
                .mapToInt(t -> t.getValue())
                .min()
                .getAsInt();
        System.out.println("Минимальная сумма среди всех транзакций: " + minAmountOfAllTransaction);
        System.out.println(); // 300

    }
}