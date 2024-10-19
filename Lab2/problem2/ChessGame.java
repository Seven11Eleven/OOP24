package oop24.Lab2.problem2;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Scanner scanner;

    public ChessGame() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Добро пожаловать в игру Шахматы!");
        board.drawBoard();

        while (!board.isGameEnded()) {
            System.out.println("Ход " + (board.getCurrentTurn() == Colour.WHITE ? "белых" : "чёрных"));
            System.out.print("Введите ваш ход (например, e2 - откуда e4 - куда): ");
            String move = scanner.nextLine().trim();

            if (move.equalsIgnoreCase("exit")) {
                System.out.println("Игра завершена.");
                board.setGameEnded(true);
                break;
            }

            try {
                String[] positions = move.split(" ");
                if (positions.length != 2) {
                    System.out.println("Неверный формат хода. Пожалуйста, введите два поля через пробел.");
                    continue;
                }

                Position from = parsePosition(positions[0]);
                Position to = parsePosition(positions[1]);

                if (from == null || to == null) {
                    System.out.println("Неверные координаты. Введите ходы в формате e2 - откуда e4 - куда.");
                    continue;
                }

                boolean moveResult = board.movePiece(from, to);
                if (!moveResult) {
                    System.out.println("Неверный ход. Попробуйте снова.");
                } else {
                    board.drawBoard();

                    if (board.isPawnPromotionPending()) {
                        handlePawnPromotion();
                        board.drawBoard();
                    }

                    if (board.isCheckmate(board.getCurrentTurn())) {
                        System.out.println("Игра окончена. " + (board.getCurrentTurn() == Colour.WHITE ? "Чёрные" : "Белые") + " победили!");
                        board.setGameEnded(true);
                    }
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка. Попробуйте снова.");
                e.printStackTrace();
            }
        }
    }



    private Position parsePosition(String pos) {
        if (pos.length() != 2) return null;

        char x = pos.charAt(0);
        int y = Character.getNumericValue(pos.charAt(1));

        if (x >= 'a' && x <= 'h' && y >= 1 && y <= 8) {
            return new Position(x, y);
        }
        return null;
    }

    private void handlePawnPromotion() {
        Pawn pawn = board.getPawnToPromote();
        System.out.println("Пешка достигла конца доски! Выберите фигуру для промоции:");
        System.out.println("Введите 'Q' для Ферзя, 'R' для Ладьи, 'B' для Слона, 'N' для Коня:");
        while (true) {
            String choice = scanner.nextLine().trim().toUpperCase();
            Piece newPiece = null;
            Position position = pawn.getPosition();
            Colour colour = pawn.colour;

            switch (choice) {
                case "Q":
                    newPiece = new Queen(position, colour);
                    break;
                case "R":
                    newPiece = new Rook(position, colour);
                    break;
                case "B":
                    newPiece = new Bishop(position, colour);
                    break;
                case "N":
                    newPiece = new Knight(position, colour);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите 'Q', 'R', 'B' или 'N'.");
                    continue;
            }

            board.completePawnPromotion(newPiece);
            System.out.println("Пешка была превращена в " + newPiece.getName() + "!");
            break;
        }
    }


    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }


}
