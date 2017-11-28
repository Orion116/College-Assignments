/*
 * File: CyberPet.java
 *
 * Author:
 *
 * Description: This class represents a CyberPet that can
 *              eat and sleep on command. This version incorporates
 *              a public getState() method to report the pet's state.
 */

public class CyberPet
{
    private boolean isEating   = true;         // CyberPet's state
    private boolean isSleeping = false;

    private String  name       = "no name";    // CyberPet's name


    /*** Constructor Methods ***/

    public CyberPet ( String str )
    {
        name = str;
    }

    /*** Transformer or Mutator Methods ***/

    public void eat( )          // Start eating
    {
        isEating   = true;      // Change the state
        isSleeping = false;
        return;
    }

    public void sleep( )       // Start sleeping
    {
        isSleeping = true;     // Change the state
        isEating   = false;
        return;
    }

    /*** Observor or Accessor Methods ***/

    public String getState( )
    {
        if (isEating)
            return "Eating";     // Exit method w/ current state

        if (isSleeping)
            return "Sleeping";

        return "Error in State";
    }

}
