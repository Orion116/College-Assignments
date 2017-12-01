-- Opens new file and creates the table
FilePeople = io.open("people.data");
	
people={};

-- loops through the lines and sets the table with the data
for line in FilePeople:lines() do
	-- gets the battle
	name, attribute, value = string.match(line, "(.+) (.+) (.+)");	-- gets the data from the stream

	-- if the attribute is not nil add the new attribute else create a new double table
 	if (attribute ~= nil) then
		if (people[name] ~= nil) then
			people[name][attribute] = value;
		else
			people[name] = {[attribute] = value};
		end
	end
end;
FilePeople:close();	-- close file

FileAdventure = io.open("adventure.data");	-- open new file

for line in FileAdventure:lines() do
	-- gets the versus
	name1, attribute1, name2, attribute2 = string.match(line, "(.+) (.+) vs (.+) (.+)");

	-- if the names are not nil continue 
	if (name1 ~= nil) then
		-- if the attribute is nil create a new one that is 0
		if (people[name1] == nil) then
			people[name1] = {[attribute1] = 0};
		end
	end

	if (name2 ~= nil) then
		if (people[name2] == nil) then
			people[name2] = {[attribute2] = 0};
		end
	end

	-- get the skill values
	skill1 = people[name1][attribute1];
	skill2 = people[name2][attribute2];

	if (skill1 == nil) then
		people[name1][attribute1] = 0;
		skill1 = people[name1][attribute1];
	end

	if (skill2 == nil) then
		people[name2][attribute2] = 0;
		skill2 = people[name2][attribute2];
	end

	-- set the default percentage
	percent = 50;

	-- skill# + 0 is to force lua to see the skill as a number
	
	-- if the skills are the same the percentage is 50/50
	if (skill1+0 == skill2+0) then
		percent = 50;
		print("-----------------------------------------------------------------------");
		print(name1 .. " " .. attribute1 .. " " .. skill1 .. " " .. name2 .. " " .. attribute2 .. " " .. skill2 .. "  " .. percent .. "% chance for " .. name1);
		print("-----------------------------------------------------------------------");
	end

	-- if the skill1 is smaller then 
	if (skill1+0 < skill2+0) then
		-- find the difference 
		test = (skill2 + 0) - (skill1 + 0);
		for I = 1,test do
			-- check to see if the percentage is bigger then 0
			if (percent > 0) then
				-- decrement the percentage by 5
				percent = percent - 5;
				-- print(percent)
			end
		end

		-- print out the data
		print("-----------------------------------------------------------------------");
		print(name1 .. " " .. attribute1 .. " " .. skill1 .. " " .. name2 .. " " .. attribute2 .. " " .. skill2 .. " " .. percent .. "% chance for " .. name1);
		print("-----------------------------------------------------------------------");
	end

	-- if the skill is bigger then
	if (skill1+0 > skill2+0) then
		-- find the difference
		test = (skill1 + 0) - (skill2 + 0);

		for I = 1,test do
			-- check to see if the percentage is smaller then 100
			if (percent < 100) then
				-- increment the percentage by 5
				percent = percent + 5;
				-- print(percent);
			end
		end

		-- print out the data
		print("-----------------------------------------------------------------------");
		print(name1 .. " " .. attribute1 .. " " .. skill1 .. " " .. name2 .. " " .. attribute2 .. " " .. skill2 .. " " .. percent .. "% chance for " .. name1);
		print("-----------------------------------------------------------------------");
	end
end

-- close the file
FileAdventure:close();