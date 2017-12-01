
--[[
mapping 
0 = this number
1 = always 0 (item)

items
0 -> Full name
1 -> location
2 -> status
3 -> article (a or an or the)
4 -> Use function

Be sure to call THINGinit in main.lua
]]--

function Tacoinit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["Taco"] = {[0] = myNumber, [1] = 0};
	mapping["taco"] = {[0] = myNumber, [1] = 0};
	mapping["tasty taco"] = {[0] = myNumber, [1] = 0};

	items[myNumber] = {[0] = "tasty taco", [1] = 4, [2] = 0, [3] = "a", [4] = useTaco};


end

--[[ 
arg = verb number used on this item
]]--
function useTaco(arg, target)
	local mynum = mapping["taco"][0];
	local myStuff = items[mynum];


	if (arg == 0) then
		print ("  "..myStuff[3].." "..myStuff[0]);
	end

	if (arg == 11) then
		if (funds >= 1) then
			if (myStuff[1] == 4) then
				print ("You purchase "..myStuff[3].." "..myStuff[0]..".");
				funds = funds -1;
				myStuff[1] = 0;
			else
				print("Kody says 'Eat the one you already have!'");
			end;
		else
			print ("Kody says 'Tacos on sale! Today only, $1'.");
		end;
	end
			
	
	if (arg == 12) then
		if (location == 4) then
			print ("Kody glares at you for trying to steal "
					..myStuff[3].." "..myStuff[0].. ".");
			print ("Don't make him angry, or he will smite you.");
		else
			print ("You pick up "..myStuff[3].." "..myStuff[0].. ".");
			myStuff[1] = 0;
		end;
	end;

-- print(myStuff[1])
	if (arg == 13) then
		print ("Dropped.");
		myStuff[1] = location;
	end

	if (arg == 15) then
		if (myStuff[1] == 0) then
			print ("It was very tasty.  You should introduce this wonder to the world!")
			myStuff[1] = 4;
		else
			print ("You live a sad life, with no taco to eat.  :(");
		end
	end


end



