Input specification

<<<<<<< HEAD
- Standard moves should follow the algebraic notation (including disambiguating moves, short notation for pawn moves and En passant without the prefix "e.p.").
- Captures should be denoted with a 'x'.
- In pawn promotion, the piece promoted to should be denoted at the end of the pawn move (for example e8Q means that the pawn moving to e8 shall be promoted to a queen).
- Castling should be denoted as 0-0 for kingside castling and as 0-0-0 for queenside castling.
- A move that places the opponent's king in check does not have to be denoted with the symbol "+" appended. The game automatically checks for check and informs the players accordingly. 
- When two (or more) identical pieces can move to the same square, the moving piece is uniquely identified by specifying the piece's letter, followed by (in descending order of preference):
    
    -the file of departure (if they differ); or
    
    -the rank of departure (if the files are the same but the ranks differ); or
    
    -both the file and rank (if neither alone is sufficient to identify the piece—which occurs only in rare cases where one or more pawns have promoted, resulting in a player having three or more identical pieces able to reach the same square).

    -if the moving piece is not uniquely identified, the first valid piece is chosen by the game!
=======
- Standard moves should follow the algebraic notation (including disambiguating moves and short notation for pawn moves).
- Captures should be denoted with a 'x' (also according to the algebraic notation).
- In pawn promotion, the piece promoted to should be denoted at the end of the pawn move (for example e8Q means that the pawn moving to e8 shall be promoted to a queen).
- Castling should be denoted as 0-0 for kingside castling and as 0-0-0 for queenside castling.
- A move that places the opponent's king in check does not have to be denoted with the symbol "+" appended. The game automatically checks for check and informs the players accordingly.
- The same goes for checkmate.
>>>>>>> master
