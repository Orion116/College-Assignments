
function parse()
	print("Enter Action: ")
	local str = io.read()
	

	lastVerb = nil;			-- Make sure that old verbs don't survive

    if ((str == "use switch") and (location == 18)) then
        print("Enter direction: ")
        local str = io.read()
        powercell = powercell - 1;
        print("Powercells remaining " .. powercell)
        -- items[1] = 18;
        -- print("Enter Action: ")
        -- local str = io.read()

    	if str == "north" then return 1 end
    	if str == "east" then return 2 end
    	if str == "south" then return 3 end
    	if str == "west" then return 4 end

    	if str == "northwest" then return 5 end
    	if str == "northeast" then return 6 end
    	if str == "southwest" then return 7 end
    	if str == "southeast" then return 8 end

    	if str == "go north" then return 1 end
    	if str == "go east" then return 2 end
    	if str == "go south" then return 3 end
    	if str == "go west" then return 4 end

    	if str == "go northwest" then return 5 end
    	if str == "go northeast" then return 6 end
    	if str == "go southwest" then return 7 end
    	if str == "go southeast" then return 8 end

    	if str == "n" then return 1 end
    	if str == "e" then return 2 end
    	if str == "s" then return 3 end
    	if str == "w" then return 4 end

    	if str == "nw" then return 5 end
    	if str == "ne" then return 6 end
    	if str == "sw" then return 7 end
    	if str == "se" then return 8 end

    elseif ((str ~= "switch") and (location ~= 18)) then
        if str == "north" then return 1 end
        if str == "east" then return 2 end
        if str == "south" then return 3 end
        if str == "west" then return 4 end

        if str == "northwest" then return 5 end
        if str == "northeast" then return 6 end
        if str == "southwest" then return 7 end
        if str == "southeast" then return 8 end

        if str == "go north" then return 1 end
        if str == "go east" then return 2 end
        if str == "go south" then return 3 end
        if str == "go west" then return 4 end

        if str == "go northwest" then return 5 end
        if str == "go northeast" then return 6 end
        if str == "go southwest" then return 7 end
        if str == "go southeast" then return 8 end

        if str == "n" then return 1 end
        if str == "e" then return 2 end
        if str == "s" then return 3 end
        if str == "w" then return 4 end

        if str == "nw" then return 5 end
        if str == "ne" then return 6 end
        if str == "sw" then return 7 end
        if str == "se" then return 8 end
    else
        print("You need to use the switch.")
    end

	local verb, object, person = superparser(str);

-- Convert the string of the verb to a verb number
	local num, special = parseVerb(verb);


-- Add blocks here to handle certain types of verbs with certain 
-- combinations of people and items

	if (handlers[num] ~= nil) then
		return handlers[num](object, person);
	end;

	
	if (num == 99) then 
		endgame() 
	end;

	if (num == 100) then 	-- Handle non-standard verbs in the room functions
		lastVerb = special;
		return 100;
		end;

	print "Command not understood"
return -1
end



function parseVerb(str)
  if (str == nil) then return 0, nil end;
  if (verbs[str] ~= nil) then
    return verbs[str], str;
  end;
  return 100, str;
end;


-- Function endgame 
-- Handle the end of the game
function endGame(num)
    if (num == 0) then
        print("\n\t\tYou Win!\n")
        location = 18;
    elseif (num == 1) then
        print("You were banned from every country. You were teleported to the Void")
        location = 0;
    elseif (num == 2) then
        print("You ran out of powercells! You expirenced a teleporter accident")
        location = 0;
    end
	print "Game Over"
	os.exit()
end

