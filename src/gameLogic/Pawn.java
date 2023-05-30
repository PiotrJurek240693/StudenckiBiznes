package gameLogic;

public class Pawn
{
    private int position = 0;

    public int getPosition(){return position;}
    public int move(int shift)
    {
        position += shift;
        if(position>=GameInfo.NUMBER_OF_SQUARES)
        {
            position = position%GameInfo.NUMBER_OF_SQUARES;
            return GameInfo.START_SQUARE_ADDITION;
        }
        return 0;
    }
    public void getToSquare(int squareIndex){position=squareIndex;}

}
