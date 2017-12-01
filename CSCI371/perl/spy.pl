#!/usr/bin/perl

# My Starting directory.  I could also read this from the command line
# $start = "/guardian/projects2/cs371/";

$start = "/home/orion116/Desktop/Misc/C++/";
# $start = "/home/orion116/Desktop/reports/";
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
        # If it ends in a / it's a directory. add it to the end of
        # the list

        if ($line =~ m#/$#)
        {
            push(@dirs, ($curr . $line));
            print $curr . $line . "\n";
        }
        else
        {
            if ($line =~ /[*@&=]$/)
            {
                chop $line;
            }   
            my @data = split/\s/, `ls -l "$curr$line"`;

            open SEARCHFILE, "$curr$line"; # open the file
            $count = 0;

            while (<SEARCHFILE>)  # loop through the file
            {
                $searchlines = $_; # read the file line by line
                $count = $count + 1;
                # try an match the phrase with the current line of the file
                if ($searchlines =~ /add/g) 
                {
                    $itemCount = $itemCount + 1;
                    # print $curr.$line . ":" . $count . "\n";
                     # print $searchlines . "\n";

                    print $itemCount . "\n";

                    # print "gedit " . $curr.$line . "\n";
                    # print "The message was found in: " . $curr.$line . "\n";
                    # print "The file is owned by: " . @data[2] . "\n";
                    # exit();     # exit the program
                }
                
                # else
                # {
                #     print $searchlines . "\n";
                # }
            }
            
        }
    }
}
