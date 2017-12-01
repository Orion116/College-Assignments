
function room18()
	location = 18
	print ("-----------------------------------------------------------")
	print ("You are in The Hub")
	list()
	show(location)
	local move = parse()
	if (move == 0) then 
		return location; 
	end

	-- North
	if (move == 1) then 
		return 8; 
	end
	-- East
	if (move == 2) then 
		return 2; 
	end
	-- South
	if (move == 3) then
		print("You can't move that way!")
		return location;
	end
	-- West
	if (move == 4) then 
		return 14; 
	end
	-- Northwest
	if (move == 5) then 
		return 12; 
	end
	-- Northeast
	if (move == 6) then 
		return 6; 
	end
	-- Southwest
	if (move == 7) then
		print("You can't move that way!")
		return location;
	end
	-- Southeast
	if (move == 8) then
		print("You can't move that way!")
		return location;
	end
	print ("I don't understand your actions!")
	return location



end
