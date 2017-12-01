#!/usr/bin/perl


open BOY, "male_first_raw";
open GIRL, "female_first_raw";
open LAST, "last_raw";
open CITIES, "cities_list";
open STREETS, "streets";
open JOBS, "jobs";
open CLASSES, "classes";
open GRADES, "grade_list" ;
open PREWORDS, "prewords.list";
open ADJECTIVES, "adjectives.list";
open COLORS, "colors.list";
open NOUNS, "nouns.list";


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

while (<CITIES>)
	{
	chomp;
	push (@cities, $_);
	}

while (<STREETS>)
	{
	chomp;
	push (@streets, $_);
	}

while (<JOBS>)
	{
	chomp;
	push (@jobs, $_);
	}

while (<ADJECTIVES>)
	{
	chomp;
	push (@adjectives, $_);
	}

while (<COLORS>)
	{
	chomp;
	push (@colors, $_);
	}

while (<NOUNS>)
	{
	chomp;
	push (@nouns, $_);
	}

while (<PREWORDS>)
	{
	chomp;
	push (@prewords, $_);
	}


while (<CLASSES>)
	{
	chomp;
	@fields = split /\s+/, $_;
	$classes{@fields[0] . " ". @fields[1]} = @fields[2];
	push (@orderclass, @fields[0] . " ". @fields[1]);
	}

while (<GRADES>)
	{
	chomp;
	@field = split /\s+/, $_;
	$grades{@field[0]} = @field[1];
	}
	
@gradelist = keys %grades;


@Number = ('1' .. '20');

foreach $usernum (@Number)
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

	$sid = (int(rand 100000000));

	$address = (int(rand 10000)) . " " . @streets[(int(rand @streets))];
	$city = @cities[(int(rand @cities))]; 

	$job = @jobs[(int(rand @jobs))];
	$salary = 50000 + (200*(int(rand 550)));

	printf("%-40s A%08d\n", $fname ." ". $lname, $sid);
	print $address . "\n";
	print $city . "\n";
	
	print "\n";
	printf("Hired as a: %-20s Starting Salary \$%6d \n", $job, $salary);
	print ("Employed at : ");
	generateWorkplace();

	printf("\n\n\n");

	$qualitypoints = 0;
	$credits = 0;
	foreach $class (@orderclass)
		{
		$grade = @gradelist[(int(rand @gradelist))];

		$credits = $credits + $classes{$class};
		$qualitypoints = $qualitypoints + $classes{$class} * $grades{$grade};

		printf("%s    %-2s   %d  SUM17\n", $class, $grade, $classes{$class});
		}
	printf("Gen Ed Credits: 25  (MTA)\n");
	printf("Total credits earned: %3d (at LSSU)\n", $credits);
	printf("Total credits earned: %3d (for degree)\n", $credits+25);
	printf("Student GPA: %4.2f\n", $qualitypoints / $credits);

	$totalGPA = $totalGPA + ($qualitypoints / $credits);
	print "\n\n\n";
	}

print ("\n\n\nGeneral statistics for class of 2017:\n");
# Placement rate
print ("Placement rate: 100%\n");
# Average GPA
printf ("Average Student GPA: %5.2f\n", $totalGPA / 20);


#########################################################################
# End main program
#########################################################################



sub generateWorkplace
	{
	my $type = (int (rand 5));

	if ($type == 0)
		{
		# The number, preword, nouns
			printf("The %d %s %s\n", int (rand 25) + 1, 
					@prewords[(int (rand @prewords))],
					@nouns[(int (rand @nouns))] );

		}

	if ($type == 1)
		{
		# color, noun, Inc.
			printf("%s %s, Inc.\n",  
					@colors[(int (rand @colors))],
					@nouns[(int (rand @nouns))] );
		}

	if ($type == 2)
		{
		# adjective, noun, LLC.
			printf("%s %s, LLC.\n",  
					@ajectives[(int (rand @adjectives))],
					@nouns[(int (rand @nouns))] );
		}
	
	if ($type == 3)
		{
		#nouns's of city
			printf("%s's of  %s, LLC.\n",  
					@last[(int (rand @last))],
					@cities[(int (rand @cities))] );
		}

	if ($type == 4)
		{
		print "The United States Government\n";
		}

	}
