
function room12()
	location = 12
	print ("-----------------------------------------------------------")
	print ("You are in Chinese Airport")
	list()
	show(location)
	local move = parse()
	if (move == 0) then 
		return location; 
	end

	-- North
	if (move == 1) then 
		return 13; 
	end
	-- East
	if (move == 2) then
		print("You can't move that way!")
		return location;
	end
	-- South
	if (move == 3) then
		print("You can't move that way!")
		return location;
	end
	-- West
	if (move == 4) then
		print("You can't move that way!")
		return location;
	end
	-- Northwest
	if (move == 5) then
		print("You can't move that way!")
		return location;
	end
	-- Northeast
	if (move == 6) then
		print("You can't move that way!")
		return location;
	end
	-- Southwest
	if (move == 7) then
		print("You can't move that way!")
		return location;
	end
	-- Southeast
	if (move == 8) then 
		return 18; 
	end
	print ("I don't understand your actions!")
	return location



end
