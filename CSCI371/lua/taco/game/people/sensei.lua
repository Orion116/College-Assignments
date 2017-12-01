--[[
mappings are always 0 = myNumber, and 1=1 (person)

people
	0 -> Full name
	1 -> Location
	2 -> Status 
	3 -> Interact function
	4 -> Tick function

]]--
function Senseiinit()
	local myNumber = nextNumber;
	nextNumber = nextNumber + 1;
	
	mapping["Sensei Schemm"] = {[0] = myNumber, [1] = 1};
    mapping["Sensei"] = {[0] = myNumber, [1] = 1};
    mapping["sensei"] = {[0] = myNumber, [1] = 1};
    
    world["sensei"] = {[0] = 0};

	people[myNumber] = {[0] = "Sensei Schemm", [1] = 13, [2] = 0, [3] = talkSensei, [4] = tickSensei};


end

--[[ Arg is the verb that we tried to use on the person ]]--
function talkSensei(arg, target)
	local mynum = mapping["sensei"][0];
	local myStuff = people[mynum];

	if (arg == 0) then
		print (myStuff[0] .. " throws num-chalk errasers at you.\n");
	end

        if (world["sensei"][0] == 0) then
        if ((arg == 10) and (people[mynum][1] == 13)) then
            print("The sensei asks if you have a taco.")
            print("The sensei: Do you have a tasty taco?")

            print("You: ")
            local ans = io.read();

            if (ans == "yes") then
                print("The sensei: Can I have the taco?")

                print("You: ")
                local ans = io.read();

                if (ans == "yes") then
                    local mynum = mapping["taco"][0];
                    local myStuff = items[mynum];
                    arg = 13;
                    target = 2;


                    if ((arg == 13) and (myStuff[1]) == 0) then
                        
                        print ("The sensei: Thank you! That was a tasty taco.");
                        print ("The sensei: Here take this powercell.\n");

                        myStuff[1] = 4;
                        world["sensei"] = {[0] = 1}

                        powercell = powercell + 1;
                        endgame = endgame + 1;

                        -- print ("Endgame: " .. endgame)
                    else
                        print ("The sensei is angry with you as you lied and did not have a taste taco.");
                        print ("The sensei takes a powercell from you.\n");
                        powercell = powercell - 1;
                        banned = banned + 1;
                    end

                else
                    print ("The sensei is angry with you for not giving her a tasty taco.");
                    print ("The sensei takes your taco and a powercell.\n");
                    powercell = powercell - 1;
                    banned = banned + 1;
                end
            elseif (ans == "no") then
                print("Go get a taco and I will give you a powercell.\n")

            end
        else
            if (((arg ~= 10) and (people[mynum][1] ~= 13))) then
                print("You can't talk to Sensei Schemm here. You need to go to China to talk to the Sensei Schemm.\n")
            end
        end
    else
        print("The sensei: Go bother someone else I am full.\n")
    end
	
end

--[[ Used if this person should do something on their own ]]--
function tickSensei()
	-- local hmm = math.random(6);

 --    if (hmm == 2 or hmm == 6) then

 --        print("The Grey Sensei Schemm says: Quit the puns or you will go to the punitentiary.")
 --        --[[
 --        local pun = math.random(10);

 --        if (pun == 1) then
 --            print("Quit the puns or you will go to the punitentiary.")
 --        elseif (pun == 2) then
 --            print("")       
 --        ]]--
 --    end
end

