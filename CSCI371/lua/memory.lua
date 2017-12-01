FilePeople = io.open("people.data");

people={};

for line in FilePeople:lines() do
	-- gets the battle
	name, attribute, value = string.match(line, "(.+) (.+) (.+)");
 	if (attribute ~= nil) then
		if (people[name] ~= nil) then
			people[name][attribute] = value;
		else
			people[name] = {[attribute] = value};
		end
	  return;
	end
end;


battle={};
FileAdventure = io.open("adventure.data");

-- battle=table.load("adventure.data");
-- people=table.load("people.data");
for line in FileAdventure.lines() do
	-- gets the versus
	name1, attribute1, name2, attribute2 = string.match(line, "(.+) (.+) vs (.+) (.+)");
	if (name1 ~= nil) then
		if (battle[name1] ~= nil) then
			-- people[name1]
		else
			battle[name1] = attribute1;
		end
	end
	if (name2 ~= nil) then
		
	end
end



function parseline(str)

	what = string.match(str, "^Quit$");
	if (what ~= nil) then
		os.exit();
	end;

	what = string.match(str, "^List$");
	if (what ~= nil) then
		for key, value in pairs(battle) do
			for inner, data in pairs(value) do
				if (key == "My") then
					print ("My "..inner.. " is ".. data..".");
				else
					print (key .. "'s ".. inner .. " is " .. data .. ".");
				end;
			end
		end;
	end

	attribute, value = string.match(str, "^My (.+) is (.+)%.$");
 	if (attribute ~= nil) then
		if (battle["My"] ~= nil) then
			battle["My"][attribute] = value;
		else
			battle["My"] = {[attribute] = value};
		end
	  return;
	end

	attribute = string.match(str, "^What is my (.+)%?$");
 	if (attribute ~= nil) then
		if (battle["My"] == nil) then
			print ("I don't know myself yet.");
		else
			if (battle["My"][attribute] == nil) then
				print ("I don't know my "..attribute..".");
			else
				print ("My "..attribute .. " is ".. battle["My"][attribute]..".");
			end
		end
	  return;
	end

	-- gets the battle
	name, attribute, value = string.match(str, "(.+) (.+) (.+)");
 	if (attribute ~= nil) then
		if (battle[name] ~= nil) then
			battle[name][attribute] = value;
		else
			battle[name] = {[attribute] = value};
		end
	  return;
	end

	-- gets the versus
	name1, attribute1, name2, attribute2 = string.match(FileAdventure:read(), "(.+) (.+) vs (.+) (.+)");
	if (name1 ~= nil and name2 ~= nil) then
		if (battle[name1] ~= nil) then
			if (battle[name2] ~= nil) then
				print (name1 .. " has already been aliased to ".. people[name]);

			-- return;
		else
			battle[name1][attribute1] = 0;
		end

		return;
	end

	-- gets the versus
	name1, attribute1, name2, attribute2 = string.match(str, "(.+) (.+) vs (.+) (.+)");
	if (name1 ~= nil and name2 ~= nil) then
		if (battle[name1] ~= nil) then
			if (battle[name2] ~= nil) then
				print (name .. " has already been aliased to ".. people[name]);
			else
				battle[name2] = {[attribute2] = 0};
			end;
		else
			battle[name1] = {[attribute1] = 0};
		end

		return;
	end





	name, attribute = string.match(str, "^What is (.+)'s (.+)%?$");
 	if (attribute ~= nil) then
		whom = people[name]
		if (battle[whom] == nil) then
			print ("I don't know "..whom.." yet.");
		else
			if (battle[whom][attribute] == nil) then
				print ("I don't know "..whom.."'s "..attribute..".");
			else
				print (whom.."'s "..attribute .. " is ".. battle[whom][attribute]..".");
			end
		end
	  return;
	end

	what, value = string.match(str, "^(.+) costs (.+)%.$");
 	if (what ~= nil) then
		real = people[what];
		if (real == nil) then
    	people[what] = what
			real = what
		end
		if (battle[real] ~= nil) then
			battle[real]["cost"] = value;
		else
			battle[real] = {["cost"] = value};
		end
	  return;
	end

	name = string.match(str, "^What does (.+) cost%?$");
 	if (name ~= nil) then
		what = people[name];
		if (battle[what] == nil) then
			print ("I don't know what "..what.." cost.");
		else
			if (battle[what]["cost"] == nil) then
				print ("I don't know what "..what.." cost.");
			else
				print (what.."s cost ".. battle[what]["cost"]..".");
			end
		end
	  return;
	end

end


end
