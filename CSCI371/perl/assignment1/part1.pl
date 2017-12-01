#!/usr/bin/perl

open BOY, 'boynames';
open GIRL, 'girlnames';
open LAST, 'lastnames';
open $applicationpool, ">", "applicants.pool";

@initials = ('A' .. 'Z');

while (<BOY>)
{
	chomp;
	
	push (@boy, $_);
}

while (<GIRL>)
{
	chomp;
	
	push (@girl, $_);
}

while (<LAST>)
{
	chomp;
	
	push (@last, $_);
}

@Number = ('1' .. '500');

foreach $number (@Number)
{
    if (int (rand 2) == 0)
	{
		$fname = @girl[(int(rand @girl))];
	}
	else
	{
		$fname = @boy[(int(rand @boy))];
	}

	$lname = @last[(int(rand @last))];
    $middle = @initials[int (rand 26)];

    $intel = int (rand 6) + int (rand 6) + int (rand 6) + 3;
    $str   = int (rand 6) + int (rand 6) + int (rand 6) + 3;
    $dex   = int (rand 6) + int (rand 6) + int (rand 6) + 3;
    $cha   = int (rand 6) + int (rand 6) + int (rand 6) + 3; 


	$apply = $fname . " " . $middle . ". " . 
             $lname . " " . $intel  . " " . 
             $str   . " " . $dex    . " " . $cha;

	print $applicationpool "", $apply;

    # add a newline only if the number is not 500
    if ($number != 500)
    {
	    print $applicationpool "\n";
    }
}