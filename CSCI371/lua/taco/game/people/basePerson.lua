--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Seaninit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["Alias"] = {[0] = myNumber, [1] = 1};
	
	people[myNumber] = {[0] = "FullName", [1] = 2, [2] = 0, [3] = talkWho, [4] = tickWho};


end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkWho(arg, target)
	local mynum = mapping["Who"][0];
	local myStuff = people[mynum];


	if (arg == 0) then
		print (myStuff[0] .. " is standing here.");
	end


	
end

--[[ Used if this person should do something on their own ]]--
function tickWho()
	
end

