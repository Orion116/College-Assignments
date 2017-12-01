#!/usr/bin/perl

open EMP, 'applicants.pool';
open $hired, ">", "PeopleToHire";

while (<EMP>)
{
    @emp = split/\s+/, $_;
    $fname = @emp[0];
    $middle = @emp[1];
    $lname = @emp[2];

    $fullname = $fname . " " . $middle . " " . $lname;

    $intel = @emp[3];
    $str = @emp[4];
    $dex = @emp[5];
    $cha = @emp[6];

    if (($intel < 15) && ($cha > 15))
    {
        $salary = $cha * 11_000;

        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Administrator", $salary); 
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");
    }
    elsif (($intel > 14) && ($str < 15) && ($cha < 13) && ($total <= 2_000_005))
    {
        $salary = 40_000 + $cha * 1_400;

        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Computer Science Faculty", $salary); 
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");
    }
    elsif ($intel > 16 && $total <= 2_000_005)
    {
        $salary = 20_000 + $cha * 1_900;
        
        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Mathematics Faculty", $salary);
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");
    }
    elsif (($intel > 12) && ($dex > 11) && ($str > 12) && ($total <= 2_000_005))
    {
        $salary = 30_000 + $cha * 1_800;
        
        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Chemistry Faculty", $salary);
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");
    }
    elsif (($dex < 13) && ($str > 14) && ($total <= 2_000_005))
    {
        $salary = 35_000 + $cha * 1_650;
        
        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Biology Faculty", $salary);
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");   
    }
    elsif ($str > 15 && $total <= 2_000_005)
    {
        $salary = 35_000 + $cha * 1_400;
        
        printf($hired "\n%-28s %-28s \$%d\n", $fullname, "Human Services Faculty", $salary);
        printf($hired "Intelligence %-6s Strength %-6s Dexterity %-6s Charisma %-6s\n\n", $intel, $str, $dex, $cha);
        print ($hired "-----------------------------------------------------------------------------------------------------\n");   
    }

    $total += $salary;

    $salary = 0; # reset the salary
}