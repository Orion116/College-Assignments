--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Oracleinit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["The Oracle"] = {[0] = myNumber, [1] = 1};
    mapping["Oracle"] = {[0] = myNumber, [1] = 1};
    mapping["oracle"] = {[0] = myNumber, [1] = 1};
    
    world["oracle"] = {[0] = 0};

	people[myNumber] = {[0] = "Oracle", [1] = 7, [2] = 0, [3] = talkOracle, [4] = tickOracle};


end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkOracle(arg, target)
	local mynum = mapping["oracle"][0];
	local myStuff = people[mynum];

	if (arg == 0) then
		print (myStuff[0] .. " sees right through you.\n");
	end

        if (world["oracle"][0] == 0) then
        if ((arg == 10) and (people[mynum][1] == 7)) then
            print("The oracle asks if you have a taco.")
            print("The oracle: Do you have a tasty taco?")

            print("You: ")
            local ans = io.read();

            if (ans == "yes") then
                print("The oracle: Can I have the taco?")

                print("You: ")
                local ans = io.read();

                if (ans == "yes") then
                    local mynum = mapping["taco"][0];
                    local myStuff = items[mynum];
                    arg = 13;
                    target = 2;


                    if ((arg == 13) and (myStuff[1]) == 0) then
                        
                        print ("The oracle: Thank you! That was a tasty taco.");
                        print ("The oracle: Here take this powercell.\n");

                        myStuff[1] = 4;
                        world["oracle"] = {[0] = 1}

                        powercell = powercell + 1;
                        endgame = endgame + 1;

                        -- print ("Endgame: " .. endgame)
                    else
                        print ("The oracle is angry with you as you lied and did not have a taste taco.");
                        print ("The oracle takes a powercell from you.\n");
                        powercell = powercell - 1;
                        banned = banned + 1;
                    end

                else
                    print ("The oracle is angry with you for not giving her a tasty taco.");
                    print ("The oracle takes your taco and a powercell.\n");
                    powercell = powercell - 1;
                    banned = banned + 1;
                end
            elseif (ans == "no") then
                print("Go get a taco and I will give you a powercell.\n")

            end
        else
            if (((arg ~= 10) and (people[mynum][1] ~= 7))) then
                print("You can't talk to Oracle here. You need to go to Serbia to talk to the Oracle.\n")
            end
        end
    else
        print("The oracle: Go bother someone else I am full.\n")
    end
	
end

--[[ Used if this person should do something on their own ]]--
function tickOracle()
	-- local hmm = math.random(6);

 --    if (hmm == 2 or hmm == 6) then

 --        print("The Grey Oracle says: Quit the puns or you will go to the punitentiary.")
 --        --[[
 --        local pun = math.random(10);

 --        if (pun == 1) then
 --            print("Quit the puns or you will go to the punitentiary.")
 --        elseif (pun == 2) then
 --            print("")       
 --        ]]--
 --    end
end

