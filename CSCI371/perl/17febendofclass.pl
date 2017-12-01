#!/usr/bin/perl

# Be sure to adjust #! line for _your_ computer... This is from furball.

open LAST, "last_raw";
open BOY, "male_first_raw";
open GIRL, "female_first_raw";
open PASSWORDS, "password_list_raw";
open WORDS, "/usr/share/dict/words";

@INITIAL = ('A' .. 'Z');

# Valid characters are 0-9, A-Z and a-z.  Note how we combine the sets to
# produce one really long list!
@salts=('46' .. '57',  '65' .. '90', '97' .. '122');

# Initialize our random number generator
srand (time() ^ ($$ + ($$ << 15)));



sub randompass
	{
	my @chars = ('33' .. '47', '48' .. '57', '65' .. '90', '97' .. '122');
	my $pw = "";
	$i = 0; 

	while ($i < $_[0])
		{
		$pw = $pw . chr($chars[int(rand$#chars+1)]);
		$i++;
		}
	return $pw;
	}



while (<LAST>)
	{
	chomp;
	my @fields = split /\s+/, $_;
	my $fixed = @fields[0];
	$fixed =~ s/ (		# Find and remove Whitespace
		(^\w)
		  |
		(\s\w)
		  )
		/\U$1/xg;
	$fixed =~ s/([\w']+)/\u\L$1/g;	# Switch all but first letter to lowercase
	push (@last, $fixed);
	}


while (<GIRL>)
  {
  chomp;
  my @fields = split /\s+/, $_;
  my $fixed = @fields[0];
  $fixed =~ s/ (
    (^\w)
      |
    (\s\w)
      )
    /\U$1/xg;
  $fixed =~ s/([\w']+)/\u\L$1/g;
  push (@girl, $fixed);
  }


while (<BOY>)
  {
  chomp;
  my @fields = split /\s+/, $_;
  my $fixed = @fields[0];
  $fixed =~ s/ (
    (^\w)
      |
    (\s\w)
      )
    /\U$1/xg;
  $fixed =~ s/([\w']+)/\u\L$1/g;
  push (@boy, $fixed);
  }

# Need to add code to read in the passwords
while (<PASSWORDS>)
  {
  chomp;
  push (@passwd, $_);
  }

# Need to add code in to read in the words.  We don't want words with 's in!
while (<WORDS>)
  {
  chomp;
  if (/'/)
    {
    }
  else
    {
    push (@words, $_);
    }
  }



@Number = ('1' .. '50');

foreach $usernum (@Number)
	{
	if (int(rand 2) == 0)
		{ # Lets make a female person
		$fname = @girl[(int(rand @girl))];
		$initial = @INITIAL[int(rand 26)];
		$lname = @last[(int(rand @last))];
		}
	else
		{ # Lets make a male person
		$fname = @boy[(int(rand @boy))];
		$initial = @INITIAL[int(rand 26)];
		$lname = @last[(int(rand @last))];
		}

	$fullname = $fname . " " . $initial . " " . $lname;
	$username = (substr($fname, 0, 1)) . $initial . (substr($lname, 0, 6));

	# See http://perldoc.perl.org/perlop.html#Quote-Like-Operators
	# for this handy tidbit!
	# (Basically this takes all uppercase and turns them into lowercase.

	$username =~ tr/A-Z/a-z/;

	# What happens if we replace the =~ with an =  ... lets find out!

	# 20% from the list
  # 30% word
  # 20% word + 2 digit
  # 10% random 6
  # 10% random 7
  # 10% random 8
	$number = int (rand 10);
	$password = "";

  if ($number < 2)
		{
		$password = @passwd[(int (rand @passwd))];
		}
	elsif ($number < 5)
		{
		$password = @words[(int (rand @words))];
		}
	elsif ($number < 7)
		{
		$password = substr(@words[(int (rand @words))], 0, 6) .. (int (rand 100));
		}
	elsif ($number < 8)
		{
		$password = &randompass(6);
		}
	elsif ($number < 9)
		{
		$password = &randompass(7);
		}
	else
		{
		$password = &randompass(8);
		}

	$encrypted = crypt($password, (chr ($salts[int (rand $#salts+1)]) .
			chr ($salts[int(rand $#salts+1) ] )));

	



	print $username . ":" . $encrypted . ":" . (1000+$usernum) . ":" . "??" . ":" . $fullname . ":" . "/usr/bin/bash" . "\n";

	}
