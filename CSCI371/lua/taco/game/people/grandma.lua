--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Grandmainit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["Grandma"] = {[0] = myNumber, [1] = 1};
	mapping["grandma"] = {[0] = myNumber, [1] = 1};
	mapping["Lulu"] = {[0] = myNumber, [1] = 1};
	mapping["Ahmed's grandma"] = {[0] = myNumber, [1] = 1};
	world["grandma"] = {[0] = 0};

	people[myNumber] = {[0] = "Ahmed's Grandma Lulu", [1] = 11, [2] = 0, [3] = talkGrandma, [4] = tickGrandma};

end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkGrandma(arg, target)
	local mynum = mapping["Grandma"][0];
	local myStuff = people[mynum];



	if (arg == 0) then
        print (myStuff[0] .. " is standing here.\n");
        print("Talk to Grandma?")
    end
-- print("World: " .. world["grandma"][0])
    if (world["grandma"][0] == 0) then
        if ((arg == 10) and (people[mynum][1] == 11)) then
            print("Ahmed's grandma asks if you have a taco.")
            print("Ahmed's grandma: Do you have a tasty taco\n?")

            print("You: ")
            local ans = io.read();

            if (ans == "yes") then
                print("Ahmed's grandma: Can I have the taco?")

                print("You: ")
                local ans = io.read();

                if (ans == "yes") then
                    local mynum = mapping["taco"][0];
                    local myStuff = items[mynum];
                    arg = 13;
                    target = 2;


                    if ((arg == 13) and (myStuff[1]) == 0) then
                        
                        print ("Ahmed's grandma: Thank you! That was a tasty taco.");
                        print ("Ahmed's grandma: Here take this powercell.\n");

                        myStuff[1] = 4;
                        world["grandma"] = {[0] = 1}

                        powercell = powercell + 1;
                        endgame = endgame + 1;

                        -- print ("Endgame: " .. endgame)
                    else
                        print ("Ahmed's grandma is angry with you as you lied and did not have a taste taco.");
                        print ("Ahmed's grandma takes a powercell from you.\n");
                        powercell = powercell - 1;
                        banned = banned + 1;
                    end

                else
                    print ("Ahmed's grandma is angry with you for not giving her a tasty taco.");
                    print ("Ahmed's grandma takes your taco and a powercell.\n");
                    powercell = powercell - 1;
                    banned = banned + 1;
                end
            elseif (ans == "no") then
                print("Go get a taco and I will give you a powercell.\n")

            end
        else
            if (((arg ~= 10) and (people[mynum][1] ~= 11))) then
                print("You can't talk to Grandma here. You need to go to Ahmed's house to talk to her.")
            end
        end
    else
        print("Ahmed's grandma: Go bother someone else I am full.")
    end
	
end

--[[ Used if this person should do something on their own ]]--
function tickGrandma()
	local mynum = mapping["taco"][0];
    local myStuff = items[mynum];

    -- myStuff[1] = 4;

end
