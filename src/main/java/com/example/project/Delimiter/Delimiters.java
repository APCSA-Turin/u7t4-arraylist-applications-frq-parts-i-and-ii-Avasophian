package com.example.project.Delimiter;
import java.util.ArrayList;

public class Delimiters {
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens) 
    {
        ArrayList<String> deList = new ArrayList<String>();
        for (String token : tokens)
        {
            if (token.equals(openDel) || token.equals(closeDel))
            {
                deList.add(token);
            }
        }
        return deList;
    }
    

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) 
    {
        int openCount = 0;
        int closedCount = 0;
        for (String delim : delimiters)
        {
            if (delim.equals(openDel))
            {
                openCount ++;
            }
            if (delim.equals(closeDel))
            {
                closedCount ++;
            }
            if (closedCount > openCount)
            {
                return false;
            }
        }
        if (closedCount == openCount)
        {
            return true;
        }
        return false;
    }
}
