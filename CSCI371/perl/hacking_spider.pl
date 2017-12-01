#!/usr/bin/perl


# My Starting directory.  I could also read this from the command line
$start = "/";
$count = 0;	# How many non-file objects found.  Line un-necessary

# Initialize the list
push (@dirs, $start);

# Iterate through the list (really a queue) 
# We could also do this with a shift, but this works
foreach $curr (@dirs)
	{
	# Get the directory listing for the current directory
	# Note that -F appends a character for the type of object it is
	# on the end (/) for directory.

	
	my @lines = split /\n/, `ls -F "$curr"`;

	# Iterate through the things we got from the ls
	foreach $line (@lines)
		{
		# The chomp is not necessary because the split strips out
		# the seperator characters.
		#chomp $line;

		# If it ends in a / it's a directory. add it to the end of
		# the list
		if ($line =~ m#/$#)
			{
			push(@dirs, ($curr.$line));
			}
		else
		  {
			if ($line =~ /[*@&=]$/)
				{
				chop $line;
				}

			@info = split /\s/ , `ls -l "$curr$line"`;

			if ($info[2] eq "www-data")
				{
				print "Found a file $curr$line\n";
				}

			}
		}
	}


foreach (@BadFiles)
	{
	print $_ . "\n";
	}
