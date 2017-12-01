


function initInventory()

  local number = 18;
  local words = {"i", "inventory"};
  for i, word in ipairs(words) do
    if (verbs[word] ~= nil) then
        print (word .. " was multiply defined as verb type " .. verbs[word] ..
        " and " .. number);
      io.exit();
    end
    verbs[word] = number
  end;

  handlers[number] = handleInventory;

end


function handleInventory(a, n)
    print ("You are carrying:")
    for name, value in pairs(items) do
        if (value[1] == 0) then
            print (value[0])
        end
    end
        print ("You have Adams " .. funds .. ".")
        print ("You have " .. powercell .. " power cels.")
    return 0
end
