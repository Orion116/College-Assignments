
function list()
	print("You see:")
	for name, value in pairs(items) do
        if (value[1] == location) then
            value[4](0);
        end
    end
end



function show(location)
  for id, value in pairs(people) do
    if (value[1] == location) then
      value[3](0);
    end
  end
end



function tick()
	for id, value in pairs(people) do
		if (value[4] ~= nil) then
			value[4]();
		end
	end
end
