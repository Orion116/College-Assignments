
--[[
mapping 
0 = this number
1 = always 0 (item)

items
0 -> Full name
1 -> location
2 -> status
3 -> article (a or an or the)
4 -> Use function

Be sure to call THINGinit in main.lua
]]--

function Switchinit()
    local myNumber = nextNumber;
    nextNumber = nextNumber + 1;
    
    mapping["switch"] = {[0] = myNumber, [1] = 0};
    mapping["Switch"] = {[0] = myNumber, [1] = 0};
    mapping["button"] = {[0] = myNumber, [1] = 0};
    mapping["Button"] = {[0] = myNumber, [1] = 0};
    -- print (mapping["switch"][0])
    items[myNumber] = {[0] = "switch", [1] = 18, [2] = 0, [3] = "a", [4] = useSwitch};


end

--[[ 
arg = verb number used on this item
]]--
function useSwitch(arg, target)
    local mynum = mapping["switch"][0];
    local myStuff = items[mynum];

    -- print (mynum)


    if (arg == 0) then
        print (" "..myStuff[3].." "..myStuff[0]);
    end

    -- if (arg == 14) then
    --     print("Before: " .. powercell)
    --     if (powercell >= 1) then
    --         print("\nmyStuff[1]:")
    --         -- print(myStuff[1])
    --         print("\n")
    --         if (myStuff[1] == 18) then
    --             print ("You purchase "..myStuff[3].." "..myStuff[0]..".");
    --             powercell = powercell - 1;
    --             print ("After: " .. powercell)
    --             myStuff[1] = 0;
    --             return true;
    --         else
    --             print("Kody says 'Eat the one you already have!'");
    --             return false
                
    --         end;
    --     else
    --         -- myStuff[1] = location;
    --         print ("Kody says 'Tacos on sale! Today only, $1'.");
    --     end;
    -- end

    if (arg == 13) then
        print ("Dropped.");
        myStuff[1] = 18;
    end
            
    
    -- if (arg == 12) then
    --     if (location == 4) then
    --         print ("Kody glares at you for trying to steal "
    --                 ..myStuff[3].." "..myStuff[0].. ".");
    --         print ("Don't make him angry, or he will smite you.");
    --     else
    --         print ("You pick up "..myStuff[3].." "..myStuff[0].. ".");
    --         myStuff[1] = 0;
    --     end;
    -- end;

    -- if (arg == 13) then
    --     print ("Dropped.");
    --     myStuff[1] = location;
    -- end

    -- if (arg == 15) then
    --     if (myStuff[1] == 0) then
    --         print ("It was very tasty.  You should introduce this wonder to the world!")
    --         myStuff[1] = 4;
    --     else
    --         print ("You live a sad life, with no taco to eat.  :(");
    --     end
    -- end


end