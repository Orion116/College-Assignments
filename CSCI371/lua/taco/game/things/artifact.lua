
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

function Artifactinit()
    local myNumber = nextNumber;
    nextNumber = nextNumber + 1;
    
    mapping["artifact"] = {[0] = myNumber, [1] = 0};
    mapping["Artifact"] = {[0] = myNumber, [1] = 0};
    -- print (mapping["artifact"][0])
    items[myNumber] = {[0] = "artifact", [1] = 10, [2] = 0, [3] = "an", [4] = useArtifact};


end

--[[ 
arg = verb number used on this item
]]--
function useArtifact(arg, target)
    local mynum = mapping["artifact"][0];
    local myStuff = items[mynum];

    -- print (mynum)


    if (arg == 0) then
        print (" "..myStuff[3].." "..myStuff[0]);
    end



    if (arg == 13) then
        print ("Dropped.");
        myStuff[1] = 18;
    end
            
    if (arg == 12) then
        if (location == 10) then
            print ("You picked up ".. myStuff[3].." "..myStuff[0].. " it contains a ancient powercell.");
            powercell = powercell + 1;
            myStuff[1] = 0;
        end;
    end;

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