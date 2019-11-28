package main.softcon.tictactoe.tictactoe;

import java.util.Scanner;

import main.softcon.tictactoe.ai.GameIntelligenceAgent;
import main.softcon.tictactoe.ai.MinimaxAgent;
import main.softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator(TicTacToeGameState.Player.O);
    GameIntelligenceAgent<TicTacToeGameState> agent =
        new MinimaxAgent<TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    TicTacToeGameRunner game = new TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
