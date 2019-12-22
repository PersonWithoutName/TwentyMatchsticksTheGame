public class MessageOutput {
    static void announceTheStartOfTheGame() {
        System.out.println("Игра началась!");
    }

    static void announceRemainingMatchsticks(int amount) {
        switch (amount) {
            case 4:
            case 3:
            case 2: {
                System.out.printf("На столе осталось %d спички. \n", amount);
                break;
            }
            case 1: {
                System.out.print("Для игрока осталась последняя спичка. ");
                break;
            }
            default: {
                System.out.printf("На столе осталось %d спичек. \n", amount);
            }
        }
    }

    static void announcePlayersStep() {
        System.out.print("-Ход игрока. Введите количество спичек: ");
    }

    static void announceComputerSelectedMatchsticks(int matchsticks) {
        System.out.println("-Ход комьпьютера. Количество выбранных компьютером спичек = " + matchsticks + ".");
    }

    static void announceLoser() {
        System.out.println("Игрок проиграл!");
    }

    public static void printWrongAmount() {
        System.out.println("Некорректное количество спичек! Попробуйте ещё раз.");
    }
}
