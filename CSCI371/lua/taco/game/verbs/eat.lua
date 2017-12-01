

function initEat()

  local number = 15
  local words = {"eat", "consume"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then
      print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleEat;

end





function handleEat(a, b)
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

	if (object[0] == mapping["taco"][0]) then
		what[4](15);
		return 0;
	end




end
