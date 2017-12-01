
function roomnum()
	location = num
	print ("-----------------------------------------------------------")
	print ("You are in name")
	list()
	show(location)
	local move = parse()
	if (move == 0) then return location; end

	-- North
	if (move == 1) then return n; end
	-- East
	if (move == 2) then return e; end
	-- South
	if (move == 3) then return s; end
	-- West
	if (move == 4) then return w; end
	-- Northwest
	if (move == 5) then return nw; end
	-- Northeast
	if (move == 6) then return ne; end
	-- Southwest
	if (move == 7) then return sw; end
	-- Southeast
	if (move == 8) then return se; end
	print ("I don't understand your actions!")
	return location



end
