#!/usr/bin/perl


# My Starting directory.  I could also read this from the command line
$start = "/home/orion116/Desktop/School/CSCI371/perl/Spider/";
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
			push(@dirs, ($curr . $line));
		}
		else
		{
			# print $line . "\n";
			if ($line =~ /[*@&=]$/)
			{
				chop $line;
				# print $line . "\n";
			}
# print $line."\n";



			my @data = split/\s/, `ls -l "$curr$line"`;
# print "$curr$line\n";

# print $data[2] eq "orion116". " You \n";
			if ($data[2] eq "orion116")
			{
				# print "$curr/$line \n";
				push (@BadFiles, ($curr.$line));
			}
		}
	}
}

foreach (@BadFiles)
{
# 	my $filename = $_;
# # print $filename;
# 	open(FILE, $filename);

# 	# @name = split/\/, $filename;

# 	while (<FILE>) 
# 	{      # Set $_ to each line of the file 
#    		print $name[0];              # Print $_
# 	}	
print $_."\n";

	# print $_ . "\n";
}
