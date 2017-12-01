


killwords = {"to", "the", "a"};

function superparser(str)
	local t = {};
	local result = {};
	local i;
	local key;
	local value;
	local pos;
	local changes;



	str:gsub("[%a]+", function(c) table.insert(t, c) end);

	if (t[1] == nil) then return nil, nil, nil end;

	result[0] = t[1];


	changes = true;
	
	-- Attempt to concatenate values in string to make longer valid strings
	while (changes == true) do	-- Need to reiterate through this
		pos = 2;
		changes = false;
		while (pos < (#t)) do
			for key, value in pairs(mapping) do
				if (t[pos+1] ~= nil) then
					if (key == (t[pos] .. " " ..  t[pos+1])) then
						t[pos] = t[pos] .. " " .. t[pos+1];
						changes = true;
						table.remove(t, pos+1);
					end;
				end;
			end;
			pos = pos + 1;
		end;
	end;

	-- Kill off any of the bogus words
	for i = 2, #t do
		for key, value in ipairs(killwords) do
			if (value == t[i]) then table.remove(t,i) end;
		end
	end

	-- Map an item and a person to the respective spots in result
	for i = 2, #t do
		if ((mapping[t[i]] ~= nil)and(mapping[t[i]][1] == 0)) then
			result[1] = t[i];
		end;
		if ((mapping[t[i]] ~= nil)and(mapping[t[i]][1] == 1)) then
			result[2] = t[i];
		end;
	end;

	return result[0], result[1], result[2];
	
end;
