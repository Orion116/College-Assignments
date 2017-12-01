


function initUse()

  local number = 14;
  local words = {"use"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then
      print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleUse;

end



function handleUse(a, b)
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

  if (what ~= nil) then -- Using an item
    if (what[1] == location) then
      what[4](14);
      return 0;
    end;
    print ("There is no "..a.." here.");
    return 0;
  end;

  if (whom ~= nil) then -- Using a person
    if (whom[1] == location) then
      whom[3](14);
      return 0
    end;
    print (b .. " isn't here.");
    return 0
  end
end
