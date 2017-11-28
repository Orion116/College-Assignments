public boolean rowAndColumn(int tN)
{
  int rowsum = 0, colsum = 0;
  for(int i = 0; i < sq[0].length; i++)
  {
    for(int j = 0; j < sq[0].length; j++)
    {
      rowsum = rowsum + sq[i][j];
      colsum = colsum + sq[j][i];
    }
    if(rowsum != tN || colsum != tN)
      return false; //no point checking the rest if the sums doesn't match
    rowsum = 0; //reset row count
    colsum = 0; //reset col count
  }
  return true; //if it doesn't return by here, all the sums match
}


  public boolean diagonalLeft(int tN)
  {
    int sum = 0;
    //write loop to see if the diagonal from
    //lower left to upper right is the same as tN
     for(int d = 0; d < sq[0].length; d++)
    {
      sum = sum + sq[d][(sq.length-1) - d];
    }
    return (sum == tN);
  }

  public boolean diagonalRight (int tN)
  {
    int sum = 0;
   //write loop to see if the diagonal from upper left
    //to lower right is the same as tN
    for (int d = 0; d < sq[0].length; d++)
    {
        sum = sum + sq[d][d];
    }

   return (sum == tN);
  }

  public boolean column (int tN)
  {
    boolean same = true;
    int sum = 0;

    //write nested loops to check each column's sum
    //if the sum is not the same as tN, set same to false.
    for(int i = 0; i < sq[0].length; i++)
    {
      for(int j = 0; j < sq[0].length; j++)
      {
        sum = sum + sq[j][i];
      }
    }
    if(sum == tN)
      same = true;
    else
      same = false;

    return same;
  }

    public boolean isMagic()
    {
      int targetNum = 0;
      boolean stuff = false;

      for (int c = 0; c < sq[0].length; c++)
      {
        targetNum += sq[0][c];
      }
      if(column(targetNum) == true && row(targetNum) == true && diagonalLeft(targetNum) == true && diagonalRight(targetNum) == true && fullSquare() == true)
      {
        return true;
      }
      else
        return false;
      //if the rows, columns, diagonals and fullSquare are all
      //true, return true, otherwise, return false.

  }