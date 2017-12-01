


function initAttack()

	local number = 25;
	local words = {"hit", "kill", "destroy", "attack"};
	for i, word in ipairs(words) do
		if (verbs[word] ~= nil) then
			print (word .. " was multiply defined as verb type " .. verbs[word] ..
				" and " .. number);
			io.exit();
		end
		verbs[word] = number
	end;

	handlers[number] = handleAttack;

end





function handleAttack(a, b)
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
		print ("I don't know who you are attacking.");
		return 0;
	end;

	if (whom[1] ~= location) then
		print (whom[0] .. " isn't here.");
		return 0
	end

	whom[3](25);
	return 0;

end
