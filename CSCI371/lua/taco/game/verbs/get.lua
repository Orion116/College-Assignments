



function initGet()

  local number = 12;
  local words = {"get", "acquire", "take", "pickup"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then
      print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleGet;

end


function handleGet(a, b)
	local object = mapping[a];
	local person = mapping[b];
	local whom;
	local what;

	if ((object == nil)and(person == nil)) then	
		print ("It isn't here!");
		return 0;
	end;
		
  if (person ~= nil) then whom = people[person[0]]; end;
  if (object ~= nil) then what = items[object[0]]; end;

  if (what ~= nul) then -- Getting an item
    if (what[1] == location) then
      what[4](12);
      return 0;
    end;
    print ("There is no "..a.." here.");
    return 0;
  end;

  if (whom ~= nil) then -- Getting a person
    if (whom[1] == location) then
      whom[3](12);
      return 0
    end;
    print (b .. " isn't here.");
    return 0
  end
end
