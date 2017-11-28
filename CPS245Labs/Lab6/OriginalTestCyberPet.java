/*
 * File: TestCyberPet.java
 *
 * Author:
 *
 * Description: This application program tests the CyberPet object.
 *
 */

public class TestCyberPet
{
    public static void main( String argv[] )
    {

        CyberPet pet1 = new CyberPet( "Ernie" );
        CyberPet pet2 = new CyberPet( "Bert"  );

        pet2.sleep( );

        System.out.println( pet1.toString() );
        System.out.println( pet2.toString() );

    }
}
