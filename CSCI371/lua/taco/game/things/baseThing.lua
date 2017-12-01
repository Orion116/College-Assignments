
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

function THINGinit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["alias"] = {[0] = myNumber, [1] = 0};
	
	items[myNumber] = {[0] = "FULL NAME", [1] = -1, [2] = 0, [3] = "a", [4] = use???};


end

--[[ 
arg = verb number used on this item
]]--
function use???(arg, target)
	local mynum = mapping["NAME"][0];
	local myStuff = items[mynum];


	if (arg == 0) then
		print ("  "..myStuff[3].." "..myStuff[0]);
	end



end



