--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Doginit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["dog"] = {[0] = myNumber, [1] = 1};
	mapping["Dog"] = {[0] = myNumber, [1] = 1};
	mapping["puppy"] = {[0] = myNumber, [1] = 1};
	mapping["Roxie"] = {[0] = myNumber, [1] = 1};
	mapping["roxie"] = {[0] = myNumber, [1] = 1};
	mapping["fatty"] = {[0] = myNumber, [1] = 1};
	mapping["fattie"] = {[0] = myNumber, [1] = 1};
	
	people[myNumber] = {[0] = "fat puppy named Roxie", [1] = 17, [2] = 0, [3] = talkDog, [4] = tickDog};


end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkDog(arg, target)
	local mynum = mapping["dog"][0];
	local myStuff = people[mynum];


	if (arg == 0) then
		print (myStuff[0] .. " is standing here.");
	end

	if (arg == 10) then
		print ("Bark! Bark! Bark!");
	end

	if ((arg == 33) and (target == mapping["taco"][0])) then
		if (items[target][1] == 0) then
			print ("Elizabeth does not want you to feed her dog tacos.");
		else
			print ("You are not carrying a taco, the puppy becomes angry!");
		end
	end
	
end

--[[ Used if this person should do something on their own ]]--
function tickDog()

	local hmm = math.random(6);

	if (hmm == 2) then
		print ("A dog howls in the distance.");
	end
	
end

