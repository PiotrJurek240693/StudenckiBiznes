package gameLogic;

public class Pawn
{
    private static int position;

    public static int move(int shift)
    {
        position += shift;
        if(position>=GameInfo.NUMBER_OF_SQUARES)
        {
            position = position%GameInfo.NUMBER_OF_SQUARES;
            return GameInfo.START_FEE;
        }
        return 0;
    }

}
