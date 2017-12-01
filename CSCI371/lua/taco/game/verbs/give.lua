function initGive()

  local number = 33;
  local words = {"give"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then 
      print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleGive;

end


function handleGive(a, b)
	local object = mapping[a];
	local person = mapping[b];
	local whom;
	local what;

	if ((object == nil)and(person == nil)) then	
		print ("You need to do that to someone/something!");
		return 0;
	end;
		
  if (person ~= nil) then whom = people[person[0]]; end;
  if (object ~= nil) then what = items[object[0]]; end;


	if (whom == nil) then
		print ("I don't know who you are giving it to.");
		return 0;
	end;

	if (whom[1] ~= location) then
		print (whom[0] .. " isn't here.");
		return 0
	end


	if ((person[0] == mapping["dog"][0]) and
		 (object[0] == mapping["taco"][0])) then
			whom[3](33, object[0]);	
			return 0;
	end;

	if ((person[0] == mapping["grandma"][0]) and
		 (object[0] == mapping["taco"][0])) then
			whom[3](33, object[0]);
			return 0;
	end

end
