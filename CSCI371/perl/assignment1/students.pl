#!/usr/bin/perl


open BOY, "male_first_raw";
open GIRL, "female_first_raw";
open LAST, "last_raw";
open $applicationpool, ">", "applicants.pool";

while (<BOY>)
	{
	chomp;
	@fields = split/\s+/, $_;
	$fixed = @fields[0];
	$fixed =~ s/([\w']+)/\u\L$1/g;
	push (@boy, $fixed);
	}

while (<GIRL>)
	{
	chomp;
	@fields = split/\s+/, $_;
	$fixed = @fields[0];
	$fixed =~ s/([\w']+)/\u\L$1/g;
	push (@girl, $fixed);
	}

while (<LAST>)
	{
	chomp;
	@fields = split/\s+/, $_;
	$fixed = @fields[0];
	$fixed =~ s/([\w']+)/\u\L$1/g;
	push (@last, $fixed);
	}

@Number = ('1' .. '20');


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
	
	$fullname = $fname . " " . $lname;

	print($applicationpool "", $fullname,);
	print $applicationpool "\n";
	}


