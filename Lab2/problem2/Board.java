
   package oop24.Lab2.problem2;

import java.util.ArrayList;
import java.util.List;

    public class Board{
        private Piece[][] board = new Piece[8][8];

        private List<Piece> capturedPieces = new ArrayList<>();
        private Colour currentTurn;
        private boolean gameEnded;

        private Position whiteKingPosition;
        private Position blackKingPosition;

        private boolean pawnPromotionPending = false;
        private Pawn pawnToPromote = null;

        public Board(){
            initBoard();
            currentTurn = Colour.WHITE;
            gameEnded = false;
        }

        public void initBoard() {
            for (int x = 0; x < 8; x++) {
                char column = (char) ('a' + x);
                board[1][x] = new Pawn(new Position(column, 2), Colour.WHITE);
//                board[6][x] = new Pawn(new Position(column, 7), Colour.BLACK);
            }

            board[0][0] = new Rook(new Position('a', 1), Colour.WHITE);
            board[0][1] = new Knight(new Position('b', 1), Colour.WHITE);
            board[0][2] = new Bishop(new Position('c', 1), Colour.WHITE);
            board[0][3] = new Queen(new Position('d', 1), Colour.WHITE);
            board[0][4] = new King(new Position('e', 1), Colour.WHITE);
            board[0][5] = new Bishop(new Position('f', 1), Colour.WHITE);
            board[0][6] = new Knight(new Position('g', 1), Colour.WHITE);
            board[0][7] = new Rook(new Position('h', 1), Colour.WHITE);

//            board[7][0] = new Rook(new Position('a', 8), Colour.BLACK);
            board[7][1] = new Knight(new Position('b', 8), Colour.BLACK);
            board[7][2] = new Bishop(new Position('c', 8), Colour.BLACK);
            board[7][3] = new Queen(new Position('d', 8), Colour.BLACK);
            board[7][4] = new King(new Position('e', 8), Colour.BLACK);
            board[7][5] = new Bishop(new Position('f', 8), Colour.BLACK);
            board[7][6] = new Knight(new Position('g', 8), Colour.BLACK);
//            board[7][7] = new Rook(new Position('h', 8), Colour.BLACK);

            whiteKingPosition = new Position('e', 1);
            blackKingPosition = new Position('e', 8);
        }

        public Piece getPieceAt(int x, int y) {
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                return board[y][x];
            }
            return null;
        }

        public void drawBoard(){
            for( int y = 7; y >= 0; y--){
                System.out.print((y+1) + " ");
                for (int x = 0; x < 8; x++){
                    Piece piece = board[y][x];
                    if (piece == null) {
                        System.out.print(". ");
                    }else{
                        System.out.print(getPieceSymbol(piece) + " ");
                    }
                }
                System.out.println();
            }
            System.out.print("  ");
            for (int x = 0; x < 8; x++){
                char column = (char) ('a' + x);
                System.out.print(column + " ");
            }
            System.out.println();
        }

        private char getPieceSymbol(Piece piece) {
            char symbol = ' ';
            if (piece instanceof Pawn){
                symbol = 'P';
            } else if(piece instanceof Rook){
                symbol = 'R';
            } else if(piece instanceof Knight){
                symbol = 'N';
            } else if(piece instanceof Bishop){
                symbol = 'B';
            } else if(piece instanceof Queen){
                symbol = 'Q';
            } else if(piece instanceof King){
                symbol = 'K';
            }
            if (piece.colour == Colour.BLACK){
                symbol = Character.toLowerCase(symbol);
            }
            return symbol;
        }

        public boolean movePiece(Position from, Position to) {
            if (gameEnded) {
                System.out.println("Игра окончена.");
                return false;
            }

            int fromX = from.getX() - 'a';
            int fromY = from.getY() - 1;
            int toX = to.getX() - 'a';
            int toY = to.getY() - 1;
            Piece piece = board[fromY][fromX];
            if (piece == null) {
                System.out.println("Здесь нет фигуры.");
                return false;
            }
            if (piece.colour != currentTurn){
                System.out.println("сейчас ход " + currentTurn);
                return false;
            }
            if (!piece.isLegalMove(to, this)) {
                System.out.println(piece + " не может так двигаться.");
                return false;
            }

            Piece[][] tempBoard = copyBoard();

            board[toY][toX] = piece;
            board[fromY][fromX] = null;
            Position originalPos = piece.a;
            piece.a = to;

            if (piece instanceof Pawn) {
                if ((piece.colour == Colour.WHITE && to.getY() == 8) || (piece.colour == Colour.BLACK && to.getY() == 1)) {
                    promotePawn((Pawn) piece, to);
                }
            }

            if (piece instanceof King) {
                if (piece.colour == Colour.WHITE) {
                    whiteKingPosition = to;
                } else {
                    blackKingPosition = to;
                }
            }

            if (isKingInCheck(piece.colour, (piece.colour == Colour.WHITE) ? whiteKingPosition : blackKingPosition)) {
                System.out.println("Ваш король находится под шахом.");
                board = tempBoard;
                piece.a = originalPos;
                return false;
            }

            switchTurn();
            return true;
        }
        private void switchTurn() {
            currentTurn = (currentTurn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        }


        private Piece[][] copyBoard() {
            Piece[][] newBoard = new Piece[8][8];
            for (int y = 0; y < 8; y++) {
                System.arraycopy(board[y], 0, newBoard[y], 0, 8);
            }
            return newBoard;
        }

        public Colour getCurrentTurn() {
            return currentTurn;
        }

        public void setCurrentTurn(Colour currentTurn) {
            this.currentTurn = currentTurn;
        }

        public boolean isGameEnded() {
            return gameEnded;
        }

        public void setGameEnded(boolean gameEnded) {
            this.gameEnded = gameEnded;
        }

        public boolean isKingInCheck(Colour colour, Position kingPos) {
            Colour opponentColour = (colour == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;

            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    Piece piece = board[y][x];
                    if (piece != null && piece.colour == opponentColour) {
                        if (piece.isLegalMove(kingPos, this)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean isCheckmate(Colour colour) {
            Position kingPos = (colour == Colour.WHITE) ? whiteKingPosition : blackKingPosition;
            if (!isKingInCheck(colour, kingPos)) {
                return false;
            }

            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    Piece piece = board[y][x];
                    if (piece != null && piece.colour == colour) {
                        for (int toY = 0; toY < 8; toY++) {
                            for (int toX = 0; toX < 8; toX++) {
                                Position from = piece.getPosition();
                                Position to = new Position((char) ('a' + toX), toY + 1);

                                if (piece.isLegalMove(to, this)) {
                                    Piece[][] tempBoard = copyBoard();
                                    Piece tempPiece = board[y][x];
                                    Piece capturedPiece = board[toY][toX];

                                    board[toY][toX] = tempPiece;
                                    board[y][x] = null;
                                    tempPiece.a = to;

                                    Position originalKingPos = kingPos;
                                    if (tempPiece instanceof King) {
                                        kingPos = to;
                                    }

                                    boolean stillInCheck = isKingInCheck(colour, kingPos);

                                    board[y][x] = tempPiece;
                                    board[toY][toX] = capturedPiece;
                                    tempPiece.a = from;
                                    kingPos = originalKingPos;

                                    if (!stillInCheck) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }

        public boolean isPawnPromotionPending() {
            return pawnPromotionPending;
        }

        public Pawn getPawnToPromote() {
            return pawnToPromote;
        }

        public void completePawnPromotion(Piece newPiece) {
            int x = pawnToPromote.getPosition().getX() - 'a';
            int y = pawnToPromote.getPosition().getY() - 1;
            board[y][x] = newPiece;
            pawnPromotionPending = false;
            pawnToPromote = null;
        }

        public void promotePawn(Pawn pawn, Position position) {

            pawnPromotionPending = true;
            pawnToPromote = pawn;
        }

    }
