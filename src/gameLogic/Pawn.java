package gameLogic;

import java.io.Serializable;

public class Pawn implements Serializable
{
    private int position = 0;

    int x = 750, y = 374;

    private PawnColor color;

    Pawn(PawnColor color) {
        this.color = color;
    }

    public int getPosition(){return position;}
    public int move(int shift)
    {
        position += shift;
        if(position>=GameInfo.NUMBER_OF_SQUARES)
        {
            position = position%GameInfo.NUMBER_OF_SQUARES;
            return GameInfo.START_SQUARE_ADDITION;
        }
        if(position<0)
            position += GameInfo.NUMBER_OF_SQUARES;
        return 0;
    }
    public void getToSquare(int squareIndex)
    {
        position=squareIndex;
    }

    public PawnColor getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void changeX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void changeY(int y) {
        this.y += y;
    }
}
