import java.util.Scanner;

public class Game {
    private static final int INITIAL_MATCHSTICKS = 20;
    private static final int THREE_MATCHSTICKS = 3;
    private static final int TWO_MATCHSTICKS = 2;
    private static final int ONE_MATCHSTICK = 1;
    int amountOfMatchsticks;

    Game() {
        this.amountOfMatchsticks = INITIAL_MATCHSTICKS;
    }

    static void takeFirstStep(Game game) {
        game.amountOfMatchsticks -= THREE_MATCHSTICKS;
        MessageOutput.announceComputerSelectedMatchsticks(THREE_MATCHSTICKS);
    }

    static void takeNextStep(Game game) {
        if (game.amountOfMatchsticks % 2 != 0) {
            game.amountOfMatchsticks -= TWO_MATCHSTICKS;
            MessageOutput.announceComputerSelectedMatchsticks(TWO_MATCHSTICKS);
        } else if (game.amountOfMatchsticks % 4 == 0) {
            game.amountOfMatchsticks -= THREE_MATCHSTICKS;
            MessageOutput.announceComputerSelectedMatchsticks(THREE_MATCHSTICKS);
        } else {
            game.amountOfMatchsticks--;
            MessageOutput.announceComputerSelectedMatchsticks(ONE_MATCHSTICK);
        }
    }

    private Scanner scanner = new Scanner(System.in);

    private int PlayerStepsAnalysis() {
        if (scanner.hasNextInt()) {
            int matchsticksToDelete = scanner.nextInt();
            if (matchsticksToDelete <= 3 && matchsticksToDelete >= 1) {
                return matchsticksToDelete;
            } else {
                MessageOutput.printWrongAmount();
            }
        }
        return 0;
    }

    void gameLogic(Game game) {
        int matchsticksToDelete;

        MessageOutput.announceTheStartOfTheGame();
        MessageOutput.announceRemainingMatchsticks(amountOfMatchsticks);
        game.takeFirstStep(game);
        MessageOutput.announceRemainingMatchsticks(amountOfMatchsticks);

        while (amountOfMatchsticks != 1) {
            MessageOutput.announcePlayersStep();
            matchsticksToDelete = PlayerStepsAnalysis();
            while (matchsticksToDelete == 0) {
                MessageOutput.announceRemainingMatchsticks(amountOfMatchsticks);
                MessageOutput.announcePlayersStep();
                matchsticksToDelete = PlayerStepsAnalysis();
            }
            amountOfMatchsticks -= matchsticksToDelete;
            MessageOutput.announceRemainingMatchsticks(amountOfMatchsticks);
            game.takeNextStep(game);
            MessageOutput.announceRemainingMatchsticks(amountOfMatchsticks);
        }
        MessageOutput.announceLoser();
        scanner.close();
    }
}

