#!/usr/bin/perl


open FEMALE, "female_first_raw";
open MALE, "male_first_raw";
open LAST, "last_raw";
open STREET, "streets";
open JOBS, "jobs";

open $phonebook, ">", "MyPhoneBook";


@initials = ('A' .. 'Z');

while (<FEMALE>)
	{
	chomp;
	my @fields = split /\s+/, $_;

	my $fixed = @fields[0];
  $fixed =~ s/([\w']+)/\u\L$1/g;  #Switch all but first character to uppercase

	push (@femalenames , $fixed );
	}





while (<MALE>)
	{
	chomp;
	my @fields = split /\s+/, $_;

	my $fixed = @fields[0];
  $fixed =~ s/([\w']+)/\u\L$1/g;  #Switch all but first character to uppercase

	push (@malenames , $fixed );
	}




while (<LAST>)
	{
	chomp;
	my @fields = split /\s+/, $_;

	my $fixed = @fields[0];
  $fixed =~ s/([\w']+)/\u\L$1/g;  #Switch all but first character to uppercase

	push (@lastnames , $fixed );
	}



while (<STREET>)
	{
	chomp;
	push (@streets, $_);
	}

while (<JOBS>)
	{
	chomp;
	push (@jobs, $_)
	}



print $phonebook "               Official Registry for Kylerland\n";
print $phonebook "\n\n";


foreach $number ((1 .. 20))
	{
	if (int (rand 4) != 0)
		{
		$first = @femalenames[int (rand $#femalenames + 1)];
		}
	else
		{
		$first = @malenames[int (rand $#malenames + 1)];
		}
		
	$middle = @initials[int (rand 26)];
	$last = @lastnames[int (rand $#lastnames + 1)];
	$address = int (rand(1000));
	$street = @streets[int (rand $#streets +1)];
	$job = @jobs[int (rand $#jobs + 1)];

	$prefix = int (rand(900)+100);
	$exchange = int (rand(10000));

	$fullname = $first . " " . $middle . ". " . $last;

	printf($phonebook "%-4d %-30s Profession: %s\n",$number, $fullname, $job);
	print $phonebook  "     $address $street\n";
	printf($phonebook "     %3d-%04d\n", $prefix, $exchange);
	print $phonebook "\n";
	}


