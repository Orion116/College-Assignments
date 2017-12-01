


function initLook()

  local number = 17;
  local words = {"look", "examine"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then
      print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleLook;

end


function handleLook(a, b)
	local object = mapping[a];
	local person = mapping[b];
	local whom;
	local what;

	if ((object == nil)and(person == nil)) then	
		print ("You need to do that to someone/something!");
		return 0;
	end;
		
  if (person ~= nil) then whom = people[person[0]]; end;
  if (object ~= nil) then  what = items[object[0]]; end;

	if (what ~= nil) then
		what[4](17);
		return 0;
	end;

	if (whom ~= nil) then
		whom[3](17);
		return 0;
	end;

end
